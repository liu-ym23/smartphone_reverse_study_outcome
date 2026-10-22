package com.bytedance.android.live.openplatform.impl.base.di;

import dagger.internal.Factory;
import po0.b;
import so0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniAppAnchorModuleFallback_ProvideMiniAppAnchorServiceFactory implements Factory<a> {
    private final b module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m625get() {
        return provideMiniAppAnchorService(null);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m625get();
    }

    public MiniAppAnchorModuleFallback_ProvideMiniAppAnchorServiceFactory(b r1) {
    }

    public static MiniAppAnchorModuleFallback_ProvideMiniAppAnchorServiceFactory create(b r1) {
        return new MiniAppAnchorModuleFallback_ProvideMiniAppAnchorServiceFactory(r1);
    }

    public static a provideMiniAppAnchorService(b r0) {
        throw null;
    }
}
