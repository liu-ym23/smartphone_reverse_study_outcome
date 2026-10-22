package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum OmniSkillSource extends Enum<OmniSkillSource> {
    private static final /* synthetic */ OmniSkillSource[] $VALUES = null;

    @SerializedName("1")
    public static final OmniSkillSource CLOUD = null;

    @SerializedName("2")
    public static final OmniSkillSource DEVICE = null;

    @SerializedName("3")
    public static final OmniSkillSource IMPORT = null;

    @SerializedName("0")
    public static final OmniSkillSource UNKNOWN = null;
    private final int value;

    static {
        OmniSkillSource r0 = new OmniSkillSource("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        OmniSkillSource r1 = new OmniSkillSource("CLOUD", 1, 1);
        CLOUD = r1;
        OmniSkillSource r3 = new OmniSkillSource("DEVICE", 2, 2);
        DEVICE = r3;
        OmniSkillSource r5 = new OmniSkillSource("IMPORT", 3, 3);
        IMPORT = r5;
        $VALUES = new OmniSkillSource[]{r0, r1, r3, r5};
    }

    private OmniSkillSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static OmniSkillSource findByValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return IMPORT;
    L14:
        return DEVICE;
    L16:
        return CLOUD;
    L18:
        return UNKNOWN;
    }

    public static OmniSkillSource valueOf(String r2) {
        return (OmniSkillSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(OmniSkillSource.class, r2), OmniSkillSource.class, "com.obric.memorydata.plugin");
    }

    public static OmniSkillSource[] values() {
        return (OmniSkillSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OmniSkillSource[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
