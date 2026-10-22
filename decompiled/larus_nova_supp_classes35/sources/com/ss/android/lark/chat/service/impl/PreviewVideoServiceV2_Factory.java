package com.ss.android.lark.chat.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreviewVideoServiceV2_Factory implements Factory<z1> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    public z1 get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m717get() {
        return get();
    }

    public PreviewVideoServiceV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.rustClientProvider = r1;
    }

    public static PreviewVideoServiceV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new PreviewVideoServiceV2_Factory(r1);
    }

    public static z1 newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new z1(r1);
    }
}
