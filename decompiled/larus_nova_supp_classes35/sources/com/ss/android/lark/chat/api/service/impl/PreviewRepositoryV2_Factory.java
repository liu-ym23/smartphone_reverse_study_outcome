package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreviewRepositoryV2_Factory implements Factory<PreviewRepositoryV2> {
    private final Provider<com.bytedance.lark.rustclient.api.l> rustClientProvider;

    public PreviewRepositoryV2 get() {
        return newInstance((com.bytedance.lark.rustclient.api.l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m87get() {
        return get();
    }

    public PreviewRepositoryV2_Factory(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        this.rustClientProvider = r1;
    }

    public static PreviewRepositoryV2_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r1) {
        return new PreviewRepositoryV2_Factory(r1);
    }

    public static PreviewRepositoryV2 newInstance(com.bytedance.lark.rustclient.api.l r1) {
        return new PreviewRepositoryV2(r1);
    }
}
