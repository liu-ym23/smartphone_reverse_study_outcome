package com.ss.android.lark.passportc.convention;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoneContainerSessionGetterImpl_Factory implements Factory<c> {
    private final Provider<j> passportProvider;

    public c get() {
        return newInstance((j) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m694get() {
        return get();
    }

    public NoneContainerSessionGetterImpl_Factory(Provider<j> r1) {
        this.passportProvider = r1;
    }

    public static NoneContainerSessionGetterImpl_Factory create(Provider<j> r1) {
        return new NoneContainerSessionGetterImpl_Factory(r1);
    }

    public static c newInstance(j r1) {
        return new c(r1);
    }
}
