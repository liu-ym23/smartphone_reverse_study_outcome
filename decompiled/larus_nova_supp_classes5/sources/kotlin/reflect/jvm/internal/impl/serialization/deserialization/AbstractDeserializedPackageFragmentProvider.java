package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    protected DeserializationComponents components;
    private final KotlinMetadataFinder finder;
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
    private final ModuleDescriptor moduleDescriptor;
    private final StorageManager storageManager;

    public static /* synthetic */ PackageFragmentDescriptor accessor$AbstractDeserializedPackageFragmentProvider$lambda0(AbstractDeserializedPackageFragmentProvider r0, FqName r1) {
        return fragments$lambda$1(r0, r1);
    }

    public abstract DeserializedPackageFragment findPackage(FqName r1);

    public final DeserializationComponents getComponents() {
        DeserializationComponents r0 = this.components;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    public final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return CollectionsKt.listOfNotNull(this.fragments.invoke(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if (this.fragments.isComputed(r2) == false) goto L5;
        PackageFragmentDescriptor r3 = (PackageFragmentDescriptor) this.fragments.invoke(r2);
    L6:
        if (r3 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r3 = findPackage(r2);
        goto L6
    }

    public final void setComponents(DeserializationComponents r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.components = r2;
    }

    private static final PackageFragmentDescriptor fragments$lambda$1(AbstractDeserializedPackageFragmentProvider r1, FqName r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "fqName");
        DeserializedPackageFragment r3 = r1.findPackage(r2);
        if (r3 == null) goto L5;
        r3.initialize(r1.getComponents());
        return r3;
    L5:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r2, Collection<PackageFragmentDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r3, this.fragments.invoke(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName r2, Function1<? super Name, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "nameFilter");
        return SetsKt.emptySet();
    }

    public AbstractDeserializedPackageFragmentProvider(StorageManager r2, KotlinMetadataFinder r3, ModuleDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "finder");
        Intrinsics.checkNotNullParameter(r4, "moduleDescriptor");
        this.storageManager = r2;
        this.finder = r3;
        this.moduleDescriptor = r4;
        this.fragments = r2.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$$Lambda$0(this));
    }
}
