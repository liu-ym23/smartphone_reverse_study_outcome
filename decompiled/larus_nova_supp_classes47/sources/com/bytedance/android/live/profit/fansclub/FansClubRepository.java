package com.bytedance.android.live.profit.fansclub;

import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.backend.IFansclubInfoHomePage;
import com.bytedance.android.live.profit.fansclub.backend.IFansclubParticipateIncentive;
import com.bytedance.android.live.profit.fansclub.backend.IGetFansclubHomepageResult;
import com.bytedance.android.live.profit.fansclub.backend.IGroupLiveInfo;
import com.bytedance.android.live.profit.fansclub.backend.IGuardInfo;
import com.bytedance.android.live.profit.fansclub.backend.IMainParticipateIncentive;
import com.bytedance.android.live.profit.fansclub.backend.IUserFansclubInfoHomePage;
import com.bytedance.android.live.profit.fansclub.transfer.FansClubLegacyApi;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FansClubRepository implements com.bytedance.android.scope.o, q {
    public static final /* synthetic */ int x = 0;
    public final CompositeDisposable a;
    public final PropertyOwner<String> b;
    public final PropertyOwner c;
    public final PropertyOwner<Integer> d;
    public final PropertyOwner e;
    public boolean f;
    public long g;
    public final PropertyOwner<g> h;
    public final PropertyOwner i;
    public final PropertyOwner<r> j;
    public final PropertyOwner k;
    public final PropertyOwner<e> l;
    public final PropertyOwner m;
    public final PropertyOwner<Integer> n;
    public final PropertyOwner o;
    public final PropertyOwner<Map<String, String>> p;
    public final PropertyOwner q;
    public final PropertyOwner<l> r;
    public final PropertyOwner s;
    public px0.a t;
    public com.bytedance.android.live.profit.fansclub.transfer.b u;
    public final d v;
    public final yz0.k w;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FansClubRepository a;

        public b(FansClubRepository r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            PropertyOwner<r> r0 = this.a.j;
            r0.a((r) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FansClubRepository a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public c(FansClubRepository r1, String r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            PropertyOwner<r> r7 = this.a.j;
            r r0 = new r();
            s r1 = new s();
            r1.intimacy = 0;
            r1.joinStatus = false;
            r1.level = 0;
            Unit r2 = Unit.INSTANCE;
            r0.userData = r1;
            r0.fansClubSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_ecommerce_fans_club%2Fentrance%2Ftemplate.js&load_taro=0&type=popup&height_percent=100&width_percent=100&open_animate=1&show_dim=0&top_level=1&author_id=" + this.b + "&room_id=" + this.c + "&scene=1";
            r7.a(r0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profit.fansclub.q
    public final void c() {
        this.f = false;
    }

    public final void k() {
        px0.a r0 = this.t;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("roomOrEpisode");
    L5:
        String r1 = r0.a();
        px0.a r2 = this.t;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("roomOrEpisode");
    L8:
        long r3 = r2.b();
        com.bytedance.android.live.profit.fansclub.transfer.b r4 = this.u;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("apiDataSource");
    L11:
        String r6 = r4.a.a();
        com.bytedance.android.live.revenue.common.g r5 = new com.bytedance.android.live.revenue.common.g("FansClubApiDataSource", "queryShopFansClubData anchorId=" + r6);
        r4.a(true, 0);
        RxUtilKt.c(RxUtilKt.i(((FansClubLegacyApi) vh6.c.b(com.bytedance.android.livesdk.revenue.service.network.a.class).getService(FansClubLegacyApi.class)).queryShopFansClubMe(r6, r4.a.b(), 1, 10).map(com.bytedance.android.live.profit.fansclub.transfer.i.a).singleOrError()).doOnSuccess(new com.bytedance.android.live.profit.fansclub.transfer.j(r5)).doOnError(new com.bytedance.android.live.profit.fansclub.transfer.k(r5)).subscribe(new b(this), new c(this, r1, r3)), this.a);
    }

    public final void onStart() {
        d r0 = this.v;
        if (r0.c.Fm() == false) goto L5;
        Episode r1 = r0.c.cl();
    L6:
        if (r1 == null) goto L8;
        int r2 = px0.a.a;
        Intrinsics.checkNotNullParameter(r1, "episode");
        px0.a r3 = new px0.a.b(r1);
    L9:
        this.t = r3;
        px0.a r4 = this.t;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("roomOrEpisode");
    L12:
        this.u = new com.bytedance.android.live.profit.fansclub.transfer.b(r4);
        return;
    L8:
        IRoom r5 = this.w.getRoom();
        int r6 = px0.a.a;
        Intrinsics.checkNotNullParameter(r5, "room");
        r3 = new px0.a.c(r5);
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void onStop() {
        this.a.dispose();
    }

    @Override // com.bytedance.android.live.profit.fansclub.q
    public final PropertyOwner a() {
        return this.i;
    }

    @Override // com.bytedance.android.live.profit.fansclub.q
    public final boolean f() {
        return this.f;
    }

    @Override // com.bytedance.android.live.profit.fansclub.q
    public final long g() {
        return this.g;
    }

    @Override // com.bytedance.android.live.profit.fansclub.q
    public final PropertyOwner getTotalFansCount() {
        return this.o;
    }

    @Override // com.bytedance.android.live.profit.fansclub.q
    public final PropertyOwner h() {
        return this.c;
    }

    @Override // com.bytedance.android.live.profit.fansclub.q
    public final void d(long r1) {
        this.g = r1;
    }

    public final void i(IGetFansclubHomepageResult r28) {
        IFansclubInfoHomePage r2 = r28.getClubInfo();
        String r4 = null;
        boolean r5 = false;
        if (r2 == null) goto L15;
        String r3 = r2.getHomepageSchema();
        if (r3 == null) goto L15;
        if (r3.length() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        this.b.a(r3);
        goto L15
    L9:
        r6 = false;
    L15:
        PropertyOwner<g> r7 = this.h;
        g r8 = (g) r7.a;
        com.bytedance.android.live.profit.fansclub.b r9 = r8.a;
        Intrinsics.checkNotNullParameter(r28, "$this$toFansClubData");
        IUserFansclubInfoHomePage r10 = r28.getUserInfo();
        long r12 = 0;
        String r13 = "";
        if (r10 == null) goto L45;
        IFansclubInfoHomePage r14 = r28.getClubInfo();
        if (r14 == null) goto L23;
        String r15 = r14.getClubName();
        if (r15 == null) goto L23;
        String r16 = r15;
    L24:
        Long r17 = r10.getLevel();
        if (r17 == null) goto L27;
        int r18 = (int) r17.longValue();
    L28:
        Integer r19 = r10.getStatus();
        if (r19 == null) goto L31;
        int r20 = r19.intValue();
    L32:
        IGuardInfo r110 = r28.getGuardInfo();
        if (r110 == null) goto L35;
        int r111 = r110.getGuardStatus();
    L36:
        j r112 = com.bytedance.android.live.profit.fansclub.transfer.m.a(r20, r111);
        if (r9 == null) goto L39;
        com.bytedance.android.live.profit.fansclub.a r113 = r9.d;
    L40:
        IGuardInfo r22 = r28.getGuardInfo();
        if (r22 == null) goto L43;
        Intrinsics.checkNotNullParameter(r22, "$this$toGuardInfo");
        m r114 = new m(r22.getGuardStatus(), r22.getActiveGuardDay(), r22.getTotalGuardDay(), r22.getExpireTime());
    L44:
        com.bytedance.android.live.profit.fansclub.b r23 = new com.bytedance.android.live.profit.fansclub.b(r16, r18, r112, r113, r114);
    L46:
        r7.a(g.a(r8, r23));
        Map<String, String> r24 = r28.getExtra();
        if (r24 != null) goto L49;
    L54:
        PropertyOwner<Integer> r25 = this.n;
        IFansclubInfoHomePage r26 = r28.getClubInfo();
        if (r26 == null) goto L59;
        Long r27 = r26.getTotalFansCount();
        if (r27 == null) goto L59;
        int r29 = (int) r27.longValue();
    L60:
        r25.a(Integer.valueOf(r29));
        PropertyOwner<e> r30 = this.l;
        Intrinsics.checkNotNullParameter(r28, "$this$toFansClubParticipateIncentive");
        IFansclubParticipateIncentive r32 = r28.getParticipateIncentive();
        if (r32 == null) goto L65;
        Long r33 = r32.getGoldCoinsCount();
        if (r33 == null) goto L65;
        r12 = r33.longValue();
    L65:
        IFansclubParticipateIncentive r34 = r28.getParticipateIncentive();
        if (r34 == null) goto L68;
        String r35 = r34.getAwardUnit();
    L69:
        IFansclubParticipateIncentive r36 = r28.getParticipateIncentive();
        if (r36 == null) goto L74;
        IMainParticipateIncentive r37 = (IMainParticipateIncentive) r36.castToOrNull(IMainParticipateIncentive.class);
        if (r37 == null) goto L74;
        r4 = r37.getPopupData();
    L74:
        r30.a(new e(r12, r35, r4));
        PropertyOwner<l> r38 = this.r;
        Intrinsics.checkNotNullParameter(r28, "$this$toFansGroupInfo");
        Boolean r39 = r28.isGroupLive();
        if (r39 == null) goto L77;
        boolean r40 = r39.booleanValue();
    L78:
        IGroupLiveInfo r42 = r28.getGroupLiveInfo();
        if (r42 == null) goto L84;
        String r43 = r42.getSelectAnchorId();
        if (r43 == null) goto L84;
        r13 = r43;
    L84:
        IGroupLiveInfo r44 = r28.getGroupLiveInfo();
        if (r44 == null) goto L87;
        r5 = r44.isManualSelect();
    L87:
        r38.a(new l(r40, r13, r5));
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L97
        com.bytedance.android.live.recharge.util.a r46 = com.bytedance.android.live.recharge.util.a.i;     // Catch: Throwable -> L97
        JsonObject r47 = new JsonObject();     // Catch: Throwable -> L97
        px0.a r48 = this.t;     // Catch: Throwable -> L97
        if (r48 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("roomOrEpisode");     // Catch: Throwable -> L97
    L92:
        r47.addProperty("room_id", Long.valueOf(r48.b()));     // Catch: Throwable -> L97
        px0.a r49 = this.t;     // Catch: Throwable -> L97
        if (r49 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("roomOrEpisode");     // Catch: Throwable -> L97
    L95:
        r47.addProperty("anchor_id", r49.a());     // Catch: Throwable -> L97
        r47.addProperty("user_id", String.valueOf(iz.a.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b())));     // Catch: Throwable -> L97
        r47.addProperty("cache_timestamp", Long.valueOf(System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN)));     // Catch: Throwable -> L97
        r47.addProperty(Constants.Keys.DATA, GsonHelper.get().toJson(r28));     // Catch: Throwable -> L97
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L97
        String r1 = r47.toString();     // Catch: Throwable -> L97
        r46.getClass();     // Catch: Throwable -> L97
        Intrinsics.checkNotNullParameter(r1, "<set-?>");     // Catch: Throwable -> L97
        com.bytedance.android.live.recharge.util.a.f.setValue(r46, com.bytedance.android.live.recharge.util.a.a[4], r1);     // Catch: Throwable -> L97
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L97
    L99:
        int r50 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.h(((g) this.i.a).a);
        return;
    L97:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L99
    L77:
        r40 = false;
        goto L78
    L68:
        r35 = null;
    L59:
        r29 = 0;
        goto L60
    L49:
        if ((true ^ r24.isEmpty()) == true) goto L52;
        r24 = null;
    L52:
        if (r24 == null) goto L54;
        this.p.a(r24);
        goto L54
    L43:
        r114 = new m(0, 0, 15);
        goto L44
    L39:
        r113 = null;
        goto L40
    L35:
        r111 = 0;
        goto L36
    L31:
        r20 = 0;
        goto L32
    L27:
        r18 = 0;
    L23:
        r16 = "";
        goto L24
    L45:
        r23 = null;
        goto L46
    }

    public final void j(int r26) {
        com.bytedance.android.live.profit.fansclub.transfer.b r10 = this.u;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("apiDataSource");
    L5:
        r10.getClass();
        String r12 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        String r13 = r10.a.a();
        long r14 = r10.a.b();
        com.bytedance.android.live.revenue.common.g r15 = new com.bytedance.android.live.revenue.common.g("FansClubApiDataSource", "queryFansClubData anchorId=" + r13);
        long r3 = SystemClock.uptimeMillis();
        r10.a(false, r26);
        int r1 = com.bytedance.android.live.profit.fansclub.transfer.a.a;
        tz0.b r2 = tz0.b.a;
        uz0.c r5 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$beforeConfigureRequest");
        Map<String, String> r4 = r5.b;
        Intrinsics.checkNotNullParameter(r4, "queriesMap");
        if (r13 != null) goto L8;
        String r6 = "";
    L9:
        Intrinsics.checkNotNullParameter("anchor_open_id", "$this$setTo");
        r4.put("anchor_open_id", r6);
        String r7 = Integer.valueOf(r26).toString();
        Intrinsics.checkNotNullParameter("source", "$this$setTo");
        if (r7 == null) goto L12;
        r4.put("source", r7);
    L12:
        String r8 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r8 == null) goto L15;
        r4.put("room_id", r8);
    L15:
        Intrinsics.checkNotNullParameter(r5, "$this$afterConfigureRequest");
        RxUtilKt.c(RxUtilKt.o(RxUtilKt.i(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/fansclub/homepage/", TypesJVMKt.getJavaType(Reflection.typeOf(IGetFansclubHomepageResult.class)), Extra.class, r5.d, r5.a, r5.b, r5.c).map(com.bytedance.android.live.profit.fansclub.transfer.c.a).singleOrError()).doOnSuccess(new com.bytedance.android.live.profit.fansclub.transfer.d(r10, r3, r12, r13, r14, r15)).doOnError(new com.bytedance.android.live.profit.fansclub.transfer.e(r10, r12, r13, r14, r15)), new FansClubRepository$fetchFansClubHomePage$1(this)), this.a);
        return;
    L8:
        r6 = r13;
        goto L9
    }

    public final void n(IBaseUser r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        com.bytedance.android.live.base.model.user.t r6 = r5.getFansClub();
        if (r6 != null) goto L5;
        return;
    L5:
        py.h r0 = r6.getData();
        px0.a r1 = this.t;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("roomOrEpisode");
    L8:
        String r2 = r1.a();
        if (r0 == null) goto L22;
        String r3 = r0.getClubName();
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L22;
        if ((!Intrinsics.areEqual(r0.getAnchorId(), r2)) == false) goto L22;
        int r7 = v.a;
        v.h("FansClubRepository", "anchorId " + r0.getAnchorId() + " does not match " + r2);
        return;
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L22:
        this.h.a(com.bytedance.android.live.profit.fansclub.transfer.m.e(r6));
        ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().setFansClub(r6);
    }

    public FansClubRepository(d r6, yz0.k r7) {
        Intrinsics.checkNotNullParameter(r6, "loaderService");
        Intrinsics.checkNotNullParameter(r7, "roomDataService");
        this.v = r6;
        this.w = r7;
        boolean r8 = r7.isAnchor();
        this.a = new CompositeDisposable();
        if (r8 == false) goto L5;
        String r9 = (String) k.c.getValue(null, k.a[1]);
    L6:
        PropertyOwner<String> r10 = new PropertyOwner(r9);
        this.b = r10;
        this.c = r10;
        int r12 = com.bytedance.android.live.profit.fansclub.transfer.n.a;
        PropertyOwner<Integer> r13 = new PropertyOwner(1);
        this.d = r13;
        this.e = r13;
        this.f = true;
        this.g = System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN);
        PropertyOwner<g> r14 = new PropertyOwner(new g());
        this.h = r14;
        this.i = r14;
        PropertyOwner<r> r15 = new PropertyOwner(new r());
        this.j = r15;
        this.k = r15;
        PropertyOwner<e> r16 = new PropertyOwner(new e(0, null, 7));
        this.l = r16;
        this.m = r16;
        PropertyOwner<Integer> r17 = new PropertyOwner(0);
        this.n = r17;
        this.o = r17;
        PropertyOwner<Map<String, String>> r18 = new PropertyOwner(MapsKt.emptyMap());
        this.p = r18;
        this.q = r18;
        PropertyOwner<l> r19 = new PropertyOwner(new l(0));
        this.r = r19;
        this.s = r19;
        return;
    L5:
        r9 = (String) k.b.getValue(null, k.a[0]);
        goto L6
    }
}
