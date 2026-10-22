package com.bytedance.android.livesdk.gift.guide.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.c;
import yy1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GuideModule_ProvideGuideDialogFactory implements Factory<c> {
    private final e module;

    public c get() {
        return provideGuideDialog(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m39get() {
        return get();
    }

    public GuideModule_ProvideGuideDialogFactory(e r1) {
        this.module = r1;
    }

    public static GuideModule_ProvideGuideDialogFactory create(e r1) {
        return new GuideModule_ProvideGuideDialogFactory(r1);
    }

    public static c provideGuideDialog(e r0) {
        r0.getClass();
        return (c) Preconditions.checkNotNullFromProvides(new yy1.c());
    }
}
