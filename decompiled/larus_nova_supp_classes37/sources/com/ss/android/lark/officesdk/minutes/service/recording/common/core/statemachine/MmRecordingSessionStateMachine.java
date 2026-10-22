package com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingSessionStateMachine {
    public final RecordingSessionType a;
    public final String b;
    public final CoroutineScope c;
    public final StateFlowImpl d;
    public final b1 e;
    public final StateMachine<c, a, b> f;

    public MmRecordingSessionStateMachine(RecordingSessionType r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionType");
        this.a = r5;
        this.b = "MmRecordingSessionSM_" + hashCode();
        Lazy r6 = MMCoroutines.a;
        if (com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.a.b != null) goto L5;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.a.b = com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.a.a.newSerialHighPriorityThreadPool("mm_high_serial");
    L5:
        ExecutorService r7 = com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.a.b;
        if (r7 == null) goto L14;
        this.c = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(r7).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        c.C0037c r8 = c.C0037c.c;
        StateFlowImpl r9 = j1.a(TuplesKt.to(r8, r8));
        this.d = r9;
        this.e = e.b(r9);
        int r10 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r11 = new MmRecordingSessionStateMachine$stateMachine$1(this);
        Intrinsics.checkNotNullParameter(r11, "init");
        StateMachine.GraphBuilder r3 = new StateMachine.GraphBuilder(null);
        r11.invoke(r3);
        STATE r1 = r3.a;
        if (r1 == 0) goto L12;
        this.f = new StateMachine(new StateMachine.b(r1, MapsKt.toMap(r3.b), CollectionsKt.toList(r3.c)));
        return;
    L12:
        throw new IllegalArgumentException("Required value was null.".toString());
    L14:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
