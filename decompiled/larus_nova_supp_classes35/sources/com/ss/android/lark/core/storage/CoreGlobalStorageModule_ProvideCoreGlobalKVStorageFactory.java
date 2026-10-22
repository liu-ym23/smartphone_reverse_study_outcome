package com.ss.android.lark.core.storage;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CoreGlobalStorageModule_ProvideCoreGlobalKVStorageFactory implements Factory<b> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> globalKvStorageProvider;
    private final c module;

    public b get() {
        return provideCoreGlobalKVStorage(this.module, (com.ss.android.lark.storage.kv.storage.a) this.globalKvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1083get() {
        return get();
    }

    public CoreGlobalStorageModule_ProvideCoreGlobalKVStorageFactory(c r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        this.module = r1;
        this.globalKvStorageProvider = r2;
    }

    public static CoreGlobalStorageModule_ProvideCoreGlobalKVStorageFactory create(c r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        return new CoreGlobalStorageModule_ProvideCoreGlobalKVStorageFactory(r1, r2);
    }

    public static b provideCoreGlobalKVStorage(c r0, com.ss.android.lark.storage.kv.storage.a r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "globalKvStorage");
        return (b) Preconditions.checkNotNullFromProvides(new b(r1));
    }
}
