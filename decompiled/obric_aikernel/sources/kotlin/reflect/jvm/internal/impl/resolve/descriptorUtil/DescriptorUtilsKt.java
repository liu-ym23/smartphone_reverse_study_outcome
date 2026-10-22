package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import com.bytedance.crash.entity.EventBody;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
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
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeRefinementSupport;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DescriptorUtilsKt {
    private static final Name RETENTION_PARAMETER_NAME = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt$declaresOrInheritsDefaultValue$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        AnonymousClass2() {
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
        public final Boolean invoke2(ValueParameterDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return Boolean.valueOf(r10.declaresDefaultValue());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ValueParameterDescriptor r10) {
            return invoke2(r10);
        }
    }

    static {
        Name r10 = Name.identifier(EventBody.KEY_VALUE);
        Intrinsics.checkNotNullExpressionValue(r10, "identifier(\"value\")");
        RETENTION_PARAMETER_NAME = r10;
    }

    public static final boolean declaresOrInheritsDefaultValue(ValueParameterDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Boolean r11 = DFS.ifAny(CollectionsKt.listOf(r10), AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r11, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return r11.booleanValue();
    }

    public static final CallableMemberDescriptor firstOverridden(CallableMemberDescriptor r10, final boolean r11, final Function1<? super CallableMemberDescriptor, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        return (CallableMemberDescriptor) DFS.dfs(CollectionsKt.listOf(r10), new C04261(r11), new C04272(r13, r12));
    }

    public static /* synthetic */ CallableMemberDescriptor firstOverridden$default(CallableMemberDescriptor r10, boolean r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = false;
    L6:
        return firstOverridden(r10, r11, r12);
    }

    public static final FqName fqNameOrNull(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FqNameUnsafe r11 = getFqNameUnsafe(r10);
        if (r11.isSafe() == true) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.toSafe();
    }

    public static final ClassDescriptor getAnnotationClass(AnnotationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassifierDescriptor r11 = r10.getType().getConstructor().mo1323getDeclarationDescriptor();
        if ((r11 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r11;
    }

    public static final KotlinBuiltIns getBuiltIns(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return getModule(r10).getBuiltIns();
    }

    public static final ClassId getClassId(ClassifierDescriptor r10) {
        if (r10 == null) goto L15;
        DeclarationDescriptor r11 = r10.getContainingDeclaration();
        if (r11 != null) goto L7;
        return null;
    L7:
        if ((r11 instanceof PackageFragmentDescriptor) == false) goto L10;
        return new ClassId(((PackageFragmentDescriptor) r11).getFqName(), r10.getName());
    L10:
        if ((r11 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L18;
        ClassId r12 = getClassId((ClassifierDescriptor) r11);
        if (r12 != null) goto L14;
        return null;
    L14:
        return r12.createNestedClassId(r10.getName());
    L18:
        return null;
    L15:
        return null;
    }

    public static final FqName getFqNameSafe(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FqName r11 = DescriptorUtils.getFqNameSafe(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "getFqNameSafe(this)");
        return r11;
    }

    public static final FqNameUnsafe getFqNameUnsafe(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FqNameUnsafe r11 = DescriptorUtils.getFqName(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "getFqName(this)");
        return r11;
    }

    public static final InlineClassRepresentation<SimpleType> getInlineClassRepresentation(ClassDescriptor r10) {
        if (r10 == null) goto L5;
        ValueClassRepresentation<SimpleType> r11 = r10.getValueClassRepresentation();
    L7:
        if ((r11 instanceof InlineClassRepresentation) == true) goto L9;
        return null;
    L9:
        return (InlineClassRepresentation) r11;
    L5:
        r11 = null;
        goto L7
    }

    public static final KotlinTypeRefiner getKotlinTypeRefiner(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref r11 = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) r10.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r11 == null) goto L5;
        TypeRefinementSupport r12 = (TypeRefinementSupport) r11.getValue();
    L7:
        if ((r12 instanceof TypeRefinementSupport.Enabled) == false) goto L10;
        return ((TypeRefinementSupport.Enabled) r12).getTypeRefiner();
    L10:
        return KotlinTypeRefiner.Default.INSTANCE;
    L5:
        r12 = null;
        goto L7
    }

    public static final ModuleDescriptor getModule(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ModuleDescriptor r11 = DescriptorUtils.getContainingModule(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "getContainingModule(this)");
        return r11;
    }

    public static final Sequence<DeclarationDescriptor> getParents(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.drop(getParentsWithSelf(r10), 1);
    }

    public static final Sequence<DeclarationDescriptor> getParentsWithSelf(DeclarationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.generateSequence(r10, DescriptorUtilsKt$parentsWithSelf$1.INSTANCE);
    }

    public static final CallableMemberDescriptor getPropertyIfAccessor(CallableMemberDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof PropertyAccessorDescriptor) == false) goto L6;
        PropertyDescriptor r11 = ((PropertyAccessorDescriptor) r10).getCorrespondingProperty();
        Intrinsics.checkNotNullExpressionValue(r11, "correspondingProperty");
        return r11;
    L6:
        return r10;
    }

    public static final ClassDescriptor getSuperClassNotAny(ClassDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<KotlinType> r11 = r10.getDefaultType().getConstructor().mo1324getSupertypes().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        KotlinType r12 = r11.next();
        if (KotlinBuiltIns.isAnyOrNullableAny(r12) == true) goto L4;
        ClassifierDescriptor r13 = r12.getConstructor().mo1323getDeclarationDescriptor();
        if (DescriptorUtils.isClassOrEnumClass(r13) == false) goto L4;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return (ClassDescriptor) r13;
    L11:
        return null;
    }

    public static final boolean isTypeRefinementEnabled(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        kotlin.reflect.jvm.internal.impl.types.checker.Ref r11 = (kotlin.reflect.jvm.internal.impl.types.checker.Ref) r10.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
        if (r11 == null) goto L10;
        TypeRefinementSupport r12 = (TypeRefinementSupport) r11.getValue();
        if (r12 == null) goto L10;
        if (r12.isEnabled() != true) goto L10;
        return true;
    L10:
        return false;
    }

    public static final ClassDescriptor resolveTopLevelClass(ModuleDescriptor r10, FqName r11, LookupLocation r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "topLevelClassFqName");
        Intrinsics.checkNotNullParameter(r12, "location");
        r11.isRoot();
        FqName r13 = r11.parent();
        Intrinsics.checkNotNullExpressionValue(r13, "topLevelClassFqName.parent()");
        MemberScope r14 = r10.getPackage(r13).getMemberScope();
        Name r15 = r11.shortName();
        Intrinsics.checkNotNullExpressionValue(r15, "topLevelClassFqName.shortName()");
        ClassifierDescriptor r16 = r14.mo1325getContributedClassifier(r15, r12);
        if ((r16 instanceof ClassDescriptor) == true) goto L7;
        return null;
    L7:
        return (ClassDescriptor) r16;
    }
}
