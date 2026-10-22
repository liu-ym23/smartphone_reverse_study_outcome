package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ResumeScene extends Enum<ResumeScene> {
    private static final /* synthetic */ ResumeScene[] $VALUES = null;

    @SerializedName("2")
    public static final ResumeScene PluginAsync = null;

    @SerializedName("1")
    public static final ResumeScene PluginAuthorized = null;

    @SerializedName("3")
    public static final ResumeScene PluginInterrupt = null;

    @SerializedName("0")
    public static final ResumeScene ResumeDefault = null;
    private final int value;

    static {
        ResumeScene r0 = new ResumeScene("ResumeDefault", 0, 0);
        ResumeDefault = r0;
        ResumeScene r1 = new ResumeScene("PluginAuthorized", 1, 1);
        PluginAuthorized = r1;
        ResumeScene r3 = new ResumeScene("PluginAsync", 2, 2);
        PluginAsync = r3;
        ResumeScene r5 = new ResumeScene("PluginInterrupt", 3, 3);
        PluginInterrupt = r5;
        $VALUES = new ResumeScene[]{r0, r1, r3, r5};
    }

    private ResumeScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ResumeScene findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return PluginInterrupt;
    L14:
        return PluginAsync;
    L16:
        return PluginAuthorized;
    L18:
        return ResumeDefault;
    }

    public static ResumeScene valueOf(String r2) {
        return (ResumeScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResumeScene.class, r2), ResumeScene.class, "com.obric.memorydata.plugin");
    }

    public static ResumeScene[] values() {
        return (ResumeScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResumeScene[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
