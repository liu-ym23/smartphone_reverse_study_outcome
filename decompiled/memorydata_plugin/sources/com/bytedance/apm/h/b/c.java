package com.bytedance.apm.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, h> f1336b;
    public Map<String, h> c;
    public int d;
    public int e;
    public int f;
    public int g;
    private int h;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f1337a = null;

        static {
            f1337a = new c();
        }

        static /* synthetic */ c a() {
            return f1337a;
        }
    }

    public c() {
        this.d = 50;
        this.e = 20;
        this.f = 50;
        this.g = Math.min(3, 50 / 2);
        this.h = 0;
    }

    public static c a() {
        return a.a();
    }

    public synchronized void a(long r11, String r13, String r14) {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L4:
        if (this.c != null) goto L7;
        this.c = new HashMap();     // Catch: Throwable -> L44
    L7:
        if (this.c.containsKey(r13) == false) goto L11;
        h r12 = (h) ZeusTransformUtils.preCheckCast(this.c.get(r13), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        r12.d++;     // Catch: Throwable -> L44
        r12.e = System.currentTimeMillis();     // Catch: Throwable -> L44
        if (r12.d <= this.h) goto L42;
        this.h = r12.d;     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return;
    L11:
        Map<String, h> r0 = this.f1336b;     // Catch: Throwable -> L44
        if (r0 == null) goto L41;
        long r1 = Long.MAX_VALUE;
        String r3 = null;
        if (r0.containsKey(r13) == false) goto L31;
        h r15 = (h) ZeusTransformUtils.preCheckCast(this.f1336b.get(r13), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        int r16 = r15.d;     // Catch: Throwable -> L44
        r15.d = r16 + 1;     // Catch: Throwable -> L44
        r15.e = System.currentTimeMillis();     // Catch: Throwable -> L44
        if (r16 <= this.g) goto L42;
        this.f1336b.remove(r13);     // Catch: Throwable -> L44
        if (this.c.size() < this.e) goto L29;
        long r4 = this.f1335a + ((System.currentTimeMillis() - this.f1335a) / 2);     // Catch: Throwable -> L44
        Iterator<Map.Entry<String, h>> r17 = this.c.entrySet().iterator();     // Catch: Throwable -> L44
    L21:
        if (r17.hasNext() == false) goto L27;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (((h) ZeusTransformUtils.preCheckCast(r18.getValue(), h.class, "com.obric.memorydata.plugin")).e >= r4) goto L21;
        if (((h) ZeusTransformUtils.preCheckCast(r18.getValue(), h.class, "com.obric.memorydata.plugin")).d >= r1) goto L21;
        long r2 = ((h) ZeusTransformUtils.preCheckCast(r18.getValue(), h.class, "com.obric.memorydata.plugin")).d;     // Catch: Throwable -> L44
        r3 = ((h) ZeusTransformUtils.preCheckCast(r18.getValue(), h.class, "com.obric.memorydata.plugin")).f1352a;     // Catch: Throwable -> L44
        r1 = r2;
        goto L21
    L27:
        if (r3 == null) goto L29;
        this.c.remove(r3);     // Catch: Throwable -> L44
    L29:
        this.c.put(r13, r15);     // Catch: Throwable -> L44
        goto L42
    L31:
        if (this.f1336b.size() < this.d) goto L40;
        Iterator<Map.Entry<String, h>> r5 = this.f1336b.entrySet().iterator();     // Catch: Throwable -> L44
    L34:
        if (r5.hasNext() == false) goto L38;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (((h) ZeusTransformUtils.preCheckCast(r6.getValue(), h.class, "com.obric.memorydata.plugin")).e >= r1) goto L34;
        r1 = ((h) ZeusTransformUtils.preCheckCast(r6.getValue(), h.class, "com.obric.memorydata.plugin")).e;     // Catch: Throwable -> L44
        r3 = ((h) ZeusTransformUtils.preCheckCast(r6.getValue(), h.class, "com.obric.memorydata.plugin")).f1352a;     // Catch: Throwable -> L44
        goto L34
    L38:
        if (r3 == null) goto L40;
        this.f1336b.remove(r3);     // Catch: Throwable -> L44
    L40:
        this.f1336b.put(r13, new h(r13, r11, r14));     // Catch: Throwable -> L44
        goto L42
    L41:
        HashMap r7 = new HashMap();     // Catch: Throwable -> L44
        this.f1336b = r7;     // Catch: Throwable -> L44
        r7.put(r13, new h(r13, r11, r14));     // Catch: Throwable -> L44
        goto L42
    }

    public void b() {
        this.f1335a = 0;
        this.h = 0;
        Map<String, h> r0 = this.f1336b;
        if (r0 == null) goto L5;
        r0.clear();
        this.f1336b = null;
    L5:
        Map<String, h> r1 = this.c;
        if (r1 == null) goto L9;
        r1.clear();
        this.c = null;
        return;
    }

    public synchronized Map<String, h> c() {
        monitor-enter(this);
        Map<String, h> r0 = this.c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int d() {
        return this.h;
    }
}
