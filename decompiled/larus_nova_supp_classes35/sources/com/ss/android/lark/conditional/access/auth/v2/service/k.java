package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.manager.DecisionLogManager;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.q;
import i8b.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k extends i8b.a {

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
    }

    public k(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        super(r2);
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        if ((r12 instanceof t) == false) goto L29;
        List r13 = (List) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((t) r12)).a;
        if (r13.isEmpty() == true) goto L79;
        ArrayList r0 = new ArrayList();
        Iterator r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L26;
        ValidateLogInfo r5 = (ValidateLogInfo) r14.next();
        LinkedList r6 = r5.getPolicySetKeys();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L12:
        if (r8.hasNext() == false) goto L20;
        Object r9 = r8.next();
        String r10 = (String) r9;
        List r11 = w4c.c.a().k0();
        if (r11 == null) goto L16;
        boolean r15 = r11.contains(r10);
    L17:
        if (r15 == true) goto L12;
        r7.add(r9);
        goto L12
    L16:
        r15 = false;
        goto L17
    L20:
        if ((!r7.isEmpty()) == false) goto L22;
        oe6.a r16 = new oe6.a(r5.getUk(), r7, String.valueOf(System.currentTimeMillis()));
    L23:
        if (r16 == null) goto L9;
        r0.add(r16);
        goto L9
    L22:
        r16 = null;
        goto L23
    L26:
        if ((!r0.isEmpty()) == false) goto L75;
        int r17 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_LogReportService", "[report log], report log, log is " + com.ss.android.lark.security.compliance.infra.util.f.c(r0));
        ke6.d.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "evaluateInfoList");
        DecisionLogManager.f(r0);
        return;
    L75:
        return;
    L79:
        return;
    L29:
        if ((r12 instanceof i8b.j) == false) goto L77;
        List r18 = (List) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((i8b.j) r12)).a;
        if (r18.isEmpty() == true) goto L80;
        ArrayList r1 = new ArrayList();
        Iterator r19 = r18.iterator();
    L35:
        if (r19.hasNext() == false) goto L52;
        ValidateLogInfo r20 = (ValidateLogInfo) r19.next();
        LinkedList r21 = r20.getPolicySetKeys();
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L38:
        if (r23.hasNext() == false) goto L46;
        Object r24 = r23.next();
        String r25 = (String) r24;
        List r110 = w4c.c.a().j0();
        if (r110 == null) goto L42;
        boolean r26 = r110.contains(r25);
    L43:
        if (r26 == true) goto L38;
        r22.add(r24);
        goto L38
    L42:
        r26 = false;
        goto L43
    L46:
        if ((!r22.isEmpty()) == false) goto L48;
        oe6.a r27 = new oe6.a(r20.getUk(), r22, String.valueOf(System.currentTimeMillis()));
    L49:
        if (r27 == null) goto L35;
        r1.add(r27);
        goto L35
    L48:
        r27 = null;
        goto L49
    L52:
        if ((!r1.isEmpty()) == false) goto L78;
        int r111 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_LogReportService", "delete log, log is " + com.ss.android.lark.security.compliance.infra.util.f.c(r1));
        ke6.d.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "evaluateInfoList");
        DecisionLogManager.a(r1);
        return;
    L78:
        return;
    L80:
        return;
    }
}
