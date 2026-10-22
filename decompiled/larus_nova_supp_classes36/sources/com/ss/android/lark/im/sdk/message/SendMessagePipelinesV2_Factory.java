package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SendMessagePipelinesV2_Factory implements Factory<f> {
    private final Provider<l> rustClientProvider;
    private final Provider<com.ss.android.lark.im.sdk.service.e> voiceTextPostProcessServiceProvider;

    public f get() {
        return newInstance((l) this.rustClientProvider.get(), (com.ss.android.lark.im.sdk.service.e) this.voiceTextPostProcessServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m736get() {
        return get();
    }

    public SendMessagePipelinesV2_Factory(Provider<l> r1, Provider<com.ss.android.lark.im.sdk.service.e> r2) {
        this.rustClientProvider = r1;
        this.voiceTextPostProcessServiceProvider = r2;
    }

    public static SendMessagePipelinesV2_Factory create(Provider<l> r1, Provider<com.ss.android.lark.im.sdk.service.e> r2) {
        return new SendMessagePipelinesV2_Factory(r1, r2);
    }

    public static f newInstance(l r1, com.ss.android.lark.im.sdk.service.e r2) {
        return new f(r1, r2);
    }
}
