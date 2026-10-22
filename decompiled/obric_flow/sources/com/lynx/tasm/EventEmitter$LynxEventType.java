package com.lynx.tasm;

/* JADX INFO: loaded from: classes2.dex */
public final enum EventEmitter$LynxEventType extends Enum<EventEmitter$LynxEventType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EventEmitter$LynxEventType f9956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EventEmitter$LynxEventType f9957b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EventEmitter$LynxEventType[] f9958c = null;

    static {
        EventEmitter$LynxEventType r5 = new EventEmitter$LynxEventType("kLynxEventTypeTouchEvent", 0);
        EventEmitter$LynxEventType r10 = new EventEmitter$LynxEventType("kLynxEventTypeCustomEvent", 1);
        f9956a = r10;
        EventEmitter$LynxEventType r11 = new EventEmitter$LynxEventType("kLynxEventTypeLayoutEvent", 2);
        f9957b = r11;
        f9958c = new EventEmitter$LynxEventType[]{r5, r10, r11};
    }

    public EventEmitter$LynxEventType(String r5, int r10) {
        super(r5, r10);
    }

    public static EventEmitter$LynxEventType valueOf(String r5) {
        return (EventEmitter$LynxEventType) Enum.valueOf(EventEmitter$LynxEventType.class, r5);
    }

    public static EventEmitter$LynxEventType[] values() {
        return (EventEmitter$LynxEventType[]) f9958c.clone();
    }
}
