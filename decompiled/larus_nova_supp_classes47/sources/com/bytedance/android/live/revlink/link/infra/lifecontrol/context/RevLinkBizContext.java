package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

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
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkBizContext implements d, com.bytedance.android.live.revlink.impl.global.c {
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.l A;
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.j B;
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.m C;
    public final Function0<IRoom> D;
    public final List<Function0<Unit>> a;
    public final List<Function0<Unit>> b;
    public final List<Function1<b03.b, Unit>> c;
    public final AnchorLinkUserCenterV2 d;
    public final PublishSubject<m> e;
    public final PublishSubject<Integer> f;
    public final NextLiveData<Long> g;
    public final NextLiveData<f31.f> h;
    public final NextLiveData<o51.e> i;
    public Boolean j;
    public final String k;
    public final boolean l;
    public final long m;
    public final String n;
    public int o;
    public long p;
    public final Function0<Integer> q;
    public final Function0<Integer> r;
    public final o11.a s;
    public final com.bytedance.android.live.revlink.impl.global.c t;
    public final x51.a u;
    public final wq2.f v;
    public final yz0.f w;
    public final com.bytedance.android.livesdk.revenue.service.message.d x;
    public final ld.a y;
    public final x11.a z;

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final m51.f A7() {
        return this.t.A7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.f Aa() {
        return this.t.Aa();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.a B8() {
        return this.t.B8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiPKLauncher Be() {
        return this.t.Be();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.profit.d Bg() {
        return this.t.Bg();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a Bi() {
        return this.t.Bi();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.h Cg() {
        return this.t.Cg();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LinkRevInternalServiceContext Cj() {
        return this.t.Cj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.service.internal.a Do() {
        return this.t.Do();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.audience.g Ee() {
        return this.t.Ee();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.match.f F8() {
        return this.t.F8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.f Fb() {
        return this.t.Fb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.e Gm() {
        return this.t.Gm();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorRtcConnectModel Hb() {
        return this.t.Hb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.i Hg() {
        return this.t.Hg();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiAnchorPkLaunchContext Ib() {
        return this.t.Ib();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e Ig() {
        return this.t.Ig();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final IPkAudienceLoadService Ik() {
        return this.t.Ik();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a K4() {
        return this.t.K4();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c K8() {
        return this.t.K8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b L1() {
        return this.t.L1();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RevLinkMultiChannelDataContext Lj() {
        return this.t.Lj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.g M2() {
        return this.t.M2();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.match.a Mf() {
        return this.t.Mf();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.a Nl() {
        return this.t.Nl();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.c O4() {
        return this.t.O4();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.c Oj() {
        return this.t.Oj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final k21.a P7() {
        return this.t.P7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RevLinkWindowRegionContext P8() {
        return this.t.P8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final v Pa() {
        return this.t.Pa();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b Q1() {
        return this.t.Q1();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.profit.a Qj() {
        return this.t.Qj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.d R8() {
        return this.t.R8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final f21.b Rb() {
        return this.t.Rb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.control.d Rc() {
        return this.t.Rc();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.a Rj() {
        return this.t.Rj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final g0 Rn() {
        return this.t.Rn();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final <T extends DataContext> T T6(Object r2, T r3) {
        Intrinsics.checkNotNullParameter(r3, "dataContext");
        return (T) this.t.T6(r2, r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.e Ta() {
        return this.t.Ta();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b0 Tj() {
        return this.t.Tj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c U7() {
        return this.t.U7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.b Ud() {
        return this.t.Ud();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.h V0() {
        return this.t.V0();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.precisefind.a Wd() {
        return this.t.Wd();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g Yg() {
        return this.t.Yg();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.c Yi() {
        return this.t.Yi();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.connect.f Z0() {
        return this.t.Z0();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorLinkAudienceOptUtils a3() {
        return this.t.a3();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final PublishSubject<Integer> a9() {
        throw null;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final NextLiveData<Long> bo() {
        throw null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final i11.b c8() {
        return this.t.c8();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.b d6() {
        return this.t.d6();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final TopBannerDetailsDataContext e7() {
        return this.t.e7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e el() {
        return this.t.el();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final a0 fl() {
        return this.t.fl();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.connect.g getAnchorConnectUtils() {
        return this.t.getAnchorConnectUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final i41.a getAutoMatchManager() {
        return this.t.getAutoMatchManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.b getClearScreenLinkUtils() {
        return this.t.getClearScreenLinkUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final e21.b getClientAttachedInfoObj() {
        return this.t.getClientAttachedInfoObj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.a getConnectionDataLogUtils() {
        return this.t.getConnectionDataLogUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LinkCrossRoomDataHolder getLinkCrossRoomDataHolder() {
        return this.t.getLinkCrossRoomDataHolder();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final r31.a getLinkNetwork() {
        return this.t.getLinkNetwork();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e getLinkOptLogContext() {
        return this.t.getLinkOptLogContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f getLinkPlayHelper() {
        return this.t.getLinkPlayHelper();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.utils.h getLinkStreamRegionUtils() {
        return this.t.getLinkStreamRegionUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final LiveFullLinkPKMonitor getLiveFullLinkPKMonitor() {
        return this.t.getLiveFullLinkPKMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.c getLiveInviteLogger() {
        return this.t.getLiveInviteLogger();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final m41.a getMatchInviteRefuseUtils() {
        return this.t.getMatchInviteRefuseUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d21.d getMergePkHelper() {
        return this.t.getMergePkHelper();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final ox0.a getModeMerge() {
        return this.t.getModeMerge();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.g getMultiAnchorLinkContextObj() {
        return this.t.getMultiAnchorLinkContextObj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final q getMultiAnchorLinkLogUtils() {
        return this.t.getMultiAnchorLinkLogUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.v getMultiLinkMonitor() {
        return this.t.getMultiLinkMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w getMultiLinkUtil() {
        return this.t.getMultiLinkUtil();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final z getMultiPkMonitor() {
        return this.t.getMultiPkMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.f getPKBaseUtils() {
        return this.t.getPKBaseUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.utils.j getPKInviteControlUtils() {
        return this.t.getPKInviteControlUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final a21.a getPkBaseLogger() {
        return this.t.getPkBaseLogger();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.d getPkBaseMonitor() {
        return this.t.getPkBaseMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.e getPkBaseResultDataContextObj() {
        return this.t.getPkBaseResultDataContextObj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.monitor.b getPkEnterRoomTracer() {
        return this.t.getPkEnterRoomTracer();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.c getPkLinkUtils() {
        return this.t.getPkLinkUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.f getPkSwitchLogger() {
        return this.t.getPkSwitchLogger();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.utils.q getPkUtils() {
        return this.t.getPkUtils();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final w31.e getPrecisionMatchMonitor() {
        return this.t.getPrecisionMatchMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final s getRevLinkCommonUtil() {
        return this.t.getRevLinkCommonUtil();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.d getRevLinkLogHelper() {
        return this.t.getRevLinkLogHelper();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.f getRevenueLinkTraceMonitor() {
        return this.t.getRevenueLinkTraceMonitor();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final NextLiveData<o51.e> getUiLayout() {
        throw null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiPkMatchContext gf() {
        return this.t.gf();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final h41.d hb() {
        return this.t.hb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiEnterRoomTracer i7() {
        return this.t.i7();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    /* JADX INFO: renamed from: if */
    public final f0 mo512if() {
        return this.t.mo512if();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final RelinkDataContext ih() {
        return this.t.ih();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.m im() {
        throw null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.a ja() {
        return this.t.ja();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.g jo() {
        return this.t.jo();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.a km() {
        return this.t.km();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final n21.a ll() {
        return this.t.ll();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.e lo() {
        return this.t.lo();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.rtc.f m0() {
        return this.t.m0();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.l md() {
        throw null;
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final IPKLinkBizDataService mk() {
        return this.t.mk();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.g n9() {
        return this.t.n9();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final p21.b ne() {
        return this.t.ne();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.pk.service.d o9() {
        return this.t.o9();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.d of() {
        return this.t.of();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c p6() {
        return this.t.p6();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.e q4() {
        return this.t.q4();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.vm.b rb() {
        return this.t.rb();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final PkCustomizePlayDataContext tf() {
        return this.t.tf();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final e0 ti() {
        return this.t.ti();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.a u5() {
        return this.t.u5();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiLinkAnchorControlContext ua() {
        return this.t.ua();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.f uc() {
        return this.t.uc();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final MultiCommonPkDataContext uk() {
        return this.t.uk();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final b21.b v2() {
        return this.t.v2();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.b vh() {
        return this.t.vh();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final ProfitInteractionDataContext vj() {
        return this.t.vj();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final AnchorLinkOptUtils vk() {
        return this.t.vk();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a w2() {
        return this.t.w2();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.utils.e0 w6() {
        return this.t.w6();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.service.h wo() {
        return this.t.wo();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final d31.f y2() {
        return this.t.y2();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revlink.impl.multianchor.utils.l yd() {
        return this.t.yd();
    }

    @Override // com.bytedance.android.live.revlink.impl.global.c
    public final com.bytedance.android.live.revenuelink.connect.k z0() {
        return this.t.z0();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final int getContainerWidth() {
        return ((Number) this.q.invoke()).intValue();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final IRoom getRoom() {
        return (IRoom) this.D.invoke();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final int l() {
        return ((Number) this.r.invoke()).intValue();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final String Ab() {
        return this.k;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final long G() {
        return this.p;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final String eg() {
        return this.n;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final AnchorLinkUserCenterV2 getAnchorLinkUserCenter() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.j getCommonService() {
        return this.B;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final x11.a getInternalLinkService() {
        return this.z;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final ld.a getLinkDataSet() {
        return this.y;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final wq2.f getRoomDataCenterService() {
        return this.v;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final long getRoomID() {
        return this.m;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final int getScene() {
        return this.o;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final NextLiveData<f31.f> hh() {
        return this.h;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final x51.a k4() {
        return this.u;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final boolean r9() {
        return this.l;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final PublishSubject<m> t() {
        return this.e;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final Disposable Pi(final Function1<? super b03.b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "change");
        ((ArrayList) this.c).add(r2);
        int r0 = com.bytedance.revenue.platform.api.core.rx.h.a;
        return com.bytedance.revenue.platform.api.core.rx.h.a(new RevLinkBizContext$registerPlatformConfigChanged$1(this, r2));
    }

    public final void a(long r4) {
        if (r4 != this.p) goto L5;
        return;
    L5:
        this.p = r4;
        this.g.setValue(Long.valueOf(r4));
    }

    @Override // com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d
    public final Disposable x7(final Function0<Unit> r3, final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "onResume");
        Intrinsics.checkNotNullParameter(r4, "onPause");
        ((ArrayList) this.a).add(r3);
        ((ArrayList) this.b).add(r4);
        Boolean r0 = this.j;
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L6;
        r3.invoke();
    L8:
        int r1 = com.bytedance.revenue.platform.api.core.rx.h.a;
        return com.bytedance.revenue.platform.api.core.rx.h.a(new RevLinkBizContext$registerResumePause$1(this, r3, r4));
    L6:
        if (Intrinsics.areEqual(r0, Boolean.FALSE) == false) goto L8;
        r4.invoke();
        goto L8
    }

    public RevLinkBizContext(String r17, boolean r18, long r19, String r22, int r23, long r24, Function0<Integer> r25, Function0<Integer> r26, o11.a r27, com.bytedance.android.live.revlink.impl.global.c r28, x51.a r29, wq2.f r30, yz0.f r32, com.bytedance.android.livesdk.revenue.service.message.d r33, ld.a r34, x11.a r35, com.bytedance.android.live.revlink.link.domain.anchorimpl.l r36, com.bytedance.android.live.revlink.link.domain.anchorimpl.j r37, com.bytedance.android.live.revlink.link.domain.anchorimpl.m r38, Function0<? extends IRoom> r39) {
        Intrinsics.checkNotNullParameter(r17, "selfUID");
        Intrinsics.checkNotNullParameter(r22, "roomOwnerID");
        Intrinsics.checkNotNullParameter(r25, "containerWidthFn");
        Intrinsics.checkNotNullParameter(r26, "containerHeightFn");
        Intrinsics.checkNotNullParameter(r27, "linkScope");
        Intrinsics.checkNotNullParameter(r28, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r29, "lynxCentralService");
        Intrinsics.checkNotNullParameter(r30, "roomDataCenterService");
        Intrinsics.checkNotNullParameter(r32, "messageService");
        Intrinsics.checkNotNullParameter(r33, "messageManagerService");
        Intrinsics.checkNotNullParameter(r34, "linkDataSet");
        Intrinsics.checkNotNullParameter(r35, "internalLinkService");
        Intrinsics.checkNotNullParameter(r36, "performanceMonitor");
        Intrinsics.checkNotNullParameter(r37, "commonService");
        Intrinsics.checkNotNullParameter(r38, "windowService");
        Intrinsics.checkNotNullParameter(r39, "roomFn");
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r22;
        this.o = r23;
        this.p = r24;
        this.q = r25;
        this.r = r26;
        this.s = r27;
        this.t = r28;
        this.u = r29;
        this.v = r30;
        this.w = r32;
        this.x = r33;
        this.y = r34;
        this.z = r35;
        this.A = r36;
        this.B = r37;
        this.C = r38;
        this.D = r39;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        i11.b r1 = r28.c8();
        if ((r1 instanceof AnchorLinkUserCenterV2) == true) goto L5;
        r1 = null;
    L5:
        AnchorLinkUserCenterV2 r2 = (AnchorLinkUserCenterV2) r1;
        l.a(r2);
        this.d = r2;
        int r3 = o.a;
        this.e = PublishSubject.create();
        this.f = PublishSubject.create();
        this.g = new NextLiveData();
        this.h = new NextLiveData();
        this.i = new NextLiveData();
    }
}
