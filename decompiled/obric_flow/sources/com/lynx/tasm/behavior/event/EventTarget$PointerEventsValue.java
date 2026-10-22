package com.lynx.tasm.behavior.event;

/* JADX INFO: loaded from: classes2.dex */
public final enum EventTarget$PointerEventsValue extends Enum<EventTarget$PointerEventsValue> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EventTarget$PointerEventsValue f10247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EventTarget$PointerEventsValue f10248b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EventTarget$PointerEventsValue f10249c = null;
    public static final /* synthetic */ EventTarget$PointerEventsValue[] d = null;

    static {
        EventTarget$PointerEventsValue r5 = new EventTarget$PointerEventsValue("Auto", 0);
        f10247a = r5;
        EventTarget$PointerEventsValue r10 = new EventTarget$PointerEventsValue("None", 1);
        f10248b = r10;
        EventTarget$PointerEventsValue r11 = new EventTarget$PointerEventsValue("Unset", 2);
        f10249c = r11;
        d = new EventTarget$PointerEventsValue[]{r5, r10, r11};
    }

    public EventTarget$PointerEventsValue(String r5, int r10) {
        super(r5, r10);
    }

    public static EventTarget$PointerEventsValue valueOf(String r5) {
        return (EventTarget$PointerEventsValue) Enum.valueOf(EventTarget$PointerEventsValue.class, r5);
    }

    public static EventTarget$PointerEventsValue[] values() {
        return (EventTarget$PointerEventsValue[]) d.clone();
    }
}
