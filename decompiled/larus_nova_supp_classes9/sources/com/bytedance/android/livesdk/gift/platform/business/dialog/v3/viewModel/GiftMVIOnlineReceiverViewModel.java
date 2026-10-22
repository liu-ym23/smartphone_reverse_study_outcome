package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import android.net.Uri;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.t;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.configmodel.e0;
import com.bytedance.android.livesdk.gift.model.j0;
import com.bytedance.android.livesdk.gift.model.t2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.ChangeReceiverSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverSwitchHelper;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.d0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeMultiSendReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickReceiverItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickReceiverWidget;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverStateMachineState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ReceiverItemState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ReceiverUIType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowReceiverDialog;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateCurrentReceiverList;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateFanTicket;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateMultiSendReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateReceiverInfo;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.w0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIOnlineReceiverViewModel extends com.bytedance.android.anya.f<GiftReceiverViewState, GiftReceiverStateMachineState, GiftAction> implements o {
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.h A;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f B;
    public final yz0.k C;
    public final y u;
    public final u1 v;
    public final w0 w;
    public final GiftReceiverRepoService x;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a y;
    public final com.bytedance.android.livesdk.revenue.room.a z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final MVIState F(l0 r19) {
        Intrinsics.checkNotNullParameter(r19, "$this$createState");
        GiftReceiverStateMachineState r2 = new GiftReceiverStateMachineState();
        boolean r4 = false;
        if (this.y.j() == false) goto L5;
        h1(r19, r2, this.y.i().size());
    L12:
        e1(r19, r2);
        r0<GiftReceiverStateMachineState, Boolean> r3 = r2.getShowNotice();
        if (this.x.k().a.isEmpty() == false) goto L16;
    L31:
        Boolean r5 = Boolean.valueOf(r4);
        r19.getClass();
        l0.h(r3, r5);
        return r2;
    L16:
        if (nz1.a.j().a() == false) goto L31;
        com.bytedance.tools.kcp.spongepreference.runtime.a r6 = ay1.b.l0;
        KProperty[] r7 = ay1.b.a;
        long r10 = ((Number) r6.getValue(null, r7[75])).longValue();
        Calendar r8 = Calendar.getInstance();
        r8.setTimeInMillis(r10);
        int r9 = r8.get(7);
        Calendar r11 = Calendar.getInstance();
        r11.setTimeInMillis(System.currentTimeMillis());
        if (r9 == r11.get(7)) goto L21;
        ArrayList r13 = new ArrayList();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        ay1.b.j0.setValue(null, r7[73], r13);
    L21:
        e0 r14 = nz1.a.j();
        String r15 = String.valueOf(((IRoom) this.z.getRoom().getValue()).getRoomId());
        com.bytedance.tools.kcp.spongepreference.runtime.a r16 = ay1.b.j0;
        ArrayList r17 = (ArrayList) r16.getValue(null, r7[73]);
        int r18 = r17.size();
        com.bytedance.tools.kcp.spongepreference.runtime.a r20 = ay1.b.k0;
        int r21 = ((Number) r20.getValue(null, r7[74])).intValue();
        if (r17.contains(r15) == false) goto L24;
    L30:
        r4 = false;
        goto L31
    L24:
        if (r18 >= r14.d()) goto L30;
        if (r21 >= r14.e()) goto L30;
        r17.add(r15);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.setValue(null, r7[73], r17);
        r20.setValue(null, r7[74], Integer.valueOf(r21 + 1));
        long r110 = System.currentTimeMillis();
        r6.setValue(null, r7[75], Long.valueOf(r110));
        r4 = true;
        goto L31
    L5:
        String r23 = this.B.a.getRealNickName();
        if (r23 == null) goto L8;
        r0<GiftReceiverStateMachineState, String> r24 = r2.getNickname();
        r19.getClass();
        l0.h(r24, r23);
    L8:
        py.k r25 = this.B.a.getAvatarThumbKt();
        if (r25 == null) goto L11;
        r0<GiftReceiverStateMachineState, py.k> r26 = r2.getAvatarThumb();
        r19.getClass();
        l0.h(r26, r25);
    L11:
        r0<GiftReceiverStateMachineState, Integer> r27 = r2.getAvatarVisibility();
        r19.getClass();
        l0.h(r27, 0);
        goto L12
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftReceiverViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIOnlineReceiverViewModel$bindToParent$1 r0 = GiftMVIOnlineReceiverViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList] */
    public final void e1(l0<GiftReceiverStateMachineState> r8, GiftReceiverStateMachineState r9) {
        if (w.a() == true) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        if (this.y.j() == false) goto L11;
        List r1 = CollectionsKt.reversed(d0.c(this.y.i()));
        ?? r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        r2.add(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h((IBaseUser) r3.next(), null));
    L13:
        if (this.y.j() == false) goto L16;
        ReceiverUIType r4 = ReceiverUIType.AllMic;
    L19:
        Iterator r5 = ((Iterable) r2).iterator();
    L21:
        if (r5.hasNext() == false) goto L43;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h r6 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h) r5.next();
        ReceiverItemState r7 = new ReceiverItemState();
        new k0.a();
        r7.getReceiver().a(r6.a);
        r7.getReceiverUIType().a(r4);
        py.k r10 = r6.a.getAvatarThumbKt();
        if (r10 == null) goto L25;
        r7.getAvatarImg().a(r10);
    L25:
        String r11 = r6.a.getRealNickName();
        if (r11 == null) goto L29;
        r7.getReceiverName().a(r11);
    L29:
        if (Intrinsics.areEqual(this.B.a.getIdString(), r6.a.getIdString()) == false) goto L31;
        r7.isSelected().a(Boolean.TRUE);
    L32:
        Lazy r13 = GiftReceiverSwitchHelper.a;
        t2 r14 = r6.b;
        if (r14 == null) goto L42;
        j0 r15 = r14.getExtraInfo();
        if (r15 == null) goto L42;
        py.k r16 = r15.getIcon();
        if (r16 == null) goto L39;
        r7.getStatusImg().a(r16);
    L39:
        String r17 = r15.getLabel();
        if (r17 == null) goto L42;
        r7.getStatusLabel().a(r17);
    L42:
        r0.add(r7);
        goto L21
    L31:
        r7.isSelected().a(Boolean.FALSE);
        goto L32
    L43:
        r0<GiftReceiverStateMachineState, ReceiverUIType> r18 = r9.getReceiverUIType();
        r8.getClass();
        l0.h(r18, r4);
        l0.d(r9.getReceiverItemList());
        l0.c(r9.getReceiverItemList(), r0);
        ALogger.d("GiftMVIOnlineReceiverViewModel", "refreshReceiverList uitype " + r4);
        return;
    L16:
        if (r2.size() <= 1) goto L18;
        Lazy r19 = GiftReceiverSwitchHelper.a;
        r4 = ReceiverUIType.MultiReceiver;
        goto L19
    L18:
        r4 = ReceiverUIType.SingleReceiver;
        goto L19
    L11:
        Lazy r20 = GiftReceiverSwitchHelper.a;
        r2 = d0.c(this.B.d);
        goto L13
    }

    public final void h1(l0<GiftReceiverStateMachineState> r4, GiftReceiverStateMachineState r5, int r6) {
        if (w.a() == false) goto L5;
        r0<GiftReceiverStateMachineState, String> r0 = r5.getNickname();
        String r7 = s1.C(2131917166, new Object[]{Integer.valueOf(r6)});
        r4.getClass();
        l0.h(r0, r7);
    L6:
        e1(r4, r5);
        return;
    L5:
        r0<GiftReceiverStateMachineState, String> r1 = r5.getNickname();
        String r8 = s1.C(2131917165, new Object[]{Integer.valueOf(r6)});
        r4.getClass();
        l0.h(r1, r8);
        l0.h(r5.getAvatarVisibility(), 8);
        goto L6
    }

    public final void w0(com.bytedance.android.anya.j0 r7, MVIState r8, p r9) {
        GiftReceiverStateMachineState r10 = (GiftReceiverStateMachineState) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter((GiftAction) r9, "action");
        com.bytedance.android.anya.internal.p r11 = r7.getContext();
        com.bytedance.android.anya.internal.p.b r13 = r11.b(r11.c(GiftPanelState.class), GiftMVIOnlineReceiverViewModel$postReduce$1$1.INSTANCE);
        boolean r0 = false;
        Object r1 = 0;
        com.bytedance.android.anya.internal.c r14 = (v) r13.a.invoke();
        if (r14 == null) goto L28;
        com.bytedance.android.anya.internal.c r2 = r14;
        Object r3 = r14.c();     // Catch: Throwable -> L24
        int r4 = r14.c;     // Catch: Throwable -> L24
        Object r5 = ((LinkedHashMap) r7.d).get(r14);     // Catch: Throwable -> L24
        if (r5 == null) goto L11;
        r1 = r5;
    L11:
        if (r4 <= ((Number) r1).intValue()) goto L13;
        r0 = true;
    L13:
        if (r0 == false) goto L20;
        com.bytedance.android.anya.j0.a r6 = com.bytedance.android.anya.j0.a.a;     // Catch: Throwable -> L24
        com.bytedance.android.livesdk.gift.platform.core.giftlist.h r15 = this.A;     // Catch: Throwable -> L24
        ReceiverType r16 = this.B.b;     // Catch: Throwable -> L24
        r0<GiftTabViewState, Integer> r17 = ((GiftTabViewState) r3).getTabType();     // Catch: Throwable -> L24
        r6.getClass();     // Catch: Throwable -> L24
        w1 r18 = r15.ve(r16, ((Number) com.bytedance.android.anya.h.b(r17)).intValue());     // Catch: Throwable -> L24
        if (r18 == null) goto L22;
        GiftReceiverStateMachineState r19 = (GiftReceiverStateMachineState) r7.g.f();     // Catch: Throwable -> L24
        r0<GiftReceiverStateMachineState, py.k> r20 = r10.getBackground();     // Catch: Throwable -> L24
        py.k r21 = r18.getReceiversModBg();     // Catch: Throwable -> L24
        if (r21 != null) goto L19;
        r21 = (py.k) vh7.f.c(py.k.class);     // Catch: Throwable -> L24
    L19:
        l0.h(r20, r21);     // Catch: Throwable -> L24
    L22:
        r7.c.put(r14, Integer.valueOf(r2.c));
        return;
    L20:
        if (r0 == false) goto L22;
        r7.a();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r7.c.put(r14, Integer.valueOf(r2.c));
        throw th;
    }

    public final void y0(l0 r11, MVIState r13, p r14) {
        GiftReceiverStateMachineState r15 = (GiftReceiverStateMachineState) r13;
        GiftAction r16 = (GiftAction) r14;
        Intrinsics.checkNotNullParameter(r11, "$this$reduce");
        Intrinsics.checkNotNullParameter(r15, "state");
        Intrinsics.checkNotNullParameter(r16, "action");
        if ((r16 instanceof UpdateFanTicket) == false) goto L5;
        K0(new UpdateReceiverInfo(((UpdateFanTicket) r16).getData()));
        return;
    L5:
        boolean r1 = false;
        if ((r16 instanceof ClickReceiverWidget) == false) goto L22;
        u1 r17 = this.v;
        String r18 = this.B.a.getIdString();
        int r0 = this.x.k().a.size();
        int r3 = u1.B;
        r17.L0(r18, r0, null);
        if (iy0.e.b(this.C.getRoom()) == false) goto L10;
        this.x.F();
    L10:
        int r19 = ((ClickReceiverWidget) r16).getHeight();
        String r110 = (String) nz1.a.u.getValue(null, nz1.a.a[19]);
        if (r110.length() <= 0) goto L13;
        r1 = true;
    L13:
        if (r1 == false) goto L19;
        Uri.Builder r111 = UriProtector.parse(r110).buildUpon();
        r111.appendQueryParameter(sz1.a.KEY_HEIGHT, String.valueOf(r19));
        r111.appendQueryParameter("gift_panel_session_id", this.w.a);
        if (nz1.a.j().c() == false) goto L17;
        r111.appendQueryParameter("highlight_style", "1");
    L18:
        Uri r112 = r111.build();
    L20:
        K0(new ShowReceiverDialog(r112));
        return;
    L17:
        r111.appendQueryParameter("highlight_style", "0");
        goto L18
    L19:
        r112 = Uri.EMPTY;
        goto L20
    L22:
        if ((r16 instanceof ChangeReceiver) == false) goto L31;
        ChangeReceiver r113 = (ChangeReceiver) r16;
        String r2 = r113.getUser().getRealNickName();
        if (r2 == null) goto L26;
        r0<GiftReceiverStateMachineState, String> r4 = r15.getNickname();
        r11.getClass();
        l0.h(r4, r2);
    L26:
        py.k r114 = r113.getUser().getAvatarThumbKt();
        if (r114 == null) goto L29;
        r0<GiftReceiverStateMachineState, py.k> r5 = r15.getAvatarThumb();
        r11.getClass();
        l0.h(r5, r114);
    L29:
        r0<GiftReceiverStateMachineState, Integer> r115 = r15.getAvatarVisibility();
        r11.getClass();
        l0.h(r115, 0);
        return;
    L31:
        if ((r16 instanceof ChangeMultiSendReceiver) == false) goto L34;
        h1(r11, r15, ((ChangeMultiSendReceiver) r16).getUsers().size());
        return;
    L34:
        if ((r16 instanceof UpdateMultiSendReceiver) == false) goto L39;
        if (this.y.j() == false) goto L94;
        h1(r11, r15, ((UpdateMultiSendReceiver) r16).getCurrentReceivers().size());
        return;
    L94:
        return;
    L39:
        if ((r16 instanceof ClickReceiverItem) == false) goto L76;
        ClickReceiverItem r116 = (ClickReceiverItem) r16;
        int r6 = r116.getPosition();
        IBaseUser r117 = r116.getReceiver();
        if (r117 == null) goto L96;
        u r7 = r15.getReceiverItemList();
        Iterator r8 = ((Iterable) r7.c()).iterator();
        int r9 = 0;
    L44:
        if (r8.hasNext() == false) goto L59;
        Object r10 = r8.next();
        int r20 = r9 + 1;
        if (r9 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        MVIState r21 = (MVIState) r10;
        new k0.a();     // Catch: Throwable -> L54
        ((ReceiverItemState) r21).isSelected().a(Boolean.FALSE);     // Catch: Throwable -> L54
        if ((!r21.modifiedProperties.isEmpty()) == false) goto L53;
        ((t) r7.c()).d(r9);
    L53:
        r9 = r20;
    L54:
        th = move-exception;
        if ((!r21.modifiedProperties.isEmpty()) == false) goto L58;
        ((t) r7.c()).d(r9);
    L58:
        throw th;
    L59:
        u r23 = r15.getReceiverItemList();
        MVIState r24 = (MVIState) ((s0) r23.c()).get(r6);
        new k0.a();     // Catch: Throwable -> L70
        ReceiverItemState r25 = (ReceiverItemState) r24;     // Catch: Throwable -> L70
        if ((!Intrinsics.areEqual(((IBaseUser) r25.getReceiver().c()).getIdString(), r117.getIdString())) == false) goto L63;
        r1 = true;
    L65:
        if ((true ^ r24.modifiedProperties.isEmpty()) == false) goto L67;
        ((t) r23.c()).d(r6);
    L67:
        if (r1 == false) goto L69;
        e1(r11, r15);
    L69:
        this.u.a(r117.getIdString(), ChangeReceiverSource.Other);
        return;
    L63:
        r25.isSelected().a(Boolean.TRUE);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        if ((!r24.modifiedProperties.isEmpty()) == false) goto L74;
        ((t) r23.c()).d(r6);
    L74:
        throw th;
    L96:
        return;
    L76:
        if ((r16 instanceof UpdateCurrentReceiverList) == true) goto L78;
        return;
    L78:
        if (((UpdateCurrentReceiverList) r16).getTriggerByReceiverPanel() == true) goto L81;
        r0<GiftReceiverStateMachineState, ReceiverUIType> r118 = r15.getReceiverUIType();
        r11.getClass();
        if (((ReceiverUIType) com.bytedance.android.anya.h.b(r118)) != ReceiverUIType.SingleReceiver) goto L81;
        return;
    L81:
        e1(r11, r15);
    }

    public GiftMVIOnlineReceiverViewModel(y r2, u1 r3, w0 r4, DataCenter r5, e1 r6, GiftReceiverRepoService r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r8, com.bytedance.android.livesdk.revenue.room.a r9, com.bytedance.android.livesdk.gift.platform.core.giftlist.h r10, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r11, yz0.k r13) {
        Intrinsics.checkNotNullParameter(r2, "selectReceiverService");
        Intrinsics.checkNotNullParameter(r3, "logService");
        Intrinsics.checkNotNullParameter(r4, "logServiceKmp");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "giftListService");
        Intrinsics.checkNotNullParameter(r7, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r8, "allMicService");
        Intrinsics.checkNotNullParameter(r9, "roomContext");
        Intrinsics.checkNotNullParameter(r10, "listPanelRepository");
        Intrinsics.checkNotNullParameter(r11, "receiverService");
        Intrinsics.checkNotNullParameter(r13, "roomDataService");
        this.u = r2;
        this.v = r3;
        this.w = r4;
        this.x = r7;
        this.y = r8;
        this.z = r9;
        this.A = r10;
        this.B = r11;
        this.C = r13;
    }
}
