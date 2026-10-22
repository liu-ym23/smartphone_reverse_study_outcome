package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f15633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f15634b;
    final String c;
    final boolean d;
    private final List<l> e;
    private int f;
    private boolean g;
    private int h;
    private String i;
    private final AtomicLong j;

    public o(String r2, String r3) {
        this.e = new ArrayList();
        this.j = new AtomicLong();
        this.f15633a = r2;
        this.d = false;
        this.f15634b = r3;
        this.c = a(r3);
    }

    public o(String r2, boolean r3) {
        this.e = new ArrayList();
        this.j = new AtomicLong();
        this.f15633a = r2;
        this.d = r3;
        this.f15634b = null;
        this.c = null;
    }

    private String a(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L16;
        int r1 = r2.lastIndexOf(".");     // Catch: Throwable -> L10
        if (r1 > 0) goto L7;
        return null;
    L7:
        if (r1 >= r2.length()) goto L18;
        return r2.substring(0, r1);
    L18:
        return null;
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    L16:
        return null;
    }

    private String e() {
        if (this.i != null) goto L9;
        StringBuilder r0 = new StringBuilder().append(this.f15633a).append("_");
        String r2 = this.f15634b;
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        this.i = r0.append(r2).append("_").append(this.d).toString();
    L9:
        return this.i;
    }

    public synchronized int a() {
        monitor-enter(this);
        int r0 = this.e.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(long r1) {
        this.j.addAndGet(r1);
    }

    public synchronized void a(l r2) {
        monitor-enter(this);
        this.e.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void b() {
        monitor-enter(this);
        this.f++;     // Catch: Throwable -> L6
        this.g = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void b(l r2) {
        monitor-enter(this);
        this.e.remove(r2);     // Catch: Throwable -> L6
    L4:
        monitor-exit(this);
    }

    public synchronized void c() {
        monitor-enter(this);
        this.g = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean d() {
        monitor-enter(this);
        boolean r0 = this.g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, o.class) == true) goto L11;
        return false;
    L11:
        return e().equals(((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.memorydata.plugin")).e());
    }

    public int hashCode() {
        if (this.h != 0) goto L6;
        this.h = e().hashCode();
    L6:
        return this.h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f15633a + "', ip='" + this.f15634b + "', ipFamily='" + this.c + "', isMainUrl=" + this.d + ", failedTimes=" + this.f + ", isCurrentFailed=" + this.g + '}';
    }
}
