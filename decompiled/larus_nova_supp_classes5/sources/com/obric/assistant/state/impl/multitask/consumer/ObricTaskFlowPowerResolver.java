package com.obric.assistant.state.impl.multitask.consumer;

import aha.a0;
import aha.c0;
import aha.e0;
import aha.h0;
import aha.n;
import aha.v;
import cha.b;
import com.larus.bmhome.utils.i;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockStateType;
import com.obric.assistant.state.impl.v2.core.ObricStateDispatcher;
import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import com.obric.assistant.state.impl.v2.utils.f;
import com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager;
import com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jha.h;
import jha.p;
import jha.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0014\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0016\u0010*\u001a\u0004\u0018\u00010+2\n\u0010,\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0002R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006/"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/consumer/ObricTaskFlowPowerResolver;", "Lcom/obric/assistant/state/multitask/core/TaskFlowCriticalResolver;", "<init>", "()V", "activeTaskIdsByReason", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/state/api/v2/core/AssistantAliveReason;", "", "", "activeTaskIdsLock", "", "resolverScope", "Lkotlinx/coroutines/CoroutineScope;", "latestNetworkKeepAliveState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricNetworkKeepAliveLockStateType;", "latestAssistantAliveState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricAssistantAliveLockStateType;", "clearStaleCacheJob", "Lkotlinx/coroutines/Job;", "powerLockStateObserver", "com/obric/assistant/state/impl/multitask/consumer/ObricTaskFlowPowerResolver$powerLockStateObserver$1", "Lcom/obric/assistant/state/impl/multitask/consumer/ObricTaskFlowPowerResolver$powerLockStateObserver$1;", "resolve", "", "id", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "taskStateEvent", "Lcom/obric/assistant/state/multitask/core/TaskStateEvent;", "(Lcom/obric/assistant/state/multitask/core/TaskFlowId;Lcom/obric/assistant/state/multitask/core/TaskStateEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTaskBecameActive", "reason", "taskKey", "onTaskBecameInactive", "scheduleClearStaleCacheIfPowerLocksInactive", "source", "state", "isPowerLocksInactiveLocked", "", "acquireLocksForReason", "releaseLocksForReason", "mapToWakeLockReason", "Lcom/obric/assistant/state/impl/v2/wakelock/ObricWakelockManager$LockReason;", "mapTaskStateToReason", "Lcom/obric/assistant/state/impl/multitask/consumer/ObricTaskFlowPowerResolver$Mapping;", "event", "Companion", "Mapping", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTaskFlowPowerResolver implements TaskFlowCriticalResolver {
    public final ConcurrentHashMap<AssistantAliveReason, Set<String>> a;
    public final Object b;
    public final CoroutineScope c;
    public ObricNetworkKeepAliveLockStateType d;
    public ObricAssistantAliveLockStateType e;
    public Job f;

    public static final class d implements b {
        public final /* synthetic */ ObricTaskFlowPowerResolver a;

        public d(ObricTaskFlowPowerResolver r1) {
            this.a = r1;
        }

        public final void a(ObricAssistantAliveLockState r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            ObricTaskFlowPowerResolver r0 = this.a;
            Object r1 = r0.b;
            monitor-enter(r1);
            r0.e = r4.getCurrentState();     // Catch: Throwable -> L8
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r1);
            ObricTaskFlowPowerResolver.b(this.a, "assistant", r4.getCurrentState().name());
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public final void d(ObricNetworkKeepAliveLockState r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            ObricTaskFlowPowerResolver r0 = this.a;
            Object r1 = r0.b;
            monitor-enter(r1);
            r0.d = r4.getCurrentState();     // Catch: Throwable -> L8
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r1);
            ObricTaskFlowPowerResolver.b(this.a, "network", r4.getCurrentState().name());
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public ObricTaskFlowPowerResolver() {
        this.a = new ConcurrentHashMap();
        this.b = new Object();
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.d = ObricNetworkKeepAliveLockStateType.IDLE;
        this.e = ObricAssistantAliveLockStateType.IDLE;
        d r0 = new d(this);
        ObricStateDispatcher r1 = ObricStateDispatcher.a;
        Intrinsics.checkNotNullParameter(r0, "observer");
        ObricStateDispatcher.d.add(r0);
    }

    public static void c(AssistantAliveReason r2) {
        ObricWakelockManager.LockReason r0 = d(r2);
        if (r0 == null) goto L6;
        ObricWakelockManager.a.getClass();
        ObricWakelockManager.a(r0);
    L6:
        switch(c.a[r2.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            default: goto L7;
        };
    L7:
        CoroutineScope r1 = ObricPowerManager.a;
        ObricPowerManager.c(r2);
        return;
    L8:
        CoroutineScope r3 = ObricPowerManager.a;
        ObricPowerManager.c(r2);
        return;
    L9:
        CoroutineScope r4 = ObricPowerManager.a;
        ObricPowerManager.d(r2);
        ObricPowerManager.c(r2);
        return;
    L10:
        CoroutineScope r5 = ObricPowerManager.a;
        ObricPowerManager.d(r2);
    }

    public static ObricWakelockManager.LockReason d(AssistantAliveReason r1) {
        int r2 = c.a[r1.ordinal()];
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L19;
        if (r2 == 6) goto L18;
        if (r2 == 9) goto L17;
        return null;
    L17:
        return ObricWakelockManager.LockReason.CLICK_TALK;
    L18:
        return ObricWakelockManager.LockReason.TTS_PLAYING;
    L19:
        return ObricWakelockManager.LockReason.WAKEUP_IN_PROGRESS;
    L15:
        return ObricWakelockManager.LockReason.SEND_MSG;
    }

    public static void f(AssistantAliveReason r2) {
        ObricWakelockManager.LockReason r0 = d(r2);
        if (r0 == null) goto L6;
        ObricWakelockManager.d(ObricWakelockManager.a, r0);
    L6:
        switch(c.a[r2.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            default: goto L7;
        };
    L7:
        ObricPowerManager.f(r2);
        return;
    L8:
        ObricPowerManager.f(r2);
        return;
    L9:
        CoroutineScope r1 = ObricPowerManager.a;
        ObricPowerManager.g(r2);
        ObricPowerManager.f(r2);
        return;
    L10:
        CoroutineScope r3 = ObricPowerManager.a;
        ObricPowerManager.g(r2);
    }

    public final Unit a(jha.g r7, q r8) {
        if (f.a == false) goto L5;
        FLogger r0 = FLogger.a;
        r0.i("ObricTaskFlowPowerResolver", "resolve, id=" + r7 + ",event=" + r8);
        p r9 = r8.a();
        b r2 = null;
        if ((r9 instanceof p) == true) goto L10;
        r9 = null;
    L10:
        if (r9 == null) goto L65;
        e0 r10 = r9.b;
        h r1 = r10.a();
        boolean r4 = true;
        boolean r3 = !(r1 instanceof h.c);
        if ((r10 instanceof n) == true) goto L65;
        if ((r10 instanceof aha.q) == false) goto L19;
        r2 = new b(AssistantAliveReason.SEND_MSG, r3);
        goto L65
    L19:
        if ((r10 instanceof aha.d) == false) goto L22;
        r2 = new b(AssistantAliveReason.COMPLEX_TASK_IN_PROGRESS, r1 instanceof h.a);
        goto L65
    L22:
        if ((r10 instanceof a0) == false) goto L25;
        r2 = new b(AssistantAliveReason.REALTIME_CALL_IN_PROGRESS, r3);
        goto L65
    L25:
        if ((r10 instanceof h0) == false) goto L28;
        r2 = new b(AssistantAliveReason.CLICK_TALK_IN_PROGRESS, r3);
        goto L65
    L28:
        if ((r10 instanceof aha.b) == false) goto L31;
        r2 = new b(AssistantAliveReason.AI_NOTE_IN_PROGRESS, r3);
        goto L65
    L31:
        if ((r10 instanceof v) == false) goto L34;
        r2 = new b(AssistantAliveReason.WAKEUP_IN_PROGRESS, r3);
        goto L65
    L34:
        if ((r10 instanceof aha.h) == false) goto L37;
        r2 = new b(AssistantAliveReason.ALARM_TTS_IN_PROGRESS, r3);
        goto L65
    L37:
        if ((r10 instanceof aha.g) == false) goto L40;
        r2 = new b(AssistantAliveReason.AIGC_GENERATION_IN_PROGRESS, r3);
        goto L65
    L40:
        if ((r10 instanceof c0) == false) goto L43;
        r2 = new b(AssistantAliveReason.SELF_UPDATE_DOWNLOAD, r3);
        goto L65
    L43:
        if ((r10 instanceof e0) == false) goto L65;
        e0 r11 = r10;
        String r5 = r11.f();
        String r12 = r11.e();
        if (r12 != null) goto L48;
        r12 = "";
    L48:
        if (r5 != null) goto L50;
    L53:
        boolean r6 = true;
    L54:
        if (r6 == false) goto L56;
    L63:
        AssistantAliveReason r13 = AssistantAliveReason.GLOBAL_AUDIO_IN_PROGRESS;
    L64:
        r2 = new b(r13, r3);
        goto L65
    L56:
        if (r12.length() > 0) goto L59;
        r4 = false;
    L59:
        if (r4 == false) goto L63;
        if (i.g(r12) == false) goto L63;
        r13 = AssistantAliveReason.MSG_TTS_IN_PROGRESS;
        goto L64
    L50:
        if (r5.length() == 0) goto L53;
        r6 = false;
    L65:
        if (r2 == null) goto L67;
        AssistantAliveReason r14 = r2.a;
        String r15 = r7.toString();
        r0.i("ObricTaskFlowPowerResolver", "resolve, active=" + r2.b + ",reason=" + r14 + ",id=" + r7);
        if (r2.b == false) goto L71;
        e(r14, r15);
    L85:
        return Unit.INSTANCE;
    L71:
        Object r16 = this.b;
        monitor-enter(r16);
        Set<String> r17 = this.a.get(r14);     // Catch: Throwable -> L86
        if (r17 != null) goto L78;
        monitor-exit(r16);
        goto L85
    L78:
        if (r17.remove(r15) == true) goto L80;
    L82:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L86
        monitor-exit(r16);
        goto L85
    L80:
        if (r17.isEmpty() == false) goto L82;
        this.a.remove(r14);     // Catch: Throwable -> L86
        r0.i("ObricTaskFlowPowerResolver", "reason=" + r14 + " deactivated, last inactive task=" + r15);     // Catch: Throwable -> L86
        f(r14);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        throw th;
    L67:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final void e(AssistantAliveReason r7, String r8) {
        Object r2 = this.b;
        monitor-enter(r2);
        Job r3 = this.f;     // Catch: Throwable -> L20
        if (r3 == null) goto L7;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);     // Catch: Throwable -> L20
    L7:
        this.f = null;     // Catch: Throwable -> L20
        ConcurrentHashMap<AssistantAliveReason, Set<String>> r4 = this.a;     // Catch: Throwable -> L20
        Set<String> r5 = r4.get(r7);     // Catch: Throwable -> L20
        if (r5 != null) goto L13;
        r5 = new LinkedHashSet();     // Catch: Throwable -> L20
        Set<String> r6 = r4.putIfAbsent(r7, r5);     // Catch: Throwable -> L20
        if (r6 == null) goto L13;
        r5 = r6;
    L13:
        Set<String> r9 = r5;     // Catch: Throwable -> L20
        boolean r10 = r9.isEmpty();     // Catch: Throwable -> L20
        r9.add(r8);     // Catch: Throwable -> L20
        if (r10 == false) goto L16;
        FLogger.a.i("ObricTaskFlowPowerResolver", "reason=" + r7 + " activated, first active task=" + r8);     // Catch: Throwable -> L20
    L17:
        c(r7);     // Catch: Throwable -> L20
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r2);
        return;
    L16:
        FLogger.a.i("ObricTaskFlowPowerResolver", "reason=" + r7 + " refresh active task=" + r8);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static final void b(ObricTaskFlowPowerResolver r7, String r8, String r9) {
        Object r0 = r7.b;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (r7.d != ObricNetworkKeepAliveLockStateType.ACQUIRED) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
    L22:
        monitor-exit(r0);
        return;
    L12:
        if (r7.a.isEmpty() == true) goto L22;
        Job r2 = r7.f;     // Catch: Throwable -> L20
        if (r2 == null) goto L17;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Throwable -> L20
    L17:
        Job r10 = BuildersKt.launch$default(r7.c, null, CoroutineStart.LAZY, new scheduleClearStaleCacheIfPowerLocksInactive.jobToStart.1.1(r7, r8, r9, null), 1, null);     // Catch: Throwable -> L20
        r7.f = r10;     // Catch: Throwable -> L20
        monitor-exit(r0);
        r10.start();
        return;
    L7:
        if (r7.e == ObricAssistantAliveLockStateType.ACQUIRED) goto L9;
        r1 = true;
        goto L10
    }
}
