package com.ss.android.lark.officesdk.container;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKUserComponent_FactoryFactoryCollector_Factory implements Factory<OfficeSDKUserComponent_FactoryFactoryCollector> {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factoryProvider;

    public OfficeSDKUserComponent_FactoryFactoryCollector get() {
        return newInstance(this.factoryProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m45get() {
        return get();
    }

    public OfficeSDKUserComponent_FactoryFactoryCollector_Factory(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        this.factoryProvider = r1;
    }

    public static OfficeSDKUserComponent_FactoryFactoryCollector_Factory create(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        return new OfficeSDKUserComponent_FactoryFactoryCollector_Factory(r1);
    }

    public static OfficeSDKUserComponent_FactoryFactoryCollector newInstance(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        return new OfficeSDKUserComponent_FactoryFactoryCollector(r1);
    }
}
