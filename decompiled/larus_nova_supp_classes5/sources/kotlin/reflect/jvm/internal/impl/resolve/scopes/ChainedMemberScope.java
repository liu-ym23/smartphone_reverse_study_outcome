package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = null;
    private final String debugName;
    private final MemberScope[] scopes;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final MemberScope create(String r4, Iterable<? extends MemberScope> r5) {
            Intrinsics.checkNotNullParameter(r4, "debugName");
            Intrinsics.checkNotNullParameter(r5, "scopes");
            SmartList r0 = new SmartList();
            Iterator<? extends MemberScope> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L12;
            MemberScope r1 = r6.next();
            if (r1 == MemberScope.Empty.INSTANCE) goto L4;
            if ((r1 instanceof ChainedMemberScope) == true) goto L9;
            r0.add(r1);
            goto L4
        L9:
            CollectionsKt.addAll(r0, ChainedMemberScope.access$getScopes$p((ChainedMemberScope) r1));
            goto L4
        L12:
            return createOrSingle$descriptors(r4, r0);
        }

        public final MemberScope createOrSingle$descriptors(String r4, List<? extends MemberScope> r5) {
            Intrinsics.checkNotNullParameter(r4, "debugName");
            Intrinsics.checkNotNullParameter(r5, "scopes");
            int r0 = r5.size();
            if (r0 == 0) goto L9;
            if (r0 == 1) goto L11;
            return new ChainedMemberScope(r4, (MemberScope[]) r5.toArray(new MemberScope[0]), null);
        L11:
            return (MemberScope) ListProtector.get(r5, 0);
        L9:
            return MemberScope.Empty.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ ChainedMemberScope(String r1, MemberScope[] r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(this.scopes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] r0 = this.scopes;
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        CollectionsKt.addAll(r1, r0[r3].getFunctionNames());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] r0 = this.scopes;
        LinkedHashSet r1 = new LinkedHashSet();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        CollectionsKt.addAll(r1, r0[r3].getVariableNames());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public String toString() {
        return this.debugName;
    }

    public static final /* synthetic */ MemberScope[] access$getScopes$p(ChainedMemberScope r0) {
        return r0.scopes;
    }

    private ChainedMemberScope(String r1, MemberScope[] r2) {
        this.debugName = r1;
        this.scopes = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo383getContributedClassifier(Name r7, LookupLocation r8) {
        Intrinsics.checkNotNullParameter(r7, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r8, "location");
        MemberScope[] r0 = this.scopes;
        int r1 = r0.length;
        ClassifierDescriptor r2 = null;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L21;
        ClassifierDescriptor r4 = r0[r3].mo383getContributedClassifier(r7, r8);
        if (r4 == null) goto L13;
        if ((r4 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L14;
        if (((MemberDescriptor) r4).isExpect() == false) goto L14;
        if (r2 != null) goto L13;
        r2 = r4;
    L14:
        return r4;
    L13:
        r3 = r3 + 1;
        goto L3
    L21:
        return r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r6, Function1<? super Name, Boolean> r7) {
        Intrinsics.checkNotNullParameter(r6, "kindFilter");
        Intrinsics.checkNotNullParameter(r7, "nameFilter");
        MemberScope[] r0 = this.scopes;
        int r1 = r0.length;
        if (r1 == 0) goto L13;
        int r2 = 0;
        if (r1 == 1) goto L17;
        int r3 = r0.length;
        Collection<DeclarationDescriptor> r4 = null;
    L7:
        if (r2 >= r3) goto L9;
        r4 = ScopeUtilsKt.concat(r4, r0[r2].getContributedDescriptors(r6, r7));
        r2 = r2 + 1;
        goto L7
    L9:
        if (r4 == null) goto L16;
        return r4;
    L16:
        return SetsKt.emptySet();
    L17:
        return r0[0].getContributedDescriptors(r6, r7);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r6, LookupLocation r7) {
        Intrinsics.checkNotNullParameter(r6, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r7, "location");
        MemberScope[] r0 = this.scopes;
        int r1 = r0.length;
        if (r1 == 0) goto L13;
        int r2 = 0;
        if (r1 == 1) goto L17;
        int r3 = r0.length;
        Collection<SimpleFunctionDescriptor> r4 = null;
    L7:
        if (r2 >= r3) goto L9;
        r4 = ScopeUtilsKt.concat(r4, r0[r2].getContributedFunctions(r6, r7));
        r2 = r2 + 1;
        goto L7
    L9:
        if (r4 == null) goto L16;
        return r4;
    L16:
        return SetsKt.emptySet();
    L17:
        return r0[0].getContributedFunctions(r6, r7);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r6, LookupLocation r7) {
        Intrinsics.checkNotNullParameter(r6, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r7, "location");
        MemberScope[] r0 = this.scopes;
        int r1 = r0.length;
        if (r1 == 0) goto L13;
        int r2 = 0;
        if (r1 == 1) goto L17;
        int r3 = r0.length;
        Collection<PropertyDescriptor> r4 = null;
    L7:
        if (r2 >= r3) goto L9;
        r4 = ScopeUtilsKt.concat(r4, r0[r2].getContributedVariables(r6, r7));
        r2 = r2 + 1;
        goto L7
    L9:
        if (r4 == null) goto L16;
        return r4;
    L16:
        return SetsKt.emptySet();
    L17:
        return r0[0].getContributedVariables(r6, r7);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(Name r5, LookupLocation r6) {
        Intrinsics.checkNotNullParameter(r5, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r6, "location");
        MemberScope[] r0 = this.scopes;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2].recordLookup(r5, r6);
        r2 = r2 + 1;
        goto L3
    }
}
