package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum InsertReferenceType extends Enum<InsertReferenceType> {
    private static final /* synthetic */ InsertReferenceType[] $VALUES = null;

    @SerializedName("3")
    public static final InsertReferenceType Image = null;

    @SerializedName("1")
    public static final InsertReferenceType Text = null;

    @SerializedName("2")
    public static final InsertReferenceType Video = null;
    private final int value;

    static {
        InsertReferenceType r0 = new InsertReferenceType("Text", 0, 1);
        Text = r0;
        InsertReferenceType r1 = new InsertReferenceType("Video", 1, 2);
        Video = r1;
        InsertReferenceType r4 = new InsertReferenceType("Image", 2, 3);
        Image = r4;
        $VALUES = new InsertReferenceType[]{r0, r1, r4};
    }

    private InsertReferenceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static InsertReferenceType findByValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return Image;
    L13:
        return Video;
    L15:
        return Text;
    }

    public static InsertReferenceType valueOf(String r2) {
        return (InsertReferenceType) ZeusTransformUtils.preCheckCast(Enum.valueOf(InsertReferenceType.class, r2), InsertReferenceType.class, "com.obric.memorydata.plugin");
    }

    public static InsertReferenceType[] values() {
        return (InsertReferenceType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InsertReferenceType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
