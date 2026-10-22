package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.entity.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.service.impl.EditMessageService$editMessage$1$msg$1", f = "EditMessageService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EditMessageService$editMessage$1$msg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Message>, Object> {
    final /* synthetic */ String $msgId;
    int label;
    final /* synthetic */ EditMessageService this$0;

    public EditMessageService$editMessage$1$msg$1(EditMessageService r1, String r2, Continuation<? super EditMessageService$editMessage$1$msg$1> r3) {
        this.this$0 = r1;
        this.$msgId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new EditMessageService$editMessage$1$msg$1(this.this$0, this.$msgId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Message> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return this.this$0.c.ta(CollectionsKt.listOf(this.$msgId)).get(this.$msgId);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
