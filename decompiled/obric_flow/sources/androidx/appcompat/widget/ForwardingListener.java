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

    public class DisallowIntercept implements Runnable {
        final /* synthetic */ ForwardingListener this$0;

        public DisallowIntercept(ForwardingListener r5) {
            this.this$0 = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent r5 = this.this$0.mSrc.getParent();
            if (r5 == null) goto L6;
            r5.requestDisallowInterceptTouchEvent(true);
            return;
        }
    }

    public class TriggerLongPress implements Runnable {
        final /* synthetic */ ForwardingListener this$0;

        public TriggerLongPress(ForwardingListener r5) {
            this.this$0 = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.onLongPress();
        }
    }

    public ForwardingListener(View r5) {
        this.mTmpLocation = new int[2];
        this.mSrc = r5;
        r5.setLongClickable(true);
        r5.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = ViewConfiguration.get(r5.getContext()).getScaledTouchSlop();
        int r10 = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = r10;
        this.mLongPressTimeout = (ViewConfiguration.getLongPressTimeout() + r10) / 2;
    }

    private void clearCallbacks() {
        Runnable r5 = this.mTriggerLongPress;
        if (r5 == null) goto L5;
        this.mSrc.removeCallbacks(r5);
    L5:
        Runnable r10 = this.mDisallowIntercept;
        if (r10 == null) goto L9;
        this.mSrc.removeCallbacks(r10);
        return;
    }

    private boolean onTouchForwarded(MotionEvent r5) {
        View r10 = this.mSrc;
        ShowableListMenu r11 = getPopup();
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.isShowing() == false) goto L26;
        DropDownListView r12 = (DropDownListView) r11.getListView();
        if (r12 != null) goto L10;
        return false;
    L10:
        if (r12.isShown() == false) goto L27;
        MotionEvent r13 = MotionEvent.obtainNoHistory(r5);
        toGlobalMotionEvent(r10, r13);
        toLocalMotionEvent(r12, r13);
        boolean r14 = r12.onForwardedEvent(r13, this.mActivePointerId);
        r13.recycle();
        int r15 = r5.getActionMasked();
        if (r15 != 1) goto L15;
    L17:
        boolean r16 = false;
    L18:
        if (r14 == false) goto L24;
        if (r16 == true) goto L21;
        return false;
    L21:
        return true;
    L24:
        return false;
    L15:
        if (r15 == 3) goto L17;
        r16 = true;
        goto L18
    L27:
        return false;
    L26:
        return false;
    }

    private boolean onTouchObserved(MotionEvent r10) {
        View r5 = this.mSrc;
        if (r5.isEnabled() == true) goto L5;
        return false;
    L5:
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L8;
        this.mActivePointerId = r10.getPointerId(0);
        if (this.mDisallowIntercept != null) goto L24;
        this.mDisallowIntercept = new DisallowIntercept(this);
    L24:
        r5.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
        if (this.mTriggerLongPress != null) goto L27;
        this.mTriggerLongPress = new TriggerLongPress(this);
    L27:
        r5.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
    L28:
        return false;
    L8:
        if (r11 != 1) goto L10;
    L20:
        clearCallbacks();
        goto L28
    L10:
        if (r11 != 2) goto L12;
        int r12 = r10.findPointerIndex(this.mActivePointerId);
        if (r12 < 0) goto L28;
        if (pointInView(r5, r10.getX(r12), r10.getY(r12), this.mScaledTouchSlop) == true) goto L28;
        clearCallbacks();
        r5.getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        if (r11 == 3) goto L20;
        goto L20
    }

    private static boolean pointInView(View r5, float r10, float r11, float r12) {
        float r13 = -r12;
        if (r10 >= r13) goto L5;
    L11:
        return false;
    L5:
        if (r11 < r13) goto L11;
        if (r10 >= ((r5.getRight() - r5.getLeft()) + r12)) goto L11;
        if (r11 >= ((r5.getBottom() - r5.getTop()) + r12)) goto L11;
        return true;
    }

    private boolean toGlobalMotionEvent(View r5, MotionEvent r10) {
        int[] r11 = this.mTmpLocation;
        r5.getLocationOnScreen(r11);
        r10.offsetLocation(r11[0], r11[1]);
        return true;
    }

    private boolean toLocalMotionEvent(View r5, MotionEvent r10) {
        int[] r11 = this.mTmpLocation;
        r5.getLocationOnScreen(r11);
        r10.offsetLocation(-r11[0], -r11[1]);
        return true;
    }

    public abstract ShowableListMenu getPopup();

    public boolean onForwardingStarted() {
        ShowableListMenu r5 = getPopup();
        if (r5 != null) goto L5;
        return true;
    L5:
        if (r5.isShowing() == true) goto L10;
        r5.show();
        return true;
    L10:
        return true;
    }

    public boolean onForwardingStopped() {
        ShowableListMenu r5 = getPopup();
        if (r5 != null) goto L5;
        return true;
    L5:
        if (r5.isShowing() == false) goto L10;
        r5.dismiss();
        return true;
    L10:
        return true;
    }

    public void onLongPress() {
        clearCallbacks();
        View r5 = this.mSrc;
        if (r5.isEnabled() == true) goto L5;
        return;
    L5:
        if (r5.isLongClickable() == false) goto L8;
        return;
    L8:
        if (onForwardingStarted() == true) goto L10;
        return;
    L10:
        r5.getParent().requestDisallowInterceptTouchEvent(true);
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r11 = MotionEvent.obtain(r10, r10, 3, 0.0f, 0.0f, 0);
        r5.onTouchEvent(r11);
        r11.recycle();
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
        long r5 = SystemClock.uptimeMillis();
        MotionEvent r10 = MotionEvent.obtain(r5, r5, 3, 0.0f, 0.0f, 0);
        this.mSrc.onTouchEvent(r10);
        r10.recycle();
        goto L19
    L14:
        if (onForwardingStarted() == false) goto L16;
        r14 = true;
        goto L17
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r5) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r5) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        Runnable r10 = this.mDisallowIntercept;
        if (r10 == null) goto L6;
        this.mSrc.removeCallbacks(r10);
        return;
    }
}
