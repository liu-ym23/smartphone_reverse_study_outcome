package com.ss.android.socialbase.downloader.b.a.a;

import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.ss.android.socialbase.downloader.b.a.i;
import com.ss.android.socialbase.downloader.b.d;
import com.ss.android.socialbase.downloader.b.e;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.impls.b;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.h;
import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.l;
import com.ss.android.socialbase.downloader.utils.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class a extends com.ss.android.socialbase.downloader.b.a.a {
    private h g;
    private d h;

    public a() {
    }

    private boolean e() {
        if (new com.ss.android.socialbase.downloader.d.a(this.c.getSavePath(), this.c.getName()).b() == false) goto L6;
        i r0 = this.f;
        r0.f = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        this.f.c.setCacheExistsInDownloading(true);
        return true;
    L6:
        return false;
    }

    private void f() {
        String r0 = this.c.getConnectionUrl();
        h r1 = a(r0, d());
        this.g = r1;
        a(r0, r1);
        if (j_() == false) goto L5;
        return;
    L5:
        d r2 = new d(this.f, this.g, 0, this.c.getTotalBytes(), this);
        this.h = r2;
        r2.a();
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public e a(i r4) {
        if (r4.c.isFastDownload() == true) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r4.f15271a, b.class) == false) goto L10;
        r4.f15271a = ((b) ZeusTransformUtils.preCheckCast(r4.f15271a, b.class, "com.obric.memorydata.plugin")).e();
    L10:
        return super.a(r4);
    }

    public h a(String r12, List<HttpHeader> r13) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        DownloadTTNetException r14 = null;
        h r15 = com.ss.android.socialbase.downloader.downloader.b.a(this.c.isNeedDefaultHttpServiceBackUp(), this.c.getMaxBytes(), r12, null, r6, this.d.b("net_lib_strategy"), false, this.c);     // Catch: Throwable -> L10
        if (r15 == null) goto L9;
        int r0 = r15.b();     // Catch: Throwable -> L6
        Throwable r1 = null;
    L13:
        if (r0 <= 0) goto L17;
        if (r0 >= 200) goto L17;
    L18:
        if (r1 != null) goto L32;
    L22:
        if (r14 != null) goto L24;
        r14 = new DownloadTTNetException(r0 + 2000, "Status Error");     // Catch: Throwable -> L20
    L24:
        a("Http Status Error: " + r0, r14);     // Catch: Throwable -> L20
    L25:
        if (r1 == null) goto L31;
        c.a(r1, "DoConnect");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r15 == null) goto L30;
        r15.d();
    L30:
        throw th;
    L31:
        return r15;
    L32:
        r14 = c.b(r1, "sendRequest");     // Catch: Throwable -> L20
    L17:
        if (r0 < 300) goto L25;
    L9:
        throw new BaseException(1022, new IOException("Connection is null"));     // Catch: Throwable -> L6
    L6:
        th = th;
    L12:
        r1 = th;
        r0 = ((l) ZeusTransformUtils.preCheckCast(k.a(l.class), l.class, "com.obric.memorydata.plugin")).h().a(th);
    L10:
        th = th;
        r15 = null;
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void a() {
        d r0 = this.h;
        if (r0 == null) goto L5;
        r0.b();
        return;
    L5:
        a(this.g);
    }

    @Override // com.ss.android.socialbase.downloader.b.a.a, com.ss.android.socialbase.downloader.b.e
    public void a(f r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadFastModule", this.c, "proceed", "Run");
    L6:
        if (a(r6, true) == false) goto L8;
        return;
    L8:
        if (j_() == false) goto L10;
        return;
    L10:
        if (e() == true) goto L22;
        f();     // Catch: Throwable -> L15
        a(this.g);
        r6.a();
        return;
    L15:
        th = move-exception;
        a(this.g);
        throw th;
    }

    public void a(String r6, h r7) {
        com.ss.android.socialbase.downloader.model.f r1 = new com.ss.android.socialbase.downloader.model.f(r6, (h) ZeusTransformUtils.wrapperContextForParams(r7, h.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L26
        String r8 = r1.d();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(this.c.getMimeType()) == true) goto L6;
    L8:
        this.c.setContentEncoding(r1.m());     // Catch: Throwable -> L26
        if (NetConst.GZIP.equalsIgnoreCase(this.c.getContentEncoding()) == false) goto L12;
        this.c.setIgnoreDataVerify(true);     // Catch: Throwable -> L26
    L12:
        if (r1.i() == true) goto L17;
        String r9 = r1.e();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r9) == true) goto L16;
        long r10 = c.a(r9);     // Catch: Throwable -> L26
    L19:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L22;
        com.ss.android.socialbase.downloader.e.a.a("DownloadFastModule", this.c, "handleResponseHeader", "totalLength:" + r10);     // Catch: Throwable -> L26
    L22:
        if (j_() == false) goto L24;
        return;
    L24:
        this.c.setCurBytes(0);     // Catch: Throwable -> L26
        this.e.a(r10, null, this.c.getName());     // Catch: Throwable -> L26
        return;
    L16:
        r10 = r1.h();     // Catch: Throwable -> L26
        goto L19
    L17:
        r10 = -1;
        this.c.setXTotalBytes(r1.j());     // Catch: Throwable -> L26
        goto L19
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L8;
        this.c.setMimeType(r8);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        c.a(th, "handleResponseHeader");
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void b() {
        d r0 = this.h;
        if (r0 == null) goto L5;
        r0.c();
        return;
    L5:
        a(this.g);
    }

    public List<HttpHeader> d() {
        List<HttpHeader> r0 = this.c.getExtraHeaders();
        ArrayList r1 = new ArrayList();
        String r2 = NetConst.GZIP;
        if (r0 == null) goto L16;
        Iterator<HttpHeader> r3 = r0.iterator();
        boolean r5 = false;
    L6:
        if (r3.hasNext() == false) goto L18;
        HttpHeader r6 = (HttpHeader) ZeusTransformUtils.preCheckCast(r3.next(), HttpHeader.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L6;
        if (NetConst.KEY_ACCEPT_ENCODING.equalsIgnoreCase(r6.getName()) == false) goto L15;
        if (NetConst.GZIP.equalsIgnoreCase(r6.getValue()) == false) goto L15;
        r5 = true;
    L15:
        r1.add(r6);
    L18:
        if (r5 == true) goto L21;
        r2 = "identity";
    L21:
        r1.add(new HttpHeader(NetConst.KEY_ACCEPT_ENCODING, r2));
        int r9 = this.d.a("ttnet_proto_type", 0);
        if (r9 <= 0) goto L24;
        r1.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(r9)));
    L24:
        return r1;
    L16:
        r5 = false;
        goto L18
    }
}
