package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusStrategyProviderType extends Enum<ArgusStrategyProviderType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusStrategyProviderType f5082b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusStrategyProviderType f5083c = null;
    public static final ArgusStrategyProviderType d = null;
    public static final ArgusStrategyProviderType e = null;
    public static final ArgusStrategyProviderType f = null;
    public static final ArgusStrategyProviderType g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArgusStrategyProviderType f5084h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArgusStrategyProviderType f5085i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArgusStrategyProviderType f5086j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ArgusStrategyProviderType f5087k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ArgusStrategyProviderType f5088l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ArgusStrategyProviderType f5089m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ ArgusStrategyProviderType[] f5090n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5091a;

    static {
        ArgusStrategyProviderType r5 = new ArgusStrategyProviderType("WebUrlListVerify", 0, "web_url_list_verify");
        f5082b = r5;
        ArgusStrategyProviderType r10 = new ArgusStrategyProviderType("JSBAuth", 1, "jsb_auth");
        f5083c = r10;
        ArgusStrategyProviderType r11 = new ArgusStrategyProviderType("CSRF_PROTECT", 2, "csrf_protect");
        d = r11;
        ArgusStrategyProviderType r12 = new ArgusStrategyProviderType("LynxSignVerify", 3, "lynx_sign_verify");
        e = r12;
        ArgusStrategyProviderType r13 = new ArgusStrategyProviderType("PrefetchWhiteList", 4, "prefetch_url_list_verify");
        f = r13;
        ArgusStrategyProviderType r14 = new ArgusStrategyProviderType("TTMACHINE", 5, "ttm");
        g = r14;
        ArgusStrategyProviderType r15 = new ArgusStrategyProviderType("LynxLoadWhiteList", 6, "lynx_load_white_list");
        f5084h = r15;
        ArgusStrategyProviderType r16 = new ArgusStrategyProviderType("MotionVerify", 7, "motion_verify");
        f5085i = r16;
        ArgusStrategyProviderType r17 = new ArgusStrategyProviderType("HttpsDomain", 8, "force_https");
        f5086j = r17;
        ArgusStrategyProviderType r18 = new ArgusStrategyProviderType("LynxSSRUrlVerify", 9, "lynx_ssr_url_verify");
        f5087k = r18;
        ArgusStrategyProviderType r19 = new ArgusStrategyProviderType("WebViewCSRFUA", 10, "webview_csrf_ua");
        f5088l = r19;
        ArgusStrategyProviderType r110 = new ArgusStrategyProviderType("UploadFileVerify", 11, "upload_file_verify");
        f5089m = r110;
        f5090n = new ArgusStrategyProviderType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
    }

    public ArgusStrategyProviderType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5091a = r11;
    }

    public static ArgusStrategyProviderType valueOf(String r5) {
        return (ArgusStrategyProviderType) Enum.valueOf(ArgusStrategyProviderType.class, r5);
    }

    public static ArgusStrategyProviderType[] values() {
        return (ArgusStrategyProviderType[]) f5090n.clone();
    }
}
