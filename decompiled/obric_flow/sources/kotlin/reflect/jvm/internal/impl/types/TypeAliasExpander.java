package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nTypeAliasExpander.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAliasExpander.kt\norg/jetbrains/kotlin/types/TypeAliasExpander\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,278:1\n1#2:279\n1620#3,3:280\n1559#3:283\n1590#3,4:284\n1559#3:288\n1590#3,4:289\n1864#3,3:293\n*S KotlinDebug\n*F\n+ 1 TypeAliasExpander.kt\norg/jetbrains/kotlin/types/TypeAliasExpander\n*L\n148#1:280,3\n197#1:283\n197#1:284,4\n232#1:288\n232#1:289,4\n249#1:293,3\n*E\n"})
public final class TypeAliasExpander {
    public static final Companion Companion = null;
    private static final TypeAliasExpander NON_REPORTING = null;
    private final TypeAliasExpansionReportStrategy reportStrategy;
    private final boolean shouldCheckBounds;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ void access$assertRecursionDepth(Companion r5, int r10, TypeAliasDescriptor r11) {
            r5.assertRecursionDepth(r10, r11);
        }

        private final void assertRecursionDepth(int r5, TypeAliasDescriptor r10) {
            if (r5 > 100) goto L6;
            return;
        L6:
            throw new AssertionError("Too deep recursion while expanding type alias " + r10.getName());
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        NON_REPORTING = new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false);
    }

    public TypeAliasExpander(TypeAliasExpansionReportStrategy r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "reportStrategy");
        this.reportStrategy = r5;
        this.shouldCheckBounds = r10;
    }

    private final void checkRepeatedAnnotations(Annotations r5, Annotations r10) {
        HashSet r11 = new HashSet();
        Iterator<AnnotationDescriptor> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(r12.next().getFqName());
        goto L4
    L6:
        Iterator<AnnotationDescriptor> r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        AnnotationDescriptor r14 = r13.next();
        if (r11.contains(r14.getFqName()) == false) goto L8;
        this.reportStrategy.repeatedAnnotation(r14);
        goto L8
    }

    private final void checkTypeArgumentsSubstitution(KotlinType r10, KotlinType r11) {
        TypeSubstitutor r5 = TypeSubstitutor.create(r11);
        Iterator<T> r12 = r11.getArguments().iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L16;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TypeProjection r16 = (TypeProjection) r14;
        if (r16.isStarProjection() == true) goto L15;
        if (TypeUtilsKt.containsTypeAliasParameters(r16.getType()) == true) goto L15;
        TypeProjection r17 = r10.getArguments().get(r13);
        TypeParameterDescriptor r18 = r10.getConstructor().getParameters().get(r13);
        if (this.shouldCheckBounds == false) goto L15;
        this.reportStrategy.boundsViolationInSubstitution(r5, r17.getType(), r16.getType(), r18);
    L15:
        r13 = r15;
        goto L4
    }

    private final DynamicType combineAttributes(DynamicType r5, TypeAttributes r10) {
        return r5.replaceAttributes(createdCombinedAttributes(r5, r10));
    }

    private final SimpleType combineNullability(SimpleType r5, KotlinType r10) {
        return TypeUtils.makeNullableIfNeeded(r5, r10.isMarkedNullable());
    }

    private final SimpleType combineNullabilityAndAnnotations(SimpleType r5, KotlinType r10) {
        return combineAttributes(combineNullability(r5, r10), r10.getAttributes());
    }

    private final SimpleType createAbbreviation(TypeAliasExpansion r5, TypeAttributes r10, boolean r11) {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(r10, r5.getDescriptor().getTypeConstructor(), r5.getArguments(), r11, MemberScope.Empty.INSTANCE);
    }

    private final TypeAttributes createdCombinedAttributes(KotlinType r5, TypeAttributes r10) {
        if (KotlinTypeKt.isError(r5) == false) goto L7;
        return r5.getAttributes();
    L7:
        return r10.add(r5.getAttributes());
    }

    private final TypeProjection expandNonArgumentTypeProjection(TypeProjection r12, TypeAliasExpansion r13, int r14) {
        UnwrappedType r5 = r12.getType().unwrap();
        if (DynamicTypesKt.isDynamic(r5) == false) goto L5;
        return r12;
    L5:
        SimpleType r10 = TypeSubstitutionKt.asSimpleType(r5);
        if (KotlinTypeKt.isError(r10) == false) goto L8;
        return r12;
    L8:
        if (TypeUtilsKt.requiresTypeAliasExpansion(r10) == false) goto L38;
        TypeConstructor r11 = r10.getConstructor();
        ClassifierDescriptor r15 = r11.mo1402getDeclarationDescriptor();
        r11.getParameters().size();
        r10.getArguments().size();
        if ((r15 instanceof TypeParameterDescriptor) == false) goto L14;
        return r12;
    L14:
        if ((r15 instanceof TypeAliasDescriptor) == false) goto L32;
        TypeAliasDescriptor r16 = (TypeAliasDescriptor) r15;
        if (r13.isRecursion(r16) == false) goto L19;
        this.reportStrategy.recursiveTypeAlias(r16);
        return new TypeProjectionImpl(Variance.INVARIANT, ErrorUtils.createErrorType(ErrorTypeKind.RECURSIVE_TYPE_ALIAS, new String[]{r16.getName().toString()}));
    L19:
        List<TypeProjection> r17 = r10.getArguments();
        ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
        Iterator<T> r19 = r17.iterator();
        int r20 = 0;
    L21:
        if (r19.hasNext() == false) goto L26;
        Object r21 = r19.next();
        int r22 = r20 + 1;
        if (r20 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        r18.add(expandTypeProjection((TypeProjection) r21, r13, r11.getParameters().get(r20), r14 + 1));
        r20 = r22;
        goto L21
    L26:
        SimpleType r23 = expandRecursively(TypeAliasExpansion.Companion.create(r13, r16, r18), r10.getAttributes(), r10.isMarkedNullable(), r14 + 1, false);
        SimpleType r110 = substituteArguments(r10, r13, r14);
        if (DynamicTypesKt.isDynamic(r23) == true) goto L30;
        r23 = SpecialTypesKt.withAbbreviation(r23, r110);
    L30:
        TypeProjectionImpl r111 = new TypeProjectionImpl(r12.getProjectionKind(), r23);
    L37:
        return r111;
    L32:
        SimpleType r112 = substituteArguments(r10, r13, r14);
        checkTypeArgumentsSubstitution(r10, r112);
        r111 = new TypeProjectionImpl(r12.getProjectionKind(), r112);
        goto L37
    L38:
        return r12;
    }

    private final SimpleType expandRecursively(TypeAliasExpansion r5, TypeAttributes r10, boolean r11, int r12, boolean r13) {
        TypeProjection r14 = expandTypeProjection(new TypeProjectionImpl(Variance.INVARIANT, r5.getDescriptor().getUnderlyingType()), r5, null, r12);
        SimpleType r15 = TypeSubstitutionKt.asSimpleType(r14.getType());
        if (KotlinTypeKt.isError(r15) == false) goto L5;
        return r15;
    L5:
        r14.getProjectionKind();
        checkRepeatedAnnotations(r15.getAnnotations(), AnnotationsTypeAttributeKt.getAnnotations(r10));
        SimpleType r16 = TypeUtils.makeNullableIfNeeded(combineAttributes(r15, r10), r11);
        if (r13 == true) goto L8;
        return r16;
    L8:
        return SpecialTypesKt.withAbbreviation(r16, createAbbreviation(r5, r10, r11));
    }

    private final TypeProjection expandTypeProjection(TypeProjection r5, TypeAliasExpansion r10, TypeParameterDescriptor r11, int r12) {
        Companion.access$assertRecursionDepth(Companion, r12, r10.getDescriptor());
        if (r5.isStarProjection() == false) goto L6;
        Intrinsics.checkNotNull(r11);
        return TypeUtils.makeStarProjection(r11);
    L6:
        KotlinType r13 = r5.getType();
        TypeProjection r14 = r10.getReplacement(r13.getConstructor());
        if (r14 != null) goto L11;
        return expandNonArgumentTypeProjection(r5, r10, r12);
    L11:
        if (r14.isStarProjection() == false) goto L14;
        Intrinsics.checkNotNull(r11);
        return TypeUtils.makeStarProjection(r11);
    L14:
        UnwrappedType r15 = r14.getType().unwrap();
        Variance r16 = r14.getProjectionKind();
        Variance r17 = r5.getProjectionKind();
        if (r17 == r16) goto L23;
        Variance r18 = Variance.INVARIANT;
        if (r17 == r18) goto L23;
        if (r16 != r18) goto L22;
        r16 = r17;
        goto L23
    L22:
        this.reportStrategy.conflictingProjection(r10.getDescriptor(), r11, r15);
    L23:
        if (r11 == null) goto L26;
        Variance r19 = r11.getVariance();
        if (r19 == null) goto L26;
    L27:
        if (r19 == r16) goto L35;
        Variance r20 = Variance.INVARIANT;
        if (r19 == r20) goto L35;
        if (r16 != r20) goto L34;
        r16 = r20;
        goto L35
    L34:
        this.reportStrategy.conflictingProjection(r10.getDescriptor(), r11, r15);
    L35:
        checkRepeatedAnnotations(r13.getAnnotations(), r15.getAnnotations());
        if ((r15 instanceof DynamicType) == false) goto L38;
        KotlinType r21 = combineAttributes((DynamicType) r15, r13.getAttributes());
    L40:
        return new TypeProjectionImpl(r16, r21);
    L38:
        r21 = combineNullabilityAndAnnotations(TypeSubstitutionKt.asSimpleType(r15), r13);
    L26:
        r19 = Variance.INVARIANT;
        goto L27
    }

    private final SimpleType substituteArguments(SimpleType r10, TypeAliasExpansion r11, int r12) {
        TypeConstructor r5 = r10.getConstructor();
        List<TypeProjection> r13 = r10.getArguments();
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L14;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        TypeProjection r19 = (TypeProjection) r17;
        TypeProjection r20 = expandTypeProjection(r19, r11, r5.getParameters().get(r16), r12 + 1);
        if (r20.isStarProjection() == true) goto L12;
        r20 = new TypeProjectionImpl(r20.getProjectionKind(), TypeUtils.makeNullableIfNeeded(r20.getType(), r19.getType().isMarkedNullable()));
    L12:
        r14.add(r20);
        r16 = r18;
        goto L4
    L14:
        return TypeSubstitutionKt.replace$default(r10, r14, null, 2, null);
    }

    public final SimpleType expand(TypeAliasExpansion r10, TypeAttributes r11) {
        Intrinsics.checkNotNullParameter(r10, "typeAliasExpansion");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        return expandRecursively(r10, r11, false, 0, true);
    }

    private final SimpleType combineAttributes(SimpleType r5, TypeAttributes r10) {
        if (KotlinTypeKt.isError(r5) == false) goto L6;
        return r5;
    L6:
        return TypeSubstitutionKt.replace$default(r5, null, createdCombinedAttributes(r5, r10), 1, null);
    }
}
