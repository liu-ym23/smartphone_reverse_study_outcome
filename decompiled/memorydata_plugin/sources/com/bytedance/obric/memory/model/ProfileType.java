package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ProfileType extends Enum<ProfileType> {
    private static final /* synthetic */ ProfileType[] $VALUES = null;

    @SerializedName("1")
    public static final ProfileType Deep = null;

    @SerializedName("0")
    public static final ProfileType Shallow = null;
    private final int value;

    static {
        ProfileType r0 = new ProfileType("Shallow", 0, 0);
        Shallow = r0;
        ProfileType r1 = new ProfileType("Deep", 1, 1);
        Deep = r1;
        $VALUES = new ProfileType[]{r0, r1};
    }

    private ProfileType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ProfileType findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Deep;
    L10:
        return Shallow;
    }

    public static ProfileType valueOf(String r2) {
        return (ProfileType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ProfileType.class, r2), ProfileType.class, "com.obric.memorydata.plugin");
    }

    public static ProfileType[] values() {
        return (ProfileType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ProfileType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
