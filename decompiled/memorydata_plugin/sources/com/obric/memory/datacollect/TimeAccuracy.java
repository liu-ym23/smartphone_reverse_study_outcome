package com.obric.memory.datacollect;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum TimeAccuracy extends Enum<TimeAccuracy> {
    private static final /* synthetic */ TimeAccuracy[] $VALUES = null;

    @SerializedName("0")
    public static final TimeAccuracy ACCURATE = null;

    @SerializedName("1")
    public static final TimeAccuracy LATE = null;
    private final int value;

    static {
        TimeAccuracy r0 = new TimeAccuracy("ACCURATE", 0, 0);
        ACCURATE = r0;
        TimeAccuracy r1 = new TimeAccuracy("LATE", 1, 1);
        LATE = r1;
        $VALUES = new TimeAccuracy[]{r0, r1};
    }

    private TimeAccuracy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static TimeAccuracy findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return LATE;
    L10:
        return ACCURATE;
    }

    public static TimeAccuracy valueOf(String r2) {
        return (TimeAccuracy) ZeusTransformUtils.preCheckCast(Enum.valueOf(TimeAccuracy.class, r2), TimeAccuracy.class, "com.obric.memorydata.plugin");
    }

    public static TimeAccuracy[] values() {
        return (TimeAccuracy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TimeAccuracy[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
