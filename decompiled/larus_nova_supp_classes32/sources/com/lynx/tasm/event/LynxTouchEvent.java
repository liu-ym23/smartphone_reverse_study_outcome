package com.lynx.tasm.event;

import android.view.MotionEvent;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxTouchEvent extends LynxEvent {
    public static final String EVENT_CLICK = "click";
    public static final String EVENT_LONG_PRESS = "longpress";
    public static final String EVENT_TAP = "tap";
    public static final String EVENT_TOUCH_CANCEL = "touchcancel";
    public static final String EVENT_TOUCH_END = "touchend";
    public static final String EVENT_TOUCH_MOVE = "touchmove";
    public static final String EVENT_TOUCH_START = "touchstart";
    public static final int kPseudoStateActive = 8;
    public static final int kPseudoStateActiveTransition = 16;
    public static final int kPseudoStateAll = -1;
    public static final int kPseudoStateFocus = 64;
    public static final int kPseudoStateFocusTransition = 128;
    public static final int kPseudoStateHover = 1;
    public static final int kPseudoStateHoverTransition = 2;
    public static final int kPseudoStateNone = 0;
    private HashMap<Integer, v6a.a> mActiveTargetMap;
    private a mClientPoint;
    private boolean mIsMultiTouch;
    private MotionEvent mMotionEvent;
    private a mPagePoint;
    private Map<Integer, a> mTouchMap;
    private JavaOnlyMap mUITouchMap;
    private a mViewPoint;

    public static class a {
        public float a;
        public float b;

        public final int hashCode() {
            return Arrays.hashCode(new float[]{this.a, this.b});
        }

        public final String toString() {
            return "Point{x=" + this.a + ", y=" + this.b + '}';
        }

        public a() {
            this.a = 0.0f;
            this.b = 0.0f;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Float.compare(r6.a, this.a) == 0) goto L11;
        L13:
            return false;
        L11:
            if (Float.compare(r6.b, this.b) != 0) goto L13;
            return true;
        }

        public a(float r1, float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.lynx.tasm.event.LynxEvent
    public ArrayList<Object> getEventParams() {
        ArrayList<Object> r0 = super.getEventParams();
        ArrayList r1 = new ArrayList();
        r1.add(Boolean.valueOf(this.mIsMultiTouch));
        if (this.mIsMultiTouch == false) goto L5;
        r1.add(this.mUITouchMap);
    L6:
        r0.add(r1);
        return r0;
    L5:
        r1.add(Float.valueOf(this.mClientPoint.a));
        r1.add(Float.valueOf(this.mClientPoint.b));
        r1.add(Float.valueOf(this.mPagePoint.a));
        r1.add(Float.valueOf(this.mPagePoint.b));
        r1.add(Float.valueOf(this.mViewPoint.a));
        r1.add(Float.valueOf(this.mViewPoint.b));
        goto L6
    }

    public HashMap<Integer, v6a.a> getActiveTargetMap() {
        return this.mActiveTargetMap;
    }

    public a getClientPoint() {
        return this.mClientPoint;
    }

    public boolean getIsMultiTouch() {
        return this.mIsMultiTouch;
    }

    public MotionEvent getMotionEvent() {
        return this.mMotionEvent;
    }

    public a getPagePoint() {
        return this.mPagePoint;
    }

    public Map<Integer, a> getTouchMap() {
        return this.mTouchMap;
    }

    public JavaOnlyMap getUITouchMap() {
        return this.mUITouchMap;
    }

    public a getViewPoint() {
        return this.mViewPoint;
    }

    public void setActiveTargetMap(HashMap<Integer, v6a.a> r1) {
        this.mActiveTargetMap = r1;
    }

    public void setMotionEvent(MotionEvent r1) {
        this.mMotionEvent = r1;
    }

    public LynxTouchEvent(String r3, JavaOnlyMap r4) {
        super(-1, r3, LynxEvent.LynxEventType.kTouch);
        this.mIsMultiTouch = true;
        this.mUITouchMap = r4;
    }

    public LynxTouchEvent(int r2, String r3) {
        super(r2, r3, LynxEvent.LynxEventType.kTouch);
    }

    public LynxTouchEvent(int r2, String r3, Map<Integer, a> r4) {
        super(r2, r3, LynxEvent.LynxEventType.kTouch);
        this.mIsMultiTouch = true;
        this.mTouchMap = r4;
    }

    public LynxTouchEvent(int r2, String r3, float r4, float r5) {
        super(r2, r3, LynxEvent.LynxEventType.kTouch);
        a r6 = new a(r4, r5);
        this.mClientPoint = r6;
        this.mPagePoint = r6;
        this.mViewPoint = r6;
    }

    public LynxTouchEvent(int r2, String r3, a r4, a r5, a r6) {
        super(r2, r3, LynxEvent.LynxEventType.kTouch);
        this.mClientPoint = r4;
        this.mPagePoint = r5;
        this.mViewPoint = r6;
    }
}
