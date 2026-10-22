package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.f1;
import com.bytedance.lark.view_flow_wrapper.ViewFlowPlugin;
import com.bytedance.lark.view_flow_wrapper.n;
import com.bytedance.lark.view_flow_wrapper.p;
import com.bytedance.lark.view_flow_wrapper.v;
import com.bytedance.lark.view_flow_wrapper.y;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory implements Factory<FeedRepositoryServiceExportedModuleWrapper> {
    private final a module;
    private final Provider<f1> param0Provider;
    private final Provider<v> strategyProvider;

    public FeedRepositoryServiceExportedModuleWrapper get() {
        return providesFeedRepositoryServiceExportedModule(this.module, (f1) this.param0Provider.get(), (v) this.strategyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1703get() {
        return get();
    }

    public FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory(a r1, Provider<f1> r2, Provider<v> r3) {
        this.module = r1;
        this.param0Provider = r2;
        this.strategyProvider = r3;
    }

    public static FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory create(a r1, Provider<f1> r2, Provider<v> r3) {
        return new FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory(r1, r2, r3);
    }

    public static FeedRepositoryServiceExportedModuleWrapper providesFeedRepositoryServiceExportedModule(a r3, final f1 r4, final v r5) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "param0");
        Intrinsics.checkNotNullParameter(r5, "strategy");
        Function0<FeedRepositoryServiceExportedModuleWrapper> r0 = new FeedRepositoryServiceDaggerModule$providesFeedRepositoryServiceExportedModule$1(r4, r5);
        Intrinsics.checkNotNullParameter(r0, "creator");
        AutoCloseable r6 = ((n) r3).d;
        Object r7 = r6;
        if (r6 != null) goto L9;
        AutoCloseable r8 = (AutoCloseable) r0.invoke();
        y r9 = ViewFlowPlugin.a;
        if (r9 == null) goto L7;
        r9.a(new p((String) ((n) r3).c.getValue(), ((n) r3).a));
    L7:
        ((n) r3).d = r8;
        r7 = r8;
    L9:
        return (FeedRepositoryServiceExportedModuleWrapper) Preconditions.checkNotNullFromProvides((FeedRepositoryServiceExportedModuleWrapper) r7);
    }
}
