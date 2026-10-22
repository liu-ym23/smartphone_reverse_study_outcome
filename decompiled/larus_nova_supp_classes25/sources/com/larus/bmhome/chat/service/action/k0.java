package com.larus.bmhome.chat.service.action;

import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class k0 implements b {
    public final a a;
    public final boolean b;
    public final ConversationFeedActionType c;

    @Override // com.larus.bmhome.chat.service.action.b
    public final void a(wh8.a r25) {
        Intrinsics.checkNotNullParameter(r25, "data");
        a r2 = this.a;
        com.larus.bmhome.chat.api.i r3 = r2.a;
        ConversationModel r4 = r2.b;
        BotModel r5 = r25.b;
        if (r5 == null) goto L6;
        String r6 = r5.getBotId();
        if (r6 == null) goto L6;
    L7:
        r4.changePinStatusConversation(r6, r25.a, this.b);
        wc9.e r7 = r25.a;
        if (ic8.n.w(r7) == false) goto L11;
        boolean r8 = this.b;
        JSONObject r9 = new JSONObject();
        r9.put("cell_type", "doubao_pc_history");
        Unit r10 = Unit.INSTANCE;
        v2.c(r8, r9);
    L109:
        Function2<ConversationFeedActionType, wh8.a, Unit> r0 = r3.j;
        if (r0 == null) goto L112;
        r0.invoke(this.c, r25);
    L112:
        Function0<Unit> r1 = r3.i;
        if (r1 == null) goto L116;
        r1.invoke();
        return;
    L116:
        return;
    L11:
        if (AudioServiceDelegate.a.getAudioConfig().n(r25.b) == false) goto L13;
        String r11 = "1";
    L15:
        if (this.b == false) goto L62;
        BotModel r12 = r25.b;
        if (r12 == null) goto L19;
        String r13 = r12.getBotId();
    L20:
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        BotModel r14 = r25.b;
        if (r14 == null) goto L25;
        String r15 = r14.getBgImgUrl();
    L27:
        if (o0.d(r15) == false) goto L29;
        String r16 = "1";
    L30:
        String r17 = r3.d;
        String r18 = r3.c;
        if (r7 == null) goto L33;
        String r20 = r7.a;
    L34:
        by7.e r19 = r3.b;
        String r110 = "1";
        ChatControlTrace r21 = ChatControlTrace.b;
        if (r7 == null) goto L37;
        Integer r22 = r7.v;
    L38:
        String r111 = r21.g(r22, c.b(r25), c.a(r25));
        Function1<wh8.a, String> r23 = r3.h;
        if (r23 == null) goto L41;
        String r24 = (String) r23.invoke(r25);
    L42:
        String r26 = r25.e;
        if (r3.e == true) goto L46;
        r110 = "0";
    L46:
        Integer r27 = c.b(r25);
        JSONObject r112 = new JSONObject();
        r112.put("object_type", "chat");
        if (r7 == null) goto L60;
        String r28 = r7.I;
        if (r28 == null) goto L60;
        if (r28.length() <= 0) goto L53;
        boolean r113 = true;
    L54:
        if (r113 == false) goto L56;
        String r114 = r28;
    L57:
        if (r114 == null) goto L60;
        String r29 = r114;
    L61:
        r112.put("project_id", r29);
        v2.a(r13, r17, r18, r111, r16, r112, r19, r24, r11, r26, r110, r27, r20);
        goto L109
    L56:
        r114 = null;
        goto L57
    L53:
        r113 = false;
    L60:
        r29 = "-";
        goto L61
    L41:
        r24 = null;
        goto L42
    L37:
        r22 = null;
        goto L38
    L33:
        r20 = null;
        goto L34
    L29:
        r16 = "0";
        goto L30
    L25:
        r15 = null;
        goto L27
    L19:
        r13 = null;
        goto L20
    L62:
        String r115 = "1";
        BotModel r30 = r25.b;
        if (r30 == null) goto L65;
        String r31 = r30.getBotId();
    L66:
        if (r31 != null) goto L68;
        String r32 = "";
    L69:
        BotModel r33 = r25.b;
        if (r33 == null) goto L72;
        String r34 = r33.getBgImgUrl();
    L74:
        if (o0.d(r34) == false) goto L76;
        String r116 = r115;
    L77:
        ChatControlTrace r35 = ChatControlTrace.b;
        if (r7 == null) goto L80;
        Integer r36 = r7.v;
    L81:
        String r117 = r35.g(r36, c.b(r25), c.a(r25));
        String r37 = r3.d;
        String r118 = r3.c;
        if (r7 == null) goto L84;
        String r210 = r7.a;
    L85:
        by7.e r38 = r3.b;
        Function1<wh8.a, String> r39 = r3.h;
        if (r39 == null) goto L88;
        String r40 = (String) r39.invoke(r25);
    L89:
        String r41 = r25.e;
        if (r3.e == true) goto L93;
        r115 = "0";
    L93:
        Integer r42 = c.b(r25);
        JSONObject r43 = new JSONObject();
        r43.put("object_type", "chat");
        if (r7 == null) goto L107;
        String r44 = r7.I;
        if (r44 == null) goto L107;
        if (r44.length() <= 0) goto L100;
        boolean r119 = true;
    L101:
        if (r119 == false) goto L103;
        String r120 = r44;
    L104:
        if (r120 == null) goto L107;
        String r45 = r120;
    L108:
        r43.put("project_id", r45);
        v2.d(r32, r37, r118, r117, r116, r43, r38, r11, r40, r41, r115, r42, r210);
        goto L109
    L103:
        r120 = null;
        goto L104
    L100:
        r119 = false;
    L107:
        r45 = "-";
        goto L108
    L88:
        r40 = null;
        goto L89
    L84:
        r210 = null;
        goto L85
    L80:
        r36 = null;
        goto L81
    L76:
        r116 = "0";
        goto L77
    L72:
        r34 = null;
        goto L74
    L68:
        r32 = r31;
        goto L69
    L65:
        r31 = null;
        goto L66
    L13:
        r11 = "0";
    L6:
        r6 = "";
        goto L7
    }

    public k0(a r2, boolean r3, ConversationFeedActionType r4) {
        Intrinsics.checkNotNullParameter(r2, "executeContext");
        Intrinsics.checkNotNullParameter(r4, "actionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
