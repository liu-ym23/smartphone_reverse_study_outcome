package cb;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a extends bb.a implements sb.d {

    /* JADX INFO: renamed from: cb.a$a, reason: collision with other inner class name */
    class RunnableC0030a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ nb.h f675c;

        RunnableC0030a(a r10, nb.h r11) {
            this.f675c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            nb.h r10 = this.f675c;
            if (r10 != null) goto L10;
            return;
        L10:
            r10.a();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public a() {
    }

    private void s() {
        com.ss.android.socialbase.downloader.utils.g.i(this.f544h);
        this.f547k.f685j = false;
        this.f544h.resetDataForEtagEndure("");
        this.f542c.b(this.f544h);
    }

    private void w(nb.h r10, int r11) {
        if (r10 != null) goto L33;
        this.f544h.setHttpStatusCode(-1);
        this.f544h.setHttpStatusMessage("");
        return;
    L33:
        this.f544h.setHttpStatusCode(r11);     // Catch: Throwable -> L24
        this.f544h.setHttpStatusMessage(com.ss.android.socialbase.downloader.utils.d.a(r11));     // Catch: Throwable -> L24
        List<String> r12 = this.f544h.getAccessHttpHeaderKeys();     // Catch: Throwable -> L24
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isEmpty() == true) goto L45;
        HashMap r13 = new HashMap();     // Catch: Throwable -> L24
        Iterator<String> r14 = r12.iterator();     // Catch: Throwable -> L24
    L12:
        if (r14.hasNext() == false) goto L21;
        String r15 = r14.next();     // Catch: Throwable -> L24
        if (r15 == null) goto L12;
        String r16 = r10.d(r15);     // Catch: Throwable -> L24
        if (r16 == null) goto L12;
        r13.put(r15, r16);     // Catch: Throwable -> L24
        goto L12
    L21:
        if (r13.isEmpty() == true) goto L46;
        this.f544h.setHttpHeaders(r13);     // Catch: Throwable -> L24
        return;
    L46:
        return;
    L45:
        return;
    L24:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        this.f544h.setHttpStatusCode(-1);
        this.f544h.setHttpStatusMessage("");
        return;
    L28:
        th = move-exception;
        this.f544h.setHttpStatusCode(-1);
        this.f544h.setHttpStatusMessage("");
        throw th;
    }

    private void x(com.ss.android.socialbase.downloader.model.g r10) {
        if (TextUtils.isEmpty(r10.b()) == false) goto L6;
        return;
    L6:
        if (r10.i() <= 0) goto L9;
        this.f544h.setCacheExpiredTime(System.currentTimeMillis() + (r10.i() * 1000));
        return;
    }

    @Override // sb.d
    public void a(long r10, int r11) {
        if (r10 <= 0) goto L10;
        if (r11 > 0) goto L6;
        return;
    L6:
        if (r10 > r11) goto L9;
        return;
    L9:
        throw new BaseException(1088, "Current Bytes:" + r10 + "Limit bytes:" + r11);
    }

    @Override // sb.d
    public void d(String r10, nb.g r11, long r12) {
    }

    @Override // sb.d
    public void g(List<Pair<String, String>> r10) {
        this.f546j.s(r10);
    }

    @Override // sb.d
    public void i(byte[] r10, int r11) {
        this.f546j.r(r10, r11);
    }

    @Override // sb.d
    public boolean j(long r10) {
        return this.f546j.q(r10);
    }

    @Override // bb.e
    public void k(bb.f r10) {
    }

    @Override // sb.d
    public void l(String r10) {
        this.f546j.t(r10);
    }

    public List<HttpHeader> n(long r16, long r18, boolean r20) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("AbsDownloadNetworkModule", this.f544h.getId(), "buildRequestHeader", "CurrentOffset: endOffset:" + r18 + " handleBody:" + r20);
    L5:
        List<HttpHeader> r10 = this.f544h.getExtraHeaders();
        ArrayList r11 = new ArrayList();
        String r12 = NetConst.GZIP;
        boolean r13 = false;
        if (r10 != null) goto L8;
    L21:
        boolean r14 = false;
    L22:
        String r15 = this.f544h.geteTag();
        if (this.f547k.f685j == false) goto L31;
        if (TextUtils.isEmpty(r15) == true) goto L28;
        r11.add(new HttpHeader("If-None-Match", r15));
    L28:
        if (TextUtils.isEmpty(this.f544h.getLastModified()) == true) goto L33;
        r11.add(new HttpHeader("if-modified-since", this.f544h.getLastModified()));
        r11.add(new HttpHeader("download-tc21-1-15", "download-tc21-1-15"));
    L33:
        String r17 = null;
        if (r18 <= 0) goto L37;
        r17 = String.format(Locale.US, "bytes=%d-%d", new Object[]{Long.valueOf(r16), Long.valueOf(r18)});
    L41:
        if (r17 == null) goto L43;
        r11.add(new HttpHeader("Range", r17));
    L45:
        if (r13 == true) goto L48;
        r12 = "identity";
    L48:
        r11.add(new HttpHeader(NetConst.KEY_ACCEPT_ENCODING, r12));
        r11.add(new HttpHeader("extra_download_id", String.valueOf(this.f544h.getId())));
        com.ss.android.socialbase.downloader.utils.c.b(this.f545i, r11, this.f544h);
        this.f547k.f689n.n(r10);
        return r11;
    L43:
        r13 = r14;
        goto L45
    L37:
        if (r16 <= 0) goto L39;
        r17 = String.format(Locale.US, "bytes=%d-", new Object[]{Long.valueOf(r16)});
        goto L41
    L39:
        if (r20 == true) goto L41;
        r17 = "bytes=0-0";
        goto L41
    L31:
        if (TextUtils.isEmpty(r15) == true) goto L33;
        r11.add(new HttpHeader("If-Match", r15));
        goto L33
    L8:
        if (r10.size() <= 0) goto L21;
        Iterator<HttpHeader> r19 = r10.iterator();
        r14 = false;
    L11:
        if (r19.hasNext() == false) goto L22;
        HttpHeader r110 = r19.next();
        if (r110 == null) goto L11;
        if (NetConst.KEY_ACCEPT_ENCODING.equalsIgnoreCase(r110.getName()) == false) goto L20;
        if (NetConst.GZIP.equalsIgnoreCase(r110.getValue()) == false) goto L20;
        r14 = true;
    L20:
        r11.add(r110);
        goto L11
    }

    public void o(nb.h r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.ss.android.socialbase.downloader.downloader.a.K0(new RunnableC0030a(this, r10), true);
    }

    protected void p(String r10, Throwable r11) {
        s();
        throw new BaseException(1089, r10, r11);
    }

    public void q(String r16, long r17, nb.h r19) {
        com.ss.android.socialbase.downloader.model.g r10 = new com.ss.android.socialbase.downloader.model.g(r16, r19);     // Catch: Throwable -> L83 BaseException -> L86
        int r11 = r10.f8195c;     // Catch: Throwable -> L83 BaseException -> L86
        String r12 = r10.f();     // Catch: Throwable -> L83 BaseException -> L86
        if (TextUtils.isEmpty(this.f544h.getMimeType()) == true) goto L6;
    L8:
        this.f544h.setSupportPartial(r10.a());     // Catch: Throwable -> L83 BaseException -> L86
        String r13 = r10.g();     // Catch: Throwable -> L83 BaseException -> L86
        if (TextUtils.isEmpty(r13) == true) goto L11;
        this.f544h.seteTag(r13);     // Catch: Throwable -> L83 BaseException -> L86
    L11:
        String r14 = r10.h();     // Catch: Throwable -> L83 BaseException -> L86
        if (TextUtils.isEmpty(r14) == true) goto L14;
        this.f544h.setLastModified(r14);     // Catch: Throwable -> L83 BaseException -> L86
    L14:
        this.f544h.setContentEncoding(r10.c());     // Catch: Throwable -> L83 BaseException -> L86
        if (NetConst.GZIP.equalsIgnoreCase(this.f544h.getContentEncoding()) == false) goto L17;
        this.f544h.setIgnoreDataVerify(true);     // Catch: Throwable -> L83 BaseException -> L86
    L17:
        x(r10);     // Catch: Throwable -> L83 BaseException -> L86
        if (lb.a.a() == false) goto L22;
        lb.a.g("AbsDownloadNetworkModule", this.f544h.getId(), "handleResponseHeader", "ResponseCode=" + r11 + " last_modified=" + r14 + " CACHE_CONTROL=" + r10.b() + " max-age=" + r10.i() + " isDeleteCacheIfCheckFailed=" + this.f544h.isDeleteCacheIfCheckFailed());     // Catch: Throwable -> L83 BaseException -> L86
        int r15 = this.f544h.getId();     // Catch: Throwable -> L83 BaseException -> L86
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L83 BaseException -> L86
        r18.append(" cur=");     // Catch: Throwable -> L83 BaseException -> L86
        r18.append(r14);     // Catch: Throwable -> L83 BaseException -> L86
        r18.append(" before=");     // Catch: Throwable -> L83 BaseException -> L86
        r18.append(this.f544h.getLastModified());     // Catch: Throwable -> L83 BaseException -> L86
        r18.append(" cur=");     // Catch: Throwable -> L83 BaseException -> L86
        r18.append(r10.j());     // Catch: Throwable -> L83 BaseException -> L86
        r18.append(" before=");     // Catch: Throwable -> L83 BaseException -> L86
        r18.append(this.f544h.getTotalBytes());     // Catch: Throwable -> L83 BaseException -> L86
        lb.a.g("AbsDownloadNetworkModule", r15, "handleResponseHeader", r18.toString());     // Catch: Throwable -> L83 BaseException -> L86
    L22:
        if ((r19 instanceof nb.a) == false) goto L27;
        String r20 = ((nb.a) r19).g();     // Catch: Throwable -> L83 BaseException -> L86
        if (TextUtils.isEmpty(r20) == true) goto L27;
        this.f544h.setRedirectPartialUrlResults(r20);     // Catch: Throwable -> L83 BaseException -> L86
    L27:
        if (r10.l() == true) goto L40;
        String r21 = r10.e();     // Catch: Throwable -> L83 BaseException -> L86
        if (lb.a.a() == false) goto L32;
        lb.a.g("AbsDownloadNetworkModule", this.f544h.getId(), "handleResponseHeader", "ContentRange:" + r21);     // Catch: Throwable -> L83 BaseException -> L86
    L32:
        if (TextUtils.isEmpty(r21) == true) goto L37;
        long r22 = com.ss.android.socialbase.downloader.utils.c.R(r21);     // Catch: Throwable -> L83 BaseException -> L86
        if (lb.a.a() == false) goto L42;
        int r23 = this.f544h.getId();     // Catch: Throwable -> L83 BaseException -> L86
        String r24 = "TotalLength:" + r22;     // Catch: Throwable -> L83 BaseException -> L86
    L36:
        lb.a.g("AbsDownloadNetworkModule", r23, "handleResponseHeader", r24);     // Catch: Throwable -> L83 BaseException -> L86
    L42:
        if (this.f544h.getStartOffset() > 0) goto L46;
        if (this.f544h.getEndOffset() >= 0) goto L46;
    L58:
        if (TextUtils.isEmpty(this.f544h.getTaskKey()) == true) goto L65;
        if (this.f544h.getTotalBytes() <= 0) goto L65;
        if (r22 == this.f544h.getTotalBytes()) goto L65;
        p("file totalLength changed", null);     // Catch: Throwable -> L83 BaseException -> L86
    L65:
        if (m() == false) goto L68;
        return;
    L68:
        if (this.f544h.getExpectFileLength() <= 0) goto L77;
        if (this.f545i.n("force_check_file_length") != 1) goto L77;
        if (this.f544h.getExpectFileLength() == r22) goto L77;
        throw new BaseException(1070, "expectFileLength = " + this.f544h.getExpectFileLength() + " , totalLength = " + r22);     // Catch: Throwable -> L83 BaseException -> L86
    L77:
        if (k.n(this.f544h) == true) goto L80;
        this.f546j.m(r22, r13, this.f544h.getName());     // Catch: Throwable -> L83 BaseException -> L86
        return;
    L80:
        throw new BaseException(1083, "download global intercept");     // Catch: Throwable -> L83 BaseException -> L86
    L46:
        if (this.f544h.getStartOffset() < 0) goto L82;
        if (this.f544h.getEndOffset() >= r22) goto L82;
        if (this.f544h.getEndOffset() < 0) goto L54;
        if (this.f544h.getStartOffset() > this.f544h.getEndOffset()) goto L82;
    L54:
        if (this.f544h.getEndOffset() >= 0) goto L56;
        r22 = r22 - this.f544h.getStartOffset();     // Catch: Throwable -> L83 BaseException -> L86
        goto L58
    L56:
        r22 = (this.f544h.getEndOffset() - this.f544h.getStartOffset()) + 1;     // Catch: Throwable -> L83 BaseException -> L86
    L82:
        throw new BaseException(1084, "startOffset = " + this.f544h.getStartOffset() + ", endOffset = " + this.f544h.getEndOffset() + ", totalLength = " + r22);     // Catch: Throwable -> L83 BaseException -> L86
    L37:
        r22 = r17 + r10.d();     // Catch: Throwable -> L83 BaseException -> L86
        if (lb.a.a() == false) goto L42;
        r23 = this.f544h.getId();     // Catch: Throwable -> L83 BaseException -> L86
        r24 = "TotalLength2:" + r22;     // Catch: Throwable -> L83 BaseException -> L86
        goto L36
    L40:
        r22 = -1;
        this.f544h.setXTotalBytes(r10.k());     // Catch: Throwable -> L83 BaseException -> L86
        goto L42
    L6:
        if (TextUtils.isEmpty(r12) == true) goto L8;
        this.f544h.setMimeType(r12);     // Catch: Throwable -> L83 BaseException -> L86
    L86:
        e = move-exception;
        throw e;
    L83:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.c.T(th, "handleResponseHeader");
    }

    public boolean r(bb.f r10, boolean r11) {
        h r12 = this.f547k;
        if (r12.f684i == false) goto L6;
        r10.b();
        return true;
    L6:
        r12.f684i = r11;
        return false;
    }

    public nb.h t(String r16, List<HttpHeader> r17, long r18) {
        long r11 = System.currentTimeMillis();
        nb.h r10 = com.ss.android.socialbase.downloader.downloader.a.f(this.f544h.isNeedDefaultHttpServiceBackUp(), this.f544h.getMaxBytes(), r16, null, r17, this.f545i.n("net_lib_strategy"), false, this.f544h);     // Catch: Throwable -> L11
        if (r10 == null) goto L10;
        int r12 = r10.c();     // Catch: Throwable -> L7
        w(r10, r12);
        mb.a.d(r16, r10, null, this.f543g.s());
        nb.h r13 = r10;
        Throwable r14 = null;
    L69:
        if (r12 != 304) goto L28;
        if (this.f544h.isDownloaded() == true) goto L21;
        p("Status 304 file not found", null);     // Catch: Throwable -> L25
    L21:
        if (System.currentTimeMillis() <= this.f544h.getCacheExpiredTime()) goto L24;
        x(new com.ss.android.socialbase.downloader.model.g(r16, r13, 304));     // Catch: Throwable -> L25
    L24:
        throw new DownloadFileExistException();     // Catch: Throwable -> L25
    L28:
        if (r12 == 403) goto L60;
        if (r12 <= 0) goto L32;
        if (r12 >= 200) goto L32;
    L33:
        if (r14 == null) goto L35;
        DownloadTTNetException r15 = com.ss.android.socialbase.downloader.utils.c.t(r14, "sendRequest");     // Catch: Throwable -> L25
    L36:
        if (r15 != null) goto L38;
        r15 = new DownloadTTNetException(r12 + 2000, "Status Error");     // Catch: Throwable -> L25
    L38:
        p("Http Status Error: " + r12, r15);     // Catch: Throwable -> L25
    L40:
        if (this.f547k.f685j == false) goto L50;
        if (r12 < 200) goto L46;
        if (r12 >= 300) goto L46;
        s();     // Catch: Throwable -> L25
        return r13;
    L46:
        if (com.ss.android.socialbase.downloader.utils.g.L(this.f544h, false, null) == true) goto L49;
        p("CheckIfModified file not found", null);     // Catch: Throwable -> L25
    L49:
        throw new DownloadFileExistException();     // Catch: Throwable -> L25
    L50:
        if (r14 == null) goto L53;
        com.ss.android.socialbase.downloader.utils.c.T(r14, "DoConnect");     // Catch: Throwable -> L25
    L53:
        if (r12 != 206) goto L55;
    L57:
        this.f544h.increaseAllConnectTime(System.currentTimeMillis() - r11);     // Catch: Throwable -> L25
        return r13;
    L55:
        if (r18 <= 0) goto L57;
        p("Http range not support", null);     // Catch: Throwable -> L25
        goto L57
    L35:
        r15 = null;
    L32:
        if (r12 < 300) goto L40;
    L60:
        throw new BaseException(1047, "Status Error:403", r14);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (r13 == null) goto L63;
        r13.a();
    L63:
        throw th;
    L10:
        throw new BaseException(1022, new IOException("Connection is null"));     // Catch: Throwable -> L7
    L7:
        th = th;
    L67:
        int r19 = ((qb.l) qb.k.a(qb.l.class)).a().b(th);     // Catch: Throwable -> L64
        w(r10, r19);
        mb.a.d(r16, r10, th, this.f543g.s());
        nb.h r110 = r10;
        r14 = th;
        r12 = r19;
        r13 = r110;
    L64:
        th = move-exception;
        w(r10, -1);
        mb.a.d(r16, r10, null, this.f543g.s());
        throw th;
    L11:
        th = th;
        r10 = null;
        goto L67
    }
}
