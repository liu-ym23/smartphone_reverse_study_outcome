package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.crash.tracker.ActivityLifecycle;
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

/* JADX INFO: loaded from: classes3.dex */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    private final MemberScope workerScope;

    public InnerClassesScopeWrapper(MemberScope r10) {
        Intrinsics.checkNotNullParameter(r10, "workerScope");
        this.workerScope = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        ClassifierDescriptor r12 = this.workerScope.mo1325getContributedClassifier(r10, r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        if ((r12 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r13 = (ClassDescriptor) r12;
    L8:
        if (r13 == null) goto L11;
        return r13;
    L11:
        if ((r12 instanceof TypeAliasDescriptor) == true) goto L13;
        return null;
    L13:
        return (TypeAliasDescriptor) r12;
    L7:
        r13 = null;
        goto L8
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(DescriptorKindFilter r10, Function1 r11) {
        return getContributedDescriptors(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public List<ClassifierDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        DescriptorKindFilter r12 = r10.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (r12 == null) goto L5;
        Collection<DeclarationDescriptor> r13 = this.workerScope.getContributedDescriptors(r12, r11);
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        if ((r16 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L8;
        r14.add(r16);
        goto L8
    L12:
        return r14;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1329recordLookup(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        this.workerScope.mo1329recordLookup(r10, r11);
    }

    public String toString() {
        return "Classes from " + this.workerScope;
    }
}
