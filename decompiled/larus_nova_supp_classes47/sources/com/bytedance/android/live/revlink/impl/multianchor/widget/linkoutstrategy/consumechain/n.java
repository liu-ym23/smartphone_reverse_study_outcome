package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements a<j>, com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f, com.bytedance.android.live.revlink.link.biz.service.k {
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

    public n(com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        Intrinsics.checkNotNullParameter(r2, "strategyContext");
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        this.b = r2;
        this.a = r3;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.a
    public final void a(j r7, Function1<? super j, Unit> r8, Function0 r9) {
        j r10 = r7;
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r8, "resolve");
        Intrinsics.checkNotNullParameter(r9, "reject");
        if (com.bytedance.android.live.revlink.link.biz.service.i.I(this).c() == false) goto L5;
        r8.invoke(r10);
        return;
    L5:
        i6 r12 = r10.a;
        k6 r13 = r12.getReply();
        String r14 = null;
        if (r13 == null) goto L8;
        Integer r15 = Integer.valueOf((int) r13.getReplyStatus());
    L9:
        if (r15 == null) goto L21;
        if (r15.intValue() != 2) goto L21;
        Intrinsics.checkNotNullParameter(this, "$this$pkInviteControlUtils");
        com.bytedance.android.live.revlink.impl.pk.utils.j r16 = com.bytedance.android.live.revlink.link.biz.service.i.getContext(this).getPKInviteControlUtils();
        String r0 = getLaunchRecord().q;
        if (r0 != null) goto L16;
        r0 = "";
    L16:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r0, "userId");
        com.bytedance.tools.kcp.spongepreference.runtime.a r17 = l51.a.v0;
        KProperty[] r1 = l51.a.a;
        Map r3 = (Map) r17.getValue(null, r1[83]);
        if (r3.get(r0) != null) goto L19;
        r3.put(r0, new ArrayList());
    L19:
        Object r2 = r3.get(r0);
        Intrinsics.checkNotNull(r2);
        i97.a r4 = i97.a.a;
        ((List) r2).add(Double.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r17.setValue(null, r1[83], r3);
    L21:
        if (getLaunchRecord().c != 1) goto L40;
        com.bytedance.android.live.revlink.impl.pk.service.a r18 = com.bytedance.android.live.revlink.link.biz.service.i.N(this);
        if (r18 == null) goto L33;
        NextLiveData<y31.k> r19 = r18.b();
        if (r19 == null) goto L33;
        y31.k r20 = (y31.k) r19.getValue();
        if (r20 == null) goto L33;
        IRoom r22 = r20.b;
        if (r22 == null) goto L33;
        IBaseUser r23 = r22.getOwnerKt();
        if (r23 == null) goto L33;
        String r24 = r23.getIdString();
    L34:
        k6 r25 = r12.getReply();
        if (r25 == null) goto L38;
        r14 = r25.getToUid();
    L38:
        if ((!Intrinsics.areEqual(r24, r14)) == false) goto L49;
        int r26 = ToastUtil.a;
        int r27 = w11.a.a;
        ToastUtil.a(2131921502, 0);
        LinkedHashMap r28 = new LinkedHashMap();
        r28.put("scene", "random_pk_match");
        mz0.n r29 = new mz0.n();
        Map<String, String> r30 = r29.a;
        Intrinsics.checkNotNullParameter(r30, "map");
        Intrinsics.checkNotNullParameter(r28, "map");
        r30.putAll(r28);
        mz0.m r32 = new mz0.m();
        r32.b(LogCommon.ROOM);
        ((ArrayList) r29.b).addAll(r32.a);
        cy0.e.a.getClass();
        cy0.j r33 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r34 = com.bytedance.android.scope.m.b(r33).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r34);
        ((mz0.i) ((f80.a) r34)).w3("livesdk_connection_fail_toast_show", r29.a, r29.b);
    L49:
        i11.b r35 = getMLinkUserCenter();
        if (r35 == null) goto L58;
        List<IBaseUser> r36 = r35.getInviteeList();
        if (r36 != null) goto L54;
        return;
    L54:
        if (r36.isEmpty() != true) goto L60;
        reset("ReplyMessageRefuseProcessor");
        r35.clear(false);
        return;
    L60:
        return;
    L58:
        return;
    L33:
        r24 = null;
        goto L34
    L40:
        k6 r37 = r12.getReply();
        if (r37 == null) goto L49;
        if (e21.a.a(r37.getBizType()) != true) goto L49;
        ld.a r38 = getLinkInternalDataSet();
        if (r38 == null) goto L49;
        NextLiveData r39 = r38.ke();
        if (r39 == null) goto L49;
        r39.setValue(4);
        goto L49
    L8:
        r15 = null;
        goto L9
    }
}
