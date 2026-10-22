package com.ss.android.socialbase.downloader.b.a;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class a extends com.ss.android.socialbase.downloader.b.a implements com.ss.android.socialbase.downloader.h.d {
    public a() {
    }

    private void a(com.ss.android.socialbase.downloader.model.f r7) {
        if (TextUtils.isEmpty(r7.g()) == false) goto L6;
        return;
    L6:
        if (r7.l() <= 0) goto L9;
        this.c.setCacheExpiredTime(System.currentTimeMillis() + (r7.l() * 1000));
        return;
    }

    private void a(com.ss.android.socialbase.downloader.network.h r7, int r8) {
        com.ss.android.socialbase.downloader.network.h r9 = (com.ss.android.socialbase.downloader.network.h) ZeusTransformUtils.wrapperContextForParams(r7, com.ss.android.socialbase.downloader.network.h.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L33;
        this.c.setHttpStatusCode(-1);
        this.c.setHttpStatusMessage("");
        return;
    L33:
        this.c.setHttpStatusCode(r8);     // Catch: Throwable -> L24
        this.c.setHttpStatusMessage(com.ss.android.socialbase.downloader.utils.d.a(r8));     // Catch: Throwable -> L24
        List<String> r10 = this.c.getAccessHttpHeaderKeys();     // Catch: Throwable -> L24
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.isEmpty() == true) goto L45;
        HashMap r3 = new HashMap();     // Catch: Throwable -> L24
        Iterator<String> r11 = r10.iterator();     // Catch: Throwable -> L24
    L12:
        if (r11.hasNext() == false) goto L21;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r4 == null) goto L12;
        String r5 = r9.a(r4);     // Catch: Throwable -> L24
        if (r5 == null) goto L12;
        r3.put(r4, r5);     // Catch: Throwable -> L24
        goto L12
    L21:
        if (r3.isEmpty() == true) goto L46;
        this.c.setHttpHeaders(r3);     // Catch: Throwable -> L24
        return;
    L46:
        return;
    L45:
        return;
    L24:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        this.c.setHttpStatusCode(-1);
        this.c.setHttpStatusMessage("");
        return;
    L28:
        th = move-exception;
        this.c.setHttpStatusCode(-1);
        this.c.setHttpStatusMessage("");
        throw th;
    }

    private void d() {
        com.ss.android.socialbase.downloader.utils.g.c(this.c);
        this.f.j = false;
        this.c.resetDataForEtagEndure("");
        this.f15249a.a(this.c);
    }

    public com.ss.android.socialbase.downloader.network.h a(String r17, List<HttpHeader> r18, long r19) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        long r12 = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.network.h r2 = com.ss.android.socialbase.downloader.downloader.b.a(this.c.isNeedDefaultHttpServiceBackUp(), this.c.getMaxBytes(), r17, null, r6, this.d.b("net_lib_strategy"), false, this.c);     // Catch: Throwable -> L11
        if (r2 == null) goto L10;
        int r0 = r2.b();     // Catch: Throwable -> L7
        a(r2, r0);
        com.ss.android.socialbase.downloader.f.a.a(r17, r2, null, this.f15250b.getCdnListener());
        com.ss.android.socialbase.downloader.network.h r3 = r2;
        Throwable r4 = null;
    L72:
        if (r0 != 304) goto L28;
        if (this.c.isDownloaded() == true) goto L21;
        a("Status 304 file not found", null);     // Catch: Throwable -> L25
    L21:
        if (System.currentTimeMillis() <= this.c.getCacheExpiredTime()) goto L24;
        a(new com.ss.android.socialbase.downloader.model.f(r17, r3, 304));     // Catch: Throwable -> L25
    L24:
        throw new DownloadFileExistException();     // Catch: Throwable -> L25
    L28:
        if (r0 == 403) goto L60;
        if (r0 <= 0) goto L32;
        if (r0 >= 200) goto L32;
    L33:
        if (r4 == null) goto L35;
        DownloadTTNetException r7 = com.ss.android.socialbase.downloader.utils.c.b(r4, "sendRequest");     // Catch: Throwable -> L25
    L36:
        if (r7 != null) goto L38;
        r7 = new DownloadTTNetException(r0 + 2000, "Status Error");     // Catch: Throwable -> L25
    L38:
        a("Http Status Error: " + r0, r7);     // Catch: Throwable -> L25
    L40:
        if (this.f.j == false) goto L50;
        if (r0 < 200) goto L46;
        if (r0 >= 300) goto L46;
        d();     // Catch: Throwable -> L25
        return r3;
    L46:
        if (com.ss.android.socialbase.downloader.utils.g.a(this.c, false, null) == true) goto L49;
        a("CheckIfModified file not found", null);     // Catch: Throwable -> L25
    L49:
        throw new DownloadFileExistException();     // Catch: Throwable -> L25
    L50:
        if (r4 == null) goto L53;
        com.ss.android.socialbase.downloader.utils.c.a(r4, "DoConnect");     // Catch: Throwable -> L25
    L53:
        if (r0 != 206) goto L55;
    L57:
        this.c.increaseAllConnectTime(System.currentTimeMillis() - r12);     // Catch: Throwable -> L25
        return r3;
    L55:
        if (r19 <= 0) goto L57;
        a("Http range not support", null);     // Catch: Throwable -> L25
        goto L57
    L35:
        r7 = null;
    L32:
        if (r0 < 300) goto L40;
    L60:
        throw new BaseException(1047, "Status Error:403", r4);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (r3 == null) goto L63;
        r3.d();
    L63:
        throw th;
    L10:
        throw new BaseException(1022, new IOException("Connection is null"));     // Catch: Throwable -> L7
    L7:
        th = th;
    L70:
        int r5 = ((com.ss.android.socialbase.downloader.service.l) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(com.ss.android.socialbase.downloader.service.l.class), com.ss.android.socialbase.downloader.service.l.class, "com.obric.memorydata.plugin")).h().a(th);     // Catch: Throwable -> L64
        a(r2, r5);
        com.ss.android.socialbase.downloader.f.a.a(r17, r2, th, this.f15250b.getCdnListener());
        com.ss.android.socialbase.downloader.network.h r15 = r2;
        r4 = th;
        r0 = r5;
        r3 = r15;
    L64:
        th = move-exception;
        a(r2, -1);
        com.ss.android.socialbase.downloader.f.a.a(r17, r2, null, this.f15250b.getCdnListener());
        throw th;
    L11:
        th = th;
        r2 = null;
        goto L70
    }

    public List<HttpHeader> a(long r16, long r18, boolean r20) {
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadNetworkModule", this.c, "buildRequestHeader", "CurrentOffset: endOffset:" + r18 + " handleBody:" + r20);
    L5:
        List<HttpHeader> r4 = this.c.getExtraHeaders();
        ArrayList r5 = new ArrayList();
        String r6 = NetConst.GZIP;
        boolean r9 = false;
        if (r4 != null) goto L8;
    L21:
        boolean r11 = false;
    L22:
        String r10 = this.c.geteTag();
        if (this.f.j == false) goto L31;
        if (TextUtils.isEmpty(r10) == true) goto L28;
        r5.add(new HttpHeader("If-None-Match", r10));
    L28:
        if (TextUtils.isEmpty(this.c.getLastModified()) == true) goto L33;
        r5.add(new HttpHeader("if-modified-since", this.c.getLastModified()));
        r5.add(new HttpHeader("download-tc21-1-15", "download-tc21-1-15"));
    L33:
        String r12 = null;
        if (r18 <= 0) goto L37;
        r12 = String.format(Locale.US, "bytes=%d-%d", new Object[]{Long.valueOf(r16), Long.valueOf(r18)});
    L41:
        if (r12 == null) goto L43;
        r5.add(new HttpHeader("Range", r12));
    L45:
        if (r9 == true) goto L48;
        r6 = "identity";
    L48:
        r5.add(new HttpHeader(NetConst.KEY_ACCEPT_ENCODING, r6));
        r5.add(new HttpHeader("extra_download_id", String.valueOf(this.c.getId())));
        com.ss.android.socialbase.downloader.utils.c.a(this.d, r5, this.c);
        this.f.n.a(r4);
        return r5;
    L43:
        r9 = r11;
        goto L45
    L37:
        if (r16 <= 0) goto L39;
        r12 = String.format(Locale.US, "bytes=%d-", new Object[]{Long.valueOf(r16)});
        goto L41
    L39:
        if (r20 == true) goto L41;
        r12 = "bytes=0-0";
        goto L41
    L31:
        if (TextUtils.isEmpty(r10) == true) goto L33;
        r5.add(new HttpHeader("If-Match", r10));
        goto L33
    L8:
        if (r4.size() <= 0) goto L21;
        Iterator<HttpHeader> r13 = r4.iterator();
        r11 = false;
    L11:
        if (r13.hasNext() == false) goto L22;
        HttpHeader r14 = (HttpHeader) ZeusTransformUtils.preCheckCast(r13.next(), HttpHeader.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L11;
        if (NetConst.KEY_ACCEPT_ENCODING.equalsIgnoreCase(r14.getName()) == false) goto L20;
        if (NetConst.GZIP.equalsIgnoreCase(r14.getValue()) == false) goto L20;
        r11 = true;
    L20:
        r5.add(r14);
        goto L11
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r2) {
        com.ss.android.socialbase.downloader.b.f r1 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
    }

    public void a(com.ss.android.socialbase.downloader.network.h r3) {
        final com.ss.android.socialbase.downloader.network.h r4 = (com.ss.android.socialbase.downloader.network.h) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.network.h.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.downloader.b.b(new AnonymousClass1(this, r4), true);
    }

    @Override // com.ss.android.socialbase.downloader.h.d
    public void a(String r1) {
        this.e.a(r1);
    }

    public void a(String r16, long r17, com.ss.android.socialbase.downloader.network.h r19) {
        com.ss.android.socialbase.downloader.network.h r4 = (com.ss.android.socialbase.downloader.network.h) ZeusTransformUtils.wrapperContextForParams(r19, com.ss.android.socialbase.downloader.network.h.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.model.f r6 = new com.ss.android.socialbase.downloader.model.f(r16, r4);     // Catch: Throwable -> L83 BaseException -> L86
        int r7 = r6.c;     // Catch: Throwable -> L83 BaseException -> L86
        String r8 = r6.d();     // Catch: Throwable -> L83 BaseException -> L86
        if (TextUtils.isEmpty(this.c.getMimeType()) == true) goto L6;
    L8:
        this.c.setSupportPartial(r6.b());     // Catch: Throwable -> L83 BaseException -> L86
        String r9 = r6.c();     // Catch: Throwable -> L83 BaseException -> L86
        if (TextUtils.isEmpty(r9) == true) goto L11;
        this.c.seteTag(r9);     // Catch: Throwable -> L83 BaseException -> L86
    L11:
        String r10 = r6.f();     // Catch: Throwable -> L83 BaseException -> L86
        if (TextUtils.isEmpty(r10) == true) goto L14;
        this.c.setLastModified(r10);     // Catch: Throwable -> L83 BaseException -> L86
    L14:
        this.c.setContentEncoding(r6.m());     // Catch: Throwable -> L83 BaseException -> L86
        if (NetConst.GZIP.equalsIgnoreCase(this.c.getContentEncoding()) == false) goto L17;
        this.c.setIgnoreDataVerify(true);     // Catch: Throwable -> L83 BaseException -> L86
    L17:
        a(r6);     // Catch: Throwable -> L83 BaseException -> L86
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L22;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadNetworkModule", this.c, "handleResponseHeader", "ResponseCode=" + r7 + " last_modified=" + r10 + " CACHE_CONTROL=" + r6.g() + " max-age=" + r6.l() + " isDeleteCacheIfCheckFailed=" + this.c.isDeleteCacheIfCheckFailed());     // Catch: Throwable -> L83 BaseException -> L86
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadNetworkModule", this.c, "handleResponseHeader", " cur=" + r10 + " before=" + this.c.getLastModified() + " cur=" + r6.k() + " before=" + this.c.getTotalBytes());     // Catch: Throwable -> L83 BaseException -> L86
    L22:
        if (ZeusTransformUtils.instanceOf(r4, com.ss.android.socialbase.downloader.network.a.class) == false) goto L27;
        String r1 = ((com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r4, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin")).i();     // Catch: Throwable -> L83 BaseException -> L86
        if (TextUtils.isEmpty(r1) == true) goto L27;
        this.c.setRedirectPartialUrlResults(r1);     // Catch: Throwable -> L83 BaseException -> L86
    L27:
        if (r6.i() == true) goto L40;
        String r2 = r6.e();     // Catch: Throwable -> L83 BaseException -> L86
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L32;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadNetworkModule", this.c, "handleResponseHeader", "ContentRange:" + r2);     // Catch: Throwable -> L83 BaseException -> L86
    L32:
        if (TextUtils.isEmpty(r2) == true) goto L37;
        long r3 = com.ss.android.socialbase.downloader.utils.c.a(r2);     // Catch: Throwable -> L83 BaseException -> L86
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L42;
        DownloadInfo r5 = this.c;     // Catch: Throwable -> L83 BaseException -> L86
        String r11 = "TotalLength:" + r3;     // Catch: Throwable -> L83 BaseException -> L86
    L36:
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadNetworkModule", r5, "handleResponseHeader", r11);     // Catch: Throwable -> L83 BaseException -> L86
    L42:
        if (this.c.getStartOffset() > 0) goto L46;
        if (this.c.getEndOffset() >= 0) goto L46;
    L58:
        if (TextUtils.isEmpty(this.c.getTaskKey()) == true) goto L65;
        if (this.c.getTotalBytes() <= 0) goto L65;
        if (r3 == this.c.getTotalBytes()) goto L65;
        a("file totalLength changed", null);     // Catch: Throwable -> L83 BaseException -> L86
    L65:
        if (j_() == false) goto L68;
        return;
    L68:
        if (this.c.getExpectFileLength() <= 0) goto L77;
        if (this.d.b("force_check_file_length") != 1) goto L77;
        if (this.c.getExpectFileLength() == r3) goto L77;
        throw new BaseException(1070, "expectFileLength = " + this.c.getExpectFileLength() + " , totalLength = " + r3);     // Catch: Throwable -> L83 BaseException -> L86
    L77:
        if (l.a(this.c) == true) goto L80;
        this.e.a(r3, r9, this.c.getName());     // Catch: Throwable -> L83 BaseException -> L86
        return;
    L80:
        throw new BaseException(1083, "download global intercept");     // Catch: Throwable -> L83 BaseException -> L86
    L46:
        if (this.c.getStartOffset() < 0) goto L82;
        if (this.c.getEndOffset() >= r3) goto L82;
        if (this.c.getEndOffset() < 0) goto L54;
        if (this.c.getStartOffset() > this.c.getEndOffset()) goto L82;
    L54:
        if (this.c.getEndOffset() >= 0) goto L56;
        r3 = r3 - this.c.getStartOffset();     // Catch: Throwable -> L83 BaseException -> L86
        goto L58
    L56:
        r3 = (this.c.getEndOffset() - this.c.getStartOffset()) + 1;     // Catch: Throwable -> L83 BaseException -> L86
    L82:
        throw new BaseException(1084, "startOffset = " + this.c.getStartOffset() + ", endOffset = " + this.c.getEndOffset() + ", totalLength = " + r3);     // Catch: Throwable -> L83 BaseException -> L86
    L37:
        r3 = r17 + r6.h();     // Catch: Throwable -> L83 BaseException -> L86
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L42;
        r5 = this.c;     // Catch: Throwable -> L83 BaseException -> L86
        r11 = "TotalLength2:" + r3;     // Catch: Throwable -> L83 BaseException -> L86
        goto L36
    L40:
        r3 = -1;
        this.c.setXTotalBytes(r6.j());     // Catch: Throwable -> L83 BaseException -> L86
        goto L42
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L8;
        this.c.setMimeType(r8);     // Catch: Throwable -> L83 BaseException -> L86
    L86:
        e = move-exception;
        throw e;
    L83:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.c.a(th, "handleResponseHeader");
    }

    @Override // com.ss.android.socialbase.downloader.h.d
    public void a(String r1, com.ss.android.socialbase.downloader.network.g r2, long r3) {
        com.ss.android.socialbase.downloader.network.g r0 = (com.ss.android.socialbase.downloader.network.g) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.network.g.class, "com.obric.memorydata.plugin");
    }

    public void a(String r2, Throwable r3) {
        d();
        throw new BaseException(1089, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.h.d
    public void a(List<Pair<String, String>> r3) {
        List<Pair<String, String>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.e.a(r4);
    }

    @Override // com.ss.android.socialbase.downloader.h.d
    public void a(byte[] r1, int r2) {
        this.e.a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.h.d
    public boolean a(long r1) {
        return this.e.a(r1);
    }

    public boolean a(com.ss.android.socialbase.downloader.b.f r3, boolean r4) {
        com.ss.android.socialbase.downloader.b.f r5 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (this.f.i == false) goto L6;
        r5.a();
        return true;
    L6:
        this.f.i = r4;
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.h.d
    public void b(long r4, int r6) {
        if (r4 <= 0) goto L10;
        if (r6 > 0) goto L6;
        return;
    L6:
        if (r4 > r6) goto L9;
        return;
    L9:
        throw new BaseException(1088, "Current Bytes:" + r4 + "Limit bytes:" + r6);
    }
}
