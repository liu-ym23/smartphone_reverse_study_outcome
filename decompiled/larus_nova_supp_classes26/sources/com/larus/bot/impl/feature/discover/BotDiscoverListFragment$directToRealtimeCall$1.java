package com.larus.bot.impl.feature.discover;

import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.audio.realtimecall.IRealtimeCallStrategy;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.bean.RecommendBot;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$directToRealtimeCall$1", f = "BotDiscoverListFragment.kt", i = {0}, l = {604}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240"}, s = {"L$2"})
final class BotDiscoverListFragment$directToRealtimeCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $argPosition;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ RecommendBot $data;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$directToRealtimeCall$1(BotDiscoverListFragment r1, String r2, String r3, RecommendBot r4, Continuation<? super BotDiscoverListFragment$directToRealtimeCall$1> r5) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$argPosition = r3;
        this.$data = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BotDiscoverListFragment$directToRealtimeCall$1(this.this$0, this.$conversationId, this.$argPosition, this.$data, r8);
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
        com.bytedance.router.i r2 = (com.bytedance.router.i) this.L$4;
        Bundle r3 = (Bundle) this.L$3;
        Bundle r4 = (Bundle) this.L$2;
        BotDiscoverListFragment r5 = (BotDiscoverListFragment) this.L$1;
        Bundle r6 = (Bundle) this.L$0;
        ResultKt.throwOnFailure(r7);
    L12:
        r3.putAll((Bundle) r7);
        by7.h.k(r4, r5);
        r2.c.putExtras(r6);
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.d();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        com.bytedance.router.i r8 = SmartRouter.buildRoute(this.this$0.getContext(), "//flow/realtime_chat_gate");
        r3 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("landing_channel", ChatLandingChannel.BOT_DISCOVER.getChannel()), TuplesKt.to("argPreviousPage", "bot_list_discover"), TuplesKt.to("argConversationId", this.$conversationId), TuplesKt.to("argBotPosition", this.$argPosition), TuplesKt.to("argBotRecommendFrom", this.$data.a), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", "bot_list_discover"), TuplesKt.to("navigate_up_from", "bot_list_discovery"), TuplesKt.to("adapter_fix_bottom_tab", "true"), TuplesKt.to("recommend_bot_mob_segment", this.$data.I0(String.valueOf(this.this$0.v))), TuplesKt.to("ignore_side_bar", "1"), TuplesKt.to("is_call_bot", "1")});
        String r9 = this.$conversationId;
        BotDiscoverListFragment r10 = this.this$0;
        IRealtimeCallStrategy.RealtimeCallStrategyDelegate r11 = IRealtimeCallStrategy.a;
        this.L$0 = r3;
        this.L$1 = r10;
        this.L$2 = r3;
        this.L$3 = r3;
        this.L$4 = r8;
        this.label = 1;
        Object r12 = r11.b(r9, this);
        if (r12 != r0) goto L11;
        return r0;
    L11:
        r2 = r8;
        r7 = r12;
        r5 = r10;
        r4 = r3;
        r6 = r4;
        goto L12
    }
}
