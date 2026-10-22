package com.larus.uaigc.chat.block.create.vertical;

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
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.vertical.CreationVerticalGroup$toItemViewBinder$1", f = "CreationVerticalGroup.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
public final class CreationVerticalGroup$toItemViewBinder$1 extends SuspendLambda implements Function1<Continuation<? super Message>, Object> {
    final /* synthetic */ cz9.b $this_toItemViewBinder;
    int label;

    public CreationVerticalGroup$toItemViewBinder$1(cz9.b r1, Continuation<? super CreationVerticalGroup$toItemViewBinder$1> r2) {
        this.$this_toItemViewBinder = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new CreationVerticalGroup$toItemViewBinder$1(this.$this_toItemViewBinder, r3);
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
        CreationChatItemClickHelper r5 = CreationChatItemClickHelper.a;
        Message r2 = ((cz9.h) this.$this_toItemViewBinder).e;
        if (r2 == null) goto L11;
        String r3 = r2.getMessageId();
    L12:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        this.label = 1;
        r5.getClass();
        r4 = CreationChatItemClickHelper.m(r3, this);
        if (r4 != r0) goto L17;
        return r0;
    L11:
        r3 = null;
        goto L12
    }
}
