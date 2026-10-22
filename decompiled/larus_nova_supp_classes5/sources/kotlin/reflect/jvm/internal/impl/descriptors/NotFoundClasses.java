package kotlin.reflect.jvm.internal.impl.descriptors;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class NotFoundClasses {
    private final MemoizedFunctionToNotNull<ClassRequest, ClassDescriptor> classes;
    private final ModuleDescriptor module;
    private final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> packageFragments;
    private final StorageManager storageManager;

    public static final class MockClassDescriptor extends ClassDescriptorBase {
        private final List<TypeParameterDescriptor> declaredTypeParameters;
        private final boolean isInner;
        private final ClassTypeConstructorImpl typeConstructor;

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isActual() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isCompanionObject() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isData() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExpect() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public boolean isExternal() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isFun() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public boolean isValue() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        public Annotations getAnnotations() {
            return Annotations.Companion.getEMPTY();
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public Collection<ClassDescriptor> getSealedSubclasses() {
            return CollectionsKt.emptyList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public /* bridge */ /* synthetic */ MemberScope getStaticScope() {
            return getStaticScope();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
        public /* bridge */ /* synthetic */ TypeConstructor getTypeConstructor() {
            return getTypeConstructor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.declaredTypeParameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
        public DescriptorVisibility getVisibility() {
            return DescriptorVisibilities.PUBLIC;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
        public boolean isInner() {
            return this.isInner;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
        public MemberScope.Empty getStaticScope() {
            return MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.typeConstructor;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        public MemberScope.Empty getUnsubstitutedMemberScope(KotlinTypeRefiner r2) {
            Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
            return MemberScope.Empty.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        public /* bridge */ /* synthetic */ MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r1) {
            return getUnsubstitutedMemberScope(r1);
        }

        public MockClassDescriptor(StorageManager r8, DeclarationDescriptor r9, Name r10, boolean r11, int r12) {
            Intrinsics.checkNotNullParameter(r8, "storageManager");
            Intrinsics.checkNotNullParameter(r9, "container");
            Intrinsics.checkNotNullParameter(r10, DBDefinition.NAME);
            super(r8, r9, r10, SourceElement.NO_SOURCE, false);
            this.isInner = r11;
            IntRange r13 = RangesKt.until(0, r12);
            ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator<Integer> r15 = r13.iterator();
        L4:
            if (r15.hasNext() == false) goto L6;
            int r5 = ((IntIterator) r15).nextInt();
            r14.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, Annotations.Companion.getEMPTY(), false, Variance.INVARIANT, Name.identifier("T" + r5), r5, r8));
            goto L4
        L6:
            this.declaredTypeParameters = r14;
            this.typeConstructor = new ClassTypeConstructorImpl(this, TypeParameterUtilsKt.computeConstructorTypeParameters(this), SetsKt.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), r8);
        }
    }

    public static /* synthetic */ PackageFragmentDescriptor accessor$NotFoundClasses$lambda0(NotFoundClasses r0, FqName r1) {
        return packageFragments$lambda$0(r0, r1);
    }

    public static /* synthetic */ ClassDescriptor accessor$NotFoundClasses$lambda1(NotFoundClasses r0, ClassRequest r1) {
        return classes$lambda$2(r0, r1);
    }

    public NotFoundClasses(StorageManager r2, ModuleDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "module");
        this.storageManager = r2;
        this.module = r3;
        this.packageFragments = r2.createMemoizedFunction(new NotFoundClasses$$Lambda$0(this));
        this.classes = r2.createMemoizedFunction(new NotFoundClasses$$Lambda$1(this));
    }

    private static final ClassDescriptor classes$lambda$2(NotFoundClasses r8, ClassRequest r9) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        Intrinsics.checkNotNullParameter(r9, "<destruct>");
        ClassId r0 = r9.component1();
        List r10 = r9.component2();
        if (r0.isLocal() == true) goto L17;
        ClassId r1 = r0.getOuterClassId();
        if (r1 == null) goto L9;
        DeclarationDescriptor r2 = r8.getClass(r1, CollectionsKt.drop(r10, 1));
        if (r2 == null) goto L9;
    L10:
        DeclarationDescriptor r4 = r2;
        boolean r6 = r0.isNestedClass();
        StorageManager r3 = r8.storageManager;
        Name r5 = r0.getShortClassName();
        Integer r11 = (Integer) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L13;
        int r7 = r11.intValue();
    L15:
        return new MockClassDescriptor(r3, r4, r5, r6, r7);
    L13:
        r7 = 0;
    L9:
        r2 = (ClassOrPackageFragmentDescriptor) r8.packageFragments.invoke(r0.getPackageFqName());
        goto L10
    L17:
        throw new UnsupportedOperationException("Unresolved local class: " + r0);
    }

    private static final PackageFragmentDescriptor packageFragments$lambda$0(NotFoundClasses r1, FqName r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return new EmptyPackageFragmentDescriptor(r1.module, r2);
    }

    public final ClassDescriptor getClass(ClassId r3, List<Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "classId");
        Intrinsics.checkNotNullParameter(r4, "typeParametersCount");
        return (ClassDescriptor) this.classes.invoke(new ClassRequest(r3, r4));
    }
}
