package com.bytedance.badger.y;

import com.bytedance.badger.Badger;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.EventReportEnum;
import com.bytedance.badger.j;
import com.bytedance.badger.network.d0;
import com.bytedance.badger.network.z0;
import com.bytedance.badger.v.h;
import com.bytedance.badger.v.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements Runnable {
    public final /* synthetic */ EventReportEnum a;
    public final /* synthetic */ Map b;

    public e(EventReportEnum r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        BadgerCore.Companion.getClass();
        if (j.a().initCore() == true) goto L5;
    L101:
        com.bytedance.badger.e.e("event_behavior# ", "initCore error");
        return;
    L5:
        if (j.a().isInitialized() == false) goto L101;
        g r0 = g.e;
        EventReportEnum r1 = this.a;
        Map r2 = this.b;
        if (r1.getValue().length() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        com.bytedance.badger.e.g("event_behavior# ", "record ignored: invalid eventName");
        return;
    L13:
        long r7 = System.currentTimeMillis();
        if (r1.getValue().equals(EventReportEnum.START.getValue()) == false) goto L25;
        Object r3 = g.b;
        monitor-enter(r3);
        LinkedHashMap r5 = g.c;     // Catch: Throwable -> L22
        r5.clear();     // Catch: Throwable -> L22
        LinkedHashMap r6 = g.d;     // Catch: Throwable -> L22
        r6.clear();     // Catch: Throwable -> L22
        r5.put(r1, new ArrayDeque());     // Catch: Throwable -> L22
        r6.put(r1, new a(r7, r7));     // Catch: Throwable -> L22
        a74.e.c();     // Catch: Throwable -> L22
        int r8 = com.bytedance.badger.t.a.a;     // Catch: Throwable -> L22
        com.bytedance.badger.e.f("event_behavior# ", "start event: clear event status=" + com.bytedance.badger.t.a.a(1644488531, null, f.a, 2).e());     // Catch: Throwable -> L22
        monitor-exit(r3);
        com.bytedance.badger.e.f("event_behavior# ", "start event: clear done.");
        return;
    L22:
        th = move-exception;
        throw th;
    L25:
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r10 = r2.entrySet().iterator();
    L27:
        if (r10.hasNext() == false) goto L43;
        Map.Entry r12 = (Map.Entry) r10.next();
        String r13 = (String) r12.getKey();
        Object r14 = r12.getValue();
        if (r13 == null) goto L42;
        String r15 = StringsKt.trim(r13).toString();
        if (r15.length() != 0) goto L33;
        boolean r16 = true;
    L34:
        if (r16 == true) goto L27;
        if (r14 == null) goto L37;
        Object r17 = r0.a(r14, 0);
        if (r17 == null) goto L27;
    L40:
        r9.put(r15, r17);
        goto L27
    L37:
        r17 = null;
        goto L40
    L33:
        r16 = false;
        goto L34
    L42:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L43:
        Object r18 = g.b;
        monitor-enter(r18);
        LinkedHashMap r19 = g.c;     // Catch: Throwable -> L98
        Object r20 = r19.get(r1);     // Catch: Throwable -> L98
        if (r20 != null) goto L48;
        r20 = new ArrayDeque();     // Catch: Throwable -> L98
        r19.put(r1, r20);     // Catch: Throwable -> L98
    L48:
        ArrayDeque r22 = (ArrayDeque) r20;     // Catch: Throwable -> L98
        Iterator r23 = r9.entrySet().iterator();     // Catch: Throwable -> L98
    L50:
        if (r23.hasNext() == false) goto L66;
        Map.Entry r24 = (Map.Entry) r23.next();     // Catch: Throwable -> L98
        String r25 = (String) r24.getKey();     // Catch: Throwable -> L98
        r22.addFirst(new b(r25, r24.getValue(), r7));     // Catch: Throwable -> L98
        EventReportEnum r26 = EventReportEnum.TOUCH;     // Catch: Throwable -> L98
        if (r1 != r26) goto L60;
        if (Intrinsics.areEqual(r25, r26.getValue()) == false) goto L60;
        com.bytedance.badger.v.d.f0.getClass();     // Catch: Throwable -> L98
        h r27 = com.bytedance.badger.v.d.Z;     // Catch: Throwable -> L98
        KProperty r28 = com.bytedance.badger.v.d.a[52];     // Catch: Throwable -> L98
        int r29 = ((Number) r27.a()).intValue();     // Catch: Throwable -> L98
    L56:
        if (r29 <= 0) goto L50;
        if (r22.size() <= r29) goto L50;
        r22.removeLast();     // Catch: Throwable -> L98
    L60:
        if (r1 == r26) goto L50;
        com.bytedance.badger.v.d.f0.getClass();     // Catch: Throwable -> L98
        h r30 = com.bytedance.badger.v.d.a0;     // Catch: Throwable -> L98
        KProperty r32 = com.bytedance.badger.v.d.a[53];     // Catch: Throwable -> L98
        int r33 = ((Number) r30.a()).intValue();     // Catch: Throwable -> L98
    L62:
        if (r33 <= 0) goto L50;
        if (r22.size() <= r33) goto L50;
        r22.removeLast();     // Catch: Throwable -> L98
        goto L62
    L66:
        com.bytedance.badger.v.d.f0.getClass();     // Catch: Throwable -> L98
        com.bytedance.badger.v.f r34 = com.bytedance.badger.v.d.c0;     // Catch: Throwable -> L98
        KProperty[] r35 = com.bytedance.badger.v.d.a;     // Catch: Throwable -> L98
        KProperty r36 = r35[55];     // Catch: Throwable -> L98
        if (((Boolean) r34.a()).booleanValue() == false) goto L69;
        a74.e.a(Badger.INSTANCE.getContext().getApplicationContext());     // Catch: Throwable -> L98
    L69:
        LinkedHashMap r37 = g.d;     // Catch: Throwable -> L98
        a r38 = (a) r37.get(r1);     // Catch: Throwable -> L98
        if (r38 != null) goto L72;
        r37.put(r1, new a(r7, r7));     // Catch: Throwable -> L98
    L73:
        monitor-exit(r18);
        switch(c.a[r1.ordinal()]) {
            case 1: goto L88;
            case 2: goto L87;
            case 3: goto L86;
            case 4: goto L85;
            case 5: goto L84;
            case 6: goto L83;
            case 7: goto L82;
            case 8: goto L81;
            case 9: goto L80;
            case 10: goto L79;
            case 11: goto L78;
            default: goto L77;
        };
    L78:
        String r39 = "4011";
    L89:
        m r40 = com.bytedance.badger.v.d.Y;
        KProperty r42 = r35[51];
        if (((Collection) r40.a()).contains(r39) == false) goto L130;
        com.bytedance.badger.e.g("event_behavior# ", "maybeTriggerReport start " + r1);
        z0 r43 = d0.a;     // Catch: Throwable -> L95
        d0.b(14, z64.h.a.a, new d(r1), true);     // Catch: Throwable -> L95
        return;
    L95:
        th = move-exception;
        com.bytedance.badger.e.c("event_behavior# ", "event report dispatch failed: " + th.getMessage(), th);
        return;
    L130:
        return;
    L79:
        r39 = "4010";
        goto L89
    L80:
        r39 = "4009";
        goto L89
    L81:
        r39 = "4008";
        goto L89
    L82:
        r39 = "4007";
        goto L89
    L83:
        r39 = "4006";
        goto L89
    L84:
        r39 = "4005";
        goto L89
    L85:
        r39 = "4004";
        goto L89
    L86:
        r39 = "4003";
        goto L89
    L87:
        r39 = "4002";
        goto L89
    L88:
        r39 = "4001";
        goto L89
    L77:
        throw new NoWhenBranchMatchedException();
    L72:
        r38.b = r7;     // Catch: Throwable -> L98
    L98:
        th = move-exception;
        throw th;
    L10:
        r4 = false;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
