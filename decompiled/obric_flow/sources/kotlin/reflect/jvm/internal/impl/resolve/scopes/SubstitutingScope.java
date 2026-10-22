package kotlin.reflect.jvm.internal.impl.resolve.scopes;

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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSubstitutingScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubstitutingScope.kt\norg/jetbrains/kotlin/resolve/scopes/SubstitutingScope\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 coreLib.kt\norg/jetbrains/kotlin/utils/CoreLibKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n361#2,3:112\n364#2,4:116\n19#3:115\n1#4:120\n*S KotlinDebug\n*F\n+ 1 SubstitutingScope.kt\norg/jetbrains/kotlin/resolve/scopes/SubstitutingScope\n*L\n52#1:112,3\n52#1:116,4\n54#1:115\n*E\n"})
public final class SubstitutingScope implements MemberScope {
    private final Lazy _allDescriptors$delegate;
    private final TypeSubstitutor capturingSubstitutor;
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    private final Lazy substitutor$delegate;
    private final MemberScope workerScope;

    public SubstitutingScope(MemberScope r5, final TypeSubstitutor r10) {
        Intrinsics.checkNotNullParameter(r5, "workerScope");
        Intrinsics.checkNotNullParameter(r10, "givenSubstitutor");
        this.workerScope = r5;
        this.substitutor$delegate = LazyKt.lazy(new SubstitutingScope$substitutor$2(r10));
        this.capturingSubstitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(r10.getSubstitution(), false, 1, null).buildSubstitutor();
        this._allDescriptors$delegate = LazyKt.lazy(new SubstitutingScope$_allDescriptors$2(this));
    }

    public static final /* synthetic */ MemberScope access$getWorkerScope$p(SubstitutingScope r5) {
        return r5.workerScope;
    }

    public static final /* synthetic */ Collection access$substitute(SubstitutingScope r5, Collection r10) {
        return r5.substitute(r10);
    }

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    private final <D extends DeclarationDescriptor> D substitute(D r5) {
        if (this.capturingSubstitutor.isEmpty() == false) goto L6;
        return r5;
    L6:
        if (this.substitutedDescriptors != null) goto L8;
        this.substitutedDescriptors = new HashMap();
    L8:
        Map<DeclarationDescriptor, DeclarationDescriptor> r10 = this.substitutedDescriptors;
        Intrinsics.checkNotNull(r10);
        DeclarationDescriptor r11 = r10.get(r5);
        if (r11 == null) goto L11;
    L19:
        D r12 = (D) r11;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return r12;
    L11:
        if ((r5 instanceof Substitutable) == false) goto L18;
        r11 = ((Substitutable) r5).substitute(this.capturingSubstitutor);
        if (r11 == null) goto L16;
        r10.put(r5, r11);
        goto L19
    L16:
        throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + r5 + " substitution fails");
    L18:
        throw new IllegalStateException(("Unknown descriptor in scope: " + r5).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        ClassifierDescriptor r11 = this.workerScope.mo1404getContributedClassifier(r5, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return (ClassifierDescriptor) substitute(r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        return get_allDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return substitute(this.workerScope.getContributedFunctions(r5, r10));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<? extends PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return substitute(this.workerScope.getContributedVariables(r5, r10));
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
    public void mo1408recordLookup(Name r5, LookupLocation r10) {
        MemberScope.DefaultImpls.recordLookup(this, r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> r5) {
        if (this.capturingSubstitutor.isEmpty() == false) goto L6;
        return r5;
    L6:
        if (r5.isEmpty() == false) goto L8;
        return r5;
    L8:
        LinkedHashSet r10 = CollectionsKt.newLinkedHashSetWithExpectedSize(r5.size());
        Iterator r11 = r5.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        r10.add(substitute((DeclarationDescriptor) r11.next()));
        goto L10
    L12:
        return r10;
    }
}
