package com.larus.asr.handsfree;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/asr/handsfree/HandsfreeForegroundService;", "Landroid/app/Service;", "<init>", "()V", "foregroundStarted", "", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "onDestroy", "startForegroundSafely", "from", "", "createNotificationChannel", "buildNotification", "Landroid/app/Notification;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class HandsfreeForegroundService extends Service {
    public static final /* synthetic */ int b = 0;
    public volatile boolean a;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        if (this.a == true) goto L5;
    L8:
        FLogger.a.i("HandsfreeForegroundService", "[HF] foreground service destroyed");
        com.larus.asr.handsfree.a.a.getClass();
        com.larus.asr.handsfree.a.b = false;
        super.onDestroy();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L7;
        stopForeground(1);
        goto L8
    L7:
        stopForeground(true);
        goto L8
    }

    public final Notification a() {
        Intent r0 = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (r0 == null) goto L5;
        r0.setFlags(335544320);
    L6:
        if (r0 != null) goto L9;
        r0 = new Intent();
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        int r2 = 201326592;
    L12:
        PendingIntent r1 = PendingIntent.getActivity(this, 0, r0, r2);
        NotificationCompat.Builder r3 = new NotificationCompat.Builder(this, "handsfree_voice_input_channel").setSmallIcon(2131241663);
        AppHost.Companion r4 = AppHost.a;
        String r5 = r4.getAppStringName();
        if (StringsKt.isBlank(r5) == false) goto L16;
        r5 = r4.getAppName();
    L16:
        return r3.setContentTitle(r5).setContentText("正在使用语音输入").setContentIntent(r1).setShowWhen(false).setSound(null).setVibrate(null).setOngoing(true).setAutoCancel(false).setPriority(-1).setVisibility(1).build();
    L11:
        r2 = 134217728;
        goto L12
    L5:
        r0 = null;
        goto L6
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        b("onCreate");
    }

    public HandsfreeForegroundService() {
    }

    public final void b(String r10) {
        if (this.a == false) goto L21;
        return;
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        int r3 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r3 < 26) goto L9;
        NotificationManager r4 = (NotificationManager) getSystemService(NotificationManager.class);     // Catch: Throwable -> L15
        NotificationChannel r5 = new NotificationChannel("handsfree_voice_input_channel", "HandsFree", 2);     // Catch: Throwable -> L15
        r5.setLockscreenVisibility(1);     // Catch: Throwable -> L15
        r5.enableVibration(false);     // Catch: Throwable -> L15
        r5.setSound(null, null);     // Catch: Throwable -> L15
        r4.createNotificationChannel(r5);     // Catch: Throwable -> L15
    L9:
        Notification r6 = a();     // Catch: Throwable -> L15
        if (r3 < 34) goto L12;
        startForeground(110, r6, 128);     // Catch: Throwable -> L15
    L13:
        this.a = true;     // Catch: Throwable -> L15
        FLogger.a.i("HandsfreeForegroundService", "[HF] foreground service started from=".concat(r10));     // Catch: Throwable -> L15
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L23;
        FLogger.a.e("HandsfreeForegroundService", "[HF] foreground service startForeground failed from=" + r10 + ", " + r1.getMessage());
        stopSelf();
        return;
    L23:
        return;
    L12:
        startForeground(110, r6);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r1, int r2, int r3) {
        b("onStartCommand");
        return 2;
    }
}
