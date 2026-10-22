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

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> r5, Set<ModuleDescriptorImpl> r10, List<ModuleDescriptorImpl> r11, Set<ModuleDescriptorImpl> r12) {
        Intrinsics.checkNotNullParameter(r5, "allDependencies");
        Intrinsics.checkNotNullParameter(r10, "modulesWhoseInternalsAreVisible");
        Intrinsics.checkNotNullParameter(r11, "directExpectedByDependencies");
        Intrinsics.checkNotNullParameter(r12, "allExpectedByDependencies");
        this.allDependencies = r5;
        this.modulesWhoseInternalsAreVisible = r10;
        this.directExpectedByDependencies = r11;
        this.allExpectedByDependencies = r12;
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
