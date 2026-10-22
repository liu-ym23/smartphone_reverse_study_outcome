package com.ss.android.socialbase.downloader.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f8184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f8187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f8189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f8190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f8191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f8192l;

    public f() {
    }

    public f a() {
        f r10 = new f();
        r10.f8181a = this.f8181a;
        r10.f8182b = this.f8182b;
        r10.f8183c = this.f8183c;
        r10.f8184d = this.f8184d;
        r10.f8185e = this.f8185e;
        r10.f8186f = this.f8186f;
        r10.f8187g = this.f8187g;
        r10.f8188h = this.f8188h;
        r10.f8189i = this.f8189i;
        r10.f8190j = this.f8190j;
        r10.f8191k = this.f8191k;
        r10.f8192l = System.currentTimeMillis();
        return r10;
    }

    public JSONObject b() {
        JSONObject r10 = new JSONObject();
        long r11 = this.f8181a;     // Catch: Throwable -> L12
        long r12 = 0;
        if (r11 <= 0) goto L6;
        long r13 = this.f8182b - r11;     // Catch: Throwable -> L12
    L7:
        r10.put("build_download_info", r13);     // Catch: Throwable -> L12
        long r14 = this.f8182b;     // Catch: Throwable -> L12
        if (r14 <= 0) goto L10;
        r12 = this.f8183c - r14;     // Catch: Throwable -> L12
    L10:
        r10.put("try_download", r12);     // Catch: Throwable -> L12
        r10.put("do_download", this.f8184d - this.f8183c);     // Catch: Throwable -> L12
        r10.put("before_thread_execute", this.f8185e - this.f8184d);     // Catch: Throwable -> L12
        r10.put("thread_execute", this.f8186f - this.f8185e);     // Catch: Throwable -> L12
        r10.put("before_on_prepare", this.f8187g - this.f8186f);     // Catch: Throwable -> L12
        r10.put("after_on_prepare", this.f8188h - this.f8187g);     // Catch: Throwable -> L12
        r10.put("before_on_start", this.f8189i - this.f8188h);     // Catch: Throwable -> L12
        r10.put("after_on_start", this.f8190j - this.f8189i);     // Catch: Throwable -> L12
        r10.put("before_on_finish", this.f8191k - this.f8190j);     // Catch: Throwable -> L12
        r10.put("after_on_finish", this.f8192l - this.f8191k);     // Catch: Throwable -> L12
    L14:
        return r10;
    L6:
        r13 = 0;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }

    public JSONObject c() {
        JSONObject r10 = new JSONObject();
        r10.put("call_download", this.f8181a);     // Catch: Throwable -> L5
        r10.put("build_download_info", this.f8182b);     // Catch: Throwable -> L5
        r10.put("try_download", this.f8183c);     // Catch: Throwable -> L5
        r10.put("do_download", this.f8184d);     // Catch: Throwable -> L5
        r10.put("before_thread_execute", this.f8185e);     // Catch: Throwable -> L5
        r10.put("thread_execute", this.f8186f);     // Catch: Throwable -> L5
        r10.put("before_on_prepare", this.f8187g);     // Catch: Throwable -> L5
        r10.put("after_on_prepare", this.f8188h);     // Catch: Throwable -> L5
        r10.put("before_on_start", this.f8189i);     // Catch: Throwable -> L5
        r10.put("after_on_start", this.f8190j);     // Catch: Throwable -> L5
        r10.put("before_on_finish", this.f8191k);     // Catch: Throwable -> L5
        r10.put("after_on_finish", System.currentTimeMillis());     // Catch: Throwable -> L5
    L7:
        return r10;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void d() {
        this.f8181a = 0;
        this.f8182b = 0;
        this.f8183c = 0;
        this.f8184d = 0;
        this.f8185e = 0;
        this.f8186f = 0;
        this.f8187g = 0;
        this.f8188h = 0;
        this.f8189i = 0;
        this.f8190j = 0;
        this.f8191k = 0;
    }
}
