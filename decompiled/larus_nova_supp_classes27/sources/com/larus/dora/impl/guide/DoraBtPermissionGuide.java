package com.larus.dora.impl.guide;

import android.media.AudioManager;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.platform.api.g1;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraBtPermissionGuide implements t39.l {
    public static final /* synthetic */ int k = 0;
    public final String a;
    public final boolean b;
    public final long c;
    public final List<String> d;
    public volatile int e;
    public t39.m f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;

    public static final class a {
        public static void a(long r7, boolean r9) {
            g49.d.a("DoraBtPermissionGuide", "[Event] try to report bt permission status, currentDay=" + r7 + ", granted=" + r9);
            DoraBuryPointManager r1 = DoraBuryPointManager.a;
            r1.getClass();
            g49.d.d(DoraBuryPointManager.b, "[Event] reportBtPermissionStatus, granted=" + r9);
            Pair[] r3 = new Pair[2];
            if (r9 == false) goto L5;
            String r4 = "on";
        L6:
            int r5 = 0;
            r3[0] = TuplesKt.to("bt_permission_status", r4);
            r3[1] = TuplesKt.to("scene", "bt_permission_guide_condition_check");
            r1.L("d_bt_permission_status", MapsKt.mapOf(r3));
            com.larus.dora.impl.util.b0.a.getClass();     // Catch: Exception -> L16
            com.larus.dora.impl.util.b0.j().storeLong("dora_bt_permission_status_last_day", r7);     // Catch: Exception -> L16
            Keva r2 = com.larus.dora.impl.util.b0.j();     // Catch: Exception -> L16
            if (r9 == false) goto L10;
            int r6 = 1;
        L11:
            r2.storeInt("dora_bt_permission_status_last_value", r6);     // Catch: Exception -> L16
            StringBuilder r8 = new StringBuilder("[State] update bt permission status keva success, day=");     // Catch: Exception -> L16
            r8.append(r7);     // Catch: Exception -> L16
            r8.append(", value=");     // Catch: Exception -> L16
            if (r9 == false) goto L14;
            r5 = 1;
        L14:
            r8.append(r5);     // Catch: Exception -> L16
            g49.d.a("DoraBtPermissionGuide", r8.toString());     // Catch: Exception -> L16
            return;
        L10:
            r6 = 0;
        L16:
            e = move-exception;
            g49.d.c("DoraBtPermissionGuide", "[Exception] store bt permission status to keva failed: " + e.getMessage(), e);
            return;
        L5:
            r4 = "off";
            goto L6
        }
    }

    public static final class b implements g1.c {
        public final /* synthetic */ DoraBtPermissionGuide a;

        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public b(DoraBtPermissionGuide r1) {
            this.a = r1;
        }

        public final void onResult(boolean r3, List<String> r4, List<String> r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r4, "grantedList");
            Intrinsics.checkNotNullParameter(r5, "deniedList");
            g49.d.d("DoraBtPermissionGuide", "Permission result, allGranted=" + r3 + ", grantedList=" + r4 + ", deniedList=" + r5 + ", goSettingsShown=" + r6);
            this.a.i(3);
            g49.d.d("DoraBtPermissionGuide", "onReadyShowNextGuide() triggered after permission result");
            DoraBtPermissionGuide r7 = this.a;
            t39.m r8 = r7.f;
            if (r8 == null) goto L5;
            r8.a(r7);
        L5:
            DoraBuryPointManager.a.G(r3, this.a.a);
        }
    }

    static {
    }

    @Override // t39.l
    public final Unit a() {
        g49.d.d("DoraBtPermissionGuide", "startGuide()");
        if (h() == true) goto L5;
        i(1);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final int f() {
        return DoraGuideMeta.DoraBtPermissionGuide.getGuideId();
    }

    public final boolean h() {
        IDoraGuideService r0 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.b();
    L6:
        if (r1 == false) goto L8;
        g49.d.d("DoraBtPermissionGuide", "guide suppressed: dora guide is degraded");
    L8:
        return r1;
    L5:
        r1 = true;
        goto L6
    }

    public final String toString() {
        return "DoraBtPermissionGuide(state=" + this.e + ')';
    }

    @Override // t39.l
    public final void b(GuideSession$setStateListener$1 r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        g49.d.d("DoraBtPermissionGuide", "setStateListener() called with " + r3);
        this.f = r3;
    }

    @Override // t39.l
    public final Object c(Continuation<? super Boolean> r17) {
        if ((r17 instanceof DoraBtPermissionGuide$isGuideConditionMet$1) == false) goto L7;
        DoraBtPermissionGuide$isGuideConditionMet$1 r3 = (DoraBtPermissionGuide$isGuideConditionMet$1) r17;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L23;
        if (r5 == 1) goto L22;
        if (r5 == 2) goto L21;
        if (r5 == 3) goto L20;
        if (r5 != 4) goto L19;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L16
        String r10 = "DoraBtPermissionGuide";
    L93:
        boolean r1 = ((Boolean) r0).booleanValue();     // Catch: Exception -> L99
        StringBuilder r6 = new StringBuilder("ServerStrategy result: ");     // Catch: Exception -> L99
        if (r1 == false) goto L96;
        boolean r11 = true;
    L97:
        r6.append(r11);     // Catch: Exception -> L99
        g49.d.d(r10, r6.toString());     // Catch: Exception -> L99
        boolean r15 = r1;
    L104:
        return Boxing.boxBoolean(r15);
    L99:
        Exception e = e;
    L100:
        g49.d.c(r10, "ServerStrategy check failed: " + e.getMessage(), e);
    L102:
        r15 = false;
        goto L104
    L96:
        r11 = false;
    L16:
        e = e;
        r10 = "DoraBtPermissionGuide";
        goto L100
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r0);
        r10 = "DoraBtPermissionGuide";
    L78:
        if (((Boolean) r0).booleanValue() == true) goto L81;
        g49.d.d(r10, "Permission guide condition not met: channel and user strategy not met");
        return Boxing.boxBoolean(false);
    L81:
        Object r2 = AppHost.a.getApplication().getSystemService("audio");
        if ((r2 instanceof AudioManager) == false) goto L84;
        AudioManager r7 = (AudioManager) r2;
    L85:
        if (r7 != null) goto L88;
        g49.d.b(r10, "AudioManager is null, cannot determine A2DP state");
        return Boxing.boxBoolean(false);
    L88:
        boolean r8 = r7.isBluetoothA2dpOn();
        g49.d.d(r10, "isGuideConditionMet() A2DP on: " + r8);
        if (r8 == true) goto L109;
        g49.d.d(r10, "A2DP off, skip showing bluetooth permission guide");
        goto L102
    L109:
        com.larus.dora.impl.guide.strategy.f r9 = new com.larus.dora.impl.guide.strategy.f();     // Catch: Exception -> L99
        r3.label = 4;     // Catch: Exception -> L99
        r0 = r9.a();     // Catch: Exception -> L99
        if (r0 != r12) goto L93;
        return r12;
    L84:
        r7 = null;
        goto L85
    L21:
        ResultKt.throwOnFailure(r0);
        boolean r14 = true;
    L71:
        if (Intrinsics.areEqual((Boolean) r0, Boxing.boxBoolean(r14)) == true) goto L74;
        g49.d.d("DoraBtPermissionGuide", "H device is not enabled");
        return Boxing.boxBoolean(false);
    L74:
        r3.label = 3;
        r0 = g(r3);
        if (r0 != r12) goto L78;
        return r12;
    L22:
        ResultKt.throwOnFailure(r0);
    L34:
        boolean r13 = ((Boolean) r0).booleanValue();
        long r16 = System.currentTimeMillis() / 86400000;
        com.larus.dora.impl.util.b0.a.getClass();     // Catch: Exception -> L58
        long r18 = com.larus.dora.impl.util.b0.j().getLong("dora_bt_permission_status_last_day", -1);     // Catch: Exception -> L58
        int r20 = com.larus.dora.impl.util.b0.j().getInt("dora_bt_permission_status_last_value", -1);     // Catch: Exception -> L58
        if (r18 == (-1)) goto L54;
        if (r20 == (-1)) goto L54;
        if (r16 == r18) goto L43;
        boolean r21 = true;
    L44:
        if (r20 != 1) goto L46;
        boolean r110 = true;
    L47:
        if (r13 == r110) goto L49;
        boolean r111 = true;
    L50:
        if (r21 == true) goto L54;
        if (r111 == true) goto L54;
        boolean r22 = false;
    L55:
        if (r22 == true) goto L57;
        g49.d.a("DoraBtPermissionGuide", "[State] skip bt permission status report, same day and same status. currentDay=" + r16 + ", lastDay=" + r18 + ", currentGranted=" + r13 + ", lastValue=" + r20);
    L60:
        if (r13 == false) goto L64;
        g49.d.d("DoraBtPermissionGuide", "Bluetooth permissions already granted, no need to show permission guide");
        return Boxing.boxBoolean(false);
    L64:
        if (this.b == true) goto L67;
        g49.d.d("DoraBtPermissionGuide", "Bluetooth permission guide condition not met: main bot guide not enabled");
        return Boxing.boxBoolean(false);
    L67:
        DoraSetting r23 = DoraSetting.a;
        Function0 r24 = new r();
        r3.label = 2;
        r14 = true;
        r0 = r23.b(5000, 100, "DoraBtPermissionGuide-updateConnectDeviceShouldShowState-isHDeviceEnabled", r24, r3);
        if (r0 != r12) goto L71;
        return r12;
    L57:
        a.a(r16, r13);
        goto L60
    L49:
        r111 = false;
        goto L50
    L46:
        r110 = false;
        goto L47
    L43:
        r21 = false;
    L54:
        r22 = true;
    L58:
        e = move-exception;
        g49.d.c("DoraBtPermissionGuide", "[Exception] read bt permission status from keva failed, treat as never reported: " + e.getMessage(), e);
        a.a(r16, r13);
        goto L60
    L23:
        ResultKt.throwOnFailure(r0);
        if (AccountService.a.isLogin().booleanValue() == true) goto L28;
        g49.d.d("DoraBtPermissionGuide", "Bluetooth permission guide condition not met: user not login");
        return Boxing.boxBoolean(false);
    L28:
        if (h() == true) goto L30;
        com.larus.dora.impl.guide.strategy.a r25 = (com.larus.dora.impl.guide.strategy.a) this.g.getValue();
        r3.label = 1;
        r25.getClass();
        r0 = com.larus.dora.impl.guide.strategy.a.c();
        if (r0 != r12) goto L34;
        return r12;
    L30:
        return Boxing.boxBoolean(false);
    L7:
        r3 = new DoraBtPermissionGuide$isGuideConditionMet$1(this, r17);
        goto L8
    }

    public final Object g(Continuation<? super Boolean> r9) {
        if ((r9 instanceof DoraBtPermissionGuide$isChannelOrUserStrategyMet$1) == false) goto L7;
        DoraBtPermissionGuide$isChannelOrUserStrategyMet$1 r0 = (DoraBtPermissionGuide$isChannelOrUserStrategyMet$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L16;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L38
    L36:
        boolean r11 = ((Boolean) r10).booleanValue();     // Catch: Exception -> L38
    L40:
        if (r11 == true) goto L44;
        g49.d.d("DoraBtPermissionGuide", "Permission guide condition not met: user is new or same-day first enter main bot page");
        return Boxing.boxBoolean(false);
    L44:
        return Boxing.boxBoolean(true);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
    L30:
        if (((Boolean) r10).booleanValue() == true) goto L33;
        g49.d.d("DoraBtPermissionGuide", "Permission guide condition not met: frequency interval not reached");
        return Boxing.boxBoolean(false);
    L33:
        com.larus.dora.impl.guide.strategy.d r12 = (com.larus.dora.impl.guide.strategy.d) this.h.getValue();     // Catch: Exception -> L38
        r0.label = 3;     // Catch: Exception -> L38
        r12.getClass();     // Catch: Exception -> L38
        r10 = com.larus.dora.impl.guide.strategy.d.a();     // Catch: Exception -> L38
        if (r10 != r2) goto L36;
        return r2;
    L18:
        ResultKt.throwOnFailure(r10);
    L23:
        if (((Boolean) r10).booleanValue() == false) goto L26;
        g49.d.d("DoraBtPermissionGuide", "ChannelStrategy allows, short-circuit to true");
        return Boxing.boxBoolean(true);
    L26:
        g49.d.d("DoraBtPermissionGuide", "isGuideConditionMet(), checking user strategy");
        com.larus.dora.impl.guide.strategy.c r13 = (com.larus.dora.impl.guide.strategy.c) this.i.getValue();
        r0.label = 2;
        r10 = r13.a();
        if (r10 != r2) goto L30;
        return r2;
    L19:
        ResultKt.throwOnFailure(r10);
        g49.d.d("DoraBtPermissionGuide", "isChannelOrUserStrategyMet(), checking strategy");
        g49.d.d("DoraBtPermissionGuide", "isGuideConditionMet(), checking channel strategy");
        com.larus.dora.impl.guide.strategy.b r14 = (com.larus.dora.impl.guide.strategy.b) this.j.getValue();
        r0.label = 1;
        r10 = r14.a();
        if (r10 != r2) goto L23;
        return r2;
    L38:
        e = move-exception;
        g49.d.c("DoraBtPermissionGuide", "NotNewUserStrategy check failed: " + e.getMessage(), e);
        r11 = false;
    L7:
        r0 = new DoraBtPermissionGuide$isChannelOrUserStrategyMet$1(this, r9);
        goto L8
    }

    public final void i(int r4) {
        if (this.e != r4) goto L5;
        return;
    L5:
        int r0 = this.e;
        this.e = r4;
        g49.d.d("DoraBtPermissionGuide", "Guide state changed: prev=" + r0 + ", new=" + r4);
        t39.m r5 = this.f;
        if (r5 == null) goto L9;
        r5.b(this, this.e, r0);
        return;
    }

    @Override // t39.l
    public final Object d(Fragment r1, View r2, Continuation<? super Unit> r3) {
        g49.d.d("DoraBtPermissionGuide", "dismissGuide() called, no-op");
        return Unit.INSTANCE;
    }

    @Override // t39.l
    public final Object e(Fragment r12, View r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof DoraBtPermissionGuide$showGuide$1) == false) goto L7;
        DoraBtPermissionGuide$showGuide$1 r0 = (DoraBtPermissionGuide$showGuide$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r12 = (Fragment) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L26
    L13:
        Fragment r5 = r12;
        i2 r16 = i2.b;     // Catch: Exception -> L26
        ((com.larus.dora.impl.guide.strategy.a) this.g.getValue()).getClass();     // Catch: Exception -> L26
        List r6 = com.larus.dora.impl.guide.strategy.a.a();     // Catch: Exception -> L26
        b r7 = new b(this);     // Catch: Exception -> L26
        ((com.larus.dora.impl.guide.strategy.a) this.g.getValue()).getClass();     // Catch: Exception -> L26
        g1.a.a(r5, r6, r7, com.larus.dora.impl.guide.strategy.a.b(), null, 16);     // Catch: Exception -> L26
        DoraBuryPointManager.a.H(this.a);     // Catch: Exception -> L26
    L31:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r15);
        g49.d.d("DoraBtPermissionGuide", "showGuide() called, fragment=" + r12 + ", anchorView=" + r13);
        if (h() == true) goto L19;
        g49.d.d("DoraBtPermissionGuide", "update state to SHOWING");
        ((com.larus.dora.impl.guide.strategy.c) this.i.getValue()).b();     // Catch: Exception -> L26
        com.larus.dora.impl.guide.strategy.b r17 = (com.larus.dora.impl.guide.strategy.b) this.j.getValue();     // Catch: Exception -> L26
        r0.L$0 = r12;     // Catch: Exception -> L26
        r0.label = 1;     // Catch: Exception -> L26
        if (r17.b() != r2) goto L13;
        return r2;
    L19:
        return Unit.INSTANCE;
    L26:
        e = move-exception;
        g49.d.c("DoraBtPermissionGuide", "showGuide() permission request failed: " + e.getMessage(), e);
        i(404);
        g49.d.d("DoraBtPermissionGuide", "onReadyShowNextGuide() triggered after error");
        t39.m r18 = this.f;
        if (r18 == null) goto L31;
        r18.a(this);
    L7:
        r0 = new DoraBtPermissionGuide$showGuide$1(this, r14);
        goto L8
    }

    public DoraBtPermissionGuide(String r2, boolean r3, long r4, List<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "page");
        Intrinsics.checkNotNullParameter(r6, "targetChannels");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.g = LazyKt.lazy(new s());
        this.h = LazyKt.lazy(new t());
        this.i = LazyKt.lazy(new u(this));
        this.j = LazyKt.lazy(new v(this));
    }
}
