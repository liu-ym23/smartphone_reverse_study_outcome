package db;

import android.text.TextUtils;
import bb.d;
import bb.e;
import bb.f;
import com.bytedance.apm6.util.constant.NetConst;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.impls.b;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.g;
import com.ss.android.socialbase.downloader.utils.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jb.i;
import nb.h;
import qb.k;
import qb.l;

/* JADX INFO: loaded from: classes2.dex */
public class a extends cb.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private h f8523l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private d f8524m;

    public a() {
    }

    private void A() {
        String r10 = this.f544h.getConnectionUrl();
        h r11 = C(r10, y());
        this.f8523l = r11;
        B(r10, r11);
        if (m() == false) goto L5;
        return;
    L5:
        d r12 = new d(this.f547k, this.f8523l, 0, this.f544h.getTotalBytes(), this);
        this.f8524m = r12;
        r12.i();
    }

    private boolean z() {
        if (new kb.a(this.f544h.getSavePath(), this.f544h.getName()).h() == false) goto L6;
        cb.h r10 = this.f547k;
        r10.f681f = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        r10.f678c.setCacheExistsInDownloading(true);
        return true;
    L6:
        return false;
    }

    public void B(String r10, h r11) {
        g r12 = new g(r10, r11);     // Catch: Throwable -> L26
        String r13 = r12.f();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(this.f544h.getMimeType()) == true) goto L6;
    L8:
        this.f544h.setContentEncoding(r12.c());     // Catch: Throwable -> L26
        if (NetConst.GZIP.equalsIgnoreCase(this.f544h.getContentEncoding()) == false) goto L12;
        this.f544h.setIgnoreDataVerify(true);     // Catch: Throwable -> L26
    L12:
        if (r12.l() == true) goto L17;
        String r14 = r12.e();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r14) == true) goto L16;
        long r15 = c.R(r14);     // Catch: Throwable -> L26
    L19:
        if (lb.a.a() == false) goto L22;
        lb.a.g("DownloadFastModule", this.f544h.getId(), "handleResponseHeader", "totalLength:" + r15);     // Catch: Throwable -> L26
    L22:
        if (m() == false) goto L24;
        return;
    L24:
        this.f544h.setCurBytes(0);     // Catch: Throwable -> L26
        this.f546j.m(r15, null, this.f544h.getName());     // Catch: Throwable -> L26
        return;
    L16:
        r15 = r12.d();     // Catch: Throwable -> L26
        goto L19
    L17:
        r15 = -1;
        this.f544h.setXTotalBytes(r12.k());     // Catch: Throwable -> L26
        goto L19
    L6:
        if (TextUtils.isEmpty(r13) == true) goto L8;
        this.f544h.setMimeType(r13);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        c.T(th, "handleResponseHeader");
    }

    public h C(String r12, List<HttpHeader> r13) {
        DownloadTTNetException r10 = null;
        h r14 = com.ss.android.socialbase.downloader.downloader.a.f(this.f544h.isNeedDefaultHttpServiceBackUp(), this.f544h.getMaxBytes(), r12, null, r13, this.f545i.n("net_lib_strategy"), false, this.f544h);     // Catch: Throwable -> L10
        if (r14 == null) goto L9;
        int r15 = r14.c();     // Catch: Throwable -> L6
        Throwable r11 = null;
    L13:
        if (r15 <= 0) goto L17;
        if (r15 >= 200) goto L17;
    L18:
        if (r11 != null) goto L32;
    L22:
        if (r10 != null) goto L24;
        r10 = new DownloadTTNetException(r15 + 2000, "Status Error");     // Catch: Throwable -> L20
    L24:
        p("Http Status Error: " + r15, r10);     // Catch: Throwable -> L20
    L25:
        if (r11 == null) goto L31;
        c.T(r11, "DoConnect");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r14 == null) goto L30;
        r14.a();
    L30:
        throw th;
    L31:
        return r14;
    L32:
        r10 = c.t(r11, "sendRequest");     // Catch: Throwable -> L20
    L17:
        if (r15 < 300) goto L25;
    L9:
        throw new BaseException(1022, new IOException("Connection is null"));     // Catch: Throwable -> L6
    L6:
        th = th;
    L12:
        r11 = th;
        r15 = ((l) k.a(l.class)).a().b(th);
    L10:
        th = th;
        r14 = null;
        goto L12
    }

    @Override // bb.a, bb.e
    public void cancel() {
        d r10 = this.f8524m;
        if (r10 == null) goto L5;
        r10.d();
        return;
    L5:
        o(this.f8523l);
    }

    @Override // bb.a, bb.e
    public e e(cb.h r10) {
        if (r10.f678c.isFastDownload() == true) goto L6;
        return null;
    L6:
        i r11 = r10.f676a;
        if ((r11 instanceof b) == false) goto L10;
        r10.f676a = ((b) r11).q();
    L10:
        return super.e(r10);
    }

    @Override // bb.a, bb.e
    public void f() {
        d r10 = this.f8524m;
        if (r10 == null) goto L5;
        r10.k();
        return;
    L5:
        o(this.f8523l);
    }

    @Override // cb.a, bb.e
    public void k(f r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("DownloadFastModule", this.f544h.getId(), "proceed", "Run");
    L6:
        if (r(r10, true) == false) goto L8;
        return;
    L8:
        if (m() == false) goto L10;
        return;
    L10:
        if (z() == true) goto L22;
        A();     // Catch: Throwable -> L15
        o(this.f8523l);
        r10.b();
        return;
    L15:
        th = move-exception;
        o(this.f8523l);
        throw th;
    }

    public List<HttpHeader> y() {
        List<HttpHeader> r10 = this.f544h.getExtraHeaders();
        ArrayList r11 = new ArrayList();
        String r12 = NetConst.GZIP;
        if (r10 == null) goto L16;
        Iterator<HttpHeader> r13 = r10.iterator();
        boolean r14 = false;
    L6:
        if (r13.hasNext() == false) goto L18;
        HttpHeader r15 = r13.next();
        if (r15 == null) goto L6;
        if (NetConst.KEY_ACCEPT_ENCODING.equalsIgnoreCase(r15.getName()) == false) goto L15;
        if (NetConst.GZIP.equalsIgnoreCase(r15.getValue()) == false) goto L15;
        r14 = true;
    L15:
        r11.add(r15);
    L18:
        if (r14 == true) goto L21;
        r12 = "identity";
    L21:
        r11.add(new HttpHeader(NetConst.KEY_ACCEPT_ENCODING, r12));
        int r16 = this.f545i.o("ttnet_proto_type", 0);
        if (r16 <= 0) goto L24;
        r11.add(new HttpHeader("x-ttnet-http-proto-type", String.valueOf(r16)));
    L24:
        return r11;
    L16:
        r14 = false;
        goto L18
    }
}
