package com.ss.android.socialbase.downloader.b.a.d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class a extends com.ss.android.socialbase.downloader.b.a.a implements f.a {
    private long g;
    private int h;
    private int i;
    private long j;
    private int k;
    private List<f> l;
    private e m;
    private d n;
    private b o;
    private i p;
    private com.ss.android.socialbase.downloader.network.h q;
    private g r;
    private Throwable s;

    public a() {
        this.l = new CopyOnWriteArrayList();
    }

    private void a(JSONObject r5) {
        this.g = r5.optLong("max_chunk_length");
        this.h = r5.optInt("thread_count");
        this.i = r5.optInt("chunk_retry_count");
        this.j = r5.optLong("pcdn_degrade_bandwidth_limit");
        int r6 = r5.optInt("pcdn_degrade_sample_count");
        this.k = r6;
        if (this.g > 0) goto L6;
        this.g = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
    L6:
        if (this.h > 0) goto L9;
        this.h = 3;
    L9:
        if (this.h <= 6) goto L12;
        this.h = 6;
    L12:
        if (this.i <= 20) goto L14;
        this.i = 20;
    L14:
        if (r6 >= 3) goto L17;
        this.k = 3;
        return;
    }

    private void d() {
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "checkTotalSize", "Run");
    L5:
        long r3 = this.c.getTotalBytes();
        if (r3 > 0) goto L8;
    L9:
        e();
        r3 = this.c.getTotalBytes();
    L11:
        if (r3 <= 0) goto L17;
        b(r3, this.c.getMaxBytes());
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "checkTotalSize", "TotalSize: " + r3);
        return;
    L18:
        return;
    L17:
        throw new BaseException(1090, "pcdn content-length empty");
    L8:
        if (this.f.j == false) goto L11;
        goto L9
    }

    private void e() {
        this.r = new g(this.c.getPcdnUrls(), this.c.getCdnUrls());
        h r4 = new h(this.i);
        String r5 = null;
    L4:
        if (j_() == true) goto L38;
        r5 = this.r.a();     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "getTotalSize", "Before Url:" + r5 + " isPcdn:" + this.r.c());     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
    L8:
        com.ss.android.socialbase.downloader.network.h r6 = a(r5, a(this.c.getStartOffset(), this.c.getEndOffset(), false), this.c.getStartOffset());     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        this.q = r6;     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        a(r5, 0, r6);     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
    L9:
        com.ss.android.socialbase.downloader.network.h r7 = this.q;
        if (r7 == null) goto L13;
        r7.d();
    L13:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L49;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "getTotalSize", "After Url:" + r5 + " isPcdn:" + this.r.c());
        return;
    L49:
        return;
    L29:
        e = move-exception;
        throw e;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        com.ss.android.socialbase.downloader.network.h r8 = this.q;
        if (r8 == null) goto L35;
        r8.d();
    L35:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L37;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "getTotalSize", "After Url:" + r5 + " isPcdn:" + this.r.c());
    L37:
        throw th;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        if (r4.a(true) == false) goto L28;
        this.r.d();     // Catch: Throwable -> L16
        com.ss.android.socialbase.downloader.network.h r9 = this.q;
        if (r9 == null) goto L26;
        r9.d();
    L26:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L4;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "getTotalSize", "After Url:" + r5 + " isPcdn:" + this.r.c());
        goto L4
    L28:
        throw e;     // Catch: Throwable -> L16
    }

    private void f() {
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, CommonConsts.APM_INNER_EVENT_COST_INIT, "Run");
    L5:
        this.m = new e(this, this.f.f15271a, this.f.c);
        this.n = new d(this.f.c, this.g);
        this.o = new b(this.f.c.getId(), this.j, this.k);
        if (this.p != null) goto L8;
        this.p = new i(this.c, this.i);
    L8:
        this.l.clear();
        this.s = null;
    }

    private void g() {
        long r0 = com.ss.android.socialbase.downloader.utils.c.a(this.c) + this.c.getStartOffset();
        int r2 = (int) Math.ceil(((this.c.getTotalBytes() - r0) * 1.0d) / this.g);
        int r3 = this.h;
        if (r2 >= r3) goto L6;
        r3 = r2;
    L6:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "doDownload", "StartOffset:" + r0 + " chunkCount:" + r2 + " threadCount:" + r3);
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r3) goto L11;
        f r4 = new f(this.m, this.n, this.o, this.p, this.r, this.i, this);
        r4.a(this.f);
        r4.a(com.ss.android.socialbase.downloader.downloader.b.o().submit(r4));
        this.l.add(r4);
        r1 = r1 + 1;
        goto L9
    L11:
        Iterator<f> r5 = this.l.iterator();
    L13:
        if (r5.hasNext() == false) goto L20;
        ((f) ZeusTransformUtils.preCheckCast(r5.next(), f.class, "com.obric.memorydata.plugin")).d().get();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L13
    L20:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L22;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "doDownload", "ChunkRunnable End");
    L22:
        this.o.b();
        this.p.a();
        if (j_() == false) goto L25;
        return;
    L25:
        Throwable r6 = this.s;
        if (r6 != null) goto L28;
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r6, BaseException.class) == false) goto L32;
        throw ((BaseException) ZeusTransformUtils.preCheckCast(this.s, BaseException.class, "com.obric.memorydata.plugin"));
    L32:
        throw new BaseException(1000, this.s);
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public com.ss.android.socialbase.downloader.b.e a(com.ss.android.socialbase.downloader.b.a.i r3) {
        JSONObject r0 = r3.d.e("pcdn_config");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r3.c.getPcdnUrls() == null) goto L9;
        if (r3.c.getPcdnUrls().isEmpty() == true) goto L9;
    L13:
        a(r0);
        return super.a(r3);
    L9:
        if (r3.c.getCdnUrls() != null) goto L11;
        return null;
    L11:
        if (r3.c.getCdnUrls().isEmpty() == false) goto L13;
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void a() {
        a(this.q);
        Iterator<f> r3 = this.l.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.memorydata.plugin")).a();
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.b.a.a, com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r5) {
        com.ss.android.socialbase.downloader.b.f r6 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadPCDNSegmentModule", this.c, "proceed", "Run");
    L6:
        if (a(r6, true) == false) goto L22;
        return;
    L22:
        d();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        if (j_() == false) goto L11;
        return;
    L11:
        f();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        g();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        r6.a();
        return;
    L20:
        e = move-exception;
        throw e;
    L17:
        e = move-exception;
        throw new DownloadPCDNException(e.getErrorCode(), e.getErrorMessage());
    L14:
        th = move-exception;
        throw new DownloadPCDNException(1000, th.getMessage());
    }

    @Override // com.ss.android.socialbase.downloader.b.a.d.f.a
    public void a(Throwable r1) {
        this.s = r1;
        b();
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void b() {
        a(this.q);
        Iterator<f> r3 = this.l.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.memorydata.plugin")).b();
        goto L4
    }
}
