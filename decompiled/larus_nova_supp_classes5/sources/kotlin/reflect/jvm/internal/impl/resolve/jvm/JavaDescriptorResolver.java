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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JavaDescriptorResolver {
    private final JavaResolverCache javaResolverCache;
    private final LazyJavaPackageFragmentProvider packageFragmentProvider;

    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final ClassDescriptor resolveClass(JavaClass r4) {
        Intrinsics.checkNotNullParameter(r4, "javaClass");
        FqName r0 = r4.getFqName();
        if (r0 != null) goto L5;
    L8:
        JavaClass r1 = r4.getOuterClass();
        if (r1 == null) goto L21;
        ClassDescriptor r2 = resolveClass(r1);
        if (r2 == null) goto L13;
        MemberScope r3 = r2.getUnsubstitutedInnerClassesScope();
    L14:
        if (r3 == null) goto L16;
        ClassifierDescriptor r5 = r3.mo383getContributedClassifier(r4.getName(), NoLookupLocation.FROM_JAVA_LOADER);
    L18:
        if ((r5 instanceof ClassDescriptor) == true) goto L20;
        return null;
    L20:
        return (ClassDescriptor) r5;
    L16:
        r5 = null;
        goto L18
    L13:
        r3 = null;
        goto L14
    L21:
        if (r0 != null) goto L23;
        return null;
    L23:
        LazyJavaPackageFragment r6 = (LazyJavaPackageFragment) CollectionsKt.firstOrNull(this.packageFragmentProvider.getPackageFragments(r0.parent()));
        if (r6 != null) goto L26;
        return null;
    L26:
        return r6.findClassifierByJavaClass$descriptors_jvm(r4);
    L5:
        if (r4.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L8;
        return this.javaResolverCache.getClassResolvedFromSource(r0);
    }

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider r2, JavaResolverCache r3) {
        Intrinsics.checkNotNullParameter(r2, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r3, "javaResolverCache");
        this.packageFragmentProvider = r2;
        this.javaResolverCache = r3;
    }
}
