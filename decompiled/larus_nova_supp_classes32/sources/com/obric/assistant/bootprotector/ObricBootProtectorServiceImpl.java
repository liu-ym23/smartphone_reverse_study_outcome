package com.obric.assistant.bootprotector;

import android.app.Application;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.SystemClock;
import android.webkit.URLUtil;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bootprotector.activity.BootProtectorLandingActivity;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd9.i;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/bootprotector/ObricBootProtectorServiceImpl;", "Lcom/obric/assistant/spi/bootprotector/IObricBootProtectorSPIService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "latestApkUrlRef", "Ljava/util/concurrent/atomic/AtomicReference;", NameKeys.UnloadStrategy_No_Strategy, "fetchStartTime", NameKeys.UnloadStrategy_No_Strategy, "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "isObricHandler", NameKeys.UnloadStrategy_No_Strategy, "prefetchLatestAppApkUrl", NameKeys.UnloadStrategy_No_Strategy, "fetchAndCache", "reason", "isValidUrl", LynxEventReporter.PROP_NAME_URL, "tryStartDownloadLatestApk", "context", "Landroid/content/Context;", "toastNoNewVersion", "downloadButtonText", "dialogMessage", "startNetworkRetry", "stopNetworkRetry", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBootProtectorServiceImpl implements IObricBootProtectorSPIService {
    public static final /* synthetic */ int e = 0;
    public final CoroutineScope a;
    public final AtomicReference<String> b;
    public volatile long c;
    public volatile b d;

    public static final class a {
    }

    public static final class b extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ ObricBootProtectorServiceImpl a;

        public b(ObricBootProtectorServiceImpl r1) {
            this.a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r3) {
            Intrinsics.checkNotNullParameter(r3, CloudControlInf.NETWORK);
            FLogger.a.i("ObricBootProtectorService", "network onAvailable, retry fetch");
            ObricBootProtectorServiceImpl r4 = this.a;
            int r0 = ObricBootProtectorServiceImpl.e;
            r4.h("networkRetry");
        }
    }

    static {
    }

    public final boolean b() {
        return true;
    }

    public final void c() {
        h("prefetch");
    }

    public final String d() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        i r1 = com.larus.im.b.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(r1.getApplication().getString(2131911977));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        return (String) r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final String e() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        i r1 = com.larus.im.b.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(r1.getApplication().getString(2131911978));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        return (String) r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public ObricBootProtectorServiceImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.b = new AtomicReference(null);
    }

    public final synchronized void a() {
        monitor-enter(this);
        b r1 = this.d;     // Catch: Throwable -> L24
        if (r1 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        ConnectivityManager r2 = null;
        this.d = null;     // Catch: Throwable -> L24
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        i r4 = com.larus.im.b.a;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L17
        Object r5 = r4.getApplication().getSystemService("connectivity");     // Catch: Throwable -> L17
        if ((r5 instanceof ConnectivityManager) == false) goto L13;
        r2 = (ConnectivityManager) r5;     // Catch: Throwable -> L17
    L13:
        if (r2 == null) goto L15;
        r2.unregisterNetworkCallback(r1);     // Catch: Throwable -> L17
    L15:
        FLogger.a.i("ObricBootProtectorService", "stopNetworkRetry unregistered");     // Catch: Throwable -> L17
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L24
        if (r7 == null) goto L22;
        FLogger.a.e("ObricBootProtectorService", "stopNetworkRetry unregister failed: " + r7);     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized void g() {
        monitor-enter(this);
    L49:
        th = move-exception;
        throw th;
    L5:
        if (i(this.b.get()) == false) goto L10;
        FLogger.a.i("ObricBootProtectorService", "startNetworkRetry skip, already has valid url");     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L10:
        if (this.d == null) goto L55;
        FLogger.a.i("ObricBootProtectorService", "startNetworkRetry skip, already registered");     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L55:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        i r2 = com.larus.im.b.a;     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L16
        Object r3 = Result.constructor-impl(r2.getApplication());     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r3) == false) goto L21;
        r3 = null;
    L21:
        Application r4 = (Application) r3;     // Catch: Throwable -> L49
        if (r4 != null) goto L27;
        FLogger.a.i("ObricBootProtectorService", "startNetworkRetry skip, context null");     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L27:
        if (ContextCompat.checkSelfPermission(r4, "android.permission.ACCESS_NETWORK_STATE") == 0) goto L31;
        FLogger.a.i("ObricBootProtectorService", "startNetworkRetry skip, no ACCESS_NETWORK_STATE permission");     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L31:
        Object r5 = r4.getSystemService("connectivity");     // Catch: Throwable -> L49
        if ((r5 instanceof ConnectivityManager) == false) goto L34;
        ConnectivityManager r6 = (ConnectivityManager) r5;     // Catch: Throwable -> L49
    L35:
        if (r6 != null) goto L39;
        FLogger.a.i("ObricBootProtectorService", "startNetworkRetry skip, ConnectivityManager null");     // Catch: Throwable -> L49
        monitor-exit(this);
        return;
    L39:
        b r7 = new b(this);     // Catch: Throwable -> L49
        r6.registerNetworkCallback(new NetworkRequest.Builder().build(), r7);     // Catch: Throwable -> L42
        this.d = r7;     // Catch: Throwable -> L42
        FLogger.a.i("ObricBootProtectorService", "startNetworkRetry registered");     // Catch: Throwable -> L42
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L49
        if (r9 == null) goto L47;
        this.d = null;     // Catch: Throwable -> L49
        FLogger.a.e("ObricBootProtectorService", "startNetworkRetry register failed: " + r9);     // Catch: Throwable -> L49
    L47:
        monitor-exit(this);
        return;
    L42:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L49
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L49
        goto L44
    L34:
        r6 = null;
    L16:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L49
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L49
        goto L19
    }

    public static boolean i(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L13:
        return false;
    L11:
        if (URLUtil.isValidUrl(r3) == false) goto L13;
        return true;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static void j(BootProtectorLandingActivity r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        s.j(s.a, r7, r7.getString(2131911979), null, false, 28);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final boolean f(BootProtectorLandingActivity r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        String r0 = this.b.get();
        FLogger r1 = FLogger.a;
        r1.i("ObricBootProtectorService", "tryStartDownloadLatestApk hasValidUrl=" + i(r0));
        boolean r4 = false;
        if (i(r0) == true) goto L15;
        r1.i("ObricBootProtectorService", "tryStartDownloadLatestApk return false, invalid url");
        h("onDownloadClick");
        j(r7);
        return false;
    L15:
        Intent r2 = new Intent("android.intent.action.VIEW", UriProtector.parse(r0));     // Catch: Exception -> L11
        r2.addFlags(268435456);     // Catch: Exception -> L11
        if (r2.resolveActivity(r7.getPackageManager()) == null) goto L9;
        r7.startActivity(r2);     // Catch: Exception -> L11
        r1.i("ObricBootProtectorService", "tryStartDownloadLatestApk success");     // Catch: Exception -> L11
        r4 = true;
    L14:
    L13:
        return r4;
    L9:
        r1.e("ObricBootProtectorService", "tryStartDownloadLatestApk fail, no activity for url");     // Catch: Exception -> L11
        j(r7);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        FLogger.a.e("ObricBootProtectorService", "tryStartDownloadLatestApk error: " + e);
        j(r7);
        goto L13
    }

    public final synchronized void h(String r11) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (i(this.b.get()) == false) goto L9;
        FLogger.a.i("ObricBootProtectorService", "fetchAndCache skip(" + r11 + "), already has valid url");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L9:
        long r2 = this.c;     // Catch: Throwable -> L24
        if (r2 != 0) goto L12;
    L16:
        IObricUpdateService r1 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Throwable -> L24
        if (r1 != null) goto L21;
        FLogger.a.i("ObricBootProtectorService", "fetchAndCache skip(" + r11 + "), update service null");     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        this.c = SystemClock.elapsedRealtime();     // Catch: Throwable -> L24
        BuildersKt.launch$default(this.a, null, null, new ObricBootProtectorServiceImpl$fetchAndCache$1(this, r11, r1, null), 3, null);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L12:
        if ((SystemClock.elapsedRealtime() - r2) >= AutoEndConversationTime.AFTER_10_SECONDS) goto L16;
        FLogger.a.i("ObricBootProtectorService", "fetchAndCache skip(" + r11 + "), a fetch is in-flight");     // Catch: Throwable -> L24
        monitor-exit(this);
    }
}
