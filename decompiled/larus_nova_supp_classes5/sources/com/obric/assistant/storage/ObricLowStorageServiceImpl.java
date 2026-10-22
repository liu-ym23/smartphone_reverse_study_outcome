package com.obric.assistant.storage;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f09.a;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kha.e;
import kha.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u000b\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J.\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006 "}, d2 = {"Lcom/obric/assistant/storage/ObricLowStorageServiceImpl;", "Lcom/obric/assistant/storage/IObricLowStorageService;", "<init>", "()V", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mainHandler", "Landroid/os/Handler;", "pendingForegroundCheck", "Ljava/lang/Runnable;", "appBackGroundListener", "com/obric/assistant/storage/ObricLowStorageServiceImpl$appBackGroundListener$1", "Lcom/obric/assistant/storage/ObricLowStorageServiceImpl$appBackGroundListener$1;", "init", "", "checkAndBlockIfLowStorage", "", "activity", "Landroid/app/Activity;", "checkAndBlockIfLowStorageGlobal", "currentForegroundActivity", "cancelPendingForegroundCheck", "reason", "", "scheduleForegroundCheck", "delayMs", "", "mainActivityRetried", DBDefinition.RETRY_COUNT, "", "isTransientActivity", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLowStorageServiceImpl implements IObricLowStorageService {
    public static final Set<String> e = null;
    public final AtomicBoolean a;
    public final Handler b;
    public f c;
    public final b d;

    public static final class b implements a.b {
        public final /* synthetic */ ObricLowStorageServiceImpl a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            ObricLowStorageServiceImpl r0 = this.a;
            Set<String> r1 = ObricLowStorageServiceImpl.e;
            r0.b("app background");
            e.a.getClass();
            if (e.f.get() != LongCompanionObject.MAX_VALUE) goto L7;
            e.b("app_background", null);
            return;
        }

        public final void onAppForeground() {
            e.a.getClass();
            if (e.f.get() != LongCompanionObject.MAX_VALUE) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            FLogger.a.i("LowStorageService", "onAppForeground: dialog already showing, skip foreground check");
            return;
        L9:
            ObricLowStorageServiceImpl.e(this.a, "app foreground", 0, 0, 14);
            return;
        L5:
            r0 = false;
            goto L6
        }

        public b(ObricLowStorageServiceImpl r1) {
            this.a = r1;
        }
    }

    static {
        e = SetsKt.setOf(new String[]{"ObricLoginRedirectActivity", "ObricPrivacyAgreeRedirectActivity", "ObricOneLoginTransparentActivity", "ObricOneLoginActivity", "ChatRouteLoadingActivity", "CommonSwitchBinderActivity", "SuperChatActivity", "AccountLoginHalfActivity", "WXEntryActivity", "DouYinEntryActivity", "MiniApplicationDouYinEntryActivity", "LarkEntryActivity", "RedirectUriReceiverActivity"});
    }

    public final boolean a() {
        e r0 = e.a;
        if (e.c() == true) goto L5;
        return false;
    L5:
        r0.getClass();
        if (e.g() == true) goto L20;
        FLogger.a.i("LowStorageGuard", "interceptIfLowStorage: dialog already reserved/showing, trigger=global");
        return true;
    L20:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        FLogger.a.i("LowStorageGuard", "checkAndBlockIfLowStorageGlobal: low storage detected");     // Catch: Throwable -> L10
        Application r2 = AppHost.a.getApplication();     // Catch: Throwable -> L10
        Intent r3 = new Intent(r2, LowStorageBlockActivity.class);     // Catch: Throwable -> L10
        r3.addFlags(268435456);     // Catch: Throwable -> L10
        r3.addFlags(67108864);     // Catch: Throwable -> L10
        r3.putExtra("obric_allow_show_when_locked", true);     // Catch: Throwable -> L10
        r2.startActivity(r3);     // Catch: Throwable -> L10
        Object r4 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L15;
        FLogger.a.w("LowStorageGuard", "interceptIfLowStorage failed, trigger=global, error=" + r5.getMessage(), r5);
        e.a.getClass();
        e.d();
    L15:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L19;
        r4 = r6;
    L19:
        return ((Boolean) r4).booleanValue();
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void init() {
        AppHost.Companion r0 = AppHost.a;
        if (q0.c(r0.getApplication()) == true) goto L7;
        FLogger.a.i("LowStorageService", "init: skip, not main process");
        return;
    L7:
        if (this.a.compareAndSet(false, true) == true) goto L10;
        FLogger.a.i("LowStorageService", "init: already initialized");
        return;
    L10:
        r0.a().j(this.d);
        FLogger.a.i("LowStorageService", "init: app foreground listener registered");
        if (r0.a().isAppBackground() == true) goto L14;
        e(this, "init in foreground", 0, 0, 14);
        return;
    }

    public ObricLowStorageServiceImpl() {
        this.a = new AtomicBoolean(false);
        this.b = new Handler(Looper.getMainLooper());
        this.d = new b(this);
    }

    public static boolean c(Activity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        e r1 = e.a;
        Intrinsics.checkNotNullParameter(r7, "activity");
        e r0 = e.a;
        String r2 = "activity:" + r7;
        boolean r4 = false;
        if (e.c() == false) goto L31;
        r0.getClass();
        if (e.g() == true) goto L28;
        FLogger.a.i("LowStorageGuard", "interceptIfLowStorage: dialog already reserved/showing, trigger=" + r2);
        return true;
    L28:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        if ((r7 instanceof LowStorageBlockActivity) == true) goto L12;
        r4 = KeyguardService.a.isKeyguardLocked();     // Catch: Throwable -> L18
    L12:
        FLogger.a.i("LowStorageGuard", "checkAndBlockIfLowStorage: low storage detected, activity=" + r7 + ", shouldUseLockscreenHost=" + r4);     // Catch: Throwable -> L18
        if (r4 == false) goto L15;
        Intent r5 = new Intent(r7, LowStorageBlockActivity.class);     // Catch: Throwable -> L18
        r5.addFlags(268435456);     // Catch: Throwable -> L18
        r5.addFlags(67108864);     // Catch: Throwable -> L18
        r5.putExtra("obric_allow_show_when_locked", true);     // Catch: Throwable -> L18
        r7.startActivity(r5);     // Catch: Throwable -> L18
    L16:
        Object r8 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L18
    L20:
        Throwable r6 = Result.exceptionOrNull-impl(r8);
        if (r6 == null) goto L23;
        FLogger.a.w("LowStorageGuard", "interceptIfLowStorage failed, trigger=" + r2 + ", error=" + r6.getMessage(), r6);
        e.a.getClass();
        e.d();
    L23:
        Boolean r9 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L27;
        r8 = r9;
    L27:
        return ((Boolean) r8).booleanValue();
    L15:
        e.e(r7);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L31:
        return false;
    }

    public final void b(String r4) {
        Runnable r0 = this.c;
        if (r0 == null) goto L5;
        this.b.removeCallbacks(r0);
        FLogger.a.i("LowStorageService", "cancelPendingForegroundCheck: " + r4);
    L5:
        this.c = null;
    }

    public final void d(String r3, long r4, boolean r6, int r7) {
        b(r3);
        Runnable r0 = new f(this, r7, r3, r6);
        this.c = r0;
        this.b.postDelayed(r0, r4);
        FLogger.a.i("LowStorageService", "scheduleForegroundCheck: reason=" + r3 + ", delayMs=" + r4 + ", retryCount=" + r7);
    }

    public static /* synthetic */ void e(ObricLowStorageServiceImpl r6, String r7, long r8, int r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        r8 = 2000;
    L5:
        long r2 = r8;
        if ((r11 & 8) == 0) goto L8;
        int r5 = 0;
    L9:
        r6.d(r7, r2, false, r5);
        return;
    L8:
        r5 = r10;
        goto L9
    }
}
