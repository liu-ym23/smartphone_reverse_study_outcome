package com.larus.bmhome.view.actionbar.custom.cache;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.o1;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.u1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItemTag;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final Object a = null;
    public static final LinkedHashMap<ModelItemIdentity, b2> b = null;
    public static final LinkedHashMap<String, t0> c = null;
    public static volatile boolean d;
    public static volatile boolean e;

    public e() {
    }

    static {
        a = new Object();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
    }

    public static ReplyOption a(ReplyOption r14) {
        Intrinsics.checkNotNullParameter(r14, "option");
        Object r0 = a;
        monitor-enter(r0);
        boolean r2 = false;
        Object r4 = null;
        Integer r5 = null;
        Integer r6 = null;
        Integer r7 = null;
        r7 = null;
        r7 = null;
        Integer r8 = null;
        r8 = null;
        Integer r9 = null;
        r9 = null;
        if (d == false) goto L110;
        LinkedHashMap<ModelItemIdentity, b2> r1 = b;     // Catch: Throwable -> L136
        if (r1.isEmpty() == true) goto L108;
        LinkedHashMap<String, t0> r10 = c;     // Catch: Throwable -> L136
        if (r10.isEmpty() == true) goto L108;
        String r11 = r14.getModeId();     // Catch: Throwable -> L136
        if (r11 == null) goto L14;
        t0 r12 = r10.get(r11);     // Catch: Throwable -> L136
    L15:
        if (r12 != null) goto L17;
    L24:
        boolean r13 = false;
    L25:
        b2 r15 = r1.get(r14.getModel());     // Catch: Throwable -> L136
        if (r15 != null) goto L28;
    L30:
        if (r13 == false) goto L56;
        if (r2 == false) goto L56;
        List r3 = r12.n;     // Catch: Throwable -> L136
        if (r3 == null) goto L39;
        List r16 = r3;     // Catch: Throwable -> L136
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));     // Catch: Throwable -> L136
        Iterator r18 = r16.iterator();     // Catch: Throwable -> L136
    L36:
        if (r18.hasNext() == false) goto L38;
        r17.add(((o1) r18.next()).a());     // Catch: Throwable -> L136
        goto L36
    L38:
        Boolean r19 = Boolean.valueOf(CollectionsKt.contains(r17, r15.b()));     // Catch: Throwable -> L136
    L41:
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == true) goto L49;
        String r110 = r15.s;     // Catch: Throwable -> L136
        u1 r20 = r15.t;     // Catch: Throwable -> L136
        if (r20 == null) goto L45;
        r5 = r20.b;     // Catch: Throwable -> L136
    L45:
        ReplyOption r111 = ReplyOption.copy$default(r14, null, r110, r5, 1, null);     // Catch: Throwable -> L136
        monitor-exit(r0);
        return r111;
    L49:
        if (r14.getReasoningEffort() != null) goto L54;
        u1 r21 = r15.t;     // Catch: Throwable -> L136
        if (r21 == null) goto L53;
        r6 = r21.b;     // Catch: Throwable -> L136
    L53:
        r14 = ReplyOption.copy$default(r14, null, null, r6, 3, null);     // Catch: Throwable -> L136
    L54:
        monitor-exit(r0);
        return r14;
    L39:
        r19 = null;
    L56:
        if (r13 == true) goto L84;
        if (r2 == true) goto L84;
        Iterator<T> r22 = r1.entrySet().iterator();     // Catch: Throwable -> L136
    L60:
        if (r22.hasNext() == false) goto L64;
        Object r23 = r22.next();     // Catch: Throwable -> L136
        Map.Entry r24 = (Map.Entry) r23;     // Catch: Throwable -> L136
        Intrinsics.checkNotNull(r24);     // Catch: Throwable -> L136
        if ((!f.b((b2) r24.getValue())) == false) goto L60;
    L65:
        Map.Entry r25 = (Map.Entry) r23;     // Catch: Throwable -> L136
        if (r25 == null) goto L69;
        ModelItemIdentity r26 = (ModelItemIdentity) r25.getKey();     // Catch: Throwable -> L136
        if (r26 == null) goto L69;
    L70:
        if (r25 == null) goto L74;
        b2 r27 = (b2) r25.getValue();     // Catch: Throwable -> L136
        if (r27 == null) goto L74;
        String r28 = r27.s;     // Catch: Throwable -> L136
    L75:
        if (r25 == null) goto L81;
        b2 r29 = (b2) r25.getValue();     // Catch: Throwable -> L136
        if (r29 == null) goto L81;
        u1 r30 = r29.t;     // Catch: Throwable -> L136
        if (r30 == null) goto L81;
        r7 = r30.b;     // Catch: Throwable -> L136
    L81:
        ReplyOption r112 = r14.copy(r26, r28, r7);     // Catch: Throwable -> L136
        monitor-exit(r0);
        return r112;
    L74:
        r28 = null;
    L69:
        r26 = r14.getModel();     // Catch: Throwable -> L136
        goto L70
    L64:
        r23 = null;
    L84:
        if (r13 == false) goto L86;
        o1 r31 = r12.m;     // Catch: Throwable -> L136
        if (r31 == null) goto L99;
        ModelItemIdentity r32 = r31.a();     // Catch: Throwable -> L136
    L100:
        ModelItemIdentity r33 = r32;
        b2 r34 = r1.get(r33);     // Catch: Throwable -> L136
        if (r34 == null) goto L105;
        u1 r35 = r34.t;     // Catch: Throwable -> L136
        if (r35 == null) goto L105;
        r9 = r35.b;     // Catch: Throwable -> L136
    L105:
        ReplyOption r113 = ReplyOption.copy$default(r14, r33, null, r9, 2, null);     // Catch: Throwable -> L136
        monitor-exit(r0);
        return r113;
    L99:
        r32 = r14.getModel();     // Catch: Throwable -> L136
        goto L100
    L86:
        if (r15 == null) goto L88;
        String r36 = r15.s;     // Catch: Throwable -> L136
    L89:
        if (r15 == null) goto L93;
        u1 r37 = r15.t;     // Catch: Throwable -> L136
        if (r37 == null) goto L93;
        r8 = r37.b;     // Catch: Throwable -> L136
    L93:
        ReplyOption r114 = ReplyOption.copy$default(r14, null, r36, r8, 1, null);     // Catch: Throwable -> L136
        monitor-exit(r0);
        return r114;
    L88:
        r36 = null;
        goto L89
    L28:
        if (f.b(r15) == true) goto L30;
        r2 = true;
        goto L30
    L17:
        if (e == false) goto L23;
        Integer r38 = r12.j;     // Catch: Throwable -> L136
        int r39 = AgentMode.MOA.getValue();     // Catch: Throwable -> L136
        if (r38 == null) goto L24;
        if (r38.intValue() != r39) goto L24;
    L23:
        r13 = true;
        goto L25
    L14:
        r12 = null;
    L108:
        monitor-exit(r0);
        return r14;
    L110:
        LinkedHashMap<ModelItemIdentity, b2> r40 = b;     // Catch: Throwable -> L136
        b2 r41 = r40.get(r14.getModel());     // Catch: Throwable -> L136
        if (r41 != null) goto L113;
    L115:
        if (r2 == false) goto L117;
    L134:
        monitor-exit(r0);
        return r14;
    L117:
        if (r40.isEmpty() == true) goto L134;
        Iterator<T> r42 = r40.entrySet().iterator();     // Catch: Throwable -> L136
    L121:
        if (r42.hasNext() == false) goto L125;
        Object r43 = r42.next();     // Catch: Throwable -> L136
        if (h((b2) ((Map.Entry) r43).getValue()) == false) goto L121;
        r4 = r43;
    L125:
        Map.Entry r44 = (Map.Entry) r4;     // Catch: Throwable -> L136
        if (r44 == null) goto L130;
        ModelItemIdentity r45 = (ModelItemIdentity) r44.getKey();     // Catch: Throwable -> L136
        if (r45 == null) goto L130;
    L131:
        ReplyOption r115 = ReplyOption.copy$default(r14, r45, null, null, 6, null);     // Catch: Throwable -> L136
        monitor-exit(r0);
        return r115;
    L130:
        r45 = wa8.t0.a;     // Catch: Throwable -> L136
        goto L131
    L113:
        if (h(r41) != true) goto L115;
        r2 = true;
    L136:
        th = move-exception;
        throw th;
    }

    public static int c(ReplyOption r2) {
        Intrinsics.checkNotNullParameter(r2, "option");
        Object r0 = a;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (d == false) goto L11;
        String r3 = r2.getModeId();     // Catch: Throwable -> L21
        if (r3 == null) goto L15;
        t0 r4 = c.get(r3);     // Catch: Throwable -> L21
        if (r4 == null) goto L15;
        Integer r5 = r4.j;     // Catch: Throwable -> L21
    L16:
        monitor-exit(r0);
        if (r5 == null) goto L20;
        return r5.intValue();
    L20:
        return AgentMode.UNKNOWN.getValue();
    L15:
        r5 = null;
        goto L16
    L11:
        b2 r6 = b.get(r2.getModel());     // Catch: Throwable -> L21
        if (r6 == null) goto L15;
        r5 = r6.l;     // Catch: Throwable -> L21
        goto L16
    }

    public static Integer d(ModelItemIdentity r3) {
        Integer r0 = null;
        if (r3 == null) goto L17;
        Object r1 = a;
        monitor-enter(r1);
        b2 r4 = b.get(r3);     // Catch: Throwable -> L14
        if (r4 == null) goto L12;
        u1 r5 = r4.t;     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        r0 = r5.b;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r1);
    L14:
        th = move-exception;
        throw th;
    L17:
        return r0;
    }

    public static DefaultReplyMenuItemTag e(List r10) {
        Object r0 = null;
        if (r10 == null) goto L42;
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L34;
        Object r1 = r11.next();
        DefaultReplyMenuItemTag r2 = (DefaultReplyMenuItemTag) r1;
        if (r2 == null) goto L10;
        Integer r3 = r2.getType();
    L11:
        boolean r4 = false;
        if (r3 != null) goto L15;
    L26:
        if (r3 == null) goto L31;
        if (r3.intValue() != 5) goto L31;
        r4 = true;
    L31:
        if (r4 == false) goto L6;
        r0 = r1;
        goto L34
    L15:
        if (r3.intValue() != 6) goto L26;
        Long r5 = r2.getTagExpireTime();
        if (r5 == null) goto L19;
        long r6 = r5.longValue();
    L21:
        if (r6 > 0) goto L23;
    L24:
        r4 = true;
    L25:
        FLogger.a.i("ActionBarMenuSwitchHelper", "getFirstValidTag, expireTime: " + r6 + ", result: " + r4);
        goto L31
    L23:
        if ((AppHost.a.getAppClock().currentTimeMillis() / ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY)) >= r6) goto L25;
    L19:
        r6 = 0;
        goto L21
    L10:
        r3 = null;
    L34:
        return (DefaultReplyMenuItemTag) r0;
    L42:
        return null;
    }

    public static Map f(ModelItemIdentity r2) {
        if (r2 == null) goto L17;
        Object r0 = a;
        monitor-enter(r0);
        b2 r3 = b.get(r2);     // Catch: Throwable -> L13
        if (r3 == null) goto L9;
        Map r4 = r3.p;     // Catch: Throwable -> L13
    L10:
        monitor-exit(r0);
        if (r4 == null) goto L17;
        return r4;
    L9:
        r4 = null;
    L13:
        th = move-exception;
        throw th;
    L17:
        return MapsKt.emptyMap();
    }

    public static String g(ModelItemIdentity r1) {
        Map r2 = f(r1);
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("provider_id");
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    public static boolean h(b2 r2) {
        if (f.b(r2) == false) goto L6;
        return false;
    L6:
        if (e == false) goto L13;
        Integer r3 = r2.l;
        int r0 = AgentMode.MOA.getValue();
        if (r3 != null) goto L11;
    L12:
        return false;
    L11:
        if (r3.intValue() != r0) goto L12;
        return true;
    L13:
        return true;
    }

    public static boolean i(ReplyOption r1) {
        Intrinsics.checkNotNullParameter(r1, "option");
        if (c(r1) != AgentMode.MOA.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void j(List r8) {
        Intrinsics.checkNotNullParameter(r8, "cache");
        Object r0 = a;
        monitor-enter(r0);
        b.clear();     // Catch: Throwable -> L76
        c.clear();     // Catch: Throwable -> L76
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L76
    L5:
        boolean r3 = false;
        if (r9.hasNext() == false) goto L18;
        Object r1 = r9.next();     // Catch: Throwable -> L76
        p0 r5 = ((z0) r1).o;     // Catch: Throwable -> L76
        if (r5 == null) goto L15;
        Integer r6 = r5.a;     // Catch: Throwable -> L76
        int r7 = ActiveSwitchType.DEEPTHINK.getValue();     // Catch: Throwable -> L76
        if (r6 == null) goto L15;
        if (r6.intValue() != r7) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == false) goto L5;
    L19:
        z0 r2 = (z0) r1;     // Catch: Throwable -> L76
        if (r2 == null) goto L22;
        p0 r11 = r2.o;     // Catch: Throwable -> L76
    L23:
        if (r11 == null) goto L25;
        boolean r4 = Intrinsics.areEqual(r11.k, Boolean.TRUE);     // Catch: Throwable -> L76
    L26:
        d = r4;     // Catch: Throwable -> L76
        if (r11 == null) goto L31;
        a2 r12 = r11.d();     // Catch: Throwable -> L76
        if (r12 == null) goto L31;
        List r13 = r12.a;     // Catch: Throwable -> L76
    L32:
        if (r13 != null) goto L34;
        r13 = CollectionsKt.emptyList();     // Catch: Throwable -> L76
    L34:
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L76
    L36:
        if (r14.hasNext() == false) goto L42;
        b2 r15 = (b2) r14.next();     // Catch: Throwable -> L76
        ModelItemIdentity r16 = r15.b();     // Catch: Throwable -> L76
        if (r16 == null) goto L36;
        b.put(r16, r15);     // Catch: Throwable -> L76
        goto L36
    L42:
        if (d == false) goto L66;
        if (r11 == null) goto L49;
        s0 r17 = r11.j;     // Catch: Throwable -> L76
        if (r17 == null) goto L49;
        u0 r18 = r17.a;     // Catch: Throwable -> L76
        if (r18 == null) goto L49;
        List r19 = r18.a;     // Catch: Throwable -> L76
    L50:
        if (r19 != null) goto L52;
        r19 = CollectionsKt.emptyList();     // Catch: Throwable -> L76
    L52:
        Iterator r20 = r19.iterator();     // Catch: Throwable -> L76
    L54:
        if (r20.hasNext() == false) goto L66;
        t0 r21 = (t0) r20.next();     // Catch: Throwable -> L76
        String r22 = r21.a;     // Catch: Throwable -> L76
        if (r22 == null) goto L54;
        if (r22.length() <= 0) goto L60;
        boolean r23 = true;
    L61:
        if (r23 == true) goto L64;
        r22 = null;
    L64:
        if (r22 == null) goto L54;
        c.put(r22, r21);     // Catch: Throwable -> L76
        goto L54
    L60:
        r23 = false;
    L49:
        r19 = null;
    L66:
        FLogger.a.d("ActionBarMenuSwitchHelper", "store, isUsingMenuConfV2: " + d + ", modelItemMap: " + b.keySet() + ", modeItemMap: " + c.keySet());     // Catch: Throwable -> L76
        ObricTaskSkillDelegate r24 = ObricTaskSkillDelegate.b;     // Catch: Throwable -> L76
        boolean r25 = d;     // Catch: Throwable -> L76
        if (r11 == null) goto L73;
        s0 r26 = r11.j;     // Catch: Throwable -> L76
        if (r26 == null) goto L73;
        Boolean r27 = r26.d;     // Catch: Throwable -> L76
        if (r27 == null) goto L73;
        r3 = r27.booleanValue();     // Catch: Throwable -> L76
    L73:
        r24.r(r25, r3);     // Catch: Throwable -> L76
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L76
        monitor-exit(r0);
        return;
    L31:
        r13 = null;
        goto L32
    L25:
        r4 = false;
        goto L26
    L22:
        r11 = null;
    L15:
        r10 = false;
        goto L16
    L18:
        r1 = null;
    L76:
        th = move-exception;
        throw th;
    }

    public static ReplyOption b(ReplyOption.a r1, ModelItemIdentity r2, String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "modelItemIdentity");
        if (r3 != null) goto L20;
        if (r2 == null) goto L19;
        Object r5 = a;
        monitor-enter(r5);
        b2 r0 = b.get(r2);     // Catch: Throwable -> L16
        if (r0 == null) goto L11;
        String r6 = r0.s;     // Catch: Throwable -> L16
    L12:
        monitor-exit(r5);
        if (r6 == null) goto L19;
        r3 = r6;
        goto L20
    L11:
        r6 = null;
    L16:
        th = move-exception;
        throw th;
    L19:
        r3 = "";
    L20:
        if (r4 != null) goto L23;
        r4 = d(r2);
    L23:
        return new ReplyOption(r2, r3, r4);
    }
}
