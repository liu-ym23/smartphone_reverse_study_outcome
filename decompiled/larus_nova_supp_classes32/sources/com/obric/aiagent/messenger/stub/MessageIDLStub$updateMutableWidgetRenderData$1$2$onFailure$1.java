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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$updateMutableWidgetRenderData$1$2$onFailure$1", f = "MessageIDLStub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$updateMutableWidgetRenderData$1$2$onFailure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ MessageIDLStub$c $pendingUpdate;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$updateMutableWidgetRenderData$1$2$onFailure$1(MessageIDLStub$c r1, MessageIDLStub r2, String r3, Continuation<? super MessageIDLStub$updateMutableWidgetRenderData$1$2$onFailure$1> r4) {
        this.$pendingUpdate = r1;
        this.this$0 = r2;
        this.$localMessageId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MessageIDLStub$updateMutableWidgetRenderData$1$2$onFailure$1(this.$pendingUpdate, this.this$0, this.$localMessageId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r11);
        MessageIDLStub$c r12 = this.$pendingUpdate;
        if (r12 == null) goto L22;
        MessageIDLStub r0 = this.this$0;
        String r1 = this.$localMessageId;
        if (AppHost.a.a().isAppBackground() == false) goto L20;
        MessageIDLStub$c r2 = (MessageIDLStub$c) MessageIDLStub.access$getPendingWidgetUpdates$p(r0).get(r1);
        if (r2 == null) goto L22;
        if (r2.e != r12.e) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == true) goto L17;
        r2 = null;
    L17:
        MessageIDLStub$c r3 = r2;
        if (r3 == null) goto L22;
        MessageIDLStub.access$getPendingWidgetUpdates$p(r0).put(r1, MessageIDLStub$c.a(r3, null, null, true, 0, 223));
        goto L22
    L13:
        r13 = false;
        goto L14
    L20:
        MessageIDLStub.access$removePendingWidgetUpdateIfCurrent(r0, r12);
    L22:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
