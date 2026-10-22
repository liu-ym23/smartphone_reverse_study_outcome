package com.obric.assistant.interaction.impl.window;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000  2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/assistant/interaction/impl/window/FakeActivityLifecycleDispatcher;", "", "<init>", "()V", "stateMap", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Lcom/obric/assistant/interaction/impl/window/FakeActivityLifecycleDispatcher$State;", "mainHandler", "Landroid/os/Handler;", "stateOf", "activity", "setState", "", "state", "runOnMainSync", "block", "Lkotlin/Function0;", "dispatchLifecycleEvent", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "nextState", "dispatchCreate", "savedInstanceState", "Landroid/os/Bundle;", "dispatchStart", "dispatchResume", "dispatchPause", "dispatchStop", "dispatchPreDestroy", "dispatchDestroy", "Companion", "State", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FakeActivityLifecycleDispatcher {
    private static final Companion Companion = null;
    private static final String TAG = "FakeActivityLifecycle";
    private final Handler mainHandler;
    private final WeakHashMap<Activity, State> stateMap;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/FakeActivityLifecycleDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/FakeActivityLifecycleDispatcher$State;", "", "<init>", "(Ljava/lang/String;I)V", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "PAUSED", "STOPPED", "DESTROYED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State PAUSED = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;
        public static final State STOPPED = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{INITIALIZED, CREATED, STARTED, RESUMED, PAUSED, STOPPED, DESTROYED};
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        static {
            INITIALIZED = new State("INITIALIZED", 0);
            CREATED = new State("CREATED", 1);
            STARTED = new State("STARTED", 2);
            RESUMED = new State("RESUMED", 3);
            PAUSED = new State("PAUSED", 4);
            STOPPED = new State("STOPPED", 5);
            DESTROYED = new State("DESTROYED", 6);
            State[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(FakeActivityLifecycleDispatcher r0, LifecycleRegistry r1, Lifecycle.Event r2, Activity r3, State r4, Ref.BooleanRef r5) {
        return dispatchLifecycleEvent$lambda$7(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void b(Function0 r0, CountDownLatch r1) {
        runOnMainSync$lambda$0(r0, r1);
    }

    public FakeActivityLifecycleDispatcher() {
        this.stateMap = new WeakHashMap();
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private final void runOnMainSync(final Function0<Unit> r4) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        r4.invoke();
        return;
    L6:
        final CountDownLatch r0 = new CountDownLatch(1);
        this.mainHandler.post(new q(r4, r0));
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        r0.await();     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L17;
        ThreadMethodProxy.currentThread().interrupt();
        FLogger.a.e(TAG, "runOnMainSync interrupted", r7);
        return;
    L17:
        return;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    private final State stateOf(Activity r2) {
        State r3 = this.stateMap.get(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return State.INITIALIZED;
    }

    public final boolean dispatchDestroy(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        State r0 = stateOf(r5);
        State r1 = State.DESTROYED;
        if (r0 != r1) goto L6;
        FLogger.a.w(TAG, "dispatchDestroy ignored, state=" + r0 + ", activity=" + r5);
        return false;
    L6:
        boolean r2 = dispatchLifecycleEvent(r5, Lifecycle.Event.ON_DESTROY, r1);
        if (r2 == false) goto L9;
        this.stateMap.remove(r5);
    L9:
        return r2;
    }

    public final boolean dispatchPause(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        State r0 = stateOf(r5);
        if (r0 == State.RESUMED) goto L7;
        FLogger.a.w(TAG, "dispatchPause ignored, state=" + r0 + ", activity=" + r5);
        return false;
    L7:
        return dispatchLifecycleEvent(r5, Lifecycle.Event.ON_PAUSE, State.PAUSED);
    }

    public final void dispatchPreDestroy(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        State r0 = stateOf(r5);
        if (r0 != State.DESTROYED) goto L6;
        FLogger.a.w(TAG, "dispatchPreDestroy ignored, state=" + r0 + ", activity=" + r5);
        return;
    }

    public final boolean dispatchResume(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        State r0 = stateOf(r5);
        if (r0 == State.STARTED) goto L7;
        FLogger.a.w(TAG, "dispatchResume ignored, state=" + r0 + ", activity=" + r5);
        return false;
    L7:
        return dispatchLifecycleEvent(r5, Lifecycle.Event.ON_RESUME, State.RESUMED);
    }

    public final boolean dispatchStart(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        State r0 = stateOf(r5);
        if (r0 == State.CREATED) goto L9;
        if (r0 == State.STOPPED) goto L9;
        FLogger.a.w(TAG, "dispatchStart ignored, state=" + r0 + ", activity=" + r5);
        return false;
    L9:
        return dispatchLifecycleEvent(r5, Lifecycle.Event.ON_START, State.STARTED);
    }

    public final boolean dispatchStop(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        State r0 = stateOf(r5);
        if (r0 == State.STARTED) goto L9;
        if (r0 == State.PAUSED) goto L9;
        FLogger.a.w(TAG, "dispatchStop ignored, state=" + r0 + ", activity=" + r5);
        return false;
    L9:
        return dispatchLifecycleEvent(r5, Lifecycle.Event.ON_STOP, State.STOPPED);
    }

    private static final void runOnMainSync$lambda$0(Function0 r0, CountDownLatch r1) {
        r0.invoke();     // Catch: Throwable -> L5
        r1.countDown();
        return;
    L5:
        th = move-exception;
        r1.countDown();
        throw th;
    }

    private final void setState(Activity r2, State r3) {
        this.stateMap.put(r2, r3);
    }

    public final boolean dispatchCreate(Activity r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        State r6 = stateOf(r4);
        if (r6 == State.INITIALIZED) goto L7;
        FLogger.a.w(TAG, "dispatchCreate ignored, state=" + r6 + ", activity=" + r4);
        return false;
    L7:
        return dispatchLifecycleEvent(r4, Lifecycle.Event.ON_CREATE, State.CREATED);
    }

    private final boolean dispatchLifecycleEvent(final Activity r11, final Lifecycle.Event r12, final State r13) {
        LifecycleRegistry r1 = null;
        if ((r11 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r0 = (LifecycleOwner) r11;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        Lifecycle r3 = r0.getLifecycle();
        if ((r3 instanceof LifecycleRegistry) == false) goto L12;
        r1 = (LifecycleRegistry) r3;
    L12:
        final LifecycleRegistry r5 = r1;
        if (r5 != null) goto L16;
        FLogger.a.w(TAG, "dispatchLifecycleEvent skipped, lifecycle=" + r0.getLifecycle().getClass().getName() + ", activity=" + r11);
        return false;
    L16:
        final Ref.BooleanRef r2 = new Ref.BooleanRef();
        runOnMainSync(new p(this, r5, r12, r11, r13, r2));
        return r2.element;
    L5:
        r0 = null;
        goto L7
    }

    private static final Unit dispatchLifecycleEvent$lambda$7(FakeActivityLifecycleDispatcher r1, LifecycleRegistry r2, Lifecycle.Event r3, Activity r4, State r5, Ref.BooleanRef r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        r2.handleLifecycleEvent(r3);     // Catch: Throwable -> L4
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L7:
        if (Result.isSuccess-impl(r7) == false) goto L9;
        Unit r8 = (Unit) r7;
        r1.setState(r4, r5);
        r6.element = true;
    L9:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L13;
        FLogger.a.e(TAG, "dispatchLifecycleEvent failed, event=" + r3 + ", activity=" + r4, r9);
    L13:
        return Unit.INSTANCE;
    L4:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
