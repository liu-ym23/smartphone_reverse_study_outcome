package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.streaminteract.biz.PushModeManagerService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.link.model.ILinkerCloseContent;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import com.bytedance.android.livesdk.link.model.bridge.o1;
import com.bytedance.android.livesdk.link.model.bridge.p1;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j0;
import com.bytedance.android.livesdk.link.model.w5;
import com.bytedance.android.livesdk.link.model.y6;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiBizLifeControlComponent extends com.bytedance.android.live.revenuelink.connect.c implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public f31.j c;
    public Function0<Unit> d;
    public String e;
    public boolean f;
    public boolean g;
    public final com.bytedance.android.livesdk.revenue.room.a h;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a i;
    public final ld.a j;
    public final com.bytedance.android.livesdk.revenue.service.room.c k;
    public final h l;
    public final yz0.f m;
    public final com.bytedance.android.live.revenuelink.rtc.i n;
    public final PushModeManagerService o;
    public final AnchorUILayoutManager p;
    public final Function1<String, Unit> q;
    public final Function0<Unit> r;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiBizLifeControlComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass1(MultiBizLifeControlComponent r8) {
            super(1, r8, MultiBizLifeControlComponent.class, "onStopLive", "onStopLive(Ljava/lang/Integer;)V", 0);
        }

        public final void invoke(Integer r4) {
            MultiBizLifeControlComponent r0 = (MultiBizLifeControlComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r4 == null) goto L12;
            r4.intValue();
            Intrinsics.checkNotNullParameter(r0, "$this$multiAnchorService");
            com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(r0).R8();
            if (r1 == null) goto L9;
            i11.b r2 = r1.getLinkUserCenter();
            if (r2 == null) goto L9;
            int r3 = r2.c();
        L10:
            r0.c = new f31.j(r3, "room_close");
            return;
        L9:
            r3 = 0;
            goto L10
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Integer) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiBizLifeControlComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/i6;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/i6;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<i6, Unit> {
        public AnonymousClass2(MultiBizLifeControlComponent r8) {
            super(1, r8, MultiBizLifeControlComponent.class, "onLinkerMessage", "onLinkerMessage(Lcom/bytedance/android/livesdk/link/model/ILinkerMessage;)V", 0);
        }

        public final void invoke(i6 r14) {
            Intrinsics.checkNotNullParameter(r14, "p1");
            MultiBizLifeControlComponent r0 = (MultiBizLifeControlComponent) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r14, "$this$sceneExt");
            if (((int) r14.getScene()) == 7) goto L9;
            Intrinsics.checkNotNullParameter(r14, "$this$sceneExt");
            if (((int) r14.getScene()) == 2) goto L9;
            Intrinsics.checkNotNullParameter(r14, "$this$sceneExt");
            if (((int) r14.getScene()) == 1) goto L9;
            return;
        L9:
            Intrinsics.checkNotNullParameter(r14, "$this$typeExt");
            int r3 = (int) r14.getType2();
            j0 r7 = null;
            Object r8 = null;
            r7 = null;
            if (r3 != 2) goto L12;
            Intrinsics.checkNotNullParameter(r14, "$this$linkerIdExt");
            if (r14.getLinkerId() != r0.getContext().G()) goto L84;
            com.bytedance.android.live.revlink.link.biz.service.i.H(r0).A(r14);
            ILinkerCloseContent r15 = r14.getClose();
            if (r15 != null) goto L71;
        L73:
            r0.a(null, "receive_link_message_2", false, false);
            return;
        L71:
            if (r15.getSource() != 1) goto L73;
            return;
        L84:
            return;
        L12:
            if (r3 != 13) goto L14;
            v r4 = com.bytedance.android.live.revlink.link.biz.service.i.H(r0);
            r4.getClass();
            Intrinsics.checkNotNullParameter(r14, Constants.OperatorKey.MSG);
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put("msg_id", String.valueOf(qj.a(r14)));
            Intrinsics.checkNotNullParameter(r14, "$this$sceneExt");
            r5.put("msg_scene", Long.valueOf(r14.getScene()));
            Intrinsics.checkNotNullParameter(r14, "$this$linkerIdExt");
            r5.put("msg_linker_id", Long.valueOf(r14.getLinkerId()));
            Intrinsics.checkNotNullParameter(r14, "$this$kickOutEx");
            ILinkerKickOutContent r9 = r14.getMKickOut();
            if (r9 == null) goto L42;
            r5.put("from_user_id", Long.valueOf(r9.getFromUserId()));
        L42:
            r4.b(r5);
            if (r4.k() == false) goto L45;
            r4.H("receive_linker_kick_out_msg", r5);
        L46:
            Intrinsics.checkNotNullParameter(r14, "$this$linkerIdExt");
            if (r14.getLinkerId() != r0.getContext().G()) goto L83;
            r0.a(null, "receive_link_message_13", false, false);
            LiveFullLinkPKMonitor r1 = com.bytedance.android.live.revlink.link.biz.service.i.s(r0);
            Intrinsics.checkNotNullParameter(r14, "$this$kickOutEx");
            ILinkerKickOutContent r16 = r14.getMKickOut();
            String r2 = "";
            if (r16 == null) goto L53;
            String r17 = String.valueOf(r16.getKickOutSource());
            if (r17 == null) goto L53;
        L54:
            int r6 = LiveFullLinkPKMonitor.p;
            LiveTracingMonitorKt.EventModule r10 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r17, "reason");
            Intrinsics.checkNotNullParameter(r10, "eventModule");
            JSONObject r12 = new JSONObject();
            int r13 = y50.b.a;
            y50.b.a.d(r12, "business_api_name", "abnormal_finish");
            y50.b.a.d(r12, "source", "sys_kick_out");
            y50.b.a.d(r12, "reason", r17);
            y50.b.a.b(r12, "error_code", 0);
            y50.b.a.b(r12, "message_type", 13);
            com.bytedance.android.live.revenuelink.rtc.f r18 = r1.e();
            if (r18 == null) goto L62;
            com.bytedance.android.live.revenuelink.rtc.i r19 = r18.getRtcManager();
            if (r19 == null) goto L62;
            String r110 = r19.c0();
            if (r110 == null) goto L62;
            r2 = r110;
        L62:
            y50.b.a.d(r12, "linker_session_id", r2);
            HashMap r111 = new HashMap();
            r111.put("business_api_name", "abnormal_finish");
            r111.put("android_event_key", "abnormal_finish");
            com.bytedance.android.live.revenuelink.f r20 = r1.i();
            if (r20 == null) goto L79;
            com.bytedance.android.live.revenuelink.f.a.b(r20, r10, 0, String.valueOf(0), r111, r12);
            return;
        L79:
            return;
        L53:
            r17 = "";
            goto L54
        L83:
            return;
        L45:
            int r22 = com.bytedance.android.live.revenue.common.v.a;
            com.bytedance.android.live.revenue.common.v.h("ttlive_anchor_link", "receive_linker_kick_out_msg " + r5);
            goto L46
        L14:
            if (r3 != 15) goto L82;
            v r23 = com.bytedance.android.live.revlink.link.biz.service.i.H(r0);
            r23.getClass();
            Intrinsics.checkNotNullParameter(r14, Constants.OperatorKey.MSG);
            JSONObject r24 = new JSONObject();
            w5 r25 = r14.getLinkerBanContent();
            if (r25 == null) goto L25;
            int r26 = y50.b.a;
            List r27 = r25.getBanUsers();
            if (r27 == null) goto L23;
            List r28 = CollectionsKt.toList(r27);
            if (r28 == null) goto L23;
            String r29 = ef2.a.a(r28);
        L24:
            y50.b.a.d(r24, "ban_users", r29);
        L23:
            r29 = null;
        L25:
            v.m(r14, r24);
            r23.I("receive_linker_ban_msg", r24, false);
            w5 r112 = r14.getLinkerBanContent();
            if (r112 == null) goto L36;
            List r113 = r112.getBanUsers();
            if (r113 == null) goto L36;
            Iterator r114 = r113.iterator();
        L31:
            if (r114.hasNext() == false) goto L35;
            Object r30 = r114.next();
            if (Intrinsics.areEqual(((j0) r30).getUserId(), r0.getContext().Ab()) == false) goto L31;
            r8 = r30;
        L35:
            r7 = (j0) r8;
        L36:
            if (r7 != null) goto L38;
            r7 = (j0) vh7.f.c(j0.class);
            r7.setUserId(r0.getContext().Ab());
            com.bytedance.live.kmp.util.c r115 = com.bytedance.live.kmp.util.c.a;
            int r116 = w11.a.a;
            r7.setReason(com.bytedance.live.kmp.util.c.a(2131921430, new Object[0]));
        L38:
            r0.getContext().ko().l(r7);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i6) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        this.g = true;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(this.j.wh(), new AnonymousClass1(this)), this.b);
        Observable r1 = yz0.h.a.a(this.m, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        final AnonymousClass2 r2 = new AnonymousClass2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r1.subscribe(new a(r2)), this.b);
        com.bytedance.android.live.revenuelink.connect.f r3 = getContext().Z0();
        if (r3 == null) goto L5;
        r3.addLinkInListener(7, this);
    L5:
        com.bytedance.android.live.revenuelink.connect.f r4 = getContext().Z0();
        if (r4 == null) goto L8;
        r4.addLinkInListener(1, this);
    L8:
        this.p.f(com.bytedance.android.live.revlink.link.core.service.c.a(getContext()), "multi_launch");
        if (this.n.isEngineOn() == false) goto L11;
        e("switch_scene or pre enter");
        com.bytedance.android.live.revlink.link.biz.service.i.f0(this).m(com.bytedance.android.live.revlink.link.biz.service.i.i(this));
        this.l.r.setValue(Unit.INSTANCE);
    L19:
        f21.a r5 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r5 != null) goto L22;
        return;
    L22:
        if (r5.f != true) goto L27;
        e("load widget: pk_to_link");
        return;
    L27:
        return;
    L11:
        f21.a r6 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r6 != null) goto L14;
    L18:
        b();
        goto L19
    L14:
        if (r6.c() != true) goto L18;
        g0 r7 = com.bytedance.android.live.revlink.link.biz.service.i.f0(this);
        f21.a r8 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        r7.getClass();
        jy0.b.c("ttlive_anchor_link", "unexpected join_channel when should skip request", null, 4);
        JSONObject r9 = new JSONObject();
        int r10 = y50.b.a;
        y50.b.a.d(r9, "connection_context", String.valueOf(r8));
        v r12 = r7.o();
        if (r12 == null) goto L18;
        r12.I("unexpected_join_channel", r9, true);
        goto L18
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.g = false;
        this.b.clear();
        com.bytedance.android.live.revenuelink.connect.f r0 = getContext().Z0();
        if (r0 == null) goto L5;
        r0.removeLinkInListener(7, this);
    L5:
        com.bytedance.android.live.revenuelink.connect.f r1 = getContext().Z0();
        if (r1 == null) goto L9;
        r1.removeLinkInListener(1, this);
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    public final void b() {
        long r1 = getContext().G();
        int r3 = getContext().getScene();
        f21.a r0 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r0 == null) goto L5;
        int r4 = r0.d;
    L6:
        fy.f r6 = new fy.f(r1, r3, r4, 16);
        com.bytedance.android.live.revenuelink.connect.f r2 = getContext().Z0();
        if (r2 == null) goto L13;
        com.bytedance.android.live.revenuelink.connect.l r5 = r2.linkInManager();
        if (r5 == null) goto L14;
        r5.c(r6);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r4 = 0;
        goto L6
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
        return this.i;
    }

    public final void e(String r10) {
        int r0 = f31.g.c;
        f21.a r1 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        com.bytedance.android.live.revlink.link.core.service.r r2 = null;
        if (r1 != null) goto L5;
        f31.g r3 = null;
    L6:
        PushModeManagerService r4 = this.o;
        if (r3 == null) goto L13;
        v1 r5 = r3.a;
        if (r5 == null) goto L13;
        o1 r6 = r5.getMultiAnchorLinkMicRtcInfo();
        if (r6 == null) goto L13;
        Map r7 = r6.getPushStreamModeRTCMap();
    L14:
        if (r3 == null) goto L20;
        u1 r8 = r3.b;
        if (r8 == null) goto L20;
        p1 r9 = r8.getMultiAnchorLiveCoreInfo();
        if (r9 == null) goto L20;
        Map r12 = r9.getPushStreamModeLiveCoreMap();
    L21:
        if (r3 == null) goto L27;
        v1 r13 = r3.a;
        if (r13 == null) goto L27;
        o1 r14 = r13.getMultiAnchorLinkMicRtcInfo();
        if (r14 == null) goto L27;
        Map r15 = r14.getRtcInfoMap();
    L28:
        if (r3 == null) goto L34;
        u1 r16 = r3.b;
        if (r16 == null) goto L34;
        p1 r17 = r16.getMultiAnchorLiveCoreInfo();
        if (r17 == null) goto L34;
        Map r18 = r17.getLiveCoreExtInfoMap();
    L35:
        PushModeManagerService.d(r4, r7, r12, r15, r18, r10);
        AnchorUILayoutManager r19 = this.p;
        f21.a r20 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r20 == null) goto L40;
        com.bytedance.android.livesdk.link.model.m r22 = r20.t;
        if (r22 == null) goto L40;
        r2 = com.bytedance.android.live.revlink.link.core.service.c.b(r22);
    L40:
        r19.d(r2, r10);
        com.bytedance.android.live.revlink.link.biz.service.i.f0(this).m(com.bytedance.android.live.revlink.link.biz.service.i.i(this));
        return;
    L34:
        r18 = null;
    L27:
        r15 = null;
    L20:
        r12 = null;
    L13:
        r7 = null;
        goto L14
    L5:
        r3 = new f31.g(r1.q, r1.p);
        goto L6
    }

    public final void d(String r2, com.bytedance.android.live.revenuelink.i r3) {
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r0 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revenuelink.i> r1 = r0.getUnloadSource();
        if (r1 == null) goto L7;
        r1.setValue(r3);
    L7:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r4 = com.bytedance.android.live.revlink.link.biz.service.i.w(this);
        if (r4 == null) goto L11;
        r4.vo(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
    public final void h3(fy.f r19, Throwable r20) {
        Intrinsics.checkNotNullParameter(r19, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r19, "joinChannelParams");
        p0.a(0, false, true, new MultiBizLifeControlComponent$onJoinFailed$1(this), 3);
        com.bytedance.android.live.revlink.link.biz.service.i.H(this).u(r19.a, r19.d, t.a(r19.e), r20);
        com.bytedance.android.live.revlink.link.biz.service.i.b0(this).c("linkmic/join_channel/", new d31.a(0, 0, 0, 7, null, 0, 0, null, null, null, null, 4087), r20, t.a(r19.e));
    }

    @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
    public final void k3(fy.h r17, ExtraResponse<n0, Extra> r18) {
        Intrinsics.checkNotNullParameter(r17, "leaveParams");
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "onLeaveSuccess", null, 4);
        if (r17.h == true) goto L5;
        v r3 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        long r7 = r17.a;
        String r4 = r17.c;
        long r9 = t.a(r17.g);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "reqSrc");
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("req_channel_id", Long.valueOf(r7));
        r12.put("req_from", r4);
        r3.b(r12);
        r3.h(r12);
        r3.D("anchor_leave_channel_success", r9, r12);
    L5:
        h r5 = this.l;
        long r8 = 0;
        if (r18 == null) goto L10;
        n0 r2 = (n0) r18.data;
        if (r2 == null) goto L10;
        long r10 = r2.getDiamondCount();
    L11:
        r5.k = r10;
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == true) goto L138;
        f21.a r6 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r6 == null) goto L16;
        long r13 = r6.s;
    L18:
        if (r13 <= 0) goto L22;
        f21.a r14 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r14 == null) goto L23;
        r8 = r14.s;
    L23:
        i97.a r15 = i97.a.a;
        long r16 = (System.currentTimeMillis() - r8) / ((long) WebcastRedirectException.UNKNOWN);
        LinkedHashMap r19 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.room.a r20 = this.h;
        if (r20 == null) goto L26;
        String r22 = r20.getPixEnterFrom();
    L27:
        r19.put("enter_from", r22);
        int r23 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).c();
        if (r23 <= 0) goto L30;
        r19.put("anchor_connect_status", String.valueOf(r23 + 1));
    L30:
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r24 = com.bytedance.android.live.revlink.link.biz.service.i.A(this);
        if (r24 == null) goto L33;
        Long r25 = Long.valueOf(r24.a());
    L34:
        r19.put("channel_id", String.valueOf(r25.longValue()));
        r19.put("connection_time", String.valueOf(r16));
        if (l51.a.e() == false) goto L37;
        String r26 = "on";
    L38:
        r19.put("gift_guest_switch_type", r26);
        r19.put("diamond", String.valueOf(this.l.k));
        r19.put("end_type", "disconnect");
        r19.put("invitee_list", this.e);
        if (this.l.f == false) goto L41;
        String r27 = "active";
    L42:
        r19.put("end_reason", r27);
        r19.put("connection_anchor_cnt", String.valueOf(this.l.g));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r28 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        String r29 = DataType.TRUE;
        if (r28 != null) goto L45;
    L47:
        Object r30 = DataType.FALSE;
    L48:
        r19.put("is_npk", r30);
        r19.put("pk_cnt", DataType.FALSE);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r32 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r32 == null) goto L51;
        int r33 = r32.getPkPlayTimes();
    L52:
        r19.put("pk_n_cnt", String.valueOf(r33));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r34 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        String r110 = "pve";
        if (r34 == null) goto L59;
        PkBaseStateMachine.c r35 = r34.getCurPKBaseState();
        if (r35 == null) goto L59;
        if (r35.b() != true) goto L59;
        Object r36 = "connection";
    L65:
        r19.put("room_status", r36);
        r19.put("connection_type", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).c());
        r19.put("is_manager", com.bytedance.android.live.revlink.link.biz.service.i.Z(this).o());
        com.bytedance.android.live.revlink.link.biz.service.i.Z(this).getClass();
        r19.put("audience_connect_cnt", String.valueOf(n41.a.b()));
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r37 = com.bytedance.android.live.revlink.link.biz.service.i.B(this);
        f21.a r111 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r111 == null) goto L68;
        boolean r112 = r111.k;
    L69:
        f21.a r38 = com.bytedance.android.live.revlink.link.biz.service.i.i(this);
        if (r38 == null) goto L72;
        int r39 = r38.d;
    L73:
        r19.put("npk_link_type", com.bytedance.android.live.revlink.impl.multianchor.utils.q.E(r37, r112, r39, 4));
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r40 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r40 == null) goto L80;
        j31.a r42 = r40.getPkStartParam();
        if (r42 == null) goto L80;
        if (r42.e != true) goto L80;
    L81:
        r19.put("is_oncemore", r29);
        r19.put("is_manager", r17.e);
        String r43 = com.bytedance.android.live.revlink.link.biz.service.i.Z(this).p(0);
        String r44 = "";
        if (r43 != null) goto L84;
        r43 = "";
    L84:
        r19.put("invitee_list", r43);
        r19.put("invite_mode", "connection");
        h r45 = this.l;
        if (r45.f == false) goto L89;
        Integer r46 = r45.o;
        if (r46 == null) goto L89;
        r19.put("anchor_connect_status", String.valueOf(r46.intValue()));
    L89:
        h r47 = this.l;
        if (r47.f == true) goto L92;
    L106:
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r48 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r48 == null) goto L111;
        com.bytedance.live.datacontext.m<String> r49 = r48.getConnectionSubType();
        if (r49 == null) goto L111;
        r19.put("connection_sub_type", r49.getValue());
    L111:
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r50 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r50 == null) goto L118;
        j31.a r52 = r50.getPkStartParam();
        if (r52 == null) goto L118;
        Integer r53 = r52.f;
        if (r53 == null) goto L118;
        int r113 = r53.intValue();
    L119:
        if (r113 == 0) goto L127;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r54 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r54 == null) goto L125;
        j31.a r55 = r54.getPkStartParam();
        if (r55 == null) goto L125;
        Integer r56 = r55.f;
    L126:
        r19.put("pk_time", String.valueOf(r56));
    L125:
        r56 = null;
    L127:
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r57 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r57 == null) goto L134;
        j31.a r58 = r57.getPkStartParam();
        if (r58 == null) goto L134;
        String r59 = r58.n;
        if (r59 == null) goto L134;
        r19.put("customize_pk_type", r59);
    L134:
        com.bytedance.android.live.revlink.link.biz.service.i.C(this).b(r19);
        if ((!StringsKt.isBlank(com.bytedance.android.live.revlink.link.biz.service.i.B(this).n())) == false) goto L137;
        r19.put("team_type", com.bytedance.android.live.revlink.link.biz.service.i.B(this).n());
    L137:
        mz0.n r60 = new mz0.n();
        Map<String, String> r62 = r60.a;
        Intrinsics.checkNotNullParameter(r62, "map");
        Intrinsics.checkNotNullParameter(r19, "map");
        r62.putAll(r19);
        mz0.m r63 = new mz0.m();
        com.bytedance.android.live.revlink.link.biz.service.i.m(this).a(r63);
        r63.b(LogCommon.ROOM);
        ((ArrayList) r60.b).addAll(r63.a);
        cy0.e.a.getClass();
        cy0.j r64 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r65 = com.bytedance.android.scope.m.b(r64).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r65);
        ((mz0.i) ((f80.a) r65)).w3("livesdk_connection_over", r60.a, r60.b);
    L118:
        r113 = 0;
        goto L119
    L92:
        if (r47.l == false) goto L106;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r66 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r66 != null) goto L96;
    L98:
        r110 = "pk";
    L99:
        r19.put("room_status", r110);
        String r67 = this.l.m;
        if (r67 == null) goto L103;
        r44 = r67;
    L103:
        r19.put("invite_mode", r44);
        Map<String, String> r68 = this.l.p;
        if (r68 == null) goto L106;
        r19.putAll(r68);
        goto L106
    L96:
        if (r66.isInBreakThrough() != true) goto L98;
    L80:
        r29 = DataType.FALSE;
        goto L81
    L72:
        r39 = 0;
        goto L73
    L68:
        r112 = false;
    L59:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r69 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r69 != null) goto L62;
    L64:
        r36 = "pk";
        goto L65
    L62:
        if (r69.isInBreakThrough() != true) goto L64;
        r36 = "pve";
        goto L65
    L51:
        r33 = 0;
        goto L52
    L45:
        if (r28.isBattleShow() != true) goto L47;
        r30 = DataType.TRUE;
        goto L48
    L41:
        r27 = "passive";
        goto L42
    L37:
        r26 = "off";
        goto L38
    L33:
        r25 = null;
        goto L34
    L26:
        r22 = "connection_panel";
        goto L27
    L22:
        r8 = this.l.h;
        goto L23
    L16:
        r13 = 0;
    L138:
        Function0<Unit> r70 = this.d;
        if (r70 == null) goto L141;
        Unit r72 = (Unit) r70.invoke();
    L141:
        this.d = null;
        this.l.i = true;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "onLeaveSuccess end rtc and call onEndSuccess", null, 4);
        if (this.n.isEngineOn() == false) goto L144;
        this.q.invoke("leaveSuccess");
        d("rtcEndSuccess", new com.bytedance.android.live.revenuelink.i.b(r17.c));
        return;
    L144:
        d("rtcEndSuccess", new com.bytedance.android.live.revenuelink.i.b(r17.c));
        return;
    L10:
        r10 = 0;
        goto L11
    }

    @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
    public final void m2(final fy.h r12, Throwable r13) {
        Intrinsics.checkNotNullParameter(r12, "leaveParams");
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "onLeaveFailed", null, 4);
        r12.h = true;
        v r4 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        long r0 = r12.a;
        String r5 = r12.c;
        long r6 = t.a(r12.g);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "reqSrc");
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("req_channel_id", Long.valueOf(r0));
        r9.put("req_from", r5);
        r4.b(r9);
        r4.F("anchor_leave_channel_failed", r6, r13, r9);
        if (r12.d == true) goto L5;
    L17:
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "onLeaveFailed post onLeaveSuccess", null, 4);
        p0.a(0, false, true, new MultiBizLifeControlComponent$onLeaveFailed$1(this, r12), 3);
        return;
    L5:
        if ((r13 instanceof ApiServerException) == true) goto L7;
        Throwable r1 = null;
    L8:
        ApiServerException r2 = (ApiServerException) r1;
        if (r2 == null) goto L17;
        if (r2.getErrorCode() != 4004266) goto L17;
        int r3 = ToastUtil.a;
        ToastUtil.b(((ApiServerException) r13).getPrompt(), 0);
        v r7 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        String r14 = r12.c;
        r7.getClass();
        Intrinsics.checkNotNullParameter((Exception) r13, "exception");
        LinkedHashMap r15 = new LinkedHashMap();
        if (r14 == null) goto L15;
        r15.put("req_src", r14);
    L15:
        r7.f(r15);
        int r16 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.b("ttlive_anchor_link", "onInterceptLeaveWhenMultiInviting: isPk=false " + r15, null);
        return;
    L7:
        r1 = r13;
        goto L8
    }

    @Override // com.bytedance.android.live.revenuelink.connect.c, com.bytedance.android.live.revenuelink.connect.i
    public final void m3(fy.f r19, ExtraResponse<com.bytedance.android.livesdk.link.model.bridge.f, Extra> r20) {
        Intrinsics.checkNotNullParameter(r19, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r20, "response");
        super.m3(r19, r20);
        com.bytedance.android.livesdk.link.model.bridge.f r2 = (com.bytedance.android.livesdk.link.model.bridge.f) r20.data;
        int r3 = f31.g.c;
        y6 r4 = com.bytedance.android.livesdk.link.model.l.a(r2);
        Map r5 = null;
        if (r4 != null) goto L5;
        f31.g r6 = null;
    L6:
        PushModeManagerService r7 = this.o;
        if (r6 == null) goto L13;
        v1 r8 = r6.a;
        if (r8 == null) goto L13;
        o1 r9 = r8.getMultiAnchorLinkMicRtcInfo();
        if (r9 == null) goto L13;
        Map r10 = r9.getPushStreamModeRTCMap();
    L14:
        if (r6 == null) goto L20;
        u1 r12 = r6.b;
        if (r12 == null) goto L20;
        p1 r13 = r12.getMultiAnchorLiveCoreInfo();
        if (r13 == null) goto L20;
        Map r14 = r13.getPushStreamModeLiveCoreMap();
    L21:
        if (r6 == null) goto L27;
        v1 r15 = r6.a;
        if (r15 == null) goto L27;
        o1 r16 = r15.getMultiAnchorLinkMicRtcInfo();
        if (r16 == null) goto L27;
        Map r17 = r16.getRtcInfoMap();
    L28:
        if (r6 == null) goto L34;
        u1 r18 = r6.b;
        if (r18 == null) goto L34;
        p1 r22 = r18.getMultiAnchorLiveCoreInfo();
        if (r22 == null) goto L34;
        r5 = r22.getLiveCoreExtInfoMap();
    L34:
        PushModeManagerService.d(r7, r10, r14, r17, r5, "joinChannelSuccess");
        com.bytedance.android.livesdk.link.model.bridge.h r23 = ((com.bytedance.android.livesdk.link.model.bridge.f) r20.data).getAnchorLayOutInfo();
        if (r23 == null) goto L37;
        int r110 = r23.getUiLayout();
    L38:
        com.bytedance.android.livesdk.link.model.bridge.h r24 = ((com.bytedance.android.livesdk.link.model.bridge.f) r20.data).getAnchorLayOutInfo();
        if (r24 == null) goto L41;
        int r111 = r24.getRange();
    L42:
        int r112 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown.ordinal();
        com.bytedance.android.livesdk.link.model.bridge.h r25 = ((com.bytedance.android.livesdk.link.model.bridge.f) r20.data).getAnchorLayOutInfo();
        if (r25 == null) goto L45;
        boolean r113 = r25.isOrientation();
    L46:
        String r114 = getContext().Ab();
        com.bytedance.android.livesdk.link.model.bridge.h r1 = ((com.bytedance.android.livesdk.link.model.bridge.f) r20.data).getAnchorLayOutInfo();
        if (r1 == null) goto L50;
        Map r26 = r1.getLayoutDetails();
        if (r26 == null) goto L50;
    L51:
        this.p.d(new com.bytedance.android.live.revlink.link.core.service.r(r110, r111, r112, r113, r114, new com.bytedance.android.live.revlink.link.core.service.o(r26)), "joinChannelSuccess");
        this.r.invoke();
        return;
    L50:
        r26 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        goto L51
    L45:
        r113 = false;
        goto L46
    L41:
        r111 = 0;
        goto L42
    L37:
        r110 = 0;
    L27:
        r17 = null;
    L20:
        r14 = null;
    L13:
        r10 = null;
        goto L14
    L5:
        r6 = new f31.g(r4.getRtcInfo(), r4.getLiveCoreInfo());
        goto L6
    }

    public final void c(String r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "reqSrc");
        Intrinsics.checkNotNullParameter(r14, "isManager");
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "call leaveChannel from " + r12 + " and hasLeaveChannel: " + this.f, null, 4);
        if (this.f == false) goto L5;
        return;
    L5:
        this.f = true;
        com.bytedance.android.live.revenuelink.connect.f r0 = getContext().Z0();
        if (r0 == null) goto L12;
        com.bytedance.android.live.revenuelink.connect.l r1 = r0.linkInManager();
        if (r1 == null) goto L13;
        r1.a(new fy.h(getContext().G(), getContext().getScene(), r12, r13, r14, com.bytedance.android.live.revenuelink.connect.h.a(r12), 192));
        return;
    L13:
        return;
    }

    public final void a(Function0<Unit> r6, String r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        Intrinsics.checkNotNullParameter(this, "$this$multiAnchorService");
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).R8();
        if (r1 == null) goto L7;
        i11.b r2 = r1.getLinkUserCenter();
        if (r2 == null) goto L7;
        int r3 = r2.c();
    L8:
        this.c = new f31.j(r3, "disconnect");
        if (Intrinsics.areEqual(r7, "close_icon_disconnect") == false) goto L14;
        this.l.a(true, com.bytedance.android.live.revlink.link.biz.service.i.S(this), com.bytedance.android.live.revlink.link.biz.service.i.M(this), r9);
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r10 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r10 == null) goto L14;
        r10.setAnchorLinkFinisher(true);
    L14:
        if (com.bytedance.android.live.revlink.link.biz.service.i.A(this).a() <= 0) goto L16;
        this.d = r6;
        c(r7, r8, com.bytedance.android.live.revlink.link.biz.service.i.Z(this).o());
        this.e = com.bytedance.android.live.revlink.link.biz.service.i.m(this).h();
        return;
    L16:
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r12 = com.bytedance.android.live.revlink.link.biz.service.i.z(this);
        if (r12 == null) goto L21;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revenuelink.i> r13 = r12.getUnloadSource();
        if (r13 == null) goto L21;
        r13.setValue(new com.bytedance.android.live.revenuelink.i.e(r7));
    L21:
        com.bytedance.android.live.revlink.impl.service.internal.a r14 = com.bytedance.android.live.revlink.link.biz.service.i.p(this);
        if (r14 == null) goto L26;
        com.bytedance.android.live.revlink.impl.service.internal.b.a.a(r14, 64, false, 6);
        return;
    L26:
        return;
    L7:
        r3 = 0;
        goto L8
    }

    public MultiBizLifeControlComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, ld.a r3, com.bytedance.android.livesdk.revenue.service.room.c r4, h r5, yz0.f r6, com.bytedance.android.live.revenuelink.rtc.i r7, PushModeManagerService r8, AnchorUILayoutManager r9, Function1 r10, Function0 r12) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "linkInternalDataSet");
        Intrinsics.checkNotNullParameter(r5, "bizDataContext");
        Intrinsics.checkNotNullParameter(r6, "messageService");
        Intrinsics.checkNotNullParameter(r7, "rtcManager");
        Intrinsics.checkNotNullParameter(r8, "pushManager");
        Intrinsics.checkNotNullParameter(r9, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r10, "stopRtc");
        Intrinsics.checkNotNullParameter(r12, "startRtc");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.o = r8;
        this.p = r9;
        this.q = r10;
        this.r = r12;
        this.a = "MultiBizLifeControlComponent";
        this.b = new CompositeDisposable();
        this.e = "";
        if (r4 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r13 = r4.getRoomContext();
    L6:
        this.h = r13;
        return;
    L5:
        r13 = null;
        goto L6
    }
}
