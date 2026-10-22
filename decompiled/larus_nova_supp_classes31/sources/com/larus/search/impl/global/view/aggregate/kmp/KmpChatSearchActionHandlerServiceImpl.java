package com.larus.search.impl.global.view.aggregate.kmp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.bytedance.flow.search.kmp.api.model.BotSearchResultItem;
import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.RecommendBotKmp;
import com.bytedance.flow.search.kmp.api.model.payload.BotPayload;
import com.bytedance.flow.search.kmp.api.model.payload.ChatSectionPayload;
import com.bytedance.flow.search.kmp.api.model.payload.MessagePayload;
import com.bytedance.flow.search.kmp.api.model.payload.MixedFeedPayload;
import com.bytedance.flow.search.kmp.api.model.payload.SingleLinePayload;
import com.bytedance.flow.search.kmp.api.model.payload.model.MessageSearchResult;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.utils.a4;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.search.api.LarkChatServiceProxy;
import com.larus.search.impl.common.ConversationRepoManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import tx9.x3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J&\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u001a\u0010\"\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020#H\u0002J\"\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010'\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020#H\u0082@¢\u0006\u0002\u0010*J\n\u0010+\u001a\u0004\u0018\u00010&H\u0002J\f\u0010,\u001a\u00020\u001b*\u00020\u001bH\u0002J)\u0010-\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u001dH\u0002¢\u0006\u0002\u00101¨\u00063"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpChatSearchActionHandlerServiceImpl;", "Lcom/bytedance/flow/search/kmp/api/spi/SearchDataChangingActionHandlerService;", "<init>", "()V", "onSearchItemClick", "", "data", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "onSearchDataChanged", "Lkotlin/Function0;", "", "handleMessageClick", "handleLarkMessageClick", "result", "Lcom/bytedance/flow/search/kmp/api/model/payload/model/MessageSearchResult;", "handleBotClick", "handleRecentConvClick", "handleMixedFeedClick", "handleLarkContactClick", "payload", "Lcom/bytedance/flow/search/kmp/api/model/payload/MixedFeedPayload;", "handleRecentBotClick", "handleChatSectionClick", "handleBotAdd", "handleBotRemove", "handleBotUpdateScene", "buildBotBundle", "Landroid/os/Bundle;", "conversationId", "", "bot", "Lcom/larus/im/bean/bot/BotModel;", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "buildBotBundleFromRecommendBot", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "navigateToBotChat", "context", "Landroid/content/Context;", "getBotByConversationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAndCreateLocalConversation", "(Lcom/larus/bmhome/chat/bean/RecommendBot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContext", "applyChatPassThroughParams", "keepConversationOnTop", "conversationType", "", "source", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpChatSearchActionHandlerServiceImpl implements zv5.h {
    public static final /* synthetic */ int b = 0;

    public static final class a {
        public a() {
        }

        public static final RecommendBot a(RecommendBotKmp r44) {
            int r1 = KmpChatSearchActionHandlerServiceImpl.b;
            String r3 = r44.a;
            String r4 = r44.b;
            Integer r5 = r44.c;
            boolean r14 = r44.j;
            String r15 = r44.k;
            String r2 = r44.f;
            String r6 = r44.g;
            return new RecommendBot(r3, r4, r5, null, null, 0, 0, 0, r14, r15, null, null, null, null, r2, null, null, null, null, r44.i, null, r6, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -18941448, 8191);
        }
    }

    static {
        new a();
    }

    public KmpChatSearchActionHandlerServiceImpl() {
    }

    private final Context getContext() {
        return AppHost.a.a().getCurrentActivity();
    }

    public static void h3(Bundle r1) {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 == null) goto L9;
        Intent r2 = r0.getIntent();
        if (r2 == null) goto L9;
        Bundle r3 = r2.getExtras();
        if (r3 == null) goto L9;
        ChatPassThroughParams r4 = ic8.k.a(r3);
    L10:
        ic8.k.b(r1, r4);
        return;
    L9:
        r4 = null;
        goto L10
    }

    public final boolean V(FlowSearchData r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return r0(r2, new zv5.g());
    }

    public final boolean r0(FlowSearchData r25, Function0<Unit> r26) {
        Intrinsics.checkNotNullParameter(r25, "data");
        Intrinsics.checkNotNullParameter(r26, "onSearchDataChanged");
        FLogger r1 = FLogger.a;
        r1.d("ChatSearchActionHandler", "onSearchItemClick: " + r25.b + ' ' + r25.a);
        int r2 = r25.b;
        ChatSectionPayload r6 = null;
        boolean r11 = true;
        if (r2 != (-1)) goto L25;
        BotPayload r0 = r25.c;
        if ((r0 instanceof BotPayload) == false) goto L7;
        BotPayload r3 = r0;
    L8:
        if (r3 == null) goto L252;
        BotSearchResultItem r4 = r3.j;
        if (r4 == null) goto L252;
        RecommendBotKmp r5 = r4.a;
        if (r5 == null) goto L252;
        RecommendBot r7 = a.a(r5);
        String r8 = r7.o();
        if (r8 != null) goto L17;
    L23:
        r1.w("ChatSearchActionHandler", "handleBotAdd: botId is blank");
        goto L252
    L17:
        if ((!StringsKt.isBlank(r8)) == true) goto L20;
        r8 = null;
    L20:
        if (r8 == null) goto L23;
        a4.a.getClass();
        a4.a(a4.b);
        BotStatusCacheDelegate.b.a(r8, true);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new KmpChatSearchActionHandlerServiceImpl$handleBotAdd$1(r7, null), 3, null);
    L256:
        return r11;
    L252:
        r11 = false;
        goto L256
    L7:
        r3 = null;
        goto L8
    L25:
        if (r2 != (-2)) goto L38;
        BotPayload r9 = r25.c;
        if ((r9 instanceof BotPayload) == false) goto L29;
        BotPayload r10 = r9;
    L30:
        if (r10 == null) goto L252;
        BotSearchResultItem r12 = r10.j;
        if (r12 == null) goto L252;
        RecommendBotKmp r13 = r12.a;
        if (r13 == null) goto L252;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1(a.a(r13), null), 3, null);
        goto L256
    L29:
        r10 = null;
        goto L30
    L38:
        if (r2 != (-3)) goto L59;
        BotPayload r14 = r25.c;
        if ((r14 instanceof BotPayload) == false) goto L42;
        BotPayload r15 = r14;
    L43:
        if (r15 == null) goto L252;
        BotSearchResultItem r16 = r15.j;
        if (r16 == null) goto L252;
        RecommendBotKmp r17 = r16.a;
        if (r17 == null) goto L252;
        RecommendBot r18 = a.a(r17);
        String r19 = r18.o();
        if (r19 != null) goto L52;
    L58:
        r1.w("ChatSearchActionHandler", "handleBotUpdateScene: botId is blank");
        goto L252
    L52:
        if ((!StringsKt.isBlank(r19)) == true) goto L55;
        r19 = null;
    L55:
        if (r19 == null) goto L58;
        a4.a.getClass();
        a4.a(a4.b);
        BotStatusCacheDelegate.b.d(r19, false);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new KmpChatSearchActionHandlerServiceImpl$handleBotUpdateScene$1(r18, null), 3, null);
        goto L256
    L42:
        r15 = null;
        goto L43
    L59:
        MixedFeedPayload r20 = r25.c;
        boolean r21 = r20 instanceof MixedFeedPayload;
        ChatSectionPayload r22 = "";
        if (r21 == false) goto L103;
        if (r21 == false) goto L63;
        MixedFeedPayload r23 = r20;
    L64:
        if (r23 == null) goto L252;
        if (r23.r == true) goto L88;
        String r24 = r23.t;
        if ((!StringsKt.isBlank(r24)) == false) goto L78;
        LarkChatServiceProxy r27 = (LarkChatServiceProxy) ServiceManager.get().getService(LarkChatServiceProxy.class);
        if (r27 != null) goto L73;
    L75:
        boolean r28 = false;
    L76:
        if (r28 == false) goto L78;
    L85:
        boolean r29 = true;
    L86:
        if (r29 == false) goto L88;
    L73:
        if (r27.a(r24, "") != true) goto L75;
        r28 = true;
    L78:
        String r30 = r23.u;
        if (StringsKt.isBlank(r30) == false) goto L81;
        r1.w("ChatSearchActionHandler", "skip lark contact click, chatId=" + r24 + ", userId=" + r30);
    L83:
        r29 = false;
        goto L86
    L81:
        Activity r31 = AppHost.a.a().getCurrentActivity();
        if (r31 == null) goto L83;
        com.bytedance.router.i r32 = SmartRouter.buildRoute(r31, "//flow/profile");
        r32.c.putExtras(BundleKt.bundleOf(new Pair[]{TuplesKt.to("key_user_id", r30)}));
        r32.d();
    L88:
        String r33 = r23.n;
        Context r34 = getContext();
        if (r34 == null) goto L252;
        if (r33 != null) goto L93;
    L96:
        boolean r35 = true;
    L97:
        if (r35 == false) goto L100;
        r1.w("ChatSearchActionHandler", "handleMixedFeedClick: conversationId is null");
        goto L252
    L100:
        if (Intrinsics.areEqual(r23.o, "3") == false) goto L102;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new KmpChatSearchActionHandlerServiceImpl$handleMixedFeedClick$1(this, r33, r34, null), 3, null);
        goto L256
    L102:
        x3.a("conversation_click", "aggregate_search_kmp_mixed_feed_blocked", "conversation_type=" + r23.o);
        goto L256
    L93:
        if (r33.length() == 0) goto L96;
        r35 = false;
        goto L97
    L63:
        r23 = null;
        goto L64
    L103:
        boolean r36 = r20 instanceof ChatSectionPayload;
        if (r36 == false) goto L123;
        if (r36 == false) goto L107;
        r6 = (ChatSectionPayload) r20;
    L107:
        if (r6 == null) goto L252;
        if (r6.m != 0) goto L252;
        String r37 = r6.k;
        if (StringsKt.isBlank(r37) == false) goto L115;
        r37 = r6.u;
    L115:
        Context r38 = getContext();
        if (r38 == null) goto L252;
        if (StringsKt.isBlank(r37) == false) goto L121;
        r1.w("ChatSearchActionHandler", "handleChatSectionClick: conversationId is blank");
        goto L252
    L121:
        com.bytedance.router.i r39 = SmartRouter.buildRoute(r38, "//flow/chat_page");
        Bundle r40 = BundleKt.bundleOf(new Pair[]{TuplesKt.to("argConversationId", r37), TuplesKt.to("enter_method", "search_result_click"), TuplesKt.to("enter_from", "search_result_click"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r6.n)), TuplesKt.to("target_middle_msg_id", r6.o), TuplesKt.to("message_id", r6.o), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("arg_is_from_search", Boolean.TRUE)});
        h3(r40);
        r39.c.putExtras(r40);
        r39.d();
        goto L256
    L123:
        if (Intrinsics.areEqual(r25.a, "message") == false) goto L147;
        SingleLinePayload r41 = r25.c;
        boolean r42 = r41 instanceof SingleLinePayload;
        if (r42 == false) goto L147;
        if (r42 == false) goto L128;
        SingleLinePayload r43 = r41;
    L129:
        if (r43 == null) goto L252;
        String r44 = r43.l;
        Context r45 = getContext();
        if (r45 == null) goto L252;
        if (r44 != null) goto L136;
    L139:
        boolean r46 = true;
    L140:
        if (r46 == false) goto L143;
        r1.w("ChatSearchActionHandler", "handleRecentConvClick: conversationId is null");
        goto L252
    L143:
        if (Intrinsics.areEqual(r43.m, "3") == false) goto L145;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new KmpChatSearchActionHandlerServiceImpl$handleRecentConvClick$1(this, r44, r45, null), 3, null);
        goto L256
    L145:
        x3.a("conversation_click", "aggregate_search_kmp_recent_conversation_blocked", "conversation_type=" + r43.m);
        goto L256
    L136:
        if (r44.length() == 0) goto L139;
        r46 = false;
        goto L140
    L128:
        r43 = null;
    L147:
        if (Intrinsics.areEqual(r25.a, "bot") == false) goto L168;
        SingleLinePayload r47 = r25.c;
        boolean r48 = r47 instanceof SingleLinePayload;
        if (r48 == false) goto L168;
        if (r48 == false) goto L152;
        SingleLinePayload r49 = r47;
    L153:
        if (r49 == null) goto L252;
        String r50 = r49.l;
        Context r51 = getContext();
        if (r51 == null) goto L252;
        if (r50 != null) goto L160;
    L163:
        boolean r52 = true;
    L164:
        if (r52 == false) goto L166;
        r1.w("ChatSearchActionHandler", "handleRecentBotClick: conversationId is null");
        goto L252
    L166:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new KmpChatSearchActionHandlerServiceImpl$handleRecentBotClick$1(this, r50, r51, null), 3, null);
        goto L256
    L160:
        if (r50.length() == 0) goto L163;
        r52 = false;
        goto L164
    L152:
        r49 = null;
    L168:
        if (Intrinsics.areEqual(r25.a, "message") == false) goto L236;
        MessagePayload r53 = r25.c;
        if ((r53 instanceof MessagePayload) == false) goto L172;
        MessagePayload r54 = r53;
    L173:
        if (r54 == null) goto L252;
        MessageSearchResult r55 = r54.j;
        if (r55 == null) goto L252;
        if (r55.l != 2) goto L194;
        ChatSectionPayload r56 = r55.n;
        if (StringsKt.isBlank(r56) == false) goto L188;
        wc9.e r57 = r55.j;
        if (r57 == null) goto L185;
        r6 = r57.a;
    L185:
        if (r6 == null) goto L189;
        r22 = r6;
    L189:
        LarkChatServiceProxy r58 = (LarkChatServiceProxy) ServiceManager.get().getService(LarkChatServiceProxy.class);
        if (r58 == null) goto L252;
        if (r58.b(r22, r55.h) != true) goto L252;
    L188:
        r22 = r56;
        goto L189
    L194:
        wc9.e r59 = r55.j;
        if (r59 == null) goto L252;
        Context r60 = getContext();
        if (r60 == null) goto L252;
        String r61 = r59.a;
        Integer r62 = r59.j;
        if (r62 != null) goto L204;
    L206:
        boolean r63 = false;
    L207:
        ChatSectionPayload r110 = f.a(r55.f);
        if (StringsKt.isBlank(r110) == false) goto L211;
        r110 = f.a(r55.e);
    L211:
        if (StringsKt.isBlank(r110) == false) goto L221;
        FlowQuery r111 = ((ISearchDataPayload) r54).e;
        if (r111 == null) goto L215;
        ChatSectionPayload r112 = r111.a;
    L216:
        if (r112 == null) goto L219;
        r22 = r112;
    L219:
        r110 = r22;
        goto L221
    L215:
        r112 = null;
    L221:
        if ((!StringsKt.isBlank(r110)) == true) goto L224;
        r110 = null;
    L224:
        StringBuilder r64 = new StringBuilder("open chat from kmp global search conversationId=");
        r64.append(r61);
        r64.append(", messageId=");
        Message r113 = r55.k;
        if (r113 == null) goto L227;
        String r114 = r113.getMessageId();
    L228:
        r64.append(r114);
        r64.append(", localIndex=");
        r64.append(r55.h);
        r64.append(", highlight=");
        r64.append(f.b(r110));
        r64.append(", query=");
        FlowQuery r115 = ((ISearchDataPayload) r54).e;
        if (r115 == null) goto L231;
        r6 = r115.a;
    L231:
        r64.append(f.b(r6));
        r64.append(", isBot=");
        r64.append(r63);
        r1.d("search_landing", r64.toString());
        if (r63 == false) goto L234;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new KmpChatSearchActionHandlerServiceImpl$handleMessageClick$1(this, r61, r59, r60, r26, r54, r110, r55, null), 3, null);
    L251:
        r11 = true;
        goto L256
    L234:
        x3.a("conversation_click", "aggregate_search_kmp_message_blocked", "conversation_type=" + r59.j);
        goto L251
    L227:
        r114 = null;
        goto L228
    L204:
        if (r62.intValue() != 3) goto L206;
        r63 = true;
        goto L207
    L172:
        r54 = null;
        goto L173
    L236:
        if (Intrinsics.areEqual(r25.a, "bot") == false) goto L254;
        BotPayload r65 = r25.c;
        if ((r65 instanceof BotPayload) == false) goto L240;
        BotPayload r66 = r65;
    L241:
        if (r66 == null) goto L252;
        BotSearchResultItem r67 = r66.j;
        if (r67 == null) goto L252;
        RecommendBotKmp r68 = r67.a;
        if (r68 == null) goto L252;
        RecommendBot r69 = a.a(r68);
        Context r70 = getContext();
        if (r70 == null) goto L252;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new KmpChatSearchActionHandlerServiceImpl$handleBotClick$1(this, r69, r70, null), 3, null);
        goto L251
    L240:
        r66 = null;
        goto L241
    L254:
        return false;
    }

    public static final Object k0(KmpChatSearchActionHandlerServiceImpl r9, RecommendBot r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof KmpChatSearchActionHandlerServiceImpl$checkAndCreateLocalConversation$1) == false) goto L7;
        KmpChatSearchActionHandlerServiceImpl$checkAndCreateLocalConversation$1 r0 = (KmpChatSearchActionHandlerServiceImpl$checkAndCreateLocalConversation$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = false;
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        ResultKt.throwOnFailure(r12);
    L73:
        String r14 = (String) r12;
    L75:
        return r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        wc9.e r15 = (wc9.e) r0.L$1;
        RecommendBot r4 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L61:
        if (r15 != null) goto L63;
        r4.G0(null);
    L63:
        String r16 = r4.E();
        if (r16 != null) goto L66;
    L67:
        r3 = true;
    L68:
        if (r3 == true) goto L70;
        r14 = r4.E();
        goto L75
    L70:
        ConversationRepoManager r17 = ConversationRepoManager.a;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 4;
        r12 = r17.b(r4, r0);
        if (r12 != r13) goto L73;
        return r13;
    L66:
        if (r16.length() != 0) goto L68;
    L18:
        r10 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L19:
        r4 = r10;
        r15 = (wc9.e) r12;
        if (r15 == null) goto L56;
        Integer r18 = r15.f;
        if (r18 == null) goto L56;
        if (r18.intValue() != 1) goto L56;
        boolean r19 = true;
    L57:
        if (r19 == false) goto L61;
        ConversationRepoManager r20 = ConversationRepoManager.a;
        String r21 = r15.a;
        r0.L$0 = r4;
        r0.L$1 = r15;
        r0.label = 3;
        if (ConversationRepoManager.g(r21, r4, r0) != r13) goto L61;
        return r13;
    L56:
        r19 = false;
        goto L57
    L20:
        r10 = (RecommendBot) r0.L$2;
        String r5 = (String) r0.L$1;
        RecommendBot r8 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L44:
        r10.G0((String) r12);
        r10 = r8;
    L45:
        ConversationRepoManager r22 = ConversationRepoManager.a;
        r0.L$0 = r10;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        r12 = ConversationRepoManager.c(r5, r0);
        if (r12 != r13) goto L19;
        return r13;
    L21:
        ResultKt.throwOnFailure(r12);
        r5 = r10.o();
        if (r5 != null) goto L25;
        return null;
    L25:
        if (r10.j0() == false) goto L37;
        String r23 = r10.E();
        if (r23 != null) goto L29;
    L32:
        boolean r24 = true;
    L33:
        if (r24 == true) goto L40;
        int r25 = wf9.a.a;
        if (wf9.a.a(r10.E()) == false) goto L37;
    L40:
        ConversationRepoManager r26 = ConversationRepoManager.a;
        r0.L$0 = r10;
        r0.L$1 = r5;
        r0.L$2 = r10;
        r0.label = 1;
        r12 = ConversationRepoManager.d(r5, r0);
        if (r12 == r13) goto L77;
        r8 = r10;
        goto L44
    L77:
        return r13;
    L29:
        if (r23.length() == 0) goto L32;
        r24 = false;
    L37:
        if (r10.j0() == true) goto L45;
        int r27 = wf9.a.a;
        if (wf9.a.a(r10.E()) == true) goto L45;
    L7:
        r0 = new KmpChatSearchActionHandlerServiceImpl$checkAndCreateLocalConversation$1(r9, r11);
        goto L8
    }

    public static final Object z0(KmpChatSearchActionHandlerServiceImpl r2, String r3, Continuation r4) {
        r2.getClass();
        SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(r4));
        com.larus.im.d.a().getBotByConversationId(r3, new d(r5));
        Object r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r6;
    }

    public static final void H2(KmpChatSearchActionHandlerServiceImpl r2, String r3, Integer r4, String r5) {
        r2.getClass();
        FLogger r6 = FLogger.a;
        StringBuilder r0 = new StringBuilder("keepConversationOnTop start, source=");
        r0.append(r5);
        r0.append(" conversationId=");
        r0.append(r3);
        r0.append(" conversationType=");
        r0.append(r4);
        r0.append(" socialActive=");
        LarkSocialExp.a.getClass();
        r0.append(LarkSocialExp.e());
        r6.i("ChatSearchActionHandler", r0.toString());
        if (LarkSocialExp.e() == false) goto L15;
        if (r3 != null) goto L6;
    L9:
        boolean r7 = true;
    L10:
        if (r7 == true) goto L16;
        if (r4 == null) goto L17;
        com.larus.im.d.d().operateConversation(r3, r4.intValue(), 7, new e(r3));
        return;
    L17:
        return;
    L16:
        return;
    L6:
        if (r3.length() == 0) goto L9;
        r7 = false;
        goto L10
    }

    public static final Bundle u(KmpChatSearchActionHandlerServiceImpl r4, String r5, BotModel r6, wc9.e r7) {
        r4.getClass();
        Pair[] r8 = new Pair[10];
        int r0 = 0;
        r8[0] = TuplesKt.to("argConversationId", r5);
        String r9 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getBotId();
    L6:
        boolean r2 = true;
        r8[1] = TuplesKt.to("argBotId", r1);
        if (r6 == null) goto L9;
        Integer r3 = r6.getBotType();
    L10:
        r8[2] = TuplesKt.to("argBotType", r3);
        if (r6 == null) goto L13;
        String r10 = r6.getBgImgUrl();
    L14:
        r8[3] = TuplesKt.to("argCvsBgImgUrl", r10);
        if (r6 == null) goto L17;
        r9 = r6.getBgImgColor();
    L17:
        r8[4] = TuplesKt.to("argCvsBgImgColor", r9);
        if (r6 == null) goto L20;
        r2 = r6.getBgImgOpen();
    L20:
        r8[5] = TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r2));
        if (r7 == null) goto L25;
        Integer r11 = r7.v;
        if (r11 == null) goto L25;
        r0 = r11.intValue();
    L25:
        r8[6] = TuplesKt.to("argBotConversationType", Integer.valueOf(r0));
        r8[7] = TuplesKt.to("argPreviousPage", "search_landing_page");
        r8[8] = TuplesKt.to("enter_method", "click_chat");
        r8[9] = TuplesKt.to("enter_from", "global_search");
        Bundle r12 = BundleKt.bundleOf(r8);
        h3(r12);
        return r12;
    L13:
        r10 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
