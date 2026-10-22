package com.bytedance.android.livesdk.gift.guide.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.d;
import yy1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GuideModule_ProvideGuidePresenterFactory implements Factory<d> {
    private final e module;

    public d get() {
        return provideGuidePresenter(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m40get() {
        return get();
    }

    public GuideModule_ProvideGuidePresenterFactory(e r1) {
        this.module = r1;
    }

    public static GuideModule_ProvideGuidePresenterFactory create(e r1) {
        return new GuideModule_ProvideGuidePresenterFactory(r1);
    }

    public static d provideGuidePresenter(e r0) {
        r0.getClass();
        return (d) Preconditions.checkNotNullFromProvides(new yy1.d());
    }
}
