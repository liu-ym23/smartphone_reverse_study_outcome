package com.obric.assistant.performance;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.network.util.ScreenStateManager;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricPerformanceMonitorConfig;
import com.obric.assistant.t1;
import com.obric.systemopt.SysPowerKit;
import fna.g;
import java.util.concurrent.atomic.AtomicBoolean;
import kna.f;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import lna.h;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/performance/ObricPerformanceMonitorServiceImpl;", "Lcom/obric/assistant/performance/IObricPerformanceMonitorService;", "<init>", "()V", "dozeReceiver", "Lcom/obric/assistant/performance/ObricPerformanceMonitorServiceImpl$DozeReceiver;", "handleDeepCheckJob", "Lkotlinx/coroutines/Job;", "handleLightCheckJob", "doPerformanceOptJob", "dozeMode", "Lcom/obric/assistant/performance/DozeMode;", "monitorConfig", "Lcom/obric/assistant/ObricPerformanceMonitorConfig;", "init", "", "handleDozeChange", "updateDozeMode", "triggerDeepDozeCheck", "doPerformanceCheck", "triggerLightDozeCheck", "registerDozeReceiver", "DozeReceiver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPerformanceMonitorServiceImpl implements IObricPerformanceMonitorService {
    public final DozeReceiver b;
    public Job c;
    public Job d;
    public Job e;
    public volatile DozeMode f;
    public ObricPerformanceMonitorConfig g;

    /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1", f = "ObricPerformanceMonitorServiceImpl.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricPerformanceMonitorServiceImpl this$0;

        /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$a */
        public static final class a implements kna.d {
            public a() {
            }

            @Override // kna.d
            public final void a(JSONObject r3) {
                Intrinsics.checkNotNullParameter("obric_performance_power", "eventName");
                Intrinsics.checkNotNullParameter(r3, "data");
                o.a.reportEvent("obric_performance_power", r3);
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$b */
        public static final class b implements kna.c {

            /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$b$a */
            public static final class a implements f09.a.b {
                public final /* synthetic */ Function1<Boolean, Unit> a;

                public final void onAllActivityDestroyed() {
                }

                public final void onAppBackground() {
                    this.a.invoke(Boolean.TRUE);
                }

                public final void onAppForeground() {
                    this.a.invoke(Boolean.FALSE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public a(Function1<? super Boolean, Unit> r1) {
                    this.a = r1;
                }
            }

            public b() {
            }

            @Override // kna.c
            public final boolean a() {
                return AppHost.a.a().isAppBackground();
            }

            @Override // kna.c
            public final String b() {
                Activity r0 = AppHost.a.a().getCurrentActivity();
                if (r0 != null) goto L7;
                return null;
            L7:
                return r0.getClass().getName();
            }

            @Override // kna.c
            public final void c(Function1<? super Boolean, Unit> r3) {
                Intrinsics.checkNotNullParameter(r3, "listener");
                AppHost.a.a().j(new a(r3));
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$c */
        public static final class c implements kna.e {

            /* JADX INFO: renamed from: com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl$init$1$c$a */
            public static final class a implements ScreenStateManager.b {
                public final /* synthetic */ Function1<Boolean, Unit> a;

                public final void onScreenOff() {
                    this.a.invoke(Boolean.FALSE);
                }

                public final void onScreenOn() {
                    this.a.invoke(Boolean.TRUE);
                }

                public final void onUserPresent() {
                    this.a.invoke(Boolean.TRUE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public a(Function1<? super Boolean, Unit> r1) {
                    this.a = r1;
                }
            }

            public c() {
            }

            @Override // kna.e
            public final boolean a() {
                PowerManager r0 = (PowerManager) ContextCompat.getSystemService(AppHost.a.getApplication(), PowerManager.class);
                if (r0 != null) goto L7;
                return true;
            L7:
                return r0.isInteractive();
            }

            @Override // kna.e
            public final void b(Function1<? super Boolean, Unit> r2) {
                Intrinsics.checkNotNullParameter(r2, "listener");
                ScreenStateManager r0 = ScreenStateManager.a;
                ScreenStateManager.a(new a(r2));
            }
        }

        public AnonymousClass1(ObricPerformanceMonitorServiceImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            ResultKt.throwOnFailure(r14);     // Catch: Exception -> L30
        L28:
            ObricPerformanceMonitorServiceImpl.d(this.this$0);     // Catch: Exception -> L30
        L33:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
            ObricPerformanceMonitorServiceImpl r15 = this.this$0;     // Catch: Exception -> L30
            t1 r3 = t1.a;     // Catch: Exception -> L30
            r15.g = r3.getObricPerformanceMonitorConfig();     // Catch: Exception -> L30
            FLogger.a.i("ObricPerformanceMonitor", "init, monitorConfig = " + this.this$0.g);     // Catch: Exception -> L30
            Lazy r16 = f.a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r17 = this.this$0.g;     // Catch: Exception -> L30
            if (r17 != null) goto L13;
            r17 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L13:
            f.a(r17);     // Catch: Exception -> L30
            Lazy r18 = com.obric.assistant.performance.c.a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r19 = this.this$0.g;     // Catch: Exception -> L30
            if (r19 != null) goto L16;
            r19 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L16:
            com.obric.assistant.performance.c.a(r19);     // Catch: Exception -> L30
            boolean r110 = h.a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r111 = this.this$0.g;     // Catch: Exception -> L30
            if (r111 != null) goto L19;
            r111 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L19:
            h.a(r111);     // Catch: Exception -> L30
            Lazy r112 = ObricSettingsChangeMonitor.a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r113 = this.this$0.g;     // Catch: Exception -> L30
            if (r113 != null) goto L22;
            r113 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L22:
            ObricSettingsChangeMonitor.c(r113);     // Catch: Exception -> L30
            Lazy r114 = l.a;     // Catch: Exception -> L30
            ObricPerformanceMonitorConfig r115 = this.this$0.g;     // Catch: Exception -> L30
            if (r115 != null) goto L25;
            r115 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L30
        L25:
            Intrinsics.checkNotNullParameter(r115, "config");     // Catch: Exception -> L30
            SysPowerKit r116 = SysPowerKit.getInstance();     // Catch: Exception -> L30
            AppHost.Companion r0 = AppHost.a;     // Catch: Exception -> L30
            r116.addPowerListener(r0.getApplication(), 1, (SysPowerKit.c) l.a.getValue());     // Catch: Exception -> L30
            b r117 = new b();     // Catch: Exception -> L30
            c r5 = new c();     // Catch: Exception -> L30
            Lazy r6 = g.a;     // Catch: Exception -> L30
            g.c(new f(r0.getApplication().getApplicationContext(), r3.getObricPerformancePowerMonitorSettingsConfig(), new a(), r117, r5));     // Catch: Exception -> L30
            AtomicBoolean r4 = h.a;     // Catch: Exception -> L30
            h.b(r3.getObricPerformanceCPUExceptionDiagnosisSettingsConfig(), r117, r5);     // Catch: Exception -> L30
            this.label = 1;     // Catch: Exception -> L30
            if (DelayKt.delay(1000, this) != r1) goto L28;
            return r1;
        L30:
            e = move-exception;
            FLogger.a.e("ObricPerformanceMonitor", "init, error = " + e);
            goto L33
        }
    }

    public static DozeMode e() {
        Lazy r0 = c.a;
        int r2 = Build.VERSION.SDK_INT;     // Catch: Exception -> L25
        boolean r4 = false;
        if (r2 < 23) goto L14;
        PowerManager r3 = (PowerManager) c.b.getValue();     // Catch: Exception -> L25
        if (r3 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L14;
        DozeMode r6 = DozeMode.DOZE_DEEP;     // Catch: Exception -> L25
    L23:
        c.c = r6;     // Catch: Exception -> L25
        FLogger.a.i("ObricPerformanceMonitor", "updateDozeMode: dozeMode = " + c.c);     // Catch: Exception -> L25
    L28:
        return c.c;
    L8:
        if (r3.isDeviceIdleMode() != true) goto L10;
        r5 = true;
    L14:
        if (r2 < 33) goto L22;
        PowerManager r7 = (PowerManager) c.b.getValue();     // Catch: Exception -> L25
        if (r7 != null) goto L18;
    L20:
        if (r4 == false) goto L22;
        r6 = DozeMode.DOZE_LIGHT;     // Catch: Exception -> L25
        goto L23
    L18:
        if (r7.isDeviceLightIdleMode() != true) goto L20;
        r4 = true;
    L22:
        r6 = DozeMode.DOZE_NONE;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "getDozeMode: e = " + e);
        goto L28
    }

    public ObricPerformanceMonitorServiceImpl() {
        this.b = new DozeReceiver(this);
        this.f = DozeMode.DOZE_NONE;
    }

    public final void init() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final void b(ObricPerformanceMonitorServiceImpl r17) {
        r17.getClass();
        if (c.b() == false) goto L6;
        FLogger.a.i("ObricPerformanceMonitor", "assistant active, skip performance check");
        return;
    L6:
        if (f.b == true) goto L51;
        FLogger.a.i("ObricPerformanceMonitor", "checkJvmMemoryLeak: monitor not enabled");
    L16:
        boolean r4 = false;
    L17:
        Lazy r0 = f.a;
        JvmMemoryinfo r5 = f.e;
        if (f.b == true) goto L47;
        FLogger.a.i("ObricPerformanceMonitor", "checkPssMemoryLeak: monitor not enabled");
    L20:
        boolean r16 = false;
    L34:
        Lazy r1 = f.a;
        PssMemoryinfo r6 = f.f;
        if (r4 == true) goto L37;
        if (r16 == true) goto L37;
        return;
    L37:
        FLogger.a.i("ObricPerformanceMonitor", "memory leak, trigger performance optimization, jvmMemory=" + r5 + ", pssMemory=" + r6);
        Job r2 = r17.e;
        if (r2 != null) goto L40;
    L45:
        r17.e = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new doPerformanceCheck.2(r17, r4, r16, r5, r6, null), 3, null);
        return;
    L40:
        if (r2.isActive() == true) goto L43;
        r2 = null;
    L43:
        if (r2 == null) goto L45;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        goto L45
    L47:
        int[] r3 = new int[1];     // Catch: Exception -> L31
        r3[0] = Process.myPid();     // Catch: Exception -> L29
        int r7 = ((ActivityManager) f.a.getValue()).getProcessMemoryInfo(r3)[0].getTotalPss() / 1024;     // Catch: Exception -> L29
        int r8 = f.d;     // Catch: Exception -> L29
        if (r7 <= r8) goto L26;
        boolean r9 = true;
    L27:
        f.f = new PssMemoryinfo(Integer.valueOf(r8), Integer.valueOf(r7));     // Catch: Exception -> L29
        FLogger.a.i("ObricPerformanceMonitor", "checkPssMemoryLeak, pssMemoryLeak=" + r9 + ", totalPss=" + r7 + ", pssLeakThreshold=" + f.d);     // Catch: Exception -> L29
        r16 = r9;
        goto L34
    L26:
        r9 = false;
    L29:
        e = e;
    L33:
        FLogger.a.e("ObricPerformanceMonitor", "checkPssMemoryLeak, e=" + e);
    L31:
        e = e;
        goto L33
    L51:
        long r10 = Runtime.getRuntime().totalMemory();     // Catch: Exception -> L14
        long r11 = r10 - Runtime.getRuntime().freeMemory();     // Catch: Exception -> L14
        long r12 = Runtime.getRuntime().maxMemory();     // Catch: Exception -> L14
        float r13 = r11;
        float r14 = f.c;     // Catch: Exception -> L14
        if (r13 <= (r12 * r14)) goto L11;
        boolean r15 = true;
    L12:
        f.e = new JvmMemoryinfo(Float.valueOf(r14), Long.valueOf(r12), Long.valueOf(r11), Long.valueOf(r10));     // Catch: Exception -> L14
        FLogger.a.i("ObricPerformanceMonitor", "checkJvmMemoryLeak, jvmMemoryLeak=" + r15 + ", jvmUsedMemory=" + r11 + ", jvmTotalMemory=" + r10 + ", jvmMaxMemory=" + r12 + ", jvmLeakThreshold=" + f.c);     // Catch: Exception -> L14
        r4 = r15;
        goto L17
    L11:
        r15 = false;
    L14:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "checkJvmMemoryLeak, e=" + e);
        goto L16
    }

    public static final void c(ObricPerformanceMonitorServiceImpl r11) {
        r11.getClass();
        DozeMode r0 = e();
        if (r0 != r11.f) goto L5;
        FLogger.a.i("ObricPerformanceMonitor", "handleDozeChange, dozeMode not changed, dozeMode = " + r11.f);
        return;
    L5:
        r11.f = r0;
        FLogger r1 = FLogger.a;
        r1.i("ObricPerformanceMonitor", "handleDozeChange, dozeMode changed, dozeMode = " + r11.f);
        int r2 = a.a[r11.f.ordinal()];
        if (r2 != 1) goto L8;
        r1.i("ObricPerformanceMonitor", "triggerDeepDozeCheck, dozeMode = " + r11.f);
        Job r3 = r11.c;
        if (r3 != null) goto L45;
    L50:
        r11.c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new triggerDeepDozeCheck.2(r11, null), 3, null);
        return;
    L45:
        if (r3.isActive() == true) goto L48;
        r3 = null;
    L48:
        if (r3 == null) goto L50;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        goto L50
    L8:
        if (r2 == 2) goto L25;
        Job r4 = r11.c;
        if (r4 != null) goto L12;
    L17:
        Job r12 = r11.d;
        if (r12 != null) goto L20;
        return;
    L20:
        if (r12.isActive() == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L54;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
        return;
    L54:
        return;
    L12:
        if (r4.isActive() == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L17;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        goto L17
    L25:
        Job r5 = r11.c;
        if (r5 != null) goto L28;
    L33:
        r1.i("ObricPerformanceMonitor", "triggerLightDozeCheck, dozeMode = " + r11.f);
        Job r6 = r11.d;
        if (r6 != null) goto L36;
    L41:
        r11.d = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new triggerLightDozeCheck.2(r11, null), 3, null);
        return;
    L36:
        if (r6.isActive() == true) goto L39;
        r6 = null;
    L39:
        if (r6 == null) goto L41;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
        goto L41
    L28:
        if (r5.isActive() == true) goto L31;
        r5 = null;
    L31:
        if (r5 == null) goto L33;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
        goto L33
    }

    public static final void d(ObricPerformanceMonitorServiceImpl r3) {
        r3.getClass();
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L11
        int r1 = Build.VERSION.SDK_INT;     // Catch: Exception -> L11
        if (r1 < 23) goto L7;
        r0.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");     // Catch: Exception -> L11
    L7:
        if (r1 < 33) goto L9;
        r0.addAction("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED");     // Catch: Exception -> L11
    L9:
        a(AppHost.a.getApplication(), r3.b, r0);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "registerDozeReceiver, e=" + e);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r8, DozeReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
