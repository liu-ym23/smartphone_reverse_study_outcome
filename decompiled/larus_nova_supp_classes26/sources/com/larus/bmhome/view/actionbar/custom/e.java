package com.larus.bmhome.view.actionbar.custom;

import com.larus.bmhome.actionbar.util.ActionBarSendMsgContentBuilder;
import com.larus.bmhome.actionbar.util.ActionBarSendMsgReplyFormat;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements w2 {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public static com.larus.bmhome.actionbar.util.e e() {
        int r0 = CustomActionBar.c0;
        String r2 = CustomActionBar.b.a();
        boolean r3 = AppHost.a.isOversea();
        boolean r4 = com.larus.platform.service.z2.a.k3();
        int r1 = com.larus.utils.j0.a;
        String r5 = com.larus.utils.j0.d(2131899645);
        String r6 = com.larus.utils.j0.d(2131899646);
        String r7 = com.larus.utils.j0.d(2131909802);
        String r8 = com.larus.utils.j0.d(2131906323);
        Function2 r9 = new b();
        Function2 r10 = new c();
        Function2 r11 = new d();
        String r12 = com.larus.utils.j0.d(2131899150);
        if (r12.length() <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L10;
        r12 = null;
    L10:
        return new com.larus.bmhome.actionbar.util.e(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L5:
        r13 = false;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.custom.w2
    public final String c() {
        ActionBarSendMsgContentBuilder r0 = ActionBarSendMsgContentBuilder.a;
        com.larus.bmhome.actionbar.util.e r1 = e();
        r0.getClass();
        return ActionBarSendMsgContentBuilder.l(r1);
    }

    @Override // com.larus.bmhome.view.actionbar.custom.w2
    public final String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        ActionBarSendMsgContentBuilder r0 = ActionBarSendMsgContentBuilder.a;
        com.larus.bmhome.actionbar.util.e r1 = e();
        r0.getClass();
        return ActionBarSendMsgContentBuilder.w(r3, r1);
    }

    public static com.larus.bmhome.actionbar.model.r d(String r18, com.larus.bmhome.actionbar.model.r r19, com.larus.bmhome.actionbar.model.r r20, List r21, com.larus.bmhome.actionbar.model.p1 r22, fq8.e r23, int r24) {
        String r1 = r18;
        com.larus.bmhome.actionbar.model.r r3 = r20;
        Intrinsics.checkNotNullParameter(r1, "userInput");
        Intrinsics.checkNotNullParameter(r19, "instructionConf");
        Intrinsics.checkNotNullParameter(r3, "sourceInstructionConf");
        ActionBarSendMsgContentBuilder r7 = ActionBarSendMsgContentBuilder.a;
        String r8 = "";
        if (r23 == null) goto L12;
        String r11 = r23.a();
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        fq8.a r12 = r23.b();
        if (r12 == null) goto L10;
        String r13 = r12.b();
    L11:
        com.larus.bmhome.actionbar.util.a r10 = new com.larus.bmhome.actionbar.util.a(r11, r13);
    L13:
        com.larus.bmhome.actionbar.util.e r14 = e();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "userInput");
        Intrinsics.checkNotNullParameter(r19, "instructionConf");
        Intrinsics.checkNotNullParameter(r3, "sourceInstructionConf");
        Intrinsics.checkNotNullParameter(r14, "options");
        List r5 = r21;
        if (r5 != null) goto L16;
    L19:
        boolean r0 = true;
    L20:
        if (r0 == false) goto L22;
        List r2 = CollectionsKt.emptyList();
    L86:
        List r4 = r2;
        if ((r4 instanceof Collection) == true) goto L89;
    L91:
        Iterator r6 = r4.iterator();
    L93:
        if (r6.hasNext() == false) goto L97;
        if (((ActionBarSendMsgContentBuilder.b) r6.next()).c == false) goto L93;
        boolean r9 = true;
    L99:
        if (r14.c == false) goto L169;
        if (r22 != null) goto L169;
        com.larus.bmhome.actionbar.model.y r15 = r3.i;
        if (r15 == null) goto L105;
        List r16 = r15.a;
    L106:
        if (r16 != null) goto L108;
        r16 = CollectionsKt.emptyList();
    L108:
        com.larus.bmhome.actionbar.model.z0 r17 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r16, r24);
        if (r17 == null) goto L111;
        com.larus.bmhome.actionbar.model.r r25 = r17.q;
    L112:
        Integer r26 = r3.a;
        if (r26 != null) goto L116;
    L119:
        if (r25 == null) goto L123;
        r3 = r25;
    L123:
        if (ActionBarSendMsgContentBuilder.p(r3.a) == false) goto L169;
        if (r10 == null) goto L134;
        StringBuilder r27 = new StringBuilder();
        r27.append(r10.a);
        String r28 = r10.b;
        if (r28 == null) goto L130;
        r8 = r28;
    L130:
        r27.append(r8);
        String r29 = r27.toString();
        if (r29 == null) goto L134;
        r1 = r29;
    L134:
        if (r5 != null) goto L136;
    L139:
        boolean r30 = true;
    L140:
        if (r30 == true) goto L156;
        String r31 = ActionBarSendMsgContentBuilder.j((com.larus.bmhome.actionbar.model.u) CollectionsKt.firstOrNull(r21), r14);
        String r32 = ActionBarSendMsgContentBuilder.k(r21, r14);
        if (r31 != null) goto L145;
    L147:
        boolean r33 = false;
    L148:
        if (r33 == true) goto L157;
        if (r32 != null) goto L151;
    L153:
        boolean r34 = false;
    L154:
        if (r34 == false) goto L156;
    L151:
        if ((!StringsKt.isBlank(r32)) != true) goto L153;
        r34 = true;
    L157:
        boolean r35 = true;
    L159:
        if (ActionBarSendMsgContentBuilder.p(r3.a) == true) goto L161;
    L167:
        boolean r36 = false;
    L168:
        boolean r37 = !r36;
    L170:
        if (r9 == true) goto L173;
        if (r37 == true) goto L173;
        return r19;
    L173:
        com.larus.bmhome.actionbar.model.j1 r38 = r19.e;
        if (r38 != null) goto L176;
        String r39 = null;
        r38 = new com.larus.bmhome.actionbar.model.j1(null, 16777215);
    L177:
        com.larus.bmhome.actionbar.model.j1 r40 = r38;
        if (r9 == false) goto L180;
        String r110 = "1";
    L181:
        if (r37 == false) goto L183;
        String r111 = "1";
    L185:
        return com.larus.bmhome.actionbar.model.r.a(r19, null, null, com.larus.bmhome.actionbar.model.j1.a(r40, null, null, null, null, null, null, null, r110, r111, 4194303), null, 4079);
    L183:
        r111 = r39;
        goto L185
    L180:
        r110 = r39;
        goto L181
    L176:
        r39 = null;
        goto L177
    L161:
        if (StringsKt.trim(r1).toString().length() != 0) goto L163;
        boolean r41 = true;
    L164:
        if (r41 == false) goto L167;
        if (r35 == true) goto L167;
        r36 = true;
        goto L168
    L163:
        r41 = false;
        goto L164
    L145:
        if ((!StringsKt.isBlank(r31)) != true) goto L147;
        r33 = true;
    L156:
        r35 = false;
        goto L159
    L136:
        if (r5.isEmpty() == true) goto L139;
        r30 = false;
        goto L140
    L116:
        if (r26.intValue() != 28) goto L119;
        if (r25 != null) goto L119;
    L111:
        r25 = null;
        goto L112
    L105:
        r16 = null;
    L169:
        r37 = false;
    L97:
        r9 = false;
        goto L99
    L89:
        if (r4.isEmpty() == false) goto L91;
    L22:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r21.iterator();
    L24:
        if (r113.hasNext() == false) goto L85;
        com.larus.bmhome.actionbar.model.u r42 = (com.larus.bmhome.actionbar.model.u) r113.next();
        Integer r114 = r42.b;
        if (r114 != null) goto L29;
    L65:
        if (r114 != null) goto L68;
    L75:
        if (r114 != null) goto L78;
    L83:
        List r43 = CollectionsKt.emptyList();
    L84:
        CollectionsKt.addAll(r112, r43);
        goto L24
    L78:
        if (r114.intValue() != 11) goto L83;
        ActionBarSendMsgContentBuilder r44 = ActionBarSendMsgContentBuilder.a;
        Integer r45 = r42.a;
        String r46 = r42.d;
        r44.getClass();
        com.larus.bmhome.actionbar.model.n r47 = ActionBarSendMsgContentBuilder.v(r46);
        if (r47 != null) goto L82;
        r43 = CollectionsKt.emptyList();
        goto L84
    L82:
        r43 = ActionBarSendMsgContentBuilder.f(r45, r47, r14);
        goto L84
    L68:
        if (r114.intValue() != 2) goto L75;
        ActionBarSendMsgContentBuilder r48 = ActionBarSendMsgContentBuilder.a;
        String r49 = r42.d;
        r48.getClass();
        com.larus.bmhome.actionbar.model.h r50 = ActionBarSendMsgContentBuilder.u(r49);
        if (r50 == null) goto L72;
        r43 = ActionBarSendMsgContentBuilder.g(r42.a, r50, r14);
    L73:
        if (r43 != null) goto L84;
        r43 = CollectionsKt.emptyList();
        goto L84
    L72:
        r43 = null;
        goto L73
    L29:
        if (r114.intValue() != 8) goto L65;
        ActionBarSendMsgContentBuilder r51 = ActionBarSendMsgContentBuilder.a;
        String r52 = r42.d;
        r51.getClass();
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L36
        ouc.v r54 = xt7.d.b;     // Catch: Throwable -> L36
        if (r52 != null) goto L34;
        r52 = "";
    L34:
        r54.getClass();     // Catch: Throwable -> L36
        Object r55 = Result.constructor-impl((com.larus.bmhome.actionbar.model.b0) r54.c(com.larus.bmhome.actionbar.model.b0.Companion.serializer(), r52));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r55) == false) goto L41;
        r55 = null;
    L41:
        com.larus.bmhome.actionbar.model.b0 r56 = (com.larus.bmhome.actionbar.model.b0) r55;
        if (r56 != null) goto L44;
        r43 = CollectionsKt.emptyList();
        goto L84
    L44:
        List r57 = r56.a;
        if (r57 == null) goto L62;
        ArrayList r58 = new ArrayList();
        Iterator r59 = r57.iterator();
    L48:
        if (r59.hasNext() == false) goto L61;
        com.larus.bmhome.actionbar.model.c0 r115 = (com.larus.bmhome.actionbar.model.c0) r59.next();
        int r116 = r115.b;
        if (r116 != 3) goto L52;
    L54:
        ActionBarSendMsgContentBuilder r60 = ActionBarSendMsgContentBuilder.a;
        String r117 = r115.c;
        r60.getClass();
        com.larus.bmhome.actionbar.model.h r61 = ActionBarSendMsgContentBuilder.u(r117);
        if (r61 == null) goto L57;
        List r62 = ActionBarSendMsgContentBuilder.g(r115.a, r61, r14);
    L58:
        if (r62 != null) goto L60;
        r62 = CollectionsKt.emptyList();
    L60:
        CollectionsKt.addAll(r58, r62);
        goto L48
    L57:
        r62 = null;
        goto L58
    L52:
        if (r116 == 6) goto L54;
        r62 = CollectionsKt.emptyList();
        goto L60
    L61:
        r43 = r58;
    L63:
        if (r43 != null) goto L84;
        r43 = CollectionsKt.emptyList();
        goto L84
    L62:
        r43 = null;
    L36:
        th = move-exception;
        Result.Companion r63 = Result.Companion;
        r55 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L85:
        r2 = r112;
        goto L86
    L16:
        if (r5.isEmpty() == true) goto L19;
        r0 = false;
        goto L20
    L10:
        r13 = null;
        goto L11
    L12:
        r10 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.actionbar.custom.w2
    public final String b(String r24, com.larus.bmhome.actionbar.model.r r25, List<com.larus.bmhome.actionbar.model.u> r26, com.larus.bmhome.actionbar.model.p1 r27, fq8.e r28, int r29, com.larus.bmhome.instruction.f2 r30) {
        String r1 = r24;
        com.larus.bmhome.actionbar.model.r r2 = r25;
        Intrinsics.checkNotNullParameter(r1, "userInput");
        ActionBarSendMsgContentBuilder r6 = ActionBarSendMsgContentBuilder.a;
        String r7 = "";
        String r8 = null;
        if (r28 == null) goto L12;
        String r10 = r28.a();
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        fq8.a r11 = r28.b();
        if (r11 == null) goto L10;
        String r12 = r11.b();
    L11:
        com.larus.bmhome.actionbar.util.a r9 = new com.larus.bmhome.actionbar.util.a(r10, r12);
    L14:
        if (Intrinsics.areEqual(r30, com.larus.bmhome.instruction.e2.a) == false) goto L17;
        ActionBarSendMsgReplyFormat r0 = ActionBarSendMsgReplyFormat.REPLICA_REPLY;
    L21:
        com.larus.bmhome.actionbar.util.e r13 = e();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "userInput");
        Intrinsics.checkNotNullParameter(r13, "options");
        if (r2 == 0) goto L705;
        if (r27 == null) goto L119;
        Integer r14 = r27.a;
        if (r14 != null) goto L30;
    L107:
        String r15 = r27.c;
        if (r15 == null) goto L119;
        if (r15.length() != 0) goto L112;
        boolean r16 = true;
    L113:
        if (r16 == false) goto L118;
        String r3 = r27.b;
        if (r3 == null) goto L709;
        r7 = r3;
    L709:
        return r7;
    L118:
        r7 = r15;
        goto L709
    L112:
        r16 = false;
        goto L113
    L30:
        if (r14.intValue() != 2) goto L107;
        if (r26 == null) goto L48;
        Iterator<T> r4 = r26.iterator();
    L34:
        if (r4.hasNext() == false) goto L44;
        Object r5 = r4.next();
        Integer r17 = ((com.larus.bmhome.actionbar.model.u) r5).b;
        if (r17 != null) goto L39;
    L41:
        boolean r18 = false;
    L42:
        if (r18 == false) goto L34;
    L45:
        com.larus.bmhome.actionbar.model.u r19 = (com.larus.bmhome.actionbar.model.u) r5;
        if (r19 == null) goto L48;
        String r20 = r19.d;
    L613:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L96
        ouc.v r22 = xt7.d.b;     // Catch: Throwable -> L96
        if (r20 != null) goto L52;
        r20 = "";
    L52:
        r22.getClass();     // Catch: Throwable -> L96
        List r23 = ((com.larus.bmhome.actionbar.model.b0) r22.c(com.larus.bmhome.actionbar.model.b0.Companion.serializer(), r20)).a;     // Catch: Throwable -> L96
        if (r23 == null) goto L72;
        Iterator r31 = r23.iterator();     // Catch: Throwable -> L96
    L56:
        if (r31.hasNext() == false) goto L68;
        Object r32 = r31.next();     // Catch: Throwable -> L96
        com.larus.bmhome.actionbar.model.c0 r33 = (com.larus.bmhome.actionbar.model.c0) r32;     // Catch: Throwable -> L96
        if (r33.b != 3) goto L65;
        Integer r34 = r33.a;     // Catch: Throwable -> L96
        if (r34 == null) goto L65;
        if (r34.intValue() != 2) goto L65;
        boolean r35 = true;
    L66:
        if (r35 == false) goto L56;
    L69:
        com.larus.bmhome.actionbar.model.c0 r36 = (com.larus.bmhome.actionbar.model.c0) r32;     // Catch: Throwable -> L96
        if (r36 == null) goto L72;
        String r37 = r36.c;     // Catch: Throwable -> L96
    L73:
        ouc.v r38 = xt7.d.b;     // Catch: Throwable -> L96
        if (r37 != null) goto L76;
        r37 = "";
    L76:
        r38.getClass();     // Catch: Throwable -> L96
        List r39 = ((com.larus.bmhome.actionbar.model.h) r38.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r37)).e;     // Catch: Throwable -> L96
        if (r39 == null) goto L79;
        com.larus.bmhome.actionbar.model.w r40 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.firstOrNull(r39);     // Catch: Throwable -> L96
    L80:
        if (r40 == null) goto L87;
        Long r41 = r40.a;     // Catch: Throwable -> L96
        if (r41 == null) goto L87;
        if (r41.longValue() != 0) goto L87;
        boolean r42 = true;
    L88:
        if (r42 == false) goto L90;
        String r43 = r13.d;     // Catch: Throwable -> L96
    L94:
        Object r44 = Result.constructor-impl(r43);     // Catch: Throwable -> L96
    L99:
        if (Result.exceptionOrNull-impl(r44) == null) goto L699;
        String r45 = r27.c;
        if (r45 == null) goto L105;
        r7 = r45;
    L105:
        r44 = r7;
    L699:
        return (String) r44;
    L90:
        Function2 r46 = r13.h;     // Catch: Throwable -> L96
        String r47 = r13.e;     // Catch: Throwable -> L96
        if (r40 == null) goto L93;
        r8 = r40.b;     // Catch: Throwable -> L96
    L93:
        r43 = (String) r46.invoke(r47, r8);     // Catch: Throwable -> L96
    L87:
        r42 = false;
        goto L88
    L79:
        r40 = null;
    L65:
        r35 = false;
        goto L66
    L68:
        r32 = null;
    L72:
        r37 = null;
    L96:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L99
    L39:
        if (r17.intValue() != 8) goto L41;
        r18 = true;
        goto L42
    L44:
        r5 = null;
    L48:
        r20 = null;
    L119:
        if (r9 == null) goto L125;
        StringBuilder r49 = new StringBuilder();
        r49.append(r9.a);
        String r50 = r9.b;
        if (r50 == null) goto L124;
        r7 = r50;
    L124:
        r49.append(r7);
        String r51 = r49.toString();
        return ActionBarSendMsgContentBuilder.h(r2, r51, ActionBarSendMsgContentBuilder.b(r2, r51, null, r13), null, r13);
    L125:
        Integer r52 = r2.a;
        if (r52 != null) goto L129;
    L302:
        if (r52 != null) goto L305;
    L306:
        if (r52 != null) goto L309;
    L310:
        if (r52 != null) goto L313;
    L314:
        if (r52 != null) goto L317;
    L318:
        if (r52 != null) goto L321;
    L322:
        if (r52 != null) goto L325;
    L327:
        if (r52 != null) goto L330;
    L347:
        if (r52 != null) goto L350;
    L391:
        if (r52 != null) goto L394;
    L395:
        if (r52 != null) goto L398;
    L400:
        if (r52 != null) goto L403;
    L442:
        if (r52 == null) goto L708;
        if (r52.intValue() != 30) goto L708;
        return ActionBarSendMsgContentBuilder.e(r1, r26, r13);
    L708:
        return ActionBarSendMsgContentBuilder.c(r2, r1, r26, r13);
    L403:
        if (r52.intValue() != 23) goto L442;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L433
        if (r26 == null) goto L431;
        Iterator<T> r54 = r26.iterator();     // Catch: Throwable -> L433
    L408:
        if (r54.hasNext() == false) goto L431;
        com.larus.bmhome.actionbar.model.u r55 = (com.larus.bmhome.actionbar.model.u) r54.next();     // Catch: Throwable -> L433
        ouc.v r56 = xt7.d.b;     // Catch: Throwable -> L433
        String r57 = r55.d;     // Catch: Throwable -> L433
        if (r57 != null) goto L412;
        r57 = "";
    L412:
        r56.getClass();     // Catch: Throwable -> L433
        List r58 = ((com.larus.bmhome.actionbar.model.b0) r56.c(com.larus.bmhome.actionbar.model.b0.Companion.serializer(), r57)).a;     // Catch: Throwable -> L433
        if (r58 == null) goto L408;
        Iterator r59 = r58.iterator();     // Catch: Throwable -> L433
    L416:
        if (r59.hasNext() == false) goto L408;
        com.larus.bmhome.actionbar.model.c0 r60 = (com.larus.bmhome.actionbar.model.c0) r59.next();     // Catch: Throwable -> L433
        ouc.v r61 = xt7.d.b;     // Catch: Throwable -> L433
        String r62 = r60.c;     // Catch: Throwable -> L433
        if (r62 != null) goto L420;
        r62 = "";
    L420:
        r61.getClass();     // Catch: Throwable -> L433
        com.larus.bmhome.actionbar.model.c r63 = (com.larus.bmhome.actionbar.model.c) r61.c(com.larus.bmhome.actionbar.model.c.Companion.serializer(), r62);     // Catch: Throwable -> L433
        Integer r64 = r63.i;     // Catch: Throwable -> L433
        if (r64 == null) goto L416;
        if (r64.intValue() != 1) goto L416;
        HashMap r65 = r63.c;     // Catch: Throwable -> L433
        if (r65 == null) goto L431;
        String r66 = (String) r65.get("reply_message_format");     // Catch: Throwable -> L433
        if (r66 == null) goto L431;
        r7 = r66;
    L431:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L433
    L436:
        if (r7.length() != 0) goto L438;
        boolean r67 = true;
    L439:
        if (r67 == true) goto L705;
        return (String) r13.h.invoke(r7, r1);
    L438:
        r67 = false;
    L433:
        th = move-exception;
        Result.Companion r68 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L436
    L398:
        if (r52.intValue() != 34) goto L400;
    L448:
        ArrayList r69 = new ArrayList();
        if (r26 == null) goto L462;
        ArrayList r70 = new ArrayList();
        Iterator<T> r71 = r26.iterator();
    L452:
        if (r71.hasNext() == false) goto L463;
        Object r72 = r71.next();
        Integer r110 = ((com.larus.bmhome.actionbar.model.u) r72).b;
        if (r110 != null) goto L457;
    L459:
        boolean r111 = false;
    L460:
        if (r111 == false) goto L452;
        r70.add(r72);
        goto L452
    L457:
        if (r110.intValue() != 1) goto L459;
        r111 = true;
    L463:
        if (r70 == null) goto L482;
        Iterator r73 = r70.iterator();
    L466:
        if (r73.hasNext() == false) goto L482;
        com.larus.bmhome.actionbar.model.u r74 = (com.larus.bmhome.actionbar.model.u) r73.next();
        ActionBarSendMsgContentBuilder r75 = ActionBarSendMsgContentBuilder.a;
        String r112 = r74.d;
        r75.getClass();
        if (ActionBarSendMsgContentBuilder.o(r112) == false) goto L466;
        Result.Companion r76 = Result.Companion;     // Catch: Throwable -> L474
        ouc.v r77 = xt7.d.b;     // Catch: Throwable -> L474
        String r78 = r74.d;     // Catch: Throwable -> L474
        if (r78 != null) goto L472;
        r78 = "";
    L472:
        r77.getClass();     // Catch: Throwable -> L474
        Object r79 = Result.constructor-impl((com.larus.bmhome.actionbar.model.k0) r77.c(com.larus.bmhome.actionbar.model.k0.Companion.serializer(), r78));     // Catch: Throwable -> L474
    L477:
        if (Result.isFailure-impl(r79) == false) goto L479;
        r79 = null;
    L479:
        com.larus.bmhome.actionbar.model.k0 r80 = (com.larus.bmhome.actionbar.model.k0) r79;
        if (r80 == null) goto L466;
        r69.add(r80);
    L474:
        th = move-exception;
        Result.Companion r81 = Result.Companion;
        r79 = Result.constructor-impl(ResultKt.createFailure(th));
    L482:
        ArrayList r82 = new ArrayList();
        if (r26 == null) goto L496;
        ArrayList r83 = new ArrayList();
        Iterator<T> r84 = r26.iterator();
    L486:
        if (r84.hasNext() == false) goto L497;
        Object r113 = r84.next();
        Integer r114 = ((com.larus.bmhome.actionbar.model.u) r113).b;
        if (r114 != null) goto L491;
    L493:
        boolean r115 = false;
    L494:
        if (r115 == false) goto L486;
        r83.add(r113);
        goto L486
    L491:
        if (r114.intValue() != 2) goto L493;
        r115 = true;
    L497:
        if (r83 == null) goto L517;
        Iterator r85 = r83.iterator();
    L500:
        if (r85.hasNext() == false) goto L517;
        com.larus.bmhome.actionbar.model.u r86 = (com.larus.bmhome.actionbar.model.u) r85.next();
        ActionBarSendMsgContentBuilder r87 = ActionBarSendMsgContentBuilder.a;
        String r116 = r86.d;
        r87.getClass();
        if (ActionBarSendMsgContentBuilder.o(r116) == false) goto L500;
        Result.Companion r88 = Result.Companion;     // Catch: Throwable -> L508
        ouc.v r89 = xt7.d.b;     // Catch: Throwable -> L508
        String r90 = r86.d;     // Catch: Throwable -> L508
        if (r90 != null) goto L506;
        r90 = "";
    L506:
        r89.getClass();     // Catch: Throwable -> L508
        Object r91 = Result.constructor-impl((com.larus.bmhome.actionbar.model.i) r89.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r90));     // Catch: Throwable -> L508
    L511:
        if (Result.isFailure-impl(r91) == false) goto L513;
        r91 = null;
    L513:
        com.larus.bmhome.actionbar.model.i r92 = (com.larus.bmhome.actionbar.model.i) r91;
        if (r92 == null) goto L500;
        r82.add(r92);
    L508:
        th = move-exception;
        Result.Companion r93 = Result.Companion;
        r91 = Result.constructor-impl(ResultKt.createFailure(th));
    L517:
        if (r69.isEmpty() == true) goto L530;
        Iterator r94 = r69.iterator();
    L521:
        if (r94.hasNext() == false) goto L530;
        List r95 = ((com.larus.bmhome.actionbar.model.k0) r94.next()).c;
        if (r95 != null) goto L525;
    L527:
        boolean r96 = false;
    L528:
        if (r96 == false) goto L521;
        boolean r97 = true;
    L531:
        if (r97 == false) goto L541;
        Iterator r98 = r69.iterator();
    L534:
        if (r98.hasNext() == false) goto L592;
        List r99 = ((com.larus.bmhome.actionbar.model.k0) r98.next()).c;
        if (r99 == null) goto L534;
        Iterator r100 = r99.iterator();
    L539:
        if (r100.hasNext() == false) goto L534;
        com.larus.bmhome.actionbar.model.y1 r101 = (com.larus.bmhome.actionbar.model.y1) r100.next();
        StringBuilder r102 = new StringBuilder();
        r102.append(r7);
        ActionBarSendMsgContentBuilder.a.getClass();
        r102.append(ActionBarSendMsgContentBuilder.a(r101, r1, r82, r13));
        r7 = r102.toString();
    L592:
        if (Intrinsics.areEqual(r7, r1) == true) goto L710;
        if (r7.length() != 0) goto L596;
        boolean r103 = true;
    L597:
        if (r103 == false) goto L709;
    L596:
        r103 = false;
    L710:
        return ActionBarSendMsgContentBuilder.c(r2, r1, r26, r13);
    L541:
        Iterator r104 = r69.iterator();
    L543:
        if (r104.hasNext() == false) goto L556;
        Object r105 = r104.next();
        com.larus.bmhome.actionbar.model.y1 r106 = ((com.larus.bmhome.actionbar.model.k0) r105).b;
        if (r106 == null) goto L553;
        com.larus.bmhome.actionbar.model.q1 r107 = r106.d;
        if (r107 == null) goto L553;
        List r108 = r107.c;
        if (r108 == null) goto L553;
        if ((!r108.isEmpty()) != true) goto L553;
        boolean r109 = true;
    L554:
        if (r109 == false) goto L543;
    L557:
        com.larus.bmhome.actionbar.model.k0 r117 = (com.larus.bmhome.actionbar.model.k0) r105;
        if (r117 == null) goto L563;
        com.larus.bmhome.actionbar.model.y1 r118 = r117.b;
        if (r118 == null) goto L563;
        ActionBarSendMsgContentBuilder.a.getClass();
        String r119 = ActionBarSendMsgContentBuilder.a(r118, r1, r82, r13);
    L562:
        r7 = r119;
    L563:
        Iterator r120 = r69.iterator();
    L565:
        if (r120.hasNext() == false) goto L575;
        Object r121 = r120.next();
        com.larus.bmhome.actionbar.model.y1 r122 = ((com.larus.bmhome.actionbar.model.k0) r121).b;
        if (r122 == null) goto L571;
        com.larus.bmhome.actionbar.model.q1 r123 = r122.d;
        if (r123 == null) goto L571;
        String r124 = r123.b;
    L573:
        if (ActionBarSendMsgContentBuilder.o(r124) == false) goto L565;
    L576:
        com.larus.bmhome.actionbar.model.k0 r125 = (com.larus.bmhome.actionbar.model.k0) r121;
        if (r125 == null) goto L584;
        com.larus.bmhome.actionbar.model.y1 r126 = r125.b;
        if (r126 == null) goto L584;
        com.larus.bmhome.actionbar.model.q1 r127 = r126.d;
        if (r127 == null) goto L584;
        r8 = r127.b;
    L584:
        if (ActionBarSendMsgContentBuilder.o(r8) == false) goto L590;
        Function2 r128 = r13.h;
        if (r8 == null) goto L589;
        r7 = r8;
    L589:
        r119 = (String) r128.invoke(r7, r1);
        goto L562
    L590:
        r7 = r1;
    L571:
        r124 = null;
        goto L573
    L575:
        r121 = null;
    L553:
        r109 = false;
        goto L554
    L556:
        r105 = null;
        goto L557
    L525:
        if ((!r95.isEmpty()) != true) goto L527;
        r96 = true;
    L530:
        r97 = false;
        goto L531
    L496:
        r83 = null;
        goto L497
    L462:
        r70 = null;
        goto L463
    L394:
        if (r52.intValue() == 2) goto L448;
    L350:
        if (r52.intValue() != 5) goto L391;
        if (r26 == null) goto L366;
        Iterator<T> r129 = r26.iterator();
    L354:
        if (r129.hasNext() == false) goto L364;
        Object r130 = r129.next();
        Integer r131 = ((com.larus.bmhome.actionbar.model.u) r130).b;
        if (r131 != null) goto L359;
    L361:
        boolean r132 = false;
    L362:
        if (r132 == false) goto L354;
    L365:
        com.larus.bmhome.actionbar.model.u r133 = (com.larus.bmhome.actionbar.model.u) r130;
    L615:
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L376
        ouc.v r135 = xt7.d.b;     // Catch: Throwable -> L376
        if (r133 == null) goto L370;
        String r136 = r133.d;     // Catch: Throwable -> L376
    L371:
        if (r136 == null) goto L374;
        r7 = r136;
    L374:
        r135.getClass();     // Catch: Throwable -> L376
        Object r137 = Result.constructor-impl((com.larus.bmhome.actionbar.model.l0) r135.c(com.larus.bmhome.actionbar.model.l0.Companion.serializer(), r7));     // Catch: Throwable -> L376
    L379:
        if (Result.isFailure-impl(r137) == false) goto L381;
        r137 = null;
    L381:
        com.larus.bmhome.actionbar.model.l0 r138 = (com.larus.bmhome.actionbar.model.l0) r137;
        r1 = ActionBarSendMsgContentBuilder.m(r2, r1, null, r13);
        if (r138 == null) goto L385;
        r8 = com.larus.bmhome.actionbar.model.k1.a.a(r138, ActionBarSendMsgContentBuilder.l(r13), 2);
    L385:
        if (ActionBarSendMsgContentBuilder.o(r8) == false) goto L705;
        StringBuilder r139 = new StringBuilder();
        r139.append(r8);
        if (Intrinsics.areEqual(r13.a, "zh") == false) goto L389;
        String r140 = "：";
    L390:
        r139.append(r140);
        r139.append(r1);
        return r139.toString();
    L389:
        r140 = ":";
        goto L390
    L370:
        r136 = null;
    L376:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        r137 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L379
    L359:
        if (r131.intValue() != 5) goto L361;
        r132 = true;
        goto L362
    L364:
        r130 = null;
        goto L365
    L366:
        r133 = null;
        goto L615
    L330:
        if (r52.intValue() != 28) goto L347;
        com.larus.bmhome.actionbar.model.y r142 = r2.i;
        if (r142 == null) goto L334;
        List r143 = r142.a;
    L335:
        if (r143 != null) goto L337;
        r143 = CollectionsKt.emptyList();
    L337:
        com.larus.bmhome.actionbar.model.z0 r144 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r143, r29);
        if (r144 == null) goto L340;
        r8 = r144.q;
    L340:
        if (r8 == null) goto L343;
        r2 = r8;
    L343:
        if (r8 == null) goto L345;
        String r145 = ActionBarSendMsgContentBuilder.b(r8, r1, r0, r13);
    L703:
        return ActionBarSendMsgContentBuilder.h(r2, r1, ActionBarSendMsgContentBuilder.d(r145, r26, r13), r0, r13);
    L345:
        r145 = r1;
        goto L703
    L334:
        r143 = null;
        goto L335
    L325:
        if (r52.intValue() != 33) goto L327;
    L602:
        return ActionBarSendMsgContentBuilder.h(r2, r1, ActionBarSendMsgContentBuilder.d(ActionBarSendMsgContentBuilder.b(r2, r1, null, r13), r26, r13), null, r13);
    L321:
        if (r52.intValue() == 32) goto L602;
    L317:
        if (r52.intValue() == 24) goto L602;
    L313:
        if (r52.intValue() == 18) goto L602;
    L309:
        if (r52.intValue() == 16) goto L602;
    L305:
        if (r52.intValue() == 4) goto L602;
    L129:
        if (r52.intValue() != 1) goto L302;
        if (r26 == null) goto L145;
        Iterator<T> r146 = r26.iterator();
    L133:
        if (r146.hasNext() == false) goto L143;
        Object r147 = r146.next();
        Integer r148 = ((com.larus.bmhome.actionbar.model.u) r147).b;
        if (r148 != null) goto L138;
    L140:
        boolean r149 = false;
    L141:
        if (r149 == false) goto L133;
    L144:
        com.larus.bmhome.actionbar.model.u r150 = (com.larus.bmhome.actionbar.model.u) r147;
    L146:
        com.larus.bmhome.actionbar.util.g r151 = com.larus.bmhome.actionbar.util.g.a;
        if (r150 == null) goto L149;
        String r152 = r150.d;
    L150:
        r151.getClass();
        if (r152 != null) goto L607;
    L163:
        List r153 = null;
    L164:
        com.larus.bmhome.actionbar.model.h1 r154 = r2.c;
        if (r154 == null) goto L167;
        String r155 = r154.c;
    L168:
        com.larus.bmhome.actionbar.model.j1 r156 = r2.e;
        if (r156 == null) goto L171;
        String r157 = r156.a;
    L172:
        if (r156 == null) goto L174;
        String r158 = r156.c;
    L175:
        List r159 = CollectionsKt.listOf("music_duration");
        com.larus.bmhome.actionbar.util.g.a.getClass();
        List r160 = com.larus.bmhome.actionbar.util.g.b(r26);
        if (r160 != null) goto L178;
    L180:
        boolean r161 = false;
    L181:
        if (r161 == false) goto L183;
        ActionBarSendMsgContentBuilder.c r162 = null;
    L208:
        if (r153 == null) goto L214;
        com.larus.bmhome.actionbar.model.w r163 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.firstOrNull(r153);
        if (r163 == null) goto L214;
        Long r164 = r163.a;
        if (r164 == null) goto L214;
        Integer r165 = Integer.valueOf((int) r164.longValue());
    L215:
        if (r165 != null) goto L218;
    L258:
        if (r165 == null) goto L705;
        if (r165.intValue() != 2) goto L705;
        if (ActionBarSendMsgContentBuilder.o(r158) == false) goto L279;
        if (r162 == null) goto L273;
        String r166 = r162.a;
        if (r166 == null) goto L273;
        if (r166.length() <= 0) goto L270;
        boolean r167 = true;
    L271:
        if (r167 != true) goto L273;
        boolean r168 = true;
    L274:
        if (r168 == false) goto L279;
        Function2 r169 = r13.h;
        if (r158 != null) goto L278;
        r158 = "";
    L278:
        String r170 = (String) r169.invoke(r158, r162.a);
    L283:
        if (ActionBarSendMsgContentBuilder.o(r155) == false) goto L288;
        Function2 r171 = r13.h;
        if (r155 != null) goto L287;
        r155 = "";
    L287:
        r170 = (String) r171.invoke(r155, r170);
    L290:
        String r172 = ActionBarSendMsgContentBuilder.w(r170, r13);
        if (ActionBarSendMsgContentBuilder.o(r157) == false) goto L297;
        Function2 r173 = r13.h;
        if (r157 == null) goto L296;
        r7 = r157;
    L296:
        r1 = (String) r173.invoke(r7, r1);
    L297:
        if (r162 == null) goto L702;
        List r174 = r162.b;
        if (r174 == null) goto L702;
        r8 = CollectionsKt.joinToString$default(r174, "", null, null, 0, null, null, 62, null);
    L702:
        return r172 + r8 + "\n\n" + r1;
    L288:
        if (r170 != null) goto L290;
        r170 = "";
        goto L290
    L270:
        r167 = false;
    L273:
        r168 = false;
    L279:
        if (r162 == null) goto L281;
        r170 = r162.a;
        goto L283
    L281:
        r170 = null;
        goto L283
    L218:
        if (r165.intValue() != 1) goto L258;
        if (ActionBarSendMsgContentBuilder.o(r155) == false) goto L225;
        Function2 r175 = r13.h;
        if (r155 != null) goto L224;
        r155 = "";
    L224:
        String r176 = (String) r175.invoke(r155, r1);
    L227:
        if (ActionBarSendMsgContentBuilder.o(r158) == false) goto L243;
        if (r162 == null) goto L237;
        String r177 = r162.a;
        if (r177 == null) goto L237;
        if (r177.length() <= 0) goto L234;
        boolean r178 = true;
    L235:
        if (r178 != true) goto L237;
        boolean r179 = true;
    L238:
        if (r179 == false) goto L243;
        Function2 r180 = r13.h;
        if (r158 != null) goto L242;
        r158 = "";
    L242:
        String r181 = (String) r180.invoke(r158, r162.a);
    L246:
        if (r162 == null) goto L250;
        List r182 = r162.b;
        if (r182 == null) goto L250;
        r8 = CollectionsKt.joinToString$default(r182, "", null, null, 0, null, null, 62, null);
    L250:
        StringBuilder r183 = new StringBuilder();
        r183.append(ActionBarSendMsgContentBuilder.w(r176, r13));
        if (r181 != null) goto L253;
        r181 = "";
    L253:
        r183.append(ActionBarSendMsgContentBuilder.w(r181, r13));
        if (r8 == null) goto L257;
        r7 = r8;
    L257:
        r183.append(r7);
        return r183.toString();
    L234:
        r178 = false;
    L237:
        r179 = false;
    L243:
        if (r162 == null) goto L245;
        r181 = r162.a;
        goto L246
    L245:
        r181 = null;
        goto L246
    L225:
        r176 = r1;
    L214:
        r165 = null;
        goto L215
    L183:
        String r184 = ActionBarSendMsgContentBuilder.l(r13);
        if (r160 == null) goto L189;
        ArrayList r185 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r160, 10));
        Iterator r186 = ((ArrayList) r160).iterator();
    L187:
        if (r186.hasNext() == false) goto L190;
        r185.add(((com.larus.bmhome.actionbar.model.k1) r186.next()).c(r184, r159));
    L190:
        ArrayList r187 = new ArrayList();
        if (r160 == null) goto L198;
        Iterator r188 = ((ArrayList) r160).iterator();
    L194:
        if (r188.hasNext() == false) goto L198;
        List r189 = ((com.larus.bmhome.actionbar.model.k1) r188.next()).b(r159);
        if (r189 == null) goto L194;
        r187.addAll(r189);
    L198:
        if (r185 == null) goto L206;
        ArrayList r190 = new ArrayList();
        Iterator r191 = r185.iterator();
    L201:
        if (r191.hasNext() == false) goto L205;
        Object r192 = r191.next();
        ActionBarSendMsgContentBuilder.a.getClass();
        if (ActionBarSendMsgContentBuilder.o((String) r192) == false) goto L201;
        r190.add(r192);
        goto L201
    L205:
        String r193 = CollectionsKt.joinToString$default(r190, r184, null, null, 0, null, null, 62, null);
    L207:
        r162 = new ActionBarSendMsgContentBuilder.c(r193, r187);
        goto L208
    L206:
        r193 = null;
        goto L207
    L189:
        r185 = null;
        goto L190
    L178:
        if (((ArrayList) r160).isEmpty() != true) goto L180;
        r161 = true;
        goto L181
    L174:
        r158 = null;
        goto L175
    L171:
        r157 = null;
        goto L172
    L167:
        r155 = null;
        goto L168
    L607:
        Result.Companion r194 = Result.Companion;     // Catch: Throwable -> L155
        Object r195 = Result.constructor-impl((com.larus.bmhome.actionbar.model.i0) xt7.d.b.c(com.larus.bmhome.actionbar.model.i0.Companion.serializer(), r152));     // Catch: Throwable -> L155
    L158:
        if (Result.isFailure-impl(r195) == false) goto L160;
        r195 = null;
    L160:
        com.larus.bmhome.actionbar.model.i0 r196 = (com.larus.bmhome.actionbar.model.i0) r195;
        if (r196 == null) goto L163;
        r153 = r196.a;
    L155:
        th = move-exception;
        Result.Companion r197 = Result.Companion;
        r195 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L158
    L149:
        r152 = null;
        goto L150
    L138:
        if (r148.intValue() != 7) goto L140;
        r149 = true;
        goto L141
    L143:
        r147 = null;
        goto L144
    L145:
        r150 = null;
    L705:
        return r1;
    L17:
        if (Intrinsics.areEqual(r30, com.larus.bmhome.instruction.d2.a) == false) goto L19;
        r0 = ActionBarSendMsgReplyFormat.REPLICA_GENERATING;
        goto L21
    L19:
        if (r30 != null) goto L604;
        r0 = null;
        goto L21
    L604:
        throw new NoWhenBranchMatchedException();
    L10:
        r12 = null;
        goto L11
    L12:
        r9 = null;
        goto L14
    }
}
