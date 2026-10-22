package com.larus.common.baidunavi.impl.notification;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/common/baidunavi/impl/notification/BaiduNaviForegroundService;", "Landroid/app/Service;", "<init>", "()V", "updateNotification", "", "notification", "Landroid/app/Notification;", "onCreate", "onDestroy", "onBind", "Landroid/os/IBinder;", "p0", "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaiduNaviForegroundService extends Service {
    public static boolean a;
    public static BaiduNaviForegroundService b;
    public static Function1<? super Boolean, Unit> c;

    public static final class a {
        public final synchronized void stopService() {
            monitor-enter(this);
            BaiduNaviForegroundService.a = false;     // Catch: Throwable -> L25
            BaiduNaviForegroundService r1 = BaiduNaviForegroundService.b;     // Catch: Throwable -> L25
            if (r1 != null) goto L10;
            monitor-exit(this);
            return;
        L10:
            if (Build.VERSION.SDK_INT < 24) goto L12;
            r1.stopForeground(1);     // Catch: Throwable -> L25
        L13:
            r1.stopSelf();     // Catch: Throwable -> L25
            FLogger.a.i("BaiduNaviForegroundService", "stopService " + r1);     // Catch: Throwable -> L25
            Object r0 = AppHost.a.getApplication().getSystemService("notification");     // Catch: Throwable -> L21
            if ((r0 instanceof NotificationManager) == false) goto L17;
            NotificationManager r2 = (NotificationManager) r0;     // Catch: Throwable -> L21
        L18:
            if (r2 == null) goto L23;
            r2.cancel(106);     // Catch: Throwable -> L21
        L23:
            monitor-exit(this);
            return;
        L17:
            r2 = null;
        L21:
            th = move-exception;
            FLogger.a.e("BaiduNaviForegroundService", "cancel notification additionally fails", th);     // Catch: Throwable -> L25
            goto L23
        L12:
            r1.stopForeground(true);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        public final synchronized void startService(Function1<? super Boolean, Unit> r5) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r5, "callback");     // Catch: Throwable -> L22
            if (BaiduNaviForegroundService.a == true) goto L6;
            BaiduNaviForegroundService.c = r5;     // Catch: Throwable -> L22
        L18:
            e = move-exception;
            r5.invoke(Boolean.FALSE);     // Catch: Throwable -> L22
            FLogger.a.e("BaiduNaviForegroundService", "startService fails", e);     // Catch: Throwable -> L22
        L20:
            monitor-exit(this);
            return;
        L13:
            if (Build.VERSION.SDK_INT < 26) goto L15;
            AppHost.Companion r0 = AppHost.a;     // Catch: Exception -> L18 Throwable -> L22
            r0.getApplication().startForegroundService(new Intent(r0.getApplication(), BaiduNaviForegroundService.class));     // Catch: Exception -> L18 Throwable -> L22
        L16:
            BaiduNaviForegroundService.a = true;     // Catch: Exception -> L18 Throwable -> L22
            FLogger.a.i("BaiduNaviForegroundService", "startService succeeds");     // Catch: Exception -> L18 Throwable -> L22
        L15:
            AppHost.Companion r1 = AppHost.a;     // Catch: Exception -> L18 Throwable -> L22
            r1.getApplication().startService(new Intent(r1.getApplication(), BaiduNaviForegroundService.class));     // Catch: Exception -> L18 Throwable -> L22
            goto L16
        L6:
            if (BaiduNaviForegroundService.b == null) goto L8;
            r5.invoke(Boolean.TRUE);     // Catch: Throwable -> L22
        L9:
            monitor-exit(this);
            return;
        L8:
            BaiduNaviForegroundService.c = r5;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        FLogger.a.i("BaiduNaviForegroundService", "service onCreate " + this);
        BaiduNaviForegroundService r0 = b;
        if (r0 == null) goto L5;
        r0.stopSelf();
    L5:
        b = this;
        d r1 = d.a;
        d.a();
        d.c(getString(2131908076), null, null, null, 12);
        if (c.a() == false) goto L8;
        int r2 = 2131238529;
    L9:
        Drawable r3 = ContextCompat.getDrawable(AppHost.a.getApplication(), r2);
        if (r3 != null) goto L19;
    L11:
        Bitmap r4 = null;
    L15:
        d r5 = d.a;
        d.c(getString(2131908076), null, null, r4, 4);
        Function1<? super Boolean, Unit> r6 = c;
        if (r6 == null) goto L21;
        r6.invoke(Boolean.TRUE);
        c = null;
        return;
    L21:
        return;
    L19:
        r4 = Bitmap.createBitmap(r3.getIntrinsicWidth(), r3.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L14
        Canvas r7 = new Canvas(r4);     // Catch: Exception -> L14
        r3.setBounds(0, 0, r7.getWidth(), r7.getHeight());     // Catch: Exception -> L14
        r3.draw(r7);     // Catch: Exception -> L14
    L8:
        r2 = 2131238530;
        goto L9
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        FLogger.a.i("BaiduNaviForegroundService", "service Destroyed " + this);
        if (Intrinsics.areEqual(b, this) == false) goto L6;
        b = null;
        a = false;
        return;
    }

    public BaiduNaviForegroundService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return new Binder();
    }
}
