package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.control.LinkRevControlWidget;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.impl.utils.x;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.y6;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiOtherComponent extends com.bytedance.android.live.revenuelink.connect.c implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public final com.bytedance.android.livesdk.revenue.room.a c;
    public final IRoom d;
    public boolean e;
    public b f;
    public c g;
    public o51.e h;
    public final d i;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a j;
    public final ld.a k;
    public final yz0.f l;
    public final h m;
    public final MultiAnchorLinkContext n;
    public final g o;
    public final MultiPkScopeProviderService p;
    public final com.bytedance.android.livesdk.revenue.service.room.c q;
    public final MultiPKContextHolder r;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            LinkRevControlWidget.O.getClass();
            LinkRevControlWidget.a.a("multi_linker", true);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiOtherComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/vm/a;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/multianchor/vm/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.impl.multianchor.vm.a, Unit> {
        public AnonymousClass1(MultiOtherComponent r8) {
            super(1, r8, MultiOtherComponent.class, "onAnchorLeave", "onAnchorLeave(Lcom/bytedance/android/live/revlink/impl/multianchor/vm/AnchorLeaveEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.revlink.impl.multianchor.vm.a r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            MultiOtherComponent r0 = (MultiOtherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            IBaseUser r1 = r4.a.getUser();
            if (r1 != null) goto L5;
            return;
        L5:
            if (r0.r.c.getBasePKContext().getCurPKBaseState().b() == false) goto L12;
            g6 r5 = r4.b;
            if (r5 != null) goto L9;
        L11:
            r0.r.c.handleUserLeave(r1);
            return;
        L9:
            if (r5.getLeaveSource() != 1) goto L11;
            return;
        L12:
            r0.r.c.handleUserLeave(r1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.revlink.impl.multianchor.vm.a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiOtherComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "p1", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Unit, Unit> {
        public AnonymousClass2(MultiOtherComponent r8) {
            super(1, r8, MultiOtherComponent.class, "onLinkInitSuccess", "onLinkInitSuccess(Lkotlin/Unit;)V", 0);
        }

        public final void invoke(Unit r12) {
            MultiOtherComponent r0 = (MultiOtherComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r12 == null) goto L103;
            com.bytedance.revenue.platform.api.core.rx.l r13 = com.bytedance.revenue.platform.api.core.rx.l.a;
            int r14 = com.bytedance.revenue.platform.api.core.rx.p.a;
            com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(1500, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r0)), r0.b);
            String r15 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0);
            StringBuilder r1 = new StringBuilder("call try tryStart2v2Match, get matchContext Service: ");
            MultiPkMatchContext r2 = com.bytedance.android.live.revlink.link.biz.service.i.J(r0);
            LiveMode r3 = null;
            if (r2 == null) goto L10;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.match.a> r4 = r2.getService();
            if (r4 == null) goto L10;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r5 = (com.bytedance.android.live.revlink.impl.multianchor.match.a) r4.getValue();
        L11:
            r1.append(r5);
            r1.append(" and matchStatus: ");
            MultiPkMatchContext r6 = com.bytedance.android.live.revlink.link.biz.service.i.J(r0);
            if (r6 == null) goto L16;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r7 = r6.getMatchStatus();
            if (r7 == null) goto L16;
            com.bytedance.android.live.revlink.impl.multianchor.match.c r8 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r7.getValue();
        L17:
            r1.append(r8);
            r1.append(" and isInviterInMultiInvite: ");
            f21.a r9 = com.bytedance.android.live.revlink.link.biz.service.i.i(r0);
            if (r9 == null) goto L20;
            Boolean r10 = Boolean.valueOf(r9.i);
        L21:
            r1.append(r10);
            r1.append("and get selfAutoMatchInfoUser: ");
            MultiPkMatchContext r16 = com.bytedance.android.live.revlink.link.biz.service.i.J(r0);
            if (r16 == null) goto L28;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.match.a> r17 = r16.getService();
            if (r17 == null) goto L28;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r18 = (com.bytedance.android.live.revlink.impl.multianchor.match.a) r17.getValue();
            if (r18 == null) goto L28;
            b0 r19 = r18.Dl();
        L29:
            r1.append(r19);
            jy0.b.c(r15, r1.toString(), null, 4);
            MultiPkMatchContext r110 = com.bytedance.android.live.revlink.link.biz.service.i.J(r0);
            if (r110 == null) goto L96;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.match.a> r111 = r110.getService();
            if (r111 == null) goto L97;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r20 = (com.bytedance.android.live.revlink.impl.multianchor.match.a) r111.getValue();
            if (r20 == null) goto L98;
            MultiPkMatchContext r112 = com.bytedance.android.live.revlink.link.biz.service.i.J(r0);
            if (r112 == null) goto L40;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r113 = r112.getMatchStatus();
            if (r113 == null) goto L40;
            com.bytedance.android.live.revlink.impl.multianchor.match.c r114 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r113.getValue();
        L42:
            if ((r114 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.e) == false) goto L59;
            f21.a r115 = com.bytedance.android.live.revlink.link.biz.service.i.i(r0);
            if (r115 != null) goto L46;
            return;
        L46:
            if (r115.i != true) goto L104;
            b0 r22 = r20.Dl();
            if (r22 == null) goto L100;
            MultiPkMatchContext r116 = com.bytedance.android.live.revlink.link.biz.service.i.J(r0);
            if (r116 == null) goto L57;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r117 = r116.getMatchStatus();
            if (r117 == null) goto L57;
            com.bytedance.android.live.revlink.impl.multianchor.match.c r118 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r117.getValue();
            if (r118 == null) goto L57;
            int r23 = r118.e;
        L58:
            com.bytedance.android.live.revlink.impl.multianchor.match.a.C0145a.a(r20, r22, 11, false, r23, null, 52);
            return;
        L57:
            r23 = 0;
            goto L58
        L100:
            return;
        L104:
            return;
        L59:
            com.bytedance.android.live.revlink.impl.multianchor.match.a r119 = com.bytedance.android.live.revlink.link.biz.service.i.K(r0);
            if (r119 == null) goto L65;
            if (r119.po() != true) goto L65;
            return;
        L65:
            if (r0.e == true) goto L102;
            f21.a r120 = com.bytedance.android.live.revlink.link.biz.service.i.i(r0);
            if (r120 != null) goto L69;
        L70:
            IRoom r121 = r0.d;
            if (r121 == null) goto L74;
            r3 = IRoomKtKt.getStreamType(r121);
        L74:
            if (r3 == LiveMode.SCREEN_RECORD) goto L94;
            int r122 = x.a;
            Intrinsics.checkNotNullParameter("live_multi_start_panel_key", "key");
            String r123 = (String) new com.bytedance.android.livesdk.sharedpref.e("live_multi_start_panel_key", "").getValue();
            if (r123.length() != 0) goto L79;
            boolean r24 = true;
        L80:
            if (r24 == true) goto L84;
            int r25 = CastIntegerProtector.parseInt(r123);
            d51.c r26 = d51.c.A0;
            r26.getClass();
            if (r25 > ((Number) d51.c.a0.getValue(r26, d51.c.a[51])).intValue()) goto L94;
        L84:
            if (r123.length() != 0) goto L86;
            boolean r27 = true;
        L87:
            if (r27 == false) goto L89;
            int r124 = 1;
        L90:
            com.bytedance.android.live.revlink.impl.multianchor.service.c r28 = com.bytedance.android.live.revlink.link.biz.service.i.D(r0);
            if (r28 == null) goto L93;
            com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r28, 0, 0, "pullup_default", 3);
        L93:
            x.b("live_multi_start_panel_key", String.valueOf(r124));
            goto L94
        L89:
            r124 = CastIntegerProtector.parseInt(r123) + 1;
            goto L90
        L86:
            r27 = false;
            goto L87
        L79:
            r24 = false;
        L94:
            r0.e = true;
            return;
        L69:
            if (r120.f == true) goto L94;
        L102:
            return;
        L40:
            r114 = null;
            goto L42
        L98:
            return;
        L97:
            return;
        L96:
            return;
        L28:
            r19 = null;
            goto L29
        L20:
            r10 = null;
        L16:
            r8 = null;
        L10:
            r5 = null;
            goto L11
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Unit) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ MultiOtherComponent a;

        public b(MultiOtherComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            o51.e r6 = (o51.e) r5;
            if (r6 == null) goto L13;
            RevLinkWindowRegionContext r0 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this.a);
            if (r0 == null) goto L9;
            r0.setUiLayout(r6);
        L9:
            if ((!Intrinsics.areEqual(this.a.h, r6)) == false) goto L11;
            cy0.e.a.getClass();
            cy0.j r1 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r2 = com.bytedance.android.scope.m.b(r1).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
            Intrinsics.checkNotNull(r2);
            JSONObject r3 = new JSONObject();
            r3.put("eventName", "revlink_ui_update");
            r3.put("ui_layout", r6.b);
            Unit r4 = Unit.INSTANCE;
            ((vy0.b) ((f80.a) r2)).sendEventToAllJsBridges("H5_revenueInteractData", r3);
            this.a.h = r6;
        L11:
            cy0.e.a.getClass();
            cy0.j r7 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r8 = com.bytedance.android.scope.m.b(r7).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
            Intrinsics.checkNotNull(r8);
            int r9 = r6.a.c;
            ((com.bytedance.live.kmp.core.c) r8).Bk();
            return;
        }
    }

    public static final class c extends i11.c.a {
        public c() {
        }

        @Override // i11.c.a, i11.c.b
        public final void d(int r5, List<? extends com.bytedance.android.livesdk.link.model.p> r6) {
            Intrinsics.checkNotNullParameter(r6, "list");
            cy0.e.a.getClass();
            cy0.j r0 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
            Intrinsics.checkNotNull(r1);
            JSONObject r2 = new JSONObject();
            r2.put("eventName", "revlink_online_update");
            r2.put("online_cnt", ((CopyOnWriteArrayList) r6).size());
            r2.put("scene", r5);
            Unit r7 = Unit.INSTANCE;
            ((vy0.b) ((f80.a) r1)).sendEventToAllJsBridges("H5_revenueInteractData", r2);
        }
    }

    public static final class d extends i11.c.a {
        public final /* synthetic */ MultiOtherComponent a;

        public d(MultiOtherComponent r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void d(int r3, List<? extends com.bytedance.android.livesdk.link.model.p> r4) {
            Intrinsics.checkNotNullParameter(r4, "list");
            if ((!r4.isEmpty()) == false) goto L8;
            CopyOnWriteArrayList r5 = (CopyOnWriteArrayList) r4;
            int r6 = r5.size();
            h r0 = this.a.m;
            if (r6 <= r0.g) goto L9;
            r0.g = r5.size();
            return;
        L9:
            return;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
        com.bytedance.android.live.revlink.link.biz.service.i.t(this).l(this.i);
        com.bytedance.android.live.revenuelink.connect.f r1 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r1 == null) goto L5;
        r1.removeLinkInListener(7, this);
    L5:
        Disposable r2 = com.bytedance.android.live.revlink.link.biz.service.i.C(this).a;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        MultiLinkAnchorControlContext r3 = com.bytedance.android.live.revlink.link.biz.service.i.G(this);
        if (r3 == null) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.utils.s r4 = r3.getConnectMonitor();
        if (r4 == null) goto L16;
        if (u41.d.n.a() == false) goto L16;
        int r5 = r4.b + ((ArrayList) r4.a).size();
        r4.b = 0;
        ((ArrayList) r4.a).clear();
    L17:
        com.bytedance.android.live.revlink.impl.multianchor.utils.l r6 = com.bytedance.android.live.revlink.link.biz.service.i.k(this);
        i97.a r7 = i97.a.a;
        long r8 = System.currentTimeMillis() - this.m.h;
        f21.a r9 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r10 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r12 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        r6.getClass();
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("link_type", "multi_anchor");
        long r14 = WebcastRedirectException.UNKNOWN;
        r13.put("link_duration", String.valueOf(r8 / r14));
        com.bytedance.android.live.revlink.impl.global.c r15 = r6.b;
        if (r15 == null) goto L20;
        MultiLinkAnchorControlContext r16 = r15.ua();
    L21:
        if (r16 == null) goto L23;
        Integer r17 = Integer.valueOf(r16.getMultiLinkTimes());
    L24:
        r13.put("multi_link_times", String.valueOf(r17));
        com.bytedance.android.live.revlink.impl.global.c r18 = r6.b;
        if (r18 == null) goto L27;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r19 = r18.rb();
    L28:
        if (r19 == null) goto L32;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revenuelink.i> r110 = r19.getUnloadSource();
        if (r110 == null) goto L32;
        com.bytedance.android.live.revenuelink.i r111 = (com.bytedance.android.live.revenuelink.i) r110.getValue();
    L33:
        r13.put("leave_source", String.valueOf(r111));
        r13.put("invalid_connects", String.valueOf(r5));
        if (r9 == null) goto L37;
        com.bytedance.android.live.revlink.impl.multianchor.utils.l.a(r13, r9);
    L37:
        if (r10 == null) goto L44;
        r13.put("pk_count", String.valueOf(r10.getPkPlayTimes()));
        r13.put("complete_pk_count", String.valueOf(r10.getCompletePkCount()));
        if (r10.getPkPlayTimes() == r10.getCompletePkCount()) goto L41;
        String r20 = DataType.TRUE;
    L42:
        r13.put("incomplete_pk", r20);
        goto L44
    L41:
        r20 = DataType.FALSE;
    L44:
        if (r12 == null) goto L67;
        com.bytedance.android.live.revlink.impl.global.c r112 = r6.b;
        if (r112 == null) goto L48;
        com.bytedance.android.live.revlink.impl.multianchor.utils.b0 r113 = r112.Tj();
    L49:
        if (r113 == null) goto L55;
        PkBaseStateMachine.c r114 = r113.e();
        if (r114 == null) goto L55;
        if ((r114 instanceof PkBaseStateMachine.c.C0130c) != true) goto L55;
        String r22 = "2";
    L66:
        r13.put("in_multi_pk", r22);
    L55:
        i31.a r23 = r12.getPkBeforeFinishData();
        if (r23 == null) goto L65;
        PkBaseStateMachine.c r115 = r23.a;
        r115.getClass();
        if ((r115 instanceof PkBaseStateMachine.c.C0130c) == true) goto L60;
    L62:
        boolean r24 = false;
    L63:
        if (r24 != true) goto L65;
        r22 = DataType.TRUE;
        goto L66
    L60:
        if ((System.currentTimeMillis() - r23.c) >= 1500) goto L62;
        r24 = true;
    L65:
        r22 = DataType.FALSE;
        goto L66
    L48:
        r113 = null;
    L67:
        r6.b(r13);
        com.bytedance.android.live.revlink.impl.global.c r25 = r6.b;
        if (r25 == null) goto L70;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r26 = r25.rb();
    L72:
        if (r26 == null) goto L79;
        com.bytedance.live.datacontext.n<? extends f21.a> r27 = r26.getConnectionContext();
        if (r27 == null) goto L79;
        f21.a r28 = (f21.a) r27.getValue();
        if (r28 == null) goto L79;
        String r29 = r28.m;
        if (r29 == null) goto L79;
    L80:
        r13.put("connection_type", r29);
        mz0.n r30 = new mz0.n();
        Map<String, String> r116 = r30.a;
        Intrinsics.checkNotNullParameter(r116, "map");
        Intrinsics.checkNotNullParameter(r13, "map");
        r116.putAll(r13);
        cy0.e.a.getClass();
        cy0.j r117 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r32 = com.bytedance.android.scope.m.b(r117).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r32);
        ((mz0.i) ((f80.a) r32)).w3("livesdk_rd_leave_connection", r30.a, r30.b);
        r6.c("livesdk_rd_leave_connection", r13);
        if (r8 > 8000) goto L92;
        com.bytedance.android.live.revlink.impl.global.c r33 = r6.b;
        if (r33 == null) goto L85;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r34 = r33.rb();
    L86:
        if (r34 == null) goto L90;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revenuelink.i> r35 = r34.getUnloadSource();
        if (r35 == null) goto L90;
        com.bytedance.android.live.revenuelink.i r36 = (com.bytedance.android.live.revenuelink.i) r35.getValue();
    L91:
        r13.put("error_msg", String.valueOf(r36));
        r6.c("abnormal_leave_connection", r13);
    L90:
        r36 = null;
        goto L91
    L85:
        r34 = null;
    L92:
        Integer r37 = (Integer) getContext().getLinkDataSet().wh().getValue();
        if (r37 == null) goto L95;
        this.n.getUnloadSource().setValue(new com.bytedance.android.live.revenuelink.i.c(String.valueOf(r37.intValue())));
    L95:
        RevLinkMultiChannelDataContext r38 = com.bytedance.android.live.revlink.link.biz.service.i.a0(this);
        if (r38 == null) goto L98;
        r38.removeMultiChannelOptManager();
    L98:
        getContext().getCommonService().i();
        h r39 = this.m;
        if (r39.i == false) goto L101;
    L234:
        getContext().getRoomDataCenterService().P1(true);
        this.k.so().setValue(new zg1.d(7, false, this.m.j, 2));
        RevLinkWindowRegionContext r40 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r40 == null) goto L237;
        r40.onLinkDestroy();
    L237:
        this.p.Ek();
        com.bytedance.android.live.revlink.link.domain.anchorimpl.i r42 = getContext().qa();
        RevLinkWindowRegionContext r43 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r43 == null) goto L240;
        Map<String, String> r44 = r43.getLogParams();
    L241:
        r42.fk(7, r44);
        b r45 = this.f;
        if (r45 == null) goto L248;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r46 = getContext();
        if (r46 == null) goto L248;
        NextLiveData<o51.e> r47 = r46.getUiLayout();
        if (r47 == null) goto L248;
        r47.removeObserver(r45);
    L248:
        c r48 = this.g;
        if (r48 == null) goto L255;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r49 = getContext();
        if (r49 == null) goto L255;
        AnchorLinkUserCenterV2 r50 = r49.getAnchorLinkUserCenter();
        if (r50 == null) goto L255;
        r50.l(r48);
    L255:
        this.f = null;
        this.g = null;
        this.h = null;
        return;
    L240:
        r44 = null;
        goto L241
    L101:
        if (r39.j == true) goto L103;
    L104:
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r52 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r53 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        LinkedHashMap r54 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.room.a r55 = this.c;
        if (r55 == null) goto L107;
        String r56 = r55.getPixEnterFrom();
    L108:
        r54.put("enter_from", r56);
        f21.a r57 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        long r118 = 0;
        if (r57 == null) goto L111;
        long r58 = r57.s;
    L113:
        if (r58 <= 0) goto L118;
        f21.a r59 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r59 == null) goto L117;
        long r60 = r59.s;
    L119:
        long r210 = (System.currentTimeMillis() - r60) / r14;
        r54.put("anchor_connect_status", String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.t(this).c() + 1));
        h r62 = this.m;
        Object r63 = DataType.FALSE;
        r54.put("diamond", String.valueOf(r62.k));
        r54.put("connection_time", String.valueOf(r210));
        if (l51.a.e() == false) goto L122;
        String r64 = "on";
    L123:
        r54.put("gift_guest_switch_type", r64);
        r54.put("end_type", "room_close");
        r54.put("pk_id", String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.T(this).i()));
        r54.put("end_reason", "active");
        r54.put("connection_anchor_cnt", String.valueOf(this.m.g));
        if (r53 == null) goto L130;
        PkBaseStateMachine.c r119 = r53.getCurPKBaseState();
        if (r119 == null) goto L130;
        Object r211 = "pve";
        boolean r65 = true;
        if (r119.b() != true) goto L131;
        Object r66 = "connection";
    L136:
        r54.put("room_status", r66);
        if (r52 == null) goto L143;
        j31.a r67 = r52.getPkStartParam();
        if (r67 == null) goto L143;
        Integer r68 = r67.f;
        if (r68 == null) goto L143;
        int r69 = r68.intValue();
    L144:
        if (r69 == 0) goto L152;
        if (r52 == null) goto L149;
        j31.a r70 = r52.getPkStartParam();
        if (r70 == null) goto L149;
        Integer r72 = r70.f;
    L150:
        r54.put("pk_time", String.valueOf(r72));
    L149:
        r72 = null;
    L152:
        r54.put("connection_type", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).c());
        r54.put("connection_sub_type", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).b());
        r54.put("is_manager", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).o());
        com.bytedance.android.live.revlink.link.biz.service.i.Z(this).getClass();
        r54.put("audience_connect_cnt", String.valueOf(n41.a.b()));
        r54.put("invite_mode", "connection");
        if (r52 == null) goto L155;
        String r73 = r52.getTeamType();
    L156:
        if (r73 != null) goto L158;
    L161:
        boolean r74 = true;
    L162:
        if (r74 == true) goto L170;
        if (r52 == null) goto L168;
        String r75 = r52.getTeamType();
        if (r75 == null) goto L168;
    L169:
        r54.put("team_type", r75);
    L171:
        r54.put("invitee_list", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).p(0));
        if (r52 == null) goto L178;
        j31.a r76 = r52.getPkStartParam();
        if (r76 == null) goto L178;
        if (r76.e != true) goto L178;
        Object r77 = DataType.TRUE;
    L179:
        r54.put("is_oncemore", r77);
        r54.put("is_manager", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).o());
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r78 = com.bytedance.android.live.revlink.link.biz.service.i.B(this);
        f21.a r79 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r79 == null) goto L182;
        boolean r80 = r79.k;
    L183:
        f21.a r82 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r82 == null) goto L186;
        int r83 = r82.d;
    L187:
        r54.put("npk_link_type", com.bytedance.android.live.revlink.impl.multianchor.utils.q.E(r78, r80, r83, 4));
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r84 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r84 == null) goto L197;
        com.bytedance.live.datacontext.m<String> r85 = r84.getConnectionSubType();
        if (r85 == null) goto L197;
        if (((CharSequence) r85.getValue()).length() <= 0) goto L194;
        boolean r86 = true;
    L195:
        if (r86 == false) goto L197;
        r54.put("connection_sub_type", r85.getValue());
        goto L197
    L194:
        r86 = false;
    L197:
        r54.put("invite_mode", "connection");
        h r87 = this.m;
        if (r87.f == false) goto L202;
        Integer r88 = r87.o;
        if (r88 == null) goto L202;
        r54.put("anchor_connect_status", String.valueOf(r88.intValue()));
    L202:
        h r89 = this.m;
        if (r89.f == true) goto L205;
    L222:
        com.bytedance.android.live.revlink.link.biz.service.i.C(this).b(r54);
        mz0.n r90 = new mz0.n();
        Map<String, String> r92 = r90.a;
        Intrinsics.checkNotNullParameter(r92, "map");
        Intrinsics.checkNotNullParameter(r54, "map");
        r92.putAll(r54);
        mz0.m r93 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r94 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r94, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r94.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r94.d("other");
        ((ArrayList) r93.a).add(r94.a);
        com.bytedance.android.live.revlink.link.biz.service.i.m(this).a(r93);
        r93.b(LogCommon.ROOM);
        ((ArrayList) r90.b).addAll(r93.a);
        Object r95 = com.bytedance.android.scope.m.b(r117).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r95);
        ((mz0.i) ((f80.a) r95)).w3("connection_over", r90.a, r90.b);
        Object r96 = com.bytedance.android.scope.m.b(r117).b(er2.b.class);
        Intrinsics.checkNotNull(r96);
        iq2.b r97 = ((com.bytedance.live.kmp.core.c) r96).getChorusService();
        if (r97 == null) goto L234;
        if (r97.e() != true) goto L234;
        Object r98 = com.bytedance.android.scope.m.b(r117).b(er2.b.class);
        Intrinsics.checkNotNull(r98);
        iq2.b r99 = ((com.bytedance.live.kmp.core.c) r98).getChorusService();
        if (r99 == null) goto L233;
        com.bytedance.android.live.liveinteract.model.a r100 = r99.c();
        if (r100 == null) goto L233;
        if (r100.getStartTime() <= 0) goto L233;
        r118 = (com.bytedance.live.kmp.util.e.b() / r14) - r100.getStartTime();
    L233:
        this.o.a(0, this.m.f, r118);
        goto L234
    L205:
        if (r89.l == false) goto L222;
        if (r53 != null) goto L208;
    L210:
        Object r101 = "pk";
    L211:
        r54.put("room_status", r101);
        String r102 = this.m.m;
        if (r102 != null) goto L214;
        r102 = "";
    L214:
        r54.put("invite_mode", r102);
        Integer r103 = this.m.n;
        if (r103 == null) goto L218;
        String r104 = String.valueOf(r103.intValue());
        if (r104 == null) goto L218;
    L219:
        r54.put("customize_pk_type", r104);
        Map<String, String> r105 = this.m.p;
        if (r105 == null) goto L222;
        r54.putAll(r105);
    L218:
        r104 = "";
        goto L219
    L208:
        if (r53.isInBreakThrough() != true) goto L210;
        r101 = r211;
        goto L211
    L186:
        r83 = 0;
        goto L187
    L182:
        r80 = false;
    L178:
        r77 = r63;
    L168:
        r75 = "";
        goto L169
    L170:
        r63 = r63;
        goto L171
    L158:
        if (r73.length() == 0) goto L161;
        r74 = false;
        goto L162
    L155:
        r73 = null;
    L143:
        r69 = 0;
    L131:
        if (r53 != null) goto L133;
    L135:
        r66 = "pk";
        goto L136
    L133:
        if (r53.isInBreakThrough() != r65) goto L135;
        r66 = r211;
    L130:
        r211 = "pve";
        r65 = true;
        goto L131
    L122:
        r64 = "off";
        goto L123
    L117:
        r60 = 0;
        goto L119
    L118:
        r60 = this.m.h;
        goto L119
    L111:
        r58 = 0;
        goto L113
    L107:
        r56 = "connection_panel";
        goto L108
    L103:
        if (r39.f == false) goto L234;
    L79:
        r29 = "";
        goto L80
    L70:
        r26 = null;
    L32:
        r111 = null;
        goto L33
    L27:
        r19 = null;
        goto L28
    L23:
        r17 = null;
        goto L24
    L20:
        r16 = null;
    L16:
        r5 = 0;
        goto L17
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.android.live.revlink.link.biz.service.i.t(this).i(this.i);
        PublishSubject r0 = this.n.getAnchorLeave().onEvent();
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new e(r1)), this.b);
        getContext().getRoomDataCenterService().Ug();
        h r2 = this.m;
        i97.a r3 = i97.a.a;
        r2.h = System.currentTimeMillis();
        com.bytedance.android.live.revenuelink.connect.f r4 = com.bytedance.android.live.revlink.link.biz.service.i.c(this);
        if (r4 == null) goto L5;
        r4.addLinkInListener(7, this);
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.utils.l r5 = com.bytedance.android.live.revlink.link.biz.service.i.k(this);
        f21.a r6 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        r5.getClass();
        LinkedHashMap r7 = new LinkedHashMap();
        if (r6 == null) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.utils.l.a(r7, r6);
    L8:
        r7.put("link_type", "multi_anchor");
        com.bytedance.android.live.revlink.impl.global.c r8 = r5.b;
        com.bytedance.android.live.revenuelink.rtc.f r9 = null;
        if (r8 == null) goto L11;
        MultiLinkAnchorControlContext r10 = r8.ua();
    L12:
        if (r10 == null) goto L14;
        Integer r12 = Integer.valueOf(r10.getMultiLinkTimes());
    L15:
        r7.put("multi_link_times", String.valueOf(r12));
        com.bytedance.android.live.revlink.impl.global.c r13 = r5.b;
        if (r13 == null) goto L18;
        w r14 = r13.getMultiLinkUtil();
    L19:
        if (r14 == null) goto L25;
        i11.b r15 = r14.a();
        if (r15 == null) goto L25;
        List<com.bytedance.android.livesdk.link.model.p> r16 = r15.getOnlineUserList();
        if (r16 == null) goto L25;
        Integer r17 = Integer.valueOf(r16.size());
    L26:
        r7.put("server_anchor_cnt", String.valueOf(r17));
        com.bytedance.android.live.revlink.impl.global.c r18 = r5.b;
        if (r18 == null) goto L29;
        r9 = r18.m0();
    L29:
        if (r9 == null) goto L33;
        com.bytedance.android.live.revenuelink.rtc.i r19 = r9.getRtcManager();
        if (r19 == null) goto L33;
        r7.put("rtc_anchor_cnt", String.valueOf(r19.L().l().size()));
    L33:
        r5.b(r7);
        mz0.n r20 = new mz0.n();
        Map<String, String> r22 = r20.a;
        Intrinsics.checkNotNullParameter(r22, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r22.putAll(r7);
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("livesdk_rd_enter_connection", r20.a, r20.b);
        r5.c("livesdk_rd_enter_connection", r7);
        getContext().getRoomDataCenterService().P1(false);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(this.m.r, new AnonymousClass2(this)), this.b);
        u r25 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r25 != null) goto L36;
    L40:
        this.m.h = System.currentTimeMillis();
        this.p.a();
        com.bytedance.android.live.revlink.link.biz.service.i.t(this).b(4, "multi_anchor_link_widget_create");
        com.bytedance.revenue.platform.api.core.rx.f.a(this.n.getWindowCount().a().subscribe(a.a), this.b);
        p11.d r26 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r26 == null) goto L43;
        r26.h();
        r26.i("multi_linker");
    L43:
        f21.a r27 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r27 != null) goto L46;
    L48:
        b r28 = new b(this);
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r29 = getContext();
        if (r29 == null) goto L53;
        NextLiveData<o51.e> r30 = r29.getUiLayout();
        if (r30 == null) goto L53;
        r30.observeForever(r28);
    L53:
        Unit r32 = Unit.INSTANCE;
        this.f = r28;
        c r33 = new c();
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r34 = getContext();
        if (r34 == null) goto L58;
        AnchorLinkUserCenterV2 r35 = r34.getAnchorLinkUserCenter();
        if (r35 == null) goto L58;
        r35.i(r33);
    L58:
        this.g = r33;
        return;
    L46:
        if (r27.f == false) goto L48;
        this.e = true;
        goto L48
    L36:
        if (com.bytedance.android.live.revlink.impl.multianchor.utils.x.a(r25.b) != true) goto L40;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r36 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r36 == null) goto L40;
        r36.setPkLauncher(true);
    L25:
        r17 = null;
        goto L26
    L18:
        r14 = null;
        goto L19
    L14:
        r12 = null;
        goto L15
    L11:
        r10 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.j;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
    public final void h3(fy.f r24, Throwable r25) {
        Intrinsics.checkNotNullParameter(r24, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r24, "joinChannelParams");
        com.bytedance.android.live.revlink.link.biz.service.i.H(this).u(r24.a, r24.d, t.a(r24.e), r25);
        com.bytedance.android.live.revlink.link.biz.service.i.b0(this).c("linkmic/join_channel/", new d31.a(0, 0, 0, 7, null, 0, 0, null, null, null, null, 4087), r25, t.a(r24.e));
    }

    @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
    public final void m3(fy.f r18, ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r19) {
        Intrinsics.checkNotNullParameter(r18, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r19, "response");
        com.bytedance.android.livesdk.link.model.bridge.f r1 = (com.bytedance.android.livesdk.link.model.bridge.f) r19.data;
        v r2 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        long r3 = r18.a;
        int r5 = r18.d;
        long r6 = t.a(r18.e);
        r2.getClass();
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("req_channel_id", Long.valueOf(r3));
        r8.put("match_type", Integer.valueOf(r5));
        r2.b(r8);
        r2.D("anchor_join_channel_success", r6, r8);
        com.bytedance.android.live.revlink.link.biz.service.i.b0(this).e("linkmic/join_channel/", new d31.a(0, 0, 0, 7, null, 0, 0, null, null, null, null, 4087), t.a(r18.e));
        f21.a r0 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r0 == null) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.utils.g r4 = r0.r;
        if (r4 == null) goto L13;
        y6 r7 = com.bytedance.android.livesdk.link.model.l.a(r1);
        if (r7 == null) goto L11;
        List r9 = r7.getAnchorUserList();
        if (r9 == null) goto L11;
        List<? extends com.bytedance.android.livesdk.link.model.p> r10 = CollectionsKt.toList(r9);
    L12:
        r4.b(r10);
    L11:
        r10 = null;
    L13:
        getContext().getRoomDataCenterService().tl(new gt1.f(7));
    }

    public MultiOtherComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r2, MultiRTCBizComponent r3, ld.a r4, yz0.f r5, RevLinkDomainAnchorService r6, h r7, MultiAnchorLinkContext r8, g r9, MultiPkScopeProviderService r10, com.bytedance.android.livesdk.revenue.service.room.c r12, com.bytedance.android.live.revlink.link.streaminteract.biz.c r13, MultiPKContextHolder r14) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rtcBizComponent");
        Intrinsics.checkNotNullParameter(r4, "linkInternalDataSet");
        Intrinsics.checkNotNullParameter(r5, "messageService");
        Intrinsics.checkNotNullParameter(r6, "domainAnchorService");
        Intrinsics.checkNotNullParameter(r7, "bizDataContext");
        Intrinsics.checkNotNullParameter(r8, "linkContext");
        Intrinsics.checkNotNullParameter(r9, "chorusComponent");
        Intrinsics.checkNotNullParameter(r10, "multiPkScopeService");
        Intrinsics.checkNotNullParameter(r12, "roomService");
        Intrinsics.checkNotNullParameter(r13, "streamMixManagerService");
        Intrinsics.checkNotNullParameter(r14, "pkContextHolder");
        this.j = r2;
        this.k = r4;
        this.l = r5;
        this.m = r7;
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r12;
        this.r = r14;
        this.a = "MultiOtherComponent";
        this.b = new CompositeDisposable();
        this.c = r12.getRoomContext();
        IRoomBase r15 = r12.getRoomContext().getCommonRoom();
        if ((r15 instanceof IRoom) == true) goto L5;
        r15 = null;
    L5:
        this.d = (IRoom) r15;
        this.i = new d(this);
    }
}
