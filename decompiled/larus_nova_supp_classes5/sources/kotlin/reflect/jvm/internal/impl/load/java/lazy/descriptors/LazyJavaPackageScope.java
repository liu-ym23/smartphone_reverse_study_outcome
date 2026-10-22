package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    private final JavaPackage jPackage;
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    private final LazyJavaPackageFragment ownerDescriptor;

    public static final class FindClassRequest {
        private final JavaClass javaClass;
        private final Name name;

        public int hashCode() {
            return this.name.hashCode();
        }

        public final JavaClass getJavaClass() {
            return this.javaClass;
        }

        public final Name getName() {
            return this.name;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof FindClassRequest) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.name, ((FindClassRequest) r2).name) == false) goto L7;
            return true;
        }

        public FindClassRequest(Name r2, JavaClass r3) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            this.name = r2;
            this.javaClass = r3;
        }
    }

    public static abstract class KotlinClassLookupResult {

        public static final class Found extends KotlinClassLookupResult {
            private final ClassDescriptor descriptor;

            public final ClassDescriptor getDescriptor() {
                return this.descriptor;
            }

            public Found(ClassDescriptor r2) {
                Intrinsics.checkNotNullParameter(r2, "descriptor");
                super(null);
                this.descriptor = r2;
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

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker r1) {
            this();
        }
    }

    public static /* synthetic */ Set accessor$LazyJavaPackageScope$lambda0(LazyJavaResolverContext r0, LazyJavaPackageScope r1) {
        return knownClassNamesInPackage$lambda$0(r0, r1);
    }

    public static /* synthetic */ ClassDescriptor accessor$LazyJavaPackageScope$lambda1(LazyJavaPackageScope r0, LazyJavaResolverContext r1, FindClassRequest r2) {
        return classes$lambda$1(r0, r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
    }

    private final JvmMetadataVersion getJvmMetadataVersion() {
        return DeserializationHelpersKt.jvmMetadataVersionOrDefault(getC().getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    private final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass r3) {
        if (r3 != null) goto L5;
        return KotlinClassLookupResult.NotFound.INSTANCE;
    L5:
        if (r3.getClassHeader().getKind() != KotlinClassHeader.Kind.CLASS) goto L11;
        ClassDescriptor r4 = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(r3);
        if (r4 == null) goto L14;
        return new KotlinClassLookupResult.Found(r4);
    L14:
        return KotlinClassLookupResult.NotFound.INSTANCE;
    L11:
        return KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass r2) {
        Intrinsics.checkNotNullParameter(r2, "javaClass");
        return findClassifier(r2.getName(), r2);
    }

    private final ClassDescriptor findClassifier(Name r4, JavaClass r5) {
        if (SpecialNames.INSTANCE.isSafeIdentifier(r4) == true) goto L5;
        return null;
    L5:
        Set r0 = (Set) this.knownClassNamesInPackage.invoke();
        if (r5 != null) goto L12;
        if (r0 == null) goto L12;
        if (r0.contains(r4.asString()) == true) goto L12;
        return null;
    L12:
        return (ClassDescriptor) this.classes.invoke(new FindClassRequest(r4, r5));
    }

    private static final Set knownClassNamesInPackage$lambda$0(LazyJavaResolverContext r1, LazyJavaPackageScope r2) {
        Intrinsics.checkNotNullParameter(r1, "$c");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        return r1.getComponents().getFinder().knownClassNamesInPackage(r2.getOwnerDescriptor().getFqName());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeClassNames(DescriptorKindFilter r4, Function1<? super Name, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "kindFilter");
        if (r4.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK()) == false) goto L5;
        Set r6 = (Set) this.knownClassNamesInPackage.invoke();
        if (r6 == null) goto L13;
        HashSet r7 = new HashSet();
        Iterator r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r7.add(Name.identifier((String) r8.next()));
        goto L10
    L12:
        return r7;
    L13:
        JavaPackage r9 = this.jPackage;
        if (r5 != null) goto L16;
        r5 = FunctionsKt.alwaysTrue();
    L16:
        Collection<JavaClass> r10 = r9.getClasses(r5);
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator<T> r12 = r10.iterator();
    L18:
        if (r12.hasNext() == false) goto L25;
        JavaClass r0 = (JavaClass) r12.next();
        if (r0.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L22;
        Name r1 = null;
    L23:
        if (r1 == null) goto L18;
        r11.add(r1);
        goto L18
    L22:
        r1 = r0.getName();
        goto L23
    L25:
        return r11;
    L5:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeFunctionNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computePropertyNames(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r1, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassDescriptor mo383getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        return findClassifier(r2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r6, "nameFilter");
        DescriptorKindFilter.Companion r0 = DescriptorKindFilter.Companion;
        int r1 = r0.getCLASSIFIERS_MASK();
        if (r5.acceptsKinds(r0.getNON_SINGLETON_CLASSIFIERS_MASK() | r1) == false) goto L23;
        Iterable r7 = (Iterable) getAllDescriptors().invoke();
        ArrayList r2 = new ArrayList();
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L17;
        Object r3 = r8.next();
        DeclarationDescriptor r4 = (DeclarationDescriptor) r3;
        if ((r4 instanceof ClassDescriptor) == true) goto L11;
    L13:
        boolean r9 = false;
    L14:
        if (r9 == false) goto L7;
        r2.add(r3);
        goto L7
    L11:
        if (((Boolean) r6.invoke(((ClassDescriptor) r4).getName())).booleanValue() == false) goto L13;
        r9 = true;
        goto L14
    L17:
        return r2;
    L23:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo383getContributedClassifier(Name r1, LookupLocation r2) {
        return mo383getContributedClassifier(r1, r2);
    }

    public LazyJavaPackageScope(final LazyJavaResolverContext r2, JavaPackage r3, LazyJavaPackageFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "jPackage");
        Intrinsics.checkNotNullParameter(r4, "ownerDescriptor");
        super(r2);
        this.jPackage = r3;
        this.ownerDescriptor = r4;
        this.knownClassNamesInPackage = r2.getStorageManager().createNullableLazyValue(new LazyJavaPackageScope$$Lambda$0(r2, this));
        this.classes = r2.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaPackageScope$$Lambda$1(this, r2));
    }

    private static final ClassDescriptor classes$lambda$1(LazyJavaPackageScope r11, LazyJavaResolverContext r12, FindClassRequest r13) {
        Intrinsics.checkNotNullParameter(r11, "this$0");
        Intrinsics.checkNotNullParameter(r12, "$c");
        Intrinsics.checkNotNullParameter(r13, "request");
        ClassId r1 = new ClassId(r11.getOwnerDescriptor().getFqName(), r13.getName());
        if (r13.getJavaClass() == null) goto L5;
        KotlinClassFinder.Result r3 = r12.getComponents().getKotlinClassFinder().findKotlinClassOrContent(r13.getJavaClass(), r11.getJvmMetadataVersion());
    L7:
        if (r3 == null) goto L9;
        KotlinJvmBinaryClass r4 = r3.toKotlinJvmBinaryClass();
    L10:
        if (r4 == null) goto L12;
        ClassId r5 = r4.getClassId();
    L13:
        if (r5 != null) goto L15;
    L19:
        KotlinClassLookupResult r6 = r11.resolveKotlinBinaryClass(r4);
        if ((r6 instanceof KotlinClassLookupResult.Found) == false) goto L23;
        return ((KotlinClassLookupResult.Found) r6).getDescriptor();
    L23:
        if ((r6 instanceof KotlinClassLookupResult.SyntheticClass) == false) goto L26;
        return null;
    L26:
        if ((r6 instanceof KotlinClassLookupResult.NotFound) == false) goto L57;
        JavaClass r2 = r13.getJavaClass();
        if (r2 != null) goto L37;
        JavaClassFinder r9 = r12.getComponents().getFinder();
        if ((r3 instanceof KotlinClassFinder.Result.ClassFileContent) == false) goto L32;
        KotlinClassFinder.Result.ClassFileContent r7 = (KotlinClassFinder.Result.ClassFileContent) r3;
    L33:
        if (r7 == null) goto L35;
        byte[] r8 = r7.getContent();
    L36:
        r2 = r9.findClass(new JavaClassFinder.Request(r1, r8, null, 4, null));
        goto L37
    L35:
        r8 = null;
        goto L36
    L32:
        r7 = null;
    L37:
        JavaClass r10 = r2;
        if (r10 == null) goto L40;
        LightClassOriginKind r14 = r10.getLightClassOriginKind();
    L42:
        if (r14 == LightClassOriginKind.BINARY) goto L55;
        if (r10 == null) goto L45;
        FqName r15 = r10.getFqName();
    L46:
        if (r15 != null) goto L48;
        return null;
    L48:
        if (r15.isRoot() == false) goto L50;
        return null;
    L50:
        if (Intrinsics.areEqual(r15.parent(), r11.getOwnerDescriptor().getFqName()) == false) goto L62;
        LazyJavaClassDescriptor r16 = new LazyJavaClassDescriptor(r12, r11.getOwnerDescriptor(), r10, null, 8, null);
        r12.getComponents().getJavaClassesTracker().reportClass(r16);
        return r16;
    L62:
        return null;
    L45:
        r15 = null;
        goto L46
    L55:
        throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + r10 + "\nClassId: " + r1 + "\nfindKotlinClass(JavaClass) = " + KotlinClassFinderKt.findKotlinClass(r12.getComponents().getKotlinClassFinder(), r10, r11.getJvmMetadataVersion()) + "\nfindKotlinClass(ClassId) = " + KotlinClassFinderKt.findKotlinClass(r12.getComponents().getKotlinClassFinder(), r1, r11.getJvmMetadataVersion()) + '\n');
    L40:
        r14 = null;
        goto L42
    L57:
        throw new NoWhenBranchMatchedException();
    L15:
        if (r5.isNestedClass() == false) goto L17;
    L18:
        return null;
    L17:
        if (r5.isLocal() == false) goto L19;
    L12:
        r5 = null;
        goto L13
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = r12.getComponents().getKotlinClassFinder().findKotlinClassOrContent(r1, r11.getJvmMetadataVersion());
        goto L7
    }
}
