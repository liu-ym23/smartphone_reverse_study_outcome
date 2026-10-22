package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreviewPushRepositoryV2_Factory implements Factory<PreviewPushRepositoryV2> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    public PreviewPushRepositoryV2 get() {
        return newInstance((String) this.currentUserIdProvider.get(), (com.bytedance.lark.rustclient.api.l) this.userClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m85get() {
        return get();
    }

    public PreviewPushRepositoryV2_Factory(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        this.currentUserIdProvider = r1;
        this.userClientProvider = r2;
    }

    public static PreviewPushRepositoryV2_Factory create(Provider<String> r1, Provider<com.bytedance.lark.rustclient.api.l> r2) {
        return new PreviewPushRepositoryV2_Factory(r1, r2);
    }

    public static PreviewPushRepositoryV2 newInstance(String r1, com.bytedance.lark.rustclient.api.l r2) {
        return new PreviewPushRepositoryV2(r1, r2);
    }
}
