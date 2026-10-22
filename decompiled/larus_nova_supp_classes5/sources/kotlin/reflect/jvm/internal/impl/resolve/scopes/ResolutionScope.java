package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ResolutionScope {

    public static final class DefaultImpls {
        public static void recordLookup(ResolutionScope r1, Name r2, LookupLocation r3) {
            Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
            Intrinsics.checkNotNullParameter(r3, "location");
            r1.getContributedFunctions(r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(ResolutionScope r0, DescriptorKindFilter r1, Function1 r2, int r3, Object r4) {
            if (r4 != null) goto L12;
            if ((r3 & 1) == 0) goto L7;
            r1 = DescriptorKindFilter.ALL;
        L7:
            if ((r3 & 2) == 0) goto L10;
            r2 = MemberScope.Companion.getALL_NAME_FILTER();
        L10:
            return r0.getContributedDescriptors(r1, r2);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }
    }

    /* JADX INFO: renamed from: getContributedClassifier */
    ClassifierDescriptor mo383getContributedClassifier(Name r1, LookupLocation r2);

    Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r1, Function1<? super Name, Boolean> r2);

    Collection<? extends FunctionDescriptor> getContributedFunctions(Name r1, LookupLocation r2);

    void recordLookup(Name r1, LookupLocation r2);
}
