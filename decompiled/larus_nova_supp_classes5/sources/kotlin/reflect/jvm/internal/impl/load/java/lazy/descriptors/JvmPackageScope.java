package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final LazyJavaResolverContext c;
    private final LazyJavaPackageScope javaScope;
    private final NotNullLazyValue kotlinScopes$delegate;
    private final LazyJavaPackageFragment packageFragment;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    }

    public static /* synthetic */ MemberScope[] accessor$JvmPackageScope$lambda0(JvmPackageScope r0) {
        return kotlinScopes_delegate$lambda$1(r0);
    }

    private final MemberScope[] getKotlinScopes() {
        return (MemberScope[]) StorageKt.getValue(this.kotlinScopes$delegate, this, $$delegatedProperties[0]);
    }

    public String toString() {
        return "scope for " + this.packageFragment;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        Set<Name> r0 = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(getKotlinScopes()));
        if (r0 == null) goto L5;
        r0.addAll(this.javaScope.getClassifierNames());
        return r0;
    L5:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] r0 = getKotlinScopes();
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        CollectionsKt.addAll(r1, r0[r3].getFunctionNames());
        r3 = r3 + 1;
        goto L3
    L5:
        r1.addAll(this.javaScope.getFunctionNames());
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] r0 = getKotlinScopes();
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        CollectionsKt.addAll(r1, r0[r3].getVariableNames());
        r3 = r3 + 1;
        goto L3
    L5:
        r1.addAll(this.javaScope.getVariableNames());
        return r1;
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.javaScope;
    }

    private static final MemberScope[] kotlinScopes_delegate$lambda$1(JvmPackageScope r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Collection<KotlinJvmBinaryClass> r0 = r5.packageFragment.getBinaryClasses$descriptors_jvm().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        KotlinJvmBinaryClass r3 = (KotlinJvmBinaryClass) r2.next();
        MemberScope r4 = r5.c.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(r5.packageFragment, r3);
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L9:
        return (MemberScope[]) ScopeUtilsKt.listOfNonEmptyScopes(r1).toArray(new MemberScope[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo383getContributedClassifier(Name r7, LookupLocation r8) {
        Intrinsics.checkNotNullParameter(r7, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r8, "location");
        recordLookup(r7, r8);
        ClassDescriptor r0 = this.javaScope.mo383getContributedClassifier(r7, r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        MemberScope[] r1 = getKotlinScopes();
        int r2 = r1.length;
        ClassifierDescriptor r3 = null;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L24;
        ClassifierDescriptor r5 = r1[r4].mo383getContributedClassifier(r7, r8);
        if (r5 == null) goto L16;
        if ((r5 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L17;
        if (((MemberDescriptor) r5).isExpect() == false) goto L17;
        if (r3 != null) goto L16;
        r3 = r5;
    L17:
        return r5;
    L16:
        r4 = r4 + 1;
        goto L6
    L24:
        return r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r6, Function1<? super Name, Boolean> r7) {
        Intrinsics.checkNotNullParameter(r6, "kindFilter");
        Intrinsics.checkNotNullParameter(r7, "nameFilter");
        LazyJavaPackageScope r0 = this.javaScope;
        MemberScope[] r1 = getKotlinScopes();
        Collection<DeclarationDescriptor> r2 = r0.getContributedDescriptors(r6, r7);
        int r3 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        r2 = ScopeUtilsKt.concat(r2, r1[r4].getContributedDescriptors(r6, r7));
        r4 = r4 + 1;
        goto L3
    L5:
        if (r2 == null) goto L7;
        return r2;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r6, LookupLocation r7) {
        Intrinsics.checkNotNullParameter(r6, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r7, "location");
        recordLookup(r6, r7);
        LazyJavaPackageScope r0 = this.javaScope;
        MemberScope[] r1 = getKotlinScopes();
        Collection<? extends SimpleFunctionDescriptor> r2 = r0.getContributedFunctions(r6, r7);
        int r3 = r1.length;
        int r4 = 0;
        Collection r5 = r2;
    L3:
        if (r4 >= r3) goto L5;
        Collection r8 = ScopeUtilsKt.concat(r5, r1[r4].getContributedFunctions(r6, r7));
        r4 = r4 + 1;
        r5 = r8;
        goto L3
    L5:
        if (r5 == null) goto L7;
        return r5;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r6, LookupLocation r7) {
        Intrinsics.checkNotNullParameter(r6, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r7, "location");
        recordLookup(r6, r7);
        LazyJavaPackageScope r0 = this.javaScope;
        MemberScope[] r1 = getKotlinScopes();
        Collection<? extends PropertyDescriptor> r2 = r0.getContributedVariables(r6, r7);
        int r3 = r1.length;
        int r4 = 0;
        Collection r5 = r2;
    L3:
        if (r4 >= r3) goto L5;
        Collection r8 = ScopeUtilsKt.concat(r5, r1[r4].getContributedVariables(r6, r7));
        r4 = r4 + 1;
        r5 = r8;
        goto L3
    L5:
        if (r5 == null) goto L7;
        return r5;
    L7:
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(Name r3, LookupLocation r4) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r4, "location");
        UtilsKt.record(this.c.getComponents().getLookupTracker(), r4, this.packageFragment, r3);
    }

    public JvmPackageScope(LazyJavaResolverContext r2, JavaPackage r3, LazyJavaPackageFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "jPackage");
        Intrinsics.checkNotNullParameter(r4, "packageFragment");
        this.c = r2;
        this.packageFragment = r4;
        this.javaScope = new LazyJavaPackageScope(r2, r3, r4);
        this.kotlinScopes$delegate = r2.getStorageManager().createLazyValue(new JvmPackageScope$$Lambda$0(this));
    }
}
