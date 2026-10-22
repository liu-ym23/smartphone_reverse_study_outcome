package com.bytedance.android.livesdk.gift.guide.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import h12.a;
import yy1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommentModule_ProviderCommentGuideViewFactory implements Factory<a> {
    private final b module;

    public a get() {
        return providerCommentGuideView(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m38get() {
        return get();
    }

    public CommentModule_ProviderCommentGuideViewFactory(b r1) {
        this.module = r1;
    }

    public static CommentModule_ProviderCommentGuideViewFactory create(b r1) {
        return new CommentModule_ProviderCommentGuideViewFactory(r1);
    }

    public static a providerCommentGuideView(b r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new yy1.a());
    }
}
