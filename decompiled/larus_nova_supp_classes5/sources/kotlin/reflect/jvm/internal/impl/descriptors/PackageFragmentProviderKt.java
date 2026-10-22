package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class PackageFragmentProviderKt {
    public static final boolean isEmpty(PackageFragmentProvider r1, FqName r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if ((r1 instanceof PackageFragmentProviderOptimized) == false) goto L6;
        return ((PackageFragmentProviderOptimized) r1).isEmpty(r2);
    L6:
        return packageFragments(r1, r2).isEmpty();
    }

    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider r1, FqName r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "fqName");
        ArrayList r0 = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(r1, r2, r0);
        return r0;
    }

    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider r1, FqName r2, Collection<PackageFragmentDescriptor> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "packageFragments");
        if ((r1 instanceof PackageFragmentProviderOptimized) == false) goto L5;
        ((PackageFragmentProviderOptimized) r1).collectPackageFragments(r2, r3);
        return;
    L5:
        r3.addAll(r1.getPackageFragments(r2));
    }
}
