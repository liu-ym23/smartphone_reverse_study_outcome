package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;

/* JADX INFO: loaded from: classes3.dex */
public class SubpackagesScope extends MemberScopeImpl {
    private final FqName fqName;
    private final ModuleDescriptor moduleDescriptor;

    public SubpackagesScope(ModuleDescriptor r10, FqName r11) {
        Intrinsics.checkNotNullParameter(r10, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r11, "fqName");
        this.moduleDescriptor = r10;
        this.fqName = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        if (r10.acceptsKinds(DescriptorKindFilter.Companion.getPACKAGES_MASK()) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (this.fqName.isRoot() == true) goto L9;
    L12:
        Collection<FqName> r12 = this.moduleDescriptor.getSubPackagesOf(this.fqName, r11);
        ArrayList r13 = new ArrayList(r12.size());
        Iterator<FqName> r14 = r12.iterator();
    L14:
        if (r14.hasNext() == false) goto L18;
        Name r15 = r14.next().shortName();
        Intrinsics.checkNotNullExpressionValue(r15, "subFqName.shortName()");
        if (r11.invoke(r15).booleanValue() == false) goto L14;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r13, getPackage(r15));
        goto L14
    L18:
        return r13;
    L9:
        if (r10.getExcludes().contains(DescriptorKindExclude.TopLevelPackages.INSTANCE) == false) goto L12;
        return CollectionsKt.emptyList();
    }

    protected final PackageViewDescriptor getPackage(Name r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        if (r10.isSpecial() == false) goto L5;
        return null;
    L5:
        ModuleDescriptor r11 = this.moduleDescriptor;
        FqName r12 = this.fqName.child(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "fqName.child(name)");
        PackageViewDescriptor r13 = r11.getPackage(r12);
        if (r13.isEmpty() == false) goto L8;
        return null;
    L8:
        return r13;
    }

    public String toString() {
        return "subpackages of " + this.fqName + " from " + this.moduleDescriptor;
    }
}
