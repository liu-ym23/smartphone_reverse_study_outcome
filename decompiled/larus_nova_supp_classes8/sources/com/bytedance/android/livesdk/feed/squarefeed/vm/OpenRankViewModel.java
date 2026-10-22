package com.bytedance.android.livesdk.feed.squarefeed.vm;

import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.rank.b;
import com.bytedance.android.live.core.cache.Cache;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.squarefeed.e;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004B\u000f\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b=\u0010>J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0007JA\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR'\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R'\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010!\u001a\u0004\b/\u00100R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00102R(\u00104\u001a\b\u0012\u0004\u0012\u00020\u0014038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/vm/OpenRankViewModel;", "Lcom/bytedance/android/live/core/paging/viewmodel/PagingViewModel;", "Lcom/bytedance/android/live/base/model/rank/a;", "Lcom/bytedance/android/live/core/paging/datasource/PagingLoadCallback;", "Lcom/bytedance/android/livesdk/feed/squarefeed/vm/a;", "Lcom/bytedance/android/livesdk/feed/feed/FeedDataKey;", "feedDataKey", "", "enterSource", "", "", "params", "reqFrom", "", "fetch", "refresh", "", "initial", "", "key", "", "pageSize", "Lio/reactivex/Observable;", "Landroid/util/Pair;", "", "Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "createObservable", "(ZLjava/lang/Long;I)Lio/reactivex/Observable;", "roomId", "deleteItem", "Lcom/bytedance/android/livesdk/feed/feed/FeedDataKey;", "Lcom/bytedance/android/live/core/cache/a;", "feedCache$delegate", "Lkotlin/Lazy;", "getFeedCache", "()Lcom/bytedance/android/live/core/cache/a;", "feedCache", "Lcom/bytedance/android/live/core/cache/Cache;", "extraCache$delegate", "getExtraCache", "()Lcom/bytedance/android/live/core/cache/Cache;", "extraCache", "Lcom/bytedance/android/live/core/paging/Listing;", "listing", "Lcom/bytedance/android/live/core/paging/Listing;", "Lcom/bytedance/android/live/core/feed/FeedApi;", "feedApi$delegate", "getFeedApi", "()Lcom/bytedance/android/live/core/feed/FeedApi;", "feedApi", "Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "pos", "Landroidx/lifecycle/MutableLiveData;", "getPos", "()Landroidx/lifecycle/MutableLiveData;", "setPos", "(Landroidx/lifecycle/MutableLiveData;)V", "Lcom/bytedance/android/livesdk/feed/squarefeed/e;", "feedListConfig", "Lcom/bytedance/android/livesdk/feed/squarefeed/e;", "<init>", "(Lcom/bytedance/android/livesdk/feed/squarefeed/e;)V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class OpenRankViewModel extends PagingViewModel<com.bytedance.android.live.base.model.rank.a> implements PagingLoadCallback<com.bytedance.android.live.base.model.rank.a>, com.bytedance.android.livesdk.feed.squarefeed.vm.a<com.bytedance.android.live.base.model.rank.a> {
    private final Lazy extraCache$delegate;
    private final Lazy feedApi$delegate;
    private final Lazy feedCache$delegate;
    private FeedDataKey feedDataKey;
    private final e feedListConfig;
    private Listing<com.bytedance.android.live.base.model.rank.a> listing;
    private MutableLiveData<Integer> pos;
    private String reqFrom;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r4) {
            BaseResponse r5 = (BaseResponse) r4;
            Intrinsics.checkNotNullParameter(r5, "response");
            ArrayList r0 = new ArrayList();
            b r1 = (b) r5.data;
            if (r1 == null) goto L13;
            List r2 = r1.a();
            if (r2 == null) goto L13;
            if ((!r2.isEmpty()) != true) goto L13;
            b r3 = (b) r5.data;
            if (r3 == null) goto L11;
            List r6 = r3.a();
        L12:
            Intrinsics.checkNotNull(r6);
            r0.addAll(r6);
            goto L13
        L11:
            r6 = null;
        L13:
            FeedExtra r7 = r5.extra;
            ((Extra) r7).hasMore = false;
            return Pair.create(r0, r7);
        }
    }

    private final Cache<FeedDataKey, FeedExtra> getExtraCache() {
        return (Cache) this.extraCache$delegate.getValue();
    }

    private final FeedApi getFeedApi() {
        return (FeedApi) this.feedApi$delegate.getValue();
    }

    public com.bytedance.android.live.core.cache.a<FeedDataKey, com.bytedance.android.live.base.model.rank.a> getFeedCache() {
        return (com.bytedance.android.live.core.cache.a) this.feedCache$delegate.getValue();
    }

    public final MutableLiveData<Integer> getPos() {
        return this.pos;
    }

    public OpenRankViewModel(e r2) {
        Intrinsics.checkNotNullParameter(r2, "feedListConfig");
        this.feedListConfig = r2;
        this.feedCache$delegate = LazyKt.lazy(OpenRankViewModel$feedCache$2.INSTANCE);
        this.extraCache$delegate = LazyKt.lazy(OpenRankViewModel$extraCache$2.INSTANCE);
        this.feedApi$delegate = LazyKt.lazy(OpenRankViewModel$feedApi$2.INSTANCE);
        this.pos = new MutableLiveData();
    }

    public final void refresh(String r2) {
        this.reqFrom = r2;
        if (super.refresh() == false) goto L6;
        this.pos.postValue(0);
        return;
    }

    public final void setPos(MutableLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pos = r2;
    }

    public void deleteItem(FeedDataKey r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "feedDataKey");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        throw new Exception("not support exception");
    }

    public Observable<Pair<List<com.bytedance.android.live.base.model.rank.a>, FeedExtra>> createObservable(boolean r1, Long r2, int r3) {
        return getFeedApi().hotRank().map(a.a);
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.vm.a
    public void fetch(FeedDataKey r1, String r2, Map<String, Object> r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "feedDataKey");
        Intrinsics.checkNotNullParameter(r2, "enterSource");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.feedDataKey = r1;
        f60.a r5 = new f60.a();
        r5.r = this;
        r5.n = r1;
        com.bytedance.android.live.core.cache.a<FeedDataKey, com.bytedance.android.live.base.model.rank.a> r6 = getFeedCache();
        Cache<FeedDataKey, FeedExtra> r7 = getExtraCache();
        r5.o = r6;
        r5.p = r7;
        r5.q = new PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(this.feedListConfig.f8()).setPrefetchDistance(this.feedListConfig.I9()).setInitialLoadSizeHint(this.feedListConfig.f8()).build();
        Listing<com.bytedance.android.live.base.model.rank.a> r8 = r5.build();
        this.listing = r8;
        register(r8);
    }
}
