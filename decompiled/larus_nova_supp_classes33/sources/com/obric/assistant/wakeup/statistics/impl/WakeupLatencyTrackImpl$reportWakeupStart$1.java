package com.obric.assistant.wakeup.statistics.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.obric.assistant.t1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.statistics.impl.WakeupLatencyTrackImpl$reportWakeupStart$1", f = "WakeupLatencyTrackImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WakeupLatencyTrackImpl$reportWakeupStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    final /* synthetic */ String $sessionName;
    private /* synthetic */ Object L$0;
    int label;

    public WakeupLatencyTrackImpl$reportWakeupStart$1(String r1, String r2, Continuation<? super WakeupLatencyTrackImpl$reportWakeupStart$1> r3) {
        this.$scene = r1;
        this.$sessionName = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        WakeupLatencyTrackImpl$reportWakeupStart$1 r0 = new WakeupLatencyTrackImpl$reportWakeupStart$1(this.$scene, this.$sessionName, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        String r7 = this.$scene;
        String r1 = this.$sessionName;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L10
        r3.put("scene", r7);     // Catch: Throwable -> L10
        r3.put("session_type", r1);     // Catch: Throwable -> L10
        by7.a r8 = new by7.a("wakeup_start_ipc");     // Catch: Throwable -> L10
        TrackParams r4 = new TrackParams().merge(r3);     // Catch: Throwable -> L10
        r8.a.merge(r4);     // Catch: Throwable -> L10
        r8.b();     // Catch: Throwable -> L10
        if (t1.a.o0() == false) goto L8;
        g.a.monitorEventForSlardar("wakeup_start_ipc", r3, null, null);     // Catch: Throwable -> L10
    L8:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L13:
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
