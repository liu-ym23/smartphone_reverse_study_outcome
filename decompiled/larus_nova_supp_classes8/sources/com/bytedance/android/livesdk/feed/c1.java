package com.bytedance.android.livesdk.feed;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.gp;
import com.bytedance.android.livesdk.config.m21;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c1 {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r7) {
            BaseListResponse r8 = (BaseListResponse) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
            FeedItem r0 = new FeedItem();
            r0.type = 10000001;
            List r1 = r8.data;
            ArrayList r2 = new ArrayList();
            Iterator<T> r3 = r1.iterator();
        L3:
            boolean r4 = false;
            if (r3.hasNext() == false) goto L10;
            T r5 = r3.next();
            if (((FeedItem) r5).scheduledLive == null) goto L8;
            r4 = true;
        L8:
            if (r4 == false) goto L3;
            r2.add(r5);
            goto L3
        L10:
            r0.setLiveHistoryItems(CollectionsKt.toMutableList(r2));
            FeedExtra r9 = r8.extra;
            if (r9 == null) goto L13;
            r4 = ((Extra) r9).hasMore;
        L13:
            r0.setHasMoreHistoryItems(r4);
            if (r0.getLiveHistoryItems().isEmpty() == false) goto L16;
            r0.setHistoryStatus(FeedItem.HistoryStatus.EMPTY);
        L16:
            return r0;
        }
    }

    public static Observable a() {
        IUserService r0 = jc1.k.f(IUserService.class);
        boolean r1 = false;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.f r2 = r0.user();
        if (r2 == null) goto L7;
        boolean r3 = r2.isLogin();
    L9:
        if (r3 == true) goto L12;
        FeedItem r4 = new FeedItem();
        r4.type = 10000001;
        r4.setHistoryStatus(FeedItem.HistoryStatus.NO_LOGIN);
        return Observable.just(r4);
    L12:
        IHostBusiness r5 = jc1.k.f(IHostBusiness.class);
        if (r5 == null) goto L15;
        r1 = r5.hasLiveHistoryPermission();
    L15:
        if (r1 == true) goto L18;
        FeedItem r6 = new FeedItem();
        r6.type = 10000001;
        r6.setHistoryStatus(FeedItem.HistoryStatus.NO_PERiMISSION);
        return Observable.just(r6);
    L18:
        FeedApi r7 = (FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class);
        m21 r8 = gp.a.getValue();
        if (r8 == null) goto L21;
        long r9 = r8.b();
    L23:
        return r7.feed(r9, 0, 1, "drawer_hot_live_history", "drawer_hot-live_history").map(a.a);
    L21:
        r9 = 50;
    L7:
        r3 = false;
        goto L9
    }

    static {
    }
}
