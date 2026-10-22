package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
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
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$restorePendingWidgetUpdates$2$onSuccess$1", f = "MessageIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MessageIDLStub$restorePendingWidgetUpdates$2$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $latestRenderDataByBlockId;
    final /* synthetic */ MessageIDLStub$d $protection;
    final /* synthetic */ MessageIDLStub$e $resultSnapshot;
    final /* synthetic */ MessageIDLStub$e $snapshot;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$restorePendingWidgetUpdates$2$onSuccess$1(MessageIDLStub r1, MessageIDLStub$e r2, MessageIDLStub$e r3, Map<String, String> r4, MessageIDLStub$d r5, Continuation<? super MessageIDLStub$restorePendingWidgetUpdates$2$onSuccess$1> r6) {
        this.this$0 = r1;
        this.$snapshot = r2;
        this.$resultSnapshot = r3;
        this.$latestRenderDataByBlockId = r4;
        this.$protection = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MessageIDLStub$restorePendingWidgetUpdates$2$onSuccess$1(this.this$0, this.$snapshot, this.$resultSnapshot, this.$latestRenderDataByBlockId, this.$protection, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        MessageIDLStub.access$getRestoringPendingWidgetMessageIds$p(this.this$0).remove(this.$snapshot.b);
        MessageIDLStub$e r4 = this.$resultSnapshot;
        if (r4 == null) goto L7;
        MessageIDLStub.access$restorePendingWidgetUpdates(this.this$0, r4);
    L7:
        FLogger.a.i("IFlowMessageIDLSPI", "restorePendingWidgetUpdates local success, messageId=" + this.$snapshot.b + ", blockIds=" + this.$latestRenderDataByBlockId.keySet() + ", protection=" + this.$protection.d);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
