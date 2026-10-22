package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PrivateDescriptionService_Factory implements Factory<PrivateDescriptionService> {
    private final Provider<a2b.g> repositoryProvider;

    public PrivateDescriptionService get() {
        return newInstance((a2b.g) this.repositoryProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m91get() {
        return get();
    }

    public PrivateDescriptionService_Factory(Provider<a2b.g> r1) {
        this.repositoryProvider = r1;
    }

    public static PrivateDescriptionService_Factory create(Provider<a2b.g> r1) {
        return new PrivateDescriptionService_Factory(r1);
    }

    public static PrivateDescriptionService newInstance(a2b.g r1) {
        return new PrivateDescriptionService(r1);
    }
}
