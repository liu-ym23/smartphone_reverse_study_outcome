package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.stop.a;
import com.larus.bmhome.chat.stop.d;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.api.i2;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e1 implements Function1 {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ wc9.e b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ i2 d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ e1(ChatListComponent r1, wc9.e r2, boolean r3, i2 r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r14) {
        ChatListComponent r0 = this.a;
        wc9.e r1 = this.b;
        boolean r2 = this.c;
        i2 r3 = this.d;
        boolean r4 = this.e;
        a r15 = (a) r14;
        int r5 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r15, "candidate");
        String r6 = r15.a.getMessageId();
        String r7 = "";
        if (r6 != null) goto L6;
        r6 = "";
    L6:
        if (r6.length() != 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L13;
        r6 = r15.a.getLocalMessageId();
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        String r9 = r15.b.getMessageId();
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        if (r9.length() != 0) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L27;
        String r11 = r15.b.getLocalMessageId();
        if (r11 == null) goto L25;
        r7 = r11;
    L25:
        r9 = r7;
    L27:
        if (r6.length() != 0) goto L29;
        boolean r12 = true;
    L30:
        Integer r13 = null;
        if (r12 == false) goto L33;
        return null;
    L33:
        if (r9.length() != 0) goto L35;
        boolean r16 = true;
    L36:
        if (r16 == true) goto L246;
        Pair r17 = TuplesKt.to(r6, r9);
        LinkedHashMap r18 = r0.v1;
        Object r19 = r18.get(r17);
        if (r19 != null) goto L41;
        r19 = Boolean.valueOf(r4);
        r18.put(r17, r19);
    L41:
        boolean r20 = ((Boolean) r19).booleanValue();
    L43:
        if (r0.v1.size() <= 16) goto L47;
        Iterator r21 = r0.v1.entrySet().iterator();
        if (r21.hasNext() == false) goto L43;
        r21.next();
        r21.remove();
        goto L43
    L47:
        int r22 = d.a;
        Message r23 = r15.a;
        Message r110 = r15.b;
        if (r2 == false) goto L51;
        if (r3 == null) goto L51;
        Integer r24 = r3.e(r23);
    L52:
        if (r1 == null) goto L59;
        Integer r25 = r1.j;
        if (r25 == null) goto L59;
        if (r25.intValue() != 3) goto L59;
        boolean r26 = true;
    L60:
        if (r26 == false) goto L247;
        if (r20 == true) goto L225;
        if (r23 == null) goto L66;
        String r27 = com.larus.im.bean.message.a.r(r23);
    L68:
        if (Intrinsics.areEqual(r27, "1") == true) goto L76;
        if (r110 == null) goto L71;
        String r28 = com.larus.im.bean.message.a.r(r110);
    L73:
        if (Intrinsics.areEqual(r28, "1") == true) goto L76;
        boolean r29 = false;
    L77:
        if (r110 == null) goto L79;
        Map r30 = r110.getExt();
    L80:
        if (r30 == null) goto L84;
        String r31 = (String) r30.get("cron_template_id");
        if (r31 == null) goto L84;
        String r32 = StringsKt.trim(r31).toString();
    L85:
        if (r30 == null) goto L87;
        String r33 = (String) r30.get("send_command");
    L88:
        if (r32 != null) goto L90;
    L93:
        boolean r34 = true;
    L94:
        String r111 = "local_pc";
        if (r34 == true) goto L101;
        if (Intrinsics.areEqual(r33, "1") == false) goto L99;
        String r35 = "pc_schedule";
    L105:
        if (d.b(r23) == false) goto L107;
    L145:
        String r36 = "applet";
    L147:
        if (ic8.n.n(r1) == false) goto L150;
        r111 = "cloud_pc";
    L154:
        if (d.d(r23) == false) goto L156;
    L171:
        String r112 = "office_slides";
    L172:
        if (r23 == null) goto L186;
        Intrinsics.checkNotNullParameter(r23, "<this>");
        List r37 = vd9.r.a(r23);
        if (r37 == null) goto L186;
        Iterator r38 = r37.iterator();
    L177:
        if (r38.hasNext() == false) goto L184;
        Object r39 = r38.next();
        if (((Block) r39).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L181;
        boolean r40 = true;
    L182:
        if (r40 == false) goto L177;
    L185:
        Block r41 = (Block) r39;
    L187:
        if (r41 == null) goto L193;
        BlockContent r42 = r41.getContent();
        if (r42 == null) goto L193;
        ArtifactBlock r43 = r42.getDocBlock();
        if (r43 == null) goto L193;
        r13 = r43.getResourceType();
    L193:
        if (r112 != null) goto L195;
        r112 = d.f(r13);
    L195:
        if (r29 == false) goto L203;
        if (r112 == null) goto L203;
        if (r35 != null) goto L242;
        if (r36 != null) goto L243;
        if (r111 == null) goto L225;
    L244:
        return r111;
    L243:
        return r36;
    L242:
        return r35;
    L203:
        if (r112 != null) goto L241;
        if (r2 == false) goto L218;
        if (r13 == null) goto L209;
        r24 = r13;
    L209:
        r112 = d.f(r24);
        if (r29 == false) goto L241;
        if (r112 == null) goto L241;
        if (r35 != null) goto L242;
        if (r36 != null) goto L243;
        if (r111 == null) goto L225;
    L218:
        if (r35 != null) goto L242;
        if (r36 != null) goto L243;
        if (r111 != null) goto L244;
        if (r29 == true) goto L225;
        r112 = "chat_stream";
    L241:
        return r112;
    L181:
        r40 = false;
        goto L182
    L184:
        r39 = null;
    L186:
        r41 = null;
        goto L187
    L156:
        if (d.d(r110) == true) goto L171;
        if (d.c(r23) == false) goto L161;
    L170:
        r112 = "office_sheet";
        goto L172
    L161:
        if (d.c(r110) == true) goto L170;
        if (d.a(r23) == false) goto L166;
    L169:
        r112 = "office_doc";
        goto L172
    L166:
        if (d.a(r110) == true) goto L169;
        r112 = null;
        goto L172
    L150:
        if (ic8.n.t(r1) == true) goto L154;
        r111 = null;
        goto L154
    L107:
        if (d.b(r110) == true) goto L145;
        Iterator r44 = SequencesKt.sequenceOf(new Message[]{r110, r23}).iterator();
    L111:
        if (r44.hasNext() == false) goto L129;
        Message r45 = (Message) r44.next();
        if (r45 == null) goto L119;
        Map r46 = r45.getExt();
        if (r46 == null) goto L119;
        String r47 = (String) r46.get("miniapp_appkey");
        if (r47 == null) goto L119;
        String r48 = StringsKt.trim(r47).toString();
    L120:
        if (r48 != null) goto L122;
    L125:
        boolean r49 = true;
    L127:
        if ((!r49) == false) goto L111;
        boolean r50 = true;
    L130:
        if (r50 == true) goto L145;
        String r51 = ic8.n.e(r1);
        if (r51 == null) goto L135;
        String r52 = StringsKt.trim(r51).toString();
    L136:
        if (r52 != null) goto L138;
    L141:
        boolean r53 = true;
    L142:
        if (r53 == false) goto L145;
        r36 = null;
        goto L147
    L138:
        if (r52.length() == 0) goto L141;
        r53 = false;
        goto L142
    L135:
        r52 = null;
        goto L136
    L122:
        if (r48.length() == 0) goto L125;
        r49 = false;
    L119:
        r48 = null;
        goto L120
    L129:
        r50 = false;
        goto L130
    L99:
        r35 = "mobile_schedule";
        goto L105
    L101:
        if (Intrinsics.areEqual(r33, "1") == false) goto L103;
        r35 = "local_pc";
        goto L105
    L103:
        r35 = null;
        goto L105
    L90:
        if (r32.length() == 0) goto L93;
        r34 = false;
        goto L94
    L87:
        r33 = null;
    L84:
        r32 = null;
        goto L85
    L79:
        r30 = null;
        goto L80
    L71:
        r28 = null;
    L76:
        r29 = true;
        goto L77
    L66:
        r27 = null;
    L225:
        return "agent_work";
    L247:
        return null;
    L59:
        r26 = false;
    L51:
        r24 = null;
        goto L52
    L246:
        return null;
    L35:
        r16 = false;
        goto L36
    L29:
        r12 = false;
        goto L30
    L19:
        r10 = false;
        goto L20
    L8:
        r8 = false;
        goto L9
    }
}
