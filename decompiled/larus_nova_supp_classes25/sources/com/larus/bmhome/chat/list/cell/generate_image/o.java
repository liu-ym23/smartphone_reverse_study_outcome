package com.larus.bmhome.chat.list.cell.generate_image;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.f0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.list.cell.progress_loading.BaseProgressLoadingCell;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.service.AccountService;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lf8.a;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements Function1 {
    public final /* synthetic */ GenerateImageCell a;

    public /* synthetic */ o(GenerateImageCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r14) {
        GenerateImageCell r0 = this.a;
        Message r15 = (Message) r14;
        ConcurrentHashMap.KeySetView r1 = GenerateImageCell.A;
        y r2 = r0.s();
        Object r3 = null;
        if (r2 == null) goto L5;
        BotModel r4 = r2.j0();
    L6:
        y r5 = r0.s();
        if (r5 == null) goto L9;
        wc9.e r6 = r5.h();
    L10:
        if (r15 == null) goto L16;
        q0 r7 = a.b(r0);
        if (r7 == null) goto L14;
        List r8 = r7.getCurrentList();
    L15:
        Message r9 = f0.c(r15, r8);
    L17:
        Pair[] r10 = new Pair[12];
        boolean r11 = false;
        r10[0] = TuplesKt.to("user_type", "bot");
        String r12 = "chat";
        r10[1] = TuplesKt.to("enter_picture_method", "chat");
        com.larus.bmhome.chat.component.collection.o r13 = (com.larus.bmhome.chat.component.collection.o) r0.u.getValue();
        if (r13 != null) goto L20;
    L22:
        boolean r16 = false;
    L23:
        if (r16 == false) goto L25;
        r12 = "temporary_chat";
    L25:
        r10[2] = TuplesKt.to("enter_from", r12);
        String r17 = "";
        if (r15 == null) goto L29;
        String r18 = r15.getMessageId();
        if (r18 == null) goto L29;
    L30:
        r10[3] = TuplesKt.to("message_id", r18);
        if (r15 == null) goto L34;
        String r19 = r15.getConversationId();
        if (r19 == null) goto L34;
    L35:
        r10[4] = TuplesKt.to("conversation_id", r19);
        if (r4 == null) goto L39;
        String r20 = r4.getBotId();
        if (r20 == null) goto L39;
    L40:
        r10[5] = TuplesKt.to("bot_id", r20);
        ChatControlTrace r21 = ChatControlTrace.b;
        if (r6 == null) goto L43;
        Integer r22 = r6.v;
    L44:
        if (r4 == null) goto L46;
        Integer r110 = r4.getBotType();
    L47:
        if (r4 == null) goto L51;
        BotCreatorInfo r23 = r4.getBotCreatorInfo();
        if (r23 == null) goto L51;
        String r24 = r23.getId();
    L52:
        r10[6] = TuplesKt.to("chat_type", r21.g(r22, r110, Intrinsics.areEqual(r24, AccountService.a.getUserId())));
        String r25 = ((ChatParam) ((BaseProgressLoadingCell) r0).m.getValue()).d;
        if (r25 != null) goto L55;
        r25 = "";
    L55:
        r10[7] = TuplesKt.to("current_page", r25);
        String r26 = ((ChatParam) ((BaseProgressLoadingCell) r0).m.getValue()).c;
        if (r26 != null) goto L58;
        r26 = "";
    L58:
        r10[8] = TuplesKt.to("previous_page", r26);
        if (r15 != null) goto L61;
    L63:
        String r27 = "0";
        if (r11 == false) goto L66;
        String r28 = "1";
    L67:
        r10[9] = TuplesKt.to("is_feely_img", r28);
        if (r15 == null) goto L73;
        String r29 = l3.f(Boolean.valueOf(com.larus.im.bean.message.a.C0(r15)));
        if (r29 == null) goto L73;
        r27 = r29;
    L73:
        r10[10] = TuplesKt.to("is_deep_thinking", r27);
        if (r15 == null) goto L76;
        String r111 = tz9.a.a(r15);
    L77:
        if (r111 == null) goto L80;
        r17 = r111;
    L80:
        r10[11] = TuplesKt.to("ai_create_show_mode", r17);
        Map r112 = MapsKt.mutableMapOf(r10);
        if (r9 == null) goto L124;
        Map r30 = r9.getExt();
        if (r30 == null) goto L124;
        String r31 = (String) r30.get("creation_template");
        if (r31 == null) goto L124;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L101
        zd9.h r33 = zd9.h.a;     // Catch: Throwable -> L101
        if (StringsKt.isBlank(r31) == false) goto L125;
    L98:
        Object r34 = null;
    L99:
        Object r35 = Result.constructor-impl((Map) r34);     // Catch: Throwable -> L101
    L104:
        if (Result.isFailure-impl(r35) == true) goto L107;
        r3 = r35;
    L107:
        Map r36 = (Map) r3;
        if (r36 == null) goto L112;
        String r37 = (String) r36.get("recommend_from");
        if (r37 == null) goto L112;
        String r38 = (String) r112.put("recommend_from", r37);
    L112:
        if (r36 == null) goto L116;
        String r39 = (String) r36.get("template_rec_extra");
        if (r39 == null) goto L116;
        String r40 = (String) r112.put("template_rec_extra", r39);
    L116:
        if (r36 == null) goto L120;
        String r41 = (String) r36.get("template_rec_req_id");
        if (r41 == null) goto L120;
        String r42 = (String) r112.put("template_rec_req_id", r41);
    L120:
        if (r36 == null) goto L124;
        String r43 = (String) r36.get("from_template_id");
        if (r43 == null) goto L124;
        r112.put("from_template_id", r43);
        goto L124
    L125:
        r33.getClass();     // Catch: Throwable -> L91
        r34 = Result.constructor-impl(zd9.h.b.fromJson(r31, new GenerateImageCell$b().getType()));     // Catch: Throwable -> L91
    L93:
        Throwable r44 = Result.exceptionOrNull-impl(r34);     // Catch: Throwable -> L101
        if (r44 == null) goto L97;
        c0 r45 = c0.b;     // Catch: Throwable -> L101
        StringBuilder r46 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L101
        Intrinsics.checkNotNullParameter(r44, "<this>");     // Catch: Throwable -> L101
        r46.append(ExceptionsKt.stackTraceToString(r44));     // Catch: Throwable -> L101
        r45.e("GsonHolder", r46.toString());     // Catch: Throwable -> L101
    L97:
        if (Result.isFailure-impl(r34) == false) goto L99;
    L91:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L101
        r34 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
    L124:
        return r112;
    L76:
        r111 = null;
        goto L77
    L66:
        r28 = "0";
        goto L67
    L61:
        if (com.larus.bmhome.chat.bean.d.y(r15) != true) goto L63;
        r11 = true;
    L51:
        r24 = null;
        goto L52
    L46:
        r110 = null;
        goto L47
    L43:
        r22 = null;
    L39:
        r20 = "";
    L34:
        r19 = "";
    L29:
        r18 = "";
        goto L30
    L20:
        if (r13.i0() != true) goto L22;
        r16 = true;
        goto L23
    L14:
        r8 = null;
        goto L15
    L16:
        r9 = null;
        goto L17
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
