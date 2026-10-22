package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessagePushV2_Factory implements Factory<MessagePushV2> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    public MessagePushV2 get() {
        return newInstance((String) this.currentUserIdProvider.get(), (com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m713get() {
        return get();
    }

    public MessagePushV2_Factory(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        this.currentUserIdProvider = r1;
        this.userClientProvider = r2;
    }

    public static MessagePushV2_Factory create(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        return new MessagePushV2_Factory(r1, r2);
    }

    public static MessagePushV2 newInstance(String r1, com.bytedance.lark.rustclient.api.l r2) {
        return new MessagePushV2(r1, r2);
    }
}
