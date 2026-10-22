package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ModuleDependenciesImpl implements ModuleDependencies {
    private final List<ModuleDescriptorImpl> allDependencies;
    private final Set<ModuleDescriptorImpl> allExpectedByDependencies;
    private final List<ModuleDescriptorImpl> directExpectedByDependencies;
    private final Set<ModuleDescriptorImpl> modulesWhoseInternalsAreVisible;

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> r10, Set<ModuleDescriptorImpl> r11, List<ModuleDescriptorImpl> r12, Set<ModuleDescriptorImpl> r13) {
        Intrinsics.checkNotNullParameter(r10, "allDependencies");
        Intrinsics.checkNotNullParameter(r11, "modulesWhoseInternalsAreVisible");
        Intrinsics.checkNotNullParameter(r12, "directExpectedByDependencies");
        Intrinsics.checkNotNullParameter(r13, "allExpectedByDependencies");
        this.allDependencies = r10;
        this.modulesWhoseInternalsAreVisible = r11;
        this.directExpectedByDependencies = r12;
        this.allExpectedByDependencies = r13;
    }

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
}
