package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.auth.h0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$performBackWhenInvalid$1$localConversation$1", f = "ChatConversationComponent.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$performBackWhenInvalid$1$localConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e>, Object> {
    final /* synthetic */ String $expectedSecUserId;
    int label;

    public ChatConversationComponent$performBackWhenInvalid$1$localConversation$1(String r1, Continuation<? super ChatConversationComponent$performBackWhenInvalid$1$localConversation$1> r2) {
        this.$expectedSecUserId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatConversationComponent$performBackWhenInvalid$1$localConversation$1(this.$expectedSecUserId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super e> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L34:
        return (e) r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        h0 r7 = AuthModelDelegate.b.v();
        if (r7 == null) goto L11;
        String r3 = r7.h();
    L13:
        if (Intrinsics.areEqual(r3, this.$expectedSecUserId) == false) goto L35;
        if (r7 == null) goto L16;
        String r4 = r7.b();
    L17:
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L36;
        if (r7 == null) goto L26;
        String r8 = r7.b();
    L28:
        if (Intrinsics.areEqual(r8, "0") == true) goto L37;
        LocalSubConvHelper r9 = LocalSubConvHelper.a;
        String r10 = this.$expectedSecUserId;
        this.label = 1;
        r6 = r9.c(r10, null, this);
        if (r6 != r0) goto L34;
        return r0;
    L37:
        return null;
    L26:
        r8 = null;
        goto L28
    L36:
        return null;
    L19:
        if (StringsKt.isBlank(r4) == true) goto L22;
        r5 = false;
        goto L23
    L16:
        r4 = null;
        goto L17
    L35:
        return null;
    L11:
        r3 = null;
        goto L13
    }
}
