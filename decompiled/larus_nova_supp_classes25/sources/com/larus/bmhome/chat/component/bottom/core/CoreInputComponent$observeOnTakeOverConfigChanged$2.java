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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager$Config;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$observeOnTakeOverConfigChanged$2", f = "CoreInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputComponent$observeOnTakeOverConfigChanged$2 extends SuspendLambda implements Function2<z8.a, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    public CoreInputComponent$observeOnTakeOverConfigChanged$2(CoreInputComponent r1, Continuation<? super CoreInputComponent$observeOnTakeOverConfigChanged$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CoreInputComponent$observeOnTakeOverConfigChanged$2(this.this$0, r3);
    }

    public final Object invoke(z8.a r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((z8.a) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        CoreInputComponent r3 = this.this$0;
        int r0 = CoreInputComponent.d3;
        r3.k4().N();
        this.this$0.lj();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
