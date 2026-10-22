package kotlin.reflect.jvm.internal.impl.types;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    private final NotNullLazyValue<Supertypes> supertypes;

    public static final class Supertypes {
        private final Collection<KotlinType> allSupertypes;
        private List<? extends KotlinType> supertypesWithoutCycles;

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(Collection<? extends KotlinType> r2) {
            Intrinsics.checkNotNullParameter(r2, "allSupertypes");
            this.allSupertypes = r2;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.supertypesWithoutCycles = r2;
        }
    }

    public static /* synthetic */ Supertypes accessor$AbstractTypeConstructor$lambda0(AbstractTypeConstructor r0) {
        return supertypes$lambda$0(r0);
    }

    public static /* synthetic */ Supertypes accessor$AbstractTypeConstructor$lambda1(boolean r0) {
        return supertypes$lambda$1(r0);
    }

    public static /* synthetic */ Unit accessor$AbstractTypeConstructor$lambda2(AbstractTypeConstructor r0, Supertypes r1) {
        return supertypes$lambda$7(r0, r1);
    }

    public static /* synthetic */ Iterable accessor$AbstractTypeConstructor$lambda3(AbstractTypeConstructor r0, TypeConstructor r1) {
        return supertypes$lambda$7$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit accessor$AbstractTypeConstructor$lambda4(AbstractTypeConstructor r0, KotlinType r1) {
        return supertypes$lambda$7$lambda$3(r0, r1);
    }

    public static /* synthetic */ Iterable accessor$AbstractTypeConstructor$lambda5(AbstractTypeConstructor r0, TypeConstructor r1) {
        return supertypes$lambda$7$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit accessor$AbstractTypeConstructor$lambda6(AbstractTypeConstructor r0, KotlinType r1) {
        return supertypes$lambda$7$lambda$6(r0, r1);
    }

    public abstract Collection<KotlinType> computeSupertypes();

    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    public List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> r2) {
        Intrinsics.checkNotNullParameter(r2, "supertypes");
        return r2;
    }

    public void reportScopesLoopError(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
    }

    public void reportSupertypeLoopError(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<KotlinType> getSupertypes() {
        return ((Supertypes) this.supertypes.invoke()).getSupertypesWithoutCycles();
    }

    public boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public /* bridge */ /* synthetic */ Collection getSupertypes() {
        return getSupertypes();
    }

    public AbstractTypeConstructor(StorageManager r4) {
        Intrinsics.checkNotNullParameter(r4, "storageManager");
        this.supertypes = r4.createLazyValueWithPostCompute(new AbstractTypeConstructor$$Lambda$0(this), AbstractTypeConstructor$$Lambda$1.INSTANCE, new AbstractTypeConstructor$$Lambda$2(this));
    }

    private static final Supertypes supertypes$lambda$0(AbstractTypeConstructor r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return new Supertypes(r1.computeSupertypes());
    }

    private static final Supertypes supertypes$lambda$1(boolean r1) {
        return new Supertypes(CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes()));
    }

    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean r1) {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner r2) {
        Intrinsics.checkNotNullParameter(r2, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, r2);
    }

    private final Collection<KotlinType> computeNeighbours(TypeConstructor r3, boolean r4) {
        if ((r3 instanceof AbstractTypeConstructor) == false) goto L5;
        AbstractTypeConstructor r0 = (AbstractTypeConstructor) r3;
    L6:
        if (r0 == null) goto L11;
        List r5 = CollectionsKt.plus(((Supertypes) r0.supertypes.invoke()).getAllSupertypes(), r0.getAdditionalNeighboursInSupertypeGraph(r4));
        if (r5 == null) goto L11;
        return r5;
    L11:
        return r3.getSupertypes();
    L5:
        r0 = null;
        goto L6
    }

    private static final Unit supertypes$lambda$7(final AbstractTypeConstructor r5, Supertypes r6) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "supertypes");
        List r0 = r5.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(r5, r6.getAllSupertypes(), new AbstractTypeConstructor$$Lambda$3(r5), new AbstractTypeConstructor$$Lambda$4(r5));
        List<KotlinType> r2 = null;
        if (r0.isEmpty() == false) goto L12;
        KotlinType r1 = r5.defaultSupertypeIfEmpty();
        if (r1 == null) goto L7;
        List r3 = CollectionsKt.listOf(r1);
    L8:
        if (r3 != null) goto L10;
        r3 = CollectionsKt.emptyList();
    L10:
        r0 = r3;
        goto L12
    L7:
        r3 = null;
    L12:
        if (r5.getShouldReportCyclicScopeWithCompanionWarning() == false) goto L15;
        r5.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(r5, r0, new AbstractTypeConstructor$.Lambda.5(r5), new AbstractTypeConstructor$.Lambda.6(r5));
    L15:
        if ((r0 instanceof List) == false) goto L17;
        r2 = (List) r0;
    L17:
        if (r2 != null) goto L19;
        r2 = CollectionsKt.toList(r0);
    L19:
        r6.setSupertypesWithoutCycles(r5.processSupertypesWithoutCycles(r2));
        return Unit.INSTANCE;
    }

    private static final Iterable supertypes$lambda$7$lambda$2(AbstractTypeConstructor r1, TypeConstructor r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1.computeNeighbours(r2, false);
    }

    private static final Unit supertypes$lambda$7$lambda$3(AbstractTypeConstructor r1, KotlinType r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.reportSupertypeLoopError(r2);
        return Unit.INSTANCE;
    }

    private static final Iterable supertypes$lambda$7$lambda$5(AbstractTypeConstructor r1, TypeConstructor r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1.computeNeighbours(r2, true);
    }

    private static final Unit supertypes$lambda$7$lambda$6(AbstractTypeConstructor r1, KotlinType r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.reportScopesLoopError(r2);
        return Unit.INSTANCE;
    }
}
