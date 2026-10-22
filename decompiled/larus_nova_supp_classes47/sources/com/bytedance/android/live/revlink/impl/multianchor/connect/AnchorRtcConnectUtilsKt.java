package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.livesdk.link.model.bridge.b2;
import com.bytedance.android.livesdk.link.model.bridge.o1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z1;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import fr2.g0;
import fr2.i0;
import fr2.l0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorRtcConnectUtilsKt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(AnchorRtcConnectUtilsKt.class, "LIVE_REV_SCENE_ENABLE_PRE_RTC_WHITELIST", "getLIVE_REV_SCENE_ENABLE_PRE_RTC_WHITELIST()[Ljava/lang/Integer;", 1))};
        a = r1;
        b = LazyKt.lazy(AnchorRtcConnectUtilsKt$newConnectAdaptSwitchStream$2.INSTANCE);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_scene_enable_pre_rtc_whitelist", new Integer[]{7, 1}, zn3.a.i, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r1[0]);
    }

    public static final boolean f() {
        return y41.f.N.h();
    }

    public static final boolean a(com.bytedance.android.live.revlink.impl.global.c r1) {
        if (r1 == null) goto L8;
        AnchorRtcConnectModel r2 = r1.Hb();
        if (r2 == null) goto L8;
        if (r2.enableFirstFrameOpt() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean d(z1 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isLinked");
        if (r1.getLinkStatus() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String b(v1 r2, String r3) {
        if (r2 == null) goto L6;
        o1 r4 = r2.getMultiAnchorLinkMicRtcInfo();
        if (r4 == null) goto L6;
        Map r5 = r4.getPushStreamModeRTCMap();
    L7:
        com.bytedance.android.live.revlink.link.streaminteract.biz.a.C0204a r0 = com.bytedance.android.live.revlink.link.streaminteract.biz.a.C0204a.c;
        if (r5 == null) goto L17;
        String r6 = (String) r5.get(Long.valueOf(5));
        if (r6 == null) goto L17;
        if (r6.length() <= 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        return r6;
    L14:
        r1 = false;
    L17:
        if (r3 != null) goto L20;
        return "";
    L20:
        return r3;
    L6:
        r5 = null;
        goto L7
    }

    public static final boolean e(b2 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$isLinkmicIdOnline");
        Intrinsics.checkNotNullParameter(r3, "linkmicId");
        Map r4 = r2.getPreRtcUserInfo();
        if (r4 == null) goto L17;
        Collection r5 = r4.values();
        if (r5 == null) goto L22;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Object r0 = r6.next();
        if (Intrinsics.areEqual(((z1) r0).getLinkmicIdStr(), r3) == false) goto L8;
    L13:
        z1 r1 = (z1) r0;
        if (r1 != null) goto L16;
        return false;
    L16:
        return d(r1);
    L12:
        r0 = null;
        goto L13
    L22:
        return false;
    L17:
        return false;
    }

    public static final void c(com.bytedance.android.live.revenuelink.rtc.i r5, fr2.n r6, IRoom r7, Function0<? extends IConfig.b> r8) {
        com.bytedance.android.live.revlink.impl.settings.live.b r0 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r0.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.b.h.getValue(r0, com.bytedance.android.live.revlink.impl.settings.live.b.a[6])).booleanValue() == true) goto L5;
    L18:
        if (r6 == null) goto L20;
        r6.setBackgroundColor("#000000");
    L20:
        IConfig.e r9 = null;
        if (r6 == null) goto L28;
        if (r7 == null) goto L26;
        IBaseStreamUrl r10 = IRoomKt_androidKt.getStreamUrlKt(r7);
        if (r10 == null) goto L26;
        String r12 = r10.getRtmpPushUrl();
    L27:
        r6.f2(r12);
    L26:
        r12 = null;
    L28:
        if (r6 == null) goto L34;
        IConfig.e r13 = vh6.c.b(g0.class).o6().b(Reflection.getOrCreateKotlinClass(IConfig.e.class), new l0());
        if ((r13 instanceof IConfig.e) == false) goto L33;
        r9 = r13;
    L33:
        KmpEnv r14 = KmpEnv.a;
        com.bytedance.live.kmp.core.b.a();
        r6.S0(r9);
    L34:
        if (r6 == null) goto L36;
        IConfig.a.a1.getClass();
        r6.l4(IConfig.a.a.a);
    L36:
        if (r6 == null) goto L42;
        if (r8 == null) goto L40;
        IConfig.b r15 = (IConfig.b) r8.invoke();
        if (r15 == null) goto L40;
    L41:
        r6.S4(r15);
    L40:
        IConfig.b.c1.getClass();
        r15 = IConfig.b.a.a;
    L42:
        if (r6 == null) goto L44;
        r6.X0(6);
    L44:
        if (r6 == null) goto L46;
        IConfig.d.e1.getClass();
        r6.e3(IConfig.d.a.b);
    L46:
        if (r6 == null) goto L48;
        r6.U3();
    L48:
        com.bytedance.android.live.revlink.impl.settings.live.c r16 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r16.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.f.getValue(r16, com.bytedance.android.live.revlink.impl.settings.live.c.a[4])).booleanValue() == false) goto L55;
        if (r6 == null) goto L52;
        r6.e();
    L52:
        if (r6 == null) goto L56;
        r6.Z2();
        return;
    L56:
        return;
    L55:
        return;
    L5:
        if (com.bytedance.android.live.revlink.impl.pk.utils.p.a(r7) == false) goto L18;
        if (r5 == null) goto L14;
        vc0.a r17 = r5.getLiveCore();
        if (r17 == null) goto L14;
        fr2.p r18 = i0.a(r17);
        if (r18 == null) goto L14;
        y41.f r1 = y41.f.N;
        r1.getClass();
        if (((Boolean) y41.f.e.getValue(r1, y41.f.a[3])).booleanValue() == false) goto L14;
        r18.s();
        r18.o0();
    L14:
        if (r6 == null) goto L16;
        r6.b();
    L16:
        if (r6 == null) goto L18;
        r6.R2();
        goto L18
    }
}
