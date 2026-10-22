package e0c;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements DwarfViewModelFactories.FactoryFactoryCollector {
    public final Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> a;

    public final DwarfViewModelFactories.DwarfInternalFactoryFactory getDwarfInternalFactoryFactory() {
        return (DwarfViewModelFactories.DwarfInternalFactoryFactory) this.a.get();
    }

    @Inject
    public d(Provider<DwarfViewModelFactories.DwarfInternalFactoryFactory> r1) {
        this.a = r1;
    }
}
