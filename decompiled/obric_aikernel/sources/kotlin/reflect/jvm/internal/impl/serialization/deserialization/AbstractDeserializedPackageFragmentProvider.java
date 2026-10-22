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

    public AbstractDeserializedPackageFragmentProvider(StorageManager r10, KotlinMetadataFinder r11, ModuleDescriptor r12) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "finder");
        Intrinsics.checkNotNullParameter(r12, "moduleDescriptor");
        this.storageManager = r10;
        this.finder = r11;
        this.moduleDescriptor = r12;
        this.fragments = r10.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r10, Collection<PackageFragmentDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "packageFragments");
        CollectionsKt.addIfNotNull(r11, this.fragments.invoke(r10));
    }

    protected abstract DeserializedPackageFragment findPackage(FqName r10);

    protected final DeserializationComponents getComponents() {
        DeserializationComponents r10 = this.components;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    protected final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    protected final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(this.fragments.invoke(r10));
    }

    protected final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        if (this.fragments.isComputed(r10) == false) goto L5;
        PackageFragmentDescriptor r11 = this.fragments.invoke(r10);
    L6:
        if (r11 != null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r11 = findPackage(r10);
        goto L6
    }

    protected final void setComponents(DeserializationComponents r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.components = r10;
    }
}
