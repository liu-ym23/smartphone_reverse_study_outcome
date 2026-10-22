package com.ss.ugc.effectplatform.preload;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.IOException;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.download.j;
import com.ss.ugc.effectplatform.download.k;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.exception.MD5Exception;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.exception.UnzipException;
import com.ss.ugc.effectplatform.exception.UrlNotExistException;
import com.ss.ugc.effectplatform.task.b1;
import com.ss.ugc.effectplatform.util.r;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final INetworkClient a;
    public final k b;
    public final j c;
    public final DownloadType d;

    public static final class a {
        public k a;
        public INetworkClient b;
        public DownloadType c;
        public j d;

        public a() {
        }
    }

    public static final class b {
    }

    static {
    }

    public final void b(String r4, long r5) {
        Logger r0 = Logger.INSTANCE;
        StringBuilder r1 = new StringBuilder();
        DownloadType r2 = this.d;
        if (r2 == null) goto L5;
        String r3 = r2.name();
    L6:
        r1.append(r3);
        r1.append("-->");
        r1.append(r4);
        r1.append(" , cost ");
        r1.append(r5);
        r1.append(" mills.");
        r0.d("DownloadManager", r1.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }

    public d(INetworkClient r1, k r2, j r3, DownloadType r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a(String r22, String r23, List r24, long r25, String r27, b1.c r28) {
        Logger r2 = Logger.INSTANCE;
        r2.d("DownloadManager", "downloadUrl=" + r22 + " start");
        com.ss.ugc.effectplatform.download.g r12 = new com.ss.ugc.effectplatform.download.g();
        int r0 = b0.a.a;
        long r16 = System.currentTimeMillis();
        if ((!r.b(r22)) == true) goto L5;
    L79:
        Logger.e$default(r2, "JKL", "[错误][下载][下载链接:" + r22 + "][下载文件地址:" + r23 + ']', null, 4, null);
        r12.a = System.currentTimeMillis() - r16;
        r12.f = new UrlNotExistException("invalid url");
        b("download failed! url: ".concat(r22), r12.a);
        r28.a(r12);
        new NetResponse(-1, new EmptyByteReadStream(), -1, null, 8, null);
        return;
    L5:
        if (r.b(r23) == true) goto L79;
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("ParamsNetLimit", Long.valueOf(r25));
        NetRequest r1 = new NetRequest(r22, r24, HTTPMethod.GET, null, null, null, false, r10, 56, null);
        com.ss.ugc.effectplatform.bridge.network.b r4 = this.a;     // Catch: Exception -> L16
        if ((r4 instanceof com.ss.ugc.effectplatform.bridge.network.b) == false) goto L14;
        if (r4 == null) goto L13;
        NetResponse r3 = r4.a(r1, r23, r27, r28);     // Catch: Exception -> L16
    L18:
        if (r3 != null) goto L20;
    L23:
        if (r3 != null) goto L25;
    L28:
        if (r3 != null) goto L30;
    L67:
        int r5 = b0.a.a;
        r12.a = System.currentTimeMillis() - r16;
        if (r3 == null) goto L74;
        int r6 = r3.getStatusCode();
        String r7 = r3.getErrorMsg();
        if (r7 != null) goto L73;
        r7 = "status code is " + r3.getStatusCode();
    L73:
        r12.f = new NetException(r6, r7);
    L74:
        b("fetchFromNetwork failed! url: ".concat(r22), r12.a);
        r28.a(r12);
        if (r3 != null) goto L87;
        new NetResponse(-1, new EmptyByteReadStream(), -1, null, 8, null);
        return;
    L87:
        return;
    L30:
        if (r3.getStatusCode() != 200) goto L67;
        int r8 = b0.a.a;
        r12.b = System.currentTimeMillis() - r16;
        b("fetchInputStream success! url: ".concat(r22), r12.b);
        this.b.a(new com.ss.ugc.effectplatform.download.d(r3.getBodyStream()), r3.getContentLength(), null);     // Catch: Exception -> L57
        com.ss.ugc.effectplatform.util.i r9 = com.ss.ugc.effectplatform.util.i.a;
        r12.e = com.ss.ugc.effectplatform.util.i.f(r23);
        r12.c = System.currentTimeMillis() - r16;
        b("writeToDisk success! url: ".concat(r22), r12.c);
        j r11 = this.c;
        if (r11 != null) goto L38;
        long r13 = System.currentTimeMillis() - r16;
        r12.a = r13;
        b("unnecessary to unzip, download success", r13);
        r28.a(r12);
        return;
    L38:
        long r14 = System.currentTimeMillis();
        boolean r15 = r11.a(r23);     // Catch: Exception -> L45
        String r17 = FileManager.a;     // Catch: Exception -> L45
        FileManager.o(r23);     // Catch: Exception -> L45
        r12.d = System.currentTimeMillis() - r14;
        r12.a = System.currentTimeMillis() - r16;
        if (r15 == false) goto L43;
        b("unzip success! url: ".concat(r22), r12.d);
        b("download success! url: ".concat(r22), r12.a);
        r28.a(r12);
        return;
    L43:
        r12.f = new UnzipException("unzip file failed!");
        b("unzip failed! url: ".concat(r22), r12.d);
        b("download failed! url: ".concat(r22), r12.a);
        r28.a(r12);
        r3.setContentLength(-1);
        return;
    L45:
        e = move-exception;
        if ((e instanceof MD5Exception) == false) goto L49;
    L56:
        throw e;
    L49:
        if ((e instanceof CurrentEditingException) == true) goto L56;
        if ((e instanceof IOException) == true) goto L56;
        if ((e instanceof UnzipException) == true) goto L56;
        throw new UnzipException(Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
    L57:
        e = move-exception;
        if ((e instanceof MD5Exception) == false) goto L61;
    L66:
        throw e;
    L61:
        if ((e instanceof CurrentEditingException) == true) goto L66;
        if ((e instanceof IOException) == true) goto L66;
        throw new IOException(Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
    L25:
        if (r3.getStatusCode() != 600) goto L28;
        r12.f = new NetException(10001, "Cancel download");
        r12.e = -3;
        r28.a(r12);
        return;
    L20:
        if (r3.getStatusCode() != 206) goto L23;
        r12.f = new NetException(10019, "Pause download");
        r12.e = -2;
        r28.a(r12);
        return;
    L13:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.bridge.network.INetworkClientEx");     // Catch: Exception -> L16
    L14:
        r3 = r4.fetchFromNetwork(r1);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        r12.f = new NetException(400, Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
        r3 = null;
        goto L18
    }
}
