package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.g;
import com.bytedance.android.live.browser.jsbridge.prefetch.i;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeModule_ProvideLocalPrefetchConfigFactory implements Factory<g> {
    private final f module;

    public g get() {
        return provideLocalPrefetchConfig(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m479get() {
        return get();
    }

    public JsBridgeModule_ProvideLocalPrefetchConfigFactory(f r1) {
        this.module = r1;
    }

    public static JsBridgeModule_ProvideLocalPrefetchConfigFactory create(f r1) {
        return new JsBridgeModule_ProvideLocalPrefetchConfigFactory(r1);
    }

    public static g provideLocalPrefetchConfig(f r0) {
        r0.getClass();
        return (g) Preconditions.checkNotNullFromProvides(new i());
    }
}
