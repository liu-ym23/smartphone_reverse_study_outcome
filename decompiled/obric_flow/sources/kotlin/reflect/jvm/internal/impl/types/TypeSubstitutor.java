package kotlin.reflect.jvm.internal.impl.types;

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

/* JADX INFO: loaded from: classes3.dex */
public class TypeSubstitutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TypeSubstitutor EMPTY = null;
    private final TypeSubstitution substitution;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = null;

        static {
            int[] r5 = new int[VarianceConflictType.values().length];
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = r5;
            r5[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class SubstitutionException extends Exception {
        public SubstitutionException(String r5) {
            super(r5);
        }
    }

    public static final enum VarianceConflictType extends Enum<VarianceConflictType> {
        private static final /* synthetic */ VarianceConflictType[] $VALUES = null;
        public static final VarianceConflictType IN_IN_OUT_POSITION = null;
        public static final VarianceConflictType NO_CONFLICT = null;
        public static final VarianceConflictType OUT_IN_IN_POSITION = null;

        static {
            VarianceConflictType r5 = new VarianceConflictType("NO_CONFLICT", 0);
            NO_CONFLICT = r5;
            VarianceConflictType r10 = new VarianceConflictType("IN_IN_OUT_POSITION", 1);
            IN_IN_OUT_POSITION = r10;
            VarianceConflictType r11 = new VarianceConflictType("OUT_IN_IN_POSITION", 2);
            OUT_IN_IN_POSITION = r11;
            $VALUES = new VarianceConflictType[]{r5, r10, r11};
        }

        private VarianceConflictType(String r5, int r10) {
            super(r5, r10);
        }

        public static VarianceConflictType valueOf(String r5) {
            return (VarianceConflictType) Enum.valueOf(VarianceConflictType.class, r5);
        }

        public static VarianceConflictType[] values() {
            return (VarianceConflictType[]) $VALUES.clone();
        }
    }

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
        if (r13 == 2) goto L85;
        if (r13 == 8) goto L86;
        if (r13 == 34) goto L87;
        if (r13 == 37) goto L88;
        switch(r13) {
            case 11: goto L89;
            case 12: goto L89;
            case 13: goto L89;
            default: goto L20;
        };
    L20:
        switch(r13) {
            case 19: goto L90;
            case 20: goto L90;
            case 21: goto L90;
            case 22: goto L90;
            case 23: goto L90;
            case 24: goto L90;
            case 25: goto L90;
            default: goto L21;
        };
    L21:
        switch(r13) {
            case 29: goto L91;
            case 30: goto L91;
            case 31: goto L91;
            case 32: goto L91;
            default: goto L22;
        };
    L22:
        switch(r13) {
            case 40: goto L92;
            case 41: goto L92;
            case 42: goto L92;
            default: goto L23;
        };
    L23:
        int r10 = 3;
    L25:
        Object[] r11 = new Object[r10];
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
        r11[0] = "substitution";
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
        r11[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
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
        r11[2] = "create";
        goto L72
    L63:
        r11[2] = "combine";
        goto L72
    L64:
        r11[2] = "filterOutUnsafeVariance";
        goto L72
    L65:
        r11[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L72
    L66:
        r11[2] = "unsafeSubstitute";
        goto L72
    L67:
        r11[2] = "substituteWithoutApproximation";
        goto L72
    L68:
        r11[2] = "substitute";
        goto L72
    L69:
        r11[2] = "safeSubstitute";
        goto L72
    L70:
        r11[2] = "<init>";
        goto L72
    L71:
        r11[2] = "createChainedSubstitutor";
    L72:
        String r12 = String.format(r5, r11);
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
            default: goto L93;
        };
    L93:
        throw new IllegalArgumentException(r12);
    L84:
        throw new IllegalStateException(r12);
    L53:
        r11[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L61
    L54:
        r11[1] = "unsafeSubstitute";
        goto L61
    L55:
        r11[1] = "safeSubstitute";
    L56:
        r11[1] = "combine";
        goto L61
    L57:
        r11[1] = "filterOutUnsafeVariance";
        goto L61
    L58:
        r11[1] = "getSubstitution";
        goto L61
    L59:
        r11[1] = "replaceWithContravariantApproximatingSubstitution";
        goto L61
    L60:
        r11[1] = "replaceWithNonApproximatingSubstitution";
        goto L61
    L28:
        r11[0] = "projectionKind";
        goto L43
    L29:
        r11[0] = "typeParameterVariance";
        goto L43
    L30:
        r11[0] = "annotations";
        goto L43
    L31:
        r11[0] = "substituted";
        goto L43
    L32:
        r11[0] = "originalType";
        goto L43
    L33:
        r11[0] = "originalProjection";
        goto L43
    L34:
        r11[0] = "typeProjection";
        goto L43
    L35:
        r11[0] = "howThisTypeIsUsed";
        goto L43
    L36:
        r11[0] = "type";
        goto L43
    L37:
        r11[0] = "context";
        goto L43
    L38:
        r11[0] = "substitutionContext";
        goto L43
    L39:
        r11[0] = "second";
        goto L43
    L40:
        r11[0] = "first";
        goto L43
    L41:
        r11[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
        goto L43
    L92:
        r10 = 2;
        goto L25
    L91:
        r10 = 2;
        goto L25
    L90:
        r10 = 2;
        goto L25
    L89:
        r10 = 2;
        goto L25
    L88:
        r10 = 2;
        goto L25
    L87:
        r10 = 2;
        goto L25
    L86:
        r10 = 2;
        goto L25
    L85:
        r10 = 2;
        goto L25
    L24:
        r10 = 2;
    L13:
        r5 = "@NotNull method %s.%s must not return null";
        goto L14
    }

    static {
        EMPTY = create(TypeSubstitution.EMPTY);
    }

    public TypeSubstitutor(TypeSubstitution r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        this.substitution = r5;
    }

    private static void assertRecursionDepth(int r5, TypeProjection r10, TypeSubstitution r11) {
        if (r5 > 100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(r10) + "; substitution: " + safeToString(r11));
    }

    public static Variance combine(Variance r5, TypeProjection r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(36);
    L7:
        if (r10.isStarProjection() == false) goto L13;
        Variance r11 = Variance.OUT_VARIANCE;
        if (r11 != null) goto L11;
        $$$reportNull$$$0(37);
    L11:
        return r11;
    L13:
        return combine(r5, r10.getProjectionKind());
    }

    private static VarianceConflictType conflictType(Variance r5, Variance r10) {
        Variance r11 = Variance.IN_VARIANCE;
        if (r5 != r11) goto L9;
        if (r10 != Variance.OUT_VARIANCE) goto L9;
        return VarianceConflictType.OUT_IN_IN_POSITION;
    L9:
        if (r5 != Variance.OUT_VARIANCE) goto L14;
        if (r10 != r11) goto L14;
        return VarianceConflictType.IN_IN_OUT_POSITION;
    L14:
        return VarianceConflictType.NO_CONFLICT;
    }

    public static TypeSubstitutor create(TypeSubstitution r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new TypeSubstitutor(r5);
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution r5, TypeSubstitution r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return create(DisjointKeysUnionTypeSubstitution.create(r5, r10));
    }

    private static Annotations filterOutUnsafeVariance(Annotations r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(33);
    L5:
        if (r5.hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L8;
        return r5;
    L8:
        return new FilteredAnnotations(r5, new AnonymousClass1());
    }

    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(KotlinType r5, TypeProjection r10, TypeParameterDescriptor r11, TypeProjection r12) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(27);
    L6:
        if (r12 != null) goto L9;
        $$$reportNull$$$0(28);
    L9:
        if (r5.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L13;
        if (r10 != null) goto L12;
        $$$reportNull$$$0(29);
    L12:
        return r10;
    L13:
        TypeConstructor r13 = r10.getType().getConstructor();
        if ((r13 instanceof NewCapturedTypeConstructor) == true) goto L16;
        return r10;
    L16:
        TypeProjection r14 = ((NewCapturedTypeConstructor) r13).getProjection();
        Variance r15 = r14.getProjectionKind();
        VarianceConflictType r16 = conflictType(r12.getProjectionKind(), r15);
        VarianceConflictType r17 = VarianceConflictType.OUT_IN_IN_POSITION;
        if (r16 == r17) goto L19;
        if (r11 != null) goto L23;
        return r10;
    L23:
        if (conflictType(r11.getVariance(), r15) == r17) goto L25;
        return r10;
    L25:
        return new TypeProjectionImpl(r14.getType());
    L19:
        return new TypeProjectionImpl(r14.getType());
    }

    private static String safeToString(Object r5) {
        return r5.toString();
    L4:
        th = move-exception;
        if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L10;
        return "[Exception while computing toString(): " + th + "]";
    L10:
        throw th;
    }

    private TypeProjection substituteCompoundType(TypeProjection r5, int r10) throws SubstitutionException {
        KotlinType r11 = r5.getType();
        Variance r12 = r5.getProjectionKind();
        if ((r11.getConstructor().mo1402getDeclarationDescriptor() instanceof TypeParameterDescriptor) == false) goto L5;
        return r5;
    L5:
        SimpleType r13 = SpecialTypesKt.getAbbreviation(r11);
        if (r13 == null) goto L8;
        KotlinType r14 = replaceWithNonApproximatingSubstitution().substitute(r13, Variance.INVARIANT);
    L9:
        KotlinType r15 = TypeSubstitutionKt.replace(r11, substituteTypeArguments(r11.getConstructor().getParameters(), r11.getArguments(), r10), this.substitution.filterAnnotations(r11.getAnnotations()));
        if ((r15 instanceof SimpleType) == false) goto L15;
        if ((r14 instanceof SimpleType) == false) goto L15;
        r15 = SpecialTypesKt.withAbbreviation((SimpleType) r15, (SimpleType) r14);
    L15:
        return new TypeProjectionImpl(r12, r15);
    L8:
        r14 = null;
        goto L9
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> r11, List<TypeProjection> r12, int r13) throws SubstitutionException {
        ArrayList r5 = new ArrayList(r11.size());
        int r10 = 0;
        boolean r14 = false;
    L4:
        if (r10 >= r11.size()) goto L21;
        TypeParameterDescriptor r15 = r11.get(r10);
        TypeProjection r16 = r12.get(r10);
        TypeProjection r17 = unsafeSubstitute(r16, r15, r13 + 1);
        int r18 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(r15.getVariance(), r17.getProjectionKind()).ordinal()];
        if (r18 != 1) goto L8;
    L17:
        r17 = TypeUtils.makeStarProjection(r15);
    L18:
        if (r17 == r16) goto L20;
        r14 = true;
    L20:
        r5.add(r17);
        r10 = r10 + 1;
        goto L4
    L8:
        if (r18 == 2) goto L17;
        if (r18 != 3) goto L18;
        Variance r19 = r15.getVariance();
        Variance r20 = Variance.INVARIANT;
        if (r19 == r20) goto L18;
        if (r17.isStarProjection() == true) goto L18;
        r17 = new TypeProjectionImpl(r20, r17.getType());
        goto L18
    L21:
        if (r14 == true) goto L23;
        return r12;
    L23:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private TypeProjection unsafeSubstitute(TypeProjection r10, TypeParameterDescriptor r11, int r12) throws SubstitutionException {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        assertRecursionDepth(r12, r10, this.substitution);
        if (r10.isStarProjection() == false) goto L8;
        return r10;
    L8:
        KotlinType r5 = r10.getType();
        if ((r5 instanceof TypeWithEnhancement) == false) goto L16;
        TypeWithEnhancement r13 = (TypeWithEnhancement) r5;
        UnwrappedType r14 = r13.getOrigin();
        KotlinType r15 = r13.getEnhancement();
        TypeProjection r16 = unsafeSubstitute(new TypeProjectionImpl(r10.getProjectionKind(), r14), r11, r12 + 1);
        if (r16.isStarProjection() == false) goto L14;
        return r16;
    L14:
        return new TypeProjectionImpl(r16.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(r16.getType().unwrap(), substitute(r15, r10.getProjectionKind())));
    L16:
        if (DynamicTypesKt.isDynamic(r5) == false) goto L18;
    L71:
        return r10;
    L18:
        if ((r5.unwrap() instanceof RawType) == true) goto L71;
        TypeProjection r17 = this.substitution.mo1407get(r5);
        if (r17 == null) goto L23;
        TypeProjection r18 = projectedTypeForConflictedTypeWithUnsafeVariance(r5, r17, r11, r10);
    L24:
        Variance r19 = r10.getProjectionKind();
        if (r18 != null) goto L38;
        if (FlexibleTypesKt.isFlexible(r5) == false) goto L38;
        if (TypeCapabilitiesKt.isCustomTypeParameter(r5) == true) goto L38;
        FlexibleType r20 = FlexibleTypesKt.asFlexibleType(r5);
        int r21 = r12 + 1;
        TypeProjection r22 = unsafeSubstitute(new TypeProjectionImpl(r19, r20.getLowerBound()), r11, r21);
        TypeProjection r23 = unsafeSubstitute(new TypeProjectionImpl(r19, r20.getUpperBound()), r11, r21);
        Variance r24 = r22.getProjectionKind();
        if (r22.getType() != r20.getLowerBound()) goto L36;
        if (r23.getType() != r20.getUpperBound()) goto L36;
        return r10;
    L36:
        return new TypeProjectionImpl(r24, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(r22.getType()), TypeSubstitutionKt.asSimpleType(r23.getType())));
    L38:
        if (KotlinBuiltIns.isNothing(r5) == true) goto L71;
        if (KotlinTypeKt.isError(r5) == true) goto L71;
        if (r18 == null) goto L67;
        VarianceConflictType r25 = conflictType(r19, r18.getProjectionKind());
        if (CapturedTypeConstructorKt.isCaptured(r5) == true) goto L53;
        int r26 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[r25.ordinal()];
        if (r26 == 1) goto L52;
        if (r26 != 2) goto L53;
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r5.getConstructor().getBuiltIns().getNullableAnyType());
    L52:
        throw new SubstitutionException("Out-projection in in-position");
    L53:
        CustomTypeParameter r27 = TypeCapabilitiesKt.getCustomTypeParameter(r5);
        if (r18.isStarProjection() == false) goto L56;
        return r18;
    L56:
        if (r27 == null) goto L58;
        KotlinType r28 = r27.substitutionResult(r18.getType());
    L60:
        if (r5.getAnnotations().isEmpty() == true) goto L63;
        r28 = TypeUtilsKt.replaceAnnotations(r28, new CompositeAnnotations(new Annotations[]{r28.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(r5.getAnnotations()))}));
    L63:
        if (r25 != VarianceConflictType.NO_CONFLICT) goto L66;
        r19 = combine(r19, r18.getProjectionKind());
    L66:
        return new TypeProjectionImpl(r19, r28);
    L58:
        r28 = TypeUtils.makeNullableIfNeeded(r18.getType(), r5.isMarkedNullable());
        goto L60
    L67:
        TypeProjection r29 = substituteCompoundType(r10, r12);
        if (r29 != null) goto L70;
        $$$reportNull$$$0(25);
    L70:
        return r29;
    L23:
        r18 = null;
        goto L24
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution r5 = this.substitution;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r5;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution r5 = this.substitution;
        if ((r5 instanceof IndexedParametersSubstitution) == true) goto L5;
    L9:
        return this;
    L5:
        if (r5.approximateContravariantCapturedTypes() == false) goto L9;
        return new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.substitution).getParameters(), ((IndexedParametersSubstitution) this.substitution).getArguments(), false));
    }

    public KotlinType safeSubstitute(KotlinType r5, Variance r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r10 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        if (isEmpty() == false) goto L20;
        if (r5 != null) goto L10;
        $$$reportNull$$$0(11);
    L10:
        return r5;
    L20:
        KotlinType r11 = unsafeSubstitute(new TypeProjectionImpl(r10, r5), null, 0).getType();     // Catch: SubstitutionException -> L15
        if (r11 != null) goto L14;
        $$$reportNull$$$0(12);
    L14:
        return r11;
    L15:
        e = move-exception;
        ErrorType r12 = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, new String[]{e.getMessage()});
        if (r12 != null) goto L19;
        $$$reportNull$$$0(13);
    L19:
        return r12;
    }

    public KotlinType substitute(KotlinType r5, Variance r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(15);
    L6:
        TypeProjection r11 = substitute(new TypeProjectionImpl(r10, getSubstitution().prepareTopLevelType(r5, r10)));
        if (r11 != null) goto L10;
        return null;
    L10:
        return r11.getType();
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        if (isEmpty() == false) goto L11;
        return r5;
    L11:
        return unsafeSubstitute(r5, null, 0);
    L10:
        return null;
    }

    public static TypeSubstitutor create(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return create(TypeConstructorSubstitution.create(r5.getConstructor(), r5.getArguments()));
    }

    public static Variance combine(Variance r5, Variance r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(38);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(39);
    L6:
        Variance r11 = Variance.INVARIANT;
        if (r5 != r11) goto L11;
        if (r10 != null) goto L10;
        $$$reportNull$$$0(40);
    L10:
        return r10;
    L11:
        if (r10 != r11) goto L15;
        if (r5 != null) goto L14;
        $$$reportNull$$$0(41);
    L14:
        return r5;
    L15:
        if (r5 != r10) goto L20;
        if (r10 != null) goto L18;
        $$$reportNull$$$0(42);
    L18:
        return r10;
    L20:
        throw new AssertionError("Variance conflict: type parameter variance '" + r5 + "' and projection kind '" + r10 + "' cannot be combined");
    }

    public TypeProjection substitute(TypeProjection r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        TypeProjection r10 = substituteWithoutApproximation(r5);
        if (this.substitution.approximateCapturedTypes() == true) goto L10;
        if (this.substitution.approximateContravariantCapturedTypes() == true) goto L10;
        return r10;
    L10:
        return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(r10, this.substitution.approximateContravariantCapturedTypes());
    }
}
