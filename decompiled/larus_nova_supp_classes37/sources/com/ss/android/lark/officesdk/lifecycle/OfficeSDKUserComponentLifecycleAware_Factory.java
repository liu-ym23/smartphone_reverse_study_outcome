package com.ss.android.lark.officesdk.lifecycle;

import android.app.Application;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import cub.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKUserComponentLifecycleAware_Factory implements Factory<a> {
    private final Provider<Application> applicationProvider;
    private final Provider<OfficeSDKUserComponentManager> officeSDKUserComponentManagerProvider;
    private final Provider<String> userIdProvider;

    public a get() {
        return newInstance((Application) this.applicationProvider.get(), (OfficeSDKUserComponentManager) this.officeSDKUserComponentManagerProvider.get(), (String) this.userIdProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m151get() {
        return get();
    }

    public OfficeSDKUserComponentLifecycleAware_Factory(Provider<Application> r1, Provider<OfficeSDKUserComponentManager> r2, Provider<String> r3) {
        this.applicationProvider = r1;
        this.officeSDKUserComponentManagerProvider = r2;
        this.userIdProvider = r3;
    }

    public static OfficeSDKUserComponentLifecycleAware_Factory create(Provider<Application> r1, Provider<OfficeSDKUserComponentManager> r2, Provider<String> r3) {
        return new OfficeSDKUserComponentLifecycleAware_Factory(r1, r2, r3);
    }

    public static a newInstance(Application r1, OfficeSDKUserComponentManager r2, String r3) {
        return new a(r1, r2, r3);
    }
}
