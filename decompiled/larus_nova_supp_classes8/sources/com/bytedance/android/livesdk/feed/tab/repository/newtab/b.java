package com.bytedance.android.livesdk.feed.tab.repository.newtab;

import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.feed.f;
import com.bytedance.android.livesdk.feed.tab.api.FeedTabApi;
import com.bytedance.android.livesdk.feed.tab.repository.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements r {
    public static boolean c;
    public final FeedTabApi a;
    public final String b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.tab.repository.newtab.b$b, reason: collision with other inner class name */
    public static final class C0311b extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public C0311b() {
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final Object apply(Object r9) {
            ListResponse r10 = (ListResponse) r9;
            Intrinsics.checkNotNullParameter(r10, "response");
            List r0 = ((BaseListResponse) r10).data;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            T r3 = r2.next();
            if (Intrinsics.areEqual(((com.bytedance.android.livesdk.feed.tab.model.b) r3).a(), "inner") == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            ArrayList r4 = null;
            if ((!r1.isEmpty()) == true) goto L13;
            r1 = null;
        L13:
            if (r1 == null) goto L23;
            com.bytedance.android.livesdk.feed.tab.model.b r5 = (com.bytedance.android.livesdk.feed.tab.model.b) ListProtector.get(r1, 0);
            if (r5 == null) goto L23;
            List<com.bytedance.android.livesdk.feed.tab.model.a> r6 = r5.b();
            if (r6 == null) goto L23;
            List<com.bytedance.android.livesdk.feed.tab.model.a> r7 = r6;
            ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r11 = r7.iterator();
        L20:
            if (r11.hasNext() == false) goto L22;
            r8.add(((com.bytedance.android.livesdk.feed.tab.model.a) r11.next()).a());
            goto L20
        L22:
            ((NewTabRepository) NewTabRepository.e.getValue()).a.a(r8);
        L24:
            List r12 = ((BaseListResponse) r10).data;
            ArrayList r13 = new ArrayList();
            Iterator<T> r14 = r12.iterator();
        L26:
            if (r14.hasNext() == false) goto L30;
            T r15 = r14.next();
            if (Intrinsics.areEqual(this.a.b, ((com.bytedance.android.livesdk.feed.tab.model.b) r15).a()) == false) goto L26;
            r13.add(r15);
            goto L26
        L30:
            com.bytedance.android.livesdk.feed.tab.model.b r16 = (com.bytedance.android.livesdk.feed.tab.model.b) ListProtector.get(r13, 0);
            if (r16 == null) goto L38;
            List<com.bytedance.android.livesdk.feed.tab.model.a> r17 = r16.b();
            if (r17 == null) goto L38;
            List<com.bytedance.android.livesdk.feed.tab.model.a> r18 = r17;
            r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
            Iterator<T> r19 = r18.iterator();
        L36:
            if (r19.hasNext() == false) goto L38;
            r4.add(((com.bytedance.android.livesdk.feed.tab.model.a) r19.next()).a());
        L38:
            if (r4 == null) goto L52;
            Iterator<T> r20 = r4.iterator();
        L41:
            if (r20.hasNext() == false) goto L52;
            e r21 = (e) r20.next();
            if (r21.getType() != 11) goto L48;
            if (r21.o() == false) goto L48;
            b.c = true;
        L48:
            if (r21.getType() != 11) goto L41;
            if (r21.o() == true) goto L41;
            b.c = false;
        L52:
            BaseListResponse r22 = new BaseListResponse();
            r22.data = r4;
            return r22;
        L23:
            ((NewTabRepository) NewTabRepository.e.getValue()).a.d();
            goto L24
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.r
    public final Observable<BaseListResponse<e, f>> a() {
        String r0 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new C0311b()).second;
        return this.a.queryNewTab(r0).map(new c(this)).subscribeOn(Schedulers.io());
    }

    public b(FeedTabApi r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "feedTabApi");
        Intrinsics.checkNotNullParameter(r3, "entrance");
        this.a = r2;
        this.b = r3;
    }
}
