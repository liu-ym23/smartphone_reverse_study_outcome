package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.common.wschannel.WsConstants;
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
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = null;

        static {
            int[] r10 = new int[VarianceConflictType.values().length];
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType = r10;
            r10[VarianceConflictType.OUT_IN_IN_POSITION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.IN_IN_OUT_POSITION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[VarianceConflictType.NO_CONFLICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static final class SubstitutionException extends Exception {
        public SubstitutionException(String r10) {
            super(r10);
        }
    }

    private static final enum VarianceConflictType extends Enum<VarianceConflictType> {
        private static final /* synthetic */ VarianceConflictType[] $VALUES = null;
        public static final VarianceConflictType IN_IN_OUT_POSITION = null;
        public static final VarianceConflictType NO_CONFLICT = null;
        public static final VarianceConflictType OUT_IN_IN_POSITION = null;

        static {
            VarianceConflictType r10 = new VarianceConflictType("NO_CONFLICT", 0);
            NO_CONFLICT = r10;
            VarianceConflictType r11 = new VarianceConflictType("IN_IN_OUT_POSITION", 1);
            IN_IN_OUT_POSITION = r11;
            VarianceConflictType r12 = new VarianceConflictType("OUT_IN_IN_POSITION", 2);
            OUT_IN_IN_POSITION = r12;
            $VALUES = new VarianceConflictType[]{r10, r11, r12};
        }

        private VarianceConflictType(String r10, int r11) {
            super(r10, r11);
        }

        public static VarianceConflictType valueOf(String r10) {
            return (VarianceConflictType) Enum.valueOf(VarianceConflictType.class, r10);
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
        String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
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
        int r11 = 3;
    L25:
        Object[] r12 = new Object[r11];
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
        r12[0] = "substitution";
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
        r12[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
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
        r12[2] = "create";
        goto L72
    L63:
        r12[2] = "combine";
        goto L72
    L64:
        r12[2] = "filterOutUnsafeVariance";
        goto L72
    L65:
        r12[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L72
    L66:
        r12[2] = "unsafeSubstitute";
        goto L72
    L67:
        r12[2] = "substituteWithoutApproximation";
        goto L72
    L68:
        r12[2] = "substitute";
        goto L72
    L69:
        r12[2] = "safeSubstitute";
        goto L72
    L70:
        r12[2] = "<init>";
        goto L72
    L71:
        r12[2] = "createChainedSubstitutor";
    L72:
        String r14 = String.format(r10, r12);
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
        throw new IllegalArgumentException(r14);
    L84:
        throw new IllegalStateException(r14);
    L53:
        r12[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
        goto L61
    L54:
        r12[1] = "unsafeSubstitute";
        goto L61
    L55:
        r12[1] = "safeSubstitute";
    L56:
        r12[1] = "combine";
        goto L61
    L57:
        r12[1] = "filterOutUnsafeVariance";
        goto L61
    L58:
        r12[1] = "getSubstitution";
        goto L61
    L59:
        r12[1] = "replaceWithContravariantApproximatingSubstitution";
        goto L61
    L60:
        r12[1] = "replaceWithNonApproximatingSubstitution";
        goto L61
    L28:
        r12[0] = "projectionKind";
        goto L43
    L29:
        r12[0] = "typeParameterVariance";
        goto L43
    L30:
        r12[0] = "annotations";
        goto L43
    L31:
        r12[0] = "substituted";
        goto L43
    L32:
        r12[0] = "originalType";
        goto L43
    L33:
        r12[0] = "originalProjection";
        goto L43
    L34:
        r12[0] = "typeProjection";
        goto L43
    L35:
        r12[0] = "howThisTypeIsUsed";
        goto L43
    L36:
        r12[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L43
    L37:
        r12[0] = "context";
        goto L43
    L38:
        r12[0] = "substitutionContext";
        goto L43
    L39:
        r12[0] = "second";
        goto L43
    L40:
        r12[0] = "first";
        goto L43
    L41:
        r12[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
        goto L43
    L92:
        r11 = 2;
        goto L25
    L91:
        r11 = 2;
        goto L25
    L90:
        r11 = 2;
        goto L25
    L89:
        r11 = 2;
        goto L25
    L88:
        r11 = 2;
        goto L25
    L87:
        r11 = 2;
        goto L25
    L86:
        r11 = 2;
        goto L25
    L85:
        r11 = 2;
        goto L25
    L24:
        r11 = 2;
    L13:
        r10 = "@NotNull method %s.%s must not return null";
        goto L14
    }

    static {
        EMPTY = create(TypeSubstitution.EMPTY);
    }

    protected TypeSubstitutor(TypeSubstitution r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        this.substitution = r10;
    }

    private static void assertRecursionDepth(int r10, TypeProjection r11, TypeSubstitution r12) {
        if (r10 > 100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + safeToString(r11) + "; substitution: " + safeToString(r12));
    }

    public static Variance combine(Variance r10, TypeProjection r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(35);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(36);
    L7:
        if (r11.isStarProjection() == false) goto L13;
        Variance r12 = Variance.OUT_VARIANCE;
        if (r12 != null) goto L11;
        $$$reportNull$$$0(37);
    L11:
        return r12;
    L13:
        return combine(r10, r11.getProjectionKind());
    }

    public static Variance combine(Variance r10, Variance r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(38);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(39);
    L6:
        Variance r12 = Variance.INVARIANT;
        if (r10 != r12) goto L11;
        if (r11 != null) goto L10;
        $$$reportNull$$$0(40);
    L10:
        return r11;
    L11:
        if (r11 != r12) goto L15;
        if (r10 != null) goto L14;
        $$$reportNull$$$0(41);
    L14:
        return r10;
    L15:
        if (r10 != r11) goto L20;
        if (r11 != null) goto L18;
        $$$reportNull$$$0(42);
    L18:
        return r11;
    L20:
        throw new AssertionError("Variance conflict: type parameter variance '" + r10 + "' and projection kind '" + r11 + "' cannot be combined");
    }

    private static VarianceConflictType conflictType(Variance r10, Variance r11) {
        Variance r12 = Variance.IN_VARIANCE;
        if (r10 != r12) goto L9;
        if (r11 != Variance.OUT_VARIANCE) goto L9;
        return VarianceConflictType.OUT_IN_IN_POSITION;
    L9:
        if (r10 != Variance.OUT_VARIANCE) goto L14;
        if (r11 != r12) goto L14;
        return VarianceConflictType.IN_IN_OUT_POSITION;
    L14:
        return VarianceConflictType.NO_CONFLICT;
    }

    public static TypeSubstitutor create(KotlinType r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return create(TypeConstructorSubstitution.create(r10.getConstructor(), r10.getArguments()));
    }

    public static TypeSubstitutor create(TypeSubstitution r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new TypeSubstitutor(r10);
    }

    public static TypeSubstitutor createChainedSubstitutor(TypeSubstitution r10, TypeSubstitution r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return create(DisjointKeysUnionTypeSubstitution.create(r10, r11));
    }

    private static Annotations filterOutUnsafeVariance(Annotations r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(33);
    L5:
        if (r10.hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L8;
        return r10;
    L8:
        return new FilteredAnnotations(r10, new AnonymousClass1());
    }

    private static TypeProjection projectedTypeForConflictedTypeWithUnsafeVariance(KotlinType r10, TypeProjection r11, TypeParameterDescriptor r12, TypeProjection r13) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(27);
    L6:
        if (r13 != null) goto L9;
        $$$reportNull$$$0(28);
    L9:
        if (r10.getAnnotations().hasAnnotation(StandardNames.FqNames.unsafeVariance) == true) goto L13;
        if (r11 != null) goto L12;
        $$$reportNull$$$0(29);
    L12:
        return r11;
    L13:
        TypeConstructor r14 = r11.getType().getConstructor();
        if ((r14 instanceof NewCapturedTypeConstructor) == true) goto L16;
        return r11;
    L16:
        TypeProjection r15 = ((NewCapturedTypeConstructor) r14).getProjection();
        Variance r16 = r15.getProjectionKind();
        VarianceConflictType r17 = conflictType(r13.getProjectionKind(), r16);
        VarianceConflictType r18 = VarianceConflictType.OUT_IN_IN_POSITION;
        if (r17 == r18) goto L19;
        if (r12 != null) goto L23;
        return r11;
    L23:
        if (conflictType(r12.getVariance(), r16) == r18) goto L25;
        return r11;
    L25:
        return new TypeProjectionImpl(r15.getType());
    L19:
        return new TypeProjectionImpl(r15.getType());
    }

    private static String safeToString(Object r10) {
        return r10.toString();
    L4:
        th = move-exception;
        if (ExceptionUtilsKt.isProcessCanceledException(th) == true) goto L10;
        return "[Exception while computing toString(): " + th + "]";
    L10:
        throw th;
    }

    private TypeProjection substituteCompoundType(TypeProjection r10, int r11) {
        KotlinType r12 = r10.getType();
        Variance r13 = r10.getProjectionKind();
        if ((r12.getConstructor().mo1323getDeclarationDescriptor() instanceof TypeParameterDescriptor) == false) goto L5;
        return r10;
    L5:
        KotlinType r14 = null;
        SimpleType r15 = SpecialTypesKt.getAbbreviation(r12);
        if (r15 == null) goto L8;
        r14 = replaceWithNonApproximatingSubstitution().substitute(r15, Variance.INVARIANT);
    L8:
        KotlinType r16 = TypeSubstitutionKt.replace(r12, substituteTypeArguments(r12.getConstructor().getParameters(), r12.getArguments(), r11), this.substitution.filterAnnotations(r12.getAnnotations()));
        if ((r16 instanceof SimpleType) == false) goto L14;
        if ((r14 instanceof SimpleType) == false) goto L14;
        r16 = SpecialTypesKt.withAbbreviation((SimpleType) r16, (SimpleType) r14);
    L14:
        return new TypeProjectionImpl(r13, r16);
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> r11, List<TypeProjection> r12, int r13) {
        ArrayList r10 = new ArrayList(r11.size());
        int r14 = 0;
        boolean r15 = false;
    L4:
        if (r14 >= r11.size()) goto L21;
        TypeParameterDescriptor r16 = r11.get(r14);
        TypeProjection r17 = r12.get(r14);
        TypeProjection r18 = unsafeSubstitute(r17, r16, r13 + 1);
        int r19 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[conflictType(r16.getVariance(), r18.getProjectionKind()).ordinal()];
        if (r19 != 1) goto L8;
    L17:
        r18 = TypeUtils.makeStarProjection(r16);
    L18:
        if (r18 == r17) goto L20;
        r15 = true;
    L20:
        r10.add(r18);
        r14 = r14 + 1;
        goto L4
    L8:
        if (r19 == 2) goto L17;
        if (r19 != 3) goto L18;
        Variance r20 = r16.getVariance();
        Variance r21 = Variance.INVARIANT;
        if (r20 == r21) goto L18;
        if (r18.isStarProjection() == true) goto L18;
        r18 = new TypeProjectionImpl(r21, r18.getType());
        goto L18
    L21:
        if (r15 == true) goto L23;
        return r12;
    L23:
        return r10;
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
    private TypeProjection unsafeSubstitute(TypeProjection r10, TypeParameterDescriptor r11, int r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(18);
    L4:
        assertRecursionDepth(r12, r10, this.substitution);
        if (r10.isStarProjection() == false) goto L7;
        return r10;
    L7:
        KotlinType r13 = r10.getType();
        if ((r13 instanceof TypeWithEnhancement) == false) goto L15;
        TypeWithEnhancement r14 = (TypeWithEnhancement) r13;
        UnwrappedType r15 = r14.getOrigin();
        KotlinType r16 = r14.getEnhancement();
        TypeProjection r17 = unsafeSubstitute(new TypeProjectionImpl(r10.getProjectionKind(), r15), r11, r12 + 1);
        if (r17.isStarProjection() == false) goto L13;
        return r17;
    L13:
        return new TypeProjectionImpl(r17.getProjectionKind(), TypeWithEnhancementKt.wrapEnhancement(r17.getType().unwrap(), substitute(r16, r10.getProjectionKind())));
    L15:
        if (DynamicTypesKt.isDynamic(r13) == false) goto L17;
    L70:
        return r10;
    L17:
        if ((r13.unwrap() instanceof RawType) == true) goto L70;
        TypeProjection r18 = this.substitution.mo1328get(r13);
        if (r18 == null) goto L22;
        TypeProjection r19 = projectedTypeForConflictedTypeWithUnsafeVariance(r13, r18, r11, r10);
    L23:
        Variance r20 = r10.getProjectionKind();
        if (r19 != null) goto L37;
        if (FlexibleTypesKt.isFlexible(r13) == false) goto L37;
        if (TypeCapabilitiesKt.isCustomTypeParameter(r13) == true) goto L37;
        FlexibleType r21 = FlexibleTypesKt.asFlexibleType(r13);
        int r22 = r12 + 1;
        TypeProjection r23 = unsafeSubstitute(new TypeProjectionImpl(r20, r21.getLowerBound()), r11, r22);
        TypeProjection r24 = unsafeSubstitute(new TypeProjectionImpl(r20, r21.getUpperBound()), r11, r22);
        Variance r25 = r23.getProjectionKind();
        if (r23.getType() != r21.getLowerBound()) goto L35;
        if (r24.getType() != r21.getUpperBound()) goto L35;
        return r10;
    L35:
        return new TypeProjectionImpl(r25, KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(r23.getType()), TypeSubstitutionKt.asSimpleType(r24.getType())));
    L37:
        if (KotlinBuiltIns.isNothing(r13) == true) goto L70;
        if (KotlinTypeKt.isError(r13) == true) goto L70;
        if (r19 == null) goto L66;
        VarianceConflictType r26 = conflictType(r20, r19.getProjectionKind());
        if (CapturedTypeConstructorKt.isCaptured(r13) == true) goto L52;
        int r27 = AnonymousClass2.$SwitchMap$org$jetbrains$kotlin$types$TypeSubstitutor$VarianceConflictType[r26.ordinal()];
        if (r27 == 1) goto L51;
        if (r27 != 2) goto L52;
        return new TypeProjectionImpl(Variance.OUT_VARIANCE, r13.getConstructor().getBuiltIns().getNullableAnyType());
    L51:
        throw new SubstitutionException("Out-projection in in-position");
    L52:
        CustomTypeParameter r28 = TypeCapabilitiesKt.getCustomTypeParameter(r13);
        if (r19.isStarProjection() == false) goto L55;
        return r19;
    L55:
        if (r28 == null) goto L57;
        KotlinType r29 = r28.substitutionResult(r19.getType());
    L59:
        if (r13.getAnnotations().isEmpty() == true) goto L62;
        r29 = TypeUtilsKt.replaceAnnotations(r29, new CompositeAnnotations(new Annotations[]{r29.getAnnotations(), filterOutUnsafeVariance(this.substitution.filterAnnotations(r13.getAnnotations()))}));
    L62:
        if (r26 != VarianceConflictType.NO_CONFLICT) goto L65;
        r20 = combine(r20, r19.getProjectionKind());
    L65:
        return new TypeProjectionImpl(r20, r29);
    L57:
        r29 = TypeUtils.makeNullableIfNeeded(r19.getType(), r13.isMarkedNullable());
        goto L59
    L66:
        TypeProjection r30 = substituteCompoundType(r10, r12);
        if (r30 != null) goto L69;
        $$$reportNull$$$0(25);
    L69:
        return r30;
    L22:
        r19 = null;
        goto L23
    }

    public TypeSubstitution getSubstitution() {
        TypeSubstitution r10 = this.substitution;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r10;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    public TypeSubstitutor replaceWithNonApproximatingSubstitution() {
        TypeSubstitution r10 = this.substitution;
        if ((r10 instanceof IndexedParametersSubstitution) == true) goto L5;
    L9:
        return this;
    L5:
        if (r10.approximateContravariantCapturedTypes() == false) goto L9;
        return new TypeSubstitutor(new IndexedParametersSubstitution(((IndexedParametersSubstitution) this.substitution).getParameters(), ((IndexedParametersSubstitution) this.substitution).getArguments(), false));
    }

    public KotlinType safeSubstitute(KotlinType r10, Variance r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(9);
    L4:
        if (r11 != null) goto L7;
        $$$reportNull$$$0(10);
    L7:
        if (isEmpty() == false) goto L21;
        if (r10 != null) goto L10;
        $$$reportNull$$$0(11);
    L10:
        return r10;
    L21:
        KotlinType r12 = unsafeSubstitute(new TypeProjectionImpl(r11, r10), null, 0).getType();     // Catch: SubstitutionException -> L16
        if (r12 != null) goto L15;
        $$$reportNull$$$0(12);
    L15:
        return r12;
    L16:
        e = move-exception;
        ErrorType r13 = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, new String[]{e.getMessage()});
        if (r13 != null) goto L20;
        $$$reportNull$$$0(13);
    L20:
        return r13;
    }

    public KotlinType substitute(KotlinType r10, Variance r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(14);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(15);
    L6:
        TypeProjection r12 = substitute(new TypeProjectionImpl(r11, getSubstitution().prepareTopLevelType(r10, r11)));
        if (r12 != null) goto L10;
        return null;
    L10:
        return r12.getType();
    }

    public TypeProjection substitute(TypeProjection r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        TypeProjection r11 = substituteWithoutApproximation(r10);
        if (this.substitution.approximateCapturedTypes() == true) goto L10;
        if (this.substitution.approximateContravariantCapturedTypes() == true) goto L10;
        return r11;
    L10:
        return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(r11, this.substitution.approximateContravariantCapturedTypes());
    }

    public TypeProjection substituteWithoutApproximation(TypeProjection r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        if (isEmpty() == false) goto L11;
        return r10;
    L11:
        return unsafeSubstitute(r10, null, 0);
    L10:
        return null;
    }
}
