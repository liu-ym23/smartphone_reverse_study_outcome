package com.bytedance.android.livesdk.floatview;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.mw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0013\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/VideoFloatWindowService;", "Landroid/app/Service;", "", "hideNotification", "Landroid/content/Context;", "context", "Landroid/app/Notification;", "buildNotification", "", "resId", "", "getResString", "onCreate", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "flags", "startId", "onStartCommand", "onDestroy", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/app/NotificationManager;", "mNotificationManager", "Landroid/app/NotificationManager;", "<init>", "()V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoFloatWindowService extends Service {
    public static final a Companion = null;
    private static final String FOREGROUND_CHANNEL_ID = "VideoFloatWindowService.notification";
    public static final String TAG = "VideoFloatWindowService";
    private static boolean isStarted = false;
    private static boolean isStoped = false;
    private static final int notificationID = 1000;
    private NotificationManager mNotificationManager;

    public static final class a {
        public final void stopService() {
            if (mw.a.getValue().booleanValue() == true) goto L5;
            VideoFloatWindowService.access$setStoped$cp(true);
            if (VideoFloatWindowService.access$isStarted$cp() == true) goto L11;
            return;
        L11:
            jc1.a.b().stopService(new Intent(jc1.a.b(), VideoFloatWindowService.class));
            return;
        L5:
            if (VideoFloatWindowService.access$isStarted$cp() == true) goto L7;
            return;
        L7:
            VideoFloatWindowService.access$setStoped$cp(true);
            goto L11
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return null;
    }

    private final void hideNotification() {
        startForeground(1000, new NotificationCompat.Builder(this, FOREGROUND_CHANNEL_ID).build());     // Catch: Throwable -> L4
        stopForeground(true);     // Catch: Throwable -> L4
        NotificationManagerCompat.from(this).cancel(1000);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ALogger.e(TAG, th.toString());
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Object r0 = getSystemService("notification");
        if (r0 == null) goto L7;
        this.mNotificationManager = (NotificationManager) r0;
        startForeground(1000, buildNotification(this));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        isStarted = false;
        isStoped = false;
        hideNotification();
    }

    public VideoFloatWindowService() {
    }

    public static final /* synthetic */ boolean access$isStarted$cp() {
        return isStarted;
    }

    public static final /* synthetic */ boolean access$isStoped$cp() {
        return isStoped;
    }

    public static final /* synthetic */ void access$setStarted$cp(boolean r0) {
        isStarted = r0;
    }

    public static final /* synthetic */ void access$setStoped$cp(boolean r0) {
        isStoped = r0;
    }

    private final Notification buildNotification(Context r9) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L12;
        NotificationManager r5 = this.mNotificationManager;
        if (r5 == null) goto L7;
        NotificationChannel r6 = r5.getNotificationChannel(FOREGROUND_CHANNEL_ID);
    L8:
        if (r6 != null) goto L12;
        NotificationChannel r7 = new NotificationChannel(FOREGROUND_CHANNEL_ID, getResString(2131916673), 3);
        r7.enableVibration(false);
        r7.setSound(null, null);
        NotificationManager r8 = this.mNotificationManager;
        if (r8 == null) goto L12;
        r8.createNotificationChannel(r7);
        goto L12
    L7:
        r6 = null;
    L12:
        int r10 = l.a;
        Intent r11 = l.a(r9, r9.getPackageName());
        if (r11 != null) goto L16;
        return null;
    L16:
        if (r0 < 23) goto L18;
        int r12 = 201326592;
    L19:
        PendingIntent r1 = PendingIntent.getActivity(r9, 0, r11, r12);
        if (r0 < 26) goto L22;
        NotificationCompat.Builder r2 = new NotificationCompat.Builder(r9, FOREGROUND_CHANNEL_ID);
    L23:
        NotificationCompat.BigTextStyle r13 = new NotificationCompat.BigTextStyle();
        r13.setBigContentTitle(getResString(2131916675));
        r13.bigText(getResString(2131916674));
        NotificationCompat.Builder r3 = r2.setContentTitle(getResString(2131916675)).setContentText(getResString(2131916674));
        if (jc1.k.f(IHostContext.class) == null) goto L26;
        int r4 = jc1.k.n(IHostContext.class).appIcon();
    L27:
        r3.setSmallIcon(r4).setOngoing(true).setWhen(System.currentTimeMillis()).setContentIntent(r1).setCategory("service").setOnlyAlertOnce(true).setAutoCancel(true).setStyle(r13).setSound(null);
        r2.setVisibility(1);
        return r2.build();
    L26:
        r4 = 2131250615;
        goto L27
    L22:
        r2 = new NotificationCompat.Builder(r9);
        goto L23
    L18:
        r12 = 134217728;
        goto L19
    }

    private final String getResString(int r2) {
        return getString(r2);
    L5:
        return jc1.a.b().getString(r2);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r9, int r10) {
        startForeground(1000, buildNotification(this));
        if (jc1.a.b() == null) goto L5;
        UtilityKotlinExtentionsKt.s(0, false, false, AnonymousClass1.INSTANCE, 7);
    L5:
        super.onStartCommand(r8, r9, r10);
        isStarted = true;
        if (isStoped == false) goto L10;
        Companion.stopService();
        isStoped = false;
        return 2;
    L10:
        return 2;
    }
}
