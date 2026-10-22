package com.bytedance.android.live.openplatform.impl.miniappanchor.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import so0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory implements Factory<a> {
    private final qp0.a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m660get() {
        return provideMiniAppAnchorService(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m660get();
    }

    public MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory(qp0.a r1) {
        this.module = r1;
    }

    public static MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory create(qp0.a r1) {
        return new MiniAppAnchorModule_ProvideMiniAppAnchorServiceFactory(r1);
    }

    public static a provideMiniAppAnchorService(qp0.a r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new bp0.a());
    }
}
