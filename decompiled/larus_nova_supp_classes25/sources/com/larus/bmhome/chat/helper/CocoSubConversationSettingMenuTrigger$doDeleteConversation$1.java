package com.larus.bmhome.chat.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.conversation.ConversationDeleteMode;
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
@DebugMetadata(c = "com.larus.bmhome.chat.helper.CocoSubConversationSettingMenuTrigger$doDeleteConversation$1", f = "CocoSubConversationHelper.kt", i = {}, l = {597}, m = "invokeSuspend", n = {}, s = {})
public final class CocoSubConversationSettingMenuTrigger$doDeleteConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    int label;

    public CocoSubConversationSettingMenuTrigger$doDeleteConversation$1(String r1, Continuation<? super CocoSubConversationSettingMenuTrigger$doDeleteConversation$1> r2) {
        this.$cvsId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CocoSubConversationSettingMenuTrigger$doDeleteConversation$1(this.$cvsId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        RepoDispatcher.a.getClass();
        ConversationRepo r6 = RepoDispatcher.f;
        String r2 = this.$cvsId;
        ConversationDeleteMode r3 = ConversationDeleteMode.DeleteMode_RealDelete;
        this.label = 1;
        if (r6.l(r2, r3, null, this) != r0) goto L12;
        return r0;
    }
}
