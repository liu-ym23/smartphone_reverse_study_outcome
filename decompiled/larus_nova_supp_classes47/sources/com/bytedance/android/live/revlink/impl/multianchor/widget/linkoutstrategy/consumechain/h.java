package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements a<i6>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
    public final com.bytedance.android.live.revlink.impl.global.c a;
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f b;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f
    public final com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.d Hd() {
        return this.b.Hd();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void finishMultiAnchor(int r8, Function0<Unit> r9, boolean r10, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "reqSrc");
        this.b.finishMultiAnchor(r8, r9, r10, r12, r13);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService() {
        return this.b.getAnchorConnectService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getAnchorLinkUserCenter() {
        return this.b.getAnchorLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final t getConnectMonitor() {
        return this.b.getConnectMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f21.a getConnectionContext() {
        return this.b.getConnectionContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MultiLinkAnchorControlContext getControlContext() {
        return this.b.getControlContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f41.a getJsbInvitePkCallback() {
        return this.b.getJsbInvitePkCallback();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u getLaunchParameters() {
        return this.b.getLaunchParameters();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u.a getLaunchRecord() {
        return this.b.getLaunchRecord();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revlink.impl.multianchor.scope.c getLinkDialogService() {
        return this.b.getLinkDialogService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final ld.a getLinkInternalDataSet() {
        return this.b.getLinkInternalDataSet();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revenuelink.connect.n getLinkOutManager() {
        return this.b.getLinkOutManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getMLinkUserCenter() {
        return this.b.getMLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final IRoom getMRoom() {
        return this.b.getMRoom();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MutableLiveData<q11.c> getPkLinkState() {
        return this.b.getPkLinkState();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final x11.a getRevInternalLinkService() {
        return this.b.getRevInternalLinkService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final wq2.f getRoomDataCenterService() {
        return this.b.getRoomDataCenterService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectManager getRtcConnectManager() {
        return this.b.getRtcConnectManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectModel getRtcConnectModel() {
        return this.b.getRtcConnectModel();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final Function0<v51.b> getStreamInteractScopeFn() {
        return this.b.getStreamInteractScopeFn();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final UnexpectedFrameMonitor getUnexpectedFrameMonitor() {
        return this.b.getUnexpectedFrameMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final boolean isLinkWithAudience() {
        return this.b.isLinkWithAudience();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f
    public final com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.b qp() {
        return this.b.qp();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void reset(String r2) {
        Intrinsics.checkNotNullParameter(r2, "src");
        this.b.reset(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setConnectionContext(f21.a r2) {
        this.b.setConnectionContext(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setJsbInvitePkCallback(f41.a r2) {
        this.b.setJsbInvitePkCallback(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setLaunchParameters(u r2) {
        this.b.setLaunchParameters(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setRtcConnectModel(AnchorRtcConnectModel r2) {
        this.b.setRtcConnectModel(r2);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.a;
    }

    public h(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(i6 r35, Function1<? super i6, Unit> r36, Function0 r37) {
        i6 r1 = r35;
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r36, "resolve");
        Intrinsics.checkNotNullParameter(r37, "reject");
        IBattleLinkerInviteMessageExtra r2 = j6.a(r1);
        if (r2 == null) goto L5;
        int r6 = (int) r2.getMatchType();
    L7:
        if (r6 == 7) goto L17;
        if (x.b(r6) == true) goto L17;
        if (r6 == 1) goto L17;
        if (r6 == 8) goto L17;
        if (r6 == 13) goto L17;
        if (r6 == 12) goto L17;
        if (r6 == 3) goto L17;
        r36.invoke(r1);
        return;
    L17:
        if (r6 != 4) goto L19;
    L22:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r5 = com.bytedance.android.live.revlink.link.biz.service.i.K(this);
        if (r5 == null) goto L26;
        r5.fl(r6, r1);
    L26:
        if (CollectionsKt.listOf(new Integer[]{1, 8, 13, 12}).contains(Integer.valueOf(r6)) == false) goto L33;
        i41.a r0 = com.bytedance.android.live.revlink.link.biz.service.i.h(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "message");
        Iterator r3 = ((ArrayList) r0.a).iterator();
    L29:
        if (r3.hasNext() == false) goto L31;
        ((i41.p) r3.next()).x9(r1);
        goto L29
    L31:
        com.bytedance.android.live.revlink.link.biz.service.i.h(this).b(AutoMatchSource.MatchSuccess);
    L33:
        if (r6 != 3) goto L93;
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.b r7 = qp();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "linkerMessage");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("is_oncemore", DataType.FALSE);
        r8.put("connection_type", "random_pk");
        com.bytedance.android.live.revlink.impl.control.d r9 = com.bytedance.android.live.revlink.link.biz.service.i.e(r7);
        if (r9 == null) goto L38;
        String r10 = r9.getRequestId();
        if (r10 == null) goto L38;
    L39:
        r8.put("request_id", r10);
        r8.put("selection", "accept");
        g1 r12 = r1.getInvite();
        if (r12 == null) goto L42;
        g1 r13 = r12;
        Intrinsics.checkNotNullParameter(r13, "$this$fromUid");
        String r14 = r13.get_fromUid();
    L43:
        if (r14 != null) goto L45;
        r14 = "";
    L45:
        r8.put("right_user_id", r14);
        r8.put("pk_description", "routine");
        r8.put("pk_activity_type", "");
        r8.put("npk_link_type", "single");
        r8.put("invitee_connection_status", "live");
        r8.put("anchor_connect_status", DataType.TRUE);
        r8.put("anchor_connection_type", "invite");
        x11.a r15 = r7.getRevInternalLinkService();
        if (r15 == null) goto L48;
        y11.d r16 = r15.getPkService();
    L49:
        if (r16 == null) goto L51;
        String r17 = r16.getInviteMode();
    L52:
        if (r17 != null) goto L54;
    L57:
        boolean r18 = true;
    L58:
        if (r18 == false) goto L61;
        r17 = "routine_pk";
    L61:
        r8.put("invite_mode", r17);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r20);
        r8.put("invitee_id", ((com.bytedance.live.kmp.core.c) r20).getCurrentUserId());
        IPKLinkBizDataService r22 = com.bytedance.android.live.revlink.link.biz.service.i.P(r7);
        if (r22 == null) goto L72;
        Object r110 = com.bytedance.android.scope.m.b(r19).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r110);
        IBaseUser r111 = ((com.bytedance.live.kmp.core.c) r110).b();
        if (r111 == null) goto L66;
        String r112 = r111.getIdString();
    L67:
        g1 r113 = r1.getInvite();
        if (r113 == null) goto L70;
        g1 r114 = r113;
        Intrinsics.checkNotNullParameter(r114, "$this$fromUid");
        String r115 = r114.get_fromUid();
    L71:
        String r23 = r22.getTransformReason(r112, r115);
    L73:
        if (r23 != null) goto L75;
    L78:
        boolean r116 = true;
    L79:
        if (r116 == true) goto L81;
        r8.put("transform_reason", r23);
    L81:
        if (r16 == null) goto L83;
        String r24 = r16.getTheme();
    L84:
        if (r24 != null) goto L86;
    L89:
        boolean r25 = true;
    L90:
        if (r25 == true) goto L92;
        r8.put(FileUtils.PICTURE_THEME, r24);
    L92:
        mz0.n r26 = new mz0.n();
        mz0.o r27 = new mz0.o(r26.a);
        e21.e.d(r27, e21.e.c(r1));
        r27.b(r8);
        mz0.m r28 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r29 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r29, "linkInfoLog");
        am2.m r30 = r29.a;
        r30.i = 300;
        ((ArrayList) r28.a).add(r30);
        com.bytedance.android.live.revlink.link.biz.service.i.m(r7).m(r28);
        r28.b(LogCommon.ROOM);
        ((ArrayList) r26.b).addAll(r28.a);
        Object r32 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r32);
        ((mz0.i) ((f80.a) r32)).w3("connection_invited", r26.a, r26.b);
        goto L93
    L86:
        if (r24.length() == 0) goto L89;
        r25 = false;
        goto L90
    L83:
        r24 = null;
        goto L84
    L75:
        if (r23.length() == 0) goto L78;
        r116 = false;
        goto L79
    L70:
        r115 = null;
        goto L71
    L66:
        r112 = null;
        goto L67
    L72:
        r23 = null;
        goto L73
    L54:
        if (r17.length() == 0) goto L57;
        r18 = false;
        goto L58
    L51:
        r17 = null;
        goto L52
    L48:
        r16 = null;
        goto L49
    L42:
        r14 = null;
    L38:
        r10 = "";
    L93:
        e6 r33 = r1.getInvite();
        if (r33 == null) goto L96;
        int r34 = r33.getInviteSource();
    L97:
        e6 r38 = r1.getInvite();
        if (r38 == null) goto L100;
        int r39 = r38.getBizType();
    L101:
        int r117 = r39;
        e6 r40 = r1.getInvite();
        if (r40 == null) goto L111;
        String r42 = r40.getGameAppId();
        if (r42 == null) goto L111;
        if ((!StringsKt.isBlank(r42)) != true) goto L111;
        e6 r4 = r1.getInvite();
        if (r4 == null) goto L110;
        String r43 = r4.getGameAppId();
    L112:
        getLaunchRecord().E = r43;
        int r44 = getLaunchRecord().g;
        IBattleLinkerInviteMessageExtra r45 = j6.a(r1);
        if (r45 == null) goto L115;
        int r118 = r45.getSwitchPlayMode();
    L116:
        g1 r119 = r1.getInvite();
        e6 r46 = r1.getInvite();
        if (r46 == null) goto L119;
        String r210 = r46.getBattleAttachedInfoStr();
    L120:
        d11.a r211 = new d11.a(r6, r44, r34, null, false, false, true, "matchAutoAgree", r118, null, r119, r210, 552);
        Intrinsics.checkNotNullParameter(r1, "$this$linkerIdExt");
        long r47 = r1.getLinkerId();
        long r48 = IRoomKtKt.getId(getMRoom());
        g1 r120 = r1.getInvite();
        if (r120 == null) goto L123;
        g1 r121 = r120;
        Intrinsics.checkNotNullParameter(r121, "$this$fromUid");
        String r212 = r121.get_fromUid();
    L124:
        g1 r49 = r1.getInvite();
        if (r49 == null) goto L127;
        g1 r50 = r49;
        Intrinsics.checkNotNullParameter(r50, "$this$secFromUid");
        String r213 = r50.get_secFromUid();
    L128:
        Boolean r214 = Boolean.FALSE;
        if (r43 != null) goto L131;
        String r310 = "";
    L132:
        e6 r52 = r1.getInvite();
        if (r52 == null) goto L135;
        String r311 = r52.getBattleAttachedInfoStr();
    L136:
        getLinkOutManager().h(new d11.g(7, r117, r47, r48, 1, r212, r213, r214, 0, r211, null, r310, r311, null, 9216), null);
        r37.invoke();
        return;
    L135:
        r311 = null;
        goto L136
    L131:
        r310 = r43;
        goto L132
    L127:
        r213 = null;
        goto L128
    L123:
        r212 = null;
        goto L124
    L119:
        r210 = null;
        goto L120
    L115:
        r118 = 0;
        goto L116
    L110:
        r43 = null;
    L111:
        r43 = com.bytedance.android.live.revlink.link.biz.service.i.h(this).g;
        goto L112
    L100:
        r39 = BizType.None.ordinal();
        goto L101
    L96:
        r34 = 0;
        goto L97
    L19:
        if (r6 == 6) goto L22;
        if (x.b(r6) == false) goto L26;
    L5:
        r6 = 0;
        goto L7
    }
}
