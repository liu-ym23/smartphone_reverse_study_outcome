package com.bytedance.android.livesdk.feed.drawerfeed.repository;

import am2.x;
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
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.gp;
import com.bytedance.android.livesdk.feed.ApiCallBack;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.c1;
import com.bytedance.android.livesdk.feed.d1;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel;
import com.bytedance.android.livesdk.log.a0;
import com.bytedance.android.livesdk.log.c0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import zv1.d;
import zv1.e;
import zv1.g;
import zv1.h;
import zv1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveDrawerFeedRepository extends BaseFeedRepository implements IFeedRepository {
    public final FeedApi g;
    public final Cache<FeedDataKey, FeedExtra> h;
    public IFeedRepository.a i;
    public com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> j;
    public final PublishSubject<Object> k;
    public final PublishSubject<String> l;
    public final PublishSubject<List<ImageModel>> m;
    public final PublishSubject<Pair<String, String>> n;
    public final PublishSubject<String> o;
    public final hw1.a p;
    public e60.b q;
    public final Cache<Long, Integer> r;
    public final f s;
    public b t;
    public final sv1.a u;
    public boolean v;
    public c w;

    public class a implements b.a {
        public final /* synthetic */ LiveDrawerFeedRepository a;

        public a(LiveDrawerFeedRepository r1) {
            this.a = r1;
        }

        public final String a(boolean r5) {
            c r0 = this.a.w;
            if (r0 != null) goto L5;
            o r6 = u.l().c(x.class);
            String r1 = "";
            if (r6 != null) goto L9;
            return "";
        L9:
            if (r6.getMap().containsKey("enter_from_merge") == false) goto L11;
            String r2 = (String) r6.getMap().get("enter_from_merge");
        L13:
            if (r6.getMap().containsKey("enter_method") == false) goto L16;
            r1 = (String) r6.getMap().get("enter_method");
        L16:
            return r2 + "-" + r1;
        L11:
            r2 = "";
            goto L13
        L5:
            return r0.mg(r5);
        }
    }

    public static class b implements PagingLoadCallback<FeedItem> {
        public long a;
        public int b;
        public final String c;
        public final FeedApi d;
        public final String e;
        public String f;
        public String g;
        public final hw1.a h;
        public final a i;
        public final f j;
        public final PublishSubject<String> k;
        public final PublishSubject<String> l;
        public final FeedDataKey m;
        public final ApiCallBack n;
        public final PublishSubject<List<ImageModel>> o;
        public final CompositeDisposable p;
        public final boolean q;

        public interface a {
        }

        public final Observable<Pair<List<FeedItem>, FeedExtra>> createObservable(final boolean r16, Long r17, int r18) {
            u.l().c(x.class);
            Integer r0 = null;
            long r1 = -1;
            if (r16 == false) goto L21;
            ((BaseFeedRepository) this.n).b(ApiCallBack.ApiType.REFRESH);
            int r8 = !this.f.equals(this.e) ? 1 : 0;
            if (((Boolean) LiveFeedSettings.REFRESH_SHOW_SANDBOX_ROOM.getValue()).booleanValue() == true) goto L7;
        L9:
            String r3 = this.c;
            String r6 = this.f;
            String r7 = ((a) this.i).a(false);
            c r9 = ((a) this.i).a.w;
            if (r9 == null) goto L12;
            r1 = r9.u20();
        L12:
            long r12 = r1;
            c r2 = ((a) this.i).a.w;
            if (r2 == null) goto L15;
            r0 = r2.s40();
        L15:
            Observable<BaseListResponse<FeedItem, FeedExtra>> r4 = a(r3, 0, r6, r7, r12, r8, r0);
            if (this.q == true) goto L18;
        L20:
            this.k.onNext(this.f);
        L36:
            return r4.map(new e(this, r16)).doOnNext(new zv1.f(this)).doOnNext(new g()).doOnNext(new h(this)).doOnError(new i(this, r16));
        L18:
            if (gp.a.getValue().c() == false) goto L20;
            r4 = Observable.zip(r4, c1.a(), d1.a);
            goto L20
        L7:
            if (v.a() == false) goto L9;
            this.f = "feed_refresh_local_test";
            goto L9
        L21:
            ((BaseFeedRepository) this.n).b(ApiCallBack.ApiType.LOAD_MORE);
            a r5 = this.i;
            String r10 = this.c;
            c r11 = ((a) r5).a.w;
            if (r11 == null) goto L24;
            r10 = r11.NX(r10);
        L24:
            a r13 = this.i;
            String r14 = this.c;
            c r15 = ((a) r13).a.w;
            if (r15 == null) goto L27;
            String r19 = r15.NX(r14);
        L28:
            long r20 = r17.longValue();
            String r21 = this.g;
            String r22 = ((a) this.i).a(!TextUtils.equals(r10, this.c));
            c r23 = ((a) this.i).a.w;
            if (r23 == null) goto L31;
            r1 = r23.u20();
        L31:
            long r110 = r1;
            c r24 = ((a) this.i).a.w;
            if (r24 == null) goto L34;
            r0 = r24.s40();
        L34:
            r4 = a(r19, r20, r21, r22, r110, 2, r0);
            this.k.onNext(this.g);
            this.l.onNext(this.g);
            goto L36
        L27:
            r19 = r14;
            goto L28
        }

        public final Observable<BaseListResponse<FeedItem, FeedExtra>> a(String r12, long r13, String r15, String r16, long r17, int r19, Integer r20) {
            long r3 = TimeZone.getDefault().getRawOffset() / BubbleId.PadCast;
            HashMap r10 = new HashMap();
            r10.put("action_type", r15);
            ((a) this.i).a.getClass();
            ((a) this.i).a.getClass();
            r10.put("req_from", r15);
            long r5 = 0;
            if (r17 <= 0) goto L5;
            r10.put("draw_room_tag_id", Long.valueOf(r17));
        L5:
            FeedDataKey r1 = this.m;
            if (r1 != null) goto L8;
        L10:
            if (r20 == null) goto L12;
            r10.put("insert_room_reason", r20);
        L12:
            r10.put("viewed_history", c0.a());
            r10.put("viewed_room_details", a0.a());
            RoomContext r2 = RoomContext.getShared();
            if (r2 != null) goto L15;
        L22:
            String r6 = r12;
        L24:
            return this.d.drawerFeed(r6, r13, r16, r10);
        L15:
            if (r2.isVSRoom() == false) goto L22;
            if (r2.isVSSpecialDrawer() == false) goto L22;
            IVSCameraInfo r4 = ew1.a.a((Room) r2.getRoom().getValue(), ((Long) r2.getCameraId().getValue()).longValue());
            if (r4 == null) goto L21;
            r5 = r4.getCameraId();
        L21:
            r10.put("is_vs_config_drawer", 1);
            r10.put("camera_id", Long.valueOf(r5));
            r10.put("draw_room_id", Long.valueOf(((Room) r2.getRoom().getValue()).getId()));
            r10.put("draw_room_owner_id", ((Room) r2.getRoom().getValue()).getAnchorId());
            r10.put("show_type", 3);
            r10.put("need_map", 1);
            r10.put("source_key", "vs_config_drawer_live_cover");
            r6 = ew1.c.a(r12, Arrays.asList(new String[]{"show_type", "need_map", "source_key"}));
            goto L24
        L8:
            if (TextUtils.equals(r1.b, "drawer_chosen") == false) goto L10;
            r10.put("offset", Long.valueOf(this.a));
            r10.put("offset_type", Integer.valueOf(this.b));
            r10.put("time_zone_offset", Long.valueOf(r3));
            goto L10
        }

        public b(String r2, FeedApi r3, hw1.a r4, f r5, PublishSubject r6, ApiCallBack r7, PublishSubject r8, PublishSubject r9, String r10, a r11, sv1.a r12, FeedDataKey r13, PublishSubject r14, Boolean r15) {
            this.e = "enter_auto";
            this.f = "enter_auto";
            this.g = "feed_loadmore";
            CompositeDisposable r0 = new CompositeDisposable();
            this.p = r0;
            this.c = r2;
            this.d = r3;
            this.i = r11;
            this.j = r5;
            this.h = r4;
            this.m = r13;
            this.k = r8;
            this.n = r7;
            this.l = r9;
            this.f = r10;
            this.e = r10;
            this.q = r15.booleanValue();
            r11.a.getClass();
            r11.a.getClass();
            this.g = "feed_loadmore";
            r0.add(r6.subscribe(new d(this), new g60.c()));
            this.o = r14;
        }
    }

    public interface c {
        String NX(String r1);

        boolean VF();

        String mg(boolean r1);

        Integer s40();

        long u20();
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final void onLeave() {
    }

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    public final void clear() {
        this.c.e(d());
        b r0 = this.t;
        if (r0 == null) goto L6;
        r0.p.clear();
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
    public com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> query() {
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
        return (FeedItem) this.c.c(d(), new zv1.a(r4));
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> p60(String r20, Map<String, Object> r21) {
        c r0 = this.w;
        if (r0 == null) goto L5;
        boolean r1 = r0.VF();
    L6:
        FeedApi r2 = this.g;
        hw1.a r3 = this.p;
        f r4 = this.s;
        PublishSubject<Pair<String, String>> r5 = this.n;
        PublishSubject<String> r7 = this.o;
        PublishSubject<String> r8 = this.l;
        if (this.v == false) goto L9;
        String r6 = "enter_auto_from_room";
    L10:
        this.t = new b(r20, r2, r3, r4, r5, this, r7, r8, r6, new a(this), this.u, ((BaseFeedDataViewModel.a) this.i).a(), this.m, Boolean.valueOf(r1));
        f60.a r9 = new f60.a();
        r9.r = this.t;
        r9.n = ((BaseFeedDataViewModel.a) this.i).a();
        com.bytedance.android.live.core.cache.a<FeedDataKey, FeedItem> r10 = this.c;
        Cache<FeedDataKey, FeedExtra> r11 = this.h;
        r9.o = r10;
        r9.p = r11;
        PagedList.Config.Builder r12 = new PagedList.Config.Builder().setEnablePlaceholders(false);
        IFeedRepository.a r13 = this.i;
        int r14 = 12;
        if (r13 != null) goto L13;
    L15:
        int r15 = 12;
    L16:
        PagedList.Config.Builder r16 = r12.setPageSize(r15);
        IFeedRepository.a r17 = this.i;
        if (r17 != null) goto L19;
    L21:
        PagedList.Config.Builder r18 = r16.setInitialLoadSizeHint(r14);
        IFeedRepository.a r19 = this.i;
        if (r19 != null) goto L24;
    L26:
        int r22 = 4;
    L27:
        r9.q = r18.setPrefetchDistance(r22).build();
        e60.a r23 = r9.build();
        e60.b r24 = (e60.b) r23;
        this.j = new com.bytedance.android.livesdk.feed.feed.a(r24, new com.bytedance.android.livesdk.feed.feed.b());
        this.q = r24;
        r23.c.observeForever(new zv1.c(this));
        return this.j;
    L24:
        if (BaseFeedDataViewModel.access$100(((BaseFeedDataViewModel.a) r19).a) <= 0) goto L26;
        r22 = BaseFeedDataViewModel.access$100(((BaseFeedDataViewModel.a) this.i).a);
        goto L27
    L19:
        if (BaseFeedDataViewModel.access$000(((BaseFeedDataViewModel.a) r17).a) <= 0) goto L21;
        r14 = BaseFeedDataViewModel.access$000(((BaseFeedDataViewModel.a) this.i).a);
        goto L21
    L13:
        if (BaseFeedDataViewModel.access$000(((BaseFeedDataViewModel.a) r13).a) <= 0) goto L15;
        r15 = BaseFeedDataViewModel.access$000(((BaseFeedDataViewModel.a) this.i).a);
        goto L16
    L9:
        r6 = "enter_auto";
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feed.IFeedRepository
    public final void setReqFrom(String r3, String r4) {
        this.n.onNext(new Pair(r3, r4));
    }

    public LiveDrawerFeedRepository(f r2, FeedApi r3, com.bytedance.android.live.core.cache.f r4, com.bytedance.android.live.core.cache.i r5, com.bytedance.android.live.core.cache.f r6, hw1.a r7, com.bytedance.android.livesdk.feed.c r8) {
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
        Disposable r10 = r9.subscribe(new zv1.b(this), new g60.c());
        this.b.add(r10);
    }
}
