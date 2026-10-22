package com.bytedance.android.live.openplatform.impl.minigameanchor.di;

import com.bytedance.android.live.openplatform.impl.minigameanchor.MiniGameAnchorServiceImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import vo0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory implements Factory<a> {
    private final ar0.a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m775get() {
        return provideMiniGameAnchorService(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m775get();
    }

    public MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory(ar0.a r1) {
        this.module = r1;
    }

    public static MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory create(ar0.a r1) {
        return new MiniGameAnchorModule_ProvideMiniGameAnchorServiceFactory(r1);
    }

    public static a provideMiniGameAnchorService(ar0.a r0) {
        r0.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new MiniGameAnchorServiceImpl());
    }
}
