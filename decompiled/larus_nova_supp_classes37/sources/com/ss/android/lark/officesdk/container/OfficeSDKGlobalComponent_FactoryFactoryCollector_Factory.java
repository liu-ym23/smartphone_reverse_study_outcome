package com.ss.android.lark.officesdk.container;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKGlobalComponent_FactoryFactoryCollector_Factory implements Factory<OfficeSDKGlobalComponent_FactoryFactoryCollector> {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factoryProvider;

    public OfficeSDKGlobalComponent_FactoryFactoryCollector get() {
        return newInstance(this.factoryProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m40get() {
        return get();
    }

    public OfficeSDKGlobalComponent_FactoryFactoryCollector_Factory(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        this.factoryProvider = r1;
    }

    public static OfficeSDKGlobalComponent_FactoryFactoryCollector_Factory create(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        return new OfficeSDKGlobalComponent_FactoryFactoryCollector_Factory(r1);
    }

    public static OfficeSDKGlobalComponent_FactoryFactoryCollector newInstance(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        return new OfficeSDKGlobalComponent_FactoryFactoryCollector(r1);
    }
}
