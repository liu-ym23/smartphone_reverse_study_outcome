package com.larus.bot.impl.feature.discover;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.f5;
import com.larus.bmhome.chat.resp.ContentDistType;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.im.bean.bot.ConversationPage;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$setupRecyclerView$1$2$onBotClick$1", f = "BotDiscoverListFragment.kt", i = {}, l = {482}, m = "invokeSuspend", n = {}, s = {})
public final class BotDiscoverListFragment$setupRecyclerView$1$2$onBotClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    int label;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$setupRecyclerView$1$2$onBotClick$1(RecommendBot r1, BotDiscoverListFragment r2, Continuation<? super BotDiscoverListFragment$setupRecyclerView$1$2$onBotClick$1> r3) {
        this.$data = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotDiscoverListFragment$setupRecyclerView$1$2$onBotClick$1(this.$data, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r32) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r32);
        Object r3 = r32;
    L18:
        String r6 = (String) r3;
        BotDiscoverListFragment r5 = this.this$0;
        RecommendBot r8 = this.$data;
        int r4 = BotDiscoverListFragment.A;
        String r7 = String.valueOf(((ArrayList) ((FPagingAdapter) r5.Z90()).b).indexOf(r8) + 1);
        if (AudioServiceDelegate.a.B(r8.o(), r8.r(), r8.c0()) == null) goto L21;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r5), null, null, new BotDiscoverListFragment$directToRealtimeCall$1(r5, r6, r7, r8, null), 3, null);
    L34:
        return Unit.INSTANCE;
    L21:
        ConversationPage r9 = r8.F();
        if (r9 == null) goto L24;
        List r10 = r9.getPageList();
    L26:
        if (ic8.l0.b(r10) == false) goto L32;
        com.bytedance.router.i r11 = SmartRouter.buildRoute(r5.getContext(), "//flow/chat_page_double_tab");
        Pair[] r12 = new Pair[13];
        r12[0] = TuplesKt.to("argPreviousPage", "bot_list_discover");
        r12[1] = TuplesKt.to("argConversationId", r6);
        r12[2] = TuplesKt.to("argClickEnterFrom", "");
        r12[3] = TuplesKt.to("argBotId", r8.o());
        r12[4] = TuplesKt.to("argBotPosition", r7);
        r12[5] = TuplesKt.to("argBotRecommendFrom", r8.a);
        r12[6] = TuplesKt.to("is_create_sub_conversation", Boolean.FALSE);
        int r0 = f5.a;
        ConversationPage r13 = r8.F();
        if (r13 == null) goto L30;
        Integer r14 = r13.getDefaultStatus();
    L31:
        r12[7] = TuplesKt.to("default_tab", Integer.valueOf(f5.a(r14)));
        r12[8] = TuplesKt.to("conversation_page", r8.F());
        r12[9] = TuplesKt.to("enter_method", "click_chat");
        r12[10] = TuplesKt.to("enter_from", "bot_discover");
        r12[11] = TuplesKt.to("recommend_bot_mob_segment", r8.I0(String.valueOf(r5.v)));
        r12[12] = TuplesKt.to("ignore_side_bar", "1");
        Bundle r15 = com.larus.utils.f.c(r12);
        by7.h.k(r15, r5);
        r11.c.putExtras(r15);
        r11.d = 2130772401;
        r11.e = 2130772399;
        r11.d();
        goto L34
    L30:
        r14 = null;
        goto L31
    L32:
        com.bytedance.router.i r16 = SmartRouter.buildRoute(r5.getContext(), "//flow/chat_page");
        Bundle r17 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("landing_channel", ChatLandingChannel.BOT_DISCOVER.getChannel()), TuplesKt.to("argPreviousPage", "bot_list_discover"), TuplesKt.to("argConversationId", r6), TuplesKt.to("argClickEnterFrom", ""), TuplesKt.to("argBotId", r8.o()), TuplesKt.to("argCvsBgImgUrl", r8.e()), TuplesKt.to("argCvsBgImgColor", r8.a()), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r8.c())), TuplesKt.to("argBotPosition", r7), TuplesKt.to("argBotRecommendFrom", r8.a), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", "bot_list_discover"), TuplesKt.to("navigate_up_from", "bot_list_discovery"), TuplesKt.to("recommend_bot_mob_segment", r8.I0(String.valueOf(r5.v))), TuplesKt.to("ignore_side_bar", "1")});
        by7.h.k(r17, r5);
        r16.c.putExtras(r17);
        r16.d = 2130772401;
        r16.e = 2130772399;
        r16.d();
        goto L34
    L24:
        r10 = null;
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r32);
        Integer r18 = this.$data.D();
        int r19 = ContentDistType.Aweme.getValue();
        if (r18 != null) goto L12;
    L15:
        BotDiscoverListFragment r20 = this.this$0;
        RecommendBot r21 = this.$data;
        this.label = 1;
        r3 = BotDiscoverListFragment.S90(r20, r21, this);
        if (r3 != r1) goto L18;
        return r1;
    L12:
        if (r18.intValue() != r19) goto L15;
        SmartRouter.buildRoute(this.this$0.getContext(), "//flow/douyin_bot").d();
        return Unit.INSTANCE;
    }
}
