package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class StaticPageHost {
    public static final ConcurrentHashMap<Integer, WeakReference<StaticPageHost>> i = null;
    public final Object a;
    public final Executor b;
    public int c;
    public boolean d;
    public long e;
    public Map<String, Object> f;
    public Map<String, Object> g;
    public x1 h;

    static {
        i = new ConcurrentHashMap();
    }

    public final void a() {
        Object r0 = this.a;
        monitor-enter(r0);
        g();     // Catch: Throwable -> L9
        this.e++;     // Catch: Throwable -> L9
        this.d = false;     // Catch: Throwable -> L9
        this.c = -1;     // Catch: Throwable -> L9
        final x1 r1 = this.h;     // Catch: Throwable -> L9
        this.h = null;     // Catch: Throwable -> L9
        this.f = Collections.emptyMap();     // Catch: Throwable -> L9
        this.g = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        b("destroy", new u1(r1));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Object r0 = this.a;
        monitor-enter(r0);
        boolean r1 = this.d;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void g() {
        int r0 = this.c;
        if (r0 >= 0) goto L5;
        return;
    L5:
        ConcurrentHashMap<Integer, WeakReference<StaticPageHost>> r1 = i;
        WeakReference<StaticPageHost> r2 = r1.get(Integer.valueOf(r0));
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.get() != this) goto L12;
        r1.remove(Integer.valueOf(this.c), r2);
        return;
    }

    public StaticPageHost(Executor r2) {
        this.a = new Object();
        this.c = -1;
        this.f = Collections.emptyMap();
        this.b = r2;
    }

    public static StaticPageHost c(int r3) {
        ConcurrentHashMap<Integer, WeakReference<StaticPageHost>> r0 = i;
        WeakReference<StaticPageHost> r1 = r0.get(Integer.valueOf(r3));
        if (r1 != null) goto L6;
        return null;
    L6:
        StaticPageHost r2 = r1.get();
        if (r2 != null) goto L9;
        r0.remove(Integer.valueOf(r3), r1);
    L9:
        return r2;
    }

    private static boolean renderPageForNative(int r4) {
        StaticPageHost r5 = c(r4);
        if (r5 == null) goto L24;
        Object r1 = r5.a;
        monitor-enter(r1);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (r5.d == false) goto L17;
        x1 r2 = r5.h;     // Catch: Throwable -> L21
        if (r2 == null) goto L17;
        Map<String, Object> r6 = r5.f;     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        r2.b(r6);     // Catch: RuntimeException -> L15
        boolean r7 = true;
    L19:
        if (r7 == true) goto L29;
        return false;
    L29:
        return true;
    L15:
        e = move-exception;
        e("renderPage", e);
    L18:
        r7 = false;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L21
        goto L18
    L24:
        return false;
    }

    public static void e(String r2, Throwable r3) {
        LLog.e("StaticPageHost", "Static page direct " + r2 + " failed:\n" + CallStackUtil.a(r3));
    }

    public final void b(final String r3, final Runnable r4) {
        this.b.execute(new w1(r4, r3));     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        e(r3.concat(" dispatch"), e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Object> h(TemplateData r9, TemplateData r10) {
        Object r0 = this.a;
        monitor-enter(r0);
        x1 r1 = null;
        if (r9 != null) goto L36;
        Map r11 = null;
    L8:
        if (r11 != null) goto L10;
        final Map<String, Object> r6 = null;
    L15:
        if (r10 != null) goto L17;
        Map r12 = null;
    L18:
        if (r12 != null) goto L20;
        Map<String, Object> r13 = null;
    L26:
        if (this.d == false) goto L28;
        r1 = this.h;     // Catch: Throwable -> L33
    L28:
        final x1 r3 = r1;
        final long r4 = this.e;     // Catch: Throwable -> L33
        monitor-exit(r0);     // Catch: Throwable -> L33
        if (r3 == null) goto L32;
        final Map<String, Object> r7 = r13;
        b("updateMetaData", new v1(this, r3, r4, r6, r7));
    L32:
        return r13;
    L33:
        th = move-exception;
        throw th;
    L20:
        if (this.g != null) goto L22;
        this.g = r12;     // Catch: Throwable -> L33
    L23:
        r13 = this.g;     // Catch: Throwable -> L33
        goto L26
    L22:
        HashMap r14 = new HashMap(this.g);     // Catch: Throwable -> L33
        r14.putAll(r12);     // Catch: Throwable -> L33
        this.g = r14;     // Catch: Throwable -> L33
        goto L23
    L17:
        r12 = r10.toMap();     // Catch: Throwable -> L33
        goto L18
    L10:
        if (this.f.isEmpty() == false) goto L12;
        this.f = r11;     // Catch: Throwable -> L33
    L13:
        r6 = this.f;     // Catch: Throwable -> L33
        goto L15
    L12:
        HashMap r2 = new HashMap(this.f);     // Catch: Throwable -> L33
        r2.putAll(r11);     // Catch: Throwable -> L33
        this.f = r2;     // Catch: Throwable -> L33
        goto L13
    L36:
        r11 = r9.toMap();     // Catch: Throwable -> L33
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Object> f(int r7, TemplateData r8, TemplateData r9, TemplateData r10, TemplateData r11) {
        boolean r2 = false;
        TemplateData[] r1 = {r9, r10, r11};
        Map r3 = null;
        int r12 = 0;
    L3:
        if (r12 >= 3) goto L14;
        TemplateData r4 = r1[r12];
        if (r4 != null) goto L7;
        Map r5 = null;
    L8:
        if (r5 == null) goto L13;
        if (r3 != null) goto L12;
        r3 = r5;
        goto L13
    L12:
        HashMap r6 = new HashMap(r3);
        r6.putAll(r5);
        r3 = r6;
    L13:
        r12 = r12 + 1;
        r3 = r3;
        goto L3
    L7:
        r5 = r4.toMap();
        goto L8
    L14:
        Object r13 = this.a;
        monitor-enter(r13);
        g();     // Catch: Throwable -> L39
        this.e++;     // Catch: Throwable -> L39
        if (r8 != null) goto L19;
        Map r14 = null;
    L20:
        if (r14 != null) goto L22;
    L25:
        if (r3 != null) goto L27;
    L30:
        this.c = r7;     // Catch: Throwable -> L39
        this.h = null;     // Catch: Throwable -> L39
        if (r7 < 0) goto L33;
        r2 = true;
    L33:
        this.d = r2;     // Catch: Throwable -> L39
        if (r2 == false) goto L36;
        i.put(Integer.valueOf(r7), new WeakReference(this));     // Catch: Throwable -> L39
    L36:
        Map<String, Object> r15 = this.g;     // Catch: Throwable -> L39
        monitor-exit(r13);     // Catch: Throwable -> L39
        return r15;
    L27:
        if (this.g != null) goto L29;
        this.g = r3;     // Catch: Throwable -> L39
        goto L30
    L29:
        HashMap r16 = new HashMap(r3);     // Catch: Throwable -> L39
        r16.putAll(this.g);     // Catch: Throwable -> L39
        this.g = r16;     // Catch: Throwable -> L39
        goto L30
    L22:
        if (this.f.isEmpty() == false) goto L24;
        this.f = r14;     // Catch: Throwable -> L39
        goto L25
    L24:
        HashMap r0 = new HashMap(r14);     // Catch: Throwable -> L39
        r0.putAll(this.f);     // Catch: Throwable -> L39
        this.f = r0;     // Catch: Throwable -> L39
        goto L25
    L19:
        r14 = r8.toMap();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }
}
