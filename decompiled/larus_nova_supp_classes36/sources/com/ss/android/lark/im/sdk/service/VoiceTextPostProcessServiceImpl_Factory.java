package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceTextPostProcessServiceImpl_Factory implements Factory<VoiceTextPostProcessServiceImpl> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    public VoiceTextPostProcessServiceImpl get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m751get() {
        return get();
    }

    public VoiceTextPostProcessServiceImpl_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.rustClientProvider = r1;
    }

    public static VoiceTextPostProcessServiceImpl_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new VoiceTextPostProcessServiceImpl_Factory(r1);
    }

    public static VoiceTextPostProcessServiceImpl newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new VoiceTextPostProcessServiceImpl(r1);
    }
}
