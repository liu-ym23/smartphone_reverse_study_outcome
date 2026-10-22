package com.larus.uaigc.createpage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService$getMainBotConversationInfo$cvs$1", f = "CreationPageService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationPageService$getMainBotConversationInfo$cvs$1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public CreationPageService$getMainBotConversationInfo$cvs$1(Continuation<? super CreationPageService$getMainBotConversationInfo$cvs$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        CreationPageService$getMainBotConversationInfo$cvs$1 r0 = new CreationPageService$getMainBotConversationInfo$cvs$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((wc9.e) r1, (Continuation) r2);
    }

    public final Object invoke(wc9.e r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        if (((wc9.e) this.L$0) == null) goto L7;
        boolean r3 = true;
    L9:
        return Boxing.boxBoolean(r3);
    L7:
        r3 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
