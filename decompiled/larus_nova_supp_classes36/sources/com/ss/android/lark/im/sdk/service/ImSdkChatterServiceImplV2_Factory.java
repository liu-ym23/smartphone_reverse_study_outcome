package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkChatterServiceImplV2_Factory implements Factory<ImSdkChatterServiceImplV2> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    public ImSdkChatterServiceImplV2 get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m741get() {
        return get();
    }

    public ImSdkChatterServiceImplV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.rustClientProvider = r1;
    }

    public static ImSdkChatterServiceImplV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new ImSdkChatterServiceImplV2_Factory(r1);
    }

    public static ImSdkChatterServiceImplV2 newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new ImSdkChatterServiceImplV2(r1);
    }
}
