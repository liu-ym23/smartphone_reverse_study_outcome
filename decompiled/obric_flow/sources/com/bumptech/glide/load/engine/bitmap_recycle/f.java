package com.bumptech.glide.load.engine.bitmap_recycle;

import ai.i0;
import ai.q0;
import ai.w0;
import android.util.Log;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class f implements ei.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1456c;
    public final Object d;
    public final Cloneable e;
    public final Object f;

    public f(LinkedList r5, int r10, Request r11, SsHttpCall r12, i0 r13) {
        this.f1456c = r5;
        this.f1454a = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
    }

    public void a(int r5, Class r10) {
        NavigableMap r11 = f(r10);
        Integer r12 = (Integer) r11.get(Integer.valueOf(r5));
        if (r12 == null) goto L10;
        if (r12.intValue() != 1) goto L7;
        r11.remove(Integer.valueOf(r5));
        return;
    L7:
        r11.put(Integer.valueOf(r5), Integer.valueOf(r12.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r5 + ", this: " + this);
    }

    public void b(int r10) {
    L3:
        if (this.f1455b <= r10) goto L7;
        Object r5 = ((s6.c) this.f1456c).B();
        io.reactivex.internal.observers.h.g(r5);
        b r11 = d(r5.getClass());
        this.f1455b = this.f1455b - (r11.b() * r11.a(r5));
        a(r11.a(r5), r5.getClass());
        if (Log.isLoggable(r11.c(), 2) == false) goto L3;
        Log.v(r11.c(), "evicted: " + r11.a(r5));
        goto L3
    }

    public synchronized Object c(int r5, Class r10) {
        monitor-enter(this);
        Integer r11 = (Integer) f(r10).ceilingKey(Integer.valueOf(r5));     // Catch: Throwable -> L16
        if (r11 == null) goto L18;
        int r12 = this.f1455b;     // Catch: Throwable -> L16
        if (r12 != 0) goto L8;
    L12:
        e r13 = (e) this.d;     // Catch: Throwable -> L16
        int r14 = r11.intValue();     // Catch: Throwable -> L16
        h r15 = (h) ((ArrayDeque) r13.f22372b).poll();     // Catch: Throwable -> L16
        if (r15 != null) goto L15;
        r15 = r13.F();     // Catch: Throwable -> L16
    L15:
        d r16 = (d) r15;     // Catch: Throwable -> L16
        r16.f1451b = r14;     // Catch: Throwable -> L16
        r16.f1452c = r10;     // Catch: Throwable -> L16
    L22:
        Object r17 = e(r16, r10);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r17;
    L8:
        if ((this.f1454a / r12) >= 2) goto L12;
        if (r11.intValue() <= (r5 * 8)) goto L12;
    L18:
        e r18 = (e) this.d;     // Catch: Throwable -> L16
        h r19 = (h) ((ArrayDeque) r18.f22372b).poll();     // Catch: Throwable -> L16
        if (r19 != null) goto L21;
        r19 = r18.F();     // Catch: Throwable -> L16
    L21:
        r16 = (d) r19;     // Catch: Throwable -> L16
        r16.f1451b = r5;     // Catch: Throwable -> L16
        r16.f1452c = r10;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public b d(Class r5) {
        HashMap r10 = (HashMap) this.f;
        b r11 = (b) r10.get(r5);
        if (r11 == null) goto L5;
    L13:
        return r11;
    L5:
        if (r5.equals(int[].class) == false) goto L8;
        r11 = new b(1);
    L10:
        r10.put(r5, r11);
        goto L13
    L8:
        if (r5.equals(byte[].class) == false) goto L12;
        r11 = new b(0);
        goto L10
    L12:
        throw new IllegalArgumentException("No array pool found for: ".concat(r5.getSimpleName()));
    }

    public Object e(d r10, Class r11) {
        b r5 = d(r11);
        Object r12 = ((s6.c) this.f1456c).v(r10);
        if (r12 == null) goto L5;
        this.f1455b = this.f1455b - (r5.b() * r5.a(r12));
        a(r5.a(r12), r11);
    L5:
        if (r12 == null) goto L7;
        return r12;
    L7:
        if (Log.isLoggable(r5.c(), 2) == false) goto L9;
        Log.v(r5.c(), "Allocated " + r10.f1451b + " bytes");
    L9:
        int r13 = r10.f1451b;
        switch(r5.f1446a) {
            case 0: goto L13;
            default: goto L11;
        };
    L11:
        Object r14 = new int[r13];
    L15:
        return r14;
    L13:
        r14 = new byte[r13];
        goto L15
    }

    public NavigableMap f(Class r5) {
        HashMap r10 = (HashMap) this.e;
        NavigableMap r11 = (NavigableMap) r10.get(r5);
        if (r11 != null) goto L6;
        TreeMap r12 = new TreeMap();
        r10.put(r5, r12);
        return r12;
    L6:
        return r11;
    }

    public q0 g(Request r10) {
        if (this.f1454a >= ((LinkedList) this.f1456c).size()) goto L36;
        int r5 = this.f1455b + 1;
        this.f1455b = r5;
        if (r5 <= 1) goto L20;
        Iterator r11 = ((LinkedList) this.f1456c).iterator();
    L8:
        if (r11.hasNext() == false) goto L20;
        ei.b r12 = (ei.b) r11.next();
        if ((r12 instanceof ai.f) == false) goto L8;
        ai.f r13 = (ai.f) r12;
        monitor-enter(r13);
        r13.f = false;     // Catch: Throwable -> L17
        monitor-exit(r13);
    L17:
        th = move-exception;
        throw th;
    L20:
        LinkedList r14 = (LinkedList) this.f1456c;
        int r15 = this.f1454a;
        f r16 = new f(r14, r15 + 1, r10, (SsHttpCall) this.e, (i0) this.f);
        ei.b r17 = (ei.b) r14.get(r15);
        StringBuilder r18 = new StringBuilder("interceptor = ");
        if (r17 == null) goto L23;
        String r19 = r17.toString();
    L24:
        r18.append(r19);
        r18.append(" url = ");
        r18.append(r10.getUrl());
        String r110 = r18.toString();
        if (r110 != null) goto L28;
    L30:
        q0 r111 = r17.intercept(r16);
        if (r111 == null) goto L34;
        return r111;
    L34:
        throw new NullPointerException("interceptor " + r17 + " returned null");
    L28:
        if (w0.f306b > 3) goto L30;
        Log.d("RealInterceptorChain", r110);
        goto L30
    L23:
        r19 = "";
        goto L24
    L36:
        throw new AssertionError();
    }

    public synchronized void h(Object r10) {
        monitor-enter(this);
        Class<?> r5 = r10.getClass();     // Catch: Throwable -> L15
        b r11 = d(r5);     // Catch: Throwable -> L15
        int r12 = r11.a(r10);     // Catch: Throwable -> L15
        int r13 = r11.b() * r12;     // Catch: Throwable -> L15
        if (r13 > (this.f1454a / 2)) goto L17;
        e r14 = (e) this.d;     // Catch: Throwable -> L15
        h r15 = (h) ((ArrayDeque) r14.f22372b).poll();     // Catch: Throwable -> L15
        if (r15 != null) goto L8;
        r15 = r14.F();     // Catch: Throwable -> L15
    L8:
        d r16 = (d) r15;     // Catch: Throwable -> L15
        r16.f1451b = r12;     // Catch: Throwable -> L15
        r16.f1452c = r5;     // Catch: Throwable -> L15
        ((s6.c) this.f1456c).A(r16, r10);     // Catch: Throwable -> L15
        NavigableMap r17 = f(r5);     // Catch: Throwable -> L15
        Integer r18 = (Integer) r17.get(Integer.valueOf(r16.f1451b));     // Catch: Throwable -> L15
        Integer r19 = Integer.valueOf(r16.f1451b);     // Catch: Throwable -> L15
        int r20 = 1;
        if (r18 == null) goto L12;
        r20 = 1 + r18.intValue();     // Catch: Throwable -> L15
    L12:
        r17.put(r19, Integer.valueOf(r20));     // Catch: Throwable -> L15
        this.f1455b += r13;     // Catch: Throwable -> L15
        b(this.f1454a);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L17:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public f(int r5) {
        this.f1456c = new s6.c(2);
        this.d = new e(0);
        this.e = new HashMap();
        this.f = new HashMap();
        this.f1454a = r5;
    }
}
