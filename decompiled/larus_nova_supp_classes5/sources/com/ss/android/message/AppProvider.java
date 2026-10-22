package com.ss.android.message;

import android.app.Application;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.utils.f;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class AppProvider {
    private static volatile Application app;
    private static final AtomicBoolean sRegisteredActivityLifecycleCallback = null;

    public AppProvider() {
    }

    static {
        sRegisteredActivityLifecycleCallback = new AtomicBoolean(false);
    }

    public static int getTargetSdkVersion() {
        return app.getApplicationInfo().targetSdkVersion;
    }

    public static Application getApp() {
        return app;
    }

    public static void initApp(Application r2) {
        if (r2 != null) goto L6;
        f.f("AppProvider", "AppProvider.initApp: application is null！！", new Throwable());
        return;
    L6:
        if (sRegisteredActivityLifecycleCallback.getAndSet(true) == false) goto L8;
        return;
    L8:
        app = r2;
        app.registerActivityLifecycleCallbacks(ActivityLifecycleObserver.getIns());
    }
}
