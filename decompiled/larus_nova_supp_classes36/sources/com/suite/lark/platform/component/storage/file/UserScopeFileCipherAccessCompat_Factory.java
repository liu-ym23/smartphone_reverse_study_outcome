package com.suite.lark.platform.component.storage.file;

import dagger.internal.Factory;
import javax.inject.Provider;
import jkc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UserScopeFileCipherAccessCompat_Factory implements Factory<b> {
    private final Provider<c> cipherManagerProvider;

    public b get() {
        return newInstance((c) this.cipherManagerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1747get() {
        return get();
    }

    public UserScopeFileCipherAccessCompat_Factory(Provider<c> r1) {
        this.cipherManagerProvider = r1;
    }

    public static UserScopeFileCipherAccessCompat_Factory create(Provider<c> r1) {
        return new UserScopeFileCipherAccessCompat_Factory(r1);
    }

    public static b newInstance(c r1) {
        return new b(r1);
    }
}
