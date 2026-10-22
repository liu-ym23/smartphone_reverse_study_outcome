package com.bytedance.android.live.saas.middleware.di;

import com.bytedance.android.live.saas.middleware.IBDLiveSdkInit;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BDLiveSdkModule_ProvideFunctionFactory implements Factory<IBDLiveSdkInit> {
    private final BDLiveSdkModule module;

    public IBDLiveSdkInit get() {
        return provideFunction(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1120get() {
        return get();
    }

    public BDLiveSdkModule_ProvideFunctionFactory(BDLiveSdkModule r1) {
        this.module = r1;
    }

    public static BDLiveSdkModule_ProvideFunctionFactory create(BDLiveSdkModule r1) {
        return new BDLiveSdkModule_ProvideFunctionFactory(r1);
    }

    public static IBDLiveSdkInit provideFunction(BDLiveSdkModule r0) {
        return (IBDLiveSdkInit) Preconditions.checkNotNullFromProvides(r0.provideFunction());
    }
}
