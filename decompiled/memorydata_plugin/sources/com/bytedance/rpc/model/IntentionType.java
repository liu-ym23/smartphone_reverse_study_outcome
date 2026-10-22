package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum IntentionType extends Enum<IntentionType> {
    private static final /* synthetic */ IntentionType[] $VALUES = null;

    @SerializedName("4")
    public static final IntentionType ComplexSearchText = null;

    @SerializedName("1")
    public static final IntentionType Default = null;

    @SerializedName("5")
    public static final IntentionType SearchImage = null;

    @SerializedName("6")
    public static final IntentionType SearchRichMedia = null;

    @SerializedName("7")
    public static final IntentionType SearchRichMediaStrong = null;

    @SerializedName("8")
    public static final IntentionType SearchRichMediaWeak = null;

    @SerializedName("2")
    public static final IntentionType SearchText = null;

    @SerializedName("3")
    public static final IntentionType SearchVideo = null;
    private final int value;

    static {
        IntentionType r0 = new IntentionType("Default", 0, 1);
        Default = r0;
        IntentionType r1 = new IntentionType("SearchText", 1, 2);
        SearchText = r1;
        IntentionType r4 = new IntentionType("SearchVideo", 2, 3);
        SearchVideo = r4;
        IntentionType r6 = new IntentionType("ComplexSearchText", 3, 4);
        ComplexSearchText = r6;
        IntentionType r8 = new IntentionType("SearchImage", 4, 5);
        SearchImage = r8;
        IntentionType r10 = new IntentionType("SearchRichMedia", 5, 6);
        SearchRichMedia = r10;
        IntentionType r12 = new IntentionType("SearchRichMediaStrong", 6, 7);
        SearchRichMediaStrong = r12;
        IntentionType r14 = new IntentionType("SearchRichMediaWeak", 7, 8);
        SearchRichMediaWeak = r14;
        $VALUES = new IntentionType[]{r0, r1, r4, r6, r8, r10, r12, r14};
    }

    private IntentionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static IntentionType findByValue(int r0) {
        switch(r0) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return SearchRichMediaWeak;
    L8:
        return SearchRichMediaStrong;
    L10:
        return SearchRichMedia;
    L12:
        return SearchImage;
    L14:
        return ComplexSearchText;
    L16:
        return SearchVideo;
    L18:
        return SearchText;
    L20:
        return Default;
    }

    public static IntentionType valueOf(String r2) {
        return (IntentionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(IntentionType.class, r2), IntentionType.class, "com.obric.memorydata.plugin");
    }

    public static IntentionType[] values() {
        return (IntentionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IntentionType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
