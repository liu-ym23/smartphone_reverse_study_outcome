package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.r5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q implements a<r>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public q(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(r r17, Function1<? super r, Unit> r18, Function0 r19) {
        r r1 = r17;
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r18, "resolve");
        Intrinsics.checkNotNullParameter(r19, "reject");
        d11.g r4 = r1.a;
        q5 r5 = r1.b;
        long r6 = r1.c;
        v r8 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        int r9 = r4.e;
        d11.a r10 = r4.j;
        i97.a r12 = i97.a.a;
        long r13 = System.currentTimeMillis() - r6;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r10, "replyParams");
        Intrinsics.checkNotNullParameter(r5, "replyResult");
        JSONObject r14 = new JSONObject();
        int r15 = y50.b.a;
        y50.b.a.d(r14, "reply_params", r10.toString());
        y50.b.a.b(r14, "invite_type", r10.b);
        y50.b.a.b(r14, "invite_source", r10.c);
        y50.b.a.b(r14, "match_type", r10.a);
        y50.b.a.d(r14, "req_from", r10.h);
        y50.b.a.b(r14, "reply_status", r9);
        y50.b.a.d(r14, "reply_link_id", r5.getLinkMicIdStr());
        b7 r3 = r5.a(r5);
        com.bytedance.android.live.revenuelink.rtc.p r16 = null;
        if (r3 == null) goto L5;
        String r7 = c7.a(r3);
    L6:
        y50.b.a.d(r14, "multi_channel_info", r7);
        b2 r20 = r5.getPreRtcInfo();
        if (r20 == null) goto L9;
        String r22 = c2.a(r20);
    L10:
        y50.b.a.d(r14, "pre_rtc_info", r22);
        List r23 = r5.getLinkUsers();
        if (r23 == null) goto L13;
        String r24 = i11.a.d(r23);
    L14:
        y50.b.a.d(r14, "link_users", r24);
        r8.c(r14);
        r8.E("anchor_reply_success", r13, r14);
        d31.f r25 = com.bytedance.android.live.revlink.link.biz.service.i.b0(this);
        int r26 = d31.a.m;
        r25.e("linkmic/reply/", d31.a.C0230a.c(r4), com.bytedance.android.live.revlink.impl.utils.t.a(r6));
        AnchorRtcConnectManager r27 = getRtcConnectManager();
        if (r27 == null) goto L38;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "replyResult");
        if (r4.j.f == true) goto L38;
        if (r27.i() == true) goto L38;
        if (r4.e != 1) goto L37;
        r27.c("onReplySuccess");
        if (r4.a != 1) goto L38;
        if (r5.getSwitchToScene() != 7) goto L38;
        com.bytedance.android.live.revenuelink.rtc.i r2 = r27.g();
        if (r2 != null) goto L31;
    L33:
        AnchorRtcConnectModel r28 = r27.j;
        com.bytedance.android.live.revenuelink.rtc.i r29 = r27.g();
        if (r29 == null) goto L36;
        r16 = r29.L();
    L36:
        r28.onReplySuccess(r5, r16);
        goto L38
    L31:
        if (r2.isEngineOn() != true) goto L33;
        r27.e.a();
        goto L33
    L37:
        r27.l("reject", true);
    L38:
        UnexpectedFrameMonitor r30 = getUnexpectedFrameMonitor();
        if (r30 == null) goto L52;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "replyResult");
        if (r4.j.f == true) goto L52;
        if (y.b() == true) goto L52;
        if (r4.e != 1) goto L52;
        if (r4.a != 1) goto L52;
        if (r5.getSwitchToScene() != 7) goto L52;
        r30.q(r5.getPreRtcInfo());
    L52:
        int r32 = r4.e;
        if (r32 != 4) goto L55;
        r19.invoke();
        return;
    L55:
        if (r32 == 4) goto L59;
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r33 = getLinkDialogService();
        if (r33 == null) goto L59;
        r33.c();
    L59:
        r18.invoke(r1);
        return;
    L13:
        r24 = null;
        goto L14
    L9:
        r22 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
