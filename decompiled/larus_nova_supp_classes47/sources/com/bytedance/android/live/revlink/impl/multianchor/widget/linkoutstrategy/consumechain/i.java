package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.launchcontext.RevLinkSwitchExtraContext;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.AnchorLinkInitType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.s;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements a<r>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public i(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(r r32, Function1<? super r, Unit> r33, Function0 r34) {
        r r1 = r32;
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r33, "resolve");
        Intrinsics.checkNotNullParameter(r34, "reject");
        d11.g r2 = r1.a;
        q5 r3 = r1.b;
        long r4 = r1.c;
        getLaunchRecord().b(r3, r2.j);
        List r5 = r3.getLinkUsers();
        d7 r7 = null;
        if (r5 != null) goto L5;
    L22:
        t r6 = getConnectMonitor();
        String r8 = "";
        if (r6 == null) goto L32;
        getConnectMonitor().getClass();
        String r9 = t.g(r4, r3);
        if (r9 != null) goto L27;
        r9 = "";
    L27:
        Intrinsics.checkNotNullParameter(r9, "bindID");
        s r10 = r6.f();
        if (r10 == null) goto L30;
        com.bytedance.android.live.revlink.impl.multianchor.utils.g r12 = r10.b(r9);
    L31:
        com.bytedance.android.live.revlink.impl.multianchor.utils.g r25 = r12;
    L33:
        Intrinsics.checkNotNullParameter(this, "$this$anchorConnectionContextObj");
        f21.b r13 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).Rb();
        d11.a r14 = r2.j;
        AnchorRtcConnectModel r15 = getRtcConnectModel();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "replyResult");
        Intrinsics.checkNotNullParameter(r14, "replyParams");
        Integer r16 = r2.i;
        boolean r17 = false;
        if (r16 == null) goto L36;
        int r18 = r16.intValue();
    L37:
        com.bytedance.android.livesdk.link.model.bridge.p r19 = r14.d;
        if (r19 == null) goto L40;
        IBattleConfigSetting r110 = (IBattleConfigSetting) r19.castTo(IBattleConfigSetting.class);
    L41:
        if (r15 != null) goto L43;
    L45:
        boolean r111 = false;
    L46:
        f21.a.C0236a r22 = new f21.a.C0236a(r18, r111, r110, 0, null, 56);
        boolean r20 = e21.a.a(r3.getToBizType());
        if (x.b(r14.a) == true) goto L58;
        int r112 = r14.a;
        if (r112 != 1) goto L51;
    L54:
        boolean r113 = true;
    L55:
        if (r113 == true) goto L58;
        boolean r114 = false;
    L59:
        if (r114 == false) goto L61;
        String r115 = "random";
    L62:
        if (r20 == false) goto L64;
        String r23 = "pk";
    L65:
        String r24 = r115 + '_' + r23;
        com.bytedance.android.live.revlink.impl.global.c r116 = r13.a;
        AnchorLinkInitType r117 = AnchorLinkInitType.REPLY_AGREE_API;
        int r118 = r14.a;
        if (r116 == null) goto L68;
        LinkCrossRoomDataHolder r26 = r116.getLinkCrossRoomDataHolder();
    L69:
        if (r26 == null) goto L71;
        r8 = r26.h();
    L71:
        String r119 = r8;
        boolean r27 = r14.f;
        if (r14.c <= 0) goto L74;
        String r28 = "pk_banner";
    L75:
        String r29 = r28;
        if (r15 == null) goto L78;
        v1 r210 = r15.getMultiRtcInfo();
    L79:
        if (r15 == null) goto L81;
        r7 = r15.getMultiLiveCoreInfo();
    L81:
        d7 r211 = r7;
        com.bytedance.android.livesdk.link.model.m r212 = r3.getLayoutInfo();
        if (r2.a == 1) goto L84;
    L86:
        setConnectionContext(new f21.a(r116, r117, r118, false, r119, r17, false, false, r27, 3, r24, r29, r22, r211, r210, r25, 0, r212, 1311328));
        if (r3.getToBizType() != BizType.PK.ordinal()) goto L89;
    L92:
        int r30 = 4;
    L93:
        getLaunchRecord().O = r3.getToBizType();
        getLaunchRecord().P = r3.getEventTrackingInfo();
        setLaunchParameters(getLaunchRecord().r());
        com.bytedance.android.live.revlink.impl.service.internal.a r35 = com.bytedance.android.live.revlink.link.biz.service.i.p(this);
        if (r35 == null) goto L97;
        int r36 = RevLinkSwitchExtraContext.g;
        u r37 = getLaunchParameters();
        f21.a r38 = getConnectionContext();
        Intrinsics.checkNotNullParameter(this, "$this$clientAttachedInfoObj");
        e21.b r39 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).getClientAttachedInfoObj();
        String r40 = r2.k;
        r39.getClass();
        r35.Gp(r30, RevLinkSwitchExtraContext.Companion.a(r37, r38, e21.b.c(r40), e21.c.c(p0.Companion, r2.m), r3.getEventTrackingInfo()));
        return;
    L97:
        return;
    L89:
        if (r3.getToBizType() == BizType.OpenGame.ordinal()) goto L92;
        r30 = 64;
        goto L93
    L84:
        if (r3.getSwitchToScene() != 7) goto L86;
        r17 = true;
        goto L86
    L78:
        r210 = null;
        goto L79
    L74:
        r28 = "link_banner";
        goto L75
    L68:
        r26 = null;
        goto L69
    L64:
        r23 = "link";
        goto L65
    L61:
        r115 = "manual";
        goto L62
    L51:
        if (r112 == 3) goto L54;
        r113 = false;
    L58:
        r114 = true;
        goto L59
    L43:
        if (r15.enableFirstFrameOpt() != true) goto L45;
        r111 = true;
        goto L46
    L40:
        r110 = null;
        goto L41
    L36:
        r18 = 0;
        goto L37
    L30:
        r12 = null;
        goto L31
    L32:
        r25 = null;
        goto L33
    L5:
        if ((!r5.isEmpty()) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L22;
        y41.f r42 = y41.f.N;
        r42.getClass();
        if (((Boolean) y41.f.h.getValue(r42, y41.f.a[6])).booleanValue() == false) goto L22;
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(this).c() == true) goto L22;
        i11.b r43 = getMLinkUserCenter();
        if (r43 == null) goto L22;
        List<? extends com.bytedance.android.livesdk.link.model.p> r44 = CollectionsKt.toList(r5);
        Intrinsics.checkNotNullParameter(r3, "$this$listVersion");
        long r120 = 0;
        if (r3.getVersion() <= 0) goto L18;
        r120 = r3.getVersion();
    L21:
        r43.p(r44, "replySuccess", Long.valueOf(r120));
        goto L22
    L18:
        b2 r45 = r3.getPreRtcInfo();
        if (r45 == null) goto L21;
        r120 = r45.getVersion();
        goto L21
    }
}
