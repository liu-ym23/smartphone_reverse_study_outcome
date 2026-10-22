package com.ss.android.lark.chat.core.dependency;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import w4b.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PassportDependencyV2_Factory implements Factory<a0> {
    private final Provider<m> userServiceProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a0 m498get() {
        return newInstance((m) this.userServiceProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m498get();
    }

    public PassportDependencyV2_Factory(Provider<m> r1) {
        this.userServiceProvider = r1;
    }

    public static PassportDependencyV2_Factory create(Provider<m> r1) {
        return new PassportDependencyV2_Factory(r1);
    }

    public static a0 newInstance(m r1) {
        return new a0(r1);
    }
}
