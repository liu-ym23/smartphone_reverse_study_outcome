package com.larus.bmhome.clarification;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final g a = null;
    public static final Set<String> b = null;

    public static final class a {
        public final wc9.e a;
        public final List<Message> b;
        public final Function1<Message, Unit> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            wc9.e r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "MainSourceContext(conversation=" + this.a + ", messages=" + this.b + ", hideMessage=" + this.c + ')';
        }

        public a(wc9.e r2, List r3, com.larus.bmhome.interactionpanel.l0 r4) {
            Intrinsics.checkNotNullParameter(r3, "messages");
            Intrinsics.checkNotNullParameter(r4, "hideMessage");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public g() {
    }

    static {
        a = new g();
        b = new LinkedHashSet();
    }

    public static List b(Message r4) {
        List r0 = CollectionsKt.createListBuilder();
        r0.add(r4);
        List r1 = r4.getSubList();
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        Iterator r2 = CollectionsKt.filterNotNull(r1).iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Message r3 = (Message) r2.next();
        a.getClass();
        r0.addAll(b(r3));
        goto L7
    L9:
        List r5 = r4.getSubListGroup();
        if (r5 != null) goto L12;
        r5 = CollectionsKt.emptyList();
    L12:
        Iterator r6 = CollectionsKt.flatten(r5).iterator();
    L14:
        if (r6.hasNext() == false) goto L17;
        Message r7 = (Message) r6.next();
        a.getClass();
        r0.addAll(b(r7));
        goto L14
    L17:
        return CollectionsKt.build(r0);
    }

    public static List c(List r2) {
        ArrayList r0 = new ArrayList();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, b((Message) r3.next()));
        goto L4
    L6:
        return r0;
    }

    public static boolean d(Message r7) {
        List r8 = b(r7);
        if ((r8 instanceof Collection) == true) goto L5;
    L7:
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L55;
        Message r0 = (Message) r9.next();
        String r2 = com.larus.bmhome.chat.bean.d.r(r0);
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        if (StringsKt.trim(r2).toString().length() <= 0) goto L16;
        boolean r3 = true;
    L17:
        List r1 = r0.getContentBlock();
        if (r1 != null) goto L20;
        r1 = CollectionsKt.emptyList();
    L20:
        List r4 = r1;
        if ((r4 instanceof Collection) == true) goto L23;
    L25:
        Iterator r5 = r4.iterator();
    L27:
        if (r5.hasNext() == false) goto L36;
        Block r6 = (Block) r5.next();
        if (r6.getBlockType() != com.larus.bmhome.chat.deepresearch.view.j.q0) goto L31;
    L33:
        boolean r10 = false;
    L34:
        if (r10 == false) goto L27;
        boolean r11 = true;
    L37:
        if (r3 == true) goto L40;
        if (r11 == true) goto L40;
        boolean r12 = true;
    L41:
        if (r12 == true) goto L9;
        return false;
    L40:
        r12 = false;
        goto L41
    L31:
        if (r6.getContent() == null) goto L33;
        r10 = true;
    L36:
        r11 = false;
        goto L37
    L23:
        if (r4.isEmpty() == false) goto L25;
    L16:
        r3 = false;
        goto L17
    L55:
        return true;
    L5:
        if (r8.isEmpty() == false) goto L7;
        return true;
    }

    public static Message a(Message r46, a r47) {
        Intrinsics.checkNotNullParameter(r46, "message");
        Intrinsics.checkNotNullParameter(r47, "context");
        List r0 = r46.getContentBlock();
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        if (r0.isEmpty() == false) goto L8;
        return r46;
    L8:
        ArrayList r12 = new ArrayList();
        Iterator r3 = r0.iterator();
        char r4 = 0;
        boolean r5 = false;
    L10:
        if (r3.hasNext() == false) goto L228;
        Object r7 = r3.next();
        Block r8 = (Block) r7;
        a.getClass();
        if (w.a(r8) == true) goto L16;
        boolean r1 = !com.larus.bmhome.chat.bean.d.j0(r46);
    L220:
        if (r1 == true) goto L222;
        r5 = true;
    L222:
        if (r1 == false) goto L224;
        r12.add(r7);
    L224:
        r4 = 0;
        goto L10
    L16:
        if (z2.a.J3() == true) goto L19;
    L116:
        boolean r2 = true;
    L118:
        if (r2 == false) goto L120;
        FLogger.a.d("AutoRouteClarificationPolicy", "skip auto-route clarification for conversation fork disabled round, messageId=" + r46.getMessageId());
    L193:
        r1 = false;
        goto L220
    L120:
        BlockContent r6 = r8.getContent();
        if (r6 == null) goto L123;
        InteractionAskBlock r9 = r6.getInteractionAskBlock();
    L124:
        if (r9 != null) goto L126;
    L128:
        boolean r10 = false;
    L130:
        if (r10 == false) goto L191;
        wc9.e r11 = r47.a;
        if (r11 == null) goto L191;
        String r13 = r11.r;
        String r14 = "";
        if (r13 != null) goto L138;
        String r15 = "";
    L235:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L141
        Object r17 = Result.constructor-impl(new JSONObject(r15).optString("fork_from_conversation_id"));     // Catch: Throwable -> L141
    L144:
        if (Result.isFailure-impl(r17) == false) goto L146;
        r17 = "";
    L146:
        String r18 = (String) r17;
        bs8.a.h.getClass();
        bs8.a r19 = bs8.a.C0004a.a(r15);
        Intrinsics.checkNotNull(r18);
        if (StringsKt.isBlank(r18) == true) goto L191;
        if (r19 == null) goto L152;
        boolean r110 = true;
        if (r19.b() != true) goto L153;
        boolean r111 = true;
    L154:
        if (r111 == true) goto L162;
        if (r19 != null) goto L157;
    L159:
        boolean r20 = false;
    L160:
        if (r20 == true) goto L162;
    L157:
        if (r19.c() != r110) goto L159;
        r20 = true;
    L162:
        Set r21 = SequencesKt.toSet(SequencesKt.filter(SequencesKt.flatMap(SequencesKt.filter(CollectionsKt.asSequence(c(r47.b)), new com.larus.bmhome.clarification.a()), new b()), new c()));
        if (r21.isEmpty() == true) goto L191;
        Iterator r112 = SequencesKt.flatMap(CollectionsKt.asSequence(b(r46)), new d()).iterator();
    L167:
        if (r112.hasNext() == false) goto L171;
        if (r21.contains((String) r112.next()) == false) goto L167;
        boolean r22 = true;
    L172:
        if (r22 == false) goto L191;
        String[] r23 = new String[4];
        String r113 = r46.getMessageId();
        if (r113 != null) goto L177;
        r113 = "";
    L177:
        r23[0] = r113;
        String r114 = r46.getLocalMessageId();
        if (r114 != null) goto L180;
        r114 = "";
    L180:
        r23[1] = r114;
        String r115 = r46.getReplyId();
        if (r115 != null) goto L183;
        r115 = "";
    L183:
        r23[2] = r115;
        String r24 = r9.getClarifyId();
        if (r24 == null) goto L187;
        r14 = r24;
    L187:
        r23[3] = r14;
        h.a.e(CollectionsKt.listOf(r23));
        if (d(r46) == false) goto L190;
        r47.c.invoke(r46);
    L190:
        FLogger.a.d("AutoRouteClarificationPolicy", "suppress auto-route clarification in forked task conversation, conversationId=" + r11.a + ", messageId=" + r46.getMessageId());
        boolean r25 = true;
    L192:
        if (r25 == true) goto L193;
        BlockContent r26 = r8.getContent();
        if (r26 == null) goto L197;
        InteractionAskBlock r27 = r26.getInteractionAskBlock();
    L198:
        h r28 = h.a;
        String[] r29 = new String[4];
        String r30 = r46.getMessageId();
        if (r30 != null) goto L201;
        r30 = "";
    L201:
        r29[0] = r30;
        String r31 = r46.getLocalMessageId();
        if (r31 != null) goto L204;
        r31 = "";
    L204:
        r29[1] = r31;
        String r32 = r46.getReplyId();
        if (r32 != null) goto L207;
        r32 = "";
    L207:
        r29[2] = r32;
        if (r27 == null) goto L210;
        String r33 = r27.getClarifyId();
    L211:
        if (r33 != null) goto L213;
        r33 = "";
    L213:
        r29[3] = r33;
        List r34 = CollectionsKt.listOf(r29);
        monitor-enter(r28);
        Intrinsics.checkNotNullParameter(r34, "identifiers");     // Catch: Throwable -> L225
        boolean r35 = h.b("consumed_identifiers", r34);     // Catch: Throwable -> L225
        monitor-exit(r28);
        if (r35 == false) goto L219;
        r1 = false;
        goto L220
    L219:
        r1 = true;
    L225:
        th = move-exception;
        throw th;
    L210:
        r33 = null;
        goto L211
    L197:
        r27 = null;
        goto L198
    L171:
        r22 = false;
    L153:
        r111 = false;
        goto L154
    L152:
        r110 = true;
    L141:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L144
    L138:
        r15 = r13;
    L191:
        r25 = false;
        goto L192
    L126:
        if (r9.getQuickReplyScene() != 11) goto L128;
        r10 = true;
        goto L130
    L123:
        r9 = null;
        goto L124
    L19:
        if (ic8.n.o(r47.a) == true) goto L116;
        Map r36 = r46.getExt();
        if (r36 != null) goto L25;
        r36 = MapsKt.emptyMap();
    L25:
        if (Intrinsics.areEqual(r36.get("disable_fork"), "1") == true) goto L116;
        List<Message> r37 = r47.b;
        String[] r117 = new String[2];
        String r118 = r46.getMessageId();
        if (r118 != null) goto L30;
        r118 = "";
    L30:
        r117[r4] = r118;
        String r119 = r46.getLocalMessageId();
        if (r119 != null) goto L33;
        r119 = "";
    L33:
        r117[1] = r119;
        Set r120 = SetsKt.setOf(r117);
        ArrayList r121 = new ArrayList();
        Iterator r122 = r120.iterator();
    L35:
        if (r122.hasNext() == false) goto L39;
        Object r38 = r122.next();
        if ((!StringsKt.isBlank((String) r38)) == false) goto L35;
        r121.add(r38);
        goto L35
    L39:
        Set r39 = CollectionsKt.toSet(r121);
        Iterator<T> r123 = r37.iterator();
    L41:
        if (r123.hasNext() == false) goto L71;
        Object r124 = r123.next();
        a.getClass();
        List r40 = b((Message) r124);
        if ((r40 instanceof Collection) == true) goto L45;
    L47:
        Iterator r41 = r40.iterator();
    L49:
        if (r41.hasNext() == false) goto L67;
        Message r42 = (Message) r41.next();
        String r210 = r42.getMessageId();
        if (r210 != null) goto L53;
        String r125 = "";
    L55:
        if (r39.contains(r125) == true) goto L63;
        String r43 = r42.getLocalMessageId();
        if (r43 != null) goto L60;
        r43 = "";
    L60:
        if (r39.contains(r43) == true) goto L63;
        boolean r44 = false;
    L64:
        if (r44 == false) goto L49;
        boolean r45 = true;
    L68:
        if (r45 == false) goto L41;
    L72:
        Message r126 = (Message) r124;
        String[] r48 = new String[2];
        String r49 = r46.getReplyId();
        if (r49 != null) goto L75;
        r49 = "";
    L75:
        r48[0] = r49;
        if (r126 == null) goto L78;
        String r50 = r126.getReplyId();
    L79:
        if (r50 != null) goto L81;
        r50 = "";
    L81:
        r48[1] = r50;
        Set r51 = SetsKt.setOf(r48);
        ArrayList r52 = new ArrayList();
        Iterator r53 = r51.iterator();
    L83:
        if (r53.hasNext() == false) goto L87;
        Object r54 = r53.next();
        if ((!StringsKt.isBlank((String) r54)) == false) goto L83;
        r52.add(r54);
        goto L83
    L87:
        Set r55 = CollectionsKt.toSet(r52);
        if (r55.isEmpty() == true) goto L117;
        ArrayList r56 = (ArrayList) c(r37);
        if (r56.isEmpty() == true) goto L117;
        Iterator r57 = r56.iterator();
    L95:
        if (r57.hasNext() == false) goto L117;
        Message r58 = (Message) r57.next();
        if (com.larus.bmhome.chat.bean.d.G0(r58) == false) goto L114;
        String r59 = r58.getMessageId();
        if (r59 != null) goto L102;
        r59 = "";
    L102:
        if (r55.contains(r59) == true) goto L108;
        String r60 = r58.getLocalMessageId();
        if (r60 != null) goto L107;
        r60 = "";
    L107:
        if (r55.contains(r60) == false) goto L114;
    L108:
        Map r61 = r58.getExt();
        if (r61 != null) goto L112;
        r61 = MapsKt.emptyMap();
    L112:
        if (Intrinsics.areEqual(r61.get("disable_fork"), "1") == false) goto L114;
        boolean r62 = true;
    L115:
        if (r62 == false) goto L95;
    L114:
        r62 = false;
    L117:
        r2 = false;
        goto L118
    L78:
        r50 = null;
    L63:
        r44 = true;
        goto L64
    L53:
        r125 = r210;
    L67:
        r45 = false;
        goto L68
    L45:
        if (r40.isEmpty() == false) goto L47;
    L71:
        r124 = null;
        goto L72
    L228:
        if (r5 == true) goto L231;
        return r46;
    L231:
        if (r12.isEmpty() == false) goto L234;
        return null;
    L234:
        return Message.copy$default(r46, null, null, null, 0, 0, null, 0, false, null, null, r12, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1025, 31, null);
    }
}
