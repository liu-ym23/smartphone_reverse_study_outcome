package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f0 {
    public final long a;
    public final long b;
    public final int c;
    public final ArrayList<e0> d;
    public final ArrayList<r0> e;
    public com.lynx.tasm.base.e<f0> f;
    public int g;
    public boolean h;

    public final void a(LynxMemoryCollectionStatus r15) {
        if (this.h == false) goto L5;
        return;
    L5:
        TraceEvent.beginSection("GlobalMemoryUsage.finish");
        this.h = true;
        n0 r1 = n0.c;
        long r2 = System.currentTimeMillis();
        long r3 = this.a;
        long r4 = r2 - r3;
        p0 r5 = p0.a(r3, r15, r4, this.b, this.c, n0.a(), this.e);
        if (TraceEvent.isTracingStarted() == false) goto L8;
        HashMap r6 = new HashMap();
        r6.put("status", r15.name());
        r6.put("duration_ms", String.valueOf(r4));
        r6.put("expected_instances", String.valueOf(this.c));
        r6.put("completed_fetchers", String.valueOf(this.g));
        TraceEvent.instant(0, "GlobalMemoryUsage.total", r6);
    L8:
        ArrayList r16 = new ArrayList(this.d);
        this.d.clear();
        com.lynx.tasm.base.e<f0> r7 = this.f;
        this.f = null;
        if (r7 == null) goto L11;
        r7.accept(this);
    L11:
        Iterator r17 = r16.iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        b((e0) r17.next(), r5);
        goto L13
    L15:
        TraceEvent.endSection("GlobalMemoryUsage.finish");
    }

    public static void b(e0 r1, p0 r2) {
        r1.onResult(r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        LLog.e("LynxMemoryUsageContext", "Failed to deliver Lynx memory usage result: " + th.getMessage());
    }

    public f0(long r3, long r5, int r7, e0 r8) {
        ArrayList<e0> r0 = new ArrayList();
        this.d = r0;
        this.e = new ArrayList();
        this.a = r3;
        this.b = r5;
        this.c = r7;
        if (this.h == true) goto L8;
        if (r8 == null) goto L9;
        r0.add(r8);
        return;
    L9:
        return;
    }
}
