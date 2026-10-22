package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
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

/* JADX INFO: loaded from: classes3.dex */
public final class KotlinTypeFactory {
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = null;
    public static final KotlinTypeFactory INSTANCE = null;

    private static final class ExpandedTypeOrRefinedConstructor {
        private final SimpleType expandedType;
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(SimpleType r10, TypeConstructor r11) {
            this.expandedType = r10;
            this.refinedConstructor = r11;
        }

        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    static {
        INSTANCE = new KotlinTypeFactory();
        EMPTY_REFINED_TYPE_FACTORY = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;
    }

    private KotlinTypeFactory() {
    }

    public static final /* synthetic */ ExpandedTypeOrRefinedConstructor access$refineConstructor(KotlinTypeFactory r10, TypeConstructor r11, KotlinTypeRefiner r12, List r13) {
        return r10.refineConstructor(r11, r12, r13);
    }

    @JvmStatic
    public static final SimpleType computeExpandedType(TypeAliasDescriptor r10, List<? extends TypeProjection> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, r10, r11), TypeAttributes.Companion.getEmpty());
    }

    private final MemberScope computeMemberScope(TypeConstructor r10, List<? extends TypeProjection> r11, KotlinTypeRefiner r12) {
        ClassifierDescriptor r13 = r10.mo1323getDeclarationDescriptor();
        if ((r13 instanceof TypeParameterDescriptor) == false) goto L6;
        return ((TypeParameterDescriptor) r13).getDefaultType().getMemberScope();
    L6:
        if ((r13 instanceof ClassDescriptor) == false) goto L14;
        if (r12 != null) goto L9;
        r12 = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(r13));
    L9:
        ClassDescriptor r14 = (ClassDescriptor) r13;
        if (r11.isEmpty() == false) goto L25;
        return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible(r14, r12);
    L25:
        return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible(r14, TypeConstructorSubstitution.Companion.create(r10, r11), r12);
    L14:
        if ((r13 instanceof TypeAliasDescriptor) == false) goto L18;
        ErrorScopeKind r15 = ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE;
        String r16 = ((TypeAliasDescriptor) r13).getName().toString();
        Intrinsics.checkNotNullExpressionValue(r16, "descriptor.name.toString()");
        return ErrorUtils.createErrorScope(r15, true, new String[]{r16});
    L18:
        if ((r10 instanceof IntersectionTypeConstructor) == false) goto L22;
        return ((IntersectionTypeConstructor) r10).createScopeForKotlinType();
    L22:
        throw new IllegalStateException("Unsupported classifier: " + r13 + " for constructor: " + r10);
    }

    @JvmStatic
    public static final UnwrappedType flexibleType(SimpleType r10, SimpleType r11) {
        Intrinsics.checkNotNullParameter(r10, "lowerBound");
        Intrinsics.checkNotNullParameter(r11, "upperBound");
        if (Intrinsics.areEqual(r10, r11) == false) goto L6;
        return r10;
    L6:
        return new FlexibleTypeImpl(r10, r11);
    }

    @JvmStatic
    public static final SimpleType integerLiteralType(TypeAttributes r10, IntegerLiteralTypeConstructor r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        return simpleTypeWithNonTrivialMemberScope(r10, r11, CollectionsKt.emptyList(), r12, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, new String[]{"unknown integer literal type"}));
    }

    private final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor r10, KotlinTypeRefiner r11, List<? extends TypeProjection> r12) {
        ClassifierDescriptor r13 = r10.mo1323getDeclarationDescriptor();
        if (r13 == null) goto L13;
        ClassifierDescriptor r14 = r11.refineDescriptor(r13);
        if (r14 == null) goto L13;
        if ((r14 instanceof TypeAliasDescriptor) == true) goto L10;
        TypeConstructor r15 = r14.getTypeConstructor().refine(r11);
        Intrinsics.checkNotNullExpressionValue(r15, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new ExpandedTypeOrRefinedConstructor(null, r15);
    L10:
        return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) r14, r12), null);
    L13:
        return null;
    }

    @JvmStatic
    public static final SimpleType simpleNotNullType(TypeAttributes r10, ClassDescriptor r11, List<? extends TypeProjection> r12) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        TypeConstructor r13 = r11.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r13, "descriptor.typeConstructor");
        return simpleType$default(r10, r13, r12, false, null, 16, null);
    }

    @JvmStatic
    public static final SimpleType simpleType(SimpleType r10, TypeAttributes r11, TypeConstructor r12, List<? extends TypeProjection> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "baseType");
        Intrinsics.checkNotNullParameter(r11, "annotations");
        Intrinsics.checkNotNullParameter(r12, "constructor");
        Intrinsics.checkNotNullParameter(r13, "arguments");
        return simpleType$default(r11, r12, r13, r14, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final SimpleType simpleType(final TypeAttributes r10, final TypeConstructor r11, final List<? extends TypeProjection> r12, final boolean r13, KotlinTypeRefiner r14) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        if (r10.isEmpty() == false) goto L12;
        if (r12.isEmpty() == false) goto L12;
        if (r13 == true) goto L12;
        if (r11.mo1323getDeclarationDescriptor() == null) goto L12;
        ClassifierDescriptor r15 = r11.mo1323getDeclarationDescriptor();
        Intrinsics.checkNotNull(r15);
        SimpleType r16 = r15.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r16, "constructor.declarationDescriptor!!.defaultType");
        return r16;
    L12:
        return simpleTypeWithNonTrivialMemberScope(r10, r11, r12, r13, INSTANCE.computeMemberScope(r11, r12, r14), new AnonymousClass1(r11, r12, r10, r13));
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType r10, TypeAttributes r11, TypeConstructor r12, List r13, boolean r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r11 = r10.getAttributes();
    L6:
        if ((r15 & 4) == 0) goto L9;
        r12 = r10.getConstructor();
    L9:
        if ((r15 & 8) == 0) goto L12;
        r13 = r10.getArguments();
    L12:
        if ((r15 & 16) == 0) goto L15;
        r14 = r10.isMarkedNullable();
    L15:
        return simpleType(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes r10, TypeConstructor r11, List r12, boolean r13, KotlinTypeRefiner r14, int r15, Object r16) {
        if ((r15 & 16) == 0) goto L6;
        r14 = null;
    L6:
        return simpleType(r10, r11, r12, r13, r14);
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(final TypeAttributes r10, final TypeConstructor r11, final List<? extends TypeProjection> r12, final boolean r13, final MemberScope r14) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        Intrinsics.checkNotNullParameter(r14, "memberScope");
        SimpleTypeImpl r15 = new SimpleTypeImpl(r11, r12, r13, r14, new C04321(r11, r12, r10, r13, r14));
        if (r10.isEmpty() == false) goto L6;
        return r15;
    L6:
        return new SimpleTypeWithAttributes(r15, r10);
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes r10, TypeConstructor r11, List<? extends TypeProjection> r12, boolean r13, MemberScope r14, Function1<? super KotlinTypeRefiner, ? extends SimpleType> r15) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        Intrinsics.checkNotNullParameter(r14, "memberScope");
        Intrinsics.checkNotNullParameter(r15, "refinedTypeFactory");
        SimpleTypeImpl r16 = new SimpleTypeImpl(r11, r12, r13, r14, r15);
        if (r10.isEmpty() == false) goto L6;
        return r16;
    L6:
        return new SimpleTypeWithAttributes(r16, r10);
    }
}
