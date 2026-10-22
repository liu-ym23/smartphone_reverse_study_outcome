package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation;
    private Runnable mTriggerLongPress;

    private class DisallowIntercept implements Runnable {
        final /* synthetic */ ForwardingListener this$0;

        DisallowIntercept(ForwardingListener r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent r10 = this.this$0.mSrc.getParent();
            if (r10 == null) goto L6;
            r10.requestDisallowInterceptTouchEvent(true);
            return;
        }
    }

    private class TriggerLongPress implements Runnable {
        final /* synthetic */ ForwardingListener this$0;

        TriggerLongPress(ForwardingListener r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.onLongPress();
        }
    }

    public ForwardingListener(View r10) {
        this.mTmpLocation = new int[2];
        this.mSrc = r10;
        r10.setLongClickable(true);
        r10.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = ViewConfiguration.get(r10.getContext()).getScaledTouchSlop();
        int r11 = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = r11;
        this.mLongPressTimeout = (r11 + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void clearCallbacks() {
        Runnable r10 = this.mTriggerLongPress;
        if (r10 == null) goto L5;
        this.mSrc.removeCallbacks(r10);
    L5:
        Runnable r11 = this.mDisallowIntercept;
        if (r11 == null) goto L9;
        this.mSrc.removeCallbacks(r11);
        return;
    }

    private boolean onTouchForwarded(MotionEvent r10) {
        View r11 = this.mSrc;
        ShowableListMenu r12 = getPopup();
        if (r12 != null) goto L5;
        return false;
    L5:
        if (r12.isShowing() == false) goto L26;
        DropDownListView r13 = (DropDownListView) r12.getListView();
        if (r13 != null) goto L10;
        return false;
    L10:
        if (r13.isShown() == false) goto L27;
        MotionEvent r14 = MotionEvent.obtainNoHistory(r10);
        toGlobalMotionEvent(r11, r14);
        toLocalMotionEvent(r13, r14);
        boolean r15 = r13.onForwardedEvent(r14, this.mActivePointerId);
        r14.recycle();
        int r16 = r10.getActionMasked();
        if (r16 != 1) goto L15;
    L17:
        boolean r17 = false;
    L18:
        if (r15 == false) goto L24;
        if (r17 == true) goto L21;
        return false;
    L21:
        return true;
    L24:
        return false;
    L15:
        if (r16 == 3) goto L17;
        r17 = true;
        goto L18
    L27:
        return false;
    L26:
        return false;
    }

    private boolean onTouchObserved(MotionEvent r10) {
        View r11 = this.mSrc;
        if (r11.isEnabled() == true) goto L5;
        return false;
    L5:
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L8;
        this.mActivePointerId = r10.getPointerId(0);
        if (this.mDisallowIntercept != null) goto L24;
        this.mDisallowIntercept = new DisallowIntercept(this);
    L24:
        r11.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
        if (this.mTriggerLongPress != null) goto L27;
        this.mTriggerLongPress = new TriggerLongPress(this);
    L27:
        r11.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
    L28:
        return false;
    L8:
        if (r12 != 1) goto L10;
    L20:
        clearCallbacks();
        goto L28
    L10:
        if (r12 != 2) goto L12;
        int r13 = r10.findPointerIndex(this.mActivePointerId);
        if (r13 < 0) goto L28;
        if (pointInView(r11, r10.getX(r13), r10.getY(r13), this.mScaledTouchSlop) == true) goto L28;
        clearCallbacks();
        r11.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        if (r12 == 3) goto L20;
        goto L20
    }

    private static boolean pointInView(View r10, float r11, float r12, float r13) {
        float r14 = -r13;
        if (r11 >= r14) goto L5;
    L11:
        return false;
    L5:
        if (r12 < r14) goto L11;
        if (r11 >= ((r10.getRight() - r10.getLeft()) + r13)) goto L11;
        if (r12 >= ((r10.getBottom() - r10.getTop()) + r13)) goto L11;
        return true;
    }

    private boolean toGlobalMotionEvent(View r10, MotionEvent r11) {
        int[] r12 = this.mTmpLocation;
        r10.getLocationOnScreen(r12);
        r11.offsetLocation(r12[0], r12[1]);
        return true;
    }

    private boolean toLocalMotionEvent(View r10, MotionEvent r11) {
        int[] r12 = this.mTmpLocation;
        r10.getLocationOnScreen(r12);
        r11.offsetLocation(-r12[0], -r12[1]);
        return true;
    }

    public abstract ShowableListMenu getPopup();

    protected boolean onForwardingStarted() {
        ShowableListMenu r10 = getPopup();
        if (r10 != null) goto L5;
        return true;
    L5:
        if (r10.isShowing() == true) goto L10;
        r10.show();
        return true;
    L10:
        return true;
    }

    protected boolean onForwardingStopped() {
        ShowableListMenu r10 = getPopup();
        if (r10 != null) goto L5;
        return true;
    L5:
        if (r10.isShowing() == false) goto L10;
        r10.dismiss();
        return true;
    L10:
        return true;
    }

    void onLongPress() {
        clearCallbacks();
        View r10 = this.mSrc;
        if (r10.isEnabled() == true) goto L5;
        return;
    L5:
        if (r10.isLongClickable() == false) goto L8;
        return;
    L8:
        if (onForwardingStarted() == true) goto L10;
        return;
    L10:
        r10.getParent().requestDisallowInterceptTouchEvent(true);
        long r11 = SystemClock.uptimeMillis();
        MotionEvent r12 = MotionEvent.obtain(r11, r11, 3, 0.0f, 0.0f, 0);
        r10.onTouchEvent(r12);
        r12.recycle();
        this.mForwarding = true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r11, MotionEvent r12) {
        boolean r13 = this.mForwarding;
        if (r13 == false) goto L12;
        if (onTouchForwarded(r12) == false) goto L7;
    L10:
        boolean r14 = true;
    L19:
        this.mForwarding = r14;
        if (r14 == true) goto L25;
        if (r13 == false) goto L24;
        return true;
    L24:
        return false;
    L25:
        return true;
    L7:
        if (onForwardingStopped() == false) goto L10;
        r14 = false;
        goto L19
    L12:
        if (onTouchObserved(r12) == true) goto L14;
    L16:
        r14 = false;
    L17:
        if (r14 == false) goto L19;
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r15 = MotionEvent.obtain(r10, r10, 3, 0.0f, 0.0f, 0);
        this.mSrc.onTouchEvent(r15);
        r15.recycle();
        goto L19
    L14:
        if (onForwardingStarted() == false) goto L16;
        r14 = true;
        goto L17
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r10) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r10) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        Runnable r11 = this.mDisallowIntercept;
        if (r11 == null) goto L6;
        this.mSrc.removeCallbacks(r11);
        return;
    }
}
