package com.lynx.devtool.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class EmulateTouchHelper {
    private static final String TAG = "EmulateTouchHelper";
    private int mDeltaScale;
    private MotionEvent mEvent;
    private float mLastX;
    private float mLastY;
    private WeakReference<LynxView> mLynxView;
    private boolean mMouseWheelFlag;
    private Handler mMouseWheelHandler;

    private void stopMouseWheel() {
        LynxView r0 = this.mLynxView.get();
        if (r0 != null) goto L7;
        LLog.e(TAG, "stopMouseWheel: lynxView is null");
        return;
    L7:
        if (this.mMouseWheelFlag == true) goto L9;
        return;
    L9:
        if (this.mEvent.getAction() != 2) goto L13;
        this.mMouseWheelFlag = false;
        MotionEvent r1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, this.mLastX, this.mLastY, 0);
        this.mEvent = r1;
        r0.dispatchTouchEvent(r1);
        this.mEvent.recycle();
        return;
    }

    public EmulateTouchHelper(WeakReference<LynxView> r2) {
        this.mLynxView = r2;
        this.mEvent = null;
        this.mMouseWheelFlag = false;
        this.mMouseWheelHandler = new Handler(Looper.getMainLooper());
        this.mDeltaScale = 10;
    }

    public static /* synthetic */ void access$000(EmulateTouchHelper r0) {
        r0.stopMouseWheel();
    }

    public void attach(LynxView r2) {
        this.mLynxView = new WeakReference(r2);
    }

    public void emulateTouch(String r16, int r17, int r18, float r19, float r20, String r21, IDevToolDelegate r22) {
        if (r16 != null) goto L6;
        LLog.e(TAG, "emulateTouch: type is null");
        return;
    L6:
        LynxView r3 = this.mLynxView.get();
        if (r3 != null) goto L10;
        LLog.e(TAG, "emulateTouch: view is null");
        return;
    L10:
        if (r22 != null) goto L14;
        LLog.e(TAG, "emulateTouch: devToolDelegate is null");
        return;
    L14:
        if (r22.getActualScreenshotMode().equals(ScreenshotMode.SCREEN_SHOT_MODE_FULL_SCREEN) == false) goto L16;
        int[] r2 = new int[2];
        r3.getLocationOnScreen(r2);
        int r5 = r17 - r2[0];
        int r4 = r18 - r2[1];
    L18:
        if (r16.equals("mousePressed") == false) goto L21;
        MotionEvent r1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, r5, r4, 0);
        this.mEvent = r1;
        r3.dispatchTouchEvent(r1);
        return;
    L21:
        if (r16.equals("mouseMoved") == false) goto L24;
        MotionEvent r6 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, r5, r4, 0);
        this.mEvent = r6;
        r3.dispatchTouchEvent(r6);
        return;
    L24:
        if (r16.equals("mouseReleased") == false) goto L27;
        MotionEvent r7 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, r5, r4, 0);
        this.mEvent = r7;
        r3.dispatchTouchEvent(r7);
        this.mEvent.recycle();
        return;
    L27:
        if (r16.equals("mouseWheel") == false) goto L33;
        this.mMouseWheelHandler.removeCallbacksAndMessages(null);
        if (this.mMouseWheelFlag == true) goto L31;
        this.mMouseWheelFlag = true;
        float r11 = r5;
        this.mLastX = r11;
        float r12 = r4;
        this.mLastY = r12;
        MotionEvent r8 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, r11, r12, 0);
        this.mEvent = r8;
        r3.dispatchTouchEvent(r8);
    L31:
        float r9 = this.mLastX;
        int r10 = this.mDeltaScale;
        this.mLastX = r9 + (r19 / r10);
        this.mLastY += r20 / r10;
        MotionEvent r13 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, this.mLastX, this.mLastY, 0);
        this.mEvent = r13;
        r3.dispatchTouchEvent(r13);
        this.mMouseWheelHandler.postDelayed(new AnonymousClass1(this), 100);
        return;
    L33:
        if (r16.equals(LynxTouchEvent.EVENT_TOUCH_START) == true) goto L47;
        if (r16.equals(LynxTouchEvent.EVENT_TOUCH_MOVE) == true) goto L47;
        if (r16.equals(LynxTouchEvent.EVENT_TOUCH_END) == true) goto L47;
        if (r16.equals(LynxTouchEvent.EVENT_TOUCH_CANCEL) == true) goto L47;
        if (r16.equals(LynxTouchEvent.EVENT_TAP) == true) goto L47;
        if (r16.equals(LynxTouchEvent.EVENT_LONG_PRESS) == true) goto L47;
        if (r16.equals(LynxTouchEvent.EVENT_CLICK) == true) goto L47;
        return;
    L47:
        if (r3.getLynxContext() != null) goto L49;
        return;
    L49:
        if (r3.getLynxContext().getEventEmitter() == null) goto L58;
        r3.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(CastIntegerProtector.parseInt(r21), r16, r5, r4));
        return;
    L58:
        return;
    L16:
        r5 = r17;
        r4 = r18;
        goto L18
    }
}
