package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TranslateRepositoryV2_Factory implements Factory<a2> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    public a2 get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m94get() {
        return get();
    }

    public TranslateRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.userClientProvider = r1;
    }

    public static TranslateRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new TranslateRepositoryV2_Factory(r1);
    }

    public static a2 newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new a2(r1);
    }
}
