package com.larus.bmhome.chat.helper;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.p0;
import com.larus.audio.realtimecall.IRealtimeCallStrategy;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.model.i1;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import tx9.x3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationClickHelper {
    public static final /* synthetic */ int f = 0;
    public final Fragment a;
    public final String b;
    public final ConversationModel c;
    public final by7.e d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    private final Context getContext() {
        return this.a.getContext();
    }

    public final void e(Bundle r9) {
        if (this.e == false) goto L6;
        ic8.k.b(r9, new ChatPassThroughParams(null, true, false, null, 13, null));
        return;
    }

    public static final void b(ConversationClickHelper r13, ni8.e r14, String r15) {
        r13.getClass();
        if (r14.v == 6) goto L11;
        Integer r0 = r14.n;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L13:
        if (r1 == false) goto L22;
        vi8.c.a.getClass();
        if (vi8.c.a() == true) goto L17;
        FLogger.a.i("DouBaoConversationClickHelper", "ignore service bot conversation click because effective gate is disabled");
        return;
    L17:
        com.bytedance.router.i r2 = SmartRouter.buildRoute(r13.getContext(), "//flow/chat_page");
        Bundle r16 = r13.c(r14, r13.b, r15);
        by7.e r17 = r13.d;
        if (r17 == null) goto L20;
        by7.h.k(r16, r17);
    L20:
        r2.c.putExtras(r16);
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.d();
        return;
    L22:
        if (r14.e == true) goto L24;
        Integer r3 = r14.l;
        if (r3 != null) goto L57;
    L62:
        x3.a("conversation_click", "chat_list_blocked", "conversation_type=" + r14.l);
        return;
    L57:
        if (r3.intValue() != 3) goto L62;
        com.bytedance.router.i r4 = SmartRouter.buildRoute(r13.getContext(), "//flow/chat_page");
        r4.c.putExtra("landing_channel", ChatLandingChannel.CHAT_LIST.getChannel());
        Bundle r18 = r13.c(r14, r13.b, r15);
        by7.e r19 = r13.d;
        if (r19 == null) goto L61;
        by7.h.k(r18, r19);
    L61:
        r4.c.putExtras(r18);
        r4.d = 2130772401;
        r4.e = 2130772399;
        r4.d();
        return;
    L24:
        if (ic8.l0.a(r14.m) == false) goto L49;
        Context r5 = r13.getContext();
        if (r5 == null) goto L69;
        MainBotServiceDelegate r6 = MainBotServiceDelegate.b;
        Bundle r7 = r13.c(r14, r13.b, r15);
        by7.e r110 = r13.d;
        if (r110 == null) goto L31;
        by7.h.k(r7, r110);
    L31:
        Unit r111 = Unit.INSTANCE;
        ConversationPage r112 = r14.h;
        if (r112 == null) goto L36;
        Integer r113 = r112.getDefaultStatus();
        if (r113 == null) goto L36;
        int r114 = r113.intValue();
    L37:
        int r8 = r114;
        ConversationPage r115 = r14.h;
        if (r115 == null) goto L41;
        List r116 = r115.getPageList();
        if (r116 == null) goto L41;
    L42:
        List r9 = r116;
        ConversationPage r117 = r14.h;
        if (r117 == null) goto L47;
        Integer r118 = r117.getPagePosition();
        if (r118 == null) goto L47;
        int r10 = r118.intValue();
    L48:
        r6.c(r5, new IMainBotService.a(r7, r8, r9, r10, 2130772401, 2130772399, null, 64));
        return;
    L47:
        r10 = 0;
    L41:
        r116 = CollectionsKt.emptyList();
    L36:
        r114 = PageType.Chat.getType();
        goto L37
    L69:
        return;
    L49:
        com.bytedance.router.i r11 = SmartRouter.buildRoute(r13.getContext(), "//flow/chat_page_double_tab");
        Bundle r119 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r13.b), TuplesKt.to("argConversationId", r14.a), TuplesKt.to("argClickEnterFrom", r14.k), TuplesKt.to("argBotId", r14.j), TuplesKt.to("argBotType", r14.n), TuplesKt.to("argBotRecommendFrom", r14.p), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r14.i)), TuplesKt.to("argBotPosition", r15), TuplesKt.to("default_tab", Integer.valueOf(r14.g)), TuplesKt.to("conversation_page", r14.h), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("argBotRecommendFrom", r14.p), TuplesKt.to("argBotConversationType", Integer.valueOf(r14.v))});
        r13.e(r119);
        r119.putInt("red_dot_entry_unread_count", r14.w);
        r119.putLong("red_dot_entry_read_message_index", r14.x);
        by7.e r120 = r13.d;
        if (r120 == null) goto L52;
        by7.h.k(r119, r120);
    L52:
        r11.c.putExtras(r119);
        r11.d = 2130772401;
        r11.e = 2130772399;
        r11.d();
        return;
    L8:
        if (r0.intValue() != 4) goto L10;
    L11:
        r1 = true;
        goto L13
    }

    public final Bundle c(ni8.e r3, String r4, String r5) {
        Bundle r6 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r4), TuplesKt.to("argConversationId", r3.a), TuplesKt.to("argBotId", r3.j), TuplesKt.to("argBotType", r3.n), TuplesKt.to("argClickEnterFrom", r3.k), TuplesKt.to("argCvsBgImgUrl", r3.b), TuplesKt.to("argCvsBgImgColor", r3.c), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r3.d)), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r3.i)), TuplesKt.to("argBotPosition", r5), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", "bot_list"), TuplesKt.to("navigate_up_from", "chat_list"), TuplesKt.to("argBotRecommendFrom", r3.p), TuplesKt.to("argBotConversationType", Integer.valueOf(r3.v)), TuplesKt.to("is_from_chat_list", Boolean.TRUE), TuplesKt.to("argChatTitle", r3.u)});
        r6.putInt("red_dot_entry_unread_count", r3.w);
        r6.putLong("red_dot_entry_read_message_index", r3.x);
        e(r6);
        return r6;
    }

    public final void d(wh8.a r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "argPosition");
        wc9.e r0 = null;
        if (r15 == null) goto L9;
        wc9.e r1 = r15.a;
        if (r1 == null) goto L9;
        ConversationPage r2 = r1.g;
        if (r2 == null) goto L9;
        List r3 = r2.getPageList();
    L10:
        boolean r4 = ic8.l0.b(r3);
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("name is >>> ");
        if (r15 == null) goto L15;
        wc9.e r7 = r15.a;
        if (r7 == null) goto L15;
        String r8 = r7.c;
    L16:
        r6.append(r8);
        r5.i("DouBaoConversationClickHelper", r6.toString());
        StringBuilder r9 = new StringBuilder("botConversationType is >>> ");
        if (r15 == null) goto L21;
        wc9.e r10 = r15.a;
        if (r10 == null) goto L21;
        Integer r11 = r10.v;
    L22:
        r9.append(r11);
        r5.i("DouBaoConversationClickHelper", r9.toString());
        boolean r12 = true;
        int r13 = 0;
        if (r15 == null) goto L32;
        wc9.e r14 = r15.a;
        if (r14 == null) goto L32;
        Integer r19 = r14.v;
        if (r19 == null) goto L32;
        if (r19.intValue() != 4) goto L32;
        boolean r20 = true;
    L33:
        if (r15 == null) goto L37;
        wc9.e r110 = r15.a;
        if (r110 == null) goto L37;
        String r111 = ic8.n.e(r110);
    L38:
        if (r20 == false) goto L47;
        r5.i("DouBaoConversationClickHelper", "current conversation is douyin");
        if (r15 == null) goto L107;
        wc9.e r21 = r15.a;
        if (r21 == null) goto L108;
        SmartRouter.buildRoute(getContext(), "//flow/douyin_bot").d();
        ConversationModel r22 = this.c;
        if (r22 == null) goto L109;
        r22.reportAwemeConversation(r21);
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L47:
        if (com.larus.utils.o0.d(r111) == false) goto L49;
        SmartRouter.buildRoute(getContext(), r111).d();
        return;
    L49:
        if (r15 == null) goto L51;
        wc9.e r23 = r15.a;
    L53:
        if (ic8.n.q(r23) == false) goto L99;
        JSONObject r24 = new JSONObject();
        if (r15 == null) goto L57;
        wc9.e r25 = r15.a;
    L59:
        if (ic8.n.w(r25) == false) goto L61;
        String r26 = "doubao_pc_history";
    L62:
        r24.put("cell_type", r26);
        if (r15 == null) goto L65;
        String r27 = r15.h;
    L66:
        if (r27 != null) goto L68;
    L71:
        int r28 = 1;
    L72:
        r24.put("if_list_empty", r28);
        tx9.c0.t(r24);
        if (r15 == null) goto L75;
        wc9.e r29 = r15.a;
    L77:
        if (ic8.n.w(r29) == false) goto L93;
        if (r15 == null) goto L80;
        String r30 = r15.h;
    L81:
        if (r30 != null) goto L83;
    L86:
        if (r12 == false) goto L93;
        if (r15 == null) goto L89;
        r0 = r15.a;
    L89:
        String r31 = ic8.n.h(r0);
        if (com.larus.utils.o0.d(r31) == false) goto L93;
        SmartRouter.buildRoute(getContext(), r31).d();
        return;
    L83:
        if (r30.length() == 0) goto L86;
        r12 = false;
        goto L86
    L80:
        r30 = null;
    L93:
        com.bytedance.router.i r32 = SmartRouter.buildRoute(getContext(), "//flow/chat_only_list");
        if (r15 == null) goto L98;
        wc9.e r33 = r15.a;
        if (r33 == null) goto L98;
        r13 = r33.F;
    L98:
        r32.c.putExtra("page_type", r13);
        Bundle r34 = new Bundle();
        e(r34);
        r32.c.putExtras(r34);
        r32.d = 2130772401;
        r32.e = 2130772399;
        r32.d();
        return;
    L75:
        r29 = null;
        goto L77
    L68:
        if (r27.length() == 0) goto L71;
        r28 = 0;
        goto L72
    L65:
        r27 = null;
        goto L66
    L61:
        r26 = "unadded_bot_list";
        goto L62
    L57:
        r25 = null;
        goto L59
    L99:
        p0 r35 = AudioServiceDelegate.a.getAudioConfig();
        if (r15 == null) goto L103;
        r0 = r15.b;
    L103:
        if (r35.n(r0) == false) goto L105;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new ConversationClickHelper$handleConversationClick$4(this, r15, r17, r18, null), 3, null);
        return;
    L105:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new ConversationClickHelper$handleConversationClick$5(r15, this, r4, r16, r17, null), 3, null);
        return;
    L51:
        r23 = null;
    L37:
        r111 = null;
    L32:
        r20 = false;
    L21:
        r11 = null;
    L15:
        r8 = null;
    L9:
        r3 = null;
        goto L10
    }

    public ConversationClickHelper(Fragment r2, String r3, ConversationModel r4, by7.e r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "currentPageName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public static final Object a(ConversationClickHelper r9, wh8.a r10, String r11, String r12, Continuation r13) {
        r9.getClass();
        if ((r13 instanceof ConversationClickHelper$directToRealtimeCall$1) == false) goto L7;
        ConversationClickHelper$directToRealtimeCall$1 r0 = (ConversationClickHelper$directToRealtimeCall$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Message r5 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r15 = (String) r0.L$3;
        r12 = (String) r0.L$2;
        r11 = (String) r0.L$1;
        wh8.a r4 = (wh8.a) r0.L$0;
        ResultKt.throwOnFailure(r14);
        String r16 = r15;
        r10 = r4;
        Object r6 = r14;
    L48:
        String r7 = (String) r6;
    L49:
        if (r10 == null) goto L51;
        RecommendFrom r8 = r10.f;
    L53:
        if (r8 == null) goto L55;
        RecommendFrom r17 = r10.f;
    L56:
        com.bytedance.router.i r18 = SmartRouter.buildRoute(r9.getContext(), "//flow/realtime_chat_gate");
        Bundle r19 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argConversationId", r16), TuplesKt.to("argBotRecommendFrom", r17), TuplesKt.to("argPreviousPage", r9.b), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", r9.b), TuplesKt.to("argBotPosition", r11), TuplesKt.to("adapter_fix_bottom_tab", "true"), TuplesKt.to("is_call_bot", "1")});
        IRealtimeCallStrategy.RealtimeCallStrategyDelegate r110 = IRealtimeCallStrategy.a;
        if (r10 == null) goto L59;
        wc9.e r111 = r10.a;
    L60:
        if (r10 == null) goto L62;
        r5 = r10.c;
    L62:
        r19.putAll(r110.a(r111, r5));
        by7.e r20 = r9.d;
        if (r20 == null) goto L65;
        by7.h.k(r19, r20);
    L65:
        r18.c.putExtras(r19);
        r18.d();
        return Unit.INSTANCE;
    L59:
        r111 = null;
        goto L60
    L55:
        r17 = new RecommendFrom(r12, null, null, 6);
        goto L56
    L51:
        r8 = null;
        goto L53
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (r10 == null) goto L19;
        wc9.e r112 = r10.a;
        if (r112 == null) goto L19;
        r16 = r112.a;
    L20:
        if (r16 == null) goto L24;
        Lazy r21 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        if (com.larus.im.j.f(r16) != true) goto L24;
        boolean r22 = true;
    L25:
        if (r22 == false) goto L49;
        if (r10.b == null) goto L49;
        wc9.e r23 = r10.a;
        if (r23 == null) goto L34;
        Map r24 = r23.x;
        if (r24 == null) goto L34;
        Map<String, String> r25 = MapsKt.toMutableMap(r24);
        if (r25 == null) goto L34;
    L36:
        if (i1.a(r10) == false) goto L43;
        BotStatusCacheDelegate r26 = BotStatusCacheDelegate.b;
        BotModel r27 = r10.b;
        if (r27 == null) goto L41;
        String r28 = r27.getBotId();
        if (r28 == null) goto L41;
    L42:
        r26.a(r28, true);
    L41:
        r28 = "";
    L43:
        ConversationModel r29 = r9.c;
        if (r29 == null) goto L49;
        BotModel r30 = r10.b;
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r12;
        r0.L$3 = r16;
        r0.label = 1;
        r6 = r29.createLocalConversation(r30, r25, r0);
        if (r6 != r2) goto L48;
        return r2;
    L34:
        r25 = new HashMap();
    L24:
        r22 = false;
    L19:
        r16 = null;
    L7:
        r0 = new ConversationClickHelper$directToRealtimeCall$1(r9, r13);
        goto L8
    }
}
