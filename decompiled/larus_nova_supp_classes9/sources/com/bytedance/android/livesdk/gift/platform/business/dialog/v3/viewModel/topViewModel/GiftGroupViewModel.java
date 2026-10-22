package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.l;
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
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.platform.business.GiftPluginType;
import com.bytedance.android.livesdk.gift.platform.business.config.m;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftSendPreCheckService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.h0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftGroupItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftGroupItemBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftGroupMostlyUsedInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GroupViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftGroupComboFinish;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftMostlyUsedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowDetail;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGroupView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.VisualStatus;
import com.bytedance.android.livesdk.gift.platform.business.g;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.i;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftMostlyUsedDataStore;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.SelectStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lc6.s;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftGroupViewModel extends com.bytedance.android.anya.f<GiftPanelState, GroupViewState, GiftAction> implements o {
    public final u1 A;
    public final e1 B;
    public final k C;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f D;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a E;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b F;
    public final GiftExtraRepo G;
    public final i H;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c I;
    public final GiftSendPreCheckService J;
    public final GiftDialogStateDataStore K;
    public final GiftSearchDataStore L;
    public final GiftMostlyUsedDataStore M;
    public final GiftTopicDataStore N;
    public int u;
    public final Set<BaseMVIDataStore<?>> v;
    public final CompositeDisposable w;
    public final h0 x;
    public final u0 y;
    public final PropListService z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GiftGroupViewModel a;

        public a(GiftGroupViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            boolean r0 = this.a.L.s();
            if (((s) r7).a() != SelectStatus.LONG_PRESS.getStatus()) goto L5;
            this.a.K0(new ShowGroupView(true, r0));
            this.a.K0(new ShowDetail(false));
            return;
        L5:
            this.a.K0(new ShowGroupView(false, r0));
        }
    }

    public final void onStop() {
    }

    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(this.K.observeCurrentSelectStatus().subscribeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)), this.w);
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.v;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GroupViewState();
    }

    public final void d(h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftGroupViewModel$bindToParent$1 r0 = GiftGroupViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void q(l<GroupViewState, r, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$buildStateMachine");
        Function1<l<GroupViewState, r, GiftAction>.a<GiftGroupItemBusinessState.Idle>, Unit> r0 = new GiftGroupViewModel$buildStateMachine$1(this);
        LinkedHashMap r1 = r5.a;
        l.a r3 = new l.a();
        r0.invoke(r3);
        r1.put(GiftGroupItemBusinessState.Idle.class, r3.a);
        Function1<l<GroupViewState, r, GiftAction>.a<GiftGroupItemBusinessState.GroupCombo>, Unit> r2 = new GiftGroupViewModel$buildStateMachine$2(this);
        LinkedHashMap r6 = r5.a;
        l.a r4 = new l.a();
        r2.invoke(r4);
        r6.put(GiftGroupItemBusinessState.GroupCombo.class, r4.a);
    }

    public final void t1(GroupViewState r8) {
        u r9 = r8.getGroupItemList();
        Iterator r0 = ((Iterable) r9.c()).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L19;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        MVIState r5 = (MVIState) r3;
        new k0.a();     // Catch: Throwable -> L14
        ((GiftGroupItem) r5).getComboCount().a(0);     // Catch: Throwable -> L14
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L13;
        ((t) r9.c()).d(r2);
    L13:
        r2 = r4;
    L14:
        th = move-exception;
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L18;
        ((t) r9.c()).d(r2);
    L18:
        throw th;
    L19:
        h0 r10 = this.x;
        GiftTransaction r1 = r10.a;
        if (r1 == null) goto L22;
        r1.finish();
    L22:
        r10.a = null;
    }

    public static void u1(l0 r1, GroupViewState r2) {
        r0<GroupViewState, Integer> r0 = r2.getSelectedPosition();
        r1.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r0)).intValue() == (-1)) goto L6;
        l0.h(r2.getSelectedPosition(), -1);
        return;
    }

    public final void s1(l0<GroupViewState> r29, GroupViewState r30) {
        t0<GroupViewState, GiftGroupItem> r0 = r30.getGroupItemList();
        List r1 = CollectionsKt.emptyList();
        r29.getClass();
        l0.g(r0, r1);
        l0.h(r30.getSelectedPosition(), -1);
        l0.h(r30.getIconModel(), new vz1.e((h1) vh7.f.c(h1.class), 0, null, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 67108862));
        l0.h(r30.getComboEndAnimPosition(), -1);
        l0.h(r30.getComboStartAnimPosition(), -1);
        t1(r30);
    }

    public final void w0(j0 r20, MVIState r21, p r23) {
        GroupViewState r0 = (GroupViewState) r21;
        Intrinsics.checkNotNullParameter(r20, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r0, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r23, "action");
        com.bytedance.android.anya.internal.p r3 = r20.getContext();
        com.bytedance.android.anya.internal.p.b r4 = r3.a(r3.b(r3.c(GiftPanelState.class), GiftGroupViewModel$postReduce$1$tmp$1.INSTANCE), GiftGroupViewModel$postReduce$1$tmp$2.INSTANCE);
        boolean r5 = false;
        Object r6 = 0;
        com.bytedance.android.anya.internal.c r7 = (v) r4.a.invoke();
        if (r7 == null) goto L41;
        com.bytedance.android.anya.internal.c r8 = r7;
        Object r9 = r7.c();     // Catch: Throwable -> L70
        int r10 = r7.c;     // Catch: Throwable -> L70
        Object r11 = ((LinkedHashMap) r20.d).get(r7);     // Catch: Throwable -> L70
        if (r11 != null) goto L10;
        r11 = r6;
    L10:
        if (r10 <= ((Number) r11).intValue()) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L38;
        k0 r14 = j0.a.a;     // Catch: Throwable -> L70
        r14.getClass();     // Catch: Throwable -> L70
        r r15 = ((GiftVerticalState) r9).toBusinessState(r14);     // Catch: Throwable -> L70
        if ((r15 instanceof GiftListBusinessState.GiftSelected) == false) goto L38;
        this.u = ((GiftListBusinessState.GiftSelected) r15).getSelectedPagePosition();     // Catch: Throwable -> L70
        vz1.e r16 = ((GiftListBusinessState.GiftSelected) r15).getIconModel();     // Catch: Throwable -> L70
        if (r16 == null) goto L38;
        if (r16.b == ((vz1.e) com.bytedance.android.anya.h.b(r0.getIconModel())).b) goto L38;
        if (((GiftListBusinessState.GiftSelected) r15).getSelectedStatus() != SelectedStatus.GROUP) goto L37;
        l0<GroupViewState> r17 = r20.g;     // Catch: Throwable -> L70
        GroupViewState r18 = (GroupViewState) r17.f();     // Catch: Throwable -> L70
        w1(r17, r0, ((Number) com.bytedance.android.anya.h.b(r0.getSelectedPosition())).intValue());     // Catch: Throwable -> L70
        x1(r17, r16, r0, ((GiftListBusinessState.GiftSelected) r15).getVisualStatus());     // Catch: Throwable -> L70
        u1 r19 = this.A;     // Catch: Throwable -> L70
        long r110 = r16.b;     // Catch: Throwable -> L70
        int r111 = ((GiftListBusinessState.GiftSelected) r15).getSelectedPosition();     // Catch: Throwable -> L70
        int r112 = ((GiftListBusinessState.GiftSelected) r15).getSelectedPagePosition();     // Catch: Throwable -> L70
        Map<Integer, Integer> r113 = this.B.c;     // Catch: Throwable -> L70
        LinkedHashMap r114 = (LinkedHashMap) r113;     // Catch: Throwable -> L70
        Integer r115 = (Integer) r114.get(Integer.valueOf(((GiftListBusinessState.GiftSelected) r15).getSelectedPagePosition()));     // Catch: Throwable -> L70
        if (r115 == null) goto L25;
        int r116 = r115.intValue();     // Catch: Throwable -> L70
    L26:
        r19.h1(r110, r111, r112, r116);     // Catch: Throwable -> L70
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L38;
        u1 r117 = this.A;     // Catch: Throwable -> L70
        int r118 = ((GiftListBusinessState.GiftSelected) r15).getSelectedPagePosition();     // Catch: Throwable -> L70
        Map<Integer, Integer> r119 = this.B.c;     // Catch: Throwable -> L70
        LinkedHashMap r120 = (LinkedHashMap) r119;     // Catch: Throwable -> L70
        Integer r24 = (Integer) r120.get(Integer.valueOf(((GiftListBusinessState.GiftSelected) r15).getSelectedPagePosition()));     // Catch: Throwable -> L70
        if (r24 == null) goto L31;
        int r25 = r24.intValue();     // Catch: Throwable -> L70
    L32:
        GiftMostlyUsedDataStore r121 = this.M;     // Catch: Throwable -> L70
        long r122 = r16.b;     // Catch: Throwable -> L70
        if (r121.g.contains(Long.valueOf(r122)) == false) goto L35;
        String r123 = "remove";
    L36:
        r117.Y0(r16, r118, r25, r123);     // Catch: Throwable -> L70
        goto L38
    L35:
        r123 = "add";
        goto L36
    L31:
        r25 = 0;
        goto L32
    L25:
        r116 = 0;
        goto L26
    L37:
        l0<GroupViewState> r26 = r20.g;     // Catch: Throwable -> L70
        GroupViewState r124 = (GroupViewState) r26.f();     // Catch: Throwable -> L70
        s1(r26, r0);     // Catch: Throwable -> L70
    L38:
        if (r13 == false) goto L40;
        r20.a();     // Catch: Throwable -> L70
    L40:
        r20.c.put(r7, Integer.valueOf(r8.c));
        goto L41
    L12:
        r13 = false;
    L70:
        th = move-exception;
        r20.c.put(r7, Integer.valueOf(r8.c));
        throw th;
    L41:
        com.bytedance.android.anya.internal.p r27 = r20.getContext();
        com.bytedance.android.anya.internal.c r28 = (v) r27.b(r27.c(GiftPanelState.class), GiftGroupViewModel$postReduce$3$1.INSTANCE).a.invoke();
        if (r28 == null) goto L77;
        com.bytedance.android.anya.internal.c r29 = r28;
        Object r30 = r28.c();     // Catch: Throwable -> L67
        int r31 = r28.c;     // Catch: Throwable -> L67
        Object r125 = ((LinkedHashMap) r20.d).get(r28);     // Catch: Throwable -> L67
        if (r125 == null) goto L50;
        r6 = r125;
    L50:
        if (r31 <= ((Number) r6).intValue()) goto L52;
        r5 = true;
    L52:
        if (r5 == false) goto L63;
        k0 r33 = j0.a.a;     // Catch: Throwable -> L67
        r33.getClass();     // Catch: Throwable -> L67
        r r34 = ((GiftSearchViewState) r30).toBusinessState(r33);     // Catch: Throwable -> L67
        if ((r34 instanceof GiftSearchBusinessState.GiftSelected) == false) goto L63;
        vz1.e r35 = ((GiftSearchBusinessState.GiftSelected) r34).getIconModel();     // Catch: Throwable -> L67
        if (r35 == null) goto L63;
        if (r35.b == ((vz1.e) com.bytedance.android.anya.h.b(r0.getIconModel())).b) goto L63;
        if (((GiftSearchBusinessState.GiftSelected) r34).getSelectedStatus() != SelectedStatus.GROUP) goto L62;
        l0<GroupViewState> r36 = r20.g;     // Catch: Throwable -> L67
        GroupViewState r37 = (GroupViewState) r36.f();     // Catch: Throwable -> L67
        w1(r36, r0, ((Number) com.bytedance.android.anya.h.b(r0.getSelectedPosition())).intValue());     // Catch: Throwable -> L67
        x1(r36, r35, r0, ((GiftSearchBusinessState.GiftSelected) r34).getSelectedVisualStatus());     // Catch: Throwable -> L67
        this.A.h1(r35.b, ((GiftSearchBusinessState.GiftSelected) r34).getSelectedPosition(), -1, 0);     // Catch: Throwable -> L67
        goto L63
    L62:
        l0<GroupViewState> r38 = r20.g;     // Catch: Throwable -> L67
        GroupViewState r39 = (GroupViewState) r38.f();     // Catch: Throwable -> L67
        s1(r38, r0);     // Catch: Throwable -> L67
    L63:
        if (r5 == false) goto L65;
        r20.a();     // Catch: Throwable -> L67
    L65:
        r20.c.put(r28, Integer.valueOf(r29.c));
        return;
    L67:
        th = move-exception;
        r20.c.put(r28, Integer.valueOf(r29.c));
        throw th;
    }

    public final void w1(l0<GroupViewState> r2, GroupViewState r3, int r4) {
        r0<GroupViewState, Integer> r0 = r3.getComboEndAnimPosition();
        Integer r5 = Integer.valueOf(r4);
        r2.getClass();
        l0.h(r0, r5);
        u1(r2, r3);
        t1(r3);
    }

    public final void y0(l0 r13, MVIState r14, p r15) {
        GroupViewState r16 = (GroupViewState) r14;
        GiftAction r17 = (GiftAction) r15;
        Intrinsics.checkNotNullParameter(r13, "$this$reduce");
        Intrinsics.checkNotNullParameter(r16, "state");
        Intrinsics.checkNotNullParameter(r17, "action");
        T0(r16, r17);
        if ((r17 instanceof OnGiftGroupComboFinish) == false) goto L6;
        w1(r13, r16, ((OnGiftGroupComboFinish) r17).getPosition());
        return;
    L6:
        if ((r17 instanceof RefreshGiftMostlyUsedStatus) == false) goto L75;
        RefreshGiftMostlyUsedStatus r0 = (RefreshGiftMostlyUsedStatus) r17;
        int r1 = r0.getOperateAction();
        int r3 = 0;
        if (r1 != 1) goto L10;
        r0<GroupViewState, vz1.e> r2 = r16.getIconModel();
        r13.getClass();
        if (((vz1.e) com.bytedance.android.anya.h.b(r2)).a.getId() != r0.getGiftId()) goto L77;
        u r18 = r16.getGroupItemList();
        Iterator r19 = ((Iterable) r18.c()).iterator();
    L41:
        if (r19.hasNext() == false) goto L80;
        Object r4 = r19.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        MVIState r6 = (MVIState) r4;
        if (((GiftGroupMostlyUsedInfo) com.bytedance.android.anya.h.b(((GiftGroupItem) r6).getMostlyUsedInfo())).getShow() == false) goto L56;
        new k0.a();     // Catch: Throwable -> L57
        GiftGroupItem r7 = (GiftGroupItem) r6;     // Catch: Throwable -> L57
        com.bytedance.android.anya.internal.c r8 = r7.getMostlyUsedInfo();     // Catch: Throwable -> L57
        if (((RefreshGiftMostlyUsedStatus) r17).getSuccess() == false) goto L51;
        GiftGroupMostlyUsedInfo r9 = GiftGroupMostlyUsedInfo.copy$default((GiftGroupMostlyUsedInfo) r7.getMostlyUsedInfo().c(), false, true, false, 1, null);     // Catch: Throwable -> L57
    L52:
        r8.a(r9);     // Catch: Throwable -> L57
        if ((!r6.modifiedProperties.isEmpty()) == false) goto L56;
        ((t) r18.c()).d(r3);
        goto L56
    L51:
        r9 = GiftGroupMostlyUsedInfo.copy$default((GiftGroupMostlyUsedInfo) r7.getMostlyUsedInfo().c(), false, false, false, 3, null);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        if ((!r6.modifiedProperties.isEmpty()) == false) goto L61;
        ((t) r18.c()).d(r3);
    L61:
        throw th;
    L56:
        r3 = r5;
        goto L41
    L80:
        return;
    L77:
        return;
    L10:
        if (r1 != 2) goto L78;
        r0<GroupViewState, vz1.e> r10 = r16.getIconModel();
        r13.getClass();
        if (((vz1.e) com.bytedance.android.anya.h.b(r10)).a.getId() != r0.getGiftId()) goto L76;
        u r110 = r16.getGroupItemList();
        Iterator r111 = ((Iterable) r110.c()).iterator();
    L16:
        if (r111.hasNext() == false) goto L79;
        Object r11 = r111.next();
        int r20 = r3 + 1;
        if (r3 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        MVIState r21 = (MVIState) r11;
        if (((GiftGroupMostlyUsedInfo) com.bytedance.android.anya.h.b(((GiftGroupItem) r21).getMostlyUsedInfo())).getShow() == false) goto L31;
        new k0.a();     // Catch: Throwable -> L32
        GiftGroupItem r23 = (GiftGroupItem) r21;     // Catch: Throwable -> L32
        com.bytedance.android.anya.internal.c r24 = r23.getMostlyUsedInfo();     // Catch: Throwable -> L32
        if (((RefreshGiftMostlyUsedStatus) r17).getSuccess() == false) goto L26;
        GiftGroupMostlyUsedInfo r25 = GiftGroupMostlyUsedInfo.copy$default((GiftGroupMostlyUsedInfo) r23.getMostlyUsedInfo().c(), false, false, false, 1, null);     // Catch: Throwable -> L32
    L27:
        r24.a(r25);     // Catch: Throwable -> L32
        if ((!r21.modifiedProperties.isEmpty()) == false) goto L31;
        ((t) r110.c()).d(r3);
        goto L31
    L26:
        r25 = GiftGroupMostlyUsedInfo.copy$default((GiftGroupMostlyUsedInfo) r23.getMostlyUsedInfo().c(), false, false, false, 3, null);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if ((!r21.modifiedProperties.isEmpty()) == false) goto L36;
        ((t) r110.c()).d(r3);
    L36:
        throw th;
    L31:
        r3 = r20;
        goto L16
    L79:
        return;
    L76:
        return;
    L78:
        return;
    }

    public static final void h1(GiftGroupViewModel r1, l0 r2, GroupViewState r3, int r4) {
        r1.getClass();
        u1(r2, r3);
        if (((Number) com.bytedance.android.anya.h.b(r3.getComboStartAnimPosition())).intValue() == (-1)) goto L6;
        l0.h(r3.getComboStartAnimPosition(), -1);
    L6:
        if (((Number) com.bytedance.android.anya.h.b(r3.getComboEndAnimPosition())).intValue() == (-1)) goto L8;
        l0.h(r3.getComboEndAnimPosition(), -1);
    L8:
        l0.h(r3.getSelectedPosition(), Integer.valueOf(r4));
        l0.h(r3.getComboStartAnimPosition(), Integer.valueOf(r4));
    }

    public final void x1(l0<GroupViewState> r10, vz1.e r11, GroupViewState r13, int r14) {
        ArrayList r15 = new ArrayList();
        List<com.bytedance.android.livesdk.gift.model.h0> r0 = r11.a.getGiftGroupList();
        if (r0 == null) goto L5;
        r15.addAll(r0);
    L5:
        CollectionsKt.sortWith(r15, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel.a.a);
        com.bytedance.android.livesdk.gift.model.h0 r1 = (com.bytedance.android.livesdk.gift.model.h0) CollectionsKt.getOrNull(r15, 0);
        if (r1 == null) goto L11;
        if (r1.getGroupCount() != 1) goto L11;
        ListProtector.remove(r15, 0);
    L11:
        if ((!r11.a.getGiftGroupList().isEmpty()) == true) goto L13;
    L15:
        ArrayList r2 = new ArrayList();
        if (this.M.s() == false) goto L21;
        if (r11.e == true) goto L21;
        GiftGroupItem r3 = new GiftGroupItem();
        new k0.a();
        com.bytedance.android.anya.internal.c r4 = r3.getMostlyUsedInfo();
        com.bytedance.android.anya.internal.c r5 = r4;
        r5.a(new GiftGroupMostlyUsedInfo(true, this.M.g.contains(Long.valueOf(r11.a.getId())), this.M.F(r11.a.getId())));
        r2.add(r3);
    L21:
        if (((Boolean) nz1.a.q0.getValue(null, nz1.a.a[67])).booleanValue() == true) goto L23;
    L24:
        Iterator r16 = r15.iterator();
    L26:
        if (r16.hasNext() == false) goto L28;
        com.bytedance.android.livesdk.gift.model.h0 r17 = (com.bytedance.android.livesdk.gift.model.h0) r16.next();
        GiftGroupItem r6 = new GiftGroupItem();
        new k0.a();
        r6.getGroupInfo().a(r17);
        r2.add(r6);
    L28:
        l0.h(r13.getIconModel(), r11);
        l0.d(r13.getGroupItemList());
        l0.c(r13.getGroupItemList(), r2);
        return;
    L23:
        if (r14 != VisualStatus.INSTANCE.getIDLE()) goto L28;
    L13:
        if (r15.isEmpty() == true) goto L15;
        r11.a.getType();
        goto L15
    }

    public static final void e1(final GiftGroupViewModel r29, final l0 r30, final GroupViewState r31, final int r33, final int r34, int r35) {
        r29.getClass();
        u r1 = r31.getGroupItemList();
        MVIState r2 = (MVIState) ((s0) r1.c()).get(r33);
        new k0.a();     // Catch: Throwable -> L104
        ((GiftGroupItem) r2).getComboCount().a(Integer.valueOf(r35));     // Catch: Throwable -> L104
        if ((!r2.modifiedProperties.isEmpty()) == false) goto L7;
        ((t) r1.c()).d(r33);
    L7:
        r0<GroupViewState, vz1.e> r3 = r31.getIconModel();
        r30.getClass();
        vz1.e r13 = (vz1.e) com.bytedance.android.anya.h.b(r3);
        if (nz1.a.g() == false) goto L12;
        l1 r4 = r29.F.a;
        if (r4 == null) goto L12;
        int r5 = r4.getBuffLevel();
    L14:
        if (nz1.a.h().c() == false) goto L16;
        l1 r6 = r29.I.q();
    L17:
        final l1 r10 = r6;
        if (nz1.a.h().d() == false) goto L20;
        n r7 = r29.I.k();
    L21:
        final n r9 = r7;
        int r8 = r29.J.c(r13.a, SendGiftSource.GiftDialog, r10, r9);
        if (r8 == 0) goto L28;
        h1 r0 = r13.a;
        if (r0 == null) goto L26;
        Long r11 = Long.valueOf(r0.getId());
    L27:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.Q(r8, r11.longValue(), -1);
        return;
    L26:
        r11 = null;
        goto L27
    L28:
        Iterator r14 = ((ArrayList) r29.y.c).iterator();
    L30:
        if (r14.hasNext() == false) goto L99;
        com.bytedance.android.livesdk.gift.platform.business.f r15 = (com.bytedance.android.livesdk.gift.platform.business.f) r14.next();
        if (r13.e == false) goto L39;
        l2 r16 = r29.z.f(Long.valueOf(r13.b));
        if (r16 != null) goto L36;
        AbsPanel<?> r17 = new pz1.d();
    L37:
        r14 = r14;
    L74:
        AbsPanel<?> r18 = r17;
    L91:
        IBaseUser r19 = r29.D.a;
        boolean r110 = r29.E.j();
        List<IBaseUser> r111 = r29.E.i();
        com.bytedance.android.livesdk.gift.platform.core.model.n r20 = new com.bytedance.android.livesdk.gift.platform.core.model.n(r13.o, r13.p, 4);
        Integer r21 = (Integer) ((LinkedHashMap) r29.B.c).get(Integer.valueOf(r29.u));
        if (r21 == null) goto L94;
        int r24 = r21.intValue();
    L96:
        if (com.bytedance.android.livesdk.gift.platform.business.f.a.c(r15, r18, r5, r34, r19, r110, r111, r20, r10, r9, r29.N.y(), r24, null, r13.z, 8576) == true) goto L121;
        r14 = r14;
        goto L30
    L121:
        return;
    L94:
        r24 = 0;
        goto L96
    L36:
        r17 = ((m) com.bytedance.android.livesdk.gift.util.b.a().d(m.class)).d(r16);
        goto L37
    L39:
        if (nz1.a.g() == false) goto L75;
        h1 r23 = r13.a;
        n r25 = r29.F.b;
        if (r23 != null) goto L43;
        r17 = new pz1.d();
        goto L37
    L43:
        com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a r26 = ((m) com.bytedance.android.livesdk.gift.util.b.a().d(m.class)).l(r23);
        int r27 = r23.getType();
        String r112 = BuildConfig.FLAVOR;
        if (r27 != 13) goto L54;
        if (r25 == null) goto L48;
        r26.b = gz1.c.g(r25);
        r26.g = r25.getConfigId();
    L48:
        if (r25 == null) goto L53;
        String r28 = r25.getCardName();
        if (r28 == null) goto L53;
        r112 = r28;
    L53:
        r26.c = r112;
    L73:
        r14 = r14;
        r17 = r26;
        goto L74
    L54:
        r14 = r14;
        g r36 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r36 == null) goto L73;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r37 = r36.h();
        if (r37 == null) goto L73;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.h> r38 = r37.values().iterator();
    L61:
        if (r38.hasNext() == false) goto L73;
        AbsPanel<?> r39 = r38.next().f(r23);
        if (r39 == null) goto L61;
        if (r25 == null) goto L67;
        r39.b = gz1.c.g(r25);
        r39.g = r25.getConfigId();
    L67:
        if (r25 == null) goto L72;
        String r40 = r25.getCardName();
        if (r40 == null) goto L72;
        r112 = r40;
    L72:
        r39.c = r112;
        r17 = r39;
        goto L74
    L75:
        r14 = r14;
        h1 r41 = r13.a;
        if (r41 != null) goto L78;
        AbsPanel<?> r43 = new pz1.d();
    L90:
        r18 = r43;
        goto L91
    L78:
        com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a r44 = ((m) com.bytedance.android.livesdk.gift.util.b.a().d(m.class)).l(r41);
        g r45 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r45 == null) goto L89;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r46 = r45.h();
        if (r46 == null) goto L89;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.h> r47 = r46.values().iterator();
    L85:
        if (r47.hasNext() == false) goto L89;
        AbsPanel<?> r48 = r47.next().f(r41);
        if (r48 == null) goto L85;
        r43 = r48;
    L89:
        r43 = r44;
        goto L90
    L99:
        final com.bytedance.android.livesdk.gift.platform.core.model.n r113 = new com.bytedance.android.livesdk.gift.platform.core.model.n(r13.o, r13.p, 4);
        if (nz1.a.g() == false) goto L102;
        final int r49 = 0;
        final String r114 = null;
        h0.d(r29.x, r34, r13, r113, r10, r9, null, new GiftGroupViewModel$sendGroupGift$$inlined$let$lambda$1(r29, r30, r34, r49, r113, r10, r9, r114, r31, r33));
        return;
    L102:
        final int r50 = 0;
        final String r51 = null;
        r29.x.a(r34, r13, r113, null, null, new GiftGroupViewModel$sendGroupGift$$inlined$let$lambda$2(r29, r30, r34, r50, r113, r10, r9, r51, r31, r33));
        return;
    L20:
        r7 = r29.F.b;
        goto L21
    L16:
        r6 = r29.F.a;
    L12:
        r5 = 0;
    L104:
        th = move-exception;
        if ((!r2.modifiedProperties.isEmpty()) == false) goto L108;
        ((t) r1.c()).d(r33);
    L108:
        throw th;
    }

    public GiftGroupViewModel(h0 r17, u0 r18, PropListService r19, u1 r20, e1 r21, k r23, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r24, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r25, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.b r26, GiftExtraRepo r27, i r28, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r29, GiftSendPreCheckService r210, GiftDialogStateDataStore r30, GiftSearchDataStore r31, GiftMostlyUsedDataStore r33, GiftTopicDataStore r34) {
        Intrinsics.checkNotNullParameter(r17, "sendGiftRepo");
        Intrinsics.checkNotNullParameter(r18, "internalScopeService");
        Intrinsics.checkNotNullParameter(r19, "propListService");
        Intrinsics.checkNotNullParameter(r20, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r21, "giftListService");
        Intrinsics.checkNotNullParameter(r23, "roomDataService");
        Intrinsics.checkNotNullParameter(r24, "receiverService");
        Intrinsics.checkNotNullParameter(r25, "allMicService");
        Intrinsics.checkNotNullParameter(r26, "buffRepo");
        Intrinsics.checkNotNullParameter(r27, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r28, "giftListRepo");
        Intrinsics.checkNotNullParameter(r29, "cardDataStore");
        Intrinsics.checkNotNullParameter(r210, "sendPreCheckService");
        Intrinsics.checkNotNullParameter(r30, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r31, "giftSearchDataStore");
        Intrinsics.checkNotNullParameter(r33, "giftMostlyUsedDataStore");
        Intrinsics.checkNotNullParameter(r34, "giftTopicDataStore");
        this.x = r17;
        this.y = r18;
        this.z = r19;
        this.A = r20;
        this.B = r21;
        this.C = r23;
        this.D = r24;
        this.E = r25;
        this.F = r26;
        this.G = r27;
        this.H = r28;
        this.I = r29;
        this.J = r210;
        this.K = r30;
        this.L = r31;
        this.M = r33;
        this.N = r34;
        this.v = SetsKt.setOf(r30);
        this.w = new CompositeDisposable();
    }
}
