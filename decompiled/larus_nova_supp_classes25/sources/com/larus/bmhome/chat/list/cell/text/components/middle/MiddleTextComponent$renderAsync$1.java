package com.larus.bmhome.chat.list.cell.text.components.middle;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Lazy;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.middle.MiddleTextComponent$renderAsync$1", f = "MiddleTextComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiddleTextComponent$renderAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h0 $renderParams;
    int label;
    final /* synthetic */ MiddleTextComponent this$0;

    public MiddleTextComponent$renderAsync$1(MiddleTextComponent r1, h0 r2, Continuation<? super MiddleTextComponent$renderAsync$1> r3) {
        this.this$0 = r1;
        this.$renderParams = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MiddleTextComponent$renderAsync$1(this.this$0, this.$renderParams, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        MiddleTextComponent r4 = this.this$0;
        h0 r0 = this.$renderParams;
        Lazy<Message> r1 = MiddleTextComponent.S;
        uvc.b r5 = r4.T(r0, null);
        if (r5 == null) goto L7;
        this.this$0.R(r5, this.$renderParams);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
