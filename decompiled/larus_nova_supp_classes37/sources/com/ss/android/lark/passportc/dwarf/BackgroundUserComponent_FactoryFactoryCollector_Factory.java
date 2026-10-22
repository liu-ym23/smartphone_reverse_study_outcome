package com.ss.android.lark.passportc.dwarf;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.internal.Factory;
import e0c.d;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BackgroundUserComponent_FactoryFactoryCollector_Factory implements Factory<d> {
    private final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> factoryProvider;

    public d get() {
        return newInstance(this.factoryProvider);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m698get() {
        return get();
    }

    public BackgroundUserComponent_FactoryFactoryCollector_Factory(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        this.factoryProvider = r1;
    }

    public static BackgroundUserComponent_FactoryFactoryCollector_Factory create(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        return new BackgroundUserComponent_FactoryFactoryCollector_Factory(r1);
    }

    public static d newInstance(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        return new d(r1);
    }
}
