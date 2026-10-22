package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    private static final String TAG = null;

    @Nullable
    private static SystemForegroundService sForegroundService;
    SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void startForeground(Service r10, int r11, Notification r12, int r13) {
            r10.startForeground(r11, r12, r13);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static void startForeground(Service r10, int r11, Notification r12, int r13) {
            r10.startForeground(r11, r12, r13);     // Catch: ForegroundServiceStartNotAllowedException -> L4
            return;
        L4:
            e = move-exception;
            Logger.get().warning(SystemForegroundService.access$000(), "Unable to start foreground service", e);
        }
    }

    static {
        TAG = Logger.tagWithPrefix("SystemFgService");
        sForegroundService = null;
    }

    public SystemForegroundService() {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    @Nullable
    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    @MainThread
    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher r10 = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = r10;
        r10.setCallback(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void cancelNotification(final int r10) {
        this.mHandler.post(new AnonymousClass3(this, r10));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void notify(final int r10, @NonNull final Notification r11) {
        this.mHandler.post(new AnonymousClass2(this, r10, r11));
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@Nullable Intent r10, int r11, int r12) {
        super.onStartCommand(r10, r11, r12);
        if (this.mIsShutdown == false) goto L5;
        Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.");
        this.mDispatcher.onDestroy();
        initializeDispatcher();
        this.mIsShutdown = false;
    L5:
        if (r10 == null) goto L9;
        this.mDispatcher.onStartCommand(r10);
        return 3;
    L9:
        return 3;
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void startForeground(final int r10, final int r11, @NonNull final Notification r12) {
        this.mHandler.post(new AnonymousClass1(this, r10, r12, r11));
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    @MainThread
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.");
        if (Build.VERSION.SDK_INT < 26) goto L5;
        stopForeground(true);
    L5:
        sForegroundService = null;
        stopSelf();
    }
}
