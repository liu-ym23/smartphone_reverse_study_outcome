package kotlin.reflect.jvm.internal.impl.types;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TypeUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SimpleType CANNOT_INFER_FUNCTION_PARAM_TYPE = null;
    public static final SimpleType DONT_CARE = null;
    public static final SimpleType NO_EXPECTED_TYPE = null;
    public static final SimpleType UNIT_EXPECTED_TYPE = null;

    public static class SpecialType extends DelegatingSimpleType {
        private final String name;

        private static /* synthetic */ void $$$reportNull$$$0(int r9) {
            if (r9 == 1) goto L6;
            if (r9 == 4) goto L6;
            String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L8:
            if (r9 == 1) goto L11;
            if (r9 == 4) goto L11;
            int r5 = 3;
        L12:
            Object[] r6 = new Object[r5];
            if (r9 == 1) goto L20;
            if (r9 == 2) goto L19;
            if (r9 == 3) goto L18;
            if (r9 == 4) goto L20;
            r6[0] = "newAttributes";
        L22:
            if (r9 == 1) goto L26;
            if (r9 == 4) goto L25;
            r6[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        L27:
            if (r9 == 1) goto L34;
            if (r9 == 2) goto L33;
            if (r9 == 3) goto L32;
            if (r9 == 4) goto L34;
            r6[2] = "replaceAttributes";
            goto L34
        L32:
            r6[2] = "refine";
            goto L34
        L33:
            r6[2] = "replaceDelegate";
        L34:
            String r3 = String.format(r2, r6);
            if (r9 == 1) goto L39;
            if (r9 == 4) goto L39;
            throw new IllegalArgumentException(r3);
        L39:
            throw new IllegalStateException(r3);
        L25:
            r6[1] = "refine";
            goto L27
        L26:
            r6[1] = "toString";
            goto L27
        L18:
            r6[0] = "kotlinTypeRefiner";
            goto L22
        L19:
            r6[0] = "delegate";
        L20:
            r6[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        L11:
            r5 = 2;
        L6:
            r2 = "@NotNull method %s.%s must not return null";
            goto L8
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public SpecialType refine(KotlinTypeRefiner r1) {
            if (r1 != null) goto L4;
            $$$reportNull$$$0(3);
        L4:
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        public SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
        public String toString() {
            String r0 = this.name;
            if (r0 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r0;
        }

        public SpecialType(String r1) {
            this.name = r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType makeNullableAsSpecified(boolean r2) {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r1) {
            return refine(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType replaceAttributes(TypeAttributes r2) {
            if (r2 != null) goto L5;
            $$$reportNull$$$0(0);
        L5:
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        public DelegatingSimpleType replaceDelegate(SimpleType r2) {
            if (r2 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r1) {
            return makeNullableAsSpecified(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public /* bridge */ /* synthetic */ SimpleType refine(KotlinTypeRefiner r1) {
            return refine(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r1) {
            return replaceAttributes(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r1) {
            return refine(r1);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r24) {
        if (r24 == 4) goto L17;
        if (r24 == 9) goto L17;
        if (r24 == 11) goto L17;
        if (r24 == 15) goto L17;
        if (r24 == 17) goto L17;
        if (r24 == 19) goto L17;
        if (r24 == 26) goto L17;
        if (r24 == 35) goto L17;
        if (r24 == 48) goto L17;
        if (r24 == 53) goto L17;
        if (r24 == 6) goto L17;
        if (r24 == 7) goto L17;
        switch(r24) {
            case 56: goto L17;
            case 57: goto L17;
            case 58: goto L17;
            case 59: goto L17;
            default: goto L16;
        };
    L16:
        String r13 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L19:
        if (r24 == 4) goto L33;
        if (r24 == 9) goto L33;
        if (r24 == 11) goto L33;
        if (r24 == 15) goto L33;
        if (r24 == 17) goto L33;
        if (r24 == 19) goto L33;
        if (r24 == 26) goto L33;
        if (r24 == 35) goto L33;
        if (r24 == 48) goto L33;
        if (r24 == 53) goto L33;
        if (r24 == 6) goto L33;
        if (r24 == 7) goto L33;
        switch(r24) {
            case 56: goto L33;
            case 57: goto L33;
            case 58: goto L33;
            case 59: goto L33;
            default: goto L32;
        };
    L32:
        int r15 = 3;
    L34:
        Object[] r16 = new Object[r15];
        switch(r24) {
            case 4: goto L59;
            case 5: goto L36;
            case 6: goto L59;
            case 7: goto L59;
            case 8: goto L36;
            case 9: goto L59;
            case 10: goto L36;
            case 11: goto L59;
            case 12: goto L58;
            case 13: goto L57;
            case 14: goto L56;
            case 15: goto L59;
            case 16: goto L55;
            case 17: goto L59;
            case 18: goto L36;
            case 19: goto L59;
            case 20: goto L54;
            case 21: goto L53;
            case 22: goto L52;
            case 23: goto L36;
            case 24: goto L51;
            case 25: goto L36;
            case 26: goto L59;
            case 27: goto L36;
            case 28: goto L36;
            case 29: goto L36;
            case 30: goto L36;
            case 31: goto L50;
            case 32: goto L49;
            case 33: goto L50;
            case 34: goto L48;
            case 35: goto L59;
            case 36: goto L47;
            case 37: goto L46;
            case 38: goto L36;
            case 39: goto L45;
            case 40: goto L36;
            case 41: goto L44;
            case 42: goto L43;
            case 43: goto L42;
            case 44: goto L42;
            case 45: goto L41;
            case 46: goto L41;
            case 47: goto L40;
            case 48: goto L59;
            case 49: goto L39;
            case 50: goto L39;
            case 51: goto L40;
            case 52: goto L38;
            case 53: goto L59;
            case 54: goto L37;
            case 55: goto L38;
            case 56: goto L59;
            case 57: goto L59;
            case 58: goto L59;
            case 59: goto L59;
            default: goto L36;
        };
    L36:
        r16[0] = EffectConfiguration.KEY_TYPE;
    L61:
        if (r24 == 4) goto L83;
        if (r24 == 9) goto L82;
        if (r24 == 11) goto L81;
        if (r24 == 15) goto L81;
        if (r24 == 17) goto L80;
        if (r24 == 19) goto L79;
        if (r24 == 26) goto L78;
        if (r24 == 35) goto L77;
        if (r24 == 48) goto L76;
        if (r24 == 53) goto L75;
        if (r24 == 6) goto L82;
        if (r24 == 7) goto L82;
        switch(r24) {
            case 56: goto L75;
            case 57: goto L75;
            case 58: goto L75;
            case 59: goto L75;
            default: goto L74;
        };
    L74:
        r16[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
    L84:
        switch(r24) {
            case 1: goto L114;
            case 2: goto L113;
            case 3: goto L112;
            case 4: goto L115;
            case 5: goto L111;
            case 6: goto L115;
            case 7: goto L115;
            case 8: goto L111;
            case 9: goto L115;
            case 10: goto L110;
            case 11: goto L115;
            case 12: goto L109;
            case 13: goto L109;
            case 14: goto L109;
            case 15: goto L115;
            case 16: goto L108;
            case 17: goto L115;
            case 18: goto L107;
            case 19: goto L115;
            case 20: goto L106;
            case 21: goto L106;
            case 22: goto L106;
            case 23: goto L105;
            case 24: goto L105;
            case 25: goto L104;
            case 26: goto L115;
            case 27: goto L103;
            case 28: goto L102;
            case 29: goto L101;
            case 30: goto L100;
            case 31: goto L99;
            case 32: goto L99;
            case 33: goto L98;
            case 34: goto L98;
            case 35: goto L115;
            case 36: goto L97;
            case 37: goto L97;
            case 38: goto L96;
            case 39: goto L96;
            case 40: goto L95;
            case 41: goto L95;
            case 42: goto L94;
            case 43: goto L94;
            case 44: goto L94;
            case 45: goto L93;
            case 46: goto L93;
            case 47: goto L92;
            case 48: goto L115;
            case 49: goto L92;
            case 50: goto L91;
            case 51: goto L90;
            case 52: goto L90;
            case 53: goto L115;
            case 54: goto L90;
            case 55: goto L90;
            case 56: goto L115;
            case 57: goto L115;
            case 58: goto L115;
            case 59: goto L115;
            case 60: goto L89;
            case 61: goto L88;
            case 62: goto L87;
            case 63: goto L86;
            default: goto L85;
        };
    L85:
        r16[2] = "noExpectedType";
        goto L115
    L86:
        r16[2] = "getTypeParameterDescriptorOrNull";
        goto L115
    L87:
        r16[2] = "isNonReifiedTypeParameter";
        goto L115
    L88:
        r16[2] = "isReifiedTypeParameter";
        goto L115
    L89:
        r16[2] = "isTypeParameter";
        goto L115
    L90:
        r16[2] = "getPrimitiveNumberType";
        goto L115
    L91:
        r16[2] = "findByFqName";
        goto L115
    L92:
        r16[2] = "getDefaultPrimitiveNumberType";
        goto L115
    L93:
        r16[2] = "makeStarProjection";
        goto L115
    L94:
        r16[2] = "contains";
        goto L115
    L95:
        r16[2] = "dependsOnTypeConstructors";
        goto L115
    L96:
        r16[2] = "dependsOnTypeParameters";
        goto L115
    L97:
        r16[2] = "equalTypes";
        goto L115
    L98:
        r16[2] = "substituteProjectionsForParameters";
        goto L115
    L99:
        r16[2] = "substituteParameters";
        goto L115
    L100:
        r16[2] = "getClassDescriptor";
        goto L115
    L101:
        r16[2] = "hasNullableSuperType";
        goto L115
    L102:
        r16[2] = "acceptsNullable";
        goto L115
    L103:
        r16[2] = "isNullableType";
        goto L115
    L104:
        r16[2] = "getAllSupertypes";
        goto L115
    L105:
        r16[2] = "collectAllSupertypes";
        goto L115
    L106:
        r16[2] = "createSubstitutedSupertype";
        goto L115
    L107:
        r16[2] = "getImmediateSupertypes";
        goto L115
    L108:
        r16[2] = "getDefaultTypeProjections";
        goto L115
    L109:
        r16[2] = "makeUnsubstitutedType";
        goto L115
    L110:
        r16[2] = "canHaveSubtypes";
        goto L115
    L111:
        r16[2] = "makeNullableIfNeeded";
        goto L115
    L112:
        r16[2] = "makeNullableAsSpecified";
        goto L115
    L113:
        r16[2] = "makeNotNullable";
        goto L115
    L114:
        r16[2] = "makeNullable";
    L115:
        String r14 = String.format(r13, r16);
        if (r24 == 4) goto L131;
        if (r24 == 9) goto L131;
        if (r24 == 11) goto L131;
        if (r24 == 15) goto L131;
        if (r24 == 17) goto L131;
        if (r24 == 19) goto L131;
        if (r24 == 26) goto L131;
        if (r24 == 35) goto L131;
        if (r24 == 48) goto L131;
        if (r24 == 53) goto L131;
        if (r24 == 6) goto L131;
        if (r24 == 7) goto L131;
        switch(r24) {
            case 56: goto L131;
            case 57: goto L131;
            case 58: goto L131;
            case 59: goto L131;
            default: goto L132;
        };
    L132:
        throw new IllegalArgumentException(r14);
    L131:
        throw new IllegalStateException(r14);
    L75:
        r16[1] = "getPrimitiveNumberType";
        goto L84
    L76:
        r16[1] = "getDefaultPrimitiveNumberType";
        goto L84
    L77:
        r16[1] = "substituteProjectionsForParameters";
        goto L84
    L78:
        r16[1] = "getAllSupertypes";
        goto L84
    L79:
        r16[1] = "getImmediateSupertypes";
        goto L84
    L80:
        r16[1] = "getDefaultTypeProjections";
    L81:
        r16[1] = "makeUnsubstitutedType";
    L82:
        r16[1] = "makeNullableIfNeeded";
        goto L84
    L83:
        r16[1] = "makeNullableAsSpecified";
        goto L84
    L37:
        r16[0] = "literalTypeConstructor";
        goto L61
    L38:
        r16[0] = "expectedType";
        goto L61
    L39:
        r16[0] = "supertypes";
        goto L61
    L40:
        r16[0] = "numberValueTypeConstructor";
        goto L61
    L41:
        r16[0] = "parameterDescriptor";
        goto L61
    L42:
        r16[0] = "isSpecialType";
        goto L61
    L43:
        r16[0] = "specialType";
        goto L61
    L44:
        r16[0] = "typeParameterConstructors";
        goto L61
    L45:
        r16[0] = "typeParameters";
        goto L61
    L46:
        r16[0] = "b";
        goto L61
    L47:
        r16[0] = "a";
        goto L61
    L48:
        r16[0] = "projections";
        goto L61
    L49:
        r16[0] = "typeArguments";
        goto L61
    L50:
        r16[0] = "clazz";
        goto L61
    L51:
        r16[0] = "result";
        goto L61
    L52:
        r16[0] = "substitutor";
        goto L61
    L53:
        r16[0] = "superType";
        goto L61
    L54:
        r16[0] = "subType";
        goto L61
    L55:
        r16[0] = "parameters";
        goto L61
    L56:
        r16[0] = "refinedTypeFactory";
        goto L61
    L57:
        r16[0] = "unsubstitutedMemberScope";
        goto L61
    L58:
        r16[0] = "typeConstructor";
        goto L61
    L59:
        r16[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
    L33:
        r15 = 2;
    L17:
        r13 = "@NotNull method %s.%s must not return null";
        goto L19
    }

    public TypeUtils() {
    }

    static {
        DONT_CARE = ErrorUtils.createErrorType(ErrorTypeKind.DONT_CARE, new String[0]);
        CANNOT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType(ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);
        NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
        UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");
    }

    public static boolean acceptsNullable(KotlinType r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(28);
    L5:
        if (r2.isMarkedNullable() == false) goto L8;
        return true;
    L8:
        if (FlexibleTypesKt.isFlexible(r2) == true) goto L10;
        return false;
    L10:
        if (acceptsNullable(FlexibleTypesKt.asFlexibleType(r2).getUpperBound()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static ClassDescriptor getClassDescriptor(KotlinType r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        ClassifierDescriptor r2 = r1.getConstructor().getDeclarationDescriptor();
        if ((r2 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r2;
    }

    public static List<TypeProjection> getDefaultTypeProjections(List<TypeParameterDescriptor> r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<TypeParameterDescriptor> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0.add(new TypeProjectionImpl(r4.next().getDefaultType()));
        goto L6
    L8:
        List<TypeProjection> r5 = CollectionsKt.toList(r0);
        if (r5 != null) goto L11;
        $$$reportNull$$$0(17);
    L11:
        return r5;
    }

    public static List<KotlinType> getImmediateSupertypes(KotlinType r4) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(18);
    L4:
        TypeSubstitutor r0 = TypeSubstitutor.create(r4);
        Collection<KotlinType> r1 = r4.getConstructor().getSupertypes();
        ArrayList r2 = new ArrayList(r1.size());
        Iterator<KotlinType> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        KotlinType r5 = createSubstitutedSupertype(r4, r3.next(), r0);
        if (r5 == null) goto L6;
        r2.add(r5);
        goto L6
    L10:
        return r2;
    }

    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(63);
    L5:
        if ((r1.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L7;
        return null;
    L7:
        return (TypeParameterDescriptor) r1.getConstructor().getDeclarationDescriptor();
    }

    public static boolean hasNullableSuperType(KotlinType r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(29);
    L5:
        if ((r2.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) == false) goto L7;
        return false;
    L7:
        Iterator<KotlinType> r3 = getImmediateSupertypes(r2).iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        if (isNullableType(r3.next()) == false) goto L9;
        return true;
    L14:
        return false;
    }

    public static boolean isDontCarePlaceholder(KotlinType r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getConstructor() != DONT_CARE.getConstructor()) goto L6;
        return true;
    }

    public static boolean isNullableType(KotlinType r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        if (r3.isMarkedNullable() == false) goto L8;
        return true;
    L8:
        if (FlexibleTypesKt.isFlexible(r3) == false) goto L13;
        if (isNullableType(FlexibleTypesKt.asFlexibleType(r3).getUpperBound()) == false) goto L13;
        return true;
    L13:
        if (SpecialTypesKt.isDefinitelyNotNullType(r3) == false) goto L16;
        return false;
    L16:
        if (isTypeParameter(r3) == false) goto L20;
        return hasNullableSuperType(r3);
    L20:
        if ((r3 instanceof AbstractStubType) == false) goto L28;
        TypeParameterDescriptor r4 = ((AbstractStubType) r3).getOriginalTypeVariable().getOriginalTypeParameter();
        if (r4 != null) goto L24;
        return true;
    L24:
        if (hasNullableSuperType(r4.getDefaultType()) == true) goto L41;
        return false;
    L41:
        return true;
    L28:
        TypeConstructor r5 = r3.getConstructor();
        if ((r5 instanceof IntersectionTypeConstructor) == false) goto L36;
        Iterator<KotlinType> r6 = r5.getSupertypes().iterator();
    L32:
        if (r6.hasNext() == false) goto L36;
        if (isNullableType(r6.next()) == false) goto L32;
        return true;
    L36:
        return false;
    }

    public static boolean isTypeParameter(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(60);
    L5:
        if (getTypeParameterDescriptorOrNull(r1) == null) goto L7;
    L10:
        return true;
    L7:
        if ((r1.getConstructor() instanceof NewTypeVariableConstructor) == true) goto L10;
        return false;
    }

    public static KotlinType makeNotNullable(KotlinType r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return makeNullableAsSpecified(r1, false);
    }

    public static KotlinType makeNullable(KotlinType r1) {
        if (r1 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        return makeNullableAsSpecified(r1, true);
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(45);
    L5:
        return new StarProjectionImpl(r1);
    }

    public static boolean noExpectedType(KotlinType r2) {
        if (r2 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r2 != NO_EXPECTED_TYPE) goto L8;
    L9:
        return true;
    L8:
        if (r2 == UNIT_EXPECTED_TYPE) goto L9;
        return false;
    }

    public static boolean contains(KotlinType r1, Function1<UnwrappedType, Boolean> r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(43);
    L5:
        return contains(r1, r2, null);
    }

    public static KotlinType makeNullableAsSpecified(KotlinType r1, boolean r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        UnwrappedType r3 = r1.unwrap().makeNullableAsSpecified(r2);
        if (r3 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return r3;
    }

    public static SimpleType makeNullableIfNeeded(SimpleType r1, boolean r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r2 == false) goto L9;
        SimpleType r3 = r1.makeNullableAsSpecified(true);
        if (r3 != null) goto L8;
        $$$reportNull$$$0(6);
    L8:
        return r3;
    L9:
        if (r1 != null) goto L11;
        $$$reportNull$$$0(7);
    L11:
        return r1;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor r1, ErasureTypeAttributes r2) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(46);
    L5:
        if (r2.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE) goto L9;
        return new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(r1));
    L9:
        return new StarProjectionImpl(r1);
    }

    public static KotlinType makeNullableIfNeeded(KotlinType r1, boolean r2) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(8);
    L4:
        if (r2 == true) goto L6;
        if (r1 != null) goto L9;
        $$$reportNull$$$0(9);
    L9:
        return r1;
    L6:
        return makeNullable(r1);
    }

    private static boolean contains(KotlinType r5, Function1<UnwrappedType, Boolean> r6, SmartSet<KotlinType> r7) {
        if (r6 != null) goto L5;
        $$$reportNull$$$0(44);
    L5:
        if (r5 != null) goto L7;
        return false;
    L7:
        DefinitelyNotNullType r1 = r5.unwrap();
        if (noExpectedType(r5) == true) goto L10;
        if (r7 == null) goto L16;
        if (r7.contains(r5) == false) goto L16;
        return false;
    L16:
        if (((Boolean) r6.invoke(r1)).booleanValue() == false) goto L18;
        return true;
    L18:
        if (r7 != null) goto L20;
        r7 = SmartSet.create();
    L20:
        r7.add(r5);
        if ((r1 instanceof FlexibleType) == false) goto L23;
        FlexibleType r2 = (FlexibleType) r1;
    L24:
        if (r2 == null) goto L31;
        if (contains(r2.getLowerBound(), r6, r7) == false) goto L28;
    L29:
        return true;
    L28:
        if (contains(r2.getUpperBound(), r6, r7) == true) goto L29;
    L31:
        if ((r1 instanceof DefinitelyNotNullType) == true) goto L33;
    L35:
        IntersectionTypeConstructor r3 = r5.getConstructor();
        if ((r3 instanceof IntersectionTypeConstructor) == false) goto L44;
        Iterator r8 = r3.getSupertypes().iterator();
    L39:
        if (r8.hasNext() == false) goto L43;
        if (contains((KotlinType) r8.next(), r6, r7) == false) goto L39;
        return true;
    L43:
        return false;
    L44:
        Iterator<TypeProjection> r9 = r5.getArguments().iterator();
    L46:
        if (r9.hasNext() == false) goto L54;
        TypeProjection r4 = r9.next();
        if (r4.isStarProjection() == true) goto L46;
        if (contains(r4.getType(), r6, r7) == false) goto L46;
        return true;
    L55:
        th = move-exception;
        throw th;
    L54:
        return false;
    L33:
        if (contains(r1.getOriginal(), r6, r7) == false) goto L35;
        return true;
    L23:
        r2 = null;
        goto L24
    L10:
        return ((Boolean) r6.invoke(r1)).booleanValue();
    }

    public static KotlinType createSubstitutedSupertype(KotlinType r1, KotlinType r2, TypeSubstitutor r3) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        if (r2 != null) goto L6;
        $$$reportNull$$$0(21);
    L6:
        if (r3 != null) goto L8;
        $$$reportNull$$$0(22);
    L8:
        KotlinType r4 = r3.substitute(r2, Variance.INVARIANT);
        if (r4 != null) goto L11;
        return null;
    L11:
        return makeNullableIfNeeded(r4, r1.isMarkedNullable());
    }

    public static SimpleType makeUnsubstitutedType(TypeConstructor r7, MemberScope r8, Function1<KotlinTypeRefiner, SimpleType> r9) {
        if (r7 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r8 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r9 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        List<TypeProjection> r3 = getDefaultTypeProjections(r7.getParameters());
        SimpleType r10 = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), r7, r3, false, r8, r9);
        if (r10 != null) goto L11;
        $$$reportNull$$$0(15);
    L11:
        return r10;
    }

    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor r1, MemberScope r2, Function1<KotlinTypeRefiner, SimpleType> r3) {
        if (ErrorUtils.isError(r1) == false) goto L9;
        ErrorType r4 = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, new String[]{r1.toString()});
        if (r4 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        return r4;
    L9:
        return makeUnsubstitutedType(r1.getTypeConstructor(), r2, r3);
    }
}
