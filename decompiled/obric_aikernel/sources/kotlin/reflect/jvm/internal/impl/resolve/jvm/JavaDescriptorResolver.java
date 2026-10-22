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

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider r10, JavaResolverCache r11) {
        Intrinsics.checkNotNullParameter(r10, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(r11, "javaResolverCache");
        this.packageFragmentProvider = r10;
        this.javaResolverCache = r11;
    }

    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final ClassDescriptor resolveClass(JavaClass r10) {
        Intrinsics.checkNotNullParameter(r10, "javaClass");
        FqName r11 = r10.getFqName();
        if (r11 != null) goto L5;
    L8:
        JavaClass r12 = r10.getOuterClass();
        if (r12 == null) goto L21;
        ClassDescriptor r13 = resolveClass(r12);
        if (r13 == null) goto L13;
        MemberScope r14 = r13.getUnsubstitutedInnerClassesScope();
    L14:
        if (r14 == null) goto L16;
        ClassifierDescriptor r15 = r14.mo1325getContributedClassifier(r10.getName(), NoLookupLocation.FROM_JAVA_LOADER);
    L18:
        if ((r15 instanceof ClassDescriptor) == true) goto L20;
        return null;
    L20:
        return (ClassDescriptor) r15;
    L16:
        r15 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    L21:
        if (r11 != null) goto L23;
        return null;
    L23:
        LazyJavaPackageFragmentProvider r16 = this.packageFragmentProvider;
        FqName r17 = r11.parent();
        Intrinsics.checkNotNullExpressionValue(r17, "fqName.parent()");
        LazyJavaPackageFragment r18 = (LazyJavaPackageFragment) CollectionsKt.firstOrNull(r16.getPackageFragments(r17));
        if (r18 != null) goto L26;
        return null;
    L26:
        return r18.findClassifierByJavaClass$descriptors_jvm(r10);
    L5:
        if (r10.getLightClassOriginKind() != LightClassOriginKind.SOURCE) goto L8;
        return this.javaResolverCache.getClassResolvedFromSource(r11);
    }
}
