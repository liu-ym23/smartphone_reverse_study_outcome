package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.a0;
import okhttp3.p;
import okhttp3.r;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes2.dex */
public class d implements nb.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache<String, w> f7983a;

    class a extends nb.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f7984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z f7985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ okhttp3.e f7986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a0 f7987d;

        a(d r10, InputStream r11, z r12, okhttp3.e r13, a0 r14) {
            this.f7984a = r11;
            this.f7985b = r12;
            this.f7986c = r13;
            this.f7987d = r14;
        }

        @Override // nb.h
        public void a() {
            a0 r10 = this.f7987d;     // Catch: Throwable -> L11
            if (r10 == null) goto L5;
            r10.close();     // Catch: Throwable -> L11
        L5:
            okhttp3.e r11 = this.f7986c;     // Catch: Throwable -> L11
            if (r11 != null) goto L8;
            return;
        L8:
            if (r11.isCanceled() == true) goto L15;
            this.f7986c.cancel();     // Catch: Throwable -> L11
            return;
        L15:
            return;
        }

        @Override // nb.h
        public InputStream b() {
            return this.f7984a;
        }

        @Override // nb.g
        public int c() {
            return this.f7985b.k();
        }

        @Override // nb.g
        public void cancel() {
            okhttp3.e r10 = this.f7986c;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.isCanceled() == true) goto L9;
            this.f7986c.cancel();
            return;
        }

        @Override // nb.g
        public String d(String r10) {
            return this.f7985b.p(r10);
        }

        @Override // nb.a
        public String e() {
            return "";
        }

        @Override // nb.a
        public List<Pair<String, String>> i() {
            r r10 = this.f7985b.v();
            if (r10 != null) goto L6;
            return null;
        L6:
            ArrayList r11 = new ArrayList();
            int r12 = 0;
            int r13 = r10.size();
        L7:
            if (r12 >= r13) goto L9;
            r11.add(new Pair(r10.c(r12), r10.i(r12)));
            r12 = r12 + 1;
            goto L7
        L9:
            return r11;
        }

        @Override // nb.a
        public boolean j() {
            return true;
        }
    }

    class b implements p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7989c;

        b(d r10, String r11, String r12) {
            this.f7988b = r11;
            this.f7989c = r12;
        }

        @Override // okhttp3.p
        public List<InetAddress> a(String r10) {
            if (TextUtils.equals(this.f7988b, r10) == false) goto L7;
            return Collections.singletonList(InetAddress.getByName(this.f7989c));
        L7:
            return p.f12019a.a(r10);
        }
    }

    public d() {
        this.f7983a = new LruCache(4, 8);
    }

    private w b(String r10, String r11) {
        String r12 = Uri.parse(r10).getHost();     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r12) == true) goto L27;
        if (TextUtils.isEmpty(r11) == true) goto L27;
        String r13 = r12 + "_" + r11;     // Catch: Throwable -> L24
        LruCache<String, w> r14 = this.f7983a;     // Catch: Throwable -> L24
        monitor-enter(r14);     // Catch: Throwable -> L24
        w r15 = this.f7983a.get(r13);     // Catch: Throwable -> L21
        if (r15 == null) goto L12;
        monitor-exit(r14);     // Catch: Throwable -> L21
        return r15;
    L12:
        monitor-exit(r14);     // Catch: Throwable -> L21
        w.a r16 = com.ss.android.socialbase.downloader.downloader.a.e();     // Catch: Throwable -> L24
        r16.i(new b(this, r12, r11));     // Catch: Throwable -> L24
        w r17 = r16.c();     // Catch: Throwable -> L24
        LruCache<String, w> r18 = this.f7983a;     // Catch: Throwable -> L24
        monitor-enter(r18);     // Catch: Throwable -> L24
        this.f7983a.put(r13, r17);     // Catch: Throwable -> L18
        monitor-exit(r18);     // Catch: Throwable -> L18
        return r17;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L27:
        return com.ss.android.socialbase.downloader.downloader.a.p();
    L24:
        th = move-exception;
        th.printStackTrace();
        goto L27
    }

    @Override // nb.i
    public nb.h a(int r12, String r13, List<HttpHeader> r14) {
        x.a r15 = new x.a().k(r13);
        int r10 = -1;
        if (r14 != null) goto L5;
    L25:
        String r11 = null;
    L27:
        if (TextUtils.isEmpty(r11) == true) goto L29;
        w r16 = b(r13, r11);
    L30:
        if (r16 == null) goto L59;
        x r17 = r15.b();
        if (lb.a.a() == false) goto L36;
        lb.a.g("DefaultDownloadHttpService", r10, "downloadWithConnection", "Request Url:" + r13);
        r r18 = r17.e();
        if (r18 == null) goto L36;
        lb.a.g("DefaultDownloadHttpService", r10, "downloadWithConnection", "Request Header");
        lb.a.g("DefaultDownloadHttpService", r10, "downloadWithConnection", "Request Headers: " + r18.toString());
    L36:
        okhttp3.e r19 = r16.A(r17);
        z r20 = r19.execute();
        if (r20 == null) goto L57;
        if (lb.a.a() == false) goto L43;
        r r110 = r20.v();
        if (r110 == null) goto L43;
        lb.a.g("DefaultDownloadHttpService", r10, "downloadWithConnection", "Response Header");
        lb.a.g("DefaultDownloadHttpService", r10, "downloadWithConnection", "Response Headers: " + r110.toString());
    L43:
        a0 r111 = r20.a();
        if (r111 == null) goto L55;
        InputStream r112 = r111.a();
        String r113 = r20.p(NetConst.KEY_CONTENT_ENCODING);
        if (r113 != null) goto L48;
    L52:
        InputStream r21 = r112;
    L54:
        return new a(this, r21, r20, r19, r111);
    L48:
        if (NetConst.GZIP.equalsIgnoreCase(r113) == false) goto L52;
        if ((r112 instanceof GZIPInputStream) == true) goto L52;
        r21 = new GZIPInputStream(r112);
        goto L54
    L55:
        return null;
    L57:
        throw new IOException("can't get response");
    L59:
        throw new IOException("can't get httpClient");
    L29:
        r16 = com.ss.android.socialbase.downloader.downloader.a.p();
        goto L30
    L5:
        if (r14.size() <= 0) goto L25;
        Iterator<HttpHeader> r114 = r14.iterator();
        r11 = null;
    L8:
        if (r114.hasNext() == false) goto L27;
        HttpHeader r22 = r114.next();
        String r23 = r22.getName();
        if (ab.c.f135a.equals(r23) == true) goto L8;
        if (ab.c.f136b.equals(r23) == true) goto L8;
        if ("extra_download_id".equalsIgnoreCase(r22.getName()) == false) goto L20;
        r10 = Integer.parseInt(r22.getValue());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L8
    L20:
        if (r11 != null) goto L24;
        if ("ss_d_request_host_ip_114".equals(r23) == false) goto L24;
        r11 = r22.getValue();
    L24:
        r15.a(r23, com.ss.android.socialbase.downloader.utils.g.v(r22.getValue()));
        goto L8
    }
}
