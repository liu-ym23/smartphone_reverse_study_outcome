package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.w;
import dagger.internal.Factory;
import s20.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveLynxModuleFallback_ProvideLynxServiceFactory implements Factory<w> {
    private final g module;

    public w get() {
        return provideLynxService(null);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m485get() {
        return get();
    }

    public LiveLynxModuleFallback_ProvideLynxServiceFactory(g r1) {
    }

    public static LiveLynxModuleFallback_ProvideLynxServiceFactory create(g r1) {
        return new LiveLynxModuleFallback_ProvideLynxServiceFactory(r1);
    }

    public static w provideLynxService(g r0) {
        throw null;
    }
}
