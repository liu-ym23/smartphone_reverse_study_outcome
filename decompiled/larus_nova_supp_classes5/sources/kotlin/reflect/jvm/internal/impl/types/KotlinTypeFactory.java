package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class KotlinTypeFactory {
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = null;
    public static final KotlinTypeFactory INSTANCE = null;

    private KotlinTypeFactory() {
    }

    public static /* synthetic */ SimpleType accessor$KotlinTypeFactory$lambda0(TypeConstructor r0, List r1, TypeAttributes r2, boolean r3, KotlinTypeRefiner r4) {
        return simpleType$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ SimpleType accessor$KotlinTypeFactory$lambda1(TypeConstructor r0, List r1, TypeAttributes r2, boolean r3, MemberScope r4, KotlinTypeRefiner r5) {
        return simpleTypeWithNonTrivialMemberScope$lambda$4(r0, r1, r2, r3, r4, r5);
    }

    @JvmStatic
    public static final SimpleType simpleType(TypeAttributes r8, TypeConstructor r9, List<? extends TypeProjection> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "attributes");
        Intrinsics.checkNotNullParameter(r9, "constructor");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        return simpleType$default(r8, r9, r10, r11, null, 16, null);
    }

    static {
        INSTANCE = new KotlinTypeFactory();
        EMPTY_REFINED_TYPE_FACTORY = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;
    }

    @JvmStatic
    public static final SimpleType computeExpandedType(TypeAliasDescriptor r3, List<? extends TypeProjection> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, r3, r4), TypeAttributes.Companion.getEmpty());
    }

    @JvmStatic
    public static final UnwrappedType flexibleType(SimpleType r1, SimpleType r2) {
        Intrinsics.checkNotNullParameter(r1, "lowerBound");
        Intrinsics.checkNotNullParameter(r2, "upperBound");
        if (Intrinsics.areEqual(r1, r2) == false) goto L6;
        return r1;
    L6:
        return new FlexibleTypeImpl(r1, r2);
    }

    private final MemberScope computeMemberScope(TypeConstructor r3, List<? extends TypeProjection> r4, KotlinTypeRefiner r5) {
        ClassifierDescriptor r0 = r3.getDeclarationDescriptor();
        if ((r0 instanceof TypeParameterDescriptor) == false) goto L6;
        return ((TypeParameterDescriptor) r0).getDefaultType().getMemberScope();
    L6:
        if ((r0 instanceof ClassDescriptor) == false) goto L14;
        if (r5 != null) goto L10;
        r5 = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(r0));
    L10:
        if (r4.isEmpty() == false) goto L25;
        return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) r0, r5);
    L25:
        return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) r0, TypeConstructorSubstitution.Companion.create(r3, r4), r5);
    L14:
        if ((r0 instanceof TypeAliasDescriptor) == false) goto L18;
        return ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE, true, new String[]{((TypeAliasDescriptor) r0).getName().toString()});
    L18:
        if ((r3 instanceof IntersectionTypeConstructor) == false) goto L22;
        return ((IntersectionTypeConstructor) r3).createScopeForKotlinType();
    L22:
        throw new IllegalStateException("Unsupported classifier: " + r0 + " for constructor: " + r3);
    }

    @JvmStatic
    public static final SimpleType integerLiteralType(TypeAttributes r4, IntegerLiteralTypeConstructor r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "attributes");
        Intrinsics.checkNotNullParameter(r5, "constructor");
        return simpleTypeWithNonTrivialMemberScope(r4, r5, CollectionsKt.emptyList(), r6, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, new String[]{"unknown integer literal type"}));
    }

    private final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor r3, KotlinTypeRefiner r4, List<? extends TypeProjection> r5) {
        ClassifierDescriptor r6 = r3.getDeclarationDescriptor();
        if (r6 == null) goto L13;
        ClassifierDescriptor r7 = r4.refineDescriptor(r6);
        if (r7 == null) goto L13;
        if ((r7 instanceof TypeAliasDescriptor) == false) goto L12;
        return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) r7, r5), null);
    L12:
        return new ExpandedTypeOrRefinedConstructor(null, r7.getTypeConstructor().refine(r4));
    L13:
        return null;
    }

    @JvmStatic
    public static final SimpleType simpleNotNullType(TypeAttributes r8, ClassDescriptor r9, List<? extends TypeProjection> r10) {
        Intrinsics.checkNotNullParameter(r8, "attributes");
        Intrinsics.checkNotNullParameter(r9, "descriptor");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        return simpleType$default(r8, r9.getTypeConstructor(), r10, false, null, 16, null);
    }

    @JvmStatic
    public static final SimpleType simpleType(final TypeAttributes r7, final TypeConstructor r8, final List<? extends TypeProjection> r9, final boolean r10, KotlinTypeRefiner r11) {
        Intrinsics.checkNotNullParameter(r7, "attributes");
        Intrinsics.checkNotNullParameter(r8, "constructor");
        Intrinsics.checkNotNullParameter(r9, "arguments");
        if (r7.isEmpty() == false) goto L12;
        if (r9.isEmpty() == false) goto L12;
        if (r10 == true) goto L12;
        if (r8.getDeclarationDescriptor() == null) goto L12;
        ClassifierDescriptor r12 = r8.getDeclarationDescriptor();
        Intrinsics.checkNotNull(r12);
        return r12.getDefaultType();
    L12:
        return simpleTypeWithNonTrivialMemberScope(r7, r8, r9, r10, INSTANCE.computeMemberScope(r8, r9, r11), new KotlinTypeFactory$$Lambda$0(r8, r9, r7, r10));
    }

    private static final SimpleType simpleType$lambda$1(TypeConstructor r1, List r2, TypeAttributes r3, boolean r4, KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r1, "$constructor");
        Intrinsics.checkNotNullParameter(r2, "$arguments");
        Intrinsics.checkNotNullParameter(r3, "$attributes");
        Intrinsics.checkNotNullParameter(r5, "refiner");
        ExpandedTypeOrRefinedConstructor r6 = INSTANCE.refineConstructor(r1, r5, r2);
        if (r6 != null) goto L6;
        return null;
    L6:
        SimpleType r0 = r6.getExpandedType();
        if (r0 == null) goto L9;
        return r0;
    L9:
        TypeConstructor r7 = r6.getRefinedConstructor();
        Intrinsics.checkNotNull(r7);
        return simpleType(r3, r7, r2, r4, r5);
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes r8, TypeConstructor r9, List<? extends TypeProjection> r10, boolean r11, MemberScope r12) {
        Intrinsics.checkNotNullParameter(r8, "attributes");
        Intrinsics.checkNotNullParameter(r9, "constructor");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        Intrinsics.checkNotNullParameter(r12, "memberScope");
        SimpleTypeImpl r0 = new SimpleTypeImpl(r9, r10, r11, r12, new KotlinTypeFactory$.Lambda.1(r9, r10, r8, r11, r12));
        if (r8.isEmpty() == false) goto L6;
        return r0;
    L6:
        return new SimpleTypeWithAttributes(r0, r8);
    }

    @JvmStatic
    public static final SimpleType simpleType(SimpleType r7, TypeAttributes r8, TypeConstructor r9, List<? extends TypeProjection> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "baseType");
        Intrinsics.checkNotNullParameter(r8, "annotations");
        Intrinsics.checkNotNullParameter(r9, "constructor");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        return simpleType$default(r8, r9, r10, r11, null, 16, null);
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes r7, TypeConstructor r8, List<? extends TypeProjection> r9, boolean r10, MemberScope r11, Function1<? super KotlinTypeRefiner, ? extends SimpleType> r12) {
        Intrinsics.checkNotNullParameter(r7, "attributes");
        Intrinsics.checkNotNullParameter(r8, "constructor");
        Intrinsics.checkNotNullParameter(r9, "arguments");
        Intrinsics.checkNotNullParameter(r11, "memberScope");
        Intrinsics.checkNotNullParameter(r12, "refinedTypeFactory");
        SimpleTypeImpl r0 = new SimpleTypeImpl(r8, r9, r10, r11, r12);
        if (r7.isEmpty() == false) goto L6;
        return r0;
    L6:
        return new SimpleTypeWithAttributes(r0, r7);
    }

    private static final SimpleType simpleTypeWithNonTrivialMemberScope$lambda$4(TypeConstructor r1, List r2, TypeAttributes r3, boolean r4, MemberScope r5, KotlinTypeRefiner r6) {
        Intrinsics.checkNotNullParameter(r1, "$constructor");
        Intrinsics.checkNotNullParameter(r2, "$arguments");
        Intrinsics.checkNotNullParameter(r3, "$attributes");
        Intrinsics.checkNotNullParameter(r5, "$memberScope");
        Intrinsics.checkNotNullParameter(r6, "kotlinTypeRefiner");
        ExpandedTypeOrRefinedConstructor r7 = INSTANCE.refineConstructor(r1, r6, r2);
        if (r7 != null) goto L6;
        return null;
    L6:
        SimpleType r8 = r7.getExpandedType();
        if (r8 == null) goto L9;
        return r8;
    L9:
        TypeConstructor r9 = r7.getRefinedConstructor();
        Intrinsics.checkNotNull(r9);
        return simpleTypeWithNonTrivialMemberScope(r3, r9, r2, r4, r5);
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType r0, TypeAttributes r1, TypeConstructor r2, List r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r1 = r0.getAttributes();
    L6:
        if ((r5 & 4) == 0) goto L9;
        r2 = r0.getConstructor();
    L9:
        if ((r5 & 8) == 0) goto L12;
        r3 = r0.getArguments();
    L12:
        if ((r5 & 16) == 0) goto L15;
        r4 = r0.isMarkedNullable();
    L15:
        return simpleType(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes r0, TypeConstructor r1, List r2, boolean r3, KotlinTypeRefiner r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L6;
        r4 = null;
    L6:
        return simpleType(r0, r1, r2, r3, r4);
    }
}
