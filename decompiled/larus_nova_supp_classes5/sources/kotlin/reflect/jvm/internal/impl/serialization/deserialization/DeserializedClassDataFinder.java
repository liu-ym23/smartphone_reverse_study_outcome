package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    private final PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(PackageFragmentProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "packageFragmentProvider");
        this.packageFragmentProvider = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r4) {
        Intrinsics.checkNotNullParameter(r4, "classId");
        Iterator<PackageFragmentDescriptor> r0 = PackageFragmentProviderKt.packageFragments(this.packageFragmentProvider, r4.getPackageFqName()).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        PackageFragmentDescriptor r1 = r0.next();
        if ((r1 instanceof DeserializedPackageFragment) == false) goto L4;
        ClassData r2 = ((DeserializedPackageFragment) r1).getClassDataFinder().findClassData(r4);
        if (r2 == null) goto L4;
        return r2;
    L10:
        return null;
    }
}
