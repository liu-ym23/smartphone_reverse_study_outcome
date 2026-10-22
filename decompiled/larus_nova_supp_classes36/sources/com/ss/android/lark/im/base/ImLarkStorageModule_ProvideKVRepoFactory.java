package com.ss.android.lark.im.base;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImLarkStorageModule_ProvideKVRepoFactory implements Factory<KVRepo> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> kvStorageProvider;
    private final e module;

    public KVRepo get() {
        return provideKVRepo(null, (com.ss.android.lark.storage.kv.storage.a) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m706get() {
        return get();
    }

    public ImLarkStorageModule_ProvideKVRepoFactory(e r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        this.kvStorageProvider = r2;
    }

    public static ImLarkStorageModule_ProvideKVRepoFactory create(e r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        return new ImLarkStorageModule_ProvideKVRepoFactory(r1, r2);
    }

    public static KVRepo provideKVRepo(e r0, com.ss.android.lark.storage.kv.storage.a r1) {
        throw null;
    }
}
