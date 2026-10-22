package com.lynx.markdown;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MarkdownGestureView extends com.lynx.markdown.a {
    private static final int PAN_STATE_IDLE = 0;
    private static final int PAN_STATE_PENDING = 1;
    private static final int PAN_STATE_TRACKING = 2;
    private a mCheckForLongPress;
    private float mDownX;
    private float mDownY;
    private boolean mIsValidClick;
    private long mNativeGestureTarget;
    private int mPanState;
    private boolean mParentInterceptDisallowed;
    private final int mTouchSlop;

    public final class a implements Runnable {
        public final float a;
        public final float b;
        public final /* synthetic */ MarkdownGestureView c;

        @Override // java.lang.Runnable
        public final void run() {
            this.c.longPressSuccess(this.a, this.b);     // Catch: Throwable -> L4
            MarkdownGestureView.access$002(this.c, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(MarkdownGestureView r1, float r2, float r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    private static int convertGestureEventType(int r2) {
        if (r2 != 0) goto L6;
        return 1;
    L6:
        if (r2 != 2) goto L9;
        return 2;
    L9:
        if (r2 != 1) goto L11;
        return 3;
    L11:
        if (r2 != 3) goto L14;
        return 4;
    L14:
        return 0;
    }

    private native boolean nativeDispatchLongPress(long r1, float r3, float r4);

    private native boolean nativeDispatchPan(long r1, float r3, float r4, float r5, float r6, int r7);

    private native boolean nativeDispatchTap(long r1, float r3, float r4);

    private native boolean nativeShouldBeginPan(long r1, float r3, float r4, float r5, float r6);

    public void resetState() {
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mPanState = 1;
        this.mIsValidClick = false;
        removeCheckLongPressCallback();
        releaseIntercept();
    }

    private void releaseIntercept() {
        if (this.mParentInterceptDisallowed == true) goto L5;
        return;
    L5:
        setInterceptAllowed(true);
    }

    private void removeCheckLongPressCallback() {
        a r0 = this.mCheckForLongPress;
        if (r0 != null) goto L5;
        return;
    L5:
        removeCallbacks(r0);
        this.mCheckForLongPress = null;
    }

    private void setInterceptAllowed(boolean r2) {
        requestDisallowInterceptTouchEvent(!r2);
        this.mParentInterceptDisallowed = !r2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r13) {
        if (this.mNativeGestureTarget == 0) goto L5;
        int r0 = r13.getActionMasked();
        float r4 = r13.getX();
        float r5 = r13.getY();
        float r14 = this.mDownX;
        float r6 = r4 - r14;
        float r1 = this.mDownY;
        float r7 = r5 - r1;
        if (r0 != 0) goto L9;
        this.mDownX = r4;
        this.mDownY = r5;
        if (checkShouldPan(r4, r5, 0.0f, 0.0f) == true) goto L38;
        this.mIsValidClick = true;
        removeCheckLongPressCallback();
        a r15 = new a(this, r4, r5);
        this.mCheckForLongPress = r15;
        postDelayed(r15, ViewConfiguration.getLongPressTimeout());
    L38:
        return true;
    L9:
        if (r0 == 1) goto L29;
        if (r0 == 2) goto L19;
        if (r0 != 3) goto L38;
        if (this.mPanState != 2) goto L17;
        nativeDispatchPan(this.mNativeGestureTarget, r4, r5, r6, r7, convertGestureEventType(3));
    L17:
        resetState();
        goto L38
    L19:
        if (this.mPanState != 1) goto L26;
        int r2 = this.mTouchSlop;
        if (((r6 * r6) + (r7 * r7)) < (r2 * r2)) goto L26;
        this.mIsValidClick = false;
        if (checkShouldPan(r14, r1, r6, r7) == true) goto L26;
        this.mPanState = 0;
    L26:
        if (this.mPanState != 2) goto L38;
        nativeDispatchPan(this.mNativeGestureTarget, r4, r5, r6, r7, convertGestureEventType(2));
        goto L38
    L29:
        if (this.mIsValidClick == false) goto L32;
        nativeDispatchTap(this.mNativeGestureTarget, r14, r1);
    L32:
        if (this.mPanState != 2) goto L34;
        nativeDispatchPan(this.mNativeGestureTarget, r4, r5, r6, r7, convertGestureEventType(1));
    L34:
        resetState();
        goto L38
    L5:
        return super.onTouchEvent(r13);
    }

    public void setNativeGestureTarget(long r1) {
        this.mNativeGestureTarget = r1;
    }

    public MarkdownGestureView(Context r3, long r4) {
        super(r3);
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mIsValidClick = false;
        this.mCheckForLongPress = null;
        this.mPanState = 0;
        this.mParentInterceptDisallowed = false;
        this.mNativeGestureTarget = r4;
        this.mTouchSlop = ViewConfiguration.get(r3).getScaledTouchSlop();
        setClickable(true);
        setLongClickable(true);
    }

    public static /* synthetic */ a access$002(MarkdownGestureView r0, a r1) {
        r0.mCheckForLongPress = r1;
        return r1;
    }

    public void longPressSuccess(float r4, float r5) {
        this.mIsValidClick = false;
        if (nativeDispatchLongPress(this.mNativeGestureTarget, r4, r5) == false) goto L6;
        this.mPanState = 1;
        setInterceptAllowed(false);
        return;
    }

    public boolean checkShouldPan(float r11, float r12, float r13, float r14) {
        boolean r0 = nativeShouldBeginPan(this.mNativeGestureTarget, r11, r12, r13, r14);
        if (r0 == false) goto L5;
        this.mPanState = 2;
        nativeDispatchPan(this.mNativeGestureTarget, r11, r12, r13, r14, convertGestureEventType(0));
        setInterceptAllowed(false);
        removeCheckLongPressCallback();
    L5:
        return r0;
    }
}
