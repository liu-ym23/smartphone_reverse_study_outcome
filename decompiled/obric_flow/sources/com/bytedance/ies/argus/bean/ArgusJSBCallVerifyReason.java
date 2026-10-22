package com.bytedance.ies.argus.bean;

import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusJSBCallVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusJSBCallVerifyReason extends Enum<ArgusJSBCallVerifyReason> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5039c = null;
    public static final ArgusJSBCallVerifyReason d = null;
    public static final ArgusJSBCallVerifyReason e = null;
    public static final ArgusJSBCallVerifyReason f = null;
    public static final ArgusJSBCallVerifyReason g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5040h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5041i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5042j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5043k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5044l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5045m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5046n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ArgusJSBCallVerifyReason f5047o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ ArgusJSBCallVerifyReason[] f5048p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5050b;

    static {
        ArgusJSBCallVerifyReason r5 = new ArgusJSBCallVerifyReason("NO_FE_ID_CONFIG", 0, -1, "app id is not legal");
        ArgusJSBCallVerifyReason r10 = new ArgusJSBCallVerifyReason("NOT_IN_SAFE_URl", 1, -2, "not in safe url");
        ArgusJSBCallVerifyReason r11 = new ArgusJSBCallVerifyReason("IN_EXCLUDE_METHODS", 2, -3, "method in exclude methods");
        f5039c = r11;
        ArgusJSBCallVerifyReason r12 = new ArgusJSBCallVerifyReason("SECURE_NOT_INCLUDE", 3, -4, "method is secure, but not in include method");
        d = r12;
        ArgusJSBCallVerifyReason r13 = new ArgusJSBCallVerifyReason("RULE_DENY_NOT_INCLUDE", 4, -5, "method < rule");
        e = r13;
        ArgusJSBCallVerifyReason r14 = new ArgusJSBCallVerifyReason("NOT_IN_SAFE_URL", 5, -6, "auth url is not in method secure url");
        f = r14;
        ArgusJSBCallVerifyReason r15 = new ArgusJSBCallVerifyReason("OVER_CALL_FREQ", 6, -7, "jsb call over call freq limit");
        g = r15;
        ArgusJSBCallVerifyReason r16 = new ArgusJSBCallVerifyReason("OVER_CALL_TIMES", 7, -8, "jsb call over call times limit");
        f5040h = r16;
        ArgusJSBCallVerifyReason r17 = new ArgusJSBCallVerifyReason("UN_KNOWN", 8, -9, "unknown reason");
        ArgusJSBCallVerifyReason r18 = new ArgusJSBCallVerifyReason("URL_EMPTY", 9, -11, "auth url is empty");
        ArgusJSBCallVerifyReason r19 = new ArgusJSBCallVerifyReason("REQUEST_CHECK_DENY", 10, -12, "failed_request_parameters_check_deny");
        ArgusJSBCallVerifyReason r110 = new ArgusJSBCallVerifyReason("IN_INCLUDE_METHODS", 11, 2, "method in included methods");
        f5041i = r110;
        ArgusJSBCallVerifyReason r20 = new ArgusJSBCallVerifyReason("PASS_GROUP_COMPARE", 12, 3, "pass group compare");
        f5042j = r20;
        ArgusJSBCallVerifyReason r21 = new ArgusJSBCallVerifyReason("GLOBAL_DISABLE_LYNX_AUTH", 13, 1001, "global disable lynx jsb auth");
        f5043k = r21;
        ArgusJSBCallVerifyReason r22 = new ArgusJSBCallVerifyReason("LYNX_INVALID_FE_ID", 14, PointerIconCompat.TYPE_HAND, "lynx invalid fe id");
        f5044l = r22;
        ArgusJSBCallVerifyReason r23 = new ArgusJSBCallVerifyReason("LYNX_AUTH_CONFIG_IS_NULL", 15, PointerIconCompat.TYPE_HELP, "lynx auth config is null");
        f5045m = r23;
        ArgusJSBCallVerifyReason r24 = new ArgusJSBCallVerifyReason("AUTH_URL_IS_NULL", 16, PointerIconCompat.TYPE_WAIT, "auth url is null");
        f5046n = r24;
        ArgusJSBCallVerifyReason r25 = new ArgusJSBCallVerifyReason("DEBUG_DISABLE_LYNX_JSB_AUTH", 17, WebSocketProtocol.CLOSE_NO_STATUS_CODE, "disable lynx jsb auth in debug env");
        ArgusJSBCallVerifyReason r26 = new ArgusJSBCallVerifyReason("RECOVERY_DISABLE_LYNX_JSB_AUTH", 18, PointerIconCompat.TYPE_CELL, "recovery disable lynx jsb auth");
        f5047o = r26;
        f5048p = new ArgusJSBCallVerifyReason[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r25, r26};
    }

    public ArgusJSBCallVerifyReason(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f5049a = r11;
        this.f5050b = r12;
    }

    public static ArgusJSBCallVerifyReason valueOf(String r5) {
        return (ArgusJSBCallVerifyReason) Enum.valueOf(ArgusJSBCallVerifyReason.class, r5);
    }

    public static ArgusJSBCallVerifyReason[] values() {
        return (ArgusJSBCallVerifyReason[]) f5048p.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return this.f5050b;
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return this.f5049a;
    }
}
