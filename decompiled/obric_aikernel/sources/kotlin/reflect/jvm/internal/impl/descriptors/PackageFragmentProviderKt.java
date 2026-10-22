package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class PackageFragmentProviderKt {
    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider r10, FqName r11, Collection<PackageFragmentDescriptor> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "fqName");
        Intrinsics.checkNotNullParameter(r12, "packageFragments");
        if ((r10 instanceof PackageFragmentProviderOptimized) == false) goto L5;
        ((PackageFragmentProviderOptimized) r10).collectPackageFragments(r11, r12);
        return;
    L5:
        r12.addAll(r10.getPackageFragments(r11));
    }

    public static final boolean isEmpty(PackageFragmentProvider r10, FqName r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "fqName");
        if ((r10 instanceof PackageFragmentProviderOptimized) == false) goto L6;
        return ((PackageFragmentProviderOptimized) r10).isEmpty(r11);
    L6:
        return packageFragments(r10, r11).isEmpty();
    }

    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider r10, FqName r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "fqName");
        ArrayList r12 = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(r10, r11, r12);
        return r12;
    }
}
