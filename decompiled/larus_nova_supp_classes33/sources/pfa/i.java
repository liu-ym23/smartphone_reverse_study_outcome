package pfa;

import android.app.ActivityManager;
import android.app.ApplicationStartInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.activeness.IObricActivenessMonitorService;
import com.obric.activeness.ObricActiveReason;
import com.obric.assistant.processesmanager.ObricKeepAliveFgService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i {
    public static final i a = null;
    public static boolean b;
    public static boolean c;
    public static long d;
    public static long e;
    public static boolean f;
    public static long g;
    public static long h;
    public static long i;
    public static int j;
    public static int k;
    public static boolean l;
    public static final Object m = null;
    public static final Lazy n = null;
    public static final g o = null;
    public static final h p = null;
    public static final b q = null;
    public static final a r = null;

    public static final class a implements k9a.b {
        public a() {
        }

        public final void a(boolean r6, ObricActiveReason r7) {
            Intrinsics.checkNotNullParameter(r7, "stateChangeReason");
            FLogger r0 = FLogger.a;
            r0.i("NovaProcessControler", "onStateChanged: isActive=" + r6 + ", isCurrentActive=" + i.c + ", reason=" + r7);
            if (r6 != i.c) goto L5;
            return;
        L5:
            i.c = r6;
            if (r6 == false) goto L8;
            i.a.getClass();
            i.a().removeCallbacks(i.o);
            i.a().postDelayed(i.p, i.e);
            r0.i("NovaProcessControler", "onBecomeActive: scheduled start in " + i.e + "ms");
            return;
        L8:
            i.a.getClass();
            Handler r8 = i.a();
            g r2 = i.o;
            r8.removeCallbacks(r2);
            i.a().removeCallbacks(i.p);
            i.a().postDelayed(r2, i.d);
            r0.i("NovaProcessControler", "onBecomeInactive: scheduled stop in " + i.d + "ms");
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            Object r2 = i.m;
            monitor-enter(r2);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (i.l == true) goto L9;
            FLogger.a.i("NovaProcessControler", "bootAutoStartExitCheckRunnable: skip, needBootAutoStartExitCheck=false");     // Catch: Throwable -> L23
            monitor-exit(r2);
            return;
        L9:
            i.a.getClass();     // Catch: Throwable -> L23
            boolean r3 = i.c();     // Catch: Throwable -> L23
            FLogger r4 = FLogger.a;     // Catch: Throwable -> L23
            r4.i("NovaProcessControler", "bootAutoStartExitCheckRunnable: isActive=" + r3 + ", retryCount=" + i.k);     // Catch: Throwable -> L23
            if (r3 == true) goto L15;
            i.l = false;     // Catch: Throwable -> L23
            r4.i("NovaProcessControler", "bootAutoStartExitCheckRunnable: kill self, pid=" + Process.myPid());     // Catch: Throwable -> L23
            i.f();     // Catch: Throwable -> L23
            Process.killProcess(Process.myPid());     // Catch: Throwable -> L23
            monitor-exit(r2);
            return;
        L15:
            if (i.k < i.j) goto L19;
            i.l = false;     // Catch: Throwable -> L23
            r4.i("NovaProcessControler", "bootAutoStartExitCheckRunnable: reach max retry count, stop recheck");     // Catch: Throwable -> L23
            monitor-exit(r2);
            return;
        L19:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L23
            monitor-exit(r2);
            i.k++;
            i.a().postDelayed(this, i.i);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public i() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [pfa.g] */
    /* JADX WARN: Type inference failed for: r0v12, types: [pfa.h] */
    static {
        a = new i();
        d = 300000;
        e = 2000;
        f = true;
        g = 600000;
        h = 60000;
        i = 20000;
        j = 10;
        m = new Object();
        n = LazyKt.lazy(new f());
        o = new g();
        p = new h();
        q = new b();
        r = new a();
    }

    public static Handler a() {
        return (Handler) s.c.getValue();
    }

    public static boolean c() {
        IObricActivenessMonitorService r0 = (IObricActivenessMonitorService) n.getValue();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.a(SetsKt.setOf(ObricActiveReason.DEVICE_SCREEN_ON));
    }

    public static void e() {
        if (b == false) goto L6;
        FLogger.a.d("NovaProcessControler", "startFgService: already running, skip");
        return;
    L6:
        boolean r0 = true;
        b = true;
        Lazy r1 = n.a;
        FLogger r3 = FLogger.a;     // Catch: Throwable -> L18
        StringBuilder r4 = new StringBuilder("startKeepAliveFgService, keepAliveHighLevel = ");     // Catch: Throwable -> L18
        Lazy r2 = n.a;     // Catch: Throwable -> L18
        r4.append(((Boolean) r2.getValue()).booleanValue());     // Catch: Throwable -> L18
        r4.append(", productName = ");     // Catch: Throwable -> L18
        r4.append((String) n.b.getValue());     // Catch: Throwable -> L18
        r3.i("ObricFgServiceControl", r4.toString());     // Catch: Throwable -> L18
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L21;
        AppHost.Companion r5 = AppHost.a;     // Catch: Throwable -> L18
        Intent r6 = new Intent(r5.getApplication(), ObricKeepAliveFgService.class);     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT >= 26) goto L14;
        r0 = false;
    L14:
        if (r0 == false) goto L16;
        r5.getApplication().startForegroundService(r6);     // Catch: Throwable -> L18
        goto L21
    L16:
        r5.getApplication().startService(r6);     // Catch: Throwable -> L18
    L21:
        return;
    L18:
        th = move-exception;
        FLogger.a.e("ObricFgServiceControl", "Failed to start startKeepAliveFgService", th);
    }

    public static void f() {
        if (b == true) goto L6;
        FLogger.a.d("NovaProcessControler", "stopFgService: not running, skip");
        return;
    L6:
        b = false;
        Lazy r0 = n.a;
        FLogger.a.i("ObricFgServiceControl", "stopFgService");     // Catch: Throwable -> L9
        AppHost.Companion r2 = AppHost.a;     // Catch: Throwable -> L9
        Intent r1 = new Intent(r2.getApplication(), ObricKeepAliveFgService.class);     // Catch: Throwable -> L9
        r2.getApplication().stopService(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        FLogger.a.e("ObricFgServiceControl", "Failed to stop stopFgService", th);
    }

    public static boolean b(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        if (Build.VERSION.SDK_INT >= 35) goto L31;
    L29:
        FLogger.a.i("NovaProcessControler", "isLaunchFromBoot: false");
        return false;
    L31:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L24
        Object r10 = r9.getSystemService("activity");     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L24
        ApplicationStartInfo r11 = (ApplicationStartInfo) CollectionsKt.firstOrNull(((ActivityManager) r10).getHistoricalProcessStartReasons(1));     // Catch: Throwable -> L24
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r11.getReason() != 3) goto L10;
        boolean r2 = true;
    L11:
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L24
        r5.i("NovaProcessControler", "isLaunchFromBoot: reason=" + r11.getReason());     // Catch: Throwable -> L24
        if (r2 == false) goto L22;
        Intent r3 = r11.getIntent();     // Catch: Throwable -> L24
        if (r3 == null) goto L16;
        String r4 = r3.getAction();     // Catch: Throwable -> L24
    L17:
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        boolean r6 = SetsKt.setOf(new String[]{"android.intent.action.BOOT_COMPLETED", "android.intent.action.LOCKED_BOOT_COMPLETED", "android.intent.action.QUICKBOOT_POWERON"}).contains(r4);     // Catch: Throwable -> L24
        r5.i("NovaProcessControler", "isLaunchFromBoot: reason=" + r11.getReason() + ", action=" + r4 + ", result=" + r6);     // Catch: Throwable -> L24
        if (r6 == false) goto L22;
        return true;
    L16:
        r4 = null;
    L22:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L29;
        FLogger.a.e("NovaProcessControler", "isLaunchFromBoot failed", r13);
        goto L29
    L10:
        r2 = false;
    L24:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    public static boolean d(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        ContentResolver r12 = r11.getContentResolver();
        boolean r1 = false;
        if (Settings.Global.getInt(r12, "device_provisioned", 0) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (Settings.Secure.getInt(r12, "user_setup_complete", 0) != 1) goto L9;
        boolean r3 = true;
    L10:
        String r13 = Settings.Global.getString(r12, "sys.boot_completed");
        if (r13 != null) goto L13;
        r13 = "0";
    L13:
        long r4 = SystemClock.elapsedRealtime();
        long r6 = SystemClock.uptimeMillis();
        if (0 <= r6) goto L16;
    L18:
        FLogger.a.i("NovaProcessControler", "isSystemJustBoot: bootRealTimeMs=" + r4 + ", bootUptimeMs=" + r6 + ", result=" + r1 + ", bootComplete=" + r13 + "，deviceProvisioned=" + r0 + "，userSetupComplete=" + r3);
        return r1;
    L16:
        if (r6 >= g) goto L18;
        r1 = true;
        goto L18
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }
}
