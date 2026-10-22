package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME = null;

    public static /* synthetic */ Iterable accessor$DescriptorUtilsKt$lambda0(ValueParameterDescriptor r0) {
        return declaresOrInheritsDefaultValue$lambda$5(r0);
    }

    public static /* synthetic */ DeclarationDescriptor accessor$DescriptorUtilsKt$lambda1(DeclarationDescriptor r0) {
        return _get_parentsWithSelf_$lambda$8(r0);
    }

    public static /* synthetic */ Iterable accessor$DescriptorUtilsKt$lambda2(boolean r0, CallableMemberDescriptor r1) {
        return firstOverridden$lambda$10(r0, r1);
    }

    public static /* synthetic */ Sequence accessor$DescriptorUtilsKt$lambda3(boolean r0, CallableMemberDescriptor r1) {
        return overriddenTreeAsSequence$lambda$12$lambda$11(r0, r1);
    }

    static {
        RETENTION_PARAMETER_NAME = Name.identifier("value");
    }

    private static final DeclarationDescriptor _get_parentsWithSelf_$lambda$8(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getContainingDeclaration();
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return DFS.ifAny(CollectionsKt.listOf(r2), DescriptorUtilsKt$.Lambda.0.INSTANCE, declaresOrInheritsDefaultValue.2.INSTANCE).booleanValue();
    }

    private static final Iterable declaresOrInheritsDefaultValue$lambda$5(ValueParameterDescriptor r2) {
        Collection<ValueParameterDescriptor> r3 = r2.getOverriddenDescriptors();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((ValueParameterDescriptor) r4.next()).getOriginal());
        goto L4
    L6:
        return r0;
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        FqNameUnsafe r3 = getFqNameUnsafe(r2);
        if (r3.isSafe() == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.toSafe();
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassifierDescriptor r2 = r1.getType().getConstructor().getDeclarationDescriptor();
        if ((r2 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r2;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return getModule(r1).getBuiltIns();
    }

    public static final ClassId getClassId(ClassifierDescriptor r3) {
        if (r3 == null) goto L15;
        DeclarationDescriptor r1 = r3.getContainingDeclaration();
        if (r1 != null) goto L7;
        return null;
    L7:
        if ((r1 instanceof PackageFragmentDescriptor) == false) goto L10;
        return new ClassId(((PackageFragmentDescriptor) r1).getFqName(), r3.getName());
    L10:
        if ((r1 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        ClassId r2 = getClassId((ClassifierDescriptor) r1);
        if (r2 != null) goto L14;
        return null;
    L14:
        return r2.createNestedClassId(r3.getName());
    L18:
        return null;
    L15:
        return null;
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return DescriptorUtils.getFqNameSafe(r1);
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return DescriptorUtils.getFqName(r1);
    }

    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(ClassDescriptor r2) {
        if (r2 == null) goto L5;
        ValueClassRepresentation<SimpleType> r3 = r2.getValueClassRepresentation();
    L7:
        if ((r3 instanceof InlineClassRepresentation) == true) goto L9;
        return null;
    L9:
        return (InlineClassRepresentation) r3;
    L5:
        r3 = null;
        goto L7
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Ref r2 = (Ref) r1.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r2 == null) goto L5;
        TypeRefinementSupport r3 = (TypeRefinementSupport) r2.getValue();
    L7:
        if ((r3 instanceof TypeRefinementSupport.Enabled) == false) goto L10;
        return ((TypeRefinementSupport.Enabled) r3).getTypeRefiner();
    L10:
        return KotlinTypeRefiner.Default.INSTANCE;
    L5:
        r3 = null;
        goto L7
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return DescriptorUtils.getContainingModule(r1);
    }

    public static final MultiFieldValueClassRepresentation<SimpleType> getMultiFieldValueClassRepresentation(ClassDescriptor r2) {
        if (r2 == null) goto L5;
        ValueClassRepresentation<SimpleType> r3 = r2.getValueClassRepresentation();
    L7:
        if ((r3 instanceof MultiFieldValueClassRepresentation) == true) goto L9;
        return null;
    L9:
        return (MultiFieldValueClassRepresentation) r3;
    L5:
        r3 = null;
        goto L7
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SequencesKt.drop(getParentsWithSelf(r1), 1);
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return SequencesKt.generateSequence(r1, DescriptorUtilsKt$.Lambda.1.INSTANCE);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof PropertyAccessorDescriptor) == true) goto L5;
        return r1;
    L5:
        return ((PropertyAccessorDescriptor) r1).getCorrespondingProperty();
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Iterator<KotlinType> r3 = r2.getDefaultType().getConstructor().getSupertypes().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        KotlinType r0 = r3.next();
        if (KotlinBuiltIns.isAnyOrNullableAny(r0) == true) goto L4;
        ClassifierDescriptor r1 = r0.getConstructor().getDeclarationDescriptor();
        if (DescriptorUtils.isClassOrEnumClass(r1) == false) goto L4;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return (ClassDescriptor) r1;
    L11:
        return null;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Ref r3 = (Ref) r2.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r3 == null) goto L10;
        TypeRefinementSupport r4 = (TypeRefinementSupport) r3.getValue();
        if (r4 != null) goto L7;
        return false;
    L7:
        if (r4.isEnabled() != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private static final Iterable firstOverridden$lambda$10(boolean r0, CallableMemberDescriptor r1) {
        if (r0 == false) goto L6;
        if (r1 == null) goto L5;
        r1 = r1.getOriginal();
        goto L6
    L5:
        r1 = null;
    L6:
        if (r1 == null) goto L10;
        Collection<? extends CallableMemberDescriptor> r2 = r1.getOverriddenDescriptors();
        if (r2 == null) goto L10;
    L12:
        return r2;
    L10:
        r2 = CollectionsKt.emptyList();
        goto L12
    }

    public static final Sequence<CallableMemberDescriptor> overriddenTreeAsSequence(CallableMemberDescriptor r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == false) goto L6;
        r2 = r2.getOriginal();
    L6:
        return SequencesKt.plus(SequencesKt.sequenceOf(new CallableMemberDescriptor[]{r2}), SequencesKt.flatMap(CollectionsKt.asSequence(r2.getOverriddenDescriptors()), new DescriptorUtilsKt$.Lambda.3(r3)));
    }

    private static final Sequence overriddenTreeAsSequence$lambda$12$lambda$11(boolean r0, CallableMemberDescriptor r1) {
        Intrinsics.checkNotNull(r1);
        return overriddenTreeAsSequence(r1, r0);
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor r2, boolean r3, Function1<? super CallableMemberDescriptor, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        kotlin.jvm.internal.Ref.ObjectRef r0 = new kotlin.jvm.internal.Ref.ObjectRef();
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt.listOf(r2), new DescriptorUtilsKt$.Lambda.2(r3), new firstOverridden.2(r0, r4));
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor r1, FqName r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(r3, "location");
        r2.isRoot();
        ClassifierDescriptor r4 = r1.getPackage(r2.parent()).getMemberScope().mo383getContributedClassifier(r2.shortName(), r3);
        if ((r4 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r4;
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return firstOverridden(r0, r1, r2);
    }
}
