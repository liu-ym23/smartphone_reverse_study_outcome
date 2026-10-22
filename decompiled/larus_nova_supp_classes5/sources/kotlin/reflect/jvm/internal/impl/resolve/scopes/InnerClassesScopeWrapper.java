package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    private final MemberScope workerScope;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    public String toString() {
        return "Classes from " + this.workerScope;
    }

    public InnerClassesScopeWrapper(MemberScope r2) {
        Intrinsics.checkNotNullParameter(r2, "workerScope");
        this.workerScope = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo383getContributedClassifier(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        ClassifierDescriptor r4 = this.workerScope.mo383getContributedClassifier(r2, r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((r4 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r0 = (ClassDescriptor) r4;
    L8:
        if (r0 == null) goto L11;
        return r0;
    L11:
        if ((r4 instanceof TypeAliasDescriptor) == true) goto L13;
        return null;
    L13:
        return (TypeAliasDescriptor) r4;
    L7:
        r0 = null;
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<ClassifierDescriptor> getContributedDescriptors(DescriptorKindFilter r3, Function1<? super Name, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "kindFilter");
        Intrinsics.checkNotNullParameter(r4, "nameFilter");
        DescriptorKindFilter r5 = r3.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (r5 == null) goto L5;
        Collection<DeclarationDescriptor> r6 = this.workerScope.getContributedDescriptors(r5, r4);
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Object r0 = r8.next();
        if ((r0 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L8;
        r7.add(r0);
        goto L8
    L12:
        return r7;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(Name r2, LookupLocation r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r3, "location");
        this.workerScope.recordLookup(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter r1, Function1 r2) {
        return getContributedDescriptors(r1, r2);
    }
}
