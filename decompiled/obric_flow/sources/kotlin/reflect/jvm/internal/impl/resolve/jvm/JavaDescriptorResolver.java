package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaDescriptorResolver {
    private final JavaResolverCache javaResolverCache;
    private final LazyJavaPackageFragmentProvider packageFragmentProvider;

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider r5, JavaResolverCache r10) {
        Intrinsics.checkNotNullParameter(r5, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r10, "javaResolverCache");
        this.packageFragmentProvider = r5;
        this.javaResolverCache = r10;
    }

    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final ClassDescriptor resolveClass(JavaClass r5) {
        Intrinsics.checkNotNullParameter(r5, "javaClass");
        FqName r10 = r5.getFqName();
        if (r10 != null) goto L5;
    L8:
        JavaClass r11 = r5.getOuterClass();
        if (r11 == null) goto L21;
        ClassDescriptor r12 = resolveClass(r11);
        if (r12 == null) goto L13;
        MemberScope r13 = r12.getUnsubstitutedInnerClassesScope();
    L14:
        if (r13 == null) goto L16;
        ClassifierDescriptor r14 = r13.mo1404getContributedClassifier(r5.getName(), NoLookupLocation.FROM_JAVA_LOADER);
    L18:
        if ((r14 instanceof ClassDescriptor) == true) goto L20;
        return null;
    L20:
        return (ClassDescriptor) r14;
    L16:
        r14 = null;
        goto L18
    L13:
        r13 = null;
        goto L14
    L21:
        if (r10 != null) goto L23;
        return null;
    L23:
        LazyJavaPackageFragment r15 = (LazyJavaPackageFragment) CollectionsKt.firstOrNull(this.packageFragmentProvider.getPackageFragments(r10.parent()));
        if (r15 != null) goto L26;
        return null;
    L26:
        return r15.findClassifierByJavaClass$descriptors_jvm(r5);
    L5:
        if (r5.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L8;
        return this.javaResolverCache.getClassResolvedFromSource(r10);
    }
}
