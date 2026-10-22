package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.launchcontext.RevLinkSwitchExtraContext;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.AnchorLinkInitType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements a<j>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public l(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(j r30, Function1<? super j, Unit> r32, Function0 r33) {
        j r0 = r30;
        Intrinsics.checkNotNullParameter(r0, "event");
        Intrinsics.checkNotNullParameter(r32, "resolve");
        Intrinsics.checkNotNullParameter(r33, "reject");
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(this).c() == false) goto L5;
        r33.invoke();
        return;
    L5:
        i6 r2 = r0.a;
        com.bytedance.android.live.revlink.impl.multianchor.utils.g r15 = r0.b;
        if (((int) i1.c(r2)) != 8) goto L30;
        k6 r1 = r2.getReply();
        if (r1 == null) goto L10;
        int r4 = r1.getMultiPkMode();
    L11:
        k6 r3 = r2.getReply();
        if (r3 != null) goto L216;
    L28:
        IBattleConfigSetting r5 = null;
    L29:
        IBattleConfigSetting r8 = r5;
        int r6 = r4;
    L31:
        u.a r7 = getLaunchRecord();
        k6 r9 = r2.getReply();
        if (r9 == null) goto L34;
        String r10 = r9.getEventTrackingInfo();
    L35:
        r7.P = r10;
        Intrinsics.checkNotNullParameter(this, "$this$anchorConnectionContextObj");
        f21.b r12 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).Rb();
        AnchorRtcConnectModel r13 = getRtcConnectModel();
        u.a r14 = getLaunchRecord();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "$this$typeExt");
        if (((int) r2.getType2()) != 8) goto L38;
        boolean r16 = true;
    L40:
        if (r13 != null) goto L42;
    L44:
        boolean r17 = false;
    L45:
        f21.a.C0236a r18 = new f21.a.C0236a(r6, r17, r8, 0, null, 56);
        k6 r19 = r2.getReply();
        if (r19 != null) goto L48;
    L50:
        boolean r20 = false;
    L51:
        if (r14 != null) goto L53;
    L54:
        if (r14 == null) goto L64;
        int r22 = r14.c;
        if (r22 != 1) goto L58;
    L61:
        boolean r23 = true;
    L62:
        if (r23 != true) goto L64;
    L63:
        boolean r24 = true;
    L65:
        if (r24 == false) goto L67;
        String r25 = "random";
    L68:
        if (r20 == false) goto L70;
        String r26 = "pk";
    L71:
        String r110 = r25 + '_' + r26;
        if (r16 == true) goto L77;
        if (r14 != null) goto L75;
    L76:
        boolean r27 = true;
    L78:
        com.bytedance.android.live.revlink.impl.global.c r28 = r12.a;
        if (r16 == false) goto L81;
        AnchorLinkInitType r29 = AnchorLinkInitType.PERMIT_AGREE_MSG;
    L82:
        AnchorLinkInitType r34 = r29;
        if (r14 != null) goto L85;
    L87:
        if (r14 != null) goto L89;
    L91:
        int r35 = 0;
    L92:
        com.bytedance.android.live.revlink.impl.global.c r36 = r12.a;
        if (r36 == null) goto L95;
        LinkCrossRoomDataHolder r37 = r36.getLinkCrossRoomDataHolder();
    L97:
        if (r37 == null) goto L99;
        String r38 = r37.h();
    L101:
        if (r13 == null) goto L103;
        v1 r210 = r13.getMultiRtcInfo();
    L105:
        if (r13 == null) goto L107;
        d7 r211 = r13.getMultiLiveCoreInfo();
    L108:
        Intrinsics.checkNotNullParameter(r2, "$this$sceneExt");
        if (((int) r2.getScene()) != 1) goto L115;
        k6 r39 = r2.getReply();
        if (r39 == null) goto L115;
        if (r39.getSwitchToScene() != 7) goto L115;
        boolean r40 = true;
    L116:
        k6 r42 = r2.getReply();
        if (r42 == null) goto L119;
        com.bytedance.android.livesdk.link.model.m r212 = r42.getLayoutInfo();
    L120:
        setConnectionContext(new f21.a(r28, r34, r35, r27, r38, r40, true, false, false, 1, r110, null, r18, r211, r210, r15, 0, r212, 1320544));
        setLaunchParameters(getLaunchRecord().r());
        k6 r43 = r2.getReply();
        if (r43 == null) goto L136;
        List r111 = r43.getLinkUsers();
        if (r111 == null) goto L136;
        boolean r44 = true;
        if ((!r111.isEmpty()) == true) goto L128;
        r111 = null;
    L128:
        if (r111 == null) goto L137;
        y41.f r45 = y41.f.N;
        r45.getClass();
        if (((Boolean) y41.f.h.getValue(r45, y41.f.a[6])).booleanValue() == false) goto L137;
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(this).c() == true) goto L137;
        i11.b r46 = getMLinkUserCenter();
        if (r46 == null) goto L137;
        r46.p(CollectionsKt.toList(r111), "replyMsg", Long.valueOf(r2.getVersion()));
    L137:
        k6 r47 = r2.getReply();
        if (r47 == null) goto L140;
        Integer r112 = Integer.valueOf(r47.getToBizType());
    L141:
        int r48 = BizType.PK.ordinal();
        if (r112 != null) goto L145;
    L146:
        int r49 = BizType.OpenGame.ordinal();
        if (r112 != null) goto L150;
    L152:
        int r50 = 64;
    L154:
        jy0.b.c("rev_scope_life_control", "handleReceiveReply with toBizType: " + r112, null, 4);
        u r52 = getLaunchParameters();
        if (r52 == null) goto L159;
        if (r52.z != r44) goto L159;
    L160:
        wq2.f r53 = getRoomDataCenterService();
        if (r53 == null) goto L163;
        r53.Wk();
    L163:
        com.bytedance.android.live.revlink.impl.service.internal.a r54 = com.bytedance.android.live.revlink.link.biz.service.i.p(this);
        if (r54 == null) goto L208;
        int r55 = RevLinkSwitchExtraContext.g;
        u r56 = getLaunchParameters();
        f21.a r57 = getConnectionContext();
        k6 r58 = r2.getReply();
        if (r58 == null) goto L168;
        String r113 = r58.getClientAttachedInfoStr();
    L169:
        if (r113 != null) goto L171;
    L174:
        boolean r114 = true;
    L175:
        if (r114 == false) goto L177;
        v3 r59 = (v3) vh7.f.c(v3.class);
    L184:
        k6 r60 = r2.getReply();
        if (r60 == null) goto L187;
        String r115 = r60.getBattleAttachedInfoStr();
    L188:
        if (r115 != null) goto L190;
    L193:
        boolean r116 = true;
    L194:
        if (r116 == false) goto L196;
        p0 r62 = (p0) vh7.f.c(p0.class);
    L203:
        k6 r63 = r2.getReply();
        if (r63 == null) goto L206;
        String r117 = r63.getEventTrackingInfo();
    L207:
        r54.Gp(r50, RevLinkSwitchExtraContext.Companion.a(r56, r57, r59, r62, r117));
        goto L208
    L206:
        r117 = null;
        goto L207
    L196:
        if (r60 != null) goto L212;
    L199:
        String r64 = "";
    L200:
        r62 = (p0) l97.a.a.fromJson(r64, TypesJVMKt.getJavaType(Reflection.typeOf(p0.class)));     // Catch: Exception -> L202
    L202:
        r62 = vh7.f.c(p0.class);
        goto L203
    L212:
        r64 = r60.getBattleAttachedInfoStr();     // Catch: Exception -> L202
        if (r64 != null) goto L200;
    L190:
        if (StringsKt.isBlank(r115) == true) goto L193;
        r116 = false;
        goto L194
    L187:
        r115 = null;
        goto L188
    L177:
        if (r58 != null) goto L214;
    L180:
        String r65 = "";
    L181:
        r59 = (v3) l97.a.a.fromJson(r65, TypesJVMKt.getJavaType(Reflection.typeOf(v3.class)));     // Catch: Exception -> L183
    L183:
        r59 = vh7.f.c(v3.class);
        goto L184
    L214:
        r65 = r58.getClientAttachedInfoStr();     // Catch: Exception -> L183
        if (r65 != null) goto L181;
    L171:
        if (StringsKt.isBlank(r113) == true) goto L174;
        r114 = false;
        goto L175
    L168:
        r113 = null;
    L208:
        com.bytedance.android.live.revlink.impl.multianchor.scope.c r66 = getLinkDialogService();
        if (r66 == null) goto L218;
        r66.c();
        return;
    L218:
        return;
    L159:
        if (isLinkWithAudience() == false) goto L163;
    L150:
        if (r112.intValue() != r49) goto L152;
    L153:
        r50 = 4;
        goto L154
    L145:
        if (r112.intValue() == r48) goto L153;
    L140:
        r112 = null;
    L136:
        r44 = true;
        goto L137
    L119:
        r212 = null;
    L115:
        r40 = false;
        goto L116
    L107:
        r211 = null;
        goto L108
    L103:
        r210 = null;
        goto L105
    L99:
        r38 = "";
        goto L101
    L95:
        r37 = null;
        goto L97
    L89:
        if (x.b(r14.c) != true) goto L91;
        r35 = r14.c;
        goto L92
    L85:
        if (x.a(r14.c) != true) goto L87;
        r35 = 7;
        goto L92
    L81:
        r29 = AnchorLinkInitType.REPLY_AGREE_MSG;
        goto L82
    L75:
        if (r14.c != 1) goto L76;
    L77:
        r27 = false;
        goto L78
    L70:
        r26 = "link";
        goto L71
    L67:
        r25 = "manual";
        goto L68
    L58:
        if (r22 == 3) goto L61;
        r23 = false;
    L64:
        r24 = false;
        goto L65
    L53:
        if (x.b(r14.c) == true) goto L63;
    L48:
        if (e21.a.a(r19.getToBizType()) != true) goto L50;
        r20 = true;
        goto L51
    L42:
        if (r13.enableFirstFrameOpt() != true) goto L44;
        r17 = true;
        goto L45
    L38:
        r16 = false;
        goto L40
    L34:
        r10 = null;
        goto L35
    L216:
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L26
        String r68 = r3.getBattleConfigSettingStr();     // Catch: Throwable -> L26
        if (r68 != null) goto L16;
    L24:
        Result.constructor-impl(null);     // Catch: Throwable -> L26
        goto L28
    L16:
        if (r68.length() <= 0) goto L18;
        boolean r69 = true;
    L19:
        if (r69 == true) goto L22;
        r68 = null;
    L22:
        if (r68 == null) goto L24;
        r5 = (IBattleConfigSetting) l97.a.a.fromJson(r68, TypesJVMKt.getJavaType(Reflection.typeOf(IBattleConfigSetting.class)));     // Catch: Throwable -> L26
        goto L29
    L18:
        r69 = false;
    L26:
        th = move-exception;
        Result.Companion r70 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L10:
        r4 = 0;
        goto L11
    L30:
        r8 = null;
        r6 = 0;
        goto L31
    }
}
