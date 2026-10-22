package com.ss.android.lark.im.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkThreadServiceImpl_Factory implements Factory<y> {
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    public y get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m750get() {
        return get();
    }

    public ImSdkThreadServiceImpl_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.userClientProvider = r1;
    }

    public static ImSdkThreadServiceImpl_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new ImSdkThreadServiceImpl_Factory(r1);
    }

    public static y newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new y(r1);
    }
}
