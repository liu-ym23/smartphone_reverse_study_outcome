package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import android.content.Context;
import android.os.SystemClock;
import android.util.LongSparseArray;
import android.util.Pair;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.GiftPluginType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.l;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.manager.PropManager;
import com.bytedance.android.livesdk.gift.platform.format.service.FormatGiftListService;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import ita.i;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FormatGiftListViewModel extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a implements o {
    public final Map<w1, LongSparseArray<Integer>> e;
    public final FormatGiftListViewModel$mSyncGiftListCallback$1 f;
    public final b g;
    public final Function1<StateMachine.c<? extends GiftStateMachineConfig.e, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> h;
    public final StateMachine<GiftStateMachineConfig.e, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> i;
    public final DataCenter j;

    public static final class a {
    }

    public static final class b implements PropManager.a {
        public final /* synthetic */ FormatGiftListViewModel a;

        @Override // com.bytedance.android.livesdk.gift.platform.core.manager.PropManager.a
        public final void a() {
            FormatGiftListViewModel.f(this.a, new ArrayList());
        }

        public b(FormatGiftListViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.manager.PropManager.a
        public final void b(List r2) {
            FormatGiftListViewModel r0 = this.a;
            if (r2 != null) goto L5;
            r2 = new ArrayList();
        L5:
            FormatGiftListViewModel.f(r0, r2);
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            T r4 = ((AbsPanel) r2).h;
            if (r4 == null) goto L11;
            Integer r5 = Integer.valueOf(((h1) r4).getDiamondCount());
            T r6 = ((AbsPanel) r3).h;
            if (r6 == null) goto L9;
            return ComparisonsKt.compareValues(r5, Integer.valueOf(((h1) r6).getDiamondCount()));
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            T r4 = ((AbsPanel) r3).h;
            if (r4 == null) goto L11;
            Integer r5 = Integer.valueOf(((h1) r4).getDiamondCount());
            T r6 = ((AbsPanel) r2).h;
            if (r6 == null) goto L9;
            return ComparisonsKt.compareValues(r5, Integer.valueOf(((h1) r6).getDiamondCount()));
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final List<w1> h() {
        List<w1> r0 = ((GiftStateMachineConfig.e) this.i.b()).a();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void a() {
        super.a();
        PropManager r0 = PropManager.b();
        b r1 = this.g;
        if (r1 != null) goto L5;
        r0.getClass();
        return;
    L5:
        if (((ArrayList) r0.b).contains(r1) == false) goto L9;
        ((ArrayList) r0.b).remove(r1);
        return;
    }

    public final void i() {
        w1 r0 = (w1) CollectionsKt.getOrNull(h(), 0);
        if (r0 == null) goto L10;
        List<h1> r1 = r0.getGifts();
        if (r1 == null) goto L11;
        h1 r2 = (h1) CollectionsKt.getOrNull(r1, 0);
        if (r2 == null) goto L12;
        k(r2.getId(), AbsPanel.GiftPanelSelectType.DEFAULT_SELECTED, 0, false, false);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onStop() {
        a();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(final GiftStateMachineConfig.Event r14) {
        Intrinsics.checkNotNullParameter(r14, "event");
        Object r1 = null;
        if ((r14 instanceof GiftStateMachineConfig.Event.v) == false) goto L14;
        if (((GiftStateMachineConfig.Event.v) r14).f == false) goto L7;
        StateMachine<GiftStateMachineConfig.e, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r0 = this.i;
        StateMachine.a r2 = StateMachine.c;
        r0.d(r14, null);
        GiftStateMachineConfig.Event.v r15 = (GiftStateMachineConfig.Event.v) r14;
        this.f.a = r15.d;
        q(r15.e);
        return;
    L7:
        Function1<GiftStateMachineConfig.c, Unit> r3 = new FormatGiftListViewModel$onAction$1(this, r14);
        i12.e r16 = i12.o.a();
        if (r16 == null) goto L10;
        r1 = m.e.d(r16, FormatGiftListService.class);
    L10:
        FormatGiftListService r4 = (FormatGiftListService) r1;
        if (r4 == null) goto L88;
        r4.a(new com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.d(this, r3));
        return;
    L88:
        return;
    L14:
        if ((r14 instanceof GiftStateMachineConfig.Event.j) == false) goto L84;
        LocateGiftInfo r17 = ((GiftStateMachineConfig.Event.j) r14).b;
        AbsPanel<?> r5 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.b();
        if (r5 != null) goto L18;
    L39:
        AbsPanel.GiftPanelSelectType r7 = AbsPanel.GiftPanelSelectType.LOCATED;
        if (n(r17.getTargetGiftId(), r7) == false) goto L42;
    L45:
        boolean r6 = true;
    L47:
        if (r6 == true) goto L76;
        int r8 = r17.getActionWhenNotExist();
        if (r8 == 1) goto L73;
        if (r8 == 2) goto L55;
        if (r8 != 3) goto L76;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.d(1, false, 30));
        goto L76
    L55:
        GiftContext r9 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r9 == null) goto L71;
        com.bytedance.live.datacontext.m<GiftContext.a> r10 = r9.getLastSendGiftId();
        if (r10 == null) goto L71;
        GiftContext.a r11 = (GiftContext.a) r10.getValue();
        if (r11 == null) goto L71;
        long r13 = r11.a;
        r17.isSecondLocate();
        AbsPanel.GiftPanelSelectType r18 = AbsPanel.GiftPanelSelectType.DEFAULT_SELECTED;
        if (n(r13, r18) == true) goto L76;
        long r19 = r11.a;
        r17.isSecondLocate();
        if (k(r19, r18, r17.getBuffLevel(), r17.getStayWithCurrentPosition(), r17.isSecondLocate()) == true) goto L76;
        if (r17.isSecondLocate() == true) goto L71;
        if (r11.a != 0) goto L76;
    L71:
        i();
        goto L76
    L73:
        if (r17.isSecondLocate() == false) goto L76;
        int r20 = ToastUtil.a;
        ToastUtil.b(r17.getTipsWhenNotExist(), 0);
    L76:
        GiftContext r110 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r110 == null) goto L93;
        com.bytedance.live.datacontext.m<Long> r111 = r110.getDefaultGiftLocatedAt();
        if (r111 != null) goto L81;
        return;
    L81:
        if (((Number) r111.getValue()).longValue() != 0) goto L95;
        r111.setValue(Long.valueOf(System.currentTimeMillis()));
        return;
    L95:
        return;
    L93:
        return;
    L42:
        if (k(r17.getTargetGiftId(), r7, r17.getBuffLevel(), r17.getStayWithCurrentPosition(), r17.isSecondLocate()) == true) goto L45;
        r6 = false;
        goto L47
    L18:
        if (r5.c() != r17.getTargetGiftId()) goto L39;
        AbsPanel<?> r21 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.b();
        if (r21 == null) goto L22;
        Object r23 = r21.h;
    L24:
        if ((r23 instanceof h1) == false) goto L90;
        AbsPanel<?> r24 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.b();
        if (r24 == null) goto L28;
        r1 = r24.h;
    L28:
        if (r1 == null) goto L38;
        if (((h1) r1).getType() == 3) goto L91;
        GiftContext r25 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r25 == null) goto L36;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.c> r26 = r25.getBubbleBuffLevel();
        if (r26 == null) goto L36;
        r26.setValue(new com.bytedance.android.livesdk.gift.platform.core.c(r17.getTargetGiftId(), r17.getBuffLevel()));
    L36:
        AbsPanel<?> r27 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.b();
        Intrinsics.checkNotNull(r27);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.p(r27, AbsPanel.GiftPanelSelectType.LOCATED, true, true));
        return;
    L91:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L90:
        return;
    L22:
        r23 = null;
        goto L24
    L84:
        if ((r14 instanceof GiftStateMachineConfig.Event.i) == false) goto L97;
        i();
        return;
    }

    public final List<AbsPanel<?>> g(int r4) {
        List<w1> r0 = ((GiftStateMachineConfig.e) this.i.b()).a();
        if (r4 == 5) goto L5;
        if (r0 == null) goto L19;
        Iterator<w1> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L19;
        w1 r2 = r1.next();
        if (r2.getPageType() != r4) goto L9;
        Map<Integer, List<AbsPanel<?>>> r3 = ((GiftStateMachineConfig.e) this.i.b()).b().get(r2);
        if (r3 == null) goto L17;
        List<AbsPanel<?>> r5 = r3.get(Integer.valueOf(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.k(r4)));
        if (r5 == null) goto L17;
        return r5;
    L17:
        return new ArrayList();
    L19:
        return new ArrayList();
    L5:
        return ((GiftStateMachineConfig.e) this.i.b()).c();
    }

    public final void q(int r23) {
        i12.e r0 = i12.o.a();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, FormatGiftListService.class);
    L6:
        FormatGiftListService r2 = (FormatGiftListService) r1;
        if (r2 == null) goto L50;
        FormatGiftListViewModel$mSyncGiftListCallback$1 r4 = this.f;
        Context r5 = s1.getContext();
        int r6 = i.a;
        if (NetworkUtils.isNetworkAvailable(r5) == false) goto L55;
        long r7 = SystemClock.uptimeMillis();
        if (((Boolean) r2.a.getValue()).booleanValue() == false) goto L14;
        Pair r8 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new com.bytedance.android.livesdk.gift.platform.format.service.b());
    L51:
        i12.e r9 = i12.o.a();     // Catch: Throwable -> L45
        if (r9 == null) goto L18;
        Object r10 = m.e.d(r9, com.bytedance.android.livesdk.gift.platform.format.service.m.class);     // Catch: Throwable -> L45
    L19:
        com.bytedance.android.livesdk.gift.platform.format.service.m r11 = (com.bytedance.android.livesdk.gift.platform.format.service.m) r10;     // Catch: Throwable -> L45
        if (r11 == null) goto L22;
        long r13 = r11.getToUserId();     // Catch: Throwable -> L45
    L23:
        tz0.b r14 = tz0.b.a;     // Catch: Throwable -> L45
        uz0.c r15 = new uz0.c();     // Catch: Throwable -> L45
        r14.getClass();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r15, "$this$beforeConfigureRequest");     // Catch: Throwable -> L45
        Map r16 = ((uz0.a) r15).b;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r16, "queriesMap");     // Catch: Throwable -> L45
        Long r17 = 0L;     // Catch: Throwable -> L45
        String r3 = r17.toString();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");     // Catch: Throwable -> L45
        if (r3 == null) goto L26;
        r16.put("room_id", r3);     // Catch: Throwable -> L45
    L26:
        Long r18 = 0L;     // Catch: Throwable -> L45
        String r19 = r18.toString();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");     // Catch: Throwable -> L45
        if (r19 == null) goto L29;
        r16.put("to_room_id", r19);     // Catch: Throwable -> L45
    L29:
        Integer r20 = 4096;     // Catch: Throwable -> L45
        String r21 = r20.toString();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter("gift_scene", "$this$setTo");     // Catch: Throwable -> L45
        if (r21 == null) goto L32;
        r16.put("gift_scene", r21);     // Catch: Throwable -> L45
    L32:
        String r24 = Long.valueOf(r13).toString();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter("to_user_id", "$this$setTo");     // Catch: Throwable -> L45
        if (r24 == null) goto L35;
        r16.put("to_user_id", r24);     // Catch: Throwable -> L45
    L35:
        String r25 = Long.valueOf(r13).toString();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");     // Catch: Throwable -> L45
        if (r25 == null) goto L38;
        r16.put("anchor_id", r25);     // Catch: Throwable -> L45
    L38:
        String r26 = Integer.valueOf(r23).toString();     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter("fetch_giftlist_from", "$this$setTo");     // Catch: Throwable -> L45
        if (r26 == null) goto L41;
        r16.put("fetch_giftlist_from", r26);     // Catch: Throwable -> L45
    L41:
        if (r8 == null) goto L43;
        Map r27 = ((uz0.a) r15).a;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r27, "headersMap");     // Catch: Throwable -> L45
        String r28 = (String) r8.first;     // Catch: Throwable -> L45
        String r29 = (String) r8.second;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r28, "$this$setTo");     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r29, "value");     // Catch: Throwable -> L45
        r27.put(r28, r29);     // Catch: Throwable -> L45
    L43:
        Intrinsics.checkNotNullParameter(r15, "$this$afterConfigureRequest");     // Catch: Throwable -> L45
        Observable r30 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/list/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.platform.core.model.i.class)), Extra.class, ((uz0.a) r15).d, ((uz0.a) r15).a, ((uz0.a) r15).b, ((uz0.a) r15).c);     // Catch: Throwable -> L45
    L47:
        if (r30 == null) goto L53;
        GiftManagerKt.z.getClass();
        r2.c.add(r30.compose(GiftManagerKt.E(false)).subscribe(new com.bytedance.android.livesdk.gift.platform.format.service.g(r2, r4, r7), com.bytedance.android.livesdk.gift.platform.format.service.h.a));
        return;
    L53:
        return;
    L22:
        r13 = 0;
        goto L23
    L18:
        r10 = null;
    L45:
        th = move-exception;
        th.printStackTrace();
        r30 = null;
        goto L47
    L14:
        r8 = null;
        goto L51
    L55:
        return;
    L50:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public FormatGiftListViewModel(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super((LifecycleOwner) r3);
        this.j = r2;
        this.e = new HashMap();
        this.f = new FormatGiftListViewModel$mSyncGiftListCallback$1(this);
        this.g = new b(this);
        Function1<StateMachine.c<? extends GiftStateMachineConfig.e, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> r4 = new FormatGiftListViewModel$listener$1(this);
        this.h = r4;
        int r5 = GiftStateMachineConfig.a;
        this.i = GiftStateMachineConfig.b(r4);
    }

    public static final void f(FormatGiftListViewModel r7, List r8) {
        r7.getClass();
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        l2 r1 = (l2) r9.next();
        if (r1.getCount() > 0) goto L10;
        if (r1.getPropType() != 4) goto L4;
    L10:
        if (r1.isDisplayedOnPanel() == false) goto L4;
        r0.add(new pz1.e(r1));
        goto L4
    L13:
        StateMachine<GiftStateMachineConfig.e, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r10 = r7.i;
        GiftStateMachineConfig.Event.z r11 = new GiftStateMachineConfig.Event.z(r0);
        StateMachine.a r2 = StateMachine.c;
        r10.d(r11, null);
    }

    public final boolean n(long r11, AbsPanel.GiftPanelSelectType r13) {
        if (com.bytedance.android.livesdk.gift.platform.business.b.b() != 1) goto L5;
    L6:
        Iterator<pz1.e> r0 = ((GiftStateMachineConfig.e) this.i.b()).c().iterator();
    L8:
        if (r0.hasNext() == false) goto L25;
        pz1.e r3 = r0.next();
        T r4 = r3.h;
        if ((r4 instanceof l2) == false) goto L8;
        l2 r5 = (l2) r4;
        if (r5 == null) goto L24;
        if (r5.getGift() == null) goto L8;
        if (r5.getGift().getId() <= 0) goto L8;
        if (r5.getGift().getId() != r11) goto L8;
        if (r5.getCount() <= 0) goto L8;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.d(5, true, 28));
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.p(r3, r13, false, false));
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L25:
        return false;
    L5:
        if (com.bytedance.android.livesdk.gift.platform.business.b.b() != 3) goto L25;
        goto L6
    }

    public final void j(List<? extends w1> r25, boolean r26, Function1<? super GiftStateMachineConfig.c, Unit> r27) {
        if ((63 & 1) == 0) goto L5;
        ArrayList r1 = new ArrayList();
    L7:
        if ((63 & 2) == 0) goto L9;
        HashMap r4 = new HashMap();
    L11:
        if ((63 & 8) == 0) goto L13;
        ArrayList r6 = new ArrayList();
    L15:
        if ((63 & 16) == 0) goto L17;
        HashMap r7 = new HashMap();
    L18:
        Intrinsics.checkNotNullParameter(r1, "giftPages");
        Intrinsics.checkNotNullParameter(r4, "mGiftPanelMap");
        Intrinsics.checkNotNullParameter(r6, "mGiftAllList");
        Intrinsics.checkNotNullParameter(r7, "tabToPageMap");
        DataCenter r13 = this.j;
        if (r13 == null) goto L23;
        Boolean r3 = (Boolean) r13.get("data_is_anchor", Boolean.FALSE);
        if (r3 == null) goto L23;
        boolean r5 = r3.booleanValue();
    L24:
        com.bytedance.android.livesdk.gift.platform.business.g r14 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r14 == null) goto L27;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r15 = r14.h();
    L28:
        Iterator<? extends w1> r16 = r25.iterator();
        int r17 = -1;
    L30:
        if (r16.hasNext() == false) goto L96;
        w1 r8 = r16.next();
        if (Lists.isEmpty(r8.getGifts()) == true) goto L42;
        List<? extends h1> r2 = CollectionsKt.toMutableList(r8.getGifts());
        List<? extends h1> r18 = r2;
        GiftManagerKt.z.getClass();
        GiftManagerKt.i(r18, r5);
        r8.getPageType();
        GiftManagerKt.h(r18);
        GiftManagerKt.g(r18);
        GiftManagerKt.e(r18);
        GiftManagerKt.f(r18);
        r8.setGifts(r2);
        if (r15 == null) goto L41;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.h> r9 = r15.values().iterator();
    L38:
        if (r9.hasNext() == false) goto L41;
        r9.next().g(r8);
    L41:
        if (r8.getPageType() == 5) goto L42;
        ArrayList r10 = new ArrayList();
        Iterator<h1> r19 = r8.getGifts().iterator();
        int r110 = r17;
    L44:
        ArrayList r111 = r1;
        if (r19.hasNext() == false) goto L72;
        h1 r11 = r19.next();
        if (r26 == true) goto L55;
        GiftContext r112 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r112 == null) goto L55;
        com.bytedance.live.datacontext.i<Map<Long, l>> r113 = r112.getGiftIdMapToInfo();
        if (r113 == null) goto L55;
        boolean r114 = r5;
        Map r20 = (Map) r113.getValue();
        if (r20 == null) goto L57;
        l r21 = (l) r20.put(Long.valueOf(r11.getId()), new l(r11.getGiftTip()));
    L57:
        AbsPanel<?> r23 = ((com.bytedance.android.livesdk.gift.platform.business.config.m) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.m.class)).l(r11);
        com.bytedance.android.livesdk.gift.platform.business.g r115 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r115 == null) goto L68;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r116 = r115.h();
        if (r116 == null) goto L68;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.h> r117 = r116.values().iterator();
    L64:
        if (r117.hasNext() == false) goto L68;
        AbsPanel<?> r118 = r117.next().f(r11);
        if (r118 == null) goto L64;
        r23 = r118;
    L68:
        r8.getPageType();
        r23.getClass();
        if (r11.getType() != 3) goto L71;
        r110 = r10.size();
    L71:
        r10.add(r23);
        r15 = r15;
        r1 = r111;
        r5 = r114;
        r16 = r16;
        r19 = r19;
    L55:
        r114 = r5;
        goto L57
    L72:
        boolean r119 = r5;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r120 = r15;
        Iterator<? extends w1> r24 = r16;
        r4.put(r8, MapsKt.hashMapOf(new kotlin.Pair[]{TuplesKt.to(0, r10), TuplesKt.to(1, o(r10, r110, true)), TuplesKt.to(2, o(r10, r110, false))}));
        if (r8.getDisplay() == false) goto L75;
        r6.add(r10);
        r7.put(Integer.valueOf(r8.getPageType()), Integer.valueOf(r6.size() - 1));
    L75:
        Map<w1, Map<Integer, List<AbsPanel<?>>>> r28 = ((GiftStateMachineConfig.e) this.i.b()).b();
        Set<w1> r29 = r28.keySet();
        ((HashMap) this.e).clear();
        Iterator<w1> r30 = r29.iterator();
    L77:
        if (r30.hasNext() == false) goto L94;
        w1 r31 = r30.next();
        Map<Integer, List<AbsPanel<?>>> r33 = r28.get(r31);
        if (r33 == null) goto L94;
        List<AbsPanel<?>> r34 = r33.get(Integer.valueOf(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.k(r31.getPageType())));
        if (r34 == null) goto L94;
        if (Lists.isEmpty(r34) == true) goto L77;
        LongSparseArray r121 = new LongSparseArray();
        int r122 = r34.size();
        int r123 = 0;
    L87:
        if (r123 >= r122) goto L93;
        Map<w1, Map<Integer, List<AbsPanel<?>>>> r210 = r28;
        AbsPanel r35 = (AbsPanel) ListProtector.get(r34, r123);
        Iterator<w1> r124 = r30;
        if ((r35.h instanceof h1) == false) goto L92;
        r121.append(r35.c(), Integer.valueOf(r123 + 1));
    L92:
        r123 = r123 + 1;
        r30 = r124;
        r28 = r210;
        r4 = r4;
        goto L87
    L93:
        ((HashMap) this.e).put(r31, r121);
        r28 = r28;
    L94:
        HashMap r211 = r4;
    L95:
        r15 = r120;
        r1 = r111;
        r5 = r119;
        r16 = r24;
        r4 = r211;
        r17 = r110;
    L42:
        r111 = r1;
        r119 = r5;
        r211 = r4;
        r24 = r16;
        r110 = r17;
        r120 = r15;
        goto L95
    L96:
        ArrayList r125 = r1;
        HashMap r212 = r4;
        r7.put(5, Integer.valueOf(r6.size()));
        List<pz1.e> r36 = ((GiftStateMachineConfig.e) this.i.b()).c();
        if ((58 & 1) == 0) goto L99;
        List<? extends w1> r37 = r125;
    L101:
        if ((2 & 58) == 0) goto L103;
        HashMap r38 = r212;
    L105:
        if ((58 & 4) == 0) goto L108;
        r36 = null;
    L108:
        if ((58 & 8) == 0) goto L110;
        ArrayList r126 = r6;
    L112:
        if ((58 & 16) == 0) goto L114;
        HashMap r127 = r7;
    L115:
        Intrinsics.checkNotNullParameter(r37, "giftPages");
        Intrinsics.checkNotNullParameter(r38, "mGiftPanelMap");
        Intrinsics.checkNotNullParameter(r126, "mGiftAllList");
        Intrinsics.checkNotNullParameter(r127, "tabToPageMap");
        GiftStateMachineConfig.c r39 = new GiftStateMachineConfig.c(r37, r38, r36, r126, r127, false);
        if (com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c() != 0) goto L122;
        w1 r40 = (w1) CollectionsKt.getOrNull(r25, 0);
        if (r40 == null) goto L120;
        int r128 = r40.getPageType();
    L121:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.d(r128, true, 20));
        goto L122
    L120:
        r128 = 0;
    L122:
        r27.invoke(r39);
        return;
    L114:
        r127 = null;
        goto L115
    L110:
        r126 = null;
        goto L112
    L103:
        r38 = null;
        goto L105
    L99:
        r37 = r25;
        goto L101
    L27:
        r15 = null;
    L23:
        r5 = false;
        goto L24
    L17:
        r7 = null;
        goto L18
    L13:
        r6 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public final List<AbsPanel<?>> o(List<AbsPanel<?>> r8, int r9, boolean r10) {
        AbsPanel r0 = (AbsPanel) CollectionsKt.getOrNull(r8, r9);
        if (r10 == false) goto L18;
        List r11 = CollectionsKt.sortedWith(r8, new c());
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L6:
        if (r14.hasNext() == false) goto L17;
        Object r5 = r14.next();
        T r6 = ((AbsPanel) r5).h;
        if (r6 == 0) goto L16;
        if (((h1) r6).getType() == 3) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L6;
        r13.add(r5);
        goto L6
    L12:
        r7 = false;
        goto L13
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L17:
        List<AbsPanel<?>> r15 = CollectionsKt.toMutableList(r13);
    L32:
        if (r0 == null) goto L34;
        ListProtector.add(r15, r9, r0);
    L34:
        return r15;
    L18:
        List r16 = CollectionsKt.sortedWith(r8, new d());
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L20:
        if (r18.hasNext() == false) goto L31;
        Object r19 = r18.next();
        T r20 = ((AbsPanel) r19).h;
        if (r20 == 0) goto L30;
        if (((h1) r20).getType() == 3) goto L26;
        boolean r21 = true;
    L27:
        if (r21 == false) goto L20;
        r17.add(r19);
        goto L20
    L26:
        r21 = false;
        goto L27
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L31:
        r15 = CollectionsKt.toMutableList(r17);
        goto L32
    }

    public final boolean k(long r15, AbsPanel.GiftPanelSelectType r17, int r18, boolean r19, boolean r20) {
        Map<w1, Map<Integer, List<AbsPanel<?>>>> r3 = ((GiftStateMachineConfig.e) this.i.b()).b();
        List<w1> r4 = ((GiftStateMachineConfig.e) this.i.b()).a();
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<w1> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L42;
        w1 r6 = r5.next();
        if (r6.getDisplay() == false) goto L7;
        Map<Integer, List<AbsPanel<?>>> r7 = r3.get(r6);
        if (r7 == null) goto L14;
        List<AbsPanel<?>> r8 = r7.get(0);
    L15:
        if (r8 == null) goto L7;
        Iterator<AbsPanel<?>> r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L7;
        AbsPanel<?> r10 = r9.next();
        T r11 = r10.h;
        if ((r11 instanceof h1) == false) goto L18;
        if (r11 == 0) goto L40;
        if (((h1) r11).getId() != r15) goto L18;
        T r13 = r10.h;
        if (r13 == 0) goto L38;
        if (((h1) r13).getType() == 3) goto L36;
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r14 == null) goto L34;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.c> r16 = r14.getBubbleBuffLevel();
        if (r16 == null) goto L34;
        r16.setValue(new com.bytedance.android.livesdk.gift.platform.core.c(r15, r18));
    L34:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.d(r6.getPageType(), false, 22));
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.p(r10, r17, r19, r20));
        return true;
    L36:
        return false;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L14:
        r8 = null;
        goto L15
    L42:
        return false;
    }
}
