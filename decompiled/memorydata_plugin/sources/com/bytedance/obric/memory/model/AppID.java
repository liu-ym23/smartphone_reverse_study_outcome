package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum AppID extends Enum<AppID> {
    private static final /* synthetic */ AppID[] $VALUES = null;

    @SerializedName("1")
    public static final AppID Coco_Android = null;

    @SerializedName("2")
    public static final AppID Coco_iOS = null;
    private final int value;

    static {
        AppID r0 = new AppID("Coco_Android", 0, 1);
        Coco_Android = r0;
        AppID r1 = new AppID("Coco_iOS", 1, 2);
        Coco_iOS = r1;
        $VALUES = new AppID[]{r0, r1};
    }

    private AppID(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static AppID findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return Coco_iOS;
    L11:
        return Coco_Android;
    }

    public static AppID valueOf(String r2) {
        return (AppID) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppID.class, r2), AppID.class, "com.obric.memorydata.plugin");
    }

    public static AppID[] values() {
        return (AppID[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppID[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
