package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import android.text.TextUtils;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t;
import com.bytedance.android.anya.t0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo;
import com.bytedance.android.livesdk.gift.model.e2;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftGroupCardDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftBuffCardHelper;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftSendPreCheckService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.m;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.m0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.o0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.p0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.GiftPanelIconSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.ImageType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.h0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.BanSendGiftSelfTipsEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CardStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClearGiftSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickSearchEntrance;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftSearchItemVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollToPositionInSearch;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShakeGiftIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SmoothScrollInSearch;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StartScrollGiftSearchPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePanelGiftSearch;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.VisualStatus;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListPanelRepository;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftConfirmService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.ComboStatus;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.SelectStatus;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVISearchViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftSearchViewState, GiftAction> implements o {
    public long A;
    public final GiftTopViewState.Mode B;
    public final CompositeDisposable C;
    public IntRange D;
    public final Set<BaseMVIDataStore<?>> E;
    public final GiftSearchDataStore F;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f G;
    public final GiftExtraRepo H;
    public final OpenDialogService H0;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f I;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c J;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.i K;
    public final e1 L;
    public final yz0.k M;
    public final h0 N;
    public final GiftDialogStateDataStore O;
    public final u0 P;
    public final xz1.c Q;
    public final u1 R;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a S;
    public final r3 T;
    public final GiftSendPreCheckService U;
    public final GiftGroupCardDataStore V;
    public final GiftConfirmService W;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b X;
    public final GiftMVICarnivalDataStore Y;
    public final GiftListSortDataStore Z;
    public final GiftListPanelRepository k0;
    public final y p0;
    public final com.bytedance.android.livesdk.gift.platform.business.config.a u;
    public final boolean v;
    public final IRoom w;
    public final n x;
    public o0 y;
    public p0 z;

    public final void onStart() {
    }

    public final void onStop() {
        this.C.clear();
        this.A = -1;
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.E;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftSearchViewState();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVISearchViewModel$bindToParent$1 r0 = GiftMVISearchViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void q(com.bytedance.android.anya.dsl.l<GiftSearchViewState, r, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$buildStateMachine");
        Function1<com.bytedance.android.anya.dsl.l<GiftSearchViewState, r, GiftAction>.a<GiftSearchBusinessState.Idle>, Unit> r0 = new GiftMVISearchViewModel$buildStateMachine$1(this);
        LinkedHashMap r1 = r5.a;
        com.bytedance.android.anya.dsl.l.a r3 = new com.bytedance.android.anya.dsl.l.a();
        r0.invoke(r3);
        r1.put(GiftSearchBusinessState.Idle.class, r3.a);
        Function1<com.bytedance.android.anya.dsl.l<GiftSearchViewState, r, GiftAction>.a<GiftSearchBusinessState.GiftSelected>, Unit> r2 = new GiftMVISearchViewModel$buildStateMachine$2(this);
        LinkedHashMap r4 = r5.a;
        com.bytedance.android.anya.dsl.l.a r6 = new com.bytedance.android.anya.dsl.l.a();
        r2.invoke(r6);
        r4.put(GiftSearchBusinessState.GiftSelected.class, r6.a);
        Function1<com.bytedance.android.anya.dsl.l<GiftSearchViewState, r, GiftAction>.a<GiftSearchBusinessState.GiftCombo>, Unit> r7 = new GiftMVISearchViewModel$buildStateMachine$3(this);
        LinkedHashMap r8 = r5.a;
        com.bytedance.android.anya.dsl.l.a r9 = new com.bytedance.android.anya.dsl.l.a();
        r7.invoke(r9);
        r8.put(GiftSearchBusinessState.GiftCombo.class, r9.a);
    }

    public final void J0(com.bytedance.android.anya.internal.e r6, MVIState r7) {
        final GiftSearchViewState r8 = (GiftSearchViewState) r7;
        Intrinsics.checkNotNullParameter(r6, "$this$reduce");
        Intrinsics.checkNotNullParameter(r8, "state");
        r6.e(this.F.n(), new GiftMVISearchViewModel$reduce$2(this, r8));
        r6.e(this.F.o(), new GiftMVISearchViewModel$reduce$3(this, r8));
        if (v.e() == false) goto L5;
        r6.e(this.V.n(), new GiftMVISearchViewModel$reduce$4(this, r8));
    L5:
        r6.e(this.J.n(), new GiftMVISearchViewModel$reduce$5(this, r8));
        t<com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c, com.bytedance.android.livesdk.gift.model.n> r0 = this.J.o();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r1 = this.J;
        r6.d(r0, (t) r1.j.getValue(r1, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c.u[4]), new GiftMVISearchViewModel$reduce$6(this, r8));
    }

    public final void t1(final l0<GiftSearchViewState> r7, final GiftSearchViewState r8) {
        SubStatePropertyImpl r0 = r8.getComboState();
        new k0.a();
        GiftComboState r1 = (GiftComboState) r0.c();
        r1.getComboNum().a(0);
        com.bytedance.android.anya.internal.c r2 = r1.getComboStatus();
        com.bytedance.android.anya.internal.c r3 = r2;
        r3.a(ComboState.IDLE);
        r1.getPositionX().a(0);
        r1.getPositionY().a(0);
        Function2<ItemListData, Integer, Unit> r4 = new GiftMVISearchViewModel$clearCombo$$inlined$modifyListDataWithRule$1(r7, r8);
        k0 r9 = r7.b;
        t0<GiftSearchViewState, ItemListData> r10 = r8.getSearchItemDataList();
        r9.getClass();
        Iterator r11 = k0.c(r10).iterator();
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L15;
        Object r5 = r11.next();
        int r6 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ItemListData r14 = (ItemListData) r5;
        if (((ItemStatus) com.bytedance.android.anya.h.b(r14.getItemStatus())) != ItemStatus.GONE) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L14;
        r4.invoke(r14, Integer.valueOf(r13));
    L14:
        r13 = r6;
        goto L4
    L11:
        r15 = false;
        goto L12
    L15:
        this.x.a();
        h0 r16 = this.N;
        GiftTransaction r17 = r16.a;
        if (r17 == null) goto L18;
        r17.finish();
    L18:
        r16.a = null;
        this.O.R(ComboStatus.IDLE);
    }

    public final void u1(final l0<GiftSearchViewState> r4, final GiftSearchViewState r5, ClearGiftSource r6) {
        int r0 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.g.c(this.O, this.P, r6, new GiftMVISearchViewModel$clearSelected$1(r4, r5));
    }

    public final void y0(l0 r45, MVIState r46, p r47) {
        GiftSearchViewState r2 = (GiftSearchViewState) r46;
        GiftAction r3 = (GiftAction) r47;
        Intrinsics.checkNotNullParameter(r45, "$this$reduce");
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "action");
        String r7 = null;
        if ((r3 instanceof UpdatePanelGiftSearch) == false) goto L51;
        if (TextUtils.isEmpty(this.F.q()) == true) goto L172;
        t1(r45, r2);
        u1(r45, r2, ClearGiftSource.SearchUpdate);
        this.D = new IntRange(-1, -1);
        UpdatePanelGiftSearch r1 = (UpdatePanelGiftSearch) r3;
        List r4 = CollectionsKt.toMutableList(r1.getSearchResult());
        ArrayList r9 = new ArrayList();
        int r10 = com.bytedance.android.livesdk.gift.platform.core.utils.f.a;
        List r11 = r4;
        boolean r13 = this.M.isAnchor();
        boolean r14 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.l(this.G.a);
        if (this.G.b != ReceiverType.OtherAnchor) goto L10;
        boolean r15 = true;
    L11:
        com.bytedance.android.livesdk.gift.platform.core.utils.f.b(r11, r13, r14, r15);
        l0.d(r2.getSearchItemDataList());
        this.F.g.onNext(Boolean.valueOf(!r11.isEmpty()));
        ArrayList r16 = new ArrayList();
        if (r4 == null) goto L14;
        Integer r17 = Integer.valueOf(r4.size());
    L15:
        int r18 = r17.intValue();
        if (r4 == null) goto L34;
        Iterator r5 = r4.iterator();
        int r19 = 0;
    L19:
        if (r5.hasNext() == false) goto L34;
        h1 r29 = (h1) r5.next();
        r16.add(Long.valueOf(r29.getId()));
        int r30 = r19 + 1;
        int r110 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        IBaseUser r111 = this.G.a;
        if (r111 == null) goto L23;
        String r112 = r111.getIdString();
    L24:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r113 = this.G;
        vz1.e r114 = com.bytedance.android.livesdk.gift.platform.core.utils.g.p(r29, -1, r112, r113.b, this.H, this.I, this.J, this.u, this.v, r113, this.w, this.K, this.L, this.k0, this.Z, r30, r18);
        ItemListData r115 = new ItemListData();
        new k0.a();
        r115.getItemData().a(r114);
        if (j0.e(r29) == false) goto L28;
        r115.getVisualStatus().a(Integer.valueOf(((Number) r115.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK()));
    L28:
        if (j0.f(r29) == false) goto L31;
        r115.getVisualStatus().a(Integer.valueOf(((Number) r115.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getLOCK_NORMAL()));
    L31:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(this.G.a.getIdString(), null) == false) goto L33;
        r115.getVisualStatus().a(Integer.valueOf(((Number) r115.getVisualStatus().c()).intValue() | VisualStatus.INSTANCE.getBAN()));
    L33:
        Unit r116 = Unit.INSTANCE;
        r9.add(r115);
        l0.g(r2.getSearchItemDataList(), r9);
        r19 = r30;
        goto L19
    L23:
        r112 = null;
    L34:
        Map<String, String> r6 = r1.getEventTrack();
        if (r6 == null) goto L38;
        String r8 = r6.get("search_id");
        if (r8 == null) goto L38;
    L39:
        GiftSearchDataStore r20 = this.F;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r8, "id");
        r20.j = r8;
        if (r6 == null) goto L42;
        r7 = r6.get("initial_return_gift_list");
    L42:
        u1 r21 = this.R;
        String r117 = this.F.q();
        if (r7 != null) goto L45;
        r7 = "[]";
    L45:
        String r118 = r16.toString();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r8, "searchId");
        Intrinsics.checkNotNullParameter(r117, "searchWord");
        Intrinsics.checkNotNullParameter(r7, "initialReturnGiftList");
        Intrinsics.checkNotNullParameter(r118, "finalReturnGiftList");
        Pair[] r119 = new Pair[6];
        if (r21.A() == false) goto L48;
        String r120 = "1";
    L49:
        r119[0] = TuplesKt.to("is_anchor", r120);
        r119[1] = TuplesKt.to("search_word", r117);
        r119[2] = TuplesKt.to("gift_panel_search_id", r8);
        r119[3] = TuplesKt.to("initial_return_gift_list", r7);
        r119[4] = TuplesKt.to("final_return_gift_list", r118);
        r119[5] = TuplesKt.to("gift_panel_session_id", r21.n.a);
        r21.p1("livesdk_gift_search_result_show", MapsKt.mutableMapOf(r119), true);
    L163:
        T0(r2, r3);
        return;
    L48:
        r120 = "0";
    L38:
        r8 = BuildConfig.FLAVOR;
        goto L39
    L14:
        r17 = null;
        goto L15
    L10:
        r15 = false;
        goto L11
    L172:
        return;
    L51:
        if ((r3 instanceof StartScrollGiftSearchPanel) == false) goto L56;
        com.bytedance.android.anya.u0<GiftSearchViewState, GiftComboState> r23 = r2.getComboState();
        r45.getClass();
        if (((ComboState) com.bytedance.android.anya.h.b(((GiftComboState) com.bytedance.android.anya.h.b(r23)).getComboStatus())) == ComboState.IDLE) goto L163;
        t1(r45, r2);
        goto L163
    L56:
        if ((r3 instanceof OnGiftSearchItemVisibleChanged) == false) goto L152;
        IntRange r24 = this.D;
        if (r24 != null) goto L60;
        r24 = new IntRange(-1, -1);
    L60:
        OnGiftSearchItemVisibleChanged r25 = (OnGiftSearchItemVisibleChanged) r3;
        this.D = r25.getCurrentShowRange();
        IntRange r26 = r25.getCurrentShowRange();
        if (Intrinsics.areEqual(r26, new IntRange(-1, -1)) == true) goto L163;
        r r27 = r45.i(r2);
        if ((r27 instanceof GiftSearchBusinessState.GiftSelected) == false) goto L66;
        vz1.e r28 = ((GiftSearchBusinessState.GiftSelected) r27).getIconModel();
    L67:
        int r121 = com.bytedance.android.anya.h.a(r2.getSearchItemDataList());
        Iterator<T> r31 = m.b(r24, r26).iterator();
    L69:
        if (r31.hasNext() == false) goto L163;
        int r33 = ((Number) r31.next()).intValue();
        k0 r122 = r45.b;
        t0<GiftSearchViewState, ItemListData> r123 = r2.getSearchItemDataList();
        r122.getClass();
        if (com.bytedance.android.anya.h.a(r123) <= r33) goto L69;
        if (r33 < 0) goto L69;
        vz1.e r124 = (vz1.e) com.bytedance.android.anya.h.b(((ItemListData) k0.d(r2.getSearchItemDataList(), r33)).getItemData());
        long r125 = r124.b;
        if (r28 != null) goto L76;
    L89:
        GiftPanelIconSource r34 = r124.q;
    L90:
        GiftPanelIconSource r210 = r34;
        CardType r35 = CardType.None;
        long r126 = r124.b;
        if (r28 != null) goto L93;
    L110:
        String r36 = r124.t.a;
    L111:
        String r211 = r36;
    L112:
        long r127 = r124.b;
        if (r28 != null) goto L115;
    L133:
        CardType r37 = CardType.DIY;
        List r38 = r124.t.b;
    L134:
        CardType r39 = r37;
        List r212 = r38;
    L135:
        com.bytedance.android.livesdk.gift.model.k0 r40 = r124.a.getGiftPreviewInfo();
        if (r40 != null) goto L138;
    L140:
        boolean r213 = false;
    L141:
        e2 r41 = r124.a.getGiftTouchLabel();
        if (r41 == null) goto L144;
        String r214 = r41.getTouchUniqueKey();
    L145:
        int r310 = (r33 / 4) + 1;
        int r311 = (r33 % 4) + 1;
        u1 r43 = this.R;
        long r128 = r124.b;
        h1 r129 = r124.a;
        boolean r130 = !r124.e;
        com.bytedance.android.livesdk.gift.platform.core.model.k r131 = r124.x;
        if (r131 == null) goto L148;
        int r44 = r131.a;
    L149:
        m0.e.getClass();
        u1.x0(r43, r128, r129, r130, r44, m0.a.a(r124), 0, -1, 0, r210, r211, r212, r213, r214, BuildConfig.FLAVOR, false, r310, r311, Integer.valueOf(r124.a.getGiftSource()), r121, false, BuildConfig.FLAVOR, this.B, r39, true, this.F.q(), this.F.j, r124.z, null, 134217728);
        goto L69
    L148:
        r44 = r33 + 1;
        goto L149
    L144:
        r214 = null;
        goto L145
    L138:
        if (r40.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L140;
        r213 = true;
        goto L141
    L115:
        if (r127 != r28.b) goto L133;
        p0 r48 = this.z;
        if (r48 == null) goto L124;
        r37 = CardType.DIY;
        com.bytedance.android.livesdk.gift.model.n r49 = r48.a;
        if (r49 == null) goto L122;
        r38 = gz1.c.g(r49);
        goto L134
    L122:
        r38 = null;
        goto L134
    L124:
        if (this.y == null) goto L132;
        r37 = CardType.Buff;
        e3 r50 = (e3) vh7.f.c(e3.class);
        o0 r132 = this.y;
        if (r132 == null) goto L130;
        l1 r133 = r132.a;
        if (r133 == null) goto L130;
        long r134 = r133.getBuffGiftId();
    L131:
        r50.setPluginId(r134);
        r38 = CollectionsKt.listOf(r50);
    L130:
        r134 = 0;
        goto L131
    L132:
        r39 = r35;
        r212 = null;
        goto L135
    L93:
        if (r126 != r28.b) goto L110;
        p0 r51 = this.z;
        if (r51 == null) goto L100;
        com.bytedance.android.livesdk.gift.model.n r53 = r51.a;
        if (r53 == null) goto L109;
        r36 = r53.getCardName();
    L109:
        r211 = null;
        goto L112
    L100:
        o0 r54 = this.y;
        if (r54 == null) goto L109;
        l1 r55 = r54.a;
        if (r55 == null) goto L105;
        long r135 = r55.getBuffGiftId();
    L106:
        h2 r56 = GiftManagerKt.l(r135);
        if (r56 == null) goto L109;
        r36 = r56.getName();
        goto L111
    L105:
        r135 = 0;
        goto L106
    L76:
        if (r125 != r28.b) goto L89;
        p0 r136 = this.z;
        if (r136 == null) goto L83;
        GiftBuffCardHelper.Companion r137 = GiftBuffCardHelper.a;
        Intrinsics.checkNotNull(r136);
        com.bytedance.android.livesdk.gift.model.n r138 = r136.a;
        com.bytedance.android.livesdk.gift.model.n r57 = this.H.I(Long.valueOf(r124.b));
        r137.getClass();
        if (GiftBuffCardHelper.Companion.a(r138, r57) == false) goto L83;
        r34 = GiftPanelIconSource.DIY_CARD;
    L83:
        o0 r58 = this.y;
        if (r58 == null) goto L88;
        l1.a r59 = l1.Companion;
        Intrinsics.checkNotNull(r58);
        l1 r60 = r58.a;
        r59.getClass();
        if (l1.a.g(0, r60) == 0) goto L88;
        r34 = GiftPanelIconSource.BUFF_CARD;
    L88:
        r34 = GiftPanelIconSource.GIFT_LIST;
        goto L90
    L66:
        r28 = null;
        goto L67
    L152:
        if ((r3 instanceof ClickSearchEntrance) == false) goto L163;
        ClickSearchEntrance r61 = (ClickSearchEntrance) r3;
        if (r61.isNormalSearch() == false) goto L159;
        GiftSearchDataStore r63 = this.F;
        if (r63 == null) goto L163;
        r63.k();
        goto L163
    L159:
        if (r61.isCloseGiftDialog() == false) goto L163;
        OpenDialogService r64 = this.H0;
        if (r64 == null) goto L163;
        OpenDialogService.d(r64, 0, null, 3);
        goto L163
    }

    public static final void h1(GiftMVISearchViewModel r23, l0 r24, GiftSearchViewState r25, int r26) {
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "$this$getListData");
        Intrinsics.checkNotNullParameter(r25, "state");
        t0<GiftSearchViewState, ItemListData> r1 = r25.getSearchItemDataList();
        r24.getClass();
        SelectedStatus r4 = null;
        if (com.bytedance.android.anya.h.a(r1) <= r26) goto L16;
        if (r26 < 0) goto L16;
        u r2 = r25.getSearchItemDataList();
        MVIState r5 = (MVIState) ((s0) r2.c()).get(r26);
        new k0.a();     // Catch: Throwable -> L11
        ItemListData r6 = (ItemListData) r5;     // Catch: Throwable -> L11
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L10;
        ((com.bytedance.android.anya.internal.t) r2.c()).d(r26);
    L10:
        ItemListData r10 = r6;
    L17:
        if (r10 == null) goto L44;
        r r3 = r24.i(r25);
        if ((r3 instanceof GiftSearchBusinessState.GiftSelected) == true) goto L22;
        r3 = null;
    L22:
        GiftSearchBusinessState.GiftSelected r7 = (GiftSearchBusinessState.GiftSelected) r3;
        if (r7 == null) goto L26;
        r4 = r7.getSelectedStatus();
    L26:
        if (g0.a((vz1.e) com.bytedance.android.anya.h.b(r10.getItemData())) == false) goto L31;
        SelectedStatus r8 = SelectedStatus.GROUP;
        if (r4 == r8) goto L45;
        z1(r23, r24, r25, r26, r8, null, 8);
        r23.O.S(SelectStatus.LONG_PRESS);
        int r17 = (r26 / 4) + 1;
        r23.R.f0(((vz1.e) com.bytedance.android.anya.h.b(r10.getItemData())).a.getId(), "bunching_panel", 0, -1, r17, (r26 % 4) + 1, true, r23.F.q(), r23.F.j, (vz1.e) com.bytedance.android.anya.h.b(r10.getItemData()));
        return;
    L45:
        return;
    L31:
        r23.t1(r24, r25);
        r23.u1(r24, r25, ClearGiftSource.GroupCancel);
        if (r23.S.j() == false) goto L36;
        String r9 = s1.B(2131917199);
    L34:
        String r11 = r9;
        int r18 = (r26 / 4) + 1;
        r23.R.f0(((vz1.e) com.bytedance.android.anya.h.b(r10.getItemData())).a.getId(), "toast", 0, -1, r18, (r26 % 4) + 1, true, r23.F.q(), r23.F.j, (vz1.e) com.bytedance.android.anya.h.b(r10.getItemData()));
        r23.K0(new ShakeGiftIcon(-1, r26, r11, -1, -1));
        return;
    L36:
        if (((vz1.e) com.bytedance.android.anya.h.b(r10.getItemData())).a.getBizType() != 1) goto L38;
        r9 = s1.B(2131917200);
        goto L34
    L38:
        r9 = nz1.a.t();
        goto L34
    L44:
        return;
    L11:
        th = move-exception;
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L15;
        ((com.bytedance.android.anya.internal.t) r2.c()).d(r26);
    L15:
        throw th;
    L16:
        r10 = null;
        goto L17
    }

    public static void z1(GiftMVISearchViewModel r23, l0 r24, GiftSearchViewState r25, int r26, SelectedStatus r27, String r28, int r29) {
        if ((r29 & 4) == 0) goto L5;
        SelectedStatus r1 = SelectedStatus.CLICK;
    L7:
        if ((r29 & 8) == 0) goto L9;
        String r2 = BuildConfig.FLAVOR;
    L10:
        r23.getClass();
        t0<GiftSearchViewState, ItemListData> r4 = r25.getSearchItemDataList();
        r24.getClass();
        if (com.bytedance.android.anya.h.a(r4) <= r26) goto L139;
        if (r26 < 0) goto L140;
        boolean r5 = false;
        if (com.bytedance.android.anya.h.a(r25.getSearchItemDataList()) <= r26) goto L30;
        if (r26 < 0) goto L30;
        u r6 = r25.getSearchItemDataList();
        MVIState r7 = (MVIState) ((s0) r6.c()).get(r26);
        new k0.a();     // Catch: Throwable -> L25
        int r8 = ((Number) ((ItemListData) r7).getVisualStatus().c()).intValue();     // Catch: Throwable -> L25
        VisualStatus r9 = VisualStatus.INSTANCE;     // Catch: Throwable -> L25
        if ((r8 & r9.getDISABLE()) != r9.getDISABLE()) goto L21;
        boolean r10 = true;
    L23:
        if ((!r7.modifiedProperties.isEmpty()) == false) goto L31;
        ((com.bytedance.android.anya.internal.t) r6.c()).d(r26);
    L31:
        if (r10 == true) goto L141;
        r23.t1(r24, r25);
        r23.u1(r24, r25, ClearGiftSource.SelectGift);
        IGiftExposureAnimInfo r11 = null;
        if (com.bytedance.android.anya.h.a(r25.getSearchItemDataList()) <= r26) goto L87;
        if (r26 < 0) goto L87;
        u r13 = r25.getSearchItemDataList();
        MVIState r14 = (MVIState) ((s0) r13.c()).get(r26);
        new k0.a();     // Catch: Throwable -> L82
        ItemListData r15 = (ItemListData) r14;     // Catch: Throwable -> L82
        Iterator r16 = ((ArrayList) r23.P.c).iterator();     // Catch: Throwable -> L82
    L39:
        if (r16.hasNext() == false) goto L43;
        com.bytedance.android.livesdk.gift.platform.business.f r17 = (com.bytedance.android.livesdk.gift.platform.business.f) r16.next();     // Catch: Throwable -> L82
        int r18 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;     // Catch: Throwable -> L82
        if (r17.x(com.bytedance.android.livesdk.gift.platform.core.utils.g.k(((vz1.e) r15.getItemData().c()).a, r23.z), r1, Integer.valueOf(r23.O.w())) == false) goto L39;
    L80:
        if ((!r14.modifiedProperties.isEmpty()) == false) goto L87;
        ((com.bytedance.android.anya.internal.t) r13.c()).d(r26);
        goto L87
    L43:
        int r19 = ((Number) r15.getVisualStatus().c()).intValue();     // Catch: Throwable -> L82
        VisualStatus r110 = VisualStatus.INSTANCE;     // Catch: Throwable -> L82
        if ((r19 & r110.getDISABLE()) == r110.getDISABLE()) goto L80;
        h1 r111 = ((vz1.e) r15.getItemData().c()).a;     // Catch: Throwable -> L82
        if (r23.A != r111.getId()) goto L48;
    L52:
        r15.getItemStatus().a(ItemStatus.SELECTED);     // Catch: Throwable -> L82
        r15.getSelectedStatus().a(r1);     // Catch: Throwable -> L82
        r23.O.S(SelectStatus.SELECT);     // Catch: Throwable -> L82
        if (((vz1.e) r15.getItemData().c()).a.getMysteryShopStatus() == 0) goto L56;
        u1 r3 = r23.R;     // Catch: Throwable -> L82
        long r112 = ((vz1.e) r15.getItemData().c()).a.getId();     // Catch: Throwable -> L82
        int r113 = ((vz1.e) r15.getItemData().c()).a.getMysteryShopStatus();     // Catch: Throwable -> L82
        r3.getClass();     // Catch: Throwable -> L82
        r3.p1("livesdk_distinct_mystery_gift_click", u1.E(r112, r113), true);     // Catch: Throwable -> L82
    L56:
        if (r1 != SelectedStatus.CLICK) goto L58;
    L61:
        r23.K0(new SmoothScrollInSearch(r26));     // Catch: Throwable -> L82
    L62:
        LinkedHashMap r20 = new LinkedHashMap();     // Catch: Throwable -> L82
        h1 r21 = ((vz1.e) r15.getItemData().c()).a;     // Catch: Throwable -> L82
        if (r21.getBizType() == 0) goto L65;
        boolean r114 = false;
    L67:
        if (((vz1.e) r15.getItemData().c()).e == false) goto L69;
        r114 = false;
    L69:
        r20.put("gift_id", String.valueOf(r21.getId()));     // Catch: Throwable -> L82
        r20.put("gift_name", r21.getName());     // Catch: Throwable -> L82
        r20.put("gift_price", String.valueOf(r21.getDiamondCount()));     // Catch: Throwable -> L82
        if (r114 == false) goto L72;
        String r115 = "1";
    L73:
        r20.put("is_normal_gift", r115);     // Catch: Throwable -> L82
        r20.put("diamond_count", String.valueOf(jc1.k.n(IRechargeService.class).rechargeCenter().getAvailableDiamonds()));     // Catch: Throwable -> L82
        com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges("giftPanelSelectEvent", r20);     // Catch: Throwable -> L82
        GiftContext r30 = com.bytedance.android.livesdk.gift.util.b.b();     // Catch: Throwable -> L82
        if (r30 == null) goto L78;
        com.bytedance.live.datacontext.n<Integer> r31 = r30.getCurrentSelectedGiftPosition();     // Catch: Throwable -> L82
        if (r31 == null) goto L78;
        r31.setValue(Integer.valueOf(r26));     // Catch: Throwable -> L82
    L78:
        r23.A = r111.getId();     // Catch: Throwable -> L82
        r23.O.I(r111, r26, false);     // Catch: Throwable -> L82
        goto L80
    L72:
        r115 = "0";
        goto L73
    L65:
        r114 = true;
        goto L67
    L58:
        if (r1 == SelectedStatus.GROUP) goto L61;
        r23.K0(new ScrollToPositionInSearch(r26));     // Catch: Throwable -> L82
        goto L62
    L48:
        if (r1 == SelectedStatus.GROUP) goto L52;
        if ((r111.getReqExtraType() & 2) != 2) goto L52;
        r23.Q.a();     // Catch: Throwable -> L82
        r0.a.a(r23.H, CollectionsKt.listOf(Long.valueOf(r111.getId())), "setSelected_" + r2, null, 12);     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        if ((!r14.modifiedProperties.isEmpty()) == false) goto L86;
        ((com.bytedance.android.anya.internal.t) r13.c()).d(r26);
    L86:
        throw th;
    L87:
        int r116 = (r26 % 4) + 1;
        int r117 = (r26 / 4) + 1;
        if (com.bytedance.android.anya.h.a(r25.getSearchItemDataList()) <= r26) goto L101;
        if (r26 < 0) goto L101;
        u r33 = r25.getSearchItemDataList();
        MVIState r34 = (MVIState) ((s0) r33.c()).get(r26);
        new k0.a();     // Catch: Throwable -> L96
        vz1.e r35 = (vz1.e) ((ItemListData) r34).getItemData().c();     // Catch: Throwable -> L96
        if ((!r34.modifiedProperties.isEmpty()) == false) goto L95;
        ((com.bytedance.android.anya.internal.t) r33.c()).d(r26);
    L95:
        vz1.e r36 = r35;
    L102:
        if (r36 == null) goto L108;
        h1 r37 = r36.a;
        if (r37 == null) goto L108;
        if (r37.getType() != 3) goto L108;
        return;
    L108:
        if (r36 == null) goto L114;
        h1 r38 = r36.a;
        if (r38 == null) goto L114;
        if (r38.getBizType() != 2) goto L114;
        return;
    L114:
        if (r36 == null) goto L120;
        h1 r39 = r36.a;
        if (r39 == null) goto L120;
        py.k r40 = r39.getDynamicImgForSelected();
        if (r40 == null) goto L120;
        r5 = r40.isValid();
    L120:
        if (r36 == null) goto L124;
        h1 r41 = r36.a;
        if (r41 == null) goto L124;
        long r43 = r41.getId();
    L125:
        u1 r44 = r23.R;
        IBaseUser r45 = r23.G.a;
        com.bytedance.android.livesdk.gift.model.g0 r46 = r23.H.q(r43);
        if (r46 == null) goto L128;
        r11 = r46.getGiftExposureAnimInfo();
    L128:
        r44.o0(r36, r26, r45, r5, 0, -1, 0, BuildConfig.FLAVOR, false, r11, r117, r116, BuildConfig.FLAVOR, r23.B, true, r23.F.q(), r23.F.j);
        return;
    L124:
        r43 = -1;
    L96:
        th = move-exception;
        if ((!r34.modifiedProperties.isEmpty()) == false) goto L100;
        ((com.bytedance.android.anya.internal.t) r33.c()).d(r26);
    L100:
        throw th;
    L101:
        r36 = null;
        goto L102
    L141:
        return;
    L21:
        r10 = false;
    L25:
        th = move-exception;
        if ((!r7.modifiedProperties.isEmpty()) == false) goto L29;
        ((com.bytedance.android.anya.internal.t) r6.c()).d(r26);
    L29:
        throw th;
    L30:
        r10 = false;
        goto L31
    L140:
        return;
    L139:
        return;
    L9:
        r2 = r28;
        goto L10
    L5:
        r1 = r27;
        goto L7
    }

    public final void w1(l0<GiftSearchViewState> r13, GiftSearchViewState r14, int r15, int r16, int r17, int r18, vz1.e r19, com.bytedance.android.livesdk.gift.platform.core.model.n r110) {
        com.bytedance.android.anya.u0<GiftSearchViewState, GiftComboState> r2 = r14.getComboState();
        r13.getClass();
        int r4 = r18 - ((Number) com.bytedance.android.anya.h.b(((GiftComboState) com.bytedance.android.anya.h.b(r2)).getComboNum())).intValue();
        if (com.bytedance.android.anya.h.a(r14.getSearchItemDataList()) <= r15) goto L15;
        if (r15 < 0) goto L15;
        u r3 = r14.getSearchItemDataList();
        MVIState r5 = (MVIState) ((s0) r3.c()).get(r15);
        new k0.a();     // Catch: Throwable -> L10
        ((ItemListData) r5).getItemStatus().a(ItemStatus.GONE);     // Catch: Throwable -> L10
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L15;
        ((com.bytedance.android.anya.internal.t) r3.c()).d(r15);
    L10:
        th = move-exception;
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L14;
        ((com.bytedance.android.anya.internal.t) r3.c()).d(r15);
    L14:
        throw th;
    L15:
        SubStatePropertyImpl r1 = r14.getComboState();
        new k0.a();
        GiftComboState r6 = (GiftComboState) r1.c();
        r6.getComboNum().a(Integer.valueOf(r18));
        r6.getComboStatus().a(ComboState.ON_LONG_CLICK);
        r6.getPositionX().a(Integer.valueOf(r16));
        r6.getPositionY().a(Integer.valueOf(r17));
        GiftBuffCardHelper.Companion r7 = GiftBuffCardHelper.a;
        l1 r8 = this.J.q();
        h1 r9 = r19.a;
        r7.getClass();
        this.y = GiftBuffCardHelper.Companion.h(r8, r9);
        p0 r10 = GiftBuffCardHelper.Companion.i(this.J.k(), r19.a);
        this.z = r10;
        x1(r13, r14, r4, 3, r19, this.y, r10, r110);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.h0] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.h0] */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.bytedance.android.livesdk.gift.model.n] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void x1(final l0<GiftSearchViewState> r28, final GiftSearchViewState r29, final int r30, final int r31, final vz1.e r33, final o0 r34, final p0 r35, final com.bytedance.android.livesdk.gift.platform.core.model.n r36) {
        int r0 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        final int r3 = com.bytedance.android.livesdk.gift.platform.core.utils.g.f(r33, this.V);
        if (r33 == null) goto L38;
        Object r1 = null;
        if (r3 > 1) goto L7;
        ?? r13 = this.N;
        if (r34 == null) goto L21;
        l1 r4 = r34.a;
        if (r4 == null) goto L21;
        int r16 = r4.getBuffLevel();
    L22:
        if (r35 == null) goto L26;
        com.bytedance.android.livesdk.gift.model.n r5 = r35.a;
        if (r5 == null) goto L26;
        r1 = gz1.c.g(r5);
    L26:
        ?? r17 = r1;
        if (r35 == null) goto L29;
        boolean r18 = true;
    L30:
        Function0<Unit> r19 = new GiftMVISearchViewModel$sendGift$$inlined$let$lambda$1(this, r28, r3, r36, r34, r35, r33, r30, r31, r29);
        if (r35 == null) goto L35;
        com.bytedance.android.livesdk.gift.model.n r2 = r35.a;
        if (r2 == null) goto L35;
        long r6 = r2.getConfigId();
    L36:
        r13.f(r30, r31, r33, r16, r17, r18, r19, r6, 0, r36, this.R.g, null, com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r33.b, this.H, this.Z, this.B));
        return;
    L35:
        r6 = 0;
        goto L36
    L29:
        r18 = false;
    L21:
        r16 = 0;
        goto L22
    L7:
        if (nz1.a.g() == false) goto L15;
        ?? r7 = this.N;
        if (r34 == null) goto L11;
        l1 r8 = r34.a;
    L12:
        if (r35 == null) goto L14;
        r1 = r35.a;
    L14:
        r7.c(r3, r33, r36, r8, r1, null, com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r33.b, this.H, this.Z, this.B), GiftMVISearchViewModel$sendGift$1$1.INSTANCE);
        return;
    L11:
        r8 = null;
        goto L12
    L15:
        this.N.a(r3, r33, r36, null, com.bytedance.android.livesdk.gift.platform.core.utils.g.i(r33.b, this.H, this.Z, this.B), GiftMVISearchViewModel$sendGift$1$2.INSTANCE);
        return;
    }

    public static final void e1(final GiftMVISearchViewModel r31, l0 r33, GiftSearchViewState r34, int r35, int r36, int r37, int r38, vz1.e r39, com.bytedance.android.livesdk.gift.platform.core.model.n r310) {
        r31.getClass();
        GiftBuffCardHelper.Companion r0 = GiftBuffCardHelper.a;
        l1 r1 = r31.J.q();
        h1 r2 = null;
        if (r39 == null) goto L5;
        h1 r3 = r39.a;
    L6:
        r0.getClass();
        r31.y = GiftBuffCardHelper.Companion.h(r1, r3);
        com.bytedance.android.livesdk.gift.model.n r4 = r31.J.k();
        if (r39 == null) goto L9;
        h1 r5 = r39.a;
    L10:
        r31.z = GiftBuffCardHelper.Companion.i(r4, r5);
        int r6 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;
        o0 r7 = r31.y;
        if (r7 == null) goto L13;
        l1 r8 = r7.a;
    L15:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.g.a(r8) == true) goto L114;
        p0 r9 = r31.z;
        if (r9 == null) goto L20;
        com.bytedance.android.livesdk.gift.model.n r10 = r9.a;
    L22:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.g.b(r10) == false) goto L25;
        return;
    L25:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.g.l(r39, r31.R, r31.G, r31.T, r31.H) == false) goto L28;
        return;
    L28:
        if (r39 == null) goto L32;
        if (r39.e != true) goto L32;
    L34:
        GiftSendPreCheckService r11 = r31.U;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r13 = r31.G;
        IBaseUser r14 = r13.a;
        if (r39 == null) goto L37;
        h1 r15 = r39.a;
    L38:
        h1 r16 = r15;
        ReceiverType r17 = r13.b;
        o0 r18 = r31.y;
        if (r18 == null) goto L41;
        l1 r19 = r18.a;
    L42:
        p0 r20 = r31.z;
        if (r20 == null) goto L45;
        com.bytedance.android.livesdk.gift.model.n r110 = r20.a;
    L46:
        int r21 = GiftSendPreCheckService.f(r11, r14, r16, null, r17, null, null, r19, r110, 48);
        long r23 = 0;
        if (r21 == 0) goto L53;
        if (r39 == null) goto L52;
        h1 r24 = r39.a;
        if (r24 == null) goto L52;
        r23 = r24.getId();
    L52:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.Q(r21, r23, -1);
        com.bytedance.android.livesdk.gift.platform.core.utils.g.m(r39, r21, BuildConfig.FLAVOR, r31.G, r31.T);
        return;
    L53:
        if (r39 == null) goto L55;
        h1 r25 = r39.a;
    L56:
        AbsPanel r26 = com.bytedance.android.livesdk.gift.platform.core.utils.g.k(r25, r31.z);
        o0 r27 = r31.y;
        if (r27 == null) goto L61;
        l1 r28 = r27.a;
        if (r28 == null) goto L61;
        int r29 = r28.getBuffLevel();
    L62:
        IBaseUser r30 = r31.G.a;
        boolean r210 = r31.S.j();
        List<IBaseUser> r311 = r31.S.i();
        int r211 = (r35 % 4) + 1;
        int r212 = (r35 / 4) + 1;
        if (r39 == null) goto L69;
        u1 r111 = r31.R;
        p0 r40 = r31.z;
        if (r40 == null) goto L67;
        com.bytedance.android.livesdk.gift.model.n r112 = r40.a;
    L68:
        IBaseUser r41 = r31.G.a;
        Map r213 = com.bytedance.android.livesdk.gift.platform.core.utils.g.g(r39.b, r31.H);
        t0<GiftSearchViewState, ItemListData> r43 = r34.getSearchItemDataList();
        r33.getClass();
        r111.w0(r39, 0, -1, 0, r112, r41, false, BuildConfig.FLAVOR, r213, r212, r211, com.bytedance.android.anya.h.a(r43), BuildConfig.FLAVOR, r31.B, true, r31.F.q(), r31.F.j);
        goto L69
    L67:
        r112 = null;
    L69:
        u1 r44 = r31.R;
        r310.c = r44.h;
        r44.h = 0;
        int r45 = com.bytedance.android.livesdk.gift.platform.core.utils.g.f(r39, r31.V);
        p0 r46 = r31.z;
        if (r46 == null) goto L72;
        com.bytedance.android.livesdk.gift.model.n r47 = r46.a;
    L73:
        o0 r48 = r31.y;
        if (r48 == null) goto L76;
        l1 r49 = r48.a;
    L77:
        if (r39 == null) goto L79;
        h1 r113 = r39.a;
    L80:
        if (r113 == null) goto L82;
        long r114 = r113.getDiamondCount();
    L83:
        if (r49 == null) goto L85;
        long r50 = r49.getBuffDiamondCount();
    L87:
        r114 = r114 + r50;
    L88:
        long r115 = r114;
        o0 r51 = r31.y;
        if (r51 == null) goto L91;
        l1 r53 = r51.a;
    L92:
        if (r39 == null) goto L94;
        h1 r54 = r39.a;
    L95:
        String r116 = com.bytedance.android.livesdk.gift.platform.core.utils.g.e(r53, r54, r31.H);
        p0 r55 = r31.z;
        if (r55 == null) goto L98;
        com.bytedance.android.livesdk.gift.model.n r56 = r55.a;
    L99:
        o0 r57 = r31.y;
        if (r57 == null) goto L102;
        l1 r58 = r57.a;
    L103:
        if (r39 == null) goto L107;
        h1 r117 = r39.a;
        if (r117 == null) goto L107;
        r23 = r117.getId();
    L107:
        String r214 = com.bytedance.android.livesdk.gift.platform.core.utils.g.j(r56, r58, r23);
        GiftConfirmService r118 = r31.W;
        if (r39 == null) goto L110;
        r2 = r39.a;
    L110:
        Observable<GiftConfirmService.ConfirmResult> r59 = r118.a(r2, r31.R, r115, r116, r214);
        Function1<GiftConfirmService.ConfirmResult, ObservableSource<com.bytedance.android.livesdk.gift.platform.business.f>> r60 = new GiftMVISearchViewModel$onComboing$1(r31);
        Lazy r61 = RxCompatKt.a;
        Intrinsics.checkNotNullParameter(r59, "$this$concatMapCompat");
        Intrinsics.checkNotNullParameter(r60, "mapper");
        RxUtilKt.c(r59.concatMap(new com.bytedance.android.live.core.utils.rxutils.n(r60), 2).map(new a(r31, r45, r39, r29, r26, r30, r210, r311, r310)).all(b.a).doAfterSuccess(new c(r39)).subscribe(new d(r31, r33, r38, r34, r35, r39, r36, r37, r310), RxUtil.getNoOpThrowable()), r31.C);
        return;
    L102:
        r58 = null;
        goto L103
    L98:
        r56 = null;
        goto L99
    L94:
        r54 = null;
        goto L95
    L91:
        r53 = null;
        goto L92
    L85:
        if (r47 == null) goto L88;
        r50 = r47.getTotalDiamonds();
        goto L87
    L82:
        r114 = 0;
        goto L83
    L79:
        r113 = null;
        goto L80
    L76:
        r49 = null;
        goto L77
    L72:
        r47 = null;
    L61:
        r29 = 0;
        goto L62
    L55:
        r25 = null;
        goto L56
    L45:
        r110 = null;
        goto L46
    L41:
        r19 = null;
        goto L42
    L37:
        r15 = null;
    L32:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(r31.G.a.getIdString(), null) == false) goto L34;
        com.bytedance.android.livesdk.gift.platform.core.utils.g.m(r39, 410, "ban send gift to self", r31.G, r31.T);
        r31.K0(new BanSendGiftSelfTipsEffect());
        return;
    L20:
        r10 = null;
        goto L22
    L114:
        return;
    L13:
        r8 = null;
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static void s1(GiftMVISearchViewModel r19, l0 r20, GiftSearchViewState r21, vz1.i r23, int r24, boolean r25, String r26, int r27, l1 r28, com.bytedance.android.livesdk.gift.model.n r29, int r210) {
        com.bytedance.android.livesdk.gift.model.n r3 = null;
        if ((r210 & 64) == 0) goto L5;
        l1 r2 = null;
    L7:
        if ((r210 & 128) != 0) goto L10;
        r3 = r29;
    L10:
        r19.getClass();
        r r1 = r20.i(r21);
        if ((r1 instanceof GiftSearchBusinessState.GiftSelected) == false) goto L48;
        int r4 = ((GiftSearchBusinessState.GiftSelected) r1).getSelectedPosition();
        if (com.bytedance.android.anya.h.a(r21.getSearchItemDataList()) <= r4) goto L50;
        if (r4 < 0) goto L51;
        u r5 = r21.getSearchItemDataList();
        MVIState r6 = (MVIState) ((s0) r5.c()).get(r4);
        new k0.a();     // Catch: Throwable -> L43
        ItemListData r7 = (ItemListData) r6;     // Catch: Throwable -> L43
        if (r25 == false) goto L19;
        int r8 = CardStatus.INSTANCE.getLOCK();     // Catch: Throwable -> L43
    L20:
        int r9 = r8;
        if (r3 == null) goto L24;
        String r10 = r3.getSendButtonText();     // Catch: Throwable -> L43
        if (r10 == null) goto L24;
    L25:
        String r13 = r10;
        int r11 = com.bytedance.android.livesdk.gift.platform.core.utils.g.a;     // Catch: Throwable -> L43
        vz1.a r18 = new vz1.a(r9, r26, r27, r13, false, null, null, com.bytedance.android.livesdk.gift.platform.core.utils.g.h(((vz1.e) r7.getItemData().c()).b, r2, r3, r19.H), 112);     // Catch: Throwable -> L43
        if (r23 != null) goto L28;
    L39:
        py.k r0 = ((vz1.e) r7.getItemData().c()).a.getImage();     // Catch: Throwable -> L43
        r7.getItemData().a(vz1.e.a((vz1.e) r7.getItemData().c(), TuplesKt.to(Integer.valueOf(r24), new vz1.i(null, r0, null, null, 13)), 0, 0, 0, r18, 66060283));     // Catch: Throwable -> L43
    L41:
        if ((!r6.modifiedProperties.isEmpty()) == false) goto L52;
        ((com.bytedance.android.anya.internal.t) r5.c()).d(r4);
        return;
    L52:
        return;
    L28:
        if (r23.getType() != ImageType.ImageModel) goto L34;
        py.k r14 = r23.b;     // Catch: Throwable -> L43
        if (r14 == null) goto L39;
        if (r14.isValid() != true) goto L39;
    L34:
        if (r23.getType() == ImageType.BitMap) goto L36;
    L38:
        r7.getItemData().a(vz1.e.a((vz1.e) r7.getItemData().c(), TuplesKt.to(Integer.valueOf(r24), r23), 0, 0, 0, r18, 66060283));     // Catch: Throwable -> L43
        goto L41
    L36:
        if (r23.d != null) goto L38;
    L24:
        r10 = BuildConfig.FLAVOR;
        goto L25
    L19:
        r8 = CardStatus.INSTANCE.getUNLOCK();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if ((!r6.modifiedProperties.isEmpty()) == false) goto L47;
        ((com.bytedance.android.anya.internal.t) r5.c()).d(r4);
    L47:
        throw th;
    L51:
        return;
    L50:
        return;
    L48:
        return;
    L5:
        r2 = r28;
        goto L7
    }

    public GiftMVISearchViewModel(GiftSearchDataStore r17, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r18, GiftExtraRepo r19, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r20, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r21, com.bytedance.android.livesdk.gift.platform.core.giftlist.i r23, e1 r24, yz0.k r25, h0 r26, GiftDialogStateDataStore r27, u0 r28, xz1.c r29, u1 r210, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r30, r3 r31, GiftSendPreCheckService r33, GiftGroupCardDataStore r34, GiftConfirmService r35, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b r36, GiftMVICarnivalDataStore r37, GiftListSortDataStore r38, GiftListPanelRepository r39, y r310, OpenDialogService r40) {
        Intrinsics.checkNotNullParameter(r17, "giftSearchDataStore");
        Intrinsics.checkNotNullParameter(r18, "receiverService");
        Intrinsics.checkNotNullParameter(r19, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r20, "giftDIYDataStore");
        Intrinsics.checkNotNullParameter(r21, "cardDataStore");
        Intrinsics.checkNotNullParameter(r23, "giftListRepository");
        Intrinsics.checkNotNullParameter(r24, "giftListService");
        Intrinsics.checkNotNullParameter(r25, "roomDataService");
        Intrinsics.checkNotNullParameter(r26, "panelSendGiftRepo");
        Intrinsics.checkNotNullParameter(r27, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r28, "internalScopeService");
        Intrinsics.checkNotNullParameter(r29, "giftExtraInterfaceMonitor");
        Intrinsics.checkNotNullParameter(r210, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r30, "allMicService");
        Intrinsics.checkNotNullParameter(r31, "giftSendService");
        Intrinsics.checkNotNullParameter(r33, "sendPreCheckService");
        Intrinsics.checkNotNullParameter(r34, "giftGroupCardDataStore");
        Intrinsics.checkNotNullParameter(r35, "giftConfirmService");
        Intrinsics.checkNotNullParameter(r36, "buffRepository");
        Intrinsics.checkNotNullParameter(r37, "giftMVICarnivalDataStore");
        Intrinsics.checkNotNullParameter(r38, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r39, "listPanelRepository");
        Intrinsics.checkNotNullParameter(r310, "giftSelectReceiverService");
        Intrinsics.checkNotNullParameter(r40, "openDialogService");
        this.F = r17;
        this.G = r18;
        this.H = r19;
        this.I = r20;
        this.J = r21;
        this.K = r23;
        this.L = r24;
        this.M = r25;
        this.N = r26;
        this.O = r27;
        this.P = r28;
        this.Q = r29;
        this.R = r210;
        this.S = r30;
        this.T = r31;
        this.U = r33;
        this.V = r34;
        this.W = r35;
        this.X = r36;
        this.Y = r37;
        this.Z = r38;
        this.k0 = r39;
        this.p0 = r310;
        this.H0 = r40;
        this.u = nz1.b.a();
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L12;
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.isVS();
        if (r5 == null) goto L11;
        if (((Boolean) r5.getValue()).booleanValue() == true) goto L12;
    L11:
        boolean r6 = false;
    L13:
        this.v = r6;
        this.w = r25.getRoom();
        this.x = new n();
        this.A = -1;
        this.B = GiftTopViewState.Mode.Default;
        this.C = new CompositeDisposable();
        this.E = SetsKt.setOf(new BaseMVIDataStore[]{r17, r21, r19, r34, r27});
        return;
    L12:
        r6 = true;
        goto L13
    }
}
