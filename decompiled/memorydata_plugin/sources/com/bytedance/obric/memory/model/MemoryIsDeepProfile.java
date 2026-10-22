package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MemoryIsDeepProfile extends Enum<MemoryIsDeepProfile> {
    private static final /* synthetic */ MemoryIsDeepProfile[] $VALUES = null;

    @SerializedName("0")
    public static final MemoryIsDeepProfile No = null;

    @SerializedName("1")
    public static final MemoryIsDeepProfile Yes = null;
    private final int value;

    static {
        MemoryIsDeepProfile r0 = new MemoryIsDeepProfile("No", 0, 0);
        No = r0;
        MemoryIsDeepProfile r1 = new MemoryIsDeepProfile("Yes", 1, 1);
        Yes = r1;
        $VALUES = new MemoryIsDeepProfile[]{r0, r1};
    }

    private MemoryIsDeepProfile(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MemoryIsDeepProfile findByValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Yes;
    L10:
        return No;
    }

    public static MemoryIsDeepProfile valueOf(String r2) {
        return (MemoryIsDeepProfile) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryIsDeepProfile.class, r2), MemoryIsDeepProfile.class, "com.obric.memorydata.plugin");
    }

    public static MemoryIsDeepProfile[] values() {
        return (MemoryIsDeepProfile[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryIsDeepProfile[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
