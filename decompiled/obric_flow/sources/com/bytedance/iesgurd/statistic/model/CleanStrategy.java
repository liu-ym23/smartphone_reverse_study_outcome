package com.bytedance.iesgurd.statistic.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/iesgurd/statistic/model/CleanStrategy;", "", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum CleanStrategy extends Enum<CleanStrategy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CleanStrategy f6698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CleanStrategy f6699b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ CleanStrategy[] f6700c = null;

    static {
        CleanStrategy r5 = new CleanStrategy("BUSINESS_CALL", 0);
        f6698a = r5;
        CleanStrategy r10 = new CleanStrategy("CHECK_UPDATE", 1);
        f6699b = r10;
        f6700c = new CleanStrategy[]{r5, r10, new CleanStrategy("PUSH", 2), new CleanStrategy("CACHE_POLICY", 3), new CleanStrategy("EXPIRE_TIME", 4)};
    }

    public CleanStrategy(String r5, int r10) {
        super(r5, r10);
    }

    public static CleanStrategy valueOf(String r5) {
        return (CleanStrategy) Enum.valueOf(CleanStrategy.class, r5);
    }

    public static CleanStrategy[] values() {
        return (CleanStrategy[]) f6700c.clone();
    }
}
