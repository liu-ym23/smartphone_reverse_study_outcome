package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.crash.tracker.ActivityLifecycle;
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
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    public static final Companion Companion = null;
    private final String debugName;
    private final MemberScope workerScope;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final MemberScope create(String r10, Collection<? extends KotlinType> r11) {
            Intrinsics.checkNotNullParameter(r10, "message");
            Intrinsics.checkNotNullParameter(r11, "types");
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
            Iterator<T> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r12.add(((KotlinType) r13.next()).getMemberScope());
            goto L4
        L6:
            SmartList<MemberScope> r14 = ScopeUtilsKt.listOfNonEmptyScopes(r12);
            MemberScope r15 = ChainedMemberScope.Companion.createOrSingle$descriptors(r10, r14);
            if (r14.size() > 1) goto L10;
            return r15;
        L10:
            return new TypeIntersectionScope(r10, r15, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private TypeIntersectionScope(String r10, MemberScope r11) {
        this.debugName = r10;
        this.workerScope = r11;
    }

    public /* synthetic */ TypeIntersectionScope(String r10, MemberScope r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    @JvmStatic
    public static final MemberScope create(String r10, Collection<? extends KotlinType> r11) {
        return Companion.create(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "kindFilter");
        Intrinsics.checkNotNullParameter(r11, "nameFilter");
        Collection<DeclarationDescriptor> r12 = super.getContributedDescriptors(r10, r11);
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r12.iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        Object r16 = r15.next();
        if ((((DeclarationDescriptor) r16) instanceof CallableDescriptor) == true) goto L7;
        r14.add(r16);
        goto L4
    L7:
        r13.add(r16);
        goto L4
    L9:
        Pair r17 = new Pair(r13, r14);
        List r18 = (List) r17.component1();
        List r19 = (List) r17.component2();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(r18, AnonymousClass2.INSTANCE), r19);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(r10, r11), AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(r10, r11), C04281.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected MemberScope getWorkerScope() {
        return this.workerScope;
    }
}
