package com.bytedance.android.livesdk.feed.live;

import android.view.View;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.banner.BannerViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.l;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveBannerViewHolder extends BannerViewHolder {
    public LiveBannerViewHolder(View r1, BannerSwipeRefreshLayout.a r2, FeedDataKey r3, PublishSubject<Object> r4, PublishSubject<Object> r5, PublishSubject<Boolean> r6, l r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
    }
}
