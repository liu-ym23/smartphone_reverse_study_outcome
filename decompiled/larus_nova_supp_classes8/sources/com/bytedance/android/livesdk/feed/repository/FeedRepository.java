package com.bytedance.android.livesdk.feed.repository;

import am2.x;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.paging.PagedList;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.cache.Cache;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.live.core.paging.datasource.PagingLoadCallback;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.feed.ApiCallBack;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.b1;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.b;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sw1.c;
import sw1.d;
import sw1.e;
import sw1.g;
import sw1.h;
import sw1.i;
import sw1.j;
import sw1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedRepository extends BaseFeedRepository implements IFeedRepository {
    public final FeedApi g;
    public final Cache<FeedDataKey, FeedExtra> h;
    public IFeedRepository.a i;
    public com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, b> j;
    public final PublishSubject<Object> k;
    public final PublishSubject<String> l;
    public final PublishSubject<List<ImageModel>> m;
    public final PublishSubject<Pair<String, String>> n;
    public final PublishSubject<String> o;
    public final hw1.a p;
    public e60.b q;
    public final Cache<Long, Integer> r;
    public final f s;
    public a t;
    public final sv1.a u;
    public boolean v;
    public b1 w;

    public static class a implements PagingLoadCallback<FeedItem> {
        public final String a;
        public final FeedApi b;
        public String c;
        public String d;
        public final hw1.a e;
        public final InterfaceC0310a f;
        public final f g;
        public final PublishSubject<String> h;
        public final PublishSubject<String> i;
        public final ApiCallBack j;
        public final PublishSubject<List<ImageModel>> k;
        public final CompositeDisposable l;
        public b1 m;
        public final Map<String, Object> n;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.repository.FeedRepository$a$a, reason: collision with other inner class name */
        public interface InterfaceC0310a {
        }

        public final Observable<Pair<List<FeedItem>, FeedExtra>> createObservable(final boolean r9, Long r10, int r11) {
            o r12 = u.l().c(x.class);
            String r0 = "";
            if (r12 != null) goto L5;
        L12:
            String r6 = r0;
            HashMap r7 = new HashMap();
            b1 r13 = this.m;
            if (r13 != null) goto L15;
        L20:
            Map<String, Object> r14 = this.n;
            if (r14 != null) goto L23;
        L25:
            if (r9 == false) goto L38;
            ((BaseFeedRepository) this.j).b(ApiCallBack.ApiType.REFRESH);
            if (((Boolean) LiveFeedSettings.REFRESH_SHOW_SANDBOX_ROOM.getValue()).booleanValue() == true) goto L29;
        L31:
            b1 r15 = this.m;
            if (r15 != null) goto L34;
        L36:
            Observable r16 = this.b.feed(this.a, 0, this.c, r6, r7);
        L37:
            this.h.onNext(this.c);
            kw1.a.c = false;
            kw1.a.d = SystemClock.elapsedRealtime();
            kw1.a.a++;
        L39:
            this.m = null;
            return r16.map(new g(this, r9)).doOnNext(new h(this)).doOnNext(new i()).doOnNext(new j(this)).doOnError(new k(this, r9));
        L34:
            if (TextUtils.isEmpty(r15.b) == true) goto L36;
            r16 = this.b.feed(this.a, 0, r6, r7);
            goto L37
        L29:
            if (v.a() == false) goto L31;
            this.c = "feed_refresh_local_test";
            goto L31
        L38:
            ((BaseFeedRepository) this.j).b(ApiCallBack.ApiType.LOAD_MORE);
            r16 = this.b.feed(this.a, r10.longValue(), this.d, r6, r7);
            this.h.onNext(this.d);
            this.i.onNext(this.d);
            goto L39
        L23:
            if (r14.isEmpty() == true) goto L25;
            r7.putAll(this.n);
            goto L25
        L15:
            if (r13.a == false) goto L17;
            r7.put("is_first_req", Boolean.TRUE);
        L17:
            int r17 = this.m.d;
            if (r17 <= 0) goto L20;
            r7.put("hometown_city_code", Integer.valueOf(r17));
            goto L20
        L5:
            if (r12.getMap().containsKey("enter_from_merge") == false) goto L7;
            String r1 = (String) r12.getMap().get("enter_from_merge");
        L9:
            if (r12.getMap().containsKey("enter_method") == false) goto L11;
            r0 = (String) r12.getMap().get("enter_method");
        L11:
            r0 = r1 + "-" + r0;
            goto L12
        L7:
            r1 = "";
            goto L9
        }

        public a(String r1, FeedApi r2, hw1.a r3, f r4, PublishSubject r5, ApiCallBack r6, PublishSubject r7, PublishSubject r8, String r9, c r10, sv1.a r11, PublishSubject r12, Map r13) {
            this.c = "enter_auto";
            this.d = "feed_loadmore";
            CompositeDisposable r14 = new CompositeDisposable();
            this.l = r14;
            this.a = r1;
            this.b = r2;
            this.f = r10;
            this.g = r4;
            this.e = r3;
            this.h = r7;
            this.j = r6;
            this.i = r8;
            this.c = r9;
            r14.add(r5.subscribe(new sw1.f(this), new g60.c()));
            this.k = r12;
            this.n = r13;
        }
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final void onLeave() {
    }

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public final void clear() {
        this.c.e(d());
        a r0 = this.t;
        if (r0 == null) goto L6;
        r0.l.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final void clearDataCache() {
        com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> r0 = this.c;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.repository.BaseFeedRepository
    public final FeedDataKey d() {
        IFeedRepository.a r0 = this.i;
        if (r0 == null) goto L7;
        return ((BaseFeedDataViewModel.a) r0).a();
    L7:
        throw new IllegalStateException("not call init() or params be null");
    }

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public final Extra extra() {
        return (Extra) this.h.get(d());
    }

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public final List<FeedItem> getFeedItems() {
        return this.c.get(d());
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final f Bf() {
        return this.s;
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final PublishSubject CP() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final PublishSubject GZ() {
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final PublishSubject<Object> o10() {
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.feed.repository.BaseFeedRepository, com.bytedance.android.livesdk.feed.ItemRepository
    public final Listing<FeedItem> pc() {
        return this.q;
    }

    @Override // com.bytedance.android.livesdk.feed.repository.BaseFeedRepository, com.bytedance.android.livesdk.feed.IFeedRepository
    public com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, b> query() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public final void Gf(String r3) {
        FeedItem r4 = getFeedItem(r3);
        if (r4 == null) goto L5;
        this.c.delete(d(), r4);
    L5:
        e60.b r5 = this.q;
        if (r5 == null) goto L9;
        r5.update();
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final void I60(boolean r1) {
        this.v = r1;
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final void Nd(BaseFeedDataViewModel.a r1) {
        this.i = r1;
    }

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public final FeedItem getFeedItem(final String r4) {
        return (FeedItem) this.c.c(d(), new sw1.b(r4));
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, b> p60(String r17, Map<String, Object> r18) {
        FeedApi r2 = this.g;
        hw1.a r3 = this.p;
        f r4 = this.s;
        PublishSubject<Pair<String, String>> r5 = this.n;
        PublishSubject<String> r7 = this.o;
        PublishSubject<String> r8 = this.l;
        if (this.v == false) goto L5;
        String r0 = "enter_auto_from_room";
    L6:
        String r9 = r0;
        c r10 = new c(this);
        sv1.a r11 = this.u;
        ((BaseFeedDataViewModel.a) this.i).a();
        a r15 = new a(r17, r2, r3, r4, r5, this, r7, r8, r9, r10, r11, this.m, r18);
        this.t = r15;
        b1 r1 = this.w;
        if (r1 == null) goto L9;
        r15.m = r1;
    L9:
        f60.a r6 = new f60.a();
        r6.r = this.t;
        r6.n = ((BaseFeedDataViewModel.a) this.i).a();
        com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> r12 = this.c;
        Cache<FeedDataKey, FeedExtra> r13 = this.h;
        r6.o = r12;
        r6.p = r13;
        PagedList.Config.Builder r14 = new PagedList.Config.Builder().setEnablePlaceholders(false);
        IFeedRepository.a r16 = this.i;
        int r19 = 12;
        if (r16 != null) goto L12;
    L14:
        int r20 = 12;
    L15:
        PagedList.Config.Builder r21 = r14.setPageSize(r20);
        IFeedRepository.a r22 = this.i;
        if (r22 != null) goto L18;
    L20:
        PagedList.Config.Builder r23 = r21.setInitialLoadSizeHint(r19);
        IFeedRepository.a r24 = this.i;
        if (r24 != null) goto L23;
    L25:
        int r25 = 4;
    L26:
        r6.q = r23.setPrefetchDistance(r25).build();
        e60.a r26 = r6.build();
        e60.b r27 = (e60.b) r26;
        this.j = new com.bytedance.android.livesdk.feed.feed.a(r27, new b());
        this.q = r27;
        e60.a r28 = r26;
        r28.c.observeForever(new d(this));
        r28.k.observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this));
        return this.j;
    L23:
        if (BaseFeedDataViewModel.access$100(((BaseFeedDataViewModel.a) r24).a) <= 0) goto L25;
        r25 = BaseFeedDataViewModel.access$100(((BaseFeedDataViewModel.a) this.i).a);
        goto L26
    L18:
        if (BaseFeedDataViewModel.access$000(((BaseFeedDataViewModel.a) r22).a) <= 0) goto L20;
        r19 = BaseFeedDataViewModel.access$000(((BaseFeedDataViewModel.a) this.i).a);
        goto L20
    L12:
        if (BaseFeedDataViewModel.access$000(((BaseFeedDataViewModel.a) r16).a) <= 0) goto L14;
        r20 = BaseFeedDataViewModel.access$000(((BaseFeedDataViewModel.a) this.i).a);
        goto L15
    L5:
        r0 = "enter_auto";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final void setReqFrom(String r3, String r4) {
        this.n.onNext(new Pair(r3, r4));
    }

    public FeedRepository(f r2, FeedApi r3, com.bytedance.android.live.core.cache.f r4, com.bytedance.android.live.core.cache.i r5, com.bytedance.android.live.core.cache.f r6, hw1.a r7, com.bytedance.android.livesdk.feed.c r8) {
        super(r2, r5);
        this.k = PublishSubject.create();
        this.l = PublishSubject.create();
        this.m = PublishSubject.create();
        this.n = PublishSubject.create();
        PublishSubject<String> r9 = PublishSubject.create();
        this.o = r9;
        this.v = false;
        this.s = r2;
        this.g = r3;
        this.h = r4;
        this.r = r6;
        this.p = r7;
        this.u = r8;
        Disposable r10 = r9.subscribe(new sw1.a(this), new g60.c());
        this.b.add(r10);
    }
}
