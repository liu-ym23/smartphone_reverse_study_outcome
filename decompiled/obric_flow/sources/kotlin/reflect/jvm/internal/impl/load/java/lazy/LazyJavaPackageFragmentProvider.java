package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder$$Util;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f18743c;
    private final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> packageFragments;

    public LazyJavaPackageFragmentProvider(JavaResolverComponents r5) {
        Intrinsics.checkNotNullParameter(r5, "components");
        LazyJavaResolverContext r10 = new LazyJavaResolverContext(r5, TypeParameterResolver.EMPTY.INSTANCE, LazyKt.b());
        this.f18743c = r10;
        this.packageFragments = r10.getStorageManager().createCacheWithNotNullValues();
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaPackageFragmentProvider r5) {
        return r5.f18743c;
    }

    private final LazyJavaPackageFragment getPackageFragment(FqName r5) {
        final JavaPackage r10 = JavaClassFinder$$Util.findPackage$default(this.f18743c.getComponents().getFinder(), r5, false, 2, null);
        if (r10 != null) goto L6;
        return null;
    L6:
        return this.packageFragments.computeIfAbsent(r5, new AnonymousClass1(this, r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r5, Collection<PackageFragmentDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "packageFragments");
        CollectionsKt.addIfNotNull(r10, getPackageFragment(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<LazyJavaPackageFragment> getPackageFragments(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(getPackageFragment(r5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(FqName r5, Function1 r10) {
        return getSubPackagesOf(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        if (JavaClassFinder$$Util.findPackage$default(this.f18743c.getComponents().getFinder(), r5, false, 2, null) != null) goto L6;
        return true;
    L6:
        return false;
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.f18743c.getComponents().getModule();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<FqName> getSubPackagesOf(FqName r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "fqName");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        LazyJavaPackageFragment r11 = getPackageFragment(r5);
        if (r11 == null) goto L5;
        List<FqName> r12 = r11.getSubPackageFqNames$descriptors_jvm();
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        return kotlin.collections.CollectionsKt.emptyList();
    L5:
        r12 = null;
        goto L6
    }
}
