package com.bytedance.awemeopen.infra.base.net.download;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetCode;
import com.bytedance.awemeopen.infra.base.net.AoNetRequest;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.net.AoNetworkEventHelper;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.util.f;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q64.c;
import q64.d;
import q64.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class BdpDownloadTask {
    public final int a;
    public final Context b;
    public final AoDownloadRequest c;
    public final AoDownloadCallback d;
    public final AtomicInteger e;
    public long f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        AoLogger.g("BdpDownloadTask", new Object[]{"execute", this.c});
        AoDownloadCallback r0 = this.d;
        if (r0 == null) goto L5;
        r0.onStart(this.a);
    L5:
        FileOutputStream r2 = null;
        if (this.e.compareAndSet(1, 2) == true) goto L9;
        b(AoNetCode.NATIVE_REQUEST_EXECUTED, "task is finished", null, null);
        return;
    L9:
        File r12 = this.c.getTargetFile();
        if (r12 != null) goto L13;
        AoLogger.g("BdpDownloadTask", new Object[]{"target file is null"});
        b(-100, "target file is null", null, null);
        return;
    L13:
        Function0<String> r1 = AoNet.a;
        AoDownloadRequest r3 = this.c;
        String r4 = r3.getUrl();
        AoFromSource r5 = AoFromSource.download;
        Intrinsics.checkNotNullParameter(r4, "httpUrl");
        Intrinsics.checkNotNullParameter(r5, "fromSource");
        new ArrayList();
        AoRequestType.a r6 = AoRequestType.Companion;
        HashMap r7 = new HashMap();
        AoRequestType r8 = r3.getRequestLibType();
        Intrinsics.checkNotNullParameter(r8, "libType");
        boolean r21 = r3.getAddBdpCommonParams();
        boolean r19 = r3.getAddHostCommonParams();
        boolean r18 = r3.getAddHostSecurityParams();
        long r26 = r3.getTimeout();
        long r28 = r3.getTimeout();
        long r30 = r3.getTimeout();
        c r9 = r3.getHeaders();
        Intrinsics.checkNotNullParameter(r9, "headers");
        Intrinsics.checkNotNullParameter(r9, "headers");
        ArrayList r10 = new ArrayList(r9.a);
        d r25 = r3.getBody();
        Intrinsics.checkNotNullParameter("GET", "method");
        AoNetResponse r13 = AoNet.d(new AoNetRequest(r4, "GET", r5, true, r18, r19, false, r21, new c(r10), true, r8, r25, r26, r28, r30, true, null, r3.getEnableHttp2(), r7)).execute();
        if (r13.getThrowable() == null) goto L18;
        b(r13.getCode(), r13.getMessage(), r13, r13.getThrowable());
        return;
    L18:
        if (this.c.getVerifyHttpCode() == true) goto L20;
    L23:
        e r14 = r13.getBody();
        if (r14 != null) goto L28;
        AoLogger.c("BdpDownloadTask", new Object[]{"responseBody is null"});
        b(AoNetCode.NETWORK_NO_BODY, "response has no body", r13, null);
        return;
    L28:
        if (this.c.getMaxLength() <= 0) goto L160;
        if (r13.contentLength() <= this.c.getMaxLength()) goto L160;
        b(AoNetCode.NATIVE_EXCEED_MAX_SIZE, "response body exceed max size " + this.c.getMaxLength(), r13, null);
        return;
    L160:
        File r11 = new PolarisFileWrapper(this.b.getCacheDir(), "bdp/download/" + System.currentTimeMillis() + '_' + this.a + ".tmp");     // Catch: Exception -> L45
        File r15 = r11.getParentFile();     // Catch: Exception -> L45
        if (r15 != null) goto L37;
    L39:
        boolean r16 = false;
    L40:
        if (r16 == false) goto L44;
        File r17 = r11.getParentFile();     // Catch: Exception -> L45
        if (r17 == null) goto L44;
        r17.mkdirs();     // Catch: Exception -> L45
    L44:
        File r20 = r11;
    L47:
        int r22 = -1;
        if (r20 != null) goto L51;
        AoLogger.c("BdpDownloadTask", new Object[]{"createTempFile is null"});
        b(-1, "create temp file failed", r13, null);
        return;
    L51:
        long r110 = r14.b();
        byte[] r23 = new byte[2048];
        long r111 = 0;
        FileOutputStream r24 = new PolarisFileOutputStreamWrapper(r20);     // Catch: Throwable -> L135
        AoDownloadCallback r27 = this.d;     // Catch: Throwable -> L132
        if (r27 != null) goto L158;
        File r29 = r20;
        String r210 = "BdpDownloadTask";
        FileOutputStream r112 = r24;
    L61:
        int r31 = r14.read(r23);     // Catch: Throwable -> L130
        if (r31 <= 0) goto L77;
        r112.write(r23, 0, r31);     // Catch: Throwable -> L130
        r112.flush();     // Catch: Throwable -> L130
        r111 = r111 + ((long) r31);     // Catch: Throwable -> L130
        AoDownloadCallback r32 = this.d;     // Catch: Throwable -> L130
        if (r32 == null) goto L66;
        d(r32, this.a, r111, r110);     // Catch: Throwable -> L130
    L66:
        long r33 = this.c.getMaxLength();     // Catch: Throwable -> L130
        if (1 <= r33) goto L69;
    L71:
        boolean r34 = false;
    L72:
        if (r34 == false) goto L61;
        f.delete(r29);     // Catch: Throwable -> L130
        b(AoNetCode.NATIVE_EXCEED_MAX_SIZE, "response body exceed max size " + this.c.getMaxLength(), r13, null);     // Catch: Throwable -> L130
        f.a(r112);
        f.a(r14);
        return;
    L130:
        th = th;
    L76:
        File r35 = r29;
        String r36 = r210;
    L134:
        r22 = -1;
        r2 = r112;
    L162:
        AoLogger.c(r36, new Object[]{th});     // Catch: Throwable -> L144
        f.delete(r35);     // Catch: Throwable -> L144
        String r37 = th.getMessage();     // Catch: Throwable -> L144
        if (r37 != null) goto L141;
        r37 = "throwable";
    L141:
        b(r22, r37, r13, th);     // Catch: Throwable -> L144
        f.a(r2);
        f.a(r14);
        return;
    L144:
        th = move-exception;
        f.a(r2);
        f.a(r14);
        throw th;
    L69:
        if (r33 >= r111) goto L71;
        r34 = true;
        goto L72
    L77:
        f.a(r112);
        f.a(r14);
        String r38 = this.c.getMd5();
        if (r38 != null) goto L80;
    L86:
        boolean r39 = false;
    L87:
        if (r39 == true) goto L156;
        File r40 = r29;
    L166:
        File r41 = r12.getParentFile();     // Catch: Throwable -> L127
        if (r41 == null) goto L116;
        r41.mkdirs();     // Catch: Throwable -> L127
    L116:
        if (r12.exists() == false) goto L119;
        r12.delete();     // Catch: Throwable -> L127
    L119:
        if (r40.exists() == true) goto L121;
        AoLogger.c(r210, new Object[]{"temp file not exist", r40, r12});     // Catch: Throwable -> L127
        b(-1, "temp file not exist", r13, null);     // Catch: Throwable -> L127
    L125:
        f.delete(r40);
        return;
    L121:
        String r42 = r210;
        if (c(r40, r12) == true) goto L124;
        AoLogger.c(r42, new Object[]{"move file failed", r40, Long.valueOf(r40.length()), r12});     // Catch: Throwable -> L127
        b(-1, "move target file failed", r13, null);     // Catch: Throwable -> L127
        goto L125
    L124:
        e(r12, r13);     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        f.delete(r40);
        throw th;
    L156:
        MessageDigest r43 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L104
        r40 = r29;
        PolarisFileInputStreamWrapper r44 = new PolarisFileInputStreamWrapper(r40);     // Catch: FileNotFoundException -> L147
        byte[] r45 = new byte[8192];
    L150:
        int r46 = r44.read(r45);     // Catch: Throwable -> L97 IOException -> L99
        if (r46 <= 0) goto L95;
        r43.update(r45, 0, r46);     // Catch: Throwable -> L97 IOException -> L99
        goto L150
    L95:
        String r47 = String.format("%32s", new Object[]{new BigInteger(1, r43.digest()).toString(16)}).replace(' ', '0');     // Catch: Throwable -> L97 IOException -> L99
        f.a(r44);
    L107:
        if (Intrinsics.areEqual(r47, this.c.getMd5()) == true) goto L166;
        f.delete(r40);
        b(-1, "md5 verify failed", r13, null);
        return;
    L97:
        th = move-exception;
        f.a(r44);
        throw th;
    L99:
        e = move-exception;
        throw new RuntimeException("Unable to process MD5", e);     // Catch: Throwable -> L97
    L105:
        r47 = null;
    L104:
        r40 = r29;
        goto L105
    L80:
        if (r38.length() <= 0) goto L82;
        boolean r48 = true;
    L84:
        if (r48 != true) goto L86;
        r39 = true;
        goto L87
    L82:
        r48 = false;
        goto L84
    L158:
        r29 = r20;
        r210 = "BdpDownloadTask";
        r112 = r24;
        d(r27, this.a, 0, r110);     // Catch: Throwable -> L130
    L58:
        th = th;
        r29 = r20;
        r210 = "BdpDownloadTask";
        r112 = r24;
    L132:
        th = th;
        r35 = r20;
        r36 = "BdpDownloadTask";
        r112 = r24;
    L135:
        th = th;
        r35 = r20;
        r36 = "BdpDownloadTask";
        goto L162
    L37:
        if (r15.exists() == true) goto L39;
        r16 = true;
    L45:
        e = move-exception;
        AoLogger.c("BdpDownloadTask", new Object[]{"createTempFile", e});
        r20 = null;
        goto L47
    L20:
        if (r13.isSuccessful() == true) goto L23;
        b(r13.getCode(), r13.getMessage(), r13, null);
    }

    public static boolean c(PolarisFileWrapper r6, File r7) {
        if (r6.renameTo(r7) == false) goto L5;
        return true;
    L5:
        char r2 = 2;
        AoLogger.g("BdpDownloadTask", new Object[]{"copy", r6, r7});
        File r0 = r7.getParentFile();
        if (r0 != null) goto L8;
    L10:
        PolarisFileOutputStreamWrapper r1 = null;
    L37:
        PolarisFileOutputStreamWrapper r8 = null;
    L38:
        f.a(r1);
        f.a(r8);
        r2 = 1;
    L39:
        if (r2 == 0) goto L52;
        return false;
    L52:
        return true;
    L35:
        PolarisFileOutputStreamWrapper r9 = null;
    L36:
        f.a(r1);
        f.a(r9);
    L31:
        th = th;
        PolarisFileOutputStreamWrapper r10 = null;
    L33:
        f.a(r1);
        f.a(r10);
        throw th;
    L12:
        if (r7.exists() == true) goto L14;
        r7.createNewFile();     // Catch: Throwable -> L31 IOException -> L35 FileNotFoundException -> L37
    L14:
        PolarisFileOutputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r6);     // Catch: Throwable -> L31 IOException -> L35 FileNotFoundException -> L37
    L47:
        PolarisFileOutputStreamWrapper r5 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L27 IOException -> L43 FileNotFoundException -> L44
    L49:
        byte[] r11 = new byte[4096];     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L26
    L18:
        int r3 = r4.read(r11);     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L26
        if (r3 <= 0) goto L21;
        r5.write(r11, 0, r3);     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L26
        goto L18
    L21:
        r6.delete();     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L26
        f.a(r4);
        f.a(r5);
        r2 = 0;
        goto L39
    L26:
        r1 = r5;
    L25:
        r1 = r5;
    L23:
        th = th;
        r1 = r5;
    L28:
        r10 = r1;
        r1 = r4;
    L27:
        th = th;
    L30:
        r8 = r1;
        r1 = r4;
    L29:
        r9 = r1;
        r1 = r4;
        goto L36
    L8:
        if (r0.exists() == true) goto L10;
        r0.mkdirs();
        goto L10
    }

    public final AoDownloadResponse e(File r16, AoNetResponse r17) {
        AoLogger.g("BdpDownloadTask", new Object[]{"success", r16, r17, this.e});
        AoDownloadResponse r2 = new AoDownloadResponse(r17.getCode(), r17.getMessage(), r16, r17.getHeaders(), r17.contentLength(), r17.getThrowable(), r17.getLibType(), r17.getMetric());
        if (this.e.compareAndSet(2, 3) == false) goto L8;
        AoDownloadCallback r1 = this.d;
        if (r1 == null) goto L12;
        r1.onFinish(this.a, this.c, r2);
    L12:
        AoNetworkEventHelper.INSTANCE.mpDownloadMonitor(this.c, r2, this.e.get());
        return r2;
    L8:
        if (this.e.get() != 4) goto L12;
        AoDownloadCallback r3 = this.d;
        if (r3 == null) goto L12;
        r3.onCancel(this.a, this.c);
        goto L12
    }

    public BdpDownloadTask(int r2, Context r3, AoDownloadRequest r4, AoDownloadCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "downloadRequest");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new AtomicInteger(1);
    }

    public final AoDownloadResponse b(int r16, String r17, AoNetResponse r18, Throwable r19) {
        AoLogger.g("BdpDownloadTask", new Object[]{"failed", Integer.valueOf(r16), r17, r18, r19, this.e});
        if (r18 == null) goto L6;
        c r1 = r18.getHeaders();
        if (r1 == null) goto L6;
    L7:
        c r5 = r1;
        if (r18 == null) goto L10;
        long r2 = r18.contentLength();
    L11:
        long r6 = r2;
        if (r19 != null) goto L19;
        if (r18 == null) goto L15;
        Throwable r3 = r18.getThrowable();
    L16:
        if (r3 != null) goto L18;
        r3 = new Exception(r17);
    L18:
        Throwable r8 = r3;
    L20:
        AoRequestType r9 = this.c.getRequestLibType();
        if (r18 == null) goto L24;
        AoNetworkMetric r4 = r18.getMetric();
        if (r4 == null) goto L24;
    L25:
        AoDownloadResponse r14 = new AoDownloadResponse(r16, r17, null, r5, r6, r8, r9, r4);
        if (this.e.compareAndSet(2, 3) == false) goto L31;
        AoDownloadCallback r7 = this.d;
        if (r7 == null) goto L35;
        r7.onFinish(this.a, this.c, r14);
    L35:
        AoNetworkEventHelper.INSTANCE.mpDownloadMonitor(this.c, r14, this.e.get());
        return r14;
    L31:
        if (this.e.get() != 4) goto L35;
        AoDownloadCallback r10 = this.d;
        if (r10 == null) goto L35;
        r10.onCancel(this.a, this.c);
    L24:
        r4 = new AoNetworkMetric();
        goto L25
    L15:
        r3 = null;
        goto L16
    L19:
        r8 = r19;
        goto L20
    L10:
        r2 = 0;
    L6:
        r1 = c.b;
        goto L7
    }

    public final void d(final AoDownloadCallback r11, final int r12, final long r13, final long r15) {
        if (this.e.get() == 2) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - this.f) >= 100) goto L8;
        return;
    L8:
        this.f = System.currentTimeMillis();
        AoPool.b(new BdpDownloadTask$progress$1(this, r11, r12, r13, r15));
    }
}
