package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import android.text.TextUtils;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l3;
import com.bytedance.android.livesdk.gift.model.p1;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.model.z2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datalayer.GiftMVIMarketingUseCase;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datalayer.GiftMVISeriesUseCase;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickLynxSeriesCard;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.w0;
import com.bytedance.android.livesdk.gift.platform.core.utils.b0;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.ComboStatus;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.SelectStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftDialogStateDataStore extends BaseMVIDataStore<GiftDialogStateDataStore> implements com.bytedance.android.scope.o, oc6.o {
    public static final /* synthetic */ KProperty[] I = null;
    public final e1 A;
    public final GiftListSortDataStore B;
    public final yz0.g C;
    public final i12.e D;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f E;
    public final u1 F;
    public final w0 G;
    public final GiftReceiverRepoService H;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final ReadOnlyProperty g;
    public final ReadOnlyProperty h;
    public final ReadOnlyProperty i;
    public final BehaviorSubject<h1> j;
    public final BehaviorSubject<Integer> k;
    public final BehaviorSubject<Integer> l;
    public final BehaviorSubject<ComboStatus> m;
    public final BehaviorSubject<Long> n;
    public final com.bytedance.android.anya.t o;
    public final BehaviorSubject<Boolean> p;
    public final BehaviorSubject<Boolean> q;
    public int r;
    public int s;
    public final BehaviorSubject<lc6.l> t;
    public final GiftMVIMarketingUseCase u;
    public final GiftMVISeriesUseCase v;
    public final GiftExtraRepo w;
    public final OpenDialogService x;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.i y;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.h z;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ GiftDialogStateDataStore a;
        public final /* synthetic */ long b;

        public a(GiftDialogStateDataStore r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            Intrinsics.checkNotNullParameter((sh6.a) r5, "it");
            lc6.d r6 = new lc6.d();
            GiftListSortDataStore r0 = this.a.B;
            long r1 = this.b;
            if (r0.o() == false) goto L6;
            r0.e.contains(Long.valueOf(r1));
        L6:
            r6.a();
            this.a.B.getClass();
            r6.b();
            if (this.a.B.n(this.b) == false) goto L11;
            GiftDialogStateDataStore r2 = this.a;
            GiftExtraRepo r3 = r2.w;
            r2.B.getClass();
            z1 r4 = r3.J();
            if (r4 == null) goto L11;
            IGiftMarketingInfo r7 = r4.getGiftMarketingInfo();
        L12:
            r6.c(r7);
            return r6;
        L11:
            r7 = null;
            goto L12
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r4) {
            Long r5 = (Long) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            lc6.s r0 = new lc6.s();
            r0.b(r5.longValue());
            return r0;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            Boolean r3 = (Boolean) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            lc6.i r0 = new lc6.i();
            r0.a(r3.booleanValue());
            return r0;
        }
    }

    public static final class d<T, R> implements Function {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r2) {
            h1 r3 = (h1) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            lc6.j r0 = new lc6.j();
            r0.b(r3);
            return r0;
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ GiftDialogStateDataStore a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ i57.a d;

        public e(GiftDialogStateDataStore r1, String r2, String r3, i57.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r13) {
            h1 r14 = (h1) r13;
            Intrinsics.checkNotNullParameter(r14, "it");
            Class r0 = lc6.k.class.getAnnotation(JsonAdapter.class).value();
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
            if (r4 == null) goto L27;
            lc6.k r5 = (lc6.k) r4;
            r5.setGift(r14);
            GiftExtraRepo r6 = this.a.w;
            long r7 = r14.getId();
            String r8 = this.b;
            String r9 = this.c;
            i57.a r15 = this.d;
            i57.e r10 = i57.e.f;
            r10.getClass();
            if (((BytesContentType) r15.a((i57.a.a) i57.e.d.getValue(r10, i57.e.a[2]))) != BytesContentType.PROTOBUF) goto L17;
            boolean r11 = true;
        L18:
            Map<Long, BehaviorSubject<sh6.b<p1>>> r16 = r6.e;
            LinkedHashMap r17 = (LinkedHashMap) r16;
            BehaviorSubject r18 = (BehaviorSubject) r17.get(Long.valueOf(r7));
            if (r18 == null) goto L23;
            sh6.b r19 = (sh6.b) r18.getValue();
            if (r19 == null) goto L23;
            p1 r110 = (p1) sh6.c.b(r19);
        L24:
            r5.m(r6.F(r7, r110, r8, r9, r11));
            return r5;
        L23:
            r110 = null;
            goto L24
        L17:
            r11 = false;
            goto L18
        L27:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.ObserveSelectedInfoResponse");
        }
    }

    public static final class f<T, R> implements Function {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r2) {
            ComboStatus r3 = (ComboStatus) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            lc6.a r0 = new lc6.a();
            r0.a(r3);
            return r0;
        }
    }

    public static final class g<T, R> implements Function {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object apply(Object r2) {
            Boolean r3 = (Boolean) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            lc6.m r0 = new lc6.m();
            r0.a(r3.booleanValue());
            return r0;
        }
    }

    static {
        I = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftDialogStateDataStore.class, "selectGift", "getSelectGift()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDialogStateDataStore.class, "selectPageType", "getSelectPageType()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDialogStateDataStore.class, "currentReceiver", "getCurrentReceiver()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDialogStateDataStore.class, "selectGiftExtra", "getSelectGiftExtra()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDialogStateDataStore.class, "selectStatus", "getSelectStatus()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(GiftDialogStateDataStore.class, "_selectGiftExtra", "get_selectGiftExtra()Lcom/bytedance/android/livesdk/gift/model/GiftExtraInfo;", 0))};
    }

    public final com.bytedance.android.anya.t<GiftDialogStateDataStore, h1> o() {
        return (com.bytedance.android.anya.t) this.e.getValue(this, I[0]);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final com.bytedance.android.anya.t<GiftDialogStateDataStore, g0> s() {
        return (com.bytedance.android.anya.t) this.h.getValue(this, I[3]);
    }

    public final com.bytedance.android.anya.t<GiftDialogStateDataStore, Integer> y() {
        return (com.bytedance.android.anya.t) this.f.getValue(this, I[1]);
    }

    public final boolean f() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.a();
    }

    public final lc6.b getLogCommonParams() {
        HashMap r0 = new HashMap();
        r0.put("gift_panel_session_id", this.G.a);
        lc6.b r1 = new lc6.b();
        r1.a(r0);
        return r1;
    }

    public final lc6.l n() {
        Integer r0 = (Integer) this.k.getValue();
        if (r0 != null) goto L5;
        r0 = 0;
    L5:
        int r1 = r0.intValue();
        lc6.l r2 = new lc6.l();
        w1 r3 = this.y.U(r1);
        String r4 = null;
        if (r3 == null) goto L8;
        x2 r5 = r3.getPageInfo();
    L9:
        r2.b(r5);
        r2.d(r1);
        if (r3 == null) goto L12;
        String r6 = r3.getPageName();
    L13:
        r2.c(r6);
        r2.a(this.w.w(r1));
        if (r3 == null) goto L20;
        py.k r7 = r3.getReceiversModBg();
        if (r7 == null) goto L20;
        List r8 = r7.getUrls();
        if (r8 == null) goto L20;
        String r9 = (String) ListProtector.get(r8, 0);
    L21:
        r2.e(r9);
        if (r3 == null) goto L28;
        py.k r10 = r3.getReceiversLongModBg();
        if (r10 == null) goto L28;
        List r11 = r10.getUrls();
        if (r11 == null) goto L28;
        r4 = (String) ListProtector.get(r11, 0);
    L28:
        r2.f(r4);
        return r2;
    L20:
        r9 = null;
        goto L21
    L12:
        r6 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    }

    public final Observable<lc6.s> observeCurrentSelectStatus() {
        return this.n.map(b.a);
    }

    public final Observable<lc6.i> observeSearchVisible() {
        return this.q.map(c.a);
    }

    public final Observable<lc6.j> observeSelectedGift() {
        return this.j.map(d.a);
    }

    public final Observable<lc6.a> observeSmallGiftCombo() {
        return this.m.map(f.a);
    }

    public final Observable<lc6.m> observeTopViewVisible() {
        return this.p.map(g.a);
    }

    public final h1 q() {
        return (h1) this.j.getValue();
    }

    public final int w() {
        Integer r0 = (Integer) this.k.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final void F(List<Long> r4) {
        Intrinsics.checkNotNullParameter(r4, "refreshGiftId");
        h1 r0 = (h1) this.j.getValue();
        if (r0 == null) goto L5;
        long r1 = r0.getId();
    L7:
        if (r4.contains(Long.valueOf(r1)) == false) goto L23;
        final g0 r5 = this.w.q(r1);
        if (r5 == null) goto L12;
        l3 r2 = r5.getSeriesGift();
        if (r2 == null) goto L12;
    L13:
        this.v.k(r2);
        if (r5 == null) goto L24;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.A.L8() == true) goto L18;
    L21:
        g("refreshSelectGiftExtra", new GiftDialogStateDataStore$refreshSelectGiftExtra$1(this, r5));
        return;
    L18:
        if (((g0) this.o.getValue(this, I[5])) != r5) goto L21;
        jy0.b.d("ttlive_gift_panel", "intercept same extraInfo " + r5);
        return;
    L24:
        return;
    L12:
        r2 = (l3) vh7.f.c(l3.class);
        goto L13
    L23:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    public final void R(ComboStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        if (((ComboStatus) this.m.getValue()) == r2) goto L6;
        this.m.onNext(r2);
        return;
    }

    public final void S(SelectStatus r4) {
        Intrinsics.checkNotNullParameter(r4, "status");
        this.n.onNext(Long.valueOf(r4.getStatus()));
    }

    public final void changeDialogHeight(int r2) {
        this.l.onNext(Integer.valueOf(r2));
    }

    public final void dismissGiftDialog(String r2) {
        this.x.a(r2);
    }

    public final boolean k(int r2) {
        w1 r3 = this.y.U(r2);
        if (r3 == null) goto L7;
        z2 r4 = r3.getLynxConfig();
        if (r4 == null) goto L7;
        String r5 = r4.getSchema();
    L9:
        if (r5 != null) goto L11;
    L14:
        boolean r6 = true;
    L16:
        return !r6;
    L11:
        if (r5.length() == 0) goto L14;
        r6 = false;
    L7:
        r5 = null;
        goto L9
    }

    public final void locateGiftById(long r3) {
        uz1.a r0 = b0.b();
        if (r0 == null) goto L6;
        r0.a(new ClickLynxSeriesCard(r3));
        return;
    }

    public final Observable<lc6.d> observeClientAIInfoById(long r3) {
        return BehaviorSubject.createDefault(sh6.a.a).map(new a(this, r3));
    }

    public final lc6.r requirePanelGiftList(List<Long> r8) {
        Intrinsics.checkNotNullParameter(r8, "giftIds");
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r2 = r9.next();
        long r3 = ((Number) r2).longValue();
        if (this.z.vb(this.E.b).contains(Long.valueOf(r3)) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        Iterator r10 = r1.iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        long r4 = ((Number) r10.next()).longValue();
        h1 r5 = this.A.findGiftById(r4);
        if (r5 == null) goto L10;
        r0.add(r5);
        goto L10
    L14:
        lc6.r r11 = new lc6.r();
        r11.a(r0);
        return r11;
    }

    public final void sendGiftSpeedLog(Map<String, Double> r14) {
        if (r14 == null) goto L43;
        i12.d r0 = i12.m.e2.a();
        String r1 = null;
        if (r0 == null) goto L6;
        Object r2 = com.bytedance.android.scope.m.e.d(r0, GiftPanelMonitorService.class);
    L7:
        GiftPanelMonitorService r3 = (GiftPanelMonitorService) r2;
        if (r3 == null) goto L53;
        Intrinsics.checkNotNullParameter(r14, "params");
        Iterator<T> r4 = r14.entrySet().iterator();
        if (r4.hasNext() == true) goto L12;
        Object r5 = null;
    L21:
        Map.Entry r6 = (Map.Entry) r5;
        if (r6 == null) goto L24;
        r1 = (String) r6.getKey();
    L24:
        Iterator<String> r7 = r14.keySet().iterator();
    L26:
        if (r7.hasNext() == false) goto L54;
        String r8 = r7.next();
        Double r9 = r14.get(r8);
        if (r9 == null) goto L30;
        long r10 = (long) r9.doubleValue();
    L32:
        if (r10 <= 0) goto L26;
        long r11 = r10 - r3.h;
        long r13 = r10 - r3.b;
        if (r11 <= 0) goto L38;
        r3.s.put(r8 + "_load_duration", String.valueOf(r11));
    L38:
        if (r13 <= 0) goto L41;
        r3.s.put(r8 + "_all_duration", String.valueOf(r13));
    L41:
        if (TextUtils.equals(r8, r1) == false) goto L26;
        r3.s.put("lynx_complete_show_page_type", r8);
        r3.s.put("lynx_complete_show_duration", String.valueOf(r11));
        r3.s.put("lynx_complete_show_all_duration", String.valueOf(r13));
        goto L26
    L30:
        r10 = 0;
        goto L32
    L54:
        return;
    L12:
        r5 = r4.next();
        if (r4.hasNext() == false) goto L21;
        double r15 = ((Number) ((Map.Entry) r5).getValue()).doubleValue();
    L16:
        Object r16 = r4.next();
        double r17 = ((Number) ((Map.Entry) r16).getValue()).doubleValue();
        if (Double.compare(r15, r17) >= 0) goto L20;
        r5 = r16;
        r15 = r17;
    L20:
        if (r4.hasNext() == true) goto L16;
    L53:
        return;
    L6:
        r2 = null;
        goto L7
    }

    public final void sendLog(final List<lc6.t> r3) {
        GiftPanelBizBoostUtils.E.getClass();
        final boolean r0 = GiftPanelBizBoostUtils.b().f9();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(r0, new AnonymousClass1(this, r3, r0));
    }

    public final void L(final int r3, int r4) {
        this.k.onNext(Integer.valueOf(r3));
        this.s = r4;
        this.t.onNext(n());
        g("selectTypeChange", new GiftDialogStateDataStore$selectTypeChange$1(this, r3));
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.e.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.e.a[0])).booleanValue() == true) goto L6;
        I(null, -1, false);
        return;
    }

    public final Observable<lc6.l> observeSelectedPageInfo(String r3, String r4) {
        GiftExtraRepo r0 = this.w;
        wz1.b r1 = new wz1.b(r4, r3);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "pageExtraDefinition");
        wz1.a r5 = r0.q;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r1, "info");
        r5.d = r1;
        return this.t;
    }

    public static /* synthetic */ void J(GiftDialogStateDataStore r1, h1 r2, int r3) {
        r1.I(r2, r3, false);
    }

    public final void I(final h1 r7, final int r8, boolean r9) {
        Long r0 = null;
        if (r7 == null) goto L5;
        Long r1 = Long.valueOf(r7.getId());
    L6:
        h1 r2 = (h1) this.j.getValue();
        if (r2 == null) goto L10;
        r0 = Long.valueOf(r2.getId());
    L10:
        if (Intrinsics.areEqual(r1, r0) == false) goto L12;
        return;
    L12:
        GiftExtraRepo r3 = this.w;
        h1 r4 = (h1) this.j.getValue();
        long r5 = 0;
        if (r4 == null) goto L15;
        long r6 = r4.getId();
    L16:
        final g0 r10 = r3.q(r6);
        BehaviorSubject<Long> r11 = this.x.e;
        if (r7 == null) goto L19;
        r5 = r7.getId();
    L19:
        r11.onNext(Long.valueOf(r5));
        g("selectGiftChanged", new GiftDialogStateDataStore$selectGiftChanged$1(this, r8, r7, r10));
        GiftMVIMarketingUseCase r13 = this.u;
        long r14 = -1;
        if (r7 == null) goto L22;
        long r15 = r7.getId();
    L23:
        r13.n(r15, r9);
        GiftMVISeriesUseCase r16 = this.v;
        if (r7 == null) goto L26;
        r14 = r7.getId();
    L26:
        r16.n(r14);
        return;
    L22:
        r15 = -1;
        goto L23
    L15:
        r6 = 0;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final Observable<lc6.k> observeSelectedInfo(i57.a r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "callContext");
        return this.j.map(new e(this, r4, r5, r3));
    }

    public GiftDialogStateDataStore(GiftMVIMarketingUseCase r2, GiftMVISeriesUseCase r3, GiftExtraRepo r4, OpenDialogService r5, com.bytedance.android.livesdk.gift.platform.core.giftlist.i r6, com.bytedance.android.livesdk.gift.platform.core.giftlist.h r7, e1 r8, GiftListSortDataStore r9, yz0.g r10, i12.e r11, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r13, u1 r14, w0 r15, GiftReceiverRepoService r16) {
        Intrinsics.checkNotNullParameter(r2, "marketingUseCase");
        Intrinsics.checkNotNullParameter(r3, "seriesUseCase");
        Intrinsics.checkNotNullParameter(r4, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r5, "openDialogService");
        Intrinsics.checkNotNullParameter(r6, "giftListRepository");
        Intrinsics.checkNotNullParameter(r7, "giftListPanelRepository");
        Intrinsics.checkNotNullParameter(r8, "giftListService");
        Intrinsics.checkNotNullParameter(r9, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r10, "roomDataService");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r13, "receiverService");
        Intrinsics.checkNotNullParameter(r14, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r15, "giftPanelLogServiceKmp");
        Intrinsics.checkNotNullParameter(r16, "receiverRepoService");
        this.u = r2;
        this.v = r3;
        this.w = r4;
        this.x = r5;
        this.y = r6;
        this.z = r7;
        this.A = r8;
        this.B = r9;
        this.C = r10;
        this.D = r11;
        this.E = r13;
        this.F = r14;
        this.G = r15;
        this.H = r16;
        com.bytedance.android.anya.internal.k r17 = i(vh7.f.c(h1.class)).a();
        KProperty[] r18 = I;
        this.e = r17.a(r18[0]);
        this.f = i(-1).a().a(r18[1]);
        this.g = i(vh7.f.c(IBaseUser.class)).a().a(r18[2]);
        this.h = i(vh7.f.c(g0.class)).a().a(r18[3]);
        this.i = i(SelectStatus.IDLE).a().a(r18[4]);
        this.j = BehaviorSubject.create();
        this.k = BehaviorSubject.create();
        this.l = BehaviorSubject.create();
        this.m = BehaviorSubject.create();
        this.n = BehaviorSubject.create();
        this.o = s();
        this.p = BehaviorSubject.create();
        this.q = BehaviorSubject.create();
        this.r = -1;
        this.t = BehaviorSubject.createDefault(n());
    }
}
