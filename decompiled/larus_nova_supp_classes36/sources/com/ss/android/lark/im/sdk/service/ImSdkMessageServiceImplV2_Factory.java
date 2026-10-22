package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkMessageServiceImplV2_Factory implements Factory<ImSdkMessageServiceImplV2> {
    private final Provider<com.ss.android.lark.im.sdk.message.b> resendMessagePipelinesProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;
    private final Provider<com.ss.android.lark.im.sdk.message.f> sendMessagePipelinesProvider;

    public ImSdkMessageServiceImplV2 get() {
        return newInstance((com.ss.android.lark.im.sdk.message.f) this.sendMessagePipelinesProvider.get(), (com.ss.android.lark.im.sdk.message.b) this.resendMessagePipelinesProvider.get(), (com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m743get() {
        return get();
    }

    public ImSdkMessageServiceImplV2_Factory(Provider<com.ss.android.lark.im.sdk.message.f> r1, Provider<com.ss.android.lark.im.sdk.message.b> r2, Provider<com.bytedance.lark.rustclient.api.l> r3) {
        this.sendMessagePipelinesProvider = r1;
        this.resendMessagePipelinesProvider = r2;
        this.rustClientProvider = r3;
    }

    public static ImSdkMessageServiceImplV2_Factory create(Provider<com.ss.android.lark.im.sdk.message.f> r1, Provider<com.ss.android.lark.im.sdk.message.b> r2, Provider<com.bytedance.lark.rustclient.api.l> r3) {
        return new ImSdkMessageServiceImplV2_Factory(r1, r2, r3);
    }

    public static ImSdkMessageServiceImplV2 newInstance(com.ss.android.lark.im.sdk.message.f r1, com.ss.android.lark.im.sdk.message.b r2, com.bytedance.lark.rustclient.api.l r3) {
        return new ImSdkMessageServiceImplV2(r1, r2, r3);
    }
}
