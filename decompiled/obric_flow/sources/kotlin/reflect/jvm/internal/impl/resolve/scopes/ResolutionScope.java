package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public interface ResolutionScope {

    @SourceDebugExtension({"SMAP\nResolutionScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResolutionScope.kt\norg/jetbrains/kotlin/resolve/scopes/ResolutionScope$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(ResolutionScope r5, DescriptorKindFilter r10, Function1 r11, int r12, Object r13) {
            if (r13 != null) goto L12;
            if ((r12 & 1) == 0) goto L7;
            r10 = DescriptorKindFilter.ALL;
        L7:
            if ((r12 & 2) == 0) goto L10;
            r11 = MemberScope.Companion.getALL_NAME_FILTER();
        L10:
            return r5.getContributedDescriptors(r10, r11);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void recordLookup(ResolutionScope r5, Name r10, LookupLocation r11) {
            Intrinsics.checkNotNullParameter(r10, "name");
            Intrinsics.checkNotNullParameter(r11, "location");
            r5.getContributedFunctions(r10, r11);
        }
    }

    /* JADX INFO: renamed from: getContributedClassifier */
    ClassifierDescriptor mo1404getContributedClassifier(Name r5, LookupLocation r10);

    Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r5, Function1<? super Name, Boolean> r10);

    Collection<? extends FunctionDescriptor> getContributedFunctions(Name r5, LookupLocation r10);

    /* JADX INFO: renamed from: recordLookup */
    void mo1408recordLookup(Name r5, LookupLocation r10);
}
