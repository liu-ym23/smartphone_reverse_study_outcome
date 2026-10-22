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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CompositePackageFragmentProvider implements PackageFragmentProviderOptimized {
    private final String debugName;
    private final List<PackageFragmentProvider> providers;

    public String toString() {
        return this.debugName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName r4) {
        Intrinsics.checkNotNullParameter(r4, "fqName");
        ArrayList r0 = new ArrayList();
        Iterator<PackageFragmentProvider> r1 = this.providers.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(r1.next(), r4, r0);
        goto L4
    L7:
        return CollectionsKt.toList(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r4) {
        Intrinsics.checkNotNullParameter(r4, "fqName");
        List<PackageFragmentProvider> r0 = this.providers;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (PackageFragmentProviderKt.isEmpty((PackageFragmentProvider) r1.next(), r4) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "providers");
        Intrinsics.checkNotNullParameter(r3, "debugName");
        this.providers = r2;
        this.debugName = r3;
        r2.size();
        CollectionsKt.toSet(r2).size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r3, Collection<PackageFragmentDescriptor> r4) {
        Intrinsics.checkNotNullParameter(r3, "fqName");
        Intrinsics.checkNotNullParameter(r4, "packageFragments");
        Iterator<PackageFragmentProvider> r0 = this.providers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(r0.next(), r3, r4);
        goto L4
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName r4, Function1<? super Name, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "fqName");
        Intrinsics.checkNotNullParameter(r5, "nameFilter");
        HashSet r0 = new HashSet();
        Iterator<PackageFragmentProvider> r1 = this.providers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll(r1.next().getSubPackagesOf(r4, r5));
        goto L4
    L6:
        return r0;
    }
}
