package com.ss.android.lark.core.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CoreUserKVStorage_Factory implements Factory<d> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> userKvStorageProvider;

    public d get() {
        return newInstance((com.ss.android.lark.storage.kv.storage.a) this.userKvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1085get() {
        return get();
    }

    public CoreUserKVStorage_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r1) {
        this.userKvStorageProvider = r1;
    }

    public static CoreUserKVStorage_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r1) {
        return new CoreUserKVStorage_Factory(r1);
    }

    public static d newInstance(com.ss.android.lark.storage.kv.storage.a r1) {
        return new d(r1);
    }
}
