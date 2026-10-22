package com.larksuite.component.air;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.larksuite.framework.utils.autoscale.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class AirApplication extends Application {
    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        int r0 = a.a;
        Resources r1 = super.getResources();
        if (my7.a.a == null) goto L5;
    L14:
        my7.a.a.getClass();
        return r1;
    L5:
        monitor-enter(my7.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (my7.a.a != null) goto L9;
        my7.a.a = new my7.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(my7.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final Resources a() {
        return super.getResources();
    }

    public AirApplication() {
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        int r2 = a.a;
    }
}
