package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* JADX INFO: loaded from: classes3.dex */
public interface TypeSystemContext extends TypeSystemOptimizationContext {

    public static final class DefaultImpls {
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(TypeSystemContext r10, SimpleTypeMarker r11, TypeConstructorMarker r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            Intrinsics.checkNotNullParameter(r12, "constructor");
            return null;
        }

        public static TypeArgumentMarker get(TypeSystemContext r10, TypeArgumentListMarker r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleTypeMarker) == false) goto L6;
            return r10.getArgument((KotlinTypeMarker) r11, r12);
        L6:
            if ((r11 instanceof ArgumentList) == false) goto L10;
            TypeArgumentMarker r13 = ((ArgumentList) r11).get(r12);
            Intrinsics.checkNotNullExpressionValue(r13, "get(index)");
            return r13;
        L10:
            throw new IllegalStateException(("unknown type argument list type: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeArgumentMarker getArgumentOrNull(TypeSystemContext r10, SimpleTypeMarker r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            boolean r13 = false;
            if (r12 >= 0) goto L5;
        L7:
            if (r13 == true) goto L9;
            return null;
        L9:
            return r10.getArgument(r11, r12);
        L5:
            if (r12 >= r10.argumentsCount(r11)) goto L7;
            r13 = true;
            goto L7
        }

        public static boolean hasFlexibleNullability(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if (r10.isMarkedNullable(r10.lowerBoundIfFlexible(r11)) == r10.isMarkedNullable(r10.upperBoundIfFlexible(r11))) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean isCapturedType(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            SimpleTypeMarker r12 = r10.asSimpleType(r11);
            if (r12 == null) goto L5;
            CapturedTypeMarker r13 = r10.asCapturedType(r12);
        L6:
            if (r13 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r13 = null;
            goto L6
        }

        public static boolean isClassType(TypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return r10.isClassTypeConstructor(r10.typeConstructor(r11));
        }

        public static boolean isDefinitelyNotNullType(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            SimpleTypeMarker r12 = r10.asSimpleType(r11);
            if (r12 == null) goto L5;
            DefinitelyNotNullTypeMarker r13 = r10.asDefinitelyNotNullType(r12);
        L6:
            if (r13 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r13 = null;
            goto L6
        }

        public static boolean isDynamic(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            FlexibleTypeMarker r12 = r10.asFlexibleType(r11);
            if (r12 == null) goto L5;
            DynamicTypeMarker r13 = r10.asDynamicType(r12);
        L6:
            if (r13 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r13 = null;
            goto L6
        }

        public static boolean isIntegerLiteralType(TypeSystemContext r10, SimpleTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            return r10.isIntegerLiteralTypeConstructor(r10.typeConstructor(r11));
        }

        public static boolean isMarkedNullable(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleTypeMarker) == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.isMarkedNullable((SimpleTypeMarker) r11) == false) goto L7;
            return true;
        }

        public static boolean isNothing(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if (r10.isNothingConstructor(r10.typeConstructor(r11)) == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.isNullableType(r11) == true) goto L7;
            return true;
        }

        public static SimpleTypeMarker lowerBoundIfFlexible(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            FlexibleTypeMarker r12 = r10.asFlexibleType(r11);
            if (r12 == null) goto L6;
            SimpleTypeMarker r13 = r10.lowerBound(r12);
            if (r13 == null) goto L6;
            return r13;
        L6:
            SimpleTypeMarker r14 = r10.asSimpleType(r11);
            Intrinsics.checkNotNull(r14);
            return r14;
        }

        public static int size(TypeSystemContext r10, TypeArgumentListMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            if ((r11 instanceof SimpleTypeMarker) == false) goto L6;
            return r10.argumentsCount((KotlinTypeMarker) r11);
        L6:
            if ((r11 instanceof ArgumentList) == false) goto L10;
            return ((ArgumentList) r11).size();
        L10:
            throw new IllegalStateException(("unknown type argument list type: " + r11 + ", " + Reflection.getOrCreateKotlinClass(r11.getClass())).toString());
        }

        public static TypeConstructorMarker typeConstructor(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            SimpleTypeMarker r12 = r10.asSimpleType(r11);
            if (r12 != null) goto L6;
            r12 = r10.lowerBoundIfFlexible(r11);
        L6:
            return r10.typeConstructor(r12);
        }

        public static SimpleTypeMarker upperBoundIfFlexible(TypeSystemContext r10, KotlinTypeMarker r11) {
            Intrinsics.checkNotNullParameter(r11, "$receiver");
            FlexibleTypeMarker r12 = r10.asFlexibleType(r11);
            if (r12 == null) goto L6;
            SimpleTypeMarker r13 = r10.upperBound(r12);
            if (r13 == null) goto L6;
            return r13;
        L6:
            SimpleTypeMarker r14 = r10.asSimpleType(r11);
            Intrinsics.checkNotNull(r14);
            return r14;
        }
    }

    boolean areEqualTypeConstructors(TypeConstructorMarker r10, TypeConstructorMarker r11);

    int argumentsCount(KotlinTypeMarker r10);

    TypeArgumentListMarker asArgumentList(SimpleTypeMarker r10);

    CapturedTypeMarker asCapturedType(SimpleTypeMarker r10);

    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker r10);

    DynamicTypeMarker asDynamicType(FlexibleTypeMarker r10);

    FlexibleTypeMarker asFlexibleType(KotlinTypeMarker r10);

    RawTypeMarker asRawType(FlexibleTypeMarker r10);

    SimpleTypeMarker asSimpleType(KotlinTypeMarker r10);

    TypeArgumentMarker asTypeArgument(KotlinTypeMarker r10);

    SimpleTypeMarker captureFromArguments(SimpleTypeMarker r10, CaptureStatus r11);

    CaptureStatus captureStatus(CapturedTypeMarker r10);

    List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker r10, TypeConstructorMarker r11);

    TypeArgumentMarker get(TypeArgumentListMarker r10, int r11);

    TypeArgumentMarker getArgument(KotlinTypeMarker r10, int r11);

    TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker r10, int r11);

    List<TypeArgumentMarker> getArguments(KotlinTypeMarker r10);

    TypeParameterMarker getParameter(TypeConstructorMarker r10, int r11);

    List<TypeParameterMarker> getParameters(TypeConstructorMarker r10);

    KotlinTypeMarker getType(TypeArgumentMarker r10);

    TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker r10);

    TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker r10);

    List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker r10);

    TypeVariance getVariance(TypeArgumentMarker r10);

    TypeVariance getVariance(TypeParameterMarker r10);

    boolean hasFlexibleNullability(KotlinTypeMarker r10);

    boolean hasRecursiveBounds(TypeParameterMarker r10, TypeConstructorMarker r11);

    KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> r10);

    boolean isAnyConstructor(TypeConstructorMarker r10);

    boolean isCapturedType(KotlinTypeMarker r10);

    boolean isClassType(SimpleTypeMarker r10);

    boolean isClassTypeConstructor(TypeConstructorMarker r10);

    boolean isCommonFinalClassConstructor(TypeConstructorMarker r10);

    boolean isDefinitelyNotNullType(KotlinTypeMarker r10);

    boolean isDenotable(TypeConstructorMarker r10);

    boolean isDynamic(KotlinTypeMarker r10);

    boolean isError(KotlinTypeMarker r10);

    boolean isIntegerLiteralType(SimpleTypeMarker r10);

    boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker r10);

    boolean isIntersection(TypeConstructorMarker r10);

    boolean isMarkedNullable(KotlinTypeMarker r10);

    boolean isMarkedNullable(SimpleTypeMarker r10);

    boolean isNotNullTypeParameter(KotlinTypeMarker r10);

    boolean isNothing(KotlinTypeMarker r10);

    boolean isNothingConstructor(TypeConstructorMarker r10);

    boolean isNullableType(KotlinTypeMarker r10);

    boolean isOldCapturedType(CapturedTypeMarker r10);

    boolean isPrimitiveType(SimpleTypeMarker r10);

    boolean isProjectionNotNull(CapturedTypeMarker r10);

    boolean isSingleClassifierType(SimpleTypeMarker r10);

    boolean isStarProjection(TypeArgumentMarker r10);

    boolean isStubType(SimpleTypeMarker r10);

    boolean isStubTypeForBuilderInference(SimpleTypeMarker r10);

    boolean isTypeVariableType(KotlinTypeMarker r10);

    SimpleTypeMarker lowerBound(FlexibleTypeMarker r10);

    SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker r10);

    KotlinTypeMarker lowerType(CapturedTypeMarker r10);

    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker r10);

    SimpleTypeMarker original(DefinitelyNotNullTypeMarker r10);

    int parametersCount(TypeConstructorMarker r10);

    Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker r10);

    TypeArgumentMarker projection(CapturedTypeConstructorMarker r10);

    int size(TypeArgumentListMarker r10);

    TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker r10);

    Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker r10);

    CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker r10);

    TypeConstructorMarker typeConstructor(KotlinTypeMarker r10);

    TypeConstructorMarker typeConstructor(SimpleTypeMarker r10);

    SimpleTypeMarker upperBound(FlexibleTypeMarker r10);

    SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker r10);

    KotlinTypeMarker withNullability(KotlinTypeMarker r10, boolean r11);

    SimpleTypeMarker withNullability(SimpleTypeMarker r10, boolean r11);
}
