package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    private final JavaPackage jPackage;
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    private final LazyJavaPackageFragment ownerDescriptor;

    private static final class FindClassRequest {
        private final JavaClass javaClass;
        private final Name name;

        public FindClassRequest(Name r10, JavaClass r11) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            this.name = r10;
            this.javaClass = r11;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof FindClassRequest) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.name, ((FindClassRequest) r10).name) == false) goto L7;
            return true;
        }

        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        public final Name getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }
    }

    private static abstract class KotlinClassLookupResult {

        public static final class Found extends KotlinClassLookupResult {
            private final ClassDescriptor descriptor;

            public Found(ClassDescriptor r10) {
                Intrinsics.checkNotNullParameter(r10, "descriptor");
                super(null);
                this.descriptor = r10;
            }

            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }
        }

        public static final class NotFound extends KotlinClassLookupResult {
            public static final NotFound INSTANCE = null;

            static {
                INSTANCE = new NotFound();
            }

            private NotFound() {
                super(null);
            }
        }

        public static final class SyntheticClass extends KotlinClassLookupResult {
            public static final SyntheticClass INSTANCE = null;

            static {
                INSTANCE = new SyntheticClass();
            }

            private SyntheticClass() {
                super(null);
            }
        }

        private KotlinClassLookupResult() {
        }

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker r10) {
            this();
        }
    }

    public LazyJavaPackageScope(final LazyJavaResolverContext r10, JavaPackage r11, LazyJavaPackageFragment r12) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "jPackage");
        Intrinsics.checkNotNullParameter(r12, "ownerDescriptor");
        super(r10);
        this.jPackage = r11;
        this.ownerDescriptor = r12;
        this.knownClassNamesInPackage = r10.getStorageManager().createNullableLazyValue(new LazyJavaPackageScope$knownClassNamesInPackage$1(r10, this));
        this.classes = r10.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaPackageScope$classes$1(this, r10));
    }

    public static final /* synthetic */ KotlinClassLookupResult access$resolveKotlinBinaryClass(LazyJavaPackageScope r10, KotlinJvmBinaryClass r11) {
        return r10.resolveKotlinBinaryClass(r11);
    }

    private final ClassDescriptor findClassifier(Name r10, JavaClass r11) {
        if (SpecialNames.INSTANCE.isSafeIdentifier(r10) == true) goto L5;
        return null;
    L5:
        Set<String> r12 = this.knownClassNamesInPackage.invoke();
        if (r11 != null) goto L12;
        if (r12 == null) goto L12;
        if (r12.contains(r10.asString()) == true) goto L12;
        return null;
    L12:
        return this.classes.invoke(new FindClassRequest(r10, r11));
    }

    private final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass r10) {
        if (r10 != null) goto L5;
    L11:
        return KotlinClassLookupResult.NotFound.INSTANCE;
    L5:
        if (r10.getClassHeader().getKind() != KotlinClassHeader.Kind.CLASS) goto L10;
        ClassDescriptor r11 = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(r10);
        if (r11 == null) goto L11;
        return new KotlinClassLookupResult.Found(r11);
    L10:
        return KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeClassNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK()) == false) goto L5;
        Set<String> r12 = this.knownClassNamesInPackage.invoke();
        if (r12 == null) goto L13;
        HashSet r13 = new HashSet();
        Iterator<T> r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r13.add(Name.identifier((String) r14.next()));
        goto L10
    L12:
        return r13;
    L13:
        JavaPackage r15 = this.jPackage;
        if (r11 != null) goto L16;
        r11 = FunctionsKt.alwaysTrue();
    L16:
        Collection<JavaClass> r16 = r15.getClasses(r11);
        LinkedHashSet r17 = new LinkedHashSet();
        Iterator<T> r18 = r16.iterator();
    L18:
        if (r18.hasNext() == false) goto L25;
        JavaClass r19 = (JavaClass) r18.next();
        if (r19.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L22;
        Name r20 = null;
    L23:
        if (r20 == null) goto L18;
        r17.add(r20);
        goto L18
    L22:
        r20 = r19.getName();
        goto L23
    L25:
        return r17;
    L5:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computeFunctionNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected Set<Name> computePropertyNames(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        return SetsKt.emptySet();
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass r10) {
        Intrinsics.checkNotNullParameter(r10, "javaClass");
        return findClassifier(r10.getName(), r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return findClassifier(r10, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        return mo1325getContributedClassifier(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        DescriptorKindFilter.Companion r12 = DescriptorKindFilter.Companion;
        int r13 = r12.getCLASSIFIERS_MASK();
        if (r10.acceptsKinds(r12.getNON_SINGLETON_CLASSIFIERS_MASK() | r13) == false) goto L23;
        Collection<DeclarationDescriptor> r14 = getAllDescriptors().invoke();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L17;
        Object r17 = r16.next();
        DeclarationDescriptor r18 = (DeclarationDescriptor) r17;
        if ((r18 instanceof ClassDescriptor) == false) goto L13;
        Name r19 = ((ClassDescriptor) r18).getName();
        Intrinsics.checkNotNullExpressionValue(r19, "it.name");
        if (r11.invoke(r19).booleanValue() == false) goto L13;
        boolean r20 = true;
    L14:
        if (r20 == false) goto L7;
        r15.add(r17);
    L13:
        r20 = false;
        goto L14
    L17:
        return r15;
    L23:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    protected LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
