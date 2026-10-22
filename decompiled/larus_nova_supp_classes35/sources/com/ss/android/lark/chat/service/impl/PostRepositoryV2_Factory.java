package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PostRepositoryV2_Factory implements Factory<n1> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    public n1 get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m715get() {
        return get();
    }

    public PostRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.userClientProvider = r1;
    }

    public static PostRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new PostRepositoryV2_Factory(r1);
    }

    public static n1 newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new n1(r1);
    }
}
