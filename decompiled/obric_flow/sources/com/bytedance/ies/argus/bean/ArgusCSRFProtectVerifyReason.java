package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusCSRFProtectVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusCSRFProtectVerifyReason extends Enum<ArgusCSRFProtectVerifyReason> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusCSRFProtectVerifyReason f5016c = null;
    public static final ArgusCSRFProtectVerifyReason d = null;
    public static final /* synthetic */ ArgusCSRFProtectVerifyReason[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5018b;

    static {
        ArgusCSRFProtectVerifyReason r5 = new ArgusCSRFProtectVerifyReason("REWRITE_HEADER", 0, 1, "rewrite header success");
        f5016c = r5;
        ArgusCSRFProtectVerifyReason r10 = new ArgusCSRFProtectVerifyReason("DISABLE_RESOURCE_LOADER", 1, 2, "disable resource loader");
        ArgusCSRFProtectVerifyReason r11 = new ArgusCSRFProtectVerifyReason("DISABLE_FOREST", 2, 3, "disable forest");
        ArgusCSRFProtectVerifyReason r12 = new ArgusCSRFProtectVerifyReason("RECOVERY_DISABLE_LOAD_STATIC_RESOURCE", 3, 1001, "disable load static resource by recovery");
        d = r12;
        e = new ArgusCSRFProtectVerifyReason[]{r5, r10, r11, r12};
    }

    public ArgusCSRFProtectVerifyReason(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f5017a = r11;
        this.f5018b = r12;
    }

    public static ArgusCSRFProtectVerifyReason valueOf(String r5) {
        return (ArgusCSRFProtectVerifyReason) Enum.valueOf(ArgusCSRFProtectVerifyReason.class, r5);
    }

    public static ArgusCSRFProtectVerifyReason[] values() {
        return (ArgusCSRFProtectVerifyReason[]) e.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return this.f5018b;
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return this.f5017a;
    }
}
