package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import android.text.format.DateUtils;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.configmodel.k0;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.q0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopicShowFrom;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollGuideStatus;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import oc6.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftTopicDataStore extends BaseMVIDataStore<GiftTopicDataStore> implements com.bytedance.android.scope.o, b0 {
    public static final /* synthetic */ KProperty[] D = null;
    public final e1 A;
    public final GiftSearchDataStore B;
    public final GiftTabDataStore C;
    public final CompositeDisposable e;
    public final ReadOnlyProperty f;
    public final ReadOnlyProperty g;
    public final ReadOnlyProperty h;
    public final ReadOnlyProperty i;
    public final com.bytedance.android.anya.t j;
    public final com.bytedance.android.anya.t k;
    public final com.bytedance.android.anya.t l;
    public final com.bytedance.android.anya.t m;
    public final BehaviorSubject<Map<String, Object>> n;
    public final BehaviorSubject<Long> o;
    public final ReadOnlyProperty p;
    public final ReadOnlyProperty q;
    public final com.bytedance.android.anya.t r;
    public final com.bytedance.android.anya.t s;
    public long t;
    public Pair<Long, Long> u;
    public long v;
    public String w;
    public long x;
    public boolean y;
    public final q0 z;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r4) {
            Long r5 = (Long) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            oc6.d r0 = new oc6.d();
            r0.a(r5.longValue());
            return r0;
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ GiftTopicDataStore a;

        public b(GiftTopicDataStore r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Intrinsics.checkNotNullParameter((Map) r5, "it");
            lc6.n r6 = new lc6.n();
            r6.e((List) this.a.S().getSecond());
            d2 r0 = (d2) this.a.R().getSecond();
            if (r0 == null) goto L5;
            long r1 = r0.getId();
        L6:
            r6.c(r1);
            r6.b(((Number) this.a.S().getFirst()).longValue());
            GiftTopicDataStore r2 = this.a;
            r6.d(((GiftTopicShowFrom) r2.m.getValue(r2, GiftTopicDataStore.D[7])).getFrom());
            return r6;
        L5:
            r1 = -1;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftTopicDataStore a;

        public c(GiftTopicDataStore r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            Long r14 = (Long) r13;
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == true) goto L30;
            GiftTopicDataStore r15 = this.a;
            r15.getClass();
            GiftTopicDataStore.j0();
            if (((Boolean) ay1.b.y0.getValue(null, ay1.b.a[91])).booleanValue() == true) goto L32;
            List<? extends o2> r0 = r15.z.c;
            if (r0 == null) goto L31;
            Iterator<T> r1 = r0.iterator();
        L11:
            if (r1.hasNext() == false) goto L33;
            o2 r2 = (o2) r1.next();
            long r3 = r2.getRelatedTopicId();
            com.bytedance.tools.kcp.spongepreference.runtime.a r5 = ay1.b.x0;
            KProperty[] r6 = ay1.b.a;
            Integer r4 = (Integer) ((HashMap) r5.getValue(null, r6[90])).get(Long.valueOf(r3));
            if (r4 != null) goto L16;
            r4 = 0;
        L16:
            if (r4.intValue() >= com.bytedance.android.livesdk.gift.platform.core.h.l().d()) goto L18;
            boolean r7 = true;
        L19:
            if (r7 == false) goto L11;
            r15.o(ScrollGuideStatus.SHOW, r2);
            HashMap r16 = (HashMap) r5.getValue(null, r6[90]);
            Long r8 = Long.valueOf(r2.getRelatedTopicId());
            Integer r9 = (Integer) ((HashMap) r5.getValue(null, r6[90])).get(Long.valueOf(r2.getRelatedTopicId()));
            if (r9 != null) goto L23;
            r9 = 0;
        L23:
            r16.put(r8, Integer.valueOf(r9.intValue() + 1));
            return;
        L18:
            r7 = false;
            goto L19
        L33:
            return;
        L31:
            return;
        L32:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ GiftTopicDataStore a;

        public d(GiftTopicDataStore r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            vz1.j r5 = (vz1.j) r4;
            GiftTopicDataStore r0 = this.a;
            if (r0.y == false) goto L6;
            r0.y = false;
            r0.e0(r5.b);
            return;
        }
    }

    static {
        D = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "currentShowTopicList", "getCurrentShowTopicList()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "currentSelectTopic", "getCurrentSelectTopic()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "currentTopicShowFrom", "getCurrentTopicShowFrom()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "topShowStatus", "getTopShowStatus()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "_currentShowTopicList", "get_currentShowTopicList()Lkotlin/Pair;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "_topShowStatus", "get_topShowStatus()Z", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "_currentSelectedTopic", "get_currentSelectedTopic()Lkotlin/Pair;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "_currentTopicShowFrom", "get_currentTopicShowFrom()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopicShowFrom;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "interactPageScrollGuideShowStatus", "getInteractPageScrollGuideShowStatus()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "interactPageScrollGuideInfo", "getInteractPageScrollGuideInfo()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "_interactPageScrollGuideShowStatus", "get_interactPageScrollGuideShowStatus()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ScrollGuideStatus;", 0)), Reflection.property1(new PropertyReference1Impl(GiftTopicDataStore.class, "_interactPageScrollGuideInfo", "get_interactPageScrollGuideInfo()Lcom/bytedance/android/livesdk/gift/model/IScrollPageNameInfo;", 0))};
    }

    public final com.bytedance.android.anya.t<GiftTopicDataStore, Pair<Long, List<d2>>> F() {
        return (com.bytedance.android.anya.t) this.f.getValue(this, D[0]);
    }

    public final com.bytedance.android.anya.t<GiftTopicDataStore, GiftTopicShowFrom> I() {
        return (com.bytedance.android.anya.t) this.h.getValue(this, D[2]);
    }

    public final com.bytedance.android.anya.t<GiftTopicDataStore, Boolean> L() {
        return (com.bytedance.android.anya.t) this.i.getValue(this, D[3]);
    }

    public final Pair<Long, d2> R() {
        return (Pair) this.l.getValue(this, D[6]);
    }

    public final Pair<Long, List<d2>> S() {
        return (Pair) this.j.getValue(this, D[4]);
    }

    public final boolean U() {
        return ((Boolean) this.k.getValue(this, D[5])).booleanValue();
    }

    public final com.bytedance.android.anya.t<GiftTopicDataStore, Pair<Long, d2>> w() {
        return (com.bytedance.android.anya.t) this.g.getValue(this, D[1]);
    }

    public static void j0() {
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = ay1.b.w0;
        KProperty[] r1 = ay1.b.a;
        if (DateUtils.isToday(((Number) r0.getValue(null, r1[89])).longValue()) == true) goto L6;
        long r5 = System.currentTimeMillis();
        r0.setValue(null, r1[89], Long.valueOf(r5));
        HashMap r2 = new HashMap();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        ay1.b.x0.setValue(null, r1[90], r2);
        ay1.b.y0.setValue(null, r1[91], Boolean.FALSE);
        return;
    }

    public final o2 J() {
        long r0 = this.t;
        if (r0 == 0) goto L10;
        if (r0 > 0) goto L6;
    L8:
        return null;
    L6:
        if (System.currentTimeMillis() >= (this.t + k0.a(com.bytedance.android.livesdk.gift.platform.core.h.l()))) goto L8;
    L10:
        return (o2) this.s.getValue(this, D[11]);
    }

    public final void b0() {
        g(null, new GiftTopicDataStore$resetSelectTopic$1(this));
    }

    public final void clickSearch() {
        this.B.k();
    }

    public final boolean f() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.a();
    }

    public final Observable<oc6.d> observeCurrentSelectTopic() {
        return this.o.map(a.a);
    }

    public final Observable<lc6.n> observeTopicDataChange() {
        return this.n.map(new b(this));
    }

    public final void onStop() {
        String r0 = this.w;
        KProperty[] r1 = ay1.b.a;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = ay1.b.h;
        KProperty[] r3 = ay1.b.a;
        r2.setValue(null, r3[7], r0);
        long r4 = this.x;
        ay1.b.g.setValue(null, r3[6], Long.valueOf(r4));
        this.e.clear();
    }

    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.d() == false) goto L9;
        j0();
        long r0 = com.bytedance.android.livesdk.gift.platform.core.h.l().c();
        if (r0 <= 0) goto L9;
        RxUtilKt.c(Observable.timer(r0, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this.e);
    L9:
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = ay1.b.h;
        KProperty[] r2 = ay1.b.a;
        this.w = (String) r1.getValue(null, r2[7]);
        this.x = ((Number) ay1.b.g.getValue(null, r2[6])).longValue();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.b() == true) goto L12;
        return;
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().j() == true) goto L17;
        RxUtilKt.c(this.C.i.subscribe(new d(this)), this.e);
        return;
    }

    public final String y() {
        d2 r0 = (d2) R().getSecond();
        if (r0 == null) goto L6;
        String r1 = r0.getName();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    public static boolean Y(int r1) {
        if (r1 == 1) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.business.b.f().i() == true) goto L7;
        return true;
    }

    public static final Map k(GiftTopicDataStore r4) {
        r4.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("topics", r4.S().getSecond());
        r0.put("page_type", r4.S().getFirst());
        d2 r1 = (d2) r4.R().getSecond();
        if (r1 == null) goto L5;
        long r2 = r1.getId();
    L6:
        r0.put("selected_topic_id", Long.valueOf(r2));
        r0.put("show_from", ((GiftTopicShowFrom) r4.m.getValue(r4, D[7])).getFrom());
        return r0;
    L5:
        r2 = -1;
        goto L6
    }

    public final void X(int r5) {
        Pair<Long, Long> r1 = null;
        if (r5 != 15) goto L8;
        o2 r0 = J();
        if (r0 == null) goto L7;
        r1 = new Pair(Long.valueOf(r5), Long.valueOf(r0.getRelatedTopicId()));
    L7:
        this.u = r1;
        return;
    L8:
        this.u = null;
    }

    public final void clickOrder(final int r3) {
        b0();
        final GiftTabDataStore r0 = this.C;
        r0.getClass();
        r0.g("updateOrder", new GiftTabDataStore$updateSort$1(r0, r3));
    }

    public final void e0(final long r2) {
        this.v = r2;
        g("selectTabChange", new GiftTopicDataStore$selectTabChange$1(this, r2));
    }

    public final void q(boolean r4) {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == true) goto L5;
        return;
    L5:
        final boolean r0 = Y((int) this.v);
        if ((!((Collection) S().getSecond()).isEmpty()) == false) goto L9;
        if (r4 == false) goto L9;
        g(null, new GiftTopicDataStore$changeTopicShowStatus$1(this, r0));
        return;
    L9:
        g(null, new GiftTopicDataStore$changeTopicShowStatus$2(this, r0));
    }

    public final void s(final long r4) {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.g() == true) goto L6;
        return;
    L6:
        if (((Number) S().getFirst()).longValue() == r4) goto L8;
        return;
    L8:
        if ((!((Collection) S().getSecond()).isEmpty()) == false) goto L12;
        g(null, new GiftTopicDataStore$doubelClickTab$1(this, r4));
        return;
    }

    public static final void n(GiftTopicDataStore r3, GiftTopicShowFrom r4) {
        r3.getClass();
        mz0.n r5 = new mz0.n();
        Map r0 = r5.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        String r6 = r4.getFrom();
        Intrinsics.checkNotNullParameter("show_from", "key");
        Intrinsics.checkNotNullParameter(r6, "value");
        r0.put("show_from", r6);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r1 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r1, "pageSourceLog");
        List r2 = r7.a;
        ArrayList r8 = (ArrayList) r2;
        r8.add(r1.a);
        List r9 = r5.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r11 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r11).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((f80.a) r13).w3("livesdk_gift_find_cluster_bar_show", r5.a, r5.b);
    }

    public final void o(final ScrollGuideStatus r4, final o2 r5) {
        Intrinsics.checkNotNullParameter(r4, "status");
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.f() == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.d() == true) goto L9;
        return;
    L9:
        if (r4 != ScrollGuideStatus.END) goto L11;
        this.t = System.currentTimeMillis();
    L11:
        com.bytedance.android.anya.t r0 = this.r;
        KProperty[] r1 = D;
        if (r4 == ((ScrollGuideStatus) r0.getValue(this, r1[10]))) goto L14;
    L15:
        g(null, new GiftTopicDataStore$changeScrollGuideState$1(this, r4, r5));
        return;
    L14:
        if ((!Intrinsics.areEqual(r5, (o2) this.s.getValue(this, r1[11]))) == true) goto L15;
    }

    public final void selectTopic(final long r1, long r3) {
        g(null, new AnonymousClass1(this, r1));
    }

    public GiftTopicDataStore(q0 r5, e1 r6, GiftSearchDataStore r7, GiftTabDataStore r8) {
        Intrinsics.checkNotNullParameter(r5, "topicRepo");
        Intrinsics.checkNotNullParameter(r6, "giftListService");
        Intrinsics.checkNotNullParameter(r7, "giftSearchDataStore");
        Intrinsics.checkNotNullParameter(r8, "tabDataStore");
        this.z = r5;
        this.A = r6;
        this.B = r7;
        this.C = r8;
        this.e = new CompositeDisposable();
        com.bytedance.android.anya.internal.k r9 = i(new Pair(-1L, CollectionsKt.emptyList())).a();
        KProperty[] r10 = D;
        this.f = r9.a(r10[0]);
        this.g = i(new Pair(-1L, null)).a().a(r10[1]);
        GiftTopicShowFrom r11 = GiftTopicShowFrom.UNKNOWN;
        this.h = i(r11).a().a(r10[2]);
        this.i = i(Boolean.FALSE).a().a(r10[3]);
        this.j = F();
        this.k = L();
        this.l = w();
        this.m = I();
        this.n = BehaviorSubject.create();
        this.o = BehaviorSubject.create();
        com.bytedance.android.anya.internal.h r0 = i(ScrollGuideStatus.IDLE).a().a(r10[8]);
        this.p = r0;
        com.bytedance.android.anya.internal.h r13 = j(null).a().a(r10[9]);
        this.q = r13;
        this.r = (com.bytedance.android.anya.t) r0.getValue(this, r10[8]);
        this.s = (com.bytedance.android.anya.t) r13.getValue(this, r10[9]);
        this.w = r11.getFrom();
        this.y = true;
        BehaviorSubject.create();
    }
}
