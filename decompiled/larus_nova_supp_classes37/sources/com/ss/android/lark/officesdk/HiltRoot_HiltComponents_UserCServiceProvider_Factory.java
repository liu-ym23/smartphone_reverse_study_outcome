package com.ss.android.lark.officesdk;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class HiltRoot_HiltComponents_UserCServiceProvider_Factory implements Factory<d1> {
    private final Provider<Map<Class<?>, Provider<Object>>> servicesProvider;

    public static d1 newInstance() {
        return new d1();
    }

    public d1 get() {
        d1 r0 = newInstance();
        r0.a = DoubleCheck.lazy(this.servicesProvider);
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m5get() {
        return get();
    }

    public HiltRoot_HiltComponents_UserCServiceProvider_Factory(Provider<Map<Class<?>, Provider<Object>>> r1) {
        this.servicesProvider = r1;
    }

    public static HiltRoot_HiltComponents_UserCServiceProvider_Factory create(Provider<Map<Class<?>, Provider<Object>>> r1) {
        return new HiltRoot_HiltComponents_UserCServiceProvider_Factory(r1);
    }
}
