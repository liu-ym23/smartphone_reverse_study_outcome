package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PoolResult;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum PoolResult extends Enum<PoolResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PoolResult f5922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PoolResult f5923b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PoolResult f5924c = null;
    public static final /* synthetic */ PoolResult[] d = null;

    static {
        PoolResult r5 = new PoolResult("SUCCESS", 0);
        PoolResult r10 = new PoolResult("FAIL_EXISTS", 1);
        PoolResult r11 = new PoolResult("FAIL_LOAD_ERROR", 2);
        f5922a = r11;
        PoolResult r12 = new PoolResult("FAIL_INVALID", 3);
        f5923b = r12;
        PoolResult r13 = new PoolResult("FAIL_EXCEPTION", 4);
        f5924c = r13;
        d = new PoolResult[]{r5, r10, r11, r12, r13};
    }

    public PoolResult(String r5, int r10) {
        super(r5, r10);
    }

    public static PoolResult valueOf(String r5) {
        return (PoolResult) Enum.valueOf(PoolResult.class, r5);
    }

    public static PoolResult[] values() {
        return (PoolResult[]) d.clone();
    }
}
