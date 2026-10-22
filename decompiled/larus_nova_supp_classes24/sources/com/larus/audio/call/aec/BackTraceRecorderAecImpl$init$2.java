package com.larus.audio.call.aec;

import android.os.Handler;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.aec.BackTraceRecorderAecImpl$init$2", f = "BackTraceRecorderAecImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BackTraceRecorderAecImpl$init$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BackTraceRecorderAecImpl this$0;

    public BackTraceRecorderAecImpl$init$2(BackTraceRecorderAecImpl r1, Continuation<? super BackTraceRecorderAecImpl$init$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BackTraceRecorderAecImpl$init$2 r0 = new BackTraceRecorderAecImpl$init$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L61;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        f r9 = new f();
        int r1 = com.larus.audio.call.common.a.a;
        v58.a r0 = new v58.a(16000, 12, 2, 6);
        int r2 = com.larus.audio.call.common.c.a;
        com.larus.audio.call.play.b r3 = new com.larus.audio.call.play.b(3, 2560, 16000, 12);
        final BackTraceRecorderAecImpl r4 = this.this$0;
        boolean r5 = false;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
        r9.b(r0, r3, false, new u(r4));     // Catch: Throwable -> L10
        BackTraceRecorderAecImpl.BoundedAudioDataQueue r10 = r4.a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r10, "queue");     // Catch: Throwable -> L10
        r9.d = r10;     // Catch: Throwable -> L10
        if (r9.f == false) goto L9;
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L15;
        c68.b.c("BackTraceRecorderAecImpl", "init failed", r12);
    L15:
        boolean r13 = Result.isSuccess-impl(r11);
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        BackTraceRecorderAecImpl r15 = this.this$0;
        Object r16 = r15.c;
        monitor-enter(r16);
        r15.i = false;     // Catch: Throwable -> L57
        if (r13 == true) goto L20;
    L24:
        r15.h = false;     // Catch: Throwable -> L57
        if (r15.j == false) goto L27;
    L29:
        r15.b.clear();     // Catch: Throwable -> L57
    L30:
        r14.element = true;     // Catch: Throwable -> L57
    L31:
        if (r5 == false) goto L33;
        r15.d();     // Catch: Throwable -> L57
    L33:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L57
        monitor-exit(r16);
        if (this.this$0.l == false) goto L44;
        BackTraceRecorderAecImpl r19 = this.this$0;
        SAMICoreVoiceAssistantAudioData r20 = r19.b.poll();
    L38:
        if (r20 == null) goto L44;
        byte[] r21 = r20.data;
        if (r21 == null) goto L42;
        int r22 = c68.b.a;
        c68.b.e("BackTraceRecorderAecImpl", "dispatch pending raw mic because OBRIC AEC init failed, size=" + r21.length);
        r19.e.get().invoke(r21);
    L42:
        r20 = r19.b.poll();
    L44:
        if (r14.element == false) goto L56;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L50
        Handler r24 = r9.i;     // Catch: Throwable -> L50
        if (r24 == null) goto L48;
        r24.removeCallbacksAndMessages(null);     // Catch: Throwable -> L50
    L48:
        r9.a();     // Catch: Throwable -> L50
        Object r25 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L50
    L52:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L56;
        c68.b.c("BackTraceRecorderAecImpl", "cleanup after init failed", r26);
    L50:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L56:
        return Unit.INSTANCE;
    L27:
        if (t68.a.a.c() == false) goto L29;
        r15.l = true;     // Catch: Throwable -> L57
        goto L30
    L20:
        if (r15.j == true) goto L24;
        r15.l = false;     // Catch: Throwable -> L57
        r15.f.set(r9);     // Catch: Throwable -> L57
        r15.h = true;     // Catch: Throwable -> L57
        if (BackTraceRecorderAecImpl.b(r15) <= 0) goto L31;
        r5 = true;
    L57:
        th = move-exception;
        throw th;
    L9:
        throw new IllegalStateException("AEC model init failed".toString());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L61:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
