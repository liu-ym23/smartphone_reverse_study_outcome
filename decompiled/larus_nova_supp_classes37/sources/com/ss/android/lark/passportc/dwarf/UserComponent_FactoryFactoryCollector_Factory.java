package com.ss.android.lark.passportc.dwarf;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.internal.Factory;
import e0c.o;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserComponent_FactoryFactoryCollector_Factory implements Factory<o> {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factoryProvider;

    public o get() {
        return newInstance(this.factoryProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m700get() {
        return get();
    }

    public UserComponent_FactoryFactoryCollector_Factory(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        this.factoryProvider = r1;
    }

    public static UserComponent_FactoryFactoryCollector_Factory create(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        return new UserComponent_FactoryFactoryCollector_Factory(r1);
    }

    public static o newInstance(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        return new o(r1);
    }
}
