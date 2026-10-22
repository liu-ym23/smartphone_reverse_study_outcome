package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatRepo", f = "ChatRepo.kt", i = {}, l = {385, 389}, m = "getLatestSubtitleMessage", n = {}, s = {})
final class ChatRepo$getLatestSubtitleMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatRepo this$0;

    public ChatRepo$getLatestSubtitleMessage$1(ChatRepo r1, Continuation<? super ChatRepo$getLatestSubtitleMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        ChatRepo r12 = this.this$0;
        r12.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        ChatRepo$getLatestSubtitleMessage$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r9 = true;
        if (r3 == 0) goto L14;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L12;
        ResultKt.throwOnFailure(r2);
    L32:
        return r2;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r2);
    L17:
        wc9.e r4 = (wc9.e) r2;
        if (r4 == null) goto L20;
        String r5 = r4.n;
    L21:
        if (r5 != null) goto L23;
    L26:
        if (r9 == true) goto L33;
        r0.label = 2;
        r2 = r12.E1(r5, r0);
        if (r2 != r7) goto L32;
        return r7;
    L33:
        return null;
    L23:
        if (StringsKt.isBlank(r5) == true) goto L26;
        r9 = false;
        goto L26
    L20:
        r5 = null;
        goto L21
    L14:
        ResultKt.throwOnFailure(r2);
        RepoDispatcher.a.getClass();
        ConversationRepo r6 = RepoDispatcher.f;
        r0.label = 1;
        r2 = IConversationRepoService$a.c(r6, null, false, null, r0, 6);
        if (r2 != r7) goto L17;
        return r7;
    L5:
        r0 = new ChatRepo$getLatestSubtitleMessage$1(r12, this);
        goto L6
    }
}
