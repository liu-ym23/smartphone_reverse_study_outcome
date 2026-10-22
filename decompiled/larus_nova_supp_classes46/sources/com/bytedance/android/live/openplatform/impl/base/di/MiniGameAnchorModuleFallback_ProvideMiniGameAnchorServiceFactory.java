package com.bytedance.android.live.openplatform.impl.base.di;

import dagger.internal.Factory;
import po0.c;
import vo0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniGameAnchorModuleFallback_ProvideMiniGameAnchorServiceFactory implements Factory<a> {
    private final c module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m626get() {
        return provideMiniGameAnchorService(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m626get();
    }

    public MiniGameAnchorModuleFallback_ProvideMiniGameAnchorServiceFactory(c r1) {
    }

    public static MiniGameAnchorModuleFallback_ProvideMiniGameAnchorServiceFactory create(c r1) {
        return new MiniGameAnchorModuleFallback_ProvideMiniGameAnchorServiceFactory(r1);
    }

    public static a provideMiniGameAnchorService(c r0) {
        throw null;
    }
}
