package com.larus.bmhome.chat.list.cell.test;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.utils.w2;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CrowdTestTask implements td8.c {
    public static final /* synthetic */ int c = 0;
    public final td8.d a;
    public final td8.c b;

    public static final class a {
    }

    static {
    }

    public CrowdTestTask(td8.d r2, td8.c r3) {
        Intrinsics.checkNotNullParameter(r2, "taskContextTask");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a = r2;
        this.b = r3;
    }

    @Override // td8.c
    public final boolean a(int r1, b r2, b r3, List<? extends b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        if (r3.getMessage().getContentType() == 67) goto L5;
    L7:
        return false;
    L5:
        if (this.a.h() == FloatChatWindowState.Preview) goto L7;
        return true;
    }

    @Override // td8.c
    public final List<b> b(int r64, b r65, b r66, List<b> r67) {
        Intrinsics.checkNotNullParameter(r66, "current");
        Intrinsics.checkNotNullParameter(r67, "input");
        ArrayList r12 = new ArrayList();
        int r0 = y.e;
        y r5 = y.a.a(r66.getMessage());
        ArrayList r6 = new ArrayList();
        Integer r7 = com.larus.im.bean.message.a.H(r66.getMessage());
        ConcurrentHashMap r1 = w2.a;
        int r2 = w2.a(r66.getMessage().getMessageId());
        if (r7 == null) goto L5;
        r2 = r7.intValue();
    L5:
        int r8 = r2;
        List r3 = r66.getMessage().getSubListGroup();
        boolean r14 = true;
        if (r3 == null) goto L24;
        List r4 = r3;
        if ((r4 instanceof Collection) == true) goto L10;
    L12:
        Iterator r9 = r4.iterator();
    L14:
        if (r9.hasNext() == false) goto L21;
        if (((List) r9.next()).size() != 1) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == true) goto L14;
        boolean r11 = false;
    L22:
        if (r11 != true) goto L24;
        boolean r13 = true;
    L25:
        List r15 = r66.getMessage().getSubListGroup();
        if (r15 == null) goto L28;
        List r16 = CollectionsKt.flatten(r15);
    L29:
        if (r16 == null) goto L50;
        List r17 = r16;
        if ((r17 instanceof Collection) == true) goto L33;
    L35:
        Iterator r18 = r17.iterator();
    L37:
        if (r18.hasNext() == false) goto L47;
        Message r19 = (Message) r18.next();
        if (r19.getContentType() != 1) goto L41;
    L44:
        boolean r110 = true;
    L45:
        if (r110 == true) goto L37;
        boolean r111 = false;
    L48:
        if (r111 != true) goto L50;
        boolean r112 = true;
    L51:
        if (r16 == null) goto L71;
        List r20 = r16;
        if ((r20 instanceof Collection) == true) goto L55;
    L57:
        Iterator r21 = r20.iterator();
    L59:
        if (r21.hasNext() == false) goto L69;
        Message r113 = (Message) r21.next();
        if (r113.getMessageStatusLocal() != 23) goto L63;
    L65:
        boolean r114 = false;
    L66:
        if (r114 == true) goto L59;
        r14 = false;
    L70:
        Boolean r115 = Boolean.valueOf(r14);
    L72:
        List r22 = r66.getMessage().getSubListGroup();
        if (r22 == null) goto L75;
        Integer r116 = Integer.valueOf(r22.size());
    L76:
        int r23 = com.larus.bmhome.chat.layout.holder.helper.s.a;
        List r24 = com.larus.bmhome.chat.layout.holder.helper.s.a(r66.getMessage());
        if (r24 == null) goto L110;
        List r25 = CollectionsKt.reversed(r24);
        if (r25 == null) goto L110;
        Iterator r117 = r25.iterator();
    L82:
        if (r117.hasNext() == false) goto L110;
        Message r118 = (Message) r117.next();
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L97
        Map r27 = r118.getBusinessExt();     // Catch: Throwable -> L97
        if (r27 != null) goto L87;
        r27 = new LinkedHashMap();     // Catch: Throwable -> L97
    L87:
        Iterator r62 = r117;
        Pair[] r119 = new Pair[4];     // Catch: Throwable -> L95
        r119[0] = TuplesKt.to("real_selected_index", String.valueOf(r7));     // Catch: Throwable -> L95
        if (r13 == false) goto L92;
        if (r112 == false) goto L92;
        boolean r120 = true;
    L93:
        r119[1] = TuplesKt.to("sub_group_full_single_text", String.valueOf(r120));     // Catch: Throwable -> L95
        r119[2] = TuplesKt.to("sub_group_number", String.valueOf(r116));     // Catch: Throwable -> L95
        r119[3] = TuplesKt.to("all_sub_group_received", String.valueOf(r115));     // Catch: Throwable -> L95
        Object r28 = Result.constructor-impl(com.larus.utils.h.c(r27, r119));     // Catch: Throwable -> L95
    L100:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L104;
        com.larus.platform.service.g.a.ensureNotReachHere(r29, "CrowdTestTask");
    L104:
        if (Result.isFailure-impl(r28) == false) goto L106;
        r28 = null;
    L106:
        Map r30 = (Map) r28;
        if (r30 != null) goto L109;
        r30 = r118.getBusinessExt();
    L109:
        MessageStatus r210 = r66.getMessage().getMessageStatus();
        String r39 = r66.getMessage().getSectionId();
        r6.add(xc8.f.f(Message.copy$default(r118, null, null, null, 0, 0, r210, 0, false, null, null, null, null, null, c.a(r118.getExt(), r66.getMessage()), null, null, 0, 0, false, r39, null, null, r30, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4726817, 31, null)));
        r117 = r62;
    L92:
        r120 = false;
    L95:
        th = th;
    L99:
        Result.Companion r31 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
    L97:
        th = th;
        r62 = r117;
    L110:
        FLogger r32 = FLogger.a;
        r32.i("EvaluationTask", "fullSingle:" + r13 + " singleText" + r112 + " subGroupNumber:" + r116 + " selectedGroupIndex:" + r8);
        StringBuilder r33 = new StringBuilder("realSelectedGroupIndex: ");
        r33.append(r7);
        r33.append(" fullReceived:");
        r33.append(r115);
        r32.i("EvaluationTask", r33.toString());
        Lazy<List<String>> r34 = p.e;
        p r35 = p.a.a(r66.getMessage());
        if (r7 == null) goto L115;
        r12.addAll(r6);
    L113:
        b r36 = r66;
    L209:
        if (td8.c.a.a(this.b, 0, null, null, r67, 7) == false) goto L215;
        List<b> r37 = this.b.b(r64, r65, r36, r67);
        if (r37.size() <= 1) goto L215;
        b r38 = (b) CollectionsKt.firstOrNull(r37);
        if (r38 == null) goto L215;
        ListProtector.add(r12, 0, r38);
    L215:
        return r12;
    L115:
        if (Intrinsics.areEqual(this.a.extraInfo().get("load_scene"), "preload") == false) goto L117;
    L119:
        boolean r40 = false;
    L120:
        if (r40 == false) goto L153;
        if (r65 == null) goto L135;
        if ((r65 instanceof yc8.a) == true) goto L133;
        String r41 = r65.getMessage().getMessageId();
        if (r41 != null) goto L127;
    L130:
        boolean r42 = true;
    L131:
        if (r42 == true) goto L133;
    L140:
        r12.addAll(r6);
        if (r66.getMessage().getMessageStatusLocal() != 22) goto L143;
        r12.add(r5);
        goto L113
    L143:
        Map<Object, Object> r43 = this.a.extraInfo();
        String r44 = r66.getMessage().getMessageId();
        String r45 = "";
        if (r44 != null) goto L147;
        r44 = "";
    L147:
        if (r43.get(r44) != null) goto L113;
        Map<Object, Object> r46 = this.a.extraInfo();
        String r47 = r66.getMessage().getMessageId();
        if (r47 == null) goto L152;
        r45 = r47;
    L152:
        r46.put(r45, Boolean.TRUE);
        r36 = r66;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new CrowdTestTask$process$2(r36, this, r8, null), 2, null);
        goto L209
    L127:
        if (r41.length() == 0) goto L130;
        r42 = false;
    L133:
        if (r64 != 1) goto L140;
    L135:
        if (Intrinsics.areEqual(r66.getMessage().getSectionId(), this.a.p()) == true) goto L139;
        if (o0.d(this.a.p()) == true) goto L140;
    L139:
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == false) goto L140;
    L153:
        r36 = r66;
        if (b0.h(r66.getMessage()) == true) goto L156;
    L158:
        Message r48 = r66.getMessage();
        Intrinsics.checkNotNullParameter(r48, "<this>");
        List r49 = r48.getSubList();
        if (r49 != null) goto L161;
        r49 = CollectionsKt.emptyList();
    L161:
        List r50 = r49;
        List r51 = r48.getSubListGroup();
        if (r51 != null) goto L164;
        r51 = CollectionsKt.emptyList();
    L164:
        List r52 = CollectionsKt.plus(r50, CollectionsKt.flatten(r51));
        if ((r52 instanceof Collection) == true) goto L167;
    L169:
        Iterator r53 = r52.iterator();
    L171:
        if (r53.hasNext() == false) goto L178;
        Message r54 = (Message) r53.next();
        if (r54 == null) goto L175;
        boolean r121 = com.larus.im.bean.message.a.r0(r54);
    L176:
        if (r121 == false) goto L171;
        boolean r55 = true;
    L179:
        if (r55 == false) goto L181;
    L207:
        r12.addAll(r6);
        r12.add(r5);
        goto L209
    L181:
        if (com.larus.im.bean.message.a.A0(r66.getMessage()) == true) goto L207;
        if (com.larus.im.bean.message.a.z0(r66.getMessage()) == true) goto L207;
        if (r66.getMessage().getMessageStatusLocal() == 20) goto L207;
        List r56 = r66.getMessage().getSubListGroup();
        if (r56 == null) goto L203;
        List r57 = r56;
        if ((r57 instanceof Collection) == true) goto L192;
    L194:
        Iterator r58 = r57.iterator();
    L196:
        if (r58.hasNext() == false) goto L200;
        boolean r59 = true;
        if ((!((List) r58.next()).isEmpty()) == true) goto L196;
        boolean r60 = false;
    L201:
        if (r60 != r59) goto L203;
        boolean r122 = true;
    L204:
        if (r122 == false) goto L206;
        r12.add(r35);
        r12.addAll(r6);
        r12.add(r5);
        goto L209
    L206:
        r12.add(r5);
        goto L209
    L200:
        r59 = true;
        r60 = true;
        goto L201
    L192:
        if (r57.isEmpty() == false) goto L194;
        r60 = true;
        r59 = true;
    L203:
        r122 = false;
        goto L204
    L175:
        r121 = false;
    L178:
        r55 = false;
        goto L179
    L167:
        if (r52.isEmpty() == false) goto L169;
    L156:
        if (com.larus.bmhome.chat.bean.d.b0(r66.getMessage()) == false) goto L158;
        r12.add(r36);
        r12.add(r5);
        goto L209
    L117:
        if (Intrinsics.areEqual(this.a.extraInfo().get("load_scene"), "preloadMessages") == true) goto L119;
        r40 = true;
        goto L120
    L75:
        r116 = null;
        goto L76
    L63:
        if (r113.getMessageStatusLocal() == 22) goto L65;
        r114 = true;
        goto L66
    L69:
        r14 = true;
        goto L70
    L55:
        if (r20.isEmpty() == false) goto L57;
    L71:
        r115 = null;
        goto L72
    L41:
        if (r19.getContentType() == 9999) goto L44;
        r110 = false;
    L47:
        r111 = true;
        goto L48
    L33:
        if (r17.isEmpty() == false) goto L35;
    L50:
        r112 = false;
        goto L51
    L28:
        r16 = null;
        goto L29
    L18:
        r10 = false;
    L21:
        r11 = true;
        goto L22
    L10:
        if (r4.isEmpty() == false) goto L12;
    L24:
        r13 = false;
        goto L25
    }
}
