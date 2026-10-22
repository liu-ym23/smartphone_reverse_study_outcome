package com.ss.android.lark.feed.export.feedlist;

import android.os.Bundle;
import ceb.a;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH&J\b\u0010\u0013\u001a\u00020\rH&J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/feed/export/feedlist/BaseFeedFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "feedListContext", "Lcom/ss/android/lark/feed/export/feedlist/FeedListContext;", "getFeedListContext", "()Lcom/ss/android/lark/feed/export/feedlist/FeedListContext;", "setFeedListContext", "(Lcom/ss/android/lark/feed/export/feedlist/FeedListContext;)V", "cacheState", "Lcom/ss/android/lark/feed/app/view/scroll/FeedScrollState;", "checkCanDoLoadMore", BuildConfig.FLAVOR, "provideRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onLoadMoreHappened", BuildConfig.FLAVOR, "isFeedUIShowed", "isLayoutInSliding", "showNextUnreadItem", "onSaveViewState", "outState", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "recoverScrollStateIfNeed", "feedFilter", "Lcom/ss/android/lark/feed/app/entity/FeedFolder;", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFeedFragment extends BaseFragment {
    public a d;
    public rdb.a e;

    public BaseFeedFragment() {
    }

    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        this.e = new rdb.a(r4.getInt("feed.view.state.scroll_first_position"), r4.getInt("feed.view.state.scroll_offset"));
        return;
    }
}
