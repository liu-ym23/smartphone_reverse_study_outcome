package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkAudienceOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.f0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.service.IPkAudienceLoadService;
import com.bytedance.android.live.revlink.impl.pk.service.TopBannerDetailsDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.impl.utils.a0;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.revenue.platform.api.core.rx.o;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements b, d {
    public final NextLiveData<RevSeiFrame> a;
    public final PublishSubject<Unit> b;
    public final NextLiveData<String> c;
    public final RevLinkBizContext d;
    public final sc0.b e;
    public final sc0.d f;
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.h g;

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final m51.f A7() {
        return this.d.A7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.f Aa() {
        return this.d.Aa();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.a B8() {
        return this.d.B8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiPKLauncher Be() {
        return this.d.Be();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.profit.d Bg() {
        return this.d.Bg();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a Bi() {
        return this.d.Bi();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.h Cg() {
        return this.d.Cg();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LinkRevInternalServiceContext Cj() {
        return this.d.Cj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.service.internal.a Do() {
        return this.d.Do();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.audience.g Ee() {
        return this.d.Ee();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.match.f F8() {
        return this.d.F8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.f Fb() {
        return this.d.Fb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.e Gm() {
        return this.d.Gm();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorRtcConnectModel Hb() {
        return this.d.Hb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.i Hg() {
        return this.d.Hg();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiAnchorPkLaunchContext Ib() {
        return this.d.Ib();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e Ig() {
        return this.d.Ig();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final IPkAudienceLoadService Ik() {
        return this.d.Ik();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a K4() {
        return this.d.K4();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c K8() {
        return this.d.K8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b L1() {
        return this.d.L1();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RevLinkMultiChannelDataContext Lj() {
        return this.d.Lj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.g M2() {
        return this.d.M2();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.match.a Mf() {
        return this.d.Mf();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.a Nl() {
        return this.d.Nl();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.c O4() {
        return this.d.O4();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.c Oj() {
        return this.d.Oj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final k21.a P7() {
        return this.d.P7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RevLinkWindowRegionContext P8() {
        return this.d.P8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final v Pa() {
        return this.d.Pa();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final Disposable Pi(Function1<? super b03.b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "change");
        return this.d.Pi(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b Q1() {
        return this.d.Q1();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.profit.a Qj() {
        return this.d.Qj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.d R8() {
        return this.d.R8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final f21.b Rb() {
        return this.d.Rb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.control.d Rc() {
        return this.d.Rc();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.a Rj() {
        return this.d.Rj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final g0 Rn() {
        return this.d.Rn();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final <T extends DataContext> T T6(Object r2, T r3) {
        Intrinsics.checkNotNullParameter(r3, "dataContext");
        return (T) this.d.T6(r2, r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.e Ta() {
        return this.d.Ta();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b0 Tj() {
        return this.d.Tj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c U7() {
        return this.d.U7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.b Ud() {
        return this.d.Ud();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.h V0() {
        return this.d.V0();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.precisefind.a Wd() {
        return this.d.Wd();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g Yg() {
        return this.d.Yg();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.c Yi() {
        return this.d.Yi();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.connect.f Z0() {
        return this.d.Z0();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorLinkAudienceOptUtils a3() {
        return this.d.a3();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final i11.b c8() {
        return this.d.c8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.b d6() {
        return this.d.d6();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final TopBannerDetailsDataContext e7() {
        return this.d.e7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e el() {
        return this.d.el();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final a0 fl() {
        return this.d.fl();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.connect.g getAnchorConnectUtils() {
        return this.d.getAnchorConnectUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final i41.a getAutoMatchManager() {
        return this.d.getAutoMatchManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.b getClearScreenLinkUtils() {
        return this.d.getClearScreenLinkUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final e21.b getClientAttachedInfoObj() {
        return this.d.getClientAttachedInfoObj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.a getConnectionDataLogUtils() {
        return this.d.getConnectionDataLogUtils();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final int getContainerWidth() {
        return this.d.getContainerWidth();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LinkCrossRoomDataHolder getLinkCrossRoomDataHolder() {
        return this.d.getLinkCrossRoomDataHolder();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final r31.a getLinkNetwork() {
        return this.d.getLinkNetwork();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e getLinkOptLogContext() {
        return this.d.getLinkOptLogContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f getLinkPlayHelper() {
        return this.d.getLinkPlayHelper();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.utils.h getLinkStreamRegionUtils() {
        return this.d.getLinkStreamRegionUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LiveFullLinkPKMonitor getLiveFullLinkPKMonitor() {
        return this.d.getLiveFullLinkPKMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.c getLiveInviteLogger() {
        return this.d.getLiveInviteLogger();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final m41.a getMatchInviteRefuseUtils() {
        return this.d.getMatchInviteRefuseUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d21.d getMergePkHelper() {
        return this.d.getMergePkHelper();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final ox0.a getModeMerge() {
        return this.d.getModeMerge();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.g getMultiAnchorLinkContextObj() {
        return this.d.getMultiAnchorLinkContextObj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final q getMultiAnchorLinkLogUtils() {
        return this.d.getMultiAnchorLinkLogUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.v getMultiLinkMonitor() {
        return this.d.getMultiLinkMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w getMultiLinkUtil() {
        return this.d.getMultiLinkUtil();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final z getMultiPkMonitor() {
        return this.d.getMultiPkMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.f getPKBaseUtils() {
        return this.d.getPKBaseUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.utils.j getPKInviteControlUtils() {
        return this.d.getPKInviteControlUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final a21.a getPkBaseLogger() {
        return this.d.getPkBaseLogger();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.d getPkBaseMonitor() {
        return this.d.getPkBaseMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.e getPkBaseResultDataContextObj() {
        return this.d.getPkBaseResultDataContextObj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.monitor.b getPkEnterRoomTracer() {
        return this.d.getPkEnterRoomTracer();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.c getPkLinkUtils() {
        return this.d.getPkLinkUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.f getPkSwitchLogger() {
        return this.d.getPkSwitchLogger();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.utils.q getPkUtils() {
        return this.d.getPkUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.e getPrecisionMatchMonitor() {
        return this.d.getPrecisionMatchMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final s getRevLinkCommonUtil() {
        return this.d.getRevLinkCommonUtil();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.d getRevLinkLogHelper() {
        return this.d.getRevLinkLogHelper();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.f getRevenueLinkTraceMonitor() {
        return this.d.getRevenueLinkTraceMonitor();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final IRoom getRoom() {
        return this.d.getRoom();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiPkMatchContext gf() {
        return this.d.gf();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.d hb() {
        return this.d.hb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiEnterRoomTracer i7() {
        return this.d.i7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    /* JADX INFO: renamed from: if */
    public final f0 mo512if() {
        return this.d.mo512if();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RelinkDataContext ih() {
        return this.d.ih();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.a ja() {
        return this.d.ja();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.g jo() {
        return this.d.jo();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.a km() {
        return this.d.km();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final int l() {
        return this.d.l();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final n21.a ll() {
        return this.d.ll();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.e lo() {
        return this.d.lo();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.rtc.f m0() {
        return this.d.m0();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final IPKLinkBizDataService mk() {
        return this.d.mk();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.g n9() {
        return this.d.n9();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final p21.b ne() {
        return this.d.ne();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.d o9() {
        return this.d.o9();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.d of() {
        return this.d.of();
    }

    public final void onStart() {
        this.d.getClass();
    }

    public final void onStop() {
        this.d.getClass();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c p6() {
        return this.d.p6();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.e q4() {
        return this.d.q4();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.b rb() {
        return this.d.rb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final PkCustomizePlayDataContext tf() {
        return this.d.tf();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final e0 ti() {
        return this.d.ti();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a u5() {
        return this.d.u5();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiLinkAnchorControlContext ua() {
        return this.d.ua();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.f uc() {
        return this.d.uc();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiCommonPkDataContext uk() {
        return this.d.uk();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.b v2() {
        return this.d.v2();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.b vh() {
        return this.d.vh();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final ProfitInteractionDataContext vj() {
        return this.d.vj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorLinkOptUtils vk() {
        return this.d.vk();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a w2() {
        return this.d.w2();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.e0 w6() {
        return this.d.w6();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.h wo() {
        return this.d.wo();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final Disposable x7(Function0<Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onResume");
        Intrinsics.checkNotNullParameter(r3, "onPause");
        return this.d.x7(r2, r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.f y2() {
        return this.d.y2();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.l yd() {
        return this.d.yd();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.connect.k z0() {
        return this.d.z0();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final String Ab() {
        return this.d.k;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final long G() {
        return this.d.p;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final PublishSubject<Integer> a9() {
        return this.d.f;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final NextLiveData<Long> bo() {
        return this.d.g;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final String eg() {
        return this.d.n;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final AnchorLinkUserCenterV2 getAnchorLinkUserCenter() {
        return this.d.d;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final x11.a getInternalLinkService() {
        return this.d.z;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final ld.a getLinkDataSet() {
        return this.d.y;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final wq2.f getRoomDataCenterService() {
        return this.d.v;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final long getRoomID() {
        return this.d.m;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final int getScene() {
        return this.d.o;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final NextLiveData<o51.e> getUiLayout() {
        return this.d.i;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final NextLiveData<f31.f> hh() {
        return this.d.h;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.m im() {
        return this.d.C;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final x51.a k4() {
        return this.d.u;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.l md() {
        return this.d.A;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final boolean r9() {
        return this.d.l;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final PublishSubject<m> t() {
        return this.d.e;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b
    public final sc0.d G6() {
        return this.f;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b
    public final sc0.b W0() {
        return this.e;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b
    public final PublishSubject<Unit> ci() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.h getCommonService() {
        return this.g;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b
    public final NextLiveData<RevSeiFrame> lb() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b
    public final NextLiveData<String> ul() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.j getCommonService() {
        return this.g;
    }

    public h(RevLinkBizContext r2, sc0.b r3, sc0.d r4, com.bytedance.android.live.revlink.link.domain.anchorimpl.h r5) {
        Intrinsics.checkNotNullParameter(r2, "baseContext");
        Intrinsics.checkNotNullParameter(r5, "commonService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new NextLiveData();
        int r6 = o.a;
        this.b = PublishSubject.create();
        this.c = new NextLiveData();
    }
}
