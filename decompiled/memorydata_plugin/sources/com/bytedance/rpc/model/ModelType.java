package com.bytedance.rpc.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelType extends Enum<ModelType> {
    private static final /* synthetic */ ModelType[] $VALUES = null;

    @SerializedName("10")
    public static final ModelType Assistant = null;

    @SerializedName(BDLocationException.ERROR_UNKNOWN)
    public static final ModelType AutoPlugin = null;

    @SerializedName("9")
    public static final ModelType Bard = null;

    @SerializedName("8")
    public static final ModelType BingChat = null;

    @SerializedName("6")
    public static final ModelType ByteArtist = null;

    @SerializedName("31")
    public static final ModelType ByteArtistAnime = null;

    @SerializedName("43")
    public static final ModelType CiciSearchBing = null;

    @SerializedName("45")
    public static final ModelType CiciSearchBing_GPT35 = null;

    @SerializedName("42")
    public static final ModelType CiciSearchLess = null;

    @SerializedName("41")
    public static final ModelType CiciSearchMore = null;

    @SerializedName("7")
    public static final ModelType Claude = null;

    @SerializedName("11")
    public static final ModelType DallE = null;

    @SerializedName("123")
    public static final ModelType Echo = null;

    @SerializedName(BDLocationException.ERROR_NO_DATA)
    public static final ModelType Edu = null;

    @SerializedName("1")
    public static final ModelType GPT3dot5Turbo = null;

    @SerializedName("23")
    public static final ModelType GPT3dot5WithFunction = null;

    @SerializedName("17")
    public static final ModelType GPT3dot5WithPlugins = null;

    @SerializedName(BDLocationException.ERROR_LOCATION_IS_NULL)
    public static final ModelType GPT3dot5WithTako = null;

    @SerializedName("2")
    public static final ModelType GPT4 = null;

    @SerializedName(BDLocationException.ERROR_BYTE_NO_FINE_LOCATION_PERMISSION)
    public static final ModelType GPT40613 = null;

    @SerializedName("33")
    public static final ModelType GPT48k = null;

    @SerializedName("15")
    public static final ModelType GPT4Browsing = null;

    @SerializedName("21")
    public static final ModelType GPT4Plugin = null;

    @SerializedName("16")
    public static final ModelType GPT4WithPlugins = null;

    @SerializedName("27")
    public static final ModelType GPT4WithTako = null;

    @SerializedName("29")
    public static final ModelType GPT4WithTakoGoogle = null;

    @SerializedName(BDLocationException.ERROR_SDK_START_FAIL)
    public static final ModelType GPT4WithTakoTikTok = null;

    @SerializedName(BDLocationException.ERROR_BEACON_START_ADVERTISING)
    public static final ModelType GPT4_32k0613 = null;

    @SerializedName("14")
    public static final ModelType GPTTask = null;

    @SerializedName(BDLocationException.ERROR_BEACON_ADVERTISING)
    public static final ModelType GPT_35Turbo = null;

    @SerializedName("101")
    public static final ModelType GPT_35Turbo0301 = null;

    @SerializedName(BDLocationException.ERROR_TMAP_BAD_JSON)
    public static final ModelType GPT_35Turbo0613 = null;

    @SerializedName("113")
    public static final ModelType GPT_35Turbo16K = null;

    @SerializedName(BDLocationException.ERROR_UID_IS_EMPTY)
    public static final ModelType GPT_4 = null;

    @SerializedName("103")
    public static final ModelType GPT_40314 = null;

    @SerializedName(BDLocationException.ERROR_BELOW_MIN_UPDATE_INTERVAL)
    public static final ModelType GPT_40613 = null;

    @SerializedName(BDLocationException.ERROR_ANDROID_VERSION_TOO_LOW)
    public static final ModelType GPT_432k = null;

    @SerializedName("105")
    public static final ModelType GPT_432k0314 = null;

    @SerializedName("133")
    public static final ModelType GPT_4Preview_128k1106 = null;

    @SerializedName(BDLocationException.ERROR_CONNECT_GOOGLE_FAIL)
    public static final ModelType GenMusic = null;

    @SerializedName("12")
    public static final ModelType Midjourney = null;

    @SerializedName("25")
    public static final ModelType MiniMax = null;

    @SerializedName("20")
    public static final ModelType Plugin = null;

    @SerializedName("3")
    public static final ModelType Seed = null;

    @SerializedName(BDLocationException.ERROR_SDK_NO_PERMISSION)
    public static final ModelType SeedBeta = null;

    @SerializedName("1705216686")
    public static final ModelType SeedBotTag = null;

    @SerializedName("121")
    public static final ModelType SeedBrowsingExperiment = null;

    @SerializedName(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_EXCEPTION)
    public static final ModelType SeedBrowsingOnly = null;

    @SerializedName(BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED)
    public static final ModelType SeedForDouyin = null;

    @SerializedName("47")
    public static final ModelType SeedForMap = null;

    @SerializedName(BDLocationException.ERROR_BYTE_NO_CHANGE_WIFI_STATE_PERMISSION)
    public static final ModelType SeedForMusic = null;

    @SerializedName("35")
    public static final ModelType SeedForTest = null;

    @SerializedName("119")
    public static final ModelType SeedFunctionCall = null;

    @SerializedName("135")
    public static final ModelType SeedFunctionCallSp = null;

    @SerializedName("4")
    public static final ModelType SeedMultiturn = null;

    @SerializedName("37")
    public static final ModelType SeedOmniBrowse = null;

    @SerializedName(BDLocationException.ERROR_MULTI_THREAD_LOCATE)
    public static final ModelType SeedOmniBrowseWithCard = null;

    @SerializedName(BDLocationException.ERROR_BACKGROUND_LOCATE)
    public static final ModelType SeedOmniFake = null;

    @SerializedName(BDLocationException.ERROR_BYTE_DISABLE_USE_WIFI)
    public static final ModelType SeedOmniPlugin = null;

    @SerializedName(BDLocationException.ERROR_DISPUTED_AREA)
    public static final ModelType SeedOmniSota = null;

    @SerializedName("39")
    public static final ModelType SeedOmniSotaBrowse = null;

    @SerializedName("1705220979")
    public static final ModelType SeedStrongCharacterAudio = null;

    @SerializedName(BDLocationException.ERROR_ABNORMAL_NETWORK)
    public static final ModelType SeedStrongCharacterForTest = null;

    @SerializedName(BDLocationException.ERROR_DOWNGRADE_LOCATION)
    public static final ModelType SeedStrongCharacterNearlinePortrait = null;

    @SerializedName("127")
    public static final ModelType SeedSuggest = null;

    @SerializedName(BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED)
    public static final ModelType SeedSuggestOffline = null;

    @SerializedName("18")
    public static final ModelType SeedSystem = null;

    @SerializedName(BDLocationException.ERROR_BLUETOOTh_NOT_AVAILABLE)
    public static final ModelType Seed_Beta = null;

    @SerializedName("129")
    public static final ModelType Seed_ComplexInstruction = null;

    @SerializedName(BDLocationException.ERROR_LIGHT_LOCATION_WIFI_LIST_ALREADY_UPLOAD)
    public static final ModelType Seed_ComplexInstructionTest = null;

    @SerializedName("109")
    public static final ModelType Seed_Img2Text = null;

    @SerializedName(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO)
    public static final ModelType Seed_Main = null;

    @SerializedName(BDLocationException.ERROR_CONTEXT_NULL)
    public static final ModelType Seed_Map = null;

    @SerializedName("107")
    public static final ModelType Seed_Music = null;

    @SerializedName(BDLocationException.ERROR_LIGHT_LOCATION_GET_CURRENT_STATION)
    public static final ModelType Seed_Omni = null;

    @SerializedName(BDLocationException.ERROR_TMAP_WGS84)
    public static final ModelType Seed_Sota = null;

    @SerializedName("115")
    public static final ModelType Seed_Sota_Browsing = null;

    @SerializedName(BDLocationException.ERROR_CODE_EXCEPTION)
    public static final ModelType Seed_Text2Img = null;

    @SerializedName(BDLocationException.ERROR_TMAP_CLIENT)
    public static final ModelType Seed_WebGPT = null;

    @SerializedName("111")
    public static final ModelType Seed_WithPlugins = null;

    @SerializedName(BDLocationException.ERROR_TMAP_FAIL)
    public static final ModelType Seed_WithSystem = null;

    @SerializedName("125")
    public static final ModelType Seed_WithSystemForTest = null;

    @SerializedName("137")
    public static final ModelType SkylarkChat = null;

    @SerializedName("1704353638")
    public static final ModelType SkylarkPro_v1_1_TT = null;

    @SerializedName("1704696164")
    public static final ModelType SkylarkPro_v1_1_TT_BROWSING = null;

    @SerializedName("5")
    public static final ModelType StableDiffusion = null;

    @SerializedName("13")
    public static final ModelType TTSearch = null;

    @SerializedName("131")
    public static final ModelType Tako_Intent = null;

    @SerializedName(BDLocationException.ERROR_AMAP_FAIL)
    public static final ModelType WebGPT = null;

    @SerializedName("49")
    public static final ModelType XiaoningWithMem = null;
    private final int value;

    static {
        GPT3dot5Turbo = new ModelType("GPT3dot5Turbo", 0, 1);
        GPT4 = new ModelType("GPT4", 1, 2);
        Seed = new ModelType("Seed", 2, 3);
        SeedMultiturn = new ModelType("SeedMultiturn", 3, 4);
        StableDiffusion = new ModelType("StableDiffusion", 4, 5);
        ByteArtist = new ModelType("ByteArtist", 5, 6);
        Claude = new ModelType("Claude", 6, 7);
        BingChat = new ModelType("BingChat", 7, 8);
        Bard = new ModelType("Bard", 8, 9);
        Assistant = new ModelType("Assistant", 9, 10);
        DallE = new ModelType("DallE", 10, 11);
        Midjourney = new ModelType("Midjourney", 11, 12);
        TTSearch = new ModelType("TTSearch", 12, 13);
        GPTTask = new ModelType("GPTTask", 13, 14);
        GPT4Browsing = new ModelType("GPT4Browsing", 14, 15);
        GPT4WithPlugins = new ModelType("GPT4WithPlugins", 15, 16);
        GPT3dot5WithPlugins = new ModelType("GPT3dot5WithPlugins", 16, 17);
        SeedSystem = new ModelType("SeedSystem", 17, 18);
        Plugin = new ModelType("Plugin", 18, 20);
        GPT4Plugin = new ModelType("GPT4Plugin", 19, 21);
        WebGPT = new ModelType("WebGPT", 20, 22);
        GPT3dot5WithFunction = new ModelType("GPT3dot5WithFunction", 21, 23);
        AutoPlugin = new ModelType("AutoPlugin", 22, 24);
        MiniMax = new ModelType("MiniMax", 23, 25);
        GPT3dot5WithTako = new ModelType("GPT3dot5WithTako", 24, 26);
        GPT4WithTako = new ModelType("GPT4WithTako", 25, 27);
        GPT4WithTakoTikTok = new ModelType("GPT4WithTakoTikTok", 26, 28);
        GPT4WithTakoGoogle = new ModelType("GPT4WithTakoGoogle", 27, 29);
        SeedBeta = new ModelType("SeedBeta", 28, 30);
        ByteArtistAnime = new ModelType("ByteArtistAnime", 29, 31);
        GenMusic = new ModelType("GenMusic", 30, 32);
        GPT48k = new ModelType("GPT48k", 31, 33);
        SeedStrongCharacterForTest = new ModelType("SeedStrongCharacterForTest", 32, 34);
        SeedForTest = new ModelType("SeedForTest", 33, 35);
        SeedOmniFake = new ModelType("SeedOmniFake", 34, 36);
        SeedOmniBrowse = new ModelType("SeedOmniBrowse", 35, 37);
        SeedOmniSota = new ModelType("SeedOmniSota", 36, 38);
        SeedOmniSotaBrowse = new ModelType("SeedOmniSotaBrowse", 37, 39);
        SeedOmniBrowseWithCard = new ModelType("SeedOmniBrowseWithCard", 38, 40);
        CiciSearchMore = new ModelType("CiciSearchMore", 39, 41);
        CiciSearchLess = new ModelType("CiciSearchLess", 40, 42);
        CiciSearchBing = new ModelType("CiciSearchBing", 41, 43);
        SeedOmniPlugin = new ModelType("SeedOmniPlugin", 42, 44);
        CiciSearchBing_GPT35 = new ModelType("CiciSearchBing_GPT35", 43, 45);
        GPT40613 = new ModelType("GPT40613", 44, 46);
        SeedForMap = new ModelType("SeedForMap", 45, 47);
        SeedForMusic = new ModelType("SeedForMusic", 46, 48);
        XiaoningWithMem = new ModelType("XiaoningWithMem", 47, 49);
        GPT_35Turbo = new ModelType("GPT_35Turbo", 48, 100);
        GPT_35Turbo0301 = new ModelType("GPT_35Turbo0301", 49, 101);
        GPT_4 = new ModelType("GPT_4", 50, 102);
        GPT_40314 = new ModelType("GPT_40314", 51, 103);
        GPT_432k = new ModelType("GPT_432k", 52, 104);
        GPT_432k0314 = new ModelType("GPT_432k0314", 53, 105);
        Seed_Beta = new ModelType("Seed_Beta", 54, 106);
        Seed_Music = new ModelType("Seed_Music", 55, 107);
        GPT4_32k0613 = new ModelType("GPT4_32k0613", 56, 108);
        Seed_Img2Text = new ModelType("Seed_Img2Text", 57, 109);
        Seed_WebGPT = new ModelType("Seed_WebGPT", 58, 110);
        Seed_WithPlugins = new ModelType("Seed_WithPlugins", 59, 111);
        GPT_35Turbo0613 = new ModelType("GPT_35Turbo0613", 60, 112);
        GPT_35Turbo16K = new ModelType("GPT_35Turbo16K", 61, 113);
        Seed_Sota = new ModelType("Seed_Sota", 62, 114);
        Seed_Sota_Browsing = new ModelType("Seed_Sota_Browsing", 63, 115);
        Seed_WithSystem = new ModelType("Seed_WithSystem", 64, 116);
        Seed_Omni = new ModelType("Seed_Omni", 65, 118);
        SeedFunctionCall = new ModelType("SeedFunctionCall", 66, IdlErrors.E_RejectInferDeviceOverheat);
        Seed_Main = new ModelType("Seed_Main", 67, 120);
        SeedBrowsingExperiment = new ModelType("SeedBrowsingExperiment", 68, 121);
        SeedBrowsingOnly = new ModelType("SeedBrowsingOnly", 69, 122);
        Echo = new ModelType("Echo", 70, 123);
        GPT_40613 = new ModelType("GPT_40613", 71, 124);
        Seed_WithSystemForTest = new ModelType("Seed_WithSystemForTest", 72, 125);
        Seed_Map = new ModelType("Seed_Map", 73, WebSocketProtocol.PAYLOAD_SHORT);
        SeedSuggest = new ModelType("SeedSuggest", 74, 127);
        Seed_ComplexInstructionTest = new ModelType("Seed_ComplexInstructionTest", 75, 128);
        Seed_ComplexInstruction = new ModelType("Seed_ComplexInstruction", 76, 129);
        Edu = new ModelType("Edu", 77, 130);
        Tako_Intent = new ModelType("Tako_Intent", 78, 131);
        Seed_Text2Img = new ModelType("Seed_Text2Img", 79, 132);
        GPT_4Preview_128k1106 = new ModelType("GPT_4Preview_128k1106", 80, 133);
        SeedForDouyin = new ModelType("SeedForDouyin", 81, 134);
        SeedFunctionCallSp = new ModelType("SeedFunctionCallSp", 82, 135);
        SeedSuggestOffline = new ModelType("SeedSuggestOffline", 83, 136);
        SkylarkChat = new ModelType("SkylarkChat", 84, 137);
        SeedStrongCharacterNearlinePortrait = new ModelType("SeedStrongCharacterNearlinePortrait", 85, 138);
        SkylarkPro_v1_1_TT = new ModelType("SkylarkPro_v1_1_TT", 86, 1704353638);
        SkylarkPro_v1_1_TT_BROWSING = new ModelType("SkylarkPro_v1_1_TT_BROWSING", 87, 1704696164);
        SeedBotTag = new ModelType("SeedBotTag", 88, 1705216686);
        SeedStrongCharacterAudio = new ModelType("SeedStrongCharacterAudio", 89, 1705220979);
        $VALUES = new ModelType[]{GPT3dot5Turbo, GPT4, Seed, SeedMultiturn, StableDiffusion, ByteArtist, Claude, BingChat, Bard, Assistant, DallE, Midjourney, TTSearch, GPTTask, GPT4Browsing, GPT4WithPlugins, GPT3dot5WithPlugins, SeedSystem, Plugin, GPT4Plugin, WebGPT, GPT3dot5WithFunction, AutoPlugin, MiniMax, GPT3dot5WithTako, GPT4WithTako, GPT4WithTakoTikTok, GPT4WithTakoGoogle, SeedBeta, ByteArtistAnime, GenMusic, GPT48k, SeedStrongCharacterForTest, SeedForTest, SeedOmniFake, SeedOmniBrowse, SeedOmniSota, SeedOmniSotaBrowse, SeedOmniBrowseWithCard, CiciSearchMore, CiciSearchLess, CiciSearchBing, SeedOmniPlugin, CiciSearchBing_GPT35, GPT40613, SeedForMap, SeedForMusic, XiaoningWithMem, GPT_35Turbo, GPT_35Turbo0301, GPT_4, GPT_40314, GPT_432k, GPT_432k0314, Seed_Beta, Seed_Music, GPT4_32k0613, Seed_Img2Text, Seed_WebGPT, Seed_WithPlugins, GPT_35Turbo0613, GPT_35Turbo16K, Seed_Sota, Seed_Sota_Browsing, Seed_WithSystem, Seed_Omni, SeedFunctionCall, Seed_Main, SeedBrowsingExperiment, SeedBrowsingOnly, Echo, GPT_40613, Seed_WithSystemForTest, Seed_Map, SeedSuggest, Seed_ComplexInstructionTest, Seed_ComplexInstruction, Edu, Tako_Intent, Seed_Text2Img, GPT_4Preview_128k1106, SeedForDouyin, SeedFunctionCallSp, SeedSuggestOffline, SkylarkChat, SeedStrongCharacterNearlinePortrait, SkylarkPro_v1_1_TT, SkylarkPro_v1_1_TT_BROWSING, SeedBotTag, SeedStrongCharacterAudio};
    }

    private ModelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelType findByValue(int r0) {
        switch(r0) {
            case 1: goto L188;
            case 2: goto L186;
            case 3: goto L184;
            case 4: goto L182;
            case 5: goto L180;
            case 6: goto L178;
            case 7: goto L176;
            case 8: goto L174;
            case 9: goto L172;
            case 10: goto L170;
            case 11: goto L168;
            case 12: goto L166;
            case 13: goto L164;
            case 14: goto L162;
            case 15: goto L160;
            case 16: goto L158;
            case 17: goto L156;
            case 18: goto L154;
            default: goto L3;
        };
    L3:
        switch(r0) {
            case 20: goto L152;
            case 21: goto L150;
            case 22: goto L148;
            case 23: goto L146;
            case 24: goto L144;
            case 25: goto L142;
            case 26: goto L140;
            case 27: goto L138;
            case 28: goto L136;
            case 29: goto L134;
            case 30: goto L132;
            case 31: goto L130;
            case 32: goto L128;
            case 33: goto L126;
            case 34: goto L124;
            case 35: goto L122;
            case 36: goto L120;
            case 37: goto L118;
            case 38: goto L116;
            case 39: goto L114;
            case 40: goto L112;
            case 41: goto L110;
            case 42: goto L108;
            case 43: goto L106;
            case 44: goto L104;
            case 45: goto L102;
            case 46: goto L100;
            case 47: goto L98;
            case 48: goto L96;
            case 49: goto L94;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 100: goto L92;
            case 101: goto L90;
            case 102: goto L88;
            case 103: goto L86;
            case 104: goto L84;
            case 105: goto L82;
            case 106: goto L80;
            case 107: goto L78;
            case 108: goto L76;
            case 109: goto L74;
            case 110: goto L72;
            case 111: goto L70;
            case 112: goto L68;
            case 113: goto L66;
            case 114: goto L64;
            case 115: goto L62;
            case 116: goto L60;
            default: goto L5;
        };
    L5:
        switch(r0) {
            case 118: goto L58;
            case 119: goto L56;
            case 120: goto L54;
            case 121: goto L52;
            case 122: goto L50;
            case 123: goto L48;
            case 124: goto L46;
            case 125: goto L44;
            case 126: goto L42;
            case 127: goto L40;
            case 128: goto L38;
            case 129: goto L36;
            case 130: goto L34;
            case 131: goto L32;
            case 132: goto L30;
            case 133: goto L28;
            case 134: goto L26;
            case 135: goto L24;
            case 136: goto L22;
            case 137: goto L20;
            case 138: goto L18;
            default: goto L6;
        };
    L6:
        switch(r0) {
            case 1704353638: goto L16;
            case 1704696164: goto L14;
            case 1705216686: goto L12;
            case 1705220979: goto L10;
            default: goto L7;
        };
    L7:
        return null;
    L10:
        return SeedStrongCharacterAudio;
    L12:
        return SeedBotTag;
    L14:
        return SkylarkPro_v1_1_TT_BROWSING;
    L16:
        return SkylarkPro_v1_1_TT;
    L18:
        return SeedStrongCharacterNearlinePortrait;
    L20:
        return SkylarkChat;
    L22:
        return SeedSuggestOffline;
    L24:
        return SeedFunctionCallSp;
    L26:
        return SeedForDouyin;
    L28:
        return GPT_4Preview_128k1106;
    L30:
        return Seed_Text2Img;
    L32:
        return Tako_Intent;
    L34:
        return Edu;
    L36:
        return Seed_ComplexInstruction;
    L38:
        return Seed_ComplexInstructionTest;
    L40:
        return SeedSuggest;
    L42:
        return Seed_Map;
    L44:
        return Seed_WithSystemForTest;
    L46:
        return GPT_40613;
    L48:
        return Echo;
    L50:
        return SeedBrowsingOnly;
    L52:
        return SeedBrowsingExperiment;
    L54:
        return Seed_Main;
    L56:
        return SeedFunctionCall;
    L58:
        return Seed_Omni;
    L60:
        return Seed_WithSystem;
    L62:
        return Seed_Sota_Browsing;
    L64:
        return Seed_Sota;
    L66:
        return GPT_35Turbo16K;
    L68:
        return GPT_35Turbo0613;
    L70:
        return Seed_WithPlugins;
    L72:
        return Seed_WebGPT;
    L74:
        return Seed_Img2Text;
    L76:
        return GPT4_32k0613;
    L78:
        return Seed_Music;
    L80:
        return Seed_Beta;
    L82:
        return GPT_432k0314;
    L84:
        return GPT_432k;
    L86:
        return GPT_40314;
    L88:
        return GPT_4;
    L90:
        return GPT_35Turbo0301;
    L92:
        return GPT_35Turbo;
    L94:
        return XiaoningWithMem;
    L96:
        return SeedForMusic;
    L98:
        return SeedForMap;
    L100:
        return GPT40613;
    L102:
        return CiciSearchBing_GPT35;
    L104:
        return SeedOmniPlugin;
    L106:
        return CiciSearchBing;
    L108:
        return CiciSearchLess;
    L110:
        return CiciSearchMore;
    L112:
        return SeedOmniBrowseWithCard;
    L114:
        return SeedOmniSotaBrowse;
    L116:
        return SeedOmniSota;
    L118:
        return SeedOmniBrowse;
    L120:
        return SeedOmniFake;
    L122:
        return SeedForTest;
    L124:
        return SeedStrongCharacterForTest;
    L126:
        return GPT48k;
    L128:
        return GenMusic;
    L130:
        return ByteArtistAnime;
    L132:
        return SeedBeta;
    L134:
        return GPT4WithTakoGoogle;
    L136:
        return GPT4WithTakoTikTok;
    L138:
        return GPT4WithTako;
    L140:
        return GPT3dot5WithTako;
    L142:
        return MiniMax;
    L144:
        return AutoPlugin;
    L146:
        return GPT3dot5WithFunction;
    L148:
        return WebGPT;
    L150:
        return GPT4Plugin;
    L152:
        return Plugin;
    L154:
        return SeedSystem;
    L156:
        return GPT3dot5WithPlugins;
    L158:
        return GPT4WithPlugins;
    L160:
        return GPT4Browsing;
    L162:
        return GPTTask;
    L164:
        return TTSearch;
    L166:
        return Midjourney;
    L168:
        return DallE;
    L170:
        return Assistant;
    L172:
        return Bard;
    L174:
        return BingChat;
    L176:
        return Claude;
    L178:
        return ByteArtist;
    L180:
        return StableDiffusion;
    L182:
        return SeedMultiturn;
    L184:
        return Seed;
    L186:
        return GPT4;
    L188:
        return GPT3dot5Turbo;
    }

    public static ModelType valueOf(String r2) {
        return (ModelType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelType.class, r2), ModelType.class, "com.obric.memorydata.plugin");
    }

    public static ModelType[] values() {
        return (ModelType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
