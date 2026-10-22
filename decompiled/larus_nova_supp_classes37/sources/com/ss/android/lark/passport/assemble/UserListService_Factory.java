package com.ss.android.lark.passport.assemble;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserListService_Factory implements Factory<UserListService> {
    private final Provider<Context> contextProvider;
    private final Provider<com.ss.android.lark.storage.kv.storage.a> kvStorageProvider;

    public UserListService get() {
        return newInstance((Context) this.contextProvider.get(), this.kvStorageProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m598get() {
        return get();
    }

    public UserListService_Factory(Provider<Context> r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        this.contextProvider = r1;
        this.kvStorageProvider = r2;
    }

    public static UserListService_Factory create(Provider<Context> r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        return new UserListService_Factory(r1, r2);
    }

    public static UserListService newInstance(Context r1, Provider<com.ss.android.lark.storage.kv.storage.a> r2) {
        return new UserListService(r1, r2);
    }
}
