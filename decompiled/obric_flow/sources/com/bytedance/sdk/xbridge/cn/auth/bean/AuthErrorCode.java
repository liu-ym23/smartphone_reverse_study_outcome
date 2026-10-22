package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AuthErrorCode extends Enum<AuthErrorCode> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AuthErrorCode f7307c = null;
    public static final AuthErrorCode d = null;
    public static final AuthErrorCode e = null;
    public static final AuthErrorCode f = null;
    public static final AuthErrorCode g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AuthErrorCode f7308h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AuthErrorCode f7309i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AuthErrorCode f7310j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AuthErrorCode f7311k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AuthErrorCode f7312l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AuthErrorCode f7313m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AuthErrorCode[] f7314n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7316b;

    static {
        AuthErrorCode r5 = new AuthErrorCode("NO_FE_ID_CONFIG", 0, -1, "app id is not legal");
        f7307c = r5;
        AuthErrorCode r10 = new AuthErrorCode("NOT_IN_SAFE_URl", 1, -2, "not in safe url");
        d = r10;
        AuthErrorCode r11 = new AuthErrorCode("IN_EXCLUDE_METHODS", 2, -3, "method in exclude methods");
        e = r11;
        AuthErrorCode r12 = new AuthErrorCode("SECURE_NOT_INCLUDE", 3, -4, "method is secure,and not in include method,fail");
        f = r12;
        AuthErrorCode r13 = new AuthErrorCode("RULE_DENY_NOT_INCLUDE", 4, -5, "method < rule");
        g = r13;
        AuthErrorCode r14 = new AuthErrorCode("WEB_BOT_IN_URL", 5, -6, "auth url is not in method secure url");
        f7308h = r14;
        AuthErrorCode r15 = new AuthErrorCode("OVER_CALL_FREQ", 6, -7, "jsb call over call freq limits");
        f7309i = r15;
        AuthErrorCode r16 = new AuthErrorCode("OVER_CALL_TIMES", 7, -8, "jsb call over call times limits");
        f7310j = r16;
        AuthErrorCode r17 = new AuthErrorCode("UN_KNOWN", 8, -9, "unknown reason");
        f7311k = r17;
        AuthErrorCode r18 = new AuthErrorCode("URL_EMPTY", 9, -11, "auth url is empty");
        f7312l = r18;
        AuthErrorCode r19 = new AuthErrorCode("REQUEST_CHECK_DENY", 10, -12, "failed_request_parameters_check_deny");
        f7313m = r19;
        f7314n = new AuthErrorCode[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, new AuthErrorCode("BLOCK_BY_BIZ_SERVICE", 11, -13, "block by biz service")};
    }

    public AuthErrorCode(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f7315a = r11;
        this.f7316b = r12;
    }

    public static AuthErrorCode valueOf(String r5) {
        return (AuthErrorCode) Enum.valueOf(AuthErrorCode.class, r5);
    }

    public static AuthErrorCode[] values() {
        return (AuthErrorCode[]) f7314n.clone();
    }
}
