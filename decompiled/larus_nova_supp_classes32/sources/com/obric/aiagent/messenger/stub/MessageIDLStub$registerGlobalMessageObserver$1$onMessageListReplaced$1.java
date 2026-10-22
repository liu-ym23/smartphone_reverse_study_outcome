package com.obric.aiagent.messenger.stub;

import com.obric.aivoice.core.data.NameKeys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$registerGlobalMessageObserver$1$onMessageListReplaced$1", f = "MessageIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$registerGlobalMessageObserver$1$onMessageListReplaced$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MessageIDLStub$e> $widgetSnapshots;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$registerGlobalMessageObserver$1$onMessageListReplaced$1(List<MessageIDLStub$e> r1, MessageIDLStub r2, Continuation<? super MessageIDLStub$registerGlobalMessageObserver$1$onMessageListReplaced$1> r3) {
        this.$widgetSnapshots = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MessageIDLStub$registerGlobalMessageObserver$1$onMessageListReplaced$1(this.$widgetSnapshots, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        List<MessageIDLStub$e> r4 = this.$widgetSnapshots;
        MessageIDLStub r0 = this.this$0;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L9;
        MessageIDLStub.access$restoreOrBufferPendingWidgetUpdates(r0, (MessageIDLStub$e) r5.next());
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
