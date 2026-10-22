package com.bytedance.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum EventType extends Enum<EventType> {
    private static final /* synthetic */ EventType[] $VALUES = null;
    public static final EventType FORWARD_V3 = null;
    public static final EventType IMPRESSION = null;
    public static final EventType Launch = null;
    public static final EventType LogData = null;
    public static final EventType Terminate = null;
    public static final EventType UNKNOWN = null;
    public static final EventType V1 = null;
    public static final EventType V3 = null;
    final int value;

    static {
        EventType r0 = new EventType("V3", 0, 0);
        V3 = r0;
        EventType r1 = new EventType("V1", 1, 1);
        V1 = r1;
        EventType r3 = new EventType("LogData", 2, 2);
        LogData = r3;
        EventType r5 = new EventType("Launch", 3, 3);
        Launch = r5;
        EventType r7 = new EventType("Terminate", 4, 4);
        Terminate = r7;
        EventType r9 = new EventType("IMPRESSION", 5, 5);
        IMPRESSION = r9;
        EventType r11 = new EventType("FORWARD_V3", 6, 6);
        FORWARD_V3 = r11;
        EventType r13 = new EventType("UNKNOWN", 7, 99);
        UNKNOWN = r13;
        $VALUES = new EventType[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    private EventType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EventType valueOf(String r2) {
        return (EventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventType.class, r2), EventType.class, "com.obric.memorydata.plugin");
    }

    public static EventType[] values() {
        return (EventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventType[].class, "com.obric.memorydata.plugin");
    }

    public int value() {
        return this.value;
    }
}
