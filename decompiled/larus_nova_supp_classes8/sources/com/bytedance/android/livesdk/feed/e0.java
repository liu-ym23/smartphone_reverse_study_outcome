package com.bytedance.android.livesdk.feed;

import com.bytedance.android.livesdk.feed.dislike.DislikeApi;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0 {
    public final f a;
    public final NewTabRepository b;
    public final LiveRoomListDataSource c;
    public final tv1.c d;
    public final LiveDrawerFeedCategoryFragment e;
    public final h f;

    public e0(LiveDrawerFeedCategoryFragment r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "feedLiveFragment");
        Intrinsics.checkNotNullParameter(r4, "feedLiveParams");
        this.e = r3;
        this.f = r4;
        this.d = new tv1.c((DislikeApi) com.bytedance.android.live.network.c.b().e(DislikeApi.class));
        this.a = com.bytedance.android.livesdk.feed.services.d.a();
        boolean r5 = x0.d;
        this.b = x0.a.a();
        this.c = LiveRoomListDataSource.instance();
        this.e = r3;
    }
}
