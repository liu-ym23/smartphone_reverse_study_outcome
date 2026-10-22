package com.larus.search.impl.combine;

import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.f5;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import ic8.l0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.x3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$openChat$1", f = "CombineSearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CombineSearchFragment$openChat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $botModel;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ boolean $isShowTab;
    final /* synthetic */ long $localIndex;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $searchHighlightKeyword;
    int label;
    final /* synthetic */ CombineSearchFragment this$0;

    public CombineSearchFragment$openChat$1(wc9.e r1, BotModel r2, boolean r3, long r4, String r6, String r7, CombineSearchFragment r8, Continuation<? super CombineSearchFragment$openChat$1> r9) {
        this.$conversation = r1;
        this.$botModel = r2;
        this.$isShowTab = r3;
        this.$localIndex = r4;
        this.$messageId = r6;
        this.$searchHighlightKeyword = r7;
        this.this$0 = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new CombineSearchFragment$openChat$1(this.$conversation, this.$botModel, this.$isShowTab, this.$localIndex, this.$messageId, this.$searchHighlightKeyword, this.this$0, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r32) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L90;
        ResultKt.throwOnFailure(r32);
        String r3 = this.$conversation.a;
        BotModel r1 = this.$botModel;
        Integer r2 = null;
        if (r1 == null) goto L7;
        String r4 = r1.getBgImgUrl();
    L8:
        BotModel r5 = this.$botModel;
        if (r5 == null) goto L11;
        String r6 = r5.getBgImgColor();
    L12:
        BotModel r7 = this.$botModel;
        boolean r29 = true;
        if (r7 == null) goto L15;
        boolean r8 = r7.getBgImgOpen();
    L16:
        int r9 = f5.a;
        wc9.e r10 = this.$conversation;
        if (r10 == null) goto L21;
        ConversationPage r11 = r10.g;
        if (r11 == null) goto L21;
        Integer r12 = r11.getDefaultStatus();
    L22:
        int r13 = f5.a(r12);
        BotModel r14 = this.$botModel;
        if (r14 == null) goto L25;
        String r15 = r14.getBotId();
    L26:
        wc9.e r16 = this.$conversation;
        if (r16 == null) goto L32;
        ConversationPage r17 = r16.g;
        if (r17 == null) goto L32;
        List r18 = r17.getPageList();
        if (r18 == null) goto L32;
    L33:
        List r19 = r18;
        ConversationPage r110 = this.$conversation.g;
        BotModel r20 = this.$botModel;
        if (r20 == null) goto L36;
        Integer r111 = r20.getBotType();
    L37:
        wc9.e r21 = this.$conversation;
        if (r21 == null) goto L40;
        r2 = r21.j;
    L40:
        Integer r112 = r2;
        Integer r22 = r21.v;
        if (r22 == null) goto L43;
        int r24 = r22.intValue();
    L44:
        ni8.e r23 = new ni8.e(r3, r4, r6, r8, this.$isShowTab, false, r13, r110, r15, null, r112, r19, r111, this.$localIndex, null, this.$messageId, null, this.$searchHighlightKeyword, null, null, r24, 0, 0, 14320928);
        CombineSearchFragment r25 = this.this$0;
        int r26 = CombineSearchFragment.G;
        String r27 = r25.k();
        if (r23.e == true) goto L47;
        Integer r28 = r23.l;
        if (r28 != null) goto L72;
    L74:
        x3.a("conversation_click", "combine_search_blocked", "conversation_type=" + r23.l);
    L75:
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == false) goto L88;
        String r30 = r23.a;
        Integer r31 = r23.l;
        FLogger.a.w("CombineSearchFragment", "keepConversationOnTop, conversationId: " + r30 + " conversationType: " + r31);
        if (r30 != null) goto L80;
    L83:
        if (r29 == true) goto L88;
        if (r31 == null) goto L88;
        com.larus.im.d.d().operateConversation(r30, r31.intValue(), 7, new x(r30));
        goto L88
    L80:
        if (r30.length() == 0) goto L83;
        r29 = false;
    L88:
        return Unit.INSTANCE;
    L72:
        if (r28.intValue() != 3) goto L74;
        com.bytedance.router.i r33 = SmartRouter.buildRoute(r25.getContext(), "//flow/chat_page");
        Bundle r34 = r25.ba0(r23, r27);
        by7.h.k(r34, r25);
        r33.c.putExtras(r34);
        r33.d = 2130772401;
        r33.e = 2130772399;
        r33.d();
        goto L75
    L47:
        if (l0.a(r23.m) == false) goto L67;
        com.bytedance.router.i r35 = SmartRouter.buildRoute(r25.getContext(), "//flow/chat_multi_tab");
        Bundle r36 = r25.ba0(r23, r27);
        ArrayList<Integer> r37 = new ArrayList();
        ConversationPage r38 = r23.h;
        if (r38 == null) goto L53;
        List r39 = r38.getPageList();
        if (r39 == null) goto L53;
    L54:
        r37.addAll(r39);
        Unit r40 = Unit.INSTANCE;
        r36.putIntegerArrayList("argument_multi_tab_list", r37);
        ConversationPage r41 = r23.h;
        if (r41 == null) goto L59;
        Integer r42 = r41.getDefaultStatus();
        if (r42 == null) goto L59;
        int r43 = r42.intValue();
    L60:
        r36.putInt("argument_multi_tab_default_tab", r43);
        ConversationPage r44 = r23.h;
        if (r44 == null) goto L65;
        Integer r45 = r44.getPagePosition();
        if (r45 == null) goto L65;
        int r46 = r45.intValue();
    L66:
        r36.putInt("argument_multi_tab_title_style", r46);
        by7.h.k(r36, r25);
        r35.c.putExtras(r36);
        r35.d = 2130772401;
        r35.e = 2130772399;
        r35.d();
    L65:
        r46 = 0;
    L59:
        r43 = PageType.Chat.getType();
    L53:
        r39 = CollectionsKt.emptyList();
        goto L54
    L67:
        com.bytedance.router.i r47 = SmartRouter.buildRoute(r25.getContext(), "//flow/chat_page_double_tab");
        Bundle r48 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r27), TuplesKt.to("argConversationId", r23.a), TuplesKt.to("argClickEnterFrom", r23.k), TuplesKt.to("argBotId", r23.j), TuplesKt.to("argBotType", r23.n), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r23.i)), TuplesKt.to("conversation_page", r23.h), TuplesKt.to("default_tab", Integer.valueOf(r23.g)), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r23.o)), TuplesKt.to("target_middle_msg_id", r23.q), TuplesKt.to("message_id", r23.q), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r23.r), TuplesKt.to("search_highlight_keyword", r23.s)});
        by7.h.k(r48, r25);
        r47.c.putExtras(r48);
        r47.d = 2130772401;
        r47.e = 2130772399;
        r47.d();
        goto L75
    L43:
        r24 = 0;
        goto L44
    L36:
        r111 = null;
    L32:
        r18 = CollectionsKt.emptyList();
        goto L33
    L25:
        r15 = null;
    L21:
        r12 = null;
        goto L22
    L15:
        r8 = true;
        goto L16
    L11:
        r6 = null;
        goto L12
    L7:
        r4 = null;
        goto L8
    L90:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
