package com.obric.update.impl.v2.handler;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.obric.update.impl.v2.m;
import com.obric.update.impl.v2.o;
import com.ss.android.update.OnUpdateStatusChangedListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricUpdateHandler {
    public static final /* synthetic */ int t = 0;
    public final o a;
    public final goa.a b;
    public final goa.b c;
    public final m d;
    public final Function0<Unit> e;
    public volatile float f;
    public volatile ObricUpdateHandler$initThermalStatus$1 g;
    public volatile boolean h;
    public volatile boolean i;
    public volatile Job j;
    public volatile Job k;
    public volatile Job l;
    public volatile Job m;
    public final AtomicBoolean n;
    public final AtomicBoolean o;
    public final AtomicBoolean p;
    public final AtomicBoolean q;
    public final AtomicLong r;
    public final CoroutineScope s;

    public static final class a {
    }

    static {
    }

    public final void d() {
        this.r.incrementAndGet();
        Job r0 = this.m;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.m = null;
        this.q.set(false);
    }

    public final boolean l() {
        this.a.a.getClass();
        String r0 = com.ss.android.update.d.x().Z;
        FLogger.a.i("ObricUpdateHandler", "isObricChannel: channel=" + r0);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L14;
        return false;
    L14:
        if (StringsKt.startsWith$default(r0, "obric_", false, 2, null) != true) goto L19;
        return true;
    L19:
        return false;
    L7:
        r2 = false;
        goto L9
    }

    public final boolean p() {
        if (this.b.c == true) goto L5;
        return false;
    L5:
        if (this.b.d == false) goto L7;
        return false;
    L7:
        if (this.b.g == true) goto L16;
        this.a.d.getClass();
        if (com.obric.update.impl.v2.gateway.c.b() == true) goto L17;
        FLogger.a.i("ObricUpdateHandler", "pauseWifiAutoDownloadOnMobileNetwork: trigger=sdk_progress");
        m.e(this.d, "network_state", "auto pause download:sdk_progress", 4);
        o(true);
        return true;
    L17:
        return false;
    L16:
        return false;
    }

    public final void t() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("updateCacheRecord: updating cache record with versionCode=");
        this.a.a.getClass();
        com.ss.android.update.d r2 = com.ss.android.update.d.x();
        monitor-enter(r2);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r2.k == true) goto L7;
        r2.U();     // Catch: Throwable -> L11
        r2.k = true;     // Catch: Throwable -> L11
    L7:
        int r3 = r2.n;     // Catch: Throwable -> L11
        monitor-exit(r2);
        r1.append(r3);
        r0.i("ObricUpdateHandler", r1.toString());
        long r4 = t1.a.L0().getObricUpdateCheckResultCacheTime() * 1000;
        goa.b r5 = this.c;
        this.a.a.getClass();
        r5.d = new goa.b.b(com.obric.update.impl.v2.gateway.f.c(), System.currentTimeMillis() + r4);
    }

    public final void r() {
        d();
        this.b.d = false;
        this.b.b = false;
        this.b.c = false;
        this.b.f = false;
        this.p.set(false);
    }

    public static final void b(ObricUpdateHandler r4) {
        r4.getClass();
        FLogger r0 = FLogger.a;
        r0.i("ObricUpdateHandler", "onPluginInstalled: plugin pre-installed successfully");
        r4.c.a(100);
        r4.c.b(4);
        r4.b.g = false;
        r4.b.d = false;
        r4.b.f = false;
        r4.p.set(false);
        if (r4.b.h == false) goto L6;
        r0.i("ObricUpdateHandler", "onPluginInstalled: triggering onInstallReady");
        r4.b.h = false;
        r4.e.invoke();
        return;
    }

    public final void c(String r7) {
        FLogger.a.i("ObricUpdateHandler", "cancelDownload: cancelling current download");     // Catch: Exception -> L8
        d();     // Catch: Exception -> L8
        Job r1 = this.j;     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);     // Catch: Exception -> L8
    L6:
        this.p.set(true);     // Catch: Exception -> L8
        this.o.set(false);     // Catch: Exception -> L8
        this.c.b(1);     // Catch: Exception -> L8
        this.a.a.getClass();     // Catch: Exception -> L8
        com.ss.android.update.d.x().h();     // Catch: Exception -> L8
        this.b.e = false;     // Catch: Exception -> L8
        this.b.c = false;     // Catch: Exception -> L8
        this.b.b = false;     // Catch: Exception -> L8
        this.b.d = false;     // Catch: Exception -> L8
        this.b.f = false;     // Catch: Exception -> L8
        this.n.set(true);     // Catch: Exception -> L8
        m r2 = this.d;     // Catch: Exception -> L8
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L8
        r4.put("cancel_reason", r7);     // Catch: Exception -> L8
        Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L8
        r2.c("download", "cancel_download", r4);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e("ObricUpdateHandler", "cancelDownload error: " + e);
    }

    public final void f(String r17) {
        if (this.c.b != 4) goto L12;
        this.a.a.getClass();
        PolarisFileWrapper r0 = com.obric.update.impl.v2.gateway.f.b();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        FLogger.a.i("ObricUpdateHandler", "checkAutoDownload: downloaded state but apk missing, fallback to STATE_AVAILABLE");
        this.c.b(1);
        goto L12
    L7:
        if (r0.exists() != true) goto L9;
        r1 = true;
    L12:
        int r2 = this.c.b;
        if (r2 == 1) goto L21;
        if (r2 == 6) goto L21;
        if (r2 == 3) goto L21;
        FLogger.a.i("ObricUpdateHandler", "checkAutoDownload return, current state = " + r2);
        m r3 = this.d;
        JSONObject r4 = new JSONObject();
        r4.put("trigger_from", r17);
        Unit r5 = Unit.INSTANCE;
        r3.c("trigger_download", "state_not_match", r4);
        return;
    L21:
        if (this.b.c == true) goto L23;
    L26:
        this.a.d.getClass();
        boolean r6 = com.obric.update.impl.v2.gateway.c.b();
        this.a.f.getClass();
        boolean r7 = ObricUpdateSettingDelegate.a.a();
        this.a.a.getClass();
        boolean r8 = com.ss.android.update.d.x().T();
        this.a.a.getClass();
        PolarisFileWrapper r10 = com.obric.update.impl.v2.gateway.f.b();
        if (r10 != null) goto L29;
    L31:
        boolean r11 = false;
    L32:
        boolean r12 = this.b.e;
        boolean r13 = this.b.g;
        this.a.f.getClass();
        float r14 = t1.a.L0().getObricUpdateTemperatureBlockThreshold();
        if (this.f <= r14) goto L35;
        boolean r15 = true;
    L36:
        FLogger r16 = FLogger.a;
        r16.i("ObricUpdateHandler", "checkAutoDownload isWifi:" + r6 + ",wifiAutoDownloadEnable=" + r7 + ",isUpdating=" + r8 + ",isApkReady=" + r11 + ",isDownloading=" + r12 + ",isZeusPluginPreInstalling=" + r13 + ",currentTemperature=" + this.f + ",temperatureBlockThreshold=" + r14 + ",isThermalBlocked=" + r15);
        if (r6 == false) goto L49;
        if (r7 == false) goto L49;
        if (r8 == true) goto L49;
        if (r11 == true) goto L49;
        if (r12 == true) goto L49;
        if (r13 == true) goto L49;
        if (r15 == true) goto L49;
        r16.i("ObricUpdateHandler", "checkAutoDownload: all conditions met, triggering startDownload");
        this.b.b = false;     // Catch: Exception -> L47
        this.b.c = true;     // Catch: Exception -> L47
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L47
        r9.put("trigger_from", r17);     // Catch: Exception -> L47
        Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L47
        s(this, "wifi_auto_download", false, r9, 0, 8);     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        q(r17, e);
        return;
    L49:
        if (r15 == false) goto L51;
        String r19 = "thermal_too_high";
    L52:
        m r20 = this.d;
        JSONObject r21 = new JSONObject();
        r21.put("trigger_from", r17);
        r21.put("current_temperature", Float.valueOf(this.f));
        Unit r22 = Unit.INSTANCE;
        r20.c("trigger_download", r19, r21);
        return;
    L51:
        r19 = "auto_download_check_fail";
        goto L52
    L35:
        r15 = false;
        goto L36
    L29:
        if (r10.exists() != true) goto L31;
        r11 = true;
        goto L32
    L23:
        if (this.b.d == false) goto L26;
        FLogger.a.i("ObricUpdateHandler", "checkAutoDownload return, wifi-auto path is frozen by user interference");
        m r23 = this.d;
        JSONObject r24 = new JSONObject();
        r24.put("trigger_from", r17);
        Unit r25 = Unit.INSTANCE;
        r23.c("trigger_download", "wifi_auto_interfered", r24);
    }

    public final Object g(Continuation<? super Boolean> r10) {
        if ((r10 instanceof checkForceUpdateForRomUnmatched.1) == false) goto L7;
        checkForceUpdateForRomUnmatched.1 r1 = (checkForceUpdateForRomUnmatched.1) r10;
        int r2 = r1.label;
        if ((r2 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r11 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = true;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L29
    L19:
        boolean r12 = ((Boolean) r11).booleanValue();     // Catch: Exception -> L29
        FLogger r6 = FLogger.a;     // Catch: Exception -> L29
        StringBuilder r7 = new StringBuilder("checkForceUpdateForRomUnmatched: isRomCompatible=");     // Catch: Exception -> L29
        if (r12 == false) goto L22;
        boolean r0 = true;
    L23:
        r7.append(r0);     // Catch: Exception -> L29
        r6.i("ObricUpdateHandler", r7.toString());     // Catch: Exception -> L29
        if (r12 == false) goto L27;
        r5 = false;
    L27:
        return Boxing.boxBoolean(r5);
    L22:
        r0 = false;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        FLogger.a.i("ObricUpdateHandler", "checkForceUpdateForRomUnmatched: start");     // Catch: Exception -> L29
        String r13 = t9a.b.b().b().b();     // Catch: Exception -> L29
        CoroutineDispatcher r8 = Dispatchers.getIO();     // Catch: Exception -> L29
        checkForceUpdateForRomUnmatched.isRomCompatible.1 r9 = new checkForceUpdateForRomUnmatched.isRomCompatible.1(r13, null);     // Catch: Exception -> L29
        r1.label = 1;     // Catch: Exception -> L29
        r11 = BuildersKt.withContext(r8, r9, r1);     // Catch: Exception -> L29
        if (r11 != r3) goto L19;
        return r3;
    L29:
        e = move-exception;
        FLogger.a.i("ObricUpdateHandler", "checkForceUpdateForRomUnmatched: fail:" + e);
        return Boxing.boxBoolean(false);
    L7:
        r1 = new checkForceUpdateForRomUnmatched.1(this, r10);
        goto L8
    }

    public final void h(h r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        Job r0 = this.l;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.l = BuildersKt.launch$default(this.s, null, null, new ObricUpdateHandler$checkNetworkState$1(this, r10, null), 3, null);
    }

    public final Object j(Continuation<? super String> r8) {
        if ((r8 instanceof fetchLatestApkUrl.1) == false) goto L7;
        fetchLatestApkUrl.1 r1 = (fetchLatestApkUrl.1) r8;
        int r2 = r1.label;
        if ((r2 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r9 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L38
    L19:
        this.a.a.getClass();     // Catch: Exception -> L38
        com.ss.android.update.d r10 = com.ss.android.update.d.x();     // Catch: Exception -> L38
        monitor-enter(r10);     // Catch: Exception -> L38
    L40:
        th = move-exception;
        throw th;     // Catch: Exception -> L38
    L22:
        if (r10.k == true) goto L24;
        r10.U();     // Catch: Throwable -> L40
        r10.k = true;     // Catch: Throwable -> L40
    L24:
        String r5 = r10.l;     // Catch: Throwable -> L40
        monitor-exit(r10);     // Catch: Exception -> L38
        FLogger r11 = FLogger.a;     // Catch: Exception -> L38
        StringBuilder r6 = new StringBuilder("fetchLatestApkUrl: hasUrl=");     // Catch: Exception -> L38
        if (r5 != null) goto L29;
    L32:
        boolean r0 = true;
    L33:
        r6.append(!r0);     // Catch: Exception -> L38
        r11.i("ObricUpdateHandler", r6.toString());     // Catch: Exception -> L38
        if (r5 != null) goto L36;
        return null;
    L36:
        if ((!StringsKt.isBlank(r5)) == true) goto L50;
        return null;
    L50:
        return r5;
    L29:
        if (StringsKt.isBlank(r5) == true) goto L32;
        r0 = false;
        goto L33
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("ObricUpdateHandler", "fetchLatestApkUrl: start");     // Catch: Exception -> L38
        CoroutineDispatcher r12 = Dispatchers.getIO();     // Catch: Exception -> L38
        fetchLatestApkUrl.2 r7 = new fetchLatestApkUrl.2(this, null);     // Catch: Exception -> L38
        r1.label = 1;     // Catch: Exception -> L38
        if (BuildersKt.withContext(r12, r7, r1) != r3) goto L19;
        return r3;
    L38:
        e = move-exception;
        FLogger.a.i("ObricUpdateHandler", "fetchLatestApkUrl: fail:" + e);
        return null;
    L7:
        r1 = new fetchLatestApkUrl.1(this, r8);
        goto L8
    }

    public final void n(boolean r15) {
        FLogger r0 = FLogger.a;
        r0.i("ObricUpdateHandler", "onDownloadCompleted start: fromDownloadResult=" + r15 + ", autoInstall=false");
        Job r1 = this.k;
        if (r1 == null) goto L7;
        boolean r3 = true;
        if (r1.isActive() != true) goto L7;
    L8:
        boolean r2 = this.b.g;
        m.d(this.d, "plugin_install", null, 6);
        if (r3 == true) goto L14;
        if (r2 == true) goto L14;
        this.k = BuildersKt.launch$default(this.s, null, null, new onDownloadCompleted.1(this, r15, null), 3, null);
        return;
    L14:
        r0.i("ObricUpdateHandler", "onDownloadCompleted ignored, plugin install already running (isActive=" + r3 + ", isPreInstalling=" + r2 + ')');
        this.d.c("plugin_install", "already_running", null);
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final void o(boolean r6) {
        FLogger.a.i("ObricUpdateHandler", "pauseDownload: pausing current download");     // Catch: Exception -> L12
        d();     // Catch: Exception -> L12
        Job r1 = this.j;     // Catch: Exception -> L12
        if (r1 == null) goto L7;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);     // Catch: Exception -> L12
    L7:
        if (this.b.c == false) goto L10;
        if (r6 == true) goto L10;
        this.b.d = true;     // Catch: Exception -> L12
    L10:
        this.p.set(true);     // Catch: Exception -> L12
        this.o.set(false);     // Catch: Exception -> L12
        this.c.b(3);     // Catch: Exception -> L12
        this.b.e = false;     // Catch: Exception -> L12
        this.n.set(true);     // Catch: Exception -> L12
        this.a.a.getClass();     // Catch: Exception -> L12
        com.ss.android.update.d.x().h();     // Catch: Exception -> L12
        m r7 = this.d;     // Catch: Exception -> L12
        int r4 = m.d;     // Catch: Exception -> L12
        r7.c("download", "pause_download", null);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        FLogger.a.e("ObricUpdateHandler", "pauseDownload error: " + e);
    }

    public final void e(String r14, boolean r15) {
        Job r0 = this.m;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.q.set(false);
        long r3 = this.r.incrementAndGet();
        this.a.a.getClass();
        com.ss.android.update.d r1 = com.ss.android.update.d.x();
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (r1.k == true) goto L10;
        r1.U();     // Catch: Throwable -> L14
        r1.k = true;     // Catch: Throwable -> L14
    L10:
        int r6 = r1.n;     // Catch: Throwable -> L14
        monitor-exit(r1);
        this.m = BuildersKt.launch$default(this.s, null, null, new checkAndRestartSdkRestoredDownload.1(r3, this, r6, r14, r15, null), 3, null);
    }

    public final void k(boolean r11, boolean r12) {
        Job r4 = this.j;     // Catch: Exception -> L37
        if (r4 == null) goto L6;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);     // Catch: Exception -> L37
    L6:
        boolean r5 = this.q.getAndSet(false);     // Catch: Exception -> L37
        int r8 = this.c.b;     // Catch: Exception -> L37
        if (this.p.get() == false) goto L10;
        if (r5 == true) goto L10;
    L35:
        FLogger.a.i("ObricUpdateHandler", "handleDownloadResult ignored after termination: success=" + r11 + ",state=" + r8);     // Catch: Exception -> L37
        return;
    L10:
        if (r8 == 4) goto L35;
        if (r8 == 5) goto L35;
        if (r8 == (-1)) goto L35;
        if (r11 == false) goto L21;
        if (this.o.compareAndSet(false, true) == false) goto L21;
        this.j = null;     // Catch: Exception -> L37
        this.n.set(false);     // Catch: Exception -> L37
    L21:
        if (this.n.get() == false) goto L24;
        FLogger.a.i("ObricUpdateHandler", "handleDownloadResult ignored, result already consumed: success=" + r11);     // Catch: Exception -> L37
        return;
    L24:
        if (r11 == true) goto L26;
        this.o.set(false);     // Catch: Exception -> L37
    L26:
        boolean r2 = this.b.b;     // Catch: Exception -> L37
        FLogger r3 = FLogger.a;     // Catch: Exception -> L37
        r3.i("ObricUpdateHandler", "handleDownloadResult: success=" + r11 + ", isManual=" + r2);     // Catch: Exception -> L37
        if (r11 == true) goto L29;
        this.j = BuildersKt.launch$default(this.s, null, null, new handleDownloadResult.1(this, null), 3, null);     // Catch: Exception -> L37
    L34:
        this.b.e = false;     // Catch: Exception -> L37
        return;
    L29:
        if (this.n.compareAndSet(false, true) == true) goto L32;
        r3.i("ObricUpdateHandler", "download success ignored, result already consumed");     // Catch: Exception -> L37
        return;
    L32:
        m.e(this.d, "download", null, 6);     // Catch: Exception -> L37
        n(r12);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        FLogger.a.e("ObricUpdateHandler", "handleDownloadResult error: " + e);
    }

    public final Object m(String r24, Continuation<? super Boolean> r25) {
        String r0 = r24;
        if ((r25 instanceof isUpdateAvailable.1) == false) goto L7;
        isUpdateAvailable.1 r14 = (isUpdateAvailable.1) r25;
        int r15 = r14.label;
        if ((r15 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r2 = r14.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r14.label;
        boolean r8 = true;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r0 = (String) r14.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L72
    L49:
        boolean r4 = ((Boolean) r2).booleanValue();     // Catch: Exception -> L72
        FLogger r5 = FLogger.a;     // Catch: Exception -> L72
        StringBuilder r6 = new StringBuilder("isUpdateAvailable: hasNewVersion=");     // Catch: Exception -> L72
        if (r4 == false) goto L52;
        boolean r7 = true;
    L53:
        r6.append(r7);     // Catch: Exception -> L72
        r6.append(" scene=");     // Catch: Exception -> L72
        r6.append(r0);     // Catch: Exception -> L72
        r5.i("ObricUpdateHandler", r6.toString());     // Catch: Exception -> L72
        if (r4 == true) goto L56;
    L59:
        if (r4 == false) goto L61;
        r5.i("ObricUpdateHandler", "isUpdateAvailable: hasNewVersion checkAutoDownload. scene=" + r0);     // Catch: Exception -> L72
        t();     // Catch: Exception -> L72
        m.d(this.d, "trigger_download", "is_update_available", 4);     // Catch: Exception -> L72
        f("is_update_available");     // Catch: Exception -> L72
    L62:
        StringBuilder r9 = new StringBuilder("isUpdateAvailable: end. hasNewVersion=");     // Catch: Exception -> L72
        if (r4 == false) goto L65;
        boolean r10 = true;
    L66:
        r9.append(r10);     // Catch: Exception -> L72
        r9.append(". ");     // Catch: Exception -> L72
        r9.append(r0);     // Catch: Exception -> L72
        r5.i("ObricUpdateHandler", r9.toString());     // Catch: Exception -> L72
        if (r4 == true) goto L71;
        r8 = false;
    L71:
        return Boxing.boxBoolean(r8);
    L65:
        r10 = false;
        goto L66
    L61:
        this.c.b(-1);     // Catch: Exception -> L72
        r();     // Catch: Exception -> L72
        r5.i("ObricUpdateHandler", "isUpdateAvailable: no new version available. scene=" + r0);     // Catch: Exception -> L72
        goto L62
    L56:
        if (l() == true) goto L59;
        r5.i("ObricUpdateHandler", "isUpdateAvailable: return false, not obric channel. " + r0);     // Catch: Exception -> L72
        this.c.b(-1);     // Catch: Exception -> L72
        r();     // Catch: Exception -> L72
        return Boxing.boxBoolean(false);
    L52:
        r7 = false;
        goto L53
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        FLogger r11 = FLogger.a;     // Catch: Exception -> L72
        r11.i("ObricUpdateHandler", "isUpdateAvailable: start scene=" + r0);     // Catch: Exception -> L72
        this.a.a.getClass();     // Catch: Exception -> L72
        if (com.ss.android.update.d.x().T() == false) goto L21;
        r11.i("ObricUpdateHandler", "isUpdateAvailable: return true, sdk updating. " + r0);     // Catch: Exception -> L72
        return Boxing.boxBoolean(true);
    L21:
        this.a.a.getClass();     // Catch: Exception -> L72
        PolarisFileWrapper r12 = com.obric.update.impl.v2.gateway.f.b();     // Catch: Exception -> L72
        if (r12 != null) goto L24;
    L26:
        boolean r13 = false;
    L27:
        if (r13 == false) goto L30;
        r11.i("ObricUpdateHandler", "isUpdateAvailable: return true, apk exists and exc onDownloadCompleted. " + r0);     // Catch: Exception -> L72
        n(false);     // Catch: Exception -> L72
        return Boxing.boxBoolean(true);
    L30:
        goa.b.b r17 = this.c.d;     // Catch: Exception -> L72
        if (r17 != null) goto L33;
    L38:
        this.a.c.getClass();     // Catch: Exception -> L72
        if (AccountService.a.isLogin().booleanValue() == true) goto L42;
        r11.i("ObricUpdateHandler", "isUpdateAvailable: return false, not Login. " + r0);     // Catch: Exception -> L72
        return Boxing.boxBoolean(false);
    L42:
        this.a.d.getClass();     // Catch: Exception -> L72
        if (com.obric.update.impl.v2.gateway.c.a() == true) goto L46;
        r11.i("ObricUpdateHandler", "isUpdateAvailable: return false, net not available. " + r0);     // Catch: Exception -> L72
        return Boxing.boxBoolean(false);
    L46:
        CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Exception -> L72
        isUpdateAvailable.hasNewVersion.1 r19 = new isUpdateAvailable.hasNewVersion.1(this, null);     // Catch: Exception -> L72
        r14.L$0 = r0;     // Catch: Exception -> L72
        r14.label = 1;     // Catch: Exception -> L72
        r2 = BuildersKt.withContext(r18, r19, r14);     // Catch: Exception -> L72
        if (r2 != r16) goto L49;
        return r16;
    L33:
        if (r17.b <= System.currentTimeMillis()) goto L38;
        if (this.c.b == (-1)) goto L38;
        r11.i("ObricUpdateHandler", "isUpdateAvailable: return true, cache hit=" + r17.a + ",checkAutoDownload. scene=" + r0);     // Catch: Exception -> L72
        m.d(this.d, "trigger_download", "is_update_available", 4);     // Catch: Exception -> L72
        f("is_update_available");     // Catch: Exception -> L72
        return Boxing.boxBoolean(true);
    L24:
        if (r12.exists() != true) goto L26;
        r13 = true;
    L72:
        e = move-exception;
        FLogger.a.i("ObricUpdateHandler", "isUpdateAvailable: fail: " + e);
        return Boxing.boxBoolean(false);
    L7:
        r14 = new isUpdateAvailable.1(this, r25);
        goto L8
    }

    public final void q(String r4, Throwable r5) {
        m r0 = this.d;
        JSONObject r1 = new JSONObject();
        r1.put("trigger_from", r4);
        String r6 = r5.getMessage();
        if (r6 != null) goto L5;
        r6 = r5.toString();
    L5:
        r1.put("error", r6);
        Unit r7 = Unit.INSTANCE;
        r0.c("trigger_download", "exception", r1);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Application r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L35
        int r1 = r0.result;     // Catch: Exception -> L35
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L18;
        return r8.registerReceiver(r9, r10);
    L18:
        return r0.intent;
    L20:
        return new Intent();
    L22:
        return r8.registerReceiver(r9, r10);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r8.registerReceiver(r9, r10);
    }

    public final void i(boolean r19, String r20, OnUpdateStatusChangedListener r21) {
        Intrinsics.checkNotNullParameter(r21, "listener");
        FLogger r9 = FLogger.a;     // Catch: Exception -> L43
        r9.i("ObricUpdateHandler", "checkUpdate isAutoCheck=" + r19 + ", scene=" + r20);     // Catch: Exception -> L43
        m.d(this.d, "check_update", r20, 4);     // Catch: Exception -> L43
        this.a.c.getClass();     // Catch: Exception -> L43
        if (AccountService.a.isLogin().booleanValue() == true) goto L8;
        r9.i("ObricUpdateHandler", "checkUpdate ignored, not login");     // Catch: Exception -> L43
        this.d.c("check_update", "not_login", null);     // Catch: Exception -> L43
        return;
    L8:
        this.a.d.getClass();     // Catch: Exception -> L43
        if (com.obric.update.impl.v2.gateway.c.a() == true) goto L12;
        r9.i("ObricUpdateHandler", "checkUpdate ignored, network unavailable");     // Catch: Exception -> L43
        this.d.c("check_update", "no_network", null);     // Catch: Exception -> L43
        return;
    L12:
        this.a.a.getClass();     // Catch: Exception -> L43
        if (com.ss.android.update.d.x().T() == false) goto L15;
    L41:
        StringBuilder r0 = new StringBuilder("checkUpdate ignored, sdk updating=");     // Catch: Exception -> L43
        this.a.a.getClass();     // Catch: Exception -> L43
        r0.append(com.ss.android.update.d.x().T());     // Catch: Exception -> L43
        r0.append(",state = ");     // Catch: Exception -> L43
        r0.append(this.c.b);     // Catch: Exception -> L43
        r0.append(",isDownloading=");     // Catch: Exception -> L43
        r0.append(this.b.e);     // Catch: Exception -> L43
        r9.i("ObricUpdateHandler", r0.toString());     // Catch: Exception -> L43
        this.d.c("check_update", "is_updating", null);     // Catch: Exception -> L43
        return;
    L15:
        if (this.b.e == true) goto L41;
        goa.b.b r6 = this.c.d;     // Catch: Exception -> L43
        int r7 = 1;
        if (r6 != null) goto L20;
    L30:
        if (r19 == false) goto L32;
        r7 = 2;
    L32:
        com.obric.update.impl.v2.gateway.f r1 = this.a.a;     // Catch: Exception -> L43
        hoa.h r2 = hoa.h.a;     // Catch: Exception -> L43
        hoa.a r5 = hoa.a.a;     // Catch: Exception -> L43
        r1.getClass();     // Catch: Exception -> L43
        Intrinsics.checkNotNullParameter(r2, "main");     // Catch: Exception -> L43
        Intrinsics.checkNotNullParameter(r5, "check");     // Catch: Exception -> L43
        com.ss.android.update.d r8 = com.ss.android.update.d.x();     // Catch: Exception -> L43
        monitor-enter(r8);     // Catch: Exception -> L43
        r8.h0 = r2;     // Catch: Throwable -> L38
        r8.i0 = r5;     // Catch: Throwable -> L38
        monitor-exit(r8);     // Catch: Throwable -> L38
        r9.i("ObricUpdateHandler", "checkUpdate: starting sdk checkUpdate");     // Catch: Exception -> L43
        this.a.a.getClass();     // Catch: Exception -> L43
        Intrinsics.checkNotNullParameter(r21, "listener");     // Catch: Exception -> L43
        com.ss.android.update.d r3 = com.ss.android.update.d.x();     // Catch: Exception -> L43
        r3.Y(r21);     // Catch: Exception -> L43
        r3.g0(r7, 3, r21, false);     // Catch: Exception -> L43
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L20:
        if (r6.b <= System.currentTimeMillis()) goto L30;
        int r13 = this.c.b;     // Catch: Exception -> L43
        r9.i("ObricUpdateHandler", "checkUpdate cache hit=" + r6.a + " scene=" + r20 + ",current_state=" + r13);     // Catch: Exception -> L43
        if (r13 == (-1)) goto L30;
        this.d.c("check_update", "cache_hit", null);     // Catch: Exception -> L43
        m.d(this.d, "trigger_download", "check_update", 4);     // Catch: Exception -> L43
        f("check_update");     // Catch: Exception -> L43
        this.a.a.getClass();     // Catch: Exception -> L43
        if (com.ss.android.update.d.x().P() == false) goto L27;
        hoa.h.a.a(true);     // Catch: Exception -> L43
        r9.i("ObricUpdateHandler", "checkUpdate cache hit，forceUpdate showMainDialog");     // Catch: Exception -> L43
        return;
    L27:
        if (r19 == true) goto L49;
        hoa.a.a.a(1);     // Catch: Exception -> L43
        r9.i("ObricUpdateHandler", "checkUpdate cache hit，not isAutoCheck showMainDialog");     // Catch: Exception -> L43
        return;
    L49:
        return;
    L43:
        e = move-exception;
        FLogger.a.i("ObricUpdateHandler", "checkUpdate fail: " + e);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.update.impl.v2.handler.ObricUpdateHandler$initThermalStatus$1] */
    public ObricUpdateHandler(o r4, goa.a r5, goa.b r6, m r7, com.obric.update.impl.v2.g r8) {
        Intrinsics.checkNotNullParameter(r4, "gateways");
        Intrinsics.checkNotNullParameter(r5, "flowContext");
        Intrinsics.checkNotNullParameter(r6, "stateHolder");
        Intrinsics.checkNotNullParameter(r7, "pipelineReporter");
        Intrinsics.checkNotNullParameter(r8, "onInstallReady");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = -1.0f;
        r4.d.getClass();
        this.h = com.obric.update.impl.v2.gateway.c.b();
        r4.d.getClass();
        this.i = com.obric.update.impl.v2.gateway.c.a();
        IntentFilter r9 = new IntentFilter("android.intent.action.BATTERY_CHANGED");     // Catch: Exception -> L10
        AppHost.Companion r10 = AppHost.a;     // Catch: Exception -> L10
        Intent r0 = a(r10.getApplication(), null, r9);     // Catch: Exception -> L10
        if (r0 == null) goto L8;
        int r1 = r0.getIntExtra("temperature", -1);     // Catch: Exception -> L10
        if (r1 == (-1)) goto L8;
        this.f = r1 / 10.0f;     // Catch: Exception -> L10
    L8:
        this.g = new ObricUpdateHandler$initThermalStatus$1(this);     // Catch: Exception -> L10
        a(r10.getApplication(), this.g, r9);     // Catch: Exception -> L10
        FLogger.a.i("ObricUpdateHandler", "initThermalStatus: registered battery receiver for temperature tracking, initial temp=" + this.f);     // Catch: Exception -> L10
    L12:
        this.n = new AtomicBoolean(false);
        this.o = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.r = new AtomicLong(0);
        this.s = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        return;
    L10:
        e = move-exception;
        FLogger.a.e("ObricUpdateHandler", "initThermalStatus failed: " + e);
        goto L12
    }

    public static void s(ObricUpdateHandler r3, String r4, boolean r5, JSONObject r6, long r7, int r9) {
        if ((r9 & 4) == 0) goto L6;
        r6 = null;
    L6:
        if ((r9 & 8) == 0) goto L11;
        Job r8 = r3.m;
        if (r8 == null) goto L10;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L10:
        r3.q.set(false);
        r7 = r3.r.incrementAndGet();
    L11:
        if (r5 == false) goto L13;
        r3.c.b(2);
    L13:
        r3.p.set(false);
        r3.q.set(true);
        r3.n.set(false);
        r3.o.set(false);
        r3.a.a.getClass();     // Catch: Exception -> L17
        com.ss.android.update.d.x().h0(false);     // Catch: Exception -> L17
        m r10 = r3.d;
        r10.getClass();
        Intrinsics.checkNotNullParameter("trigger_download", "stage");
        r10.b("trigger_download", "success", r4, r6);
        return;
    L17:
        e = move-exception;
        if (r7 != r3.r.get()) goto L21;
        r3.q.set(false);
    L21:
        throw e;
    }
}
