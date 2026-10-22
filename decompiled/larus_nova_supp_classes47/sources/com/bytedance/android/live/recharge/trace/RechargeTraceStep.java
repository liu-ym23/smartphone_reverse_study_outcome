package com.bytedance.android.live.recharge.trace;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/recharge/trace/RechargeTraceStep;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "STEP_WALLET_INFO", "STEP_RECHARGE_PANEL_CREATE", "STEP_NO_PASSWORD_SIGN_INFO", "STEP_NO_PASSWORD_SIGN_RESULT", "STEP_NO_PASSWORD_PANEL_SHOW", "STEP_DEALS_LOADED", "STEP_CLICK_DEAL", "STEP_CUSTOM_RECHARGE", "STEP_PAY_CLICK", "STEP_DIAMOND_BUY_PRE", "STEP_DIAMOND_BUY", "STEP_CJ_CALLBACK", "STEP_QUERY_ORDER", "STEP_RECHARGE_SUCCESS", "STEP_RECHARGE_FAIL", "STEP_RECHARGE_PANEL_CLOSE", "STEP_IAP_RECHARGE_CJ_RESULT", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RechargeTraceStep extends Enum<RechargeTraceStep> {
    public static final RechargeTraceStep STEP_CJ_CALLBACK = null;
    public static final RechargeTraceStep STEP_CLICK_DEAL = null;
    public static final RechargeTraceStep STEP_CUSTOM_RECHARGE = null;
    public static final RechargeTraceStep STEP_DEALS_LOADED = null;
    public static final RechargeTraceStep STEP_DIAMOND_BUY = null;
    public static final RechargeTraceStep STEP_DIAMOND_BUY_PRE = null;
    public static final RechargeTraceStep STEP_IAP_RECHARGE_CJ_RESULT = null;
    public static final RechargeTraceStep STEP_NO_PASSWORD_PANEL_SHOW = null;
    public static final RechargeTraceStep STEP_NO_PASSWORD_SIGN_INFO = null;
    public static final RechargeTraceStep STEP_NO_PASSWORD_SIGN_RESULT = null;
    public static final RechargeTraceStep STEP_PAY_CLICK = null;
    public static final RechargeTraceStep STEP_QUERY_ORDER = null;
    public static final RechargeTraceStep STEP_RECHARGE_FAIL = null;
    public static final RechargeTraceStep STEP_RECHARGE_PANEL_CLOSE = null;
    public static final RechargeTraceStep STEP_RECHARGE_PANEL_CREATE = null;
    public static final RechargeTraceStep STEP_RECHARGE_SUCCESS = null;
    public static final RechargeTraceStep STEP_WALLET_INFO = null;
    public static final /* synthetic */ RechargeTraceStep[] a = null;
    private final String value;

    public static RechargeTraceStep valueOf(String r1) {
        return (RechargeTraceStep) r27.a.a(RechargeTraceStep.class, r1);
    }

    public static RechargeTraceStep[] values() {
        return (RechargeTraceStep[]) a.clone();
    }

    static {
        RechargeTraceStep r1 = new RechargeTraceStep("STEP_WALLET_INFO", 0, "wallet_info");
        STEP_WALLET_INFO = r1;
        RechargeTraceStep r2 = new RechargeTraceStep("STEP_RECHARGE_PANEL_CREATE", 1, "recharge_panel_create");
        STEP_RECHARGE_PANEL_CREATE = r2;
        RechargeTraceStep r3 = new RechargeTraceStep("STEP_NO_PASSWORD_SIGN_INFO", 2, "recharge_no_password_sign_info");
        STEP_NO_PASSWORD_SIGN_INFO = r3;
        RechargeTraceStep r4 = new RechargeTraceStep("STEP_NO_PASSWORD_SIGN_RESULT", 3, "recharge_no_password_sign_result");
        STEP_NO_PASSWORD_SIGN_RESULT = r4;
        RechargeTraceStep r5 = new RechargeTraceStep("STEP_NO_PASSWORD_PANEL_SHOW", 4, "recharge_no_password_panel_show");
        STEP_NO_PASSWORD_PANEL_SHOW = r5;
        RechargeTraceStep r6 = new RechargeTraceStep("STEP_DEALS_LOADED", 5, "recharge_deals_loaded");
        STEP_DEALS_LOADED = r6;
        RechargeTraceStep r7 = new RechargeTraceStep("STEP_CLICK_DEAL", 6, "recharge_deal_click");
        STEP_CLICK_DEAL = r7;
        RechargeTraceStep r8 = new RechargeTraceStep("STEP_CUSTOM_RECHARGE", 7, "custom_recharge_panel_create");
        STEP_CUSTOM_RECHARGE = r8;
        RechargeTraceStep r9 = new RechargeTraceStep("STEP_PAY_CLICK", 8, "recharge_pay_click");
        STEP_PAY_CLICK = r9;
        RechargeTraceStep r10 = new RechargeTraceStep("STEP_DIAMOND_BUY_PRE", 9, "diamond_buy_pre");
        STEP_DIAMOND_BUY_PRE = r10;
        RechargeTraceStep r12 = new RechargeTraceStep("STEP_DIAMOND_BUY", 10, "diamond_buy_result");
        STEP_DIAMOND_BUY = r12;
        RechargeTraceStep r13 = new RechargeTraceStep("STEP_CJ_CALLBACK", 11, "cj_callback");
        STEP_CJ_CALLBACK = r13;
        RechargeTraceStep r14 = new RechargeTraceStep("STEP_QUERY_ORDER", 12, "query_order");
        STEP_QUERY_ORDER = r14;
        RechargeTraceStep r15 = new RechargeTraceStep("STEP_RECHARGE_SUCCESS", 13, "recharge_success");
        STEP_RECHARGE_SUCCESS = r15;
        RechargeTraceStep r16 = new RechargeTraceStep("STEP_RECHARGE_FAIL", 14, "recharge_fail");
        STEP_RECHARGE_FAIL = r16;
        RechargeTraceStep r17 = new RechargeTraceStep("STEP_RECHARGE_PANEL_CLOSE", 15, "recharge_panel_close");
        STEP_RECHARGE_PANEL_CLOSE = r17;
        RechargeTraceStep r18 = new RechargeTraceStep("STEP_IAP_RECHARGE_CJ_RESULT", 16, "iap_recharge_cj_result");
        STEP_IAP_RECHARGE_CJ_RESULT = r18;
        a = new RechargeTraceStep[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18};
    }

    public final String getValue() {
        return this.value;
    }

    public RechargeTraceStep(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
