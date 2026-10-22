package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.uaigc.createpage.utils.CreationRemoteConversationHelper;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/uaigc/createpage/utils/CreationRemoteConversationHelper$ResolveResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {2317}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CreationRemoteConversationHelper.a>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    int label;

    public MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1(String r1, String r2, Continuation<? super MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1> r3) {
        this.$conversationId = r1;
        this.$botId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1(this.$conversationId, this.$botId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super CreationRemoteConversationHelper.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationRemoteConversationHelper r6 = CreationRemoteConversationHelper.a;
        String r2 = this.$conversationId;
        String r3 = this.$botId;
        this.label = 1;
        r5 = r6.a(r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
