package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RustAssemblyModule_ProviderMakeOnlineV2RequestFactoryFactory implements Factory<p> {
    private final Provider<p> requestFactoryProvider;

    public p get() {
        return providerMakeOnlineV2RequestFactory((p) this.requestFactoryProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m685get() {
        return get();
    }

    public RustAssemblyModule_ProviderMakeOnlineV2RequestFactoryFactory(Provider<p> r1) {
        this.requestFactoryProvider = r1;
    }

    public static RustAssemblyModule_ProviderMakeOnlineV2RequestFactoryFactory create(Provider<p> r1) {
        return new RustAssemblyModule_ProviderMakeOnlineV2RequestFactoryFactory(r1);
    }

    public static p providerMakeOnlineV2RequestFactory(p r1) {
        int r0 = t.a;
        Intrinsics.checkNotNullParameter(r1, "requestFactory");
        return (p) Preconditions.checkNotNullFromProvides(r1);
    }
}
