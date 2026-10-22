package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeSystemContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeSystemContext.kt\norg/jetbrains/kotlin/types/model/TypeSystemContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,578:1\n1#2:579\n*E\n"})
public interface TypeSystemContext extends TypeSystemOptimizationContext {
    boolean areEqualTypeConstructors(TypeConstructorMarker r5, TypeConstructorMarker r10);

    int argumentsCount(KotlinTypeMarker r5);

    TypeArgumentListMarker asArgumentList(SimpleTypeMarker r5);

    CapturedTypeMarker asCapturedType(SimpleTypeMarker r5);

    DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker r5);

    DynamicTypeMarker asDynamicType(FlexibleTypeMarker r5);

    FlexibleTypeMarker asFlexibleType(KotlinTypeMarker r5);

    RawTypeMarker asRawType(FlexibleTypeMarker r5);

    SimpleTypeMarker asSimpleType(KotlinTypeMarker r5);

    TypeArgumentMarker asTypeArgument(KotlinTypeMarker r5);

    SimpleTypeMarker captureFromArguments(SimpleTypeMarker r5, CaptureStatus r10);

    CaptureStatus captureStatus(CapturedTypeMarker r5);

    List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker r5, TypeConstructorMarker r10);

    TypeArgumentMarker get(TypeArgumentListMarker r5, int r10);

    TypeArgumentMarker getArgument(KotlinTypeMarker r5, int r10);

    TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker r5, int r10);

    List<TypeArgumentMarker> getArguments(KotlinTypeMarker r5);

    TypeParameterMarker getParameter(TypeConstructorMarker r5, int r10);

    List<TypeParameterMarker> getParameters(TypeConstructorMarker r5);

    KotlinTypeMarker getType(TypeArgumentMarker r5);

    TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker r5);

    TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker r5);

    List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker r5);

    TypeVariance getVariance(TypeArgumentMarker r5);

    TypeVariance getVariance(TypeParameterMarker r5);

    boolean hasFlexibleNullability(KotlinTypeMarker r5);

    boolean hasRecursiveBounds(TypeParameterMarker r5, TypeConstructorMarker r10);

    KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> r5);

    boolean isAnyConstructor(TypeConstructorMarker r5);

    boolean isCapturedType(KotlinTypeMarker r5);

    boolean isClassType(SimpleTypeMarker r5);

    boolean isClassTypeConstructor(TypeConstructorMarker r5);

    boolean isCommonFinalClassConstructor(TypeConstructorMarker r5);

    boolean isDefinitelyNotNullType(KotlinTypeMarker r5);

    boolean isDenotable(TypeConstructorMarker r5);

    boolean isDynamic(KotlinTypeMarker r5);

    boolean isError(KotlinTypeMarker r5);

    boolean isIntegerLiteralType(SimpleTypeMarker r5);

    boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker r5);

    boolean isIntersection(TypeConstructorMarker r5);

    boolean isMarkedNullable(KotlinTypeMarker r5);

    boolean isMarkedNullable(SimpleTypeMarker r5);

    boolean isNotNullTypeParameter(KotlinTypeMarker r5);

    boolean isNothing(KotlinTypeMarker r5);

    boolean isNothingConstructor(TypeConstructorMarker r5);

    boolean isNullableType(KotlinTypeMarker r5);

    boolean isOldCapturedType(CapturedTypeMarker r5);

    boolean isPrimitiveType(SimpleTypeMarker r5);

    boolean isProjectionNotNull(CapturedTypeMarker r5);

    boolean isSingleClassifierType(SimpleTypeMarker r5);

    boolean isStarProjection(TypeArgumentMarker r5);

    boolean isStubType(SimpleTypeMarker r5);

    boolean isStubTypeForBuilderInference(SimpleTypeMarker r5);

    boolean isTypeVariableType(KotlinTypeMarker r5);

    SimpleTypeMarker lowerBound(FlexibleTypeMarker r5);

    SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker r5);

    KotlinTypeMarker lowerType(CapturedTypeMarker r5);

    KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker r5);

    SimpleTypeMarker original(DefinitelyNotNullTypeMarker r5);

    SimpleTypeMarker originalIfDefinitelyNotNullable(SimpleTypeMarker r5);

    int parametersCount(TypeConstructorMarker r5);

    Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker r5);

    TypeArgumentMarker projection(CapturedTypeConstructorMarker r5);

    int size(TypeArgumentListMarker r5);

    TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker r5);

    Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker r5);

    CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker r5);

    TypeConstructorMarker typeConstructor(KotlinTypeMarker r5);

    TypeConstructorMarker typeConstructor(SimpleTypeMarker r5);

    SimpleTypeMarker upperBound(FlexibleTypeMarker r5);

    SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker r5);

    KotlinTypeMarker withNullability(KotlinTypeMarker r5, boolean r10);

    SimpleTypeMarker withNullability(SimpleTypeMarker r5, boolean r10);
}
