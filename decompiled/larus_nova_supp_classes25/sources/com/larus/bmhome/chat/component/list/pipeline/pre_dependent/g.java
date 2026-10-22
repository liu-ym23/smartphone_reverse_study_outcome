package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements td8.c {
    public static Long b;
    public final td8.d a;

    public static final class a {
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return true;
    }

    public g(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    public final void c(Message r11, String r12) {
        ChatControlTrace r0 = ChatControlTrace.b;
        String r1 = r11.getMessageId();
        String r2 = r11.getSenderId();
        String r3 = com.larus.bmhome.chat.bean.d.Z0(r11);
        Long r5 = Long.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - (r11.getCreateTime() * ((long) 1000)), 0));
        long r6 = this.a.b();
        if (com.larus.bmhome.chat.bean.d.x(r11).getNextPulseType() == null) goto L5;
        boolean r4 = true;
    L6:
        Boolean r8 = Boolean.valueOf(r4);
        Integer r9 = com.larus.bmhome.chat.bean.d.x(r11).getNextPulseType();
        r0.getClass();
        ChatControlTrace.Q(r1, r2, r3, r12, r5, r6, r8, r9);
        return;
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // td8.c
    public final List<xc8.b> b(int r20, xc8.b r21, xc8.b r22, List<xc8.b> r23) {
        Intrinsics.checkNotNullParameter(r22, "current");
        Intrinsics.checkNotNullParameter(r23, "input");
        List r3 = CollectionsKt.takeLast(r23, 10);
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r6 = r5.next();
        if (com.larus.bmhome.chat.bean.d.k0(((xc8.b) r6).getMessage()) == false) goto L4;
        r4.add(r6);
        goto L4
    L8:
        Iterator r7 = r4.iterator();
        if (r7.hasNext() == true) goto L11;
        Long r8 = null;
    L17:
        if (r8 == null) goto L38;
        long r9 = r8.longValue();
        LinkedHashSet r10 = new LinkedHashSet();
        ?? r11 = new ArrayList();
        Iterator r12 = r4.iterator();
    L20:
        if (r12.hasNext() == false) goto L40;
        Object r13 = r12.next();
        Message r14 = ((xc8.b) r13).getMessage();
        if (r14.getServerIndex() != r9) goto L34;
        String r15 = r14.getMessageId();
        if (r15 != null) goto L27;
    L30:
        boolean r16 = true;
    L31:
        if (r16 == false) goto L33;
    L35:
        boolean r17 = false;
    L36:
        if (r17 == false) goto L20;
        r11.add(r13);
        goto L20
    L33:
        if (r10.add(r15) == true) goto L35;
    L27:
        if (r15.length() == 0) goto L30;
        r16 = false;
    L34:
        r17 = true;
    L40:
        if (r11.isEmpty() == false) goto L42;
        Message r18 = null;
    L73:
        ArrayList r2 = new ArrayList();
        Iterator r19 = r23.iterator();
    L75:
        if (r19.hasNext() == false) goto L109;
        xc8.b r24 = (xc8.b) r19.next();
        Message r25 = r24.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r25) == false) goto L82;
        if (com.larus.bmhome.chat.bean.d.w(r25) == true) goto L82;
    L101:
        boolean r26 = false;
    L102:
        if (r26 == false) goto L107;
        if (b0.f(r24.getMessage()) == true) goto L107;
        r2.add(r24);
    L107:
        if (r2.size() >= 2) goto L109;
    L82:
        if (com.larus.bmhome.chat.bean.d.T(r25) == true) goto L101;
        if (com.larus.bmhome.chat.bean.d.p0(r25) == true) goto L101;
        if (com.larus.bmhome.chat.bean.d.C0(r25) == true) goto L89;
    L91:
        MessageStatus r27 = r25.getMessageStatus();
        if (r27 != null) goto L94;
    L96:
        boolean r28 = false;
    L97:
        if (r28 == false) goto L99;
    L100:
        r26 = true;
        goto L102
    L99:
        if (b0.f(r25) == false) goto L101;
    L94:
        if (r27.isVisible() != true) goto L96;
        r28 = true;
        goto L97
    L89:
        if (r25.getRegenVisible() == true) goto L91;
    L109:
        boolean r29 = false;
        Pair r30 = TuplesKt.to(CollectionsKt.getOrNull(r2, 0), CollectionsKt.getOrNull(r2, 1));
        xc8.b r31 = (xc8.b) r30.component1();
        xc8.b r32 = (xc8.b) r30.component2();
        if (r31 != null) goto L112;
        return r23;
    L112:
        Message r33 = r31.getMessage();
        if (com.larus.bmhome.chat.bean.d.W0(r33) == true) goto L115;
    L114:
        boolean r34 = false;
    L120:
        if (r34 == false) goto L123;
        c(r31.getMessage(), "wcb downgrade");
        r23.remove(r31);
        return r23;
    L123:
        Message r35 = r31.getMessage();
        if (r32 == null) goto L126;
        Message r36 = r32.getMessage();
    L128:
        if (com.larus.bmhome.chat.bean.d.W0(r35) == false) goto L143;
        if (r36 == null) goto L143;
        if (com.larus.bmhome.chat.bean.d.Y0(r35) == true) goto L143;
        if (com.larus.bmhome.chat.bean.d.X0(r35) == true) goto L143;
        long r110 = r35.getCreateTime() - r36.getCreateTime();
        long r37 = z2.a.showWCBMinIntervalBeforePrevMessage();
        if (r37 <= 0) goto L143;
        if (r110 >= r37) goto L143;
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r35).get("next_pulse_scene"), "2") == false) goto L142;
        FLogger.a.i("Pipeline_List_PreDependentFilterTask", "isWrongSequenceWelcomeBack but is regenerate, timeAfterPrevMessage = " + r110 + ", local messageId is " + r35.getLocalMessageId());
        goto L143
    L142:
        FLogger.a.i("Pipeline_List_PreDependentFilterTask", "isWrongSequenceWelcomeBack timeAfterPrevMessage = " + r110 + ", local messageId is " + r35.getLocalMessageId());
        r29 = true;
    L143:
        if (r29 == false) goto L145;
        c(r31.getMessage(), "wrong sequence");
        r23.remove(r31);
    L145:
        return r23;
    L126:
        r36 = r18;
        goto L128
    L115:
        long r111 = z2.a.hideWcbBeforeTimestamp();
        if (r111 <= 0) goto L114;
        if (r33.getCreateTime() >= r111) goto L114;
        FLogger.a.i("Pipeline_List_PreDependentFilterTask", "hideWcbDowngrade hideWcbBeforeTimestamp = " + r111 + ", local messageId is " + r33.getLocalMessageId());
        r34 = true;
        goto L120
    L42:
        LinkedHashMap r38 = new LinkedHashMap();
        Iterator r39 = r4.iterator();
    L44:
        if (r39.hasNext() == false) goto L49;
        Object r40 = r39.next();
        Long r112 = Long.valueOf(((xc8.b) r40).getMessage().getServerIndex());
        Object r113 = r38.get(r112);
        if (r113 != null) goto L48;
        r113 = new ArrayList();
        r38.put(r112, r113);
    L48:
        ((List) r113).add(r40);
        goto L44
    L49:
        ArrayList r41 = new ArrayList(r38.size());
        Iterator r42 = r38.entrySet().iterator();
    L51:
        if (r42.hasNext() == false) goto L57;
        Map.Entry r114 = (Map.Entry) r42.next();
        StringBuilder r115 = new StringBuilder();
        r115.append(((Number) r114.getKey()).longValue());
        r115.append(':');
        Iterable r116 = (Iterable) r114.getValue();
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r118 = r116.iterator();
    L54:
        if (r118.hasNext() == false) goto L56;
        xc8.b r119 = (xc8.b) r118.next();
        r117.add(r119.getMessage().getMessageId() + '_' + r119.getMessage().getLocalMessageId() + '_' + r119.getMessage().getLocalIndex() + '_' + r119.getMessage().getCreateTime());
        goto L54
    L56:
        r115.append(r117);
        r41.add(r115.toString());
        goto L51
    L57:
        String r43 = r41.toString();
        FLogger r44 = FLogger.a;
        r44.e("Pipeline_List_PreDependentFilterTask", "dedupeFirstMetMsg firstMeet map size = " + r38.size() + ", content=" + r43);
        if (this.a.e() == true) goto L60;
    L59:
        r18 = null;
    L67:
        if (z2.a.a3().a() == false) goto L73;
        r23.removeAll((Collection) r11);
        StringBuilder r45 = new StringBuilder("do remove duplicate firstMet ");
        Iterable r120 = (Iterable) r11;
        ArrayList r46 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator r47 = r120.iterator();
    L70:
        if (r47.hasNext() == false) goto L72;
        xc8.b r48 = (xc8.b) r47.next();
        r46.add(r48.getMessage().getMessageId() + '_' + r48.getMessage().getLocalIndex() + '_' + r48.getMessage().getCreateTime());
        goto L70
    L72:
        r45.append(r46);
        r44.e("Pipeline_List_PreDependentFilterTask", r45.toString());
        goto L73
    L60:
        Long r49 = b;
        if (r49 != null) goto L63;
    L65:
        b = Long.valueOf(this.a.b());
        r18 = null;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PreDependentFilterTask$monitorDuplicateFirstMeetMsg$1(this, r38, r43, null), 3, null);
        goto L67
    L63:
        if (r49.longValue() != this.a.b()) goto L65;
    L38:
        r11 = CollectionsKt.emptyList();
        goto L40
    L11:
        r8 = Long.valueOf(((xc8.b) r7.next()).getMessage().getServerIndex());
    L13:
        if (r7.hasNext() == false) goto L17;
        Long r50 = Long.valueOf(((xc8.b) r7.next()).getMessage().getServerIndex());
        if (r8.compareTo(r50) >= 0) goto L13;
        r8 = r50;
        goto L13
    }
}
