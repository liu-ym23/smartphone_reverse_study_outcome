package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.g;
import com.bytedance.android.live.browser.jsbridge.prefetch.j;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeModule_ProvidePrefetchConfigFactory implements Factory<g> {
    private final f module;

    public g get() {
        return providePrefetchConfig(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m480get() {
        return get();
    }

    public JsBridgeModule_ProvidePrefetchConfigFactory(f r1) {
        this.module = r1;
    }

    public static JsBridgeModule_ProvidePrefetchConfigFactory create(f r1) {
        return new JsBridgeModule_ProvidePrefetchConfigFactory(r1);
    }

    public static g providePrefetchConfig(f r0) {
        r0.getClass();
        return (g) Preconditions.checkNotNullFromProvides(new j());
    }
}
