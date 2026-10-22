package com.bytedance.android.livesdk.feed;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface IFeedRepository extends ItemRepository<FeedItem> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.IFeedRepository$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ void $default$update(IFeedRepository r0, String r1) {
            ItemRepository.CC.$default$update(r0, r1);
        }
    }

    public @interface FEED_ACTION {
    }

    public @interface LoadMoreFrom {
    }

    public @interface RefreshFrom {
    }

    public interface a {
    }

    f Bf();

    PublishSubject CP();

    PublishSubject GZ();

    void I60(boolean r1);

    void Nd(BaseFeedDataViewModel.a r1);

    void clearDataCache();

    PublishSubject<Object> o10();

    void onLeave();

    com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> p60(String r1, Map<String, Object> r2);

    com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> query();

    void setReqFrom(String r1, String r2);

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    /* bridge */ /* synthetic */ void update(String r1);

    void vK(LifecycleOwner r1);
}
