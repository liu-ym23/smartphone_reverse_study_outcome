package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypeIntersectionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n3190#2,10:60\n*S KotlinDebug\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope\n*L\n36#1:60,10\n*E\n"})
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    public static final Companion Companion = null;
    private final String debugName;
    private final MemberScope workerScope;

    @SourceDebugExtension({"SMAP\nTypeIntersectionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1549#2:60\n1620#2,3:61\n*S KotlinDebug\n*F\n+ 1 TypeIntersectionScope.kt\norg/jetbrains/kotlin/resolve/scopes/TypeIntersectionScope$Companion\n*L\n50#1:60\n50#1:61,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final MemberScope create(String r5, Collection<? extends KotlinType> r10) {
            Intrinsics.checkNotNullParameter(r5, "message");
            Intrinsics.checkNotNullParameter(r10, "types");
            Collection<? extends KotlinType> r11 = r10;
            ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
            Iterator<T> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r12.add(((KotlinType) r13.next()).getMemberScope());
            goto L4
        L6:
            SmartList<MemberScope> r14 = ScopeUtilsKt.listOfNonEmptyScopes(r12);
            MemberScope r15 = ChainedMemberScope.Companion.createOrSingle$descriptors(r5, r14);
            if (r14.size() > 1) goto L10;
            return r15;
        L10:
            return new TypeIntersectionScope(r5, r15, null);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TypeIntersectionScope(String r5, MemberScope r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    @JvmStatic
    public static final MemberScope create(String r5, Collection<? extends KotlinType> r10) {
        return Companion.create(r5, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "kindFilter");
        Intrinsics.checkNotNullParameter(r10, "nameFilter");
        Collection<DeclarationDescriptor> r11 = super.getContributedDescriptors(r5, r10);
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        Object r15 = r14.next();
        if ((((DeclarationDescriptor) r15) instanceof CallableDescriptor) == true) goto L7;
        r13.add(r15);
        goto L4
    L7:
        r12.add(r15);
        goto L4
    L9:
        Pair r16 = new Pair(r12, r13);
        List r17 = (List) r16.component1();
        List r18 = (List) r16.component2();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(r17, AnonymousClass2.INSTANCE), r18);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(r5, r10), AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r5, LookupLocation r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(r5, r10), C02371.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    public MemberScope getWorkerScope() {
        return this.workerScope;
    }

    private TypeIntersectionScope(String r5, MemberScope r10) {
        this.debugName = r5;
        this.workerScope = r10;
    }
}
