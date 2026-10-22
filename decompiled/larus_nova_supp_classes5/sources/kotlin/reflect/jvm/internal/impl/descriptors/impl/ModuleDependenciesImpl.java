package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ModuleDependenciesImpl implements ModuleDependencies {
    private final List<ModuleDescriptorImpl> allDependencies;
    private final Set<ModuleDescriptorImpl> allExpectedByDependencies;
    private final List<ModuleDescriptorImpl> directExpectedByDependencies;
    private final Set<ModuleDescriptorImpl> modulesWhoseInternalsAreVisible;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public List<ModuleDescriptorImpl> getAllDependencies() {
        return this.allDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public List<ModuleDescriptorImpl> getDirectExpectedByDependencies() {
        return this.directExpectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.modulesWhoseInternalsAreVisible;
    }

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> r2, Set<ModuleDescriptorImpl> r3, List<ModuleDescriptorImpl> r4, Set<ModuleDescriptorImpl> r5) {
        Intrinsics.checkNotNullParameter(r2, "allDependencies");
        Intrinsics.checkNotNullParameter(r3, "modulesWhoseInternalsAreVisible");
        Intrinsics.checkNotNullParameter(r4, "directExpectedByDependencies");
        Intrinsics.checkNotNullParameter(r5, "allExpectedByDependencies");
        this.allDependencies = r2;
        this.modulesWhoseInternalsAreVisible = r3;
        this.directExpectedByDependencies = r4;
        this.allExpectedByDependencies = r5;
    }
}
