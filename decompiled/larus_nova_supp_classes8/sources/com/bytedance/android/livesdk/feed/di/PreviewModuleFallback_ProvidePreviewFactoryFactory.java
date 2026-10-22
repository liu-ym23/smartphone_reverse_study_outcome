package com.bytedance.android.livesdk.feed.di;

import com.bytedance.android.livesdk.feed.preview.a;
import dagger.internal.Factory;
import rv1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PreviewModuleFallback_ProvidePreviewFactoryFactory implements Factory<a> {
    private final c module;

    public a get() {
        return providePreviewFactory(null);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1222get() {
        return get();
    }

    public PreviewModuleFallback_ProvidePreviewFactoryFactory(c r1) {
    }

    public static PreviewModuleFallback_ProvidePreviewFactoryFactory create(c r1) {
        return new PreviewModuleFallback_ProvidePreviewFactoryFactory(r1);
    }

    public static a providePreviewFactory(c r0) {
        throw null;
    }
}
