package com.bytedance.android.live.lynx.di;

import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.lynx.d;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ml0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveLynxModule_ProvideLynxServiceFactory implements Factory<w> {
    private final a module;

    public w get() {
        return provideLynxService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m509get() {
        return get();
    }

    public LiveLynxModule_ProvideLynxServiceFactory(a r1) {
        this.module = r1;
    }

    public static LiveLynxModule_ProvideLynxServiceFactory create(a r1) {
        return new LiveLynxModule_ProvideLynxServiceFactory(r1);
    }

    public static w provideLynxService(a r0) {
        r0.getClass();
        return (w) Preconditions.checkNotNullFromProvides(new d());
    }
}
