package com.larus.uaigc.chat.block.create;

import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1", f = "RichMediaCreationClickServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1 extends SuspendLambda implements Function1<Continuation<? super Message>, Object> {
    final /* synthetic */ Message $message;
    int label;

    public RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1(Message r1, Continuation<? super RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1> r2) {
        this.$message = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new RichMediaCreationClickServiceImpl$imageOperator$1$messageGetter$1(this.$message, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Message> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return this.$message;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
