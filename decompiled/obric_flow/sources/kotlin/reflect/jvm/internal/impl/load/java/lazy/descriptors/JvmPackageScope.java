package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nJvmPackageScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/JvmPackageScope\n+ 2 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,109:1\n92#2,14:110\n60#2,5:124\n60#2,5:129\n60#2,5:134\n10664#3,5:139\n10664#3,5:144\n*S KotlinDebug\n*F\n+ 1 JvmPackageScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/JvmPackageScope\n*L\n58#1:110,14\n63#1:124,5\n68#1:129,5\n74#1:134,5\n76#1:139,5\n80#1:144,5\n*E\n"})
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f18745c;
    private final LazyJavaPackageScope javaScope;
    private final NotNullLazyValue kotlinScopes$delegate;
    private final LazyJavaPackageFragment packageFragment;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    public JvmPackageScope(LazyJavaResolverContext r5, JavaPackage r10, LazyJavaPackageFragment r11) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r10, "jPackage");
        Intrinsics.checkNotNullParameter(r11, "packageFragment");
        this.f18745c = r5;
        this.packageFragment = r11;
        this.javaScope = new LazyJavaPackageScope(r5, r10, r11);
        this.kotlinScopes$delegate = r5.getStorageManager().createLazyValue(new JvmPackageScope$kotlinScopes$2(this));
    }

    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(JvmPackageScope r5) {
        return r5.f18745c;
    }

    public static final /* synthetic */ LazyJavaPackageFragment access$getPackageFragment$p(JvmPackageScope r5) {
        return r5.packageFragment;
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) StorageKt.getValue(this.kotlinScopes$delegate, this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        Set<Name> r5 = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(getKotlinScopes()));
        if (r5 == null) goto L5;
        r5.addAll(this.javaScope.getClassifierNames());
        return r5;
    L5:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1404getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "location");
        mo1408recordLookup(r10, r11);
        ClassDescriptor r5 = this.javaScope.mo1404getContributedClassifier(r10, r11);
        if (r5 == null) goto L5;
        return r5;
    L5:
        MemberScope[] r12 = getKotlinScopes();
        int r13 = r12.length;
        ClassifierDescriptor r14 = null;
        int r15 = 0;
    L6:
        if (r15 >= r13) goto L24;
        ClassifierDescriptor r16 = r12[r15].mo1404getContributedClassifier(r10, r11);
        if (r16 == null) goto L16;
        if ((r16 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L17;
        if (((ClassifierDescriptorWithTypeParameters) r16).isExpect() == false) goto L17;
        if (r14 != null) goto L16;
        r14 = r16;
    L17:
        return r16;
    L16:
        r15 = r15 + 1;
        goto L6
    L24:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        LazyJavaPackageScope r11 = this.javaScope;
        MemberScope[] r12 = getKotlinScopes();
        Collection<DeclarationDescriptor> r13 = r11.getContributedDescriptors(r5, r10);
        int r14 = r12.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        r13 = ScopeUtilsKt.concat(r13, r12[r15].getContributedDescriptors(r5, r10));
        r15 = r15 + 1;
        goto L3
    L5:
        if (r13 == null) goto L7;
        return r13;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        mo1408recordLookup(r5, r10);
        LazyJavaPackageScope r11 = this.javaScope;
        MemberScope[] r12 = getKotlinScopes();
        Collection<? extends SimpleFunctionDescriptor> r13 = r11.getContributedFunctions(r5, r10);
        int r14 = r12.length;
        int r15 = 0;
        Collection r16 = r13;
    L3:
        if (r15 >= r14) goto L5;
        Collection r17 = ScopeUtilsKt.concat(r16, r12[r15].getContributedFunctions(r5, r10));
        r15 = r15 + 1;
        r16 = r17;
        goto L3
    L5:
        if (r16 == null) goto L7;
        return r16;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        mo1408recordLookup(r5, r10);
        LazyJavaPackageScope r11 = this.javaScope;
        MemberScope[] r12 = getKotlinScopes();
        Collection<? extends PropertyDescriptor> r13 = r11.getContributedVariables(r5, r10);
        int r14 = r12.length;
        int r15 = 0;
        Collection r16 = r13;
    L3:
        if (r15 >= r14) goto L5;
        Collection r17 = ScopeUtilsKt.concat(r16, r12[r15].getContributedVariables(r5, r10));
        r15 = r15 + 1;
        r16 = r17;
        goto L3
    L5:
        if (r16 == null) goto L7;
        return r16;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] r5 = getKotlinScopes();
        LinkedHashSet r10 = new LinkedHashSet();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        CollectionsKt.a(r10, r5[r12].getFunctionNames());
        r12 = r12 + 1;
        goto L3
    L5:
        r10.addAll(this.javaScope.getFunctionNames());
        return r10;
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] r5 = getKotlinScopes();
        LinkedHashSet r10 = new LinkedHashSet();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        CollectionsKt.a(r10, r5[r12].getVariableNames());
        r12 = r12 + 1;
        goto L3
    L5:
        r10.addAll(this.javaScope.getVariableNames());
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1408recordLookup(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        UtilsKt.record(this.f18745c.getComponents().getLookupTracker(), r10, this.packageFragment, r5);
    }

    public String toString() {
        return "scope for " + this.packageFragment;
    }
}
