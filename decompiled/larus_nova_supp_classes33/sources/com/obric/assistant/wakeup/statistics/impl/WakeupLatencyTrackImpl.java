package com.obric.assistant.wakeup.statistics.impl;

import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0002J8\u0010#\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0002J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/assistant/wakeup/statistics/impl/WakeupLatencyTrackImpl;", "Lcom/obric/assistant/spi/wakeup/IWakeupLatencyTrackService;", "<init>", "()V", "scene", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "sessionType", "tIpc", "Ljava/util/concurrent/atomic/AtomicLong;", "tMain", "tLaunch", "activateToRecordTrace", "Lcom/obric/assistant/wakeup/statistics/impl/WakeupLatencyTrackImpl$ActivateToRecordTrace;", "markActivationStart", "", "activationStartUptimeMillis", "", "launchMethod", "mainProcessReady", "", "markIpcStart", "sessionName", "ipcStartTime", "markMainProcessReceived", "timestamp", "markAssistantLaunchStart", "markRecordStart", "reportActivateToRecord", "recordStartUptimeMillis", "resetInternal", "duration", "start", "end", "report", "ipcToMain", "mainToLaunch", "launchToRecord", "total", "reportWakeupStart", "reportAttemptDropped", "prevScene", "prevSession", "stage", "Companion", "ActivateToRecordTrace", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupLatencyTrackImpl implements IWakeupLatencyTrackService {
    public final AtomicReference<String> a;
    public final AtomicReference<String> b;
    public final AtomicLong c;
    public final AtomicLong d;
    public final AtomicLong e;
    public final AtomicReference<a> f;

    public static final class a {
        public final long a;
        public final String b;
        public final boolean c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r2 = 1231;
        L7:
            return r1 + r2;
        L5:
            r2 = 1237;
            goto L7
        }

        public final String toString() {
            return "ActivateToRecordTrace(activationStartUptimeMillis=" + this.a + ", launchMethod=" + this.b + ", mainProcessReady=" + this.c + ')';
        }

        public a(long r2, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "launchMethod");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class b {
    }

    static {
    }

    public static long f(long r3, long r5) {
        if (r3 > 0) goto L5;
    L9:
        return -1;
    L5:
        if (r5 <= 0) goto L9;
        long r6 = r5 - r3;
        if (r6 < 0) goto L9;
        return r6;
    }

    public WakeupLatencyTrackImpl() {
        this.a = new AtomicReference("");
        this.b = new AtomicReference("");
        this.c = new AtomicLong(0);
        this.d = new AtomicLong(0);
        this.e = new AtomicLong(0);
        this.f = new AtomicReference(null);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void b(long r6) {
        if (this.c.get() > 0) goto L5;
        return;
    L5:
        this.d.compareAndSet(0, r6);
    }

    /* JADX WARN: Failed to calculate best type for var: r7v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v0 ??, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v0 ??, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v1 ??, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v0 java.util.concurrent.atomic.AtomicLong, new type: java.util.concurrent.atomic.AtomicLong
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void c(long r28) {
        long r3 = SystemClock.uptimeMillis();
        a r10 = this.f.getAndSet(null);
        if (r10 == null) goto L13;
        long r8 = f(r10.a, r3);
        long r15 = -1;
        if (r8 != (-1)) goto L9;
        FLogger.a.w("WakeupLatencyTrackImpl", "skip activate_to_record: start=" + r10.a + ", end=" + r3);
        goto L13
    L9:
        long r4 = iba.a.a(AppHost.a.getApplication());
        if (r4 <= 0) goto L12;
        r15 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r4, 0);
    L12:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new WakeupLatencyTrackImpl$reportActivateToRecord$1(r8, r10, r15, null), 3, null);
    L13:
        long r7 = this.c.getAndSet(r11);
        if (r7 > r11) goto L16;
        return;
    L16:
        long r9 = this.d.getAndSet(r11);
        long r5 = this.e.getAndSet(0);
        long r11 = f(r7, r9);
        long r12 = f(r9, r5);
        long r6 = f(r5, r28);
        long r13 = f(r7, r28);
        FLogger.a.i("WakeupLatencyTrackImpl", "markRecordStart t3=" + r28 + "; durations ipc->main=" + r11 + " main->launch=" + r12 + " launch->record=" + r6 + " total=" + r13 + ' ');
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new WakeupLatencyTrackImpl$report$1(this.a.getAndSet(""), this.b.getAndSet(""), r11, r12, r6, r13, null), 3, null);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void e(long r6) {
        if (this.c.get() > 0) goto L5;
        return;
    L5:
        this.e.compareAndSet(0, r6);
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void a(long r4, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "launchMethod");
        if (r4 > 0) goto L5;
        return;
    L5:
        this.f.set(new a(r4, r6, r7));
    }

    @Override // com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService
    public final void d(String r20, String r21, long r22) {
        Intrinsics.checkNotNullParameter(r20, "scene");
        Intrinsics.checkNotNullParameter(r21, "sessionName");
        if (r22 > 0) goto L7;
        FLogger.a.w("WakeupLatencyTrackImpl", "markIpcStart got invalid ipcStartTime=" + r22 + ", skip sample");
        this.c.set(0);
        this.d.set(0);
        this.e.set(0);
        this.a.set("");
        this.b.set("");
        return;
    L7:
        if (this.c.get() <= 0) goto L12;
        if (Intrinsics.areEqual(this.a.get(), r20) == false) goto L12;
        return;
    L12:
        if (this.c.get() <= 0) goto L21;
        String r7 = this.a.get();
        String r8 = this.b.get();
        if (this.e.get() <= 0) goto L17;
        String r11 = "record_pending";
    L20:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new WakeupLatencyTrackImpl$reportAttemptDropped$1(r7, r8, r11, null), 3, null);
        goto L21
    L17:
        if (this.d.get() <= 0) goto L19;
        r11 = "launch";
        goto L20
    L19:
        r11 = "main";
    L21:
        this.a.set(r20);
        this.b.set(r21);
        this.c.set(r22);
        this.d.set(0);
        this.e.set(0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new WakeupLatencyTrackImpl$reportWakeupStart$1(r20, r21, null), 3, null);
    }
}
