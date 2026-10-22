package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TypeSubstitutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor EMPTY = null;
    private final TypeSubstitution substitution;

    private static /* synthetic */ void $$$reportNull$$$0(int r13) {
        if (r13 == 1) goto L13;
        if (r13 == 2) goto L13;
        if (r13 == 8) goto L13;
        if (r13 == 34) goto L13;
        if (r13 == 37) goto L13;
        switch(r13) {
            case 11: goto L13;
            case 12: goto L13;
            case 13: goto L13;
            default: goto L9;
        };
    L9:
        switch(r13) {
            case 19: goto L13;
            case 20: goto L13;
            case 21: goto L13;
            case 22: goto L13;
            case 23: goto L13;
            case 24: goto L13;
            case 25: goto L13;
            default: goto L10;
        };
    L10:
        switch(r13) {
            case 29: goto L13;
            case 30: goto L13;
            case 31: goto L13;
            case 32: goto L13;
            default: goto L11;
        };
    L11:
        switch(r13) {
            case 40: goto L13;
            case 41: goto L13;
            case 42: goto L13;
            default: goto L12;
        };
    L12:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L14:
        if (r13 == 1) goto L24;
        if (r13 == 2) goto L24;
        if (r13 == 8) goto L24;
        if (r13 == 34) goto L24;
        if (r13 == 37) goto L24;
        switch(r13) {
            case 11: goto L24;
            case 12: goto L24;
            case 13: goto L24;
            default: goto L20;
        };
    L20:
        switch(r13) {
            case 19: goto L24;
            case 20: goto L24;
            case 21: goto L24;
            case 22: goto L24;
            case 23: goto L24;
            case 24: goto L24;
            case 25: goto L24;
            default: goto L21;
        };
    L21:
        switch(r13) {
            case 29: goto L24;
            case 30: goto L24;
            case 31: goto L24;
            case 32: goto L24;
            default: goto L22;
        };
    L22:
        switch(r13) {
            case 40: goto L24;
            case 41: goto L24;
            case 42: goto L24;
            default: goto L23;
        };
    L23:
        int r6 = 3;
    L25:
        Object[] r7 = new Object[r6];
        switch(r13) {
            case 1: goto L41;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L27;
            case 8: goto L41;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L41;
            case 12: goto L41;
            case 13: goto L41;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L34;
            case 18: goto L33;
            case 19: goto L41;
            case 20: goto L41;
            case 21: goto L41;
            case 22: goto L41;
            case 23: goto L41;
            case 24: goto L41;
            case 25: goto L41;
            case 26: goto L32;
            case 27: goto L31;
            case 28: goto L33;
            case 29: goto L41;
            case 30: goto L41;
            case 31: goto L41;
            case 32: goto L41;
            case 33: goto L30;
            case 34: goto L41;
            case 35: goto L29;
            case 36: goto L34;
            case 37: goto L41;
            case 38: goto L29;
            case 39: goto L28;
            case 40: goto L41;
            case 41: goto L41;
            case 42: goto L41;
            default: goto L27;
        };
    L27:
        r7[0] = "substitution";
    L43:
        if (r13 == 1) goto L60;
        if (r13 == 2) goto L59;
        if (r13 == 8) goto L58;
        if (r13 == 34) goto L57;
        if (r13 == 37) goto L56;
        switch(r13) {
            case 11: goto L55;
            case 12: goto L55;
            case 13: goto L55;
            default: goto L49;
        };
    L49:
        switch(r13) {
            case 19: goto L54;
            case 20: goto L54;
            case 21: goto L54;
            case 22: goto L54;
            case 23: goto L54;
            case 24: goto L54;
            case 25: goto L54;
            default: goto L50;
        };
    L50:
        switch(r13) {
            case 29: goto L53;
            case 30: goto L53;
            case 31: goto L53;
            case 32: goto L53;
            default: goto L51;
        };
    L51:
        switch(r13) {
            case 40: goto L56;
            case 41: goto L56;
            case 42: goto L56;
            default: goto L52;
        };
    L52:
        r7[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
    L61:
        switch(r13) {
            case 1: goto L72;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L71;
            case 5: goto L62;
            case 6: goto L62;
            case 7: goto L70;
            case 8: goto L72;
            case 9: goto L69;
            case 10: goto L69;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L68;
            case 15: goto L68;
            case 16: goto L68;
            case 17: goto L67;
            case 18: goto L66;
            case 19: goto L72;
            case 20: goto L72;
            case 21: goto L72;
            case 22: goto L72;
            case 23: goto L72;
            case 24: goto L72;
            case 25: goto L72;
            case 26: goto L65;
            case 27: goto L65;
            case 28: goto L65;
            case 29: goto L72;
            case 30: goto L72;
            case 31: goto L72;
            case 32: goto L72;
            case 33: goto L64;
            case 34: goto L72;
            case 35: goto L63;
            case 36: goto L63;
            case 37: goto L72;
            case 38: goto L63;
            case 39: goto L63;
            case 40: goto L72;
            case 41: goto L72;
            case 42: goto L72;
            default: goto L62;
        };
    L62:
        r7[2] = "create";
        goto L72
    L63:
        r7[2] = "combine";
        goto L72
    L64:
        r7[2] = "filterOutUnsafeVariance";
        goto L72
    L65:
        r7[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L72
    L66:
        r7[2] = "unsafeSubstitute";
        goto L72
    L67:
        r7[2] = "substituteWithoutApproximation";
        goto L72
    L68:
        r7[2] = "substitute";
        goto L72
    L69:
        r7[2] = "safeSubstitute";
        goto L72
    L70:
        r7[2] = "<init>";
        goto L72
    L71:
        r7[2] = "createChainedSubstitutor";
    L72:
        String r8 = String.format(r5, r7);
        if (r13 == 1) goto L84;
        if (r13 == 2) goto L84;
        if (r13 == 8) goto L84;
        if (r13 == 34) goto L84;
        if (r13 == 37) goto L84;
        switch(r13) {
            case 11: goto L84;
            case 12: goto L84;
            case 13: goto L84;
            default: goto L79;
        };
    L79:
        switch(r13) {
            case 19: goto L84;
            case 20: goto L84;
            case 21: goto L84;
            case 22: goto L84;
            case 23: goto L84;
            case 24: goto L84;
            case 25: goto L84;
            default: goto L80;
        };
    L80:
        switch(r13) {
            case 29: goto L84;
            case 30: goto L84;
            case 31: goto L84;
            case 32: goto L84;
            default: goto L81;
        };
    L81:
        switch(r13) {
            case 40: goto L84;
            case 41: goto L84;
            case 42: goto L84;
            default: goto L85;
        };
    L85:
        throw new IllegalArgumentException(r8);
    L84:
        throw new IllegalStateException(r8);
    L53:
        r7[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L61
    L54:
        r7[1] = "unsafeSubstitute";
        goto L61
    L55:
        r7[1] = "safeSubstitute";
    L56:
        r7[1] = "combine";
        goto L61
    L57:
        r7[1] = "filterOutUnsafeVariance";
        goto L61
    L58:
        r7[1] = "getSubstitution";
        goto L61
    L59:
        r7[1] = "replaceWithContravariantApproximatingSubstitution";
        goto L61
    L60:
        r7[1] = "replaceWithNonApproximatingSubstitution";
        goto L61
    L28:
        r7[0] = "projectionKind";
        goto L43
    L29:
        r7[0] = "typeParameterVariance";
        goto L43
    L30:
        r7[0] = "annotations";
        goto L43
    L31:
        r7[0] = "substituted";
        goto L43
    L32:
        r7[0] = "originalType";
        goto L43
    L33:
        r7[0] = "originalProjection";
        goto L43
    L34:
        r7[0] = "typeProjection";
        goto L43
    L35:
        r7[0] = "howThisTypeIsUsed";
        goto L43
    L36:
        r7[0] = EffectConfiguration.KEY_TYPE;
        goto L43
    L37:
        r7[0] = "context";
        goto L43
    L38:
        r7[0] = "substitutionContext";
        goto L43
    L39:
        r7[0] = "second";
        goto L43
    L40:
        r7[0] = "first";
        goto L43
    L41:
        r7[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
    L24:
        r6 = 2;
    L13:
        r5 = "@NotNull method %s.%s must not return null";
        goto L14
    }

    static {
        EMPTY = create(TypeSubstitution.EMPTY);
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution r0 = this.substitution;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r0;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution r0 = this.substitution;
        if ((r0 instanceof IndexedParametersSubstitution) == true) goto L5;
    L9:
        return this;
    L5:
        if (r0.approximateContravariantCapturedTypes() == false) goto L9;
        return new TypeSubstitutor(new IndexedParametersSubstitution(this.substitution.getParameters(), this.substitution.getArguments(), false));
    }

    public TypeSubstitutor(TypeSubstitution r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        this.substitution = r2;
    }

    public static TypeSubstitutor create(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return create(TypeConstructorSubstitution.create(r1.getConstructor(), r1.getArguments()));
    }

    private static Annotations filterOutUnsafeVariance(Annotations r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(33);
    L5:
        if (r2.hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L8;
        return r2;
    L8:
        return new FilteredAnnotations(r2, new 1());
    }

    private static String safeToString(Object r2) {
        return r2.toString();
    L4:
        th = move-exception;
        if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L10;
        return "[Exception while computing toString(): " + th + "]";
    L10:
        throw th;
    }

    public TypeProjection substitute(TypeProjection r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        TypeProjection r3 = substituteWithoutApproximation(r2);
        if (this.substitution.approximateCapturedTypes() == true) goto L10;
        if (this.substitution.approximateContravariantCapturedTypes() == true) goto L10;
        return r3;
    L10:
        return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(r3, this.substitution.approximateContravariantCapturedTypes());
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        if (isEmpty() == false) goto L11;
        return r3;
    L11:
        return unsafeSubstitute(r3, null, 0);
    L10:
        return null;
    }

    public static TypeSubstitutor create(TypeSubstitution r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new TypeSubstitutor(r1);
    }

    public static Variance combine(Variance r3, Variance r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(38);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(39);
    L6:
        Variance r0 = Variance.INVARIANT;
        if (r3 != r0) goto L11;
        if (r4 != null) goto L10;
        $$$reportNull$$$0(40);
    L10:
        return r4;
    L11:
        if (r4 != r0) goto L15;
        if (r3 != null) goto L14;
        $$$reportNull$$$0(41);
    L14:
        return r3;
    L15:
        if (r3 != r4) goto L20;
        if (r4 != null) goto L18;
        $$$reportNull$$$0(42);
    L18:
        return r4;
    L20:
        throw new AssertionError("Variance conflict: type parameter variance '" + r3 + "' and projection kind '" + r4 + "' cannot be combined");
    }

    private static VarianceConflictType conflictType(Variance r2, Variance r3) {
        Variance r0 = Variance.IN_VARIANCE;
        if (r2 != r0) goto L9;
        if (r3 != Variance.OUT_VARIANCE) goto L9;
        return VarianceConflictType.OUT_IN_IN_POSITION;
    L9:
        if (r2 != Variance.OUT_VARIANCE) goto L14;
        if (r3 != r0) goto L14;
        return VarianceConflictType.IN_IN_OUT_POSITION;
    L14:
        return VarianceConflictType.NO_CONFLICT;
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution r1, TypeSubstitution r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return create(DisjointKeysUnionTypeSubstitution.create(r1, r2));
    }

    private TypeProjection substituteCompoundType(TypeProjection r5, int r6) throws SubstitutionException {
        KotlinType r0 = r5.getType();
        Variance r1 = r5.getProjectionKind();
        if ((r0.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) == false) goto L5;
        return r5;
    L5:
        SimpleType r7 = SpecialTypesKt.getAbbreviation(r0);
        if (r7 == null) goto L8;
        KotlinType r8 = replaceWithNonApproximatingSubstitution().substitute(r7, Variance.INVARIANT);
    L9:
        KotlinType r9 = TypeSubstitutionKt.replace(r0, substituteTypeArguments(r0.getConstructor().getParameters(), r0.getArguments(), r6), this.substitution.filterAnnotations(r0.getAnnotations()));
        if ((r9 instanceof SimpleType) == false) goto L15;
        if ((r8 instanceof SimpleType) == false) goto L15;
        r9 = SpecialTypesKt.withAbbreviation((SimpleType) r9, (SimpleType) r8);
    L15:
        return new TypeProjectionImpl(r1, r9);
    L8:
        r8 = null;
        goto L9
    }

    public KotlinType safeSubstitute(KotlinType r3, Variance r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r4 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        if (isEmpty() == false) goto L21;
        if (r3 != null) goto L10;
        $$$reportNull$$$0(11);
    L10:
        return r3;
    L21:
        KotlinType r5 = unsafeSubstitute(new TypeProjectionImpl(r4, r3), null, 0).getType();     // Catch: SubstitutionException -> L16
        if (r5 != null) goto L15;
        $$$reportNull$$$0(12);
    L15:
        return r5;
    L16:
        e = move-exception;
        ErrorType r6 = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, new String[]{e.getMessage()});
        if (r6 != null) goto L20;
        $$$reportNull$$$0(13);
    L20:
        return r6;
    }

    public KotlinType substitute(KotlinType r3, Variance r4) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r4 != null) goto L6;
        $$$reportNull$$$0(15);
    L6:
        TypeProjection r5 = substitute(new TypeProjectionImpl(r4, getSubstitution().prepareTopLevelType(r3, r4)));
        if (r5 != null) goto L10;
        return null;
    L10:
        return r5.getType();
    }

    public static Variance combine(Variance r1, TypeProjection r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        if (r2 != null) goto L7;
        $$$reportNull$$$0(36);
    L7:
        if (r2.isStarProjection() == false) goto L13;
        Variance r3 = Variance.OUT_VARIANCE;
        if (r3 != null) goto L11;
        $$$reportNull$$$0(37);
    L11:
        return r3;
    L13:
        return combine(r1, r2.getProjectionKind());
    }

    private static void assertRecursionDepth(int r2, TypeProjection r3, TypeSubstitution r4) {
        if (r2 > 100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(r3) + "; substitution: " + safeToString(r4));
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> r11, List<TypeProjection> r12, int r13) throws SubstitutionException {
        ArrayList r0 = new ArrayList(r11.size());
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r11.size()) goto L21;
        TypeParameterDescriptor r3 = (TypeParameterDescriptor) ListProtector.get(r11, r1);
        TypeProjection r4 = (TypeProjection) ListProtector.get(r12, r1);
        TypeProjection r6 = unsafeSubstitute(r4, r3, r13 + 1);
        int r7 = 2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(r3.getVariance(), r6.getProjectionKind()).ordinal()];
        if (r7 != 1) goto L8;
    L17:
        r6 = TypeUtils.makeStarProjection(r3);
    L18:
        if (r6 == r4) goto L20;
        r2 = true;
    L20:
        r0.add(r6);
        r1 = r1 + 1;
        goto L4
    L8:
        if (r7 == 2) goto L17;
        if (r7 != 3) goto L18;
        Variance r5 = r3.getVariance();
        Variance r8 = Variance.INVARIANT;
        if (r5 == r8) goto L18;
        if (r6.isStarProjection() == true) goto L18;
        r6 = new TypeProjectionImpl(r8, r6.getType());
        goto L18
    L21:
        if (r2 == true) goto L23;
        return r12;
    L23:
        return r0;
    }

    private TypeProjection unsafeSubstitute(TypeProjection r8, TypeParameterDescriptor r9, int r10) throws SubstitutionException {
        if (r8 != null) goto L4;
        $$$reportNull$$$0(18);
    L4:
        assertRecursionDepth(r10, r8, this.substitution);
        if (r8.isStarProjection() == false) goto L7;
        return r8;
    L7:
        TypeWithEnhancement r0 = r8.getType();
        if ((r0 instanceof TypeWithEnhancement) == false) goto L15;
        TypeWithEnhancement r1 = r0;
        UnwrappedType r2 = r1.getOrigin();
        KotlinType r3 = r1.getEnhancement();
        TypeProjection r11 = unsafeSubstitute(new TypeProjectionImpl(r8.getProjectionKind(), r2), r9, r10 + 1);
        if (r11.isStarProjection() == false) goto L13;
        return r11;
    L13:
        return new TypeProjectionImpl(r11.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(r11.getType().unwrap(), substitute(r3, r8.getProjectionKind())));
    L15:
        if (DynamicTypesKt.isDynamic(r0) == false) goto L17;
    L69:
        return r8;
    L17:
        if ((r0.unwrap() instanceof RawType) == true) goto L69;
        TypeProjection r4 = this.substitution.mo385get(r0);
        if (r4 == null) goto L22;
        TypeProjection r5 = projectedTypeForConflictedTypeWithUnsafeVariance(r0, r4, r9, r8);
    L23:
        Variance r6 = r8.getProjectionKind();
        if (r5 != null) goto L37;
        if (FlexibleTypesKt.isFlexible(r0) == false) goto L37;
        if (TypeCapabilitiesKt.isCustomTypeParameter(r0) == true) goto L37;
        FlexibleType r7 = FlexibleTypesKt.asFlexibleType(r0);
        int r12 = r10 + 1;
        TypeProjection r13 = unsafeSubstitute(new TypeProjectionImpl(r6, r7.getLowerBound()), r9, r12);
        TypeProjection r14 = unsafeSubstitute(new TypeProjectionImpl(r6, r7.getUpperBound()), r9, r12);
        Variance r15 = r13.getProjectionKind();
        if (r13.getType() != r7.getLowerBound()) goto L35;
        if (r14.getType() != r7.getUpperBound()) goto L35;
        return r8;
    L35:
        return new TypeProjectionImpl(r15, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(r13.getType()), TypeSubstitutionKt.asSimpleType(r14.getType())));
    L37:
        if (KotlinBuiltIns.isNothing(r0) == true) goto L69;
        if (KotlinTypeKt.isError(r0) == true) goto L69;
        if (r5 == null) goto L66;
        VarianceConflictType r16 = conflictType(r6, r5.getProjectionKind());
        if (CapturedTypeConstructorKt.isCaptured(r0) == true) goto L52;
        int r17 = 2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[r16.ordinal()];
        if (r17 == 1) goto L51;
        if (r17 != 2) goto L52;
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r0.getConstructor().getBuiltIns().getNullableAnyType());
    L51:
        throw new SubstitutionException("Out-projection in in-position");
    L52:
        CustomTypeParameter r18 = TypeCapabilitiesKt.getCustomTypeParameter(r0);
        if (r5.isStarProjection() == false) goto L55;
        return r5;
    L55:
        if (r18 == null) goto L57;
        KotlinType r19 = r18.substitutionResult(r5.getType());
    L59:
        if (r0.getAnnotations().isEmpty() == true) goto L62;
        r19 = TypeUtilsKt.replaceAnnotations(r19, new CompositeAnnotations(new Annotations[]{r19.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(r0.getAnnotations()))}));
    L62:
        if (r16 != VarianceConflictType.NO_CONFLICT) goto L65;
        r6 = combine(r6, r5.getProjectionKind());
    L65:
        return new TypeProjectionImpl(r6, r19);
    L57:
        r19 = TypeUtils.makeNullableIfNeeded(r5.getType(), r0.isMarkedNullable());
        goto L59
    L66:
        r8 = substituteCompoundType(r8, r10);
        if (r8 != null) goto L69;
        $$$reportNull$$$0(25);
        goto L69
    L22:
        r5 = null;
        goto L23
    }

    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(KotlinType r2, TypeProjection r3, TypeParameterDescriptor r4, TypeProjection r5) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(27);
    L6:
        if (r5 != null) goto L9;
        $$$reportNull$$$0(28);
    L9:
        if (r2.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L13;
        if (r3 != null) goto L12;
        $$$reportNull$$$0(29);
    L12:
        return r3;
    L13:
        NewCapturedTypeConstructor r6 = r3.getType().getConstructor();
        if ((r6 instanceof NewCapturedTypeConstructor) == true) goto L16;
        return r3;
    L16:
        TypeProjection r7 = r6.getProjection();
        Variance r0 = r7.getProjectionKind();
        VarianceConflictType r8 = conflictType(r5.getProjectionKind(), r0);
        VarianceConflictType r1 = VarianceConflictType.OUT_IN_IN_POSITION;
        if (r8 == r1) goto L19;
        if (r4 != null) goto L23;
        return r3;
    L23:
        if (conflictType(r4.getVariance(), r0) == r1) goto L25;
        return r3;
    L25:
        return new TypeProjectionImpl(r7.getType());
    L19:
        return new TypeProjectionImpl(r7.getType());
    }
}
