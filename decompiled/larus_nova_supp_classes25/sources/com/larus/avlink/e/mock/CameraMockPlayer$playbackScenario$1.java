package com.larus.avlink.e.mock;

import com.larus.avlink.e.mock.scenario.Scenario;
import com.larus.avlink.e.mock.scenario.TimingStrategy;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.mock.CameraMockPlayer$playbackScenario$1", f = "CameraMockPlayer.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
final class CameraMockPlayer$playbackScenario$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Scenario $scenario;
    int label;
    final /* synthetic */ f this$0;

    public CameraMockPlayer$playbackScenario$1(Scenario r1, f r2, Continuation<? super CameraMockPlayer$playbackScenario$1> r3) {
        this.$scenario = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CameraMockPlayer$playbackScenario$1(this.$scenario, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L13;
        if (r3 != 1) goto L12;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7 Exception -> L9
    L17:
        FLogger.a.i("CameraMockPlayer", "✅ Scenario playback completed: " + this.$scenario.getName());     // Catch: Throwable -> L7 Exception -> L9
        f r9 = this.this$0;
    L21:
        r9.a.set(false);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("CameraMockPlayer", "Starting scenario playback: " + this.$scenario.getName());     // Catch: Throwable -> L7 Exception -> L9
        List r10 = f.a(this.this$0, this.$scenario.getCallbacks(), this.$scenario.getParameterMapping());     // Catch: Throwable -> L7 Exception -> L9
        f r1 = this.this$0;     // Catch: Throwable -> L7 Exception -> L9
        TimingStrategy r4 = this.$scenario.getTimingStrategy();     // Catch: Throwable -> L7 Exception -> L9
        this.label = 1;     // Catch: Throwable -> L7 Exception -> L9
        if (f.b(r1, r10, r4, this) != r2) goto L17;
        return r2;
    L9:
        e = move-exception;
        FLogger.a.e("CameraMockPlayer", "Scenario playback failed", e);     // Catch: Throwable -> L7
        r9 = this.this$0;
    L7:
        th = move-exception;
        this.this$0.a.set(false);
        throw th;
    }
}
