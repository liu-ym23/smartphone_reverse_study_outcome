package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeEnhancementKt {
    private static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS = null;
    private static final EnhancedTypeAnnotations ENHANCED_NULLABILITY_ANNOTATIONS = null;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[NullabilityQualifier.values().length];
            r10[NullabilityQualifier.NULLABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[NullabilityQualifier.NOT_NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        FqName r10 = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(r10, "ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(r10);
        FqName r11 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(r11, "ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(r11);
    }

    public static final /* synthetic */ Annotations access$compositeAnnotationsOrSingle(List r10) {
        return compositeAnnotationsOrSingle(r10);
    }

    public static final /* synthetic */ ClassifierDescriptor access$enhanceMutability(ClassifierDescriptor r10, JavaTypeQualifiers r11, TypeComponentPosition r12) {
        return enhanceMutability(r10, r11, r12);
    }

    public static final /* synthetic */ EnhancedTypeAnnotations access$getENHANCED_MUTABILITY_ANNOTATIONS$p() {
        return ENHANCED_MUTABILITY_ANNOTATIONS;
    }

    public static final /* synthetic */ EnhancedTypeAnnotations access$getENHANCED_NULLABILITY_ANNOTATIONS$p() {
        return ENHANCED_NULLABILITY_ANNOTATIONS;
    }

    public static final /* synthetic */ Boolean access$getEnhancedNullability(JavaTypeQualifiers r10, TypeComponentPosition r11) {
        return getEnhancedNullability(r10, r11);
    }

    private static final Annotations compositeAnnotationsOrSingle(List<? extends Annotations> r10) {
        int r11 = r10.size();
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L8;
        return new CompositeAnnotations(CollectionsKt.toList(r10));
    L8:
        return (Annotations) CollectionsKt.single(r10);
    L10:
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    private static final ClassifierDescriptor enhanceMutability(ClassifierDescriptor r10, JavaTypeQualifiers r11, TypeComponentPosition r12) {
        JavaToKotlinClassMapper r13 = JavaToKotlinClassMapper.INSTANCE;
        if (TypeComponentPositionKt.shouldEnhance(r12) == true) goto L6;
        return null;
    L6:
        if ((r10 instanceof ClassDescriptor) == true) goto L9;
        return null;
    L9:
        if (r11.getMutability() != MutabilityQualifier.READ_ONLY) goto L16;
        if (r12 != TypeComponentPosition.FLEXIBLE_LOWER) goto L16;
        ClassDescriptor r14 = (ClassDescriptor) r10;
        if (r13.isMutable(r14) == false) goto L16;
        return r13.convertMutableToReadOnly(r14);
    L16:
        if (r11.getMutability() == MutabilityQualifier.MUTABLE) goto L18;
        return null;
    L18:
        if (r12 != TypeComponentPosition.FLEXIBLE_UPPER) goto L25;
        ClassDescriptor r15 = (ClassDescriptor) r10;
        if (r13.isReadOnly(r15) == true) goto L22;
        return null;
    L22:
        return r13.convertReadOnlyToMutable(r15);
    L25:
        return null;
    }

    private static final Boolean getEnhancedNullability(JavaTypeQualifiers r10, TypeComponentPosition r11) {
        if (TypeComponentPositionKt.shouldEnhance(r11) == true) goto L5;
        return null;
    L5:
        NullabilityQualifier r12 = r10.getNullability();
        if (r12 != null) goto L8;
        int r13 = -1;
    L10:
        if (r13 == 1) goto L16;
        if (r13 == 2) goto L17;
        return null;
    L17:
        return Boolean.FALSE;
    L16:
        return Boolean.TRUE;
    L8:
        r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        goto L10
    }

    public static final boolean hasEnhancedNullability(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return TypeEnhancementUtilsKt.hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, r10);
    }
}
