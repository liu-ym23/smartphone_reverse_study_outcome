package com.larus.tts.impl;

import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader$asyncPlayTtsByQueue$2$pullStateCorrectionJob$1", f = "TtsReader.kt", i = {}, l = {495, 497}, m = "invokeSuspend", n = {}, s = {})
final class TtsReader$asyncPlayTtsByQueue$2$pullStateCorrectionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<Boolean> $isFinish;
    final /* synthetic */ Ref.BooleanRef $suspendEnded;
    final /* synthetic */ TtsReader$b $task;
    int label;
    final /* synthetic */ TtsReader this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PlayStateEnum.values().length];
            r0[PlayStateEnum.PLAY_STATE_FAIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TtsReader$asyncPlayTtsByQueue$2$pullStateCorrectionJob$1(Ref.BooleanRef r1, TtsReader$b r2, TtsReader r3, kotlinx.coroutines.i<? super Boolean> r4, Continuation<? super TtsReader$asyncPlayTtsByQueue$2$pullStateCorrectionJob$1> r5) {
        this.$suspendEnded = r1;
        this.$task = r2;
        this.this$0 = r3;
        this.$isFinish = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new TtsReader$asyncPlayTtsByQueue$2$pullStateCorrectionJob$1(this.$suspendEnded, this.$task, this.this$0, this.$isFinish, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003e -> B:19:0x0041). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
        TtsReader$asyncPlayTtsByQueue$2$pullStateCorrectionJob$1 r10 = this;
    L19:
        IFlowTtsClientService.a.getClass();
        PlayStateEnum r2 = IFlowTtsClientService.a.a().m();
        FLogger.a.i("TtsReader", "queue playing poll state " + r2 + ' ' + r10.$task);
        int r3 = a.a[IFlowTtsClientService.a.a().m().ordinal()];
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L23;
    L15:
        if (r10.$suspendEnded.element == true) goto L23;
        r10.label = 2;
        if (DelayKt.delay(500, r10) != r0) goto L19;
        return r0;
    L23:
        FLogger r4 = FLogger.a;
        r4.i("TtsReader", "[TTS] queue playing poll state end " + r10.$task);
        Ref.BooleanRef r5 = r10.$suspendEnded;
        if (r5.element == true) goto L27;
        r5.element = true;
        r4.i("TtsReader", "[TTS] unknown in queue playing finished without callback " + r10.$task);
        r10.this$0.f.clear();
        kotlinx.coroutines.i<Boolean> r11 = r10.$isFinish;
        Result.Companion r6 = Result.Companion;
        r11.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        r10 = this;
        goto L15
    L10:
        ResultKt.throwOnFailure(r9);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L13;
        return r0;
    }
}
