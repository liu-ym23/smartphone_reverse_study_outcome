package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiInviteLogDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkInviteLogDataContext;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import dq2.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements a<j>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public k(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v90 */
    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(j r42, Function1<? super j, Unit> r43, Function0 r44) {
        j r1 = r42;
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r43, "resolve");
        Intrinsics.checkNotNullParameter(r44, "reject");
        i6 r3 = r1.a;
        int r5 = (int) i1.c(r3);
        AnchorRtcConnectManager r4 = getRtcConnectManager();
        if (r4 == null) goto L40;
        Intrinsics.checkNotNullParameter(r3, "linkerMessage");
        k6 r12 = r3.getReply();
        if (r12 == null) goto L40;
        if (r4.i() == true) goto L40;
        if (((int) r12.getReplyStatus()) != 1) goto L28;
        r4.c("onReceiveReplyOrPermit");
        Intrinsics.checkNotNullParameter(r3, "$this$typeExt");
        if (((int) r3.getType2()) != 5) goto L40;
        Intrinsics.checkNotNullParameter(r3, "$this$sceneExt");
        if (((int) r3.getScene()) != 1) goto L40;
        if (r12.getSwitchToScene() != 7) goto L40;
        com.bytedance.android.live.revenuelink.rtc.i r13 = r4.g();
        if (r13 != null) goto L21;
    L23:
        AnchorRtcConnectModel r14 = r4.j;
        com.bytedance.android.live.revenuelink.rtc.i r6 = r4.g();
        if (r6 == null) goto L26;
        com.bytedance.android.live.revenuelink.rtc.p r7 = r6.L();
    L27:
        r14.onReceiveReply(r12, r7);
        goto L40
    L26:
        r7 = null;
        goto L27
    L21:
        if (r13.isEngineOn() != true) goto L23;
        r4.e.a();
        goto L23
    L28:
        com.bytedance.android.live.revlink.impl.global.c r15 = r4.m;
        if (r15 == null) goto L39;
        com.bytedance.android.live.revenuelink.connect.g r16 = r15.getAnchorConnectUtils();
        if (r16 == null) goto L39;
        if (r16.u1() != true) goto L39;
        StringBuilder r17 = new StringBuilder("receive reject from ");
        r17.append(r12.getToUid());
        r17.append(" but still have invitee ");
        LiveData<ey.f> r8 = r4.m.getAnchorConnectUtils().connectState();
        if (r8 == null) goto L37;
        ey.f r9 = (ey.f) r8.getValue();
    L38:
        r17.append(r9);
        jy0.b.f("ttlive_anchor_connect_mgr", r17.toString(), null, 4);
        goto L40
    L37:
        r9 = null;
    L39:
        r4.l("receiveReject", true);
    L40:
        UnexpectedFrameMonitor r10 = getUnexpectedFrameMonitor();
        if (r10 == null) goto L57;
        Intrinsics.checkNotNullParameter(r3, "linkerMessage");
        k6 r18 = r3.getReply();
        if (r18 == null) goto L57;
        if (y.b() == true) goto L57;
        String r45 = "linkerMessage";
        if (((int) r18.getReplyStatus()) != 1) goto L59;
        if (r3.getMType() != 5) goto L59;
        if (r3.getScene() != 1) goto L59;
        if (r18.getSwitchToScene() != 7) goto L59;
        r10.q(r18.getPreRtcInfo());
    L59:
        if (getLaunchRecord().c != 7) goto L61;
    L72:
        i11.b r19 = getMLinkUserCenter();
        if (r19 == null) goto L76;
        List<IBaseUser> r110 = r19.getInviteeList();
        if (r110 == null) goto L76;
    L77:
        Iterator<IBaseUser> r111 = r110.iterator();
    L79:
        if (r111.hasNext() == false) goto L88;
        IBaseUser r112 = r111.next();
        String r113 = iz.a.a(r112);
        k6 r114 = r3.getReply();
        if (r114 == null) goto L83;
        String r115 = r114.getToUid();
    L85:
        if (Intrinsics.areEqual(r113, r115) == false) goto L79;
    L89:
        if (r19 == null) goto L92;
        List<IBaseUser> r116 = r19.n();
        if (r116 == null) goto L92;
    L93:
        Iterator<IBaseUser> r117 = r116.iterator();
    L95:
        if (r117.hasNext() == false) goto L104;
        IBaseUser r118 = r117.next();
        String r119 = iz.a.a(r118);
        k6 r120 = r3.getReply();
        if (r120 == null) goto L99;
        String r20 = r120.getToUid();
    L101:
        if (Intrinsics.areEqual(r119, r20) == false) goto L95;
    L105:
        if (r5 != 5) goto L115;
        if (r112 == null) goto L119;
        if (r19 == null) goto L109;
        r19.r(r112);
    L109:
        MultiLinkAnchorControlContext r22 = com.bytedance.android.live.revlink.link.biz.service.i.G(this);
        if (r22 == null) goto L119;
        MultiInviteLogDataContext r23 = r22.getInviteLogContext();
        if (r23 == null) goto L119;
        r23.a(iz.a.a(r112));
    L119:
        k6 r24 = r3.getReply();
        if (r24 == null) goto L122;
        ?? r25 = r24.getBizJoinChannel();
    L123:
        com.bytedance.android.live.revlink.link.biz.service.i.s(this).h = r25;
        LiveFullLinkPKMonitor r26 = com.bytedance.android.live.revlink.link.biz.service.i.s(this);
        boolean r27 = isLinkWithAudience();
        boolean r121 = getLaunchRecord().x;
        boolean r122 = getLaunchRecord().x;
        r26.getClass();
        Intrinsics.checkNotNullParameter("onReceiveReply", "type");
        JSONObject r123 = new JSONObject();
        LiveTracingMonitorKt.EventModule r124 = LiveTracingMonitorKt.EventModule.PK;
        r26.c(r123, r124);
        int r125 = y50.b.a;
        y50.b.a.b(r123, "self_has_audience", r27 ? 1 : 0);
        y50.b.a.b(r123, "inviter_has_audience", r121 ? 1 : 0);
        y50.b.a.b(r123, "replyer_has_audience", r122 ? 1 : 0);
        y50.b.a.b(r123, "is_pk_opt_link", r25);
        y50.b.a.b(r123, "is_biz_opt_link", 1);
        y50.b.a.d(r123, "type", "onReceiveReply");
        LiveTracingMonitorKt r2 = LiveTracingMonitorKt.a;
        LiveTracingMonitorKt.EventType r28 = LiveTracingMonitorKt.EventType.SERVER_API_CALL;
        Intrinsics.checkNotNullParameter(r2, "$this$monitorEvent");
        Intrinsics.checkNotNullParameter("ttlive_interact_server_api_call", "serviceName");
        Intrinsics.checkNotNullParameter(r124, "eventModule");
        Intrinsics.checkNotNullParameter(r28, "eventType");
        Intrinsics.checkNotNullParameter("", "statusMsg");
        Intrinsics.checkNotNullParameter(r124, "$this$toReal");
        int r126 = y50.k.a[r124.ordinal()];
        if (r126 == 1) goto L135;
        if (r126 != 2) goto L127;
        LiveTracingMonitor.EventModule r127 = LiveTracingMonitor.EventModule.MULTI_LINKER;
    L136:
        LiveTracingMonitor.EventModule r128 = r127;
        Intrinsics.checkNotNullParameter(r28, "$this$toReal");
        int r29 = y50.k.b[r28.ordinal()];
        if (r29 == 1) goto L151;
        if (r29 != 2) goto L140;
        LiveTracingMonitor.EventType r30 = LiveTracingMonitor.EventType.SERVER_API_CALL;
    L152:
        LiveTracingMonitor.c("ttlive_interact_server_api_call", r128, r30, 0, "", null, null, r123);
        HashMap r32 = new HashMap();
        r32.put("self_has_audience", Integer.valueOf(r27 ? 1 : 0));
        r32.put("inviter_has_audience", Integer.valueOf(r121 ? 1 : 0));
        r32.put("replyer_has_audience", Integer.valueOf(r122 ? 1 : 0));
        r32.put("is_pk_opt_link", Integer.valueOf(r25));
        r32.put("type", "onReceiveReply");
        com.bytedance.android.live.revenuelink.f r129 = r26.i();
        if (r129 == null) goto L155;
        r129.c0("ttlive_interact_server_api_call", r124, 0, "", r32, r123);
    L155:
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.d r0 = Hd();
        r0.getClass();
        i6 r33 = r3;
        Intrinsics.checkNotNullParameter(r33, r45);
        k6 r34 = r33.getReply();
        if (r34 == null) goto L158;
        int r35 = r34.getToBizType();
    L159:
        r0.getLaunchRecord().O = r35;
        k6 r36 = r33.getReply();
        if (r36 == null) goto L170;
        b7 r37 = r36.getMultiChannelInfo();
        if (r37 == null) goto L170;
        if (r37.getUseMultiChannel() == false) goto L170;
        Map r38 = r37.getChannelMap();
        if (r38 == null) goto L170;
        if ((!r38.isEmpty()) != true) goto L170;
        r0.getLaunchRecord().e = r37;
    L170:
        u.a r39 = r0.getLaunchRecord();
        k6 r40 = r33.getReply();
        if (r40 == null) goto L187;
        j5 r46 = r40.getFromLinkmicInfo();
        if (r46 == null) goto L187;
        Intrinsics.checkNotNullParameter(r46, "$this$getLinkerID");
        String r47 = r46.getInteractIdStr();
        if (r47 != null) goto L177;
    L180:
        boolean r48 = true;
    L181:
        if (r48 == false) goto L183;
        String r49 = String.valueOf(r46.getInteractId());
    L186:
        if (r49 == null) goto L187;
    L188:
        r39.getClass();
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        r39.i = r49;
        u.a r50 = r0.getLaunchRecord();
        k6 r52 = r33.getReply();
        if (r52 == null) goto L193;
        j5 r53 = r52.getFromLinkmicInfo();
        if (r53 == null) goto L193;
        String r54 = r53.getRtcInfo();
    L194:
        r50.j = r54;
        u.a r55 = r0.getLaunchRecord();
        k6 r56 = r33.getReply();
        if (r56 == null) goto L199;
        j5 r57 = r56.getFromLinkmicInfo();
        if (r57 == null) goto L199;
        String r58 = r57.getInteractIdStr();
    L200:
        if (r58 != null) goto L202;
    L205:
        boolean r59 = true;
    L206:
        if (r59 == false) goto L214;
        k6 r60 = r33.getReply();
        if (r60 == null) goto L220;
        j5 r62 = r60.getToLinkmicInfo();
        if (r62 == null) goto L220;
        String r63 = String.valueOf(r62.getInteractId());
        if (r63 == null) goto L220;
    L221:
        r55.a = r63;
        jy0.b.c("rev_double_guest_linker_id", "handle receiveReply set guestUserLinkerID: " + r0.getLaunchRecord().a, null, 4);
        k6 r64 = r33.getReply();
        if (r64 != null) goto L224;
        Object r65 = "anchor_connect_status";
    L416:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r130 = com.bytedance.android.live.revlink.link.biz.service.i.B(this);
        k6 r210 = r33.getReply();
        if (r210 == null) goto L419;
        String r66 = r210.getToUid();
    L420:
        com.bytedance.android.live.revlink.impl.global.c r131 = r130.d;
        if (r131 == null) goto L423;
        MultiLinkAnchorControlContext r132 = r131.ua();
    L424:
        if (r132 == null) goto L508;
        MultiInviteLogDataContext r133 = r132.getInviteLogContext();
        if (r133 == null) goto L508;
        d11.d r134 = (d11.d) ((Map) r133.b.getValue()).get(r66);
        if (r134 == null) goto L508;
        com.bytedance.android.live.revlink.impl.global.c r135 = r130.d;
        if (r135 == null) goto L433;
        MultiLinkAnchorControlContext r136 = r135.ua();
    L434:
        if (r136 == null) goto L438;
        MultiInviteLogDataContext r137 = r136.getInviteLogContext();
        if (r137 == null) goto L438;
        IRivalExtraInfo r67 = (IRivalExtraInfo) ((Map) r137.a.getValue()).get(r66);
    L439:
        int r138 = UserListInviteType.a;
        IRivalExtraInfo r211 = r67;
        String r139 = UserListInviteType.a(r134.d, null);
        IRoomBase r68 = r134.h;
        LinkedHashMap r69 = new LinkedHashMap();
        d31.d r310 = r130.m();
        if (r310 == null) goto L445;
        String r311 = r310.a();
        if (r311 == null) goto L445;
        String r70 = r311;
    L446:
        r69.put(r65, r70);
        r69.put("connection_type", com.bytedance.android.live.revlink.impl.utils.f.a(7));
        if (r68 == null) goto L452;
        IBaseUser r72 = r68.getOwnerKt();
        if (r72 == null) goto L452;
        String r73 = r72.getIdString();
        if (r73 == null) goto L452;
    L453:
        r69.put("invitee_id", r73);
        if (r68 == null) goto L456;
        Long r74 = Long.valueOf(IRoomKtKt.getId(r68));
    L457:
        r69.put("invitee_room_id", String.valueOf(r74));
        r69.put("invitee_status", DataType.FALSE);
        r69.put("invitee_list", r139);
        com.bytedance.android.live.revlink.impl.global.c r75 = r130.d;
        if (r75 == null) goto L460;
        e21.b r76 = r75.getClientAttachedInfoObj();
    L461:
        if (r76 == null) goto L463;
        v3 r77 = e21.b.c(r134.y);
    L464:
        if (r77 == null) goto L467;
        String r78 = r77.getImprId();
        if (r78 == null) goto L467;
    L468:
        com.bytedance.android.live.revlink.impl.global.c r79 = r130.d;
        if (r79 == null) goto L471;
        com.bytedance.android.live.revlink.impl.control.d r80 = r79.Rc();
    L472:
        if (r80 == null) goto L474;
        r80.setRequestId(r78);
    L474:
        r69.put("request_id", r78);
        LinkCrossRoomDataHolder r82 = r130.f();
        if (r82 == null) goto L477;
        Long r140 = Long.valueOf(r82.c());
    L478:
        r69.put("channel_id", String.valueOf(r140));
        r69.put("is_oncemore", DataType.FALSE);
        r69.put("anchor_connection_type", "invite");
        r69.put("from_room_status", "live");
        r69.put("connection_sub_type", "");
        r69.put("room_status", "live");
        r69.put("invitee_connection_status", "live");
        r69.put("support_multi_invite", DataType.FALSE);
        r69.put("is_random_match", DataType.FALSE);
        r69.put("invite_type", "anchor");
        d31.d r83 = r130.m();
        if (r83 == null) goto L482;
        String r84 = r83.a();
        if (r84 == null) goto L482;
    L483:
        r69.put(r65, r84);
        r69.put("invitee_connect_cnt", DataType.FALSE);
        r69.put("invitee_room_status", "live");
        r69.put("audience_connect_cnt", DataType.FALSE);
        if (r211 == null) goto L491;
        d6 r85 = r211.getLinkerInfo();
        if (r85 == null) goto L491;
        List r86 = r85.getLinkedUserInfos();
        if (r86 == null) goto L491;
        r69.put("connection_sub_type", "manual_nlink");
        r69.put("invitee_connect_cnt", String.valueOf(r86.size()));
        r69.put("invitee_room_status", "connection");
    L491:
        r69.put("npk_link_type", "single");
        r69.put("list_num", String.valueOf(r134.v + 1));
        int r87 = r134.d;
        if (r87 != 1) goto L494;
    L504:
        mz0.n r88 = new mz0.n();
        mz0.o r89 = new mz0.o(r88.a);
        r89.b(r69);
        e21.e.d(r89, r77);
        mz0.m r90 = new mz0.m();
        LinkCrossRoomDataHolder r92 = r130.f();
        if (r92 == null) goto L507;
        r92.a(r90);
    L507:
        r90.b(LogCommon.ROOM);
        ((ArrayList) r88.b).addAll(r90.a);
        cy0.e.a.getClass();
        cy0.j r93 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r94 = com.bytedance.android.scope.m.b(r93).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r94);
        ((mz0.i) ((f80.a) r94)).w3("livesdk_connection_invite_result", r88.a, r88.b);
        goto L508
    L494:
        if (r87 == 2) goto L504;
        if (r87 == 3) goto L504;
        if (r87 == 4) goto L504;
        if (r87 == 9) goto L504;
        if (r87 == 105) goto L504;
    L482:
        r84 = "";
        goto L483
    L477:
        r140 = null;
        goto L478
    L471:
        r80 = null;
    L467:
        r78 = "";
        goto L468
    L463:
        r77 = null;
        goto L464
    L460:
        r76 = null;
        goto L461
    L456:
        r74 = null;
    L452:
        r73 = "";
    L445:
        r70 = "";
    L438:
        r67 = null;
        goto L439
    L433:
        r136 = null;
    L508:
        k6 r95 = r33.getReply();
        if (r95 != null) goto L511;
    L513:
        r43.invoke(r1);
        return;
    L511:
        if (e21.a.a(r95.getBizType()) != true) goto L513;
        LiveFullLinkPKMonitor r96 = com.bytedance.android.live.revlink.link.biz.service.i.s(this);
        r96.getClass();
        i97.a r97 = i97.a.a;
        r96.e = System.currentTimeMillis();
        goto L513
    L423:
        r132 = null;
        goto L424
    L419:
        r66 = null;
        goto L420
    L224:
        if (e21.a.a(r64.getBizType()) != true) goto L414;
        Intrinsics.checkNotNullParameter(this, "$this$liveInviteLogger");
        h41.c r98 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).getLiveInviteLogger();
        k6 r141 = r33.getReply();
        if (r141 == null) goto L228;
        String r142 = r141.getToUid();
    L229:
        k6 r143 = r33.getReply();
        if (r143 == null) goto L232;
        long r312 = r143.getReplyStatus();
    L233:
        r98.getClass();
        r33 = r33;
        LinkedHashMap r99 = new LinkedHashMap();
        if (r98.c() == null) goto L238;
        IPKLinkBizDataService r144 = r98.c();
        if (r144 == null) goto L238;
        PkInviteLogDataContext r145 = r144.getPkInviteLogContext();
    L240:
        if (r312 != 1) goto L242;
        Object r212 = "invite_type";
        r99.put("result", "accept");
        Object r213 = "audience_connect_cnt";
        Object r214 = "connection_type";
    L247:
        if (r142 == null) goto L253;
        r99.put("invitee_id", r142);
        if (r145 == null) goto L253;
        Intrinsics.checkNotNullParameter(r99, "map");
        Pair<Integer, d11.d> r100 = r145.a().get(r142);
        if (r100 == null) goto L253;
        r99.put("invited_cnt", String.valueOf(((Number) r100.getFirst()).intValue()));
    L253:
        if (r145 == null) goto L260;
        Pair<Integer, d11.d> r101 = r145.a().get(r142);
        if (r101 == null) goto L257;
        d11.d r102 = (d11.d) r101.getSecond();
    L258:
        if (r102 == null) goto L260;
        IRoom r103 = r102.h;
    L261:
        if (r103 == null) goto L263;
        r99.put("invitee_room_id", String.valueOf(IRoomKtKt.getId((IRoomBase) r103)));
    L263:
        r99.put("is_oncemore", DataType.FALSE);
        r99.put("npk_link_type", "single");
        r99.put("pitch_on", DataType.FALSE);
        com.bytedance.android.live.revlink.impl.global.c r104 = r98.c;
        if (r104 == null) goto L266;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r105 = r104.getLinkOptLogContext();
    L267:
        if (r105 == null) goto L270;
        String r106 = r105.c;
        if (r106 == null) goto L270;
    L271:
        r99.put("source", r106);
        r99.put("pk_time", String.valueOf(l51.a.j()));
        com.bytedance.android.livesdk.revenue.service.room.c r107 = r98.b;
        if (r107 == null) goto L276;
        com.bytedance.android.livesdk.revenue.room.a r108 = r107.getRoomContext();
        if (r108 == null) goto L276;
        IRoomBase r109 = r108.getCommonRoom();
    L277:
        IRoom r146 = (IRoom) r109;
        r99.put("is_recommend_list", DataType.FALSE);
        r99.put("pk_description", "routine");
        r99.put("room_status", "live");
        if (r98.c() == null) goto L284;
        IPKLinkBizDataService r147 = r98.c();
        if (r147 == null) goto L284;
        if (r147.getSelfHasAudienceBeforePk() != true) goto L284;
        r99.put("room_status", "audience_connection");
    L284:
        com.bytedance.android.live.revlink.impl.global.c r148 = r98.c;
        if (r148 == null) goto L287;
        IPKLinkBizDataService r149 = r148.mk();
    L288:
        if (r149 == null) goto L299;
        IBattleRivalTag.a r150 = IBattleRivalTag.Companion;
        com.bytedance.android.live.revlink.impl.global.c r151 = r98.c;
        if (r151 == null) goto L292;
        IPKLinkBizDataService r152 = r151.mk();
    L293:
        if (r152 == null) goto L297;
        List r153 = r152.getPkBattleRivalTagsInfo();
        if (r153 == null) goto L297;
    L298:
        r150.getClass();
        IBattleRivalTag.a.a(r153, r99);
    L297:
        r153 = CollectionsKt.emptyList();
        goto L298
    L292:
        r152 = null;
    L299:
        com.bytedance.android.live.revlink.impl.global.c r154 = r98.c;
        if (r154 == null) goto L302;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r155 = r154.getLinkOptLogContext();
    L303:
        if (r155 == null) goto L305;
        String r156 = r155.a();
    L306:
        r99.put("from_room_status", r156);
        x11.a r157 = r98.a;
        if (r157 == null) goto L309;
        y11.d r158 = r157.getPkService();
    L310:
        if (r158 == null) goto L312;
        String r159 = r158.D();
    L313:
        if (r159 != null) goto L315;
    L321:
        if (r158 == null) goto L323;
        String r160 = r158.getInviteMode();
    L325:
        if (r160 != null) goto L327;
    L333:
        if (r158 == null) goto L335;
        String r161 = r158.getTheme();
    L336:
        if (r161 != null) goto L338;
    L344:
        IPKLinkBizDataService r162 = r98.c();
        if (r162 == null) goto L348;
        String r163 = r162.getFlexActivityId();
        if (r163 == null) goto L348;
    L350:
        if (r163.length() <= 0) goto L352;
        boolean r164 = true;
    L353:
        if (r164 == false) goto L359;
        IPKLinkBizDataService r165 = r98.c();
        if (r165 == null) goto L357;
        String r166 = r165.getFlexActivityId();
    L358:
        r99.put("pk_activity_type", String.valueOf(r166));
        r99.put("invite_mode", "activity_pk");
        r99.put(r214, "manual_pk");
        goto L359
    L357:
        r166 = null;
    L359:
        com.bytedance.android.live.revlink.impl.global.c r167 = r98.c;
        if (r167 == null) goto L362;
        ox0.a r168 = r167.getModeMerge();
    L363:
        if (r168 == null) goto L365;
        int r169 = r168.a();
    L367:
        if (com.bytedance.android.live.utils.c.a(r169, 32) == false) goto L376;
        cy0.e.a.getClass();
        cy0.j r170 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r171 = com.bytedance.android.scope.m.b(r170).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r171);
        if (((com.bytedance.live.kmp.core.c) r171).M1() == null) goto L376;
        Object r172 = com.bytedance.android.scope.m.b(r170).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r172);
        w r173 = ((com.bytedance.live.kmp.core.c) r172).M1();
        if (r173 == null) goto L374;
        String r174 = String.valueOf(r173.w());
        if (r174 == null) goto L374;
    L375:
        r99.put(r213, r174);
    L377:
        r99.put(r212, "anchor");
        r99.put("connection_sub_type", "");
        r99.put("anchor_connection_type", "invite");
        r99.put("anchor_connect_status", DataType.FALSE);
        r99.put("invitee_room_status", "live");
        r99.put("invitee_connect_cnt", DataType.FALSE);
        r99.put("is_random_match", DataType.FALSE);
        r99.put("anchor_invite_type", "invite");
        if (r98.b() == null) goto L399;
        com.bytedance.android.live.revlink.impl.pk.vm.linkout.n r175 = r98.b();
        if (r175 == null) goto L399;
        if (r175.a != true) goto L399;
        r99.put("support_multi_invite", DataType.TRUE);
        com.bytedance.android.live.revlink.impl.global.c r176 = r98.c;
        if (r176 == null) goto L386;
        com.bytedance.android.live.revlink.impl.pk.service.b r177 = r176.Ud();
    L387:
        if (r177 == null) goto L389;
        i11.b r178 = r177.getLinkUserCenter();
    L390:
        if (r178 == null) goto L400;
        i11.b r179 = r177.getLinkUserCenter();
        if (r179 == null) goto L394;
        r179.getInviteeList();
    L394:
        com.bytedance.android.live.revlink.impl.pk.vm.linkout.n r180 = r98.b();
        if (r180 == null) goto L397;
        Integer r181 = Integer.valueOf(r180.b);
    L398:
        r99.put("invited_cnt", String.valueOf(r181));
        goto L400
    L397:
        r181 = null;
    L400:
        mz0.n r182 = new mz0.n();
        Map<String, String> r183 = r182.a;
        Intrinsics.checkNotNullParameter(r183, "map");
        Intrinsics.checkNotNullParameter(r99, "map");
        r183.putAll(r99);
        mz0.m r184 = new mz0.m();
        LinkCrossRoomDataHolder r185 = r98.a();
        if (r185 == null) goto L403;
        r185.m(r184);
    L403:
        com.bytedance.android.livesdk.revenue.log.i r186 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r186, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r186.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r186.d("other");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r186.c("live_detail");
        ((ArrayList) r184.a).add(r186.a);
        com.bytedance.android.livesdk.revenue.log.h r187 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r187, "linkInfoLog");
        String r188 = l51.a.m();
        Intrinsics.checkNotNullParameter(r188, "title");
        r187.h(r188);
        LinkCrossRoomDataHolder r189 = r98.a();
        if (r189 == null) goto L406;
        int r190 = r189.f();
    L407:
        r187.c(r190);
        if (r146 == null) goto L412;
        IBaseUser r191 = r146.getOwnerKt();
        if (r191 == null) goto L412;
        String r192 = r191.getIdString();
    L413:
        r187.e(r192);
        r187.f(r142);
        r187.g();
        ((ArrayList) r184.a).add(r187.a);
        r184.b(LogCommon.ROOM);
        ((ArrayList) r182.b).addAll(r184.a);
        cy0.e.a.getClass();
        cy0.j r193 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r194 = com.bytedance.android.scope.m.b(r193).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r194);
        ((mz0.i) ((f80.a) r194)).w3("livesdk_connection_invite_result", r182.a, r182.b);
    L412:
        r192 = null;
        goto L413
    L406:
        r190 = 0;
        goto L407
    L389:
        r178 = null;
        goto L390
    L386:
        r177 = null;
    L399:
        r99.put("support_multi_invite", DataType.FALSE);
    L374:
        r174 = "";
    L376:
        r99.put(r213, DataType.FALSE);
        goto L377
    L365:
        r169 = 0;
        goto L367
    L362:
        r168 = null;
        goto L363
    L352:
        r164 = false;
    L348:
        r163 = "";
        goto L350
    L338:
        if (r161.length() <= 0) goto L340;
        boolean r195 = true;
    L342:
        if (r195 != true) goto L344;
        r99.put(FileUtils.PICTURE_THEME, r161);
        goto L344
    L340:
        r195 = false;
        goto L342
    L335:
        r161 = null;
        goto L336
    L327:
        if (r160.length() <= 0) goto L329;
        boolean r196 = true;
    L331:
        if (r196 != true) goto L333;
        r99.put("invite_mode", r160);
        goto L333
    L329:
        r196 = false;
        goto L331
    L323:
        r160 = null;
        goto L325
    L315:
        if (r159.length() <= 0) goto L317;
        boolean r197 = true;
    L319:
        if (r197 != true) goto L321;
        r99.put("transform_reason", r159);
        goto L321
    L317:
        r197 = false;
        goto L319
    L312:
        r159 = null;
        goto L313
    L309:
        r158 = null;
        goto L310
    L305:
        r156 = "";
        goto L306
    L302:
        r155 = null;
        goto L303
    L287:
        r149 = null;
    L276:
        r109 = null;
    L270:
        r106 = "";
        goto L271
    L266:
        r105 = null;
        goto L267
    L257:
        r102 = null;
    L260:
        r103 = null;
        goto L261
    L242:
        Object r215 = "audience_connect_cnt";
        Object r216 = "connection_type";
        Object r217 = "invite_type";
        if (r312 != 5) goto L245;
        r99.put("result", "overtime");
        r212 = r217;
        r213 = r215;
        r214 = r216;
        goto L247
    L245:
        r99.put("result", "reject");
        r212 = r217;
        r213 = r215;
        r214 = r216;
    L238:
        r145 = null;
        goto L240
    L232:
        r312 = 0;
        goto L233
    L228:
        r142 = null;
        goto L229
    L414:
        r65 = "anchor_connect_status";
    L220:
        r63 = "";
        goto L221
    L214:
        k6 r198 = r33.getReply();
        if (r198 == null) goto L220;
        j5 r199 = r198.getToLinkmicInfo();
        if (r199 == null) goto L220;
        r63 = r199.getInteractIdStr();
        if (r63 != null) goto L221;
    L202:
        if (r58.length() == 0) goto L205;
        r59 = false;
    L199:
        r58 = null;
    L193:
        r54 = null;
        goto L194
    L183:
        r49 = r46.getInteractIdStr();
        if (r49 != null) goto L186;
        r49 = "";
        goto L186
    L177:
        if (r47.length() == 0) goto L180;
        r48 = false;
    L187:
        r49 = "";
        goto L188
    L158:
        r35 = BizType.None.ordinal();
        goto L159
    L140:
        if (r29 != 3) goto L142;
        r30 = LiveTracingMonitor.EventType.MESSAGE_RECEIVED;
        goto L152
    L142:
        if (r29 != 4) goto L144;
        r30 = LiveTracingMonitor.EventType.SDK_INTERFACE_CALL;
        goto L152
    L144:
        if (r29 != 5) goto L147;
        r30 = LiveTracingMonitor.EventType.SDK_CALLBACK;
        goto L152
    L147:
        throw new NoWhenBranchMatchedException();
    L151:
        r30 = LiveTracingMonitor.EventType.BUSSINESS_API_CALL;
        goto L152
    L127:
        if (r126 != 3) goto L129;
        r127 = LiveTracingMonitor.EventModule.MEDIA_MULTI_LINKER;
        goto L136
    L129:
        if (r126 != 4) goto L132;
        r127 = LiveTracingMonitor.EventModule.SCREEN_LINKER;
        goto L136
    L132:
        throw new NoWhenBranchMatchedException();
    L135:
        r127 = LiveTracingMonitor.EventModule.PK;
        goto L136
    L122:
        r25 = 0;
        goto L123
    L115:
        if (r5 != 8) goto L119;
        if (r118 == null) goto L119;
        if (r19 == null) goto L119;
        r19.t(r118);
        goto L119
    L99:
        r20 = null;
        goto L101
    L104:
        r118 = null;
    L92:
        r116 = CollectionsKt.emptyList();
        goto L93
    L83:
        r115 = null;
        goto L85
    L88:
        r112 = null;
    L76:
        r110 = CollectionsKt.emptyList();
        goto L77
    L61:
        if (x.b(getLaunchRecord().c) == true) goto L72;
        k6 r200 = r3.getReply();
        if (r200 == null) goto L72;
        String r201 = r200.getToast();
        if (r201 == null) goto L72;
        if (r201.length() <= 0) goto L69;
        boolean r1100 = true;
    L70:
        if (r1100 == false) goto L72;
        ToastUtil.b(r201, 0);
        goto L72
    L69:
        r1100 = false;
    L57:
        r45 = "linkerMessage";
        goto L59
    }
}
