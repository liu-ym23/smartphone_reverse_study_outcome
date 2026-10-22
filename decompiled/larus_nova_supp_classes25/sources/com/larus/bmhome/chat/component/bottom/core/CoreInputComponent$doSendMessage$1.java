package com.larus.bmhome.chat.component.bottom.core;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$doSendMessage$1", f = "CoreInputComponent.kt", i = {}, l = {3437}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputComponent$doSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $sendClickTimestamp;
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    public CoreInputComponent$doSendMessage$1(CoreInputComponent r1, long r2, Continuation<? super CoreInputComponent$doSendMessage$1> r4) {
        this.this$0 = r1;
        this.$sendClickTimestamp = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CoreInputComponent$doSendMessage$1(this.this$0, this.$sendClickTimestamp, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r3 = r20;
    L11:
        String r4 = (String) r3;
        if (r4 == null) goto L14;
        CoreInputComponent r5 = this.this$0;
        int r6 = CoreInputComponent.d3;
        CoreInputAbility r7 = r5.k4();
        boolean r17 = this.this$0.yP();
        CoreInputAbility.t(r7, r4, false, null, null, null, null, null, null, null, null, true, this.$sendClickTimestamp, r17, 1016);
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        CoreInputComponent r8 = this.this$0;
        this.label = 1;
        r3 = r8.KD(this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
