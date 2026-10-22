package com.obric.sva.sdk.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationDispatchService;", "Landroid/app/Service;", "<init>", "()V", "binder", "com/obric/sva/sdk/notification/SvaNotificationDispatchService$binder$1", "Lcom/obric/sva/sdk/notification/SvaNotificationDispatchService$binder$1;", "onCreate", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "Dispatcher", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SvaNotificationDispatchService extends Service {
    public static final Companion Companion = null;
    private static final String TAG = "SvaNotificationDispatch";
    private final binder.1 binder;

    static {
        Companion = new Companion(null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogUtils.i(TAG, "onDestroy", new Object[0]);
        Dispatcher.INSTANCE.kill();
        super.onDestroy();
    }

    public SvaNotificationDispatchService() {
        this.binder = new binder.1();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtils.i(TAG, "onCreate", new Object[0]);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r3) {
        LogUtils.i(TAG, "onBind: " + r3, new Object[0]);
        return this.binder;
    }
}
