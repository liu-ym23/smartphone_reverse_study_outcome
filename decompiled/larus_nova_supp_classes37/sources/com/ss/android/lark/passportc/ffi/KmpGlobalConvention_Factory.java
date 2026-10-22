package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class KmpGlobalConvention_Factory implements Factory<a> {
    private final Provider<j> passportProvider;

    public a get() {
        return newInstance((j) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m701get() {
        return get();
    }

    public KmpGlobalConvention_Factory(Provider<j> r1) {
        this.passportProvider = r1;
    }

    public static KmpGlobalConvention_Factory create(Provider<j> r1) {
        return new KmpGlobalConvention_Factory(r1);
    }

    public static a newInstance(j r1) {
        return new a(r1);
    }
}
