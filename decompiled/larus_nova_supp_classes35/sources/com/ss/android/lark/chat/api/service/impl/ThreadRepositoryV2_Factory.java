package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadRepositoryV2_Factory implements Factory<l1> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    public l1 get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m92get() {
        return get();
    }

    public ThreadRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.userClientProvider = r1;
    }

    public static ThreadRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new ThreadRepositoryV2_Factory(r1);
    }

    public static l1 newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new l1(r1);
    }
}
