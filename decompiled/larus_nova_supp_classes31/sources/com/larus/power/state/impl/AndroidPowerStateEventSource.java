package com.larus.power.state.impl;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.larus.power.state.api.PowerMetricAvailability;
import com.larus.power.state.api.PowerMetricSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import wr9.d;
import wr9.e;
import wr9.k;
import wr9.l;
import xr9.f;
import xr9.g;
import xr9.h;
import xr9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class AndroidPowerStateEventSource implements f {
    public static final /* synthetic */ int n = 0;
    public final e a;
    public final Context b;
    public final ActivityManager c;
    public final PowerManager d;
    public final as9.c e;
    public final AtomicBoolean f;
    public final Object g;
    public volatile xr9.e h;
    public l i;
    public wr9.a j;
    public final c k;
    public final AndroidPowerStateEventSource$batteryReceiver$1 l;
    public final b m;

    public static final class a {
    }

    public static final class b implements ComponentCallbacks2 {
        public final /* synthetic */ AndroidPowerStateEventSource a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r2) {
            Intrinsics.checkNotNullParameter(r2, "newConfig");
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            AndroidPowerStateEventSource.g(this.a, null, true, 1);
        }

        public b(AndroidPowerStateEventSource r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r4) {
            AndroidPowerStateEventSource.g(this.a, Integer.valueOf(r4), false, 2);
        }
    }

    public static final class c implements zr9.b {
        public final /* synthetic */ AndroidPowerStateEventSource a;

        @Override // zr9.b
        public final String getDescription() {
            return "FlowPowerState";
        }

        public c(AndroidPowerStateEventSource r1) {
            this.a = r1;
        }

        @Override // zr9.b
        public final void a(zr9.f r2) {
            Intrinsics.checkNotNullParameter(r2, "status");
            this.a.i(r2);
        }
    }

    static {
    }

    public final void h() {
        long r0 = this.a.a();
        Object r2 = this.g;
        monitor-enter(r2);
        wr9.a r3 = this.j;     // Catch: Throwable -> L13
        if (r3 != null) goto L7;
        r3 = g.b(r0, "battery_event_not_received").e;     // Catch: Throwable -> L13
    L7:
        d<Boolean> r4 = e(r0);     // Catch: Throwable -> L13
        d<Integer> r5 = r3.a;     // Catch: Throwable -> L13
        d<Boolean> r6 = r3.b;     // Catch: Throwable -> L13
        r3.getClass();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r5, "levelPercent");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r6, "isCharging");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r4, "isPowerSaveMode");     // Catch: Throwable -> L13
        wr9.a r7 = new wr9.a(r5, r6, r4);     // Catch: Throwable -> L13
        this.j = r7;     // Catch: Throwable -> L13
        monitor-exit(r2);
        xr9.e r8 = this.h;
        if (r8 == null) goto L18;
        r8.b(r7, r0);
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static d j(long r3) {
        int r0 = d.f;
        return d.a.a(PowerMetricAvailability.UNSUPPORTED, PowerMetricSource.LINUX_SYSFS, r3, "cpu_clusters_not_distinguishable");
    }

    @Override // xr9.f
    public final void a(xr9.e r9) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        this.h = r9;
        if (this.f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        as9.c r10 = this.e;
        if (r10 == null) goto L39;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        r10.c(this.k);     // Catch: Throwable -> L10
        i(r10.a);     // Catch: Throwable -> L10
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Result.exceptionOrNull-impl(r11);
    L10:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L28
        IntentFilter r4 = new IntentFilter();     // Catch: Throwable -> L28
        r4.addAction("android.intent.action.BATTERY_CHANGED");     // Catch: Throwable -> L28
        r4.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");     // Catch: Throwable -> L28
        if (Build.VERSION.SDK_INT < 33) goto L18;
        Context r5 = this.b;     // Catch: Throwable -> L28
        Intent r6 = c(r5, this.l, r4, r5.getPackageName() + ".permission.POWER_STATE_BROADCAST");     // Catch: Throwable -> L28
    L19:
        if (r6 == null) goto L21;
        String r7 = r6.getAction();     // Catch: Throwable -> L28
    L23:
        if (Intrinsics.areEqual(r7, "android.intent.action.BATTERY_CHANGED") == false) goto L25;
        f(r6);     // Catch: Throwable -> L28
    L26:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Result.exceptionOrNull-impl(r12);
        this.b.registerComponentCallbacks(this.m);     // Catch: Throwable -> L33
        g(this, null, false, 3);     // Catch: Throwable -> L33
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Result.exceptionOrNull-impl(r13);
        return;
    L33:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L25:
        h();     // Catch: Throwable -> L28
        goto L26
    L21:
        r7 = null;
        goto L23
    L18:
        Context r8 = this.b;     // Catch: Throwable -> L28
        r6 = d(r8, this.l, r4, r8.getPackageName() + ".permission.POWER_STATE_BROADCAST");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    @Override // xr9.f
    public final k b(long r16) {
        int r10 = RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors(), 1);
        d r11 = new d(Integer.valueOf(r10), PowerMetricAvailability.AVAILABLE, PowerMetricSource.COMPOSITE, r16);
        int r12 = 0;
        IntRange r0 = RangesKt.until(0, r10);
        ArrayList r13 = new ArrayList();
        IntIterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        int r2 = r1.nextInt();
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(StringsKt.toLongOrNull(StringsKt.trim(FilesKt.readText$default(new PolarisFileWrapper("/sys/devices/system/cpu/cpu" + r2 + "/cpufreq/cpuinfo_max_freq"), null, 1, null)).toString()));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r5) == true) goto L14;
        r3 = r5;
    L14:
        Long r6 = (Long) r3;
        if (r6 == null) goto L4;
        r13.add(r6);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L18:
        if (r13.size() == r10) goto L21;
        int r8 = d.f;
        return new k(r11, d.a.a(PowerMetricAvailability.UNSUPPORTED, PowerMetricSource.LINUX_SYSFS, r16, "incomplete_cpu_frequency_profile"), j(r16), j(r16));
    L21:
        List r9 = CollectionsKt.sorted(CollectionsKt.distinct(r13));
        d r14 = new d(r13, PowerMetricAvailability.AVAILABLE, PowerMetricSource.LINUX_SYSFS, r16);
        if (r9.size() < 2) goto L24;
        long r15 = ((Number) CollectionsKt.first(r9)).longValue();
        if (r13.isEmpty() == true) goto L40;
        Iterator r17 = r13.iterator();
        int r18 = 0;
    L30:
        if (r17.hasNext() == false) goto L39;
        if (((Number) r17.next()).longValue() != r15) goto L34;
        boolean r19 = true;
    L35:
        if (r19 == false) goto L30;
        r18 = r18 + 1;
        if (r18 >= 0) goto L30;
        CollectionsKt.throwCountOverflow();
        goto L30
    L34:
        r19 = false;
        goto L35
    L39:
        r12 = r18;
    L40:
        Integer r20 = Integer.valueOf(r12);
        PowerMetricSource r21 = PowerMetricSource.LINUX_SYSFS;
        return new k(r11, r14, xr9.b.a(r20, r21, r16, "classified_by_lowest_max_frequency_cluster"), xr9.b.a(Integer.valueOf(r10 - r12), r21, r16, "classified_by_lowest_max_frequency_cluster"));
    L24:
        return new k(r11, r14, j(r16), j(r16));
    }

    public final d<Boolean> e(long r4) {
        PowerManager r0 = this.d;
        if (r0 != null) goto L7;
        PowerMetricAvailability r1 = PowerMetricAvailability.UNSUPPORTED;
        PowerMetricSource r2 = PowerMetricSource.ANDROID_POWER_MANAGER;
        int r3 = d.f;
        return d.a.a(r1, r2, r4, "power_save_mode_unsupported");
    L7:
        return xr9.b.a(Boolean.valueOf(r0.isPowerSaveMode()), PowerMetricSource.ANDROID_POWER_MANAGER, r4, null);
    }

    public final void f(Intent r8) {
        long r0 = this.a.a();
        int r2 = r8.getIntExtra("level", -1);
        int r3 = r8.getIntExtra("scale", -1);
        if (r2 < 0) goto L6;
        if (r3 <= 0) goto L6;
        Integer r4 = Integer.valueOf(RangesKt.coerceIn((int) ((((double) r2) / ((double) r3)) * 100.0d), 0, 100));
    L7:
        int r9 = r8.getIntExtra("status", 1);
        if (r9 != 2) goto L10;
    L17:
        Boolean r10 = Boolean.TRUE;
    L18:
        if (r4 == null) goto L20;
        d r5 = xr9.b.a(Integer.valueOf(r4.intValue()), PowerMetricSource.BATTERY_MANAGER, r0, null);
    L21:
        if (r10 == null) goto L23;
        d r11 = xr9.b.a(Boolean.valueOf(r10.booleanValue()), PowerMetricSource.BATTERY_MANAGER, r0, null);
    L24:
        wr9.a r6 = new wr9.a(r5, r11, e(r0));
        Object r12 = this.g;
        monitor-enter(r12);
        this.j = r6;     // Catch: Throwable -> L32
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r12);
        xr9.e r13 = this.h;
        if (r13 == null) goto L37;
        r13.b(r6, r0);
        return;
    L37:
        return;
    L32:
        th = move-exception;
        throw th;
    L23:
        PowerMetricAvailability r14 = PowerMetricAvailability.TEMPORARILY_UNAVAILABLE;
        PowerMetricSource r15 = PowerMetricSource.BATTERY_MANAGER;
        int r16 = d.f;
        r11 = d.a.a(r14, r15, r0, "charging_status_unavailable");
        goto L24
    L20:
        PowerMetricAvailability r17 = PowerMetricAvailability.TEMPORARILY_UNAVAILABLE;
        PowerMetricSource r18 = PowerMetricSource.BATTERY_MANAGER;
        int r19 = d.f;
        r5 = d.a.a(r17, r18, r0, "battery_level_unavailable");
        goto L21
    L10:
        if (r9 != 3) goto L12;
    L16:
        r10 = Boolean.FALSE;
        goto L18
    L12:
        if (r9 == 4) goto L16;
        if (r9 == 5) goto L17;
        r10 = null;
    L6:
        r4 = null;
        goto L7
    }

    public final void i(zr9.f r22) {
        long r2 = this.a.a();
        Object r4 = this.g;
        monitor-enter(r4);
        l r5 = this.i;     // Catch: Throwable -> L101
        if (r5 != null) goto L7;
        r5 = g.b(r2, "unitm_not_ready").b;     // Catch: Throwable -> L101
    L7:
        monitor-exit(r4);
        boolean r6 = false;
        if (r22 == null) goto L21;
        float r9 = r22.d;
        int r10 = r22.b;
        int r11 = r22.c;
        as9.c r0 = this.e;
        if (r0 == null) goto L15;
        zr9.g r1 = r0.b;
        if (r1 == null) goto L15;
        Integer r12 = Integer.valueOf(r1.a);
    L17:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        boolean r13 = true;
    L20:
        h r14 = new h(r9, r10, r11, r12, r13);
    L22:
        Intrinsics.checkNotNullParameter(r5, "previous");
        Intrinsics.checkNotNullParameter("unitm_status_unavailable", "unavailableReason");
        if (r14 != null) goto L25;
        d r7 = g.a(r5.a);
        d r8 = g.a(r5.b);
        d r15 = g.a(r5.c);
        d r16 = g.a(r5.d);
        d r17 = g.a(r5.e);
        Intrinsics.checkNotNullParameter(r7, "effectiveStatus");
        Intrinsics.checkNotNullParameter(r8, "batteryDerivedStatus");
        Intrinsics.checkNotNullParameter(r15, "aospStatus");
        Intrinsics.checkNotNullParameter(r16, "aospRawStatus");
        Intrinsics.checkNotNullParameter(r17, "batteryTemperatureCelsius");
        l r3 = new l(r7, r8, r15, r16, r17);
    L90:
        Object r18 = this.g;
        monitor-enter(r18);
        this.i = r3;     // Catch: Throwable -> L98
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L98
        monitor-exit(r18);
        xr9.e r20 = this.h;
        if (r20 == null) goto L108;
        r20.a(r3, r2);
        return;
    L108:
        return;
    L98:
        th = move-exception;
        throw th;
    L25:
        float r21 = r14.a;
        if (r21 > 0.0f) goto L28;
    L30:
        boolean r23 = false;
    L32:
        if (r23 == false) goto L40;
        int r24 = r14.b;
        if (r24 < 0) goto L37;
        if (r24 >= 7) goto L37;
        boolean r25 = true;
    L38:
        if (r25 == false) goto L40;
        boolean r26 = true;
    L42:
        if (r14.e == false) goto L50;
        int r110 = r14.c;
        if (r110 < 0) goto L47;
        if (r110 >= 7) goto L47;
        boolean r27 = true;
    L48:
        if (r27 == false) goto L50;
        r6 = true;
    L47:
        r27 = false;
    L50:
        if (r23 == false) goto L52;
        d r28 = i.a(Double.valueOf(r21), PowerMetricSource.BATTERY_MANAGER, r2);
    L53:
        d r29 = r28;
        if (r26 == false) goto L56;
        d r30 = i.a(i.b(r14.b), PowerMetricSource.UNITM_BATTERY, r2);
    L58:
        if (r14.e == false) goto L60;
        PowerMetricAvailability r31 = PowerMetricAvailability.TEMPORARILY_UNAVAILABLE;
    L62:
        if (r6 == false) goto L64;
        d r111 = i.a(i.b(r14.c), PowerMetricSource.ANDROID_THERMAL, r2);
    L65:
        if (r6 == false) goto L67;
        d r32 = i.a(Integer.valueOf(r14.c), PowerMetricSource.ANDROID_THERMAL, r2);
    L68:
        d r112 = r32;
        Integer r33 = r14.d;
        if (r33 != null) goto L72;
    L75:
        Integer r34 = r14.d;
        if (r34 == null) goto L83;
        if (r34.intValue() != 1) goto L83;
        if (r6 == false) goto L83;
        d r113 = r111;
    L89:
        r3 = new l(r113, r30, r111, r112, r29);
    L83:
        if (r6 == false) goto L85;
        d r35 = d.a(r111, null, "fallback_from_unavailable_primary_source", 15);
    L88:
        r113 = r35;
        goto L89
    L85:
        if (r26 == false) goto L87;
        r35 = d.a(r30, null, "fallback_from_unavailable_primary_source", 15);
        goto L88
    L87:
        r35 = i.c(PowerMetricAvailability.TEMPORARILY_UNAVAILABLE, PowerMetricSource.UNKNOWN, r2, "no_trusted_thermal_source");
        goto L88
    L72:
        if (r33.intValue() != 0) goto L75;
        if (r26 == false) goto L75;
        r113 = r30;
        goto L89
    L67:
        r32 = i.c(r31, PowerMetricSource.ANDROID_THERMAL, r2, "aosp_thermal_status_unavailable");
        goto L68
    L64:
        r111 = i.c(r31, PowerMetricSource.ANDROID_THERMAL, r2, "aosp_thermal_status_unavailable");
        goto L65
    L60:
        r31 = PowerMetricAvailability.UNSUPPORTED;
        goto L62
    L56:
        r30 = i.c(PowerMetricAvailability.TEMPORARILY_UNAVAILABLE, PowerMetricSource.UNITM_BATTERY, r2, "battery_thermal_source_invalid");
        goto L58
    L52:
        r28 = i.c(PowerMetricAvailability.TEMPORARILY_UNAVAILABLE, PowerMetricSource.BATTERY_MANAGER, r2, "invalid_battery_temperature");
    L37:
        r25 = false;
    L40:
        r26 = false;
        goto L42
    L28:
        if (r21 > 100.0f) goto L30;
        r23 = true;
        goto L32
    L19:
        r13 = false;
    L15:
        r12 = null;
        goto L17
    L21:
        r14 = null;
    L101:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.power.state.impl.AndroidPowerStateEventSource$batteryReceiver$1] */
    public AndroidPowerStateEventSource(Context r3, e r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "clock");
        this.a = r4;
        Context r5 = r3.getApplicationContext();
        this.b = r5;
        Object r6 = r5.getSystemService("activity");
        as9.c r1 = null;
        if ((r6 instanceof ActivityManager) == false) goto L5;
        ActivityManager r7 = (ActivityManager) r6;
    L6:
        this.c = r7;
        Object r8 = r5.getSystemService("power");
        if ((r8 instanceof PowerManager) == false) goto L9;
        PowerManager r9 = (PowerManager) r8;
    L10:
        this.d = r9;
        if (as9.d.c == null) goto L13;
    L22:
        as9.d r10 = as9.d.c;
        if (r10 == null) goto L25;
        r1 = r10.a;
    L25:
        this.e = r1;
        this.f = new AtomicBoolean(false);
        this.g = new Object();
        this.k = new c(this);
        this.l = new AndroidPowerStateEventSource$batteryReceiver$1(this);
        this.m = new b(this);
        return;
    L13:
        monitor-enter(as9.d.class);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (as9.d.c != null) goto L17;
        as9.d.c = new as9.d(r5.getApplicationContext());     // Catch: Throwable -> L19
    L17:
        monitor-exit(as9.d.class);     // Catch: Throwable -> L19
        goto L22
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent c(Context r9, AndroidPowerStateEventSource$batteryReceiver$1 r10, IntentFilter r11, String r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L31;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L31:
    L25:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L29;
        throw e;
    L29:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, r12, null, 4);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 4, r12, null, 5, r9);     // Catch: Exception -> L25
        int r1 = r0.result;     // Catch: Exception -> L25
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L18;
        return r9.registerReceiver(r10, r11, r12, null, 4);
    L18:
        return r0.intent;
    L20:
        return new Intent();
    L22:
        return r9.registerReceiver(r10, r11, r12, null, 4);
    L24:
        return r9.registerReceiver(r10, r11, r12, null, 4);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent d(Context r9, AndroidPowerStateEventSource$batteryReceiver$1 r10, IntentFilter r11, String r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, r12, null);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 0, r12, null, 4, r9);     // Catch: Exception -> L26
        int r2 = r1.result;     // Catch: Exception -> L26
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L19;
        return r9.registerReceiver(r10, r11, r12, null);
    L19:
        return r1.intent;
    L21:
        return new Intent();
    L23:
        return r9.registerReceiver(r10, r11, r12, null);
    L25:
        return r9.registerReceiver(r10, r11, r12, null);
    }

    public static void g(AndroidPowerStateEventSource r12, Integer r13, boolean r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r13 = null;
    L5:
        boolean r0 = false;
        if ((r15 & 2) == 0) goto L8;
        r14 = false;
    L8:
        long r2 = r12.a.a();
        ActivityManager r16 = r12.c;
        if (r16 != null) goto L42;
        xr9.e r17 = r12.h;
        if (r17 == null) goto L44;
        r17.c(g.b(r2, "activity_manager_unavailable").d, r2);
        return;
    L44:
        return;
    L42:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L32
        ActivityManager.MemoryInfo r5 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L32
        r16.getMemoryInfo(r5);     // Catch: Throwable -> L32
        if (r13 == null) goto L24;
        int r18 = r13.intValue();     // Catch: Throwable -> L32
        if (r18 != 20) goto L19;
    L21:
        boolean r19 = false;
    L22:
        if (r19 != true) goto L24;
        boolean r110 = true;
    L25:
        Long r6 = Long.valueOf(r5.totalMem);     // Catch: Throwable -> L32
        PowerMetricSource r7 = PowerMetricSource.ACTIVITY_MANAGER;     // Catch: Throwable -> L32
        d r8 = xr9.b.a(r6, r7, r2, null);     // Catch: Throwable -> L32
        d r9 = xr9.b.a(Long.valueOf(r5.availMem), r7, r2, null);     // Catch: Throwable -> L32
        PowerMetricAvailability r10 = PowerMetricAvailability.UNSUPPORTED;     // Catch: Throwable -> L32
        int r11 = d.f;     // Catch: Throwable -> L32
        d r20 = d.a.a(r10, r7, r2, "event_driven_pss_disabled");     // Catch: Throwable -> L32
        if (r5.lowMemory == true) goto L29;
        if (r110 == true) goto L29;
        if (r14 == true) goto L29;
    L30:
        Object r111 = Result.constructor-impl(new wr9.c(r8, r9, r20, xr9.b.a(Boolean.valueOf(r0), r7, r2, null)));     // Catch: Throwable -> L32
    L35:
        if (Result.exceptionOrNull-impl(r111) == null) goto L38;
        r111 = g.b(r2, "memory_event_failed").d;
    L38:
        wr9.c r112 = (wr9.c) r111;
        xr9.e r113 = r12.h;
        if (r113 == null) goto L46;
        r113.c(r112, r2);
        return;
    L46:
        return;
    L29:
        r0 = true;
        goto L30
    L19:
        if (r18 < 10) goto L21;
        r19 = true;
    L24:
        r110 = false;
    L32:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }
}
