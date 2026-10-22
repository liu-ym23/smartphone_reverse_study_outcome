package com.larus.search.impl.global.view.aggregate.kmp;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
@DebugMetadata(c = "com.larus.search.impl.global.view.aggregate.kmp.KmpChatSearchActionHandlerServiceImpl$handleBotClick$1", f = "KmpChatSearchActionHandlerServiceImpl.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
final class KmpChatSearchActionHandlerServiceImpl$handleBotClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $bot;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ KmpChatSearchActionHandlerServiceImpl this$0;

    public KmpChatSearchActionHandlerServiceImpl$handleBotClick$1(KmpChatSearchActionHandlerServiceImpl r1, RecommendBot r2, Context r3, Continuation<? super KmpChatSearchActionHandlerServiceImpl$handleBotClick$1> r4) {
        this.this$0 = r1;
        this.$bot = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new KmpChatSearchActionHandlerServiceImpl$handleBotClick$1(this.this$0, this.$bot, this.$context, r5);
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
    L11:
        String r8 = (String) r7;
        KmpChatSearchActionHandlerServiceImpl.H2(this.this$0, r8, Boxing.boxInt(3), "handleBotClick");
        KmpChatSearchActionHandlerServiceImpl r2 = this.this$0;
        Context r3 = this.$context;
        RecommendBot r4 = this.$bot;
        r2.getClass();
        Bundle r9 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("argConversationId", r8), TuplesKt.to("argBotId", r4.o()), TuplesKt.to("argBotType", r4.r()), TuplesKt.to("argCvsBgImgUrl", r4.e()), TuplesKt.to("argCvsBgImgColor", r4.a()), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r4.c())), TuplesKt.to("argPreviousPage", "search_landing_page"), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", "global_search")});
        KmpChatSearchActionHandlerServiceImpl.h3(r9);
        com.bytedance.router.i r5 = SmartRouter.buildRoute(r3, "//flow/chat_page");
        r5.c.putExtras(r9);
        r5.d();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        KmpChatSearchActionHandlerServiceImpl r10 = this.this$0;
        RecommendBot r6 = this.$bot;
        this.label = 1;
        r7 = KmpChatSearchActionHandlerServiceImpl.k0(r10, r6, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
