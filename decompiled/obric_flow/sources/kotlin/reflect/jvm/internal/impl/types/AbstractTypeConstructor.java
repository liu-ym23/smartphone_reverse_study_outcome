package kotlin.reflect.jvm.internal.impl.types;

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

    public final class ModuleViewTypeConstructor implements TypeConstructor {
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final Lazy refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(final AbstractTypeConstructor r5, KotlinTypeRefiner r10) {
            Intrinsics.checkNotNullParameter(r10, "kotlinTypeRefiner");
            this.this$0 = r5;
            this.kotlinTypeRefiner = r10;
            this.refinedSupertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(this, r5));
        }

        public static final /* synthetic */ KotlinTypeRefiner access$getKotlinTypeRefiner$p(ModuleViewTypeConstructor r5) {
            return r5.kotlinTypeRefiner;
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        public boolean equals(Object r5) {
            return this.this$0.equals(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            return this.this$0.getBuiltIns();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo1402getDeclarationDescriptor() {
            return this.this$0.mo1402getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.this$0.getParameters();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getSupertypes */
        public /* bridge */ /* synthetic */ Collection mo1403getSupertypes() {
            return mo1403getSupertypes();
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner r5) {
            Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
            return this.this$0.refine(r5);
        }

        public String toString() {
            return this.this$0.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getSupertypes */
        public List<KotlinType> mo1403getSupertypes() {
            return getRefinedSupertypes();
        }
    }

    public static final class Supertypes {
        private final Collection<KotlinType> allSupertypes;
        private List<? extends KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(Collection<? extends KotlinType> r5) {
            Intrinsics.checkNotNullParameter(r5, "allSupertypes");
            this.allSupertypes = r5;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.supertypesWithoutCycles = r5;
        }
    }

    public AbstractTypeConstructor(StorageManager r5) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        this.supertypes = r5.createLazyValueWithPostCompute(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    public static final /* synthetic */ Collection access$computeNeighbours(AbstractTypeConstructor r5, TypeConstructor r10, boolean r11) {
        return r5.computeNeighbours(r10, r11);
    }

    private final Collection<KotlinType> computeNeighbours(TypeConstructor r5, boolean r10) {
        if ((r5 instanceof AbstractTypeConstructor) == false) goto L5;
        AbstractTypeConstructor r11 = (AbstractTypeConstructor) r5;
    L6:
        if (r11 == null) goto L11;
        List r12 = CollectionsKt.plus(r11.supertypes.invoke().getAllSupertypes(), r11.getAdditionalNeighboursInSupertypeGraph(r10));
        if (r12 == null) goto L11;
        return r12;
    L11:
        return r5.mo1403getSupertypes();
    L5:
        r11 = null;
        goto L6
    }

    public abstract Collection<KotlinType> computeSupertypes();

    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean r5) {
        return CollectionsKt.emptyList();
    }

    public boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public /* bridge */ /* synthetic */ Collection mo1403getSupertypes() {
        return mo1403getSupertypes();
    }

    public List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> r5) {
        Intrinsics.checkNotNullParameter(r5, "supertypes");
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner r5) {
        Intrinsics.checkNotNullParameter(r5, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, r5);
    }

    public void reportScopesLoopError(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
    }

    public void reportSupertypeLoopError(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public List<KotlinType> mo1403getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }
}
