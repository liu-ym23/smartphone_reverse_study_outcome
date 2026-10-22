package com.larus.tts.impl;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.utils.logger.FLogger;
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
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$syncConversationTtsEnable$2", f = "ChatTitleTtsComponent.kt", i = {}, l = {491}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleTtsComponent$syncConversationTtsEnable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ boolean $enable;
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public ChatTitleTtsComponent$syncConversationTtsEnable$2(ChatTitleTtsComponent r1, boolean r2, String r3, Continuation<? super ChatTitleTtsComponent$syncConversationTtsEnable$2> r4) {
        this.this$0 = r1;
        this.$enable = r2;
        this.$cvsId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatTitleTtsComponent$syncConversationTtsEnable$2(this.this$0, this.$enable, this.$cvsId, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ChatTitleTtsComponent r8 = this.this$0;
        int r2 = ChatTitleTtsComponent.v;
        com.larus.bmhome.chat.component.cvs.y r9 = r8.u0();
        if (r9 == null) goto L11;
        e r10 = r9.h();
    L12:
        if (r10 == null) goto L24;
        boolean r3 = r10.i;
        boolean r4 = this.$enable;
        if (r3 == r4) goto L24;
        if (r4 == true) goto L20;
        if (r3 == false) goto L20;
        FLogger.a.i("ChatTitleTtsComponent", "syncConversationTtsEnable cvsId=" + this.$cvsId + " skip downgrade from true to false");
        return Unit.INSTANCE;
    L20:
        FLogger.a.i("ChatTitleTtsComponent", "syncConversationTtsEnable cvsId=" + this.$cvsId + " from " + r10.i + " to " + this.$enable);
        IConversationRepoService r11 = RepoDispatcherDelegate.b.f();
        String r5 = this.$cvsId;
        boolean r6 = this.$enable;
        this.label = 1;
        if (r11.p(r5, r6, this) != r0) goto L24;
        return r0;
    L11:
        r10 = null;
        goto L12
    }
}
