package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare;

import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.im.sdk.service.x;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import m6b.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatPrepareDataLoader_Factory implements Factory<a> {
    private final Provider<ImSdkChatService> chatServiceProvider;
    private final Provider<t> chatterPushProvider;
    private final Provider<h> chatterServiceProvider;
    private final Provider<m> passportProvider;
    private final Provider<x> threadServiceProvider;
    private final Provider<String> userIdProvider;

    public a get() {
        return newInstance((m) this.passportProvider.get(), (String) this.userIdProvider.get(), (ImSdkChatService) this.chatServiceProvider.get(), (h) this.chatterServiceProvider.get(), (x) this.threadServiceProvider.get(), (t) this.chatterPushProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m330get() {
        return get();
    }

    public ChatPrepareDataLoader_Factory(Provider<m> r1, Provider<String> r2, Provider<ImSdkChatService> r3, Provider<h> r4, Provider<x> r5, Provider<t> r6) {
        this.passportProvider = r1;
        this.userIdProvider = r2;
        this.chatServiceProvider = r3;
        this.chatterServiceProvider = r4;
        this.threadServiceProvider = r5;
        this.chatterPushProvider = r6;
    }

    public static ChatPrepareDataLoader_Factory create(Provider<m> r8, Provider<String> r9, Provider<ImSdkChatService> r10, Provider<h> r11, Provider<x> r12, Provider<t> r13) {
        return new ChatPrepareDataLoader_Factory(r8, r9, r10, r11, r12, r13);
    }

    public static a newInstance(m r8, String r9, ImSdkChatService r10, h r11, x r12, t r13) {
        return new a(r8, r9, r10, r11, r12, r13);
    }
}
