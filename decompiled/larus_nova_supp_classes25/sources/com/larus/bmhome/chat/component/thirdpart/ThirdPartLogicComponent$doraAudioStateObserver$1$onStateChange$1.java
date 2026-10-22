package com.larus.bmhome.chat.component.thirdpart;

import ce8.c;
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
import ry8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.thirdpart.ThirdPartLogicComponent$doraAudioStateObserver$1$onStateChange$1", f = "ThirdPartLogicComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ThirdPartLogicComponent$doraAudioStateObserver$1$onStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ ThirdPartLogicComponent this$0;

    public ThirdPartLogicComponent$doraAudioStateObserver$1$onStateChange$1(ThirdPartLogicComponent r1, int r2, Continuation<? super ThirdPartLogicComponent$doraAudioStateObserver$1$onStateChange$1> r3) {
        this.this$0 = r1;
        this.$state = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ThirdPartLogicComponent$doraAudioStateObserver$1$onStateChange$1(this.this$0, this.$state, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        if (c.a() == true) goto L7;
        ThirdPartLogicComponent r4 = this.this$0;
        int r0 = ThirdPartLogicComponent.p;
        b r5 = (b) r4.k.getValue();
        if (r5 == null) goto L12;
        r5.lL(this.this$0.F2(this.$state));
    L12:
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
