package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/BidSource;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum BidSource extends Enum<BidSource> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BidSource f7209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ BidSource[] f7210b = null;

    static {
        BidSource r5 = new BidSource("Schema", 0);
        BidSource r10 = new BidSource("Default", 1);
        f7209a = r10;
        f7210b = new BidSource[]{r5, r10};
    }

    public BidSource(String r5, int r10) {
        super(r5, r10);
    }

    public static BidSource valueOf(String r5) {
        return (BidSource) Enum.valueOf(BidSource.class, r5);
    }

    public static BidSource[] values() {
        return (BidSource[]) f7210b.clone();
    }
}
