package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.q;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import s20.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class H5Module_ProvideInternalServiceFactory implements Factory<q> {
    private final c module;

    public q get() {
        return provideInternalService(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m474get() {
        return get();
    }

    public H5Module_ProvideInternalServiceFactory(c r1) {
        this.module = r1;
    }

    public static H5Module_ProvideInternalServiceFactory create(c r1) {
        return new H5Module_ProvideInternalServiceFactory(r1);
    }

    public static q provideInternalService(c r0) {
        r0.getClass();
        return (q) Preconditions.checkNotNullFromProvides(new q());
    }
}
