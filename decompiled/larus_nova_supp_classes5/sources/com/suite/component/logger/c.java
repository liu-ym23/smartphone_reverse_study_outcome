package com.suite.component.logger;

import com.suite.component.logger.api.LogLevel;
import com.suite.component.logger.api.h;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final Object w = null;
    public static c x;
    public static int y;
    public LogLevel a;
    public String b;
    public String c;
    public String[] d;
    public Function0<String> e;
    public String f;
    public String g;
    public String h;
    public int i;
    public Throwable j;
    public long k;
    public String l;
    public long m;
    public String n;
    public long o;
    public HashMap<String, Object> p;
    public HashMap<String, Object> q;
    public h r;
    public e s;
    public c t;
    public int u;
    public final int v;

    public static final class a {
        @JvmStatic
        public static c a() {
            Object r0 = c.w;
            monitor-enter(r0);
            c r1 = c.x;     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            c.x = r1.t;     // Catch: Throwable -> L10
            r1.t = null;     // Catch: Throwable -> L10
            r1.u = 0;     // Catch: Throwable -> L10
            c.y--;     // Catch: Throwable -> L10
        L8:
            monitor-exit(r0);
            return r1;
        L7:
            r1 = new c();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        w = new Object();
    }

    public final void a() {
        int r0 = this.u;
        int r1 = this.v;
        if ((r0 & r1) != r1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        this.u = r0 | r1;
        this.a = LogLevel.ERROR;
        this.b = "";
        this.c = "";
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = -1;
        this.k = -1;
        this.l = "";
        this.m = -1;
        this.n = "";
        this.o = -1;
        this.j = null;
        HashMap<String, Object> r3 = this.p;
        if (r3 == null) goto L11;
        r3.clear();
    L11:
        HashMap<String, Object> r4 = this.q;
        if (r4 == null) goto L14;
        r4.clear();
    L14:
        this.r = null;
        this.s = null;
        Object r5 = w;
        monitor-enter(r5);
        int r6 = y;     // Catch: Throwable -> L22
        if (r6 >= 50) goto L19;
        this.t = x;     // Catch: Throwable -> L22
        x = this;     // Catch: Throwable -> L22
        y = r6 + 1;     // Catch: Throwable -> L22
    L19:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r5);
        return;
    L22:
        th = move-exception;
        throw th;
    L5:
        r2 = false;
        goto L6
    }

    public c() {
        this.a = LogLevel.INFO;
        this.b = "";
        this.c = "";
        this.i = -1;
        this.k = -1;
        this.l = "";
        this.m = -1;
        this.n = "";
        this.o = -1;
        this.v = 1;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void c(Map<String, ? extends Object> r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (this.p != null) goto L13;
        this.p = new HashMap(4);
    L13:
        HashMap<String, Object> r1 = this.p;
        if (r1 == null) goto L17;
        r1.putAll(r3);
        return;
    L17:
        return;
    L4:
        if (r3.isEmpty() == true) goto L7;
        r0 = false;
        goto L8
    }
}
