package com.larus.ugc.perf.impl;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/bot/BotModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.perf.impl.MessageLruSourceImpl$onStartSendMsg$1$bot$1", f = "MessageLruSource.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
public final class MessageLruSourceImpl$onStartSendMsg$1$bot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BotModel>, Object> {
    final /* synthetic */ String $botId;
    int label;

    public MessageLruSourceImpl$onStartSendMsg$1$bot$1(String r1, Continuation<? super MessageLruSourceImpl$onStartSendMsg$1$bot$1> r2) {
        this.$botId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessageLruSourceImpl$onStartSendMsg$1$bot$1(this.$botId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BotModel> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        IBotRepoService r3 = RepoDispatcherDelegate.b.b();
        String r4 = this.$botId;
        this.label = 1;
        r11 = IBotRepoService.b.a(r3, r4, false, null, false, this, 30);
        if (r11 != r0) goto L11;
        return r0;
    }
}
