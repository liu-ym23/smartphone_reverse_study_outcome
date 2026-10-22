package com.bytedance.android.livesdk.feed.openui.vm;

import android.util.Pair;
import androidx.paging.PagedList;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b \u0010!J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007JA\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001e¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/vm/RoomListViewModel;", "Lcom/bytedance/android/live/core/paging/viewmodel/PagingViewModel;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "Lcom/bytedance/android/live/core/paging/datasource/PagingLoadCallback;", "", "url", "enterSource", "", "", "params", "", "fetch", "", "initial", "", "key", "", "pageSize", "Lio/reactivex/Observable;", "Landroid/util/Pair;", "", "Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "createObservable", "(ZLjava/lang/Long;I)Lio/reactivex/Observable;", "Lcom/bytedance/android/live/core/feed/FeedApi;", "feedApi$delegate", "Lkotlin/Lazy;", "getFeedApi", "()Lcom/bytedance/android/live/core/feed/FeedApi;", "feedApi", "Ljava/lang/String;", "Ljava/util/Map;", "<init>", "()V", "Companion", "a", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class RoomListViewModel extends PagingViewModel<Room> implements PagingLoadCallback<Room> {
    public static final a Companion = null;
    private static final int PAGE_SIZE = 6;
    private static final int PREFETCH_DISTANCE = 4;
    private String enterSource;
    private final Lazy feedApi$delegate;
    private Map<String, Object> params;
    private String url;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r8) {
            BaseListResponse r9 = (BaseListResponse) r8;
            Intrinsics.checkNotNullParameter(r9, "response");
            ArrayList r0 = new ArrayList();
            List r1 = r9.data;
            if (r1 == null) goto L22;
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L22;
            FeedItem r3 = (FeedItem) r2.next();
            Room r4 = r3.getRoom();
            if (r4 == null) goto L6;
            String r5 = r3.resId;
            String r6 = "";
            if (r5 != null) goto L12;
            r5 = "";
        L12:
            r4.setRequestId(r5);
            FeedExtra r7 = r9.extra;
            if (r7 == null) goto L20;
            JsonObject r10 = r7.getLogPb();
            if (r10 == null) goto L20;
            String r11 = r10.toString();
            if (r11 == null) goto L20;
            r6 = r11;
        L20:
            r4.setLog_pb(r6);
            r4.adRawString = r3.adRawString;
            r0.add(r4);
            nn2.a r12 = nn2.a.d;
            nn2.a.a.a().c(r4.id, r3.type);
        L22:
            return Pair.create(r0, r9.extra);
        }
    }

    static {
        Companion = new a();
    }

    private final FeedApi getFeedApi() {
        return (FeedApi) this.feedApi$delegate.getValue();
    }

    public RoomListViewModel() {
        this.feedApi$delegate = LazyKt.lazy(RoomListViewModel$feedApi$2.INSTANCE);
        this.enterSource = "";
        this.params = new LinkedHashMap();
        this.url = "";
    }

    public Observable<Pair<List<Room>, FeedExtra>> createObservable(boolean r10, Long r11, int r12) {
        long r0 = 0;
        if (r10 == false) goto L5;
    L4:
        long r4 = r0;
        return getFeedApi().feed(this.url, r4, "feed_refresh", this.enterSource, this.params).map(b.a);
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
