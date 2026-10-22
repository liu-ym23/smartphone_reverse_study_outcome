package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.annie.param.GsonList;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.l3;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.x1;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDefaultLocationInfoDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftScrollDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTabDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.m;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.u;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDynamicPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabChangeEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopicShowFrom;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ModifyDialogHeightEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowOperation;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowTopicView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateTopViewSource;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListPanelRepository;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftMostlyUsedDataStore;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import lc6.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDynamicPanelViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftDynamicPanelState, GiftAction> implements o {
    public boolean A;
    public final Set<BaseMVIDataStore<?>> B;
    public final e1 C;
    public final GiftListRepository D;
    public final GiftDialogStateDataStore E;
    public final GiftExtraRepo F;
    public final u G;
    public final m H;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f I;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k J;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.a K;
    public final GiftListSortDataStore L;
    public final GiftMVICarnivalDataStore M;
    public final GiftListPanelRepository N;
    public final GiftPanelMonitorService O;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.h P;
    public final GiftTopicDataStore Q;
    public final GiftScrollDataStore R;
    public final PropListService S;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i T;
    public final GiftSearchDataStore U;
    public final GiftMostlyUsedDataStore V;
    public final GiftTabDataStore W;
    public final GiftDefaultLocationInfoDataStore X;
    public HashMap<Integer, Boolean> u;
    public boolean v;
    public final Lazy w;
    public final CompositeDisposable x;
    public h1 y;
    public LocateGiftInfo z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GiftMVIDynamicPanelViewModel a;

        public a(GiftMVIDynamicPanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Integer r8 = (Integer) r7;
            if (v.e() == false) goto L31;
            boolean r1 = true;
            if (r8.intValue() != 5) goto L10;
            if (r8.intValue() == 26) goto L10;
        L13:
            if (this.a.s1(r8.intValue()) == true) goto L28;
            GiftMVIDynamicPanelViewModel r0 = this.a;
            if (r8.intValue() == 17) goto L17;
            r0.getClass();
        L22:
            r1 = false;
        L23:
            if (r1 == true) goto L28;
            if (r8.intValue() == 26) goto L28;
            if (this.a.E.k(r8.intValue()) == true) goto L28;
            return;
        L17:
            if (r0.h1() == false) goto L22;
            if (r0.V.y() == false) goto L22;
        L28:
            this.a.t1(false, UpdateTopViewSource.OTHERS);
            return;
        L10:
            if (this.a.h1() == true) goto L13;
            this.a.K0(new ShowOperation(true));
            goto L13
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GiftMVIDynamicPanelViewModel a;

        public b(GiftMVIDynamicPanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            lc6.j r5 = (lc6.j) r4;
            GiftExtraRepo r0 = this.a.F;
            h1 r1 = r5.a();
            if (r1 == null) goto L5;
            long r2 = r1.getId();
        L6:
            g0 r3 = r0.q(r2);
            if (v.e() == true) goto L27;
            if (r3 != null) goto L10;
        L22:
            GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r6 == null) goto L41;
            com.bytedance.live.datacontext.k<Boolean> r7 = r6.getGiftBannerShowEvent();
            if (r7 == null) goto L42;
            r7.post(Boolean.TRUE);
            return;
        L42:
            return;
        L41:
            return;
        L10:
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r3.getBannerGiftInfo()) == false) goto L22;
            h1 r8 = r5.a();
            if (r8 == null) goto L22;
            String r9 = r8.getBannerScheme();
            if (r9 == null) goto L22;
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r9) != true) goto L22;
            GiftContext r10 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r10 == null) goto L38;
            com.bytedance.live.datacontext.k<Boolean> r11 = r10.getGiftBannerShowEvent();
            if (r11 == null) goto L39;
            r11.post(Boolean.FALSE);
            return;
        L39:
            return;
        L38:
            return;
        L27:
            if (r3 != null) goto L35;
            h1 r13 = r5.a();
            if (r13 == null) goto L44;
            List<h0> r14 = r13.getGiftGroupList();
            if (r14 != null) goto L33;
            return;
        L33:
            if ((!r14.isEmpty()) == true) goto L35;
            return;
        L44:
            return;
        L35:
            if (this.a.h1() == true) goto L47;
            this.a.K0(new ShowOperation(true));
            return;
        L47:
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftMVIDynamicPanelViewModel a;

        public c(GiftMVIDynamicPanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            n r4 = (n) r3;
            if (v.a() == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r4.a(), GiftTopicShowFrom.UNKNOWN.getFrom()) == false) goto L8;
            this.a.K0(new ShowTopicView(false));
            return;
        L8:
            this.a.K0(new ShowTopicView(true));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ GiftMVIDynamicPanelViewModel a;

        public d(GiftMVIDynamicPanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Integer r6 = (Integer) r5;
            if (v.e() == true) goto L8;
            if (this.a.U.s() == true) goto L8;
            return;
        L8:
            if (this.a.h1() == false) goto L10;
        L19:
            this.a.P.k();
            if (((List) com.bytedance.android.livesdk.gift.platform.core.h.s0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[69])).contains(Integer.valueOf(this.a.P.k())) == false) goto L23;
            this.a.e1(UpdateTopViewSource.OTHERS);
            return;
        L23:
            if (this.a.P.k() == 0) goto L25;
            this.a.t1(true, UpdateTopViewSource.OTHERS);
            return;
        L25:
            this.a.t1(false, UpdateTopViewSource.OTHERS);
            return;
        L10:
            if (this.a.U.s() == true) goto L19;
            if (r6 != null) goto L14;
        L18:
            this.a.K0(new ShowOperation(true));
            return;
        L14:
            if (r6.intValue() != 0) goto L18;
            if (this.a.E.w() != 5) goto L18;
            this.a.K0(new ShowOperation(false));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ GiftMVIDynamicPanelViewModel a;

        public e(GiftMVIDynamicPanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.K0(new GiftTabChangeEffect(((vz1.j) r3).b));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ GiftMVIDynamicPanelViewModel a;

        public f(GiftMVIDynamicPanelViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.K0(new ModifyDialogHeightEffect(((Integer) r3).intValue()));
        }
    }

    public final boolean h1() {
        return ((Boolean) this.w.getValue()).booleanValue();
    }

    public final void onStop() {
        this.x.clear();
    }

    public final void onStart() {
        if (v.a() == true) goto L6;
        return;
    L6:
        if (this.T.c.a == null) goto L8;
        boolean r0 = true;
    L9:
        this.A = r0;
        com.bytedance.revenue.platform.api.core.rx.f.a(this.E.k.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.x);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.E.observeSelectedGift().subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.x);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.Q.observeTopicDataChange().subscribeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this.x);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.P.h.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)), this.x);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.W.i.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new e(this)), this.x);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.E.l.subscribeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)), this.x);
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.B;
    }

    public final MVIState F(l0 r19) {
        Intrinsics.checkNotNullParameter(r19, "$this$createState");
        LinkedHashMap r4 = new LinkedHashMap();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L200
        r4.put("available_diamonds", Long.valueOf(this.G.k()));     // Catch: Throwable -> L200
        r4.put("consume_level", Integer.valueOf(ay1.b.u()));     // Catch: Throwable -> L200
        Gson r7 = GsonHelper.getDefault();     // Catch: Throwable -> L200
        m r8 = this.H;     // Catch: Throwable -> L200
        t r9 = r8.i;     // Catch: Throwable -> L200
        KProperty[] r10 = m.n;     // Catch: Throwable -> L200
        JsonElement r11 = r7.toJsonTree((PayGrade) r9.getValue(r8, r10[4]));     // Catch: Throwable -> L200
        Object r13 = null;
        if ((r11 instanceof JsonObject) == true) goto L6;
        r11 = null;
    L6:
        JsonObject r14 = (JsonObject) r11;     // Catch: Throwable -> L200
        if (r14 == null) goto L9;
        GsonMap r15 = UtilsKt.i(r14);     // Catch: Throwable -> L200
    L10:
        r4.put("pay_grade", r15);     // Catch: Throwable -> L200
        m r16 = this.H;     // Catch: Throwable -> L200
        String r17 = (String) r16.h.getValue(r16, r10[3]);     // Catch: Throwable -> L200
        if (r17 != null) goto L13;
        r17 = BuildConfig.FLAVOR;
    L13:
        r4.put("touch_positions_str", r17);     // Catch: Throwable -> L200
        LocateGiftInfo r18 = this.X.a;     // Catch: Throwable -> L200
        this.z = r18;     // Catch: Throwable -> L200
        com.bytedance.android.livesdk.gift.platform.core.model.j r20 = this.L.i;     // Catch: Throwable -> L200
        if (r20 == null) goto L16;
        List<w1> r21 = r20.c;     // Catch: Throwable -> L200
    L17:
        List<w1> r23 = r21;     // Catch: Throwable -> L200
        boolean r24 = false;
        if (r23 != null) goto L20;
    L23:
        boolean r25 = true;
    L24:
        if (r25 == true) goto L41;
        com.bytedance.android.livesdk.gift.platform.core.model.j r26 = this.L.i;     // Catch: Throwable -> L200
        if (r26 == null) goto L41;
        List<w1> r27 = r26.c;     // Catch: Throwable -> L200
        if (r27 == null) goto L41;
        Iterator<T> r28 = r27.iterator();     // Catch: Throwable -> L200
    L31:
        if (r28.hasNext() == false) goto L40;
        Object r110 = r28.next();     // Catch: Throwable -> L200
        if (((w1) r110).getDisplay() == false) goto L31;
        w1 r111 = (w1) r110;     // Catch: Throwable -> L200
        if (r111 == null) goto L41;
        List<h1> r29 = r111.getGifts();     // Catch: Throwable -> L200
        if (r29 == null) goto L41;
        h1 r30 = (h1) CollectionsKt.firstOrNull(r29);     // Catch: Throwable -> L200
    L42:
        long r112 = 0;
        if (r18.getTargetGiftId() == (-1)) goto L45;
        long r113 = r18.getTargetGiftId();     // Catch: Throwable -> L200
    L59:
        this.y = this.C.findGiftById(r113);     // Catch: Throwable -> L200
        LinkedHashMap r31 = new LinkedHashMap();     // Catch: Throwable -> L200
        h1 r114 = this.y;     // Catch: Throwable -> L200
        if (r114 == null) goto L62;
        r31.put("default_location_gift", UtilsKt.i(GsonHelper.getDefault().toJsonTree(r114).getAsJsonObject()));     // Catch: Throwable -> L200
    L62:
        r31.put("default_location_buff", Integer.valueOf(r18.getBuffLevel()));     // Catch: Throwable -> L200
        r31.put("default_card_name", r18.getCardName());     // Catch: Throwable -> L200
        r31.put("default_jump_schema", r18.getJumpSchema());     // Catch: Throwable -> L200
        r4.put("location_info", UtilsKt.i(GsonHelper.getDefault().toJsonTree(r31).getAsJsonObject()));     // Catch: Throwable -> L200
        GiftExtraRepo r33 = this.F;     // Catch: Throwable -> L200
        h1 r115 = this.y;     // Catch: Throwable -> L200
        if (r115 == null) goto L65;
        long r116 = r115.getId();     // Catch: Throwable -> L200
    L66:
        g0 r34 = r33.q(r116);     // Catch: Throwable -> L200
        GiftExtraRepo r117 = this.F;     // Catch: Throwable -> L200
        h1 r118 = this.y;     // Catch: Throwable -> L200
        if (r118 == null) goto L69;
        long r119 = r118.getId();     // Catch: Throwable -> L200
    L70:
        JsonObject r120 = (JsonObject) ((LinkedHashMap) r117.h).get(Long.valueOf(r119));     // Catch: Throwable -> L200
        if (r120 != null) goto L75;
        if (r34 == null) goto L74;
        r120 = GsonHelper.getDefault().toJsonTree(r34).getAsJsonObject();     // Catch: Throwable -> L200
        goto L75
    L74:
        r120 = null;
    L75:
        if (r120 == null) goto L77;
        r4.put("extra_object", r120.toString());     // Catch: Throwable -> L200
    L77:
        w1 r121 = this.D.U(r18.getTargetPageType());     // Catch: Throwable -> L200
        LinkedHashMap r122 = new LinkedHashMap();     // Catch: Throwable -> L200
        r122.put("page_type", Integer.valueOf(r18.getTargetPageType()));     // Catch: Throwable -> L200
        if (r121 == null) goto L82;
        String r123 = r121.getPageName();     // Catch: Throwable -> L200
        if (r123 == null) goto L82;
        r122.put("page_name", r123);     // Catch: Throwable -> L200
    L82:
        if (r121 == null) goto L86;
        x2 r124 = r121.getPageInfo();     // Catch: Throwable -> L200
        if (r124 == null) goto L86;
        r122.put("page_info", r124);     // Catch: Throwable -> L200
    L86:
        if (r121 == null) goto L94;
        py.k r125 = r121.getReceiversModBg();     // Catch: Throwable -> L200
        if (r125 == null) goto L94;
        List r126 = r125.getUrls();     // Catch: Throwable -> L200
        if (r126 == null) goto L94;
        String r127 = (String) CollectionsKt.getOrNull(r126, 0);     // Catch: Throwable -> L200
        if (r127 == null) goto L94;
        r122.put("receiver_background_img", r127);     // Catch: Throwable -> L200
    L94:
        if (r121 == null) goto L102;
        py.k r128 = r121.getReceiversLongModBg();     // Catch: Throwable -> L200
        if (r128 == null) goto L102;
        List r129 = r128.getUrls();     // Catch: Throwable -> L200
        if (r129 == null) goto L102;
        String r130 = (String) CollectionsKt.getOrNull(r129, 0);     // Catch: Throwable -> L200
        if (r130 == null) goto L102;
        r122.put("receiver_long_background_url", r130);     // Catch: Throwable -> L200
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L200
    L102:
        r4.put("current_page_Info", UtilsKt.i(GsonHelper.getDefault().toJsonTree(r122).getAsJsonObject()));     // Catch: Throwable -> L200
        Gson r132 = GsonHelper.getDefault();     // Catch: Throwable -> L200
        oc6.h0 r133 = (oc6.h0) this.W.e.getValue();     // Catch: Throwable -> L200
        if (r133 == null) goto L105;
        List r134 = r133.a();     // Catch: Throwable -> L200
    L106:
        JsonArray r135 = r132.toJsonTree(r134).getAsJsonArray();     // Catch: Throwable -> L200
        Intrinsics.checkNotNullParameter(r135, "<this>");     // Catch: Throwable -> L200
        r4.put("tab_list", new GsonList(r135));     // Catch: Throwable -> L200
        JsonObject r35 = this.F.w(r18.getTargetPageType());     // Catch: Throwable -> L200
        if (r35 == null) goto L109;
        r4.put("page_extra", r35.toString());     // Catch: Throwable -> L200
    L109:
        r4.put("show_recipient_entrance", Boolean.valueOf(this.J.g()));     // Catch: Throwable -> L200
        r4.put("current_receiver", UtilsKt.i(GsonHelper.getDefault().toJsonTree(this.I.a).getAsJsonObject()));     // Catch: Throwable -> L200
        r4.put("current_receiver_type", Integer.valueOf(this.I.b.getValue()));     // Catch: Throwable -> L200
        lc6.h r36 = (lc6.h) this.I.e.getValue();     // Catch: Throwable -> L200
        if (r36 == null) goto L114;
        List r37 = r36.a();     // Catch: Throwable -> L200
        if (r37 == null) goto L114;
        JsonArray r38 = GsonHelper.getDefault().toJsonTree(r37).getAsJsonArray();     // Catch: Throwable -> L200
        Intrinsics.checkNotNullParameter(r38, "<this>");     // Catch: Throwable -> L200
        r4.put("receiver_list", new GsonList(r38));     // Catch: Throwable -> L200
    L114:
        r4.put("fans_club_render_data", UtilsKt.i(this.K.k()));     // Catch: Throwable -> L200
        int r0 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h0.a;     // Catch: Throwable -> L200
        if (r34 == null) goto L120;
        l3 r1 = r34.getSeriesGift();     // Catch: Throwable -> L200
        if (r1 == null) goto L120;
        List<k3> r2 = r1.getSeriesGiftList();     // Catch: Throwable -> L200
        if (r2 == null) goto L120;
    L121:
        com.bytedance.android.livesdk.gift.platform.core.model.l r39 = (com.bytedance.android.livesdk.gift.platform.core.model.l) ((LinkedHashMap) this.N.a).get(this.I.b);     // Catch: Throwable -> L200
        if (r39 == null) goto L124;
        List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> r40 = r39.a;     // Catch: Throwable -> L200
    L125:
        r4.put("series_gift_map", UtilsKt.i(GsonHelper.getDefault().toJsonTree(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h0.a(r2, r40, this.D)).getAsJsonObject()));     // Catch: Throwable -> L200
        this.L.getClass();     // Catch: Throwable -> L200
        h1 r3 = this.y;     // Catch: Throwable -> L200
        List<String> r41 = com.bytedance.android.livesdk.gift.platform.core.h.o();     // Catch: Throwable -> L200
        this.L.getClass();     // Catch: Throwable -> L200
        if (CollectionsKt.contains(r41, null) == false) goto L138;
        GiftListSortDataStore r43 = this.L;     // Catch: Throwable -> L200
        if (r3 == null) goto L131;
        long r136 = r3.getId();     // Catch: Throwable -> L200
    L133:
        if (r43.n(r136) == false) goto L138;
        if (this.L.o() == false) goto L138;
        r24 = true;
        goto L138
    L131:
        r136 = -1;
    L138:
        if (r24 == false) goto L142;
        z1 r5 = this.L.k();     // Catch: Throwable -> L200
        if (r5 == null) goto L142;
        IGiftMarketingInfo r44 = r5.getGiftMarketingInfo();     // Catch: Throwable -> L200
    L143:
        if (r44 == null) goto L151;
        JsonElement r45 = GsonHelper.getDefault().toJsonTree(r44);     // Catch: Throwable -> L200
        if (r45 == null) goto L149;
        JsonObject r46 = r45.getAsJsonObject();     // Catch: Throwable -> L200
        if (r46 == null) goto L149;
        GsonMap r47 = UtilsKt.i(r46);     // Catch: Throwable -> L200
    L150:
        r4.put("scene_marketing_info", r47);     // Catch: Throwable -> L200
    L149:
        r47 = null;
    L151:
        this.L.getClass();     // Catch: Throwable -> L200
        Map<String, ArrayList<String>> r48 = ay1.b.b();     // Catch: Throwable -> L200
        h1 r49 = this.y;     // Catch: Throwable -> L200
        if (r49 == null) goto L154;
        r112 = r49.getId();     // Catch: Throwable -> L200
    L154:
        ArrayList<String> r50 = r48.get(String.valueOf(r112));     // Catch: Throwable -> L200
        if (r50 == null) goto L157;
        r4.put("cache_cards", r50);     // Catch: Throwable -> L200
    L157:
        sh6.b r51 = (sh6.b) this.M.e.getValue();     // Catch: Throwable -> L200
        if (r51 == null) goto L162;
        x1 r53 = (x1) sh6.c.b(r51);     // Catch: Throwable -> L200
        if (r53 == null) goto L162;
        r4.put("top_bar_data", r53);     // Catch: Throwable -> L200
    L162:
        LinkedHashMap r54 = new LinkedHashMap();     // Catch: Throwable -> L200
        r54.put("last_send_ids", ay1.b.c());     // Catch: Throwable -> L200
        r54.put("last_send_time", ay1.b.d());     // Catch: Throwable -> L200
        r4.put("buff_cache", r54);     // Catch: Throwable -> L200
        LinkedHashMap r55 = new LinkedHashMap();     // Catch: Throwable -> L200
        r55.put("last_send_time", ay1.b.h());     // Catch: Throwable -> L200
        r55.put("diy_toolbar_cache", ay1.b.b());     // Catch: Throwable -> L200
        r55.put("last_send_ids", ay1.b.g());     // Catch: Throwable -> L200
        r55.put("last_send_card_name", ay1.b.f());     // Catch: Throwable -> L200
        r4.put("diy_cache", r55);     // Catch: Throwable -> L200
        if (tb1.c.c == false) goto L165;
    L166:
        ca0.e r56 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ca0.e.class);     // Catch: Throwable -> L200
        if (r56 == null) goto L174;
        List r57 = r56.getBehaviorList();     // Catch: Throwable -> L200
        if (r57 == null) goto L174;
        List r58 = r57;     // Catch: Throwable -> L200
        ArrayList r59 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r58, 10));     // Catch: Throwable -> L200
        Iterator r60 = r58.iterator();     // Catch: Throwable -> L200
    L172:
        if (r60.hasNext() == false) goto L175;
        r59.add(((com.lynx.tasm.behavior.a) r60.next()).getName());     // Catch: Throwable -> L200
    L175:
        r4.put("support_custom_element_name_list", r59);     // Catch: Throwable -> L200
        Gson r61 = GsonHelper.getDefault();     // Catch: Throwable -> L200
        oc6.e r63 = (oc6.e) this.G.j.getValue();     // Catch: Throwable -> L200
        if (r63 != null) goto L178;
        r63 = new oc6.e();     // Catch: Throwable -> L200
    L178:
        r4.put("exchange_data", r61.toJson(r63));     // Catch: Throwable -> L200
    L179:
        LinkedHashMap r64 = new LinkedHashMap();     // Catch: Throwable -> L200
        r64.put("live_gift_tab_dynamization", Boolean.valueOf(v.f()));     // Catch: Throwable -> L200
        r4.put("settings", UtilsKt.i(GsonHelper.getDefault().toJsonTree(r64).getAsJsonObject()));     // Catch: Throwable -> L200
        ArrayList r65 = new ArrayList();     // Catch: Throwable -> L200
        if (r34 == null) goto L193;
        IGiftMarketingInfo r66 = r34.getGiftMarketingInfo();     // Catch: Throwable -> L200
        if (r66 == null) goto L193;
        List<Long> r67 = r66.getRelatedGiftIds();     // Catch: Throwable -> L200
        if (r67 == null) goto L193;
        Iterator<T> r68 = r67.iterator();     // Catch: Throwable -> L200
    L187:
        if (r68.hasNext() == false) goto L191;
        h1 r69 = this.C.findGiftById(((Number) r68.next()).longValue());     // Catch: Throwable -> L200
        if (r69 == null) goto L187;
        r65.add(r69);     // Catch: Throwable -> L200
        Unit r70 = Unit.INSTANCE;     // Catch: Throwable -> L200
        goto L187
    L191:
        Unit r71 = Unit.INSTANCE;     // Catch: Throwable -> L200
    L193:
        if ((!r65.isEmpty()) == true) goto L196;
        r65 = null;
    L196:
        if (r65 == null) goto L198;
        r13 = r4.put("market_related_gifts", UtilsKt.i(GsonHelper.getDefault().toJsonTree(r65).getAsJsonObject()));     // Catch: Throwable -> L200
    L198:
        Result.constructor-impl(r13);     // Catch: Throwable -> L200
    L202:
        GiftDynamicPanelState r73 = new GiftDynamicPanelState();
        r0<GiftDynamicPanelState, Map<String, Object>> r74 = r73.getShowParams();
        r19.getClass();
        l0.h(r74, r4);
        l0.h(r73.getNeedHideOperation(), Boolean.FALSE);
        return r73;
    L174:
        r59 = null;
        goto L175
    L165:
        if (tb1.c.b == false) goto L179;
    L142:
        r44 = null;
        goto L143
    L124:
        r40 = null;
    L120:
        r2 = CollectionsKt.emptyList();     // Catch: Throwable -> L200
        goto L121
    L105:
        r134 = null;
        goto L106
    L69:
        r119 = 0;
        goto L70
    L65:
        r116 = 0;
        goto L66
    L45:
        GiftContext r137 = com.bytedance.android.livesdk.gift.util.b.b();     // Catch: Throwable -> L200
        if (r137 == null) goto L52;
        com.bytedance.live.datacontext.m<GiftContext.a> r138 = r137.getLastSendGiftId();     // Catch: Throwable -> L200
        if (r138 == null) goto L52;
        GiftContext.a r139 = (GiftContext.a) r138.getValue();     // Catch: Throwable -> L200
        if (r139 == null) goto L52;
        r113 = r139.a;     // Catch: Throwable -> L200
    L54:
        if (r113 != 0) goto L59;
        if (r30 == null) goto L58;
        r113 = r30.getId();     // Catch: Throwable -> L200
        goto L59
    L58:
        r113 = 0;
    L52:
        r113 = 0;
        goto L54
    L40:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");     // Catch: Throwable -> L200
    L41:
        r30 = null;
        goto L42
    L20:
        if (r23.isEmpty() == true) goto L23;
        r25 = false;
        goto L24
    L16:
        r21 = null;
        goto L17
    L9:
        r15 = null;
    L200:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L202
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDynamicPanelViewModel$bindToParent$1 r0 = GiftMVIDynamicPanelViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void e1(UpdateTopViewSource r3) {
        if (h1() == false) goto L9;
        GiftDialogStateDataStore r0 = this.E;
        r0.getClass();
        int r1 = r0.s;
        if (Intrinsics.areEqual(this.u.get(Integer.valueOf(r1)), Boolean.FALSE) == false) goto L7;
        t1(false, r3);
        return;
    L7:
        t1(true, r3);
        return;
    }

    public final boolean s1(int r4) {
        List<l2> r0 = this.S.a;
        if (r4 == 5) goto L5;
    L15:
        return false;
    L5:
        if (h1() == false) goto L15;
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        return true;
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    }

    public final void J0(com.bytedance.android.anya.internal.e r3, MVIState r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$reduce");
        Intrinsics.checkNotNullParameter((GiftDynamicPanelState) r4, "state");
        if (v.a() == false) goto L7;
        r3.e(this.F.R(), new GiftMVIDynamicPanelViewModel$reduce$1(this));
        r3.d(this.R.k(), this.R.n(), new GiftMVIDynamicPanelViewModel$reduce$2(this));
        r3.e(this.V.w(), new GiftMVIDynamicPanelViewModel$reduce$3(this));
        return;
    }

    public final void t1(boolean r10, UpdateTopViewSource r11) {
        if (h1() == true) goto L8;
        if (this.U.s() == true) goto L8;
        return;
    L8:
        if (s1(this.E.w()) == false) goto L10;
    L24:
        boolean r4 = false;
    L25:
        Objects.toString(r11);
        this.U.s();
        GiftDialogStateDataStore r13 = this.E;
        boolean r0 = this.U.s();
        if ((true ^ Intrinsics.areEqual((Boolean) r13.p.getValue(), Boolean.valueOf(r4))) == true) goto L28;
        if (r0 == true) goto L28;
    L29:
        GiftDialogStateDataStore r1 = this.E;
        r1.getClass();
        int r5 = Integer.valueOf(r1.s).intValue();
        GiftDialogStateDataStore r2 = this.E;
        r2.getClass();
        K0(new GiftTopVisibleChanged(r4, r5, Integer.valueOf(r2.r).intValue(), r11, this.U.s()));
        return;
    L28:
        r13.p.onNext(Boolean.valueOf(r4));
        goto L29
    L10:
        if (this.E.w() == 17) goto L12;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L24;
        if (this.E.w() == 26) goto L24;
        GiftDialogStateDataStore r6 = this.E;
        if (r6.k(r6.w()) == true) goto L24;
        r4 = r10;
        goto L25
    L12:
        if (h1() == false) goto L16;
        if (this.V.y() == false) goto L16;
        r3 = true;
        goto L17
    }

    public GiftMVIDynamicPanelViewModel(e1 r17, GiftListRepository r18, LocateGiftInfo r19, GiftDialogStateDataStore r20, GiftExtraRepo r21, u r23, m r24, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r25, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k r26, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.a r27, GiftListSortDataStore r28, GiftMVICarnivalDataStore r29, GiftListPanelRepository r210, GiftPanelMonitorService r30, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.h r31, GiftTopicDataStore r33, GiftScrollDataStore r34, PropListService r35, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.i r36, GiftSearchDataStore r37, GiftMostlyUsedDataStore r38, GiftTabDataStore r39, GiftDefaultLocationInfoDataStore r310) {
        Intrinsics.checkNotNullParameter(r17, "giftListService");
        Intrinsics.checkNotNullParameter(r18, "giftListRepository");
        Intrinsics.checkNotNullParameter(r19, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r20, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r21, "extraDataStore");
        Intrinsics.checkNotNullParameter(r23, "rechargeDataStore");
        Intrinsics.checkNotNullParameter(r24, "profitDataStore");
        Intrinsics.checkNotNullParameter(r25, "giftPanelReceiverService");
        Intrinsics.checkNotNullParameter(r26, "giftReceiverModeService");
        Intrinsics.checkNotNullParameter(r27, "fansClubDataStore");
        Intrinsics.checkNotNullParameter(r28, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r29, "giftMVICarnivalDataStore");
        Intrinsics.checkNotNullParameter(r210, "giftListPanelRepository");
        Intrinsics.checkNotNullParameter(r30, "giftPanelMonitorService");
        Intrinsics.checkNotNullParameter(r31, "operationDataStore");
        Intrinsics.checkNotNullParameter(r33, "topicDataStore");
        Intrinsics.checkNotNullParameter(r34, "giftScrollDataStore");
        Intrinsics.checkNotNullParameter(r35, "propListService");
        Intrinsics.checkNotNullParameter(r36, "preloaderService");
        Intrinsics.checkNotNullParameter(r37, "giftSearchDataStore");
        Intrinsics.checkNotNullParameter(r38, "giftMostlyUsedDataStore");
        Intrinsics.checkNotNullParameter(r39, "giftTabDataStore");
        Intrinsics.checkNotNullParameter(r310, "defaultLocationInfoDataStore");
        this.C = r17;
        this.D = r18;
        this.E = r20;
        this.F = r21;
        this.G = r23;
        this.H = r24;
        this.I = r25;
        this.J = r26;
        this.K = r27;
        this.L = r28;
        this.M = r29;
        this.N = r210;
        this.O = r30;
        this.P = r31;
        this.Q = r33;
        this.R = r34;
        this.S = r35;
        this.T = r36;
        this.U = r37;
        this.V = r38;
        this.W = r39;
        this.X = r310;
        this.u = new HashMap();
        this.v = true;
        this.w = LazyKt.lazy(GiftMVIDynamicPanelViewModel$enableScrollAnimationOpt$2.INSTANCE);
        this.x = new CompositeDisposable();
        this.B = SetsKt.setOf(new BaseMVIDataStore[]{r31, r20, r21, r34, r37, r38});
    }
}
