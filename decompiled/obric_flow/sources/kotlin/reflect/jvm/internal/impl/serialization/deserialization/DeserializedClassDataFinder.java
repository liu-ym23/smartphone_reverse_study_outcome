package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDeserializedClassDataFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeserializedClassDataFinder.kt\norg/jetbrains/kotlin/serialization/deserialization/DeserializedClassDataFinder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class DeserializedClassDataFinder implements ClassDataFinder {
    private final PackageFragmentProvider packageFragmentProvider;

    public DeserializedClassDataFinder(PackageFragmentProvider r5) {
        Intrinsics.checkNotNullParameter(r5, "packageFragmentProvider");
        this.packageFragmentProvider = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        Iterator<PackageFragmentDescriptor> r10 = PackageFragmentProviderKt.packageFragments(this.packageFragmentProvider, r5.getPackageFqName()).iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        PackageFragmentDescriptor r11 = r10.next();
        if ((r11 instanceof DeserializedPackageFragment) == false) goto L4;
        ClassData r12 = ((DeserializedPackageFragment) r11).getClassDataFinder().findClassData(r5);
        if (r12 == null) goto L4;
        return r12;
    L10:
        return null;
    }
}
