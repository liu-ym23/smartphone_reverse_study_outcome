package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.obric.assistant.component.ObricChatPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1", f = "ObricChatPageStateComponent.kt", i = {}, l = {851}, m = "invokeSuspend", n = {}, s = {})
public final class ObricChatPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $trigger;
    int label;
    final /* synthetic */ ObricChatPageStateComponent this$0;

    public ObricChatPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1(ObricChatPageStateComponent r1, String r2, Continuation<? super ObricChatPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1> r3) {
        this.this$0 = r1;
        this.$trigger = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricChatPageStateComponent$postTryConsumePendingComplexTaskReplyTarget$1$1(this.this$0, this.$trigger, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        ObricChatPageStateComponent r7 = this.this$0;
        com.larus.bmhome.view.b r3 = ObricChatPageStateComponent.v2;
        r7.getClass();
        String r4 = sea.e.b();
        if (r4 != null) goto L14;
    L17:
        if (r2 == true) goto L22;
        String r5 = sea.e.d.get();
        if (r5 != null) goto L21;
        r5 = "scene:conversation_change";
    L21:
        r7.H0 = new laa.w(r4, r5);
        FLogger.a.i("OrionChatPageStateComponent", "updatePendingComplexTaskReplyTarget from sceneHelper, trigger=conversation_change, replyMessageId=".concat(r4));
    L22:
        ObricChatPageStateComponent.Y2(this.this$0, this.$trigger);
        return Unit.INSTANCE;
    L14:
        if (r4.length() == 0) goto L17;
        r2 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L11;
        return r0;
    }
}
