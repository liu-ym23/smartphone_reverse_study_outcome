package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.p;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatDataPreLoaderV2_Factory implements Factory<ChatDataPreLoaderV2> {
    private final Provider<ImSdkChatService> chatServiceProvider;
    private final Provider<p> messageServiceProvider;
    private final Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b> prepareDataLoaderProvider;

    public ChatDataPreLoaderV2 get() {
        return newInstance((ImSdkChatService) this.chatServiceProvider.get(), (p) this.messageServiceProvider.get(), (com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b) this.prepareDataLoaderProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m328get() {
        return get();
    }

    public ChatDataPreLoaderV2_Factory(Provider<ImSdkChatService> r1, Provider<p> r2, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b> r3) {
        this.chatServiceProvider = r1;
        this.messageServiceProvider = r2;
        this.prepareDataLoaderProvider = r3;
    }

    public static ChatDataPreLoaderV2_Factory create(Provider<ImSdkChatService> r1, Provider<p> r2, Provider<com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b> r3) {
        return new ChatDataPreLoaderV2_Factory(r1, r2, r3);
    }

    public static ChatDataPreLoaderV2 newInstance(ImSdkChatService r1, p r2, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.b r3) {
        return new ChatDataPreLoaderV2(r1, r2, r3);
    }
}
