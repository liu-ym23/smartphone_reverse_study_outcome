package com.ss.android.lark.diskmanage.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserScopeCipherFileSystem_UserScopeCipherFileSystemFactory_Factory implements Factory<UserScopeCipherFileSystem.UserScopeCipherFileSystemFactory> {
    private final Provider<jkc.c> cipherManagerProvider;

    public UserScopeCipherFileSystem.UserScopeCipherFileSystemFactory get() {
        return newInstance((jkc.c) this.cipherManagerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1137get() {
        return get();
    }

    public UserScopeCipherFileSystem_UserScopeCipherFileSystemFactory_Factory(Provider<jkc.c> r1) {
        this.cipherManagerProvider = r1;
    }

    public static UserScopeCipherFileSystem_UserScopeCipherFileSystemFactory_Factory create(Provider<jkc.c> r1) {
        return new UserScopeCipherFileSystem_UserScopeCipherFileSystemFactory_Factory(r1);
    }

    public static UserScopeCipherFileSystem.UserScopeCipherFileSystemFactory newInstance(jkc.c r1) {
        return new UserScopeCipherFileSystem.UserScopeCipherFileSystemFactory(r1);
    }
}
