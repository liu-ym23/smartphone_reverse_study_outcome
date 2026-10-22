package com.bytedance.android.live.openplatform.impl.minigameaudience.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import er0.b;
import wo0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory implements Factory<a> {
    private final hr0.a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m785get() {
        return provideMiniGameAudienceService(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m785get();
    }

    public MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory(hr0.a r1) {
        this.module = r1;
    }

    public static MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory create(hr0.a r1) {
        return new MiniGameAudienceModule_ProvideMiniGameAudienceServiceFactory(r1);
    }

    public static a provideMiniGameAudienceService(hr0.a r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new b());
    }
}
