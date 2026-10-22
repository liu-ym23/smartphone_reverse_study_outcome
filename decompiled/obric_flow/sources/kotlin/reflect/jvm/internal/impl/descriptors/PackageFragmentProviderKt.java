package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class PackageFragmentProviderKt {
    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider r5, FqName r10, Collection<PackageFragmentDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "packageFragments");
        if ((r5 instanceof PackageFragmentProviderOptimized) == false) goto L5;
        ((PackageFragmentProviderOptimized) r5).collectPackageFragments(r10, r11);
        return;
    L5:
        r11.addAll(r5.getPackageFragments(r10));
    }

    public static final boolean isEmpty(PackageFragmentProvider r5, FqName r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "fqName");
        if ((r5 instanceof PackageFragmentProviderOptimized) == false) goto L6;
        return ((PackageFragmentProviderOptimized) r5).isEmpty(r10);
    L6:
        return packageFragments(r5, r10).isEmpty();
    }

    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider r5, FqName r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "fqName");
        ArrayList r11 = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(r5, r10, r11);
        return r11;
    }
}
