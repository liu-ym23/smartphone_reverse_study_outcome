package com.ss.android.lark.officesdk.launcher;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSdkLauncherFactory_Factory implements Factory<i> {
    private final Provider<com.ss.android.lark.app.initiator.a> appLauncherProvider;

    public static i newInstance() {
        return new i();
    }

    public i get() {
        i r0 = newInstance();
        r0.a = DoubleCheck.lazy(this.appLauncherProvider);
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m140get() {
        return get();
    }

    public OfficeSdkLauncherFactory_Factory(Provider<com.ss.android.lark.app.initiator.a> r1) {
        this.appLauncherProvider = r1;
    }

    public static OfficeSdkLauncherFactory_Factory create(Provider<com.ss.android.lark.app.initiator.a> r1) {
        return new OfficeSdkLauncherFactory_Factory(r1);
    }
}
