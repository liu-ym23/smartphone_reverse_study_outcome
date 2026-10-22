package com.larus.bmhome.chat.list.cell.prompt;

import android.graphics.Rect;
import android.view.View;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.platform.spi.IAIChatControlTraceService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l0 implements Function0 {
    public final /* synthetic */ PromptCell a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ l0(PromptCell r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13, types: [com.larus.bmhome.chat.list.cell.prompt.h1] */
    public final Object invoke() {
        PromptCell r1 = this.a;
        boolean r2 = this.b;
        PromptSpan r3 = r1.e;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r3 = null;
    L5:
        Object r4 = r3.getSuggestViewList().clone();
        if ((r4 instanceof ArrayList) == false) goto L8;
        ArrayList r5 = (ArrayList) r4;
    L9:
        if (r5 == null) goto L236;
        Iterator r6 = r5.iterator();
        PromptCell r7 = r1;
        int r15 = 0;
    L12:
        if (r6.hasNext() == false) goto L236;
        Object r8 = r6.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        Pair r9 = (Pair) r8;
        View r10 = (View) r9.getFirst();
        PromptSpan.a.C0062a r11 = (PromptSpan.a.C0062a) r9.getSecond();
        if (r11 == null) goto L20;
        String r12 = r11.a;
        if (r12 == null) goto L20;
    L21:
        Pair<Integer, Integer> r13 = y0.a(r10);
        Rect r14 = new Rect();
        if (r10.getGlobalVisibleRect(r14) == true) goto L24;
    L233:
        PromptCell r0 = r1;
        Integer r16 = Integer.valueOf(r15);
        r7.K.put(r16, Boolean.FALSE);
    L234:
        r1 = r0;
        r15 = r17;
        r2 = r2;
        r6 = r6;
        goto L12
    L24:
        if (r14.width() <= 0) goto L233;
        if (r14.height() <= 0) goto L233;
        Object r18 = r7.K.get(Integer.valueOf(r15));
        Boolean r19 = Boolean.TRUE;
        if (Intrinsics.areEqual(r18, r19) == false) goto L32;
        if (r2 == true) goto L32;
        r0 = r1;
    L32:
        final HashMap r110 = new HashMap();
        Boolean r27 = r19;
        if (r7.U == null) goto L85;
        Intrinsics.checkNotNullParameter(r110, "extra");
        Intrinsics.checkNotNullParameter(r9, "pair");
        View r20 = (View) r9.getFirst();
        int r28 = r15;
        PromptSpan.a.C0062a r111 = (PromptSpan.a.C0062a) r9.getSecond();
        if (r111 == null) goto L38;
        String r112 = r111.b;
        if (r112 == null) goto L38;
    L39:
        String r113 = "extra";
        PromptSpan.a.C0062a r114 = (PromptSpan.a.C0062a) r9.getSecond();
        if (r114 == null) goto L43;
        String r115 = r114.c;
        if (r115 == null) goto L43;
    L44:
        String r21 = r12;
        PromptSpan.a.C0062a r22 = (PromptSpan.a.C0062a) r9.getSecond();
        if (r22 == null) goto L50;
        String r23 = r22.a;
        if (r23 == null) goto L50;
    L51:
        Intrinsics.checkNotNullParameter(r20, "view");
        r0 = r1;
        if (r20.getTag(2131388507) != null) goto L54;
    L56:
        String r24 = "";
    L57:
        String r25 = y0.b(r20);
        r110.put("item_id", r112);
        r110.put("item_type", r115);
        r110.put("item_content", r23);
        if (r24 != null) goto L60;
        r24 = "";
    L60:
        r110.put("recommend_botid", r24);
        PromptSpan.a.C0062a r26 = (PromptSpan.a.C0062a) r9.getSecond();
        if (r26 == null) goto L66;
        Integer r29 = r26.e;
        if (r29 == null) goto L66;
        r110.put("type", String.valueOf(r29.intValue()));
    L66:
        if (com.larus.utils.o0.d(r25) == false) goto L86;
        PromptContent.SuggestV2Extra r30 = y0.c(r25);
        if (r30 == null) goto L86;
        r110.put("isRecommendBot", "true");
        String r31 = r30.getRequestId();
        if (r31 != null) goto L72;
        r31 = "";
    L72:
        r110.put("request_id", r31);
        String r32 = r30.getRecommendBot1StType();
        if (r32 != null) goto L75;
        r32 = "";
    L75:
        r110.put("recommend_bot_1sttype", r32);
        String r33 = r30.getRecommendBot2ndType();
        if (r33 != null) goto L78;
        r33 = "";
    L78:
        r110.put("recommend_bot_2ndtype", r33);
        String r34 = r30.getRecommendBot3StType();
        if (r34 != null) goto L81;
        r34 = "";
    L81:
        r110.put("recommend_bot_3rdtype", r34);
        String r35 = r30.getRsRequestId();
        if (r35 != null) goto L84;
        r35 = "";
    L84:
        r110.put("rs_request_id", r35);
    L86:
        Object r36 = r10.getTag(2131387708);
        if ((r36 instanceof PromptContent.SuggestV2) == false) goto L89;
        PromptContent.SuggestV2 r37 = (PromptContent.SuggestV2) r36;
    L90:
        PromptCell$g r38 = r0.M;
        if (r38 == null) goto L230;
        final int r116 = ((Number) r13.getFirst()).intValue();
        int r117 = ((Number) r13.getSecond()).intValue();
        final String r39 = r21;
        Intrinsics.checkNotNullParameter(r39, "content");
        String r40 = r113;
        Intrinsics.checkNotNullParameter(r110, r40);
        if (r38.a == true) goto L230;
        com.larus.bmhome.chat.api.q0 r41 = lf8.a.b(r38.b);
        if (r41 == null) goto L100;
        ChatMessageList r42 = r41.B7();
        if (r42 == null) goto L100;
        Object r43 = r42.getTag(2131384073);
    L102:
        if (TypeIntrinsics.isMutableSet(r43) == false) goto L104;
        Set r118 = (Set) r43;
    L105:
        if (r37 == null) goto L112;
        Integer r119 = r37.getSuggestType();
        if (r119 == null) goto L112;
        int r44 = r119.intValue();
        int r120 = r117;
        if (r44 != 3) goto L113;
        boolean r45 = true;
    L114:
        if (r45 == false) goto L141;
        Pair r46 = TuplesKt.to(r38.c.getMessageId(), "deep_search_entry_show");
        if (r118 != null) goto L118;
    L120:
        boolean r121 = false;
    L121:
        if (r121 == false) goto L141;
        de8.c r122 = r38.b.y();
        if (r122 == null) goto L125;
        String r310 = r122.p();
    L126:
        String r123 = r38.c.getMessageId();
        if (r123 == null) goto L129;
        String r311 = com.larus.bmhome.social.userchat.model.b0.d(r123);
    L130:
        PromptCell r124 = r38.b;
        String r125 = r124.H;
        de8.c r126 = r124.y();
        if (r126 == null) goto L134;
        String r127 = r126.f();
        if (r127 == null) goto L134;
    L137:
        String r312 = r127;
    L139:
        Intrinsics.checkNotNullParameter("suggest_prompt", "enterMethod");
        sf8.n.b("deep_search_button_show", r310, r311, r125, r312, new sf8.j("suggest_prompt"));
        r118.add(r46);
    L134:
        ChatParam r128 = (ChatParam) r38.b.f.getValue();
        if (r128 == null) goto L138;
        r127 = r128.b;
        goto L137
    L138:
        r312 = null;
        goto L139
    L129:
        r311 = null;
        goto L130
    L125:
        r310 = null;
        goto L126
    L118:
        if (r118.contains(r46) == true) goto L120;
        r121 = true;
    L141:
        List<PromptContent.SuggestItem> r47 = r38.d.getSuggestItems();
        int r129 = r28;
        if (r47 == null) goto L144;
        PromptContent.SuggestItem r48 = (PromptContent.SuggestItem) CollectionsKt.getOrNull(r47, r129);
    L146:
        if (com.larus.bmhome.chat.bean.d.D(r38.c) != MessageTag.MessageTag_Unknown) goto L229;
        Message r130 = r38.c;
        int r131 = gx9.o.a;
        Triple r49 = new Triple(r130, r39, "onShowSuggestedPromptSingleQuestion");
        if (r118 != null) goto L150;
    L152:
        boolean r50 = false;
    L153:
        if (r50 == false) goto L227;
        i1 r51 = r38.b.U;
        if (r51 == null) goto L225;
        final Message r52 = r38.c;
        Intrinsics.checkNotNullParameter(r52, "data");
        Intrinsics.checkNotNullParameter(r110, r40);
        if (r37 == null) goto L164;
        Integer r53 = r37.getSuggestType();
        if (r53 == null) goto L164;
        if (r53.intValue() != 5) goto L164;
        boolean r54 = true;
    L165:
        if (r54 == false) goto L167;
    L177:
        Triple r313 = r49;
        String r210 = "onShowSuggestedPromptSingleQuestion";
        Set r314 = r118;
        PromptContent.SuggestV2ExtraForMultiAction r132 = null;
    L178:
        if (r37 == null) goto L180;
        PromptContent.SuggestV2ExtraForMultiAction r55 = r37.getSuggestV2ExtForMultiAction();
    L181:
        final PromptContent.SuggestV2 r211 = r37;
        final PromptContent.SuggestItem r212 = r48;
        final PromptContent.SuggestV2ExtraForMultiAction r213 = r55;
        ?? r56 = new h1(r52, r211, r212, r110, r213);
        String r410 = i1.d(r37, r48);
        int r57 = gx9.o.a;
        String r58 = r52.getMessageId();
        if (r58 != null) goto L184;
        r58 = "";
    L184:
        String r59 = (String) r56.invoke();
        int r315 = r116 + 1;
        long r60 = r51.e();
        String r61 = (String) r110.get("request_id");
        if (r61 != null) goto L187;
        String r411 = "";
    L188:
        String r62 = (String) r110.get("rs_request_id");
        if (r62 != null) goto L191;
        String r412 = "";
    L192:
        String r63 = (String) r110.get("recommend_botid");
        if (r63 != null) goto L195;
        String r413 = "";
    L196:
        String r64 = (String) r110.get("recommend_bot_1sttype");
        if (r64 != null) goto L199;
        String r414 = "";
    L200:
        String r65 = (String) r110.get("recommend_bot_2ndtype");
        if (r65 != null) goto L203;
        String r415 = "";
    L204:
        String r66 = (String) r110.get("recommend_bot_3rdtype");
        if (r66 != null) goto L207;
        String r510 = "";
    L208:
        String r416 = r52.getSectionId();
        String r417 = com.larus.bmhome.chat.bean.d.x(r52).getActionBarKey();
        String r511 = (String) r110.get("item_id");
        if (r55 == null) goto L211;
        String r512 = r55.getSuggestActionType();
    L212:
        if (r55 == null) goto L214;
        String r513 = r55.getActionBarTemplateId();
    L215:
        if (r55 == null) goto L217;
        String r514 = r55.getActionBarItemId();
    L218:
        if (r55 == null) goto L220;
        String r515 = r55.getActionBarKey();
    L221:
        if (r48 == null) goto L223;
        String r516 = r48.getItemType();
    L224:
        String r517 = IAIChatControlTraceService.a.tb(r52);
        Intrinsics.checkNotNullParameter(r58, "messageId");
        Intrinsics.checkNotNullParameter(r59, "suggestedType");
        gx9.m r67 = new gx9.m(r315, r58, r416, r410, r417, r59, r411, r412, r413, r414, r415, r510, r511, r512, r513, r514, r515, r516, r517, null);
        gx9.o.i(r60, r210, r67);
        Triple r68 = r313;
    L226:
        r314.add(r68);
    L228:
        final int r133 = r129;
    L232:
        Integer r69 = Integer.valueOf(r133);
        r0.K.put(r69, r27);
        r7 = r0;
        goto L234
    L223:
        r516 = r132;
        goto L224
    L220:
        r515 = r132;
        goto L221
    L217:
        r514 = r132;
        goto L218
    L214:
        r513 = r132;
        goto L215
    L211:
        r512 = r132;
        goto L212
    L207:
        r510 = r66;
        goto L208
    L203:
        r415 = r65;
        goto L204
    L199:
        r414 = r64;
        goto L200
    L195:
        r413 = r63;
        goto L196
    L191:
        r412 = r62;
        goto L192
    L187:
        r411 = r61;
    L180:
        r55 = r132;
        goto L181
    L167:
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r52).getActionBarKey(), "coco_spring_festival_2025") == true) goto L177;
        String r70 = r52.getLocalMessageId();
        if (r70 == null) goto L173;
        r313 = r49;
        r210 = "onShowSuggestedPromptSingleQuestion";
        r314 = r118;
        r132 = null;
        boolean r71 = true;
        if (StringsKt.contains$default(r70, "-aweme", false, 2, null) == true) goto L175;
    L174:
        r71 = false;
    L175:
        if (r71 == false) goto L180;
    L173:
        r313 = r49;
        r210 = "onShowSuggestedPromptSingleQuestion";
        r314 = r118;
        r132 = null;
    L164:
        r54 = false;
        goto L165
    L225:
        r314 = r118;
        r132 = null;
        r68 = r49;
        goto L226
    L227:
        r132 = null;
        goto L228
    L150:
        if (r118.contains(r49) == true) goto L152;
        r50 = true;
        goto L153
    L229:
        final Set r72 = r118;
        StringBuilder r73 = new StringBuilder();
        r73.append(r38.c.getMessageId());
        r73.append(',');
        r73.append(r116);
        r73.append(',');
        final int r74 = r120;
        r73.append(r74);
        String r75 = r73.toString();
        ConcurrentHashMap r76 = com.larus.bmhome.chat.trace.k0.a;
        final Message r77 = r38.c;
        final PromptCell r78 = r38.b;
        final PromptContent r134 = r38.d;
        final PromptContent.SuggestItem r135 = r48;
        r27 = r27;
        r133 = r129;
        r0 = r0;
        com.larus.bmhome.chat.trace.k0.a(r75, new v0(r77, r39, r78, r72, r110, r135, r134, r116, r74, r133));
        goto L232
    L144:
        r48 = null;
    L113:
        r45 = false;
    L112:
        r120 = r117;
        goto L113
    L104:
        r118 = null;
    L100:
        r43 = null;
    L230:
        r133 = r28;
        goto L232
    L89:
        r37 = null;
        goto L90
    L54:
        if ((r20.getTag(2131388507) instanceof String) == false) goto L56;
        Object r79 = r20.getTag(2131388507);
        Intrinsics.checkNotNull(r79, "null cannot be cast to non-null type kotlin.String");
        r24 = (String) r79;
    L50:
        r23 = "";
    L43:
        r115 = "";
    L38:
        r112 = "";
        goto L39
    L85:
        r0 = r1;
        r21 = r12;
        r13 = r13;
        r113 = "extra";
        r28 = r15;
    L20:
        r12 = "";
    L236:
        return Unit.INSTANCE;
    L8:
        r5 = null;
        goto L9
    }
}
