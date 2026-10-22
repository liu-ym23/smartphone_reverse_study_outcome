package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum AssistParameterType extends Enum<AssistParameterType> {
    private static final /* synthetic */ AssistParameterType[] $VALUES = null;

    @SerializedName("8")
    public static final AssistParameterType AUDIO = null;

    @SerializedName("4")
    public static final AssistParameterType CODE = null;

    @SerializedName("1")
    public static final AssistParameterType DEFAULT = null;

    @SerializedName("3")
    public static final AssistParameterType DOC = null;

    @SerializedName("7")
    public static final AssistParameterType EXCEL = null;

    @SerializedName("2")
    public static final AssistParameterType IMAGE = null;

    @SerializedName("5")
    public static final AssistParameterType PPT = null;

    @SerializedName("11")
    public static final AssistParameterType SVG = null;

    @SerializedName("6")
    public static final AssistParameterType TXT = null;

    @SerializedName("10")
    public static final AssistParameterType VIDEO = null;

    @SerializedName("12")
    public static final AssistParameterType VOICE = null;

    @SerializedName("9")
    public static final AssistParameterType ZIP = null;
    private final int value;

    static {
        AssistParameterType r0 = new AssistParameterType("DEFAULT", 0, 1);
        DEFAULT = r0;
        AssistParameterType r1 = new AssistParameterType("IMAGE", 1, 2);
        IMAGE = r1;
        AssistParameterType r4 = new AssistParameterType("DOC", 2, 3);
        DOC = r4;
        AssistParameterType r6 = new AssistParameterType("CODE", 3, 4);
        CODE = r6;
        AssistParameterType r8 = new AssistParameterType("PPT", 4, 5);
        PPT = r8;
        AssistParameterType r10 = new AssistParameterType("TXT", 5, 6);
        TXT = r10;
        AssistParameterType r12 = new AssistParameterType("EXCEL", 6, 7);
        EXCEL = r12;
        AssistParameterType r14 = new AssistParameterType("AUDIO", 7, 8);
        AUDIO = r14;
        AssistParameterType r13 = new AssistParameterType("ZIP", 8, 9);
        ZIP = r13;
        AssistParameterType r15 = new AssistParameterType("VIDEO", 9, 10);
        VIDEO = r15;
        AssistParameterType r11 = new AssistParameterType("SVG", 10, 11);
        SVG = r11;
        AssistParameterType r9 = new AssistParameterType("VOICE", 11, 12);
        VOICE = r9;
        $VALUES = new AssistParameterType[]{r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r11, r9};
    }

    private AssistParameterType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static AssistParameterType findByValue(int r0) {
        switch(r0) {
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return VOICE;
    L8:
        return SVG;
    L10:
        return VIDEO;
    L12:
        return ZIP;
    L14:
        return AUDIO;
    L16:
        return EXCEL;
    L18:
        return TXT;
    L20:
        return PPT;
    L22:
        return CODE;
    L24:
        return DOC;
    L26:
        return IMAGE;
    L28:
        return DEFAULT;
    }

    public static AssistParameterType valueOf(String r2) {
        return (AssistParameterType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AssistParameterType.class, r2), AssistParameterType.class, "com.obric.memorydata.plugin");
    }

    public static AssistParameterType[] values() {
        return (AssistParameterType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AssistParameterType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
