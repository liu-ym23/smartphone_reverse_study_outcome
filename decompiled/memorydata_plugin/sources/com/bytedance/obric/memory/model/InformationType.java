package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum InformationType extends Enum<InformationType> {
    private static final /* synthetic */ InformationType[] $VALUES = null;

    @SerializedName("2")
    public static final InformationType Commemoration = null;

    @SerializedName("4")
    public static final InformationType CommuteTime = null;

    @SerializedName("0")
    public static final InformationType HomeAddress = null;

    @SerializedName("3")
    public static final InformationType SleepTime = null;

    @SerializedName("1")
    public static final InformationType WorkAddress = null;
    private final int value;

    static {
        InformationType r0 = new InformationType("HomeAddress", 0, 0);
        HomeAddress = r0;
        InformationType r1 = new InformationType("WorkAddress", 1, 1);
        WorkAddress = r1;
        InformationType r3 = new InformationType("Commemoration", 2, 2);
        Commemoration = r3;
        InformationType r5 = new InformationType("SleepTime", 3, 3);
        SleepTime = r5;
        InformationType r7 = new InformationType("CommuteTime", 4, 4);
        CommuteTime = r7;
        $VALUES = new InformationType[]{r0, r1, r3, r5, r7};
    }

    private InformationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static InformationType findByValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return CommuteTime;
    L16:
        return SleepTime;
    L18:
        return Commemoration;
    L20:
        return WorkAddress;
    L22:
        return HomeAddress;
    }

    public static InformationType valueOf(String r2) {
        return (InformationType) ZeusTransformUtils.preCheckCast(Enum.valueOf(InformationType.class, r2), InformationType.class, "com.obric.memorydata.plugin");
    }

    public static InformationType[] values() {
        return (InformationType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InformationType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
