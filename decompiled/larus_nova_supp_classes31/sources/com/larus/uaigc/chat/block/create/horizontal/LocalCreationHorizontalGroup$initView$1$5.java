package com.larus.uaigc.chat.block.create.horizontal;

import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.markdown.helper.LocalCreationChatItemClickHelper;
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
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.LocalCreationHorizontalGroup$initView$1$5", f = "LocalCreationHorizontalGroup.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
final class LocalCreationHorizontalGroup$initView$1$5 extends SuspendLambda implements Function1<Continuation<? super Message>, Object> {
    int label;
    final /* synthetic */ LocalCreationHorizontalGroup this$0;

    public LocalCreationHorizontalGroup$initView$1$5(LocalCreationHorizontalGroup r1, Continuation<? super LocalCreationHorizontalGroup$initView$1$5> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new LocalCreationHorizontalGroup$initView$1$5(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Message> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L17:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        LocalCreationChatItemClickHelper r5 = LocalCreationChatItemClickHelper.a;
        LocalCreationHorizontalGroup r6 = this.this$0;
        int r2 = LocalCreationHorizontalGroup.w;
        Message r7 = r6.e;
        if (r7 == null) goto L11;
        String r8 = r7.getMessageId();
    L12:
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        this.label = 1;
        r4 = LocalCreationChatItemClickHelper.f(r8, this);
        if (r4 != r0) goto L17;
        return r0;
    L11:
        r8 = null;
        goto L12
    }
}
