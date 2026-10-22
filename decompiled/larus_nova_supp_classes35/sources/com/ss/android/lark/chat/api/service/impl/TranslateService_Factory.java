package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TranslateService_Factory implements Factory<TranslateService> {
    private final Provider<t0> repositoryProvider;

    public TranslateService get() {
        return newInstance((t0) this.repositoryProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m95get() {
        return get();
    }

    public TranslateService_Factory(Provider<t0> r1) {
        this.repositoryProvider = r1;
    }

    public static TranslateService_Factory create(Provider<t0> r1) {
        return new TranslateService_Factory(r1);
    }

    public static TranslateService newInstance(t0 r1) {
        return new TranslateService(r1);
    }
}
