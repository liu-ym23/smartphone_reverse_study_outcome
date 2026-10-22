package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f8307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f8308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f8309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f8310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<l> f8311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicLong f8316j;

    public o(String r10, String r11) {
        this.f8311e = new ArrayList();
        this.f8316j = new AtomicLong();
        this.f8307a = r10;
        this.f8310d = false;
        this.f8308b = r11;
        this.f8309c = b(r11);
    }

    public o(String r10, boolean r11) {
        this.f8311e = new ArrayList();
        this.f8316j = new AtomicLong();
        this.f8307a = r10;
        this.f8310d = r11;
        this.f8308b = null;
        this.f8309c = null;
    }

    private String b(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L16;
        int r11 = r10.lastIndexOf(".");     // Catch: Throwable -> L10
        if (r11 > 0) goto L7;
        return null;
    L7:
        if (r11 >= r10.length()) goto L18;
        return r10.substring(0, r11);
    L18:
        return null;
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    L16:
        return null;
    }

    private String c() {
        if (this.f8315i != null) goto L9;
        StringBuilder r10 = new StringBuilder();
        r10.append(this.f8307a);
        r10.append("_");
        String r11 = this.f8308b;
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r10.append(r11);
        r10.append("_");
        r10.append(this.f8310d);
        this.f8315i = r10.toString();
    L9:
        return this.f8315i;
    }

    public synchronized int a() {
        monitor-enter(this);
        int r10 = this.f8311e.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void d(long r10) {
        this.f8316j.addAndGet(r10);
    }

    public synchronized boolean e() {
        monitor-enter(this);
        boolean r10 = this.f8313g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L10;
        return false;
    L10:
        return c().equals(((o) r10).c());
    }

    public synchronized void f() {
        monitor-enter(this);
        this.f8312f++;     // Catch: Throwable -> L6
        this.f8313g = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void g() {
        monitor-enter(this);
        this.f8313g = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void h(l r10) {
        monitor-enter(this);
        this.f8311e.remove(r10);     // Catch: Throwable -> L6
    L4:
        monitor-exit(this);
    }

    public int hashCode() {
        if (this.f8314h != 0) goto L6;
        this.f8314h = c().hashCode();
    L6:
        return this.f8314h;
    }

    public synchronized void i(l r10) {
        monitor-enter(this);
        this.f8311e.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f8307a + "', ip='" + this.f8308b + "', ipFamily='" + this.f8309c + "', isMainUrl=" + this.f8310d + ", failedTimes=" + this.f8312f + ", isCurrentFailed=" + this.f8313g + '}';
    }
}
