package com.lynx.tasm.behavior.event;

/* JADX INFO: loaded from: classes2.dex */
public final enum EventTarget$EnableStatus extends Enum<EventTarget$EnableStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EventTarget$EnableStatus f10244a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EventTarget$EnableStatus f10245b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EventTarget$EnableStatus f10246c = null;
    public static final /* synthetic */ EventTarget$EnableStatus[] d = null;

    static {
        EventTarget$EnableStatus r5 = new EventTarget$EnableStatus("Enable", 0);
        f10244a = r5;
        EventTarget$EnableStatus r10 = new EventTarget$EnableStatus("Disable", 1);
        f10245b = r10;
        EventTarget$EnableStatus r11 = new EventTarget$EnableStatus("Undefined", 2);
        f10246c = r11;
        d = new EventTarget$EnableStatus[]{r5, r10, r11};
    }

    public EventTarget$EnableStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static EventTarget$EnableStatus valueOf(String r5) {
        return (EventTarget$EnableStatus) Enum.valueOf(EventTarget$EnableStatus.class, r5);
    }

    public static EventTarget$EnableStatus[] values() {
        return (EventTarget$EnableStatus[]) d.clone();
    }
}
