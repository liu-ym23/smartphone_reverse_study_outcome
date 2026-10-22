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
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositePackageFragmentProvider implements PackageFragmentProviderOptimized {
    private final String debugName;
    private final List<PackageFragmentProvider> providers;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "providers");
        Intrinsics.checkNotNullParameter(r11, "debugName");
        this.providers = r10;
        this.debugName = r11;
        r10.size();
        CollectionsKt.toSet(r10).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r10, Collection<PackageFragmentDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "packageFragments");
        Iterator<PackageFragmentProvider> r12 = this.providers.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(r12.next(), r10, r11);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        ArrayList r11 = new ArrayList();
        Iterator<PackageFragmentProvider> r12 = this.providers.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(r12.next(), r10, r11);
        goto L4
    L7:
        return CollectionsKt.toList(r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        HashSet r12 = new HashSet();
        Iterator<PackageFragmentProvider> r13 = this.providers.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.addAll(r13.next().getSubPackagesOf(r10, r11));
        goto L4
    L6:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        List<PackageFragmentProvider> r11 = this.providers;
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        if (PackageFragmentProviderKt.isEmpty((PackageFragmentProvider) r12.next(), r10) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return true;
    }

    public String toString() {
        return this.debugName;
    }
}
