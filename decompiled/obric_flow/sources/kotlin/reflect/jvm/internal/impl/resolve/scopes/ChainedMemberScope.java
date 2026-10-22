package kotlin.reflect.jvm.internal.impl.resolve.scopes;

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
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nChainedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope\n+ 2 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,91:1\n92#2,14:92\n47#2,11:106\n47#2,11:117\n47#2,11:128\n10664#3,5:139\n10664#3,5:144\n13579#3,2:149\n*S KotlinDebug\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope\n*L\n35#1:92,14\n38#1:106,11\n41#1:117,11\n44#1:128,11\n46#1:139,5\n47#1:144,5\n51#1:149,2\n*E\n"})
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = null;
    private final String debugName;
    private final MemberScope[] scopes;

    @SourceDebugExtension({"SMAP\nChainedMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope$Companion\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,91:1\n37#2,2:92\n*S KotlinDebug\n*F\n+ 1 ChainedMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/ChainedMemberScope$Companion\n*L\n87#1:92,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final MemberScope create(String r5, Iterable<? extends MemberScope> r10) {
            Intrinsics.checkNotNullParameter(r5, "debugName");
            Intrinsics.checkNotNullParameter(r10, "scopes");
            SmartList r11 = new SmartList();
            Iterator<? extends MemberScope> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            MemberScope r13 = r12.next();
            if (r13 == MemberScope.Empty.INSTANCE) goto L4;
            if ((r13 instanceof ChainedMemberScope) == true) goto L9;
            r11.add(r13);
            goto L4
        L9:
            CollectionsKt.c(r11, ChainedMemberScope.access$getScopes$p((ChainedMemberScope) r13));
            goto L4
        L12:
            return createOrSingle$descriptors(r5, r11);
        }

        public final MemberScope createOrSingle$descriptors(String r5, List<? extends MemberScope> r10) {
            Intrinsics.checkNotNullParameter(r5, "debugName");
            Intrinsics.checkNotNullParameter(r10, "scopes");
            int r11 = r10.size();
            if (r11 == 0) goto L9;
            if (r11 == 1) goto L11;
            return new ChainedMemberScope(r5, (MemberScope[]) r10.toArray(new MemberScope[0]), null);
        L11:
            return r10.get(0);
        L9:
            return MemberScope.Empty.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ ChainedMemberScope(String r5, MemberScope[] r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static final /* synthetic */ MemberScope[] access$getScopes$p(ChainedMemberScope r5) {
        return r5.scopes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(this.scopes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public ClassifierDescriptor mo1404getContributedClassifier(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "location");
        MemberScope[] r5 = this.scopes;
        int r12 = r5.length;
        ClassifierDescriptor r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L21;
        ClassifierDescriptor r15 = r5[r14].mo1404getContributedClassifier(r10, r11);
        if (r15 == null) goto L13;
        if ((r15 instanceof ClassifierDescriptorWithTypeParameters) == false) goto L14;
        if (((ClassifierDescriptorWithTypeParameters) r15).isExpect() == false) goto L14;
        if (r13 != null) goto L13;
        r13 = r15;
    L14:
        return r15;
    L13:
        r14 = r14 + 1;
        goto L3
    L21:
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        MemberScope[] r11 = this.scopes;
        int r12 = r11.length;
        if (r12 == 0) goto L13;
        int r13 = 0;
        if (r12 == 1) goto L17;
        int r14 = r11.length;
        Collection<DeclarationDescriptor> r15 = null;
    L7:
        if (r13 >= r14) goto L9;
        r15 = ScopeUtilsKt.concat(r15, r11[r13].getContributedDescriptors(r5, r10));
        r13 = r13 + 1;
        goto L7
    L9:
        if (r15 == null) goto L16;
        return r15;
    L16:
        return SetsKt.emptySet();
    L17:
        return r11[0].getContributedDescriptors(r5, r10);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        MemberScope[] r11 = this.scopes;
        int r12 = r11.length;
        if (r12 == 0) goto L13;
        int r13 = 0;
        if (r12 == 1) goto L17;
        int r14 = r11.length;
        Collection<SimpleFunctionDescriptor> r15 = null;
    L7:
        if (r13 >= r14) goto L9;
        r15 = ScopeUtilsKt.concat(r15, r11[r13].getContributedFunctions(r5, r10));
        r13 = r13 + 1;
        goto L7
    L9:
        if (r15 == null) goto L16;
        return r15;
    L16:
        return SetsKt.emptySet();
    L17:
        return r11[0].getContributedFunctions(r5, r10);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        MemberScope[] r11 = this.scopes;
        int r12 = r11.length;
        if (r12 == 0) goto L13;
        int r13 = 0;
        if (r12 == 1) goto L17;
        int r14 = r11.length;
        Collection<PropertyDescriptor> r15 = null;
    L7:
        if (r13 >= r14) goto L9;
        r15 = ScopeUtilsKt.concat(r15, r11[r13].getContributedVariables(r5, r10));
        r13 = r13 + 1;
        goto L7
    L9:
        if (r15 == null) goto L16;
        return r15;
    L16:
        return SetsKt.emptySet();
    L17:
        return r11[0].getContributedVariables(r5, r10);
    L13:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] r5 = this.scopes;
        LinkedHashSet r10 = new LinkedHashSet();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        CollectionsKt.a(r10, r5[r12].getFunctionNames());
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] r5 = this.scopes;
        LinkedHashSet r10 = new LinkedHashSet();
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        CollectionsKt.a(r10, r5[r12].getVariableNames());
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1408recordLookup(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        MemberScope[] r11 = this.scopes;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13].mo1408recordLookup(r5, r10);
        r13 = r13 + 1;
        goto L3
    }

    public String toString() {
        return this.debugName;
    }

    private ChainedMemberScope(String r5, MemberScope[] r10) {
        this.debugName = r5;
        this.scopes = r10;
    }
}
