package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.c0;
import okhttp3.internal.connection.RealCall;
import okhttp3.l0;
import okhttp3.n0;
import okhttp3.s0;
import okhttp3.t;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDownloadHttpService implements IDownloadHttpService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache f15687a;

    public DefaultDownloadHttpService() {
        this.f15687a = new LruCache(4, 8);
    }

    public final IDownloadHttpConnection a(String r12, ArrayList r13) {
        n0 r5 = new n0();
        r5.g(r12);
        int r10 = -1;
        if (r13.size() <= 0) goto L33;
        Iterator r14 = r13.iterator();
        String r11 = null;
    L6:
        if (r14.hasNext() == false) goto L35;
        HttpHeader r15 = (HttpHeader) r14.next();
        String r16 = r15.f15909a;
        if ("x-ttnet-req-biz-id".equals(r16) == true) goto L6;
        if ("x-ttnet-req-biz-ver".equals(r16) == true) goto L6;
        if ("extra_download_id".equalsIgnoreCase(r15.f15909a) == false) goto L18;
        r10 = Integer.parseInt(r15.f15910b);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L6
    L18:
        if (r11 != null) goto L22;
        if ("ss_d_request_host_ip_114".equals(r16) == false) goto L22;
        r11 = r15.f15910b;
    L22:
        String r17 = r15.f15910b;
        char[] r18 = DownloadUtils.f16142a;
        StringBuilder r19 = new StringBuilder();
        int r20 = r17.length();
        int r21 = 0;
    L23:
        if (r21 >= r20) goto L32;
        char r22 = r17.charAt(r21);
        if (r22 > 31) goto L27;
    L30:
        r19.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r22)}));
    L31:
        r21 = r21 + 1;
        goto L23
    L27:
        if (r22 >= 127) goto L30;
        r19.append(r22);
        goto L31
    L32:
        r5.a(r16, r19.toString());
    L35:
        if (TextUtils.isEmpty(r11) == true) goto L37;
        OkHttpClient r110 = a(r12, r11);
    L38:
        if (r110 == null) goto L64;
        Request r111 = r5.b();
        if (Logger.a() == false) goto L44;
        Logger.b("DefaultDownloadHttpService", "downloadWithConnection", r10 + "|Request Url:" + r12);
        c0 r112 = r111.headers();
        if (r112 == null) goto L44;
        Logger.b("DefaultDownloadHttpService", "downloadWithConnection", r10 + "|Request Headers: " + r112.toString());
    L44:
        final RealCall r113 = r110.a(r111);
        final s0 r114 = r113.execute();
        if (r114 == null) goto L62;
        if (Logger.a() == false) goto L49;
        c0 r115 = r114.g;
        Logger.b("DefaultDownloadHttpService", "downloadWithConnection", r10 + "|Response Header");
        Logger.b("DefaultDownloadHttpService", "downloadWithConnection", r10 + "|Response Headers: " + r115.toString());
    L49:
        final w0 r116 = r114.f20748h;
        if (r116 == null) goto L60;
        final InputStream r23 = r116.byteStream();
        String r24 = r114.d("Content-Encoding", null);
        if (r24 == null) goto L59;
        if ("gzip".equalsIgnoreCase(r24) == false) goto L59;
        if ((r23 instanceof GZIPInputStream) == true) goto L59;
        r23 = new GZIPInputStream(r23);
    L59:
        return new AnonymousClass1(r23, r114, r113, r116);
    L60:
        return null;
    L62:
        throw new IOException("can't get response");
    L64:
        throw new IOException("can't get httpClient");
    L37:
        r110 = DownloadComponentManager.i();
        goto L38
    L33:
        r11 = null;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OkHttpClient a(String r5, String r10) {
        String r11 = Uri.parse(r5).getHost();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r11) == true) goto L32;
        if (TextUtils.isEmpty(r10) == true) goto L32;
        String r12 = r11 + "_" + r10;     // Catch: Throwable -> L26
        LruCache r13 = this.f15687a;     // Catch: Throwable -> L26
        monitor-enter(r13);     // Catch: Throwable -> L26
        OkHttpClient r14 = (OkHttpClient) this.f15687a.get(r12);     // Catch: Throwable -> L12
        if (r14 == null) goto L14;
        monitor-exit(r13);     // Catch: Throwable -> L12
        return r14;
    L14:
        monitor-exit(r13);     // Catch: Throwable -> L12
        l0 r15 = DownloadComponentManager.a();     // Catch: Throwable -> L26
        t r16 = new AnonymousClass2();     // Catch: Throwable -> L26
        r15.getClass();     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r16, "dns");     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r16, r15.f20683l) == true) goto L18;
        r15.B = null;     // Catch: Throwable -> L26
    L18:
        r15.f20683l = r16;     // Catch: Throwable -> L26
        OkHttpClient r17 = new OkHttpClient(r15);     // Catch: Throwable -> L26
        LruCache r18 = this.f15687a;     // Catch: Throwable -> L26
        monitor-enter(r18);     // Catch: Throwable -> L26
        this.f15687a.put(r12, r17);     // Catch: Throwable -> L23
        monitor-exit(r18);     // Catch: Throwable -> L23
        return r17;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L32:
        return DownloadComponentManager.i();
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L32
    }
}
