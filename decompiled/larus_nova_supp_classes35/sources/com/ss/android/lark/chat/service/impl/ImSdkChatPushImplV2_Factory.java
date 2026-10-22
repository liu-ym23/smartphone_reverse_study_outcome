package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ImSdkChatPushImplV2_Factory implements Factory<ImSdkChatPushImplV2> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userRustClientProvider;

    public ImSdkChatPushImplV2 get() {
        return newInstance((String) this.currentUserIdProvider.get(), (com.bytedance.lark.rustclient.api.l) this.userRustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m704get() {
        return get();
    }

    public ImSdkChatPushImplV2_Factory(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        this.currentUserIdProvider = r1;
        this.userRustClientProvider = r2;
    }

    public static ImSdkChatPushImplV2_Factory create(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        return new ImSdkChatPushImplV2_Factory(r1, r2);
    }

    public static ImSdkChatPushImplV2 newInstance(String r1, com.bytedance.lark.rustclient.api.l r2) {
        return new ImSdkChatPushImplV2(r1, r2);
    }
}
