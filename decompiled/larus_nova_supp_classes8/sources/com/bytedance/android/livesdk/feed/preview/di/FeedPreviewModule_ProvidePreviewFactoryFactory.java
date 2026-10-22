package com.bytedance.android.livesdk.feed.preview.di;

import com.bytedance.android.livesdk.feed.preview.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import pw1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedPreviewModule_ProvidePreviewFactoryFactory implements Factory<a> {
    private final b module;

    public a get() {
        return providePreviewFactory(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1233get() {
        return get();
    }

    public FeedPreviewModule_ProvidePreviewFactoryFactory(b r1) {
        this.module = r1;
    }

    public static FeedPreviewModule_ProvidePreviewFactoryFactory create(b r1) {
        return new FeedPreviewModule_ProvidePreviewFactoryFactory(r1);
    }

    public static a providePreviewFactory(b r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new pw1.a());
    }
}
