package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nKotlinTypeFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTypeFactory.kt\norg/jetbrains/kotlin/types/KotlinTypeFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,301:1\n1#2:302\n*E\n"})
public final class KotlinTypeFactory {
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = null;
    public static final KotlinTypeFactory INSTANCE = null;

    public static final class ExpandedTypeOrRefinedConstructor {
        private final SimpleType expandedType;
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(SimpleType r5, TypeConstructor r10) {
            this.expandedType = r5;
            this.refinedConstructor = r10;
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

    public static final /* synthetic */ ExpandedTypeOrRefinedConstructor access$refineConstructor(KotlinTypeFactory r5, TypeConstructor r10, KotlinTypeRefiner r11, List r12) {
        return r5.refineConstructor(r10, r11, r12);
    }

    @JvmStatic
    public static final SimpleType computeExpandedType(TypeAliasDescriptor r5, List<? extends TypeProjection> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, r5, r10), TypeAttributes.Companion.getEmpty());
    }

    private final MemberScope computeMemberScope(TypeConstructor r5, List<? extends TypeProjection> r10, KotlinTypeRefiner r11) {
        ClassifierDescriptor r12 = r5.mo1402getDeclarationDescriptor();
        if ((r12 instanceof TypeParameterDescriptor) == false) goto L6;
        return ((TypeParameterDescriptor) r12).getDefaultType().getMemberScope();
    L6:
        if ((r12 instanceof ClassDescriptor) == false) goto L14;
        if (r11 != null) goto L10;
        r11 = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(r12));
    L10:
        if (r10.isEmpty() == false) goto L25;
        return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) r12, r11);
    L25:
        return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) r12, TypeConstructorSubstitution.Companion.create(r5, r10), r11);
    L14:
        if ((r12 instanceof TypeAliasDescriptor) == false) goto L18;
        return ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE, true, new String[]{((TypeAliasDescriptor) r12).getName().toString()});
    L18:
        if ((r5 instanceof IntersectionTypeConstructor) == false) goto L22;
        return ((IntersectionTypeConstructor) r5).createScopeForKotlinType();
    L22:
        throw new IllegalStateException("Unsupported classifier: " + r12 + " for constructor: " + r5);
    }

    @JvmStatic
    public static final UnwrappedType flexibleType(SimpleType r5, SimpleType r10) {
        Intrinsics.checkNotNullParameter(r5, "lowerBound");
        Intrinsics.checkNotNullParameter(r10, "upperBound");
        if (Intrinsics.areEqual(r5, r10) == false) goto L6;
        return r5;
    L6:
        return new FlexibleTypeImpl(r5, r10);
    }

    @JvmStatic
    public static final SimpleType integerLiteralType(TypeAttributes r5, IntegerLiteralTypeConstructor r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "attributes");
        Intrinsics.checkNotNullParameter(r10, "constructor");
        return simpleTypeWithNonTrivialMemberScope(r5, r10, CollectionsKt.emptyList(), r11, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, new String[]{"unknown integer literal type"}));
    }

    private final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor r5, KotlinTypeRefiner r10, List<? extends TypeProjection> r11) {
        ClassifierDescriptor r12 = r5.mo1402getDeclarationDescriptor();
        if (r12 == null) goto L13;
        ClassifierDescriptor r13 = r10.refineDescriptor(r12);
        if (r13 == null) goto L13;
        if ((r13 instanceof TypeAliasDescriptor) == false) goto L12;
        return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) r13, r11), null);
    L12:
        return new ExpandedTypeOrRefinedConstructor(null, r13.getTypeConstructor().refine(r10));
    L13:
        return null;
    }

    @JvmStatic
    public static final SimpleType simpleNotNullType(TypeAttributes r10, ClassDescriptor r11, List<? extends TypeProjection> r12) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "descriptor");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        return simpleType$default(r10, r11.getTypeConstructor(), r12, false, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final SimpleType simpleType(TypeAttributes r10, TypeConstructor r11, List<? extends TypeProjection> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        return simpleType$default(r10, r11, r12, r13, null, 16, null);
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes r5, TypeConstructor r10, List r11, boolean r12, KotlinTypeRefiner r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L6;
        r13 = null;
    L6:
        return simpleType(r5, r10, r11, r12, r13);
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(final TypeAttributes r10, final TypeConstructor r11, final List<? extends TypeProjection> r12, final boolean r13, final MemberScope r14) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        Intrinsics.checkNotNullParameter(r14, "memberScope");
        SimpleTypeImpl r5 = new SimpleTypeImpl(r11, r12, r13, r14, new C02411(r11, r12, r10, r13, r14));
        if (r10.isEmpty() == false) goto L6;
        return r5;
    L6:
        return new SimpleTypeWithAttributes(r5, r10);
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
        if (r11.mo1402getDeclarationDescriptor() == null) goto L12;
        ClassifierDescriptor r15 = r11.mo1402getDeclarationDescriptor();
        Intrinsics.checkNotNull(r15);
        return r15.getDefaultType();
    L12:
        return simpleTypeWithNonTrivialMemberScope(r10, r11, r12, r13, INSTANCE.computeMemberScope(r11, r12, r14), new AnonymousClass1(r11, r12, r10, r13));
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType r5, TypeAttributes r10, TypeConstructor r11, List r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r10 = r5.getAttributes();
    L6:
        if ((r14 & 4) == 0) goto L9;
        r11 = r5.getConstructor();
    L9:
        if ((r14 & 8) == 0) goto L12;
        r12 = r5.getArguments();
    L12:
        if ((r14 & 16) == 0) goto L15;
        r13 = r5.isMarkedNullable();
    L15:
        return simpleType(r5, r10, r11, r12, r13);
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
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes r10, TypeConstructor r11, List<? extends TypeProjection> r12, boolean r13, MemberScope r14, Function1<? super KotlinTypeRefiner, ? extends SimpleType> r15) {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "constructor");
        Intrinsics.checkNotNullParameter(r12, "arguments");
        Intrinsics.checkNotNullParameter(r14, "memberScope");
        Intrinsics.checkNotNullParameter(r15, "refinedTypeFactory");
        SimpleTypeImpl r5 = new SimpleTypeImpl(r11, r12, r13, r14, r15);
        if (r10.isEmpty() == false) goto L6;
        return r5;
    L6:
        return new SimpleTypeWithAttributes(r5, r10);
    }
}
