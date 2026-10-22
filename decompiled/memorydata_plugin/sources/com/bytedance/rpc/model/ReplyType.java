package com.bytedance.rpc.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ReplyType extends Enum<ReplyType> {
    private static final /* synthetic */ ReplyType[] $VALUES = null;

    @SerializedName("1")
    public static final ReplyType Answer = null;

    @SerializedName("5")
    public static final ReplyType DataSet = null;

    @SerializedName("7")
    public static final ReplyType IntermediateOutput = null;

    @SerializedName("3")
    public static final ReplyType LLMOutput = null;

    @SerializedName("101")
    public static final ReplyType PlaceHolder = null;

    @SerializedName("6")
    public static final ReplyType QueryKeyword = null;

    @SerializedName("2")
    public static final ReplyType Suggest = null;

    @SerializedName("4")
    public static final ReplyType ToolOutput = null;

    @SerializedName(BDLocationException.ERROR_BEACON_ADVERTISING)
    public static final ReplyType Verbose = null;
    private final int value;

    static {
        ReplyType r0 = new ReplyType("Answer", 0, 1);
        Answer = r0;
        ReplyType r1 = new ReplyType("Suggest", 1, 2);
        Suggest = r1;
        ReplyType r4 = new ReplyType("LLMOutput", 2, 3);
        LLMOutput = r4;
        ReplyType r6 = new ReplyType("ToolOutput", 3, 4);
        ToolOutput = r6;
        ReplyType r8 = new ReplyType("DataSet", 4, 5);
        DataSet = r8;
        ReplyType r10 = new ReplyType("QueryKeyword", 5, 6);
        QueryKeyword = r10;
        ReplyType r12 = new ReplyType("IntermediateOutput", 6, 7);
        IntermediateOutput = r12;
        ReplyType r14 = new ReplyType("Verbose", 7, 100);
        Verbose = r14;
        ReplyType r11 = new ReplyType("PlaceHolder", 8, 101);
        PlaceHolder = r11;
        $VALUES = new ReplyType[]{r0, r1, r4, r6, r8, r10, r12, r14, r11};
    }

    private ReplyType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ReplyType findByValue(int r1) {
        if (r1 == 100) goto L26;
        if (r1 == 101) goto L24;
        switch(r1) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            default: goto L7;
        };
    L7:
        return null;
    L10:
        return IntermediateOutput;
    L12:
        return QueryKeyword;
    L14:
        return DataSet;
    L16:
        return ToolOutput;
    L18:
        return LLMOutput;
    L20:
        return Suggest;
    L22:
        return Answer;
    L24:
        return PlaceHolder;
    L26:
        return Verbose;
    }

    public static ReplyType valueOf(String r2) {
        return (ReplyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReplyType.class, r2), ReplyType.class, "com.obric.memorydata.plugin");
    }

    public static ReplyType[] values() {
        return (ReplyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReplyType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
