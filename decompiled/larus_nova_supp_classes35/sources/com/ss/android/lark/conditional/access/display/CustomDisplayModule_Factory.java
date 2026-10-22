package com.ss.android.lark.conditional.access.display;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CustomDisplayModule_Factory implements Factory<CustomDisplayModule> {
    private final Provider<apb.a> languageServiceProvider;
    private final Provider<h> networkRepositoryProvider;
    private final Provider<m> passportProvider;
    private final Provider<i> storageProvider;

    public CustomDisplayModule get() {
        return newInstance((m) this.passportProvider.get(), (h) this.networkRepositoryProvider.get(), (i) this.storageProvider.get(), (apb.a) this.languageServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m966get() {
        return get();
    }

    public CustomDisplayModule_Factory(Provider<m> r1, Provider<h> r2, Provider<i> r3, Provider<apb.a> r4) {
        this.passportProvider = r1;
        this.networkRepositoryProvider = r2;
        this.storageProvider = r3;
        this.languageServiceProvider = r4;
    }

    public static CustomDisplayModule_Factory create(Provider<m> r1, Provider<h> r2, Provider<i> r3, Provider<apb.a> r4) {
        return new CustomDisplayModule_Factory(r1, r2, r3, r4);
    }

    public static CustomDisplayModule newInstance(m r1, h r2, i r3, apb.a r4) {
        return new CustomDisplayModule(r1, r2, r3, r4);
    }
}
