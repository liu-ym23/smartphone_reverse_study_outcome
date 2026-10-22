package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmOverloads;
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

/* JADX INFO: loaded from: classes3.dex */
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

    @JvmOverloads
    public ModuleDescriptorImpl(Name r11, StorageManager r12, KotlinBuiltIns r13, TargetPlatform r14) {
        Intrinsics.checkNotNullParameter(r11, "moduleName");
        Intrinsics.checkNotNullParameter(r12, "storageManager");
        Intrinsics.checkNotNullParameter(r13, "builtIns");
        this(r11, r12, r13, r14, null, null, 48, null);
    }

    @JvmOverloads
    public ModuleDescriptorImpl(Name r10, StorageManager r11, KotlinBuiltIns r12, TargetPlatform r13, Map<ModuleCapability<?>, ? extends Object> r14, Name r15) {
        Intrinsics.checkNotNullParameter(r10, "moduleName");
        Intrinsics.checkNotNullParameter(r11, "storageManager");
        Intrinsics.checkNotNullParameter(r12, "builtIns");
        Intrinsics.checkNotNullParameter(r14, "capabilities");
        super(Annotations.Companion.getEMPTY(), r10);
        this.storageManager = r11;
        this.builtIns = r12;
        this.platform = r13;
        this.stableName = r15;
        if (r10.isSpecial() == false) goto L10;
        this.capabilities = r14;
        PackageViewDescriptorFactory r16 = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
        if (r16 != null) goto L7;
        r16 = PackageViewDescriptorFactory.Default.INSTANCE;
    L7:
        this.packageViewDescriptorFactory = r16;
        this.isValid = true;
        this.packages = r11.createMemoizedFunction(new ModuleDescriptorImpl$packages$1(this));
        this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy(new ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(this));
        return;
    L10:
        throw new IllegalArgumentException("Module name must be special: " + r10);
    }

    public /* synthetic */ ModuleDescriptorImpl(Name r10, StorageManager r11, KotlinBuiltIns r12, TargetPlatform r13, Map r14, Name r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 8) == 0) goto L5;
        TargetPlatform r18 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        Map r19 = MapsKt.emptyMap();
    L11:
        if ((r16 & 32) == 0) goto L13;
        Name r20 = null;
    L14:
        this(r10, r11, r12, r18, r19, r20);
        return;
    L13:
        r20 = r15;
        goto L14
    L9:
        r19 = r14;
        goto L11
    L5:
        r18 = r13;
        goto L7
    }

    public static final /* synthetic */ ModuleDependencies access$getDependencies$p(ModuleDescriptorImpl r10) {
        return r10.dependencies;
    }

    public static final /* synthetic */ String access$getId(ModuleDescriptorImpl r10) {
        return r10.getId();
    }

    public static final /* synthetic */ PackageFragmentProvider access$getPackageFragmentProviderForModuleContent$p(ModuleDescriptorImpl r10) {
        return r10.packageFragmentProviderForModuleContent;
    }

    public static final /* synthetic */ PackageViewDescriptorFactory access$getPackageViewDescriptorFactory$p(ModuleDescriptorImpl r10) {
        return r10.packageViewDescriptorFactory;
    }

    public static final /* synthetic */ StorageManager access$getStorageManager$p(ModuleDescriptorImpl r10) {
        return r10.storageManager;
    }

    public static final /* synthetic */ boolean access$isInitialized(ModuleDescriptorImpl r10) {
        return r10.isInitialized();
    }

    private final String getId() {
        String r10 = getName().toString();
        Intrinsics.checkNotNullExpressionValue(r10, "name.toString()");
        return r10;
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r10, D r11) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, r10, r11);
    }

    public void assertValid() {
        if (isValid() == true) goto L6;
        InvalidModuleExceptionKt.moduleInvalidated(this);
        return;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public <T> T getCapability(ModuleCapability<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "capability");
        T r11 = (T) this.capabilities.get(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies r10 = this.dependencies;
        if (r10 == null) goto L7;
        return r10.getDirectExpectedByDependencies();
    L7:
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public PackageViewDescriptor getPackage(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        assertValid();
        return this.packages.invoke(r10);
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public Collection<FqName> getSubPackagesOf(FqName r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(r10, r11);
    }

    public final void initialize(PackageFragmentProvider r10) {
        Intrinsics.checkNotNullParameter(r10, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = r10;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public final void setDependencies(List<ModuleDescriptorImpl> r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptors");
        setDependencies(r10, SetsKt.emptySet());
    }

    public final void setDependencies(List<ModuleDescriptorImpl> r10, Set<ModuleDescriptorImpl> r11) {
        Intrinsics.checkNotNullParameter(r10, "descriptors");
        Intrinsics.checkNotNullParameter(r11, "friends");
        setDependencies(new ModuleDependenciesImpl(r10, r11, CollectionsKt.emptyList(), SetsKt.emptySet()));
    }

    public final void setDependencies(ModuleDependencies r10) {
        Intrinsics.checkNotNullParameter(r10, "dependencies");
        this.dependencies = r10;
    }

    public final void setDependencies(ModuleDescriptorImpl... r10) {
        Intrinsics.checkNotNullParameter(r10, "descriptors");
        setDependencies(ArraysKt.toList(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "targetModule");
        if (Intrinsics.areEqual(this, r10) == false) goto L5;
        return true;
    L5:
        ModuleDependencies r11 = this.dependencies;
        Intrinsics.checkNotNull(r11);
        if (CollectionsKt.contains(r11.getModulesWhoseInternalsAreVisible(), r10) == false) goto L9;
        return true;
    L9:
        if (getExpectedByModules().contains(r10) == false) goto L12;
        return true;
    L12:
        if (r10.getExpectedByModules().contains(this) == false) goto L14;
        return true;
    L14:
        return false;
    }
}
