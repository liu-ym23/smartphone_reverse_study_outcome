package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
class UrlRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16090c;
    public final boolean d;
    public final ArrayList e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f16092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f16093j;

    public UrlRecord(String r5, boolean r10) {
        this.e = new ArrayList();
        this.f16093j = new AtomicLong();
        this.f16088a = r5;
        this.d = r10;
        this.f16089b = null;
        this.f16090c = null;
    }

    public final synchronized void a(SegmentReader r5) {
        monitor-enter(this);
        this.e.remove(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    }

    public final String b() {
        if (this.f16092i != null) goto L9;
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f16088a);
        r5.append("_");
        String r10 = this.f16089b;
        if (r10 != null) goto L7;
        r10 = "";
    L7:
        r5.append(r10);
        r5.append("_");
        r5.append(this.d);
        this.f16092i = r5.toString();
    L9:
        return this.f16092i;
    }

    public final synchronized void c() {
        monitor-enter(this);
        this.g = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlRecord) == true) goto L10;
        return false;
    L10:
        return b().equals(((UrlRecord) r5).b());
    }

    public final int hashCode() {
        if (this.f16091h != 0) goto L6;
        this.f16091h = b().hashCode();
    L6:
        return this.f16091h;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("UrlRecord{url='");
        r5.append(this.f16088a);
        r5.append("', ip='");
        r5.append(this.f16089b);
        r5.append("', ipFamily='");
        r5.append(this.f16090c);
        r5.append("', isMainUrl=");
        r5.append(this.d);
        r5.append(", failedTimes=");
        r5.append(this.f);
        r5.append(", isCurrentFailed=");
        return a.w(r5, this.g, '}');
    }

    public final synchronized int a() {
        monitor-enter(this);
        int r5 = this.e.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public UrlRecord(String r5, String r10) {
        this.e = new ArrayList();
        this.f16093j = new AtomicLong();
        this.f16088a = r5;
        this.d = false;
        this.f16089b = r10;
        if (TextUtils.isEmpty(r10) == false) goto L15;
    L12:
        String r11 = null;
    L13:
        this.f16090c = r11;
        return;
    L15:
        int r12 = r10.lastIndexOf(".");     // Catch: Throwable -> L10
        if (r12 <= 0) goto L12;
        if (r12 >= r10.length()) goto L12;
        r11 = r10.substring(0, r12);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }
}
