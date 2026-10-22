package mv1;

import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements l {
    public final /* synthetic */ k b;

    @Override // mv1.l
    public final FeedDataKey a() {
        return this.b.c.feedDataKey();
    }

    @Override // mv1.l
    public final BannerSwipeRefreshLayout.a b() {
        return this.b.i;
    }

    public i(k r1) {
        this.b = r1;
    }
}
