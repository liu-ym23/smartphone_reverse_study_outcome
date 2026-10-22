package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAliasExpander {
    public static final Companion Companion = null;
    private static final TypeAliasExpander NON_REPORTING = null;
    private final TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ void access$assertRecursionDepth(Companion r10, int r11, TypeAliasDescriptor r12) {
            r10.assertRecursionDepth(r11, r12);
        }

        private final void assertRecursionDepth(int r10, TypeAliasDescriptor r11) {
            if (r10 > 100) goto L6;
            return;
        L6:
            throw new AssertionError("Too deep recursion while expanding type alias " + r11.getName());
        }
    }

    static {
        Companion = new Companion(null);
        NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    }

    public TypeAliasExpander(TypeAliasExpansionReportStrategy r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "reportStrategy");
        this.reportStrategy = r10;
        this.shouldCheckBounds = r11;
    }

    private final void checkRepeatedAnnotations(Annotations r10, Annotations r11) {
        HashSet r12 = new HashSet();
        Iterator<AnnotationDescriptor> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(r13.next().getFqName());
        goto L4
    L6:
        Iterator<AnnotationDescriptor> r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        AnnotationDescriptor r15 = r14.next();
        if (r12.contains(r15.getFqName()) == false) goto L8;
        this.reportStrategy.repeatedAnnotation(r15);
        goto L8
    }

    private final void checkTypeArgumentsSubstitution(KotlinType r10, KotlinType r11) {
        TypeSubstitutor r12 = TypeSubstitutor.create(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "create(substitutedType)");
        Iterator<T> r13 = r11.getArguments().iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L16;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TypeProjection r17 = (TypeProjection) r15;
        if (r17.isStarProjection() == true) goto L15;
        KotlinType r18 = r17.getType();
        Intrinsics.checkNotNullExpressionValue(r18, "substitutedArgument.type");
        if (TypeUtilsKt.containsTypeAliasParameters(r18) == true) goto L15;
        TypeProjection r19 = r10.getArguments().get(r14);
        TypeParameterDescriptor r20 = r10.getConstructor().getParameters().get(r14);
        if (this.shouldCheckBounds == false) goto L15;
        TypeAliasExpansionReportStrategy r21 = this.reportStrategy;
        KotlinType r22 = r19.getType();
        Intrinsics.checkNotNullExpressionValue(r22, "unsubstitutedArgument.type");
        KotlinType r23 = r17.getType();
        Intrinsics.checkNotNullExpressionValue(r23, "substitutedArgument.type");
        Intrinsics.checkNotNullExpressionValue(r20, "typeParameter");
        r21.boundsViolationInSubstitution(r12, r22, r23, r20);
    L15:
        r14 = r16;
        goto L4
    }

    private final DynamicType combineAttributes(DynamicType r10, TypeAttributes r11) {
        return r10.replaceAttributes(createdCombinedAttributes(r10, r11));
    }

    private final SimpleType combineAttributes(SimpleType r10, TypeAttributes r11) {
        if (KotlinTypeKt.isError(r10) == false) goto L6;
        return r10;
    L6:
        return TypeSubstitutionKt.replace$default(r10, null, createdCombinedAttributes(r10, r11), 1, null);
    }

    private final SimpleType combineNullability(SimpleType r10, KotlinType r11) {
        SimpleType r12 = TypeUtils.makeNullableIfNeeded(r10, r11.isMarkedNullable());
        Intrinsics.checkNotNullExpressionValue(r12, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
        return r12;
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType r10, KotlinType r11) {
        return combineAttributes(combineNullability(r10, r11), r11.getAttributes());
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion r10, TypeAttributes r11, boolean r12) {
        TypeConstructor r13 = r10.getDescriptor().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r13, "descriptor.typeConstructor");
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r11, r13, r10.getArguments(), r12, MemberScope.Empty.INSTANCE);
    }

    private final TypeAttributes createdCombinedAttributes(KotlinType r10, TypeAttributes r11) {
        if (KotlinTypeKt.isError(r10) == false) goto L7;
        return r10.getAttributes();
    L7:
        return r11.add(r10.getAttributes());
    }

    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection r13, TypeAliasExpansion r14, int r15) {
        UnwrappedType r10 = r13.getType().unwrap();
        if (DynamicTypesKt.isDynamic(r10) == false) goto L5;
        return r13;
    L5:
        SimpleType r11 = TypeSubstitutionKt.asSimpleType(r10);
        if (KotlinTypeKt.isError(r11) == false) goto L8;
        return r13;
    L8:
        if (TypeUtilsKt.requiresTypeAliasExpansion(r11) == false) goto L38;
        TypeConstructor r12 = r11.getConstructor();
        ClassifierDescriptor r16 = r12.mo1323getDeclarationDescriptor();
        r12.getParameters().size();
        r11.getArguments().size();
        if ((r16 instanceof TypeParameterDescriptor) == false) goto L14;
        return r13;
    L14:
        if ((r16 instanceof TypeAliasDescriptor) == false) goto L31;
        TypeAliasDescriptor r17 = (TypeAliasDescriptor) r16;
        int r18 = 0;
        if (r14.isRecursion(r17) == false) goto L19;
        this.reportStrategy.recursiveTypeAlias(r17);
        Variance r19 = Variance.INVARIANT;
        ErrorTypeKind r110 = ErrorTypeKind.RECURSIVE_TYPE_ALIAS;
        String r20 = r17.getName().toString();
        Intrinsics.checkNotNullExpressionValue(r20, "typeDescriptor.name.toString()");
        return new TypeProjectionImpl(r19, ErrorUtils.createErrorType(r110, new String[]{r20}));
    L19:
        List<TypeProjection> r21 = r11.getArguments();
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<T> r23 = r21.iterator();
    L21:
        if (r23.hasNext() == false) goto L26;
        Object r24 = r23.next();
        int r25 = r18 + 1;
        if (r18 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        r22.add(expandTypeProjection((TypeProjection) r24, r14, r12.getParameters().get(r18), r15 + 1));
        r18 = r25;
        goto L21
    L26:
        SimpleType r26 = expandRecursively(TypeAliasExpansion.Companion.create(r14, r17, r22), r11.getAttributes(), r11.isMarkedNullable(), r15 + 1, false);
        SimpleType r111 = substituteArguments(r11, r14, r15);
        if (DynamicTypesKt.isDynamic(r26) == true) goto L30;
        r26 = SpecialTypesKt.withAbbreviation(r26, r111);
    L30:
        TypeProjectionImpl r112 = new TypeProjectionImpl(r13.getProjectionKind(), r26);
    L33:
        return r112;
    L31:
        SimpleType r113 = substituteArguments(r11, r14, r15);
        checkTypeArgumentsSubstitution(r11, r113);
        r112 = new TypeProjectionImpl(r13.getProjectionKind(), r113);
        goto L33
    L38:
        return r13;
    }

    private final SimpleType expandRecursively(TypeAliasExpansion r10, TypeAttributes r11, boolean r12, int r13, boolean r14) {
        TypeProjection r15 = expandTypeProjection(new TypeProjectionImpl(Variance.INVARIANT, r10.getDescriptor().getUnderlyingType()), r10, null, r13);
        KotlinType r16 = r15.getType();
        Intrinsics.checkNotNullExpressionValue(r16, "expandedProjection.type");
        SimpleType r17 = TypeSubstitutionKt.asSimpleType(r16);
        if (KotlinTypeKt.isError(r17) == false) goto L5;
        return r17;
    L5:
        r15.getProjectionKind();
        checkRepeatedAnnotations(r17.getAnnotations(), AnnotationsTypeAttributeKt.getAnnotations(r11));
        SimpleType r18 = TypeUtils.makeNullableIfNeeded(combineAttributes(r17, r11), r12);
        Intrinsics.checkNotNullExpressionValue(r18, "expandedType.combineAttr…fNeeded(it, isNullable) }");
        if (r14 == true) goto L8;
        return r18;
    L8:
        return SpecialTypesKt.withAbbreviation(r18, createAbbreviation(r10, r11, r12));
    }

    private final TypeProjection expandTypeProjection(TypeProjection r10, TypeAliasExpansion r11, TypeParameterDescriptor r12, int r13) {
        Companion.access$assertRecursionDepth(Companion, r13, r11.getDescriptor());
        if (r10.isStarProjection() == false) goto L6;
    L4:
        Intrinsics.checkNotNull(r12);
        TypeProjection r14 = TypeUtils.makeStarProjection(r12);
        Intrinsics.checkNotNullExpressionValue(r14, "makeStarProjection(typeParameterDescriptor!!)");
        return r14;
    L6:
        KotlinType r15 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r15, "underlyingProjection.type");
        TypeProjection r16 = r11.getReplacement(r15.getConstructor());
        if (r16 != null) goto L11;
        return expandNonArgumentTypeProjection(r10, r11, r13);
    L11:
        if (r16.isStarProjection() == true) goto L4;
        UnwrappedType r17 = r16.getType().unwrap();
        Variance r18 = r16.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r18, "argument.projectionKind");
        Variance r19 = r10.getProjectionKind();
        Intrinsics.checkNotNullExpressionValue(r19, "underlyingProjection.projectionKind");
        if (r19 == r18) goto L22;
        Variance r20 = Variance.INVARIANT;
        if (r19 == r20) goto L22;
        if (r18 != r20) goto L21;
        r18 = r19;
        goto L22
    L21:
        this.reportStrategy.conflictingProjection(r11.getDescriptor(), r12, r17);
    L22:
        if (r12 == null) goto L25;
        Variance r21 = r12.getVariance();
        if (r21 == null) goto L25;
    L26:
        Intrinsics.checkNotNullExpressionValue(r21, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
        if (r21 == r18) goto L35;
        Variance r22 = Variance.INVARIANT;
        if (r21 == r22) goto L35;
        if (r18 != r22) goto L34;
        r18 = r22;
        goto L35
    L34:
        this.reportStrategy.conflictingProjection(r11.getDescriptor(), r12, r17);
    L35:
        checkRepeatedAnnotations(r15.getAnnotations(), r17.getAnnotations());
        if ((r17 instanceof DynamicType) == false) goto L38;
        KotlinType r23 = combineAttributes((DynamicType) r17, r15.getAttributes());
    L40:
        return new TypeProjectionImpl(r18, r23);
    L38:
        r23 = combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(r17), r15);
    L25:
        r21 = Variance.INVARIANT;
        goto L26
    }

    private final SimpleType substituteArguments(SimpleType r10, TypeAliasExpansion r11, int r12) {
        TypeConstructor r13 = r10.getConstructor();
        List<TypeProjection> r14 = r10.getArguments();
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
        int r17 = 0;
    L4:
        if (r16.hasNext() == false) goto L14;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TypeProjection r20 = (TypeProjection) r18;
        TypeProjection r21 = expandTypeProjection(r20, r11, r13.getParameters().get(r17), r12 + 1);
        if (r21.isStarProjection() == true) goto L12;
        r21 = new TypeProjectionImpl(r21.getProjectionKind(), TypeUtils.makeNullableIfNeeded(r21.getType(), r20.getType().isMarkedNullable()));
    L12:
        r15.add(r21);
        r17 = r19;
        goto L4
    L14:
        return TypeSubstitutionKt.replace$default(r10, r15, null, 2, null);
    }

    public final SimpleType expand(TypeAliasExpansion r10, TypeAttributes r11) {
        Intrinsics.checkNotNullParameter(r10, "typeAliasExpansion");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        return expandRecursively(r10, r11, false, 0, true);
    }
}
