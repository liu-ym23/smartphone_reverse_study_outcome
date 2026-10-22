package tc0;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.n;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.scope.o;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends a implements o {
    public final bn0.b b;
    public final g c;

    @Override // tc0.b
    public final void Ba() {
        Intrinsics.checkNotNullParameter("", "applyReason");
        c.h().F = "";
    }

    @Override // tc0.b
    public final void De() {
        Intrinsics.checkNotNullParameter("", "connectType");
        c.h().H = "";
    }

    public final void onStart() {
        InteractLinkFullLinkMonitor.h = this;
        n.b.getClass();
        n.a = this;
    }

    public final void onStop() {
        Set r0 = InteractLinkFullLinkMonitor.a;
        InteractLinkFullLinkMonitor.h = null;
        n.b.getClass();
        n.a = null;
    }

    @Override // tc0.b
    public final com.bytedance.android.livesdk.message.linker.b Oa() {
        return c.h().A;
    }

    @Override // tc0.b
    public final String Vd() {
        return c.h().f;
    }

    @Override // tc0.b
    public final String getApplyReason() {
        String r0 = c.h().F;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // tc0.b
    public final long getChannelId() {
        return c.h().getChannelId();
    }

    @Override // tc0.b
    public final String getLiveCoreExtInfo() {
        return c.h().m;
    }

    @Override // tc0.b
    public final e0 getMcuContent() {
        return c.h().s;
    }

    @Override // tc0.b
    public final u1 getMultiLiveCoreInfo() {
        return c.h().r;
    }

    @Override // tc0.b
    public final v1 getMultiRtcInfo() {
        return c.h().n;
    }

    @Override // tc0.b
    public final String getRtcExtInfo() {
        String r0 = c.h().k;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // tc0.b
    public final boolean isSupportCamera() {
        return c.h().E;
    }

    @Override // tc0.b
    public final String u() {
        String r0 = c.h().e;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // tc0.b
    public final String x9() {
        return c.h().x;
    }

    @Override // tc0.b
    public final boolean zi() {
        return c.h().N;
    }

    @Override // tc0.b
    public final void Ah(String r2) {
        c.h().x = r2;
    }

    @Override // tc0.b
    public final void Cl(Map<Long, ? extends g2> r2) {
        Intrinsics.checkNotNullParameter(r2, "linkRoomInfoMap");
        c.h().l(r2);
    }

    @Override // tc0.b
    public final void D0(com.bytedance.android.livesdk.message.linker.b r2) {
        c.h().A = r2;
    }

    @Override // tc0.b
    public final void D6(String r2) {
        c.h().f = r2;
    }

    @Override // tc0.b
    public final void F7(LinkMatchType r2) {
        Intrinsics.checkNotNullParameter(r2, "matchType");
        c.h().L = r2;
    }

    @Override // tc0.b
    public final void H9(boolean r2) {
        c.h().C = r2;
    }

    @Override // tc0.b
    public final void Jm(String r2) {
        c.h().y = r2;
    }

    @Override // tc0.b
    public final void Kj(boolean r2) {
        c.h().N = r2;
    }

    @Override // tc0.b
    public final void Pd(int r2) {
        c r0 = c.h();
        r0.i = r2;
        r0.h = r2;
    }

    @Override // tc0.b
    public final void R0(int r2) {
        c.h().u = r2;
    }

    @Override // tc0.b
    public final void c1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorInteractId");
        c.h().e = r2;
    }

    @Override // tc0.b
    public final void dh(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskName");
        c.h().M = r2;
    }

    @Override // tc0.b
    public final void rg(int r2) {
        c.h().j = r2;
    }

    @Override // tc0.b
    public final void setApplyType(int r2) {
        c.h().K = r2;
    }

    @Override // tc0.b
    public final void setChorusCDNInfo(v r2) {
        c.h().l = r2;
    }

    @Override // tc0.b
    public final void setLiveCoreExtInfo(String r2) {
        c.h().m = r2;
    }

    @Override // tc0.b
    public final void setMcuContent(e0 r2) {
        c.h().s = r2;
    }

    @Override // tc0.b
    public final void setMultiLiveCoreInfo(u1 r2) {
        c.h().r = r2;
    }

    @Override // tc0.b
    public final void setMultiRtcInfo(v1 r2) {
        c.h().n = r2;
    }

    @Override // tc0.b
    public final void setRtcExtInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcExtInfo");
        c.h().k = r2;
    }

    @Override // tc0.b
    public final void v6(boolean r2) {
        c.h().E = r2;
    }

    public d(bn0.b r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "myScope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        super(r3);
        this.b = r2;
        this.c = r3;
    }
}
