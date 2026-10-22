package com.obric.aiagent.messenger.stub;

import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
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
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$rememberConfirmedWidgetUpdate$1", f = "MessageIDLStub.kt", i = {}, l = {1578}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$rememberConfirmedWidgetUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $expiresAt;
    final /* synthetic */ MessageIDLStub$c $update;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$rememberConfirmedWidgetUpdate$1(MessageIDLStub r1, MessageIDLStub$c r2, long r3, Continuation<? super MessageIDLStub$rememberConfirmedWidgetUpdate$1> r5) {
        this.this$0 = r1;
        this.$update = r2;
        this.$expiresAt = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MessageIDLStub$rememberConfirmedWidgetUpdate$1(this.this$0, this.$update, this.$expiresAt, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        MessageIDLStub$a r8 = (MessageIDLStub$a) MessageIDLStub.access$getConfirmedWidgetUpdates$p(this.this$0).get(this.$update.a);
        if (r8 == null) goto L23;
        long r3 = this.$expiresAt;
        if (r8.d == r3) goto L17;
        r2 = false;
    L17:
        if (r2 == true) goto L20;
        r8 = null;
    L20:
        if (r8 == null) goto L23;
        MessageIDLStub r9 = this.this$0;
        MessageIDLStub$c r4 = this.$update;
        MessageIDLStub.access$getConfirmedWidgetUpdates$p(r9).remove(r4.a);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(AutoEndConversationTime.AFTER_10_SECONDS, this) != r0) goto L11;
        return r0;
    }
}
