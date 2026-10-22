package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthSuccessCode;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AuthSuccessCode extends Enum<AuthSuccessCode> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AuthSuccessCode f7320c = null;
    public static final AuthSuccessCode d = null;
    public static final AuthSuccessCode e = null;
    public static final AuthSuccessCode f = null;
    public static final AuthSuccessCode g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AuthSuccessCode f7321h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AuthSuccessCode f7322i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AuthSuccessCode f7323j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AuthSuccessCode[] f7324k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7326b;

    static {
        AuthSuccessCode r5 = new AuthSuccessCode("UN_SET", 0, 0);
        AuthSuccessCode r10 = new AuthSuccessCode("LEGACY_PUBLIC_METHOD", 1, 1);
        f7320c = r10;
        AuthSuccessCode r11 = new AuthSuccessCode("LEGACY_PRIVATE_DOMAINS", 2, 2);
        d = r11;
        AuthSuccessCode r12 = new AuthSuccessCode("METHOD_NOT_FOUND", 3, 3);
        AuthSuccessCode r13 = new AuthSuccessCode("DISABLE_AUTH", 4, 9, "XBridge disable auth");
        e = r13;
        AuthSuccessCode r14 = new AuthSuccessCode("MATCH_RECOVERY_CONFIG", 5, 10, "recovery over auth");
        f = r14;
        AuthSuccessCode r15 = new AuthSuccessCode("REQUEST_CHECK_PASSED", 6, 17, "success_request_parameters_check_passed");
        g = r15;
        AuthSuccessCode r16 = new AuthSuccessCode("NO_AUTH_PACKAGE", 7, 101, "all permission config not found");
        f7321h = r16;
        AuthSuccessCode r17 = new AuthSuccessCode("LOGIC_ERROR", 8, 102, "unexpected error");
        f7322i = r17;
        AuthSuccessCode r18 = new AuthSuccessCode("REQUEST_CHECK_WARNING", 9, 103, "success_request_parameters_warn");
        f7323j = r18;
        f7324k = new AuthSuccessCode[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public AuthSuccessCode(String r5, int r10, int r11) {
        super(r5, r10);
        this.f7325a = r11;
        this.f7326b = null;
    }

    public static AuthSuccessCode valueOf(String r5) {
        return (AuthSuccessCode) Enum.valueOf(AuthSuccessCode.class, r5);
    }

    public static AuthSuccessCode[] values() {
        return (AuthSuccessCode[]) f7324k.clone();
    }

    public AuthSuccessCode(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f7325a = r11;
        this.f7326b = r12;
    }
}
