package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCompositePackageFragmentProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompositePackageFragmentProvider.kt\norg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n1726#2,3:64\n*S KotlinDebug\n*F\n+ 1 CompositePackageFragmentProvider.kt\norg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider\n*L\n51#1:64,3\n*E\n"})
public final class CompositePackageFragmentProvider implements PackageFragmentProviderOptimized {
    private final String debugName;
    private final List<PackageFragmentProvider> providers;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "providers");
        Intrinsics.checkNotNullParameter(r10, "debugName");
        this.providers = r5;
        this.debugName = r10;
        r5.size();
        CollectionsKt.toSet(r5).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r5, Collection<PackageFragmentDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "packageFragments");
        Iterator<PackageFragmentProvider> r11 = this.providers.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(r11.next(), r5, r10);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        ArrayList r10 = new ArrayList();
        Iterator<PackageFragmentProvider> r11 = this.providers.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(r11.next(), r5, r10);
        goto L4
    L7:
        return CollectionsKt.toList(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        HashSet r11 = new HashSet();
        Iterator<PackageFragmentProvider> r12 = this.providers.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.addAll(r12.next().getSubPackagesOf(r5, r10));
        goto L4
    L6:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        List<PackageFragmentProvider> r10 = this.providers;
        if (r10 != null) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if (PackageFragmentProviderKt.isEmpty((PackageFragmentProvider) r11.next(), r5) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return true;
    }

    public String toString() {
        return this.debugName;
    }
}
