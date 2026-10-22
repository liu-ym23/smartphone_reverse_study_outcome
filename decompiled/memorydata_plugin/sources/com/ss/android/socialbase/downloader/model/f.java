package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.network.g f15574b;
    public final int c;
    private long d;
    private long e;

    public f(String r3, com.ss.android.socialbase.downloader.network.g r4) {
        com.ss.android.socialbase.downloader.network.g r5 = (com.ss.android.socialbase.downloader.network.g) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.socialbase.downloader.network.g.class, "com.obric.memorydata.plugin");
        this.f15573a = r3;
        this.c = r5.b();
        this.f15574b = r5;
    }

    public f(String r3, com.ss.android.socialbase.downloader.network.g r4, int r5) {
        com.ss.android.socialbase.downloader.network.g r6 = (com.ss.android.socialbase.downloader.network.g) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.socialbase.downloader.network.g.class, "com.obric.memorydata.plugin");
        this.f15573a = r3;
        this.c = r5;
        this.f15574b = r6;
    }

    public boolean a() {
        return com.ss.android.socialbase.downloader.utils.c.a(this.c);
    }

    public boolean b() {
        return com.ss.android.socialbase.downloader.utils.c.a(this.c, this.f15574b.a("Accept-Ranges"));
    }

    public String c() {
        return this.f15574b.a("Etag");
    }

    public String d() {
        return this.f15574b.a(NetConst.KEY_CONTENT_TYPE);
    }

    public String e() {
        return com.ss.android.socialbase.downloader.utils.g.a(this.f15574b, "Content-Range");
    }

    public String f() {
        String r0 = com.ss.android.socialbase.downloader.utils.g.a(this.f15574b, "last-modified");
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return com.ss.android.socialbase.downloader.utils.g.a(this.f15574b, "Last-Modified");
    }

    public String g() {
        return com.ss.android.socialbase.downloader.utils.g.a(this.f15574b, "Cache-Control");
    }

    public long h() {
        if (this.d > 0) goto L6;
        this.d = com.ss.android.socialbase.downloader.utils.g.a(this.f15574b);
    L6:
        return this.d;
    }

    public boolean i() {
        return com.ss.android.socialbase.downloader.utils.c.a(this.f15574b);
    }

    public long j() {
        String r2 = com.ss.android.socialbase.downloader.utils.g.a(this.f15574b, "X-Content-Length");
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L6:
        return -1;
    L9:
        return Long.parseLong(r2);
    }

    public long k() {
        if (this.e > 0) goto L12;
        if (i() == true) goto L9;
        String r0 = e();
        if (TextUtils.isEmpty(r0) == true) goto L12;
        long r1 = com.ss.android.socialbase.downloader.utils.c.a(r0);
    L10:
        this.e = r1;
        goto L12
    L9:
        r1 = -1;
    L12:
        return this.e;
    }

    public long l() {
        return com.ss.android.socialbase.downloader.utils.c.b(g());
    }

    public String m() {
        return com.ss.android.socialbase.downloader.utils.g.a(this.f15574b, NetConst.KEY_CONTENT_ENCODING);
    }
}
