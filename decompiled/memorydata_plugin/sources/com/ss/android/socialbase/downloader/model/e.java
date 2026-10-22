package com.ss.android.socialbase.downloader.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15572b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    public e() {
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        long r2 = this.f15571a;     // Catch: Throwable -> L12
        long r4 = 0;
        if (r2 <= 0) goto L6;
        long r6 = this.f15572b - r2;     // Catch: Throwable -> L12
    L7:
        r0.put("build_download_info", r6);     // Catch: Throwable -> L12
        long r3 = this.f15572b;     // Catch: Throwable -> L12
        if (r3 <= 0) goto L10;
        r4 = this.c - r3;     // Catch: Throwable -> L12
    L10:
        r0.put("try_download", r4);     // Catch: Throwable -> L12
        r0.put("do_download", this.d - this.c);     // Catch: Throwable -> L12
        r0.put("before_thread_execute", this.e - this.d);     // Catch: Throwable -> L12
        r0.put("thread_execute", this.f - this.e);     // Catch: Throwable -> L12
        r0.put("before_on_prepare", this.g - this.f);     // Catch: Throwable -> L12
        r0.put("after_on_prepare", this.h - this.g);     // Catch: Throwable -> L12
        r0.put("before_on_start", this.i - this.h);     // Catch: Throwable -> L12
        r0.put("after_on_start", this.j - this.i);     // Catch: Throwable -> L12
        r0.put("before_on_finish", this.k - this.j);     // Catch: Throwable -> L12
        r0.put("after_on_finish", this.l - this.k);     // Catch: Throwable -> L12
    L14:
        return r0;
    L6:
        r6 = 0;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    public JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("call_download", this.f15571a);     // Catch: Throwable -> L5
        r0.put("build_download_info", this.f15572b);     // Catch: Throwable -> L5
        r0.put("try_download", this.c);     // Catch: Throwable -> L5
        r0.put("do_download", this.d);     // Catch: Throwable -> L5
        r0.put("before_thread_execute", this.e);     // Catch: Throwable -> L5
        r0.put("thread_execute", this.f);     // Catch: Throwable -> L5
        r0.put("before_on_prepare", this.g);     // Catch: Throwable -> L5
        r0.put("after_on_prepare", this.h);     // Catch: Throwable -> L5
        r0.put("before_on_start", this.i);     // Catch: Throwable -> L5
        r0.put("after_on_start", this.j);     // Catch: Throwable -> L5
        r0.put("before_on_finish", this.k);     // Catch: Throwable -> L5
        r0.put("after_on_finish", System.currentTimeMillis());     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public e c() {
        e r0 = new e();
        r0.f15571a = this.f15571a;
        r0.f15572b = this.f15572b;
        r0.c = this.c;
        r0.d = this.d;
        r0.e = this.e;
        r0.f = this.f;
        r0.g = this.g;
        r0.h = this.h;
        r0.i = this.i;
        r0.j = this.j;
        r0.k = this.k;
        r0.l = System.currentTimeMillis();
        return r0;
    }

    public void d() {
        this.f15571a = 0;
        this.f15572b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }
}
