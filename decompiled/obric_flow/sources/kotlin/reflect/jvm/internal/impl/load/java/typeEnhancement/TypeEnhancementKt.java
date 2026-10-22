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
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeEnhancementKt {
    private static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS = null;
    private static final Annotations ENHANCED_NULLABILITY_ANNOTATIONS = null;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[NullabilityQualifier.values().length];
            r5[NullabilityQualifier.NULLABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[NullabilityQualifier.NOT_NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION);
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION);
    }

    public static final /* synthetic */ Annotations access$compositeAnnotationsOrSingle(List r5) {
        return compositeAnnotationsOrSingle(r5);
    }

    public static final /* synthetic */ ClassifierDescriptor access$enhanceMutability(ClassifierDescriptor r5, JavaTypeQualifiers r10, TypeComponentPosition r11) {
        return enhanceMutability(r5, r10, r11);
    }

    public static final /* synthetic */ EnhancedTypeAnnotations access$getENHANCED_MUTABILITY_ANNOTATIONS$p() {
        return ENHANCED_MUTABILITY_ANNOTATIONS;
    }

    public static final /* synthetic */ Boolean access$getEnhancedNullability(JavaTypeQualifiers r5, TypeComponentPosition r10) {
        return getEnhancedNullability(r5, r10);
    }

    private static final Annotations compositeAnnotationsOrSingle(List<? extends Annotations> r5) {
        int r10 = r5.size();
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L8;
        return new CompositeAnnotations(CollectionsKt.toList(r5));
    L8:
        return (Annotations) CollectionsKt.single(r5);
    L10:
        throw new IllegalStateException("At least one Annotations object expected");
    }

    private static final ClassifierDescriptor enhanceMutability(ClassifierDescriptor r5, JavaTypeQualifiers r10, TypeComponentPosition r11) {
        JavaToKotlinClassMapper r12 = JavaToKotlinClassMapper.INSTANCE;
        if (TypeComponentPositionKt.shouldEnhance(r11) == true) goto L6;
        return null;
    L6:
        if ((r5 instanceof ClassDescriptor) == true) goto L9;
        return null;
    L9:
        if (r10.getMutability() != MutabilityQualifier.READ_ONLY) goto L16;
        if (r11 != TypeComponentPosition.FLEXIBLE_LOWER) goto L16;
        ClassDescriptor r13 = (ClassDescriptor) r5;
        if (r12.isMutable(r13) == false) goto L16;
        return r12.convertMutableToReadOnly(r13);
    L16:
        if (r10.getMutability() == MutabilityQualifier.MUTABLE) goto L18;
        return null;
    L18:
        if (r11 != TypeComponentPosition.FLEXIBLE_UPPER) goto L25;
        ClassDescriptor r14 = (ClassDescriptor) r5;
        if (r12.isReadOnly(r14) == true) goto L22;
        return null;
    L22:
        return r12.convertReadOnlyToMutable(r14);
    L25:
        return null;
    }

    public static final Annotations getENHANCED_NULLABILITY_ANNOTATIONS() {
        return ENHANCED_NULLABILITY_ANNOTATIONS;
    }

    private static final Boolean getEnhancedNullability(JavaTypeQualifiers r5, TypeComponentPosition r10) {
        if (TypeComponentPositionKt.shouldEnhance(r10) == true) goto L5;
        return null;
    L5:
        NullabilityQualifier r11 = r5.getNullability();
        if (r11 != null) goto L8;
        int r12 = -1;
    L10:
        if (r12 == 1) goto L16;
        if (r12 == 2) goto L17;
        return null;
    L17:
        return Boolean.FALSE;
    L16:
        return Boolean.TRUE;
    L8:
        r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        goto L10
    }

    public static final boolean hasEnhancedNullability(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return TypeEnhancementUtilsKt.hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, r5);
    }
}
