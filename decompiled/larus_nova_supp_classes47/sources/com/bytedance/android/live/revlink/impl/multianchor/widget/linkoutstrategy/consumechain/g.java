package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.TopBannerDetailsDataContext;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements a<i6>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public g(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(i6 r22, Function1<? super i6, Unit> r23, Function0 r24) {
        i6 r1 = r22;
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r23, "resolve");
        Intrinsics.checkNotNullParameter(r24, "reject");
        com.bytedance.android.live.revlink.impl.control.d r2 = com.bytedance.android.live.revlink.link.biz.service.i.e(this);
        String r3 = "";
        if (r2 == null) goto L12;
        e6 r4 = r1.getInvite();
        if (r4 == null) goto L10;
        v3 r5 = e21.e.b(r4);
        if (r5 == null) goto L10;
        String r6 = r5.getImprId();
        if (r6 == null) goto L10;
    L11:
        r2.setRequestId(r6);
    L10:
        r6 = "";
    L12:
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.d r7 = Hd();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "linkerMessage");
        u.a r8 = r7.getLaunchRecord();
        IBattleLinkerInviteMessageExtra r9 = j6.a(r1);
        View r10 = null;
        if (r9 == null) goto L51;
        r8.c = (int) r9.getMatchType();
        r8.q((int) r9.getInviteType());
        r8.k = r9.getInviteRoom();
        r8.z = (int) r9.getDuration();
        String r12 = r9.getTheme();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r8.A = r12;
        r8.p = r9.getInviteRoom();
        IRoom r13 = r9.getInviteRoom();
        if (r13 == null) goto L17;
        IBaseUser r14 = r13.getOwnerKt();
    L18:
        r8.o = r14;
        List r15 = r9.getCannotPkAnchorUidList();
        if (r15 == null) goto L21;
        List<String> r16 = CollectionsKt.toList(r15);
    L22:
        r8.B = r16;
        r8.C = r9.getSwitchPlayMode();
        r8.D = r9.getVoteSetting();
        List r17 = r9.getTagList();
        if (r17 == null) goto L25;
        r8.H.clear();
        r8.H.addAll(CollectionsKt.toList(r17));
    L25:
        IBattleConfigSetting r18 = r9.getBattleConfigSetting();
        if (r18 == null) goto L37;
        r8.M = r18;
        aa r19 = r18.getVoteData();
        if (r19 == null) goto L30;
        PkDoubleAnchorDataContext.d r110 = new PkDoubleAnchorDataContext.d(r19.getDurationTime(), r19, 4);
    L31:
        r8.J = r110;
        if (r18.getModType() != PkBaseDataContext.PKModType.BreakThrough.getType()) goto L34;
        boolean r111 = true;
    L35:
        r8.K = r111;
        goto L37
    L34:
        r111 = false;
        goto L35
    L30:
        r110 = null;
    L37:
        if (r8.c != 1) goto L51;
        String r112 = r9.getActivityName();
        if (r112 != null) goto L41;
    L44:
        boolean r113 = true;
    L45:
        if (r113 == true) goto L50;
        r8.s = true;
        String r20 = r9.getActivityName();
        if (r20 != null) goto L49;
        r20 = "";
    L49:
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r8.t = r20;
        goto L51
    L50:
        r8.s = false;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r8.t = "";
        goto L51
    L41:
        if (r112.length() == 0) goto L44;
        r113 = false;
        goto L45
    L21:
        r16 = null;
        goto L22
    L17:
        r14 = null;
    L51:
        g1 r25 = r1.getInvite();
        if (r25 == null) goto L54;
        g1 r26 = r25;
        Intrinsics.checkNotNullParameter(r26, "$this$fromUid");
        String r27 = r26.get_fromUid();
    L55:
        r8.q = r27;
        r8.u = false;
        Intrinsics.checkNotNullParameter(r1, "$this$linkerIdExt");
        r8.b = r1.getLinkerId();
        g1 r28 = r1.getInvite();
        if (r28 == null) goto L58;
        g1 r29 = r28;
        Intrinsics.checkNotNullParameter(r29, "$this$fromUid");
        String r30 = r29.get_fromUid();
    L59:
        r8.d = r30;
        IBattleLinkerInviteMessageExtra r32 = j6.a(r1);
        if (r32 == null) goto L62;
        int r33 = (int) r32.getInviteType();
    L63:
        r8.q(r33);
        IBaseUser r34 = r7.getMRoom().getOwnerKt();
        if (r34 == null) goto L66;
        String r35 = iz.a.a(r34);
    L67:
        r8.f = r35;
        e6 r36 = r1.getInvite();
        if (r36 == null) goto L70;
        boolean r37 = r36.getSupportMultiInvite();
    L71:
        r8.l = r37;
        e6 r38 = r1.getInvite();
        if (r38 != null) goto L74;
    L76:
        boolean r39 = false;
    L77:
        r8.m = r39;
        r8.v = r7.isLinkWithAudience();
        e6 r40 = r1.getInvite();
        if (r40 == null) goto L80;
        boolean r42 = r40.getInviterWithAudience();
    L81:
        r8.x = r42;
        e6 r43 = r1.getInvite();
        if (r43 == null) goto L86;
        j5 r44 = r43.getFromLinkMicInfo();
        if (r44 == null) goto L86;
        String r45 = r44.getInteractIdStr();
    L87:
        if (r45 != null) goto L89;
    L92:
        boolean r46 = true;
    L93:
        if (r46 == false) goto L101;
        e6 r47 = r1.getInvite();
        if (r47 == null) goto L107;
        j5 r48 = r47.getFromLinkMicInfo();
        if (r48 == null) goto L107;
        String r49 = String.valueOf(r48.getInteractId());
        if (r49 == null) goto L107;
    L108:
        r8.a = r49;
        jy0.b.c("rev_double_guest_linker_id", "handle receive invite set guestUserLinkerID: " + r7.getLaunchRecord().a, null, 4);
        com.bytedance.android.live.revlink.link.biz.service.i.s(this).f = true;
        com.bytedance.android.live.revlink.link.biz.service.i.s(this).g = true;
        com.bytedance.android.live.revlink.impl.pk.service.a r50 = com.bytedance.android.live.revlink.link.biz.service.i.N(this);
        if (r50 == null) goto L111;
        r50.f(AutoMatchSource.ReceiveMultiInviteWhenMatching);
    L111:
        Intrinsics.checkNotNullParameter(this, "$this$topBannerDetailsDataContext");
        TopBannerDetailsDataContext r52 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).e7();
        if (r52 == null) goto L118;
        com.bytedance.live.datacontext.n<TopBannerDetailsDataContext.b> r53 = r52.getUpdateGiftInfoService();
        if (r53 == null) goto L118;
        TopBannerDetailsDataContext.b r54 = (TopBannerDetailsDataContext.b) r53.getValue();
        if (r54 == null) goto L118;
        r54.dismissDialog();
    L118:
        AnchorRtcConnectManager r55 = getRtcConnectManager();
        if (r55 == null) goto L159;
        e6 r56 = r1.getInvite();
        Map<String, Boolean> r114 = r55.j.getAnchorWithAudienceMap();
        if (r56 == null) goto L144;
        Intrinsics.checkNotNullParameter(r56, "$this$inviterLinkerID");
        j5 r115 = r56.getFromLinkMicInfo();
        if (r115 == null) goto L125;
        String r116 = r115.getInteractIdStr();
    L126:
        if (r116 != null) goto L128;
    L131:
        boolean r117 = true;
    L132:
        if (r117 == false) goto L138;
        j5 r118 = r56.getFromLinkMicInfo();
        if (r118 == null) goto L144;
        String r119 = String.valueOf(r118.getInteractId());
        if (r119 == null) goto L144;
    L143:
        r3 = r119;
        goto L144
    L138:
        j5 r120 = r56.getFromLinkMicInfo();
        if (r120 == null) goto L144;
        r119 = r120.getInteractIdStr();
        if (r119 != null) goto L143;
    L128:
        if (r116.length() == 0) goto L131;
        r117 = false;
        goto L132
    L125:
        r116 = null;
    L144:
        if (r56 == null) goto L146;
        boolean r121 = r56.getInviterWithAudience();
    L147:
        r114.put(r3, Boolean.valueOf(r121));
        if (r56 == null) goto L159;
        if (r56.getInviteSource() == 2) goto L159;
        if (r55.i() == true) goto L159;
        r55.j.onReceiveInvite(r56);
        if (r55.j.enableFirstFrameOpt() == false) goto L159;
        r55.k(AnchorRtcConnectUtilsKt.b(r56.getMultiRtcInfo(), r56.getToRtcExtInfo()), "receiveInvite", r56.getBizType());
        goto L159
    L146:
        r121 = false;
    L159:
        UnexpectedFrameMonitor r57 = getUnexpectedFrameMonitor();
        if (r57 == null) goto L170;
        e6 r58 = r1.getInvite();
        if (r58 == null) goto L170;
        if (r58.getInviteSource() == 2) goto L170;
        if (y.b() == true) goto L170;
        r57.q(r58.getPreRtcInfo());
    L170:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r59 = com.bytedance.android.live.revlink.link.biz.service.i.K(this);
        if (r59 != null) goto L173;
    L177:
        com.bytedance.android.live.revlink.impl.service.internal.a r60 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r60 == null) goto L180;
        r10 = r60.Ii();
    L180:
        if (r10 == null) goto L189;
        gt1.d r62 = gt1.e.a(1, Boolean.FALSE, false, false, false, false, 0, false, false, null, 2044);
        ld.a r63 = ld.d.a();
        if (r63 == null) goto L186;
        NextLiveData r64 = r63.Y1();
        if (r64 == null) goto L186;
        r64.setValue(r62);
    L186:
        wq2.f r65 = ma1.a.a();
        if (r65 == null) goto L189;
        r65.S1(r62);
    L189:
        r23.invoke(r1);
        return;
    L173:
        if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(r59) != true) goto L177;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r66 = com.bytedance.android.live.revlink.link.biz.service.i.K(this);
        if (r66 == null) goto L177;
        r66.ni(0, "receiveInviteMsg");
    L107:
        r49 = "";
        goto L108
    L101:
        e6 r67 = r1.getInvite();
        if (r67 == null) goto L107;
        j5 r68 = r67.getFromLinkMicInfo();
        if (r68 == null) goto L107;
        r49 = r68.getInteractIdStr();
        if (r49 != null) goto L108;
    L89:
        if (r45.length() == 0) goto L92;
        r46 = false;
    L86:
        r45 = null;
        goto L87
    L80:
        r42 = false;
        goto L81
    L74:
        if (r38.getCurInviteNum() != 1) goto L76;
        r39 = true;
        goto L77
    L70:
        r37 = false;
        goto L71
    L66:
        r35 = null;
        goto L67
    L62:
        r33 = 0;
        goto L63
    L58:
        r30 = null;
        goto L59
    L54:
        r27 = null;
        goto L55
    }
}
