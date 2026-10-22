package com.larus.bmhome.chat.list.cell.prompt;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.auth.OnboardingActionCardItemData;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.bmhome.chat.layout.item.g3;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u0 implements Runnable {
    public final /* synthetic */ PromptCell a;
    public final /* synthetic */ int b;
    public final /* synthetic */ PromptContent c;
    public final /* synthetic */ Message d;

    public /* synthetic */ u0(PromptCell r1, int r2, PromptContent r3, Message r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        PromptCell r2 = this.a;
        int r0 = this.b;
        PromptContent r3 = this.c;
        Message r4 = this.d;
        r2.O = null;
        if (r2.P != r0) goto L227;
        r2.N.removeCallbacksAndMessages(null);
        FLogger r1 = FLogger.a;
        StringBuilder r6 = new StringBuilder("Report TIMESTAMP ");
        r6.append(System.currentTimeMillis());
        r6.append(", bindToken:");
        r6.append(r2.P);
        r6.append(", sugItem:");
        List<PromptContent.SuggestItem> r8 = r3.getSuggestItems();
        if (r8 == null) goto L7;
        Integer r9 = Integer.valueOf(r8.size());
    L8:
        r6.append(r9);
        r6.append(" sugV2:");
        List<PromptContent.SuggestV2> r10 = r3.getSuggestV2();
        if (r10 == null) goto L11;
        Integer r11 = Integer.valueOf(r10.size());
    L12:
        r6.append(r11);
        r1.d("WcbSugPromptCell", r6.toString());
        i1 r5 = r2.U;
        if (r5 == null) goto L226;
        PromptSpan r12 = r2.e;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r12 = null;
    L17:
        com.larus.bmhome.chat.api.q0 r13 = lf8.a.b(r2);
        OnboardingActionCardData r14 = r2.W;
        boolean r15 = r2.F(r4);
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r12, "span");
        Intrinsics.checkNotNullParameter(r3, "promptContent");
        List<String> r16 = r3.suggestTxt();
        int r17 = r3.getSuggestActionCardCnt();
        if (r17 == 0) goto L33;
        if (r14 == null) goto L33;
        List<OnboardingActionCardItemData> r18 = r14.a();
        if (r18 == null) goto L32;
        List<OnboardingActionCardItemData> r19 = r18;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator<T> r20 = r19.iterator();
    L24:
        if (r20.hasNext() == false) goto L31;
        OnboardingActionCardItemData r111 = (OnboardingActionCardItemData) r20.next();
        if (r111 == null) goto L29;
        String r112 = r111.d();
        if (r112 == null) goto L29;
    L30:
        r110.add(r112);
    L29:
        r112 = "";
        goto L30
    L31:
        r16 = r110;
        goto L33
    L32:
        r16 = null;
    L33:
        int r113 = r12.getBotViews().size();
        int r114 = r12.getSuggestViewList().size();
        boolean r7 = true;
        if (com.larus.bmhome.chat.bean.d.D(r4) == MessageTag.MessageTag_Unknown) goto L36;
        List<PromptContent.SuggestItem> r21 = r3.getSuggestItems();
        if (r21 == null) goto L138;
        Iterator<T> r22 = r21.iterator();
    L131:
        if (r22.hasNext() == false) goto L136;
        Object r115 = r22.next();
        if (Intrinsics.areEqual(((PromptContent.SuggestItem) r115).getItemType(), PromptContent.SuggestItemType.FestivalWelcomeBack.getValue()) == false) goto L131;
    L137:
        PromptContent.SuggestItem r116 = (PromptContent.SuggestItem) r115;
    L139:
        if (r116 == null) goto L142;
        String r23 = "spring_new_topic";
    L141:
        String r24 = r23;
        if (r13 == null) goto L149;
        ChatMessageList r25 = r13.B7();
        if (r25 == null) goto L149;
        Object r26 = r25.getTag(2131384073);
    L151:
        if (TypeIntrinsics.isMutableSet(r26) == false) goto L153;
        Set r27 = (Set) r26;
    L154:
        int r117 = gx9.o.a;
        Pair r28 = new Pair(r4, "onShowOnboardingCard");
        if (r27 != null) goto L157;
    L159:
        boolean r118 = false;
    L160:
        if (r118 == false) goto L170;
        r27.add(r28);
        int r29 = gx9.o.a;
        String r119 = r4.getMessageId();
        String r120 = r4.getSenderId();
        long r30 = r114;
        Integer r210 = r4.isConnectCallerName();
        String r211 = com.larus.bmhome.chat.bean.d.E(r4);
        if (r17 == 0) goto L166;
        String r31 = "function_card";
    L164:
        String r212 = r31;
        long r121 = r5.e();
        List<String> r122 = r16;
        gx9.o.i(r121, "onShowOnboardingCard", new gx9.l(r119, r120, r122, r210, r121, r211, r24, Long.valueOf(r30), null, null, com.larus.im.bean.message.a.x(r4), r212));
        goto L170
    L166:
        if (r12.h == false) goto L168;
        r31 = "multi_one_line";
        goto L164
    L168:
        r31 = "single_one_line";
    L170:
        long r32 = System.currentTimeMillis();
        com.larus.bmhome.chat.component.trace.z r33 = r5.c;
        if (r33 == null) goto L173;
        Long r34 = Long.valueOf(r33.fK());
    L175:
        if (r34 == null) goto L177;
        long r123 = RangesKt.coerceAtLeast(r32 - r34.longValue(), 0);
    L178:
        Map r124 = r4.getBusinessExt();
        if (r124 == null) goto L185;
        String r125 = (String) r124.get("time_after_prev_message");
        if (r125 == null) goto L185;
        Long r126 = StringsKt.toLongOrNull(r125);
        if (r126 == null) goto L185;
        int r127 = 1000;
        long r128 = RangesKt.coerceAtLeast(r126.longValue(), 0) * ((long) 1000);
    L186:
        long r129 = r127;
        long r130 = r123;
        long r35 = RangesKt.coerceAtLeast(r32 - (r4.getCreateTime() * r129), 0);
        FLogger.a.d("WcbSugPromptCell", "now = " + r32 + ", create = " + (r4.getCreateTime() * r129) + ", foregroundTime = " + r34 + ", timeAfterPrevMessage = " + r128 + ", timeAfterEnterForeground = " + r130 + ", timeAfterCreate = " + r35);
        String r36 = r4.getMessageId();
        String r37 = r4.getSenderId();
        String r38 = com.larus.bmhome.chat.bean.d.Z0(r4);
        if (r16 == null) goto L201;
        List<String> r39 = r16;
        if ((r39 instanceof Collection) == true) goto L191;
    L193:
        Iterator r40 = r39.iterator();
    L195:
        if (r40.hasNext() == false) goto L199;
        if (StringsKt.isBlank((String) r40.next()) == false) goto L195;
        boolean r131 = true;
    L200:
        boolean r310 = r131;
    L202:
        de8.c r41 = r5.a;
        if (r41 == null) goto L205;
        String r42 = r41.q();
    L206:
        boolean r311 = com.larus.utils.o0.d(r42);
        List<PromptContent.SuggestItem> r43 = r3.getSuggestItems();
        if (r43 == null) goto L222;
        List<PromptContent.SuggestItem> r44 = r43;
        if ((r44 instanceof Collection) == true) goto L211;
    L213:
        Iterator<T> r45 = r44.iterator();
    L215:
        if (r45.hasNext() == false) goto L219;
        if (Intrinsics.areEqual(((PromptContent.SuggestItem) r45.next()).isHighlightPush(), Boolean.TRUE) == false) goto L215;
        boolean r46 = true;
        boolean r132 = true;
    L220:
        if (r132 != r46) goto L222;
        boolean r312 = true;
    L223:
        IAIChatControlTraceService.a.Lb(r36, r37, r38, 2, r310, r311, r312, r5.e(), Long.valueOf(r128), Long.valueOf(r130), Long.valueOf(r35), com.larus.bmhome.chat.bean.d.x(r4).getNextPulseType());
    L219:
        r46 = true;
        r132 = false;
        goto L220
    L211:
        if (r44.isEmpty() == false) goto L213;
    L222:
        r312 = false;
        goto L223
    L205:
        r42 = null;
    L199:
        r131 = false;
        goto L200
    L191:
        if (r39.isEmpty() == false) goto L193;
    L201:
        r310 = false;
    L185:
        r127 = 1000;
        r128 = -1;
        goto L186
    L177:
        r123 = -1;
        goto L178
    L173:
        r34 = null;
        goto L175
    L157:
        if (r27.contains(r28) == true) goto L159;
        r118 = true;
        goto L160
    L153:
        r27 = null;
    L149:
        r26 = null;
        goto L151
    L142:
        if (r15 == false) goto L144;
        r23 = "new_topic";
        goto L141
    L144:
        r23 = com.larus.bmhome.chat.bean.d.Z0(r4);
        goto L141
    L136:
        r115 = null;
        goto L137
    L138:
        r116 = null;
        goto L139
    L36:
        if (r12.O == true) goto L38;
        if (r13 == null) goto L77;
        ChatMessageList r47 = r13.B7();
        if (r47 == null) goto L77;
        Object r48 = r47.getTag(2131384073);
    L79:
        if (TypeIntrinsics.isMutableSet(r48) == false) goto L81;
        Set r49 = (Set) r48;
    L82:
        String r50 = r4.getMessageId();
        int r51 = gx9.o.a;
        Pair r52 = new Pair(r50, "onShowSuggestedPrompt");
        String r53 = com.larus.bmhome.chat.bean.d.i(r4);
        int r54 = g3.a;
        if (Intrinsics.areEqual(r53, "coco_spring_festival_2025") == false) goto L85;
        String r133 = "spring_suggest";
        PromptContent.SuggestItem r134 = null;
    L108:
        if (r49 != null) goto L110;
    L112:
        r7 = false;
    L113:
        if (r7 == false) goto L226;
        r49.add(r52);
        List<PromptContent.SuggestV2> r55 = r3.getSuggestV2();
        if (r55 == null) goto L117;
        PromptContent.SuggestV2 r56 = (PromptContent.SuggestV2) CollectionsKt.firstOrNull(r55);
    L118:
        List<PromptContent.SuggestItem> r57 = r3.getSuggestItems();
        if (r57 == null) goto L121;
        r134 = (PromptContent.SuggestItem) CollectionsKt.firstOrNull(r57);
    L121:
        String r213 = i1.d(r56, r134);
        int r58 = gx9.o.a;
        String r59 = r4.getMessageId();
        if (r59 != null) goto L124;
        String r135 = "";
    L125:
        gx9.o.g(r135, r4.getSenderId(), r114, r113, r133, r5.e(), r4.getSectionId(), com.larus.bmhome.chat.bean.d.x(r4).getActionBarKey(), null, r213, IAIChatControlTraceService.a.tb(r4));
        goto L226
    L124:
        r135 = r59;
        goto L125
    L117:
        r56 = r134;
        goto L118
    L110:
        if (r49.contains(r52) == true) goto L112;
    L85:
        String r60 = r4.getLocalMessageId();
        if (r60 == null) goto L90;
        r134 = null;
        if (StringsKt.contains$default(r60, "-aweme", false, 2, null) != true) goto L91;
        boolean r136 = true;
    L92:
        if (r136 == false) goto L98;
        Map r61 = r4.getBusinessExt();
        if (r61 == null) goto L97;
        String r62 = (String) r61.get("suggested_type");
        if (r62 == null) goto L97;
    L107:
        r133 = r62;
    L97:
        r62 = "suggested_prompt";
        goto L107
    L98:
        List<PromptContent.SuggestV2> r63 = r3.getSuggestV2();
        if (r63 == null) goto L101;
        PromptContent.SuggestV2 r64 = (PromptContent.SuggestV2) CollectionsKt.firstOrNull(r63);
    L102:
        List<PromptContent.SuggestItem> r65 = r3.getSuggestItems();
        if (r65 == null) goto L105;
        PromptContent.SuggestItem r66 = (PromptContent.SuggestItem) CollectionsKt.firstOrNull(r65);
    L106:
        r62 = com.larus.bmhome.chat.bean.d.f1(r4, r64, r66);
        goto L107
    L105:
        r66 = r134;
        goto L106
    L101:
        r64 = r134;
    L91:
        r136 = false;
        goto L92
    L90:
        r134 = null;
        goto L91
    L81:
        r49 = null;
    L77:
        r48 = null;
        goto L79
    L38:
        if (r12.getImmerseBgColor() == null) goto L40;
        String r67 = "1";
    L41:
        int r68 = gx9.o.a;
        long r69 = r5.e();
        String r70 = r4.getSenderId();
        com.larus.bmhome.chat.trace.a r71 = IAIChatControlTraceService.a.gc(r69);
        if (r71 == null) goto L226;
        String r72 = r71.a;
        if (r72 != null) goto L47;
    L50:
        if (r7 == true) goto L53;
        r70 = r71.a;
    L53:
        if (r70 == null) goto L55;
        Long r73 = StringsKt.toLongOrNull(r70);
    L56:
        String r74 = gx9.o.d(r69);
        String r75 = r71.g;
        if (r75 == null) goto L59;
        Long r76 = StringsKt.toLongOrNull(r75);
    L60:
        boolean r77 = o3.a;
        JSONObject r78 = new JSONObject();
        Intrinsics.checkNotNullParameter(r78, "params");
        if (r73 != null) goto L229;
    L65:
        if (r74 == null) goto L67;
        r78.put("chat_type", r74);     // Catch: JSONException -> L63
    L67:
        if (r76 == null) goto L69;
        r78.put("conversation_id", r76.longValue());     // Catch: JSONException -> L63
    L69:
        r78.put("is_immersive_background", r67);     // Catch: JSONException -> L63
    L72:
        TrackParams r79 = new TrackParams().merge(r78);
        by7.a r80 = new by7.a("show_suggest_prompt_fold");
        r80.a.merge(r79);
        r80.b();
    L63:
        e = move-exception;
        FLogger.a.e("ShowEventHelper", "error in ShowEventHelper mobShowSuggestPromptFold " + e.getLocalizedMessage());
        goto L72
    L229:
        r78.put("bot_id", r73.longValue());     // Catch: JSONException -> L63
        goto L65
    L59:
        r76 = null;
        goto L60
    L55:
        r73 = null;
        goto L56
    L47:
        if (r72.length() == 0) goto L50;
        r7 = false;
        goto L50
    L40:
        r67 = "0";
    L226:
        r2.u(false);
        return;
    L11:
        r11 = null;
        goto L12
    L7:
        r9 = null;
        goto L8
    L227:
        FLogger.a.d("WcbSugPromptCell", "Prevent TIMESTAMP " + System.currentTimeMillis() + ", beforeBindToken:" + r0 + ",bindToken:" + r2.P);
    }
}
