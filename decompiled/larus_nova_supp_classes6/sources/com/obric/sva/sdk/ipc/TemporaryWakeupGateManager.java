package com.obric.sva.sdk.ipc;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.EnumMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003&'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000fJ\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J&\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager;", "", "<init>", "()V", "TAG", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "states", "Ljava/util/EnumMap;", "Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$Gate;", "Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$State;", "ownerToken", "Landroid/os/IBinder;", "ownerGeneration", "", "ownerDeath", "Landroid/os/IBinder$DeathRecipient;", "wakewordBusyCallback", "Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$WakewordBusyFailOpenCallback;", "setWakewordBusyFailOpenCallback", "", "callback", "onOwnerTokenAvailable", "token", "generation", "onOwnerBinderDied", "updateGate", "gate", "enabled", "", "reason", "sweepIfExpired", "sweepGateIfExpired", "failOpenAll", "failOpen", "applyGateToGlobals", "isEnabled", "Gate", "WakewordBusyFailOpenCallback", "State", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class TemporaryWakeupGateManager {
    public static final TemporaryWakeupGateManager INSTANCE = null;
    private static final String TAG = "TemporaryWakeupGateManager";
    private static final ReentrantLock lock = null;
    private static volatile IBinder.DeathRecipient ownerDeath;
    private static volatile long ownerGeneration;
    private static volatile IBinder ownerToken;
    private static final EnumMap<Gate, State> states = null;
    private static volatile WakewordBusyFailOpenCallback wakewordBusyCallback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$Gate;", "", "ttlMs", "", "<init>", "(Ljava/lang/String;IJ)V", "getTtlMs", "()J", "DORA_SUPPRESS", "ENROLL_IGNORE", "WAKEWORD_SOURCE_BUSY", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final enum Gate extends Enum<Gate> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Gate[] $VALUES = null;
        public static final Gate DORA_SUPPRESS = null;
        public static final Gate ENROLL_IGNORE = null;
        public static final Gate WAKEWORD_SOURCE_BUSY = null;
        private final long ttlMs;

        private static final /* synthetic */ Gate[] $values() {
            return new Gate[]{DORA_SUPPRESS, ENROLL_IGNORE, WAKEWORD_SOURCE_BUSY};
        }

        public static EnumEntries<Gate> getEntries() {
            return $ENTRIES;
        }

        static {
            DORA_SUPPRESS = new Gate("DORA_SUPPRESS", 0, 60000);
            ENROLL_IGNORE = new Gate("ENROLL_IGNORE", 1, 30000);
            WAKEWORD_SOURCE_BUSY = new Gate("WAKEWORD_SOURCE_BUSY", 2, 15000);
            Gate[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static Gate[] values() {
            return (Gate[]) $VALUES.clone();
        }

        public final long getTtlMs() {
            return this.ttlMs;
        }

        public static Gate valueOf(String r1) {
            return (Gate) r27.a.a(Gate.class, r1);
        }

        private Gate(String r1, int r2, long r3) {
            super(r1, r2);
            this.ttlMs = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$State;", "", "enabled", "", "setAtElapsedMs", "", "generation", "reason", "", "<init>", "(ZJJLjava/lang/String;)V", "getEnabled", "()Z", "getSetAtElapsedMs", "()J", "getGeneration", "getReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class State {
        private final boolean enabled;
        private final long generation;
        private final String reason;
        private final long setAtElapsedMs;

        public static /* synthetic */ State copy$default(State r4, boolean r5, long r6, long r8, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.enabled;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.setAtElapsedMs;
        L8:
            long r0 = r6;
            if ((r11 & 4) == 0) goto L11;
            r8 = r4.generation;
        L11:
            long r2 = r8;
            if ((r11 & 8) == 0) goto L14;
            r10 = r4.reason;
        L14:
            boolean r7 = r5;
            return r4.copy(r7, r0, r2, r10);
        }

        public final boolean component1() {
            return this.enabled;
        }

        public final long component2() {
            return this.setAtElapsedMs;
        }

        public final long component3() {
            return this.generation;
        }

        public final String component4() {
            return this.reason;
        }

        public final State copy(boolean r9, long r10, long r12, String r14) {
            Intrinsics.checkNotNullParameter(r14, "reason");
            return new State(r9, r10, r12, r14);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof State) == true) goto L8;
            return false;
        L8:
            State r9 = (State) r8;
            if (this.enabled == r9.enabled) goto L12;
            return false;
        L12:
            if (this.setAtElapsedMs == r9.setAtElapsedMs) goto L15;
            return false;
        L15:
            if (this.generation == r9.generation) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.reason, r9.reason) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            if (this.enabled == false) goto L5;
            int r0 = 1231;
        L6:
            long r1 = this.setAtElapsedMs;
            int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.generation;
            return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.reason.hashCode();
        L5:
            r0 = 1237;
            goto L6
        }

        public String toString() {
            return "State(enabled=" + this.enabled + ", setAtElapsedMs=" + this.setAtElapsedMs + ", generation=" + this.generation + ", reason=" + this.reason + ')';
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final long getGeneration() {
            return this.generation;
        }

        public final String getReason() {
            return this.reason;
        }

        public final long getSetAtElapsedMs() {
            return this.setAtElapsedMs;
        }

        public State(boolean r2, long r3, long r5, String r7) {
            Intrinsics.checkNotNullParameter(r7, "reason");
            this.enabled = r2;
            this.setAtElapsedMs = r3;
            this.generation = r5;
            this.reason = r7;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/sva/sdk/ipc/TemporaryWakeupGateManager$WakewordBusyFailOpenCallback;", "", "onWakewordBusyFailOpen", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public interface WakewordBusyFailOpenCallback {
        void onWakewordBusyFailOpen();
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Gate.values().length];
            r0[Gate.DORA_SUPPRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Gate.ENROLL_IGNORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Gate.WAKEWORD_SOURCE_BUSY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private TemporaryWakeupGateManager() {
    }

    static {
        INSTANCE = new TemporaryWakeupGateManager();
        lock = new ReentrantLock();
        states = new EnumMap(Gate.class);
    }

    public final boolean sweepIfExpired() {
        IBinder r0 = ownerToken;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isBinderAlive() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        return false;
    L10:
        LogUtils.w(TAG, "sweepIfExpired owner binder not alive, fail-open all gates", new Object[0]);
        return failOpenAll("sweep_binder_dead");
    L7:
        r2 = false;
        goto L8
    }

    private final boolean failOpenAll(String r7) {
        Gate[] r0 = Gate.values();
        int r1 = r0.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L10;
        Gate r4 = r0[r2];
        if (INSTANCE.failOpen(r4, r7) == false) goto L9;
        if (r4 != Gate.WAKEWORD_SOURCE_BUSY) goto L9;
        r3 = true;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r3;
    }

    public final boolean isEnabled(Gate r4) {
        Intrinsics.checkNotNullParameter(r4, "gate");
        ReentrantLock r0 = lock;
        r0.lock();
        State r5 = states.get(r4);     // Catch: Throwable -> L11
        boolean r1 = false;
        if (r5 == null) goto L9;
        if (r5.getEnabled() != true) goto L9;
        r1 = true;
    L9:
        r0.unlock();
        return r1;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void setWakewordBusyFailOpenCallback(WakewordBusyFailOpenCallback r1) {
        wakewordBusyCallback = r1;
    }

    public final boolean sweepGateIfExpired(Gate r8) {
        Intrinsics.checkNotNullParameter(r8, "gate");
        IBinder r0 = ownerToken;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isBinderAlive() != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        return false;
    L10:
        ReentrantLock r1 = lock;
        r1.lock();
        State r3 = states.get(r8);     // Catch: Throwable -> L34
        r1.unlock();
        if (r3 != null) goto L15;
    L33:
        return false;
    L15:
        if (r3.getEnabled() == false) goto L33;
        if ((SystemClock.elapsedRealtime() - r3.getSetAtElapsedMs()) > r8.getTtlMs()) goto L20;
        return false;
    L20:
        boolean r4 = failOpen(r8, "ttl_expired");
        if (r4 == true) goto L23;
    L32:
        return r4;
    L23:
        if (r8 != Gate.WAKEWORD_SOURCE_BUSY) goto L32;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L30
        WakewordBusyFailOpenCallback r10 = wakewordBusyCallback;     // Catch: Throwable -> L30
        if (r10 == null) goto L27;
        r10.onWakewordBusyFailOpen();     // Catch: Throwable -> L30
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        Result.constructor-impl(r11);     // Catch: Throwable -> L30
        goto L32
    L27:
        r11 = null;
    L30:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        th = move-exception;
        r1.unlock();
        throw th;
    L7:
        r2 = false;
        goto L8
    }

    private final void applyGateToGlobals(Gate r2, boolean r3) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r4 != 1) goto L5;
        Global.sWakeupSupress = r3;
        return;
    L5:
        if (r4 != 2) goto L7;
        Global.sEnrollIgnore = r3;
        return;
    L7:
        if (r4 != 3) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final boolean failOpen(Gate r17, String r18) {
        ReentrantLock r3 = lock;
        r3.lock();
        EnumMap<Gate, State> r4 = states;     // Catch: Throwable -> L15
        State r5 = r4.get(r17);     // Catch: Throwable -> L15
        if (r5 == null) goto L8;
        boolean r8 = true;
        if (r5.getEnabled() != true) goto L8;
    L9:
        if (r8 == false) goto L11;
        r4.put(r17, new State(false, SystemClock.elapsedRealtime(), r5.getGeneration(), "fail_open_" + r18));     // Catch: Throwable -> L15
        INSTANCE.applyGateToGlobals(r17, false);     // Catch: Throwable -> L15
    L11:
        r3.unlock();
        if (r8 == false) goto L14;
        TrackerTelemetry.INSTANCE.onGateFailOpen(r17.name(), r18);
    L14:
        return r8;
    L8:
        r8 = false;
    L15:
        th = move-exception;
        r3.unlock();
        throw th;
    }

    private final void onOwnerBinderDied(IBinder r6, long r7) {
        ReentrantLock r0 = lock;
        r0.lock();
    L25:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (ownerToken != r6) goto L9;
        if (ownerGeneration != r7) goto L9;
        boolean r8 = true;
    L10:
        r0.unlock();
        if (r8 == true) goto L14;
        LogUtils.i(TAG, "owner binder died ignored generation=" + r7, new Object[0]);
        return;
    L14:
        LogUtils.w(TAG, "owner binder died generation=" + r7 + ", fail-open all gates", new Object[0]);
        if (failOpenAll("binder_died") == false) goto L32;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L22
        WakewordBusyFailOpenCallback r10 = wakewordBusyCallback;     // Catch: Throwable -> L22
        if (r10 == null) goto L19;
        r10.onWakewordBusyFailOpen();     // Catch: Throwable -> L22
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L20:
        Result.constructor-impl(r11);     // Catch: Throwable -> L22
        return;
    L19:
        r11 = null;
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L32:
        return;
    L9:
        r8 = false;
        goto L10
    }

    public final void onOwnerTokenAvailable(final IBinder r8, final long r9) {
        Intrinsics.checkNotNullParameter(r8, "token");
        ReentrantLock r2 = lock;
        r2.lock();
        IBinder r3 = ownerToken;     // Catch: Throwable -> L27
        if (r3 != r8) goto L7;
        r2.unlock();
        return;
    L7:
        IBinder.DeathRecipient r4 = ownerDeath;     // Catch: Throwable -> L27
        if (r3 == null) goto L15;
        if (r4 == null) goto L15;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        Result.constructor-impl(Boolean.valueOf(r3.unlinkToDeath(r4, 0)));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L27
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
    L15:
        ownerToken = r8;     // Catch: Throwable -> L27
        ownerGeneration = r9;     // Catch: Throwable -> L27
        IBinder.DeathRecipient r7 = new TemporaryWakeupGateManager$onOwnerTokenAvailable$1$recipient$1(r8, r9);     // Catch: Throwable -> L27
        ownerDeath = r7;     // Catch: Throwable -> L27
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L18
        r8.linkToDeath(r7, 0);     // Catch: Throwable -> L18
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r12 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L27
        if (r12 == null) goto L24;
        LogUtils.e(TAG, "linkToDeath ownerToken failed: " + r12.getMessage(), new Object[0]);     // Catch: Throwable -> L27
    L24:
        LogUtils.i(TAG, "onOwnerTokenAvailable generation=" + r9, new Object[0]);     // Catch: Throwable -> L27
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r2.unlock();
        return;
    L18:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L27
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r2.unlock();
        throw th;
    }

    public static final /* synthetic */ void access$onOwnerBinderDied(TemporaryWakeupGateManager r0, IBinder r1, long r2) {
        r0.onOwnerBinderDied(r1, r2);
    }

    public final void updateGate(Gate r11, boolean r12, long r13, String r15) {
        Intrinsics.checkNotNullParameter(r11, "gate");
        Intrinsics.checkNotNullParameter(r15, "reason");
        ReentrantLock r1 = lock;
        r1.lock();
    L15:
        th = move-exception;
        r1.unlock();
        throw th;
    L4:
        if (ownerGeneration > 0) goto L6;
    L12:
        states.put(r11, new State(r12, SystemClock.elapsedRealtime(), r13, r15));     // Catch: Throwable -> L15
        INSTANCE.applyGateToGlobals(r11, r12);     // Catch: Throwable -> L15
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r1.unlock();
        TrackerTelemetry.INSTANCE.onGateUpdate(r11.name(), r12, r13);
        return;
    L6:
        if (r13 <= 0) goto L12;
        if (r13 == ownerGeneration) goto L12;
        LogUtils.w(TAG, "updateGate ignored generation mismatch gate=" + r11 + " enabled=" + r12 + " generation=" + r13 + " current=" + ownerGeneration, new Object[0]);     // Catch: Throwable -> L15
        r1.unlock();
    }
}
