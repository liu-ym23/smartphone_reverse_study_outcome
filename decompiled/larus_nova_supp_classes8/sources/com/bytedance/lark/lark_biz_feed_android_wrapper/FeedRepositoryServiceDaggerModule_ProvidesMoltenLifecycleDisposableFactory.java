package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.view_flow_wrapper.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory implements Factory<m> {
    private final a module;

    public m get() {
        return providesMoltenLifecycleDisposable(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1704get() {
        return get();
    }

    public FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory(a r1) {
        this.module = r1;
    }

    public static FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory create(a r1) {
        return new FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory(r1);
    }

    public static m providesMoltenLifecycleDisposable(a r0) {
        r0.getClass();
        return (m) Preconditions.checkNotNullFromProvides(r0);
    }
}
