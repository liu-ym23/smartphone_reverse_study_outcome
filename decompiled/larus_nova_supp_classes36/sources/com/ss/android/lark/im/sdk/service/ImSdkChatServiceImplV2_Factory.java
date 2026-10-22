package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkChatServiceImplV2_Factory implements Factory<f> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;
    private final Provider<String> userIdProvider;

    public f get() {
        return newInstance((String) this.userIdProvider.get(), (com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m740get() {
        return get();
    }

    public ImSdkChatServiceImplV2_Factory(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        this.userIdProvider = r1;
        this.userClientProvider = r2;
    }

    public static ImSdkChatServiceImplV2_Factory create(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        return new ImSdkChatServiceImplV2_Factory(r1, r2);
    }

    public static f newInstance(String r1, com.bytedance.lark.rustclient.api.l r2) {
        return new f(r1, r2);
    }
}
