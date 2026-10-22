package com.ss.android.lark.officesdk;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class HiltRoot_HiltComponents_OfficeSDKGlobalCServiceProvider_Factory implements Factory<o0> {
    private final Provider<Map<Class<?>, Provider<Object>>> servicesProvider;

    public static o0 newInstance() {
        return new o0();
    }

    public o0 get() {
        o0 r0 = newInstance();
        r0.a = DoubleCheck.lazy(this.servicesProvider);
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2get() {
        return get();
    }

    public HiltRoot_HiltComponents_OfficeSDKGlobalCServiceProvider_Factory(Provider<Map<Class<?>, Provider<Object>>> r1) {
        this.servicesProvider = r1;
    }

    public static HiltRoot_HiltComponents_OfficeSDKGlobalCServiceProvider_Factory create(Provider<Map<Class<?>, Provider<Object>>> r1) {
        return new HiltRoot_HiltComponents_OfficeSDKGlobalCServiceProvider_Factory(r1);
    }
}
