package androidx.fragment.app;

import ai.j0;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u0000 *2\u00020\u0001:\u0003*+,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J#\u0010\u001a\u001a\u00020\u000f2\u0011\u0010\u001b\u001a\r\u0012\t\u0012\u00070\f¢\u0006\u0002\b\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\bH&J\u0006\u0010\u001f\u001a\u00020\u000fJ\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010$\u001a\u00020\u000fJ\u0006\u0010%\u001a\u00020\u000fJ\u0010\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u000fJ\b\u0010(\u001a\u00020\u000fH\u0002J\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController;", "", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "getContainer", "()Landroid/view/ViewGroup;", "isContainerPostponed", "", "operationDirectionIsPop", "pendingOperations", "", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "runningOperations", "enqueue", "", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragmentStateManager", "Landroidx/fragment/app/FragmentStateManager;", "enqueueAdd", "enqueueHide", "enqueueRemove", "enqueueShow", "executeOperations", "operations", "", "Lkotlin/jvm/JvmSuppressWildcards;", "isPop", "executePendingOperations", "findPendingOperation", "fragment", "Landroidx/fragment/app/Fragment;", "findRunningOperation", "forceCompleteAllOperations", "forcePostponedExecutePendingOperations", "getAwaitingCompletionLifecycleImpact", "markPostponedState", "updateFinalState", "updateOperationDirection", "Companion", "FragmentStateManagerOperation", "Operation", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,710:1\n288#2,2:711\n288#2,2:713\n533#2,6:715\n*S KotlinDebug\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController\n*L\n69#1:711,2\n75#1:713,2\n166#1:715,6\n*E\n"})
public abstract class SpecialEffectsController {
    public static final Companion Companion = null;
    private final ViewGroup container;
    private boolean isContainerPostponed;
    private boolean operationDirectionIsPop;
    private final List<Operation> pendingOperations;
    private final List<Operation> runningOperations;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Companion;", "", "()V", "getOrCreateController", "Landroidx/fragment/app/SpecialEffectsController;", "container", "Landroid/view/ViewGroup;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "factory", "Landroidx/fragment/app/SpecialEffectsControllerFactory;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final SpecialEffectsController getOrCreateController(ViewGroup r5, FragmentManager r10) {
            Intrinsics.checkNotNullParameter(r5, "container");
            Intrinsics.checkNotNullParameter(r10, "fragmentManager");
            return getOrCreateController(r5, r10.getSpecialEffectsControllerFactory());
        }

        private Companion() {
        }

        @JvmStatic
        public final SpecialEffectsController getOrCreateController(ViewGroup r5, SpecialEffectsControllerFactory r10) {
            Intrinsics.checkNotNullParameter(r5, "container");
            Intrinsics.checkNotNullParameter(r10, "factory");
            Object r11 = r5.getTag(R.id.special_effects_controller_view_tag);
            if ((r11 instanceof SpecialEffectsController) == true) goto L5;
            SpecialEffectsController r12 = r10.createController(r5);
            r5.setTag(R.id.special_effects_controller_view_tag, r12);
            return r12;
        L5:
            return (SpecialEffectsController) r11;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;", "Landroidx/fragment/app/SpecialEffectsController$Operation;", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragmentStateManager", "Landroidx/fragment/app/FragmentStateManager;", "cancellationSignal", "Landroidx/core/os/CancellationSignal;", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/FragmentStateManager;Landroidx/core/os/CancellationSignal;)V", "complete", "", "onStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FragmentStateManagerOperation extends Operation {
        private final FragmentStateManager fragmentStateManager;

        public FragmentStateManagerOperation(Operation.State r5, Operation.LifecycleImpact r10, FragmentStateManager r11, CancellationSignal r12) {
            Intrinsics.checkNotNullParameter(r5, "finalState");
            Intrinsics.checkNotNullParameter(r10, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(r11, "fragmentStateManager");
            Intrinsics.checkNotNullParameter(r12, "cancellationSignal");
            super(r5, r10, r11.getFragment(), r12);
            this.fragmentStateManager = r11;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.fragmentStateManager.moveToExpectedState();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void onStart() {
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L19;
            Fragment r5 = this.fragmentStateManager.getFragment();
            View r10 = r5.mView.findFocus();
            if (r10 == null) goto L9;
            r5.setFocusedView(r10);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L9;
            Log.v(FragmentManager.TAG, "requestFocus: Saved focused view " + r10 + " for Fragment " + r5);
        L9:
            View r11 = getFragment().requireView();
            if (r11.getParent() != null) goto L13;
            this.fragmentStateManager.addViewToContainer();
            r11.setAlpha(0.0f);
        L13:
            if (r11.getAlpha() == 0.0f) goto L15;
        L17:
            r11.setAlpha(r5.getPostOnViewCreatedAlpha());
            return;
        L15:
            if (r11.getVisibility() != 0) goto L17;
            r11.setVisibility(4);
            goto L17
        L19:
            if (getLifecycleImpact() != Operation.LifecycleImpact.REMOVING) goto L26;
            Fragment r12 = this.fragmentStateManager.getFragment();
            View r13 = r12.requireView();
            if (FragmentManager.isLoggingEnabled(2) == false) goto L23;
            Log.v(FragmentManager.TAG, "Clearing focus " + r13.findFocus() + " on view " + r13 + " for Fragment " + r12);
        L23:
            r13.clearFocus();
            return;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001:\u0002+,B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020 J\b\u0010#\u001a\u00020 H\u0017J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\tJ\u0016\u0010'\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010(\u001a\u00020 H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation;", "", "finalState", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "lifecycleImpact", "Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "fragment", "Landroidx/fragment/app/Fragment;", "cancellationSignal", "Landroidx/core/os/CancellationSignal;", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;Landroidx/fragment/app/Fragment;Landroidx/core/os/CancellationSignal;)V", "completionListeners", "", "Ljava/lang/Runnable;", "getFinalState", "()Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "setFinalState", "(Landroidx/fragment/app/SpecialEffectsController$Operation$State;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "<set-?>", "", "isCanceled", "()Z", "isComplete", "getLifecycleImpact", "()Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "setLifecycleImpact", "(Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;)V", "specialEffectsSignals", "", "addCompletionListener", "", "listener", "cancel", "complete", "completeSpecialEffect", "signal", "markStartedSpecialEffect", "mergeWith", "onStart", "toString", "", "LifecycleImpact", "State", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSpecialEffectsController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController$Operation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,710:1\n1855#2,2:711\n*S KotlinDebug\n*F\n+ 1 SpecialEffectsController.kt\nandroidx/fragment/app/SpecialEffectsController$Operation\n*L\n607#1:711,2\n*E\n"})
    public static class Operation {
        private final List<Runnable> completionListeners;
        private State finalState;
        private final Fragment fragment;
        private boolean isCanceled;
        private boolean isComplete;
        private LifecycleImpact lifecycleImpact;
        private final Set<CancellationSignal> specialEffectsSignals;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$LifecycleImpact;", "", "(Ljava/lang/String;I)V", "NONE", "ADDING", "REMOVING", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final enum LifecycleImpact extends Enum<LifecycleImpact> {
            private static final /* synthetic */ LifecycleImpact[] $VALUES = null;
            public static final LifecycleImpact ADDING = null;
            public static final LifecycleImpact NONE = null;
            public static final LifecycleImpact REMOVING = null;

            private static final /* synthetic */ LifecycleImpact[] $values() {
                return new LifecycleImpact[]{NONE, ADDING, REMOVING};
            }

            static {
                NONE = new LifecycleImpact("NONE", 0);
                ADDING = new LifecycleImpact("ADDING", 1);
                REMOVING = new LifecycleImpact("REMOVING", 2);
                $VALUES = $values();
            }

            private LifecycleImpact(String r5, int r10) {
                super(r5, r10);
            }

            public static LifecycleImpact valueOf(String r5) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, r5);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) $VALUES.clone();
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "", "(Ljava/lang/String;I)V", "applyState", "", "view", "Landroid/view/View;", "REMOVED", "VISIBLE", "GONE", "INVISIBLE", "Companion", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final enum State extends Enum<State> {
            private static final /* synthetic */ State[] $VALUES = null;
            public static final Companion Companion = null;
            public static final State GONE = null;
            public static final State INVISIBLE = null;
            public static final State REMOVED = null;
            public static final State VISIBLE = null;

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\n\u0010\u0007\u001a\u00020\u0004*\u00020\b¨\u0006\t"}, d2 = {"Landroidx/fragment/app/SpecialEffectsController$Operation$State$Companion;", "", "()V", "from", "Landroidx/fragment/app/SpecialEffectsController$Operation$State;", "visibility", "", "asOperationState", "Landroid/view/View;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                    this();
                }

                public final State asOperationState(View r5) {
                    Intrinsics.checkNotNullParameter(r5, "<this>");
                    if (r5.getAlpha() != 0.0f) goto L8;
                    if (r5.getVisibility() != 0) goto L8;
                    return State.INVISIBLE;
                L8:
                    return from(r5.getVisibility());
                }

                @JvmStatic
                public final State from(int r5) {
                    if (r5 == 0) goto L12;
                    if (r5 == 4) goto L14;
                    if (r5 != 8) goto L9;
                    return State.GONE;
                L9:
                    throw new IllegalArgumentException(j0.g(r5, "Unknown visibility "));
                L14:
                    return State.INVISIBLE;
                L12:
                    return State.VISIBLE;
                }

                private Companion() {
                }
            }

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] r5 = new int[State.values().length];
                    r5[State.REMOVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r5[State.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r5[State.GONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r5[State.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    $EnumSwitchMapping$0 = r5;
                }
            }

            private static final /* synthetic */ State[] $values() {
                return new State[]{REMOVED, VISIBLE, GONE, INVISIBLE};
            }

            static {
                REMOVED = new State("REMOVED", 0);
                VISIBLE = new State("VISIBLE", 1);
                GONE = new State("GONE", 2);
                INVISIBLE = new State("INVISIBLE", 3);
                $VALUES = $values();
                Companion = new Companion(null);
            }

            private State(String r5, int r10) {
                super(r5, r10);
            }

            @JvmStatic
            public static final State from(int r5) {
                return Companion.from(r5);
            }

            public static State valueOf(String r5) {
                return (State) Enum.valueOf(State.class, r5);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }

            public final void applyState(View r5) {
                Intrinsics.checkNotNullParameter(r5, "view");
                int r10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
                if (r10 != 1) goto L5;
                ViewParent r11 = r5.getParent();
                if ((r11 instanceof ViewGroup) == false) goto L26;
                ViewGroup r12 = (ViewGroup) r11;
            L27:
                if (r12 != null) goto L29;
                return;
            L29:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L31;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Removing view " + r5 + " from container " + r12);
            L31:
                r12.removeView(r5);
                return;
            L26:
                r12 = null;
                goto L27
            L5:
                if (r10 == 2) goto L20;
                if (r10 == 3) goto L16;
                if (r10 == 4) goto L12;
                return;
            L12:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + r5 + " to INVISIBLE");
            L14:
                r5.setVisibility(4);
                return;
            L16:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + r5 + " to GONE");
            L18:
                r5.setVisibility(8);
                return;
            L20:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L22;
                Log.v(FragmentManager.TAG, "SpecialEffectsController: Setting view " + r5 + " to VISIBLE");
            L22:
                r5.setVisibility(0);
            }
        }

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[LifecycleImpact.values().length];
                r5[LifecycleImpact.ADDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r5[LifecycleImpact.REMOVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r5[LifecycleImpact.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public Operation(State r5, LifecycleImpact r10, Fragment r11, CancellationSignal r12) {
            Intrinsics.checkNotNullParameter(r5, "finalState");
            Intrinsics.checkNotNullParameter(r10, "lifecycleImpact");
            Intrinsics.checkNotNullParameter(r11, "fragment");
            Intrinsics.checkNotNullParameter(r12, "cancellationSignal");
            this.finalState = r5;
            this.lifecycleImpact = r10;
            this.fragment = r11;
            this.completionListeners = new ArrayList();
            this.specialEffectsSignals = new LinkedHashSet();
            r12.setOnCancelListener(new androidx.core.view.inputmethod.a(this, 2));
        }

        private static final void _init_$lambda$0(Operation r5) {
            Intrinsics.checkNotNullParameter(r5, "this$0");
            r5.cancel();
        }

        public static /* synthetic */ void a(Operation r5) {
            _init_$lambda$0(r5);
        }

        public final void addCompletionListener(Runnable r5) {
            Intrinsics.checkNotNullParameter(r5, "listener");
            this.completionListeners.add(r5);
        }

        public final void cancel() {
            if (this.isCanceled == false) goto L5;
            return;
        L5:
            this.isCanceled = true;
            if (this.specialEffectsSignals.isEmpty() == false) goto L8;
            complete();
            return;
        L8:
            Iterator r5 = CollectionsKt.toMutableSet(this.specialEffectsSignals).iterator();
        L10:
            if (r5.hasNext() == false) goto L14;
            ((CancellationSignal) r5.next()).cancel();
            goto L10
        }

        @CallSuper
        public void complete() {
            if (this.isComplete == false) goto L6;
            return;
        L6:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: " + this + " has called complete.");
        L8:
            this.isComplete = true;
            Iterator<T> r5 = this.completionListeners.iterator();
        L10:
            if (r5.hasNext() == false) goto L12;
            ((Runnable) r5.next()).run();
            goto L10
        }

        public final void completeSpecialEffect(CancellationSignal r5) {
            Intrinsics.checkNotNullParameter(r5, "signal");
            if (this.specialEffectsSignals.remove(r5) == true) goto L5;
            return;
        L5:
            if (this.specialEffectsSignals.isEmpty() == false) goto L9;
            complete();
            return;
        }

        public final State getFinalState() {
            return this.finalState;
        }

        public final Fragment getFragment() {
            return this.fragment;
        }

        public final LifecycleImpact getLifecycleImpact() {
            return this.lifecycleImpact;
        }

        public final boolean isCanceled() {
            return this.isCanceled;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        public final void markStartedSpecialEffect(CancellationSignal r5) {
            Intrinsics.checkNotNullParameter(r5, "signal");
            onStart();
            this.specialEffectsSignals.add(r5);
        }

        public final void mergeWith(State r10, LifecycleImpact r11) {
            Intrinsics.checkNotNullParameter(r10, "finalState");
            Intrinsics.checkNotNullParameter(r11, "lifecycleImpact");
            int r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
            if (r12 == 1) goto L20;
            if (r12 == 2) goto L16;
            if (r12 == 3) goto L10;
            return;
        L10:
            if (this.finalState != State.REMOVED) goto L12;
            return;
        L12:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> " + r10 + '.');
        L14:
            this.finalState = r10;
            return;
        L16:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = " + this.finalState + " -> REMOVED. mLifecycleImpact  = " + this.lifecycleImpact + " to REMOVING.");
        L18:
            this.finalState = State.REMOVED;
            this.lifecycleImpact = LifecycleImpact.REMOVING;
            return;
        L20:
            if (this.finalState == State.REMOVED) goto L22;
            return;
        L22:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L24;
            Log.v(FragmentManager.TAG, "SpecialEffectsController: For fragment " + this.fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.lifecycleImpact + " to ADDING.");
        L24:
            this.finalState = State.VISIBLE;
            this.lifecycleImpact = LifecycleImpact.ADDING;
        }

        public void onStart() {
        }

        public final void setFinalState(State r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.finalState = r5;
        }

        public final void setLifecycleImpact(LifecycleImpact r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.lifecycleImpact = r5;
        }

        public String toString() {
            StringBuilder r5 = j0.x("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
            r5.append(this.finalState);
            r5.append(" lifecycleImpact = ");
            r5.append(this.lifecycleImpact);
            r5.append(" fragment = ");
            r5.append(this.fragment);
            r5.append('}');
            return r5.toString();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Operation.LifecycleImpact.values().length];
            r5[Operation.LifecycleImpact.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SpecialEffectsController(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        this.container = r5;
        this.pendingOperations = new ArrayList();
        this.runningOperations = new ArrayList();
    }

    public static /* synthetic */ void a(SpecialEffectsController r5, FragmentStateManagerOperation r10) {
        enqueue$lambda$4$lambda$2(r5, r10);
    }

    public static /* synthetic */ void b(SpecialEffectsController r5, FragmentStateManagerOperation r10) {
        enqueue$lambda$4$lambda$3(r5, r10);
    }

    private final void enqueue(Operation.State r5, Operation.LifecycleImpact r10, FragmentStateManager r11) {
        List<Operation> r12 = this.pendingOperations;
        monitor-enter(r12);
        CancellationSignal r13 = new CancellationSignal();     // Catch: Throwable -> L9
        Operation r14 = findPendingOperation(r11.getFragment());     // Catch: Throwable -> L9
        if (r14 == null) goto L11;
        r14.mergeWith(r5, r10);     // Catch: Throwable -> L9
        monitor-exit(r12);
        return;
    L11:
        FragmentStateManagerOperation r15 = new FragmentStateManagerOperation(r5, r10, r11, r13);     // Catch: Throwable -> L9
        this.pendingOperations.add(r15);     // Catch: Throwable -> L9
        r15.addCompletionListener(new j(this, r15, 0));     // Catch: Throwable -> L9
        r15.addCompletionListener(new j(this, r15, 1));     // Catch: Throwable -> L9
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r12);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static final void enqueue$lambda$4$lambda$2(SpecialEffectsController r5, FragmentStateManagerOperation r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$operation");
        if (r5.pendingOperations.contains(r10) == false) goto L6;
        r10.getFinalState().applyState(r10.getFragment().mView);
        return;
    }

    private static final void enqueue$lambda$4$lambda$3(SpecialEffectsController r5, FragmentStateManagerOperation r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$operation");
        r5.pendingOperations.remove(r10);
        r5.runningOperations.remove(r10);
    }

    private final Operation findPendingOperation(Fragment r5) {
        Iterator<T> r10 = this.pendingOperations.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Object r11 = r10.next();
        Operation r12 = (Operation) r11;
        if (Intrinsics.areEqual(r12.getFragment(), r5) == false) goto L4;
        if (r12.isCanceled() == true) goto L4;
    L12:
        return (Operation) r11;
    L10:
        r11 = null;
        goto L12
    }

    private final Operation findRunningOperation(Fragment r5) {
        Iterator<T> r10 = this.runningOperations.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Object r11 = r10.next();
        Operation r12 = (Operation) r11;
        if (Intrinsics.areEqual(r12.getFragment(), r5) == false) goto L4;
        if (r12.isCanceled() == true) goto L4;
    L12:
        return (Operation) r11;
    L10:
        r11 = null;
        goto L12
    }

    @JvmStatic
    public static final SpecialEffectsController getOrCreateController(ViewGroup r5, FragmentManager r10) {
        return Companion.getOrCreateController(r5, r10);
    }

    private final void updateFinalState() {
        Iterator<Operation> r5 = this.pendingOperations.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Operation r10 = r5.next();
        if (r10.getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L4;
        View r11 = r10.getFragment().requireView();
        r10.mergeWith(Operation.State.Companion.from(r11.getVisibility()), Operation.LifecycleImpact.NONE);
        goto L4
    }

    public final void enqueueAdd(Operation.State r5, FragmentStateManager r10) {
        Intrinsics.checkNotNullParameter(r5, "finalState");
        Intrinsics.checkNotNullParameter(r10, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing add operation for fragment " + r10.getFragment());
    L5:
        enqueue(r5, Operation.LifecycleImpact.ADDING, r10);
    }

    public final void enqueueHide(FragmentStateManager r5) {
        Intrinsics.checkNotNullParameter(r5, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing hide operation for fragment " + r5.getFragment());
    L5:
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, r5);
    }

    public final void enqueueRemove(FragmentStateManager r5) {
        Intrinsics.checkNotNullParameter(r5, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing remove operation for fragment " + r5.getFragment());
    L5:
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, r5);
    }

    public final void enqueueShow(FragmentStateManager r5) {
        Intrinsics.checkNotNullParameter(r5, "fragmentStateManager");
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Enqueuing show operation for fragment " + r5.getFragment());
    L5:
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, r5);
    }

    public abstract void executeOperations(List<Operation> r5, boolean r10);

    public final void executePendingOperations() {
        if (this.isContainerPostponed == false) goto L6;
        return;
    L6:
        if (ViewCompat.isAttachedToWindow(this.container) == true) goto L9;
        forceCompleteAllOperations();
        this.operationDirectionIsPop = false;
        return;
    L9:
        List<Operation> r5 = this.pendingOperations;
        monitor-enter(r5);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (this.pendingOperations.isEmpty() == true) goto L34;
        List r10 = CollectionsKt.toMutableList(this.runningOperations);     // Catch: Throwable -> L19
        this.runningOperations.clear();     // Catch: Throwable -> L19
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L19
    L15:
        if (r11.hasNext() == false) goto L24;
        Operation r12 = (Operation) r11.next();     // Catch: Throwable -> L19
        if (FragmentManager.isLoggingEnabled(2) == false) goto L21;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Cancelling operation " + r12);     // Catch: Throwable -> L19
    L21:
        r12.cancel();     // Catch: Throwable -> L19
        if (r12.isComplete() == true) goto L15;
        this.runningOperations.add(r12);     // Catch: Throwable -> L19
        goto L15
    L24:
        updateFinalState();     // Catch: Throwable -> L19
        List<Operation> r13 = CollectionsKt.toMutableList(this.pendingOperations);     // Catch: Throwable -> L19
        this.pendingOperations.clear();     // Catch: Throwable -> L19
        this.runningOperations.addAll(r13);     // Catch: Throwable -> L19
        if (FragmentManager.isLoggingEnabled(2) == false) goto L27;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Executing pending operations");     // Catch: Throwable -> L19
    L27:
        Iterator<Operation> r14 = r13.iterator();     // Catch: Throwable -> L19
    L29:
        if (r14.hasNext() == false) goto L31;
        r14.next().onStart();     // Catch: Throwable -> L19
        goto L29
    L31:
        executeOperations(r13, this.operationDirectionIsPop);     // Catch: Throwable -> L19
        this.operationDirectionIsPop = false;     // Catch: Throwable -> L19
        if (FragmentManager.isLoggingEnabled(2) == false) goto L34;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Finished executing pending operations");     // Catch: Throwable -> L19
    L34:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r5);
    }

    public final void forceCompleteAllOperations() {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing all operations to complete");
    L5:
        boolean r5 = ViewCompat.isAttachedToWindow(this.container);
        List<Operation> r10 = this.pendingOperations;
        monitor-enter(r10);
        updateFinalState();     // Catch: Throwable -> L11
        Iterator<Operation> r11 = this.pendingOperations.iterator();     // Catch: Throwable -> L11
    L9:
        if (r11.hasNext() == false) goto L13;
        r11.next().onStart();     // Catch: Throwable -> L11
        goto L9
    L13:
        Iterator r12 = CollectionsKt.toMutableList(this.runningOperations).iterator();     // Catch: Throwable -> L11
    L15:
        if (r12.hasNext() == false) goto L23;
        Operation r13 = (Operation) r12.next();     // Catch: Throwable -> L11
        if (FragmentManager.isLoggingEnabled(2) == false) goto L22;
        if (r5 == false) goto L20;
        String r14 = "";
    L21:
        Log.v(FragmentManager.TAG, "SpecialEffectsController: " + r14 + "Cancelling running operation " + r13);     // Catch: Throwable -> L11
        goto L22
    L20:
        r14 = "Container " + this.container + " is not attached to window. ";     // Catch: Throwable -> L11
    L22:
        r13.cancel();     // Catch: Throwable -> L11
        goto L15
    L23:
        Iterator r15 = CollectionsKt.toMutableList(this.pendingOperations).iterator();     // Catch: Throwable -> L11
    L25:
        if (r15.hasNext() == false) goto L33;
        Operation r16 = (Operation) r15.next();     // Catch: Throwable -> L11
        if (FragmentManager.isLoggingEnabled(2) == false) goto L32;
        if (r5 == false) goto L30;
        String r17 = "";
    L31:
        Log.v(FragmentManager.TAG, "SpecialEffectsController: " + r17 + "Cancelling pending operation " + r16);     // Catch: Throwable -> L11
        goto L32
    L30:
        r17 = "Container " + this.container + " is not attached to window. ";     // Catch: Throwable -> L11
    L32:
        r16.cancel();     // Catch: Throwable -> L11
        goto L25
    L33:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r10);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void forcePostponedExecutePendingOperations() {
        if (this.isContainerPostponed == true) goto L5;
        return;
    L5:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        Log.v(FragmentManager.TAG, "SpecialEffectsController: Forcing postponed operations");
    L7:
        this.isContainerPostponed = false;
        executePendingOperations();
    }

    public final Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(FragmentStateManager r5) {
        Intrinsics.checkNotNullParameter(r5, "fragmentStateManager");
        Fragment r10 = r5.getFragment();
        Operation r11 = findPendingOperation(r10);
        Operation.LifecycleImpact r12 = null;
        if (r11 == null) goto L5;
        Operation.LifecycleImpact r13 = r11.getLifecycleImpact();
    L6:
        Operation r14 = findRunningOperation(r10);
        if (r14 == null) goto L10;
        r12 = r14.getLifecycleImpact();
    L10:
        if (r13 != null) goto L12;
        int r15 = -1;
    L13:
        if (r15 == (-1)) goto L18;
        if (r15 == 1) goto L18;
        return r13;
    L18:
        return r12;
    L12:
        r15 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    public final ViewGroup getContainer() {
        return this.container;
    }

    public final void markPostponedState() {
        List<Operation> r5 = this.pendingOperations;
        monitor-enter(r5);
        updateFinalState();     // Catch: Throwable -> L11
        List<Operation> r10 = this.pendingOperations;     // Catch: Throwable -> L11
        ListIterator<Operation> r11 = r10.listIterator(r10.size());     // Catch: Throwable -> L11
    L5:
        Fragment r12 = null;
        if (r11.hasPrevious() == false) goto L13;
        Operation r13 = r11.previous();     // Catch: Throwable -> L11
        Operation r14 = r13;     // Catch: Throwable -> L11
        Operation.State r15 = Operation.State.Companion.asOperationState(r14.getFragment().mView);     // Catch: Throwable -> L11
        Operation.State r16 = r14.getFinalState();     // Catch: Throwable -> L11
        Operation.State r17 = Operation.State.VISIBLE;     // Catch: Throwable -> L11
        if (r16 != r17) goto L5;
        if (r15 == r17) goto L5;
    L14:
        Operation r18 = r13;     // Catch: Throwable -> L11
        if (r18 == null) goto L17;
        r12 = r18.getFragment();     // Catch: Throwable -> L11
    L17:
        if (r12 == null) goto L19;
        boolean r19 = r12.isPostponed();     // Catch: Throwable -> L11
    L20:
        this.isContainerPostponed = r19;     // Catch: Throwable -> L11
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return;
    L19:
        r19 = false;
        goto L20
    L13:
        r13 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public final void updateOperationDirection(boolean r5) {
        this.operationDirectionIsPop = r5;
    }

    @JvmStatic
    public static final SpecialEffectsController getOrCreateController(ViewGroup r5, SpecialEffectsControllerFactory r10) {
        return Companion.getOrCreateController(r5, r10);
    }
}
