package com.ss.android.lark.chameleonv2.container.jsruntime;

import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.convention.b;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import javax.inject.Provider;
import m0b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CmlJsRuntimeProxy_Factory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;
    private final Provider<b<AbsChameleonJsRuntime>> proxyProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public c m50get() {
        return newInstance((j) this.passportProvider.get(), (v) this.accessorProvider.get(), (b) this.proxyProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m50get();
    }

    public CmlJsRuntimeProxy_Factory(Provider<j> r1, Provider<v> r2, Provider<b<AbsChameleonJsRuntime>> r3) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
        this.proxyProvider = r3;
    }

    public static CmlJsRuntimeProxy_Factory create(Provider<j> r1, Provider<v> r2, Provider<b<AbsChameleonJsRuntime>> r3) {
        return new CmlJsRuntimeProxy_Factory(r1, r2, r3);
    }

    public static c newInstance(j r1, v r2, b<AbsChameleonJsRuntime> r3) {
        return new c(r1, r2, r3);
    }
}
