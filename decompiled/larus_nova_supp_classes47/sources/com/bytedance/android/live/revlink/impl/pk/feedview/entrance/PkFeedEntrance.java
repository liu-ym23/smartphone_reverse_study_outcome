package com.bytedance.android.live.revlink.impl.pk.feedview.entrance;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/feedview/entrance/PkFeedEntrance;", "", "ImCardLive", "SearchCard", "FullCard", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkFeedEntrance extends Enum<PkFeedEntrance> {
    public static final PkFeedEntrance FullCard = null;
    public static final PkFeedEntrance ImCardLive = null;
    public static final PkFeedEntrance SearchCard = null;
    public static final /* synthetic */ PkFeedEntrance[] a = null;

    static {
        PkFeedEntrance r1 = new PkFeedEntrance("ImCardLive", 0);
        ImCardLive = r1;
        PkFeedEntrance r2 = new PkFeedEntrance("SearchCard", 1);
        SearchCard = r2;
        PkFeedEntrance r3 = new PkFeedEntrance("FullCard", 2);
        FullCard = r3;
        a = new PkFeedEntrance[]{r1, r2, r3};
    }

    public static PkFeedEntrance valueOf(String r1) {
        return (PkFeedEntrance) a.a(PkFeedEntrance.class, r1);
    }

    public static PkFeedEntrance[] values() {
        return (PkFeedEntrance[]) a.clone();
    }

    public PkFeedEntrance(String r1, int r2) {
        super(r1, r2);
    }
}
