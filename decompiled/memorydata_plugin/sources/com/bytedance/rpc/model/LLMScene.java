package com.bytedance.rpc.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum LLMScene extends Enum<LLMScene> {
    private static final /* synthetic */ LLMScene[] $VALUES = null;

    @SerializedName("25")
    public static final LLMScene BackOnboardingSug = null;

    @SerializedName("9")
    public static final LLMScene BrowserPlugin = null;

    @SerializedName("11")
    public static final LLMScene BrowserPluginExplain = null;

    @SerializedName("14")
    public static final LLMScene BrowserPluginGrammar = null;

    @SerializedName("33")
    public static final LLMScene BrowserPluginImgReader = null;

    @SerializedName(BDLocationException.ERROR_CONNECT_GOOGLE_FAIL)
    public static final LLMScene BrowserPluginPDFReader = null;

    @SerializedName("31")
    public static final LLMScene BrowserPluginRawChain = null;

    @SerializedName("15")
    public static final LLMScene BrowserPluginRewrite = null;

    @SerializedName("10")
    public static final LLMScene BrowserPluginSearch = null;

    @SerializedName("29")
    public static final LLMScene BrowserPluginSelectionQuestion = null;

    @SerializedName("13")
    public static final LLMScene BrowserPluginSummary = null;

    @SerializedName("12")
    public static final LLMScene BrowserPluginTranslate = null;

    @SerializedName("16")
    public static final LLMScene BrowserPluginWebSummary = null;

    @SerializedName(BDLocationException.ERROR_SDK_NO_PERMISSION)
    public static final LLMScene BrowserPluginYoutubeSummary = null;

    @SerializedName("1")
    public static final LLMScene Chat = null;

    @SerializedName(BDLocationException.ERROR_LOCATION_IS_NULL)
    public static final LLMScene GenCard = null;

    @SerializedName("8")
    public static final LLMScene GenProfile = null;

    @SerializedName("27")
    public static final LLMScene HighLightMsg = null;

    @SerializedName(BDLocationException.ERROR_SDK_START_FAIL)
    public static final LLMScene HighLightMsgSearch = null;

    @SerializedName("17")
    public static final LLMScene HotSearch = null;

    @SerializedName("18")
    public static final LLMScene HotSearchPreload = null;

    @SerializedName("19")
    public static final LLMScene InputSug = null;

    @SerializedName("7")
    public static final LLMScene Naming = null;

    @SerializedName("20")
    public static final LLMScene NewsPush = null;

    @SerializedName("21")
    public static final LLMScene NewsPushPreload = null;

    @SerializedName("6")
    public static final LLMScene OnboardingOffline = null;

    @SerializedName("5")
    public static final LLMScene OnboardingOnline = null;

    @SerializedName(BDLocationException.ERROR_AMAP_FAIL)
    public static final LLMScene OnboardingSug = null;

    @SerializedName("23")
    public static final LLMScene OnboardingSugPreload = null;

    @SerializedName("3")
    public static final LLMScene QueryKeyword = null;

    @SerializedName(BDLocationException.ERROR_ABNORMAL_NETWORK)
    public static final LLMScene SearchSummary = null;

    @SerializedName("2")
    public static final LLMScene Suggest = null;

    @SerializedName(BDLocationException.ERROR_UNKNOWN)
    public static final LLMScene WebNotLogin = null;

    @SerializedName("4")
    public static final LLMScene Workflow = null;
    private final int value;

    static {
        LLMScene r0 = new LLMScene("Chat", 0, 1);
        Chat = r0;
        LLMScene r1 = new LLMScene("Suggest", 1, 2);
        Suggest = r1;
        LLMScene r2 = new LLMScene("QueryKeyword", 2, 3);
        QueryKeyword = r2;
        LLMScene r5 = new LLMScene("Workflow", 3, 4);
        Workflow = r5;
        LLMScene r7 = new LLMScene("OnboardingOnline", 4, 5);
        OnboardingOnline = r7;
        LLMScene r9 = new LLMScene("OnboardingOffline", 5, 6);
        OnboardingOffline = r9;
        LLMScene r11 = new LLMScene("Naming", 6, 7);
        Naming = r11;
        LLMScene r13 = new LLMScene("GenProfile", 7, 8);
        GenProfile = r13;
        LLMScene r15 = new LLMScene("BrowserPlugin", 8, 9);
        BrowserPlugin = r15;
        LLMScene r14 = new LLMScene("BrowserPluginSearch", 9, 10);
        BrowserPluginSearch = r14;
        LLMScene r12 = new LLMScene("BrowserPluginExplain", 10, 11);
        BrowserPluginExplain = r12;
        LLMScene r10 = new LLMScene("BrowserPluginTranslate", 11, 12);
        BrowserPluginTranslate = r10;
        LLMScene r8 = new LLMScene("BrowserPluginSummary", 12, 13);
        BrowserPluginSummary = r8;
        LLMScene r6 = new LLMScene("BrowserPluginGrammar", 13, 14);
        BrowserPluginGrammar = r6;
        LLMScene r4 = new LLMScene("BrowserPluginRewrite", 14, 15);
        BrowserPluginRewrite = r4;
        LLMScene r3 = new LLMScene("BrowserPluginWebSummary", 15, 16);
        BrowserPluginWebSummary = r3;
        LLMScene r16 = new LLMScene("HotSearch", 16, 17);
        HotSearch = r16;
        LLMScene r17 = new LLMScene("HotSearchPreload", 17, 18);
        HotSearchPreload = r17;
        LLMScene r18 = new LLMScene("InputSug", 18, 19);
        InputSug = r18;
        LLMScene r19 = new LLMScene("NewsPush", 19, 20);
        NewsPush = r19;
        LLMScene r20 = new LLMScene("NewsPushPreload", 20, 21);
        NewsPushPreload = r20;
        LLMScene r21 = new LLMScene("OnboardingSug", 21, 22);
        OnboardingSug = r21;
        LLMScene r22 = new LLMScene("OnboardingSugPreload", 22, 23);
        OnboardingSugPreload = r22;
        LLMScene r23 = new LLMScene("WebNotLogin", 23, 24);
        WebNotLogin = r23;
        LLMScene r24 = new LLMScene("BackOnboardingSug", 24, 25);
        BackOnboardingSug = r24;
        LLMScene r25 = new LLMScene("GenCard", 25, 26);
        GenCard = r25;
        LLMScene r26 = new LLMScene("HighLightMsg", 26, 27);
        HighLightMsg = r26;
        LLMScene r27 = new LLMScene("HighLightMsgSearch", 27, 28);
        HighLightMsgSearch = r27;
        LLMScene r28 = new LLMScene("BrowserPluginSelectionQuestion", 28, 29);
        BrowserPluginSelectionQuestion = r28;
        LLMScene r29 = new LLMScene("BrowserPluginYoutubeSummary", 29, 30);
        BrowserPluginYoutubeSummary = r29;
        LLMScene r30 = new LLMScene("BrowserPluginRawChain", 30, 31);
        BrowserPluginRawChain = r30;
        LLMScene r31 = new LLMScene("BrowserPluginPDFReader", 31, 32);
        BrowserPluginPDFReader = r31;
        LLMScene r32 = new LLMScene("BrowserPluginImgReader", 32, 33);
        BrowserPluginImgReader = r32;
        LLMScene r33 = new LLMScene("SearchSummary", 33, 34);
        SearchSummary = r33;
        $VALUES = new LLMScene[]{r0, r1, r2, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r3, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33};
    }

    private LLMScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static LLMScene findByValue(int r0) {
        switch(r0) {
            case 1: goto L72;
            case 2: goto L70;
            case 3: goto L68;
            case 4: goto L66;
            case 5: goto L64;
            case 6: goto L62;
            case 7: goto L60;
            case 8: goto L58;
            case 9: goto L56;
            case 10: goto L54;
            case 11: goto L52;
            case 12: goto L50;
            case 13: goto L48;
            case 14: goto L46;
            case 15: goto L44;
            case 16: goto L42;
            case 17: goto L40;
            case 18: goto L38;
            case 19: goto L36;
            case 20: goto L34;
            case 21: goto L32;
            case 22: goto L30;
            case 23: goto L28;
            case 24: goto L26;
            case 25: goto L24;
            case 26: goto L22;
            case 27: goto L20;
            case 28: goto L18;
            case 29: goto L16;
            case 30: goto L14;
            case 31: goto L12;
            case 32: goto L10;
            case 33: goto L8;
            case 34: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return SearchSummary;
    L8:
        return BrowserPluginImgReader;
    L10:
        return BrowserPluginPDFReader;
    L12:
        return BrowserPluginRawChain;
    L14:
        return BrowserPluginYoutubeSummary;
    L16:
        return BrowserPluginSelectionQuestion;
    L18:
        return HighLightMsgSearch;
    L20:
        return HighLightMsg;
    L22:
        return GenCard;
    L24:
        return BackOnboardingSug;
    L26:
        return WebNotLogin;
    L28:
        return OnboardingSugPreload;
    L30:
        return OnboardingSug;
    L32:
        return NewsPushPreload;
    L34:
        return NewsPush;
    L36:
        return InputSug;
    L38:
        return HotSearchPreload;
    L40:
        return HotSearch;
    L42:
        return BrowserPluginWebSummary;
    L44:
        return BrowserPluginRewrite;
    L46:
        return BrowserPluginGrammar;
    L48:
        return BrowserPluginSummary;
    L50:
        return BrowserPluginTranslate;
    L52:
        return BrowserPluginExplain;
    L54:
        return BrowserPluginSearch;
    L56:
        return BrowserPlugin;
    L58:
        return GenProfile;
    L60:
        return Naming;
    L62:
        return OnboardingOffline;
    L64:
        return OnboardingOnline;
    L66:
        return Workflow;
    L68:
        return QueryKeyword;
    L70:
        return Suggest;
    L72:
        return Chat;
    }

    public static LLMScene valueOf(String r2) {
        return (LLMScene) ZeusTransformUtils.preCheckCast(Enum.valueOf(LLMScene.class, r2), LLMScene.class, "com.obric.memorydata.plugin");
    }

    public static LLMScene[] values() {
        return (LLMScene[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LLMScene[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
