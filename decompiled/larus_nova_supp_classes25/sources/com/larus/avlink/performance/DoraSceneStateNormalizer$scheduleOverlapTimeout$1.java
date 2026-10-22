package com.larus.avlink.performance;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@DebugMetadata(c = "com.larus.avlink.performance.DoraSceneStateNormalizer$scheduleOverlapTimeout$1", f = "DoraSceneStateNormalizer.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSceneStateNormalizer$scheduleOverlapTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraSceneStateNormalizer this$0;

    public DoraSceneStateNormalizer$scheduleOverlapTimeout$1(DoraSceneStateNormalizer r1, Continuation<? super DoraSceneStateNormalizer$scheduleOverlapTimeout$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraSceneStateNormalizer$scheduleOverlapTimeout$1(this.this$0, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        DoraSceneStateNormalizer r7 = this.this$0;
        int r2 = DoraSceneStateNormalizer.g;
        monitor-enter(r7);
    L26:
        th = move-exception;
        throw th;
    L14:
        if (r7.e == null) goto L22;
        if (r7.f.size() <= 1) goto L22;
        r7.e();     // Catch: Throwable -> L26
        monitor-exit(r7);
    L25:
        return Unit.INSTANCE;
    L22:
        r7.d = null;     // Catch: Throwable -> L26
        monitor-exit(r7);
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
