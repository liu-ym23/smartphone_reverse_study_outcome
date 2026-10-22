package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricChatPageStateComponent$onResume$2$1", f = "ObricChatPageStateComponent.kt", i = {}, l = {773}, m = "invokeSuspend", n = {}, s = {})
public final class ObricChatPageStateComponent$onResume$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricChatPageStateComponent this$0;

    public ObricChatPageStateComponent$onResume$2$1(ObricChatPageStateComponent r1, Continuation<? super ObricChatPageStateComponent$onResume$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricChatPageStateComponent$onResume$2$1(this.this$0, r3);
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
    L11:
        ObricFloatChatPageData.a r5 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r2 = this.this$0.getPageState();
        r5.getClass();
        if (ObricFloatChatPageData.a.c(r2) == false) goto L15;
        FLogger.a.i("OrionChatPageStateComponent", "onResume but is unknown, delay 100, still unknown, change to full");
        laa.d.a.a(this.this$0, 0.0f, false, 3);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L11;
        return r0;
    }
}
