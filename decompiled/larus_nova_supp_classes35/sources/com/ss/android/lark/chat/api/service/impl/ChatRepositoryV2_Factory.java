package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatRepositoryV2_Factory implements Factory<o> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    public o get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m81get() {
        return get();
    }

    public ChatRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.userClientProvider = r1;
    }

    public static ChatRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new ChatRepositoryV2_Factory(r1);
    }

    public static o newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new o(r1);
    }
}
