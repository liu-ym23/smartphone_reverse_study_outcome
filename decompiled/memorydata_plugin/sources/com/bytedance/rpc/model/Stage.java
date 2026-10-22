package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum Stage extends Enum<Stage> {
    private static final /* synthetic */ Stage[] $VALUES = null;

    @SerializedName("1")
    public static final Stage AgentHook = null;

    @SerializedName("0")
    public static final Stage Plan = null;
    private final int value;

    static {
        Stage r0 = new Stage("Plan", 0, 0);
        Plan = r0;
        Stage r1 = new Stage("AgentHook", 1, 1);
        AgentHook = r1;
        $VALUES = new Stage[]{r0, r1};
    }

    private Stage(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static Stage findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return AgentHook;
    L10:
        return Plan;
    }

    public static Stage valueOf(String r2) {
        return (Stage) ZeusTransformUtils.preCheckCast(Enum.valueOf(Stage.class, r2), Stage.class, "com.obric.memorydata.plugin");
    }

    public static Stage[] values() {
        return (Stage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Stage[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
