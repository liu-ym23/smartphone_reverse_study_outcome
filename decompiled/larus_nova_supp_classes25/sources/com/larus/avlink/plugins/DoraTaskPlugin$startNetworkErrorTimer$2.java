package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraTaskPlugin$startNetworkErrorTimer$2", f = "DoraTaskPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraTaskPlugin$startNetworkErrorTimer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Boolean> $isTimerValid;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ DoraTaskPlugin this$0;

    public DoraTaskPlugin$startNetworkErrorTimer$2(DoraTaskPlugin r1, String r2, Function0<Boolean> r3, Continuation<? super DoraTaskPlugin$startNetworkErrorTimer$2> r4) {
        this.this$0 = r1;
        this.$source = r2;
        this.$isTimerValid = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraTaskPlugin$startNetworkErrorTimer$2(this.this$0, this.$source, this.$isTimerValid, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r4);
        com.larus.avlink.n1.d(this.this$0.f, "startNetworkErrorTimer " + this.$source + ", firstCallRetry=" + this.this$0.m.c());
        if (((Boolean) this.$isTimerValid.invoke()).booleanValue() == true) goto L9;
        return Unit.INSTANCE;
    L9:
        if (this.this$0.m.c() == false) goto L18;
        this.this$0.m.d(false);
        if (this.this$0.l3().a0() == true) goto L18;
        DoraTaskPlugin r5 = this.this$0;
        if (r5.o == false) goto L18;
        if (v88.a.f(Boxing.boxInt(((n4) r5.getContext()).q())) == true) goto L18;
        final DoraTaskPlugin r6 = this.this$0;
        final Function0<Boolean> r0 = this.$isTimerValid;
        final String r1 = this.$source;
        r6.n3(15000, new m3(r6, r0, r1));
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
