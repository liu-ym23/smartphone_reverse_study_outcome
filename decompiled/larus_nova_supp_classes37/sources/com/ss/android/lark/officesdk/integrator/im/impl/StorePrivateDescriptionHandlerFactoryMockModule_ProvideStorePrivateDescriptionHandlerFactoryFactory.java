package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class StorePrivateDescriptionHandlerFactoryMockModule_ProvideStorePrivateDescriptionHandlerFactoryFactory implements Factory<a2b.k> {
    private final s module;

    public a2b.k get() {
        return provideStorePrivateDescriptionHandlerFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m89get() {
        return get();
    }

    public StorePrivateDescriptionHandlerFactoryMockModule_ProvideStorePrivateDescriptionHandlerFactoryFactory(s r1) {
        this.module = r1;
    }

    public static StorePrivateDescriptionHandlerFactoryMockModule_ProvideStorePrivateDescriptionHandlerFactoryFactory create(s r1) {
        return new StorePrivateDescriptionHandlerFactoryMockModule_ProvideStorePrivateDescriptionHandlerFactoryFactory(r1);
    }

    public static a2b.k provideStorePrivateDescriptionHandlerFactory(s r0) {
        r0.getClass();
        return (a2b.k) Preconditions.checkNotNullFromProvides(new r());
    }
}
