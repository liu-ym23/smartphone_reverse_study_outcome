package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreviewService_Factory implements Factory<PreviewService> {
    private final Provider<a2b.e> repoProvider;

    public PreviewService get() {
        return newInstance((a2b.e) this.repoProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m89get() {
        return get();
    }

    public PreviewService_Factory(Provider<a2b.e> r1) {
        this.repoProvider = r1;
    }

    public static PreviewService_Factory create(Provider<a2b.e> r1) {
        return new PreviewService_Factory(r1);
    }

    public static PreviewService newInstance(a2b.e r1) {
        return new PreviewService(r1);
    }
}
