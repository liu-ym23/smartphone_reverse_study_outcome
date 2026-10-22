package com.bytedance.android.live.revlink.impl.global;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenuelink.connect.g;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.b0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.service.e;
import com.bytedance.android.live.revlink.impl.pk.service.h;
import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.scope.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final x11.a i() {
        o41.a r0 = (o41.a) f.d(j.C0.a(), o41.a.class);
        if (r0 == null) goto L7;
        o11.b r1 = r0.a;
        if (r1 == null) goto L7;
        return (x11.a) m.e.d(r1, x11.a.class);
    L7:
        return null;
    }

    public static final c k() {
        o41.a r0 = (o41.a) f.d(j.C0.a(), o41.a.class);
        if (r0 == null) goto L7;
        o11.b r1 = r0.a;
        if (r1 == null) goto L7;
        return (c) m.e.d(r1, c.class);
    L7:
        return null;
    }

    public static final o11.a o() {
        o41.a r0 = (o41.a) f.d(j.C0.a(), o41.a.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public static final p21.b A() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ne();
    }

    public static final MultiLinkAnchorControlContext B() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ua();
    }

    public static final v C() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkMonitor();
    }

    public static final w D() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    public static final k21.a E() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.P7();
    }

    public static final MultiPKLauncher F() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Be();
    }

    public static final MultiPkMatchContext G() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.gf();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.match.f H() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.F8();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.match.a I() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Mf();
    }

    public static final z J() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiPkMonitor();
    }

    public static final com.bytedance.android.live.revlink.impl.precisefind.a K() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Wd();
    }

    public static final b0 L() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Tj();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.service.a M() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ja();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.service.b N() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ud();
    }

    public static final com.bytedance.android.live.revlink.impl.pk.utils.j O() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPKInviteControlUtils();
    }

    public static final IPKLinkBizDataService P() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mk();
    }

    public static final e Q() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.lo();
    }

    public static final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e R() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ig();
    }

    public static final com.bytedance.android.live.revlink.impl.monitor.b S() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkEnterRoomTracer();
    }

    public static final w31.c T() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    public static final h U() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.V0();
    }

    public static final h41.f V() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkSwitchLogger();
    }

    public static final q W() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkUtils();
    }

    public static final ProfitInteractionDataContext X() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.vj();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.profit.a Y() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Qj();
    }

    public static final e0 Z() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ti();
    }

    public static final com.bytedance.android.live.revenuelink.connect.f a() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Z0();
    }

    public static final com.bytedance.android.livesdk.log.filter.v a0() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Pa();
    }

    public static final g b() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnchorConnectUtils();
    }

    public static final s b0() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkCommonUtil();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.utils.a c() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.km();
    }

    public static final d31.d c0() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    public static final com.bytedance.android.live.revenuelink.rtc.f d() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m0();
    }

    public static final d31.e d0() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q4();
    }

    public static final i11.b e() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c8();
    }

    public static final d31.f e0() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.y2();
    }

    public static final com.bytedance.android.live.revlink.impl.control.d f() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Rc();
    }

    public static final RevLinkWindowRegionContext f0() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.P8();
    }

    public static final i41.a g() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAutoMatchManager();
    }

    public static final com.bytedance.android.live.revenuelink.f g0() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevenueLinkTraceMonitor();
    }

    public static final e21.b h() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getClientAttachedInfoObj();
    }

    public static final i h0() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Hg();
    }

    public static final LinkCrossRoomDataHolder j() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e l() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkOptLogContext();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f m() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkPlayHelper();
    }

    public static final com.bytedance.android.live.revlink.impl.service.internal.a n() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Do();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.vm.f p() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Fb();
    }

    public static final LiveFullLinkPKMonitor q() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveFullLinkPKMonitor();
    }

    public static final d21.d r() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMergePkHelper();
    }

    public static final ox0.a s() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getModeMerge();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.a t() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.u5();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.vm.g u() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiAnchorLinkContextObj();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.utils.q v() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiAnchorLinkLogUtils();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.b w() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d6();
    }

    public static final MultiAnchorPkLaunchContext x() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ib();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.c y() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.O4();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.service.d z() {
        c r0 = k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.R8();
    }
}
