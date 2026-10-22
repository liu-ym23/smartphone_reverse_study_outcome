package com.obric.aiagent.messenger.stub;

import com.larus.common.apphost.AppHost;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$schedulePendingWidgetUpdateAfterForegroundTransition$1", f = "MessageIDLStub.kt", i = {}, l = {1852, 1854}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$schedulePendingWidgetUpdateAfterForegroundTransition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localMessageId;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$schedulePendingWidgetUpdateAfterForegroundTransition$1(MessageIDLStub r1, String r2, Continuation<? super MessageIDLStub$schedulePendingWidgetUpdateAfterForegroundTransition$1> r3) {
        this.this$0 = r1;
        this.$localMessageId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MessageIDLStub$schedulePendingWidgetUpdateAfterForegroundTransition$1(this.this$0, this.$localMessageId, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L14:
        if (AppHost.a.a().isAppBackground() == true) goto L19;
        MessageIDLStub r7 = this.this$0;
        String r2 = this.$localMessageId;
        this.label = 2;
        if (MessageIDLStub.access$syncPendingWidgetUpdate(r7, r2, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L14;
        return r0;
    }
}
