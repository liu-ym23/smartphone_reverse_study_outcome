package com.larus.bmhome.debug;

import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.debug.databinding.LarusPageChatDebugBinding;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.debug.ChatDebugFragment$setupMessageInfo$1$19$1$1", f = "ChatDebugFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatDebugFragment$setupMessageInfo$1$19$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $findLastIndexMessage;
    final /* synthetic */ LarusPageChatDebugBinding $this_run;
    int label;

    public ChatDebugFragment$setupMessageInfo$1$19$1$1(Message r1, LarusPageChatDebugBinding r2, Continuation<? super ChatDebugFragment$setupMessageInfo$1$19$1$1> r3) {
        this.$findLastIndexMessage = r1;
        this.$this_run = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatDebugFragment$setupMessageInfo$1$19$1$1(this.$findLastIndexMessage, this.$this_run, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r13);
        PromptContent r14 = IAIChatService.a.L7(this.$findLastIndexMessage);
        if (r14 == null) goto L7;
        final List r15 = r14.getSuggestItems();
    L8:
        List r0 = r15;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == true) goto L18;
        this.$this_run.W.setText(CollectionsKt.joinToString$default(r15, "    ", "\nwelcomeback个数: " + r15.size() + '\n', null, 0, null, new n0(r15), 28, null));
    L18:
        return Unit.INSTANCE;
    L11:
        if (r0.isEmpty() == true) goto L14;
        r1 = false;
        goto L15
    L7:
        r15 = null;
        goto L8
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
