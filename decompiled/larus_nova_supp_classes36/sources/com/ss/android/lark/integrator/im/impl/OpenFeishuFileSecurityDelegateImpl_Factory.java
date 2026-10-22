package com.ss.android.lark.integrator.im.impl;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OpenFeishuFileSecurityDelegateImpl_Factory implements Factory<i> {
    private final Provider<jza.c> internalFileSecurityServiceProvider;

    public i get() {
        return newInstance((jza.c) this.internalFileSecurityServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m901get() {
        return get();
    }

    public OpenFeishuFileSecurityDelegateImpl_Factory(Provider<jza.c> r1) {
        this.internalFileSecurityServiceProvider = r1;
    }

    public static OpenFeishuFileSecurityDelegateImpl_Factory create(Provider<jza.c> r1) {
        return new OpenFeishuFileSecurityDelegateImpl_Factory(r1);
    }

    public static i newInstance(jza.c r1) {
        return new i(r1);
    }
}
