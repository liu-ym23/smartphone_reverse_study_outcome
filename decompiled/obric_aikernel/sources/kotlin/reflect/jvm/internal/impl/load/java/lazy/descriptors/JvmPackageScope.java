package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f10209c;
    private final LazyJavaPackageScope javaScope;
    private final NotNullLazyValue kotlinScopes$delegate;
    private final LazyJavaPackageFragment packageFragment;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    public JvmPackageScope(LazyJavaResolverContext r10, JavaPackage r11, LazyJavaPackageFragment r12) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "jPackage");
        Intrinsics.checkNotNullParameter(r12, "packageFragment");
        this.f10209c = r10;
        this.packageFragment = r12;
        this.javaScope = new LazyJavaPackageScope(r10, r11, r12);
        this.kotlinScopes$delegate = r10.getStorageManager().createLazyValue(new JvmPackageScope$kotlinScopes$2(this));
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(JvmPackageScope r10) {
        return r10.f10209c;
    }

    public static final /* synthetic */ LazyJavaPackageFragment access$getPackageFragment$p(JvmPackageScope r10) {
        return r10.packageFragment;
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) StorageKt.getValue(this.kotlinScopes$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        Set<Name> r10 = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(getKotlinScopes()));
        if (r10 == null) goto L5;
        r10.addAll(this.javaScope.getClassifierNames());
        return r10;
    L5:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        mo1329recordLookup(r10, r11);
        ClassDescriptor r12 = this.javaScope.mo1325getContributedClassifier(r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        MemberScope[] r13 = getKotlinScopes();
        ClassifierDescriptor r14 = null;
        int r15 = 0;
        int r16 = r13.length;
    L6:
        if (r15 >= r16) goto L24;
        ClassifierDescriptor r17 = r13[r15].mo1325getContributedClassifier(r10, r11);
        if (r17 == null) goto L16;
        if ((r17 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L17;
        if (((ClassifierDescriptorWithTypeParameters) r17).isExpect() == false) goto L17;
        if (r14 != null) goto L16;
        r14 = r17;
    L17:
        return r17;
    L16:
        r15 = r15 + 1;
        goto L6
    L24:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        LazyJavaPackageScope r12 = this.javaScope;
        MemberScope[] r13 = getKotlinScopes();
        Collection<DeclarationDescriptor> r14 = r12.getContributedDescriptors(r10, r11);
        int r15 = r13.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        r14 = ScopeUtilsKt.concat(r14, r13[r16].getContributedDescriptors(r10, r11));
        r16 = r16 + 1;
        goto L3
    L5:
        if (r14 == null) goto L7;
        return r14;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        mo1329recordLookup(r10, r11);
        LazyJavaPackageScope r12 = this.javaScope;
        MemberScope[] r13 = getKotlinScopes();
        Collection<? extends SimpleFunctionDescriptor> r14 = r12.getContributedFunctions(r10, r11);
        int r15 = r13.length;
        int r16 = 0;
        Collection r17 = r14;
    L3:
        if (r16 >= r15) goto L5;
        Collection r18 = ScopeUtilsKt.concat(r17, r13[r16].getContributedFunctions(r10, r11));
        r16 = r16 + 1;
        r17 = r18;
        goto L3
    L5:
        if (r17 == null) goto L7;
        return r17;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        mo1329recordLookup(r10, r11);
        LazyJavaPackageScope r12 = this.javaScope;
        MemberScope[] r13 = getKotlinScopes();
        Collection<? extends PropertyDescriptor> r14 = r12.getContributedVariables(r10, r11);
        int r15 = r13.length;
        int r16 = 0;
        Collection r17 = r14;
    L3:
        if (r16 >= r15) goto L5;
        Collection r18 = ScopeUtilsKt.concat(r17, r13[r16].getContributedVariables(r10, r11));
        r16 = r16 + 1;
        r17 = r18;
        goto L3
    L5:
        if (r17 == null) goto L7;
        return r17;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] r10 = getKotlinScopes();
        LinkedHashSet r11 = new LinkedHashSet();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        CollectionsKt.addAll(r11, r10[r13].getFunctionNames());
        r13 = r13 + 1;
        goto L3
    L5:
        r11.addAll(this.javaScope.getFunctionNames());
        return r11;
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] r10 = getKotlinScopes();
        LinkedHashSet r11 = new LinkedHashSet();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        CollectionsKt.addAll(r11, r10[r13].getVariableNames());
        r13 = r13 + 1;
        goto L3
    L5:
        r11.addAll(this.javaScope.getVariableNames());
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1329recordLookup(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        UtilsKt.record(this.f10209c.getComponents().getLookupTracker(), r11, this.packageFragment, r10);
    }

    public String toString() {
        return "scope for " + this.packageFragment;
    }
}
