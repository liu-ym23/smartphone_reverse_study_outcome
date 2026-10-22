package com.obric.aikernel.multiproc;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.service.foreground.DelayedForegroundServiceRunState;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class LLMForegroundService extends Service {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f4695g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile Context f4696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile LLMForegroundService f4697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final DelayedForegroundServiceRunState f4698j = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4699c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        private final boolean c(Context r10) {
            boolean r11 = com.obric.aikernel.api.b.f4431a.a().q();
            String r12 = Process.myProcessName();
            Intrinsics.checkNotNullExpressionValue(r12, "myProcessName()");
            return c.a(r11, r12, r10.getPackageName() + ":llm");
        }

        public final void a(Context r10) {
            if (r10 == null) goto L4;
            Context r11 = r10.getApplicationContext();
        L5:
            if (r11 != null) goto L7;
            return;
        L7:
            LLMForegroundService.d(r11);
            LLMForegroundService.c().d();
            return;
        L4:
            r11 = null;
            goto L5
        }

        public final void b(Context r10) {
            if (r10 == null) goto L4;
            Context r11 = r10.getApplicationContext();
        L5:
            if (r11 != null) goto L8;
            return;
        L8:
            if (c(r11) == true) goto L10;
            return;
        L10:
            LLMForegroundService.d(r11);
            LLMForegroundService.c().b();
            return;
        L4:
            r11 = null;
            goto L5
        }
    }

    static {
        f4695g = new a(null);
        f4698j = new DelayedForegroundServiceRunState(300000, null, LLMForegroundService$Companion$runState$1.INSTANCE, LLMForegroundService$Companion$runState$2.INSTANCE, LLMForegroundService$Companion$runState$3.INSTANCE, 2, null);
    }

    public LLMForegroundService() {
    }

    public static final /* synthetic */ Context a() {
        return f4696h;
    }

    public static final /* synthetic */ LLMForegroundService b() {
        return f4697i;
    }

    public static final /* synthetic */ DelayedForegroundServiceRunState c() {
        return f4698j;
    }

    public static final /* synthetic */ void d(Context r10) {
        f4696h = r10;
    }

    public static final /* synthetic */ void e(LLMForegroundService r10) {
        r10.h();
    }

    private final Notification f() {
        Notification r10 = new NotificationCompat.Builder(this, "aikernel_llm_fgs").setSmallIcon(R.drawable.stat_notify_sync).setContentTitle("AIKernel").setContentText("LLM service is running").setPriority(-1).setCategory("service").setOngoing(true).setOnlyAlertOnce(true).setSilent(true).build();
        Intrinsics.checkNotNullExpressionValue(r10, "Builder(this, CHANNEL_ID…rue)\n            .build()");
        return r10;
    }

    private final void g() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        Object r10 = getSystemService("notification");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel r11 = new NotificationChannel("aikernel_llm_fgs", "AIKernel LLM", 2);
        r11.setDescription("Foreground service for llm process priority");
        r11.setSound(null, null);
        r11.enableVibration(false);
        r11.setShowBadge(false);
        r11.setLockscreenVisibility(-1);
        ((NotificationManager) r10).createNotificationChannel(r11);
    }

    private final void h() {
        if (f4698j.f() == false) goto L5;
        return;
    L5:
        AIKLog.INSTANCE.i("LLMForegroundService", "llm execution idle delay elapsed, stop self");
        stopSelf();
    }

    private final void i() {
        if (this.f4699c == false) goto L13;
        return;
    L13:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        com.obric.aikernel.service.foreground.d.a(this, 2577, f());     // Catch: Throwable -> L7
        this.f4699c = true;     // Catch: Throwable -> L7
        AIKLog.INSTANCE.i("LLMForegroundService", "startForeground success");     // Catch: Throwable -> L7
        Object r11 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r12 = Result.m35exceptionOrNullimpl(r11);
        if (r12 == null) goto L15;
        AIKLog.INSTANCE.e("LLMForegroundService", "startForeground failed: " + r12);
        stopSelf();
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f4697i = this;
        g();
        i();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (f4697i != this) goto L6;
        f4697i = null;
    L6:
        if (this.f4699c == false) goto L8;
        stopForeground(1);
        this.f4699c = false;
    L8:
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (this.f4699c == true) goto L6;
        i();
    L6:
        if (f4698j.f() == true) goto L10;
        AIKLog.INSTANCE.i("LLMForegroundService", "no active llm execution demand after sync, stop self");
        stopSelfResult(r12);
        return 2;
    L10:
        return 2;
    }
}
