package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class SubpackagesScope extends MemberScopeImpl {
    private final FqName fqName;
    private final ModuleDescriptor moduleDescriptor;

    public String toString() {
        return "subpackages of " + this.fqName + " from " + this.moduleDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return SetsKt.emptySet();
    }

    public final PackageViewDescriptor getPackage(Name r4) {
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        if (r4.isSpecial() == false) goto L5;
        return null;
    L5:
        PackageViewDescriptor r5 = this.moduleDescriptor.getPackage(this.fqName.child(r4));
        if (r5.isEmpty() == false) goto L8;
        return null;
    L8:
        return r5;
    }

    public SubpackagesScope(ModuleDescriptor r2, FqName r3) {
        Intrinsics.checkNotNullParameter(r2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(r3, "fqName");
        this.moduleDescriptor = r2;
        this.fqName = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r4, Function1<? super Name, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r4, "kindFilter");
        Intrinsics.checkNotNullParameter(r5, "nameFilter");
        if (r4.acceptsKinds(DescriptorKindFilter.Companion.getPACKAGES_MASK()) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (this.fqName.isRoot() == true) goto L9;
    L12:
        Collection<FqName> r6 = this.moduleDescriptor.getSubPackagesOf(this.fqName, r5);
        ArrayList r0 = new ArrayList(r6.size());
        Iterator<FqName> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L18;
        Name r1 = r7.next().shortName();
        if (((Boolean) r5.invoke(r1)).booleanValue() == false) goto L14;
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r0, getPackage(r1));
        goto L14
    L18:
        return r0;
    L9:
        if (r4.getExcludes().contains(DescriptorKindExclude.TopLevelPackages.INSTANCE) == false) goto L12;
        return CollectionsKt.emptyList();
    }
}
