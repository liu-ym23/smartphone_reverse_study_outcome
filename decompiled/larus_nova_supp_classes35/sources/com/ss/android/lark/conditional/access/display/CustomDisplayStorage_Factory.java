package com.ss.android.lark.conditional.access.display;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CustomDisplayStorage_Factory implements Factory<e> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> kvStorageProvider;

    public e get() {
        return newInstance((com.ss.android.lark.storage.kv.storage.a) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m968get() {
        return get();
    }

    public CustomDisplayStorage_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r1) {
        this.kvStorageProvider = r1;
    }

    public static CustomDisplayStorage_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r1) {
        return new CustomDisplayStorage_Factory(r1);
    }

    public static e newInstance(com.ss.android.lark.storage.kv.storage.a r1) {
        return new e(r1);
    }
}
