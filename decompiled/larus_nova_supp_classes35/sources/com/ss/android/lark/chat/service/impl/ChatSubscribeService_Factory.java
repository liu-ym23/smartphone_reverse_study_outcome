package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.api.service.IChatService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatSubscribeService_Factory implements Factory<i> {
    private final Provider<IChatService> legacyChatServiceProvider;

    public i get() {
        return newInstance((IChatService) this.legacyChatServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m683get() {
        return get();
    }

    public ChatSubscribeService_Factory(Provider<IChatService> r1) {
        this.legacyChatServiceProvider = r1;
    }

    public static ChatSubscribeService_Factory create(Provider<IChatService> r1) {
        return new ChatSubscribeService_Factory(r1);
    }

    public static i newInstance(IChatService r1) {
        return new i(r1);
    }
}
