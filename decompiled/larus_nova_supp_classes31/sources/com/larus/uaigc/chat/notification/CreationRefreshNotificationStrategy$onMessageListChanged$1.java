package com.larus.uaigc.chat.notification;

import com.larus.im.bean.message.Message;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.notification.CreationRefreshNotificationStrategy$onMessageListChanged$1", f = "CreationRefreshNotificationStrategy.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class CreationRefreshNotificationStrategy$onMessageListChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Message> $lastMsgList;
    Object L$0;
    int label;

    public CreationRefreshNotificationStrategy$onMessageListChanged$1(List<Message> r1, Continuation<? super CreationRefreshNotificationStrategy$onMessageListChanged$1> r2) {
        this.$lastMsgList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationRefreshNotificationStrategy$onMessageListChanged$1(this.$lastMsgList, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r6);
    L11:
        if (r2.hasNext() == false) goto L18;
        Message r3 = (Message) r2.next();
        if (com.larus.bmhome.chat.bean.d.a0(r3) == false) goto L11;
        CreationRefreshNotificationStrategy r4 = CreationRefreshNotificationStrategy.a;
        this.L$0 = r2;
        this.label = 1;
        if (CreationRefreshNotificationStrategy.a(r4, r3, this) != r0) goto L11;
        return r0;
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        r2 = this.$lastMsgList.iterator();
        goto L11
    }
}
