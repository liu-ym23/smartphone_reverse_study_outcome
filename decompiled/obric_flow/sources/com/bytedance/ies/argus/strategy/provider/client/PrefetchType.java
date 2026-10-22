package com.bytedance.ies.argus.strategy.provider.client;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/PrefetchType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum PrefetchType extends Enum<PrefetchType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PrefetchType f5150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ PrefetchType[] f5151b = null;

    static {
        PrefetchType r5 = new PrefetchType("Latch", 0);
        PrefetchType r10 = new PrefetchType("PrefetchV2", 1);
        f5150a = r10;
        f5151b = new PrefetchType[]{r5, r10};
    }

    public PrefetchType(String r5, int r10) {
        super(r5, r10);
    }

    public static PrefetchType valueOf(String r5) {
        return (PrefetchType) Enum.valueOf(PrefetchType.class, r5);
    }

    public static PrefetchType[] values() {
        return (PrefetchType[]) f5151b.clone();
    }
}
