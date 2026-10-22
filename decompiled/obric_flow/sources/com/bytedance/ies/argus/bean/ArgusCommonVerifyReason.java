package com.bytedance.ies.argus.bean;

import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusCommonVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusCommonVerifyReason extends Enum<ArgusCommonVerifyReason> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusCommonVerifyReason f5019c = null;
    public static final ArgusCommonVerifyReason d = null;
    public static final ArgusCommonVerifyReason e = null;
    public static final ArgusCommonVerifyReason f = null;
    public static final ArgusCommonVerifyReason g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArgusCommonVerifyReason f5020h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArgusCommonVerifyReason f5021i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ArgusCommonVerifyReason f5022j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ArgusCommonVerifyReason f5023k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ArgusCommonVerifyReason f5024l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ArgusCommonVerifyReason f5025m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ArgusCommonVerifyReason f5026n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ ArgusCommonVerifyReason[] f5027o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5029b;

    static {
        ArgusCommonVerifyReason r5 = new ArgusCommonVerifyReason("REWRITE_BY_EXTERN_SERVICE", 0, -3, "rewrite by extern service");
        ArgusCommonVerifyReason r10 = new ArgusCommonVerifyReason("BLOCK_BY_EXTERN_SERVICE", 1, -2, "block by extern service");
        ArgusCommonVerifyReason r11 = new ArgusCommonVerifyReason("BLOCK_BY_SEC_LINK_HANDLE", 2, -1, "block handle by secLink strategy");
        ArgusCommonVerifyReason r12 = new ArgusCommonVerifyReason("UN_SET", 3, 0, "unset");
        ArgusCommonVerifyReason r13 = new ArgusCommonVerifyReason("ASYNC_PASS_FIRST", 4, 1, "async pass first");
        ArgusCommonVerifyReason r14 = new ArgusCommonVerifyReason("PASS_STRATEGY_CALCULATE", 5, 2, "pass calculate");
        f5019c = r14;
        ArgusCommonVerifyReason r15 = new ArgusCommonVerifyReason("PASS_BY_SEC_LINK_HANDLE", 6, 3, "pass by secLink handle");
        ArgusCommonVerifyReason r16 = new ArgusCommonVerifyReason("SEC_LINK_STRATEGY_IS_NULL", 7, 4, "secLink strategy is null");
        ArgusCommonVerifyReason r17 = new ArgusCommonVerifyReason("TTM_IS_NOT_ENABLED", 8, 1001, "ttm is not enabled");
        d = r17;
        ArgusCommonVerifyReason r18 = new ArgusCommonVerifyReason("TTM_RULE_NAME_IS_NULL", 9, PointerIconCompat.TYPE_HAND, "ttm rule name is null");
        ArgusCommonVerifyReason r19 = new ArgusCommonVerifyReason("TTM_RULE_VERSION_IS_NULL", 10, PointerIconCompat.TYPE_HELP, "ttm rule version is null");
        ArgusCommonVerifyReason r110 = new ArgusCommonVerifyReason("TTM_RULE_INFO_IS_NULL", 11, PointerIconCompat.TYPE_WAIT, "ttm rule info is null");
        ArgusCommonVerifyReason r20 = new ArgusCommonVerifyReason("TTM_RULE_ADDRESS_IS_NULL", 12, WebSocketProtocol.CLOSE_NO_STATUS_CODE, "ttm rule address is null");
        ArgusCommonVerifyReason r21 = new ArgusCommonVerifyReason("RUN_TTM_ERROR", 13, PointerIconCompat.TYPE_CELL, "run ttm error");
        ArgusCommonVerifyReason r22 = new ArgusCommonVerifyReason("MISMATCH_PARAMS_TYPE", 14, PointerIconCompat.TYPE_CROSSHAIR, "mismatch param type");
        e = r22;
        ArgusCommonVerifyReason r23 = new ArgusCommonVerifyReason("TRY_CATCH_ERROR", 15, PointerIconCompat.TYPE_TEXT, "try catch error");
        f = r23;
        ArgusCommonVerifyReason r24 = new ArgusCommonVerifyReason("STRATEGY_RULE_NAME_IS_NULL", 16, PointerIconCompat.TYPE_VERTICAL_TEXT, "strategy rule name is null");
        g = r24;
        ArgusCommonVerifyReason r25 = new ArgusCommonVerifyReason("ASPECT_CONFIG_IS_NULL", 17, PointerIconCompat.TYPE_ALIAS, "aspect config is null");
        f5020h = r25;
        ArgusCommonVerifyReason r26 = new ArgusCommonVerifyReason("CLIENT_STRATEGY_PROVIDER_NOT_FOUND", 18, PointerIconCompat.TYPE_COPY, "client strategy provider not found");
        f5021i = r26;
        ArgusCommonVerifyReason r27 = new ArgusCommonVerifyReason("STRATEGY_RULE_LIST_IS_EMPTY", 19, PointerIconCompat.TYPE_NO_DROP, "strategy rule list is empty");
        f5022j = r27;
        ArgusCommonVerifyReason r28 = new ArgusCommonVerifyReason("ASPECT_IS_REPORT_ONLY", 20, PointerIconCompat.TYPE_ALL_SCROLL, "aspect switch is report only");
        f5023k = r28;
        ArgusCommonVerifyReason r29 = new ArgusCommonVerifyReason("ASPECT_IS_OFF", 21, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, "aspect switch is off");
        f5024l = r29;
        ArgusCommonVerifyReason r30 = new ArgusCommonVerifyReason("DISABLE_BY_RECOVERY", 22, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, "disable by recovery");
        f5025m = r30;
        ArgusCommonVerifyReason r31 = new ArgusCommonVerifyReason("TTM_STRATEGY_PROVIDER_NOT_FOUND", 23, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, "ttm strategy provider not found");
        f5026n = r31;
        f5027o = new ArgusCommonVerifyReason[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, new ArgusCommonVerifyReason("STRATEGY_CONFIG_IS_NULL", 24, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, "strategy config is null")};
    }

    public ArgusCommonVerifyReason(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f5028a = r11;
        this.f5029b = r12;
    }

    public static ArgusCommonVerifyReason valueOf(String r5) {
        return (ArgusCommonVerifyReason) Enum.valueOf(ArgusCommonVerifyReason.class, r5);
    }

    public static ArgusCommonVerifyReason[] values() {
        return (ArgusCommonVerifyReason[]) f5027o.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return this.f5029b;
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return this.f5028a;
    }
}
