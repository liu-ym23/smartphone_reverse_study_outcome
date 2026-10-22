package com.obric.aiagent.messenger.stub;

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
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$appBackgroundListener$1$onAppForeground$1", f = "MessageIDLStub.kt", i = {}, l = {242, 244, 245}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$appBackgroundListener$1$onAppForeground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$appBackgroundListener$1$onAppForeground$1(MessageIDLStub r1, Continuation<? super MessageIDLStub$appBackgroundListener$1$onAppForeground$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessageIDLStub$appBackgroundListener$1$onAppForeground$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r8);
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L18:
        MessageIDLStub r9 = this.this$0;
        this.label = 3;
        if (MessageIDLStub.flushPendingWidgetUpdates$default(r9, null, this, 1, null) != r0) goto L22;
        return r0;
    L11:
        ResultKt.throwOnFailure(r8);
    L15:
        this.label = 2;
        if (DelayKt.delay(500, this) != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        MessageIDLStub.access$consumeBufferedWidgetSnapshots(this.this$0);
        MessageIDLStub r10 = this.this$0;
        this.label = 1;
        if (MessageIDLStub.access$restorePendingWidgetUpdatesFromLocal(r10, this) != r0) goto L15;
        return r0;
    }
}
