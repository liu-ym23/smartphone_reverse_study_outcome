package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SceneType extends Enum<SceneType> {
    private static final /* synthetic */ SceneType[] $VALUES = null;

    @SerializedName("3")
    public static final SceneType SceneTypeDora = null;

    @SerializedName("1")
    public static final SceneType SceneTypeGUI = null;

    @SerializedName("0")
    public static final SceneType SceneTypeUnknown = null;

    @SerializedName("2")
    public static final SceneType SceneTypeVUI = null;

    @SerializedName("4")
    public static final SceneType SceneTypeVision = null;
    private final int value;

    static {
        SceneType r0 = new SceneType("SceneTypeUnknown", 0, 0);
        SceneTypeUnknown = r0;
        SceneType r1 = new SceneType("SceneTypeGUI", 1, 1);
        SceneTypeGUI = r1;
        SceneType r3 = new SceneType("SceneTypeVUI", 2, 2);
        SceneTypeVUI = r3;
        SceneType r5 = new SceneType("SceneTypeDora", 3, 3);
        SceneTypeDora = r5;
        SceneType r7 = new SceneType("SceneTypeVision", 4, 4);
        SceneTypeVision = r7;
        $VALUES = new SceneType[]{r0, r1, r3, r5, r7};
    }

    private SceneType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static SceneType findByValue(int r1) {
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L14;
        return null;
    L14:
        return SceneTypeVision;
    L16:
        return SceneTypeDora;
    L18:
        return SceneTypeVUI;
    L20:
        return SceneTypeGUI;
    L22:
        return SceneTypeUnknown;
    }

    public static SceneType valueOf(String r2) {
        return (SceneType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SceneType.class, r2), SceneType.class, "com.obric.memorydata.plugin");
    }

    public static SceneType[] values() {
        return (SceneType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SceneType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
