package com.ss.ugc.effectplatform.download;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.IOException;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.exception.MD5Exception;
import com.ss.ugc.effectplatform.exception.NetException;
import com.ss.ugc.effectplatform.exception.UnzipException;
import com.ss.ugc.effectplatform.exception.UrlNotExistException;
import com.ss.ugc.effectplatform.util.r;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public final INetworkClient a;
    public final k b;
    public final j c;
    public final DownloadType d;
    public final String e;

    public static final class a {
        public k a;
        public INetworkClient b;
        public DownloadType c;
        public j d;
        public String e;

        public a() {
        }

        public final f a() {
            if (this.b == null) goto L17;
            if (this.a == null) goto L15;
            INetworkClient r2 = this.b;
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("networkClient");
        L9:
            k r3 = this.a;
            if (r3 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("writeDisk");
        L13:
            return new f(r2, r3, this.d, this.c, this.e);
        L15:
            throw new IllegalArgumentException("cacheStrategy is required to setup!");
        L17:
            throw new IllegalArgumentException("networkClient is required to setup!");
        }
    }

    public static final class b {
    }

    static {
    }

    public final long a(String r23, e r24) {
        Logger.INSTANCE.d("DownloadManager", "downloadUrl=" + r23 + " start");
        g r15 = new g();
        int r0 = b0.a.a;
        long r16 = System.currentTimeMillis();
        if ((!r.b(r23)) == false) goto L64;
        r24.onStart();
        NetResponse r1 = this.a.fetchFromNetwork(new NetRequest(r23, null, HTTPMethod.GET, null, null, null, false, null, 186, null));     // Catch: Exception -> L7
    L9:
        if (r1 != null) goto L11;
    L55:
        int r2 = b0.a.a;
        r15.a = System.currentTimeMillis() - r16;
        if (r1 == null) goto L62;
        int r3 = r1.getStatusCode();
        String r4 = r1.getErrorMsg();
        if (r4 != null) goto L61;
        r4 = "status code is " + r1.getStatusCode();
    L61:
        r15.f = new NetException(r3, r4);
    L62:
        c("fetchFromNetwork failed! url: " + r23, r15.a);
        r24.a(r15);
        return -1;
    L11:
        if (r1.getStatusCode() != 200) goto L55;
        int r5 = b0.a.a;
        r15.b = System.currentTimeMillis() - r16;
        c("fetchInputStream success! url: " + r23, r15.b);
        long r6 = System.currentTimeMillis();
        String r7 = this.b.a(new d(r1.getBodyStream()), r1.getContentLength(), r24);     // Catch: Exception -> L45
        if (r7 == null) goto L44;
        com.ss.ugc.effectplatform.util.i r8 = com.ss.ugc.effectplatform.util.i.a;     // Catch: Exception -> L45
        long r9 = com.ss.ugc.effectplatform.util.i.f(r7);     // Catch: Exception -> L45
        r15.e = r9;
        r15.c = System.currentTimeMillis() - r6;
        if (r9 <= 0) goto L42;
        c("writeToDisk success! url: " + r23, r15.c);
        j r10 = this.c;
        if (r10 != null) goto L23;
        long r11 = System.currentTimeMillis() - r16;
        r15.a = r11;
        c("unnecessary to unzip, download success", r11);
        r24.a(r15);
        return r9;
    L23:
        long r12 = System.currentTimeMillis();
        boolean r13 = r10.a(r7);     // Catch: Exception -> L30
        r15.d = System.currentTimeMillis() - r12;
        r15.a = System.currentTimeMillis() - r16;
        if (r13 == false) goto L28;
        c("unzip success! url: " + r23, r15.d);
        c("download success! url: " + r23, r15.a);
        r24.a(r15);
        return r9;
    L28:
        r15.f = new UnzipException("unzip file failed!");
        c("unzip failed! url: " + r23, r15.d);
        c("download failed! url: " + r23, r15.a);
        r24.a(r15);
        return -1;
    L30:
        e = move-exception;
        if ((e instanceof MD5Exception) == false) goto L34;
        throw e;
    L34:
        if ((e instanceof CurrentEditingException) == false) goto L36;
        throw e;
    L36:
        if ((e instanceof IOException) == false) goto L38;
        throw e;
    L38:
        if ((e instanceof UnzipException) == false) goto L40;
        throw e;
    L40:
        throw new UnzipException(Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
    L42:
        c("writeToDisk failed! url: " + r23, r15.c);
        r15.a = System.currentTimeMillis() - r16;
        r15.f = new IOException("write file to disk failed!");
        r24.a(r15);
        return r9;
    L44:
        return -1;
    L45:
        e = move-exception;
        if ((e instanceof MD5Exception) == false) goto L49;
    L54:
        throw e;
    L49:
        if ((e instanceof CurrentEditingException) == true) goto L54;
        if ((e instanceof IOException) == true) goto L54;
        throw new IOException(Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
    L7:
        e = move-exception;
        r15.f = new NetException(400, Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
        r1 = null;
        goto L9
    L64:
        r15.a = System.currentTimeMillis() - r16;
        r15.f = new UrlNotExistException("invalid url");
        c("download failed! url: " + r23, r15.a);
        r24.a(r15);
        return -1;
    }

    public final void c(String r4, long r5) {
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

    public f(INetworkClient r1, k r2, j r3, DownloadType r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final NetResponse b(String r23, String r24, List<String> r25, String r26, e r27) {
        Logger r2 = Logger.INSTANCE;
        r2.d("DownloadManager", "downloadUrl=" + r23 + " start");
        g r15 = new g();
        int r0 = b0.a.a;
        long r16 = System.currentTimeMillis();
        if (r24 == null) goto L5;
        String r12 = r24;
    L7:
        if ((!r.b(r23)) == true) goto L9;
    L96:
        Logger.e$default(r2, "JKL", "[错误][下载][下载链接:" + r23 + "][下载文件地址:" + r12 + ']', null, 4, null);
        r15.a = System.currentTimeMillis() - r16;
        r15.f = new UrlNotExistException("invalid url");
        StringBuilder r1 = new StringBuilder("download failed! url: ");
        r1.append(r23);
        c(r1.toString(), r15.a);
        r27.a(r15);
        return new NetResponse(-1, new EmptyByteReadStream(), -1, null, 8, null);
    L9:
        if (r.b(r12) == true) goto L96;
        r27.onStart();
        String r28 = r12;
        NetRequest r3 = new NetRequest(r23, r25, HTTPMethod.GET, null, null, null, false, null, 184, null);
        com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a r4 = com.ss.ugc.effectplatform.cache.disklrucache.a.w;
        com.ss.ugc.effectplatform.util.i r5 = com.ss.ugc.effectplatform.util.i.a;
        String r6 = com.ss.ugc.effectplatform.util.i.e(r28);
        if (r6 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r4.getClass();
        String r7 = com.ss.ugc.effectplatform.util.i.g(r28) + FileManager.a + com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r6);
        INetworkClient r8 = this.a;     // Catch: Exception -> L23
        if ((r8 instanceof com.ss.ugc.effectplatform.bridge.network.b) == false) goto L21;
        if (r8 == null) goto L20;
        NetResponse r9 = ((com.ss.ugc.effectplatform.bridge.network.b) r8).a(r3, r7, r26, r27);     // Catch: Exception -> L23
    L25:
        if (r9 != null) goto L27;
    L29:
        if (r9 != null) goto L31;
    L33:
        if (r9 != null) goto L35;
    L84:
        int r10 = b0.a.a;
        r15.a = System.currentTimeMillis() - r16;
        if (r9 == null) goto L91;
        int r11 = r9.getStatusCode();
        String r13 = r9.getErrorMsg();
        if (r13 != null) goto L90;
        r13 = "status code is " + r9.getStatusCode();
    L90:
        r15.f = new NetException(r11, r13);
    L91:
        c("fetchFromNetwork failed! url: " + r23, r15.a);
        r27.a(r15);
        if (r9 == null) goto L95;
        return r9;
    L95:
        return new NetResponse(-1, new EmptyByteReadStream(), -1, null, 8, null);
    L35:
        if (r9.getStatusCode() != 200) goto L84;
        int r14 = b0.a.a;
        r15.b = System.currentTimeMillis() - r16;
        c("fetchInputStream success! url: " + r23, r15.b);
        this.b.a(new d(r9.getBodyStream()), r9.getContentLength(), r27);     // Catch: Exception -> L74
        com.ss.ugc.effectplatform.util.i r17 = com.ss.ugc.effectplatform.util.i.a;     // Catch: Exception -> L74
        String r18 = com.ss.ugc.effectplatform.util.i.g(r9.getFilePath());     // Catch: Exception -> L74
        if (r18 != null) goto L41;
    L51:
        r15.e = com.ss.ugc.effectplatform.util.i.f(r7);
        r15.c = System.currentTimeMillis() - r16;
        c("writeToDisk success! url: " + r23, r15.c);
        j r19 = this.c;
        if (r19 != null) goto L55;
        long r20 = System.currentTimeMillis() - r16;
        r15.a = r20;
        c("unnecessary to unzip, download success", r20);
        r27.a(r15);
        return r9;
    L55:
        long r21 = System.currentTimeMillis();
        boolean r22 = r19.a(r7);     // Catch: Exception -> L62
        String r29 = FileManager.a;     // Catch: Exception -> L62
        FileManager.o(r7);     // Catch: Exception -> L62
        r15.d = System.currentTimeMillis() - r21;
        r15.a = System.currentTimeMillis() - r16;
        if (r22 == false) goto L60;
        c("unzip success! url: " + r23, r15.d);
        c("download success! url: " + r23, r15.a);
        r27.a(r15);
    L61:
        return r9;
    L60:
        r15.f = new UnzipException("unzip file failed!");
        c("unzip failed! url: " + r23, r15.d);
        c("download failed! url: " + r23, r15.a);
        r27.a(r15);
        r9.setContentLength(-1);
    L62:
        e = move-exception;
        if ((e instanceof MD5Exception) == false) goto L66;
    L73:
        throw e;
    L66:
        if ((e instanceof CurrentEditingException) == true) goto L73;
        if ((e instanceof IOException) == true) goto L73;
        if ((e instanceof UnzipException) == true) goto L73;
        throw new UnzipException(Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
    L41:
        if (r18.length() <= 0) goto L43;
        boolean r30 = true;
    L45:
        if (r30 != true) goto L51;
        if ((!Intrinsics.areEqual(r18, com.ss.ugc.effectplatform.util.i.g(r28))) == false) goto L51;
        if (StringsKt.contains$default(r18, "effectpreload", false, 2, null) == false) goto L51;
        r17.delete(r9.getFilePath());     // Catch: Exception -> L74
        goto L51
    L43:
        r30 = false;
    L74:
        e = move-exception;
        if ((e instanceof MD5Exception) == false) goto L78;
    L83:
        throw e;
    L78:
        if ((e instanceof CurrentEditingException) == true) goto L83;
        if ((e instanceof IOException) == true) goto L83;
        throw new IOException(Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
    L31:
        if (r9.getStatusCode() != 600) goto L33;
        return r9;
    L27:
        if (r9.getStatusCode() != 206) goto L29;
        return r9;
    L20:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.bridge.network.INetworkClientEx");     // Catch: Exception -> L23
    L21:
        r9 = r8.fetchFromNetwork(r3);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        r15.f = new NetException(400, Reflection.getOrCreateKotlinClass(e.getClass()).getQualifiedName() + ':' + e.getMessage());
        r9 = null;
        goto L25
    L5:
        r12 = this.e;
        goto L7
    }
}
