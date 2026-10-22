package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.ErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelListScene extends Enum<ModelListScene> {
    private static final /* synthetic */ ModelListScene[] $VALUES = null;

    @SerializedName("4000")
    public static final ModelListScene BotPlatform = null;

    @SerializedName("4001")
    public static final ModelListScene BotPlatformInhouse = null;

    @SerializedName("3001")
    public static final ModelListScene FlowAll = null;

    @SerializedName("2000")
    public static final ModelListScene FlowApp = null;

    @SerializedName("3000")
    public static final ModelListScene FlowOPAdmin = null;

    @SerializedName("1000")
    public static final ModelListScene PromptEvaluatePlatform = null;

    @SerializedName("5000")
    public static final ModelListScene Workflow = null;
    private final int value;

    static {
        ModelListScene r0 = new ModelListScene("PromptEvaluatePlatform", 0, 1000);
        PromptEvaluatePlatform = r0;
        ModelListScene r1 = new ModelListScene("FlowApp", 1, 2000);
        FlowApp = r1;
        ModelListScene r3 = new ModelListScene("FlowOPAdmin", 2, 3000);
        FlowOPAdmin = r3;
        ModelListScene r5 = new ModelListScene("FlowAll", 3, ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR);
        FlowAll = r5;
        ModelListScene r7 = new ModelListScene("BotPlatform", 4, 4000);
        BotPlatform = r7;
        ModelListScene r9 = new ModelListScene("BotPlatformInhouse", 5, ErrorCode.System.UNSUPPORTED_SCREEN_RECORDER_WHEN_KEYGUARD_LOCKED_ERROR);
        BotPlatformInhouse = r9;
        ModelListScene r11 = new ModelListScene("Workflow", 6, 5000);
        Workflow = r11;
        $VALUES = new ModelListScene[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private ModelListScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelListScene findByValue(int r1) {
        if (r1 == 1000) goto L31;
        if (r1 == 2000) goto L29;
        if (r1 == 5000) goto L27;
        if (r1 == 3000) goto L25;
        if (r1 == 3001) goto L23;
        if (r1 == 4000) goto L21;
        if (r1 == 4001) goto L19;
        return null;
    L19:
        return BotPlatformInhouse;
    L21:
        return BotPlatform;
    L23:
        return FlowAll;
    L25:
        return FlowOPAdmin;
    L27:
        return Workflow;
    L29:
        return FlowApp;
    L31:
        return PromptEvaluatePlatform;
    }

    public static ModelListScene valueOf(String r2) {
        return (ModelListScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelListScene.class, r2), ModelListScene.class, "com.obric.memorydata.plugin");
    }

    public static ModelListScene[] values() {
        return (ModelListScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelListScene[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
