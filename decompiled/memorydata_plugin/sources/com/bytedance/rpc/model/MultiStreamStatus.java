package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MultiStreamStatus extends Enum<MultiStreamStatus> {
    private static final /* synthetic */ MultiStreamStatus[] $VALUES = null;

    @SerializedName("2")
    public static final MultiStreamStatus End = null;

    @SerializedName("1")
    public static final MultiStreamStatus Start = null;

    @SerializedName("0")
    public static final MultiStreamStatus Unknown_MultiStreamStatus = null;
    private final int value;

    static {
        MultiStreamStatus r0 = new MultiStreamStatus("Unknown_MultiStreamStatus", 0, 0);
        Unknown_MultiStreamStatus = r0;
        MultiStreamStatus r1 = new MultiStreamStatus("Start", 1, 1);
        Start = r1;
        MultiStreamStatus r3 = new MultiStreamStatus("End", 2, 2);
        End = r3;
        $VALUES = new MultiStreamStatus[]{r0, r1, r3};
    }

    private MultiStreamStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MultiStreamStatus findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return End;
    L12:
        return Start;
    L14:
        return Unknown_MultiStreamStatus;
    }

    public static MultiStreamStatus valueOf(String r2) {
        return (MultiStreamStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(MultiStreamStatus.class, r2), MultiStreamStatus.class, "com.obric.memorydata.plugin");
    }

    public static MultiStreamStatus[] values() {
        return (MultiStreamStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MultiStreamStatus[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
