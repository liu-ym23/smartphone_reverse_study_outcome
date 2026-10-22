package com.ss.android.lark.integrator.im.impl;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IIMGlobalServiceImpl_Factory implements Factory<IIMGlobalServiceImpl> {
    private final Provider<vmb.c> mixedFeedUserBundleProxyProvider;
    private final Provider<sza.c> officeUrlPreviewServiceProvider;
    private final Provider<j> userServiceProvider;

    public IIMGlobalServiceImpl get() {
        IIMGlobalServiceImpl r0 = newInstance((j) this.userServiceProvider.get(), (vmb.c) this.mixedFeedUserBundleProxyProvider.get());
        r0.c = (sza.c) this.officeUrlPreviewServiceProvider.get();
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m897get() {
        return get();
    }

    public static IIMGlobalServiceImpl newInstance(j r1, vmb.c r2) {
        return new IIMGlobalServiceImpl(r1, r2);
    }

    public IIMGlobalServiceImpl_Factory(Provider<j> r1, Provider<vmb.c> r2, Provider<sza.c> r3) {
        this.userServiceProvider = r1;
        this.mixedFeedUserBundleProxyProvider = r2;
        this.officeUrlPreviewServiceProvider = r3;
    }

    public static IIMGlobalServiceImpl_Factory create(Provider<j> r1, Provider<vmb.c> r2, Provider<sza.c> r3) {
        return new IIMGlobalServiceImpl_Factory(r1, r2, r3);
    }
}
