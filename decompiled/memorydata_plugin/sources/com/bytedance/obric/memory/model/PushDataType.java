package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum PushDataType extends Enum<PushDataType> {
    private static final /* synthetic */ PushDataType[] $VALUES = null;

    @SerializedName("2")
    public static final PushDataType APPOpenClose = null;

    @SerializedName("5")
    public static final PushDataType ConnectedDevice = null;

    @SerializedName("0")
    public static final PushDataType IMG = null;

    @SerializedName("4")
    public static final PushDataType LocationChange = null;

    @SerializedName("1")
    public static final PushDataType Recording = null;

    @SerializedName("3")
    public static final PushDataType SystemPush = null;
    private final int value;

    static {
        PushDataType r0 = new PushDataType("IMG", 0, 0);
        IMG = r0;
        PushDataType r1 = new PushDataType("Recording", 1, 1);
        Recording = r1;
        PushDataType r3 = new PushDataType("APPOpenClose", 2, 2);
        APPOpenClose = r3;
        PushDataType r5 = new PushDataType("SystemPush", 3, 3);
        SystemPush = r5;
        PushDataType r7 = new PushDataType("LocationChange", 4, 4);
        LocationChange = r7;
        PushDataType r9 = new PushDataType("ConnectedDevice", 5, 5);
        ConnectedDevice = r9;
        $VALUES = new PushDataType[]{r0, r1, r3, r5, r7, r9};
    }

    private PushDataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static PushDataType findByValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return ConnectedDevice;
    L18:
        return LocationChange;
    L20:
        return SystemPush;
    L22:
        return APPOpenClose;
    L24:
        return Recording;
    L26:
        return IMG;
    }

    public static PushDataType valueOf(String r2) {
        return (PushDataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PushDataType.class, r2), PushDataType.class, "com.obric.memorydata.plugin");
    }

    public static PushDataType[] values() {
        return (PushDataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PushDataType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
