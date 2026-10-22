package com.obric.aiagent.messenger.stub;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$awaitWidgetUpdatesBeforeConversationPull$2", f = "MessageIDLStub.kt", i = {0}, l = {299, 305}, m = "invokeSuspend", n = {"waiter"}, s = {"L$0"})
public final class MessageIDLStub$awaitWidgetUpdatesBeforeConversationPull$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<Boolean> $completion;
    final /* synthetic */ String $conversationId;
    Object L$0;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$awaitWidgetUpdatesBeforeConversationPull$2(MessageIDLStub r1, String r2, CompletableDeferred<Boolean> r3, Continuation<? super MessageIDLStub$awaitWidgetUpdatesBeforeConversationPull$2> r4) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$completion = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageIDLStub$awaitWidgetUpdatesBeforeConversationPull$2(this.this$0, this.$conversationId, this.$completion, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L24:
        MessageIDLStub.notifyForegroundWidgetSyncProgress$default(this.this$0, this.$conversationId, false, 2, null);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        MessageIDLStub$b r2 = (MessageIDLStub$b) this.L$0;
        ResultKt.throwOnFailure(r9);
    L18:
        if (AppHost.a.a().isAppBackground() == false) goto L21;
        MessageIDLStub.access$getForegroundWidgetSyncWaiters$p(this.this$0).remove(r2);
        this.$completion.complete(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    L21:
        MessageIDLStub r10 = this.this$0;
        String r3 = this.$conversationId;
        this.L$0 = null;
        this.label = 2;
        if (MessageIDLStub.access$flushPendingWidgetUpdates(r10, r3, this) != r0) goto L24;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        if (MessageIDLStub.access$hasPendingWidgetUpdates(this.this$0, this.$conversationId) == true) goto L14;
        this.$completion.complete(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L14:
        r2 = new MessageIDLStub$b(this.$conversationId, this.$completion);
        MessageIDLStub.access$getForegroundWidgetSyncWaiters$p(this.this$0).add(r2);
        FLogger.a.i("IFlowMessageIDLSPI", "awaitWidgetUpdatesBeforeConversationPull start, conversationId=" + this.$conversationId);
        this.L$0 = r2;
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L18;
        return r0;
    }
}
