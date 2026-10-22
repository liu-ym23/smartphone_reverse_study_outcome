package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebViewCSRFUAStrategyVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusWebViewCSRFUAStrategyVerifyReason extends Enum<ArgusWebViewCSRFUAStrategyVerifyReason> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusWebViewCSRFUAStrategyVerifyReason f5104c = null;
    public static final /* synthetic */ ArgusWebViewCSRFUAStrategyVerifyReason[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5106b;

    static {
        ArgusWebViewCSRFUAStrategyVerifyReason r5 = new ArgusWebViewCSRFUAStrategyVerifyReason("APPID_IS_NULL", 0, 1, "appid is null");
        f5104c = r5;
        d = new ArgusWebViewCSRFUAStrategyVerifyReason[]{r5, new ArgusWebViewCSRFUAStrategyVerifyReason("UA_CONTAINS_ALL_PART", 1, 2, "ua already contains all part"), new ArgusWebViewCSRFUAStrategyVerifyReason("REWRITE_UA", 2, 3, "rewrite ua")};
    }

    public ArgusWebViewCSRFUAStrategyVerifyReason(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f5105a = r11;
        this.f5106b = r12;
    }

    public static ArgusWebViewCSRFUAStrategyVerifyReason valueOf(String r5) {
        return (ArgusWebViewCSRFUAStrategyVerifyReason) Enum.valueOf(ArgusWebViewCSRFUAStrategyVerifyReason.class, r5);
    }

    public static ArgusWebViewCSRFUAStrategyVerifyReason[] values() {
        return (ArgusWebViewCSRFUAStrategyVerifyReason[]) d.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return this.f5106b;
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return this.f5105a;
    }
}
