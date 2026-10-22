package com.larus.dora.impl.guide;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraTextBtnBalloonBinding;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonCenterAlign;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraKeepAliveGuide implements t39.l {
    public final String a;
    public final long b;
    public final int c;
    public final Lazy d;
    public volatile int e;
    public t39.m f;
    public Balloon g;

    public static final class a {
    }

    static {
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d("DoraKeepAliveGuide", "startGuide()");
        if (h() == true) goto L5;
        i(1);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return DoraGuideMeta.DoraKeepAliveGuide.getGuideId();
    }

    public final boolean h() {
        IDoraGuideService r0 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.b();
    L6:
        if (r1 == false) goto L8;
        g49.d.d("DoraKeepAliveGuide", "guide suppressed: dora guide is degraded");
    L8:
        return r1;
    L5:
        r1 = true;
        goto L6
    }

    public final String toString() {
        return "DoraKeepAliveGuide(state=" + this.e + ')';
    }

    public DoraKeepAliveGuide(String r3) {
        Intrinsics.checkNotNullParameter(r3, "page");
        this.a = r3;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L5;
        long r0 = r4.t();
    L6:
        this.b = r0;
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L9;
        int r6 = r5.F();
    L10:
        this.c = r6;
        this.d = LazyKt.lazy(new d0());
        return;
    L9:
        r6 = 3;
        goto L10
    L5:
        r0 = 10000;
        goto L6
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        g49.d.d("DoraKeepAliveGuide", "setStateListener() called with " + r3);
        this.f = r3;
    }

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r13) {
        if ((r13 instanceof DoraKeepAliveGuide$isGuideConditionMet$1) == false) goto L7;
        DoraKeepAliveGuide$isGuideConditionMet$1 r0 = (DoraKeepAliveGuide$isGuideConditionMet$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        DoraDevice r5 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L74:
        if (((Boolean) r14).booleanValue() == false) goto L78;
        return Boxing.boxBoolean(true);
    L78:
        if (com.larus.dora.impl.alive.a.a((IFlowCompanionDeviceManager) this.d.getValue()) == false) goto L103;
        IFlowCompanionDeviceManager r15 = (IFlowCompanionDeviceManager) this.d.getValue();
        if (r15 != null) goto L82;
    L84:
        boolean r16 = false;
    L85:
        if (r16 == true) goto L93;
        IFlowCompanionDeviceManager r17 = (IFlowCompanionDeviceManager) this.d.getValue();
        if (r17 != null) goto L89;
    L91:
        boolean r18 = false;
    L92:
        if (r18 == true) goto L93;
    L102:
        return Boxing.boxBoolean(!r4);
    L89:
        if (r17.c(r5.sn) != true) goto L91;
        r18 = true;
    L93:
        IFlowCompanionDeviceManager r110 = (IFlowCompanionDeviceManager) this.d.getValue();
        if (r110 != null) goto L96;
    L98:
        boolean r111 = false;
    L99:
        if (r111 == false) goto L102;
        r4 = true;
        goto L102
    L96:
        if (r110.m(r5.mac) != true) goto L98;
        r111 = true;
        goto L99
    L82:
        if (r15.b(r5.mac) != true) goto L84;
        r16 = true;
        goto L85
    L103:
        int r112 = com.larus.dora.impl.alive.y.a;
        AppHost.Companion r113 = AppHost.a;
        Object r6 = r113.getApplication().getSystemService("power");
        if ((r6 instanceof PowerManager) == false) goto L106;
        PowerManager r7 = (PowerManager) r6;
    L107:
        if (r7 != null) goto L110;
    L112:
        boolean r114 = false;
    L113:
        if (r114 == false) goto L117;
        g49.d.d("DoraKeepAliveGuide", "checkShowState: ignoring battery optimizations enabled, not shown");
        return Boxing.boxBoolean(false);
    L117:
        return Boxing.boxBoolean(true);
    L110:
        if (Build.VERSION.SDK_INT < 23) goto L112;
        r114 = r7.isIgnoringBatteryOptimizations(r113.getApplication().getPackageName());
        goto L113
    L106:
        r7 = null;
        goto L107
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        IObricDoraService r115 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r115 != null) goto L17;
    L19:
        boolean r116 = false;
    L20:
        if (r116 == false) goto L24;
        g49.d.d("DoraKeepAliveGuide", "Keep-alive guide condition not met: hidden by Obric");
        return Boxing.boxBoolean(false);
    L24:
        if (AccountService.a.isLogin().booleanValue() == true) goto L28;
        g49.d.d("DoraKeepAliveGuide", "Keep-alive guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L28:
        if (h() == true) goto L30;
        e10 r117 = e10.a;
        boolean r118 = e10.N();
        com.larus.dora.impl.util.b0.a.getClass();
        if (com.larus.dora.impl.util.b0.j().getBoolean("dora_cdm_keep_alive_nova", false) == false) goto L35;
        if (r118 == true) goto L35;
        boolean r8 = true;
    L37:
        if (com.larus.dora.impl.util.b0.j().getInt("dora_keep_alive_balloon_close_times", 0) < this.c) goto L39;
        boolean r9 = true;
    L40:
        g49.d.d("DoraKeepAliveGuide", "closeTimes=" + com.larus.dora.impl.util.b0.j().getInt("dora_keep_alive_balloon_close_times", 0) + ", bubbleCounts=" + this.c + ", isCdmKeepAliveNovaClosed=" + r8 + ", isCdmKeepAliveNovaEnabled=" + r118);
        if (r9 == false) goto L46;
        if (r8 == false) goto L46;
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_cdm_keep_alive_nova", false);
        int r119 = com.larus.dora.impl.util.b0.j().getInt("dora_keep_alive_balloon_close_times", 0);
        if (r119 <= 0) goto L50;
        com.larus.dora.impl.util.b0.j().storeInt("dora_keep_alive_balloon_close_times", r119 - 1);
    L50:
        DoraDevice r120 = DoraAdapterExtKt.h(kj4.a.g());
        int r10 = kj4.a.g().getDoraLinkState(r120);
        if (r120 == null) goto L119;
        if (r10 != 2) goto L119;
        ArrayList r11 = (ArrayList) com.larus.dora.impl.util.b0.i();
        if (r11.isEmpty() == false) goto L58;
        int r12 = 0;
    L66:
        if (r12 < 1) goto L69;
        g49.d.d("DoraKeepAliveGuide", "checkShowState: today is shown more than 1");
        return Boxing.boxBoolean(false);
    L69:
        kj4.a r20 = kj4.a.g();
        r0.L$0 = r120;
        r0.label = 1;
        Object r21 = DoraAdapterExtKt.s(r20);
        if (r21 != r2) goto L72;
        return r2;
    L72:
        r5 = r120;
        r14 = r21;
        goto L74
    L58:
        Iterator r22 = r11.iterator();
        r12 = 0;
    L60:
        if (r22.hasNext() == false) goto L66;
        if (DateUtils.isToday(((Number) r22.next()).longValue()) == false) goto L60;
        r12 = r12 + 1;
        if (r12 >= 0) goto L60;
        CollectionsKt.throwCountOverflow();
    L119:
        return Boxing.boxBoolean(false);
    L46:
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_cdm_keep_alive_nova", r118);
        if (r9 == false) goto L50;
        return Boxing.boxBoolean(false);
    L39:
        r9 = false;
    L35:
        r8 = false;
        goto L37
    L30:
        return Boxing.boxBoolean(false);
    L17:
        if (r115.j() != true) goto L19;
        r116 = true;
    L7:
        r0 = new DoraKeepAliveGuide$isGuideConditionMet$1(this, r13);
        goto L8
    }

    public final LarusDoraTextBtnBalloonBinding g(Fragment r5) {
        if (r5 == null) goto L5;
        final Context r6 = r5.getContext();
        if (r6 == null) goto L5;
    L6:
        final LarusDoraTextBtnBalloonBinding r0 = LarusDoraTextBtnBalloonBinding.a(LayoutInflater.from(r6));
        e1.d(r0.c, new e0(r0));
        final g0 r1 = new g0(this);
        TextView r2 = r0.d;
        int r3 = j0.a;
        r2.setText(j0.d(2131903295));
        r0.b.setText(j0.d(2131902349));
        e1.d(r0.b, new f0(r6, r1));
        return r0;
    L5:
        r6 = AppHost.a.getApplication();
        goto L6
    }

    public final void i(int r4) {
        if (this.e != r4) goto L5;
        return;
    L5:
        int r0 = this.e;
        this.e = r4;
        g49.d.d("DoraKeepAliveGuide", "Guide state changed: prev=" + r0 + ", new=" + r4);
        t39.m r1 = this.f;
        if (r1 == null) goto L9;
        r1.b(this, r4, r0);
        return;
    }

    @Override // t39.l
    public final Object d(Fragment r2, View r3, Continuation<? super Unit> r4) {
        g49.d.d("DoraKeepAliveGuide", "dismissGuide() called, fragment=" + r2 + ", anchorView=" + r3);
        Balloon r5 = this.g;     // Catch: Exception -> L10
        if (r5 == null) goto L6;
        r5.h();     // Catch: Exception -> L10
    L6:
        this.g = null;     // Catch: Exception -> L10
        i(3);     // Catch: Exception -> L10
        g49.d.d("DoraKeepAliveGuide", "onReadyShowNextGuide() triggered after dismissGuide");     // Catch: Exception -> L10
        t39.m r6 = this.f;     // Catch: Exception -> L10
        if (r6 == null) goto L15;
        r6.a(this);     // Catch: Exception -> L10
    L15:
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        g49.d.c("DoraKeepAliveGuide", "dismissGuide() exception: " + e.getMessage(), e);
        i(404);
        t39.m r7 = this.f;
        if (r7 == null) goto L15;
        r7.a(this);
        goto L15
    }

    @Override // t39.l
    public final Object e(Fragment r8, View r9, Continuation<? super Unit> r10) {
        g49.d.d("DoraKeepAliveGuide", "showGuide() called, fragment=" + r8 + ", anchorView=" + r9);
        if (h() == true) goto L5;
        i(2);
        LarusDoraTextBtnBalloonBinding r1 = g(r8);     // Catch: Exception -> L24
        if (r8 == null) goto L11;
        Context r2 = r8.getContext();     // Catch: Exception -> L24
        if (r2 == null) goto L11;
    L12:
        Balloon.a r3 = new Balloon.a(r2);     // Catch: Exception -> L24
        r3.d = 1.0f;     // Catch: Exception -> L24
        r3.j(86);     // Catch: Exception -> L24
        r3.z = 16.0f;     // Catch: Exception -> L24
        r3.e(ArrowPositionRules.ALIGN_BALLOON);     // Catch: Exception -> L24
        r3.f(0);     // Catch: Exception -> L24
        r3.p = 0.5f;     // Catch: Exception -> L24
        r3.v = 0;     // Catch: Exception -> L24
        r3.g(BalloonAnimation.FADE);     // Catch: Exception -> L24
        r3.g0 = false;     // Catch: Exception -> L24
        r3.W = r8;     // Catch: Exception -> L24
        r3.V = this.b;     // Catch: Exception -> L24
        r3.h(false);     // Catch: Exception -> L24
        r3.k(r1);     // Catch: Exception -> L24
        r3.l(new c0(this));     // Catch: Exception -> L24
        Balloon r4 = r3.b();     // Catch: Exception -> L24
        com.larus.dora.impl.util.b0 r5 = com.larus.dora.impl.util.b0.a;     // Catch: Exception -> L24
        long r6 = System.currentTimeMillis();     // Catch: Exception -> L24
        r5.getClass();     // Catch: Exception -> L24
        com.larus.dora.impl.util.b0.a(r6);     // Catch: Exception -> L24
        int r7 = j49.a.a;     // Catch: Exception -> L24
        j49.a.d();     // Catch: Exception -> L24
        this.g = r4;     // Catch: Exception -> L24
        r1.a.setTag(r4);     // Catch: Exception -> L24
        if (r9 == null) goto L15;
        r4.s(r9, 0, c7.b(Boxing.boxInt(8)));     // Catch: Exception -> L24
    L29:
        return Unit.INSTANCE;
    L15:
        if (r8 == null) goto L17;
        View r11 = r8.getView();     // Catch: Exception -> L24
    L18:
        if (r11 == null) goto L20;
        r4.y(r11, 0, 0, BalloonCenterAlign.TOP);     // Catch: Exception -> L24
        goto L29
    L20:
        g49.d.b("DoraKeepAliveGuide", "showGuide() failed: no anchor and fragment view is null");     // Catch: Exception -> L24
        i(404);     // Catch: Exception -> L24
        t39.m r12 = this.f;     // Catch: Exception -> L24
        if (r12 == null) goto L29;
        r12.a(this);     // Catch: Exception -> L24
        goto L29
    L17:
        r11 = null;
    L11:
        r2 = AppHost.a.getApplication();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        g49.d.c("DoraKeepAliveGuide", "showGuide() exception: " + e.getMessage(), e);
        i(404);
        g49.d.d("DoraKeepAliveGuide", "onReadyShowNextGuide() triggered after error");
        t39.m r13 = this.f;
        if (r13 == null) goto L29;
        r13.a(this);
        goto L29
    L5:
        return Unit.INSTANCE;
    }
}
