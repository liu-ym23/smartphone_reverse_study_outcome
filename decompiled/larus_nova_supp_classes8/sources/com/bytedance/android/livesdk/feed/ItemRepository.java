package com.bytedance.android.livesdk.feed;

import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.paging.Listing;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface ItemRepository<T extends FeedItem> extends LifecycleObserver {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.ItemRepository$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T extends FeedItem> {
        public static void $default$update(ItemRepository r0, String r1) {
        }
    }

    void Gf(String r1);

    void clear();

    Extra extra();

    T getFeedItem(String r1);

    List<T> getFeedItems();

    Listing<T> pc();

    void update(String r1);
}
