package com.ss.android.lark.officesdk;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory implements Factory<h0> {
    private final Provider<Map<Class<?>, Provider<Object>>> servicesProvider;

    public static h0 newInstance() {
        return new h0();
    }

    public h0 get() {
        h0 r0 = newInstance();
        r0.a = DoubleCheck.lazy(this.servicesProvider);
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1get() {
        return get();
    }

    public HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory(Provider<Map<Class<?>, Provider<Object>>> r1) {
        this.servicesProvider = r1;
    }

    public static HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory create(Provider<Map<Class<?>, Provider<Object>>> r1) {
        return new HiltRoot_HiltComponents_BackgroundUserCServiceProvider_Factory(r1);
    }
}
