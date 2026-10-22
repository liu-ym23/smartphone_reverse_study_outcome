package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* JADX INFO: loaded from: classes3.dex */
public final class SimpleClassicTypeSystemContext implements ClassicTypeSystemContext {
    public static final SimpleClassicTypeSystemContext INSTANCE = null;

    static {
        INSTANCE = new SimpleClassicTypeSystemContext();
    }

    private SimpleClassicTypeSystemContext() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean areEqualTypeConstructors(TypeConstructorMarker r10, TypeConstructorMarker r11) {
        return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int argumentsCount(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentListMarker asArgumentList(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeMarker asCapturedType(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DynamicTypeMarker asDynamicType(FlexibleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public FlexibleTypeMarker asFlexibleType(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public RawTypeMarker asRawType(FlexibleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.asRawType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker asSimpleType(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker asTypeArgument(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker captureFromArguments(SimpleTypeMarker r10, CaptureStatus r11) {
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CaptureStatus captureStatus(CapturedTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    public KotlinTypeMarker createFlexibleType(SimpleTypeMarker r10, SimpleTypeMarker r11) {
        return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker r10, TypeConstructorMarker r11) {
        return ClassicTypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker get(TypeArgumentListMarker r10, int r11) {
        return ClassicTypeSystemContext.DefaultImpls.get(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgument(KotlinTypeMarker r10, int r11) {
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker r10, int r11) {
        return ClassicTypeSystemContext.DefaultImpls.getArgumentOrNull(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeArgumentMarker> getArguments(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getArguments(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getParameter(TypeConstructorMarker r10, int r11) {
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeParameterMarker> getParameters(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getParameters(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveArrayType(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveType(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker getType(TypeArgumentMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeArgumentMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeParameterMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean hasAnnotation(KotlinTypeMarker r10, FqName r11) {
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasFlexibleNullability(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.hasFlexibleNullability(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasRecursiveBounds(TypeParameterMarker r10, TypeConstructorMarker r11) {
        return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public boolean identicalArguments(SimpleTypeMarker r10, SimpleTypeMarker r11) {
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> r10) {
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isAnyConstructor(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCapturedType(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isCapturedType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassType(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isClassType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassTypeConstructor(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCommonFinalClassConstructor(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDefinitelyNotNullType(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isDefinitelyNotNullType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDenotable(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDynamic(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isDynamic(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isError(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isError(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isInlineClass(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralType(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntersection(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNotNullTypeParameter(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothing(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isNothing(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothingConstructor(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNullableType(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isOldCapturedType(CapturedTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isPrimitiveType(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isProjectionNotNull(CapturedTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isSingleClassifierType(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStarProjection(TypeArgumentMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubType(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubTypeForBuilderInference(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isTypeVariableType(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBound(FlexibleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBoundIfFlexible(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker lowerType(CapturedTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker makeNullable(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.makeNullable(this, r10);
    }

    public TypeCheckerState newTypeCheckerState(boolean r10, boolean r11) {
        return ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker original(DefinitelyNotNullTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.original(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int parametersCount(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker projection(CapturedTypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.projection(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int size(TypeArgumentListMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.size(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBound(FlexibleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.upperBoundIfFlexible(this, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker withNullability(KotlinTypeMarker r10, boolean r11) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker withNullability(SimpleTypeMarker r10, boolean r11) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, r10, r11);
    }
}
