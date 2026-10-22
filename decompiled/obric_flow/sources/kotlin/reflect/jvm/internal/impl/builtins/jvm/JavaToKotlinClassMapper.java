package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJavaToKotlinClassMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaToKotlinClassMapper.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMapper\n*L\n1#1,80:1\n75#1,3:81\n75#1,3:84\n*S KotlinDebug\n*F\n+ 1 JavaToKotlinClassMapper.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMapper\n*L\n59#1:81,3\n65#1:84,3\n*E\n"})
public final class JavaToKotlinClassMapper {
    public static final JavaToKotlinClassMapper INSTANCE = null;

    static {
        INSTANCE = new JavaToKotlinClassMapper();
    }

    private JavaToKotlinClassMapper() {
    }

    public static /* synthetic */ ClassDescriptor mapJavaToKotlin$default(JavaToKotlinClassMapper r5, FqName r10, KotlinBuiltIns r11, Integer r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = null;
    L6:
        return r5.mapJavaToKotlin(r10, r11, r12);
    }

    public final ClassDescriptor convertMutableToReadOnly(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "mutable");
        FqName r10 = JavaToKotlinClassMap.INSTANCE.mutableToReadOnly(DescriptorUtils.getFqName(r5));
        if (r10 == null) goto L7;
        return DescriptorUtilsKt.getBuiltIns(r5).getBuiltInClassByFqName(r10);
    L7:
        throw new IllegalArgumentException("Given class " + r5 + " is not a mutable collection");
    }

    public final ClassDescriptor convertReadOnlyToMutable(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "readOnly");
        FqName r10 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtils.getFqName(r5));
        if (r10 == null) goto L7;
        return DescriptorUtilsKt.getBuiltIns(r5).getBuiltInClassByFqName(r10);
    L7:
        throw new IllegalArgumentException("Given class " + r5 + " is not a read-only collection");
    }

    public final boolean isMutable(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "mutable");
        return JavaToKotlinClassMap.INSTANCE.isMutable(DescriptorUtils.getFqName(r5));
    }

    public final boolean isReadOnly(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "readOnly");
        return JavaToKotlinClassMap.INSTANCE.isReadOnly(DescriptorUtils.getFqName(r5));
    }

    public final ClassDescriptor mapJavaToKotlin(FqName r5, KotlinBuiltIns r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "builtIns");
        if (r11 != null) goto L5;
    L7:
        ClassId r12 = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(r5);
    L8:
        if (r12 != null) goto L12;
        return null;
    L12:
        return r10.getBuiltInClassByFqName(r12.asSingleFqName());
    L5:
        if (Intrinsics.areEqual(r5, JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME()) == false) goto L7;
        r12 = StandardNames.getFunctionClassId(r11.intValue());
        goto L8
    }

    public final Collection<ClassDescriptor> mapPlatformClass(FqName r10, KotlinBuiltIns r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "builtIns");
        ClassDescriptor r12 = mapJavaToKotlin$default(this, r10, r11, null, 4, null);
        if (r12 == null) goto L5;
        FqName r13 = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(r12));
        if (r13 != null) goto L11;
        return SetsKt.setOf(r12);
    L11:
        return CollectionsKt.listOf(new ClassDescriptor[]{r12, r11.getBuiltInClassByFqName(r13)});
    L5:
        return SetsKt.emptySet();
    }
}
