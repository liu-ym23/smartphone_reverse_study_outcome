package com.lynx.tasm.event;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxEventDetail {
    public final LynxEvent a;
    public final v6a.a b;

    public static final enum EVENT_TYPE extends Enum<EVENT_TYPE> {
        public static final EVENT_TYPE CUSTOM_EVENT = null;
        public static final EVENT_TYPE TOUCH_EVENT = null;
        public static final /* synthetic */ EVENT_TYPE[] a = null;

        static {
            EVENT_TYPE r0 = new EVENT_TYPE("TOUCH_EVENT", 0);
            TOUCH_EVENT = r0;
            EVENT_TYPE r1 = new EVENT_TYPE("CUSTOM_EVENT", 1);
            CUSTOM_EVENT = r1;
            a = new EVENT_TYPE[]{r0, r1};
        }

        public static EVENT_TYPE[] values() {
            return (EVENT_TYPE[]) a.clone();
        }

        public static EVENT_TYPE valueOf(String r1) {
            return (EVENT_TYPE) r27.a.a(EVENT_TYPE.class, r1);
        }

        public EVENT_TYPE(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final LynxTouchEvent.a a() {
        if (this.a.getType() == LynxEvent.LynxEventType.kTouch) goto L6;
        LLog.w("LynxEventDetail", "getTargetPoint error, event type is not touch event. type is " + this.a.getType());
        return new LynxTouchEvent.a(0.0f, 0.0f);
    L6:
        LynxTouchEvent.a r0 = ((LynxTouchEvent) this.a).getViewPoint();
        if (r0 == null) goto L9;
        return r0;
    L9:
        return new LynxTouchEvent.a(0.0f, 0.0f);
    }

    public LynxEventDetail(LynxEvent r1, EventTarget r2) {
        this.a = r1;
        this.b = r2;
    }
}
