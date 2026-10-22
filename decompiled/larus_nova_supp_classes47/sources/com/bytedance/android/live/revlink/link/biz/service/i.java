package com.bytedance.android.live.revlink.link.biz.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.g0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.component.MultiOtherComponent;
import com.bytedance.android.livesdk.link.model.p;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public static final com.bytedance.android.live.revlink.impl.multianchor.vm.g A(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAnchorLinkContextObj");
        return getContext(r1).getMultiAnchorLinkContextObj();
    }

    public static final q B(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAnchorLinkLogUtils");
        return getContext(r1).getMultiAnchorLinkLogUtils();
    }

    public static final d31.b C(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAnchorLogger");
        return getContext(r1).vh();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.c D(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAnchorPkLaunchService");
        return getContext(r1).O4();
    }

    public static final com.bytedance.android.live.revlink.impl.control.launchcontext.b E(b r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAudienceLaunchContext");
        sc0.b r2 = r1.getContext().W0();
        if ((r2 instanceof com.bytedance.android.live.revlink.impl.control.launchcontext.b) == true) goto L6;
        r2 = null;
    L6:
        return (com.bytedance.android.live.revlink.impl.control.launchcontext.b) r2;
    }

    public static final MultiEnterRoomTracer F(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiEnterRoomTracer");
        return getContext(r1).i7();
    }

    public static final MultiLinkAnchorControlContext G(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiLinkAnchorControlContext");
        return getContext(r1).ua();
    }

    public static final v H(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiLinkMonitor");
        return getContext(r1).getMultiLinkMonitor();
    }

    public static final w I(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiLinkUtil");
        return getContext(r1).getMultiLinkUtil();
    }

    public static final MultiPkMatchContext J(MultiOtherComponent r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiPkMatchContext");
        return getContext(r1).gf();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.match.a K(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiPkMatchService");
        return getContext(r1).Mf();
    }

    public static final z L(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiPkMonitor");
        return getContext(r1).getMultiPkMonitor();
    }

    public static final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b M(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiPkService");
        return getContext(r1).Q1();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.service.a N(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pKAutoMatchService");
        return getContext(r1).ja();
    }

    public static final com.bytedance.android.live.revlink.impl.mergepk.pkbase.f O(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pKBaseUtils");
        return getContext(r1).getPKBaseUtils();
    }

    public static final IPKLinkBizDataService P(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pKLinkBizDataService");
        return getContext(r1).mk();
    }

    public static final com.bytedance.android.live.revlink.impl.control.launchcontext.c Q(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkAnchorLaunchContext");
        sc0.c r2 = r1.getContext().Wi();
        if ((r2 instanceof com.bytedance.android.live.revlink.impl.control.launchcontext.c) == true) goto L6;
        r2 = null;
    L6:
        return (com.bytedance.android.live.revlink.impl.control.launchcontext.c) r2;
    }

    public static final b21.d R(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkBaseMonitor");
        return getContext(r1).getPkBaseMonitor();
    }

    public static final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e S(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkBaseService");
        return getContext(r1).Ig();
    }

    public static final w31.c T(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkLinkUtils");
        return getContext(r1).getPkLinkUtils();
    }

    public static final com.bytedance.android.live.revlink.impl.lynxcontainer.a U(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkLynxContainerService");
        return getContext(r1).w2();
    }

    public static final h41.f V(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkSwitchLogger");
        return getContext(r1).getPkSwitchLogger();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.utils.q W(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pkUtils");
        return getContext(r1).getPkUtils();
    }

    public static final RelinkDataContext X(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$relinkDataContext");
        return getContext(r1).ih();
    }

    public static final s Y(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$revLinkCommonUtil");
        return getContext(r1).getRevLinkCommonUtil();
    }

    public static final d31.d Z(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$revLinkLogHelper");
        return getContext(r1).getRevLinkLogHelper();
    }

    public static final f a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$anchor");
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r3 = r2.getContext();
        if ((r3 instanceof com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a) == true) goto L5;
        r3 = null;
    L5:
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r4 = (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return new f(r4);
    }

    public static final RevLinkMultiChannelDataContext a0(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$revLinkMultiChannelDataContext");
        return getContext(r1).Lj();
    }

    public static final g b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$audience");
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r3 = r2.getContext();
        if ((r3 instanceof com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b) == true) goto L5;
        r3 = null;
    L5:
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r4 = (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return new g(r4);
    }

    public static final d31.f b0(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$revLinkRDLogger");
        return getContext(r1).y2();
    }

    public static final com.bytedance.android.live.revenuelink.connect.f c(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$anchorConnectService");
        return getContext(r1).Z0();
    }

    public static final RevLinkWindowRegionContext c0(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$revLinkWindowRegionContext");
        return getContext(r1).P8();
    }

    public static final com.bytedance.android.live.revenuelink.connect.g d(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$anchorConnectUtils");
        return getContext(r1).getAnchorConnectUtils();
    }

    public static final m51.f d0(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$revSpatialAudioUtils");
        return getContext(r1).A7();
    }

    public static final com.bytedance.android.live.revlink.impl.control.d e(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$anchorLogParamsService");
        return getContext(r1).Rc();
    }

    public static final String e0(j r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$roomOwnerLinkerID");
        p r3 = r2.getContext().getAnchorLinkUserCenter().getGuestInfo(r2.getContext().eg(), null);
        if (r3 == null) goto L6;
        String r4 = r3.getInteractId();
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "";
    }

    public static final com.bytedance.android.live.revenuelink.rtc.i f(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$anchorRtcManager");
        com.bytedance.android.live.revenuelink.rtc.f r2 = r1.getContext().m0();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getRtcManager();
    }

    public static final g0 f0(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$rtcConnectMonitor");
        return getContext(r1).Rn();
    }

    public static final com.bytedance.android.live.revenuelink.rtc.i g(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$anchorRtcManager");
        com.bytedance.android.live.revenuelink.rtc.f r2 = getContext(r1).m0();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getRtcManager();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.service.i g0(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toolbarPkService");
        return getContext(r1).Hg();
    }

    public static final com.bytedance.android.live.revlink.impl.global.c getContext(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$context");
        return r1.getLinkInstanceService();
    }

    public static final i41.a h(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$autoMatchManager");
        return getContext(r1).getAutoMatchManager();
    }

    public static final f21.a i(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$connectionContext");
        sc0.a r3 = r2.getContext().sd();
        if ((r3 instanceof com.bytedance.android.live.revlink.impl.control.launchcontext.a) == true) goto L5;
        r3 = null;
    L5:
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r4 = (com.bytedance.android.live.revlink.impl.control.launchcontext.a) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.b;
    }

    public static final w31.a j(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$connectionDataLogUtils");
        return getContext(r1).getConnectionDataLogUtils();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.utils.l k(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$connectionStateMonitorObj");
        return getContext(r1).yd();
    }

    public static final com.bytedance.android.live.revlink.impl.control.launchcontext.d l(b r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$doubleAudienceLaunchContext");
        sc0.d r2 = r1.getContext().G6();
        if ((r2 instanceof com.bytedance.android.live.revlink.impl.control.launchcontext.d) == true) goto L6;
        r2 = null;
    L6:
        return (com.bytedance.android.live.revlink.impl.control.launchcontext.d) r2;
    }

    public static final LinkCrossRoomDataHolder m(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$linkCrossRoomDataHolder");
        return getContext(r1).getLinkCrossRoomDataHolder();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e n(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$linkOptLogContext");
        return getContext(r1).getLinkOptLogContext();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f o(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$linkPlayHelper");
        return getContext(r1).getLinkPlayHelper();
    }

    public static final com.bytedance.android.live.revlink.impl.service.internal.a p(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$linkRevInternalService");
        return getContext(r1).Do();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.utils.h q(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$linkStreamRegionUtils");
        return getContext(r1).getLinkStreamRegionUtils();
    }

    public static final int r(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$linkedAnchorCount");
        i11.b r2 = getContext(r1).c8();
        if (r2 == null) goto L7;
        List<p> r3 = r2.getOnlineUserList();
        if (r3 == null) goto L7;
        return r3.size();
    L7:
        return 0;
    }

    public static final LiveFullLinkPKMonitor s(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$liveFullLinkPKMonitor");
        return getContext(r1).getLiveFullLinkPKMonitor();
    }

    public static final AnchorLinkUserCenterV2 t(j r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$mLinkUserCenter");
        return r1.getContext().getAnchorLinkUserCenter();
    }

    public static final String u(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$mergeDoubleGuestUID");
        Iterator<T> r0 = t(r4).a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((!Intrinsics.areEqual(iz.a.a(((p) r1).getUser()), r4.getContext().eg())) == false) goto L4;
    L9:
        p r2 = (p) r1;
        if (r2 == null) goto L15;
        IBaseUser r5 = r2.getUser();
        if (r5 == null) goto L15;
        String r6 = iz.a.a(r5);
        if (r6 == null) goto L15;
        return r6;
    L15:
        return "";
    L8:
        r1 = null;
        goto L9
    }

    public static final String v(b r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$mergeDoubleGuestUID");
        Intrinsics.checkNotNullParameter(r4, "$this$doubleGuestUID");
        l(r4);
        Iterator<T> r0 = t(r4).a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((!Intrinsics.areEqual(iz.a.a(((p) r1).getUser()), r4.getContext().eg())) == false) goto L4;
    L9:
        p r2 = (p) r1;
        if (r2 == null) goto L15;
        IBaseUser r5 = r2.getUser();
        if (r5 == null) goto L15;
        String r6 = iz.a.a(r5);
        if (r6 == null) goto L15;
        return r6;
    L15:
        return "";
    L8:
        r1 = null;
        goto L9
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.a w(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAnchorControlService");
        return getContext(r1).u5();
    }

    public static final com.bytedance.android.live.revlink.impl.control.launchcontext.a x(a r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAnchorLaunchContext");
        sc0.a r2 = r1.getContext().sd();
        if ((r2 instanceof com.bytedance.android.live.revlink.impl.control.launchcontext.a) == true) goto L6;
        r2 = null;
    L6:
        return (com.bytedance.android.live.revlink.impl.control.launchcontext.a) r2;
    }

    public static final u y(a r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$multiAnchorLaunchParam");
        sc0.a r3 = r2.getContext().sd();
        if ((r3 instanceof com.bytedance.android.live.revlink.impl.control.launchcontext.a) == true) goto L5;
        r3 = null;
    L5:
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r4 = (com.bytedance.android.live.revlink.impl.control.launchcontext.a) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.a;
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.vm.b z(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAnchorLinkContext");
        return getContext(r1).rb();
    }
}
