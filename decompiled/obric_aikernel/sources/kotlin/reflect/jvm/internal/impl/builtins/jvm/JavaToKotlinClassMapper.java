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

/* JADX INFO: loaded from: classes3.dex */
public final class JavaToKotlinClassMapper {
    public static final JavaToKotlinClassMapper INSTANCE = null;

    static {
        INSTANCE = new JavaToKotlinClassMapper();
    }

    private JavaToKotlinClassMapper() {
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper r10, FqName r11, KotlinBuiltIns r12, Integer r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = null;
    L6:
        return r10.mapJavaToKotlin(r11, r12, r13);
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "mutable");
        FqName r11 = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(DescriptorUtils.getFqName(r10));
        if (r11 == null) goto L7;
        ClassDescriptor r12 = DescriptorUtilsKt.getBuiltIns(r10).getBuiltInClassByFqName(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        return r12;
    L7:
        throw new IllegalArgumentException("Given class " + r10 + " is not a mutable collection");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "readOnly");
        FqName r11 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqName(r10));
        if (r11 == null) goto L7;
        ClassDescriptor r12 = DescriptorUtilsKt.getBuiltIns(r10).getBuiltInClassByFqName(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        return r12;
    L7:
        throw new IllegalArgumentException("Given class " + r10 + " is not a read-only collection");
    }

    public final boolean isMutable(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "mutable");
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(r10));
    }

    public final boolean isReadOnly(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(r10));
    }

    public final ClassDescriptor mapJavaToKotlin(FqName r10, KotlinBuiltIns r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "builtIns");
        if (r12 != null) goto L5;
    L7:
        ClassId r13 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(r10);
    L8:
        if (r13 != null) goto L12;
        return null;
    L12:
        return r11.getBuiltInClassByFqName(r13.asSingleFqName());
    L5:
        if (Intrinsics.areEqual(r10, JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME()) == false) goto L7;
        r13 = StandardNames.getFunctionClassId(r12.intValue());
        goto L8
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName r10, KotlinBuiltIns r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "builtIns");
        ClassDescriptor r12 = mapJavaToKotlin$default(this, r10, r11, null, 4, null);
        if (r12 == null) goto L5;
        FqName r13 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(r12));
        if (r13 == null) goto L9;
        ClassDescriptor r14 = r11.getBuiltInClassByFqName(r13);
        Intrinsics.checkNotNullExpressionValue(r14, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return CollectionsKt.listOf(new ClassDescriptor[]{r12, r14});
    L9:
        return SetsKt.setOf(r12);
    L5:
        return SetsKt.emptySet();
    }
}
