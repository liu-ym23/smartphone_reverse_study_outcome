package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatService_Factory implements Factory<ChatService> {
    private final Provider<a2b.a> chatRepositoryProvider;

    public ChatService get() {
        return newInstance((a2b.a) this.chatRepositoryProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m82get() {
        return get();
    }

    public ChatService_Factory(Provider<a2b.a> r1) {
        this.chatRepositoryProvider = r1;
    }

    public static ChatService_Factory create(Provider<a2b.a> r1) {
        return new ChatService_Factory(r1);
    }

    public static ChatService newInstance(a2b.a r1) {
        return new ChatService(r1);
    }
}
