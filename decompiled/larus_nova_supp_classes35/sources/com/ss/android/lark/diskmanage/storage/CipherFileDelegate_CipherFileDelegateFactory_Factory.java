package com.ss.android.lark.diskmanage.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CipherFileDelegate_CipherFileDelegateFactory_Factory implements Factory<a.C0192a> {
    private final Provider<jkc.c> cipherManagerProvider;

    public a.C0192a get() {
        return newInstance((jkc.c) this.cipherManagerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1132get() {
        return get();
    }

    public CipherFileDelegate_CipherFileDelegateFactory_Factory(Provider<jkc.c> r1) {
        this.cipherManagerProvider = r1;
    }

    public static CipherFileDelegate_CipherFileDelegateFactory_Factory create(Provider<jkc.c> r1) {
        return new CipherFileDelegate_CipherFileDelegateFactory_Factory(r1);
    }

    public static a.C0192a newInstance(jkc.c r1) {
        return new a.C0192a(r1);
    }
}
