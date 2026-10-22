package com.bytedance.rpc.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum CopilotContentType extends Enum<CopilotContentType> {
    private static final /* synthetic */ CopilotContentType[] $VALUES = null;

    @SerializedName(BDLocationException.ERROR_BEACON_ADVERTISING)
    public static final CopilotContentType APP = null;

    @SerializedName("3")
    public static final CopilotContentType Audio = null;

    @SerializedName("51")
    public static final CopilotContentType BotCard = null;

    @SerializedName(BDLocationException.ERROR_BYTE_SCAN_RESULT_IS_EMPTY)
    public static final CopilotContentType Card = null;

    @SerializedName("9")
    public static final CopilotContentType File = null;

    @SerializedName("2")
    public static final CopilotContentType Image = null;

    @SerializedName("6")
    public static final CopilotContentType Link = null;

    @SerializedName("7")
    public static final CopilotContentType Music = null;

    @SerializedName("201")
    public static final CopilotContentType OutputMultiStream = null;

    @SerializedName(BDLocationException.SUCCESS)
    public static final CopilotContentType OutputSearchResult = null;

    @SerializedName("300")
    public static final CopilotContentType SearchIntentionResult = null;

    @SerializedName("8")
    public static final CopilotContentType Tako = null;

    @SerializedName("1")
    public static final CopilotContentType Txt = null;

    @SerializedName("4")
    public static final CopilotContentType Video = null;

    @SerializedName(BDLocationException.ERROR_NO_BYTE_IMPL)
    public static final CopilotContentType Widget = null;
    private final int value;

    static {
        CopilotContentType r0 = new CopilotContentType("Txt", 0, 1);
        Txt = r0;
        CopilotContentType r1 = new CopilotContentType("Image", 1, 2);
        Image = r1;
        CopilotContentType r4 = new CopilotContentType("Audio", 2, 3);
        Audio = r4;
        CopilotContentType r6 = new CopilotContentType("Video", 3, 4);
        Video = r6;
        CopilotContentType r8 = new CopilotContentType(i.L, 4, 6);
        Link = r8;
        CopilotContentType r10 = new CopilotContentType("Music", 5, 7);
        Music = r10;
        CopilotContentType r12 = new CopilotContentType("Tako", 6, 8);
        Tako = r12;
        CopilotContentType r15 = new CopilotContentType("File", 7, 9);
        File = r15;
        CopilotContentType r11 = new CopilotContentType("Card", 8, 50);
        Card = r11;
        CopilotContentType r7 = new CopilotContentType("BotCard", 9, 51);
        BotCard = r7;
        CopilotContentType r13 = new CopilotContentType("Widget", 10, 52);
        Widget = r13;
        CopilotContentType r5 = new CopilotContentType("APP", 11, 100);
        APP = r5;
        CopilotContentType r3 = new CopilotContentType("OutputSearchResult", 12, 200);
        OutputSearchResult = r3;
        CopilotContentType r2 = new CopilotContentType("OutputMultiStream", 13, 201);
        OutputMultiStream = r2;
        CopilotContentType r9 = new CopilotContentType("SearchIntentionResult", 14, 300);
        SearchIntentionResult = r9;
        $VALUES = new CopilotContentType[]{r0, r1, r4, r6, r8, r10, r12, r15, r11, r7, r13, r5, r3, r2, r9};
    }

    private CopilotContentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static CopilotContentType findByValue(int r1) {
        if (r1 == 1) goto L51;
        if (r1 == 2) goto L49;
        if (r1 == 3) goto L47;
        if (r1 == 4) goto L45;
        if (r1 == 100) goto L43;
        if (r1 == 300) goto L41;
        if (r1 == 200) goto L39;
        if (r1 == 201) goto L37;
        switch(r1) {
            case 6: goto L35;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L29;
            default: goto L19;
        };
    L19:
        switch(r1) {
            case 50: goto L27;
            case 51: goto L25;
            case 52: goto L23;
            default: goto L20;
        };
    L20:
        return null;
    L23:
        return Widget;
    L25:
        return BotCard;
    L27:
        return Card;
    L29:
        return File;
    L31:
        return Tako;
    L33:
        return Music;
    L35:
        return Link;
    L37:
        return OutputMultiStream;
    L39:
        return OutputSearchResult;
    L41:
        return SearchIntentionResult;
    L43:
        return APP;
    L45:
        return Video;
    L47:
        return Audio;
    L49:
        return Image;
    L51:
        return Txt;
    }

    public static CopilotContentType valueOf(String r2) {
        return (CopilotContentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CopilotContentType.class, r2), CopilotContentType.class, "com.obric.memorydata.plugin");
    }

    public static CopilotContentType[] values() {
        return (CopilotContentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CopilotContentType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
