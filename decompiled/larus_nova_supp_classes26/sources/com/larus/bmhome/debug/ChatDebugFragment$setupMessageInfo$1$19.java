package com.larus.bmhome.debug;

import com.larus.bmhome.chat.debug.databinding.LarusPageChatDebugBinding;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.debug.ChatDebugFragment$setupMessageInfo$1$19", f = "ChatDebugFragment.kt", i = {}, l = {361, 363}, m = "invokeSuspend", n = {}, s = {})
final class ChatDebugFragment$setupMessageInfo$1$19 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $chatMessage;
    final /* synthetic */ LarusPageChatDebugBinding $this_run;
    Object L$0;
    int label;

    public ChatDebugFragment$setupMessageInfo$1$19(Message r1, LarusPageChatDebugBinding r2, Continuation<? super ChatDebugFragment$setupMessageInfo$1$19> r3) {
        this.$chatMessage = r1;
        this.$this_run = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatDebugFragment$setupMessageInfo$1$19(this.$chatMessage, this.$this_run, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        LarusPageChatDebugBinding r2 = (LarusPageChatDebugBinding) this.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        Message r8 = (Message) r7;
        if (Intrinsics.areEqual(IAIChatService.a.E7(r8), Boxing.boxBoolean(true)) == false) goto L23;
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        ChatDebugFragment$setupMessageInfo$1$19$1$1 r4 = new ChatDebugFragment$setupMessageInfo$1$19$1$1(r8, r2, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r3, r4, this) != r0) goto L23;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        Message r9 = this.$chatMessage;
        if (r9 == null) goto L23;
        String r10 = r9.getConversationId();
        if (r10 == null) goto L23;
        r2 = this.$this_run;
        IChatRepoService r5 = RepoDispatcherDelegate.b.e();
        this.L$0 = r2;
        this.label = 1;
        r7 = r5.K1(r10, this);
        if (r7 != r0) goto L17;
        return r0;
    }
}
