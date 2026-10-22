package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    boolean mIsContainerPostponed;
    boolean mOperationDirectionIsPop;
    final ArrayList<Operation> mPendingOperations;
    final ArrayList<Operation> mRunningOperations;

    /* JADX INFO: renamed from: androidx.fragment.app.SpecialEffectsController$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = null;

        static {
            int[] r10 = new int[Operation.LifecycleImpact.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = r10;
            r10[Operation.LifecycleImpact.ADDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[Operation.LifecycleImpact.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r11 = new int[Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r11;
            r11[Operation.State.REMOVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.GONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[Operation.State.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    private static class FragmentStateManagerOperation extends Operation {

        @NonNull
        private final FragmentStateManager mFragmentStateManager;

        FragmentStateManagerOperation(@NonNull Operation.State r10, @NonNull Operation.LifecycleImpact r11, @NonNull FragmentStateManager r12, @NonNull CancellationSignal r13) {
            super(r10, r11, r12.getFragment(), r13);
            this.mFragmentStateManager = r12;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        void onStart() {
            if (getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L19;
            Fragment r10 = this.mFragmentStateManager.getFragment();
            View r11 = r10.mView.findFocus();
            if (r11 == null) goto L9;
            r10.setFocusedView(r11);
            if (FragmentManager.isLoggingEnabled(2) == false) goto L9;
            Log.v("FragmentManager", "requestFocus: Saved focused view " + r11 + " for Fragment " + r10);
        L9:
            View r12 = getFragment().requireView();
            if (r12.getParent() != null) goto L13;
            this.mFragmentStateManager.addViewToContainer();
            r12.setAlpha(0.0f);
        L13:
            if (r12.getAlpha() == 0.0f) goto L15;
        L17:
            r12.setAlpha(r10.getPostOnViewCreatedAlpha());
            return;
        L15:
            if (r12.getVisibility() != 0) goto L17;
            r12.setVisibility(4);
            goto L17
        }
    }

    static class Operation {

        @NonNull
        private final List<Runnable> mCompletionListeners;

        @NonNull
        private State mFinalState;

        @NonNull
        private final Fragment mFragment;
        private boolean mIsCanceled;
        private boolean mIsComplete;

        @NonNull
        private LifecycleImpact mLifecycleImpact;

        @NonNull
        private final HashSet<CancellationSignal> mSpecialEffectsSignals;

        static final enum LifecycleImpact extends Enum<LifecycleImpact> {
            private static final /* synthetic */ LifecycleImpact[] $VALUES = null;
            public static final LifecycleImpact ADDING = null;
            public static final LifecycleImpact NONE = null;
            public static final LifecycleImpact REMOVING = null;

            static {
                LifecycleImpact r10 = new LifecycleImpact("NONE", 0);
                NONE = r10;
                LifecycleImpact r11 = new LifecycleImpact("ADDING", 1);
                ADDING = r11;
                LifecycleImpact r12 = new LifecycleImpact("REMOVING", 2);
                REMOVING = r12;
                $VALUES = new LifecycleImpact[]{r10, r11, r12};
            }

            private LifecycleImpact(String r10, int r11) {
                super(r10, r11);
            }

            public static LifecycleImpact valueOf(String r10) {
                return (LifecycleImpact) Enum.valueOf(LifecycleImpact.class, r10);
            }

            public static LifecycleImpact[] values() {
                return (LifecycleImpact[]) $VALUES.clone();
            }
        }

        static final enum State extends Enum<State> {
            private static final /* synthetic */ State[] $VALUES = null;
            public static final State GONE = null;
            public static final State INVISIBLE = null;
            public static final State REMOVED = null;
            public static final State VISIBLE = null;

            static {
                State r10 = new State("REMOVED", 0);
                REMOVED = r10;
                State r11 = new State("VISIBLE", 1);
                VISIBLE = r11;
                State r12 = new State("GONE", 2);
                GONE = r12;
                State r13 = new State("INVISIBLE", 3);
                INVISIBLE = r13;
                $VALUES = new State[]{r10, r11, r12, r13};
            }

            private State(String r10, int r11) {
                super(r10, r11);
            }

            @NonNull
            static State from(int r10) {
                if (r10 == 0) goto L14;
                if (r10 == 4) goto L12;
                if (r10 != 8) goto L10;
                return GONE;
            L10:
                throw new IllegalArgumentException("Unknown visibility " + r10);
            L12:
                return INVISIBLE;
            L14:
                return VISIBLE;
            }

            @NonNull
            static State from(@NonNull View r10) {
                if (r10.getAlpha() != 0.0f) goto L9;
                if (r10.getVisibility() != 0) goto L9;
                return INVISIBLE;
            L9:
                return from(r10.getVisibility());
            }

            public static State valueOf(String r10) {
                return (State) Enum.valueOf(State.class, r10);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }

            void applyState(@NonNull View r10) {
                int r11 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[ordinal()];
                if (r11 != 1) goto L5;
                ViewGroup r12 = (ViewGroup) r10.getParent();
                if (r12 != null) goto L27;
                return;
            L27:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L29;
                Log.v("FragmentManager", "SpecialEffectsController: Removing view " + r10 + " from container " + r12);
            L29:
                r12.removeView(r10);
                return;
            L5:
                if (r11 == 2) goto L20;
                if (r11 == 3) goto L16;
                if (r11 == 4) goto L12;
                return;
            L12:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r10 + " to INVISIBLE");
            L14:
                r10.setVisibility(4);
                return;
            L16:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r10 + " to GONE");
            L18:
                int r13 = 8;
            L23:
                r10.setVisibility(r13);
                return;
            L20:
                if (FragmentManager.isLoggingEnabled(2) == false) goto L22;
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + r10 + " to VISIBLE");
            L22:
                r13 = 0;
                goto L23
            }
        }

        Operation(@NonNull State r10, @NonNull LifecycleImpact r11, @NonNull Fragment r12, @NonNull CancellationSignal r13) {
            this.mCompletionListeners = new ArrayList();
            this.mSpecialEffectsSignals = new HashSet();
            this.mIsCanceled = false;
            this.mIsComplete = false;
            this.mFinalState = r10;
            this.mLifecycleImpact = r11;
            this.mFragment = r12;
            r13.setOnCancelListener(new AnonymousClass1(this));
        }

        final void addCompletionListener(@NonNull Runnable r10) {
            this.mCompletionListeners.add(r10);
        }

        final void cancel() {
            if (isCanceled() == false) goto L5;
            return;
        L5:
            this.mIsCanceled = true;
            if (this.mSpecialEffectsSignals.isEmpty() == false) goto L8;
            complete();
            return;
        L8:
            Iterator r10 = new ArrayList(this.mSpecialEffectsSignals).iterator();
        L10:
            if (r10.hasNext() == false) goto L14;
            ((CancellationSignal) r10.next()).cancel();
            goto L10
        }

        @CallSuper
        public void complete() {
            if (this.mIsComplete == false) goto L6;
            return;
        L6:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
            Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
        L8:
            this.mIsComplete = true;
            Iterator<Runnable> r10 = this.mCompletionListeners.iterator();
        L10:
            if (r10.hasNext() == false) goto L12;
            r10.next().run();
            goto L10
        }

        public final void completeSpecialEffect(@NonNull CancellationSignal r10) {
            if (this.mSpecialEffectsSignals.remove(r10) == true) goto L5;
            return;
        L5:
            if (this.mSpecialEffectsSignals.isEmpty() == false) goto L9;
            complete();
            return;
        }

        @NonNull
        public State getFinalState() {
            return this.mFinalState;
        }

        @NonNull
        public final Fragment getFragment() {
            return this.mFragment;
        }

        @NonNull
        LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        final boolean isCanceled() {
            return this.mIsCanceled;
        }

        final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void markStartedSpecialEffect(@NonNull CancellationSignal r10) {
            onStart();
            this.mSpecialEffectsSignals.add(r10);
        }

        final void mergeWith(@NonNull State r10, @NonNull LifecycleImpact r11) {
            int r12 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[r11.ordinal()];
            if (r12 == 1) goto L21;
            if (r12 == 2) goto L16;
            if (r12 == 3) goto L10;
            return;
        L10:
            if (this.mFinalState != State.REMOVED) goto L12;
            return;
        L12:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L14;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + this.mFinalState + " -> " + r10 + ". ");
        L14:
            this.mFinalState = r10;
            return;
        L16:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = " + this.mFinalState + " -> REMOVED. mLifecycleImpact  = " + this.mLifecycleImpact + " to REMOVING.");
        L18:
            this.mFinalState = State.REMOVED;
            LifecycleImpact r13 = LifecycleImpact.REMOVING;
        L19:
            this.mLifecycleImpact = r13;
            return;
        L21:
            if (this.mFinalState == State.REMOVED) goto L23;
            return;
        L23:
            if (FragmentManager.isLoggingEnabled(2) == false) goto L25;
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.mFragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.mLifecycleImpact + " to ADDING.");
        L25:
            this.mFinalState = State.VISIBLE;
            r13 = LifecycleImpact.ADDING;
            goto L19
        }

        void onStart() {
        }

        @NonNull
        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.mFinalState + "} {mLifecycleImpact = " + this.mLifecycleImpact + "} {mFragment = " + this.mFragment + "}";
        }
    }

    SpecialEffectsController(@NonNull ViewGroup r10) {
        this.mPendingOperations = new ArrayList();
        this.mRunningOperations = new ArrayList();
        this.mOperationDirectionIsPop = false;
        this.mIsContainerPostponed = false;
        this.mContainer = r10;
    }

    private void enqueue(@NonNull Operation.State r10, @NonNull Operation.LifecycleImpact r11, @NonNull FragmentStateManager r12) {
        ArrayList<Operation> r13 = this.mPendingOperations;
        monitor-enter(r13);
        CancellationSignal r14 = new CancellationSignal();     // Catch: Throwable -> L12
        Operation r15 = findPendingOperation(r12.getFragment());     // Catch: Throwable -> L12
        if (r15 == null) goto L9;
        r15.mergeWith(r10, r11);     // Catch: Throwable -> L12
        monitor-exit(r13);     // Catch: Throwable -> L12
        return;
    L9:
        final FragmentStateManagerOperation r16 = new FragmentStateManagerOperation(r10, r11, r12, r14);     // Catch: Throwable -> L12
        this.mPendingOperations.add(r16);     // Catch: Throwable -> L12
        r16.addCompletionListener(new AnonymousClass1(this, r16));     // Catch: Throwable -> L12
        r16.addCompletionListener(new AnonymousClass2(this, r16));     // Catch: Throwable -> L12
        monitor-exit(r13);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Nullable
    private Operation findPendingOperation(@NonNull Fragment r10) {
        Iterator<Operation> r11 = this.mPendingOperations.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Operation r12 = r11.next();
        if (r12.getFragment().equals(r10) == false) goto L4;
        if (r12.isCanceled() == true) goto L4;
        return r12;
    L10:
        return null;
    }

    @Nullable
    private Operation findRunningOperation(@NonNull Fragment r10) {
        Iterator<Operation> r11 = this.mRunningOperations.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Operation r12 = r11.next();
        if (r12.getFragment().equals(r10) == false) goto L4;
        if (r12.isCanceled() == true) goto L4;
        return r12;
    L10:
        return null;
    }

    @NonNull
    static SpecialEffectsController getOrCreateController(@NonNull ViewGroup r10, @NonNull FragmentManager r11) {
        return getOrCreateController(r10, r11.getSpecialEffectsControllerFactory());
    }

    @NonNull
    static SpecialEffectsController getOrCreateController(@NonNull ViewGroup r10, @NonNull SpecialEffectsControllerFactory r11) {
        int r12 = R.id.special_effects_controller_view_tag;
        Object r13 = r10.getTag(r12);
        if ((r13 instanceof SpecialEffectsController) == true) goto L5;
        SpecialEffectsController r14 = r11.createController(r10);
        r10.setTag(r12, r14);
        return r14;
    L5:
        return (SpecialEffectsController) r13;
    }

    private void updateFinalState() {
        Iterator<Operation> r10 = this.mPendingOperations.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Operation r11 = r10.next();
        if (r11.getLifecycleImpact() != Operation.LifecycleImpact.ADDING) goto L4;
        r11.mergeWith(Operation.State.from(r11.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
        goto L4
    }

    void enqueueAdd(@NonNull Operation.State r10, @NonNull FragmentStateManager r11) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + r11.getFragment());
    L5:
        enqueue(r10, Operation.LifecycleImpact.ADDING, r11);
    }

    void enqueueHide(@NonNull FragmentStateManager r10) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + r10.getFragment());
    L5:
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, r10);
    }

    void enqueueRemove(@NonNull FragmentStateManager r10) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + r10.getFragment());
    L5:
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, r10);
    }

    void enqueueShow(@NonNull FragmentStateManager r10) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + r10.getFragment());
    L5:
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, r10);
    }

    abstract void executeOperations(@NonNull List<Operation> r10, boolean r11);

    void executePendingOperations() {
        if (this.mIsContainerPostponed == false) goto L6;
        return;
    L6:
        if (ViewCompat.isAttachedToWindow(this.mContainer) == true) goto L9;
        forceCompleteAllOperations();
        this.mOperationDirectionIsPop = false;
        return;
    L9:
        ArrayList<Operation> r10 = this.mPendingOperations;
        monitor-enter(r10);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.mPendingOperations.isEmpty() == true) goto L27;
        ArrayList r11 = new ArrayList(this.mRunningOperations);     // Catch: Throwable -> L29
        this.mRunningOperations.clear();     // Catch: Throwable -> L29
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L29
    L15:
        if (r12.hasNext() == false) goto L22;
        Operation r13 = (Operation) r12.next();     // Catch: Throwable -> L29
        if (FragmentManager.isLoggingEnabled(2) == false) goto L19;
        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + r13);     // Catch: Throwable -> L29
    L19:
        r13.cancel();     // Catch: Throwable -> L29
        if (r13.isComplete() == true) goto L15;
        this.mRunningOperations.add(r13);     // Catch: Throwable -> L29
        goto L15
    L22:
        updateFinalState();     // Catch: Throwable -> L29
        ArrayList r14 = new ArrayList(this.mPendingOperations);     // Catch: Throwable -> L29
        this.mPendingOperations.clear();     // Catch: Throwable -> L29
        this.mRunningOperations.addAll(r14);     // Catch: Throwable -> L29
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L29
    L24:
        if (r15.hasNext() == false) goto L26;
        ((Operation) r15.next()).onStart();     // Catch: Throwable -> L29
        goto L24
    L26:
        executeOperations(r14, this.mOperationDirectionIsPop);     // Catch: Throwable -> L29
        this.mOperationDirectionIsPop = false;     // Catch: Throwable -> L29
    L27:
        monitor-exit(r10);     // Catch: Throwable -> L29
    }

    void forceCompleteAllOperations() {
        boolean r10 = ViewCompat.isAttachedToWindow(this.mContainer);
        ArrayList<Operation> r11 = this.mPendingOperations;
        monitor-enter(r11);
        updateFinalState();     // Catch: Throwable -> L32
        Iterator<Operation> r12 = this.mPendingOperations.iterator();     // Catch: Throwable -> L32
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().onStart();     // Catch: Throwable -> L32
        goto L6
    L8:
        Iterator r13 = new ArrayList(this.mRunningOperations).iterator();     // Catch: Throwable -> L32
    L10:
        if (r13.hasNext() == false) goto L19;
        Operation r14 = (Operation) r13.next();     // Catch: Throwable -> L32
        if (FragmentManager.isLoggingEnabled(2) == false) goto L18;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L32
        r15.append("SpecialEffectsController: ");     // Catch: Throwable -> L32
        if (r10 == false) goto L16;
        String r16 = "";
    L17:
        r15.append(r16);     // Catch: Throwable -> L32
        r15.append("Cancelling running operation ");     // Catch: Throwable -> L32
        r15.append(r14);     // Catch: Throwable -> L32
        Log.v("FragmentManager", r15.toString());     // Catch: Throwable -> L32
        goto L18
    L16:
        r16 = "Container " + this.mContainer + " is not attached to window. ";     // Catch: Throwable -> L32
    L18:
        r14.cancel();     // Catch: Throwable -> L32
        goto L10
    L19:
        Iterator r17 = new ArrayList(this.mPendingOperations).iterator();     // Catch: Throwable -> L32
    L21:
        if (r17.hasNext() == false) goto L30;
        Operation r18 = (Operation) r17.next();     // Catch: Throwable -> L32
        if (FragmentManager.isLoggingEnabled(2) == false) goto L29;
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L32
        r19.append("SpecialEffectsController: ");     // Catch: Throwable -> L32
        if (r10 == false) goto L27;
        String r20 = "";
    L28:
        r19.append(r20);     // Catch: Throwable -> L32
        r19.append("Cancelling pending operation ");     // Catch: Throwable -> L32
        r19.append(r18);     // Catch: Throwable -> L32
        Log.v("FragmentManager", r19.toString());     // Catch: Throwable -> L32
        goto L29
    L27:
        r20 = "Container " + this.mContainer + " is not attached to window. ";     // Catch: Throwable -> L32
    L29:
        r18.cancel();     // Catch: Throwable -> L32
        goto L21
    L30:
        monitor-exit(r11);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed == false) goto L6;
        this.mIsContainerPostponed = false;
        executePendingOperations();
        return;
    }

    @Nullable
    Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(@NonNull FragmentStateManager r10) {
        Operation r11 = findPendingOperation(r10.getFragment());
        if (r11 == null) goto L5;
        Operation.LifecycleImpact r12 = r11.getLifecycleImpact();
    L6:
        Operation r13 = findRunningOperation(r10.getFragment());
        if (r13 == null) goto L13;
        if (r12 == null) goto L12;
        if (r12 != Operation.LifecycleImpact.NONE) goto L13;
    L12:
        return r13.getLifecycleImpact();
    L13:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    @NonNull
    public ViewGroup getContainer() {
        return this.mContainer;
    }

    void markPostponedState() {
        ArrayList<Operation> r10 = this.mPendingOperations;
        monitor-enter(r10);
        updateFinalState();     // Catch: Throwable -> L13
        this.mIsContainerPostponed = false;     // Catch: Throwable -> L13
        int r11 = this.mPendingOperations.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (r11 < 0) goto L11;
        Operation r12 = this.mPendingOperations.get(r11);     // Catch: Throwable -> L13
        Operation.State r13 = Operation.State.from(r12.getFragment().mView);     // Catch: Throwable -> L13
        Operation.State r14 = r12.getFinalState();     // Catch: Throwable -> L13
        Operation.State r15 = Operation.State.VISIBLE;     // Catch: Throwable -> L13
        if (r14 != r15) goto L10;
        if (r13 == r15) goto L10;
        this.mIsContainerPostponed = r12.getFragment().isPostponed();     // Catch: Throwable -> L13
    L10:
        r11 = r11 - 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void updateOperationDirection(boolean r10) {
        this.mOperationDirectionIsPop = r10;
    }
}
