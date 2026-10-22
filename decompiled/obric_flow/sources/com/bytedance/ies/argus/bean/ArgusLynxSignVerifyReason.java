package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLynxSignVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusLynxSignVerifyReason extends Enum<ArgusLynxSignVerifyReason> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5054c = null;
    public static final ArgusLynxSignVerifyReason d = null;
    public static final ArgusLynxSignVerifyReason e = null;
    public static final ArgusLynxSignVerifyReason f = null;
    public static final ArgusLynxSignVerifyReason g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5055h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5056i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5057j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5058k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5059l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5060m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5061n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5062o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5063p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5064q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5065r = null;
    public static final ArgusLynxSignVerifyReason s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5066t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5067u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ArgusLynxSignVerifyReason f5068v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ ArgusLynxSignVerifyReason[] f5069w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5071b;

    static {
        ArgusLynxSignVerifyReason r5 = new ArgusLynxSignVerifyReason("TASM_SIGN_FAIL", 0, -1, "lynx sign verify failed");
        f5054c = r5;
        ArgusLynxSignVerifyReason r10 = new ArgusLynxSignVerifyReason("NO_CONFIG", 1, -2, "no fe public key");
        d = r10;
        ArgusLynxSignVerifyReason r11 = new ArgusLynxSignVerifyReason("UN_KNOWN", 2, -3, "unknown");
        e = r11;
        ArgusLynxSignVerifyReason r12 = new ArgusLynxSignVerifyReason("URL_DEGRADE_FAILED", 3, -4, "url degrade failed");
        f = r12;
        ArgusLynxSignVerifyReason r13 = new ArgusLynxSignVerifyReason("DISABLE_GLOBAL_SIGN", 4, -5, "disable global sign");
        g = r13;
        ArgusLynxSignVerifyReason r14 = new ArgusLynxSignVerifyReason("TASM_PARSE_FAILED", 5, -6, "parse tasm failed");
        f5055h = r14;
        ArgusLynxSignVerifyReason r15 = new ArgusLynxSignVerifyReason("FORCE_USE_URL_VERIFY_FAILED", 6, -7, "force use url verify failed");
        f5056i = r15;
        ArgusLynxSignVerifyReason r16 = new ArgusLynxSignVerifyReason("FORBID_FE_PAGE_LOAD_SOURCE", 7, -10, "fe enable load source verify but not match");
        f5057j = r16;
        ArgusLynxSignVerifyReason r17 = new ArgusLynxSignVerifyReason("SIGN_SUCCESS", 8, 1, "sign success");
        f5058k = r17;
        ArgusLynxSignVerifyReason r18 = new ArgusLynxSignVerifyReason("URL_DEGRADE_SUCCESS", 9, 2, "url degrade success");
        f5059l = r18;
        ArgusLynxSignVerifyReason r19 = new ArgusLynxSignVerifyReason("NOT_VERIFY_UNSIGNED_FILE", 10, 3, "not verify unsigned failed");
        f5060m = r19;
        ArgusLynxSignVerifyReason r110 = new ArgusLynxSignVerifyReason("VERIFY_ONLY_NO_CONFIG", 11, 4, "mode is verify only, no config");
        f5061n = r110;
        ArgusLynxSignVerifyReason r20 = new ArgusLynxSignVerifyReason("CONTAINER_DISABLE_SIGN", 12, 5, "container disable sign");
        f5062o = r20;
        ArgusLynxSignVerifyReason r21 = new ArgusLynxSignVerifyReason("DEBUG_DISABLE_LYNX_SIGN_VERIFY", 13, 6, "disable lynx sign verify in debug env");
        ArgusLynxSignVerifyReason r22 = new ArgusLynxSignVerifyReason("FE_PAGE_LOAD_LIMIT_SOURCE_PASS_NOT_MAIN_TEMPLATE", 14, 7, "fe enable load source verify, pass because not main template");
        f5063p = r22;
        ArgusLynxSignVerifyReason r23 = new ArgusLynxSignVerifyReason("FE_PAGE_LOAD_LIMIT_SOURCE_PASS", 15, 8, "fe enable load source verify and pass");
        f5064q = r23;
        ArgusLynxSignVerifyReason r24 = new ArgusLynxSignVerifyReason("LOGIC_ERROR", 16, 102, "logic error");
        f5065r = r24;
        ArgusLynxSignVerifyReason r25 = new ArgusLynxSignVerifyReason("FORCE_USE_URL_VERIFY_SUCCESS", 17, 104, "force use url verify success");
        s = r25;
        ArgusLynxSignVerifyReason r26 = new ArgusLynxSignVerifyReason("USE_DEGRAED_BUT_WHITE_LIST_IS_NULL", 18, 105, "use degrade but white list is null");
        f5066t = r26;
        ArgusLynxSignVerifyReason r27 = new ArgusLynxSignVerifyReason("TS_VERIFY_PARAMS_IS_NULL", 19, 107, "ts verify param is null");
        f5067u = r27;
        ArgusLynxSignVerifyReason r28 = new ArgusLynxSignVerifyReason("FE_PAGE_LOAD_LIMIT_SOURCE_ABNORMAL_PASS_NO_VIEW", 20, 108, "fe enable load source verify, pass because no view");
        f5068v = r28;
        f5069w = new ArgusLynxSignVerifyReason[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28};
    }

    public ArgusLynxSignVerifyReason(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f5070a = r11;
        this.f5071b = r12;
    }

    public static ArgusLynxSignVerifyReason valueOf(String r5) {
        return (ArgusLynxSignVerifyReason) Enum.valueOf(ArgusLynxSignVerifyReason.class, r5);
    }

    public static ArgusLynxSignVerifyReason[] values() {
        return (ArgusLynxSignVerifyReason[]) f5069w.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return this.f5071b;
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return this.f5070a;
    }
}
