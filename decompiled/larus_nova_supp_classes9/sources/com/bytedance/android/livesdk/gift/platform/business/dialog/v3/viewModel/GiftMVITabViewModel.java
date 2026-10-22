package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import android.text.TextUtils;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.e0;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t;
import com.bytedance.android.anya.t0;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.c3;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.o2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.q0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CleanTabShowRange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchConfigData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnPageScrollGuideAnimationEnd;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnTabItemVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ReScroll;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshPropList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollGuideState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollGuideStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicLabelStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdatePanelGiftList;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.m;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.d1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITabViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftTabViewState, GiftAction> implements o {
    public static final /* synthetic */ int O = 0;
    public final DataCenter A;
    public final u1 B;
    public final g1 C;
    public final e1 D;
    public final LocateGiftInfo E;
    public final yz0.k F;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.h G;
    public final GiftListRepository H;
    public final GiftDialogStateDataStore I;
    public final GiftDataStorageService J;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.g K;
    public final GiftTopicDataStore L;
    public final q0 M;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f N;
    public boolean u;
    public boolean v;
    public final int w;
    public final Map<Integer, Integer> x;
    public final Set<Integer> y;
    public final Set<BaseMVIDataStore<?>> z;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.z;
    }

    public final MVIState F(l0 r9) {
        Intrinsics.checkNotNullParameter(r9, "$this$createState");
        GiftTabViewState r0 = new GiftTabViewState();
        ReceiverType r1 = this.N.b;
        List<w1> r2 = this.G.Mn(r1).c;
        List<w1> r3 = r2;
        boolean r4 = false;
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
        A1(r9, r2, r0);
        z1(r9, r0, 0);
    L11:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r6 = this.H.k;
        if (r6 == null) goto L14;
        m r7 = r6.d;
    L15:
        if (r7 == null) goto L24;
        r0<GiftTabViewState, GiftSearchConfigData> r8 = r0.getGiftSearchConfig();
        py.k r10 = r7.getIcon();
        String r11 = r7.getSchema();
        Boolean r13 = r7.getCloseGiftPanel();
        if (r13 == null) goto L19;
        boolean r14 = r13.booleanValue();
    L20:
        Boolean r15 = r7.isNormalSearch();
        if (r15 == null) goto L23;
        r4 = r15.booleanValue();
    L23:
        GiftSearchConfigData r16 = new GiftSearchConfigData(r10, r11, r14, r4);
        r9.getClass();
        l0.h(r8, r16);
        goto L24
    L19:
        r14 = false;
    L24:
        return r0;
    L14:
        r7 = null;
        goto L15
    L5:
        if (r3.isEmpty() == true) goto L8;
        r5 = false;
        goto L9
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITabViewModel$bindToParent$1 r0 = GiftMVITabViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final ScrollGuideState h1(int r10) {
        if (r10 != 15) goto L6;
        GiftTopicDataStore r0 = this.L;
        return new ScrollGuideState((ScrollGuideStatus) r0.r.getValue(r0, GiftTopicDataStore.D[10]), this.L.J(), Long.valueOf(this.L.t));
    L6:
        return new ScrollGuideState(null, null, null, 7, null);
    }

    public final void q(com.bytedance.android.anya.dsl.l<GiftTabViewState, r, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$buildStateMachine");
        if (v.f() == false) goto L5;
        return;
    L5:
        Function1<com.bytedance.android.anya.dsl.l<GiftTabViewState, r, GiftAction>.a<GiftTabBusinessState.Idle>, Unit> r0 = new GiftMVITabViewModel$buildStateMachine$1(this);
        LinkedHashMap r1 = r5.a;
        com.bytedance.android.anya.dsl.l.a r3 = new com.bytedance.android.anya.dsl.l.a();
        r0.invoke(r3);
        r1.put(GiftTabBusinessState.Idle.class, r3.a);
        Function1<com.bytedance.android.anya.dsl.l<GiftTabViewState, r, GiftAction>.a<GiftTabBusinessState.TabSelected>, Unit> r2 = new GiftMVITabViewModel$buildStateMachine$2(this);
        LinkedHashMap r6 = r5.a;
        com.bytedance.android.anya.dsl.l.a r4 = new com.bytedance.android.anya.dsl.l.a();
        r2.invoke(r4);
        r6.put(GiftTabBusinessState.TabSelected.class, r4.a);
    }

    public final int s1(int r5) {
        Iterator r0 = ((LinkedHashMap) this.D.c).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        int r1 = ((Number) r0.next()).intValue();
        Map<Integer, Integer> r2 = this.D.c;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        Integer r4 = (Integer) r3.get(Integer.valueOf(r1));
        if (r4 == null) goto L4;
        if (r4.intValue() != r5) goto L4;
        return r1;
    L11:
        return -1;
    }

    public final int t1(int r3) {
        int r1 = 0;
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().i() == false) goto L13;
        GiftDataStorageService r0 = this.J;
        if (r0 == null) goto L10;
        Map<Integer, Integer> r2 = r0.g;
        LinkedHashMap r4 = (LinkedHashMap) r2;
        Integer r5 = (Integer) r4.get(Integer.valueOf(r3));
        if (r5 == null) goto L9;
        r1 = r5.intValue();
    L9:
        Integer r6 = Integer.valueOf(r1);
    L12:
        return r6.intValue();
    L10:
        r6 = null;
        goto L12
    L13:
        Map<Integer, Integer> r7 = this.x;
        LinkedHashMap r8 = (LinkedHashMap) r7;
        Integer r9 = (Integer) r8.get(Integer.valueOf(r3));
        if (r9 != null) goto L16;
        return 0;
    L16:
        return r9.intValue();
    }

    public final int u1(int r2) {
        Map<Integer, Integer> r0 = this.D.c;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Integer r3 = (Integer) r1.get(Integer.valueOf(r2));
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.intValue();
    }

    public final void J0(com.bytedance.android.anya.internal.e r6, MVIState r7) {
        final GiftTabViewState r8 = (GiftTabViewState) r7;
        Intrinsics.checkNotNullParameter(r6, "$this$reduce");
        Intrinsics.checkNotNullParameter(r8, "state");
        if (v.e() == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.g r0 = this.K;
        r6.e((t) r0.e.getValue(r0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.g.j[0]), new GiftMVITabViewModel$reduce$1(this, r8));
    L6:
        if (v.g() == false) goto L9;
        r6.d(this.L.L(), this.L.F(), new GiftMVITabViewModel$reduce$2(this, r8));
        GiftTopicDataStore r1 = this.L;
        ReadOnlyProperty r2 = r1.q;
        KProperty[] r3 = GiftTopicDataStore.D;
        t r4 = (t) r2.getValue(r1, r3[9]);
        GiftTopicDataStore r5 = this.L;
        r6.d(r4, (t) r5.p.getValue(r5, r3[8]), new GiftMVITabViewModel$reduce$3(this, r8));
        return;
    }

    public final TopicLabelStatus e1(boolean r1, List<? extends d2> r2) {
        List<? extends d2> r3 = r2;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L23;
        if (v.g() == false) goto L23;
        if (r1 == true) goto L17;
        return TopicLabelStatus.ARROW_DOWN;
    L17:
        if (this.L.U() == false) goto L21;
        return TopicLabelStatus.ARROW_UP;
    L21:
        return TopicLabelStatus.ARROW_DOWN;
    L23:
        return TopicLabelStatus.ARROW_GONE;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    public final void A1(l0<GiftTabViewState> r23, List<? extends w1> r24, GiftTabViewState r25) {
        GiftTabItem r2 = null;
        if (r24.isEmpty() == false) goto L5;
        List<? extends w1> r1 = r24;
    L7:
        if (r1 == null) goto L12;
        t0<GiftTabViewState, GiftTabItem> r3 = r25.getGiftTabItemList();
        r23.getClass();
        if (com.bytedance.android.anya.h.a(r3) != 0) goto L209;
        u r4 = r25.getGiftTabItemList();
        GiftTabItem r5 = new GiftTabItem();
        new k0.a();
        r5.getTitle().a("礼物");
        r5.getOrderIcon().a(0);
        r5.getSelected().a(Boolean.TRUE);
        r5.getShowRedDot().a(Boolean.FALSE);
        Unit r6 = Unit.INSTANCE;
        ((e0) r4.c()).add(r5);
        return;
    L209:
        return;
    L12:
        ArrayList r7 = new ArrayList();
        List<? extends w1> r8 = r24;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L14:
        if (r10.hasNext() == false) goto L42;
        Object r11 = r10.next();
        w1 r13 = (w1) r11;
        if (r13.getDisplay() == false) goto L39;
        List<c3> r14 = r13.getSectionList();
        if (r14 != null) goto L20;
    L23:
        boolean r15 = true;
    L24:
        if (r15 == true) goto L38;
        List<c3> r16 = r13.getSectionList();
        if (r16 == null) goto L32;
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L29:
        if (r18.hasNext() == false) goto L31;
        CollectionsKt.addAll(r17, ((c3) r18.next()).d());
        goto L29
    L31:
        int r19 = r17.size();
    L34:
        if (r19 < this.w) goto L36;
        boolean r20 = true;
    L37:
        if (r20 == false) goto L39;
    L36:
        r20 = false;
        goto L37
    L32:
        r19 = 0;
    L38:
        boolean r21 = true;
    L40:
        if (r21 == false) goto L14;
        r9.add(r11);
        goto L14
    L20:
        if (r14.isEmpty() == true) goto L23;
        r15 = false;
    L39:
        r21 = false;
        goto L40
    L42:
        r0<GiftTabViewState, Integer> r26 = r25.getTabType();
        r23.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r26)).intValue() == 0) goto L56;
        Iterator r27 = r9.iterator();
    L46:
        if (r27.hasNext() == false) goto L53;
        Object r28 = r27.next();
        if (((w1) r28).getPageType() != ((Number) com.bytedance.android.anya.h.b(r25.getTabType())).intValue()) goto L50;
        boolean r29 = true;
    L51:
        if (r29 == false) goto L46;
    L54:
        if (r28 != null) goto L56;
        boolean r30 = true;
    L57:
        Iterator r31 = r9.iterator();
        int r33 = 0;
    L59:
        if (r31.hasNext() == false) goto L148;
        Object r34 = r31.next();
        int r110 = r33 + 1;
        if (r33 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        w1 r35 = (w1) r34;
        this.D.c.put(Integer.valueOf(r7.size()), Integer.valueOf(r35.getPageType()));
        GiftTabItem r111 = new GiftTabItem();
        new k0.a();
        r111.getTitle().a(r35.getPageName());
        com.bytedance.android.anya.internal.c r112 = r111.getOrderIcon();
        int r113 = r7.size();
        Integer r114 = Integer.valueOf(t1(r7.size()));
        int r115 = r35.getPageType();
        int r36 = ((Number) r25.getTabType().c()).intValue();
        if (com.bytedance.android.livesdk.gift.platform.core.h.n().i() == false) goto L67;
        if (r115 != r36) goto L67;
        boolean r37 = true;
    L68:
        r112.a(Integer.valueOf(x1(r113, r114, r37)));
        r111.getOrderRule().a(Integer.valueOf(t1(r7.size())));
        com.bytedance.android.anya.internal.c r38 = r111.getSelected();
        if (r30 == false) goto L73;
        if (r33 == 0) goto L74;
    L75:
        boolean r116 = false;
    L76:
        r38.a(Boolean.valueOf(r116));
        com.bytedance.android.anya.internal.c r39 = r111.getShowRedDot();
        if (this.v == false) goto L83;
        if (r35.getPageType() != 5) goto L83;
        GiftTabItem r117 = r2;
        com.bytedance.android.anya.internal.c r118 = r39;
    L134:
        boolean r40 = true;
    L137:
        r118.a(Boolean.valueOf(r40));
        com.bytedance.android.anya.internal.c r41 = r111.getTopicLabelIconStatus();
        if (r35.getPageType() != ((Number) r25.getTabType().c()).intValue()) goto L140;
        boolean r43 = true;
    L141:
        r41.a(e1(r43, r35.getTopicList()));
        r111.getScrollGuideState().a(h1(r35.getPageType()));
        if (((Boolean) com.bytedance.android.anya.h.b(r111.getShowRedDot())).booleanValue() == false) goto L144;
        GiftTabItem r44 = r111;
    L145:
        if (r44 == null) goto L147;
        c0 r45 = c0.a;
        c0.f(r35.getPageType());
    L147:
        r7.add(r111);
        r33 = r110;
        r2 = r117;
        goto L59
    L144:
        r44 = r117;
        goto L145
    L140:
        r43 = false;
    L83:
        if (r35.getPageType() != 13) goto L128;
        int r119 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k0.a;
        if (((Boolean) nz1.a.I.getValue(r2, nz1.a.a[33])).booleanValue() == false) goto L90;
        HashSet r120 = (HashSet) ay1.b.g0.getValue(r2, ay1.b.a[70]);
        if (r120.isEmpty() == false) goto L91;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k0.a(r35);
        goto L90
    L91:
        Iterator r121 = r120.iterator();
    L93:
        if (r121.hasNext() == false) goto L103;
        String r122 = (String) r121.next();
        Iterator<T> r123 = r35.getGifts().iterator();
    L96:
        if (r123.hasNext() == false) goto L100;
        Object r124 = r123.next();
        if (TextUtils.equals(r122, String.valueOf(((h1) r124).getId())) == false) goto L96;
    L101:
        if (r124 != null) goto L93;
        r121.remove();
        goto L93
    L100:
        r124 = r2;
        goto L101
    L103:
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        ay1.b.g0.setValue(r2, ay1.b.a[70], r120);
        Iterator<h1> r46 = r35.getGifts().iterator();
    L105:
        if (r46.hasNext() == false) goto L115;
        h1 r125 = r46.next();
        if (r125.isDisplayedOnPanel() == false) goto L105;
        r118 = r39;
        if (((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).g1(r125.getPrimaryEffectId()) == true) goto L112;
    L114:
        r39 = r118;
        goto L105
    L112:
        if (r120.contains(String.valueOf(r125.getId())) == true) goto L114;
        boolean r47 = true;
    L116:
        if (r47 == false) goto L123;
        com.bytedance.tools.kcp.spongepreference.runtime.a r48 = ay1.b.h0;
        KProperty[] r49 = ay1.b.a;
        long r126 = ((Number) r48.getValue(null, r49[71])).longValue();
        if (r126 > 0) goto L121;
    L124:
        r48.setValue(null, r49[71], Long.valueOf(System.currentTimeMillis()));
        boolean r50 = true;
    L125:
        if (r50 == false) goto L130;
        r117 = null;
    L130:
        if (r35.getPageType() != 17) goto L135;
        if (r33 == 0) goto L135;
        r117 = null;
        if (((Boolean) ay1.b.v0.getValue(null, ay1.b.a[88])).booleanValue() == true) goto L134;
    L136:
        r40 = false;
    L135:
        r117 = null;
        goto L136
    L121:
        if ((System.currentTimeMillis() - r126) <= (((((Number) nz1.a.H.getValue(null, nz1.a.a[32])).intValue() * 60) * 60) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) goto L124;
        r48.setValue(null, r49[71], 0L);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k0.a(r35);
    L123:
        r50 = false;
        goto L125
    L115:
        r118 = r39;
        r47 = false;
    L90:
        r118 = r39;
        goto L123
    L128:
        r118 = r39;
    L74:
        r116 = true;
        goto L76
    L73:
        if (r35.getPageType() != ((Number) r25.getTabType().c()).intValue()) goto L75;
    L67:
        r37 = false;
        goto L68
    L148:
        GiftTabItem r127 = r2;
        if (((Number) com.bytedance.android.anya.h.b(r25.getTabType())).intValue() != 0) goto L172;
        Iterator<T> r51 = r8.iterator();
    L152:
        if (r51.hasNext() == false) goto L159;
        Object r53 = r51.next();
        if (((w1) r53).getPageType() != this.E.getTargetPageType()) goto L156;
        boolean r54 = true;
    L157:
        if (r54 == false) goto L152;
        Object r55 = r53;
    L160:
        w1 r56 = (w1) r55;
        if (r56 != null) goto L163;
    L165:
        boolean r57 = false;
    L166:
        if (r57 == false) goto L172;
        l0.h(r25.getTabType(), Integer.valueOf(this.E.getTargetPageType()));
        GiftContext r58 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r58 == null) goto L172;
        com.bytedance.live.datacontext.m<Integer> r59 = r58.getPageType();
        if (r59 == null) goto L172;
        r59.setValue(Integer.valueOf(this.E.getTargetPageType()));
        goto L172
    L163:
        if (r56.getDisplay() != true) goto L165;
        r57 = true;
        goto L166
    L156:
        r54 = false;
        goto L157
    L159:
        r55 = r127;
    L172:
        l0.g(r25.getGiftTabItemList(), r7);
        K0(new CleanTabShowRange());
        if (r30 == false) goto L210;
        z1(r23, r25, 0);
        return;
    L210:
        return;
    L50:
        r29 = false;
        goto L51
    L53:
        r28 = null;
    L56:
        r30 = false;
        goto L57
    L5:
        r1 = null;
        goto L7
    }

    public final /* bridge */ /* synthetic */ void w0(j0 r1, MVIState r2, p r3) {
        w1(r1, (GiftTabViewState) r2, (GiftAction) r3);
    }

    public final void w1(j0<GiftTabViewState> r23, GiftTabViewState r24, GiftAction r25) {
        Intrinsics.checkNotNullParameter(r23, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r24, "state");
        Intrinsics.checkNotNullParameter(r25, "action");
        if (v.f() == false) goto L5;
        return;
    L5:
        com.bytedance.android.anya.internal.p r3 = r23.getContext();
        com.bytedance.android.anya.internal.c r4 = (com.bytedance.android.anya.v) r3.a(r3.b(r3.c(GiftPanelState.class), GiftMVITabViewModel$postReduce$1$tmp$1.INSTANCE), GiftMVITabViewModel$postReduce$1$tmp$2.INSTANCE).a.invoke();
        if (r4 == null) goto L73;
        com.bytedance.android.anya.internal.c r5 = r4;
        Object r6 = r4.c();     // Catch: Throwable -> L67
        int r7 = r4.c;     // Catch: Throwable -> L67
        Object r8 = ((LinkedHashMap) r23.d).get(r4);     // Catch: Throwable -> L67
        if (r8 != null) goto L13;
        r8 = 0;     // Catch: Throwable -> L67
    L13:
        if (r7 <= ((Number) r8).intValue()) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L63;
        j0.a r10 = j0.a.a;     // Catch: Throwable -> L67
        GiftVerticalState r11 = (GiftVerticalState) r6;     // Catch: Throwable -> L67
        com.bytedance.android.anya.internal.p r13 = r23.getContext();     // Catch: Throwable -> L67
        com.bytedance.android.anya.internal.c r14 = (com.bytedance.android.anya.v) r13.a(r13.b(r13.c(GiftPanelState.class), GiftMVITabViewModel$postReduce$2$1$1.INSTANCE), GiftMVITabViewModel$postReduce$2$1$2.INSTANCE).a.invoke();     // Catch: Throwable -> L67
        if (r14 == null) goto L63;
        com.bytedance.android.anya.internal.c r15 = r14;     // Catch: Throwable -> L67
        Object r16 = r14.c();     // Catch: Throwable -> L60
        int r17 = r14.c;     // Catch: Throwable -> L60
        Object r18 = ((LinkedHashMap) r23.d).get(r14);     // Catch: Throwable -> L60
        if (r18 != null) goto L25;
        r18 = 0;     // Catch: Throwable -> L60
    L25:
        if (r17 <= ((Number) r18).intValue()) goto L27;
        boolean r19 = true;
    L28:
        if (r19 == false) goto L57;
        GiftVerticalState r20 = (GiftVerticalState) r16;     // Catch: Throwable -> L60
        l0<GiftTabViewState> r110 = r23.g;     // Catch: Throwable -> L60
        GiftTabViewState r111 = (GiftTabViewState) r110.f();     // Catch: Throwable -> L60
        r r112 = r110.i(r24);     // Catch: Throwable -> L60
        r r113 = r110.i(r20);     // Catch: Throwable -> L60
        if ((r112 instanceof GiftTabBusinessState.TabSelected) == false) goto L32;
        int r114 = ((GiftTabBusinessState.TabSelected) r112).getPosition();     // Catch: Throwable -> L60
    L34:
        if (r114 == ((Number) com.bytedance.android.anya.h.b(r20.getCurrentPagePosition())).intValue()) goto L57;
        String r115 = null;
        if (((Number) com.bytedance.android.anya.h.b(r20.getCurrentPagePosition())).intValue() >= com.bytedance.android.anya.h.a(r24.getGiftTabItemList())) goto L46;
        k0 r116 = r110.b;     // Catch: Throwable -> L60
        t0<GiftTabViewState, GiftTabItem> r117 = r24.getGiftTabItemList();     // Catch: Throwable -> L60
        r0<GiftVerticalState, Integer> r118 = r20.getCurrentPagePosition();     // Catch: Throwable -> L60
        r116.getClass();     // Catch: Throwable -> L60
        ScrollGuideState r119 = (ScrollGuideState) com.bytedance.android.anya.h.b(((GiftTabItem) k0.d(r117, ((Number) com.bytedance.android.anya.h.b(r118)).intValue())).getScrollGuideState());     // Catch: Throwable -> L60
        if (r119.getEndTime() != null) goto L40;
    L43:
        o2 r120 = r119.getScrollGuideInfo();     // Catch: Throwable -> L60
        if (r120 == null) goto L46;
        r115 = r120.getName();     // Catch: Throwable -> L60
        goto L46
    L40:
        if (r119.getEndTime().longValue() <= 0) goto L43;
        if (System.currentTimeMillis() < (r119.getEndTime().longValue() + com.bytedance.android.livesdk.gift.configmodel.k0.a(com.bytedance.android.livesdk.gift.platform.core.h.l()))) goto L43;
    L46:
        String r121 = r115;
        z1(r110, r24, ((Number) com.bytedance.android.anya.h.b(r20.getCurrentPagePosition())).intValue());     // Catch: Throwable -> L60
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L60
        if ((r113 instanceof GiftListBusinessState.GiftSelected) == true) goto L49;
    L50:
        u1 r123 = this.B;     // Catch: Throwable -> L60
        int r124 = u1(((Number) com.bytedance.android.anya.h.b(r20.getCurrentPagePosition())).intValue());     // Catch: Throwable -> L60
        int r125 = ((Number) com.bytedance.android.anya.h.b(r24.getTabType())).intValue();     // Catch: Throwable -> L60
        String r126 = this.N.d().getIdString();     // Catch: Throwable -> L60
        IRoom r127 = this.F.getRoom();     // Catch: Throwable -> L60
        if (u1(((Number) com.bytedance.android.anya.h.b(r20.getCurrentPagePosition())).intValue()) == 5) goto L53;
    L55:
        boolean r128 = false;
    L56:
        u1.f1(r123, r124, r125, "click", r126, r127, r128, r121, 256);     // Catch: Throwable -> L60
        goto L57
    L53:
        if (com.bytedance.android.anya.h.a(r24.getGiftTabItemList()) <= 0) goto L55;
        r128 = true;
        goto L56
    L49:
        if (((GiftListBusinessState.GiftSelected) r113).getSelectedStatus() == SelectedStatus.LOCATE) goto L57;
    L32:
        r114 = -1;
    L57:
        if (r19 == false) goto L59;
        r23.a();     // Catch: Throwable -> L60
    L59:
        r23.c.put(r14, Integer.valueOf(r14.c));     // Catch: Throwable -> L67
        goto L63
    L27:
        r19 = false;
    L60:
        th = move-exception;
        r23.c.put(r14, Integer.valueOf(r14.c));     // Catch: Throwable -> L67
        throw th;     // Catch: Throwable -> L67
    L63:
        if (r9 == false) goto L65;
        r23.a();     // Catch: Throwable -> L67
    L65:
        r23.c.put(r4, Integer.valueOf(r5.c));
        return;
    L15:
        r9 = false;
    L67:
        th = move-exception;
        r23.c.put(r4, Integer.valueOf(r5.c));
        throw th;
    }

    public final int x1(int r2, Integer r3, boolean r4) {
        Map<Integer, Integer> r0 = tz1.a.a;
        if (tz1.a.d(u1(r2)) == true) goto L7;
        return 0;
    L7:
        if (r4 == true) goto L9;
        return 2131250705;
    L9:
        if (r3 != null) goto L12;
    L14:
        if (r3 != null) goto L17;
    L19:
        if (r3 != null) goto L22;
        return 2131250705;
    L22:
        if (r3.intValue() != 2) goto L26;
        return 2131250706;
    L26:
        return 2131250705;
    L17:
        if (r3.intValue() != 1) goto L19;
        return 2131250689;
    L12:
        if (r3.intValue() != 0) goto L14;
        return 2131250705;
    }

    public final void y0(final l0 r9, MVIState r10, p r11) {
        final GiftTabViewState r13 = (GiftTabViewState) r10;
        final GiftAction r14 = (GiftAction) r11;
        Intrinsics.checkNotNullParameter(r9, "$this$reduce");
        Intrinsics.checkNotNullParameter(r13, "state");
        Intrinsics.checkNotNullParameter(r14, "action");
        if (v.f() == true) goto L111;
        Object r1 = null;
        m r2 = null;
        boolean r3 = true;
        boolean r4 = false;
        if ((r14 instanceof UpdatePanelGiftList) == false) goto L34;
        UpdatePanelGiftList r5 = (UpdatePanelGiftList) r14;
        List<w1> r0 = this.G.Mn(r5.getReceiverType()).c;
        List<w1> r6 = r0;
        if (r6 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
    L19:
        if (r3 == true) goto L21;
        A1(r9, r0, r13);
    L21:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.a r8 = this.H.k;
        if (r8 == null) goto L24;
        r2 = r8.d;
    L24:
        if (r2 == null) goto L103;
        r0<GiftTabViewState, GiftSearchConfigData> r15 = r13.getGiftSearchConfig();
        py.k r16 = r2.getIcon();
        String r17 = r2.getSchema();
        Boolean r18 = r2.getCloseGiftPanel();
        if (r18 == null) goto L28;
        boolean r19 = r18.booleanValue();
    L29:
        Boolean r20 = r2.isNormalSearch();
        if (r20 == null) goto L32;
        r4 = r20.booleanValue();
    L32:
        GiftSearchConfigData r21 = new GiftSearchConfigData(r16, r17, r19, r4);
        r9.getClass();
        l0.h(r15, r21);
        goto L103
    L28:
        r19 = false;
    L103:
        T0(r13, r14);
        return;
    L16:
        if (this.N.b != r5.getReceiverType()) goto L19;
        r3 = false;
        goto L19
    L10:
        if (r6.isEmpty() == true) goto L13;
        r7 = false;
        goto L14
    L34:
        if ((r14 instanceof RefreshGiftList) == false) goto L44;
        RefreshGiftList r23 = (RefreshGiftList) r14;
        if (r23.getScene() != 0) goto L40;
        t0<GiftTabViewState, GiftTabItem> r24 = r13.getGiftTabItemList();
        r9.getClass();
        if (com.bytedance.android.anya.h.a(r24) <= 0) goto L40;
    L41:
        if (r3 == true) goto L103;
        A1(r9, r23.getGiftPages(), r13);
    L40:
        r3 = false;
        goto L41
    L44:
        if ((r14 instanceof RefreshPropList) == false) goto L90;
        if (this.u == true) goto L103;
        i12.e r25 = i12.o.b();
        if (r25 == null) goto L50;
        Object r26 = com.bytedance.android.scope.m.e.d(r25, PropListService.class);
    L51:
        PropListService r27 = (PropListService) r26;
        if (r27 != null) goto L54;
    L55:
        i12.e r28 = i12.o.b();
        if (r28 == null) goto L58;
        r1 = com.bytedance.android.scope.m.e.d(r28, PropListService.class);
    L58:
        PropListService r29 = (PropListService) r1;
        if (r29 != null) goto L61;
    L63:
        boolean r30 = false;
    L64:
        this.v = r30;
        if (r30 == false) goto L88;
        u r31 = r13.getGiftTabItemList();
        Iterator r33 = ((Iterable) r31.c()).iterator();
        int r34 = 0;
    L68:
        if (r33.hasNext() == false) goto L88;
        Object r35 = r33.next();
        int r36 = r34 + 1;
        if (r34 >= 0) goto L72;
        CollectionsKt.throwIndexOverflow();
    L72:
        MVIState r37 = (MVIState) r35;
        GiftTabItem r38 = (GiftTabItem) r37;
        if (u1(r34) != 5) goto L75;
        boolean r39 = true;
    L76:
        if (r39 == false) goto L82;
        new k0.a();     // Catch: Throwable -> L83
        ((GiftTabItem) r37).getShowRedDot().a(Boolean.TRUE);     // Catch: Throwable -> L83
        if ((!r37.modifiedProperties.isEmpty()) == false) goto L82;
        ((com.bytedance.android.anya.internal.t) r31.c()).d(r34);
    L83:
        th = move-exception;
        if ((!r37.modifiedProperties.isEmpty()) == false) goto L87;
        ((com.bytedance.android.anya.internal.t) r31.c()).d(r34);
    L87:
        throw th;
    L82:
        r34 = r36;
        goto L68
    L75:
        r39 = false;
    L88:
        this.u = true;
        goto L103
    L61:
        if (r29.h() != true) goto L63;
    L62:
        r30 = true;
        goto L64
    L54:
        if (r27.g(PropListService.ExpirePropShowType.RED_DOT) == true) goto L62;
    L50:
        r26 = null;
        goto L51
    L90:
        if ((r14 instanceof ReScroll) == false) goto L95;
        r0<GiftTabViewState, Integer> r40 = r13.getSelectPosition();
        r9.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r40)).intValue() == (-1)) goto L103;
        z1(r9, r13, ((Number) com.bytedance.android.anya.h.b(r13.getSelectPosition())).intValue());
        goto L103
    L95:
        if ((r14 instanceof OnPageScrollGuideAnimationEnd) == false) goto L98;
        GiftTopicDataStore r41 = this.L;
        r41.o(ScrollGuideStatus.END, r41.J());
        goto L103
    L98:
        if ((r14 instanceof OnTabItemVisibleChanged) == false) goto L103;
        if (Intrinsics.areEqual(((OnTabItemVisibleChanged) r14).getCurrentShowRange(), new IntRange(-1, -1)) == true) goto L112;
        GiftPanelBizBoostUtils.E.getClass();
        final boolean r43 = GiftPanelBizBoostUtils.b().f9();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g.a(r43, new GiftMVITabViewModel$reduce$7(this, r9, r14, r13, r43));
        goto L103
    L112:
        return;
    }

    public final void z1(l0<GiftTabViewState> r13, GiftTabViewState r14, int r15) {
        t0<GiftTabViewState, GiftTabItem> r1 = r14.getGiftTabItemList();
        r13.getClass();
        if (r15 < com.bytedance.android.anya.h.a(r1)) goto L5;
        return;
    L5:
        u r2 = r14.getGiftTabItemList();
        Iterator r3 = ((Iterable) r2.c()).iterator();
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r3.hasNext() == false) goto L24;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        MVIState r8 = (MVIState) r6;
        if (((Boolean) com.bytedance.android.anya.h.b(((GiftTabItem) r8).getSelected())).booleanValue() == false) goto L18;
        new k0.a();     // Catch: Throwable -> L19
        ((GiftTabItem) r8).getSelected().a(Boolean.FALSE);     // Catch: Throwable -> L19
        if ((!r8.modifiedProperties.isEmpty()) == false) goto L18;
        ((com.bytedance.android.anya.internal.t) r2.c()).d(r5);
    L19:
        th = move-exception;
        if ((!r8.modifiedProperties.isEmpty()) == false) goto L23;
        ((com.bytedance.android.anya.internal.t) r2.c()).d(r5);
    L23:
        throw th;
    L18:
        r5 = r7;
        goto L7
    L24:
        l0.h(r14.getSelectPosition(), -1);
        this.I.L(-1, -1);
        if (v.f() == true) goto L27;
        this.I.L(u1(r15), r15);
    L27:
        u r9 = r14.getGiftTabItemList();
        MVIState r10 = (MVIState) ((s0) r9.c()).get(r15);
        new k0.a();     // Catch: Throwable -> L186
        GiftTabItem r11 = (GiftTabItem) r10;     // Catch: Throwable -> L186
        r11.getSelected().a(Boolean.TRUE);     // Catch: Throwable -> L186
        u1 r16 = this.B;     // Catch: Throwable -> L186
        boolean r17 = ((Boolean) r11.getShowRedDot().c()).booleanValue();     // Catch: Throwable -> L186
        Map<String, String> r18 = r16.a;     // Catch: Throwable -> L186
        String r19 = "1";
        if (r17 == false) goto L32;
        String r20 = "1";
    L33:
        r18.put("red_dot", r20);     // Catch: Throwable -> L186
        g1 r21 = this.C;     // Catch: Throwable -> L186
        boolean r23 = ((Boolean) r11.getShowRedDot().c()).booleanValue();     // Catch: Throwable -> L186
        Map<String, String> r24 = r21.a;     // Catch: Throwable -> L186
        if (r23 == true) goto L37;
        r19 = "0";
    L37:
        r24.put("red_dot", r19);     // Catch: Throwable -> L186
        r11.getTopicLabelIconStatus().a(e1(true, this.M.a(u1(r15))));     // Catch: Throwable -> L186
        r11.getScrollGuideState().a(h1(u1(r15)));     // Catch: Throwable -> L186
        if ((!r10.modifiedProperties.isEmpty()) == false) goto L41;
        ((com.bytedance.android.anya.internal.t) r9.c()).d(r15);
    L41:
        Object r25 = null;
        if (u1(r15) != 17) goto L69;
        if (r15 == 0) goto L69;
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = ay1.b.v0;
        KProperty[] r26 = ay1.b.a;
        if (((Boolean) r0.getValue(null, r26[88])).booleanValue() == false) goto L69;
        r0.setValue(null, r26[88], Boolean.FALSE);
        u r27 = r14.getGiftTabItemList();
        Iterator r28 = ((Iterable) r27.c()).iterator();
        int r29 = 0;
    L48:
        if (r28.hasNext() == false) goto L69;
        Object r30 = r28.next();
        int r31 = r29 + 1;
        if (r29 >= 0) goto L52;
        CollectionsKt.throwIndexOverflow();
    L52:
        MVIState r33 = (MVIState) r30;
        GiftTabItem r34 = (GiftTabItem) r33;
        if (u1(r29) != 17) goto L55;
        boolean r35 = true;
    L56:
        if (r35 == false) goto L62;
        new k0.a();     // Catch: Throwable -> L63
        ((GiftTabItem) r33).getShowRedDot().a(Boolean.FALSE);     // Catch: Throwable -> L63
        if ((!r33.modifiedProperties.isEmpty()) == false) goto L62;
        ((com.bytedance.android.anya.internal.t) r27.c()).d(r29);
    L63:
        th = move-exception;
        if ((!r33.modifiedProperties.isEmpty()) == false) goto L67;
        ((com.bytedance.android.anya.internal.t) r27.c()).d(r29);
    L67:
        throw th;
    L62:
        r29 = r31;
        goto L48
    L55:
        r35 = false;
    L69:
        if (u1(r15) != 5) goto L103;
        if (this.v == false) goto L103;
        i12.e r36 = i12.o.b();
        if (r36 == null) goto L76;
        Object r37 = com.bytedance.android.scope.m.e.d(r36, PropListService.class);
    L77:
        PropListService r38 = (PropListService) r37;
        if (r38 == null) goto L80;
        r38.d();
    L80:
        this.v = false;
        u r39 = r14.getGiftTabItemList();
        Iterator r40 = ((Iterable) r39.c()).iterator();
        int r41 = 0;
    L82:
        if (r40.hasNext() == false) goto L103;
        Object r43 = r40.next();
        int r44 = r41 + 1;
        if (r41 >= 0) goto L86;
        CollectionsKt.throwIndexOverflow();
    L86:
        MVIState r45 = (MVIState) r43;
        GiftTabItem r46 = (GiftTabItem) r45;
        if (u1(r41) != 5) goto L89;
        boolean r47 = true;
    L90:
        if (r47 == false) goto L96;
        new k0.a();     // Catch: Throwable -> L97
        ((GiftTabItem) r45).getShowRedDot().a(Boolean.FALSE);     // Catch: Throwable -> L97
        if ((!r45.modifiedProperties.isEmpty()) == false) goto L96;
        ((com.bytedance.android.anya.internal.t) r39.c()).d(r41);
    L97:
        th = move-exception;
        if ((!r45.modifiedProperties.isEmpty()) == false) goto L101;
        ((com.bytedance.android.anya.internal.t) r39.c()).d(r41);
    L101:
        throw th;
    L96:
        r41 = r44;
        goto L82
    L89:
        r47 = false;
        goto L90
    L76:
        r37 = null;
    L103:
        if (u1(r15) != 13) goto L138;
        u r48 = r14.getGiftTabItemList();
        Iterator r49 = ((Iterable) r48.c()).iterator();
        int r50 = 0;
    L107:
        if (r49.hasNext() == false) goto L127;
        Object r51 = r49.next();
        int r53 = r50 + 1;
        if (r50 >= 0) goto L111;
        CollectionsKt.throwIndexOverflow();
    L111:
        MVIState r54 = (MVIState) r51;
        GiftTabItem r55 = (GiftTabItem) r54;
        if (u1(r50) != 13) goto L114;
        boolean r56 = true;
    L115:
        if (r56 == false) goto L121;
        new k0.a();     // Catch: Throwable -> L122
        ((GiftTabItem) r54).getShowRedDot().a(Boolean.FALSE);     // Catch: Throwable -> L122
        if ((!r54.modifiedProperties.isEmpty()) == false) goto L121;
        ((com.bytedance.android.anya.internal.t) r48.c()).d(r50);
    L122:
        th = move-exception;
        if ((!r54.modifiedProperties.isEmpty()) == false) goto L126;
        ((com.bytedance.android.anya.internal.t) r48.c()).d(r50);
    L126:
        throw th;
    L121:
        r50 = r53;
        goto L107
    L114:
        r56 = false;
        goto L115
    L127:
        int r57 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k0.a;
        Iterator<T> r58 = this.G.Mn(this.N.b).c.iterator();
    L129:
        if (r58.hasNext() == false) goto L136;
        Object r59 = r58.next();
        if (((w1) r59).getPageType() != 13) goto L133;
        boolean r60 = true;
    L134:
        if (r60 == false) goto L129;
    L137:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.k0.a((w1) r59);
        goto L138
    L133:
        r60 = false;
        goto L134
    L136:
        r59 = null;
    L138:
        u r61 = r14.getGiftTabItemList();
        Iterator r63 = ((Iterable) r61.c()).iterator();
        int r64 = 0;
    L140:
        if (r63.hasNext() == false) goto L159;
        Object r65 = r63.next();
        int r66 = r64 + 1;
        if (r64 >= 0) goto L144;
        CollectionsKt.throwIndexOverflow();
    L144:
        MVIState r67 = (MVIState) r65;
        new k0.a();     // Catch: Throwable -> L154
        GiftTabItem r68 = (GiftTabItem) r67;     // Catch: Throwable -> L154
        com.bytedance.android.anya.internal.c r69 = r68.getOrderIcon();     // Catch: Throwable -> L154
        Integer r110 = Integer.valueOf(t1(r64));     // Catch: Throwable -> L154
        if (r15 != r64) goto L148;
        boolean r111 = true;
    L149:
        r69.a(Integer.valueOf(x1(r64, r110, r111)));     // Catch: Throwable -> L154
        r68.getOrderRule().a(Integer.valueOf(t1(r64)));     // Catch: Throwable -> L154
        if ((!r67.modifiedProperties.isEmpty()) == false) goto L153;
        ((com.bytedance.android.anya.internal.t) r61.c()).d(r64);
    L153:
        r64 = r66;
        goto L140
    L148:
        r111 = false;
    L154:
        th = move-exception;
        if ((!r67.modifiedProperties.isEmpty()) == false) goto L158;
        ((com.bytedance.android.anya.internal.t) r61.c()).d(r64);
    L158:
        throw th;
    L159:
        Iterator<T> r70 = this.G.Mn(this.N.b).c.iterator();
    L161:
        if (r70.hasNext() == false) goto L168;
        Object r71 = r70.next();
        if (((w1) r71).getPageType() != u1(r15)) goto L165;
        boolean r73 = true;
    L166:
        if (r73 == false) goto L161;
        r25 = r71;
        goto L168
    L165:
        r73 = false;
    L168:
        w1 r74 = (w1) r25;
        if (r74 == null) goto L179;
        List<h1> r75 = r74.getGifts();
        if (r75 == null) goto L179;
        ArrayList r76 = new ArrayList();
        Iterator<T> r77 = r75.iterator();
    L174:
        if (r77.hasNext() == false) goto L178;
        Object r78 = r77.next();
        if (((h1) r78).isDisplayedOnPanel() == false) goto L174;
        r76.add(r78);
        goto L174
    L178:
        r4 = r76.size();
    L179:
        k0 r79 = r13.b;
        r0<GiftTabViewState, Integer> r80 = r14.getTabType();
        r79.getClass();
        int r81 = ((Number) com.bytedance.android.anya.h.b(r80)).intValue();
        k0 r112 = r13.b;
        r0<GiftTabViewState, Integer> r83 = r14.getSelectPosition();
        r112.getClass();
        int r113 = ((Number) com.bytedance.android.anya.h.b(r83)).intValue();
        this.B.c(r81, r113, r4);
        this.C.c(r81, r113, r4);
        l0.h(r14.getTabType(), Integer.valueOf(u1(r15)));
        GiftContext r114 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r114 == null) goto L184;
        com.bytedance.live.datacontext.m<Integer> r115 = r114.getPageType();
        if (r115 == null) goto L184;
        r115.setValue(Integer.valueOf(u1(r15)));
    L184:
        this.B.h(r15, u1(r15));
        this.C.h(r15, u1(r15));
        l0.h(r14.getSelectPosition(), Integer.valueOf(r15));
        return;
    L32:
        r20 = "0";
    L186:
        th = move-exception;
        if ((!r10.modifiedProperties.isEmpty()) == false) goto L190;
        ((com.bytedance.android.anya.internal.t) r9.c()).d(r15);
    L190:
        throw th;
    }

    public GiftMVITabViewModel(DataCenter r17, u1 r18, g1 r19, e1 r20, d1 r21, LocateGiftInfo r23, yz0.k r24, com.bytedance.android.livesdk.gift.platform.core.giftlist.h r25, GiftListRepository r26, GiftDialogStateDataStore r27, GiftReceiverRepoService r28, PropListService r29, GiftDataStorageService r210, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.g r30, GiftTopicDataStore r31, q0 r33, GiftSearchDataStore r34, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r35) {
        Intrinsics.checkNotNullParameter(r17, "dataCenter");
        Intrinsics.checkNotNullParameter(r18, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r19, "giftLogService");
        Intrinsics.checkNotNullParameter(r20, "giftListService");
        Intrinsics.checkNotNullParameter(r21, "giftListRoomService");
        Intrinsics.checkNotNullParameter(r23, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r24, "roomDataService");
        Intrinsics.checkNotNullParameter(r25, "listPanelRepository");
        Intrinsics.checkNotNullParameter(r26, "giftListRepository");
        Intrinsics.checkNotNullParameter(r27, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r28, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r29, "propListService");
        Intrinsics.checkNotNullParameter(r210, "dataStorageService");
        Intrinsics.checkNotNullParameter(r30, "expansionControlsDataStore");
        Intrinsics.checkNotNullParameter(r31, "giftTopicDataStore");
        Intrinsics.checkNotNullParameter(r33, "giftTopicRepo");
        Intrinsics.checkNotNullParameter(r34, "giftSearchDataStore");
        Intrinsics.checkNotNullParameter(r35, "receiverService");
        this.A = r17;
        this.B = r18;
        this.C = r19;
        this.D = r20;
        this.E = r23;
        this.F = r24;
        this.G = r25;
        this.H = r26;
        this.I = r27;
        this.J = r210;
        this.K = r30;
        this.L = r31;
        this.M = r33;
        this.N = r35;
        this.v = ay1.b.v();
        this.w = ((com.bytedance.android.livesdk.gift.configmodel.d1) com.bytedance.android.livesdk.gift.platform.business.b.A.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[25])).b();
        this.x = new LinkedHashMap();
        this.y = new LinkedHashSet();
        this.z = SetsKt.setOf(new BaseMVIDataStore[]{r30, r31, r34});
    }
}
