package com.ss.android.lark.integrator.im.impl.search;

import bnb.b;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import tza.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSDKSearchModule_ProvideOfficeSDKSearchRouterFactory implements Factory<a> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m922get() {
        return provideOfficeSDKSearchRouter(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m922get();
    }

    public OfficeSDKSearchModule_ProvideOfficeSDKSearchRouterFactory(b r1) {
        this.module = r1;
    }

    public static OfficeSDKSearchModule_ProvideOfficeSDKSearchRouterFactory create(b r1) {
        return new OfficeSDKSearchModule_ProvideOfficeSDKSearchRouterFactory(r1);
    }

    public static a provideOfficeSDKSearchRouter(b r0) {
        r0.getClass();
        Object r1 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r1 != null) goto L6;
        r1 = new bnb.a();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r1);
    }
}
