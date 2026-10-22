package com.larus.profile.impl.view;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.view.ProfileInfoView$initRecyclerView$1$1$1$onAction$1$1$existConv$1", f = "ProfileInfoView.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileInfoView$initRecyclerView$1$1$1$onAction$1$1$existConv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
    final /* synthetic */ fs9.n $profileBot;
    int label;

    public ProfileInfoView$initRecyclerView$1$1$1$onAction$1$1$existConv$1(fs9.n r1, Continuation<? super ProfileInfoView$initRecyclerView$1$1$1$onAction$1$1$existConv$1> r2) {
        this.$profileBot = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ProfileInfoView$initRecyclerView$1$1$1$onAction$1$1$existConv$1(this.$profileBot, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super wc9.e> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IConversationRepoService r3 = RepoDispatcherDelegate.b.f();
        String r11 = this.$profileBot.i();
        if (r11 != null) goto L11;
        r11 = "";
    L11:
        this.label = 1;
        r10 = IConversationRepoService.a.c(r3, r11, false, null, this, 6);
        if (r10 != r0) goto L14;
        return r0;
    }
}
