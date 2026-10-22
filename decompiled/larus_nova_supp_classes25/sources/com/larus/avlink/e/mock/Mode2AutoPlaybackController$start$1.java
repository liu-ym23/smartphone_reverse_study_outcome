package com.larus.avlink.e.mock;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.mock.Mode2AutoPlaybackController$start$1", f = "Mode2AutoPlaybackController.kt", i = {}, l = {68, 74, 84}, m = "invokeSuspend", n = {}, s = {})
final class Mode2AutoPlaybackController$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ l this$0;

    public Mode2AutoPlaybackController$start$1(l r1, Continuation<? super Mode2AutoPlaybackController$start$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new Mode2AutoPlaybackController$start$1(null, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L24;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L22 Throwable -> L33
    L28:
        FLogger r7 = FLogger.a;     // Catch: Exception -> L22 Throwable -> L33
        int r8 = l.a;     // Catch: Exception -> L22 Throwable -> L33
        throw null;     // Catch: Exception -> L22 Throwable -> L33
    L6:
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L22 Throwable -> L33
        if (((Boolean) r6).booleanValue() == true) goto L18;
        FLogger r9 = FLogger.a;     // Catch: Exception -> L22 Throwable -> L33
        r9.e("Mode2AutoPlayback", "❌ Failed to play cycle, stopping auto playback");     // Catch: Exception -> L22 Throwable -> L33
        r9.i("Mode2AutoPlayback", "🛑 Mode2 auto playback stopped");     // Catch: Exception -> L22 Throwable -> L33
        int r10 = l.a;
        throw null;
    L18:
        int r11 = l.a;     // Catch: Exception -> L22 Throwable -> L33
        throw null;     // Catch: Exception -> L22 Throwable -> L33
    L8:
        if (r1 != 3) goto L10;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L22 Throwable -> L33
        int r12 = l.a;     // Catch: Exception -> L22 Throwable -> L33
        throw null;     // Catch: Exception -> L22 Throwable -> L33
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L24:
        ResultKt.throwOnFailure(r6);
        FLogger.a.i("Mode2AutoPlayback", "🎬 Mode2 auto playback starting in 3000ms...");     // Catch: Exception -> L22 Throwable -> L33
        this.label = 1;     // Catch: Exception -> L22 Throwable -> L33
        if (DelayKt.delay(3000, this) != r0) goto L28;
        return r0;
    L22:
        e = move-exception;
        FLogger.a.e("Mode2AutoPlayback", "Auto playback error", e);     // Catch: Throwable -> L33
        int r13 = l.a;
        throw null;
    L33:
        int r14 = l.a;
        throw null;
    }
}
