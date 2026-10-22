package kotlin.reflect.jvm.internal.impl.descriptors.impl;

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

    public SubpackagesScope(ModuleDescriptor r5, FqName r10) {
        Intrinsics.checkNotNullParameter(r5, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r10, "fqName");
        this.moduleDescriptor = r5;
        this.fqName = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return SetsKt.emptySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        if (r5.acceptsKinds(DescriptorKindFilter.Companion.getPACKAGES_MASK()) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (this.fqName.isRoot() == true) goto L9;
    L12:
        Collection<FqName> r11 = this.moduleDescriptor.getSubPackagesOf(this.fqName, r10);
        ArrayList r12 = new ArrayList(r11.size());
        Iterator<FqName> r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        Name r14 = r13.next().shortName();
        if (r10.invoke(r14).booleanValue() == false) goto L14;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r12, getPackage(r14));
        goto L14
    L18:
        return r12;
    L9:
        if (r5.getExcludes().contains(DescriptorKindExclude.TopLevelPackages.INSTANCE) == false) goto L12;
        return CollectionsKt.emptyList();
    }

    public final PackageViewDescriptor getPackage(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        if (r5.isSpecial() == false) goto L5;
        return null;
    L5:
        PackageViewDescriptor r10 = this.moduleDescriptor.getPackage(this.fqName.child(r5));
        if (r10.isEmpty() == false) goto L8;
        return null;
    L8:
        return r10;
    }

    public String toString() {
        return "subpackages of " + this.fqName + " from " + this.moduleDescriptor;
    }
}
