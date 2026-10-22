package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import android.os.SystemClock;
import android.util.LongSparseArray;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.f3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.GiftPluginType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.business.g;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.manager.PropManager;
import com.bytedance.android.livesdk.gift.platform.core.manager.u;
import com.bytedance.android.livesdk.gift.platform.core.manager.v;
import com.bytedance.android.livesdk.gift.platform.core.manager.w;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.i;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.message.model.r7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import yz0.h;
import yz0.k;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListViewModelNew extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a {
    public final Map<w1, LongSparseArray<Integer>> e;
    public final GiftListViewModelNew$mSyncGiftListCallback$1 f;
    public final b g;
    public IBaseUser h;
    public final Function1<StateMachine.c<? extends GiftStateMachineConfig.e, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> i;
    public final StateMachine<GiftStateMachineConfig.e, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> j;
    public final DataCenter k;
    public final GiftViewModelManager l;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftListViewModelNew$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", BuildConfig.FLAVOR, "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(GiftListViewModelNew r8) {
            super(1, r8, GiftListViewModelNew.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r4) {
            ((GiftListViewModelNew) ((CallableReference) this).receiver).getClass();
            if ((r4 instanceof r7) == true) goto L5;
            return;
        L5:
            if (((r7) r4).getUpdateType() != 1) goto L9;
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.v(false, true, 5, false));
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b implements PropManager.a {
        public final /* synthetic */ GiftListViewModelNew a;

        @Override // com.bytedance.android.livesdk.gift.platform.core.manager.PropManager.a
        public final void a() {
            this.a.h(new ArrayList());
        }

        public b(GiftListViewModelNew r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.manager.PropManager.a
        public final void b(List r2) {
            GiftListViewModelNew r0 = this.a;
            if (r2 != null) goto L5;
            r2 = new ArrayList();
        L5:
            r0.h(r2);
        }
    }

    public final class c implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
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

    public static final class e<T> implements Comparator<T> {
        public e() {
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

    public final List<w1> g() {
        List<w1> r0 = ((GiftStateMachineConfig.e) this.j.b()).a();
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

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(final GiftStateMachineConfig.Event r23) {
        Intrinsics.checkNotNullParameter(r23, "event");
        Object r8 = null;
        boolean r9 = false;
        if ((r23 instanceof GiftStateMachineConfig.Event.v) == true) goto L5;
        int r11 = 2;
        if ((r23 instanceof GiftStateMachineConfig.Event.y) == false) goto L108;
        k r0 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        if (r0 == null) goto L189;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L198;
        long r2 = r1.getId();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()) == false) goto L66;
        r2 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r());
    L66:
        String r3 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r().getIdString();
        final PropManager r4 = PropManager.b();
        long r5 = r1.getId();
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.m() == null) goto L90;
        int r6 = GiftReceiverViewModel.h;
        ReceiverType r7 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.d();
        Intrinsics.checkNotNullParameter(r7, "receiverType");
        if (x.d() == false) goto L72;
        r11 = 16;
    L92:
        if (r4.c == true) goto L199;
        r4.c = true;
        final long r10 = SystemClock.uptimeMillis();
        int r13 = a12.a.a;
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        tz0.b r14 = tz0.b.a;
        uz0.c r15 = new uz0.c();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "$this$beforeConfigureRequest");
        Map r16 = ((uz0.a) r15).b;
        Intrinsics.checkNotNullParameter(r16, "queriesMap");
        String r17 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r17 == null) goto L97;
        r16.put("room_id", r17);
    L97:
        String r18 = Integer.valueOf(r11).toString();
        Intrinsics.checkNotNullParameter("prop_scene", "$this$setTo");
        if (r18 == null) goto L100;
        r16.put("prop_scene", r18);
    L100:
        String r19 = Long.valueOf(r2).toString();
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r19 == null) goto L103;
        r16.put("to_room_id", r19);
    L103:
        Intrinsics.checkNotNullParameter("to_openid", "$this$setTo");
        if (r3 == null) goto L106;
        r16.put("to_openid", r3);
    L106:
        Intrinsics.checkNotNullParameter(r15, "$this$afterConfigureRequest");
        com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/props/mine/", TypesJVMKt.getJavaType(Reflection.typeOf(f3.class)), Extra.class, ((uz0.a) r15).d, ((uz0.a) r15).a, ((uz0.a) r15).b, ((uz0.a) r15).c).compose(RxUtil.rxSchedulerHelper()).subscribe(new u(r4, r10), new v(r4), new w(r4));
        return;
    L199:
        return;
    L72:
        if (x.c() == false) goto L75;
        r11 = 32;
        goto L92
    L75:
        if (x.b() == false) goto L78;
        r11 = 64;
        goto L92
    L78:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.a(8) == false) goto L81;
        r11 = 8;
        goto L92
    L81:
        switch(f.a[r7.ordinal()]) {
            case 1: goto L89;
            case 2: goto L92;
            case 3: goto L92;
            case 4: goto L87;
            case 5: goto L85;
            case 6: goto L84;
            case 7: goto L90;
            default: goto L83;
        };
    L84:
        r11 = 4;
        goto L92
    L85:
        r11 = 1024;
        goto L92
    L89:
        r11 = 128;
        goto L92
    L83:
        throw new NoWhenBranchMatchedException();
    L87:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.a(2) == true) goto L92;
    L90:
        r11 = 1;
        goto L92
    L198:
        return;
    L189:
        return;
    L108:
        if ((r23 instanceof GiftStateMachineConfig.Event.j) == false) goto L191;
        LocateGiftInfo r110 = ((GiftStateMachineConfig.Event.j) r23).b;
        AbsPanel<?> r20 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        if (r20 != null) goto L112;
    L133:
        AbsPanel.GiftPanelSelectType r21 = AbsPanel.GiftPanelSelectType.LOCATED;
        if (k(r110.getTargetGiftId(), r21) == false) goto L136;
    L139:
        boolean r24 = true;
    L141:
        if (r24 == true) goto L177;
        int r25 = r110.getActionWhenNotExist();
        if (r25 == 1) goto L174;
        if (r25 == 2) goto L149;
        if (r25 != 3) goto L177;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.d(1, false, 30));
        goto L177
    L149:
        if (((Boolean) y12.b.c.getValue(null, y12.b.a[1])).booleanValue() == false) goto L166;
        GiftContext r26 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r26 == null) goto L166;
        m<GiftContext.a> r27 = r26.getLastSendGiftId();
        if (r27 == null) goto L166;
        GiftContext.a r28 = (GiftContext.a) r27.getValue();
        if (r28 == null) goto L166;
        long r29 = r28.a;
        r110.isSecondLocate();
        AbsPanel.GiftPanelSelectType r30 = AbsPanel.GiftPanelSelectType.DEFAULT_SELECTED;
        if (k(r29, r30) == true) goto L177;
        long r31 = r28.a;
        r110.isSecondLocate();
        if (j(r31, r30, r110.getBuffLevel(), r110.getStayWithCurrentPosition(), r110.isSecondLocate()) == true) goto L177;
        if (r110.isSecondLocate() == true) goto L166;
        if (r28.a != 0) goto L177;
    L166:
        w1 r33 = (w1) CollectionsKt.getOrNull(g(), 0);
        if (r33 == null) goto L177;
        List<h1> r34 = r33.getGifts();
        if (r34 == null) goto L177;
        h1 r35 = (h1) CollectionsKt.getOrNull(r34, 0);
        if (r35 == null) goto L177;
        j(r35.getId(), AbsPanel.GiftPanelSelectType.DEFAULT_SELECTED, r110.getBuffLevel(), r110.getStayWithCurrentPosition(), r110.isSecondLocate());
        goto L177
    L174:
        if (r110.isSecondLocate() == false) goto L177;
        int r36 = ToastUtil.a;
        ToastUtil.b(r110.getTipsWhenNotExist(), 0);
    L177:
        GiftContext r37 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r37 == null) goto L195;
        m<Long> r38 = r37.getDefaultGiftLocatedAt();
        if (r38 != null) goto L182;
        return;
    L182:
        if (((Number) r38.getValue()).longValue() != 0) goto L197;
        r38.setValue(Long.valueOf(System.currentTimeMillis()));
        return;
    L197:
        return;
    L195:
        return;
    L136:
        if (j(r110.getTargetGiftId(), r21, r110.getBuffLevel(), r110.getStayWithCurrentPosition(), r110.isSecondLocate()) == true) goto L139;
        r24 = false;
        goto L141
    L112:
        if (r20.c() != r110.getTargetGiftId()) goto L133;
        AbsPanel<?> r39 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        if (r39 == null) goto L116;
        Object r40 = r39.h;
    L118:
        if ((r40 instanceof h1) == false) goto L192;
        AbsPanel<?> r41 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        if (r41 == null) goto L122;
        r8 = r41.h;
    L122:
        if (r8 == null) goto L132;
        if (((h1) r8).getType() == 3) goto L193;
        GiftContext r43 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r43 == null) goto L130;
        m<com.bytedance.android.livesdk.gift.platform.core.c> r44 = r43.getBubbleBuffLevel();
        if (r44 == null) goto L130;
        r44.setValue(new com.bytedance.android.livesdk.gift.platform.core.c(r110.getTargetGiftId(), r110.getBuffLevel()));
    L130:
        AbsPanel<?> r45 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        Intrinsics.checkNotNull(r45);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.p(r45, AbsPanel.GiftPanelSelectType.LOCATED, true, true));
        return;
    L193:
        return;
    L132:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L192:
        return;
    L116:
        r40 = null;
        goto L118
    L191:
        return;
    L5:
        if (((GiftStateMachineConfig.Event.v) r23).f == false) goto L7;
        StateMachine<GiftStateMachineConfig.e, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r46 = this.j;
        StateMachine.a r47 = StateMachine.c;
        r46.d(r23, null);
        GiftStateMachineConfig.Event.v r48 = (GiftStateMachineConfig.Event.v) r23;
        this.f.a = r48.d;
        o(r48.e);
        return;
    L7:
        Function1<GiftStateMachineConfig.c, Unit> r49 = new GiftListViewModelNew$onAction$1(this, r23);
        boolean r50 = com.bytedance.android.livesdk.gift.platform.core.utils.u.p();
        h(new ArrayList());
        GiftManagerKt.z.getClass();
        e1 r51 = (e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L18;
        if (r50 == true) goto L11;
        List<w1> r53 = r51.N3().c;
        if (r53 != null) goto L16;
    L33:
        if (r9 == false) goto L55;
        if (r50 == false) goto L37;
        List<? extends w1> r54 = GiftManagerKt.y();
    L53:
        i(r54, true, r49);
        return;
    L37:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L40;
        r54 = GiftManagerKt.m();
        goto L53
    L40:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.t() == false) goto L43;
        r54 = GiftManagerKt.n();
        goto L53
    L43:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()) == true) goto L45;
        r54 = GiftManagerKt.t();
        goto L53
    L45:
        IBaseUser r55 = this.h;
        if (r55 == null) goto L54;
        i r56 = (i) ((HashMap) GiftManagerKt.o).get(Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r55)));
        if (r56 != null) goto L50;
    L52:
        r54 = new ArrayList();
        goto L53
    L50:
        if (Lists.isEmpty(r56.giftPages) == true) goto L52;
        r54 = new ArrayList(r56.giftPages);
        goto L53
    L54:
        r49.invoke(new GiftStateMachineConfig.c(null, 63));
        return;
    L55:
        r49.invoke(new GiftStateMachineConfig.c(((GiftStateMachineConfig.e) this.j.b()).c(), 59));
        return;
    L16:
        if (r53.isEmpty() == true) goto L33;
    L31:
        r9 = true;
        goto L33
    L11:
        if (new ArrayList().isEmpty() == true) goto L33;
    L18:
        if (r50 == false) goto L23;
        if (GiftManagerKt.y().isEmpty() == true) goto L33;
    L23:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L28;
        if (GiftManagerKt.m().isEmpty() == true) goto L33;
    L28:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.t() == true) goto L30;
        r9 = GiftManagerKt.A();
        goto L33
    L30:
        if (GiftManagerKt.n().isEmpty() == true) goto L33;
        goto L31
    }

    public final List<AbsPanel<?>> f(int r4) {
        List<w1> r0 = ((GiftStateMachineConfig.e) this.j.b()).a();
        if (r4 == 5) goto L5;
        if (r0 == null) goto L19;
        Iterator<w1> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L19;
        w1 r2 = r1.next();
        if (r2.getPageType() != r4) goto L9;
        Map<Integer, List<AbsPanel<?>>> r3 = ((GiftStateMachineConfig.e) this.j.b()).b().get(r2);
        if (r3 == null) goto L17;
        List<AbsPanel<?>> r5 = r3.get(Integer.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.p(r4)));
        if (r5 == null) goto L17;
        return r5;
    L17:
        return new ArrayList();
    L19:
        return new ArrayList();
    L5:
        return ((GiftStateMachineConfig.e) this.j.b()).c();
    }

    public final void h(List r8) {
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
        StateMachine<GiftStateMachineConfig.e, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r10 = this.j;
        GiftStateMachineConfig.Event.z r2 = new GiftStateMachineConfig.Event.z(r0);
        StateMachine.a r3 = StateMachine.c;
        r10.d(r2, null);
    }

    public final void o(int r17) {
        DataCenter r1 = this.k;
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.get("data_is_anchor", Boolean.FALSE);
        if (r2 == null) goto L7;
        boolean r9 = r2.booleanValue();
    L8:
        IRoom r3 = x.a();
        if (r3 != null) goto L11;
        return;
    L11:
        n01.a r4 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), n01.a.class);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()) == false) goto L33;
        this.h = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();
        GiftManagerKt r5 = GiftManagerKt.z;
        GiftListViewModelNew$mSyncGiftListCallback$1 r8 = this.f;
        long r10 = r3.getId();
        IBaseUser r13 = this.h;
        if (r13 == null) goto L16;
        long r14 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r13);
    L18:
        if (r3.getOwner() == null) goto L23;
        IBaseUser r6 = r3.getOwner();
        if (r6 == null) goto L22;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r7 = r6.getCastSecUid();
    L24:
        IBaseUser r11 = this.h;
        if (r11 == null) goto L27;
        Intrinsics.checkNotNullParameter(r11, "$this$secUidExt");
        String r15 = r11.getCastSecUid();
    L28:
        if (r4 == null) goto L30;
        Episode r16 = r4.jf();
    L31:
        r5.getClass();
        GiftManagerKt.J(r8, r10, r14, 4, r17, r9, r7, r15, r16);
        return;
    L30:
        r16 = null;
        goto L31
    L27:
        r15 = null;
        goto L28
    L22:
        r7 = null;
        goto L24
    L23:
        r7 = BuildConfig.FLAVOR;
        goto L24
    L16:
        r14 = 0;
        goto L18
    L33:
        if (r3.getOwner() == null) goto L38;
        IBaseUser r18 = r3.getOwner();
        if (r18 == null) goto L37;
        Intrinsics.checkNotNullParameter(r18, "$this$secUidExt");
        String r19 = r18.getCastSecUid();
    L40:
        if (x.d() == false) goto L43;
        int r20 = 16;
    L55:
        GiftManagerKt r21 = GiftManagerKt.z;
        GiftListViewModelNew$mSyncGiftListCallback$1 r23 = this.f;
        long r110 = r3.getId();
        long r111 = r3.getId();
        if (r4 == null) goto L58;
        Episode r24 = r4.jf();
    L59:
        r21.getClass();
        GiftManagerKt.J(r23, r110, r111, r20, r17, r9, r19, r19, r24);
        return;
    L58:
        r24 = null;
        goto L59
    L43:
        if (x.c() == false) goto L46;
        r20 = 32;
        goto L55
    L46:
        if (x.b() == false) goto L49;
        r20 = 64;
        goto L55
    L49:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L52;
        r20 = 512;
        goto L55
    L52:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.t() == false) goto L54;
        r20 = 1024;
        goto L55
    L54:
        r20 = 1;
        goto L55
    L37:
        r19 = null;
        goto L40
    L38:
        r19 = BuildConfig.FLAVOR;
    L7:
        r9 = false;
        goto L8
    }

    public final boolean k(long r11, AbsPanel.GiftPanelSelectType r13) {
        if (com.bytedance.android.livesdk.gift.platform.business.b.b() != 1) goto L5;
    L6:
        Iterator<pz1.e> r0 = ((GiftStateMachineConfig.e) this.j.b()).c().iterator();
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

    public GiftListViewModelNew(DataCenter r2, GiftViewModelManager r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r3, "giftViewModelManager");
        Intrinsics.checkNotNullParameter(r4, "owner");
        super(r4);
        this.k = r2;
        this.l = r3;
        this.e = new HashMap();
        this.f = new GiftListViewModelNew$mSyncGiftListCallback$1(this);
        b r5 = new b(this);
        this.g = r5;
        PropManager r6 = PropManager.b();
        if (((ArrayList) r6.b).contains(r5) == true) goto L5;
        ((ArrayList) r6.b).add(r5);
    L5:
        l r7 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), l.class);
        if (r7 == null) goto L12;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r8 = h.a.a(r7, com.bytedance.android.live.revenue.common.message.b.B, false, 6);
        if (r8 == null) goto L12;
        Disposable r9 = r8.subscribe(new c(new AnonymousClass1(this)));
        if (r9 == null) goto L12;
        RxUtilKt.c(r9, this.c);
    L12:
        Function1<StateMachine.c<? extends GiftStateMachineConfig.e, ? extends GiftStateMachineConfig.Event, ? extends GiftStateMachineConfig.f>, Unit> r10 = new GiftListViewModelNew$listener$1(this);
        this.i = r10;
        int r11 = GiftStateMachineConfig.a;
        this.j = GiftStateMachineConfig.b(r10);
    }

    public final void i(List<? extends w1> r26, boolean r27, Function1<? super GiftStateMachineConfig.c, Unit> r28) {
        if ((63 & 1) == 0) goto L5;
        ArrayList r1 = new ArrayList();
    L7:
        if ((63 & 2) == 0) goto L9;
        HashMap r4 = new HashMap();
    L11:
        if ((63 & 8) == 0) goto L13;
        ArrayList r7 = new ArrayList();
    L15:
        if ((63 & 16) == 0) goto L17;
        HashMap r8 = new HashMap();
    L18:
        Intrinsics.checkNotNullParameter(r1, "giftPages");
        Intrinsics.checkNotNullParameter(r4, "mGiftPanelMap");
        Intrinsics.checkNotNullParameter(r7, "mGiftAllList");
        Intrinsics.checkNotNullParameter(r8, "tabToPageMap");
        DataCenter r13 = this.k;
        if (r13 == null) goto L23;
        Boolean r5 = (Boolean) r13.get("data_is_anchor", Boolean.FALSE);
        if (r5 == null) goto L23;
        boolean r6 = r5.booleanValue();
    L24:
        g r14 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r14 == null) goto L27;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r15 = r14.h();
    L28:
        Iterator<? extends w1> r16 = r26.iterator();
        int r17 = -1;
    L30:
        if (r16.hasNext() == false) goto L119;
        w1 r18 = r16.next();
        if (Lists.isEmpty(r18.getGifts()) == true) goto L65;
        List<? extends h1> r2 = CollectionsKt.toMutableList(r18.getGifts());
        if (this.l.getSendToAnchor(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()) == false) goto L37;
    L56:
        GiftManagerKt.z.getClass();
        GiftManagerKt.i(r2, r6);
        r18.getPageType();
    L57:
        List<? extends h1> r9 = r2;
        GiftManagerKt.z.getClass();
        GiftManagerKt.h(r9);
        GiftManagerKt.g(r9);
        GiftManagerKt.e(r9);
        GiftManagerKt.f(r9);
        r18.setGifts(r2);
        if (r15 == null) goto L64;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.h> r3 = r15.values().iterator();
    L61:
        if (r3.hasNext() == false) goto L64;
        r3.next().g(r18);
    L64:
        if (r18.getPageType() == 5) goto L65;
        ArrayList r10 = new ArrayList();
        Iterator<h1> r11 = r18.getGifts().iterator();
        int r19 = r17;
    L67:
        ArrayList r110 = r1;
        if (r11.hasNext() == false) goto L95;
        h1 r20 = r11.next();
        if (r27 == true) goto L78;
        GiftContext r111 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r111 == null) goto L78;
        com.bytedance.live.datacontext.i<Map<Long, com.bytedance.android.livesdk.gift.platform.core.l>> r112 = r111.getGiftIdMapToInfo();
        if (r112 == null) goto L78;
        Iterator<h1> r21 = r11;
        Map r23 = (Map) r112.getValue();
        if (r23 == null) goto L80;
        com.bytedance.android.livesdk.gift.platform.core.l r24 = (com.bytedance.android.livesdk.gift.platform.core.l) r23.put(Long.valueOf(r20.getId()), new com.bytedance.android.livesdk.gift.platform.core.l(r20.getGiftTip()));
    L80:
        AbsPanel<?> r25 = ((com.bytedance.android.livesdk.gift.platform.business.config.m) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.m.class)).l(r20);
        g r113 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r113 == null) goto L91;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r29 = r113.h();
        if (r29 == null) goto L91;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.h> r30 = r29.values().iterator();
    L87:
        if (r30.hasNext() == false) goto L91;
        AbsPanel<?> r114 = r30.next().f(r20);
        if (r114 == null) goto L87;
        r25 = r114;
    L91:
        r18.getPageType();
        r25.getClass();
        if (r20.getType() != 3) goto L94;
        r19 = r10.size();
    L94:
        r10.add(r25);
        r6 = r6;
        r1 = r110;
        r11 = r21;
        r15 = r15;
        r16 = r16;
    L78:
        r21 = r11;
        goto L80
    L95:
        boolean r115 = r6;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r210 = r15;
        Iterator<? extends w1> r211 = r16;
        int r31 = 0;
        r4.put(r18, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(0, r10), TuplesKt.to(1, n(r10, r19, true)), TuplesKt.to(2, n(r10, r19, false))}));
        if (r18.getDisplay() == false) goto L98;
        r7.add(r10);
        r8.put(Integer.valueOf(r18.getPageType()), Integer.valueOf(r7.size() - 1));
    L98:
        Map<w1, Map<Integer, List<AbsPanel<?>>>> r33 = ((GiftStateMachineConfig.e) this.j.b()).b();
        Set<w1> r34 = r33.keySet();
        ((HashMap) this.e).clear();
        Iterator<w1> r35 = r34.iterator();
    L100:
        if (r35.hasNext() == false) goto L117;
        w1 r36 = r35.next();
        Map<Integer, List<AbsPanel<?>>> r116 = r33.get(r36);
        if (r116 == null) goto L117;
        List<AbsPanel<?>> r117 = r116.get(Integer.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.p(r36.getPageType())));
        if (r117 == null) goto L117;
        if (Lists.isEmpty(r117) == true) goto L100;
        LongSparseArray r118 = new LongSparseArray();
        int r119 = r117.size();
    L110:
        if (r31 >= r119) goto L116;
        Map<w1, Map<Integer, List<AbsPanel<?>>>> r212 = r33;
        AbsPanel r37 = (AbsPanel) ListProtector.get(r117, r31);
        Iterator<w1> r120 = r35;
        if ((r37.h instanceof h1) == false) goto L115;
        r118.append(r37.c(), Integer.valueOf(r31 + 1));
    L115:
        r31 = r31 + 1;
        r35 = r120;
        r33 = r212;
        r4 = r4;
        goto L110
    L116:
        ((HashMap) this.e).put(r36, r118);
        r33 = r33;
        r31 = 0;
    L117:
        HashMap r213 = r4;
    L118:
        r6 = r115;
        r1 = r110;
        r15 = r210;
        r16 = r211;
        r4 = r213;
        r17 = r19;
        goto L30
    L37:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.a(4) == true) goto L56;
        List<? extends h1> r38 = r2;
        GiftManagerKt.z.getClass();
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L43;
        com.bytedance.android.livesdk.gift.platform.core.utils.f.c(r38, r6, null);
    L55:
        r18.getPageType();
        goto L57
    L43:
        if (r38 == null) goto L55;
        GiftManagerKt.i(r38, r6);
        Iterator<? extends h1> r39 = r38.iterator();
    L47:
        if (r39.hasNext() == false) goto L55;
        h1 r121 = r39.next();
        if (r121 == null) goto L54;
        if (r121.isForLinkMic() == true) goto L47;
        r39.remove();
        goto L47
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L65:
        r110 = r1;
        r213 = r4;
        r210 = r15;
        r211 = r16;
        r19 = r17;
        r115 = r6;
        goto L118
    L119:
        ArrayList r122 = r1;
        HashMap r214 = r4;
        r8.put(5, Integer.valueOf(r7.size()));
        List<pz1.e> r40 = ((GiftStateMachineConfig.e) this.j.b()).c();
        if ((58 & 1) == 0) goto L122;
        List<? extends w1> r41 = r122;
    L124:
        if ((2 & 58) == 0) goto L126;
        HashMap r43 = r214;
    L128:
        if ((4 & 58) == 0) goto L131;
        r40 = null;
    L131:
        if ((58 & 8) == 0) goto L133;
        ArrayList r123 = r7;
    L135:
        if ((58 & 16) == 0) goto L137;
        HashMap r124 = r8;
    L138:
        Intrinsics.checkNotNullParameter(r41, "giftPages");
        Intrinsics.checkNotNullParameter(r43, "mGiftPanelMap");
        Intrinsics.checkNotNullParameter(r123, "mGiftAllList");
        Intrinsics.checkNotNullParameter(r124, "tabToPageMap");
        GiftStateMachineConfig.c r44 = new GiftStateMachineConfig.c(r41, r43, r40, r123, r124, false);
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f() != 0) goto L145;
        w1 r45 = (w1) CollectionsKt.getOrNull(r26, 0);
        if (r45 == null) goto L143;
        int r125 = r45.getPageType();
    L144:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.d(r125, true, 20));
        goto L145
    L143:
        r125 = 0;
    L145:
        r28.invoke(r44);
        return;
    L137:
        r124 = null;
        goto L138
    L133:
        r123 = null;
        goto L135
    L126:
        r43 = null;
        goto L128
    L122:
        r41 = r26;
        goto L124
    L27:
        r15 = null;
    L23:
        r6 = false;
        goto L24
    L17:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public final List<AbsPanel<?>> n(List<AbsPanel<?>> r8, int r9, boolean r10) {
        AbsPanel r0 = (AbsPanel) CollectionsKt.getOrNull(r8, r9);
        if (r10 == false) goto L18;
        List r11 = CollectionsKt.sortedWith(r8, new d());
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
        List r16 = CollectionsKt.sortedWith(r8, new e());
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

    public final boolean j(long r15, AbsPanel.GiftPanelSelectType r17, int r18, boolean r19, boolean r20) {
        Map<w1, Map<Integer, List<AbsPanel<?>>>> r3 = ((GiftStateMachineConfig.e) this.j.b()).b();
        List<w1> r4 = ((GiftStateMachineConfig.e) this.j.b()).a();
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
        m<com.bytedance.android.livesdk.gift.platform.core.c> r16 = r14.getBubbleBuffLevel();
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
