package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public interface ResolutionScope {

    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(ResolutionScope r10, DescriptorKindFilter r11, Function1 r12, int r13, Object r14) {
            if (r14 != null) goto L12;
            if ((r13 & 1) == 0) goto L7;
            r11 = DescriptorKindFilter.ALL;
        L7:
            if ((r13 & 2) == 0) goto L10;
            r12 = MemberScope.Companion.getALL_NAME_FILTER();
        L10:
            return r10.getContributedDescriptors(r11, r12);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void recordLookup(ResolutionScope r10, Name r11, LookupLocation r12) {
            Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r12, "location");
            r10.getContributedFunctions(r11, r12);
        }
    }

    /* JADX INFO: renamed from: getContributedClassifier */
    ClassifierDescriptor mo1325getContributedClassifier(Name r10, LookupLocation r11);

    Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r10, Function1<? super Name, Boolean> r11);

    Collection<? extends FunctionDescriptor> getContributedFunctions(Name r10, LookupLocation r11);

    /* JADX INFO: renamed from: recordLookup */
    void mo1329recordLookup(Name r10, LookupLocation r11);
}
