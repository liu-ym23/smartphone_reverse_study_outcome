package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.n1;
import com.bytedance.android.livesdk.gift.model.o1;
import com.bytedance.android.livesdk.gift.model.p1;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftExtra;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftExtraRepo extends BaseMVIDataStore<GiftExtraRepo> implements com.bytedance.android.scope.o, r0, mc6.d, xc6.a {
    public static final /* synthetic */ KProperty[] r = null;
    public static final ReadOnlyProperty s = null;
    public static final ReadOnlyProperty t = null;
    public static final ReadOnlyProperty u = null;
    public static final a v = null;
    public final Map<Long, BehaviorSubject<sh6.b<p1>>> e;
    public final Map<Long, Long> f;
    public final CompositeDisposable g;
    public final Map<Long, JsonObject> h;
    public final Map<Long, Boolean> i;
    public final boolean j;
    public final boolean k;
    public final ReadOnlyProperty l;
    public final ReadOnlyProperty m;
    public final com.bytedance.android.anya.t n;
    public final i12.e o;
    public final com.bytedance.android.livesdk.revenue.service.message.f p;
    public final wz1.a q;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_GIFT_EXTRA_CALLBACK_SCHEDULER_OPT", "getLIVE_GIFT_EXTRA_CALLBACK_SCHEDULER_OPT()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_GIFT_EXTRA_REQUEST_ADVANCE_OPT", "getLIVE_GIFT_EXTRA_REQUEST_ADVANCE_OPT()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "LIVE_GIFT_EXTRA_CALLBACK_IO_THREAD", "getLIVE_GIFT_EXTRA_CALLBACK_IO_THREAD()Z", 0))};
        }

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

        public final Object apply(Object r3) {
            ExtraResponse r4 = (ExtraResponse) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            List<p1> r5 = ((o1) r4.data).getGiftExtras();
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            r0.add(((p1) r6.next()).getDecoded());
            goto L4
        L6:
            return r0;
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ GiftExtraRepo a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;

        public c(GiftExtraRepo r1, long r2, String r4, String r5, boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final Object apply(Object r10) {
            sh6.b r11 = (sh6.b) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            Class r0 = kc6.q.class.getAnnotation(JsonAdapter.class).value();
            ConcurrentHashMap r1 = vh7.b.a;
            Object r2 = r1.get(r0);
            if (r2 != null) goto L12;
            r2 = r0.getConstructor(new Class[0]);
            if (r2 == null) goto L11;
            Object r3 = r1.putIfAbsent(r0, r2);
            if (r3 == null) goto L12;
            r2 = r3;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
        L12:
            Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
            if (r4 == null) goto L21;
            kc6.q r5 = (kc6.q) r4;
            p1 r6 = (p1) sh6.c.b(r11);
            if (r6 == null) goto L17;
            com.bytedance.android.livesdk.gift.model.g0 r7 = r6.getDecoded();
        L18:
            r5.M1(r7);
            r5.m(this.a.F(this.b, (p1) sh6.c.b(r11), this.c, this.d, this.e));
            return r5;
        L17:
            r7 = null;
            goto L18
        L21:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.kmp.livesdk.gift.platform.aio.model.GiftExtraObserveResponse");
        }
    }

    static {
        r = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftExtraRepo.class, "updateGifts", "getUpdateGifts()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftExtraRepo.class, "sortSceneUpdateConfig", "getSortSceneUpdateConfig()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftExtraRepo.class, "sortSceneConfigMap", "getSortSceneConfigMap()Ljava/util/Map;", 0))};
        v = new a();
        Boolean r1 = Boolean.FALSE;
        Class r4 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_extra_callback_scheduler_opt", r1, r4, false);
        KProperty[] r6 = a.a;
        s = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r6[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_extra_request_advance_opt", r1, r4, false);
        t = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r6[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_extra_callback_io_thread", r1, r4, false);
        u = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r6[2]);
    }

    public final com.bytedance.android.anya.t<GiftExtraRepo, Map<String, z1>> L() {
        return (com.bytedance.android.anya.t) this.m.getValue(this, r[1]);
    }

    public final com.bytedance.android.anya.t<GiftExtraRepo, x0> R() {
        return (com.bytedance.android.anya.t) this.l.getValue(this, r[0]);
    }

    public final void onStart() {
    }

    public final z1 J() {
        return (z1) ((Map) this.n.getValue(this, r[2])).get(null);
    }

    public final boolean f() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.a();
    }

    public final void onStop() {
        this.g.clear();
    }

    public final com.bytedance.android.livesdk.gift.model.n I(Long r7) {
        if (r7 == null) goto L22;
        r7.longValue();
        com.bytedance.android.livesdk.gift.model.g0 r1 = q(r7.longValue());
        if (r1 == null) goto L22;
        com.bytedance.android.livesdk.gift.model.p r2 = r1.getDiyGiftToolbarInfo();
        if (r2 == null) goto L22;
        String r8 = ay1.b.h().get(String.valueOf(r7.longValue()));
        if (r8 == null) goto L12;
        Long r9 = StringsKt.toLongOrNull(r8);
    L13:
        com.bytedance.android.livesdk.gift.model.n r3 = (com.bytedance.android.livesdk.gift.model.n) CollectionsKt.getOrNull(r2.getForceIndexCards(), 0);
        if (r3 != null) goto L16;
        return null;
    L16:
        if (r9 != null) goto L18;
    L21:
        return r3;
    L18:
        if (r3.getStartTime() > r9.longValue()) goto L21;
        return null;
    L12:
        r9 = null;
    L22:
        return null;
    }

    public final com.bytedance.android.livesdk.gift.model.g0 q(long r2) {
        Map<Long, BehaviorSubject<sh6.b<p1>>> r0 = this.e;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        BehaviorSubject r3 = (BehaviorSubject) r1.get(Long.valueOf(r2));
        if (r3 == null) goto L9;
        sh6.b r4 = (sh6.b) r3.getValue();
        if (r4 == null) goto L9;
        p1 r5 = (p1) sh6.c.b(r4);
        if (r5 == null) goto L9;
        return r5.getDecoded();
    L9:
        return null;
    }

    public final Long s(long r2) {
        Map<Long, Long> r0 = this.f;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        return (Long) r1.get(Long.valueOf(r2));
    }

    public final Single<kc6.j0> updateGiftExtraInfoById(final List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "giftIds");
        return Single.create(new AnonymousClass1(this, r2));
    }

    public final JsonObject w(int r8) {
        wz1.a r0 = this.q;
        long r2 = r8;
        k2 r1 = r0.c.get(Long.valueOf(r2));
        String r4 = null;
        if (r1 == null) goto L5;
        byte[] r3 = r1.getRawPB();
    L6:
        k2 r5 = r0.c.get(Long.valueOf(r2));
        if (r5 == null) goto L9;
        JsonObject r6 = r5.getRawJson();
    L10:
        wz1.b r7 = r0.d;
        if (r7 == null) goto L13;
        String r9 = r7.b;
    L14:
        if (r7 == null) goto L17;
        r4 = r7.a;
    L17:
        if (r0.b == true) goto L21;
        JsonObject r10 = (JsonObject) ((LinkedHashMap) r0.a).get(Integer.valueOf(r8));
        if (r10 != null) goto L23;
        JsonObject r11 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c.a(r3, r6, r9, r4);
        r0.a.put(Integer.valueOf(r8), r11);
        return r11;
    L23:
        return r10;
    L21:
        r0.b = false;
        JsonObject r13 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c.a(r3, r6, r9, r4);
        r0.a.put(Integer.valueOf(r8), r13);
        return r13;
    L13:
        r9 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void Y(long r4, p1 r6) {
        this.i.put(Long.valueOf(r4), Boolean.TRUE);
        Map<Long, BehaviorSubject<sh6.b<p1>>> r0 = this.e;
        Long r5 = Long.valueOf(r4);
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Object r7 = r1.get(r5);
        if (r7 != null) goto L5;
        r7 = BehaviorSubject.createDefault(sh6.c.a(r6));
        r1.put(r5, r7);
    L5:
        ((BehaviorSubject) r7).onNext(sh6.c.a(r6));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0
    public final void c(List r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "giftIds");
        Intrinsics.checkNotNullParameter("send gift", "source");
        Observable r5 = Observable.timer(r4, TimeUnit.SECONDS);
        GiftManagerKt r6 = GiftManagerKt.z;
        boolean r0 = this.j;
        r6.getClass();
        RxUtilKt.c(r5.compose(GiftManagerKt.E(r0)).subscribe(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.c(this, r3)), this.g);
    }

    public final l1 o(int r3, long r4) {
        if (r3 != 0) goto L5;
        return null;
    L5:
        com.bytedance.android.livesdk.gift.model.g0 r5 = q(r4);
        if (r5 == null) goto L22;
        List<l1> r6 = r5.getGiftBuffInfos();
        if (r6 == null) goto L22;
        Iterator<T> r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L18;
        Object r8 = r7.next();
        if (((l1) r8).getBuffLevel() != r3) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L11;
    L19:
        l1 r9 = (l1) r8;
        if (r9 == null) goto L22;
        return r9;
    L15:
        r1 = false;
        goto L16
    L18:
        r8 = null;
    L22:
        return null;
    }

    public GiftExtraRepo(i12.e r3, com.bytedance.android.livesdk.revenue.service.message.f r4, wz1.a r5) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "revUplinkCompat");
        Intrinsics.checkNotNullParameter(r5, "pageExtraDataSource");
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new CompositeDisposable();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        a r6 = v;
        r6.getClass();
        ReadOnlyProperty r7 = s;
        KProperty[] r8 = a.a;
        this.j = ((Boolean) r7.getValue(r6, r8[0])).booleanValue();
        this.k = ((Boolean) u.getValue(r6, r8[2])).booleanValue();
        com.bytedance.android.anya.internal.k r9 = i(new x0(null, false, 7)).a();
        KProperty[] r10 = r;
        this.l = r9.a(r10[0]);
        this.m = i(MapsKt.emptyMap()).a().a(r10[1]);
        this.n = L();
    }

    public final void S(final List<Long> r13, final n1 r14, final String r15) {
        final ArrayList r6 = new ArrayList(r13);
        if (r14 == null) goto L62;
        Iterator<T> r0 = r14.getGiftExtras().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        p1 r1 = (p1) r0.next();
        com.bytedance.android.livesdk.gift.model.g0 r2 = r1.getDecoded();
        r6.remove(Long.valueOf(r2.getGiftId()));
        Y(r2.getGiftId(), r1);
        q3 r3 = r2.getSubscribeGiftPackInfo();
        if (r3 == null) goto L10;
        this.f.put(Long.valueOf(r3.getRelatedGiftId()), Long.valueOf(r2.getGiftId()));
    L10:
        Iterator<T> r4 = r2.getGiftBuffInfos().iterator();
    L12:
        if (r4.hasNext() == false) goto L6;
        this.f.put(Long.valueOf(((l1) r4.next()).getBuffGiftId()), Long.valueOf(r2.getGiftId()));
        goto L12
    L14:
        boolean r7 = nz1.a.h().c();
        GiftPanelBizBoostUtils.E.getClass();
        final boolean r8 = GiftPanelBizBoostUtils.A.W7();
        if (r7 == false) goto L17;
        if (r8 == false) goto L17;
    L18:
        Iterator r5 = r6.iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        Long r9 = (Long) r5.next();
        this.h.remove(r9);
        Y(r9.longValue(), null);
        goto L20
    L22:
        wz1.a r10 = this.q;
        Map<Long, ? extends k2> r11 = MapsKt.toMap(r14.getPageExtra());
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "newData");
        boolean r16 = true;
        r10.b = true;
        r10.c = r11;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.D0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[80])).booleanValue() == false) goto L46;
        i12.m.a r17 = i12.m.e2;
        i12.d r18 = r17.a();
        if (r18 == null) goto L27;
        Object r19 = com.bytedance.android.scope.m.e.d(r18, GiftDialogStateDataStore.class);
    L28:
        GiftDialogStateDataStore r20 = (GiftDialogStateDataStore) r19;
        if (r20 == null) goto L37;
        long r21 = r20.w();
        if (r10.c.get(Long.valueOf(r21)) == null) goto L35;
        if (r11.get(Long.valueOf(r21)) != null) goto L35;
    L38:
        if (r16 == false) goto L53;
        i12.d r23 = r17.a();
        if (r23 == null) goto L42;
        Object r24 = com.bytedance.android.scope.m.e.d(r23, GiftDialogStateDataStore.class);
    L43:
        GiftDialogStateDataStore r25 = (GiftDialogStateDataStore) r24;
        if (r25 == null) goto L53;
        r25.t.onNext(r25.n());
        goto L53
    L42:
        r24 = null;
    L53:
        if (r7 == false) goto L55;
        g("giftExtraProcessResult", new GiftExtraRepo$processResult$$inlined$let$lambda$2(r8, r14, this, r6, r13, r15));
        return;
    L55:
        uz1.a r110 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r110 == null) goto L64;
        r110.a(new RefreshGiftExtra(r13, false, 2, null));
        return;
    L64:
        return;
    L35:
        if (r11.get(Long.valueOf(r21)) != null) goto L38;
    L37:
        r16 = false;
        goto L38
    L27:
        r19 = null;
        goto L28
    L46:
        i12.d r26 = i12.m.e2.a();
        if (r26 == null) goto L49;
        Object r27 = com.bytedance.android.scope.m.e.d(r26, GiftDialogStateDataStore.class);
    L50:
        GiftDialogStateDataStore r28 = (GiftDialogStateDataStore) r27;
        if (r28 == null) goto L53;
        r28.t.onNext(r28.n());
        goto L53
    L49:
        r27 = null;
    L17:
        g("sortSceneConfig", new GiftExtraRepo$processResult$$inlined$let$lambda$1(r14, this, r6, r13, r15));
        goto L18
    }

    public final void b0(final long r2, p1 r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "extraInfo");
        Y(r2, r4);
        if (nz1.a.h().c() == false) goto L5;
        g("updateExtra", new GiftExtraRepo$updateExtra$1(this, r2, r5));
        return;
    L5:
        uz1.a r6 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r6 == null) goto L10;
        r6.a(new RefreshGiftExtra(CollectionsKt.listOf(Long.valueOf(r2)), r5));
        return;
    }

    public final long y(long r8, long r10, ArrayList<e3> r13) {
        if (r13 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return 0;
    L11:
        ArrayList<String> r1 = ay1.b.b().get(String.valueOf(r8));
        if (r1 == null) goto L25;
        Iterator<T> r2 = r1.iterator();
    L15:
        if (r2.hasNext() == false) goto L25;
        String r3 = (String) r2.next();
        sz1.a r4 = new sz1.a();
        r4.convertFromString(r3);
        if (gz1.c.h(gz1.c.g(r4), r13) == false) goto L15;
        if (r4.getTotalDiamonds() <= 0) goto L15;
        if (r4.isNewCard() == false) goto L24;
        long r9 = r4.getTotalDiamonds();
    L54:
        return r9 + r10;
    L24:
        return r4.getTotalDiamonds();
    L25:
        com.bytedance.android.livesdk.gift.model.g0 r5 = q(r8);
        if (r5 == null) goto L37;
        com.bytedance.android.livesdk.gift.model.p r6 = r5.getDiyGiftToolbarInfo();
        if (r6 == null) goto L37;
        List<com.bytedance.android.livesdk.gift.model.n> r7 = r6.getCards();
        if (r7 == null) goto L37;
        Iterator<T> r11 = r7.iterator();
    L33:
        if (r11.hasNext() == false) goto L37;
        com.bytedance.android.livesdk.gift.model.n r14 = (com.bytedance.android.livesdk.gift.model.n) r11.next();
        if (gz1.c.h(gz1.c.g(r14), r13) == false) goto L33;
        r9 = r14.getTotalDiamonds();
    L37:
        i12.e r15 = i12.o.b();
        if (r15 == null) goto L40;
        Object r16 = com.bytedance.android.scope.m.e.d(r15, com.bytedance.android.livesdk.gift.platform.core.scope.service.m0.class);
    L41:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.m0 r17 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.m0) r16;
        if (r17 == null) goto L55;
        ArrayList<sz1.a> r18 = r17.a.get(String.valueOf(r8));
        if (r18 == null) goto L55;
        Iterator<T> r19 = r18.iterator();
    L47:
        if (r19.hasNext() == false) goto L55;
        sz1.a r20 = (sz1.a) r19.next();
        if (gz1.c.h(gz1.c.g(r20), r13) == false) goto L47;
        if (r20.getTotalDiamonds() <= 0) goto L47;
        r9 = r20.getTotalDiamonds();
    L55:
        return 0;
    L40:
        r16 = null;
        goto L41
    L4:
        if (r13.isEmpty() == true) goto L7;
        r0 = false;
        goto L9
    }

    public final void U(List<Long> r10, final String r11, IBaseUser r13, final Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "giftIds");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r14, "callback");
        StringBuilder r0 = new StringBuilder("syncGiftExtra source=");
        r0.append(r11);
        r0.append(" giftIds=");
        r0.append(r10);
        r0.append(" receiver=");
        if (r13 == null) goto L5;
        String r1 = r13.getIdString();
    L6:
        r0.append(r1);
        jy0.b.d("ttlive_gift_extra", r0.toString());
        X(this, r11, r10, r13, null, new GiftExtraRepo$syncGiftExtra$1(this, r11, r14), 8);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Observable<kc6.q> observeGiftExtraInfoById(i57.a r9, long r10, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "callContext");
        i57.e r0 = i57.e.f;
        r0.getClass();
        if (((BytesContentType) r9.a((i57.a.a) i57.e.d.getValue(r0, i57.e.a[2]))) != BytesContentType.PROTOBUF) goto L5;
        boolean r6 = true;
    L6:
        Map<Long, BehaviorSubject<sh6.b<p1>>> r11 = this.e;
        Long r1 = Long.valueOf(r10);
        LinkedHashMap r15 = (LinkedHashMap) r11;
        Object r2 = r15.get(r1);
        if (r2 != null) goto L10;
        r2 = BehaviorSubject.createDefault(sh6.a.a);
        r15.put(r1, r2);
    L10:
        return ((BehaviorSubject) r2).map(new c(this, r10, r13, r14, r6));
    L5:
        r6 = false;
        goto L6
    }

    public final JsonOrBytesJvm F(long r6, p1 r8, String r9, String r10, boolean r11) {
        byte[] r0 = null;
        if (r11 == false) goto L10;
        if (r8 == null) goto L6;
        byte[] r13 = r8.getRawPB();
    L7:
        if (r13 == null) goto L10;
        Intrinsics.checkNotNullParameter(r13, "rawBytes");
        return new JsonOrBytesJvm(null, r13);
    L6:
        r13 = null;
    L10:
        if (r8 == null) goto L13;
        JsonObject r14 = r8.getRawJson();
        if (r14 == null) goto L13;
    L26:
        if (r14 == null) goto L29;
    L35:
        if (r8 == null) goto L38;
        r0 = r8.getRawPB();
    L38:
        return new JsonOrBytesJvm(r14, r0);
    L29:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L34;
        if (r8 == null) goto L34;
        com.bytedance.android.livesdk.gift.model.g0 r7 = r8.getDecoded();
        if (r7 == null) goto L34;
        r14 = GsonProtectorUtils.toJsonTree(l97.a.a, r7);
    L34:
        r14 = null;
    L13:
        if (r8 == null) goto L15;
        byte[] r15 = r8.getRawPB();
    L16:
        if (r8 == null) goto L18;
        JsonObject r1 = r8.getRawJson();
    L20:
        if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.i).get(Long.valueOf(r6)), Boolean.TRUE)) == false) goto L25;
        JsonObject r2 = (JsonObject) ((LinkedHashMap) this.h).get(Long.valueOf(r6));
        if (r2 != null) goto L24;
        r14 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c.a(r15, r1, r9, r10);
        this.h.put(Long.valueOf(r6), r14);
        goto L26
    L24:
        r14 = r2;
        goto L26
    L25:
        this.i.put(Long.valueOf(r6), Boolean.FALSE);
        r14 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c.a(r15, r1, r9, r10);
        this.h.put(Long.valueOf(r6), r14);
        goto L26
    L18:
        r1 = null;
        goto L20
    L15:
        r15 = null;
        goto L16
    }

    public final Observable<List<com.bytedance.android.livesdk.gift.model.g0>> a(String r19, String r20, String r21, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r19, "giftIds");
        Intrinsics.checkNotNullParameter(r20, "toRoomId");
        Intrinsics.checkNotNullParameter(r21, "fromRoomId");
        Intrinsics.checkNotNullParameter(r23, "fromAnchorId");
        Intrinsics.checkNotNullParameter(r24, "toUserId");
        tz0.b r5 = tz0.b.a;
        uz0.e r6 = new uz0.e();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "$this$beforeConfigureRequest");
        Map r7 = ((uz0.a) r6).b;
        Intrinsics.checkNotNullParameter(r7, "queriesMap");
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r20 == null) goto L5;
        r7.put("to_room_id", r20);
    L5:
        Map r1 = r6.e;
        Intrinsics.checkNotNullParameter(r1, "fieldsMap");
        Intrinsics.checkNotNullParameter("gift_ids", "$this$setTo");
        if (r19 == null) goto L8;
        r1.put("gift_ids", r19);
    L8:
        Intrinsics.checkNotNullParameter("to_open_id", "$this$setTo");
        if (r24 == null) goto L11;
        r1.put("to_open_id", r24);
    L11:
        Intrinsics.checkNotNullParameter("from_open_id", "$this$setTo");
        if (r23 == null) goto L14;
        r1.put("from_open_id", r23);
    L14:
        Intrinsics.checkNotNullParameter("from_room_id", "$this$setTo");
        if (r21 == null) goto L17;
        r1.put("from_room_id", r21);
    L17:
        Intrinsics.checkNotNullParameter(r6, "$this$afterConfigureRequest");
        return com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(r5.b(), "/webcast/gift/extra/", TypesJVMKt.getJavaType(Reflection.typeOf(o1.class)), Extra.class, ((uz0.a) r6).d, ((uz0.a) r6).a, ((uz0.a) r6).b, ((uz0.a) r6).c, r6.e, r6.f, r6.g).map(b.a);
    }

    public static void X(GiftExtraRepo r34, String r35, List r36, IBaseUser r37, Function1 r38, Function2 r39, int r40) {
        if ((r40 & 2) == 0) goto L5;
        List r16 = null;
    L7:
        if ((r40 & 4) == 0) goto L9;
        IBaseUser r17 = null;
    L11:
        if ((r40 & 8) == 0) goto L13;
        Function1 r18 = GiftExtraRepo$syncGiftExtra$2.INSTANCE;
    L14:
        r34.getClass();
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        LinkedHashSet r13 = new LinkedHashSet();
        if (r0 == null) goto L198;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L199;
        StringBuilder r14 = new StringBuilder();
        List r2 = r16;
        if (r2 != null) goto L21;
    L24:
        boolean r3 = true;
    L26:
        if (r3 == false) goto L50;
        GiftManagerKt.z.getClass();
        Iterator r4 = GiftManagerKt.t().iterator();
    L29:
        if (r4.hasNext() == false) goto L62;
        List<h1> r6 = ((w1) r4.next()).getGifts();
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L32:
        if (r8.hasNext() == false) goto L39;
        Object r9 = r8.next();
        if ((((h1) r9).getReqExtraType() & 1) != 1) goto L36;
        boolean r10 = true;
    L37:
        if (r10 == false) goto L32;
        r7.add(r9);
        goto L32
    L36:
        r10 = false;
        goto L37
    L39:
        Iterator r11 = r7.iterator();
    L41:
        if (r11.hasNext() == false) goto L29;
        h1 r15 = (h1) r11.next();
        if (r14.length() != 0) goto L45;
        boolean r19 = true;
    L46:
        if (r19 == false) goto L48;
        r14.append(r15.getId());
    L49:
        r13.add(Long.valueOf(r15.getId()));
        goto L41
    L48:
        r14.append(",");
        r14.append(r15.getId());
        goto L49
    L45:
        r19 = false;
    L62:
        if (r14.length() != 0) goto L64;
        boolean r5 = true;
    L65:
        if (r5 == false) goto L67;
        r39.invoke(CollectionsKt.toList(r13), vh7.f.c(o1.class));
        return;
    L67:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r20 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r20 == null) goto L71;
        IBaseUser r21 = r20.a;
        if (r21 == null) goto L71;
    L72:
        if (r21 != null) goto L74;
        r21 = r1.getOwner();
    L74:
        i12.e r23 = i12.o.b();
        if (r23 == null) goto L77;
        Object r24 = com.bytedance.android.scope.m.e.d(r23, GiftReceiverRepoService.class);
    L78:
        GiftReceiverRepoService r25 = (GiftReceiverRepoService) r24;
        if (r25 == null) goto L84;
        if (r21 == null) goto L82;
        Intrinsics.checkNotNullParameter(r21, "$this$secUidExt");
        String r26 = r21.getCastSecUid();
    L83:
        IBaseUser r27 = GiftReceiverRepoService.g(r25, r26, null, 2);
    L85:
        if (r27 == null) goto L87;
        boolean r28 = true;
    L88:
        Ref.LongRef r110 = new Ref.LongRef();
        if (r21 == null) goto L91;
        long r29 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r21);
    L92:
        r110.element = r29;
        if (r21 == null) goto L96;
        String r30 = r21.getIdString();
        if (r30 == null) goto L96;
    L101:
        if (r30 != null) goto L103;
        r30 = BuildConfig.FLAVOR;
    L103:
        IBaseUser r31 = r1.getOwner();
        if (r31 == null) goto L107;
        String r33 = r31.getIdString();
        if (r33 == null) goto L107;
    L108:
        Ref.LongRef r41 = new Ref.LongRef();
        r41.element = r1.getId();
        i12.e r43 = i12.o.b();
        if (r43 == null) goto L111;
        Object r44 = com.bytedance.android.scope.m.e.d(r43, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L112:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r45 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r44;
        if (r45 != null) goto L115;
    L117:
        boolean r46 = false;
    L118:
        if (r28 == true) goto L120;
    L123:
        String r47 = BuildConfig.FLAVOR;
    L124:
        com.bytedance.android.livesdk.revenue.message.m r48 = r34.p.get();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.o0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[65])).booleanValue() == false) goto L128;
        if (r48 == null) goto L128;
        boolean r111 = true;
    L129:
        Intrinsics.checkNotNullParameter(r35, "originSource");
        if (StringsKt.contains$default(r35, "giftPanelOpen", false, 2, null) == false) goto L133;
        String r49 = "gift_panel_open";
    L154:
        String r50 = GsonProtectorUtils.toJson(GsonHelper.get(), new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.a(r49));
        if (r111 == false) goto L164;
        LinkedHashMap r51 = new LinkedHashMap();
        r51.put("to_room_id", String.valueOf(r110.element));
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("gift_ids", r14.toString());
        r112.put("to_open_id", r30);
        r112.put("from_open_id", r33);
        r112.put("from_room_id", String.valueOf(r41.element));
        r112.put("source", r50);
        LinkedHashMap r53 = new LinkedHashMap();
        r53.putAll(r51);
        r53.putAll(r112);
        com.bytedance.android.live.revenue.core.util.f.a(bd6.c.class).s2("/webcast/gift/extra/", r53);
        i12.e r54 = i12.o.b();
        if (r54 == null) goto L159;
        Object r55 = com.bytedance.android.scope.m.e.d(r54, xz1.c.class);
    L160:
        xz1.c r56 = (xz1.c) r55;
        if (r56 == null) goto L163;
        r56.f();
        Unit r57 = Unit.INSTANCE;
    L163:
        Intrinsics.checkNotNull(r48);
        Observable r58 = r48.a(r51, r112);
    L180:
        long r113 = System.currentTimeMillis();
        if (r34.k == false) goto L183;
        Observable r59 = r58.subscribeOn(Schedulers.io());
    L184:
        boolean r60 = r111;
        List r61 = r16;
        IBaseUser r114 = r17;
        RxUtilKt.c(r59.subscribe(new d(r14, r110, r41, r113, r60, r34, r61, r13, r39, r114, r35, r18), new e(r14, r110, r41, r113, r60, r34, r61, r13, r39, r114, r35, r18)), r34.g);
        return;
    L183:
        GiftManagerKt r63 = GiftManagerKt.z;
        boolean r64 = r34.j;
        r63.getClass();
        r59 = r58.compose(GiftManagerKt.E(r64));
        goto L184
    L159:
        r55 = null;
        goto L160
    L164:
        tz0.b r65 = tz0.b.a;
        uz0.e r115 = new uz0.e();
        r65.getClass();
        Intrinsics.checkNotNullParameter(r115, "$this$beforeConfigureRequest");
        Map r66 = ((uz0.a) r115).b;
        Intrinsics.checkNotNullParameter(r66, "queriesMap");
        String r67 = Long.valueOf(r110.element).toString();
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r67 == null) goto L167;
        r66.put("to_room_id", r67);
    L167:
        Map r68 = r115.e;
        Intrinsics.checkNotNullParameter(r68, "fieldsMap");
        String r69 = r14.toString();
        Intrinsics.checkNotNullParameter("gift_ids", "$this$setTo");
        if (r69 == null) goto L170;
        r68.put("gift_ids", r69);
    L170:
        Intrinsics.checkNotNullParameter("to_open_id", "$this$setTo");
        r68.put("to_open_id", r30);
        Intrinsics.checkNotNullParameter("from_open_id", "$this$setTo");
        r68.put("from_open_id", r33);
        String r70 = Long.valueOf(r41.element).toString();
        Intrinsics.checkNotNullParameter("from_room_id", "$this$setTo");
        if (r70 == null) goto L173;
        r68.put("from_room_id", r70);
    L173:
        Intrinsics.checkNotNullParameter("video_linkmic_room_id", "$this$setTo");
        if (r47 == null) goto L176;
        r68.put("video_linkmic_room_id", r47);
    L176:
        Intrinsics.checkNotNullParameter("source", "$this$setTo");
        if (r50 == null) goto L179;
        r68.put("source", r50);
    L179:
        Intrinsics.checkNotNullParameter(r115, "$this$afterConfigureRequest");
        r58 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/gift/extra/", TypesJVMKt.getJavaType(Reflection.typeOf(o1.class)), Extra.class, ((uz0.a) r115).d, ((uz0.a) r115).a, ((uz0.a) r115).b, ((uz0.a) r115).c, r115.e, r115.f, r115.g);
        goto L180
    L133:
        if (StringsKt.contains$default(r35, "updateGiftList", false, 2, null) == false) goto L136;
        r49 = "update_extra_by_message";
        goto L154
    L136:
        if (StringsKt.contains$default(r35, "setSelected", false, 2, null) == false) goto L139;
        r49 = "select_gift";
        goto L154
    L139:
        if (StringsKt.contains$default(r35, "changeReceiver", false, 2, null) == false) goto L142;
        r49 = "change_receiver";
        goto L154
    L142:
        if (StringsKt.contains$default(r35, "incrementalUpdateList", false, 2, null) == false) goto L145;
        r49 = "update_extra_by_incremental_operation";
        goto L154
    L145:
        if (StringsKt.contains$default(r35, "handleSelectedGift", false, 2, null) == false) goto L148;
        r49 = "vs_select_gift";
        goto L154
    L148:
        if (StringsKt.contains$default(r35, "updateExtraIfNeeded", false, 2, null) == false) goto L151;
        r49 = "update_extra_when_panel_closed";
        goto L154
    L151:
        if (StringsKt.contains$default(r35, "touchDownPreload", false, 2, null) == false) goto L153;
        r49 = "touch_down_preload";
        goto L154
    L153:
        r49 = CardLockInfo.sUNKNOWN;
    L128:
        r111 = false;
        goto L129
    L120:
        if (r46 == false) goto L122;
        r110.element = r1.getId();
        jy0.b.d("NewVideoLinkAnchor", "syncExtra change isAllMicScene=true, " + r110.element);
        goto L123
    L122:
        r47 = String.valueOf(r41.element);
        r41.element = r110.element;
        jy0.b.d("NewVideoLinkAnchor", "syncExtra change isAllMicScene=false, " + r30 + ", " + r110.element + 65292 + r47);
        r33 = r30;
        goto L124
    L115:
        if (r45.j() != true) goto L117;
        r46 = true;
        goto L118
    L111:
        r44 = null;
    L107:
        r33 = BuildConfig.FLAVOR;
    L96:
        IBaseUser r71 = r1.getOwner();
        if (r71 == null) goto L99;
        r30 = r71.getIdString();
        goto L101
    L99:
        r30 = null;
        goto L101
    L91:
        r29 = r1.getId();
        goto L92
    L87:
        r28 = false;
        goto L88
    L82:
        r26 = null;
        goto L83
    L84:
        r27 = null;
        goto L85
    L77:
        r24 = null;
    L71:
        r21 = r17;
        goto L72
    L64:
        r5 = false;
        goto L65
    L50:
        Iterator r73 = r16.iterator();
    L52:
        if (r73.hasNext() == false) goto L62;
        long r74 = ((Number) r73.next()).longValue();
        if (r14.length() != 0) goto L56;
        boolean r75 = true;
    L57:
        if (r75 == false) goto L59;
        r14.append(r74);
    L60:
        r13.add(Long.valueOf(r74));
        goto L52
    L59:
        r14.append(",");
        r14.append(r74);
        goto L60
    L56:
        r75 = false;
        goto L57
    L21:
        if (r2.isEmpty() == true) goto L24;
        r3 = false;
        goto L26
    L199:
        return;
    L198:
        return;
    L13:
        r18 = r38;
        goto L14
    L9:
        r17 = r37;
        goto L11
    L5:
        r16 = r36;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    public static final void k(GiftExtraRepo r2, List r3, StringBuilder r4, String r5, long r6, long r8, o1 r10, Throwable r11, boolean r13) {
        r2.getClass();
        if (r13 == false) goto L22;
        List r7 = r3;
        if (r7 != null) goto L8;
    L11:
        boolean r9 = true;
    L12:
        if (r9 == false) goto L15;
        r4 = "0";
    L15:
        if (r11 == null) goto L17;
        jy0.b.a("GiftExtraRepo", "syncGiftExtraFailed, giftIds = " + r4 + ", source = " + r5 + ", toRoomId = " + r6 + ", fromRoomId = " + r8 + ", throwable.msg = " + com.bytedance.android.live.revenue.common.q0.a(r11) + ", throwable.errorcode = " + com.bytedance.android.live.revenue.common.r0.a(r11));
        return;
    L17:
        if (r10 == null) goto L21;
        jy0.b.a("GiftExtraRepo", "syncGiftExtraSuccess, giftIds = " + r4 + ", source = " + r5 + ", toRoomId = " + r6 + ", fromRoomId = " + r8 + ", giftExtraListModel = " + GsonProtectorUtils.toJson(GsonHelper.get(), r10));
        return;
    L21:
        return;
    L8:
        if (r7.isEmpty() == true) goto L11;
        r9 = false;
        goto L12
    }

    public static final void n(GiftExtraRepo r13, List r14, StringBuilder r15, String r16, long r17, long r18, long r20, Throwable r23, boolean r24) {
        r13.getClass();
        long r3 = System.currentTimeMillis() - r20;
        List r0 = r14;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.T(r16, r3, "0", r17, r18, r23, r24);
        return;
    L11:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.T(r16, r3, r15.toString(), r17, r18, r23, r24);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
