package com.ss.android.lark.language.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class GlobalLanguageServiceImpl_Factory implements Factory<GlobalLanguageServiceImpl> {
    private final Provider<com.ss.android.lark.core.storage.b> globalCoreStorageProvider;

    public GlobalLanguageServiceImpl get() {
        return newInstance((com.ss.android.lark.core.storage.b) this.globalCoreStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1383get() {
        return get();
    }

    public GlobalLanguageServiceImpl_Factory(Provider<com.ss.android.lark.core.storage.b> r1) {
        this.globalCoreStorageProvider = r1;
    }

    public static GlobalLanguageServiceImpl_Factory create(Provider<com.ss.android.lark.core.storage.b> r1) {
        return new GlobalLanguageServiceImpl_Factory(r1);
    }

    public static GlobalLanguageServiceImpl newInstance(com.ss.android.lark.core.storage.b r1) {
        return new GlobalLanguageServiceImpl(r1);
    }
}
