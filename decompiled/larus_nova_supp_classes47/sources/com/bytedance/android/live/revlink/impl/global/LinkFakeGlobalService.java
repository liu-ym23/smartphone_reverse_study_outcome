package com.bytedance.android.live.revlink.impl.global;

import b21.e;
import com.bytedance.android.live.revenuelink.connect.k;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.audience.g;
import com.bytedance.android.live.revlink.impl.behavior.ToolbarPKServiceContext;
import com.bytedance.android.live.revlink.impl.control.AnchorLogParamsContext;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.LinkAudioPunishContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.PkMultiDataContext;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.MultiDynamicLocalContext;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiEnLargeContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkAudienceOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.f0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.l;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkControlContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.RevLinkPreloadContext;
import com.bytedance.android.live.revlink.impl.pk.scopeservice.PkWidgetDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.pk.service.PkServiceContext;
import com.bytedance.android.live.revlink.impl.pk.service.TopBannerDetailsDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.android.live.revlink.impl.pk.utils.h;
import com.bytedance.android.live.revlink.impl.pk.utils.j;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PKAutoMatchServiceContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PKControlServiceContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkPrecisionMatchDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.impl.precisefind.MultiPkPreciseFindContext;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.impl.utils.a0;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import m51.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkFakeGlobalService implements c, o {
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy G1;
    public final Lazy H;
    public final Lazy H0;
    public final Lazy H1;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy L0;
    public final Lazy L1;
    public final Lazy M;
    public final Lazy M1;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy P0;
    public final Lazy P1;
    public final Lazy Q;
    public final cy0.c Q1;
    public final Lazy R;
    public final Lazy S;
    public final com.bytedance.android.live.revenuelink.withroom.a S1;
    public final Lazy T;
    public final com.bytedance.android.livesdk.revenue.service.room.c T1;
    public final Lazy U;
    public final Lazy V;
    public final Lazy V0;
    public final com.bytedance.android.livesdk.revenue.service.user.a V1;
    public final Lazy W;
    public final Lazy X;
    public final Lazy Y;
    public final Lazy Z;
    public final a a;
    public final Lazy b;
    public final Lazy b1;
    public final com.bytedance.android.livesdk.revenue.service.interact.d b2;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy g1;
    public final Lazy h;
    public final Lazy h1;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy k0;
    public final Lazy k1;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy p0;
    public final Lazy p1;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy v1;
    public final Lazy w;
    public final Lazy x;
    public final Lazy x1;
    public final Lazy y;
    public final Lazy y1;
    public final Lazy z;

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final f A7() {
        return (f) this.W.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.a B8() {
        return (com.bytedance.android.live.revlink.impl.utils.a) this.z.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.profit.d Bg() {
        return (com.bytedance.android.live.revlink.impl.multianchor.profit.d) this.L.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final g Ee() {
        return (g) this.k.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.match.f F8() {
        return (com.bytedance.android.live.revlink.impl.multianchor.match.f) this.F.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.f Fb() {
        return (com.bytedance.android.live.revlink.impl.multianchor.vm.f) this.p0.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final e Gm() {
        return (e) this.w.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.a Nl() {
        return (h41.a) this.V.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final k21.a P7() {
        return (k21.a) this.f.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final v Pa() {
        return (v) this.M.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.profit.a Qj() {
        return (com.bytedance.android.live.revlink.impl.multianchor.profit.a) this.j.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final f21.b Rb() {
        return (f21.b) this.o.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.a Rj() {
        return (b21.a) this.B.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final g0 Rn() {
        return (g0) this.g.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b0 Tj() {
        return (b0) this.T.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g Yg() {
        return (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g) this.L1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorLinkAudienceOptUtils a3() {
        return (AnchorLinkAudienceOptUtils) this.Z.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e el() {
        return (com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e) this.U.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final a0 fl() {
        return (a0) this.y1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final i41.a getAutoMatchManager() {
        return (i41.a) this.b.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.b getClearScreenLinkUtils() {
        return (com.bytedance.android.live.revlink.impl.utils.b) this.P0.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final e21.b getClientAttachedInfoObj() {
        return (e21.b) this.J.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.a getConnectionDataLogUtils() {
        return (w31.a) this.q.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LinkCrossRoomDataHolder getLinkCrossRoomDataHolder() {
        return (LinkCrossRoomDataHolder) this.p.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final r31.a getLinkNetwork() {
        return (r31.a) this.H0.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e getLinkOptLogContext() {
        return (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e) this.P.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f getLinkPlayHelper() {
        return (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f) this.N.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h getLinkStreamRegionUtils() {
        return (h) this.L0.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LiveFullLinkPKMonitor getLiveFullLinkPKMonitor() {
        return (LiveFullLinkPKMonitor) this.u.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.c getLiveInviteLogger() {
        return (h41.c) this.x.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final m41.a getMatchInviteRefuseUtils() {
        return (m41.a) this.x1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d21.d getMergePkHelper() {
        return (d21.d) this.g1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final ox0.a getModeMerge() {
        return (ox0.a) this.v1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.g getMultiAnchorLinkContextObj() {
        return (com.bytedance.android.live.revlink.impl.multianchor.vm.g) this.y.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final q getMultiAnchorLinkLogUtils() {
        return (q) this.E.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.v getMultiLinkMonitor() {
        return (com.bytedance.android.live.revlink.impl.multianchor.utils.v) this.c.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w getMultiLinkUtil() {
        return (w) this.k1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final z getMultiPkMonitor() {
        return (z) this.h.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.f getPKBaseUtils() {
        return (com.bytedance.android.live.revlink.impl.mergepk.pkbase.f) this.O.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final j getPKInviteControlUtils() {
        return (j) this.p1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final a21.a getPkBaseLogger() {
        return (a21.a) this.s.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.d getPkBaseMonitor() {
        return (b21.d) this.l.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.e getPkBaseResultDataContextObj() {
        return (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.e) this.h1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.monitor.b getPkEnterRoomTracer() {
        return (com.bytedance.android.live.revlink.impl.monitor.b) this.e.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.c getPkLinkUtils() {
        return (w31.c) this.H.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.f getPkSwitchLogger() {
        return (h41.f) this.G.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.utils.q getPkUtils() {
        return (com.bytedance.android.live.revlink.impl.pk.utils.q) this.K.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.e getPrecisionMatchMonitor() {
        return (w31.e) this.H1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final s getRevLinkCommonUtil() {
        return (s) this.V0.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.d getRevLinkLogHelper() {
        return (d31.d) this.I.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.d hb() {
        return (h41.d) this.r.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiEnterRoomTracer i7() {
        return (MultiEnterRoomTracer) this.d.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final f0 mo512if() {
        return (f0) this.b1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.a km() {
        return (com.bytedance.android.live.revlink.impl.multianchor.utils.a) this.S.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final p21.b ne() {
        return (p21.b) this.X.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.d of() {
        return (com.bytedance.android.live.revlink.impl.multianchor.utils.d) this.m.getValue();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.e q4() {
        return (d31.e) this.D.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final e0 ti() {
        return (e0) this.P1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.f uc() {
        return (com.bytedance.android.live.revlink.impl.multianchor.utils.f) this.t.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.b v2() {
        return (b21.b) this.v.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.b vh() {
        return (d31.b) this.M1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorLinkOptUtils vk() {
        return (AnchorLinkOptUtils) this.k0.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.e0 w6() {
        return (com.bytedance.android.live.revlink.impl.utils.e0) this.G1.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.f y2() {
        return (d31.f) this.A.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final l yd() {
        return (l) this.n.getValue();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.f Aa() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPkAudienceDataService");
        DataContext r2 = null;
        if ((r0 instanceof DataContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.pk.service.f) == false) goto L11;
        r2 = r0;
    L11:
        return (com.bytedance.android.live.revlink.impl.pk.service.f) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiPKLauncher Be() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(MultiPKLauncher.TAG);
        DataContext r2 = null;
        if ((r0 instanceof MultiPKLauncher) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof MultiPKLauncher) == false) goto L11;
        r2 = r0;
    L11:
        return (MultiPKLauncher) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a Bi() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPkLynxContainerService");
        if ((r0 instanceof PkLynxDataContext) == true) goto L6;
        r0 = null;
    L6:
        PkLynxDataContext r1 = (PkLynxDataContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.lynxcontainer.a> r2 = r1.getNewService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.lynxcontainer.a) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.h Cg() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(MultiAnchorLinkContext.class));
        if ((r0 instanceof MultiAnchorLinkContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof MultiAnchorLinkContext) == true) goto L9;
        r0 = null;
    L9:
        MultiAnchorLinkContext r1 = (MultiAnchorLinkContext) r0;
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.ui.h> r2 = r1.getLayoutService();
        if (r2 != null) goto L14;
        return null;
    L14:
        return (com.bytedance.android.live.revlink.impl.multianchor.ui.h) r2.getValue();
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LinkRevInternalServiceContext Cj() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(LinkRevInternalServiceContext.TAG);
        DataContext r2 = null;
        if ((r0 instanceof LinkRevInternalServiceContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof LinkRevInternalServiceContext) == false) goto L11;
        r2 = r0;
    L11:
        return (LinkRevInternalServiceContext) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.service.internal.a Do() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(LinkRevInternalServiceContext.TAG);
        if ((r0 instanceof LinkRevInternalServiceContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof LinkRevInternalServiceContext) == true) goto L9;
        r0 = null;
    L9:
        LinkRevInternalServiceContext r1 = (LinkRevInternalServiceContext) r0;
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.service.internal.a> r2 = r1.getService();
        if (r2 != null) goto L14;
        return null;
    L14:
        return (com.bytedance.android.live.revlink.impl.service.internal.a) r2.getValue();
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorRtcConnectModel Hb() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(AnchorRtcConnectModel.class));
        if ((r0 instanceof AnchorRtcConnectModel) == true) goto L7;
        r0 = null;
    L7:
        return (AnchorRtcConnectModel) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final i Hg() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IToolbarPkService");
        if ((r0 instanceof ToolbarPKServiceContext) == true) goto L6;
        r0 = null;
    L6:
        ToolbarPKServiceContext r1 = (ToolbarPKServiceContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<i> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (i) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiAnchorPkLaunchContext Ib() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.a.class));
        if ((r0 instanceof MultiAnchorPkLaunchContext) == true) goto L6;
        r0 = null;
    L6:
        MultiAnchorPkLaunchContext r1 = (MultiAnchorPkLaunchContext) r0;
        if (r1 != null) goto L9;
    L11:
        return r1;
    L9:
        if (r1.isCleared() != true) goto L11;
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e Ig() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(PkBaseDataContext.TAG);
        DataContext r2 = null;
        if ((r0 instanceof Object) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.mergepk.pkbase.e) == false) goto L11;
        r2 = r0;
    L11:
        return (com.bytedance.android.live.revlink.impl.mergepk.pkbase.e) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final IPkAudienceLoadService Ik() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPkAudienceLoadService");
        DataContext r2 = null;
        if ((r0 instanceof DataContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof IPkAudienceLoadService) == false) goto L11;
        r2 = r0;
    L11:
        return (IPkAudienceLoadService) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a K4() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPkBaseWidgetService");
        if ((r0 instanceof PkWidgetDataContext) == true) goto L6;
        r0 = null;
    L6:
        PkWidgetDataContext r1 = (PkWidgetDataContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.pk.scopeservice.a> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.pk.scopeservice.a) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c K8() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(PkDoubleDataContext.TAG);
        DataContext r2 = null;
        if ((r0 instanceof Object) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c) == false) goto L11;
        r2 = r0;
    L11:
        return (com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b L1() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(PkDoubleAnchorDataContext.TAG);
        DataContext r2 = null;
        if ((r0 instanceof Object) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b) == false) goto L11;
        r2 = r0;
    L11:
        return (com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RevLinkMultiChannelDataContext Lj() {
        RevLinkMultiChannelDataContext.Companion.getClass();
        DataContext r0 = com.bytedance.live.datacontext.d.d(RevLinkMultiChannelDataContext.access$getTAG$cp());
        if ((r0 instanceof RevLinkMultiChannelDataContext) == true) goto L7;
        r0 = null;
    L7:
        return (RevLinkMultiChannelDataContext) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.g M2() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(MultiDynamicLocalContext.class));
        if ((r0 instanceof MultiDynamicLocalContext) == true) goto L6;
        r0 = null;
    L6:
        MultiDynamicLocalContext r1 = (MultiDynamicLocalContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.dynamic.g> r2 = r1.getLocalComponentService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.multianchor.dynamic.g) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.c Oj() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("anchor_audio_punish_context");
        if ((r0 instanceof LinkAudioPunishContext) == true) goto L7;
        r0 = null;
    L7:
        return (com.bytedance.android.live.revlink.impl.mergepk.pkbase.c) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RevLinkWindowRegionContext P8() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(RevLinkWindowRegionContext.TAG);
        DataContext r2 = null;
        if ((r0 instanceof RevLinkWindowRegionContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof RevLinkWindowRegionContext) == false) goto L11;
        r2 = r0;
    L11:
        return (RevLinkWindowRegionContext) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b Q1() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(PkMultiDataContext.TAG);
        DataContext r2 = null;
        if ((r0 instanceof Object) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b) == false) goto L11;
        r2 = r0;
    L11:
        return (com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.d R8() {
        Intrinsics.checkNotNullParameter(MultiLinkControlContext.Companion, "$this$TAG");
        DataContext r0 = com.bytedance.live.datacontext.d.d("MultiLinkControlContext");
        if ((r0 instanceof MultiLinkControlContext) == true) goto L6;
        r0 = null;
    L6:
        MultiLinkControlContext r1 = (MultiLinkControlContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.d> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.multianchor.service.d) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.control.d Rc() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("anchor_log_params_context");
        if ((r0 instanceof AnchorLogParamsContext) == true) goto L7;
        r0 = null;
    L7:
        return (com.bytedance.android.live.revlink.impl.control.d) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c U7() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c.class));
        DataContext r2 = null;
        if ((r0 instanceof Object) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c) == false) goto L11;
        r2 = r0;
    L11:
        return (com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.b Ud() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPKControlService");
        if ((r0 instanceof PKControlServiceContext) == true) goto L6;
        r0 = null;
    L6:
        PKControlServiceContext r1 = (PKControlServiceContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.pk.service.b> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.pk.service.b) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.h V0() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPkService");
        if ((r0 instanceof PkServiceContext) == true) goto L6;
        r0 = null;
    L6:
        PkServiceContext r1 = (PkServiceContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.pk.service.h> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.pk.service.h) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.precisefind.a Wd() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(MultiPkPreciseFindContext.class));
        if ((r0 instanceof MultiPkPreciseFindContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof MultiPkPreciseFindContext) == true) goto L9;
        r0 = null;
    L9:
        MultiPkPreciseFindContext r1 = (MultiPkPreciseFindContext) r0;
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.precisefind.a> r2 = r1.getService();
        if (r2 != null) goto L14;
        return null;
    L14:
        return (com.bytedance.android.live.revlink.impl.precisefind.a) r2.getValue();
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.c Yi() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPKCustomizePlayDataService");
        if ((r0 instanceof PkCustomizePlayDataContext) == true) goto L7;
        r0 = null;
    L7:
        return (PkCustomizePlayDataContext) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.connect.f Z0() {
        return this.S1.Z0();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.b d6() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(MultiAnchorLinkContext.class));
        if ((r0 instanceof MultiAnchorLinkContext) == true) goto L6;
        r0 = null;
    L6:
        MultiAnchorLinkContext r1 = (MultiAnchorLinkContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.b> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.multianchor.service.b) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final TopBannerDetailsDataContext e7() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(TopBannerDetailsDataContext.TAG);
        DataContext r2 = null;
        if ((r0 instanceof DataContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof TopBannerDetailsDataContext) == false) goto L11;
        r2 = r0;
    L11:
        return (TopBannerDetailsDataContext) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.connect.g getAnchorConnectUtils() {
        return this.S1.getAnchorConnectUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.f getRevenueLinkTraceMonitor() {
        return this.S1.getRevenueLinkTraceMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiPkMatchContext gf() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(MultiPkMatchContext.class));
        DataContext r2 = null;
        if ((r0 instanceof MultiPkMatchContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof MultiPkMatchContext) == false) goto L11;
        r2 = r0;
    L11:
        return (MultiPkMatchContext) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RelinkDataContext ih() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(RelinkDataContext.class));
        DataContext r2 = null;
        if ((r0 instanceof RelinkDataContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof RelinkDataContext) == false) goto L11;
        r2 = r0;
    L11:
        return (RelinkDataContext) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.a ja() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPKAutoMatchService");
        if ((r0 instanceof PKAutoMatchServiceContext) == true) goto L6;
        r0 = null;
    L6:
        PKAutoMatchServiceContext r1 = (PKAutoMatchServiceContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.pk.service.a> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.pk.service.a) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.g jo() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPkBattleReserveService");
        if ((r0 instanceof PkReserveBattleDataContext) == true) goto L7;
        r0 = null;
    L7:
        return (PkReserveBattleDataContext) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final n21.a ll() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(MultiAnchorLinkContext.class));
        if ((r0 instanceof MultiAnchorLinkContext) == true) goto L6;
        r0 = null;
    L6:
        MultiAnchorLinkContext r1 = (MultiAnchorLinkContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<n21.a> r2 = r1.getCommonService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (n21.a) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.e lo() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPKPrecisionMatchService");
        if ((r0 instanceof PkPrecisionMatchDataContext) == true) goto L7;
        r0 = null;
    L7:
        return (PkPrecisionMatchDataContext) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.rtc.f m0() {
        return this.S1.m0();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final IPKLinkBizDataService mk() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPKLinkBizDataService");
        DataContext r2 = null;
        if ((r0 instanceof DataContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof IPKLinkBizDataService) == false) goto L11;
        r2 = r0;
    L11:
        return (IPKLinkBizDataService) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.g n9() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IMultiEnlargeService");
        if ((r0 instanceof MultiEnLargeContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof MultiEnLargeContext) == true) goto L9;
        r0 = null;
    L9:
        MultiEnLargeContext r1 = (MultiEnLargeContext) r0;
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.ui.g> r2 = r1.getEnlargeService();
        if (r2 != null) goto L14;
        return null;
    L14:
        return (com.bytedance.android.live.revlink.impl.multianchor.ui.g) r2.getValue();
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.d o9() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPKLinkDataService");
        DataContext r2 = null;
        if ((r0 instanceof DataContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.pk.service.d) == false) goto L11;
        r2 = r0;
    L11:
        return (com.bytedance.android.live.revlink.impl.pk.service.d) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c p6() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(MultiDynamicLocalContext.class));
        if ((r0 instanceof MultiDynamicLocalContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof MultiDynamicLocalContext) == true) goto L9;
        r0 = null;
    L9:
        MultiDynamicLocalContext r1 = (MultiDynamicLocalContext) r0;
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c> r2 = r1.getTopReserveContext();
        if (r2 != null) goto L14;
        return null;
    L14:
        return (com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c) r2.getValue();
    L15:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.b rb() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(MultiAnchorLinkContext.class));
        if ((r0 instanceof MultiAnchorLinkContext) == true) goto L7;
        r0 = null;
    L7:
        return (com.bytedance.android.live.revlink.impl.multianchor.vm.b) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final PkCustomizePlayDataContext tf() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPKCustomizePlayDataService");
        if ((r0 instanceof PkCustomizePlayDataContext) == true) goto L7;
        r0 = null;
    L7:
        return (PkCustomizePlayDataContext) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiLinkAnchorControlContext ua() {
        Intrinsics.checkNotNullParameter(MultiLinkControlContext.Companion, "$this$TAG");
        DataContext r0 = com.bytedance.live.datacontext.d.d("MultiLinkControlContext");
        if ((r0 instanceof MultiLinkControlContext) == true) goto L6;
        r0 = null;
    L6:
        MultiLinkControlContext r1 = (MultiLinkControlContext) r0;
        if ((r1 instanceof MultiLinkAnchorControlContext) == true) goto L9;
        return null;
    L9:
        return (MultiLinkAnchorControlContext) r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiCommonPkDataContext uk() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(MultiCommonPkDataContext.TAG);
        DataContext r2 = null;
        if ((r0 instanceof MultiCommonPkDataContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof MultiCommonPkDataContext) == false) goto L11;
        r2 = r0;
    L11:
        return (MultiCommonPkDataContext) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final ProfitInteractionDataContext vj() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(ProfitInteractionDataContext.class));
        DataContext r2 = null;
        if ((r0 instanceof ProfitInteractionDataContext) == true) goto L7;
        r0 = null;
    L7:
        if ((r0 instanceof ProfitInteractionDataContext) == false) goto L11;
        r2 = r0;
    L11:
        return (ProfitInteractionDataContext) r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a w2() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("IPkLynxContainerService");
        if ((r0 instanceof PkLynxDataContext) == true) goto L6;
        r0 = null;
    L6:
        PkLynxDataContext r1 = (PkLynxDataContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.lynxcontainer.a> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.lynxcontainer.a) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.h wo() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("MultiLinkPreloadWidget" + this.T1.getRoomContext().getCommonRoom().getIdStr());
        if ((r0 instanceof RevLinkPreloadContext) == true) goto L6;
        r0 = null;
    L6:
        RevLinkPreloadContext r1 = (RevLinkPreloadContext) r0;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.h> r2 = r1.getService();
        if (r2 != null) goto L11;
        return null;
    L11:
        return (com.bytedance.android.live.revlink.impl.multianchor.service.h) r2.getValue();
    L12:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final k z0() {
        return this.S1.z0();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.match.a Mf() {
        MultiPkMatchContext r0 = gf();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.match.a> r1 = r0.getService();
        if (r1 == null) goto L7;
        return (com.bytedance.android.live.revlink.impl.multianchor.match.a) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.c O4() {
        MultiAnchorPkLaunchContext r0 = Ib();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.c> r1 = r0.getService();
        if (r1 == null) goto L7;
        return (com.bytedance.android.live.revlink.impl.multianchor.service.c) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.e Ta() {
        com.bytedance.android.live.revlink.impl.multianchor.service.d r0 = R8();
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.multianchor.service.e) == true) goto L6;
        r0 = null;
    L6:
        return (com.bytedance.android.live.revlink.impl.multianchor.service.e) r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final i11.b c8() {
        LinkRevInternalServiceContext r0 = Cj();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<AnchorLinkUserCenterV2> r1 = r0.getLinkUserCenter();
        if (r1 == null) goto L7;
        return (AnchorLinkUserCenterV2) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a u5() {
        com.bytedance.android.live.revlink.impl.multianchor.service.d r0 = R8();
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.multianchor.service.a) == true) goto L6;
        r0 = null;
    L6:
        return (com.bytedance.android.live.revlink.impl.multianchor.service.a) r0;
    }

    public static final ld.a a(LinkFakeGlobalService r1) {
        cy0.c r2 = r1.Q1;
        m.e.getClass();
        return (ld.a) m.b(r2).a(Reflection.getOrCreateKotlinClass(ld.a.class));
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final <T extends DataContext> T T6(Object r3, T r4) {
        Intrinsics.checkNotNullParameter(r4, "dataContext");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "dataContext");
        com.bytedance.live.datacontext.b.a(r4, r3);
        return r4;
    }

    public LinkFakeGlobalService(cy0.c r2, com.bytedance.android.live.revenuelink.withroom.a r3, com.bytedance.android.livesdk.revenue.service.room.c r4, com.bytedance.android.livesdk.revenue.service.user.a r5, com.bytedance.android.livesdk.revenue.service.interact.d r6) {
        Intrinsics.checkNotNullParameter(r2, "revenueDataScope");
        Intrinsics.checkNotNullParameter(r3, "linkStoreService");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        Intrinsics.checkNotNullParameter(r6, "revInternalService");
        this.Q1 = r2;
        this.S1 = r3;
        this.T1 = r4;
        this.V1 = r5;
        this.b2 = r6;
        this.a = new a();
        this.b = LazyKt.lazy(new LinkFakeGlobalService$autoMatchManager$2(this));
        this.c = LazyKt.lazy(new LinkFakeGlobalService$multiLinkMonitor$2(this));
        this.d = LazyKt.lazy(new LinkFakeGlobalService$multiEnterRoomTracer$2(this));
        this.e = LazyKt.lazy(new LinkFakeGlobalService$pkEnterRoomTracer$2(this));
        this.f = LazyKt.lazy(new LinkFakeGlobalService$multiMatchMonitor$2(this));
        this.g = LazyKt.lazy(new LinkFakeGlobalService$rtcConnectMonitor$2(this));
        this.h = LazyKt.lazy(new LinkFakeGlobalService$multiPkMonitor$2(this));
        this.i = LazyKt.lazy(new LinkFakeGlobalService$revLinkAudienceMonitor$2(this));
        this.j = LazyKt.lazy(new LinkFakeGlobalService$profitInteractionMonitor$2(this));
        this.k = LazyKt.lazy(new LinkFakeGlobalService$seiLoadMonitor$2(this));
        this.l = LazyKt.lazy(new LinkFakeGlobalService$pkBaseMonitor$2(this));
        this.m = LazyKt.lazy(new LinkFakeGlobalService$anchorLinkStateCheckerObj$2(this));
        this.n = LazyKt.lazy(new LinkFakeGlobalService$connectionStateMonitorObj$2(this));
        this.o = LazyKt.lazy(new LinkFakeGlobalService$anchorConnectionContextObj$2(this));
        this.p = LazyKt.lazy(new LinkFakeGlobalService$linkCrossRoomDataHolder$2(this));
        this.q = LazyKt.lazy(new LinkFakeGlobalService$connectionDataLogUtils$2(this));
        this.r = LazyKt.lazy(new LinkFakeGlobalService$livePkLogger$2(this));
        this.s = LazyKt.lazy(new LinkFakeGlobalService$pkBaseLogger$2(this));
        this.t = LazyKt.lazy(new LinkFakeGlobalService$baseMultiAnchorMonitorObj$2(this));
        this.u = LazyKt.lazy(new LinkFakeGlobalService$liveFullLinkPKMonitor$2(this));
        this.v = LazyKt.lazy(new LinkFakeGlobalService$bizLauncherMonitor$2(this));
        this.w = LazyKt.lazy(new LinkFakeGlobalService$pkLauncherMonitor$2(this));
        this.x = LazyKt.lazy(new LinkFakeGlobalService$liveInviteLogger$2(this));
        this.y = LazyKt.lazy(new LinkFakeGlobalService$multiAnchorLinkContextObj$2(this));
        this.z = LazyKt.lazy(new LinkFakeGlobalService$anchorLinkMonitorUtils$2(this));
        this.A = LazyKt.lazy(new LinkFakeGlobalService$revLinkRDLogger$2(this));
        this.B = LazyKt.lazy(new LinkFakeGlobalService$battleInviteLogger$2(this));
        this.C = LazyKt.lazy(new LinkFakeGlobalService$revLinkConLogger$2(this));
        this.D = LazyKt.lazy(new LinkFakeGlobalService$revLinkPanelLogger$2(this));
        this.E = LazyKt.lazy(new LinkFakeGlobalService$multiAnchorLinkLogUtils$2(this));
        this.F = LazyKt.lazy(new LinkFakeGlobalService$multiPkMatchLogUtils$2(this));
        this.G = LazyKt.lazy(new LinkFakeGlobalService$pkSwitchLogger$2(this));
        this.H = LazyKt.lazy(new LinkFakeGlobalService$pkLinkUtils$2(this));
        this.I = LazyKt.lazy(new LinkFakeGlobalService$revLinkLogHelper$2(this));
        this.J = LazyKt.lazy(new LinkFakeGlobalService$clientAttachedInfoObj$2(this));
        this.K = LazyKt.lazy(new LinkFakeGlobalService$pkUtils$2(this));
        this.L = LazyKt.lazy(new LinkFakeGlobalService$profitLinkScoreLogUtils$2(this));
        this.M = LazyKt.lazy(new LinkFakeGlobalService$revLinkCommonLogFilter$2(this));
        this.N = LazyKt.lazy(new LinkFakeGlobalService$linkPlayHelper$2(this));
        this.O = LazyKt.lazy(new LinkFakeGlobalService$pKBaseUtils$2(this));
        this.P = LazyKt.lazy(new LinkFakeGlobalService$linkOptLogContext$2(this));
        this.Q = LazyKt.lazy(new LinkFakeGlobalService$pkTitleLogUtils$2(this));
        this.R = LazyKt.lazy(new LinkFakeGlobalService$revLinkSeiCreatorObj$2(this));
        this.S = LazyKt.lazy(new LinkFakeGlobalService$anchorLinkFullEnlargeUtils$2(this));
        this.T = LazyKt.lazy(new LinkFakeGlobalService$multiPkUtils$2(this));
        this.U = LazyKt.lazy(new LinkFakeGlobalService$pkDoubleUtils$2(this));
        this.V = LazyKt.lazy(new LinkFakeGlobalService$linkCrossRoomLogger$2(this));
        this.W = LazyKt.lazy(new LinkFakeGlobalService$revSpatialAudioUtils$2(this));
        this.X = LazyKt.lazy(new LinkFakeGlobalService$multiEnlargeUtils$2(this));
        this.Y = LazyKt.lazy(new LinkFakeGlobalService$revSpatialAudioStrategyManager$2(this));
        this.Z = LazyKt.lazy(LinkFakeGlobalService$anchorLinkAudienceOptUtils$2.INSTANCE);
        this.k0 = LazyKt.lazy(new LinkFakeGlobalService$anchorLinkOptUtils$2(this));
        this.p0 = LazyKt.lazy(new LinkFakeGlobalService$linkingInvitePreloadUtilsObj$2(this));
        this.H0 = LazyKt.lazy(new LinkFakeGlobalService$linkNetwork$2(this));
        this.L0 = LazyKt.lazy(new LinkFakeGlobalService$linkStreamRegionUtils$2(this));
        this.P0 = LazyKt.lazy(new LinkFakeGlobalService$clearScreenLinkUtils$2(this));
        this.V0 = LazyKt.lazy(new LinkFakeGlobalService$revLinkCommonUtil$2(this));
        this.b1 = LazyKt.lazy(new LinkFakeGlobalService$revControlMonitor$2(this));
        this.g1 = LazyKt.lazy(new LinkFakeGlobalService$mergePkHelper$2(this));
        this.h1 = LazyKt.lazy(new LinkFakeGlobalService$pkBaseResultDataContextObj$2(this));
        this.k1 = LazyKt.lazy(new LinkFakeGlobalService$multiLinkUtil$2(this));
        this.p1 = LazyKt.lazy(new LinkFakeGlobalService$pKInviteControlUtils$2(this));
        this.v1 = LazyKt.lazy(new LinkFakeGlobalService$modeMerge$2(this));
        this.x1 = LazyKt.lazy(new LinkFakeGlobalService$matchInviteRefuseUtils$2(this));
        this.y1 = LazyKt.lazy(LinkFakeGlobalService$revLinkUtils$2.INSTANCE);
        this.G1 = LazyKt.lazy(new LinkFakeGlobalService$windowDiffCheckUtil$2(this));
        this.H1 = LazyKt.lazy(new LinkFakeGlobalService$precisionMatchMonitor$2(this));
        this.L1 = LazyKt.lazy(new LinkFakeGlobalService$linkStartLogger$2(this));
        this.M1 = LazyKt.lazy(new LinkFakeGlobalService$multiAnchorLogger$2(this));
        this.P1 = LazyKt.lazy(new LinkFakeGlobalService$relinkMonitor$2(this));
    }
}
