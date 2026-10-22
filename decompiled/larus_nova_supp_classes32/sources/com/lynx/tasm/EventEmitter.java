package com.lynx.tasm;

import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class EventEmitter {
    private static final String TAG = "EventEmitter";

    public static final enum LynxEventType extends Enum<LynxEventType> {
        public static final /* synthetic */ LynxEventType[] a = null;
        public static final LynxEventType kLynxEventTypeCustomEvent = null;
        public static final LynxEventType kLynxEventTypeLayoutEvent = null;
        public static final LynxEventType kLynxEventTypeTouchEvent = null;

        static {
            LynxEventType r0 = new LynxEventType("kLynxEventTypeTouchEvent", 0);
            kLynxEventTypeTouchEvent = r0;
            LynxEventType r1 = new LynxEventType("kLynxEventTypeCustomEvent", 1);
            kLynxEventTypeCustomEvent = r1;
            LynxEventType r3 = new LynxEventType("kLynxEventTypeLayoutEvent", 2);
            kLynxEventTypeLayoutEvent = r3;
            a = new LynxEventType[]{r0, r1, r3};
        }

        public static LynxEventType[] values() {
            return (LynxEventType[]) a.clone();
        }

        public static LynxEventType valueOf(String r1) {
            return (LynxEventType) r27.a.a(LynxEventType.class, r1);
        }

        public LynxEventType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
    }

    public interface b {
        void checkFallbackForLynxEvent(boolean r1);
    }

    public interface c {
        void a(LynxEventType r1, LynxEvent r2);
    }

    public interface d {
        boolean a(LynxEvent r1);
    }

    public EventEmitter() {
    }

    public abstract void addObserver(c r1);

    public void onInternalEvent(m7a.c r1) {
    }

    public abstract boolean onLynxEvent(LynxEvent r1);

    public abstract void onPseudoStatusChanged(int r1, int r2, int r3);

    public abstract void registerEventFallback(b r1);

    public abstract void registerEventReporter(d r1);

    public abstract void removeObserver(c r1);

    public abstract void sendCustomEvent(com.lynx.tasm.event.a r1);

    public abstract void sendGestureEvent(int r1, com.lynx.tasm.event.a r2);

    public void sendInternalEvent(m7a.c r1) {
    }

    public abstract void sendLayoutEvent();

    public abstract void sendMultiTouchEvent(LynxTouchEvent r1);

    public abstract void sendTouchEvent(LynxTouchEvent r1);

    public void setEventID(long r1) {
    }

    public abstract void setInPreLoad(boolean r1);

    public abstract void setTestTapTracker(a r1);

    public void startEventBubble(long r1) {
    }

    public void startEventCapture(long r1) {
    }

    public void startEventFire(boolean r1, long r2) {
    }

    public void startEventGenerate(LynxEvent r1) {
    }
}
