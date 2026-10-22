package com.obric.aiagent.messenger.stub;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$syncPendingWidgetUpdate$2$onSuccess$1", f = "MessageIDLStub.kt", i = {0}, l = {1764}, m = "invokeSuspend", n = {"hasNewerPending"}, s = {"I$0"})
final class MessageIDLStub$syncPendingWidgetUpdate$2$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ boolean $requestStartedInBackground;
    final /* synthetic */ MessageIDLStub$c $requestUpdate;
    final /* synthetic */ boolean $retryingBackgroundFailure;
    int I$0;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$syncPendingWidgetUpdate$2$onSuccess$1(MessageIDLStub r1, String r2, MessageIDLStub$c r3, boolean r4, boolean r5, Continuation<? super MessageIDLStub$syncPendingWidgetUpdate$2$onSuccess$1> r6) {
        this.this$0 = r1;
        this.$localMessageId = r2;
        this.$requestUpdate = r3;
        this.$requestStartedInBackground = r4;
        this.$retryingBackgroundFailure = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MessageIDLStub$syncPendingWidgetUpdate$2$onSuccess$1(this.this$0, this.$localMessageId, this.$requestUpdate, this.$requestStartedInBackground, this.$retryingBackgroundFailure, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r11);
    L47:
        int r4 = r3;
    L48:
        FLogger r12 = FLogger.a;
        StringBuilder r5 = new StringBuilder("syncPendingWidgetUpdate remote success, localMessageId=");
        r5.append(this.$localMessageId);
        r5.append(", messageId=");
        r5.append(this.$requestUpdate.b);
        r5.append(", blockIds=");
        r5.append(this.$requestUpdate.d.keySet());
        r5.append(", revision=");
        r5.append(this.$requestUpdate.e);
        r5.append(", retryingBackgroundFailure=");
        r5.append(this.$retryingBackgroundFailure);
        r5.append(", requestStartedInBackground=");
        r5.append(this.$requestStartedInBackground);
        r5.append(", protectedAfterSuccess=");
        r5.append(this.$requestUpdate.g);
        r5.append(", hasNewerPending=");
        if (r4 == 0) goto L51;
        r2 = true;
    L51:
        r5.append(r2);
        r12.i("IFlowMessageIDLSPI", r5.toString());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        Long r13 = (Long) MessageIDLStub.access$getInFlightWidgetUpdateRevisions$p(this.this$0).get(this.$localMessageId);
        long r6 = this.$requestUpdate.e;
        if (r13 == null) goto L14;
        if (r13.longValue() != r6) goto L14;
        MessageIDLStub.access$getInFlightWidgetUpdateRevisions$p(this.this$0).remove(this.$localMessageId);
        MessageIDLStub$c r14 = (MessageIDLStub$c) MessageIDLStub.access$getPendingWidgetUpdates$p(this.this$0).get(this.$localMessageId);
        if (this.$requestUpdate.h == MessageIDLStub.access$getAppBackgroundGeneration$p(this.this$0).get()) goto L18;
        boolean r7 = true;
    L19:
        if (r14 != null) goto L21;
    L23:
        r4 = 0;
    L24:
        if (r14 != null) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == false) goto L42;
        MessageIDLStub$c r15 = this.$requestUpdate;
        if (r15.g == false) goto L33;
    L35:
        MessageIDLStub.access$rememberConfirmedWidgetUpdate(this.this$0, r15);
    L36:
        MessageIDLStub.access$getPendingWidgetUpdates$p(this.this$0).remove(this.$localMessageId);
        if (AppHost.a.a().isAppBackground() == true) goto L41;
        MessageIDLStub$e r16 = (MessageIDLStub$e) MessageIDLStub.access$getBufferedWidgetSnapshots$p(this.this$0).remove(this.$localMessageId);
        if (r16 == null) goto L41;
        MessageIDLStub.access$restorePendingWidgetUpdates(this.this$0, r16);
    L41:
        MessageIDLStub.notifyForegroundWidgetSyncProgress$default(this.this$0, this.$requestUpdate.c, false, 2, null);
        goto L48
    L33:
        if (this.$requestStartedInBackground == true) goto L35;
        if (r7 == false) goto L36;
    L42:
        if (r14 == null) goto L48;
        MessageIDLStub r17 = this.this$0;
        String r9 = this.$localMessageId;
        this.I$0 = r4;
        this.label = 1;
        if (MessageIDLStub.access$syncPendingWidgetUpdate(r17, r9, this) != r0) goto L46;
        return r0;
    L46:
        r3 = r4;
        goto L47
    L26:
        if (r14.e != this.$requestUpdate.e) goto L28;
        r8 = true;
        goto L29
    L21:
        if (r14.e == this.$requestUpdate.e) goto L23;
        r4 = 1;
        goto L24
    L18:
        r7 = false;
    L14:
        return Unit.INSTANCE;
    }
}
