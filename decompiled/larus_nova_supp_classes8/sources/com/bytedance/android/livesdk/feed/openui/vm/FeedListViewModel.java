package com.bytedance.android.livesdk.feed.openui.vm;

import android.util.Pair;
import androidx.paging.PagedList;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.paging.builder.LiveDataBuilder;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import com.bytedance.android.live.core.paging.viewmodel.PagingViewModel;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.JsonObject;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001'B\u0007¢\u0006\u0004\b$\u0010%J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\u000f\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\fJA\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u00152\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010!R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\"R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010!R\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010#¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/vm/FeedListViewModel;", "Lcom/bytedance/android/live/core/paging/viewmodel/PagingViewModel;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "Lcom/bytedance/android/live/core/paging/datasource/PagingLoadCallback;", "", "url", "enterSource", "", "", "params", "", "fetch", "Lkotlin/Function1;", "", "predicate", "setDataFilter", "initial", "", "key", "", "pageSize", "Lio/reactivex/Observable;", "Landroid/util/Pair;", "", "Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "createObservable", "(ZLjava/lang/Long;I)Lio/reactivex/Observable;", "Lcom/bytedance/android/live/core/feed/FeedApi;", "feedApi$delegate", "Lkotlin/Lazy;", "getFeedApi", "()Lcom/bytedance/android/live/core/feed/FeedApi;", "feedApi", "Ljava/lang/String;", "Ljava/util/Map;", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "a", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class FeedListViewModel extends PagingViewModel<FeedItem> implements PagingLoadCallback<FeedItem> {
    public static final a Companion = null;
    private static final int PAGE_SIZE = 6;
    private static final int PREFETCH_DISTANCE = 4;
    private String enterSource;
    private final Lazy feedApi$delegate;
    private Map<String, Object> params;
    private Function1<? super FeedItem, Boolean> predicate;
    private String url;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ FeedListViewModel a;

        public b(FeedListViewModel r1) {
            this.a = r1;
        }

        public final Object apply(Object r8) {
            BaseListResponse r9 = (BaseListResponse) r8;
            Intrinsics.checkNotNullParameter(r9, "response");
            ArrayList r0 = new ArrayList();
            List r1 = r9.data;
            if (r1 == null) goto L10;
            ArrayList r3 = new ArrayList();
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L11;
            T r4 = r2.next();
            if (((Boolean) FeedListViewModel.access$getPredicate$p(this.a).invoke((FeedItem) r4)).booleanValue() == false) goto L6;
            r3.add(r4);
        L11:
            if (r3 == null) goto L36;
            Iterator<T> r5 = r3.iterator();
        L14:
            if (r5.hasNext() == false) goto L36;
            FeedItem r6 = (FeedItem) r5.next();
            Room r7 = r6.getRoom();
            if (r7 == null) goto L29;
            String r10 = r6.resId;
            String r11 = "";
            if (r10 != null) goto L20;
            r10 = "";
        L20:
            r7.setRequestId(r10);
            FeedExtra r12 = r9.extra;
            if (r12 == null) goto L28;
            JsonObject r13 = r12.getLogPb();
            if (r13 == null) goto L28;
            String r14 = r13.toString();
            if (r14 == null) goto L28;
            r11 = r14;
        L28:
            r7.setLog_pb(r11);
        L29:
            FeedExtra r15 = r9.extra;
            if (r15 == null) goto L34;
            JsonObject r16 = r15.getLogPb();
            if (r16 == null) goto L34;
            String r17 = r16.toString();
        L35:
            r6.logPb = r17;
            r0.add(r6);
        L34:
            r17 = null;
        L36:
            FeedExtra r18 = r9.extra;
            ((Extra) r18).hasMore = false;
            return Pair.create(r0, r18);
        L10:
            r3 = null;
            goto L11
        }
    }

    static {
        Companion = new a();
    }

    private final FeedApi getFeedApi() {
        return (FeedApi) this.feedApi$delegate.getValue();
    }

    public FeedListViewModel() {
        this.feedApi$delegate = LazyKt.lazy(FeedListViewModel$feedApi$2.INSTANCE);
        this.enterSource = "";
        this.params = new LinkedHashMap();
        this.url = "";
        this.predicate = FeedListViewModel$predicate$1.INSTANCE;
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(FeedListViewModel r0) {
        return r0.predicate;
    }

    public final void setDataFilter(Function1<? super FeedItem, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "predicate");
        this.predicate = r2;
    }

    public static final /* synthetic */ void access$setPredicate$p(FeedListViewModel r0, Function1 r1) {
        r0.predicate = r1;
    }

    public Observable<Pair<List<FeedItem>, FeedExtra>> createObservable(boolean r10, Long r11, int r12) {
        long r0 = 0;
        if (r10 == false) goto L5;
    L4:
        long r4 = r0;
        return getFeedApi().feed(this.url, r4, "feed_refresh", this.enterSource, this.params).map(new b(this));
    L5:
        if (r11 == null) goto L4;
        r0 = r11.longValue();
        goto L4
    }

    public final void fetch(String r2, String r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "enterSource");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.url = r2;
        this.enterSource = r3;
        this.params = r4;
        register(new LiveDataBuilder().loadMoreCallback(this).pageConfig(new PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(6).setPrefetchDistance(4).build()).build());
    }
}
