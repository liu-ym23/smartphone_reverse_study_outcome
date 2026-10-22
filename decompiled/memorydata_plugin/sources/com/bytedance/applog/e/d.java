package com.bytedance.applog.e;

import android.content.Context;
import com.bytedance.applog.i;
import com.bytedance.applog.log.j;
import com.bytedance.applog.log.p;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.n.h;
import com.bytedance.applog.util.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    private static final List<String> f = null;
    private final com.bytedance.applog.h.a g;

    static {
        f = Collections.singletonList("ForwardSender");
    }

    public d(c r1, com.bytedance.applog.h.a r2) {
        super(r1);
        this.g = r2;
    }

    private void a(final String r3, Set<Long> r4, final boolean r5) {
        final Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (p.a() == false) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.isEmpty() == true) goto L12;
        p.a("event_upload_eid", new AnonymousClass1(this, r3, r6, r5));
        return;
    }

    private void a(List<com.bytedance.applog.n.f> r19, JSONObject r20, int r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        if (this.g != null) goto L5;
        return;
    L5:
        Iterator r2 = r1.iterator();
        ArrayList r3 = new ArrayList();
        HashSet r4 = new HashSet();
    L6:
        boolean r6 = true;
        if (r2.hasNext() == false) goto L19;
        JSONArray r5 = new JSONArray();
        h r15 = new h();
        r15.a(b().b(), r20, null, null, null, new JSONArray[]{null, r5, null}, new long[]{0, 0, 0}, null, null, r21);
    L10:
        if (r2.hasNext() == false) goto L18;
        com.bytedance.applog.n.f r7 = (com.bytedance.applog.n.f) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.applog.n.f.class, "com.obric.memorydata.plugin");
        r5.put(r7.m());
        if (p.a() == true) goto L17;
        if (r7.q <= 0) goto L17;
        r4.add(Long.valueOf(r7.q));
    L17:
        if (r5.length() != 200) goto L10;
    L18:
        r15.t();
        r3.add(r15);
        goto L6
    L19:
        String r8 = b().av().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.g.i());
        Iterator r9 = r3.iterator();
    L21:
        if (r9.hasNext() == false) goto L23;
        r6 = r6 & b().aw().a(r8, (h) ZeusTransformUtils.preCheckCast(r9.next(), h.class, "com.obric.memorydata.plugin"), b().aW());
        goto L21
    L23:
        a(this.f1568a.a().b(), r4, r6);
    }

    @Override // com.bytedance.applog.e.a
    public synchronized boolean b(int r10) {
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L25
        f r2 = this.f1568a.b();     // Catch: Throwable -> L25
        j r3 = b().aA();     // Catch: Throwable -> L25
        List<String> r4 = f;     // Catch: Throwable -> L25
        Object[] r6 = new Object[4];     // Catch: Throwable -> L25
        boolean r8 = false;
        r6[0] = g();     // Catch: Throwable -> L25
        r6[1] = Long.valueOf(r0);     // Catch: Throwable -> L25
        if (r2 == null) goto L6;
        String r5 = r2.c();     // Catch: Throwable -> L25
    L7:
        r6[2] = r5;     // Catch: Throwable -> L25
        r6[3] = Integer.valueOf(r10);     // Catch: Throwable -> L25
        r3.b(r4, "{} start doWork curTs={}, curSid={}, requestFrom={}", r6);     // Catch: Throwable -> L25
        com.bytedance.applog.n.b r1 = this.f1568a.d();     // Catch: Throwable -> L25
        com.bytedance.applog.k.c r7 = this.f1568a.h();     // Catch: Throwable -> L25
        if (r7.e() == true) goto L10;
    L23:
        monitor-exit(this);
        return r8;
    L10:
        if (this.g == null) goto L23;
        JSONObject r9 = l.a(r7.a());     // Catch: Throwable -> L25
        i r11 = b().z();     // Catch: Throwable -> L25
        if (r11 != null) goto L28;
    L17:
        List<com.bytedance.applog.n.f> r12 = r1.f();     // Catch: Throwable -> L25
        if (r12 != null) goto L20;
    L22:
        r8 = true;
        goto L23
    L20:
        if (r12.isEmpty() == true) goto L22;
        r1.b(r12);     // Catch: Throwable -> L25
        a(r12, r9, r10);     // Catch: Throwable -> L25
        goto L22
    L28:
        r11.a(r9);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        b().ab().a(StatsCountKeys.PACK_ERROR_COUNT);     // Catch: Throwable -> L25
        b().ab().a("HeaderCustomTimelyCallback update header failed", th);     // Catch: Throwable -> L25
        b().aA().a(f, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L25
        goto L17
    L6:
        r5 = "null";
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.e.a
    public boolean d() {
        return true;
    }

    @Override // com.bytedance.applog.e.a
    public long e() {
        com.bytedance.applog.h.a r0 = this.g;
        if (r0 == null) goto L7;
        return r0.b();
    L7:
        return this.f1568a.m().u();
    }

    @Override // com.bytedance.applog.e.a
    public long[] f() {
        return e;
    }

    @Override // com.bytedance.applog.e.a
    public String g() {
        return "ForwardSender";
    }
}
