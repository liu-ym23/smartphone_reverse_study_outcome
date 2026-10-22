package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public interface MemberScope extends ResolutionScope {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Function1<Name, Boolean> ALL_NAME_FILTER = null;

        static {
            $$INSTANCE = new Companion();
            ALL_NAME_FILTER = MemberScope$Companion$ALL_NAME_FILTER$1.INSTANCE;
        }

        private Companion() {
        }

        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return ALL_NAME_FILTER;
        }
    }

    public static final class DefaultImpls {
        public static void recordLookup(MemberScope r10, Name r11, LookupLocation r12) {
            Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r12, "location");
            ResolutionScope.DefaultImpls.recordLookup(r10, r11, r12);
        }
    }

    public static final class Empty extends MemberScopeImpl {
        public static final Empty INSTANCE = null;

        static {
            INSTANCE = new Empty();
        }

        private Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getClassifierNames() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getFunctionNames() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getVariableNames() {
            return SetsKt.emptySet();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Set<Name> getClassifierNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11);

    Collection<? extends PropertyDescriptor> getContributedVariables(Name r10, LookupLocation r11);

    Set<Name> getFunctionNames();

    Set<Name> getVariableNames();
}
