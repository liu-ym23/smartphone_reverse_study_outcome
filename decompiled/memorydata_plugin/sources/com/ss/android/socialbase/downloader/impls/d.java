package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.utils.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes6.dex */
public class d implements com.ss.android.socialbase.downloader.network.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache<String, OkHttpClient> f15489a;

    public d() {
        this.f15489a = new LruCache(4, 8);
    }

    private OkHttpClient a(String r6, final String r7) {
        final String r8 = Uri.parse(r6).getHost();     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r8) == true) goto L27;
        if (TextUtils.isEmpty(r7) == true) goto L27;
        String r0 = r8 + "_" + r7;     // Catch: Throwable -> L24
        LruCache<String, OkHttpClient> r1 = this.f15489a;     // Catch: Throwable -> L24
        monitor-enter(r1);     // Catch: Throwable -> L24
        OkHttpClient r2 = (OkHttpClient) ZeusTransformUtils.preCheckCast(this.f15489a.get(r0), OkHttpClient.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r2 == null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r2;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L21
        OkHttpClient.Builder r3 = com.ss.android.socialbase.downloader.downloader.b.x();     // Catch: Throwable -> L24
        r3.dns(new AnonymousClass2(this, r8, r7));     // Catch: Throwable -> L24
        OkHttpClient r9 = r3.build();     // Catch: Throwable -> L24
        LruCache<String, OkHttpClient> r10 = this.f15489a;     // Catch: Throwable -> L24
        monitor-enter(r10);     // Catch: Throwable -> L24
        this.f15489a.put(r0, r9);     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        return r9;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L27:
        return com.ss.android.socialbase.downloader.downloader.b.v();
    L24:
        th = move-exception;
        th.printStackTrace();
        goto L27
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public com.ss.android.socialbase.downloader.network.h a(int r12, String r13, List<HttpHeader> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Request.Builder r16 = new Request.Builder().url(r13);
        int r2 = -1;
        if (r15 != null) goto L5;
    L25:
        String r3 = null;
    L27:
        if (TextUtils.isEmpty(r3) == true) goto L29;
        OkHttpClient r17 = a(r13, r3);
    L30:
        if (r17 == null) goto L59;
        Request r18 = r16.build();
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L36;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadHttpService", "downloadWithConnection", r2 + "|Request Url:" + r13);
        Headers r19 = r18.headers();
        if (r19 == null) goto L36;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadHttpService", "downloadWithConnection", r2 + "|Request Headers: " + r19.toString());
    L36:
        final Call r9 = r17.newCall(r18);
        final Response r8 = r9.execute();
        if (r8 == null) goto L57;
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L43;
        Headers r110 = r8.headers();
        if (r110 == null) goto L43;
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadHttpService", "downloadWithConnection", r2 + "|Response Header");
        com.ss.android.socialbase.downloader.e.a.a("DefaultDownloadHttpService", "downloadWithConnection", r2 + "|Response Headers: " + r110.toString());
    L43:
        final ResponseBody r10 = r8.body();
        if (r10 == null) goto L55;
        InputStream r111 = r10.byteStream();
        String r112 = r8.header(NetConst.KEY_CONTENT_ENCODING);
        if (r112 != null) goto L48;
    L52:
        final InputStream r7 = r111;
    L54:
        return new AnonymousClass1(this, r7, r8, r9, r10);
    L48:
        if (NetConst.GZIP.equalsIgnoreCase(r112) == false) goto L52;
        if (ZeusTransformUtils.instanceOf(r111, GZIPInputStream.class) == true) goto L52;
        r7 = new GZIPInputStream(r111);
        goto L54
    L55:
        return null;
    L57:
        throw new IOException("can't get response");
    L59:
        throw new IOException("can't get httpClient");
    L29:
        r17 = com.ss.android.socialbase.downloader.downloader.b.v();
        goto L30
    L5:
        if (r15.size() <= 0) goto L25;
        Iterator r113 = r15.iterator();
        r3 = null;
    L8:
        if (r113.hasNext() == false) goto L27;
        HttpHeader r4 = (HttpHeader) ZeusTransformUtils.preCheckCast(r113.next(), HttpHeader.class, "com.obric.memorydata.plugin");
        String r5 = r4.getName();
        if (com.ss.android.socialbase.downloader.constants.c.f15354a.equals(r5) == true) goto L8;
        if (com.ss.android.socialbase.downloader.constants.c.f15355b.equals(r5) == true) goto L8;
        if ("extra_download_id".equalsIgnoreCase(r4.getName()) == false) goto L20;
        r2 = Integer.parseInt(r4.getValue());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L8
    L20:
        if (r3 != null) goto L24;
        if ("ss_d_request_host_ip_114".equals(r5) == false) goto L24;
        r3 = r4.getValue();
    L24:
        r16.addHeader(r5, com.ss.android.socialbase.downloader.utils.g.d(r4.getValue()));
        goto L8
    }
}
