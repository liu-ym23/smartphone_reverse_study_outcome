package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleExceptionKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    private final KotlinBuiltIns builtIns;
    private final Map<ModuleCapability<?>, Object> capabilities;
    private ModuleDependencies dependencies;
    private boolean isValid;
    private PackageFragmentProvider packageFragmentProviderForModuleContent;
    private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    private final PackageViewDescriptorFactory packageViewDescriptorFactory;
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    private final TargetPlatform platform;
    private final Name stableName;
    private final StorageManager storageManager;

    public ModuleDescriptorImpl(Name r11, StorageManager r12, KotlinBuiltIns r13, TargetPlatform r14) {
        Intrinsics.checkNotNullParameter(r11, "moduleName");
        Intrinsics.checkNotNullParameter(r12, "storageManager");
        Intrinsics.checkNotNullParameter(r13, "builtIns");
        this(r11, r12, r13, r14, null, null, 48, null);
    }

    public static /* synthetic */ PackageViewDescriptor accessor$ModuleDescriptorImpl$lambda0(ModuleDescriptorImpl r0, FqName r1) {
        return packages$lambda$0(r0, r1);
    }

    public static /* synthetic */ CompositePackageFragmentProvider accessor$ModuleDescriptorImpl$lambda1(ModuleDescriptorImpl r0) {
        return packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(r0);
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    private final boolean isInitialized() {
        if (this.packageFragmentProviderForModuleContent == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies r0 = this.dependencies;
        if (r0 == null) goto L7;
        return r0.getDirectExpectedByDependencies();
    L7:
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        if (isValid() == true) goto L5;
        r0.append(" !isValid");
    L5:
        r0.append(" packageFragmentProvider: ");
        PackageFragmentProvider r1 = this.packageFragmentProviderForModuleContent;
        if (r1 == null) goto L8;
        String r2 = r1.getClass().getSimpleName();
    L9:
        r0.append(r2);
        return r0.toString();
    L8:
        r2 = null;
        goto L9
    }

    private final String getId() {
        return getName().toString();
    }

    public void assertValid() {
        if (isValid() == true) goto L6;
        InvalidModuleExceptionKt.moduleInvalidated(this);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    public boolean isValid() {
        return this.isValid;
    }

    private static final CompositePackageFragmentProvider packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(ModuleDescriptorImpl r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        ModuleDependencies r0 = r3.dependencies;
        if (r0 == null) goto L15;
        List<ModuleDescriptorImpl> r1 = r0.getAllDependencies();
        r3.assertValid();
        r1.contains(r3);
        List<ModuleDescriptorImpl> r2 = r1;
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        ((ModuleDescriptorImpl) r4.next()).isInitialized();
        goto L6
    L8:
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r6 = r2.iterator();
    L10:
        if (r6.hasNext() == false) goto L13;
        PackageFragmentProvider r7 = ((ModuleDescriptorImpl) r6.next()).packageFragmentProviderForModuleContent;
        Intrinsics.checkNotNull(r7);
        r5.add(r7);
        goto L10
    L13:
        return new CompositePackageFragmentProvider(r5, "CompositeProvider@ModuleDescriptor for " + r3.getName());
    L15:
        throw new AssertionError("Dependencies of module " + r3.getId() + " were not set before querying module content");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public <T> T getCapability(ModuleCapability<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "capability");
        T r3 = (T) this.capabilities.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public PackageViewDescriptor getPackage(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        assertValid();
        return (PackageViewDescriptor) this.packages.invoke(r2);
    }

    public final void initialize(PackageFragmentProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = r2;
    }

    public final void setDependencies(List<ModuleDescriptorImpl> r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptors");
        setDependencies(r2, SetsKt.emptySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(ModuleDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "targetModule");
        if (Intrinsics.areEqual(this, r3) == false) goto L5;
        return true;
    L5:
        ModuleDependencies r0 = this.dependencies;
        Intrinsics.checkNotNull(r0);
        if (CollectionsKt.contains(r0.getModulesWhoseInternalsAreVisible(), r3) == false) goto L9;
        return true;
    L9:
        if (getExpectedByModules().contains(r3) == false) goto L12;
        return true;
    L12:
        if (r3.getExpectedByModules().contains(this) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final void setDependencies(ModuleDescriptorImpl... r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptors");
        setDependencies(ArraysKt.toList(r2));
    }

    public final void setDependencies(ModuleDependencies r2) {
        Intrinsics.checkNotNullParameter(r2, "dependencies");
        this.dependencies = r2;
    }

    private static final PackageViewDescriptor packages$lambda$0(ModuleDescriptorImpl r2, FqName r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "fqName");
        return r2.packageViewDescriptorFactory.compute(r2, r3, r2.storageManager);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r1, D r2) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public Collection<FqName> getSubPackagesOf(FqName r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(r2, r3);
    }

    public final void setDependencies(List<ModuleDescriptorImpl> r4, Set<ModuleDescriptorImpl> r5) {
        Intrinsics.checkNotNullParameter(r4, "descriptors");
        Intrinsics.checkNotNullParameter(r5, "friends");
        setDependencies(new ModuleDependenciesImpl(r4, r5, CollectionsKt.emptyList(), SetsKt.emptySet()));
    }

    public ModuleDescriptorImpl(Name r2, StorageManager r3, KotlinBuiltIns r4, TargetPlatform r5, Map<ModuleCapability<?>, ? extends Object> r6, Name r7) {
        Intrinsics.checkNotNullParameter(r2, "moduleName");
        Intrinsics.checkNotNullParameter(r3, "storageManager");
        Intrinsics.checkNotNullParameter(r4, "builtIns");
        Intrinsics.checkNotNullParameter(r6, "capabilities");
        super(Annotations.Companion.getEMPTY(), r2);
        this.storageManager = r3;
        this.builtIns = r4;
        this.platform = r5;
        this.stableName = r7;
        if (r2.isSpecial() == false) goto L10;
        this.capabilities = r6;
        PackageViewDescriptorFactory r8 = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
        if (r8 != null) goto L7;
        r8 = PackageViewDescriptorFactory.Default.INSTANCE;
    L7:
        this.packageViewDescriptorFactory = r8;
        this.isValid = true;
        this.packages = r3.createMemoizedFunction(new ModuleDescriptorImpl$$Lambda$0(this));
        this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy(new ModuleDescriptorImpl$$Lambda$1(this));
        return;
    L10:
        throw new IllegalArgumentException("Module name must be special: " + r2);
    }

    public /* synthetic */ ModuleDescriptorImpl(Name r10, StorageManager r11, KotlinBuiltIns r12, TargetPlatform r13, Map r14, Name r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        TargetPlatform r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        Map r7 = MapsKt.emptyMap();
    L11:
        if ((r16 & 32) == 0) goto L13;
        Name r8 = null;
    L14:
        this(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }
}
