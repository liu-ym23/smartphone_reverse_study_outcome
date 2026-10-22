package com.bytedance.android.live.openplatform.impl.miniappaudience.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import to0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory implements Factory<a> {
    private final jq0.a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m725get() {
        return provideMiniAppAudienceService(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m725get();
    }

    public MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory(jq0.a r1) {
        this.module = r1;
    }

    public static MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory create(jq0.a r1) {
        return new MiniAppAudienceModule_ProvideMiniAppAudienceServiceFactory(r1);
    }

    public static a provideMiniAppAudienceService(jq0.a r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new fq0.a());
    }
}
