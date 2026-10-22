package com.ss.android.socialbase.downloader.b.a.c;

import com.ss.android.socialbase.downloader.b.d;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.constants.b;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.h;
import com.ss.android.socialbase.downloader.utils.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class a extends com.ss.android.socialbase.downloader.b.a.a {
    private h g;
    private d h;

    public a() {
    }

    private void d() {
        String r0 = this.c.getConnectionUrl();
        long r1 = c.a(this.c);
        int r3 = this.d.b("verify_response_pre_file_length");
        if (r3 > 0) goto L5;
    L9:
        long r4 = this.c.getStartOffset() + r1;
        List<HttpHeader> r5 = a(r4, this.c.getEndOffset(), true);
        this.f.n.a(r5);
        this.c.setHttpRequestHeader(r5.toString());
        this.g = a(r0, r5, r4);
        if (j_() == false) goto L12;
        return;
    L12:
        a(r0, r1, this.g);
        long r6 = this.c.getTotalBytes();
        b(r6, this.c.getMaxBytes());
        if (j_() == false) goto L15;
        return;
    L15:
        d r2 = new d(this.f, this.g, r4, r6 - r1, this);
        this.h = r2;
        r2.a();
        return;
    L5:
        if (r3 >= b.e) goto L9;
        long r7 = r3;
        if (r1 <= r7) goto L9;
        this.c.setVerifyCurBytes(r1);
        r1 = r1 - r7;
        this.c.setCurBytes(r1);
        goto L9
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

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public void a(long r4, int r6) {
        if (com.ss.android.socialbase.downloader.g.a.a(this.c.getId()).a("use_default_throttle_speed", 1) == 1) goto L14;
        h r7 = this.g;
        if (r7 != null) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, com.ss.android.socialbase.downloader.network.a.class) == false) goto L21;
        ((com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(this.g, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin")).a(r4);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L21:
        return;
    L14:
        d r3 = this.h;
        if (r3 == null) goto L23;
        r3.a(r4, r6);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.b.a.a, com.ss.android.socialbase.downloader.b.e
    public void a(f r5) {
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("DownloadSingleSegmentModule", this.c, "proceed", "Run");
    L6:
        if (a(r6, true) == false) goto L8;
        return;
    L8:
        if (j_() == true) goto L19;
        d();     // Catch: Throwable -> L13
        a(this.g);
        r6.a();
        return;
    L13:
        th = move-exception;
        a(this.g);
        throw th;
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
}
