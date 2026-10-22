package com.bytedance.android.livesdk.feed.squarefeed.vm;

import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.cache.Cache;
import com.bytedance.android.live.core.cache.j;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.live.core.utils.y0;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.squarefeed.e;
import com.bytedance.android.livesdkapi.depend.model.live.HotsoonAd;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004B\u000f\u0012\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bH\u0010IJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J6\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0019\u001a\u00020\rH\u0004J\b\u0010\u001a\u001a\u00020\rH\u0004JA\u0010$\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020#\u0012\u0004\u0012\u00020\u00060\"0!2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010&R\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010(R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b)\u0010&R'\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R'\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010,\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010,\u001a\u0004\b?\u0010@R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010&R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001f0B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/vm/OpenFeedViewModel;", "Lcom/bytedance/android/live/core/paging/viewmodel/PagingViewModel;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "Lcom/bytedance/android/live/core/paging/datasource/PagingLoadCallback;", "Lcom/bytedance/android/livesdk/feed/squarefeed/vm/a;", "item", "Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "extra", "", "handleFeedAdParams", "handleRoomParams", "Lcom/bytedance/android/livesdk/feed/feed/FeedDataKey;", "feedDataKey", "", "enterSource", "", "", "params", "reqFrom", "fetch", "refresh", "roomId", "deleteItem", "id", "getFeedItem", "getLoadMoreFrom", "getRefreshFrom", "", "initial", "", "key", "", "pageSize", "Lio/reactivex/Observable;", "Landroid/util/Pair;", "", "createObservable", "(ZLjava/lang/Long;I)Lio/reactivex/Observable;", "Ljava/lang/String;", "Ljava/util/Map;", "Lcom/bytedance/android/livesdk/feed/feed/FeedDataKey;", "url", "Lcom/bytedance/android/live/core/cache/a;", "feedCache$delegate", "Lkotlin/Lazy;", "getFeedCache", "()Lcom/bytedance/android/live/core/cache/a;", "feedCache", "Lcom/bytedance/android/live/core/cache/Cache;", "extraCache$delegate", "getExtraCache", "()Lcom/bytedance/android/live/core/cache/Cache;", "extraCache", "Lcom/bytedance/android/live/core/paging/Listing;", "listing", "Lcom/bytedance/android/live/core/paging/Listing;", "Lcom/bytedance/android/live/core/feed/FeedApi;", "feedApi$delegate", "getFeedApi", "()Lcom/bytedance/android/live/core/feed/FeedApi;", "feedApi", "Lvw1/a;", "feedItemFilter$delegate", "getFeedItemFilter", "()Lvw1/a;", "feedItemFilter", "Landroidx/lifecycle/MutableLiveData;", "pos", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/feed/squarefeed/e;", "feedListConfig", "Lcom/bytedance/android/livesdk/feed/squarefeed/e;", "<init>", "(Lcom/bytedance/android/livesdk/feed/squarefeed/e;)V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class OpenFeedViewModel extends PagingViewModel<FeedItem> implements PagingLoadCallback<FeedItem>, com.bytedance.android.livesdk.feed.squarefeed.vm.a<FeedItem> {
    private String enterSource;
    private final Lazy extraCache$delegate;
    private final Lazy feedApi$delegate;
    private final Lazy feedCache$delegate;
    private FeedDataKey feedDataKey;
    private final Lazy feedItemFilter$delegate;
    private final e feedListConfig;
    private Listing<FeedItem> listing;
    private Map<String, Object> params;
    private MutableLiveData<Integer> pos;
    private String reqFrom;
    private String url;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ OpenFeedViewModel a;
        public final /* synthetic */ boolean b;

        public a(OpenFeedViewModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            BaseListResponse r6 = (BaseListResponse) r5;
            Intrinsics.checkNotNullParameter(r6, "response");
            ArrayList r0 = new ArrayList();
            r0.addAll(CollectionsKt.filterNotNull(r6.data));
            FeedExtra r7 = r6.extra;
            if (r0.isEmpty() == true) goto L12;
            Iterator r1 = r0.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            FeedItem r2 = (FeedItem) r1.next();
            OpenFeedViewModel.access$handleRoomParams(this.a, r2, r7);
            OpenFeedViewModel.access$handleFeedAdParams(this.a, r2, r7);
            goto L7
        L9:
            OpenFeedViewModel.access$getFeedItemFilter$p(this.a).a(OpenFeedViewModel.access$getUrl$p(this.a), r0, r7, this.b);
            return Pair.create(r0, r7);
        L12:
            return Pair.create(r0, r7);
        }
    }

    public static final class b<T> implements j {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            FeedItem r3 = (FeedItem) r2;
            Intrinsics.checkNotNullParameter(r3, "item");
            if (r3.getItem() == null) goto L11;
            Item r4 = r3.getItem();
            if (r4 == null) goto L7;
            String r5 = r4.getMixId();
        L9:
            if (y0.a(r5, this.a) == false) goto L11;
            return true;
        L7:
            r5 = null;
        L11:
            return false;
        }
    }

    private final Cache<FeedDataKey, FeedExtra> getExtraCache() {
        return (Cache) this.extraCache$delegate.getValue();
    }

    private final FeedApi getFeedApi() {
        return (FeedApi) this.feedApi$delegate.getValue();
    }

    private final vw1.a getFeedItemFilter() {
        return (vw1.a) this.feedItemFilter$delegate.getValue();
    }

    public com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> getFeedCache() {
        return (com.bytedance.android.live.core.cache.a) this.feedCache$delegate.getValue();
    }

    public final String getLoadMoreFrom() {
        return "feed_loadmore";
    }

    public final String getRefreshFrom() {
        String r0 = this.reqFrom;
        if (r0 != null) goto L6;
        return "feed_refresh";
    L6:
        return r0;
    }

    public OpenFeedViewModel(e r2) {
        Intrinsics.checkNotNullParameter(r2, "feedListConfig");
        this.feedListConfig = r2;
        this.enterSource = "";
        this.params = new LinkedHashMap();
        this.feedCache$delegate = LazyKt.lazy(OpenFeedViewModel$feedCache$2.INSTANCE);
        this.extraCache$delegate = LazyKt.lazy(OpenFeedViewModel$extraCache$2.INSTANCE);
        this.feedApi$delegate = LazyKt.lazy(OpenFeedViewModel$feedApi$2.INSTANCE);
        this.feedItemFilter$delegate = LazyKt.lazy(OpenFeedViewModel$feedItemFilter$2.INSTANCE);
        this.pos = new MutableLiveData();
    }

    public static final /* synthetic */ vw1.a access$getFeedItemFilter$p(OpenFeedViewModel r0) {
        return r0.getFeedItemFilter();
    }

    public static final /* synthetic */ String access$getUrl$p(OpenFeedViewModel r1) {
        String r2 = r1.url;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("url");
    L5:
        return r2;
    }

    public final FeedItem getFeedItem(String r4) {
        Intrinsics.checkNotNullParameter(r4, "id");
        com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> r0 = getFeedCache();
        FeedDataKey r1 = this.feedDataKey;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedDataKey");
    L6:
        return (FeedItem) r0.c(r1, new b(r4));
    }

    public final void refresh(String r2) {
        this.reqFrom = r2;
        if (super.refresh() == false) goto L6;
        this.pos.postValue(0);
        return;
    }

    public static final /* synthetic */ void access$setUrl$p(OpenFeedViewModel r0, String r1) {
        r0.url = r1;
    }

    private final void handleFeedAdParams(FeedItem r3, FeedExtra r4) {
        if (r3.type != 3) goto L12;
        HotsoonAd r0 = r3.getItem();
        if (r0 == null) goto L11;
        HotsoonAd r1 = r0;
        if (r4.getLogPb() == null) goto L9;
        r1.setLog_pb(String.valueOf(r4.getLogPb()));
    L9:
        r1.setRequestId(r3.resId);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.HotsoonAd");
    }

    private final void handleRoomParams(FeedItem r6, FeedExtra r7) {
        int r0 = r6.type;
        String r1 = "";
        if (r0 != 1) goto L5;
    L6:
        Room r2 = r6.getItem();
        if (r2 == null) goto L34;
        Room r3 = r2;
        if (r7.getLogPb() == null) goto L15;
        r6.logPb = String.valueOf(r7.getLogPb());
        r3.setLog_pb(String.valueOf(r7.getLogPb()));
        if (r3.getOwner() == null) goto L15;
        User r4 = r3.getOwner();
        if (r4 == null) goto L15;
        r4.setLogPb(String.valueOf(r7.getLogPb()));
    L15:
        String r8 = r6.resId;
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        r3.setRequestId(r8);
    L20:
        if (r6.type == 1) goto L22;
        return;
    L22:
        if ((r6.getItem() instanceof Room) == false) goto L35;
        Room r9 = r6.getItem();
        if (r9 == null) goto L31;
        Room r10 = r9;
        r10.setIsFromRecommendCard(r6.isRecommendCard);
        String r11 = r6.liveReason;
        if (r11 == null) goto L29;
        r1 = r11;
    L29:
        r10.setLiveReason(r1);
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
    L35:
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Room");
    L5:
        if (r0 != 2) goto L20;
        goto L6
    }

    public void deleteItem(FeedDataKey r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "feedDataKey");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        FeedItem r4 = getFeedItem(r3);
        if (r4 == null) goto L5;
        getFeedCache().delete(r2, r4);
    L5:
        Listing<FeedItem> r5 = this.listing;
        if (r5 == null) goto L9;
        r5.update();
        return;
    }

    public static final /* synthetic */ void access$handleFeedAdParams(OpenFeedViewModel r0, FeedItem r1, FeedExtra r2) {
        r0.handleFeedAdParams(r1, r2);
    }

    public static final /* synthetic */ void access$handleRoomParams(OpenFeedViewModel r0, FeedItem r1, FeedExtra r2) {
        r0.handleRoomParams(r1, r2);
    }

    public Observable<Pair<List<FeedItem>, FeedExtra>> createObservable(boolean r10, Long r11, int r12) {
        long r0 = 0;
        if (r10 == false) goto L5;
    L4:
        long r4 = r0;
        if (r10 == false) goto L9;
        getRefreshFrom();
    L10:
        FeedApi r2 = getFeedApi();
        String r3 = this.url;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("url");
    L14:
        return r2.feed(r3, r4, this.reqFrom, this.enterSource, this.params).map(new a(this, r10));
    L9:
        getLoadMoreFrom();
        goto L10
    L5:
        if (r11 == null) goto L4;
        r0 = r11.longValue();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.feed.squarefeed.vm.a
    public void fetch(FeedDataKey r2, String r3, Map<String, Object> r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "feedDataKey");
        Intrinsics.checkNotNullParameter(r3, "enterSource");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.feedDataKey = r2;
        this.url = r2.a;
        this.enterSource = r3;
        this.params = r4;
        this.reqFrom = r5;
        f60.a r6 = new f60.a();
        r6.r = this;
        r6.n = r2;
        com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> r7 = getFeedCache();
        Cache<FeedDataKey, FeedExtra> r8 = getExtraCache();
        r6.o = r7;
        r6.p = r8;
        r6.q = new PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(this.feedListConfig.f8()).setPrefetchDistance(this.feedListConfig.I9()).setInitialLoadSizeHint(this.feedListConfig.f8()).build();
        Listing<FeedItem> r9 = r6.build();
        this.listing = r9;
        register(r9);
    }
}
