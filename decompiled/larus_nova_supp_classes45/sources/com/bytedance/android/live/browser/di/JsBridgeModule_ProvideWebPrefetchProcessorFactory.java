package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.h;
import com.bytedance.android.live.browser.jsbridge.prefetch.LivePrefetchProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeModule_ProvideWebPrefetchProcessorFactory implements Factory<h> {
    private final f module;

    public h get() {
        return provideWebPrefetchProcessor(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m484get() {
        return get();
    }

    public JsBridgeModule_ProvideWebPrefetchProcessorFactory(f r1) {
        this.module = r1;
    }

    public static JsBridgeModule_ProvideWebPrefetchProcessorFactory create(f r1) {
        return new JsBridgeModule_ProvideWebPrefetchProcessorFactory(r1);
    }

    public static h provideWebPrefetchProcessor(f r0) {
        r0.getClass();
        return (h) Preconditions.checkNotNullFromProvides(new LivePrefetchProcessor());
    }
}
