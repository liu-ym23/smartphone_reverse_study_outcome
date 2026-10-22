package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.q;
import com.bytedance.android.live.browser.u;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import s20.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class H5Module_ProvideH5ServiceFactory implements Factory<u> {
    private final Provider<q> h5ServiceProvider;
    private final c module;

    public u get() {
        return provideH5Service(this.module, (q) this.h5ServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m473get() {
        return get();
    }

    public H5Module_ProvideH5ServiceFactory(c r1, Provider<q> r2) {
        this.module = r1;
        this.h5ServiceProvider = r2;
    }

    public static H5Module_ProvideH5ServiceFactory create(c r1, Provider<q> r2) {
        return new H5Module_ProvideH5ServiceFactory(r1, r2);
    }

    public static u provideH5Service(c r0, q r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "h5Service");
        return (u) Preconditions.checkNotNullFromProvides(r1);
    }
}
