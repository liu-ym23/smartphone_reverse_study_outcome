package com.bytedance.android.livesdk.feed;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface f {

    public interface a {
        void a(String r1);
    }

    void a(String r1, List<FeedItem> r2, FeedExtra r3, boolean r4);

    void b(a r1);

    void c(com.bytedance.android.livesdk.feed.feed.d r1);

    ItemRepository d(FeedDataKey r1);

    void e(FeedDataKey r1, String r2);

    void f(com.bytedance.android.livesdk.feed.feed.d r1);

    void g(FeedDataKey r1, ItemRepository r2);

    boolean h(FeedDataKey r1, ItemRepository r2);

    void i(a r1);
}
