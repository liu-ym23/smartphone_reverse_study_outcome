package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes3.dex */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = null;
    private final String debugName;
    private final MemberScope[] scopes;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final MemberScope create(String r10, Iterable<? extends MemberScope> r11) {
            Intrinsics.checkNotNullParameter(r10, "debugName");
            Intrinsics.checkNotNullParameter(r11, "scopes");
            SmartList r12 = new SmartList();
            Iterator<? extends MemberScope> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L12;
            MemberScope r14 = r13.next();
            if (r14 == MemberScope.Empty.INSTANCE) goto L4;
            if ((r14 instanceof ChainedMemberScope) == true) goto L9;
            r12.add(r14);
            goto L4
        L9:
            CollectionsKt.addAll(r12, ChainedMemberScope.access$getScopes$p((ChainedMemberScope) r14));
            goto L4
        L12:
            return createOrSingle$descriptors(r10, r12);
        }

        public final MemberScope createOrSingle$descriptors(String r10, List<? extends MemberScope> r11) {
            Intrinsics.checkNotNullParameter(r10, "debugName");
            Intrinsics.checkNotNullParameter(r11, "scopes");
            int r12 = r11.size();
            if (r12 == 0) goto L9;
            if (r12 == 1) goto L11;
            Object[] r13 = r11.toArray(new MemberScope[0]);
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new ChainedMemberScope(r10, (MemberScope[]) r13, null);
        L11:
            return r11.get(0);
        L9:
            return MemberScope.Empty.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private ChainedMemberScope(String r10, MemberScope[] r11) {
        this.debugName = r10;
        this.scopes = r11;
    }

    public /* synthetic */ ChainedMemberScope(String r10, MemberScope[] r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static final /* synthetic */ MemberScope[] access$getScopes$p(ChainedMemberScope r10) {
        return r10.scopes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(this.scopes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        MemberScope[] r12 = this.scopes;
        int r13 = r12.length;
        ClassifierDescriptor r14 = null;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L21;
        ClassifierDescriptor r16 = r12[r15].mo1325getContributedClassifier(r10, r11);
        if (r16 == null) goto L13;
        if ((r16 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L14;
        if (((ClassifierDescriptorWithTypeParameters) r16).isExpect() == false) goto L14;
        if (r14 != null) goto L13;
        r14 = r16;
    L14:
        return r16;
    L13:
        r15 = r15 + 1;
        goto L3
    L21:
        return r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        MemberScope[] r12 = this.scopes;
        int r13 = r12.length;
        if (r13 == 0) goto L13;
        int r14 = 0;
        if (r13 == 1) goto L17;
        Collection<DeclarationDescriptor> r15 = null;
        int r16 = r12.length;
    L7:
        if (r14 >= r16) goto L9;
        r15 = ScopeUtilsKt.concat(r15, r12[r14].getContributedDescriptors(r10, r11));
        r14 = r14 + 1;
        goto L7
    L9:
        if (r15 == null) goto L16;
        return r15;
    L16:
        return SetsKt.emptySet();
    L17:
        return r12[0].getContributedDescriptors(r10, r11);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        MemberScope[] r12 = this.scopes;
        int r13 = r12.length;
        if (r13 == 0) goto L13;
        int r14 = 0;
        if (r13 == 1) goto L17;
        Collection<SimpleFunctionDescriptor> r15 = null;
        int r16 = r12.length;
    L7:
        if (r14 >= r16) goto L9;
        r15 = ScopeUtilsKt.concat(r15, r12[r14].getContributedFunctions(r10, r11));
        r14 = r14 + 1;
        goto L7
    L9:
        if (r15 == null) goto L16;
        return r15;
    L16:
        return SetsKt.emptySet();
    L17:
        return r12[0].getContributedFunctions(r10, r11);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        MemberScope[] r12 = this.scopes;
        int r13 = r12.length;
        if (r13 == 0) goto L13;
        int r14 = 0;
        if (r13 == 1) goto L17;
        Collection<PropertyDescriptor> r15 = null;
        int r16 = r12.length;
    L7:
        if (r14 >= r16) goto L9;
        r15 = ScopeUtilsKt.concat(r15, r12[r14].getContributedVariables(r10, r11));
        r14 = r14 + 1;
        goto L7
    L9:
        if (r15 == null) goto L16;
        return r15;
    L16:
        return SetsKt.emptySet();
    L17:
        return r12[0].getContributedVariables(r10, r11);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] r10 = this.scopes;
        LinkedHashSet r11 = new LinkedHashSet();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        CollectionsKt.addAll(r11, r10[r13].getFunctionNames());
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] r10 = this.scopes;
        LinkedHashSet r11 = new LinkedHashSet();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        CollectionsKt.addAll(r11, r10[r13].getVariableNames());
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1329recordLookup(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        MemberScope[] r12 = this.scopes;
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12[r14].mo1329recordLookup(r10, r11);
        r14 = r14 + 1;
        goto L3
    }

    public String toString() {
        return this.debugName;
    }
}
