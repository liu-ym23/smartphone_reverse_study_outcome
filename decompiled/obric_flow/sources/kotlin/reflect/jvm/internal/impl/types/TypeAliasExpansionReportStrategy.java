package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeAliasExpansionReportStrategy {

    public static final class DO_NOTHING implements TypeAliasExpansionReportStrategy {
        public static final DO_NOTHING INSTANCE = null;

        static {
            INSTANCE = new DO_NOTHING();
        }

        private DO_NOTHING() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(TypeSubstitutor r5, KotlinType r10, KotlinType r11, TypeParameterDescriptor r12) {
            Intrinsics.checkNotNullParameter(r5, "substitutor");
            Intrinsics.checkNotNullParameter(r10, "unsubstitutedArgument");
            Intrinsics.checkNotNullParameter(r11, "argument");
            Intrinsics.checkNotNullParameter(r12, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void conflictingProjection(TypeAliasDescriptor r5, TypeParameterDescriptor r10, KotlinType r11) {
            Intrinsics.checkNotNullParameter(r5, "typeAlias");
            Intrinsics.checkNotNullParameter(r11, "substitutedArgument");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(TypeAliasDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(AnnotationDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
        }
    }

    void boundsViolationInSubstitution(TypeSubstitutor r5, KotlinType r10, KotlinType r11, TypeParameterDescriptor r12);

    void conflictingProjection(TypeAliasDescriptor r5, TypeParameterDescriptor r10, KotlinType r11);

    void recursiveTypeAlias(TypeAliasDescriptor r5);

    void repeatedAnnotation(AnnotationDescriptor r5);
}
