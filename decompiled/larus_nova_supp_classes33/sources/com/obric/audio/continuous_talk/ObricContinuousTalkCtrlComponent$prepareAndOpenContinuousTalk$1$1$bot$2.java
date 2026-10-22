package com.obric.audio.continuous_talk;

import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/bot/BotModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$bot$2", f = "ObricContinuousTalkCtrlComponent.kt", i = {}, l = {737}, m = "invokeSuspend", n = {}, s = {})
public final class ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$bot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BotModel>, Object> {
    int label;
    final /* synthetic */ ObricContinuousTalkCtrlComponent this$0;

    public ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$bot$2(ObricContinuousTalkCtrlComponent r1, Continuation<? super ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$bot$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$bot$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BotModel> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ObricContinuousTalkCtrlComponent r5 = this.this$0;
        this.label = 1;
        int r2 = ObricContinuousTalkCtrlComponent.L;
        r4 = r5.D3(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
