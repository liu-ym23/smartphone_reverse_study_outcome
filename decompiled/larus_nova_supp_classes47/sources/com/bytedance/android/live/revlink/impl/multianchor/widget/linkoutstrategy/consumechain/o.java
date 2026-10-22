package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o implements a<j>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public o(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(j r10, Function1<? super j, Unit> r12, Function0 r13) {
        j r14 = r10;
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        i6 r0 = r14.a;
        v r1 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, Constants.OperatorKey.MSG);
        JSONObject r2 = new JSONObject();
        k6 r3 = r0.getReply();
        if (r3 == null) goto L29;
        int r5 = y50.b.a;
        y50.b.a.c(r2, "reply_status", r3.getReplyStatus());
        j5 r6 = r3.getFromLinkmicInfo();
        if (r6 == null) goto L7;
        String r7 = r6.getInteractIdStr();
    L8:
        y50.b.a.d(r2, "interact_id", r7);
        String r8 = r3.getFromUid();
        String r9 = "";
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        y50.b.a.d(r2, "from_user", r8);
        y50.b.a.c(r2, "from_room", r3.getFromRoomId());
        y50.b.a.c(r2, "match_type", r3.getMatchType());
        String r15 = r3.getToUid();
        if (r15 == null) goto L15;
        r9 = r15;
    L15:
        y50.b.a.d(r2, "to_user", r9);
        b7 r16 = r3.getMultiChannelInfo();
        if (r16 == null) goto L18;
        String r17 = c7.a(r16);
    L19:
        y50.b.a.d(r2, "multi_channel_info", r17);
        b2 r18 = r3.getPreRtcInfo();
        if (r18 == null) goto L23;
        String r19 = c2.a(r18);
        if (r19 == null) goto L23;
    L24:
        y50.b.a.d(r2, "pre_rtc_info", r19);
        y50.b.a.d(r2, "ui_layout", ef2.a.c(r3.getLayoutInfo()));
        List r20 = r3.getLinkUsers();
        if (r20 == null) goto L27;
        String r22 = i11.a.d(r20);
    L28:
        y50.b.a.d(r2, "link_users", r22);
        y50.b.a.c(r2, Constants.Keys.VERSION, r3.getVersion());
        y50.b.a.b(r2, "msg_multi_pk_mode", r3.getMultiPkMode());
        goto L29
    L27:
        r22 = null;
    L23:
        r19 = "null";
        goto L24
    L18:
        r17 = null;
        goto L19
    L7:
        r7 = null;
    L29:
        v.m(r0, r2);
        r1.c(r2);
        r1.I("receive_reply_msg", r2, false);
        Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
        if (((int) r0.getScene()) == 7) goto L36;
        Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
        if (((int) r0.getScene()) == 2) goto L36;
        Intrinsics.checkNotNullParameter(r0, "$this$sceneExt");
        if (((int) r0.getScene()) == 1) goto L36;
        r13.invoke();
        return;
    L36:
        long r4 = getLaunchRecord().b;
        Intrinsics.checkNotNullParameter(r0, "$this$linkerIdExt");
        if (r4 == r0.getLinkerId()) goto L40;
        com.bytedance.android.live.revlink.link.biz.service.i.H(this).t(r0, "channel_id_dismatch", Long.valueOf(getLaunchRecord().b));
        r13.invoke();
        return;
    L40:
        if (r0.getReply() != null) goto L42;
        r13.invoke();
        return;
    L42:
        k6 r23 = r0.getReply();
        if (r23 != null) goto L45;
    L60:
        k6 r24 = r0.getReply();
        if (r24 != null) goto L63;
    L77:
        r12.invoke(r14);
        return;
    L63:
        if (((int) r24.getReplyStatus()) != 1) goto L77;
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(this).c() == true) goto L77;
        k6 r25 = r0.getReply();
        if (r25 == null) goto L69;
        String r26 = r25.getFromUid();
    L70:
        IBaseUser r27 = getMRoom().getOwnerKt();
        if (r27 == null) goto L73;
        String r28 = iz.a.a(r27);
    L75:
        if ((!Intrinsics.areEqual(r26, r28)) == false) goto L77;
        com.bytedance.android.live.revlink.link.biz.service.i.H(this).t(r0, "from_uid_mismatch", null);
        r13.invoke();
        return;
    L73:
        r28 = null;
        goto L75
    L69:
        r26 = null;
        goto L70
    L45:
        if (((int) r23.getReplyStatus()) != 1) goto L60;
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(this).c() == false) goto L60;
        v51.b r29 = (v51.b) getStreamInteractScopeFn().invoke();
        if (r29 == null) goto L60;
        AnchorUILayoutManager r30 = com.bytedance.android.live.revlink.link.utils.a.b(r29);
        if (r30 == null) goto L60;
        k6 r32 = r0.getReply();
        if (r32 == null) goto L58;
        com.bytedance.android.livesdk.link.model.m r33 = r32.getLayoutInfo();
        if (r33 == null) goto L58;
        Map r34 = r33.getLayoutDetails();
        if (r34 == null) goto L58;
    L59:
        r30.a(new com.bytedance.android.live.revlink.link.core.service.o(r34), "online_receive_reply");
    L58:
        r34 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        goto L59
    }
}
