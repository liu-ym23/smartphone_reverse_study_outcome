package com.larus.bmhome.chat.helper;

import android.os.Bundle;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ChatRouterHelper$getSubConversationFragmentBundle$2", f = "ChatRouterHelper.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
final class ChatRouterHelper$getSubConversationFragmentBundle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Bundle $chatBundle;
    final /* synthetic */ wc9.e $conv;
    final /* synthetic */ List<Message> $msgList;
    final /* synthetic */ String $targetProjectId;
    int label;

    public ChatRouterHelper$getSubConversationFragmentBundle$2(Bundle r1, String r2, wc9.e r3, List<Message> r4, String r5, Continuation<? super ChatRouterHelper$getSubConversationFragmentBundle$2> r6) {
        this.$chatBundle = r1;
        this.$botId = r2;
        this.$conv = r3;
        this.$msgList = r4;
        this.$targetProjectId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatRouterHelper$getSubConversationFragmentBundle$2(this.$chatBundle, this.$botId, this.$conv, this.$msgList, this.$targetProjectId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bundle> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        if (((Boolean) r9).booleanValue() == true) goto L16;
        return null;
    L16:
        return this.$chatBundle;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        ChatRouterHelper r2 = ChatRouterHelper.a;
        Bundle r10 = this.$chatBundle;
        String r3 = this.$botId;
        wc9.e r4 = this.$conv;
        List<Message> r5 = this.$msgList;
        String r6 = this.$targetProjectId;
        this.label = 1;
        r9 = ChatRouterHelper.a(r2, r10, r3, r4, r5, r6, this);
        if (r9 != r0) goto L12;
        return r0;
    }
}
