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
        public void boundsViolationInSubstitution(TypeSubstitutor r10, KotlinType r11, KotlinType r12, TypeParameterDescriptor r13) {
            Intrinsics.checkNotNullParameter(r10, "substitutor");
            Intrinsics.checkNotNullParameter(r11, "unsubstitutedArgument");
            Intrinsics.checkNotNullParameter(r12, "argument");
            Intrinsics.checkNotNullParameter(r13, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void conflictingProjection(TypeAliasDescriptor r10, TypeParameterDescriptor r11, KotlinType r12) {
            Intrinsics.checkNotNullParameter(r10, "typeAlias");
            Intrinsics.checkNotNullParameter(r12, "substitutedArgument");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(TypeAliasDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(AnnotationDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "annotation");
        }
    }

    void boundsViolationInSubstitution(TypeSubstitutor r10, KotlinType r11, KotlinType r12, TypeParameterDescriptor r13);

    void conflictingProjection(TypeAliasDescriptor r10, TypeParameterDescriptor r11, KotlinType r12);

    void recursiveTypeAlias(TypeAliasDescriptor r10);

    void repeatedAnnotation(AnnotationDescriptor r10);
}
