package com.ss.android.lark.integrator.security.compliance.export;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SecurityFileCryptoService_Factory implements Factory<SecurityFileCryptoService> {
    private final Provider<jkc.c> cipherManagerProvider;
    private final Provider<String> userIdProvider;

    public SecurityFileCryptoService get() {
        return newInstance((String) this.userIdProvider.get(), (jkc.c) this.cipherManagerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m947get() {
        return get();
    }

    public SecurityFileCryptoService_Factory(Provider<String> r1, Provider<jkc.c> r2) {
        this.userIdProvider = r1;
        this.cipherManagerProvider = r2;
    }

    public static SecurityFileCryptoService_Factory create(Provider<String> r1, Provider<jkc.c> r2) {
        return new SecurityFileCryptoService_Factory(r1, r2);
    }

    public static SecurityFileCryptoService newInstance(String r1, jkc.c r2) {
        return new SecurityFileCryptoService(r1, r2);
    }
}
