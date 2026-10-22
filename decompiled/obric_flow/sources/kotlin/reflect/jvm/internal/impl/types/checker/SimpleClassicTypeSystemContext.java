package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
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
    public boolean areEqualTypeConstructors(TypeConstructorMarker r5, TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.areEqualTypeConstructors(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int argumentsCount(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentListMarker asArgumentList(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeMarker asCapturedType(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public DynamicTypeMarker asDynamicType(FlexibleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public FlexibleTypeMarker asFlexibleType(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public RawTypeMarker asRawType(FlexibleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.asRawType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker asSimpleType(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker asTypeArgument(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker captureFromArguments(SimpleTypeMarker r5, CaptureStatus r10) {
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CaptureStatus captureStatus(CapturedTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.captureStatus(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext
    public KotlinTypeMarker createFlexibleType(SimpleTypeMarker r5, SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.createFlexibleType(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker r5, TypeConstructorMarker r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "constructor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker get(TypeArgumentListMarker r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof SimpleTypeMarker) == false) goto L6;
        return getArgument((KotlinTypeMarker) r5, r10);
    L6:
        if ((r5 instanceof ArgumentList) == false) goto L10;
        return ((ArgumentList) r5).get(r10);
    L10:
        throw new IllegalStateException(("unknown type argument list type: " + r5 + ", " + Reflection.getOrCreateKotlinClass(r5.getClass())).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgument(KotlinTypeMarker r5, int r10) {
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 >= 0) goto L5;
        return null;
    L5:
        if (r10 < argumentsCount(r5)) goto L7;
        return null;
    L7:
        return getArgument(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeArgumentMarker> getArguments(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getArguments(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getParameter(TypeConstructorMarker r5, int r10) {
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<TypeParameterMarker> getParameters(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getParameters(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveArrayType(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public PrimitiveType getPrimitiveType(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker getType(TypeArgumentMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameter(TypeVariableTypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameter(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker getUnsubstitutedUnderlyingType(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getUnsubstitutedUnderlyingType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public List<KotlinTypeMarker> getUpperBounds(TypeParameterMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getUpperBounds(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeArgumentMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean hasAnnotation(KotlinTypeMarker r5, FqName r10) {
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasFlexibleNullability(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (isMarkedNullable(lowerBoundIfFlexible(r5)) == isMarkedNullable(upperBoundIfFlexible(r5))) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean hasRecursiveBounds(TypeParameterMarker r5, TypeConstructorMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.hasRecursiveBounds(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemOptimizationContext
    public boolean identicalArguments(SimpleTypeMarker r5, SimpleTypeMarker r10) {
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> r5) {
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isAnyConstructor(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCapturedType(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SimpleTypeMarker r10 = asSimpleType(r5);
        if (r10 == null) goto L5;
        CapturedTypeMarker r11 = asCapturedType(r10);
    L6:
        if (r11 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassType(SimpleTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return isClassTypeConstructor(typeConstructor(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isClassTypeConstructor(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isCommonFinalClassConstructor(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDefinitelyNotNullType(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SimpleTypeMarker r10 = asSimpleType(r5);
        if (r10 == null) goto L5;
        DefinitelyNotNullTypeMarker r11 = asDefinitelyNotNullType(r10);
    L6:
        if (r11 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDenotable(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isDynamic(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FlexibleTypeMarker r10 = asFlexibleType(r5);
        if (r10 == null) goto L5;
        DynamicTypeMarker r11 = asDynamicType(r10);
    L6:
        if (r11 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r11 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isError(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isError(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isInlineClass(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralType(SimpleTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return isIntegerLiteralTypeConstructor(typeConstructor(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isIntersection(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNotNullTypeParameter(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isNotNullTypeParameter(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothing(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (isNothingConstructor(typeConstructor(r5)) == true) goto L5;
    L7:
        return false;
    L5:
        if (isNullableType(r5) == true) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNothingConstructor(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isNullableType(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isOldCapturedType(CapturedTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isOldCapturedType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isPrimitiveType(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isProjectionNotNull(CapturedTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isSingleClassifierType(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStarProjection(TypeArgumentMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubType(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isStubTypeForBuilderInference(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isStubTypeForBuilderInference(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isTypeVariableType(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isTypeVariableType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public boolean isUnderKotlinPackage(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBound(FlexibleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FlexibleTypeMarker r10 = asFlexibleType(r5);
        if (r10 == null) goto L6;
        SimpleTypeMarker r11 = lowerBound(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        SimpleTypeMarker r12 = asSimpleType(r5);
        Intrinsics.checkNotNull(r12);
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker lowerType(CapturedTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker makeDefinitelyNotNullOrNotNull(KotlinTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.makeDefinitelyNotNullOrNotNull(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext
    public KotlinTypeMarker makeNullable(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SimpleTypeMarker r10 = asSimpleType(r5);
        if (r10 == null) goto L8;
        SimpleTypeMarker r11 = withNullability(r10, true);
        if (r11 != null) goto L7;
        return r5;
    L7:
        return r11;
    L8:
        return r5;
    }

    public TypeCheckerState newTypeCheckerState(boolean r5, boolean r10) {
        return ClassicTypeSystemContext.DefaultImpls.newTypeCheckerState(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker original(DefinitelyNotNullTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.original(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker originalIfDefinitelyNotNullable(SimpleTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        DefinitelyNotNullTypeMarker r10 = asDefinitelyNotNullType(r5);
        if (r10 == null) goto L9;
        SimpleTypeMarker r11 = original(r10);
        if (r11 != null) goto L8;
        return r5;
    L8:
        return r11;
    L9:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int parametersCount(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeArgumentMarker projection(CapturedTypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.projection(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public int size(TypeArgumentListMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof SimpleTypeMarker) == false) goto L6;
        return argumentsCount((KotlinTypeMarker) r5);
    L6:
        if ((r5 instanceof ArgumentList) == false) goto L10;
        return ((ArgumentList) r5).size();
    L10:
        throw new IllegalStateException(("unknown type argument list type: " + r5 + ", " + Reflection.getOrCreateKotlinClass(r5.getClass())).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.substitutionSupertypePolicy(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public CapturedTypeConstructorMarker typeConstructor(CapturedTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBound(FlexibleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FlexibleTypeMarker r10 = asFlexibleType(r5);
        if (r10 == null) goto L6;
        SimpleTypeMarker r11 = upperBound(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        SimpleTypeMarker r12 = asSimpleType(r5);
        Intrinsics.checkNotNull(r12);
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public KotlinTypeMarker withNullability(KotlinTypeMarker r5, boolean r10) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeVariance getVariance(TypeParameterMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.getVariance(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public boolean isMarkedNullable(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof SimpleTypeMarker) == true) goto L5;
    L7:
        return false;
    L5:
        if (isMarkedNullable((SimpleTypeMarker) r5) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(SimpleTypeMarker r5) {
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor(this, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public SimpleTypeMarker withNullability(SimpleTypeMarker r5, boolean r10) {
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    public TypeConstructorMarker typeConstructor(KotlinTypeMarker r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        SimpleTypeMarker r10 = asSimpleType(r5);
        if (r10 != null) goto L6;
        r10 = lowerBoundIfFlexible(r5);
    L6:
        return typeConstructor(r10);
    }
}
