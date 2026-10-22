package com.larus.bmhome.chat.component.bottom.core;

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
import kotlin.jvm.internal.Reflection;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/chat/component/bottom/core/CoreInputComponentState;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$observeOnTakeOverConfigChanged$4", f = "CoreInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputComponent$observeOnTakeOverConfigChanged$4 extends SuspendLambda implements Function2<CoreInputComponentState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    public CoreInputComponent$observeOnTakeOverConfigChanged$4(CoreInputComponent r1, Continuation<? super CoreInputComponent$observeOnTakeOverConfigChanged$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CoreInputComponent$observeOnTakeOverConfigChanged$4 r0 = new CoreInputComponent$observeOnTakeOverConfigChanged$4(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(CoreInputComponentState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoreInputComponentState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        CoreInputComponentState r5 = (CoreInputComponentState) this.L$0;
        FLogger.a.i("CoreInputComponent", Reflection.getOrCreateKotlinClass(a.c(this.this$0).getClass()).getSimpleName() + " takeOverConfig.enableActionbar changed, new value = " + r5.getTakeOverConfig().j);
        CoreInputComponent r6 = this.this$0;
        int r0 = CoreInputComponent.d3;
        r6.F6();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
