package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusPrefetchVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusPrefetchVerifyReason extends Enum<ArgusPrefetchVerifyReason> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusPrefetchVerifyReason f5077c = null;
    public static final ArgusPrefetchVerifyReason d = null;
    public static final ArgusPrefetchVerifyReason e = null;
    public static final ArgusPrefetchVerifyReason f = null;
    public static final ArgusPrefetchVerifyReason g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArgusPrefetchVerifyReason f5078h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ ArgusPrefetchVerifyReason[] f5079i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5081b;

    static {
        ArgusPrefetchVerifyReason r5 = new ArgusPrefetchVerifyReason("NOT_MATCH", 0, -1, "not match white list");
        f5077c = r5;
        ArgusPrefetchVerifyReason r10 = new ArgusPrefetchVerifyReason("PREFETCH_HOST_UNPARSEABLE", 1, -2, "prefetch host unparseable");
        d = r10;
        ArgusPrefetchVerifyReason r11 = new ArgusPrefetchVerifyReason("NOT_END_WITH_CORRECT_SUFFIX", 2, -3, "not end with correct suffix");
        e = r11;
        ArgusPrefetchVerifyReason r12 = new ArgusPrefetchVerifyReason("MATCH", 3, 1, "match white list");
        f = r12;
        ArgusPrefetchVerifyReason r13 = new ArgusPrefetchVerifyReason("EMPTY_HOST", 4, 2, "empty host");
        ArgusPrefetchVerifyReason r14 = new ArgusPrefetchVerifyReason("PREFETCH_LOAD_OFFLINE_CONFIG", 5, 3, "prefetch load offline config");
        g = r14;
        ArgusPrefetchVerifyReason r15 = new ArgusPrefetchVerifyReason("DEBUG_DISABLE_PREFETCH_VERIFY", 6, 6, "disable prefetch verify in debug env");
        ArgusPrefetchVerifyReason r16 = new ArgusPrefetchVerifyReason("RECOVERY_DISABLE_PREFETCH_VERIFY", 7, 1001, "recovery disable prefetch verify");
        f5078h = r16;
        f5079i = new ArgusPrefetchVerifyReason[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public ArgusPrefetchVerifyReason(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f5080a = r11;
        this.f5081b = r12;
    }

    public static ArgusPrefetchVerifyReason valueOf(String r5) {
        return (ArgusPrefetchVerifyReason) Enum.valueOf(ArgusPrefetchVerifyReason.class, r5);
    }

    public static ArgusPrefetchVerifyReason[] values() {
        return (ArgusPrefetchVerifyReason[]) f5079i.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return this.f5081b;
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return this.f5080a;
    }
}
