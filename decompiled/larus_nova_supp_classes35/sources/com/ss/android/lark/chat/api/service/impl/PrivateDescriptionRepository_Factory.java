package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PrivateDescriptionRepository_Factory implements Factory<e1> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    public e1 get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m90get() {
        return get();
    }

    public PrivateDescriptionRepository_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.rustClientProvider = r1;
    }

    public static PrivateDescriptionRepository_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new PrivateDescriptionRepository_Factory(r1);
    }

    public static e1 newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new e1(r1);
    }
}
