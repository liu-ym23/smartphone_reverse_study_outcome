package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AudioTextPushRepositoryV2_Factory implements Factory<g> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    public g get() {
        return newInstance((String) this.currentUserIdProvider.get(), (com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m681get() {
        return get();
    }

    public AudioTextPushRepositoryV2_Factory(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        this.currentUserIdProvider = r1;
        this.userClientProvider = r2;
    }

    public static AudioTextPushRepositoryV2_Factory create(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        return new AudioTextPushRepositoryV2_Factory(r1, r2);
    }

    public static g newInstance(String r1, com.bytedance.lark.rustclient.api.l r2) {
        return new g(r1, r2);
    }
}
