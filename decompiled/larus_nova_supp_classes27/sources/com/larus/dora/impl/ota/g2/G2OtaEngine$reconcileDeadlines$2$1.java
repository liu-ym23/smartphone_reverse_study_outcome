package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.G2OtaEngine$reconcileDeadlines$2$1", f = "G2OtaEngine.kt", i = {}, l = {351}, m = "invokeSuspend", n = {}, s = {})
public final class G2OtaEngine$reconcileDeadlines$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $deadline;
    final /* synthetic */ G2OtaEngine$b $key;
    int label;
    final /* synthetic */ G2OtaEngine this$0;

    public G2OtaEngine$reconcileDeadlines$2$1(long r1, G2OtaEngine r3, G2OtaEngine$b r4, Continuation<? super G2OtaEngine$reconcileDeadlines$2$1> r5) {
        this.$deadline = r1;
        this.this$0 = r3;
        this.$key = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new G2OtaEngine$reconcileDeadlines$2$1(this.$deadline, this.this$0, this.$key, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        this.this$0.q(new s.c(this.$key.getType(), this.$key.a(), this.$key.b(), ((Number) G2OtaEngine.b(this.this$0).invoke()).longValue()));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        long r3 = RangesKt.coerceAtLeast(this.$deadline - ((Number) G2OtaEngine.b(this.this$0).invoke()).longValue(), 0);
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L11;
        return r0;
    }
}
