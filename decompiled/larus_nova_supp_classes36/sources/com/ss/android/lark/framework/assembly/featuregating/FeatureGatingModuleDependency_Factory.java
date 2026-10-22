package com.ss.android.lark.framework.assembly.featuregating;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FeatureGatingModuleDependency_Factory implements Factory<FeatureGatingModuleDependency> {
    private final Provider<epb.a> deviceIdApiProvider;
    private final Provider<j> passportProvider;
    private final Provider<yzb.b> userListApiProvider;

    public FeatureGatingModuleDependency get() {
        return newInstance((j) this.passportProvider.get(), (epb.a) this.deviceIdApiProvider.get(), (yzb.b) this.userListApiProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m659get() {
        return get();
    }

    public FeatureGatingModuleDependency_Factory(Provider<j> r1, Provider<epb.a> r2, Provider<yzb.b> r3) {
        this.passportProvider = r1;
        this.deviceIdApiProvider = r2;
        this.userListApiProvider = r3;
    }

    public static FeatureGatingModuleDependency_Factory create(Provider<j> r1, Provider<epb.a> r2, Provider<yzb.b> r3) {
        return new FeatureGatingModuleDependency_Factory(r1, r2, r3);
    }

    public static FeatureGatingModuleDependency newInstance(j r1, epb.a r2, yzb.b r3) {
        return new FeatureGatingModuleDependency(r1, r2, r3);
    }
}
