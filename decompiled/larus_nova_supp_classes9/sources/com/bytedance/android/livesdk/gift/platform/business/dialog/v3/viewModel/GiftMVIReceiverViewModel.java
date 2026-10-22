package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.d0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeCurrentReceiverMode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeNewReceiverPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.NewReceiverPanelStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIReceiverViewModel extends com.bytedance.android.livesdk.gift.framework.base.b<GiftPanelState, GiftReceiverViewState, GiftAction> implements o {
    public final u1 A;
    public final yz0.k B;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f C;
    public GiftReceiverViewState.Mode z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftReceiverViewState();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIReceiverViewModel$bindToParent$1 r0 = GiftMVIReceiverViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void h1(j0 r8, MVIState r9, p r10, Function2 r11) {
        GiftReceiverViewState r13 = (GiftReceiverViewState) r9;
        GiftAction r14 = (GiftAction) r10;
        Intrinsics.checkNotNullParameter(r8, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r13, "state");
        Intrinsics.checkNotNullParameter(r14, "action");
        Intrinsics.checkNotNullParameter(r11, "dispatchPostReduce");
        com.bytedance.android.anya.internal.p r0 = r8.getContext();
        com.bytedance.android.anya.internal.p.b r1 = r0.a(r0.b(r0.c(GiftPanelState.class), GiftMVIReceiverViewModel$postReduce$1$wrapped$1.INSTANCE), GiftMVIReceiverViewModel$postReduce$1$wrapped$2.INSTANCE);
        boolean r2 = false;
        Object r3 = 0;
        com.bytedance.android.anya.internal.c r4 = (v) r1.a.invoke();
        if (r4 == null) goto L36;
        com.bytedance.android.anya.internal.c r5 = r4;
        Object r6 = r4.c();     // Catch: Throwable -> L38
        int r7 = r4.c;     // Catch: Throwable -> L38
        Object r15 = ((LinkedHashMap) r8.d).get(r4);     // Catch: Throwable -> L38
        if (r15 == null) goto L11;
        r3 = r15;
    L11:
        if (r7 <= ((Number) r3).intValue()) goto L13;
        boolean r16 = true;
    L14:
        if (r16 == false) goto L33;
        k0 r17 = j0.a.a;     // Catch: Throwable -> L38
        r17.getClass();     // Catch: Throwable -> L38
        r r18 = ((GiftVerticalState) r6).toBusinessState(r17);     // Catch: Throwable -> L38
        if ((r18 instanceof GiftListBusinessState.GiftSelected) == true) goto L18;
        r18 = null;
    L18:
        GiftListBusinessState.GiftSelected r19 = (GiftListBusinessState.GiftSelected) r18;     // Catch: Throwable -> L38
        if (r19 == null) goto L32;
        vz1.e r20 = r19.getIconModel();     // Catch: Throwable -> L38
        if (r20 == null) goto L32;
        h1 r21 = r20.a;     // Catch: Throwable -> L38
        if (r21 == null) goto L32;
        GiftReceiverViewState r23 = (GiftReceiverViewState) r8.g.f();     // Catch: Throwable -> L38
        GiftReceiverViewState.Mode r24 = this.z;     // Catch: Throwable -> L38
        if (r21.getBizType() != 1) goto L28;
        r2 = true;
    L28:
        if (r2 == false) goto L30;
        r24 = GiftReceiverViewState.Mode.IDLE;     // Catch: Throwable -> L38
    L30:
        l0.h(r13.getMode(), r24);     // Catch: Throwable -> L38
    L32:
        r8.c.put(r4, Integer.valueOf(r5.c));
        return;
    L33:
        if (r16 == false) goto L35;
        r8.a();     // Catch: Throwable -> L38
    L35:
        r8.c.put(r4, Integer.valueOf(r5.c));
        goto L36
    L13:
        r16 = false;
    L38:
        th = move-exception;
        r8.c.put(r4, Integer.valueOf(r5.c));
        throw th;
    L36:
        r11.invoke(r8, r14);
    }

    public final void s1(l0 r17, MVIState r18, p r19, Function1 r20) {
        GiftReceiverViewState r2 = (GiftReceiverViewState) r18;
        GiftAction r3 = (GiftAction) r19;
        Intrinsics.checkNotNullParameter(r17, "$this$reduce");
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r20, "dispatchReduce");
        if ((r3 instanceof ChangeCurrentReceiverMode) == false) goto L43;
        String r7 = "0";
        if (((ChangeCurrentReceiverMode) r3).getShouldShowGuestListPanel() == false) goto L40;
        r0<GiftReceiverViewState, GiftReceiverViewState.Mode> r4 = r2.getMode();
        GiftReceiverViewState.Mode r11 = GiftReceiverViewState.Mode.Receiver;
        r17.getClass();
        l0.h(r4, r11);
        com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges("giftPanelReceiverShowEvent", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_receiver_show", "1")}));
        u1 r5 = this.A;
        IRoom r8 = this.B.getRoom();
        List<com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h> r9 = this.C.d;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r13 = r9.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r10.add(((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h) r13.next()).a);
        goto L8
    L10:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r14 = this.C;
        IBaseUser r15 = r14.a;
        ReceiverType r16 = r14.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "showReceiverList");
        Intrinsics.checkNotNullParameter(r15, "selectUser");
        Intrinsics.checkNotNullParameter(r16, "selectReceiverType");
        if (r5.i == true) goto L41;
        r5.i = true;
        n r110 = new n();
        mz0.o r111 = new mz0.o(r110.a);
        if (r8 != null) goto L16;
    L19:
        if (r8 == null) goto L21;
        String r6 = r8.getIdStr();
    L22:
        r111.a("room_id", String.valueOf(r6));
        if (r8 == null) goto L26;
        String r21 = r8.getAnchorId();
        if (r21 == null) goto L26;
    L27:
        r111.a("anchor_id", r21);
        r111.a("user_id", u1.s());
        r111.a("selected_user_id", r15.getIdString());
        r111.a("selected_user_type", r5.t1(r16, r15));
        List r23 = d0.c(r10);
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r25 = r23.iterator();
    L29:
        if (r25.hasNext() == false) goto L31;
        IBaseUser r26 = (IBaseUser) r25.next();
        r24.add(r5.t1(r5.q.R(r26), r26));
        goto L29
    L31:
        r111.a("to_user_type", r24.toString());
        List r27 = d0.c(r10);
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r29 = r27.iterator();
    L33:
        if (r29.hasNext() == false) goto L35;
        r28.add(((IBaseUser) r29.next()).getIdString());
        goto L33
    L35:
        r111.a("to_user_id", r28.toString());
        r111.a("gift_dialog_request_id", u1.x());
        if ((!r5.q.o(1024).a.isEmpty()) == false) goto L38;
        String r30 = "shortcut";
    L39:
        r111.a("entrance_type", r30);
        r111.a("gift_panel_session_id", r5.n.a);
        m r31 = new m();
        com.bytedance.android.livesdk.revenue.log.i r33 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r33, "pageSourceLog");
        ((ArrayList) r31.a).add(r33.a);
        r31.b(LogCommon.ROOM);
        ((ArrayList) r110.b).addAll(r31.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((f80.a) r35).w3("livesdk_send_choose_entrance_show", r110.a, r110.b);
        goto L41
    L38:
        r30 = "no_shortcut";
    L26:
        r21 = BuildConfig.FLAVOR;
        goto L27
    L21:
        r6 = null;
        goto L22
    L16:
        if (iy0.e.b(r8) == false) goto L18;
        r7 = "1";
    L18:
        r111.a("is_grouped_lived", r7);
    L41:
        r0<GiftReceiverViewState, GiftReceiverViewState.Mode> r36 = r2.getMode();
        r17.getClass();
        this.z = (GiftReceiverViewState.Mode) com.bytedance.android.anya.h.b(r36);
    L48:
        r20.invoke(r3);
        return;
    L40:
        r0<GiftReceiverViewState, GiftReceiverViewState.Mode> r37 = r2.getMode();
        GiftReceiverViewState.Mode r38 = GiftReceiverViewState.Mode.IDLE;
        r17.getClass();
        l0.h(r37, r38);
        com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges("giftPanelReceiverShowEvent", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_receiver_show", "0")}));
        goto L41
    L43:
        if ((r3 instanceof ChangeNewReceiverPanel) == false) goto L48;
        if (((ChangeNewReceiverPanel) r3).getShow() == false) goto L47;
        r0<GiftReceiverViewState, NewReceiverPanelStatus> r39 = r2.getShowNewReceiverPanel();
        NewReceiverPanelStatus r40 = NewReceiverPanelStatus.Show;
        r17.getClass();
        l0.h(r39, r40);
        goto L48
    L47:
        r0<GiftReceiverViewState, NewReceiverPanelStatus> r41 = r2.getShowNewReceiverPanel();
        NewReceiverPanelStatus r43 = NewReceiverPanelStatus.Hide;
        r17.getClass();
        l0.h(r41, r43);
        goto L48
    }

    public GiftMVIReceiverViewModel(DataCenter r2, GiftMVIOnlineReceiverViewModel r3, u1 r4, yz0.k r5, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r6) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "stateMachineViewModel");
        Intrinsics.checkNotNullParameter(r4, "logService");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        Intrinsics.checkNotNullParameter(r6, "receiverService");
        super(CollectionsKt.listOf(r3));
        this.A = r4;
        this.B = r5;
        this.C = r6;
        this.z = GiftReceiverViewState.Mode.IDLE;
    }
}
