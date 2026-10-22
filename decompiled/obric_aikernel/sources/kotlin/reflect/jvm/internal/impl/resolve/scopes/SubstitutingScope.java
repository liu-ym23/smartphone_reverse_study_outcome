package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SubstitutingScope implements MemberScope {
    private final Lazy _allDescriptors$delegate;
    private final TypeSubstitutor capturingSubstitutor;
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    private final Lazy substitutor$delegate;
    private final MemberScope workerScope;

    public SubstitutingScope(MemberScope r10, final TypeSubstitutor r11) {
        Intrinsics.checkNotNullParameter(r10, "workerScope");
        Intrinsics.checkNotNullParameter(r11, "givenSubstitutor");
        this.workerScope = r10;
        this.substitutor$delegate = LazyKt.lazy(new SubstitutingScope$substitutor$2(r11));
        TypeSubstitution r12 = r11.getSubstitution();
        Intrinsics.checkNotNullExpressionValue(r12, "givenSubstitutor.substitution");
        this.capturingSubstitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(r12, false, 1, null).buildSubstitutor();
        this._allDescriptors$delegate = LazyKt.lazy(new SubstitutingScope$_allDescriptors$2(this));
    }

    public static final /* synthetic */ MemberScope access$getWorkerScope$p(SubstitutingScope r10) {
        return r10.workerScope;
    }

    public static final /* synthetic */ Collection access$substitute(SubstitutingScope r10, Collection r11) {
        return r10.substitute(r11);
    }

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> r10) {
        if (this.capturingSubstitutor.isEmpty() == false) goto L6;
        return r10;
    L6:
        if (r10.isEmpty() == false) goto L8;
        return r10;
    L8:
        LinkedHashSet r11 = CollectionsKt.newLinkedHashSetWithExpectedSize(r10.size());
        Iterator r12 = r10.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        r11.add(substitute((DeclarationDescriptor) r12.next()));
        goto L10
    L12:
        return r11;
    }

    private final <D extends DeclarationDescriptor> D substitute(D r10) {
        if (this.capturingSubstitutor.isEmpty() == false) goto L6;
        return r10;
    L6:
        if (this.substitutedDescriptors != null) goto L8;
        this.substitutedDescriptors = new HashMap();
    L8:
        Map<DeclarationDescriptor, DeclarationDescriptor> r11 = this.substitutedDescriptors;
        Intrinsics.checkNotNull(r11);
        DeclarationDescriptor r12 = r11.get(r10);
        if (r12 == null) goto L11;
    L19:
        D r13 = (D) r12;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return r13;
    L11:
        if ((r10 instanceof Substitutable) == false) goto L18;
        r12 = ((Substitutable) r10).substitute(this.capturingSubstitutor);
        if (r12 == null) goto L16;
        r11.put(r10, r12);
        goto L19
    L16:
        throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + r10 + " substitution fails");
    L18:
        throw new IllegalStateException(("Unknown descriptor in scope: " + r10).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        ClassifierDescriptor r12 = this.workerScope.mo1325getContributedClassifier(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return (ClassifierDescriptor) substitute(r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        return get_allDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return substitute(this.workerScope.getContributedFunctions(r10, r11));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return substitute(this.workerScope.getContributedVariables(r10, r11));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1329recordLookup(Name r10, LookupLocation r11) {
        MemberScope.DefaultImpls.recordLookup(this, r10, r11);
    }
}
