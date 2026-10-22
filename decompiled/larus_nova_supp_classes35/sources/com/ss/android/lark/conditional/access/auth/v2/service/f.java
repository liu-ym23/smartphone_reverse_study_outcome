package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.lark.policy.model.b0;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import i8b.p;
import i8b.q;
import i8b.r;
import i8b.s;
import i8b.v;
import i8b.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends i8b.a {
    public PthreadTimer b;
    public a c;
    public final ConcurrentHashMap<String, i> d;
    public final long e;
    public final long f;
    public final ScheduledExecutorService g;

    public final class a extends TimerTask {
        public final /* synthetic */ f a;

        public final void a() {
            ArrayList<String> r0 = com.ss.android.lark.conditional.access.utils.c.a;
            com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_DelayCleanupService", "Clean up execute", true);
            ArrayList r1 = new ArrayList();
            long r3 = System.currentTimeMillis();
            f r5 = this.a;
            Iterator<Map.Entry<String, i>> r6 = r5.d.entrySet().iterator();
        L3:
            int r8 = 0;
            if (r6.hasNext() == false) goto L15;
            Map.Entry<String, i> r7 = r6.next();
            String r9 = r7.getKey();
            i r10 = r7.getValue();
            if (r10.a == false) goto L3;
            Long r11 = r10.b;
            if (r11 != null) goto L11;
        L13:
            if (r8 == 0) goto L3;
            r1.add(r9);
            r10.b = null;
            goto L3
        L11:
            if ((r3 - r11.longValue()) < r5.f) goto L13;
            r8 = 1;
            goto L13
        L15:
            int r4 = ScsLogger.a;
            ScsLogger.a("SecurityPolicy_DelayCleanupService", "IpInfo will clean: " + this.a.d);
            Iterator<Map.Entry<String, i>> r12 = this.a.d.entrySet().iterator();
        L17:
            if (r12.hasNext() == false) goto L21;
            if (r12.next().getValue().b == null) goto L17;
            r8 = r8 + 1;
            goto L17
        L21:
            if (r8 >= 1) goto L24;
            f r13 = this.a;
            r13.g.execute(new g(r13));
        L24:
            if ((true ^ r1.isEmpty()) == false) goto L39;
            ScsLogger.d("SecurityPolicy_DelayCleanupService", "notifyEvent RemoveResultEvent");
            this.a.c(new s(r1));
            return;
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

        public a(f r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
        this.g.execute(new g(this));
        this.d.clear();
    }

    public final int e() {
        Iterator<Map.Entry<String, i>> r0 = this.d.entrySet().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().getValue().a == false) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        return r1;
    }

    public f(q r3) {
        Intrinsics.checkNotNullParameter(r3, "mManager");
        super(r3);
        this.d = new ConcurrentHashMap();
        this.e = w4c.c.a().a0() * 1000;
        this.f = w4c.c.a().b0() * 1000;
        this.g = CoreThreadPool.getDefault().getSingleScheduledThreadPool("security_delay_clean_thread");
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof w) == false) goto L22;
        ScsLogger.d("SecurityPolicy_DelayCleanupService", "handleEvent ValidateUpdateEvent");
        Map<String, b0> r6 = ((v) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((w) r5)).a).b;
        ScsLogger.a("SecurityPolicy_DelayCleanupService", "updateClearInfo taskID: " + r6 + ", " + this.d);
        Iterator<Map.Entry<String, i>> r0 = this.d.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L19;
        Map.Entry<String, i> r1 = r0.next();
        String r2 = r1.getKey();
        i r3 = r1.getValue();
        if (r3.a == false) goto L6;
        if (r3.b == null) goto L6;
        b0 r4 = r6.get(r2);
        if (r4 == null) goto L6;
        if (r4.c() != null) goto L6;
        if (r4.getType() == ResponseType.DOWNGRADE) goto L6;
        r3.b = null;
        goto L6
    L19:
        if (e() >= 1) goto L43;
        this.g.execute(new g(this));
        return;
    L43:
        return;
    L22:
        if ((r5 instanceof p) == false) goto L25;
        f(((IPConfig) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((p) r5)).a).getIpConfigInfo());
        return;
    L25:
        if ((r5 instanceof r) == true) goto L27;
        return;
    L27:
        if (((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((r) r5)).a != FileAuthMonitor.UpdateTrigger.NetworkChange) goto L47;
        ScsLogger.d("SecurityPolicy_DelayCleanupService", "handleEvent LifeCycleEvent.data == NetworkChange");
        this.g.execute(new h(this));
        return;
    }

    public final void f(Map<String, Boolean> r6) {
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_DelayCleanupService", "updateIPConfig, ipConfigMap is " + com.ss.android.lark.security.compliance.infra.util.f.c(r6));
        Iterator<Map.Entry<String, Boolean>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        Map.Entry<String, Boolean> r1 = r7.next();
        String r2 = r1.getKey();
        boolean r3 = r1.getValue().booleanValue();
        i r4 = this.d.get(r2);
        if (r4 == null) goto L8;
        Long r5 = r4.b;
    L9:
        if (r5 == null) goto L13;
        if (r3 == false) goto L13;
        this.d.put(r2, new i(true, r4.b));
    L13:
        this.d.put(r2, new i(r3, null));
        goto L4
    L8:
        r5 = null;
        goto L9
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
        com.ss.android.lark.storage.kv.repo.a r4 = y.a;
        com.ss.android.lark.storage.kv.repo.a r5 = y.a;
        if (r5 == null) goto L5;
        IPConfig r6 = (IPConfig) r5.getJSONObject("FileAuthIPConfig", IPConfig.class);
    L6:
        if (r6 != null) goto L8;
        Map<String, Boolean> r7 = new HashMap();
    L9:
        f(r7);
        this.g.execute(new h(this));
        return;
    L8:
        r7 = r6.getIpConfigInfo();
        goto L9
    L5:
        r6 = null;
        goto L6
    }
}
