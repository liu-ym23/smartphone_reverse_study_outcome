package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import android.os.Bundle;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.internal.t;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.i;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datalayer.GiftMVIMarketingUseCase;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DIYCardSelectType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnLocateGiftRequestReceived;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftExtra;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIBuffCardViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftBuffCardViewState, GiftAction> implements l<GiftBuffCardViewState, GiftAction> {
    public final GiftExtraRepo A;
    public final u0 B;
    public final GiftMVIMarketingUseCase C;
    public final GiftDialogStateDataStore D;
    public long u;
    public SelectedStatus v;
    public final com.bytedance.android.livesdk.gift.platform.business.config.a w;
    public LocateGiftInfo x;
    public final Set<BaseMVIDataStore<?>> y;
    public final u1 z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.y;
    }

    public static void h1(GiftBuffCardViewState r6) {
        u r7 = r6.getBuffCardList();
        Iterator r0 = ((Iterable) r7.c()).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L19;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        MVIState r4 = (MVIState) r2;
        new k0.a();     // Catch: Throwable -> L14
        ((GiftBuffCardItem) r4).getSelected().a(Boolean.FALSE);     // Catch: Throwable -> L14
        if ((!r4.modifiedProperties.isEmpty()) == false) goto L13;
        ((t) r7.c()).d(r1);
    L13:
        r1 = r3;
    L14:
        th = move-exception;
        if ((!r4.modifiedProperties.isEmpty()) == false) goto L18;
        ((t) r7.c()).d(r1);
    L18:
        throw th;
    }

    public static boolean t1(l1 r5) {
        i r0 = r5.getLockInfo();
        if (r0 == null) goto L7;
        if (r0.getLocked() != true) goto L7;
    L8:
        return false;
    L7:
        if (r5.getSweepLightImg() == null) goto L8;
        String r1 = ay1.b.e().get(String.valueOf(r5.getBuffGiftId()));
        if (r1 == null) goto L12;
        int r2 = CastIntegerProtector.parseInt(r1);
    L14:
        if (r2 < 3) goto L16;
        return false;
    L16:
        HashMap<String, String> r3 = ay1.b.e();
        r3.put(String.valueOf(r5.getBuffGiftId()), String.valueOf(r2 + 1));
        ay1.b.x(r3);
        return true;
    L12:
        r2 = 0;
        goto L14
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftBuffCardViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIBuffCardViewModel$bindToParent$1 r0 = GiftMVIBuffCardViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void q(com.bytedance.android.anya.dsl.l<GiftBuffCardViewState, r, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$buildStateMachine");
        Function1<com.bytedance.android.anya.dsl.l<GiftBuffCardViewState, r, GiftAction>.a<GiftBuffCardBusinessState.Idle>, Unit> r0 = new GiftMVIBuffCardViewModel$buildStateMachine$1(this);
        LinkedHashMap r1 = r5.a;
        com.bytedance.android.anya.dsl.l.a r3 = new com.bytedance.android.anya.dsl.l.a();
        r0.invoke(r3);
        r1.put(GiftBuffCardBusinessState.Idle.class, r3.a);
        Function1<com.bytedance.android.anya.dsl.l<GiftBuffCardViewState, r, GiftAction>.a<GiftBuffCardBusinessState.BuffSelected>, Unit> r2 = new GiftMVIBuffCardViewModel$buildStateMachine$2(this);
        LinkedHashMap r6 = r5.a;
        com.bytedance.android.anya.dsl.l.a r4 = new com.bytedance.android.anya.dsl.l.a();
        r2.invoke(r4);
        r6.put(GiftBuffCardBusinessState.BuffSelected.class, r4.a);
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftBuffCardViewState r6 = (GiftBuffCardViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        r4.d(this.D.o(), this.C.k(), new GiftMVIBuffCardViewModel$reduce$1(this, r6));
    }

    public static l1 s1(l0 r0, GiftBuffCardViewState r1, int r2) {
        k0 r3 = r0.b;
        t0<GiftBuffCardViewState, GiftBuffCardItem> r4 = r1.getBuffCardList();
        r3.getClass();
        return (l1) com.bytedance.android.anya.h.b(((GiftBuffCardItem) ListProtector.get(k0.c(r4), r2)).getBuffInfo());
    }

    public static void w1(l0 r4, GiftBuffCardViewState r5, int r6) {
        h1(r5);
        u r0 = r5.getBuffCardList();
        MVIState r1 = (MVIState) ((s0) r0.c()).get(r6);
        new k0.a();     // Catch: Throwable -> L9
        ((GiftBuffCardItem) r1).getSelected().a(Boolean.TRUE);     // Catch: Throwable -> L9
        if ((!r1.modifiedProperties.isEmpty()) == false) goto L7;
        ((t) r0.c()).d(r6);
    L7:
        r0<GiftBuffCardViewState, Integer> r7 = r5.getSelectedPosition();
        Integer r8 = Integer.valueOf(r6);
        r4.getClass();
        l0.h(r7, r8);
        return;
    L9:
        th = move-exception;
        if ((!r1.modifiedProperties.isEmpty()) == false) goto L13;
        ((t) r0.c()).d(r6);
    L13:
        throw th;
    }

    public final void w0(j0 r23, MVIState r24, p r25) {
        GiftMVIBuffCardViewModel r7 = this;
        GiftBuffCardViewState r3 = (GiftBuffCardViewState) r24;
        Intrinsics.checkNotNullParameter(r23, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r25, "action");
        if (nz1.a.h().c() == true) goto L151;
        com.bytedance.android.anya.internal.p r0 = r23.getContext();
        v r9 = (v) r0.a(r0.b(r0.c(GiftPanelState.class), GiftMVIBuffCardViewModel$postReduce$1$wrapped$1.INSTANCE), GiftMVIBuffCardViewModel$postReduce$1$wrapped$2.INSTANCE).a.invoke();
        if (r9 == null) goto L151;
        com.bytedance.android.anya.internal.c r10 = (com.bytedance.android.anya.internal.c) r9;
        Object r1 = ((com.bytedance.android.anya.internal.c) r9).c();     // Catch: Throwable -> L124
        int r2 = ((com.bytedance.android.anya.internal.c) r9).c;     // Catch: Throwable -> L124
        Object r4 = ((LinkedHashMap) r23.d).get(r9);     // Catch: Throwable -> L124
        if (r4 != null) goto L13;
        r4 = 0;     // Catch: Throwable -> L124
    L13:
        if (r2 <= ((Number) r4).intValue()) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == false) goto L116;
        k0 r5 = j0.a.a;     // Catch: Throwable -> L124
        GiftVerticalState r6 = (GiftVerticalState) r1;     // Catch: Throwable -> L124
        r5.getClass();     // Catch: Throwable -> L124
        r r8 = r6.toBusinessState(r5);     // Catch: Throwable -> L124
        if ((r8 instanceof GiftListBusinessState.GiftSelected) == true) goto L137;
    L114:
        v r20 = r9;
        j0 r11 = r23;
        GiftBuffCardViewState r14 = (GiftBuffCardViewState) r11.g.f();     // Catch: Throwable -> L120
        l0.d(r3.getBuffCardList());     // Catch: Throwable -> L120
        l0.h(r3.getSelectedPosition(), -1);     // Catch: Throwable -> L120
        l0.h(r3.getOriginGiftType(), -1);     // Catch: Throwable -> L120
        r7.u = -1;     // Catch: Throwable -> L120
        r7.v = SelectedStatus.CLICK;     // Catch: Throwable -> L120
    L117:
        if (r13 == false) goto L122;
        r23.a();     // Catch: Throwable -> L120
    L122:
        r11.c.put(r20, Integer.valueOf(r10.c));
        return;
    L120:
        th = th;
    L121:
        v r15 = r20;
    L127:
        r11.c.put(r15, Integer.valueOf(r10.c));
        throw th;
    L137:
    L112:
        th = th;
        r11 = r23;
    L126:
        r15 = r9;
        goto L127
    L20:
        if (((GiftListBusinessState.GiftSelected) r8).getIconModel() == null) goto L114;
    L109:
        th = th;
        r20 = r9;
    L111:
        r11 = r23;
        goto L121
    L25:
        int r16 = ((Number) com.bytedance.android.anya.h.b(((PagerListData) k0.d(r6.getPanelList(), ((GiftListBusinessState.GiftSelected) r8).getSelectedPagePosition())).getTabType())).intValue();     // Catch: Throwable -> L112
        vz1.e r17 = ((GiftListBusinessState.GiftSelected) r8).getIconModel();     // Catch: Throwable -> L112
        SelectedStatus r18 = ((GiftListBusinessState.GiftSelected) r8).getSelectedStatus();     // Catch: Throwable -> L112
        h1 r19 = r17.a;     // Catch: Throwable -> L109
        if (r7.u != r19.getId()) goto L29;
    L28:
        r20 = r9;
    L108:
        r11 = r23;
        goto L117
    L29:
        r7.u = r19.getId();     // Catch: Throwable -> L109
        r7.v = r18;     // Catch: Throwable -> L109
        g0 r21 = r7.A.q(r19.getId());     // Catch: Throwable -> L109
        if (r21 == null) goto L32;
        List<l1> r110 = r21.getGiftBuffInfos();     // Catch: Throwable -> L109
    L33:
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L109
        l0<GiftBuffCardViewState> r26 = r23.g;     // Catch: Throwable -> L109
        GiftBuffCardViewState r27 = (GiftBuffCardViewState) r26.f();     // Catch: Throwable -> L109
        if (r110 != null) goto L135;
    L68:
        r20 = r9;
        l0.d(r3.getBuffCardList());     // Catch: Throwable -> L62
        l0.c(r3.getBuffCardList(), r111);     // Catch: Throwable -> L62
        l0.h(r3.getOriginGiftModel(), r17);     // Catch: Throwable -> L62
        l0.h(r3.getOriginGiftType(), Integer.valueOf(r16));     // Catch: Throwable -> L62
        u1(r26, r3, r17, r18, ((Number) com.bytedance.android.anya.h.b(r3.getOriginGiftType())).intValue());     // Catch: Throwable -> L62
        u1 r28 = this.z;     // Catch: Throwable -> L99
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));     // Catch: Throwable -> L99
        Iterator r30 = r111.iterator();     // Catch: Throwable -> L99
    L72:
        if (r30.hasNext() == false) goto L74;
        r29.add((l1) com.bytedance.android.anya.h.b(((GiftBuffCardItem) r30.next()).getBuffInfo()));     // Catch: Throwable -> L99
        goto L72
    L74:
        r28.getClass();     // Catch: Throwable -> L99
        Intrinsics.checkNotNullParameter(r17, "curGift");     // Catch: Throwable -> L99
        Intrinsics.checkNotNullParameter(r29, "buffGiftList");     // Catch: Throwable -> L99
        Bundle r31 = r28.k;     // Catch: Throwable -> L99
        if (r31 == null) goto L80;
        Object r33 = r31.get("buff_source");     // Catch: Throwable -> L99
        if (r33 == null) goto L80;
        String r34 = r33.toString();     // Catch: Throwable -> L99
        if (r34 == null) goto L80;
    L81:
        Iterator r35 = r29.iterator();     // Catch: Throwable -> L99
        int r36 = 0;
    L83:
        if (r35.hasNext() == false) goto L101;
        Object r37 = r35.next();     // Catch: Throwable -> L99
        int r38 = r36 + 1;     // Catch: Throwable -> L99
        if (r36 >= 0) goto L87;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L99
    L87:
        l1 r39 = (l1) r37;     // Catch: Throwable -> L99
        Pair[] r40 = new Pair[9];     // Catch: Throwable -> L99
        r40[0] = TuplesKt.to("origin_gift_id", String.valueOf(r17.b));     // Catch: Throwable -> L99
        r40[1] = TuplesKt.to("gift_price", String.valueOf(r17.a.getDiamondCount()));     // Catch: Throwable -> L99
        r40[2] = TuplesKt.to("gift_buff_id", String.valueOf(r39.getBuffGiftId()));     // Catch: Throwable -> L99
        r40[3] = TuplesKt.to("gift_buff_price", String.valueOf(r39.getBuffDiamondCount()));     // Catch: Throwable -> L99
        i r41 = r39.getLockInfo();     // Catch: Throwable -> L99
        if (r41 != null) goto L90;
    L92:
        String r43 = "1";
    L93:
        r40[4] = TuplesKt.to("gift_buff_unlock_type", r43);     // Catch: Throwable -> L99
        r40[5] = TuplesKt.to("card_location", String.valueOf(r38));     // Catch: Throwable -> L99
        h2 r44 = GiftManagerKt.l(r39.getBuffGiftId());     // Catch: Throwable -> L99
        if (r44 == null) goto L97;
        String r45 = r44.getName();     // Catch: Throwable -> L99
        if (r45 == null) goto L97;
    L98:
        r40[6] = TuplesKt.to("card_name", r45);     // Catch: Throwable -> L99
        r40[7] = TuplesKt.to("tag_type", "null");     // Catch: Throwable -> L99
        r40[8] = TuplesKt.to("request_page", r34);     // Catch: Throwable -> L99
        r28.p1("gift_buff_show", MapsKt.mutableMapOf(r40), true);     // Catch: Throwable -> L99
        r36 = r38;
    L97:
        r45 = BuildConfig.FLAVOR;
        goto L98
    L90:
        if (r41.getLocked() != true) goto L92;
        r43 = "0";
        goto L93
    L101:
        if (r110 == null) goto L108;
        if ((!r110.isEmpty()) == false) goto L105;
        List<l1> r46 = r110;
    L106:
        if (r46 == null) goto L108;
        boolean r47 = d0.a;     // Catch: Throwable -> L99
        d0.j(this.u, r110, null);     // Catch: Throwable -> L99
        goto L108
    L105:
        r46 = null;
    L80:
        r34 = "default";
    L99:
        th = th;
    L62:
        th = th;
        goto L111
    L135:
        Iterator r48 = r110.iterator();     // Catch: Throwable -> L64
    L36:
        if (r48.hasNext() == false) goto L68;
        l1 r49 = (l1) r48.next();     // Catch: Throwable -> L64
        h2 r50 = GiftManagerKt.l(r49.getBuffGiftId());     // Catch: Throwable -> L64
        if (r50 == null) goto L28;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.i(r50.getPrimaryEffectId()) == false) goto L45;
    L49:
        boolean r112 = true;
    L51:
        if (r112 == false) goto L66;
        GiftBuffCardItem r113 = new GiftBuffCardItem();     // Catch: Throwable -> L64
        new k0.a();     // Catch: Throwable -> L64
        r113.getBuffInfo().a(r49);     // Catch: Throwable -> L64
        com.bytedance.android.anya.internal.c r114 = r113.getExpireTime();     // Catch: Throwable -> L64
        long r115 = r50.getGiftEndingTime();     // Catch: Throwable -> L64
        r20 = r9;
        com.bytedance.android.live.revenue.common.u0 r51 = com.bytedance.android.live.revenue.common.u0.g;     // Catch: Throwable -> L62
        Long r53 = Long.valueOf(r115 * r51.a);     // Catch: Throwable -> L62
        Intrinsics.checkNotNullParameter(r50, "$this$nowTimeDiffSeconds");     // Catch: Throwable -> L62
        if ((r50 instanceof h1) == true) goto L57;
        r50 = null;
    L57:
        h1 r54 = (h1) r50;     // Catch: Throwable -> L62
        if (r54 == null) goto L60;
        long r116 = r54.getNowTimeDiffSeconds();     // Catch: Throwable -> L62
    L61:
        r114.a(new Pair(r53, Long.valueOf(r116 * r51.a)));     // Catch: Throwable -> L62
        r113.getShowAnim().a(Boolean.valueOf(t1(r49)));     // Catch: Throwable -> L62
        Unit r55 = Unit.INSTANCE;     // Catch: Throwable -> L62
        r111.add(r113);     // Catch: Throwable -> L62
    L67:
        r7 = this;
        r48 = r48;
        r9 = r20;
        goto L36
    L60:
        r116 = 0;
        goto L61
    L66:
        r20 = r9;
        goto L67
    L45:
        if (com.bytedance.android.livesdk.gift.platform.business.i.m().getEnable() == true) goto L49;
        if (a0.c() == true) goto L49;
        r112 = false;
    L64:
        th = th;
        r20 = r9;
        goto L111
    L32:
        r110 = null;
        goto L33
    L116:
        r11 = r23;
        r20 = r9;
        goto L117
    L15:
        r13 = false;
    L124:
        th = th;
        r11 = r23;
    }

    public final void y0(l0 r19, MVIState r20, p r21) {
        GiftBuffCardViewState r7 = (GiftBuffCardViewState) r20;
        GiftAction r8 = (GiftAction) r21;
        Intrinsics.checkNotNullParameter(r19, "$this$reduce");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r8, "action");
        if ((r8 instanceof OnLocateGiftRequestReceived) == false) goto L43;
        LocateGiftInfo r0 = ((OnLocateGiftRequestReceived) r8).getLocateGiftInfo();
        if (this.u != r0.getTargetGiftId()) goto L41;
        int r3 = r0.getBuffLevel();
        k0 r4 = r19.b;
        t0<GiftBuffCardViewState, GiftBuffCardItem> r5 = r7.getBuffCardList();
        r4.getClass();
        Iterator r6 = k0.c(r5).iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        GiftBuffCardItem r9 = (GiftBuffCardItem) r6.next();
        if (((l1) com.bytedance.android.anya.h.b(r9.getBuffInfo())).getBuffLevel() != r3) goto L8;
        l1 r10 = (l1) com.bytedance.android.anya.h.b(r9.getBuffInfo());
    L13:
        if (r10 == null) goto L41;
        if (r10.getBuffLevel() == 0) goto L41;
        i r11 = r10.getLockInfo();
        if (r11 != null) goto L19;
    L30:
        int r13 = r10.getBuffLevel();
        k0 r14 = r19.b;
        t0<GiftBuffCardViewState, GiftBuffCardItem> r15 = r7.getBuffCardList();
        r14.getClass();
        List r16 = k0.c(r15);
        int r17 = r16.size();
        int r2 = 0;
    L32:
        if (r2 >= r17) goto L37;
        if (((l1) com.bytedance.android.anya.h.b(((GiftBuffCardItem) ListProtector.get(r16, r2)).getBuffInfo())).getBuffLevel() == r13) goto L38;
        r2 = r2 + 1;
    L38:
        if (r2 == (-1)) goto L40;
        w1(r19, r7, r2);
        goto L41
    L40:
        h1(r7);
        goto L41
    L37:
        r2 = -1;
        goto L38
    L19:
        if (r11.getLocked() != true) goto L30;
        com.bytedance.android.livesdk.gift.platform.business.config.a r18 = this.w;
        GiftContext r23 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r23 == null) goto L27;
        m<Integer> r24 = r23.getPageType();
        if (r24 == null) goto L27;
        Integer r25 = (Integer) r24.getValue();
        if (r25 == null) goto L27;
        int r26 = r25.intValue();
    L29:
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.a(r18, r26) == false) goto L41;
    L27:
        r26 = 0;
        goto L29
    L12:
        r10 = null;
    L41:
        this.x = r0;
    L94:
        T0(r7, r8);
        return;
    L43:
        if ((r8 instanceof RefreshGiftExtra) == false) goto L94;
        long r27 = this.u;
        r0<GiftBuffCardViewState, vz1.e> r1 = r7.getOriginGiftModel();
        r19.getClass();
        if (r27 != ((vz1.e) com.bytedance.android.anya.h.b(r1)).a.getId()) goto L94;
        h1 r110 = ((vz1.e) com.bytedance.android.anya.h.b(r7.getOriginGiftModel())).a;
        g0 r28 = this.A.q(r110.getId());
        if (r28 == null) goto L50;
        List<l1> r111 = r28.getGiftBuffInfos();
    L51:
        ArrayList r29 = new ArrayList();
        if (r111 == null) goto L79;
        Iterator<T> r30 = r111.iterator();
    L55:
        if (r30.hasNext() == false) goto L79;
        l1 r31 = (l1) r30.next();
        h2 r33 = GiftManagerKt.l(r31.getBuffGiftId());
        if (r33 == null) goto L94;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.i(r33.getPrimaryEffectId()) == false) goto L63;
    L61:
        boolean r112 = true;
    L69:
        if (r112 == false) goto L55;
        GiftBuffCardItem r113 = new GiftBuffCardItem();
        new k0.a();
        r113.getBuffInfo().a(r31);
        com.bytedance.android.anya.internal.c r114 = r113.getExpireTime();
        long r115 = r33.getGiftEndingTime();
        com.bytedance.android.live.revenue.common.u0 r34 = com.bytedance.android.live.revenue.common.u0.g;
        Long r35 = Long.valueOf(r115 * r34.a);
        Intrinsics.checkNotNullParameter(r33, "$this$nowTimeDiffSeconds");
        if ((r33 instanceof h1) == true) goto L73;
        r33 = null;
    L73:
        h1 r36 = (h1) r33;
        if (r36 == null) goto L76;
        long r116 = r36.getNowTimeDiffSeconds();
    L77:
        r114.a(new Pair(r35, Long.valueOf(r116 * r34.a)));
        r113.getShowAnim().a(Boolean.valueOf(t1(r31)));
        Unit r37 = Unit.INSTANCE;
        r29.add(r113);
        goto L55
    L76:
        r116 = 0;
        goto L77
    L63:
        if (com.bytedance.android.livesdk.gift.platform.business.i.m().getEnable() == true) goto L61;
        if (a0.c() == true) goto L61;
        r112 = false;
    L79:
        l0.d(r7.getBuffCardList());
        l0.c(r7.getBuffCardList(), r29);
        u1(r19, r7, (vz1.e) com.bytedance.android.anya.h.b(r7.getOriginGiftModel()), this.v, ((Number) com.bytedance.android.anya.h.b(r7.getOriginGiftType())).intValue());
        if (r110.getReqExtraType() != 1) goto L82;
    L83:
        Iterator r38 = ((ArrayList) this.B.c).iterator();
    L85:
        if (r38.hasNext() == false) goto L87;
        ((com.bytedance.android.livesdk.gift.platform.business.f) r38.next()).i(r110);
    L87:
        if (r111 == null) goto L94;
        if ((!r111.isEmpty()) == false) goto L91;
        List<l1> r39 = r111;
    L92:
        if (r39 == null) goto L94;
        boolean r40 = d0.a;
        d0.j(this.u, r111, null);
        goto L94
    L91:
        r39 = null;
        goto L92
    L82:
        if (r110.getReqExtraType() != 2) goto L87;
    L50:
        r111 = null;
        goto L51
    }

    public static final void e1(GiftMVIBuffCardViewModel r7, l0 r8, GiftBuffCardViewState r9, int r10) {
        r7.getClass();
        l1 r2 = s1(r8, r9, r10);
        String r11 = r2.getLockToast();
        int r0 = ToastUtil.a;
        if (r11 != null) goto L5;
    L10:
        Object[] r13 = new Object[1];
        h2 r1 = GiftManagerKt.l(r2.getBuffGiftId());
        if (r1 == null) goto L13;
        String r3 = r1.getName();
    L14:
        r13[0] = r3;
        r11 = s1.C(2131917096, r13);
    L15:
        ToastUtil.b(r11, 0);
        r7.z.b0((vz1.e) com.bytedance.android.anya.h.b(r9.getOriginGiftModel()), r2, false, DIYCardSelectType.CLICK_SELECT.ordinal(), false, r10);
        return;
    L13:
        r3 = null;
        goto L14
    L5:
        if (r11.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 != true) goto L10;
    L7:
        r4 = false;
        goto L8
    }

    public final void u1(l0<GiftBuffCardViewState> r19, GiftBuffCardViewState r20, vz1.e r21, SelectedStatus r23, int r24) {
        String r2 = ay1.b.d().get(String.valueOf(r21.a.getId()));
        if (r2 == null) goto L7;
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L7;
        long r4 = r3.longValue();
    L8:
        g0 r5 = this.A.q(r21.a.getId());
        boolean r10 = true;
        if (r5 == null) goto L34;
        List<l1> r6 = r5.getGiftBuffInfos();
        if (r6 == null) goto L34;
        Iterator<T> r7 = r6.iterator();
        l1 r8 = null;
    L14:
        if (r7.hasNext() == false) goto L35;
        l1 r9 = (l1) r7.next();
        i r11 = r9.getLockInfo();
        if (r11 == null) goto L31;
        if (r11.getLocked() != true) goto L31;
        com.bytedance.android.livesdk.gift.platform.business.config.a r13 = this.w;
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r14 == null) goto L26;
        m<Integer> r15 = r14.getPageType();
        if (r15 == null) goto L26;
        Integer r16 = (Integer) r15.getValue();
        if (r16 == null) goto L26;
        int r17 = r16.intValue();
    L28:
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.a(r13, r17) == false) goto L14;
    L26:
        r17 = 0;
    L31:
        l1.Companion.getClass();
        if (l1.a.g(r24, r9) == 0) goto L14;
        r8 = r9;
    L35:
        int r18 = DIYCardSelectType.DEFAULT_SELECT.ordinal();
        if (r23 != SelectedStatus.LOCATE) goto L41;
        if (this.x.getBuffLevel() == 0) goto L41;
        String r25 = String.valueOf(this.x.getBuffLevel());
        boolean r26 = true;
    L52:
        if (r8 == null) goto L58;
        if (r26 == true) goto L58;
        r25 = String.valueOf(r8.getBuffLevel());
        if (r25 != null) goto L57;
        r25 = "-1";
    L57:
        r18 = DIYCardSelectType.RECOMMEND_SELECT.ordinal();
    L58:
        String r110 = r25;
        int r111 = r18;
        u r112 = r20.getBuffCardList();
        Iterator r113 = ((Iterable) r112.c()).iterator();
        int r27 = -1;
        int r28 = 0;
    L60:
        if (r113.hasNext() == false) goto L108;
        Object r29 = r113.next();
        int r114 = r28 + 1;
        if (r28 >= 0) goto L64;
        CollectionsKt.throwIndexOverflow();
    L64:
        MVIState r30 = (MVIState) r29;
        new k0.a();     // Catch: Throwable -> L101
        GiftBuffCardItem r31 = (GiftBuffCardItem) r30;     // Catch: Throwable -> L101
        if (Intrinsics.areEqual(String.valueOf(((l1) r31.getBuffInfo().c()).getBuffLevel()), r110) == true) goto L125;
    L96:
        MVIState r33 = r30;
        int r210 = r28;
    L98:
        if ((!r33.modifiedProperties.isEmpty()) == false) goto L100;
        ((t) r112.c()).d(r210);
    L100:
        r28 = r114;
        goto L60
    L125:
    L93:
        th = th;
        r33 = r30;
        r210 = r28;
    L95:
        int r34 = r210;
    L104:
        if ((!r33.modifiedProperties.isEmpty()) == false) goto L106;
        ((t) r112.c()).d(r34);
    L106:
        throw th;
    L69:
        i r35 = ((l1) r31.getBuffInfo().c()).getLockInfo();     // Catch: Throwable -> L101
        if (r35 == null) goto L84;
        if (r35.getLocked() != true) goto L84;
        com.bytedance.android.livesdk.gift.platform.business.config.a r36 = this.w;     // Catch: Throwable -> L101
        GiftContext r37 = com.bytedance.android.livesdk.gift.util.b.b();     // Catch: Throwable -> L101
        if (r37 == null) goto L80;
        m<Integer> r38 = r37.getPageType();     // Catch: Throwable -> L101
        if (r38 == null) goto L80;
        Integer r39 = (Integer) r38.getValue();     // Catch: Throwable -> L101
        if (r39 == null) goto L80;
        int r40 = r39.intValue();     // Catch: Throwable -> L101
    L82:
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.a(r36, r40) == false) goto L96;
    L80:
        r40 = 0;
    L84:
        r31.getSelected().a(Boolean.TRUE);     // Catch: Throwable -> L93
        r33 = r30;
        r210 = r28;
        this.z.b0(r21, (l1) r31.getBuffInfo().c(), false, r111, true, r210);     // Catch: Throwable -> L91
        r27 = r210;
    L91:
        th = th;
    L101:
        th = th;
        r33 = r30;
        r34 = r28;
        goto L104
    L108:
        if (r27 == (-1)) goto L110;
        r0<GiftBuffCardViewState, Integer> r0 = r20.getSelectedPosition();
        Integer r41 = Integer.valueOf(r27);
        r19.getClass();
        l0.h(r0, r41);
    L110:
        if (r27 == (-1)) goto L112;
        return;
    L112:
        if (this.x.getBuffLevel() == 0) goto L143;
        String r1 = this.x.getJumpSchema();
        if (r1.length() > 0) goto L117;
        r10 = false;
    L117:
        if (r10 == false) goto L119;
        String r43 = r1;
    L120:
        if (r43 == null) goto L144;
        com.bytedance.android.live.revenue.core.util.f.a(g.class).S2(s1.getContext(), r43);
        return;
    L144:
        return;
    L119:
        r43 = null;
        goto L120
    L143:
        return;
    L41:
        if (ay1.b.c().get(String.valueOf(r21.a.getId())) == null) goto L46;
        if (r8 != null) goto L44;
    L45:
        r25 = ay1.b.c().get(String.valueOf(r21.a.getId()));
    L51:
        r26 = false;
        goto L52
    L44:
        if (r8.getStartTime() <= r4) goto L45;
    L46:
        r18 = DIYCardSelectType.RECOMMEND_SELECT.ordinal();
        if (r8 == null) goto L49;
        Integer r44 = Integer.valueOf(r8.getBuffLevel());
    L50:
        r25 = String.valueOf(r44);
        goto L51
    L49:
        r44 = null;
    L34:
        r8 = null;
    L7:
        r4 = 0;
        goto L8
    }

    public GiftMVIBuffCardViewModel(LocateGiftInfo r2, u1 r3, GiftExtraRepo r4, u0 r5, GiftMVIMarketingUseCase r6, GiftDialogStateDataStore r7) {
        Intrinsics.checkNotNullParameter(r2, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r3, "logService");
        Intrinsics.checkNotNullParameter(r4, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r5, "internalScopeService");
        Intrinsics.checkNotNullParameter(r6, "giftMarketingUseCase");
        Intrinsics.checkNotNullParameter(r7, "giftDialogStateDataStore");
        this.z = r3;
        this.A = r4;
        this.B = r5;
        this.C = r6;
        this.D = r7;
        this.u = -1;
        this.v = SelectedStatus.CLICK;
        this.w = nz1.b.a();
        this.x = r2;
        this.y = SetsKt.setOf(new BaseMVIDataStore[]{r6, r7});
    }
}
