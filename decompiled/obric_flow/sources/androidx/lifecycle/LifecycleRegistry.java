package androidx.lifecycle;

import ai.j0;
import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 42\u00020\u0001:\u000245B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0003J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\"H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001fj\b\u0012\u0004\u0012\u00020\u000b` X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "provider", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "enforceMainThread", "", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "addingObserverCounter", "", "state", "Landroidx/lifecycle/Lifecycle$State;", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "handlingEvent", "isSynced", "()Z", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "newEventOccurred", "observerCount", "getObserverCount", "()I", "observerMap", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "parentStates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "backwardPass", "calculateTargetState", "enforceMainThreadIfNeeded", "methodName", "", "forwardPass", "handleLifecycleEvent", "event", "Landroidx/lifecycle/Lifecycle$Event;", "markState", "moveToState", "next", "popParentState", "pushParentState", "removeObserver", "sync", "Companion", "ObserverWithState", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LifecycleRegistry extends Lifecycle {
    public static final Companion Companion = null;
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    private ArrayList<Lifecycle.State> parentStates;
    private Lifecycle.State state;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "()V", "createUnsafe", "Landroidx/lifecycle/LifecycleRegistry;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "min", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "min$lifecycle_runtime_release", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        @VisibleForTesting
        public final LifecycleRegistry createUnsafe(LifecycleOwner r5) {
            Intrinsics.checkNotNullParameter(r5, "owner");
            return new LifecycleRegistry(r5, false, null);
        }

        @JvmStatic
        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State r5, Lifecycle.State r10) {
            Intrinsics.checkNotNullParameter(r5, "state1");
            if (r10 != null) goto L5;
            return r5;
        L5:
            if (r10.compareTo(r5) < 0) goto L7;
            return r5;
        L7:
            return r10;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "state", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "dispatchEvent", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public ObserverWithState(LifecycleObserver r5, Lifecycle.State r10) {
            Intrinsics.checkNotNullParameter(r10, "initialState");
            Intrinsics.checkNotNull(r5);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(r5);
            this.state = r10;
        }

        public final void dispatchEvent(LifecycleOwner r5, Lifecycle.Event r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            Lifecycle.State r11 = r10.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, r11);
            LifecycleEventObserver r12 = this.lifecycleObserver;
            Intrinsics.checkNotNull(r5);
            r12.onStateChanged(r5, r10);
            this.state = r11;
        }

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(LifecycleEventObserver r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.lifecycleObserver = r5;
        }

        public final void setState(Lifecycle.State r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.state = r5;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner r5, boolean r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    private final void backwardPass(LifecycleOwner r10) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> r5 = this.observerMap.descendingIterator();
    L4:
        if (r5.hasNext() == false) goto L19;
        if (this.newEventOccurred == true) goto L27;
        Map.Entry<LifecycleObserver, ObserverWithState> r11 = r5.next();
        LifecycleObserver r12 = r11.getKey();
        ObserverWithState r13 = r11.getValue();
    L9:
        if (r13.getState().compareTo(this.state) <= 0) goto L4;
        if (this.newEventOccurred == true) goto L4;
        if (this.observerMap.contains(r12) == false) goto L4;
        Lifecycle.Event r14 = Lifecycle.Event.Companion.downFrom(r13.getState());
        if (r14 == null) goto L18;
        pushParentState(r14.getTargetState());
        r13.dispatchEvent(r10, r14);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event down from " + r13.getState());
    L27:
        return;
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver r5) {
        Map.Entry<LifecycleObserver, ObserverWithState> r10 = this.observerMap.ceil(r5);
        Lifecycle.State r11 = null;
        if (r10 == null) goto L7;
        ObserverWithState r12 = r10.getValue();
        if (r12 == null) goto L7;
        Lifecycle.State r13 = r12.getState();
    L9:
        if (this.parentStates.isEmpty() == true) goto L11;
        r11 = (Lifecycle.State) androidx.constraintlayout.motion.widget.a.h(this.parentStates, 1);
    L11:
        Companion r14 = Companion;
        return r14.min$lifecycle_runtime_release(r14.min$lifecycle_runtime_release(this.state, r13), r11);
    L7:
        r13 = null;
        goto L9
    }

    @JvmStatic
    @VisibleForTesting
    public static final LifecycleRegistry createUnsafe(LifecycleOwner r5) {
        return Companion.createUnsafe(r5);
    }

    @SuppressLint({"RestrictedApi"})
    private final void enforceMainThreadIfNeeded(String r5) {
        if (this.enforceMainThread == true) goto L5;
        return;
    L5:
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(j0.k("Method ", r5, " must be called on the main thread").toString());
    }

    private final void forwardPass(LifecycleOwner r10) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions r5 = this.observerMap.iteratorWithAdditions();
    L4:
        if (r5.hasNext() == false) goto L19;
        if (this.newEventOccurred == true) goto L27;
        Map.Entry r11 = r5.next();
        LifecycleObserver r12 = (LifecycleObserver) r11.getKey();
        ObserverWithState r13 = (ObserverWithState) r11.getValue();
    L9:
        if (r13.getState().compareTo(this.state) >= 0) goto L4;
        if (this.newEventOccurred == true) goto L4;
        if (this.observerMap.contains(r12) == false) goto L4;
        pushParentState(r13.getState());
        Lifecycle.Event r14 = Lifecycle.Event.Companion.upFrom(r13.getState());
        if (r14 == null) goto L18;
        r13.dispatchEvent(r10, r14);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event up from " + r13.getState());
    L27:
        return;
    }

    private final boolean isSynced() {
        if (this.observerMap.size() != 0) goto L5;
        return true;
    L5:
        Map.Entry<LifecycleObserver, ObserverWithState> r5 = this.observerMap.eldest();
        Intrinsics.checkNotNull(r5);
        Lifecycle.State r10 = r5.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> r11 = this.observerMap.newest();
        Intrinsics.checkNotNull(r11);
        Lifecycle.State r12 = r11.getValue().getState();
        if (r10 == r12) goto L8;
    L10:
        return false;
    L8:
        if (this.state != r12) goto L10;
        return true;
    }

    @JvmStatic
    public static final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State r5, Lifecycle.State r10) {
        return Companion.min$lifecycle_runtime_release(r5, r10);
    }

    private final void moveToState(Lifecycle.State r5) {
        Lifecycle.State r10 = this.state;
        if (r10 != r5) goto L6;
        return;
    L6:
        if (r10 == Lifecycle.State.INITIALIZED) goto L8;
    L12:
        this.state = r5;
        if (this.handlingEvent == false) goto L15;
    L21:
        this.newEventOccurred = true;
        return;
    L15:
        if (this.addingObserverCounter != 0) goto L21;
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state != Lifecycle.State.DESTROYED) goto L23;
        this.observerMap = new FastSafeIterableMap();
        return;
    L23:
        return;
    L8:
        if (r5 != Lifecycle.State.DESTROYED) goto L12;
        throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
    }

    private final void popParentState() {
        ArrayList<Lifecycle.State> r5 = this.parentStates;
        r5.remove(r5.size() - 1);
    }

    private final void pushParentState(Lifecycle.State r5) {
        this.parentStates.add(r5);
    }

    private final void sync() {
        LifecycleOwner r5 = this.lifecycleOwner.get();
        if (r5 == null) goto L18;
    L5:
        if (isSynced() == true) goto L15;
        this.newEventOccurred = false;
        Lifecycle.State r10 = this.state;
        Map.Entry<LifecycleObserver, ObserverWithState> r11 = this.observerMap.eldest();
        Intrinsics.checkNotNull(r11);
        if (r10.compareTo(r11.getValue().getState()) >= 0) goto L9;
        backwardPass(r5);
    L9:
        Map.Entry<LifecycleObserver, ObserverWithState> r12 = this.observerMap.newest();
        if (this.newEventOccurred == true) goto L5;
        if (r12 == null) goto L5;
        if (this.state.compareTo(r12.getValue().getState()) <= 0) goto L5;
        forwardPass(r5);
        goto L5
    L15:
        this.newEventOccurred = false;
        return;
    L18:
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State r5 = this.state;
        Lifecycle.State r11 = Lifecycle.State.DESTROYED;
        if (r5 == r11) goto L6;
        r11 = Lifecycle.State.INITIALIZED;
    L6:
        ObserverWithState r12 = new ObserverWithState(r10, r11);
        if (this.observerMap.putIfAbsent(r10, r12) == null) goto L9;
        return;
    L9:
        LifecycleOwner r13 = this.lifecycleOwner.get();
        if (r13 != null) goto L13;
        return;
    L13:
        if (this.addingObserverCounter == 0) goto L15;
    L18:
        boolean r14 = true;
    L19:
        Lifecycle.State r15 = calculateTargetState(r10);
        this.addingObserverCounter++;
    L21:
        if (r12.getState().compareTo(r15) >= 0) goto L29;
        if (this.observerMap.contains(r10) == false) goto L29;
        pushParentState(r12.getState());
        Lifecycle.Event r16 = Lifecycle.Event.Companion.upFrom(r12.getState());
        if (r16 == null) goto L28;
        r12.dispatchEvent(r13, r16);
        popParentState();
        r15 = calculateTargetState(r10);
        goto L21
    L28:
        throw new IllegalStateException("no event up from " + r12.getState());
    L29:
        if (r14 == true) goto L31;
        sync();
    L31:
        this.addingObserverCounter--;
        return;
    L15:
        if (this.handlingEvent == true) goto L18;
        r14 = false;
        goto L19
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.state;
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    public void handleLifecycleEvent(Lifecycle.Event r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(r5.getTargetState());
    }

    @Deprecated(message = "Override [currentState].")
    @MainThread
    public void markState(Lifecycle.State r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(r5);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver r5) {
        Intrinsics.checkNotNullParameter(r5, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(r5);
    }

    public void setCurrentState(Lifecycle.State r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(r5);
    }

    private LifecycleRegistry(LifecycleOwner r5, boolean r10) {
        this.enforceMainThread = r10;
        this.observerMap = new FastSafeIterableMap();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList();
        this.lifecycleOwner = new WeakReference(r5);
    }

    public LifecycleRegistry(LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r5, "provider");
        this(r5, true);
    }
}
