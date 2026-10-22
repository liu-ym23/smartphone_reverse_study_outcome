package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SpaceType extends Enum<SpaceType> {
    private static final /* synthetic */ SpaceType[] $VALUES = null;

    @SerializedName("1")
    public static final SpaceType Explore = null;

    @SerializedName("2")
    public static final SpaceType Person = null;

    @SerializedName("3")
    public static final SpaceType Team = null;
    private final int value;

    static {
        SpaceType r0 = new SpaceType("Explore", 0, 1);
        Explore = r0;
        SpaceType r1 = new SpaceType("Person", 1, 2);
        Person = r1;
        SpaceType r4 = new SpaceType("Team", 2, 3);
        Team = r4;
        $VALUES = new SpaceType[]{r0, r1, r4};
    }

    private SpaceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static SpaceType findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return Team;
    L13:
        return Person;
    L15:
        return Explore;
    }

    public static SpaceType valueOf(String r2) {
        return (SpaceType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SpaceType.class, r2), SpaceType.class, "com.obric.memorydata.plugin");
    }

    public static SpaceType[] values() {
        return (SpaceType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SpaceType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
