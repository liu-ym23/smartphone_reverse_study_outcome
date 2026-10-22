package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum RelatedType extends Enum<RelatedType> {
    private static final /* synthetic */ RelatedType[] $VALUES = null;

    @SerializedName("2")
    public static final RelatedType NotRelated = null;

    @SerializedName("1")
    public static final RelatedType Related = null;
    private final int value;

    static {
        RelatedType r0 = new RelatedType("Related", 0, 1);
        Related = r0;
        RelatedType r1 = new RelatedType("NotRelated", 1, 2);
        NotRelated = r1;
        $VALUES = new RelatedType[]{r0, r1};
    }

    private RelatedType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static RelatedType findByValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return NotRelated;
    L11:
        return Related;
    }

    public static RelatedType valueOf(String r2) {
        return (RelatedType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RelatedType.class, r2), RelatedType.class, "com.obric.memorydata.plugin");
    }

    public static RelatedType[] values() {
        return (RelatedType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RelatedType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
