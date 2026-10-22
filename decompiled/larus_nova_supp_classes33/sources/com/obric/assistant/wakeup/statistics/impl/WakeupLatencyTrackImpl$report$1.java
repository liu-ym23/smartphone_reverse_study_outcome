package com.obric.assistant.wakeup.statistics.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
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
@DebugMetadata(c = "com.obric.assistant.wakeup.statistics.impl.WakeupLatencyTrackImpl$report$1", f = "WakeupLatencyTrackImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WakeupLatencyTrackImpl$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $ipcToMain;
    final /* synthetic */ long $launchToRecord;
    final /* synthetic */ long $mainToLaunch;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $sessionType;
    final /* synthetic */ long $total;
    private /* synthetic */ Object L$0;
    int label;

    public WakeupLatencyTrackImpl$report$1(String r1, String r2, long r3, long r5, long r7, long r9, Continuation<? super WakeupLatencyTrackImpl$report$1> r11) {
        this.$scene = r1;
        this.$sessionType = r2;
        this.$ipcToMain = r3;
        this.$mainToLaunch = r5;
        this.$launchToRecord = r7;
        this.$total = r9;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        WakeupLatencyTrackImpl$report$1 r12 = new WakeupLatencyTrackImpl$report$1(this.$scene, this.$sessionType, this.$ipcToMain, this.$mainToLaunch, this.$launchToRecord, this.$total, r15);
        r12.L$0 = r14;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        String r15 = this.$scene;
        String r1 = this.$sessionType;
        long r2 = this.$ipcToMain;
        long r4 = this.$mainToLaunch;
        long r6 = this.$launchToRecord;
        long r8 = this.$total;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L14
        r11.put("scene", r15);     // Catch: Throwable -> L14
        r11.put("session_type", r1);     // Catch: Throwable -> L14
        r11.put("ipc_to_main_duration", r2);     // Catch: Throwable -> L14
        r11.put("main_to_launch_duration", r4);     // Catch: Throwable -> L14
        r11.put("launch_to_record_duration", r6);     // Catch: Throwable -> L14
        r11.put("total_duration", r8);     // Catch: Throwable -> L14
        if (ObricAsrDelegate.b.m() == false) goto L8;
        int r3 = 1;
    L9:
        r11.put("enable_backtrace", r3);     // Catch: Throwable -> L14
        TrackParams r16 = new TrackParams().merge(r11);     // Catch: Throwable -> L14
        by7.a r5 = new by7.a("wakeup_to_record_duration");     // Catch: Throwable -> L14
        r5.a.merge(r16);     // Catch: Throwable -> L14
        r5.b();     // Catch: Throwable -> L14
        if (t1.a.o0() == false) goto L12;
        g.a.monitorEventForSlardar("wakeup_to_record_duration", r11, null, null);     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L17:
        return Unit.INSTANCE;
    L8:
        r3 = 0;
    L14:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
