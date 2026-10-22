package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<h> f1999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<c> f2000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedList<com.bytedance.framwork.core.sdkmonitor.a> f2001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2003e;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SDKMonitor f2004c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f2005g;

        a(b r10, SDKMonitor r11) {
            this.f2005g = r10;
            this.f2004c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r10 = b.a(this.f2005g);     // Catch: Throwable -> L37
            monitor-enter(r10);     // Catch: Throwable -> L37
            LinkedList r11 = new LinkedList(b.a(this.f2005g));     // Catch: Throwable -> L33
            b.a(this.f2005g).clear();     // Catch: Throwable -> L33
            monitor-exit(r10);     // Catch: Throwable -> L33
            Iterator r12 = r11.iterator();     // Catch: Throwable -> L37
        L8:
            if (r12.hasNext() == false) goto L10;
            h r13 = (h) r12.next();     // Catch: Throwable -> L37
            b.b(this.f2005g, this.f2004c, r13);     // Catch: Throwable -> L37
            goto L8
        L10:
            LinkedList r14 = b.c(this.f2005g);     // Catch: Throwable -> L37
            monitor-enter(r14);     // Catch: Throwable -> L37
            LinkedList r15 = new LinkedList(b.c(this.f2005g));     // Catch: Throwable -> L30
            b.c(this.f2005g).clear();     // Catch: Throwable -> L30
            monitor-exit(r14);     // Catch: Throwable -> L30
            Iterator r16 = r15.iterator();     // Catch: Throwable -> L37
        L16:
            if (r16.hasNext() == false) goto L18;
            c r17 = (c) r16.next();     // Catch: Throwable -> L37
            b.d(this.f2005g, this.f2004c, r17);     // Catch: Throwable -> L37
            goto L16
        L18:
            LinkedList r18 = b.e(this.f2005g);     // Catch: Throwable -> L37
            monitor-enter(r18);     // Catch: Throwable -> L37
            LinkedList r19 = new LinkedList(b.e(this.f2005g));     // Catch: Throwable -> L27
            b.e(this.f2005g).clear();     // Catch: Throwable -> L27
            monitor-exit(r18);     // Catch: Throwable -> L27
            Iterator r20 = r19.iterator();     // Catch: Throwable -> L37
        L24:
            if (r20.hasNext() == false) goto L48;
            com.bytedance.framwork.core.sdkmonitor.a r21 = (com.bytedance.framwork.core.sdkmonitor.a) r20.next();     // Catch: Throwable -> L37
            b.f(this.f2005g, this.f2004c, r21);     // Catch: Throwable -> L37
            goto L24
        L48:
            return;
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        }
    }

    public b() {
        this.f1999a = new LinkedList();
        this.f2000b = new LinkedList();
        this.f2001c = new LinkedList();
        this.f2002d = 200;
    }

    static /* synthetic */ LinkedList a(b r10) {
        return r10.f1999a;
    }

    static /* synthetic */ void b(b r10, SDKMonitor r11, h r12) {
        r10.j(r11, r12);
    }

    static /* synthetic */ LinkedList c(b r10) {
        return r10.f2000b;
    }

    static /* synthetic */ void d(b r10, SDKMonitor r11, c r12) {
        r10.i(r11, r12);
    }

    static /* synthetic */ LinkedList e(b r10) {
        return r10.f2001c;
    }

    static /* synthetic */ void f(b r10, SDKMonitor r11, com.bytedance.framwork.core.sdkmonitor.a r12) {
        r10.g(r11, r12);
    }

    private void g(SDKMonitor r11, com.bytedance.framwork.core.sdkmonitor.a r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r12.f1991a) == false) goto L7;
        return;
    L7:
        if (r12.f1991a.equals("api_error") == false) goto L10;
        r11.monitorApiError(r12.f1992b, r12.f1993c, r12.f1994d, r12.f1995e, r12.f1996f, r12.f1997g, r12.f1998h);
        return;
    L10:
        if (r12.f1991a.equals("api_all") == false) goto L15;
        r11.monitorSLA(r12.f1992b, r12.f1993c, r12.f1994d, r12.f1995e, r12.f1996f, r12.f1997g, r12.f1998h);
        return;
    }

    private void i(SDKMonitor r10, c r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        r10.monitorCommonLogInternal(r11.f2006a, r11.f2007b, r11.f2008c);
    }

    private void j(SDKMonitor r10, h r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.f2022a) == true) goto L9;
        r10.monitorService(r11.f2022a, r11.f2023b, r11.f2024c, r11.f2025d, r11.f2026e, r11.f2027f, r11.f2028g);
        return;
    }

    public void h(SDKMonitor r10) {
        if (this.f2003e == false) goto L5;
        return;
    L5:
        this.f2003e = true;
        k3.a.e().f(new a(this, r10));
    }

    public void k(com.bytedance.framwork.core.sdkmonitor.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        LinkedList<com.bytedance.framwork.core.sdkmonitor.a> r11 = this.f2001c;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f2001c.size() <= this.f2002d) goto L9;
        this.f2001c.poll();     // Catch: Throwable -> L12
    L9:
        this.f2001c.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
    }

    public void l(c r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        LinkedList<c> r11 = this.f2000b;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f2000b.size() <= this.f2002d) goto L9;
        this.f2000b.poll();     // Catch: Throwable -> L12
    L9:
        this.f2000b.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
    }

    public void m(h r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        LinkedList<h> r11 = this.f1999a;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f1999a.size() <= this.f2002d) goto L9;
        this.f1999a.poll();     // Catch: Throwable -> L12
    L9:
        this.f1999a.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
    }
}
