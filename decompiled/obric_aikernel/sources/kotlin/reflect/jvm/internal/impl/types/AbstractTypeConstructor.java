package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    private final NotNullLazyValue<Supertypes> supertypes;

    private final class ModuleViewTypeConstructor implements TypeConstructor {
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final Lazy refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(final AbstractTypeConstructor r10, KotlinTypeRefiner r11) {
            Intrinsics.checkNotNullParameter(r11, "kotlinTypeRefiner");
            this.this$0 = r10;
            this.kotlinTypeRefiner = r11;
            this.refinedSupertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(this, r10));
        }

        public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefiner$p(ModuleViewTypeConstructor r10) {
            return r10.kotlinTypeRefiner;
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        public boolean equals(Object r10) {
            return this.this$0.equals(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns r10 = this.this$0.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(r10, "this@AbstractTypeConstructor.builtIns");
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo1323getDeclarationDescriptor() {
            return this.this$0.mo1323getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> r10 = this.this$0.getParameters();
            Intrinsics.checkNotNullExpressionValue(r10, "this@AbstractTypeConstructor.parameters");
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getSupertypes */
        public /* bridge */ /* synthetic */ Collection mo1324getSupertypes() {
            return mo1324getSupertypes();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getSupertypes */
        public List<KotlinType> mo1324getSupertypes() {
            return getRefinedSupertypes();
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner r10) {
            Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
            return this.this$0.refine(r10);
        }

        public String toString() {
            return this.this$0.toString();
        }
    }

    private static final class Supertypes {
        private final Collection<KotlinType> allSupertypes;
        private List<? extends KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(Collection<? extends KotlinType> r10) {
            Intrinsics.checkNotNullParameter(r10, "allSupertypes");
            this.allSupertypes = r10;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.supertypesWithoutCycles = r10;
        }
    }

    public AbstractTypeConstructor(StorageManager r10) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        this.supertypes = r10.createLazyValueWithPostCompute(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    public static final /* synthetic */ Collection access$computeNeighbours(AbstractTypeConstructor r10, TypeConstructor r11, boolean r12) {
        return r10.computeNeighbours(r11, r12);
    }

    private final Collection<KotlinType> computeNeighbours(TypeConstructor r10, boolean r11) {
        if ((r10 instanceof AbstractTypeConstructor) == false) goto L5;
        AbstractTypeConstructor r12 = (AbstractTypeConstructor) r10;
    L6:
        if (r12 == null) goto L10;
        List r13 = CollectionsKt.plus(r12.supertypes.invoke().getAllSupertypes(), r12.getAdditionalNeighboursInSupertypeGraph(r11));
        if (r13 == null) goto L10;
        return r13;
    L10:
        Collection<KotlinType> r14 = r10.mo1324getSupertypes();
        Intrinsics.checkNotNullExpressionValue(r14, "supertypes");
        return r14;
    L5:
        r12 = null;
        goto L6
    }

    protected abstract Collection<KotlinType> computeSupertypes();

    protected KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean r10) {
        return CollectionsKt.emptyList();
    }

    protected boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    protected abstract SupertypeLoopChecker getSupertypeLoopChecker();

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public /* bridge */ /* synthetic */ Collection mo1324getSupertypes() {
        return mo1324getSupertypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public List<KotlinType> mo1324getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }

    protected List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> r10) {
        Intrinsics.checkNotNullParameter(r10, "supertypes");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner r10) {
        Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, r10);
    }

    protected void reportScopesLoopError(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
    }

    protected void reportSupertypeLoopError(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
    }
}
