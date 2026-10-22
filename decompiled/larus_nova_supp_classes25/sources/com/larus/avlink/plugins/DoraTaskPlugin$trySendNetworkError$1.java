package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraTaskPlugin$trySendNetworkError$1", f = "DoraTaskPlugin.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
final class DoraTaskPlugin$trySendNetworkError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $code;
    int label;

    public DoraTaskPlugin$trySendNetworkError$1(int r1, Continuation<? super DoraTaskPlugin$trySendNetworkError$1> r2) {
        this.$code = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraTaskPlugin$trySendNetworkError$1(this.$code, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Map<Function1<Boolean, Unit>, k4> r5 = x2.a;
        int r6 = this.$code;
        this.label = 1;
        if (x2.l(3, r6, false, this) != r0) goto L12;
        return r0;
    }
}
