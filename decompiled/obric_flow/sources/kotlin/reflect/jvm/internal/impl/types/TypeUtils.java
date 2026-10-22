package kotlin.reflect.jvm.internal.impl.types;

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

/* JADX INFO: loaded from: classes3.dex */
public class TypeUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final SimpleType CANNOT_INFER_FUNCTION_PARAM_TYPE = null;
    public static final SimpleType DONT_CARE = null;
    public static final SimpleType NO_EXPECTED_TYPE = null;
    public static final SimpleType UNIT_EXPECTED_TYPE = null;

    public static class SpecialType extends DelegatingSimpleType {
        private final String name;

        private static /* synthetic */ void $$$reportNull$$$0(int r10) {
            if (r10 == 1) goto L6;
            if (r10 == 4) goto L6;
            String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L8:
            if (r10 == 1) goto L11;
            if (r10 == 4) goto L11;
            int r11 = 3;
        L12:
            Object[] r12 = new Object[r11];
            if (r10 == 1) goto L20;
            if (r10 == 2) goto L19;
            if (r10 == 3) goto L18;
            if (r10 == 4) goto L20;
            r12[0] = "newAttributes";
        L22:
            if (r10 == 1) goto L26;
            if (r10 == 4) goto L25;
            r12[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        L27:
            if (r10 == 1) goto L34;
            if (r10 == 2) goto L33;
            if (r10 == 3) goto L32;
            if (r10 == 4) goto L34;
            r12[2] = "replaceAttributes";
            goto L34
        L32:
            r12[2] = "refine";
            goto L34
        L33:
            r12[2] = "replaceDelegate";
        L34:
            String r13 = String.format(r5, r12);
            if (r10 == 1) goto L39;
            if (r10 == 4) goto L39;
            throw new IllegalArgumentException(r13);
        L39:
            throw new IllegalStateException(r13);
        L25:
            r12[1] = "refine";
            goto L27
        L26:
            r12[1] = "toString";
            goto L27
        L18:
            r12[0] = "kotlinTypeRefiner";
            goto L22
        L19:
            r12[0] = "delegate";
        L20:
            r12[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
        L11:
            r11 = 2;
        L6:
            r5 = "@NotNull method %s.%s must not return null";
            goto L8
        }

        public SpecialType(String r5) {
            this.name = r5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        public SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public /* bridge */ /* synthetic */ UnwrappedType makeNullableAsSpecified(boolean r5) {
            return makeNullableAsSpecified(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public SpecialType refine(KotlinTypeRefiner r5) {
            if (r5 != null) goto L4;
            $$$reportNull$$$0(3);
        L4:
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public /* bridge */ /* synthetic */ UnwrappedType replaceAttributes(TypeAttributes r5) {
            return replaceAttributes(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
        public DelegatingSimpleType replaceDelegate(SimpleType r5) {
            if (r5 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType
        public String toString() {
            String r5 = this.name;
            if (r5 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType makeNullableAsSpecified(boolean r5) {
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner r5) {
            return refine(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType
        public SimpleType replaceAttributes(TypeAttributes r5) {
            if (r5 != null) goto L5;
            $$$reportNull$$$0(0);
        L5:
            throw new IllegalStateException(this.name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public /* bridge */ /* synthetic */ SimpleType refine(KotlinTypeRefiner r5) {
            return refine(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
        public /* bridge */ /* synthetic */ UnwrappedType refine(KotlinTypeRefiner r5) {
            return refine(r5);
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
        if (r24 == 9) goto L132;
        if (r24 == 11) goto L133;
        if (r24 == 15) goto L134;
        if (r24 == 17) goto L135;
        if (r24 == 19) goto L136;
        if (r24 == 26) goto L137;
        if (r24 == 35) goto L138;
        if (r24 == 48) goto L139;
        if (r24 == 53) goto L140;
        if (r24 == 6) goto L141;
        if (r24 == 7) goto L142;
        switch(r24) {
            case 56: goto L143;
            case 57: goto L143;
            case 58: goto L143;
            case 59: goto L143;
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
        r16[0] = "type";
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
            default: goto L144;
        };
    L144:
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
        goto L61
    L143:
        r15 = 2;
        goto L34
    L142:
        r15 = 2;
        goto L34
    L141:
        r15 = 2;
        goto L34
    L140:
        r15 = 2;
        goto L34
    L139:
        r15 = 2;
        goto L34
    L138:
        r15 = 2;
        goto L34
    L137:
        r15 = 2;
        goto L34
    L136:
        r15 = 2;
        goto L34
    L135:
        r15 = 2;
        goto L34
    L134:
        r15 = 2;
        goto L34
    L133:
        r15 = 2;
        goto L34
    L132:
        r15 = 2;
        goto L34
    L33:
        r15 = 2;
    L17:
        r13 = "@NotNull method %s.%s must not return null";
        goto L19
    }

    static {
        DONT_CARE = ErrorUtils.createErrorType(ErrorTypeKind.DONT_CARE, new String[0]);
        CANNOT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType(ErrorTypeKind.UNINFERRED_LAMBDA_PARAMETER_TYPE, new String[0]);
        NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
        UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");
    }

    public TypeUtils() {
    }

    public static boolean acceptsNullable(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(28);
    L5:
        if (r5.isMarkedNullable() == false) goto L8;
        return true;
    L8:
        if (FlexibleTypesKt.isFlexible(r5) == true) goto L10;
        return false;
    L10:
        if (acceptsNullable(FlexibleTypesKt.asFlexibleType(r5).getUpperBound()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean contains(KotlinType r5, Function1<UnwrappedType, Boolean> r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(43);
    L5:
        return contains(r5, r10, null);
    }

    public static KotlinType createSubstitutedSupertype(KotlinType r5, KotlinType r10, TypeSubstitutor r11) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(20);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(21);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(22);
    L8:
        KotlinType r12 = r11.substitute(r10, Variance.INVARIANT);
        if (r12 != null) goto L11;
        return null;
    L11:
        return makeNullableIfNeeded(r12, r5.isMarkedNullable());
    }

    public static ClassDescriptor getClassDescriptor(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(30);
    L4:
        ClassifierDescriptor r10 = r5.getConstructor().mo1402getDeclarationDescriptor();
        if ((r10 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r10;
    }

    public static List<TypeProjection> getDefaultTypeProjections(List<TypeParameterDescriptor> r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(16);
    L4:
        ArrayList r10 = new ArrayList(r5.size());
        Iterator<TypeParameterDescriptor> r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.add(new TypeProjectionImpl(r11.next().getDefaultType()));
        goto L6
    L8:
        List<TypeProjection> r12 = CollectionsKt.toList(r10);
        if (r12 != null) goto L11;
        $$$reportNull$$$0(17);
    L11:
        return r12;
    }

    public static List<KotlinType> getImmediateSupertypes(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(18);
    L4:
        TypeSubstitutor r10 = TypeSubstitutor.create(r5);
        Collection<KotlinType> r11 = r5.getConstructor().mo1403getSupertypes();
        ArrayList r12 = new ArrayList(r11.size());
        Iterator<KotlinType> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        KotlinType r14 = createSubstitutedSupertype(r5, r13.next(), r10);
        if (r14 == null) goto L6;
        r12.add(r14);
        goto L6
    L10:
        return r12;
    }

    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(63);
    L5:
        if ((r5.getConstructor().mo1402getDeclarationDescriptor() instanceof TypeParameterDescriptor) == true) goto L7;
        return null;
    L7:
        return (TypeParameterDescriptor) r5.getConstructor().mo1402getDeclarationDescriptor();
    }

    public static boolean hasNullableSuperType(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(29);
    L5:
        if ((r5.getConstructor().mo1402getDeclarationDescriptor() instanceof ClassDescriptor) == false) goto L7;
        return false;
    L7:
        Iterator<KotlinType> r10 = getImmediateSupertypes(r5).iterator();
    L9:
        if (r10.hasNext() == false) goto L14;
        if (isNullableType(r10.next()) == false) goto L9;
        return true;
    L14:
        return false;
    }

    public static boolean isDontCarePlaceholder(KotlinType r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.getConstructor() != DONT_CARE.getConstructor()) goto L6;
        return true;
    }

    public static boolean isNullableType(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(27);
    L5:
        if (r5.isMarkedNullable() == false) goto L8;
        return true;
    L8:
        if (FlexibleTypesKt.isFlexible(r5) == false) goto L13;
        if (isNullableType(FlexibleTypesKt.asFlexibleType(r5).getUpperBound()) == false) goto L13;
        return true;
    L13:
        if (SpecialTypesKt.isDefinitelyNotNullType(r5) == false) goto L16;
        return false;
    L16:
        if (isTypeParameter(r5) == false) goto L20;
        return hasNullableSuperType(r5);
    L20:
        if ((r5 instanceof AbstractStubType) == false) goto L28;
        TypeParameterDescriptor r10 = ((AbstractStubType) r5).getOriginalTypeVariable().getOriginalTypeParameter();
        if (r10 != null) goto L24;
        return true;
    L24:
        if (hasNullableSuperType(r10.getDefaultType()) == false) goto L27;
        return true;
    L27:
        return false;
    L28:
        TypeConstructor r11 = r5.getConstructor();
        if ((r11 instanceof IntersectionTypeConstructor) == false) goto L36;
        Iterator<KotlinType> r12 = r11.mo1403getSupertypes().iterator();
    L32:
        if (r12.hasNext() == false) goto L36;
        if (isNullableType(r12.next()) == false) goto L32;
        return true;
    L36:
        return false;
    }

    public static boolean isTypeParameter(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(60);
    L5:
        if (getTypeParameterDescriptorOrNull(r5) == null) goto L7;
    L10:
        return true;
    L7:
        if ((r5.getConstructor() instanceof NewTypeVariableConstructor) == true) goto L10;
        return false;
    }

    public static KotlinType makeNotNullable(KotlinType r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return makeNullableAsSpecified(r5, false);
    }

    public static KotlinType makeNullable(KotlinType r5) {
        if (r5 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        return makeNullableAsSpecified(r5, true);
    }

    public static KotlinType makeNullableAsSpecified(KotlinType r5, boolean r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        UnwrappedType r11 = r5.unwrap().makeNullableAsSpecified(r10);
        if (r11 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return r11;
    }

    public static SimpleType makeNullableIfNeeded(SimpleType r5, boolean r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        if (r10 == false) goto L9;
        SimpleType r11 = r5.makeNullableAsSpecified(true);
        if (r11 != null) goto L8;
        $$$reportNull$$$0(6);
    L8:
        return r11;
    L9:
        if (r5 != null) goto L11;
        $$$reportNull$$$0(7);
    L11:
        return r5;
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(45);
    L5:
        return new StarProjectionImpl(r5);
    }

    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor r5, MemberScope r10, Function1<KotlinTypeRefiner, SimpleType> r11) {
        if (ErrorUtils.isError(r5) == false) goto L9;
        ErrorType r12 = ErrorUtils.createErrorType(ErrorTypeKind.UNABLE_TO_SUBSTITUTE_TYPE, new String[]{r5.toString()});
        if (r12 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        return r12;
    L9:
        return makeUnsubstitutedType(r5.getTypeConstructor(), r10, r11);
    }

    public static boolean noExpectedType(KotlinType r5) {
        if (r5 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r5 != NO_EXPECTED_TYPE) goto L8;
    L9:
        return true;
    L8:
        if (r5 == UNIT_EXPECTED_TYPE) goto L9;
        return false;
    }

    private static boolean contains(KotlinType r5, Function1<UnwrappedType, Boolean> r10, SmartSet<KotlinType> r11) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(44);
    L5:
        if (r5 != null) goto L7;
        return false;
    L7:
        UnwrappedType r12 = r5.unwrap();
        if (noExpectedType(r5) == true) goto L10;
        if (r11 == null) goto L16;
        if (r11.contains(r5) == false) goto L16;
        return false;
    L16:
        if (r10.invoke(r12).booleanValue() == false) goto L18;
        return true;
    L18:
        if (r11 != null) goto L20;
        r11 = SmartSet.create();
    L20:
        r11.add(r5);
        if ((r12 instanceof FlexibleType) == false) goto L23;
        FlexibleType r13 = (FlexibleType) r12;
    L24:
        if (r13 == null) goto L31;
        if (contains(r13.getLowerBound(), r10, r11) == false) goto L28;
    L29:
        return true;
    L28:
        if (contains(r13.getUpperBound(), r10, r11) == true) goto L29;
    L31:
        if ((r12 instanceof DefinitelyNotNullType) == true) goto L33;
    L35:
        TypeConstructor r14 = r5.getConstructor();
        if ((r14 instanceof IntersectionTypeConstructor) == false) goto L44;
        Iterator<KotlinType> r15 = ((IntersectionTypeConstructor) r14).mo1403getSupertypes().iterator();
    L39:
        if (r15.hasNext() == false) goto L43;
        if (contains(r15.next(), r10, r11) == false) goto L39;
        return true;
    L43:
        return false;
    L44:
        Iterator<TypeProjection> r16 = r5.getArguments().iterator();
    L46:
        if (r16.hasNext() == false) goto L53;
        TypeProjection r17 = r16.next();
        if (r17.isStarProjection() == true) goto L46;
        if (contains(r17.getType(), r10, r11) == false) goto L46;
        return true;
    L53:
        return false;
    L33:
        if (contains(((DefinitelyNotNullType) r12).getOriginal(), r10, r11) == false) goto L35;
        return true;
    L23:
        r13 = null;
        goto L24
    L10:
        return r10.invoke(r12).booleanValue();
    }

    public static TypeProjection makeStarProjection(TypeParameterDescriptor r5, ErasureTypeAttributes r10) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(46);
    L5:
        if (r10.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE) goto L9;
        return new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(r5));
    L9:
        return new StarProjectionImpl(r5);
    }

    public static KotlinType makeNullableIfNeeded(KotlinType r5, boolean r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(8);
    L4:
        if (r10 == true) goto L6;
        if (r5 != null) goto L9;
        $$$reportNull$$$0(9);
    L9:
        return r5;
    L6:
        return makeNullable(r5);
    }

    public static SimpleType makeUnsubstitutedType(TypeConstructor r10, MemberScope r11, Function1<KotlinTypeRefiner, SimpleType> r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        List<TypeProjection> r5 = getDefaultTypeProjections(r10.getParameters());
        SimpleType r13 = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), r10, r5, false, r11, r12);
        if (r13 != null) goto L11;
        $$$reportNull$$$0(15);
    L11:
        return r13;
    }
}
