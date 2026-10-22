package com.obric.assistant.processesmanager;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.activeness.IObricActivenessMonitorService;
import com.obric.activeness.ObricActiveReason;
import com.obric.assistant.ObricProcessesManagerConfig;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.t1;
import f09.a;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import pfa.e;
import pfa.i;
import pfa.j;
import pfa.k;
import pfa.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/processesmanager/ObricProcessesManagerImpl;", "Lcom/obric/assistant/processesmanager/IObricProcessesManager;", "<init>", "()V", "listener", "com/obric/assistant/processesmanager/ObricProcessesManagerImpl$listener$1", "Lcom/obric/assistant/processesmanager/ObricProcessesManagerImpl$listener$1;", "init", "", "initMemoryKeepAlive", "keepAliveLevel", "", "reconnectDelayMs", "", "initBindDelayMs", "initKeepAliveState", "processesManagerConfig", "Lcom/obric/assistant/ObricProcessesManagerConfig;", "startKeepAliveNormalService", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricProcessesManagerImpl implements IObricProcessesManager {
    public final b b;

    public static final class b implements a.b {
        public b() {
        }

        public final void onAllActivityDestroyed() {
            FLogger.a.i("ObricProcessesManagerImpl", "onAllActivityDestroyed");
        }

        public final void onAppBackground() {
            FLogger.a.i("ObricProcessesManagerImpl", "onAppBackground");
        }

        public final void onAppForeground() {
            FLogger.a.i("ObricProcessesManagerImpl", "onAppForeground");
        }
    }

    static {
    }

    public final void init() {
        FLogger.a.i("ObricProcessesManagerImpl", "ObricProcessesManagerImpl init");
        a(t1.a.getObricProcessesManagerConfig());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("ObricProcessesManagerImpl", "ObricProcessesManagerImpl init fail", e);
    }

    public ObricProcessesManagerImpl() {
        this.b = new b();
    }

    public final void a(ObricProcessesManagerConfig r28) {
        String r1 = ObricFeatureServiceDelegate.b.f();
        FLogger r0 = FLogger.a;
        r0.i("ObricProcessesManagerImpl", "initKeepAliveState, keepAliveLevel = " + r1);
        int r2 = mda.a.a;
        AppHost.Companion r3 = AppHost.a;
        if (mda.a.b(r3.getApplication()) == false) goto L44;
        if (Intrinsics.areEqual(r1, "MidLevel") == false) goto L12;
        r0.i("ObricProcessesManagerImpl", "startKeepAliveNormalService, productName = " + t9a.b.a().d());     // Catch: Throwable -> L9
        Intent r4 = new Intent(r3.getApplication(), ObricKeepAliveNormalService.class);     // Catch: Throwable -> L9
        r4.putExtra("caller", "myself");     // Catch: Throwable -> L9
        r3.getApplication().startService(r4);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        FLogger.a.e("ObricProcessesManagerImpl", "Failed to start startKeepAliveNormalService", th);
    L12:
        if (Intrinsics.areEqual(r1, "HighLevel") == false) goto L14;
    L42:
        AppHost.a.a().j(this.b);
        return;
    L14:
        if (Intrinsics.areEqual(r1, "LowLevel") == false) goto L16;
        boolean r5 = r28.getEnableBootAutoStartExitForLow();
    L17:
        i r14 = i.a;
        long r16 = r28.getNovaStopFgsDelayMs();
        long r18 = r28.getNovaStartFgsDelayMs();
        long r20 = r28.getBootAutoStartWindowMs();
        long r22 = r28.getBootAutoStartFirstCheckDelayMs();
        long r24 = r28.getBootAutoStartRetryDelayMs();
        int r26 = r28.getBootAutoStartMaxRetryCount();
        k r15 = new k(r16, r18, r5, r20, r22, r24, r26);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "params");
        i.d = r16;
        i.e = r18;
        i.f = r5;
        i.g = r20;
        i.h = r22;
        i.i = r24;
        i.j = r26;
        FLogger r6 = FLogger.a;
        r6.i("NovaProcessControler", "init: stopDelayMs=" + i.d + ", startDelayMs=" + i.e + ", enableBootAutoStartExit=" + i.f + ", bootAutoStartWindowMs=" + i.g + ", bootAutoStartFirstCheckDelayMs=" + i.h + ", bootAutoStartRetryDelayMs=" + i.i + ", bootAutoStartMaxRetryCount=" + i.j);
        IObricActivenessMonitorService r7 = (IObricActivenessMonitorService) i.n.getValue();
        if (r7 == null) goto L20;
        r7.b(i.r, SetsKt.setOf(ObricActiveReason.DEVICE_SCREEN_ON));
    L20:
        i.e();
        i.a().postDelayed(i.o, i.d);
        Object r8 = i.m;
        monitor-enter(r8);
    L39:
        th = move-exception;
        throw th;
    L23:
        if (i.f == true) goto L27;
        i.l = false;     // Catch: Throwable -> L39
        i.k = 0;     // Catch: Throwable -> L39
        i.a().removeCallbacks(i.q);     // Catch: Throwable -> L39
        r6.i("NovaProcessControler", "initAutoStartExit: disabled by config");     // Catch: Throwable -> L39
        monitor-exit(r8);
        goto L42
    L27:
        AppHost.Companion r9 = AppHost.a;     // Catch: Throwable -> L39
        Application r10 = r9.getApplication();     // Catch: Throwable -> L39
        boolean r11 = i.b(r10);     // Catch: Throwable -> L39
        boolean r12 = i.d(r10);     // Catch: Throwable -> L39
        if (r11 == true) goto L32;
        if (r12 == true) goto L32;
        boolean r13 = false;
    L33:
        i.l = r13;     // Catch: Throwable -> L39
        i.k = 0;     // Catch: Throwable -> L39
        Handler r17 = i.a();     // Catch: Throwable -> L39
        Runnable r19 = i.q;     // Catch: Throwable -> L39
        r17.removeCallbacks(r19);     // Catch: Throwable -> L39
        r6.i("NovaProcessControler", "initAutoStartExit: launchFromBoot=" + r11 + ", systemJustBoot=" + r12 + ", needBootAutoStartExitCheck=" + i.l);     // Catch: Throwable -> L39
        if (i.l == false) goto L36;
        i.a().postDelayed(r19, i.h);     // Catch: Throwable -> L39
        r6.i("NovaProcessControler", "initAutoStartExit: post bootAutoStartExitCheckRunnable delay=" + i.h);     // Catch: Throwable -> L39
    L36:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(r8);
        r9.a().j(new j());
    L32:
        r13 = true;
        goto L33
    L16:
        r5 = r28.getEnableBootAutoStartExit();
        goto L17
    L44:
        if (mda.a.a(r3.getApplication()) == false) goto L51;
        long r23 = r28.getMemoryReconnectDelayMs();
        long r25 = r28.getMemoryInitBindDelayMs();
        e r27 = e.a;
        Intrinsics.checkNotNullParameter(r1, "keepAliveLevel");
        e.f = r1;
        e.d = r23;
        e.e = r25;
        r0.i("MemoryProcessControler", "init: keepAliveLevel=" + r1 + ", reconnectDelayMs=" + r23 + ", initBindDelayMs=" + e.e);
        Lazy r29 = s.c;
        Handler r30 = (Handler) r29.getValue();
        Runnable r31 = e.j;
        r30.removeCallbacks(r31);
        ((Handler) r29.getValue()).postDelayed(r31, e.e);
        return;
    }
}
