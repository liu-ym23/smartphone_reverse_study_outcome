package com.ss.android.lark.core.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CoreUserStorageModule_ProvideCoreUserKVStorageFactory implements Factory<d> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> kvStorageProvider;
    private final e module;

    public d get() {
        return provideCoreUserKVStorage(null, (com.ss.android.lark.storage.kv.storage.a) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1086get() {
        return get();
    }

    public CoreUserStorageModule_ProvideCoreUserKVStorageFactory(e r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        this.kvStorageProvider = r2;
    }

    public static CoreUserStorageModule_ProvideCoreUserKVStorageFactory create(e r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        return new CoreUserStorageModule_ProvideCoreUserKVStorageFactory(r1, r2);
    }

    public static d provideCoreUserKVStorage(e r0, com.ss.android.lark.storage.kv.storage.a r1) {
        throw null;
    }
}
