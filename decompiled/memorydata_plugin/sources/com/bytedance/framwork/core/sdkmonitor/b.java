package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<h> f2640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<c> f2641b;
    private final LinkedList<a> c;
    private int d;
    private boolean e;

    public b() {
        this.f2640a = new LinkedList();
        this.f2641b = new LinkedList();
        this.c = new LinkedList();
        this.d = 200;
    }

    static /* synthetic */ LinkedList a(b r0) {
        return r0.f2640a;
    }

    private void a(SDKMonitor r11, a r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r12.f2638a) == false) goto L7;
        return;
    L7:
        if (r12.f2638a.equals("api_error") == false) goto L10;
        r11.monitorApiError(r12.f2639b, r12.c, r12.d, r12.e, r12.f, r12.g, r12.h);
        return;
    L10:
        if (r12.f2638a.equals("api_all") == false) goto L15;
        r11.monitorSLA(r12.f2639b, r12.c, r12.d, r12.e, r12.f, r12.g, r12.h);
        return;
    }

    private void a(SDKMonitor r4, c r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r4.monitorCommonLogInternal(r5.f2644a, r5.f2645b, r5.c);
    }

    private void a(SDKMonitor r10, h r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.f2651a) == true) goto L9;
        r10.monitorService(r11.f2651a, r11.f2652b, r11.c, r11.d, r11.e, r11.f, r11.g);
        return;
    }

    static /* synthetic */ void a(b r0, SDKMonitor r1, a r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(b r0, SDKMonitor r1, c r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(b r0, SDKMonitor r1, h r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ LinkedList b(b r0) {
        return r0.f2641b;
    }

    static /* synthetic */ LinkedList c(b r0) {
        return r0.c;
    }

    public void a(final SDKMonitor r3) {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        com.bytedance.framwork.core.sdklib.a.a.a().a(new AnonymousClass1(this, r3));
    }

    public void a(a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<a> r0 = this.c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.c.size() <= this.d) goto L9;
        this.c.poll();     // Catch: Throwable -> L12
    L9:
        this.c.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void a(c r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<c> r0 = this.f2641b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f2641b.size() <= this.d) goto L9;
        this.f2641b.poll();     // Catch: Throwable -> L12
    L9:
        this.f2641b.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void a(h r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<h> r0 = this.f2640a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f2640a.size() <= this.d) goto L9;
        this.f2640a.poll();     // Catch: Throwable -> L12
    L9:
        this.f2640a.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }
}
