package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MultiStreamScene extends Enum<MultiStreamScene> {
    private static final /* synthetic */ MultiStreamScene[] $VALUES = null;

    @SerializedName("1")
    public static final MultiStreamScene CrowdTesting = null;

    @SerializedName("0")
    public static final MultiStreamScene Unknown_MultiStreamScene = null;
    private final int value;

    static {
        MultiStreamScene r0 = new MultiStreamScene("Unknown_MultiStreamScene", 0, 0);
        Unknown_MultiStreamScene = r0;
        MultiStreamScene r1 = new MultiStreamScene("CrowdTesting", 1, 1);
        CrowdTesting = r1;
        $VALUES = new MultiStreamScene[]{r0, r1};
    }

    private MultiStreamScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MultiStreamScene findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return CrowdTesting;
    L10:
        return Unknown_MultiStreamScene;
    }

    public static MultiStreamScene valueOf(String r2) {
        return (MultiStreamScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(MultiStreamScene.class, r2), MultiStreamScene.class, "com.obric.memorydata.plugin");
    }

    public static MultiStreamScene[] values() {
        return (MultiStreamScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MultiStreamScene[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
