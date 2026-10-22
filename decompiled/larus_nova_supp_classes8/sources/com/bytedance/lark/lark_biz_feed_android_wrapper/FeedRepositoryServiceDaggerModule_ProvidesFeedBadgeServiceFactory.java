package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.view_flow_wrapper.h;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory implements Factory<b> {
    private final Provider<FeedRepositoryServiceExportedModuleWrapper> containerProvider;
    private final a module;

    public b get() {
        return providesFeedBadgeService(this.module, (FeedRepositoryServiceExportedModuleWrapper) this.containerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1702get() {
        return get();
    }

    public FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory(a r1, Provider<FeedRepositoryServiceExportedModuleWrapper> r2) {
        this.module = r1;
        this.containerProvider = r2;
    }

    public static FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory create(a r1, Provider<FeedRepositoryServiceExportedModuleWrapper> r2) {
        return new FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory(r1, r2);
    }

    public static b providesFeedBadgeService(a r1, final FeedRepositoryServiceExportedModuleWrapper r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "container");
        b.u1.getClass();
        Intrinsics.checkNotNullParameter(r2, "container");
        b.C0375b r3 = new b.C0375b(new IFeedBadgeService$Companion$from$1(r2));
        Intrinsics.checkNotNullParameter(r3, "provider");
        return (b) Preconditions.checkNotNullFromProvides((b) ((h) ((com.bytedance.lark.view_flow_wrapper.a) r3).a.invoke()));
    }
}
