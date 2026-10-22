package com.ss.android.socialbase.downloader.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTimingInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15904c;
    public long d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f15905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f15906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f15907j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f15908k;

    public DownloadTimingInfo() {
    }

    public final JSONObject a() {
        JSONObject r5 = new JSONObject();
        long r10 = this.f15902a;     // Catch: Throwable -> L6
        if (r10 <= 0) goto L8;
        long r11 = this.f15903b - r10;     // Catch: Throwable -> L6
    L9:
        r5.put("build_download_info", r11);     // Catch: Throwable -> L6
        long r12 = this.f15903b;     // Catch: Throwable -> L6
        if (r12 <= 0) goto L12;
        long r13 = this.f15904c - r12;     // Catch: Throwable -> L6
    L13:
        r5.put("try_download", r13);     // Catch: Throwable -> L6
        r5.put("do_download", this.d - this.f15904c);     // Catch: Throwable -> L6
        r5.put("before_thread_execute", this.e - this.d);     // Catch: Throwable -> L6
        r5.put("thread_execute", this.f - this.e);     // Catch: Throwable -> L6
        r5.put("before_on_prepare", this.g - this.f);     // Catch: Throwable -> L6
        r5.put("after_on_prepare", this.f15905h - this.g);     // Catch: Throwable -> L6
        r5.put("before_on_start", this.f15906i - this.f15905h);     // Catch: Throwable -> L6
        r5.put("after_on_start", this.f15907j - this.f15906i);     // Catch: Throwable -> L6
        r5.put("before_on_finish", this.f15908k - this.f15907j);     // Catch: Throwable -> L6
        r5.put("after_on_finish", 0 - this.f15908k);     // Catch: Throwable -> L6
        return r5;
    L12:
        r13 = 0;
        goto L13
    L8:
        r11 = 0;
    L6:
        th = move-exception;
        th.printStackTrace();
        return r5;
    }

    public final JSONObject b() {
        JSONObject r5 = new JSONObject();
        r5.put("call_download", this.f15902a);     // Catch: Throwable -> L5
        r5.put("build_download_info", this.f15903b);     // Catch: Throwable -> L5
        r5.put("try_download", this.f15904c);     // Catch: Throwable -> L5
        r5.put("do_download", this.d);     // Catch: Throwable -> L5
        r5.put("before_thread_execute", this.e);     // Catch: Throwable -> L5
        r5.put("thread_execute", this.f);     // Catch: Throwable -> L5
        r5.put("before_on_prepare", this.g);     // Catch: Throwable -> L5
        r5.put("after_on_prepare", this.f15905h);     // Catch: Throwable -> L5
        r5.put("before_on_start", this.f15906i);     // Catch: Throwable -> L5
        r5.put("after_on_start", this.f15907j);     // Catch: Throwable -> L5
        r5.put("before_on_finish", this.f15908k);     // Catch: Throwable -> L5
        r5.put("after_on_finish", System.currentTimeMillis());     // Catch: Throwable -> L5
        return r5;
    L5:
        th = move-exception;
        th.printStackTrace();
        return r5;
    }
}
