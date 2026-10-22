package com.suite.lark.platform.component.storage.di;

import android.app.Application;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.storage.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class GlobalStorageModule_ProvideGlobalKVStorageFactory implements Factory<a> {
    private final Provider<Application> appProvider;

    public a get() {
        return provideGlobalKVStorage((Application) this.appProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1744get() {
        return get();
    }

    public GlobalStorageModule_ProvideGlobalKVStorageFactory(Provider<Application> r1) {
        this.appProvider = r1;
    }

    public static GlobalStorageModule_ProvideGlobalKVStorageFactory create(Provider<Application> r1) {
        return new GlobalStorageModule_ProvideGlobalKVStorageFactory(r1);
    }

    public static a provideGlobalKVStorage(Application r1) {
        int r0 = woc.a.a;
        Intrinsics.checkNotNullParameter(r1, "app");
        return (a) Preconditions.checkNotNullFromProvides(LarkKVStorage.e(r1, "lark"));
    }
}
