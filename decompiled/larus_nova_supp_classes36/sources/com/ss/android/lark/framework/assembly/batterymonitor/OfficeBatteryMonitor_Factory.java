package com.ss.android.lark.framework.assembly.batterymonitor;

import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import dagger.internal.Factory;
import djb.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeBatteryMonitor_Factory implements Factory<a> {
    private final Provider<IAppStateSyncService> appStateSyncServiceProvider;

    public a get() {
        return newInstance((IAppStateSyncService) this.appStateSyncServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m653get() {
        return get();
    }

    public OfficeBatteryMonitor_Factory(Provider<IAppStateSyncService> r1) {
        this.appStateSyncServiceProvider = r1;
    }

    public static OfficeBatteryMonitor_Factory create(Provider<IAppStateSyncService> r1) {
        return new OfficeBatteryMonitor_Factory(r1);
    }

    public static a newInstance(IAppStateSyncService r1) {
        return new a(r1);
    }
}
