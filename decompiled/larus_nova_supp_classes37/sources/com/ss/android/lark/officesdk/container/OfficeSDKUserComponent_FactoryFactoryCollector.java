package com.ss.android.lark.officesdk.container;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKUserComponent_FactoryFactoryCollector implements DwarfViewModelFactories.FactoryFactoryCollector {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factory;

    public DwarfViewModelFactories.DwarfInternalFactoryFactory getDwarfInternalFactoryFactory() {
        return (DwarfViewModelFactories.DwarfInternalFactoryFactory) this.factory.get();
    }

    @Inject
    public OfficeSDKUserComponent_FactoryFactoryCollector(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        this.factory = r1;
    }
}
