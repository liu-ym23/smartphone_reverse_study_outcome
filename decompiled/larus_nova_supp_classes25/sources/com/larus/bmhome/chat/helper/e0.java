package com.larus.bmhome.chat.helper;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.utils.w2;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.block.AuthIdentityBlock;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import v19.j5;
import yc9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 {
    public static final Set<Integer> a = null;
    public static final Regex b = null;

    static {
        a = SetsKt.setOf(new Integer[]{3, 4});
        b = new Regex("((\\(\\*).+?(\\*\\)))|((（\\*).+?(\\*）))");
    }

    public static String c(wh8.a r10) {
        wc9.e r0 = r10.a;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L6:
        com.larus.bmhome.chat.model.x r2 = com.larus.bmhome.chat.model.x.a;
        if (r2.f(r1, com.larus.bmhome.chat.model.x.c) == true) goto L9;
        return null;
    L9:
        BotModel r11 = r10.b;
        if (r11 == null) goto L12;
        Integer r12 = r11.getBotType();
    L13:
        FLogger.a.d("ChatDraftRepo", "getDraftBrief conversationId:" + r1);
        List r3 = com.larus.bmhome.chat.model.x.e(r2, r1, null, null, 6);
        StringBuilder r4 = new StringBuilder();
        List r5 = r3;
        Iterator r6 = r5.iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r7).getType(), ChatDraftItem.TYPE_NESTED_FILE) == false) goto L15;
    L20:
        ChatDraftItem r8 = (ChatDraftItem) r7;
        if (r8 != null) goto L23;
    L32:
        Iterator r9 = r5.iterator();
    L34:
        if (r9.hasNext() == false) goto L38;
        Object r13 = r9.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r13).getType(), ChatDraftItem.TYPE_TEXT) == false) goto L34;
    L39:
        ChatDraftItem r14 = (ChatDraftItem) r13;
        if (r14 != null) goto L42;
    L44:
        boolean r15 = true;
        if (com.larus.bmhome.chat.manager.l0.a(r12) == false) goto L58;
        Iterator r16 = r5.iterator();
    L48:
        if (r16.hasNext() == false) goto L52;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r17).getType(), ChatDraftItem.TYPE_REPLY) == false) goto L48;
    L53:
        ChatDraftItem r18 = (ChatDraftItem) r17;
        if (r18 == null) goto L58;
        if (com.larus.bmhome.chat.model.z.a(r18) == false) goto L58;
        boolean r19 = true;
    L59:
        Iterator r20 = r5.iterator();
    L61:
        if (r20.hasNext() == false) goto L65;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((ChatDraftItem) r21).getType(), ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) == false) goto L61;
    L66:
        ChatDraftItem r22 = (ChatDraftItem) r21;
        if (r22 != null) goto L69;
    L71:
        boolean r23 = false;
    L73:
        if (r4.length() <= 0) goto L75;
        boolean r24 = true;
    L76:
        if (r24 == true) goto L79;
        if (r19 == true) goto L79;
        if (r23 == true) goto L79;
    L80:
        String r110 = r4.toString();
        if (r110.length() > 0) goto L84;
        r15 = false;
    L84:
        if (r15 == true) goto L86;
        return null;
    L86:
        return r110;
    L79:
        z2.a.w3();
        r4.insert(0, "[" + AppHost.a.getApplication().getString(2131900781) + "] ");
        goto L80
    L75:
        r24 = false;
        goto L76
    L69:
        if (com.larus.bmhome.chat.model.z.a(r22) != true) goto L71;
        r23 = true;
        goto L73
    L65:
        r21 = null;
        goto L66
    L52:
        r17 = null;
    L58:
        r19 = false;
        goto L59
    L42:
        if (com.larus.bmhome.chat.model.z.a(r14) == false) goto L44;
        r4.append(r14.getContent());
        goto L44
    L38:
        r13 = null;
        goto L39
    L23:
        if (com.larus.bmhome.chat.model.z.a(r8) == false) goto L32;
        int r25 = v0.h(r8.getNestedFileContent());
        int r26 = v0.c(r8.getNestedFileContent());
        int r27 = v0.e(r8.getNestedFileContent());
        if (r27 <= 0) goto L27;
        r4.append(AppHost.a.getApplication().getString(2131900789) + ' ');
    L27:
        if (r26 <= 0) goto L30;
        r4.append(AppHost.a.getApplication().getString(2131900783) + ' ');
    L30:
        if (r25 <= (r26 + r27)) goto L32;
        r4.append(AppHost.a.getApplication().getString(2131905683) + ' ');
        goto L32
    L19:
        r7 = null;
        goto L20
    L12:
        r12 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public static CharSequence d(String r14) {
        Intrinsics.checkNotNullParameter(r14, "originString");
        int r3 = 0;
        List r0 = SequencesKt.toList(Regex.findAll$default(b, r14, 0, 2, null));     // Catch: Exception -> L21
        if ((!r0.isEmpty()) == false) goto L23;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L21
        Iterator r1 = r0.iterator();     // Catch: Exception -> L21
        String r4 = r14;
    L7:
        if (r1.hasNext() == false) goto L9;
        MatchResult r5 = (MatchResult) r1.next();     // Catch: Exception -> L21
        String r12 = r5.getValue();     // Catch: Exception -> L21
        IntRange r13 = r5.getRange();     // Catch: Exception -> L21
        r4 = StringsKt.replaceFirst$default(r4, r12, StringsKt.replace$default(r12, "*", "", false, 4, null), false, 4, null);     // Catch: Exception -> L21
        int r6 = (r13.getFirst() + 1) - (r3 * 2);     // Catch: Exception -> L21
        r3 = r3 + 1;     // Catch: Exception -> L21
        r2.add(new IntRange(r6, r13.getLast() - (r3 * 2)));     // Catch: Exception -> L21
        goto L7
    L9:
        SpannableString r7 = new SpannableString(r4);     // Catch: Exception -> L21
        Iterator r8 = r2.iterator();     // Catch: Exception -> L21
    L10:
        if (r8.hasNext() == false) goto L20;
        IntRange r9 = (IntRange) r8.next();     // Catch: Exception -> L21
        if (r9.getFirst() <= 0) goto L10;
        if (r9.getLast() <= 0) goto L10;
        if (r9.getLast() < r9.getFirst()) goto L10;
        r7.setSpan(new StyleSpan(2), r9.getFirst(), r9.getLast(), 33);     // Catch: Exception -> L21
        goto L10
    L20:
        return r7;
    L23:
        return r14;
    L21:
        e = move-exception;
        FLogger.a.e("ConversationBriefHelper", e.getMessage());
        goto L23
    }

    public static String a(Context r11, wh8.a r12, boolean r13) {
        wc9.e r0 = r12.a;
        Message r1 = r12.c;
        boolean r3 = true;
        String r5 = null;
        if (r12.b == null) goto L30;
        if (r0 == null) goto L10;
        String r2 = r0.a;
        if (r2 == null) goto L10;
        Lazy r10 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (com.larus.im.j.f(r2) != true) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L30;
        BotModel r14 = r12.b;
        if (r14 == null) goto L17;
        BotOnBoarding r15 = r14.getOnBoarding();
        if (r15 == null) goto L17;
        String r16 = r15.getPrologue();
    L19:
        if (com.larus.utils.o0.d(r16) == false) goto L23;
        if (r16 != null) goto L110;
        return "";
    L110:
        return r16;
    L23:
        String r6 = r11.getString(2131906312);
        if (r13 == false) goto L111;
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("#1 handleConversationMessage: brief = ");
        r18.append(r6);
        r18.append(", cvsId:");
        if (r0 == null) goto L28;
        r5 = r0.a;
    L28:
        r18.append(r5);
        r17.i("ConversationBriefHelper", r18.toString());
        return r6;
    L111:
        return r6;
    L17:
        r16 = null;
    L10:
        r4 = false;
    L30:
        Set<Integer> r7 = a;
        if (r0 == null) goto L33;
        Integer r19 = r0.t;
    L35:
        if (CollectionsKt.contains(r7, r19) == false) goto L43;
        String r110 = r11.getString(2131906312);
        if (r13 == false) goto L42;
        FLogger r111 = FLogger.a;
        StringBuilder r112 = new StringBuilder("#2 handleConversationMessage: brief = ");
        r112.append(r110);
        r112.append(", cvsId:");
        if (r0 == null) goto L41;
        r5 = r0.a;
    L41:
        r112.append(r5);
        r111.i("ConversationBriefHelper", r112.toString());
    L42:
        return r110;
    L43:
        if (r0 == null) goto L50;
        Integer r8 = r0.j;
        if (r8 == null) goto L50;
        if (r8.intValue() != 2) goto L50;
        boolean r9 = true;
    L51:
        if (r9 == false) goto L64;
        if (r1 == null) goto L54;
        String r20 = r1.getSenderId();
    L56:
        if (Intrinsics.areEqual(r20, AccountService.a.getUserId()) == true) goto L64;
        if (r1 != null) goto L59;
    L61:
        boolean r21 = false;
    L62:
        if (r21 == true) goto L64;
    L65:
        boolean r22 = true;
    L67:
        if (r22 == false) goto L92;
        String r23 = r12.d;
        if (com.larus.utils.o0.d(r23) == false) goto L73;
        return r23 + ": " + b(r11, r0, r1, r13);
    L73:
        if (ic8.n.w(r0) == false) goto L90;
        String r113 = r12.h;
        if (r113 != null) goto L77;
    L80:
        if (r3 == false) goto L90;
        if (AppHost.a.isOversea() == false) goto L87;
        String r114 = j5.a(r11, 2131894311, 2131901952);
        if (r114 != null) goto L113;
        return "";
    L113:
        return r114;
    L87:
        String r24 = r11.getString(2131901360);
        Intrinsics.checkNotNull(r24);
        return r24;
    L77:
        if (r113.length() == 0) goto L80;
        r3 = false;
    L90:
        return b(r11, r0, r1, r13);
    L92:
        if (f.a(r0) == false) goto L109;
        if (r1 != null) goto L95;
    L97:
        r3 = false;
    L98:
        if (r3 == false) goto L109;
        String r115 = f.b();
        if (r115 != null) goto L102;
        r115 = r11.getString(2131906312);
    L102:
        if (r13 == false) goto L107;
        FLogger r116 = FLogger.a;
        StringBuilder r117 = new StringBuilder("#3 handleConversationMessage: brief = ");
        r117.append(r115);
        r117.append(", cvsId:");
        if (r0 == null) goto L106;
        r5 = r0.a;
    L106:
        r117.append(r5);
        r116.i("ConversationBriefHelper", r117.toString());
    L107:
        return r115;
    L95:
        if (com.larus.bmhome.chat.bean.d.k0(r1) != true) goto L97;
    L109:
        return b(r11, r0, r1, r13);
    L59:
        if (r1.getContentType() != 1001) goto L61;
        r21 = true;
        goto L62
    L54:
        r20 = null;
    L64:
        if (ic8.n.q(r0) == true) goto L65;
        r22 = false;
    L50:
        r9 = false;
        goto L51
    L33:
        r19 = null;
        goto L35
    }

    public static String b(Context r16, wc9.e r17, Message r18, boolean r19) {
        String r4 = null;
        if (r18 != null) goto L11;
        if (r19 == false) goto L10;
        FLogger r2 = FLogger.a;
        StringBuilder r5 = new StringBuilder("#4 handleConversationMessage, cvsId:");
        if (r17 == null) goto L8;
        r4 = r17.a;
    L8:
        r5.append(r4);
        r2.i("ConversationBriefHelper", r5.toString());
    L10:
        return r16.getString(2131906312);
    L11:
        List r6 = r18.getContentBlock();
        if (r6 != null) goto L14;
        r6 = CollectionsKt.emptyList();
    L14:
        List r7 = r6;
        if (r7.isEmpty() == false) goto L17;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        r7 = vd9.r.a(r18);
    L17:
        List r8 = r7;
        boolean r9 = true;
        if ((r8 instanceof Collection) == true) goto L20;
    L22:
        Iterator r10 = r8.iterator();
    L24:
        if (r10.hasNext() == false) goto L37;
        Block r11 = (Block) r10.next();
        if (r11.getBlockType() == BlockType.BLOCK_TYPE_BIZ_MERGE_FORWARD.getValue()) goto L34;
        BlockContent r12 = r11.getContent();
        if (r12 == null) goto L30;
        BizMergeForwardBlock r13 = r12.getBizMergeForwardBlock();
    L31:
        if (r13 != null) goto L34;
        boolean r14 = false;
    L35:
        if (r14 == false) goto L24;
        boolean r15 = true;
    L39:
        if (r15 == true) goto L41;
        CopyOnWriteArraySet r20 = xc8.f.a;
        Iterator r21 = ((ArrayList) xc8.f.b()).iterator();
    L44:
        if (r21.hasNext() == false) goto L53;
        Object r110 = r21.next();
        xc8.g r111 = (xc8.g) r110;
        if (r111.a(r18) == true) goto L48;
    L50:
        boolean r112 = false;
    L51:
        if (r112 == false) goto L44;
    L54:
        xc8.g r113 = (xc8.g) r110;
        String r22 = com.larus.bmhome.chat.bean.d.H(r18);
        if (r18.getContentType() != 800) goto L60;
        if (Intrinsics.areEqual(r18.getBizContentType(), "dora_record") == false) goto L60;
        String r0 = r16.getString(2131907355);
    L234:
        Intrinsics.checkNotNull(r0);
        if (r9 == true) goto L237;
        return r0;
    L237:
        return "[" + r0 + ']';
    L60:
        if (r18.getMessageStatusLocal() != 20) goto L62;
    L232:
        r22 = r16.getString(2131900777);
    L233:
        r0 = r22;
        r9 = false;
        goto L234
    L62:
        if (r18.getMessageStatusLocal() == 24) goto L232;
        if (r18.getMessageStatusLocal() != 10) goto L68;
        r22 = r16.getString(2131900787);
        goto L233
    L68:
        if ((r113 instanceof zc8.b) == false) goto L71;
        r22 = r16.getString(2131900811);
        goto L233
    L71:
        if (r18.getContentType() != 66) goto L86;
        ConcurrentHashMap r1 = w2.a;
        int r3 = w2.a(r18.getMessageId());
        List r23 = r18.getSubList();
        if (r23 == null) goto L75;
        Message r24 = (Message) CollectionsKt.getOrNull(r23, r3);
    L76:
        if (r24 == null) goto L79;
        r22 = com.larus.bmhome.chat.bean.d.H(r24);
        if (r22 != null) goto L233;
    L79:
        String r25 = r18.getBrief();
        if (com.larus.utils.o0.d(r25) == false) goto L82;
        r4 = r25;
    L82:
        if (r4 != null) goto L84;
        r22 = r16.getString(2131906312);
    L84:
        r22 = r4;
        goto L233
    L75:
        r24 = null;
        goto L76
    L86:
        if (r18.getContentType() != 67) goto L104;
        Integer r26 = com.larus.im.bean.message.a.H(r18);
        ConcurrentHashMap r27 = w2.a;
        int r28 = w2.a(r18.getMessageId());
        if (r26 == null) goto L90;
        r28 = r26.intValue();
    L90:
        List r29 = r18.getSubListGroup();
        if (r29 == null) goto L95;
        List r30 = (List) CollectionsKt.getOrNull(r29, r28);
        if (r30 == null) goto L95;
        Message r31 = (Message) CollectionsKt.getOrNull(r30, 0);
    L96:
        if (r31 == null) goto L99;
        r22 = com.larus.bmhome.chat.bean.d.H(r31);
        if (r22 != null) goto L233;
    L99:
        String r32 = r18.getBrief();
        if (com.larus.utils.o0.d(r32) == false) goto L102;
        r4 = r32;
    L102:
        if (r4 != null) goto L84;
        r22 = r16.getString(2131906312);
    L95:
        r31 = null;
        goto L96
    L104:
        String r114 = r18.getBrief();
        if (r114 != null) goto L107;
    L109:
        boolean r115 = false;
    L111:
        if (r115 == true) goto L113;
    L119:
        String r116 = r18.getBrief();
        if (r116 != null) goto L122;
    L124:
        boolean r117 = false;
    L125:
        if (r117 == false) goto L129;
        r22 = r18.getBrief();
        if (r22 != null) goto L233;
        r22 = "";
        goto L233
    L129:
        int r118 = 2131900783;
        if (r18.getContentType() != 6) goto L132;
    L231:
        r0 = r16.getString(2131900783);
        goto L234
    L132:
        if (dp8.a.a(r18) == true) goto L231;
        if (r18.getContentType() != 3) goto L138;
        r22 = r16.getString(2131900786);
        goto L233
    L138:
        if (r18.getContentType() != 5) goto L141;
        r22 = r16.getString(2131900789);
        goto L233
    L141:
        if (r18.getContentType() != 50) goto L144;
        r22 = r16.getString(2131900785);
        goto L233
    L144:
        if (r18.getContentType() != 7) goto L147;
        r0 = r16.getString(2131905683);
        goto L234
    L147:
        if (lr8.c.a(r18) == false) goto L156;
        NestedFileContent r33 = com.larus.bmhome.chat.bean.d.f(r18);
        int r34 = v0.h(r33);
        int r35 = v0.c(r33);
        int r36 = v0.e(r33);
        if (r34 == r35) goto L154;
        if (r34 != r36) goto L153;
        r118 = 2131900789;
        goto L154
    L153:
        r118 = 2131905683;
    L154:
        r0 = r16.getString(r118);
        goto L234
    L156:
        if (r18.getContentType() != 8) goto L159;
        r22 = r16.getString(2131900779);
        goto L233
    L159:
        if (r18.getContentType() != 70) goto L162;
        r22 = r16.getString(2131900786);
        goto L233
    L162:
        if (r18.getContentType() != 72) goto L165;
        r22 = r16.getString(2131900786);
        goto L233
    L165:
        if (r18.getContentType() != 9) goto L168;
        r22 = r16.getString(2131900789);
        goto L233
    L168:
        if (r18.getContentType() != 60) goto L171;
        r22 = r16.getString(2131900779);
        goto L233
    L171:
        if (r22 != null) goto L173;
    L175:
        boolean r37 = false;
    L176:
        if (r37 == false) goto L178;
        r22 = r16.getString(2131900783);
        goto L233
    L178:
        if (r22 != null) goto L180;
    L182:
        boolean r38 = false;
    L183:
        if (r38 == false) goto L186;
        r22 = r16.getString(2131900780);
        goto L233
    L186:
        if (com.larus.bmhome.utils.i.f(r17) == false) goto L191;
        if (com.larus.bmhome.chat.bean.d.W0(r18) == false) goto L191;
        r22 = r16.getString(2131910018);
    L191:
        if (com.larus.im.bean.message.a.d0(r18) == false) goto L199;
        int r39 = com.larus.bmhome.u.a;
        if (r16 == null) goto L196;
        r4 = r16.getString(2131901301) + '\n' + r16.getString(2131901300, new Object[]{r16.getString(2131894309)});
    L196:
        if (r4 != null) goto L84;
        r22 = r16.getString(2131906312);
        goto L233
    L199:
        if (com.larus.im.bean.message.a.X(r18) == false) goto L220;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Iterator r40 = vd9.r.a(r18).iterator();
    L202:
        if (r40.hasNext() == false) goto L209;
        Object r41 = r40.next();
        if (((Block) r41).getBlockType() != BlockType.BLOCK_TYPE_AUTH_IDENTITY.getValue()) goto L206;
        boolean r42 = true;
    L207:
        if (r42 == false) goto L202;
    L210:
        Block r43 = (Block) r41;
        if (r43 == null) goto L215;
        BlockContent r44 = r43.getContent();
        if (r44 == null) goto L215;
        r4 = r44.getAuthIdentityBlock();
    L215:
        if (r4 == null) goto L219;
        String r45 = ((AuthIdentityBlock) r4).text;
        if (r45 == null) goto L219;
        return r45;
    L219:
        return r16.getString(2131906312);
    L206:
        r42 = false;
        goto L207
    L209:
        r41 = null;
        goto L210
    L220:
        if (r22 != null) goto L222;
    L227:
        r9 = false;
    L228:
        if (r9 == true) goto L233;
        r22 = r16.getString(2131906312);
        goto L233
    L222:
        if (r22.length() <= 0) goto L224;
        boolean r46 = true;
    L225:
        if (r46 != true) goto L227;
    L224:
        r46 = false;
        goto L225
    L180:
        if (StringsKt.contains$default(r22, "```", false, 2, null) != true) goto L182;
        r38 = true;
        goto L183
    L173:
        if (StringsKt.contains$default(r22, "<img", false, 2, null) != true) goto L175;
        r37 = true;
        goto L176
    L122:
        if (com.larus.utils.o0.d(r116) != true) goto L124;
        r117 = true;
        goto L125
    L113:
        if (com.larus.bmhome.utils.i.f(r17) == false) goto L119;
        if (com.larus.bmhome.chat.bean.d.W0(r18) == false) goto L119;
        if (com.larus.bmhome.chat.bean.d.Y0(r18) == true) goto L119;
        r22 = r16.getString(2131910018);
        goto L233
    L107:
        if (com.larus.utils.o0.d(r114) != true) goto L109;
        r115 = true;
        goto L111
    L48:
        if ((r111 instanceof zc8.b) == true) goto L50;
        r112 = true;
        goto L51
    L53:
        r110 = null;
        goto L54
    L41:
        return "[" + r16.getString(2131906311) + ']';
    L30:
        r13 = null;
    L34:
        r14 = true;
    L37:
        r15 = false;
        goto L39
    L20:
        if (r8.isEmpty() == false) goto L22;
        goto L22
    }
}
