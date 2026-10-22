package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
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
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    protected DeserializationComponents components;
    private final KotlinMetadataFinder finder;
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
    private final ModuleDescriptor moduleDescriptor;
    private final StorageManager storageManager;

    public AbstractDeserializedPackageFragmentProvider(StorageManager r5, KotlinMetadataFinder r10, ModuleDescriptor r11) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        Intrinsics.checkNotNullParameter(r10, "finder");
        Intrinsics.checkNotNullParameter(r11, "moduleDescriptor");
        this.storageManager = r5;
        this.finder = r10;
        this.moduleDescriptor = r11;
        this.fragments = r5.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r5, Collection<PackageFragmentDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "packageFragments");
        CollectionsKt.addIfNotNull(r10, this.fragments.invoke(r5));
    }

    public abstract DeserializedPackageFragment findPackage(FqName r5);

    public final DeserializationComponents getComponents() {
        DeserializationComponents r5 = this.components;
        if (r5 == null) goto L5;
        return r5;
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(this.fragments.invoke(r5));
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        if (this.fragments.isComputed(r5) == false) goto L5;
        PackageFragmentDescriptor r10 = this.fragments.invoke(r5);
    L6:
        if (r10 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r10 = findPackage(r5);
        goto L6
    }

    public final void setComponents(DeserializationComponents r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.components = r5;
    }
}
