package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nb.g f8194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8197e;

    public g(String r10, nb.g r11) {
        this.f8193a = r10;
        this.f8195c = r11.c();
        this.f8194b = r11;
    }

    public g(String r10, nb.g r11, int r12) {
        this.f8193a = r10;
        this.f8195c = r12;
        this.f8194b = r11;
    }

    public boolean a() {
        return com.ss.android.socialbase.downloader.utils.c.c(this.f8195c, this.f8194b.d("Accept-Ranges"));
    }

    public String b() {
        return com.ss.android.socialbase.downloader.utils.g.B(this.f8194b, "Cache-Control");
    }

    public String c() {
        return com.ss.android.socialbase.downloader.utils.g.B(this.f8194b, NetConst.KEY_CONTENT_ENCODING);
    }

    public long d() {
        if (this.f8196d > 0) goto L6;
        this.f8196d = com.ss.android.socialbase.downloader.utils.g.p(this.f8194b);
    L6:
        return this.f8196d;
    }

    public String e() {
        return com.ss.android.socialbase.downloader.utils.g.B(this.f8194b, "Content-Range");
    }

    public String f() {
        return this.f8194b.d(NetConst.KEY_CONTENT_TYPE);
    }

    public String g() {
        return this.f8194b.d("Etag");
    }

    public String h() {
        String r10 = com.ss.android.socialbase.downloader.utils.g.B(this.f8194b, "last-modified");
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        return com.ss.android.socialbase.downloader.utils.g.B(this.f8194b, "Last-Modified");
    }

    public long i() {
        return com.ss.android.socialbase.downloader.utils.c.X(b());
    }

    public long j() {
        if (this.f8197e > 0) goto L12;
        if (l() == true) goto L9;
        String r10 = e();
        if (TextUtils.isEmpty(r10) == true) goto L12;
        long r11 = com.ss.android.socialbase.downloader.utils.c.R(r10);
    L10:
        this.f8197e = r11;
        goto L12
    L9:
        r11 = -1;
    L12:
        return this.f8197e;
    }

    public long k() {
        String r10 = com.ss.android.socialbase.downloader.utils.g.B(this.f8194b, "X-Content-Length");
        if (TextUtils.isEmpty(r10) == false) goto L9;
    L6:
        return -1;
    L9:
        return Long.parseLong(r10);
    }

    public boolean l() {
        return com.ss.android.socialbase.downloader.utils.c.y(this.f8194b);
    }

    public boolean m() {
        return com.ss.android.socialbase.downloader.utils.c.K(this.f8195c);
    }
}
