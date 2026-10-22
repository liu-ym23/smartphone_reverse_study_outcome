package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JavaToKotlinClassMapper {
    public static final JavaToKotlinClassMapper INSTANCE = null;

    static {
        INSTANCE = new JavaToKotlinClassMapper();
    }

    private JavaToKotlinClassMapper() {
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "mutable");
        FqName r0 = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(DescriptorUtils.getFqName(r4));
        if (r0 == null) goto L7;
        return DescriptorUtilsKt.getBuiltIns(r4).getBuiltInClassByFqName(r0);
    L7:
        throw new IllegalArgumentException("Given class " + r4 + " is not a mutable collection");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "readOnly");
        FqName r0 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqName(r4));
        if (r0 == null) goto L7;
        return DescriptorUtilsKt.getBuiltIns(r4).getBuiltInClassByFqName(r0);
    L7:
        throw new IllegalArgumentException("Given class " + r4 + " is not a read-only collection");
    }

    public final boolean isMutable(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "mutable");
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(r2));
    }

    public final boolean isReadOnly(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(r2));
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName r8, KotlinBuiltIns r9) {
        Intrinsics.checkNotNullParameter(r8, "fqName");
        Intrinsics.checkNotNullParameter(r9, "builtIns");
        ClassDescriptor r10 = mapJavaToKotlin$default(this, r8, r9, null, 4, null);
        if (r10 == null) goto L5;
        FqName r0 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(r10));
        if (r0 != null) goto L11;
        return SetsKt.setOf(r10);
    L11:
        return CollectionsKt.listOf(new ClassDescriptor[]{r10, r9.getBuiltInClassByFqName(r0)});
    L5:
        return SetsKt.emptySet();
    }

    public final ClassDescriptor mapJavaToKotlin(FqName r2, KotlinBuiltIns r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        Intrinsics.checkNotNullParameter(r3, "builtIns");
        if (r4 != null) goto L5;
    L7:
        ClassId r5 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(r2);
    L8:
        if (r5 != null) goto L12;
        return null;
    L12:
        return r3.getBuiltInClassByFqName(r5.asSingleFqName());
    L5:
        if (Intrinsics.areEqual(r2, JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME()) == false) goto L7;
        r5 = StandardNames.getFunctionClassId(r4.intValue());
        goto L8
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper r0, FqName r1, KotlinBuiltIns r2, Integer r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.mapJavaToKotlin(r1, r2, r3);
    }
}
