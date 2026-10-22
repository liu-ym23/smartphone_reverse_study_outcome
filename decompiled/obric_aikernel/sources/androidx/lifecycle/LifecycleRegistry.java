package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
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

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        @VisibleForTesting
        public final LifecycleRegistry createUnsafe(LifecycleOwner r10) {
            Intrinsics.checkNotNullParameter(r10, "owner");
            return new LifecycleRegistry(r10, false, null);
        }

        @JvmStatic
        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State r10, Lifecycle.State r11) {
            Intrinsics.checkNotNullParameter(r10, "state1");
            if (r11 != null) goto L5;
            return r10;
        L5:
            if (r11.compareTo(r10) < 0) goto L7;
            return r10;
        L7:
            return r11;
        }
    }

    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public ObserverWithState(LifecycleObserver r10, Lifecycle.State r11) {
            Intrinsics.checkNotNullParameter(r11, "initialState");
            Intrinsics.checkNotNull(r10);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(r10);
            this.state = r11;
        }

        public final void dispatchEvent(LifecycleOwner r10, Lifecycle.Event r11) {
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
            Lifecycle.State r12 = r11.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, r12);
            LifecycleEventObserver r13 = this.lifecycleObserver;
            Intrinsics.checkNotNull(r10);
            r13.onStateChanged(r10, r11);
            this.state = r12;
        }

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(LifecycleEventObserver r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.lifecycleObserver = r10;
        }

        public final void setState(Lifecycle.State r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.state = r10;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LifecycleRegistry(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "provider");
        this(r10, true);
    }

    private LifecycleRegistry(LifecycleOwner r10, boolean r11) {
        this.enforceMainThread = r11;
        this.observerMap = new FastSafeIterableMap();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList();
        this.lifecycleOwner = new WeakReference(r10);
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner r10, boolean r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    private final void backwardPass(LifecycleOwner r10) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> r11 = this.observerMap.descendingIterator();
        Intrinsics.checkNotNullExpressionValue(r11, "observerMap.descendingIterator()");
    L4:
        if (r11.hasNext() == false) goto L19;
        if (this.newEventOccurred == true) goto L27;
        Map.Entry<LifecycleObserver, ObserverWithState> r12 = r11.next();
        Intrinsics.checkNotNullExpressionValue(r12, "next()");
        LifecycleObserver r13 = r12.getKey();
        ObserverWithState r14 = r12.getValue();
    L9:
        if (r14.getState().compareTo(this.state) <= 0) goto L4;
        if (this.newEventOccurred == true) goto L4;
        if (this.observerMap.contains(r13) == false) goto L4;
        Lifecycle.Event r15 = Lifecycle.Event.Companion.downFrom(r14.getState());
        if (r15 == null) goto L18;
        pushParentState(r15.getTargetState());
        r14.dispatchEvent(r10, r15);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event down from " + r14.getState());
    L27:
        return;
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver r10) {
        Map.Entry<LifecycleObserver, ObserverWithState> r11 = this.observerMap.ceil(r10);
        Lifecycle.State r12 = null;
        if (r11 == null) goto L7;
        ObserverWithState r13 = r11.getValue();
        if (r13 == null) goto L7;
        Lifecycle.State r14 = r13.getState();
    L9:
        if ((!this.parentStates.isEmpty()) == false) goto L11;
        ArrayList<Lifecycle.State> r15 = this.parentStates;
        r12 = r15.get(r15.size() - 1);
    L11:
        Companion r16 = Companion;
        return r16.min$lifecycle_runtime_release(r16.min$lifecycle_runtime_release(this.state, r14), r12);
    L7:
        r14 = null;
        goto L9
    }

    @JvmStatic
    @VisibleForTesting
    public static final LifecycleRegistry createUnsafe(LifecycleOwner r10) {
        return Companion.createUnsafe(r10);
    }

    @SuppressLint({"RestrictedApi"})
    private final void enforceMainThreadIfNeeded(String r10) {
        if (this.enforceMainThread == true) goto L5;
        return;
    L5:
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException(("Method " + r10 + " must be called on the main thread").toString());
    }

    private final void forwardPass(LifecycleOwner r10) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions r11 = this.observerMap.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(r11, "observerMap.iteratorWithAdditions()");
    L4:
        if (r11.hasNext() == false) goto L19;
        if (this.newEventOccurred == true) goto L27;
        Map.Entry r12 = r11.next();
        LifecycleObserver r13 = (LifecycleObserver) r12.getKey();
        ObserverWithState r14 = (ObserverWithState) r12.getValue();
    L9:
        if (r14.getState().compareTo(this.state) >= 0) goto L4;
        if (this.newEventOccurred == true) goto L4;
        if (this.observerMap.contains(r13) == false) goto L4;
        pushParentState(r14.getState());
        Lifecycle.Event r15 = Lifecycle.Event.Companion.upFrom(r14.getState());
        if (r15 == null) goto L18;
        r14.dispatchEvent(r10, r15);
        popParentState();
        goto L9
    L18:
        throw new IllegalStateException("no event up from " + r14.getState());
    L27:
        return;
    }

    private final boolean isSynced() {
        if (this.observerMap.size() != 0) goto L5;
        return true;
    L5:
        Map.Entry<LifecycleObserver, ObserverWithState> r10 = this.observerMap.eldest();
        Intrinsics.checkNotNull(r10);
        Lifecycle.State r11 = r10.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> r12 = this.observerMap.newest();
        Intrinsics.checkNotNull(r12);
        Lifecycle.State r13 = r12.getValue().getState();
        if (r11 == r13) goto L8;
    L10:
        return false;
    L8:
        if (this.state != r13) goto L10;
        return true;
    }

    @JvmStatic
    public static final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State r10, Lifecycle.State r11) {
        return Companion.min$lifecycle_runtime_release(r10, r11);
    }

    private final void moveToState(Lifecycle.State r10) {
        Lifecycle.State r11 = this.state;
        if (r11 != r10) goto L6;
        return;
    L6:
        if (r11 == Lifecycle.State.INITIALIZED) goto L8;
    L11:
        boolean r12 = true;
    L12:
        if (r12 == false) goto L25;
        this.state = r10;
        if (this.handlingEvent == false) goto L16;
    L22:
        this.newEventOccurred = true;
        return;
    L16:
        if (this.addingObserverCounter != 0) goto L22;
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state != Lifecycle.State.DESTROYED) goto L26;
        this.observerMap = new FastSafeIterableMap();
        return;
    L26:
        return;
    L25:
        throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
    L8:
        if (r10 != Lifecycle.State.DESTROYED) goto L11;
        r12 = false;
        goto L12
    }

    private final void popParentState() {
        ArrayList<Lifecycle.State> r10 = this.parentStates;
        r10.remove(r10.size() - 1);
    }

    private final void pushParentState(Lifecycle.State r10) {
        this.parentStates.add(r10);
    }

    private final void sync() {
        LifecycleOwner r10 = this.lifecycleOwner.get();
        if (r10 == null) goto L17;
    L4:
        boolean r11 = isSynced();
        this.newEventOccurred = false;
        if (r11 == true) goto L15;
        Lifecycle.State r12 = this.state;
        Map.Entry<LifecycleObserver, ObserverWithState> r13 = this.observerMap.eldest();
        Intrinsics.checkNotNull(r13);
        if (r12.compareTo(r13.getValue().getState()) >= 0) goto L9;
        backwardPass(r10);
    L9:
        Map.Entry<LifecycleObserver, ObserverWithState> r14 = this.observerMap.newest();
        if (this.newEventOccurred == true) goto L4;
        if (r14 == null) goto L4;
        if (this.state.compareTo(r14.getValue().getState()) <= 0) goto L4;
        forwardPass(r10);
        goto L4
    L15:
        return;
    L17:
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State r11 = this.state;
        Lifecycle.State r12 = Lifecycle.State.DESTROYED;
        if (r11 == r12) goto L6;
        r12 = Lifecycle.State.INITIALIZED;
    L6:
        ObserverWithState r13 = new ObserverWithState(r10, r12);
        if (this.observerMap.putIfAbsent(r10, r13) == null) goto L9;
        return;
    L9:
        LifecycleOwner r14 = this.lifecycleOwner.get();
        if (r14 != null) goto L13;
        return;
    L13:
        if (this.addingObserverCounter == 0) goto L15;
    L18:
        boolean r15 = true;
    L19:
        Lifecycle.State r16 = calculateTargetState(r10);
        this.addingObserverCounter++;
    L21:
        if (r13.getState().compareTo(r16) >= 0) goto L29;
        if (this.observerMap.contains(r10) == false) goto L29;
        pushParentState(r13.getState());
        Lifecycle.Event r17 = Lifecycle.Event.Companion.upFrom(r13.getState());
        if (r17 == null) goto L28;
        r13.dispatchEvent(r14, r17);
        popParentState();
        r16 = calculateTargetState(r10);
        goto L21
    L28:
        throw new IllegalStateException("no event up from " + r13.getState());
    L29:
        if (r15 == true) goto L31;
        sync();
    L31:
        this.addingObserverCounter--;
        return;
    L15:
        if (this.handlingEvent == true) goto L18;
        r15 = false;
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

    public void handleLifecycleEvent(Lifecycle.Event r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(r10.getTargetState());
    }

    @Deprecated(message = "Override [currentState].")
    @MainThread
    public void markState(Lifecycle.State r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(r10);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(r10);
    }

    public void setCurrentState(Lifecycle.State r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(r10);
    }
}
