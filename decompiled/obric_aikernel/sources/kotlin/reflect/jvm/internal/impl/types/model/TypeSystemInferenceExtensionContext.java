package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeSystemInferenceExtensionContext extends TypeSystemCommonSuperTypesContext, TypeSystemContext {

    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemInferenceExtensionContext r10, SimpleTypeMarker r11, TypeConstructorMarker r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            Intrinsics.checkNotNullParameter(r12, "constructor");
            return TypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(r10, r11, r12);
        }

        public static TypeArgumentMarker get(TypeSystemInferenceExtensionContext r10, TypeArgumentListMarker r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.get(r10, r11, r12);
        }

        public static TypeArgumentMarker getArgumentOrNull(TypeSystemInferenceExtensionContext r10, SimpleTypeMarker r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.getArgumentOrNull(r10, r11, r12);
        }

        public static boolean hasFlexibleNullability(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.hasFlexibleNullability(r10, r11);
        }

        public static boolean isCapturedType(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.isCapturedType(r10, r11);
        }

        public static boolean isClassType(TypeSystemInferenceExtensionContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.isClassType(r10, r11);
        }

        public static boolean isDefinitelyNotNullType(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.isDefinitelyNotNullType(r10, r11);
        }

        public static boolean isDynamic(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.isDynamic(r10, r11);
        }

        public static boolean isIntegerLiteralType(TypeSystemInferenceExtensionContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.isIntegerLiteralType(r10, r11);
        }

        public static boolean isMarkedNullable(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.isMarkedNullable(r10, r11);
        }

        public static boolean isNothing(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.isNothing(r10, r11);
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible(r10, r11);
        }

        public static int size(TypeSystemInferenceExtensionContext r10, TypeArgumentListMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.size(r10, r11);
        }

        public static TypeConstructorMarker typeConstructor(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.typeConstructor(r10, r11);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemInferenceExtensionContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return TypeSystemContext.DefaultImpls.upperBoundIfFlexible(r10, r11);
        }
    }
}
