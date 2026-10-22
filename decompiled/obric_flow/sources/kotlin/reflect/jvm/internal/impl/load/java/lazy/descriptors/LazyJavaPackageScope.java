package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

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
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nLazyJavaPackageScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n1620#2,3:190\n1611#2:193\n1855#2:194\n1856#2:196\n1612#2:197\n766#2:198\n857#2,2:199\n1#3:195\n*S KotlinDebug\n*F\n+ 1 LazyJavaPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageScope\n*L\n160#1:190,3\n162#1:193\n162#1:194\n162#1:196\n162#1:197\n185#1:198\n185#1:199,2\n162#1:195\n*E\n"})
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> classes;
    private final JavaPackage jPackage;
    private final NullableLazyValue<Set<String>> knownClassNamesInPackage;
    private final LazyJavaPackageFragment ownerDescriptor;

    public static final class FindClassRequest {
        private final JavaClass javaClass;
        private final Name name;

        public FindClassRequest(Name r5, JavaClass r10) {
            Intrinsics.checkNotNullParameter(r5, "name");
            this.name = r5;
            this.javaClass = r10;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof FindClassRequest) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.name, ((FindClassRequest) r5).name) == false) goto L7;
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

    public static abstract class KotlinClassLookupResult {

        public static final class Found extends KotlinClassLookupResult {
            private final ClassDescriptor descriptor;

            public Found(ClassDescriptor r5) {
                Intrinsics.checkNotNullParameter(r5, "descriptor");
                super(null);
                this.descriptor = r5;
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

        public /* synthetic */ KotlinClassLookupResult(DefaultConstructorMarker r5) {
            this();
        }

        private KotlinClassLookupResult() {
        }
    }

    public LazyJavaPackageScope(final LazyJavaResolverContext r5, JavaPackage r10, LazyJavaPackageFragment r11) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "jPackage");
        Intrinsics.checkNotNullParameter(r11, "ownerDescriptor");
        super(r5);
        this.jPackage = r10;
        this.ownerDescriptor = r11;
        this.knownClassNamesInPackage = r5.getStorageManager().createNullableLazyValue(new LazyJavaPackageScope$knownClassNamesInPackage$1(r5, this));
        this.classes = r5.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaPackageScope$classes$1(this, r5));
    }

    public static final /* synthetic */ JvmMetadataVersion access$getJvmMetadataVersion(LazyJavaPackageScope r5) {
        return r5.getJvmMetadataVersion();
    }

    public static final /* synthetic */ KotlinClassLookupResult access$resolveKotlinBinaryClass(LazyJavaPackageScope r5, KotlinJvmBinaryClass r10) {
        return r5.resolveKotlinBinaryClass(r10);
    }

    private final ClassDescriptor findClassifier(Name r5, JavaClass r10) {
        if (SpecialNames.INSTANCE.isSafeIdentifier(r5) == true) goto L5;
        return null;
    L5:
        Set<String> r11 = this.knownClassNamesInPackage.invoke();
        if (r10 != null) goto L12;
        if (r11 == null) goto L12;
        if (r11.contains(r5.asString()) == true) goto L12;
        return null;
    L12:
        return this.classes.invoke(new FindClassRequest(r5, r10));
    }

    private final JvmMetadataVersion getJvmMetadataVersion() {
        return DeserializationHelpersKt.jvmMetadataVersionOrDefault(getC().getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration());
    }

    private final KotlinClassLookupResult resolveKotlinBinaryClass(KotlinJvmBinaryClass r5) {
        if (r5 != null) goto L5;
        return KotlinClassLookupResult.NotFound.INSTANCE;
    L5:
        if (r5.getClassHeader().getKind() != KotlinClassHeader.Kind.CLASS) goto L11;
        ClassDescriptor r10 = getC().getComponents().getDeserializedDescriptorResolver().resolveClass(r5);
        if (r10 == null) goto L14;
        return new KotlinClassLookupResult.Found(r10);
    L14:
        return KotlinClassLookupResult.NotFound.INSTANCE;
    L11:
        return KotlinClassLookupResult.SyntheticClass.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeClassNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        if (r5.acceptsKinds(DescriptorKindFilter.Companion.getNON_SINGLETON_CLASSIFIERS_MASK()) == false) goto L5;
        Set<String> r11 = this.knownClassNamesInPackage.invoke();
        if (r11 == null) goto L13;
        HashSet r12 = new HashSet();
        Iterator<T> r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        r12.add(Name.identifier((String) r13.next()));
        goto L10
    L12:
        return r12;
    L13:
        JavaPackage r14 = this.jPackage;
        if (r10 != null) goto L16;
        r10 = FunctionsKt.alwaysTrue();
    L16:
        Collection<JavaClass> r15 = r14.getClasses(r10);
        LinkedHashSet r16 = new LinkedHashSet();
        Iterator<T> r17 = r15.iterator();
    L18:
        if (r17.hasNext() == false) goto L25;
        JavaClass r18 = (JavaClass) r17.next();
        if (r18.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L22;
        Name r19 = null;
    L23:
        if (r19 == null) goto L18;
        r16.add(r19);
        goto L18
    L22:
        r19 = r18.getName();
        goto L23
    L25:
        return r16;
    L5:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computeFunctionNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public DeclaredMemberIndex computeMemberIndex() {
        return DeclaredMemberIndex.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void computeNonDeclaredFunctions(Collection<SimpleFunctionDescriptor> r5, Name r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r10, "name");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public Set<Name> computePropertyNames(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        return SetsKt.emptySet();
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass r5) {
        Intrinsics.checkNotNullParameter(r5, "javaClass");
        return findClassifier(r5.getName(), r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10) {
        return mo1404getContributedClassifier(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        DescriptorKindFilter.Companion r11 = DescriptorKindFilter.Companion;
        int r12 = r11.getCLASSIFIERS_MASK();
        if (r5.acceptsKinds(r11.getNON_SINGLETON_CLASSIFIERS_MASK() | r12) == false) goto L22;
        Collection<DeclarationDescriptor> r13 = getAllDescriptors().invoke();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L7:
        if (r15.hasNext() == false) goto L14;
        Object r16 = r15.next();
        DeclarationDescriptor r17 = (DeclarationDescriptor) r16;
        if ((r17 instanceof ClassDescriptor) == false) goto L7;
        if (r10.invoke(((ClassDescriptor) r17).getName()).booleanValue() == false) goto L7;
        r14.add(r16);
        goto L7
    L14:
        return r14;
    L22:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOwnerDescriptor() {
        return getOwnerDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return findClassifier(r5, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public LazyJavaPackageFragment getOwnerDescriptor() {
        return this.ownerDescriptor;
    }
}
