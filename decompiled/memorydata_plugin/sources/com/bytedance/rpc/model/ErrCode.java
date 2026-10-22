package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ErrCode extends Enum<ErrCode> {
    private static final /* synthetic */ ErrCode[] $VALUES = null;

    @SerializedName("702112109")
    public static final ErrCode AbParamsError = null;

    @SerializedName("702112102")
    public static final ErrCode AuthenticationError = null;

    @SerializedName("5")
    public static final ErrCode ByteArtist = null;

    @SerializedName("6")
    public static final ErrCode Claude = null;

    @SerializedName("7")
    public static final ErrCode Dalle2 = null;

    @SerializedName("702112106")
    public static final ErrCode EngineInternalError = null;

    @SerializedName("702112105")
    public static final ErrCode FunctionInputError = null;

    @SerializedName("8")
    public static final ErrCode GPT = null;

    @SerializedName("2")
    public static final ErrCode InnerErr = null;

    @SerializedName("702112104")
    public static final ErrCode InvalidRequestError = null;

    @SerializedName("702112107")
    public static final ErrCode MaximumTokenError = null;

    @SerializedName("702112108")
    public static final ErrCode NotSupportRoleTypeError = null;

    @SerializedName("1")
    public static final ErrCode ParamErr = null;

    @SerializedName("702112103")
    public static final ErrCode RateLimitError = null;

    @SerializedName("12")
    public static final ErrCode RequireLocation = null;

    @SerializedName("11")
    public static final ErrCode RiskSecurity = null;

    @SerializedName("9")
    public static final ErrCode Seed = null;

    @SerializedName("10")
    public static final ErrCode StableDiffusion = null;

    @SerializedName("702112101")
    public static final ErrCode Timeout = null;

    @SerializedName("4")
    public static final ErrCode WebGPT = null;
    private final int value;

    static {
        ErrCode r0 = new ErrCode("ParamErr", 0, 1);
        ParamErr = r0;
        ErrCode r1 = new ErrCode("InnerErr", 1, 2);
        InnerErr = r1;
        ErrCode r4 = new ErrCode("Timeout", 2, 702112101);
        Timeout = r4;
        ErrCode r6 = new ErrCode("WebGPT", 3, 4);
        WebGPT = r6;
        ErrCode r7 = new ErrCode("ByteArtist", 4, 5);
        ByteArtist = r7;
        ErrCode r10 = new ErrCode("Claude", 5, 6);
        Claude = r10;
        ErrCode r12 = new ErrCode("Dalle2", 6, 7);
        Dalle2 = r12;
        ErrCode r14 = new ErrCode("GPT", 7, 8);
        GPT = r14;
        ErrCode r13 = new ErrCode("Seed", 8, 9);
        Seed = r13;
        ErrCode r15 = new ErrCode("StableDiffusion", 9, 10);
        StableDiffusion = r15;
        ErrCode r11 = new ErrCode("RiskSecurity", 10, 11);
        RiskSecurity = r11;
        ErrCode r9 = new ErrCode("RequireLocation", 11, 12);
        RequireLocation = r9;
        ErrCode r8 = new ErrCode("AuthenticationError", 12, 702112102);
        AuthenticationError = r8;
        ErrCode r2 = new ErrCode("RateLimitError", 13, 702112103);
        RateLimitError = r2;
        ErrCode r5 = new ErrCode("InvalidRequestError", 14, 702112104);
        InvalidRequestError = r5;
        ErrCode r3 = new ErrCode("FunctionInputError", 15, 702112105);
        FunctionInputError = r3;
        ErrCode r16 = new ErrCode("EngineInternalError", 16, 702112106);
        EngineInternalError = r16;
        ErrCode r17 = new ErrCode("MaximumTokenError", 17, 702112107);
        MaximumTokenError = r17;
        ErrCode r18 = new ErrCode("NotSupportRoleTypeError", 18, 702112108);
        NotSupportRoleTypeError = r18;
        ErrCode r19 = new ErrCode("AbParamsError", 19, 702112109);
        AbParamsError = r19;
        $VALUES = new ErrCode[]{r0, r1, r4, r6, r7, r10, r12, r14, r13, r15, r11, r9, r8, r2, r5, r3, r16, r17, r18, r19};
    }

    private ErrCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ErrCode findByValue(int r1) {
        if (r1 == 1) goto L49;
        if (r1 == 2) goto L47;
        switch(r1) {
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L37;
            case 9: goto L35;
            case 10: goto L33;
            case 11: goto L31;
            case 12: goto L29;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 702112101: goto L27;
            case 702112102: goto L25;
            case 702112103: goto L23;
            case 702112104: goto L21;
            case 702112105: goto L19;
            case 702112106: goto L17;
            case 702112107: goto L15;
            case 702112108: goto L13;
            case 702112109: goto L11;
            default: goto L8;
        };
    L8:
        return null;
    L11:
        return AbParamsError;
    L13:
        return NotSupportRoleTypeError;
    L15:
        return MaximumTokenError;
    L17:
        return EngineInternalError;
    L19:
        return FunctionInputError;
    L21:
        return InvalidRequestError;
    L23:
        return RateLimitError;
    L25:
        return AuthenticationError;
    L27:
        return Timeout;
    L29:
        return RequireLocation;
    L31:
        return RiskSecurity;
    L33:
        return StableDiffusion;
    L35:
        return Seed;
    L37:
        return GPT;
    L39:
        return Dalle2;
    L41:
        return Claude;
    L43:
        return ByteArtist;
    L45:
        return WebGPT;
    L47:
        return InnerErr;
    L49:
        return ParamErr;
    }

    public static ErrCode valueOf(String r2) {
        return (ErrCode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ErrCode.class, r2), ErrCode.class, "com.obric.memorydata.plugin");
    }

    public static ErrCode[] values() {
        return (ErrCode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ErrCode[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
