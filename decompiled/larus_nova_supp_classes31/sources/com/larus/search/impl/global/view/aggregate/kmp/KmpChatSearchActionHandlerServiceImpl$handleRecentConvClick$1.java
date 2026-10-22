package com.larus.search.impl.global.view.aggregate.kmp;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.im.bean.bot.BotModel;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.view.aggregate.kmp.KmpChatSearchActionHandlerServiceImpl$handleRecentConvClick$1", f = "KmpChatSearchActionHandlerServiceImpl.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
final class KmpChatSearchActionHandlerServiceImpl$handleRecentConvClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ KmpChatSearchActionHandlerServiceImpl this$0;

    public KmpChatSearchActionHandlerServiceImpl$handleRecentConvClick$1(KmpChatSearchActionHandlerServiceImpl r1, String r2, Context r3, Continuation<? super KmpChatSearchActionHandlerServiceImpl$handleRecentConvClick$1> r4) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new KmpChatSearchActionHandlerServiceImpl$handleRecentConvClick$1(this.this$0, this.$conversationId, this.$context, r5);
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
    L11:
        KmpChatSearchActionHandlerServiceImpl r2 = this.this$0;
        String r3 = this.$conversationId;
        Bundle r6 = KmpChatSearchActionHandlerServiceImpl.u(r2, r3, (BotModel) r5, null);
        KmpChatSearchActionHandlerServiceImpl.H2(this.this$0, this.$conversationId, Boxing.boxInt(3), "handleRecentConvClickBot");
        com.bytedance.router.i r4 = SmartRouter.buildRoute(this.$context, "//flow/chat_page");
        r4.c.putExtras(r6);
        r4.d();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        KmpChatSearchActionHandlerServiceImpl r7 = this.this$0;
        String r8 = this.$conversationId;
        this.label = 1;
        r5 = KmpChatSearchActionHandlerServiceImpl.z0(r7, r8, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
