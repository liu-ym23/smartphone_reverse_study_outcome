package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
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
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDescriptorUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorUtils.kt\norg/jetbrains/kotlin/resolve/descriptorUtil/DescriptorUtilsKt\n+ 2 ClassKind.kt\norg/jetbrains/kotlin/descriptors/ClassKindKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,458:1\n34#2:459\n819#3:460\n847#3,2:461\n1603#3,9:463\n1855#3:472\n1856#3:474\n1612#3:475\n819#3:476\n847#3,2:477\n819#3:481\n847#3,2:482\n350#3,7:485\n1747#3,3:492\n2624#3,3:495\n1549#3:498\n1620#3,3:499\n1#4:473\n1#4:484\n1282#5,2:479\n*S KotlinDebug\n*F\n+ 1 DescriptorUtils.kt\norg/jetbrains/kotlin/resolve/descriptorUtil/DescriptorUtilsKt\n*L\n141#1:459\n160#1:460\n160#1:461,2\n161#1:463,9\n161#1:472\n161#1:474\n161#1:475\n168#1:476\n168#1:477,2\n229#1:481\n229#1:482,2\n299#1:485,7\n441#1:492,3\n447#1:495,3\n201#1:498\n201#1:499,3\n161#1:473\n222#1:479,2\n*E\n"})
public final class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$declaresOrInheritsDefaultValue$2, reason: invalid class name */
    public /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(ValueParameterDescriptor.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(ValueParameterDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            return Boolean.valueOf(r5.declaresDefaultValue());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ValueParameterDescriptor r5) {
            return invoke2(r5);
        }
    }

    static {
        RETENTION_PARAMETER_NAME = Name.identifier("value");
    }

    public static /* synthetic */ Iterable accessor$DescriptorUtilsKt$lambda0(ValueParameterDescriptor r5) {
        return declaresOrInheritsDefaultValue$lambda$5(r5);
    }

    public static /* synthetic */ Iterable accessor$DescriptorUtilsKt$lambda1(boolean r5, CallableMemberDescriptor r10) {
        return firstOverridden$lambda$9(r5, r10);
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return DFS.ifAny(CollectionsKt.listOf(r5), DescriptorUtilsKt$$Lambda$0.INSTANCE, AnonymousClass2.INSTANCE).booleanValue();
    }

    private static final Iterable declaresOrInheritsDefaultValue$lambda$5(ValueParameterDescriptor r5) {
        Collection<ValueParameterDescriptor> r10 = r5.getOverriddenDescriptors();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((ValueParameterDescriptor) r12.next()).getOriginal());
        goto L4
    L6:
        return r11;
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor r5, final boolean r10, final Function1<? super CallableMemberDescriptor, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt.listOf(r5), new DescriptorUtilsKt$$Lambda$1(r10), new C02362(r12, r11));
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor r5, boolean r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = false;
    L6:
        return firstOverridden(r5, r10, r11);
    }

    private static final Iterable firstOverridden$lambda$9(boolean r5, CallableMemberDescriptor r10) {
        Collection<? extends CallableMemberDescriptor> r11 = null;
        if (r5 == false) goto L7;
        if (r10 == null) goto L6;
        r10 = r10.getOriginal();
        goto L7
    L6:
        r10 = null;
    L7:
        if (r10 == null) goto L9;
        r11 = r10.getOverriddenDescriptors();
    L9:
        if (r11 != null) goto L12;
        return CollectionsKt.emptyList();
    L12:
        return r11;
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FqNameUnsafe r10 = getFqNameUnsafe(r5);
        if (r10.isSafe() == true) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.toSafe();
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ClassifierDescriptor r10 = r5.getType().getConstructor().mo1402getDeclarationDescriptor();
        if ((r10 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r10;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return getModule(r5).getBuiltIns();
    }

    public static final ClassId getClassId(ClassifierDescriptor r5) {
        if (r5 == null) goto L15;
        DeclarationDescriptor r10 = r5.getContainingDeclaration();
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10 instanceof PackageFragmentDescriptor) == false) goto L10;
        return new ClassId(((PackageFragmentDescriptor) r10).getFqName(), r5.getName());
    L10:
        if ((r10 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        ClassId r11 = getClassId((ClassifierDescriptor) r10);
        if (r11 != null) goto L14;
        return null;
    L14:
        return r11.createNestedClassId(r5.getName());
    L18:
        return null;
    L15:
        return null;
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return DescriptorUtils.getFqNameSafe(r5);
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return DescriptorUtils.getFqName(r5);
    }

    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(ClassDescriptor r5) {
        if (r5 == null) goto L5;
        ValueClassRepresentation<SimpleType> r10 = r5.getValueClassRepresentation();
    L7:
        if ((r10 instanceof InlineClassRepresentation) == true) goto L9;
        return null;
    L9:
        return (InlineClassRepresentation) r10;
    L5:
        r10 = null;
        goto L7
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref r10 = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) r5.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r10 == null) goto L5;
        TypeRefinementSupport r11 = (TypeRefinementSupport) r10.getValue();
    L7:
        if ((r11 instanceof TypeRefinementSupport.Enabled) == false) goto L10;
        return ((TypeRefinementSupport.Enabled) r11).getTypeRefiner();
    L10:
        return KotlinTypeRefiner.Default.INSTANCE;
    L5:
        r11 = null;
        goto L7
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return DescriptorUtils.getContainingModule(r5);
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return SequencesKt.drop(getParentsWithSelf(r5), 1);
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return SequencesKt.generateSequence(r5, DescriptorUtilsKt$parentsWithSelf$1.INSTANCE);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof PropertyAccessorDescriptor) == true) goto L5;
        return r5;
    L5:
        return ((PropertyAccessorDescriptor) r5).getCorrespondingProperty();
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<KotlinType> r10 = r5.getDefaultType().getConstructor().mo1403getSupertypes().iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        KotlinType r11 = r10.next();
        if (KotlinBuiltIns.isAnyOrNullableAny(r11) == true) goto L4;
        ClassifierDescriptor r12 = r11.getConstructor().mo1402getDeclarationDescriptor();
        if (DescriptorUtils.isClassOrEnumClass(r12) == false) goto L4;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return (ClassDescriptor) r12;
    L11:
        return null;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref r10 = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) r5.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r10 == null) goto L10;
        TypeRefinementSupport r11 = (TypeRefinementSupport) r10.getValue();
        if (r11 != null) goto L7;
        return false;
    L7:
        if (r11.isEnabled() == true) goto L9;
        return false;
    L9:
        return true;
    L10:
        return false;
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor r5, FqName r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(r11, "location");
        r10.isRoot();
        ClassifierDescriptor r12 = r5.getPackage(r10.parent()).getMemberScope().mo1404getContributedClassifier(r10.shortName(), r11);
        if ((r12 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r12;
    }
}
