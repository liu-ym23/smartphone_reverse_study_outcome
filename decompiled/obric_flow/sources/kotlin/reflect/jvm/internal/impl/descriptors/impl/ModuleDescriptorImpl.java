package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import ai.j0;
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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nModuleDescriptorImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ModuleDescriptorImpl\n+ 2 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,176:1\n19#2:177\n19#2:181\n19#2:182\n766#3:178\n857#3,2:179\n1#4:183\n*S KotlinDebug\n*F\n+ 1 ModuleDescriptorImpl.kt\norg/jetbrains/kotlin/descriptors/impl/ModuleDescriptorImpl\n*L\n72#1:177\n75#1:181\n78#1:182\n72#1:178\n72#1:179,2\n*E\n"})
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
        Map r10 = null;
        Name r15 = null;
        this(r11, r12, r13, r14, r10, r15, 48, null);
    }

    public static final /* synthetic */ ModuleDependencies access$getDependencies$p(ModuleDescriptorImpl r5) {
        return r5.dependencies;
    }

    public static final /* synthetic */ String access$getId(ModuleDescriptorImpl r5) {
        return r5.getId();
    }

    public static final /* synthetic */ PackageFragmentProvider access$getPackageFragmentProviderForModuleContent$p(ModuleDescriptorImpl r5) {
        return r5.packageFragmentProviderForModuleContent;
    }

    public static final /* synthetic */ PackageViewDescriptorFactory access$getPackageViewDescriptorFactory$p(ModuleDescriptorImpl r5) {
        return r5.packageViewDescriptorFactory;
    }

    public static final /* synthetic */ StorageManager access$getStorageManager$p(ModuleDescriptorImpl r5) {
        return r5.storageManager;
    }

    public static final /* synthetic */ boolean access$isInitialized(ModuleDescriptorImpl r5) {
        return r5.isInitialized();
    }

    private final String getId() {
        return getName().toString();
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
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r5, D r10) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, r5, r10);
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
    public <T> T getCapability(ModuleCapability<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "capability");
        T r10 = (T) this.capabilities.get(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies r5 = this.dependencies;
        if (r5 == null) goto L7;
        return r5.getDirectExpectedByDependencies();
    L7:
        throw new AssertionError(j0.q(new StringBuilder("Dependencies of module "), getId(), " were not set"));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public PackageViewDescriptor getPackage(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        assertValid();
        return this.packages.invoke(r5);
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public Collection<FqName> getSubPackagesOf(FqName r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(r5, r10);
    }

    public final void initialize(PackageFragmentProvider r5) {
        Intrinsics.checkNotNullParameter(r5, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = r5;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public final void setDependencies(ModuleDependencies r5) {
        Intrinsics.checkNotNullParameter(r5, "dependencies");
        this.dependencies = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "targetModule");
        if (Intrinsics.areEqual(this, r5) == false) goto L5;
        return true;
    L5:
        ModuleDependencies r10 = this.dependencies;
        Intrinsics.checkNotNull(r10);
        if (CollectionsKt.contains(r10.getModulesWhoseInternalsAreVisible(), r5) == false) goto L9;
        return true;
    L9:
        if (getExpectedByModules().contains(r5) == false) goto L12;
        return true;
    L12:
        if (r5.getExpectedByModules().contains(this) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        String r5 = super.toString();
        if (isValid() == false) goto L6;
        return r5;
    L6:
        return j0.j(r5, " !isValid");
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

    public final void setDependencies(ModuleDescriptorImpl... r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptors");
        setDependencies(ArraysKt.toList(r5));
    }

    public final void setDependencies(List<ModuleDescriptorImpl> r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptors");
        setDependencies(r5, SetsKt.emptySet());
    }

    @JvmOverloads
    public ModuleDescriptorImpl(Name r5, StorageManager r10, KotlinBuiltIns r11, TargetPlatform r12, Map<ModuleCapability<?>, ? extends Object> r13, Name r14) {
        Intrinsics.checkNotNullParameter(r5, "moduleName");
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "builtIns");
        Intrinsics.checkNotNullParameter(r13, "capabilities");
        super(Annotations.Companion.getEMPTY(), r5);
        this.storageManager = r10;
        this.builtIns = r11;
        this.platform = r12;
        this.stableName = r14;
        if (r5.isSpecial() == false) goto L10;
        this.capabilities = r13;
        PackageViewDescriptorFactory r15 = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
        if (r15 != null) goto L7;
        r15 = PackageViewDescriptorFactory.Default.INSTANCE;
    L7:
        this.packageViewDescriptorFactory = r15;
        this.isValid = true;
        this.packages = r10.createMemoizedFunction(new ModuleDescriptorImpl$packages$1(this));
        this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy(new ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(this));
        return;
    L10:
        throw new IllegalArgumentException("Module name must be special: " + r5);
    }

    public final void setDependencies(List<ModuleDescriptorImpl> r5, Set<ModuleDescriptorImpl> r10) {
        Intrinsics.checkNotNullParameter(r5, "descriptors");
        Intrinsics.checkNotNullParameter(r10, "friends");
        setDependencies(new ModuleDependenciesImpl(r5, r10, CollectionsKt.emptyList(), SetsKt.emptySet()));
    }
}
