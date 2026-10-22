package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    private final PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(PackageFragmentProvider r10) {
        Intrinsics.checkNotNullParameter(r10, "packageFragmentProvider");
        this.packageFragmentProvider = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r10) {
        Intrinsics.checkNotNullParameter(r10, "classId");
        PackageFragmentProvider r11 = this.packageFragmentProvider;
        FqName r12 = r10.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(r12, "classId.packageFqName");
        Iterator<PackageFragmentDescriptor> r13 = PackageFragmentProviderKt.packageFragments(r11, r12).iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        PackageFragmentDescriptor r14 = r13.next();
        if ((r14 instanceof DeserializedPackageFragment) == false) goto L4;
        ClassData r15 = ((DeserializedPackageFragment) r14).getClassDataFinder().findClassData(r10);
        if (r15 == null) goto L4;
        return r15;
    L10:
        return null;
    }
}
