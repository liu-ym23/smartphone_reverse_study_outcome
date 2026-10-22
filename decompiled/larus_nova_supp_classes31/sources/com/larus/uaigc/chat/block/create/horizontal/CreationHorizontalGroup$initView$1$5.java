package com.larus.uaigc.chat.block.create.horizontal;

import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.CreationHorizontalGroup$initView$1$5", f = "CreationHorizontalGroup.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
final class CreationHorizontalGroup$initView$1$5 extends SuspendLambda implements Function1<Continuation<? super Message>, Object> {
    int label;
    final /* synthetic */ CreationHorizontalGroup this$0;

    public CreationHorizontalGroup$initView$1$5(CreationHorizontalGroup r1, Continuation<? super CreationHorizontalGroup$initView$1$5> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new CreationHorizontalGroup$initView$1$5(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Message> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L17:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationChatItemClickHelper r6 = CreationChatItemClickHelper.a;
        CreationHorizontalGroup r2 = this.this$0;
        int r3 = CreationHorizontalGroup.w;
        Message r4 = r2.e;
        if (r4 == null) goto L11;
        String r7 = r4.getMessageId();
    L12:
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        this.label = 1;
        r6.getClass();
        r5 = CreationChatItemClickHelper.m(r7, this);
        if (r5 != r0) goto L17;
        return r0;
    L11:
        r7 = null;
        goto L12
    }
}
