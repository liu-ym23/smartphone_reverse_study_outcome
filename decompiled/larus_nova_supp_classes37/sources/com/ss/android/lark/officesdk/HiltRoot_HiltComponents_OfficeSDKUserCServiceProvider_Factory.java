package com.ss.android.lark.officesdk;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class HiltRoot_HiltComponents_OfficeSDKUserCServiceProvider_Factory implements Factory<t0> {
    private final Provider<Map<Class<?>, Provider<Object>>> servicesProvider;

    public static t0 newInstance() {
        return new t0();
    }

    public t0 get() {
        t0 r0 = newInstance();
        r0.a = DoubleCheck.lazy(this.servicesProvider);
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3get() {
        return get();
    }

    public HiltRoot_HiltComponents_OfficeSDKUserCServiceProvider_Factory(Provider<Map<Class<?>, Provider<Object>>> r1) {
        this.servicesProvider = r1;
    }

    public static HiltRoot_HiltComponents_OfficeSDKUserCServiceProvider_Factory create(Provider<Map<Class<?>, Provider<Object>>> r1) {
        return new HiltRoot_HiltComponents_OfficeSDKUserCServiceProvider_Factory(r1);
    }
}
