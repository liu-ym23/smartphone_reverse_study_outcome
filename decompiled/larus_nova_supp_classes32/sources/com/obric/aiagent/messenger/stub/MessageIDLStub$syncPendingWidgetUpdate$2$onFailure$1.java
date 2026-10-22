package com.obric.aiagent.messenger.stub;

import com.larus.common.apphost.AppHost;
import com.larus.im.callback.IIMError;
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
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$syncPendingWidgetUpdate$2$onFailure$1", f = "MessageIDLStub.kt", i = {0, 0}, l = {1824}, m = "invokeSuspend", n = {"shouldRetryAfterBackgroundTransition", "shouldRetryForegroundWarmup"}, s = {"I$0", "I$1"})
public final class MessageIDLStub$syncPendingWidgetUpdate$2$onFailure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IIMError $error;
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ boolean $requestStartedInBackground;
    final /* synthetic */ MessageIDLStub$c $requestUpdate;
    final /* synthetic */ boolean $retryingBackgroundFailure;
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$syncPendingWidgetUpdate$2$onFailure$1(MessageIDLStub r1, String r2, MessageIDLStub$c r3, IIMError r4, boolean r5, boolean r6, Continuation<? super MessageIDLStub$syncPendingWidgetUpdate$2$onFailure$1> r7) {
        this.this$0 = r1;
        this.$localMessageId = r2;
        this.$requestUpdate = r3;
        this.$error = r4;
        this.$requestStartedInBackground = r5;
        this.$retryingBackgroundFailure = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MessageIDLStub$syncPendingWidgetUpdate$2$onFailure$1(this.this$0, this.$localMessageId, this.$requestUpdate, this.$error, this.$requestStartedInBackground, this.$retryingBackgroundFailure, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r3 = this.I$1;
        int r4 = this.I$0;
        ResultKt.throwOnFailure(r14);
    L54:
        int r11 = r3;
    L55:
        FLogger r15 = FLogger.a;
        StringBuilder r5 = new StringBuilder("syncPendingWidgetUpdate remote failed, localMessageId=");
        r5.append(this.$localMessageId);
        r5.append(", messageId=");
        r5.append(this.$requestUpdate.b);
        r5.append(", blockIds=");
        r5.append(this.$requestUpdate.d.keySet());
        r5.append(", revision=");
        r5.append(this.$requestUpdate.e);
        r5.append(", requestStartedInBackground=");
        r5.append(this.$requestStartedInBackground);
        r5.append(", retryAfterBackground=");
        if (r4 == 0) goto L58;
        boolean r6 = true;
    L59:
        r5.append(r6);
        r5.append(", retryForegroundWarmup=");
        if (r11 == 0) goto L62;
        r2 = true;
    L62:
        r5.append(r2);
        r5.append(", error=");
        r5.append(this.$error);
        r15.e("IFlowMessageIDLSPI", r5.toString());
        return Unit.INSTANCE;
    L58:
        r6 = false;
        goto L59
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        Long r16 = (Long) MessageIDLStub.access$getInFlightWidgetUpdateRevisions$p(this.this$0).get(this.$localMessageId);
        long r7 = this.$requestUpdate.e;
        if (r16 == null) goto L14;
        if (r16.longValue() != r7) goto L14;
        MessageIDLStub.access$getInFlightWidgetUpdateRevisions$p(this.this$0).remove(this.$localMessageId);
        MessageIDLStub$c r8 = (MessageIDLStub$c) MessageIDLStub.access$getPendingWidgetUpdates$p(this.this$0).get(this.$localMessageId);
        boolean r17 = AppHost.a.a().isAppBackground();
        if (this.$requestUpdate.h == MessageIDLStub.access$getAppBackgroundGeneration$p(this.this$0).get()) goto L18;
        boolean r9 = true;
    L20:
        if (this.$error.getCode() != (-1001)) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == true) goto L25;
    L29:
        r4 = 0;
    L30:
        if (r10 == true) goto L32;
    L35:
        r11 = 0;
    L36:
        if (r8 != null) goto L38;
    L40:
        boolean r12 = false;
    L41:
        if (r12 == false) goto L49;
        if (r4 == 0) goto L46;
        MessageIDLStub.access$getPendingWidgetUpdates$p(this.this$0).put(this.$localMessageId, MessageIDLStub$c.a(r8, null, null, true, 0, 223));
        if (r17 == true) goto L55;
        MessageIDLStub.access$schedulePendingWidgetUpdateAfterForegroundTransition(this.this$0, this.$localMessageId);
        goto L55
    L46:
        if (r11 == 0) goto L48;
        MessageIDLStub.access$getPendingWidgetUpdates$p(this.this$0).put(this.$localMessageId, MessageIDLStub$c.a(r8, null, null, false, 0, 223));
        MessageIDLStub.access$schedulePendingWidgetUpdateAfterForegroundTransition(this.this$0, this.$localMessageId);
        goto L55
    L48:
        MessageIDLStub.access$getPendingWidgetUpdates$p(this.this$0).remove(this.$localMessageId);
        MessageIDLStub.access$getBufferedWidgetSnapshots$p(this.this$0).remove(this.$localMessageId);
        MessageIDLStub.access$notifyForegroundWidgetSyncProgress(this.this$0, this.$requestUpdate.c, true);
        goto L55
    L49:
        if (r8 == null) goto L55;
        MessageIDLStub r18 = this.this$0;
        String r13 = this.$localMessageId;
        this.I$0 = r4;
        this.I$1 = r11;
        this.label = 1;
        if (MessageIDLStub.access$syncPendingWidgetUpdate(r18, r13, this) != r0) goto L53;
        return r0;
    L53:
        r3 = r11;
        goto L54
    L38:
        if (r8.e != this.$requestUpdate.e) goto L40;
        r12 = true;
        goto L41
    L32:
        if (this.$retryingBackgroundFailure == false) goto L35;
        if (r4 != 0) goto L35;
        r11 = 1;
        goto L36
    L25:
        if (this.$requestStartedInBackground == true) goto L28;
        if (r17 == true) goto L28;
        if (r9 == false) goto L29;
    L28:
        r4 = 1;
        goto L30
    L22:
        r10 = false;
        goto L23
    L18:
        r9 = false;
    L14:
        return Unit.INSTANCE;
    }
}
