package com.bytedance.android.live.core.paging.datasource;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import f60.a;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class DefaultRxCacheDataSource<CacheKey, V> extends RxCacheDataSource<Long, V, CacheKey> {
    public final PagingLoadCallback<V> m;

    public DefaultRxCacheDataSource(a<CacheKey, V> r1) {
        super(r1);
        this.m = r1.r;
    }

    @Override // com.bytedance.android.live.core.paging.datasource.RxCacheDataSource
    public final Long h(FeedExtra r3) {
        if (r3 != null) goto L4;
    L6:
        return null;
    L4:
        if (r3.hasMore == false) goto L6;
        return Long.valueOf(r3.maxTime);
    }

    @Override // com.bytedance.android.live.core.paging.datasource.RxCacheDataSource
    public final Observable e(boolean r2, Long r3, int r4) {
        PagingLoadCallback<V> r0 = this.m;
        return r0.createObservable(r2, r3, r4);
    }
}
