package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.DirectSendFileHelper$getUploadCallback$1$requestPreParse$1", f = "DirectSendFileHelper.kt", i = {}, l = {538}, m = "invokeSuspend", n = {}, s = {})
final class DirectSendFileHelper$getUploadCallback$1$requestPreParse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $localMessageId;
    int label;

    public DirectSendFileHelper$getUploadCallback$1$requestPreParse$1(UplinkFileEntity r1, wc9.e r2, String r3, String r4, Continuation<? super DirectSendFileHelper$getUploadCallback$1$requestPreParse$1> r5) {
        this.$entity = r1;
        this.$conversation = r2;
        this.$botId = r3;
        this.$localMessageId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DirectSendFileHelper$getUploadCallback$1$requestPreParse$1(this.$entity, this.$conversation, this.$botId, this.$localMessageId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        FLogger.a.i("DirectSendFileHelper", "requestMessagePreHandleV2 result:" + ((com.larus.network.http.a) r10));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Lazy<ChatApi> r11 = ChatApi.a;
        ChatApi r12 = ChatApi.a.a();
        UplinkFileEntity r3 = this.$entity;
        wc9.e r2 = this.$conversation;
        String r4 = r2.a;
        String r5 = this.$botId;
        String r6 = r2.B;
        String r7 = this.$localMessageId;
        this.label = 1;
        r12.getClass();
        r10 = ChatApi.b(r3, r4, r5, r6, r7, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
