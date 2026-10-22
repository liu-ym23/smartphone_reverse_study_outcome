package com.bytedance.android.live.revlink.impl.global;

import b21.e;
import com.bytedance.android.live.revenuelink.connect.k;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.audience.g;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.h;
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
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.pk.service.TopBannerDetailsDataContext;
import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.android.live.revlink.impl.pk.utils.j;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.impl.utils.a0;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.DataContext;
import m51.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c extends o {
    f A7();

    com.bytedance.android.live.revlink.impl.pk.service.f Aa();

    com.bytedance.android.live.revlink.impl.utils.a B8();

    MultiPKLauncher Be();

    com.bytedance.android.live.revlink.impl.multianchor.profit.d Bg();

    com.bytedance.android.live.revlink.impl.lynxcontainer.a Bi();

    h Cg();

    LinkRevInternalServiceContext Cj();

    com.bytedance.android.live.revlink.impl.service.internal.a Do();

    g Ee();

    com.bytedance.android.live.revlink.impl.multianchor.match.f F8();

    com.bytedance.android.live.revlink.impl.multianchor.vm.f Fb();

    e Gm();

    AnchorRtcConnectModel Hb();

    i Hg();

    MultiAnchorPkLaunchContext Ib();

    com.bytedance.android.live.revlink.impl.mergepk.pkbase.e Ig();

    IPkAudienceLoadService Ik();

    com.bytedance.android.live.revlink.impl.pk.scopeservice.a K4();

    com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c K8();

    com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b L1();

    RevLinkMultiChannelDataContext Lj();

    com.bytedance.android.live.revlink.impl.multianchor.dynamic.g M2();

    com.bytedance.android.live.revlink.impl.multianchor.match.a Mf();

    h41.a Nl();

    com.bytedance.android.live.revlink.impl.multianchor.service.c O4();

    com.bytedance.android.live.revlink.impl.mergepk.pkbase.c Oj();

    k21.a P7();

    RevLinkWindowRegionContext P8();

    v Pa();

    com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b Q1();

    com.bytedance.android.live.revlink.impl.multianchor.profit.a Qj();

    com.bytedance.android.live.revlink.impl.multianchor.service.d R8();

    f21.b Rb();

    com.bytedance.android.live.revlink.impl.control.d Rc();

    b21.a Rj();

    g0 Rn();

    <T extends DataContext> T T6(Object r1, T r2);

    com.bytedance.android.live.revlink.impl.multianchor.service.e Ta();

    b0 Tj();

    com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c U7();

    com.bytedance.android.live.revlink.impl.pk.service.b Ud();

    com.bytedance.android.live.revlink.impl.pk.service.h V0();

    com.bytedance.android.live.revlink.impl.precisefind.a Wd();

    com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g Yg();

    com.bytedance.android.live.revlink.impl.pk.service.c Yi();

    com.bytedance.android.live.revenuelink.connect.f Z0();

    AnchorLinkAudienceOptUtils a3();

    i11.b c8();

    com.bytedance.android.live.revlink.impl.multianchor.service.b d6();

    TopBannerDetailsDataContext e7();

    com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e el();

    a0 fl();

    com.bytedance.android.live.revenuelink.connect.g getAnchorConnectUtils();

    i41.a getAutoMatchManager();

    com.bytedance.android.live.revlink.impl.utils.b getClearScreenLinkUtils();

    e21.b getClientAttachedInfoObj();

    w31.a getConnectionDataLogUtils();

    LinkCrossRoomDataHolder getLinkCrossRoomDataHolder();

    r31.a getLinkNetwork();

    com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e getLinkOptLogContext();

    com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f getLinkPlayHelper();

    com.bytedance.android.live.revlink.impl.pk.utils.h getLinkStreamRegionUtils();

    LiveFullLinkPKMonitor getLiveFullLinkPKMonitor();

    h41.c getLiveInviteLogger();

    m41.a getMatchInviteRefuseUtils();

    d21.d getMergePkHelper();

    ox0.a getModeMerge();

    com.bytedance.android.live.revlink.impl.multianchor.vm.g getMultiAnchorLinkContextObj();

    q getMultiAnchorLinkLogUtils();

    com.bytedance.android.live.revlink.impl.multianchor.utils.v getMultiLinkMonitor();

    w getMultiLinkUtil();

    z getMultiPkMonitor();

    com.bytedance.android.live.revlink.impl.mergepk.pkbase.f getPKBaseUtils();

    j getPKInviteControlUtils();

    a21.a getPkBaseLogger();

    b21.d getPkBaseMonitor();

    com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.e getPkBaseResultDataContextObj();

    com.bytedance.android.live.revlink.impl.monitor.b getPkEnterRoomTracer();

    w31.c getPkLinkUtils();

    h41.f getPkSwitchLogger();

    com.bytedance.android.live.revlink.impl.pk.utils.q getPkUtils();

    w31.e getPrecisionMatchMonitor();

    s getRevLinkCommonUtil();

    d31.d getRevLinkLogHelper();

    com.bytedance.android.live.revenuelink.f getRevenueLinkTraceMonitor();

    MultiPkMatchContext gf();

    h41.d hb();

    MultiEnterRoomTracer i7();

    /* JADX INFO: renamed from: if */
    f0 mo512if();

    RelinkDataContext ih();

    com.bytedance.android.live.revlink.impl.pk.service.a ja();

    com.bytedance.android.live.revlink.impl.pk.service.g jo();

    com.bytedance.android.live.revlink.impl.multianchor.utils.a km();

    n21.a ll();

    com.bytedance.android.live.revlink.impl.pk.service.e lo();

    com.bytedance.android.live.revenuelink.rtc.f m0();

    IPKLinkBizDataService mk();

    com.bytedance.android.live.revlink.impl.multianchor.ui.g n9();

    p21.b ne();

    com.bytedance.android.live.revlink.impl.pk.service.d o9();

    com.bytedance.android.live.revlink.impl.multianchor.utils.d of();

    com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c p6();

    d31.e q4();

    com.bytedance.android.live.revlink.impl.multianchor.vm.b rb();

    PkCustomizePlayDataContext tf();

    e0 ti();

    com.bytedance.android.live.revlink.impl.multianchor.service.a u5();

    MultiLinkAnchorControlContext ua();

    com.bytedance.android.live.revlink.impl.multianchor.utils.f uc();

    MultiCommonPkDataContext uk();

    b21.b v2();

    d31.b vh();

    ProfitInteractionDataContext vj();

    AnchorLinkOptUtils vk();

    com.bytedance.android.live.revlink.impl.lynxcontainer.a w2();

    com.bytedance.android.live.revlink.impl.utils.e0 w6();

    com.bytedance.android.live.revlink.impl.multianchor.service.h wo();

    d31.f y2();

    l yd();

    k z0();
}
