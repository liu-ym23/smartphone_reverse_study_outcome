package com.ss.android.lark.chat.api.service.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreviewPush_Factory implements Factory<PreviewPush> {
    private final Provider<a2b.f> previewServiceProvider;
    private final Provider<a2b.d> pushRepoProvider;

    public PreviewPush get() {
        return newInstance((a2b.d) this.pushRepoProvider.get(), (a2b.f) this.previewServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m86get() {
        return get();
    }

    public PreviewPush_Factory(Provider<a2b.d> r1, Provider<a2b.f> r2) {
        this.pushRepoProvider = r1;
        this.previewServiceProvider = r2;
    }

    public static PreviewPush_Factory create(Provider<a2b.d> r1, Provider<a2b.f> r2) {
        return new PreviewPush_Factory(r1, r2);
    }

    public static PreviewPush newInstance(a2b.d r1, a2b.f r2) {
        return new PreviewPush(r1, r2);
    }
}
