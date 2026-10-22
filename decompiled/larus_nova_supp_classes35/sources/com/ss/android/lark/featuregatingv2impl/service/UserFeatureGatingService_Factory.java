package com.ss.android.lark.featuregatingv2impl.service;

import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.d;
import ldb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserFeatureGatingService_Factory implements Factory<g> {
    private final Provider<d> globalFeatureGatingDispatcherProvider;
    private final Provider<String> mUidProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public g m1164get() {
        g r0 = newInstance((d) this.globalFeatureGatingDispatcherProvider.get());
        r0.a = (String) this.mUidProvider.get();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1164get();
    }

    public static g newInstance(d r1) {
        return new g(r1);
    }

    public UserFeatureGatingService_Factory(Provider<d> r1, Provider<String> r2) {
        this.globalFeatureGatingDispatcherProvider = r1;
        this.mUidProvider = r2;
    }

    public static UserFeatureGatingService_Factory create(Provider<d> r1, Provider<String> r2) {
        return new UserFeatureGatingService_Factory(r1, r2);
    }
}
