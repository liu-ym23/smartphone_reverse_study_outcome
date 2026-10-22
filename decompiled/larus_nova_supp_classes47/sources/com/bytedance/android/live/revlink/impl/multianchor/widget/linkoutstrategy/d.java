package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkInviteLogDataContext;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements k, c {
    public final PkInviteLogDataContext a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final c c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void finishMultiAnchor(int r8, Function0<Unit> r9, boolean r10, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "reqSrc");
        this.c.finishMultiAnchor(r8, r9, r10, r12, r13);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService() {
        return this.c.getAnchorConnectService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getAnchorLinkUserCenter() {
        return this.c.getAnchorLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final t getConnectMonitor() {
        return this.c.getConnectMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f21.a getConnectionContext() {
        return this.c.getConnectionContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MultiLinkAnchorControlContext getControlContext() {
        return this.c.getControlContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f41.a getJsbInvitePkCallback() {
        return this.c.getJsbInvitePkCallback();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u getLaunchParameters() {
        return this.c.getLaunchParameters();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u.a getLaunchRecord() {
        return this.c.getLaunchRecord();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revlink.impl.multianchor.scope.c getLinkDialogService() {
        return this.c.getLinkDialogService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final ld.a getLinkInternalDataSet() {
        return this.c.getLinkInternalDataSet();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final n getLinkOutManager() {
        return this.c.getLinkOutManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getMLinkUserCenter() {
        return this.c.getMLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final IRoom getMRoom() {
        return this.c.getMRoom();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MutableLiveData<q11.c> getPkLinkState() {
        return this.c.getPkLinkState();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final x11.a getRevInternalLinkService() {
        return this.c.getRevInternalLinkService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final wq2.f getRoomDataCenterService() {
        return this.c.getRoomDataCenterService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectManager getRtcConnectManager() {
        return this.c.getRtcConnectManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectModel getRtcConnectModel() {
        return this.c.getRtcConnectModel();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final Function0<v51.b> getStreamInteractScopeFn() {
        return this.c.getStreamInteractScopeFn();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final UnexpectedFrameMonitor getUnexpectedFrameMonitor() {
        return this.c.getUnexpectedFrameMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final boolean isLinkWithAudience() {
        return this.c.isLinkWithAudience();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setConnectionContext(f21.a r2) {
        this.c.setConnectionContext(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setJsbInvitePkCallback(f41.a r2) {
        this.c.setJsbInvitePkCallback(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setLaunchParameters(u r2) {
        this.c.setLaunchParameters(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setRtcConnectModel(AnchorRtcConnectModel r2) {
        this.c.setRtcConnectModel(r2);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void reset(String r4) {
        Intrinsics.checkNotNullParameter(r4, "src");
        getLaunchRecord().p(r4);
        getPkLinkState().setValue(q11.c.b.b);
        i.h(this).g = "";
        vh6.c.b(qr2.c.class).resetLinkData();
        jy0.b.f("ttlive_pk", "PKLinkBizDataContext.reset by ".concat(r4), null, 4);
    }

    public d(com.bytedance.android.live.revlink.impl.global.c r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r3, "layoutOutStrategyContext");
        this.b = r2;
        this.c = r3;
        this.a = new PkInviteLogDataContext(r2);
    }
}
