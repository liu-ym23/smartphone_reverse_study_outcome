package com.larus.avlink.e.model.session_memory;

import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.model.session_memory.SessionMemoryMode$startTimerInternal$1", f = "SessionMemoryMode.kt", i = {0, 1}, l = {63, 65}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
public final class SessionMemoryMode$startTimerInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $interval;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SessionMemoryMode this$0;

    public SessionMemoryMode$startTimerInternal$1(SessionMemoryMode r1, int r2, Continuation<? super SessionMemoryMode$startTimerInternal$1> r3) {
        this.this$0 = r1;
        this.$interval = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SessionMemoryMode$startTimerInternal$1 r0 = new SessionMemoryMode$startTimerInternal$1(this.this$0, this.$interval, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:18:0x0037). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 != 0) goto L32;
        ResultKt.throwOnFailure(r11);
        ?? r2 = (CoroutineScope) this.L$0;
    L17:
        SessionMemoryMode$startTimerInternal$1 r12 = this;
    L19:
        if (CoroutineScopeKt.isActive(r2) == false) goto L31;
        long r5 = ((Number) r12.this$0.f.getValue()).longValue() * ((long) r12.$interval);     // Catch: Exception -> L26 CancellationException -> L29
        r12.L$0 = r2;     // Catch: Exception -> L26 CancellationException -> L29
        r12.label = 1;     // Catch: Exception -> L26 CancellationException -> L29
    L21:
        if (DelayKt.delay(r5, r12) != r0) goto L23;
        return r0;
    L23:
        SessionMemoryMode r6 = r12.this$0;     // Catch: Exception -> L26 CancellationException -> L29
        r12.L$0 = r2;     // Catch: Exception -> L26 CancellationException -> L29
        r12.label = 2;     // Catch: Exception -> L26 CancellationException -> L29
        if (SessionMemoryMode.a(r6, r12) != r0) goto L19;
        return r0;
    L26:
        e = move-exception;
        Object r9 = r0;
        SessionMemoryMode$startTimerInternal$1 r3 = r12;
        ?? r7 = r2;
        n1.c("SessionMemoryMode", "An error occurred in timer loop.", e);
        r12 = r3;
        r0 = r9;
        r2 = r7;
    L31:
        return Unit.INSTANCE;
    L32:
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L14 CancellationException -> L29
        r2 = r4;
        goto L17
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L14 CancellationException -> L29
        r12 = this;
    L14:
        e = move-exception;
        n1.c("SessionMemoryMode", "An error occurred in timer loop.", e);
        r12 = this;
        r0 = r0;
        r2 = r1;
    L29:
        n1.d("SessionMemoryMode", "Timer job was cancelled.");
        goto L31
    }
}
