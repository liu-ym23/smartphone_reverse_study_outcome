package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/load/java/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,49:1\n1#2:50\n12744#3,2:51\n*S KotlinDebug\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/load/java/UtilsKt\n*L\n47#1:51,2\n*E\n"})
public final class UtilsKt {
    public static final AnnotationDescriptor extractNullabilityAnnotationOnBoundedWildcard(LazyJavaResolverContext r10, JavaWildcardType r11) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "wildcardType");
        if (r11.getBound() == null) goto L17;
        Iterator<AnnotationDescriptor> r12 = new LazyJavaAnnotations(r10, r11, false, 4, null).iterator();
    L6:
        if (r12.hasNext() == false) goto L13;
        AnnotationDescriptor r13 = r12.next();
        AnnotationDescriptor r5 = r13;
        FqName[] r14 = JavaNullabilityAnnotationSettingsKt.getRXJAVA3_ANNOTATIONS();
        int r15 = r14.length;
        int r16 = 0;
    L8:
        if (r16 >= r15) goto L6;
        FqName r17 = r14[r16];
        if (Intrinsics.areEqual(r5.getFqName(), r17) == true) goto L15;
        r16 = r16 + 1;
    L15:
        return r13;
    L13:
        r13 = null;
        goto L15
    L17:
        throw new IllegalArgumentException("Nullability annotations on unbounded wildcards aren't supported");
    }

    public static final boolean hasErasedValueParameters(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "memberDescriptor");
        if ((r5 instanceof FunctionDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), Boolean.TRUE) == false) goto L7;
        return true;
    }

    public static final boolean isJspecifyEnabledInStrictMode(JavaTypeEnhancementState r5) {
        Intrinsics.checkNotNullParameter(r5, "javaTypeEnhancementState");
        if (r5.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) != ReportLevel.STRICT) goto L5;
        return true;
    L5:
        return false;
    }

    public static final DescriptorVisibility toDescriptorVisibility(Visibility r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return JavaDescriptorVisibilities.toDescriptorVisibility(r5);
    }
}
