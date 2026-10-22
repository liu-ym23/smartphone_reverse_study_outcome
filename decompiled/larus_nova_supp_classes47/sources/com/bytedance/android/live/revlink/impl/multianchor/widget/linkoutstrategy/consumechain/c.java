package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.c2;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.f6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements a<i6>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public c(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(i6 r15, Function1<? super i6, Unit> r16, Function0 r17) {
        i6 r1 = r15;
        Intrinsics.checkNotNullParameter(r1, "event");
        Intrinsics.checkNotNullParameter(r16, "resolve");
        Intrinsics.checkNotNullParameter(r17, "reject");
        v r2 = com.bytedance.android.live.revlink.link.biz.service.i.H(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, Constants.OperatorKey.MSG);
        JSONObject r4 = new JSONObject();
        g1 r5 = r1.getInvite();
        int r6 = y50.b.a;
        y31.k r7 = null;
        if (r5 == null) goto L20;
        g1 r8 = r5;
        Intrinsics.checkNotNullParameter(r8, "$this$fromUid");
        String r9 = r8.get_fromUid();
        if (r9 != null) goto L7;
        r9 = "";
    L7:
        y50.b.a.d(r4, "from_user", r9);
        y50.b.a.c(r4, "from_room", r5.getFromRoomId());
        y50.b.a.b(r4, "invite_source", r5.getInviteSource());
        y50.b.a.d(r4, "multi_channel_info", c7.a(r5.getMultiChannelInfo()));
        b2 r10 = r5.getPreRtcInfo();
        if (r10 == null) goto L10;
        String r12 = c2.a(r10);
    L11:
        y50.b.a.d(r4, "pre_rtc_info", r12);
        List r13 = r5.getInviterUsers();
        if (r13 == null) goto L20;
        if ((!r13.isEmpty()) != true) goto L20;
        List r14 = f6.b(r5);
        if (r14 == null) goto L18;
        List r18 = CollectionsKt.toList(r14);
    L19:
        y50.b.a.d(r4, "inviterUsers", x.g(r18));
        goto L20
    L18:
        r18 = null;
        goto L19
    L10:
        r12 = null;
    L20:
        IBattleLinkerInviteMessageExtra r19 = j6.a(r1);
        if (r19 == null) goto L23;
        y50.b.a.c(r4, "invite_type", r19.getInviteType());
        y50.b.a.c(r4, "match_type", r19.getMatchType());
    L23:
        v.m(r1, r4);
        r2.c(r4);
        boolean r20 = false;
        r2.I("receive_invite_msg", r4, false);
        Intrinsics.checkNotNullParameter(r1, "$this$sceneExt");
        int r3 = (int) r1.getScene();
        if (r3 != 1) goto L26;
    L30:
        boolean r22 = true;
    L31:
        if (r22 == false) goto L79;
        m0 r23 = r1.getCommonData();
        if (r23 == null) goto L38;
        Intrinsics.checkNotNullParameter(r23, "$this$createTimeKt");
        long r24 = r23.getCreateTime();
        long r110 = WebcastRedirectException.UNKNOWN;
        u41.c r25 = u41.c.f;
        r25.getClass();
        ReadOnlyProperty r26 = u41.c.d;
        KProperty[] r111 = u41.c.a;
        long r27 = (r24 / r110) + ((Number) r26.getValue(r25, r111[2])).longValue();
        i97.a r28 = i97.a.a;
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r1, "$this$getTimeStampMills");
        if ((r27 - (r1.getTimestampFlex() / r110)) <= ((Number) u41.c.e.getValue(r25, r111[3])).longValue()) goto L38;
        boolean r29 = true;
    L39:
        if (r29 == false) goto L79;
        if (r1.getInvite() != null) goto L43;
    L50:
        boolean r30 = false;
    L51:
        if (r30 == false) goto L79;
        if (j6.a(r1) == null) goto L67;
        LiveFullLinkPKMonitor r32 = com.bytedance.android.live.revlink.link.biz.service.i.s(this);
        e6 r33 = r1.getInvite();
        r32.b = 0;
        r32.c = 0;
        r32.d = 0;
        r32.e = 0;
        r32.j = 0;
        r32.k = 0;
        r32.l = false;
        r32.m = false;
        r32.h = false;
        i97.a r34 = i97.a.a;
        r32.c = System.currentTimeMillis();
        if (r33 != null) goto L58;
    L60:
        boolean r35 = false;
    L61:
        r32.l = r35;
        if (r33 != null) goto L64;
    L66:
        r32.m = r20;
        goto L67
    L64:
        if (r33.getCurInviteNum() != 1) goto L66;
        r20 = true;
        goto L66
    L58:
        if (r33.getSupportMultiInvite() != true) goto L60;
        r35 = true;
    L67:
        IBattleLinkerInviteMessageExtra r36 = j6.a(r1);
        if (r36 != null) goto L70;
    L78:
        r16.invoke(r1);
        return;
    L70:
        if (((int) r36.getMatchType()) != 1) goto L78;
        com.bytedance.android.live.revlink.impl.pk.service.a r37 = com.bytedance.android.live.revlink.link.biz.service.i.N(this);
        if (r37 == null) goto L76;
        NextLiveData<y31.k> r38 = r37.b();
        if (r38 == null) goto L76;
        r7 = (y31.k) r38.getValue();
    L76:
        if (r7 == null) goto L78;
        return;
    L43:
        if (j6.a(r1) == null) goto L50;
        IBattleLinkerInviteMessageExtra r39 = j6.a(r1);
        if (r39 == null) goto L47;
        IRoom r40 = r39.getInviteRoom();
    L48:
        if (r40 == null) goto L50;
        r30 = true;
        goto L51
    L47:
        r40 = null;
    L38:
        r29 = false;
    L79:
        r17.invoke();
        return;
    L26:
        if (r3 == 7) goto L30;
        if (r3 == 2) goto L30;
        r22 = false;
        goto L31
    }
}
