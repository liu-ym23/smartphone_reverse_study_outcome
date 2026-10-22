package com.bytedance.android.live.liveinteract.plantform.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/utils/PublicStreamClientMixStrategy;", "", "None", "Purpose", "Using", "Fallback", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PublicStreamClientMixStrategy extends Enum<PublicStreamClientMixStrategy> {
    public static final PublicStreamClientMixStrategy Fallback = null;
    public static final PublicStreamClientMixStrategy None = null;
    public static final PublicStreamClientMixStrategy Purpose = null;
    public static final PublicStreamClientMixStrategy Using = null;
    public static final /* synthetic */ PublicStreamClientMixStrategy[] a = null;

    static {
        PublicStreamClientMixStrategy r1 = new PublicStreamClientMixStrategy("None", 0);
        None = r1;
        PublicStreamClientMixStrategy r2 = new PublicStreamClientMixStrategy("Purpose", 1);
        Purpose = r2;
        PublicStreamClientMixStrategy r3 = new PublicStreamClientMixStrategy("Using", 2);
        Using = r3;
        PublicStreamClientMixStrategy r4 = new PublicStreamClientMixStrategy("Fallback", 3);
        Fallback = r4;
        a = new PublicStreamClientMixStrategy[]{r1, r2, r3, r4};
    }

    public static PublicStreamClientMixStrategy valueOf(String r1) {
        return (PublicStreamClientMixStrategy) r27.a.a(PublicStreamClientMixStrategy.class, r1);
    }

    public static PublicStreamClientMixStrategy[] values() {
        return (PublicStreamClientMixStrategy[]) a.clone();
    }

    public PublicStreamClientMixStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
