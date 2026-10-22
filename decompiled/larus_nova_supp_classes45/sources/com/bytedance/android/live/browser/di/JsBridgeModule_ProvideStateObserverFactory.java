package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.StateObserver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class JsBridgeModule_ProvideStateObserverFactory implements Factory<i.d> {
    private final f module;

    public i.d get() {
        return provideStateObserver(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m481get() {
        return get();
    }

    public JsBridgeModule_ProvideStateObserverFactory(f r1) {
        this.module = r1;
    }

    public static JsBridgeModule_ProvideStateObserverFactory create(f r1) {
        return new JsBridgeModule_ProvideStateObserverFactory(r1);
    }

    public static i.d provideStateObserver(f r0) {
        r0.getClass();
        return (i.d) Preconditions.checkNotNullFromProvides(new StateObserver());
    }
}
