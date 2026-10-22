package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.f6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements a<i6>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public d(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(i6 r33, Function1<? super i6, Unit> r34, Function0 r35) {
        i6 r1 = r33;
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r34, "resolve");
        Intrinsics.checkNotNullParameter(r35, "reject");
        if (com.bytedance.android.live.revenuelink.connect.b.a(r1) == true) goto L5;
        r34.invoke(r1);
        return;
    L5:
        IBattleLinkerInviteMessageExtra r0 = j6.a(r1);
        if (r0 == null) goto L8;
        int r5 = (int) r0.getMatchType();
    L9:
        e6 r2 = r1.getInvite();
        if (r2 == null) goto L12;
        int r7 = r2.getInviteSource();
    L13:
        IBattleLinkerInviteMessageExtra r3 = j6.a(r1);
        if (r3 == null) goto L16;
        int r6 = (int) r3.getInviteType();
    L17:
        e6 r4 = r1.getInvite();
        if (r4 == null) goto L20;
        int r8 = r4.getBizType();
    L21:
        getLaunchRecord().c = r5;
        getLaunchRecord().q(r6);
        jy0.b.c("ttlive_anchor_link", "receive MultiAnchorInvite matchType=" + r5 + " inviteType=" + r6, null, 4);
        if (r5 != 4) goto L24;
    L38:
        Intrinsics.checkNotNullParameter(this, "$this$multiMatchMonitor");
        k21.a r9 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).P7();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "linkerMessage");
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("match_type", Integer.valueOf(r5));
        r10.put("msg_id", String.valueOf(qj.a(r1)));
        Intrinsics.checkNotNullParameter(r1, "$this$linkerIdExt");
        r10.put("msg_linker_id", Long.valueOf(r1.getLinkerId()));
        g1 r12 = r1.getInvite();
        if (r12 == null) goto L49;
        g1 r13 = r12;
        Intrinsics.checkNotNullParameter(r13, "$this$fromUid");
        String r14 = r13.get_fromUid();
        String r15 = "";
        if (r14 != null) goto L43;
        r14 = "";
    L43:
        r10.put("from_user", r14);
        r10.put("from_room", Long.valueOf(r12.getFromRoomId()));
        List r16 = f6.b(r12);
        if (r16 == null) goto L48;
        List r17 = CollectionsKt.toList(r16);
        if (r17 == null) goto L48;
        r15 = x.g(r17);
    L48:
        r10.put("inviterUsers", r15);
    L49:
        r9.b(r10);
        r9.f(r10);
        int r18 = v.a;
        v.b("ttlive_anchor_link_match", "receive_multi_auto_invite: " + r10, null);
        r9.n("receive_multi_auto_invite", r10);
        com.bytedance.android.live.revlink.impl.multianchor.match.a r19 = com.bytedance.android.live.revlink.link.biz.service.i.K(this);
        if (r19 == null) goto L52;
        r19.fl(r5, r1);
    L52:
        com.bytedance.android.live.revenuelink.connect.n r20 = getLinkOutManager();
        Intrinsics.checkNotNullParameter(r1, "$this$linkerIdExt");
        long r110 = r1.getLinkerId();
        long r22 = IRoomKtKt.getId(getMRoom());
        g1 r23 = r1.getInvite();
        if (r23 == null) goto L55;
        g1 r24 = r23;
        Intrinsics.checkNotNullParameter(r24, "$this$fromUid");
        String r26 = r24.get_fromUid();
    L56:
        g1 r25 = r1.getInvite();
        if (r25 == null) goto L59;
        g1 r27 = r25;
        Intrinsics.checkNotNullParameter(r27, "$this$secFromUid");
        String r28 = r27.get_secFromUid();
    L60:
        Boolean r29 = Boolean.FALSE;
        g1 r210 = r1.getInvite();
        e6 r30 = r1.getInvite();
        if (r30 == null) goto L63;
        String r211 = r30.getBattleAttachedInfoStr();
    L64:
        d11.a r32 = new d11.a(r5, r6, r7, null, false, true, true, "matchAutoAgree", 0, null, r210, r211, 776);
        e6 r36 = r1.getInvite();
        if (r36 == null) goto L67;
        String r37 = r36.getBattleAttachedInfoStr();
    L68:
        r20.h(new d11.g(7, r8, r110, r22, 1, r26, r28, r29, 0, r32, null, null, r37, null, 11264), null);
        r35.invoke();
        return;
    L67:
        r37 = null;
        goto L68
    L63:
        r211 = null;
        goto L64
    L59:
        r28 = null;
        goto L60
    L55:
        r26 = null;
        goto L56
    L24:
        if (r5 == 6) goto L38;
        if (x.b(r5) == true) goto L38;
        com.bytedance.android.live.revlink.impl.multianchor.service.c r38 = com.bytedance.android.live.revlink.link.biz.service.i.D(this);
        if (r38 == null) goto L31;
        r38.Bp();
    L31:
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r39 = getLinkDialogService();
        if (r39 == null) goto L34;
        r39.d(r1);
    L34:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r40 = com.bytedance.android.live.revlink.link.biz.service.i.K(this);
        if (r40 == null) goto L37;
        r40.ni(0, "receiveInviteMsg");
    L37:
        r35.invoke();
        return;
    L20:
        r8 = BizType.None.ordinal();
        goto L21
    L16:
        r6 = 0;
        goto L17
    L12:
        r7 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }
}
