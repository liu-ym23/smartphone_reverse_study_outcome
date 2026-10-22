package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class InitRustSdkTaskForSimple_Factory implements Factory<InitRustSdkTaskForSimple> {
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    public InitRustSdkTaskForSimple get() {
        return newInstance((com.ss.android.lark.passportc.api.j) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m678get() {
        return get();
    }

    public InitRustSdkTaskForSimple_Factory(Provider<com.ss.android.lark.passportc.api.j> r1) {
        this.passportProvider = r1;
    }

    public static InitRustSdkTaskForSimple_Factory create(Provider<com.ss.android.lark.passportc.api.j> r1) {
        return new InitRustSdkTaskForSimple_Factory(r1);
    }

    public static InitRustSdkTaskForSimple newInstance(com.ss.android.lark.passportc.api.j r1) {
        return new InitRustSdkTaskForSimple(r1);
    }
}
