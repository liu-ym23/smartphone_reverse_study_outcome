package com.ss.android.lark.integrator.im.impl.component;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import eza.a;
import tmb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeComponentAdaptModule_ProvideOfficeComponentAdaptServiceFactory implements Factory<a> {
    private final b module;

    public a get() {
        return provideOfficeComponentAdaptService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m906get() {
        return get();
    }

    public OfficeComponentAdaptModule_ProvideOfficeComponentAdaptServiceFactory(b r1) {
        this.module = r1;
    }

    public static OfficeComponentAdaptModule_ProvideOfficeComponentAdaptServiceFactory create(b r1) {
        return new OfficeComponentAdaptModule_ProvideOfficeComponentAdaptServiceFactory(r1);
    }

    public static a provideOfficeComponentAdaptService(b r1) {
        r1.getClass();
        Object r0 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r0 != null) goto L6;
        r0 = new tmb.a(r1);
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r0);
    }
}
