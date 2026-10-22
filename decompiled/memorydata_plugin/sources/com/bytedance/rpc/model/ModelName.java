package com.bytedance.rpc.model;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ModelName extends Enum<ModelName> {
    private static final /* synthetic */ ModelName[] $VALUES = null;

    @SerializedName("23")
    public static final ModelName Echo = null;

    @SerializedName("31")
    public static final ModelName Edu = null;

    @SerializedName("14")
    public static final ModelName GPT35_Turbo16k = null;

    @SerializedName("1")
    public static final ModelName GPT3dot5Turbo = null;

    @SerializedName("13")
    public static final ModelName GPT3dot5Turbo0613 = null;

    @SerializedName("3")
    public static final ModelName GPT4 = null;

    @SerializedName(BDLocationException.ERROR_UNKNOWN)
    public static final ModelName GPT4_0613 = null;

    @SerializedName("2")
    public static final ModelName GPT4_32k = null;

    @SerializedName("8")
    public static final ModelName GPT4_32k0613 = null;

    @SerializedName(BDLocationException.ERROR_AMAP_FAIL)
    public static final ModelName MiniMaxABAB5dot5Chat = null;

    @SerializedName("4")
    public static final ModelName SeedBeta = null;

    @SerializedName("20")
    public static final ModelName SeedBrowsingExperiment = null;

    @SerializedName("21")
    public static final ModelName SeedBrowsingOnly = null;

    @SerializedName("29")
    public static final ModelName SeedComplexInstruction = null;

    @SerializedName(BDLocationException.ERROR_SDK_NO_PERMISSION)
    public static final ModelName SeedComplexInstructionTest = null;

    @SerializedName("18")
    public static final ModelName SeedFunctionCall = null;

    @SerializedName("19")
    public static final ModelName SeedMain = null;

    @SerializedName("27")
    public static final ModelName SeedMap = null;

    @SerializedName("7")
    public static final ModelName SeedMusic = null;

    @SerializedName("17")
    public static final ModelName SeedOmni = null;

    @SerializedName("33")
    public static final ModelName SeedOmniSota = null;

    @SerializedName("15")
    public static final ModelName SeedSota = null;

    @SerializedName("16")
    public static final ModelName SeedSotaBrowsing = null;

    @SerializedName(BDLocationException.ERROR_ABNORMAL_NETWORK)
    public static final ModelName SeedStrongCharacterNearlinePortrait = null;

    @SerializedName(BDLocationException.ERROR_SDK_START_FAIL)
    public static final ModelName SeedSuggest = null;

    @SerializedName(BDLocationException.ERROR_CONNECT_GOOGLE_FAIL)
    public static final ModelName SeedSuggestOffline = null;

    @SerializedName("6")
    public static final ModelName SeedSystem = null;

    @SerializedName("25")
    public static final ModelName SeedSystemWithMemory = null;

    @SerializedName(BDLocationException.ERROR_LOCATION_IS_NULL)
    public static final ModelName SeedSystemWithMemoryTest = null;

    @SerializedName("5")
    public static final ModelName SeedWebGPT = null;

    @SerializedName("9")
    public static final ModelName Seed_Img2Text = null;

    @SerializedName("10")
    public static final ModelName Seed_SCTest = null;

    @SerializedName("11")
    public static final ModelName Seed_Test = null;

    @SerializedName("12")
    public static final ModelName Seed_WithPlugins = null;
    private final int value;

    static {
        ModelName r0 = new ModelName("GPT3dot5Turbo", 0, 1);
        GPT3dot5Turbo = r0;
        ModelName r1 = new ModelName("GPT4_32k", 1, 2);
        GPT4_32k = r1;
        ModelName r2 = new ModelName("GPT4", 2, 3);
        GPT4 = r2;
        ModelName r5 = new ModelName("SeedBeta", 3, 4);
        SeedBeta = r5;
        ModelName r7 = new ModelName("SeedWebGPT", 4, 5);
        SeedWebGPT = r7;
        ModelName r9 = new ModelName("SeedSystem", 5, 6);
        SeedSystem = r9;
        ModelName r11 = new ModelName("SeedMusic", 6, 7);
        SeedMusic = r11;
        ModelName r13 = new ModelName("GPT4_32k0613", 7, 8);
        GPT4_32k0613 = r13;
        ModelName r15 = new ModelName("Seed_Img2Text", 8, 9);
        Seed_Img2Text = r15;
        ModelName r14 = new ModelName("Seed_SCTest", 9, 10);
        Seed_SCTest = r14;
        ModelName r12 = new ModelName("Seed_Test", 10, 11);
        Seed_Test = r12;
        ModelName r10 = new ModelName("Seed_WithPlugins", 11, 12);
        Seed_WithPlugins = r10;
        ModelName r8 = new ModelName("GPT3dot5Turbo0613", 12, 13);
        GPT3dot5Turbo0613 = r8;
        ModelName r6 = new ModelName("GPT35_Turbo16k", 13, 14);
        GPT35_Turbo16k = r6;
        ModelName r4 = new ModelName("SeedSota", 14, 15);
        SeedSota = r4;
        ModelName r3 = new ModelName("SeedSotaBrowsing", 15, 16);
        SeedSotaBrowsing = r3;
        ModelName r16 = new ModelName("SeedOmni", 16, 17);
        SeedOmni = r16;
        ModelName r17 = new ModelName("SeedFunctionCall", 17, 18);
        SeedFunctionCall = r17;
        ModelName r18 = new ModelName("SeedMain", 18, 19);
        SeedMain = r18;
        ModelName r19 = new ModelName("SeedBrowsingExperiment", 19, 20);
        SeedBrowsingExperiment = r19;
        ModelName r20 = new ModelName("SeedBrowsingOnly", 20, 21);
        SeedBrowsingOnly = r20;
        ModelName r21 = new ModelName("MiniMaxABAB5dot5Chat", 21, 22);
        MiniMaxABAB5dot5Chat = r21;
        ModelName r22 = new ModelName("Echo", 22, 23);
        Echo = r22;
        ModelName r23 = new ModelName("GPT4_0613", 23, 24);
        GPT4_0613 = r23;
        ModelName r24 = new ModelName("SeedSystemWithMemory", 24, 25);
        SeedSystemWithMemory = r24;
        ModelName r25 = new ModelName("SeedSystemWithMemoryTest", 25, 26);
        SeedSystemWithMemoryTest = r25;
        ModelName r26 = new ModelName("SeedMap", 26, 27);
        SeedMap = r26;
        ModelName r27 = new ModelName("SeedSuggest", 27, 28);
        SeedSuggest = r27;
        ModelName r28 = new ModelName("SeedComplexInstruction", 28, 29);
        SeedComplexInstruction = r28;
        ModelName r29 = new ModelName("SeedComplexInstructionTest", 29, 30);
        SeedComplexInstructionTest = r29;
        ModelName r30 = new ModelName("Edu", 30, 31);
        Edu = r30;
        ModelName r31 = new ModelName("SeedSuggestOffline", 31, 32);
        SeedSuggestOffline = r31;
        ModelName r32 = new ModelName("SeedOmniSota", 32, 33);
        SeedOmniSota = r32;
        ModelName r33 = new ModelName("SeedStrongCharacterNearlinePortrait", 33, 34);
        SeedStrongCharacterNearlinePortrait = r33;
        $VALUES = new ModelName[]{r0, r1, r2, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r3, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33};
    }

    private ModelName(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ModelName findByValue(int r0) {
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
        return SeedStrongCharacterNearlinePortrait;
    L8:
        return SeedOmniSota;
    L10:
        return SeedSuggestOffline;
    L12:
        return Edu;
    L14:
        return SeedComplexInstructionTest;
    L16:
        return SeedComplexInstruction;
    L18:
        return SeedSuggest;
    L20:
        return SeedMap;
    L22:
        return SeedSystemWithMemoryTest;
    L24:
        return SeedSystemWithMemory;
    L26:
        return GPT4_0613;
    L28:
        return Echo;
    L30:
        return MiniMaxABAB5dot5Chat;
    L32:
        return SeedBrowsingOnly;
    L34:
        return SeedBrowsingExperiment;
    L36:
        return SeedMain;
    L38:
        return SeedFunctionCall;
    L40:
        return SeedOmni;
    L42:
        return SeedSotaBrowsing;
    L44:
        return SeedSota;
    L46:
        return GPT35_Turbo16k;
    L48:
        return GPT3dot5Turbo0613;
    L50:
        return Seed_WithPlugins;
    L52:
        return Seed_Test;
    L54:
        return Seed_SCTest;
    L56:
        return Seed_Img2Text;
    L58:
        return GPT4_32k0613;
    L60:
        return SeedMusic;
    L62:
        return SeedSystem;
    L64:
        return SeedWebGPT;
    L66:
        return SeedBeta;
    L68:
        return GPT4;
    L70:
        return GPT4_32k;
    L72:
        return GPT3dot5Turbo;
    }

    public static ModelName valueOf(String r2) {
        return (ModelName) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModelName.class, r2), ModelName.class, "com.obric.memorydata.plugin");
    }

    public static ModelName[] values() {
        return (ModelName[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModelName[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
