package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelProvider extends Enum<ModelProvider> {
    private static final /* synthetic */ ModelProvider[] $VALUES = null;

    @SerializedName("5")
    public static final ModelProvider BytedLLMServer = null;

    @SerializedName("2")
    public static final ModelProvider GptEngine = null;

    @SerializedName("1")
    public static final ModelProvider GptOpenApi = null;

    @SerializedName("3")
    public static final ModelProvider MaaS = null;

    @SerializedName("4")
    public static final ModelProvider QianFan = null;
    private final int value;

    static {
        ModelProvider r0 = new ModelProvider("GptOpenApi", 0, 1);
        GptOpenApi = r0;
        ModelProvider r1 = new ModelProvider("GptEngine", 1, 2);
        GptEngine = r1;
        ModelProvider r4 = new ModelProvider("MaaS", 2, 3);
        MaaS = r4;
        ModelProvider r6 = new ModelProvider("QianFan", 3, 4);
        QianFan = r6;
        ModelProvider r8 = new ModelProvider("BytedLLMServer", 4, 5);
        BytedLLMServer = r8;
        $VALUES = new ModelProvider[]{r0, r1, r4, r6, r8};
    }

    private ModelProvider(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelProvider findByValue(int r1) {
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L17;
        if (r1 == 5) goto L15;
        return null;
    L15:
        return BytedLLMServer;
    L17:
        return QianFan;
    L19:
        return MaaS;
    L21:
        return GptEngine;
    L23:
        return GptOpenApi;
    }

    public static ModelProvider valueOf(String r2) {
        return (ModelProvider) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelProvider.class, r2), ModelProvider.class, "com.obric.memorydata.plugin");
    }

    public static ModelProvider[] values() {
        return (ModelProvider[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelProvider[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
