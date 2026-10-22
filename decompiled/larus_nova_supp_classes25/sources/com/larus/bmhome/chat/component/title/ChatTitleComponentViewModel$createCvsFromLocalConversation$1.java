package com.larus.bmhome.chat.component.title;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import ic8.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponentViewModel$createCvsFromLocalConversation$1", f = "ChatTitleComponentViewModel.kt", i = {}, l = {41, MessageCellStateTransformerType.DEEP_SEARCH_TEXT}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleComponentViewModel$createCvsFromLocalConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $localConversation;
    int label;

    public ChatTitleComponentViewModel$createCvsFromLocalConversation$1(e r1, Continuation<? super ChatTitleComponentViewModel$createCvsFromLocalConversation$1> r2) {
        this.$localConversation = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatTitleComponentViewModel$createCvsFromLocalConversation$1(this.$localConversation, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L31:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        Object r1 = r14;
    L20:
        String r2 = (String) CollectionsKt.firstOrNull((List) r1);
        if (r2 != null) goto L23;
        r2 = "";
    L23:
        String r3 = r2;
        RepoDispatcher.a.getClass();
        ConversationRepo r4 = RepoDispatcher.f;
        Integer r5 = this.$localConversation.v;
        if (r5 == null) goto L26;
        int r6 = r5.intValue();
    L27:
        this.label = 2;
        if (IConversationRepoService$a.a(r4, r3, r6, null, null, false, null, null, null, null, this, 508) != r12) goto L31;
        return r12;
    L26:
        r6 = 2;
        goto L27
    L10:
        ResultKt.throwOnFailure(r14);
        Integer r7 = this.$localConversation.f;
        if (r7 == null) goto L16;
        if (r7.intValue() != 1) goto L16;
        e r8 = this.$localConversation;
        this.label = 1;
        r1 = n.c(r8, this);
        if (r1 != r12) goto L20;
        return r12;
    L16:
        return Unit.INSTANCE;
    }
}
