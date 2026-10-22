package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelProxy extends Enum<ModelProxy> {
    private static final /* synthetic */ ModelProxy[] $VALUES = null;

    @SerializedName("3")
    public static final ModelProxy Agent = null;

    @SerializedName("2")
    public static final ModelProxy Chain = null;

    @SerializedName("4")
    public static final ModelProxy Executor = null;

    @SerializedName("1")
    public static final ModelProxy FuncBot = null;
    private final int value;

    static {
        ModelProxy r0 = new ModelProxy("FuncBot", 0, 1);
        FuncBot = r0;
        ModelProxy r1 = new ModelProxy("Chain", 1, 2);
        Chain = r1;
        ModelProxy r4 = new ModelProxy("Agent", 2, 3);
        Agent = r4;
        ModelProxy r6 = new ModelProxy("Executor", 3, 4);
        Executor = r6;
        $VALUES = new ModelProxy[]{r0, r1, r4, r6};
    }

    private ModelProxy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelProxy findByValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return Executor;
    L15:
        return Agent;
    L17:
        return Chain;
    L19:
        return FuncBot;
    }

    public static ModelProxy valueOf(String r2) {
        return (ModelProxy) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelProxy.class, r2), ModelProxy.class, "com.obric.memorydata.plugin");
    }

    public static ModelProxy[] values() {
        return (ModelProxy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelProxy[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
