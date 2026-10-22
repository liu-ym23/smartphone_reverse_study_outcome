package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10207c;
    private final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> packageFragments;

    public LazyJavaPackageFragmentProvider(JavaResolverComponents r10) {
        Intrinsics.checkNotNullParameter(r10, "components");
        LazyJavaResolverContext r11 = new LazyJavaResolverContext(r10, TypeParameterResolver.EMPTY.INSTANCE, LazyKt.lazyOf(null));
        this.f10207c = r11;
        this.packageFragments = r11.getStorageManager().createCacheWithNotNullValues();
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaPackageFragmentProvider r10) {
        return r10.f10207c;
    }

    private final LazyJavaPackageFragment getPackageFragment(FqName r10) {
        final JavaPackage r11 = JavaClassFinder.DefaultImpls.findPackage$default(this.f10207c.getComponents().getFinder(), r10, false, 2, null);
        if (r11 != null) goto L6;
        return null;
    L6:
        return this.packageFragments.computeIfAbsent(r10, new AnonymousClass1(this, r11));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(FqName r10, Collection<PackageFragmentDescriptor> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "packageFragments");
        CollectionsKt.addIfNotNull(r11, getPackageFragment(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<LazyJavaPackageFragment> getPackageFragments(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(getPackageFragment(r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(FqName r10, Function1 r11) {
        return getSubPackagesOf(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public List<FqName> getSubPackagesOf(FqName r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        LazyJavaPackageFragment r12 = getPackageFragment(r10);
        if (r12 == null) goto L5;
        List<FqName> r13 = r12.getSubPackageFqNames$descriptors_jvm();
    L6:
        if (r13 == null) goto L8;
        return r13;
    L8:
        return kotlin.collections.CollectionsKt.emptyList();
    L5:
        r13 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        if (JavaClassFinder.DefaultImpls.findPackage$default(this.f10207c.getComponents().getFinder(), r10, false, 2, null) != null) goto L6;
        return true;
    L6:
        return false;
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.f10207c.getComponents().getModule();
    }
}
