package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class KmpUserConvention_Factory implements Factory<KmpUserConvention> {
    private final Provider<m> passportProvider;

    public KmpUserConvention get() {
        return newInstance((m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m705get() {
        return get();
    }

    public KmpUserConvention_Factory(Provider<m> r1) {
        this.passportProvider = r1;
    }

    public static KmpUserConvention_Factory create(Provider<m> r1) {
        return new KmpUserConvention_Factory(r1);
    }

    public static KmpUserConvention newInstance(m r1) {
        return new KmpUserConvention(r1);
    }
}
