package com.larus.bmhome.clarification;

import android.content.Context;
import android.view.View;
import com.ixigua.lib.track.FrozenTrackNode;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.im.bean.message.block.InteractionAskQuestion;
import com.larus.im.service.IMessageService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class t0 implements Function2 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ t0(ClarificationComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [com.larus.bmhome.clarification.d1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.larus.bmhome.clarification.f1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.larus.bmhome.clarification.g1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.clarification.h1] */
    public final Object invoke(Object r64, Object r65) {
        final ClarificationComponent r8 = this.a;
        int r9 = ((Integer) r64).intValue();
        InteractionAskOption r0 = (InteractionAskOption) r65;
        int r2 = ClarificationComponent.k0;
        Intrinsics.checkNotNullParameter(r0, "option");
        d2 r10 = r8.n.a;
        if (r10 == null) goto L493;
        int r3 = r0.getActionType();
        boolean r13 = false;
        if (r3 != 50) goto L8;
        String[] r4 = new String[2];
        r4[0] = r10.b;
        String r5 = r10.f.getLocalMessageId();
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r4[1] = r5;
        Set r6 = SetsKt.setOf(r4);
        ArrayList r7 = new ArrayList();
        Iterator r11 = r6.iterator();
    L19:
        if (r11.hasNext() == false) goto L23;
        Object r12 = r11.next();
        if ((!StringsKt.isBlank((String) r12)) == false) goto L19;
        r7.add(r12);
        goto L19
    L23:
        Set r14 = CollectionsKt.toSet(r7);
        u7 r15 = r8.u3();
        if (r15 == null) goto L26;
        List r16 = r15.zj();
    L27:
        if (r16 != null) goto L29;
        r16 = CollectionsKt.emptyList();
    L29:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L31:
        if (r18.hasNext() == false) goto L33;
        CollectionsKt.addAll(r17, r8.D3((Message) r18.next()));
        goto L31
    L33:
        Iterator r19 = r17.iterator();
    L35:
        if (r19.hasNext() == false) goto L45;
        Object r20 = r19.next();
        Message r21 = (Message) r20;
        Set r22 = r14;
        if (CollectionsKt.contains(r22, r21.getMessageId()) == false) goto L39;
    L42:
        boolean r23 = true;
    L43:
        if (r23 == false) goto L35;
    L46:
        Message r24 = (Message) r20;
        if (r24 != null) goto L49;
        r24 = r10.f;
    L49:
        Message r110 = r24;
        String[] r25 = new String[4];
        String r26 = r110.getMessageId();
        String r27 = "";
        if (r26 != null) goto L52;
        r26 = "";
    L52:
        r25[0] = r26;
        String r28 = r110.getLocalMessageId();
        if (r28 != null) goto L55;
        r28 = "";
    L55:
        r25[1] = r28;
        r25[2] = r10.b;
        String r29 = r10.f.getLocalMessageId();
        if (r29 != null) goto L58;
        r29 = "";
    L58:
        r25[3] = r29;
        Set r30 = SetsKt.setOf(r25);
        ArrayList r31 = new ArrayList();
        Iterator r32 = r30.iterator();
    L60:
        if (r32.hasNext() == false) goto L64;
        Object r33 = r32.next();
        if ((!StringsKt.isBlank((String) r33)) == false) goto L60;
        r31.add(r33);
        goto L60
    L64:
        Set r34 = CollectionsKt.toSet(r31);
        u7 r35 = r8.u3();
        if (r35 == null) goto L67;
        List r36 = r35.zj();
    L68:
        if (r36 != null) goto L70;
        r36 = CollectionsKt.emptyList();
    L70:
        Iterator r37 = r36.iterator();
    L72:
        if (r37.hasNext() == false) goto L102;
        Object r38 = r37.next();
        List r39 = r8.D3((Message) r38);
        if ((r39 instanceof Collection) == true) goto L76;
    L78:
        Iterator r40 = r39.iterator();
    L80:
        if (r40.hasNext() == false) goto L98;
        Message r41 = (Message) r40.next();
        String r111 = r41.getMessageId();
        if (r111 != null) goto L84;
        String r112 = "";
    L86:
        if (r34.contains(r112) == true) goto L94;
        String r42 = r41.getLocalMessageId();
        if (r42 != null) goto L91;
        r42 = "";
    L91:
        if (r34.contains(r42) == true) goto L94;
        boolean r43 = false;
    L95:
        if (r43 == false) goto L80;
        boolean r44 = true;
    L99:
        if (r44 == false) goto L72;
    L103:
        Message r45 = (Message) r38;
        if (r45 == null) goto L106;
        String r46 = r45.getReplyId();
    L107:
        if (r46 != null) goto L110;
        r46 = "";
    L110:
        if (StringsKt.isBlank(r46) == false) goto L115;
        r46 = r110.getReplyId();
        if (r46 != null) goto L115;
        r46 = "";
    L115:
        if (StringsKt.isBlank(r46) == false) goto L121;
        String r47 = r10.f.getReplyId();
        if (r47 == null) goto L120;
        r27 = r47;
    L120:
        final String r113 = r27;
    L123:
        if (r8.j4(r10, "auto_route_fork") == true) goto L126;
    L368:
        r13 = true;
    L369:
        if (r13 == true) goto L493;
        InteractionAskQuestion r1 = (InteractionAskQuestion) CollectionsKt.getOrNull(r10.h, r9);
        if (r1 == null) goto L493;
        final String r48 = r0.getOptionId();
        if (r48 != null) goto L378;
        r48 = "";
    L378:
        if (StringsKt.isBlank(r48) == true) goto L493;
        Integer r49 = r1.getType();
        if (r49 == null) goto L383;
        final int r50 = r49.intValue();
    L384:
        d2 r51 = r8.n.a;
        if (r51 == null) goto L397;
        List<z1> r52 = r51.l;
        if (r52 == null) goto L397;
        z1 r53 = (z1) CollectionsKt.getOrNull(r52, r9);
        if (r53 == null) goto L397;
        i r54 = r53.l;
        if (r54 == null) goto L397;
        List<String> r55 = r54.a;
        if (r55 == null) goto L397;
        if (r55.contains(r48) != true) goto L397;
        boolean r114 = true;
    L398:
        r8.n.d(r9, new y0(r50, r48));
        d2 r56 = r8.n.a;
        if (r56 == null) goto L411;
        List<z1> r57 = r56.l;
        if (r57 == null) goto L411;
        z1 r58 = (z1) CollectionsKt.getOrNull(r57, r9);
        if (r58 == null) goto L411;
        i r59 = r58.l;
        if (r59 == null) goto L411;
        List<String> r60 = r59.a;
        if (r60 == null) goto L411;
        if (r60.contains(r48) != true) goto L411;
        boolean r61 = true;
    L412:
        d2 r62 = r8.n.a;
        if (r62 == null) goto L454;
        z1 r63 = (z1) CollectionsKt.getOrNull(r62.l, r9);
        if (r63 == null) goto L421;
        i r66 = r63.l;
        if (r66 == null) goto L421;
        List<String> r67 = r66.a;
        if (r67 == null) goto L421;
        Integer r68 = Integer.valueOf(r67.size());
    L422:
        String r69 = r62.d;
        String r70 = r62.b;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        com.larus.trace.tracknode.a r115 = com.larus.ui.arch.component.internal.attach.a.b(r8, r8);
        if ((r115 instanceof com.larus.trace.tracknode.a) == false) goto L425;
        com.larus.trace.tracknode.a r116 = r115;
    L426:
        if (r116 == null) goto L428;
        String r117 = r116.k();
    L429:
        String r118 = u1.c(Integer.valueOf(r50));
        String r71 = r1.getQuestionId();
        if (r114 == false) goto L432;
        String r119 = "unselect";
    L433:
        com.larus.bmhome.interactionpanel.w r72 = r62.n;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        FrozenTrackNode r120 = by7.h.d(com.larus.ui.arch.component.internal.attach.a.b(r8, r8));
        JSONObject r121 = new JSONObject();
        Intrinsics.checkNotNullParameter(r121, "params");
        if (r69 != null) goto L496;
    L438:
        if (r70 == null) goto L440;
        r121.put(MusicAppletPage.KEY_MESSAGE_ID, r70);     // Catch: JSONException -> L436
    L440:
        if (r117 == null) goto L442;
        r121.put("current_page", r117);     // Catch: JSONException -> L436
    L442:
        r121.put("question_type", r118);     // Catch: JSONException -> L436
        if (r71 == null) goto L445;
        r121.put("question_id", r71);     // Catch: JSONException -> L436
    L445:
        r121.put("option_id", r48);     // Catch: JSONException -> L436
        r121.put("select_action", r119);     // Catch: JSONException -> L436
        if (r68 == null) goto L448;
        r121.put("selected_count", r68.intValue());     // Catch: JSONException -> L436
    L448:
        com.larus.bmhome.interactionpanel.x.a(r121, r72);     // Catch: JSONException -> L436
    L451:
        i2.a("select_clarification_option", r121, r120);
    L436:
        e = move-exception;
        FLogger.a.e("ClarificationTracer", "error in ClarificationTracer mobSelectClarificationOption " + e.getLocalizedMessage());
        goto L451
    L496:
        r121.put("clarify_id", r69);     // Catch: JSONException -> L436
        goto L438
    L432:
        r119 = "select";
        goto L433
    L428:
        r117 = null;
        goto L429
    L425:
        r116 = null;
    L421:
        r68 = null;
    L454:
        if (r50 != 1) goto L456;
    L458:
        ze8.b r73 = r10.k;
        if (r73 == null) goto L461;
        r73.h(r9);
    L461:
        r8.l4();
        if (r50 != 1) goto L487;
        if (r61 == true) goto L470;
        d2 r74 = r8.n.a;
        if (r74 == null) goto L493;
        ze8.b r75 = r74.k;
        if (r75 == null) goto L493;
        r75.e(r9);
        goto L493
    L470:
        if (r9 == r10.j) goto L472;
        r8.n.c(r9);
    L472:
        ze8.b r76 = r10.k;
        if (r76 == null) goto L493;
        if (r9 < CollectionsKt.getLastIndex(r10.h)) goto L480;
        d2 r77 = r8.n.a;
        if (r77 == null) goto L493;
        r8.h4(r77);
        goto L493
    L480:
        int r78 = RangesKt.coerceAtMost(r9 + 1, CollectionsKt.getLastIndex(r10.h));
        r8.N = Integer.valueOf(r78);
        if (r76.b() == false) goto L486;
        r8.X3(r10, r9);
        r8.n.c(r78);
        r8.W3(r10, r78, "next", "click");
        r76.e(r78);
        ICoreInputAbility r79 = r8.H3();
        if (r79 == null) goto L485;
        r79.qp(false);
    L485:
        r8.l4();
        goto L487
    L486:
        r8.N = null;
    L487:
        d2 r80 = r8.n.a;
        if (r80 == null) goto L493;
        ze8.b r81 = r80.k;
        if (r81 == null) goto L493;
        r81.e(r9);
        goto L493
    L456:
        if (r50 == 2) goto L458;
    L411:
        r61 = false;
    L397:
        r114 = false;
        goto L398
    L383:
        r50 = 0;
        goto L384
    L126:
        if (z2.a.J3() == true) goto L129;
        FLogger.a.d("ClarificationComponent", "auto-route fork blocked: settings disabled");
        t19.s r82 = t19.s.a;
        Context r83 = r8.getContext();
        r82.getClass();
        t19.s.b(r83, 2131905626, false);
    L146:
        boolean r84 = false;
    L147:
        if (r84 == true) goto L160;
        com.larus.bmhome.interactionpanel.m r85 = r8.Q;
        if (r85 == null) goto L368;
        if (Intrinsics.areEqual(r85.a.a, r10.a) == false) goto L368;
        if (Intrinsics.areEqual(r85.a.c, r10.c) == false) goto L368;
        a2 r86 = r8.R;
        if (r86 == null) goto L159;
        r86.b(r85, false, "auto_route_fork_failed");
    L159:
        r8.S = false;
        goto L368
    L160:
        r8.Q3(r10);
        r8.C3(r10, "finish_submitted", ClarificationAttachmentReleasePolicy.DISMISS_AND_DELETE_TEMP_RESOURCES, true, true);
        g r87 = g.a;
        u7 r88 = r8.u3();
        if (r88 == null) goto L163;
        List r89 = r88.zj();
    L164:
        if (r89 != null) goto L166;
        r89 = CollectionsKt.emptyList();
    L166:
        ?? r90 = new d1(r8);
        ?? r91 = new f1(r8);
        ?? r92 = new g1(r8);
        r87.getClass();
        Intrinsics.checkNotNullParameter(r110, "answerMessage");
        Intrinsics.checkNotNullParameter(r113, "sourceMessageId");
        Intrinsics.checkNotNullParameter(r89, "messages");
        Intrinsics.checkNotNullParameter(r90, "hideMessage");
        Intrinsics.checkNotNullParameter(r91, "refreshMessage");
        Intrinsics.checkNotNullParameter(r92, "stopTts");
        String[] r93 = new String[2];
        String r94 = r110.getMessageId();
        if (r94 != null) goto L169;
        r94 = "";
    L169:
        r93[0] = r94;
        String r95 = r110.getLocalMessageId();
        if (r95 != null) goto L172;
        r95 = "";
    L172:
        r93[1] = r95;
        Set r96 = SetsKt.setOf(r93);
        ArrayList r97 = new ArrayList();
        Iterator r98 = r96.iterator();
    L174:
        if (r98.hasNext() == false) goto L179;
        Object r122 = r98.next();
        if ((!StringsKt.isBlank((String) r122)) == false) goto L174;
        r97.add(r122);
        goto L174
    L179:
        Set r99 = CollectionsKt.toSet(r97);
        if (StringsKt.isBlank(r113) == true) goto L195;
        Iterator r100 = r89.iterator();
        int r123 = 0;
    L184:
        if (r100.hasNext() == false) goto L195;
        Message r124 = (Message) r100.next();
        if (Intrinsics.areEqual(r124.getMessageId(), r113) == false) goto L188;
    L191:
        boolean r125 = true;
    L192:
        if (r125 == true) goto L196;
        r123 = r123 + 1;
    L196:
        Message r101 = (Message) CollectionsKt.getOrNull(r89, r123);
        if (r123 < 0) goto L205;
        List r102 = CollectionsKt.asReversed(r89.subList(0, r123));
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L200:
        if (r104.hasNext() == false) goto L247;
        Object r126 = r104.next();
        if ((!com.larus.bmhome.chat.bean.d.G0((Message) r126)) == false) goto L247;
        r103.add(r126);
    L247:
        if (r103.isEmpty() == true) goto L274;
        Iterator r105 = r103.iterator();
    L251:
        if (r105.hasNext() == false) goto L274;
        List r106 = g.b((Message) r105.next());
        if ((r106 instanceof Collection) == true) goto L255;
    L257:
        Iterator r107 = r106.iterator();
    L259:
        if (r107.hasNext() == false) goto L271;
        Message r127 = (Message) r107.next();
        if (com.larus.bmhome.chat.bean.d.Q0(r127) == false) goto L263;
    L268:
        boolean r128 = true;
    L269:
        if (r128 == false) goto L259;
        boolean r108 = true;
    L272:
        if (r108 == false) goto L251;
        boolean r109 = true;
    L275:
        if (r109 == true) goto L284;
        ArrayList r129 = new ArrayList();
        Iterator r130 = r103.iterator();
    L279:
        if (r130.hasNext() == false) goto L283;
        Object r131 = r130.next();
        if (g.d((Message) r131) == false) goto L279;
        r129.add(r131);
        goto L279
    L283:
        r103 = r129;
    L284:
        HashSet r132 = new HashSet();
        ArrayList r133 = new ArrayList();
        Iterator r134 = r103.iterator();
    L286:
        if (r134.hasNext() == false) goto L300;
        Object r135 = r134.next();
        Message r136 = (Message) r135;
        String r137 = r136.getLocalMessageId();
        if (r137 != null) goto L291;
        r137 = "";
    L291:
        if (StringsKt.isBlank(r137) == false) goto L297;
        String r138 = r136.getMessageId();
        if (r138 != null) goto L295;
        r138 = "";
    L295:
        r137 = r138;
    L297:
        if (r132.add(r137) == false) goto L286;
        r133.add(r135);
        goto L286
    L300:
        if (r133.isEmpty() == true) goto L367;
        if (r109 == false) goto L356;
        List r139 = CollectionsKt.createListBuilder();
        r139.add(r113);
        if (r101 == null) goto L312;
        String r140 = r101.getMessageId();
        if (r140 != null) goto L308;
        r140 = "";
    L308:
        r139.add(r140);
        String r141 = r101.getLocalMessageId();
        if (r141 != null) goto L311;
        r141 = "";
    L311:
        r139.add(r141);
    L312:
        g.a.getClass();
        Iterator r142 = ((ArrayList) g.c(r133)).iterator();
    L314:
        if (r142.hasNext() == false) goto L325;
        Message r143 = (Message) r142.next();
        String r144 = r143.getMessageId();
        if (r144 != null) goto L318;
        r144 = "";
    L318:
        r139.add(r144);
        String r145 = r143.getLocalMessageId();
        if (r145 != null) goto L321;
        r145 = "";
    L321:
        r139.add(r145);
        String r146 = r143.getReplyId();
        if (r146 != null) goto L324;
        r146 = "";
    L324:
        r139.add(r146);
        goto L314
    L325:
        List r147 = CollectionsKt.build(r139);
        ArrayList r148 = new ArrayList();
        Iterator r149 = r147.iterator();
    L327:
        if (r149.hasNext() == false) goto L331;
        Object r150 = r149.next();
        if ((!StringsKt.isBlank((String) r150)) == false) goto L327;
        r148.add(r150);
        goto L327
    L331:
        h r151 = h.a;
        monitor-enter(r151);
        Intrinsics.checkNotNullParameter(r148, "identifiers");     // Catch: Throwable -> L353
        h.a("discarded_answer_identifiers", r148);     // Catch: Throwable -> L353
        monitor-exit(r151);
        if (r101 == null) goto L348;
        Map r152 = r101.getBusinessExt();
        if (r152 != null) goto L339;
        r152 = MapsKt.emptyMap();
    L339:
        Map r153 = MapsKt.toMutableMap(r152);
        r153.put("send_loading", TriggerSendLoading.NO_LOADING);
        r91.invoke(Message.copy$default(r101, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, r153, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194305, 31, null));
        IChatRepoService r154 = zh8.a.a;
        String r155 = r101.getLocalMessageId();
        if (r155 != null) goto L343;
        r155 = "";
    L343:
        if (StringsKt.isBlank(r155) == false) goto L347;
        r155 = r101.getMessageId();
        if (r155 != null) goto L347;
        r155 = "";
    L347:
        r154.r1(r155, new e());
        FLogger.a.i("AutoRouteClarificationPolicy", "stop auto-route source fake loading, conversationId=" + r101.getConversationId() + ", messageId=" + r101.getMessageId() + ", localMessageId=" + r101.getLocalMessageId());
        Unit r156 = Unit.INSTANCE;
    L348:
        Iterator r157 = r133.iterator();
    L350:
        if (r157.hasNext() == false) goto L352;
        r90.invoke(r157.next());
        goto L350
    L352:
        r92.invoke();
    L360:
        String r158 = r110.getConversationId();
        if (r158 != null) goto L363;
        r158 = "";
    L363:
        String r159 = r158;
        if ((!StringsKt.isBlank(r159)) == false) goto L366;
        IMessageService.a.a(com.larus.im.d.e(), r159, r133, false, false, false, null, 48);
    L366:
        List r160 = SequencesKt.toList(SequencesKt.take(SequencesKt.map(CollectionsKt.asSequence(r133), new f()), 10));
        FLogger.a.i("AutoRouteClarificationPolicy", "discard auto-route answers, sourceMessageId=" + r113 + ", isRoundGenerating=" + r109 + ", discardCount=" + r133.size() + ", messageIdPreview=" + r160);
    L353:
        th = move-exception;
        throw th;
    L356:
        Iterator r161 = r133.iterator();
    L358:
        if (r161.hasNext() == false) goto L360;
        r90.invoke(r161.next());
    L367:
        r8.Z3(r10, true, "auto_route_fork");
        goto L368
    L263:
        if (r127.getMessageStatusLocal() == 20) goto L268;
        if (r127.getMessageStatusLocal() == 24) goto L268;
        r128 = false;
    L271:
        r108 = false;
        goto L272
    L255:
        if (r106.isEmpty() == false) goto L257;
    L274:
        r109 = false;
        goto L275
    L205:
        ArrayList r162 = new ArrayList();
        Iterator r163 = r89.iterator();
    L207:
        if (r163.hasNext() == false) goto L245;
        Object r164 = r163.next();
        Message r165 = (Message) r164;
        if (com.larus.bmhome.chat.bean.d.G0(r165) == true) goto L241;
        g.a.getClass();
        List r166 = g.b(r165);
        if ((r166 instanceof Collection) == true) goto L213;
    L215:
        Iterator r167 = r166.iterator();
    L217:
        if (r167.hasNext() == false) goto L238;
        Message r168 = (Message) r167.next();
        String r169 = r168.getMessageId();
        if (r169 != null) goto L221;
        r169 = "";
    L221:
        Iterator r170 = r167;
        if (r99.contains(r169) == true) goto L234;
        String r171 = r168.getLocalMessageId();
        if (r171 != null) goto L227;
        r171 = "";
    L227:
        if (r99.contains(r171) == true) goto L234;
        if ((!StringsKt.isBlank(r113)) == true) goto L231;
    L233:
        boolean r172 = false;
    L235:
        if (r172 == true) goto L236;
        r167 = r170;
        goto L217
    L236:
        boolean r173 = true;
    L239:
        if (r173 == false) goto L241;
        boolean r174 = true;
    L242:
        if (r174 == false) goto L207;
        r162.add(r164);
        goto L207
    L231:
        if (Intrinsics.areEqual(r168.getReplyId(), r113) == false) goto L233;
    L234:
        r172 = true;
    L238:
        r173 = false;
        goto L239
    L213:
        if (r166.isEmpty() == false) goto L215;
    L241:
        r174 = false;
        goto L242
    L245:
        r103 = r162;
        goto L247
    L188:
        if (Intrinsics.areEqual(r124.getLocalMessageId(), r113) == true) goto L191;
        r125 = false;
    L195:
        r123 = -1;
        goto L196
    L163:
        r89 = null;
        goto L164
    L129:
        if (StringsKt.isBlank(r113) == false) goto L131;
        FLogger.a.e("ClarificationComponent", "auto-route fork failed: source message id is empty");
        t19.s r175 = t19.s.a;
        Context r176 = r8.getContext();
        r175.getClass();
        t19.s.b(r176, 2131901132, false);
        goto L146
    L131:
        View r177 = r8.z;
        if (r177 != null) goto L135;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r177 = com.larus.ui.arch.component.internal.attach.a.b(r8, r8).getView();
    L135:
        com.larus.bmhome.instruction.g r178 = r8.vc();
        if (r178 == null) goto L138;
        com.larus.bmhome.actionbar.model.z0 r179 = r178.un(ActiveSwitchType.DEEPTHINK, null);
    L139:
        if (r177 == null) goto L145;
        if (r179 == null) goto L145;
        r84 = IMainBotNestedMenuService.a.Q8(r177, r179, new h1(r8, r113));
        if (r84 == true) goto L147;
        FLogger.a.e("ClarificationComponent", "auto-route fork failed: task mode target unavailable");
        t19.s r180 = t19.s.a;
        Context r181 = r8.getContext();
        r180.getClass();
        t19.s.b(r181, 2131901132, false);
    L145:
        FLogger.a.e("ClarificationComponent", "auto-route fork failed: action bar config unavailable");
        t19.s r182 = t19.s.a;
        Context r183 = r8.getContext();
        r182.getClass();
        t19.s.b(r183, 2131901132, false);
        goto L146
    L138:
        r179 = null;
        goto L139
    L121:
        r113 = r46;
        goto L123
    L106:
        r46 = null;
    L94:
        r43 = true;
        goto L95
    L84:
        r112 = r111;
    L98:
        r44 = false;
        goto L99
    L76:
        if (r39.isEmpty() == false) goto L78;
    L102:
        r38 = null;
        goto L103
    L67:
        r36 = null;
        goto L68
    L39:
        if (CollectionsKt.contains(r22, r21.getLocalMessageId()) == true) goto L42;
        r23 = false;
        goto L43
    L45:
        r20 = null;
        goto L46
    L26:
        r16 = null;
        goto L27
    L8:
        if (r3 != 51) goto L369;
        if (r8.j4(r10, "auto_route_close") == false) goto L368;
        r8.Q3(r10);
        r8.C3(r10, "close_button", ClarificationAttachmentReleasePolicy.DISMISS_AND_DELETE_TEMP_RESOURCES, true, true);
        r8.Z3(r10, true, "auto_route_close");
    L493:
        return Unit.INSTANCE;
    }
}
