package com.larus.bmhome.social.userchat.model;

import com.larus.im.bean.message.Message;
import com.larus.platform.service.i3;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.TouristModeMessageSyncModel$onSendOrUpdateMsg$1", f = "TouristModeMessageSyncModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TouristModeMessageSyncModel$onSendOrUpdateMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ g0 this$0;

    public TouristModeMessageSyncModel$onSendOrUpdateMsg$1(Message r1, g0 r2, Continuation<? super TouristModeMessageSyncModel$onSendOrUpdateMsg$1> r3) {
        this.$msg = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TouristModeMessageSyncModel$onSendOrUpdateMsg$1(this.$msg, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r8);
        FLogger r9 = FLogger.a;
        r9.i("TouristModeMessageSyncModel", "onSendOrUpdateMsg isMessageLimited " + i3.a.a());
        long r2 = this.$msg.getLocalIndex();
        g0 r0 = this.this$0;
        if (r2 < r0.g) goto L17;
        r0.g = this.$msg.getLocalIndex();
        if (this.$msg.getMessageStatusLocal() == 12) goto L9;
    L15:
        Result.box-impl(g0.b(this.this$0, null));
        goto L17
    L9:
        if (Intrinsics.areEqual(this.$msg.getSenderId(), TriggerSendLoading.NO_LOADING) == false) goto L15;
        if (g0.a(this.this$0, this.$msg) == false) goto L15;
        r9.i("TouristModeMessageSyncModel", "onSendMessage failed");
        g0 r10 = this.this$0;
        String r1 = r10.c;
        if (r1 == null) goto L17;
        g0.b(r10, new MessageWithBotId(r1, this.$msg));
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
