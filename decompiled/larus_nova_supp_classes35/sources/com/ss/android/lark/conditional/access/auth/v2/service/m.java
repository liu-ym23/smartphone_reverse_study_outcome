package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.model.b0;
import com.bytedance.services.apm.api.EnsureManager;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.q;
import i8b.v;
import i8b.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m extends i8b.a {
    public final ConcurrentHashMap<PolicyModel, Integer> b;
    public final int c;
    public final long d;
    public Timer e;
    public b f;
    public final ScheduledExecutorService g;

    public static final class a {
    }

    public final class b extends TimerTask {
        public final /* synthetic */ m a;

        public final void a() {
            if (this.a.b.size() >= 1) goto L6;
            ScsLogger.d("SecurityPolicy_PolicyRetryService", "mRetryTable.size < 1, RetryTimeTask do not run");
            this.a.e = null;
            return;
        L6:
            ScsLogger.d("SecurityPolicy_PolicyRetryService", "RetryTimeTask run()");
            m r0 = this.a;
            r0.getClass();
            qqb.a.h("Retry validate execute");     // Catch: Throwable -> L10
            ArrayList<String> r4 = com.ss.android.lark.conditional.access.utils.c.a;     // Catch: Throwable -> L10
            com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyRetryService", "Retry validate execute", false);     // Catch: Throwable -> L10
            ArrayList r1 = Collections.list(r0.b.keys());     // Catch: Throwable -> L10
            r0.c(new i8b.c(new i8b.b(new FileAuthMonitor.a(FileAuthMonitor.UpdateTrigger.Retry, null), r1)));     // Catch: Throwable -> L10
            qqb.a.a();
            return;
        L10:
            th = move-exception;
            qqb.a.a();
            throw th;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public b(m r1) {
            this.a = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ m a;

        public c(m r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.f();     // Catch: Throwable -> L4
            this.a.b.clear();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ m b;
        public final /* synthetic */ v c;

        public d(String r1, m r2, v r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            String r1 = this.a;
            m r2 = this.b;
            v r3 = this.c;
            String r4 = qqb.a.d();     // Catch: Throwable -> L9
            qqb.a.f(r1);     // Catch: Throwable -> L7
            m.e(r2, r3.a, r3.b, r3.c.a);     // Catch: Throwable -> L7
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r4, "traceId");
            qqb.a.g(r4);
            return;
        L7:
            th = th;
        L11:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r4, "traceId");
            qqb.a.g(r4);
            throw th;
        L9:
            th = th;
            r4 = BuildConfig.FLAVOR;
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

    static {
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
    }

    @Override // i8b.a
    public final void a() {
        this.g.execute(new c(this));
    }

    public final void f() {
        ScsLogger.d("SecurityPolicy_PolicyRetryService", "stopRetryTask");
        Timer r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        b r1 = this.f;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.f = null;
        this.e = null;
    }

    public m(q r3) {
        Intrinsics.checkNotNullParameter(r3, "mManager");
        super(r3);
        this.b = new ConcurrentHashMap();
        this.c = w4c.c.a().e0();
        this.d = w4c.c.a().d0();
        this.g = CoreThreadPool.getDefault().getSingleScheduledThreadPool("security_retry_thread");
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof w) == false) goto L6;
        v r5 = (v) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((w) r4)).a;
        String r0 = qqb.a.d();
        this.g.execute(new d(r0, this, r5));
        return;
    }

    public static final void e(m r9, List r10, Map r11, FileAuthMonitor.UpdateTrigger r12) {
        r9.getClass();
        List r13 = r10;
        Iterator r0 = r13.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        PolicyModel r5 = (PolicyModel) r1;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.a.values().contains(r5.getPointKey()) == false) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L4;
    L15:
        if (r1 != null) goto L111;
        ArrayList<String> r2 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.a("SecurityPolicy_PolicyRetryService", "RetryTable update from: " + r12, true);
        if (r12 != FileAuthMonitor.UpdateTrigger.Retry) goto L32;
        Iterator r14 = r13.iterator();
    L21:
        if (r14.hasNext() == false) goto L46;
        PolicyModel r3 = (PolicyModel) r14.next();
        b0 r7 = (b0) r11.get(r3.getTaskId());
        if (r7 == null) goto L29;
        if (r7.c() != null) goto L29;
        if (com.bytedance.lark.policy.utils.d.a(r7) == true) goto L29;
        r9.b.remove(r3);
    L29:
        Integer r8 = r9.b.get(r3);
        if (r8 == null) goto L21;
        r9.b.put(r3, Integer.valueOf(r8.intValue() - 1));
    L46:
        Iterator<Map.Entry<PolicyModel, Integer>> r15 = r9.b.entrySet().iterator();
    L48:
        if (r15.hasNext() == false) goto L53;
        Map.Entry<PolicyModel, Integer> r16 = r15.next();
        if (r16.getValue().intValue() >= 1) goto L48;
        r9.b.remove(r16.getKey());
        goto L48
    L53:
        if (r9.b.size() > 0) goto L55;
        r9.e = null;
    L55:
        ArrayList<String> r17 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.a("SecurityPolicy_PolicyRetryService", "Retry table updated, size: " + r9.b.size(), false);
        if (r9.b.size() <= 0) goto L71;
        if (r12 != FileAuthMonitor.UpdateTrigger.Retry) goto L60;
    L61:
        ScsLogger.d("SecurityPolicy_PolicyRetryService", "startRetryTask");
        if (r9.e == null) goto L64;
        r9.f();
    L64:
        r9.f = new b(r9);
        PthreadTimer r18 = new PthreadTimer("PolicyRetryService");
        r9.e = r18;
        r18.schedule(r9.f, r9.d * ((long) 1000));     // Catch: Exception -> L67
    L69:
        ArrayList<String> r19 = com.ss.android.lark.conditional.access.utils.c.a;
        com.ss.android.lark.conditional.access.utils.c.a("SecurityPolicy_PolicyRetryService", "Retry execute, Timer is " + r9.e, true);
        return;
    L67:
        e = move-exception;
        r9.e = null;
        EnsureManager.ensureNotReachHere(e, "Retry timer schedule task failed");
        goto L69
    L60:
        if (r9.e == null) goto L61;
    L71:
        if (r9.b.size() > 0) goto L73;
        return;
    L73:
        if (r12 == FileAuthMonitor.UpdateTrigger.Retry) goto L110;
        com.ss.android.lark.conditional.access.utils.c.a("SecurityPolicy_PolicyRetryService", "Retry task already exist, retry timer:" + r9.e, true);
        return;
    L110:
        return;
    L32:
        Iterator r110 = r13.iterator();
    L34:
        if (r110.hasNext() == false) goto L46;
        PolicyModel r4 = (PolicyModel) r110.next();
        b0 r20 = (b0) r11.get(r4.getTaskId());
        if (r20 == null) goto L45;
        if (r20.c() != null) goto L45;
        if (com.bytedance.lark.policy.utils.d.a(r20) == true) goto L45;
        if (r9.b.get(r4) == null) goto L34;
        r9.b.remove(r4);
    L45:
        r9.b.put(r4, Integer.valueOf(r9.c));
        goto L34
    L111:
        return;
    L8:
        if (Intrinsics.areEqual(r5.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS") == true) goto L11;
        r6 = false;
        goto L12
    L14:
        r1 = null;
        goto L15
    }
}
