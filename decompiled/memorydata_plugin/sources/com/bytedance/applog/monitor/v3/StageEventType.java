package com.bytedance.applog.monitor.v3;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum StageEventType extends Enum<StageEventType> {
    private static final /* synthetic */ StageEventType[] $VALUES = null;
    public static final StageEventType ITEM_IMPRESSION = null;
    public static final StageEventType LAUNCH = null;
    public static final StageEventType LOG_DATA = null;
    public static final StageEventType TERMINATE = null;
    public static final StageEventType V1_EVENT = null;
    public static final StageEventType V3_EVENT = null;
    private final int label;

    static {
        StageEventType r0 = new StageEventType("V3_EVENT", 0, 0);
        V3_EVENT = r0;
        StageEventType r1 = new StageEventType("V1_EVENT", 1, 1);
        V1_EVENT = r1;
        StageEventType r3 = new StageEventType("LOG_DATA", 2, 2);
        LOG_DATA = r3;
        StageEventType r5 = new StageEventType("LAUNCH", 3, 3);
        LAUNCH = r5;
        StageEventType r7 = new StageEventType("TERMINATE", 4, 4);
        TERMINATE = r7;
        StageEventType r9 = new StageEventType("ITEM_IMPRESSION", 5, 5);
        ITEM_IMPRESSION = r9;
        $VALUES = new StageEventType[]{r0, r1, r3, r5, r7, r9};
    }

    private StageEventType(String r1, int r2, int r3) {
        super(r1, r2);
        this.label = r3;
    }

    public static StageEventType fromLabel(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return V3_EVENT;
    L13:
        return TERMINATE;
    L15:
        return LAUNCH;
    L17:
        return LOG_DATA;
    L19:
        return V1_EVENT;
    }

    public static StageEventType parse(String r5) {
        StageEventType[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        StageEventType r3 = r0[r2];
        if (r3.name().equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return V3_EVENT;
    }

    public static StageEventType valueOf(String r2) {
        return (StageEventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(StageEventType.class, r2), StageEventType.class, "com.obric.memorydata.plugin");
    }

    public static StageEventType[] values() {
        return (StageEventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StageEventType[].class, "com.obric.memorydata.plugin");
    }

    public int getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + "-" + this.label;
    }
}
