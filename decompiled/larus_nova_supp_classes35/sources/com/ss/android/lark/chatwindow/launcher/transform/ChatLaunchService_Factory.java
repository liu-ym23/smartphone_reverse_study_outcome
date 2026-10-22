package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatLaunchService_Factory implements Factory<ChatLaunchService> {
    private final Provider<ImSdkChatService> chatServiceProvider;
    private final Provider<h> chatterServiceProvider;

    public ChatLaunchService get() {
        return newInstance((ImSdkChatService) this.chatServiceProvider.get(), (h) this.chatterServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m739get() {
        return get();
    }

    public ChatLaunchService_Factory(Provider<ImSdkChatService> r1, Provider<h> r2) {
        this.chatServiceProvider = r1;
        this.chatterServiceProvider = r2;
    }

    public static ChatLaunchService_Factory create(Provider<ImSdkChatService> r1, Provider<h> r2) {
        return new ChatLaunchService_Factory(r1, r2);
    }

    public static ChatLaunchService newInstance(ImSdkChatService r1, h r2) {
        return new ChatLaunchService(r1, r2);
    }
}
