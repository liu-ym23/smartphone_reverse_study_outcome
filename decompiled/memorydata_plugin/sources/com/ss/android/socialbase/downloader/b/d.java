package com.ss.android.socialbase.downloader.b;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.downloader.b.a.i;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f15282a = "DownloadSingleResponseHandler";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DownloadInfo f15283b;
    private h c;
    private w d;
    private com.ss.android.socialbase.downloader.network.h e;
    private com.ss.android.socialbase.downloader.g.a f;
    private long g;
    private long h;
    private com.ss.android.socialbase.downloader.h.d i;
    private boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;

    static {
    }

    public d(i r3, com.ss.android.socialbase.downloader.network.h r4, long r5, long r7, com.ss.android.socialbase.downloader.h.d r9) {
        com.ss.android.socialbase.downloader.network.h r6 = (com.ss.android.socialbase.downloader.network.h) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.socialbase.downloader.network.h.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.h.d r10 = (com.ss.android.socialbase.downloader.h.d) ZeusTransformUtils.wrapperContextForParams(r9, com.ss.android.socialbase.downloader.h.d.class, "com.obric.memorydata.plugin");
        this.j = true;
        this.f15283b = r3.c;
        this.c = r3.f15271a;
        this.d = r3.m;
        this.f = r3.d;
        this.e = r6;
        this.g = r5;
        this.h = r7;
        this.i = r10;
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.network.h a(d r0) {
        return r0.e;
    }

    private InputStream a(InputStream r6) {
        if (ZeusTransformUtils.instanceOf(r6, com.ss.android.socialbase.downloader.network.a.b.class) == false) goto L5;
        com.ss.android.socialbase.downloader.network.a.b r7 = (com.ss.android.socialbase.downloader.network.a.b) ZeusTransformUtils.preCheckCast(r6, com.ss.android.socialbase.downloader.network.a.b.class, "com.obric.memorydata.plugin");
    L6:
        r7.a(this.f15283b.getThrottleNetSpeed(), this.f15283b.getThrottleSmoothness());
        return r7;
    L5:
        r7 = new com.ss.android.socialbase.downloader.network.a.a(r6, (float) this.f.a("throttle_factor_min", 0.10000000149011612d), (float) this.f.a("throttle_factor_max", 0.699999988079071d));
        goto L6
    }

    private boolean a(byte[] r5, byte[] r6, int r7) {
        if (r5 != null) goto L5;
    L16:
        return true;
    L5:
        if (r5.length < r7) goto L16;
        if (r6 == null) goto L16;
        if (r6.length < r7) goto L16;
        int r1 = 0;
    L11:
        if (r1 >= r7) goto L16;
        if (r5[r1] != r6[r1]) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    }

    private byte[] a(int r8) {
        com.ss.android.socialbase.downloader.utils.b r2 = new com.ss.android.socialbase.downloader.utils.b(new FileInputStream(new File(this.f15283b.getTempPath(), this.f15283b.getTempName())));     // Catch: Throwable -> L12
        r2.a(this.f15283b.getCurBytes(), 0);     // Catch: Throwable -> L10
        byte[] r7 = new byte[r8];     // Catch: Throwable -> L10
        if (r2.a(r7, 0, r8) == r8) goto L29;
    L25:
        r2.b();     // Catch: Throwable -> L22
    L17:
        return null;
    L29:
        r2.b();     // Catch: Throwable -> L23
    L7:
        return r7;
    L10:
        th = th;
    L27:
        th.printStackTrace();     // Catch: Throwable -> L18
        if (r2 == null) goto L17;
    L18:
        th = move-exception;
        if (r2 != null) goto L33;
    L21:
        throw th;
    L33:
        r2.b();     // Catch: Throwable -> L24
    L12:
        th = th;
        r2 = null;
        goto L27
    }

    private boolean e() {
        if (this.k == false) goto L5;
    L8:
        return true;
    L5:
        if (this.l == true) goto L8;
        return false;
    }

    private void f() {
        if (this.e != null) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.downloader.b.b(new AnonymousClass1(this), true);
    }

    private void g() {
        this.f15283b.updateRealDownloadTime(true);     // Catch: Exception -> L4
        this.c.a(this.f15283b);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.ss.android.socialbase.downloader.network.a] */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v11 */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v14 */
    /* JADX WARN: Type inference failed for: r25v15 */
    /* JADX WARN: Type inference failed for: r25v16 */
    /* JADX WARN: Type inference failed for: r25v17 */
    /* JADX WARN: Type inference failed for: r25v18 */
    /* JADX WARN: Type inference failed for: r25v19 */
    /* JADX WARN: Type inference failed for: r25v20 */
    /* JADX WARN: Type inference failed for: r25v21 */
    /* JADX WARN: Type inference failed for: r25v22 */
    /* JADX WARN: Type inference failed for: r25v23 */
    /* JADX WARN: Type inference failed for: r25v24 */
    /* JADX WARN: Type inference failed for: r25v25 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v10 */
    /* JADX WARN: Type inference failed for: r29v11, types: [com.ss.android.socialbase.downloader.network.a] */
    /* JADX WARN: Type inference failed for: r29v12 */
    /* JADX WARN: Type inference failed for: r29v13 */
    /* JADX WARN: Type inference failed for: r29v14 */
    /* JADX WARN: Type inference failed for: r29v15 */
    /* JADX WARN: Type inference failed for: r29v16 */
    /* JADX WARN: Type inference failed for: r29v17 */
    /* JADX WARN: Type inference failed for: r29v18 */
    /* JADX WARN: Type inference failed for: r29v19 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v20 */
    /* JADX WARN: Type inference failed for: r29v21 */
    /* JADX WARN: Type inference failed for: r29v22 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v6 */
    /* JADX WARN: Type inference failed for: r29v7 */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r29v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.ss.android.socialbase.downloader.network.a] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.ss.android.socialbase.downloader.network.a] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.ss.android.socialbase.downloader.network.a] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.ss.android.socialbase.downloader.network.a] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public void a() {
        ?? r2 = " isFirstRead:";
        String r3 = "Exception:";
        long r21 = g.a(this.e);
        if (r21 == 0) goto L260;
        long r9 = this.g;
        if (this.f15283b.getVerifyCurBytes() <= 0) goto L7;
        int r0 = (int) (this.f15283b.getVerifyCurBytes() - this.f15283b.getCurBytes());
        byte[] r13 = a(r0);
    L9:
        if (ZeusTransformUtils.instanceOf(this.e, com.ss.android.socialbase.downloader.network.a.class) == false) goto L11;
        ?? r11 = (com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(this.e, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin");
    L277:
        DownloadInfo r14 = this.f15283b;     // Catch: Throwable -> L170 BaseException -> L226
        com.ss.android.socialbase.downloader.model.g r12 = com.ss.android.socialbase.downloader.utils.c.a(r14, r14.getTempPath(), this.f15283b.getTempName(), -1, true);     // Catch: Throwable -> L170 BaseException -> L226
        if (this.f15283b.isFastDownload() == true) goto L24;
        long r19 = r9;
        r12.a(this.g - this.f15283b.getStartOffset());     // Catch: Throwable -> L19 IOException -> L22 BaseException -> L157
    L284:
        InputStream r8 = this.e.a();     // Catch: Throwable -> L151 BaseException -> L157
    L275:
        this.f15283b.updateRealStartDownloadTime();     // Catch: Throwable -> L145 BaseException -> L149
        boolean r10 = this.f15283b.isIgnoreDataVerify();     // Catch: Throwable -> L145 BaseException -> L149
        if (this.f15283b.getOpenLimitSpeed() == false) goto L34;
        if (r11 == 0) goto L34;
        r21 = r21;
        r11.a(com.ss.android.socialbase.downloader.constants.b.d);     // Catch: Throwable -> L32 BaseException -> L149
    L271:
    L143:
        th = th;
    L147:
        ?? r29 = r11;
    L148:
        r11 = r12;
        int r6 = 0;
        ?? r25 = r2;
        ?? r210 = r29;
    L289:
        com.ss.android.socialbase.downloader.e.a.b(f15282a, this.f15283b.getId(), "handleResponse", r3 + th.toString() + r25 + this.j);     // Catch: Throwable -> L224
        if (r210 == 0) goto L176;
        ?? r4 = r210;
        r4.a(th);     // Catch: Throwable -> L245
        r2 = r4;
    L178:
        if (e() == false) goto L287;
        if (r6 > 0) goto L285;
    L181:
        if (r11 != 0) goto L183;
    L185:
        this.e.d();
        g.a(new Closeable[]{r8});
        g.a(new Closeable[]{r11});
        if (r2 != 0) goto L188;
        return;
    L188:
        if (TextUtils.isEmpty(r2.h()) == true) goto L316;
        this.f15283b.setRequestLog(r2.h());
        if (this.f15283b.isHandleRequest() == false) goto L317;
        this.i.a(r2.h());
        return;
    L317:
        return;
    L316:
        return;
    L183:
        if (this.l == true) goto L185;
        g();
        goto L185
    L285:
        this.i.a(r6);     // Catch: Throwable -> L263
        goto L181
    L287:
        com.ss.android.socialbase.downloader.utils.c.a(th, "ResponseHandler");     // Catch: BaseException -> L221 Throwable -> L245
        if (r6 > 0) goto L267;
    L196:
        if (r11 != 0) goto L198;
    L200:
        this.e.d();
        g.a(new Closeable[]{r8});
        g.a(new Closeable[]{r11});
        if (r2 != 0) goto L203;
    L209:
        if (this.f15283b.isIgnoreDataVerify() == false) goto L211;
        return;
    L211:
        long r5 = this.g - r19;
        if (r5 < 0) goto L220;
        long r7 = this.h;
        if (r7 >= 0) goto L216;
        return;
    L216:
        if (r7 != r5) goto L219;
        return;
    L219:
        throw new BaseException(1051, String.format(Locale.US, "handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", new Object[]{Long.valueOf(r5), Long.valueOf(r21), Long.valueOf(this.h), Long.valueOf(this.f15283b.getStartOffset()), Long.valueOf(this.f15283b.getEndOffset()), Long.valueOf(this.g), Long.valueOf(r19)}));
    L220:
        return;
    L203:
        if (TextUtils.isEmpty(r2.h()) == true) goto L209;
        this.f15283b.setRequestLog(r2.h());
        if (this.f15283b.isHandleRequest() == false) goto L209;
        com.ss.android.socialbase.downloader.h.d r1 = this.i;
        String r15 = r2.h();
    L207:
        r1.a(r15);
        goto L209
    L198:
        if (this.l == true) goto L200;
        g();
        goto L200
    L267:
        this.i.a(r6);     // Catch: Throwable -> L264
        goto L196
    L221:
        e = move-exception;
        com.ss.android.socialbase.downloader.utils.c.a(this.e, e);     // Catch: Throwable -> L245
        throw e;     // Catch: Throwable -> L245
    L176:
        r2 = r210;
    L224:
        th = th;
        r2 = r210;
    L246:
        if (r6 > 0) goto L278;
    L248:
        if (r11 != 0) goto L250;
    L252:
        this.e.d();
        g.a(new Closeable[]{r8});
        g.a(new Closeable[]{r11});
        if (r2 != 0) goto L255;
        throw th;
    L255:
        if (TextUtils.isEmpty(r2.h()) == true) goto L324;
        this.f15283b.setRequestLog(r2.h());
        if (this.f15283b.isHandleRequest() == false) goto L325;
        this.i.a(r2.h());
        throw th;
    L325:
        throw th;
    L324:
        throw th;
    L250:
        if (this.l == true) goto L252;
        g();
        goto L252
    L278:
        this.i.a(r6);     // Catch: Throwable -> L265
        goto L248
    L36:
        if (this.f.a("use_default_throttle_speed", 1) != 1) goto L42;
        long r16 = this.f15283b.getThrottleNetSpeed();     // Catch: Throwable -> L32 BaseException -> L149
        if (r16 != (-1)) goto L40;
    L41:
        this.m = true;     // Catch: Throwable -> L32 BaseException -> L149
        goto L42
    L40:
        if (r16 > 0) goto L41;
    L42:
        int r17 = com.ss.android.socialbase.downloader.downloader.b.N();     // Catch: Throwable -> L143 BaseException -> L149
        if (r11 != 0) goto L45;
    L53:
        byte[] r18 = new byte[r17];     // Catch: Throwable -> L143 BaseException -> L149
        r6 = 0;
        long r23 = 0;
        ?? r20 = r2;
        ?? r110 = r11;
    L307:
        if (this.m == false) goto L58;
        this.m = false;     // Catch: Throwable -> L139 BaseException -> L141
        r8 = a(r8);     // Catch: Throwable -> L139 BaseException -> L141
    L58:
        int r111 = r8.read(r18);     // Catch: Throwable -> L139 BaseException -> L141
        if (r111 == (-1)) goto L61;
        if (r10 == true) goto L82;
        ?? r112 = r110;
        long r113 = this.h;     // Catch: Throwable -> L77 BaseException -> L80
        r2 = r20;
        r3 = r3;
        long r22 = this.g;     // Catch: Throwable -> L73 BaseException -> L75
    L68:
        if (r113 <= (r22 - r19)) goto L72;
        ?? r211 = r112;
        r2 = r2;
        r29 = r211;
        if (r113 >= ((r22 - r19) + ((long) r111))) goto L293;
        r111 = (int) (r113 - (r22 - r19));
        r2 = r2;
        r29 = r211;
    L293:
    L137:
        e = e;
    L138:
        r12 = r12;
        ?? r24 = r2;
        String r26 = r3;
        ?? r27 = r29;
    L228:
        com.ss.android.socialbase.downloader.e.a.b(f15282a, this.f15283b.getId(), "handleResponse", r26 + e.toString() + r24 + this.j);     // Catch: Throwable -> L245
        if (e() == false) goto L244;
        if (r6 > 0) goto L273;
    L232:
        if (r12 != null) goto L234;
    L236:
        this.e.d();
        g.a(new Closeable[]{r8});
        g.a(new Closeable[]{r12});
        if (r27 != 0) goto L239;
        return;
    L239:
        if (TextUtils.isEmpty(r27.h()) == true) goto L321;
        this.f15283b.setRequestLog(r27.h());
        if (this.f15283b.isHandleRequest() == false) goto L322;
        this.i.a(r27.h());
        return;
    L322:
        return;
    L321:
        return;
    L234:
        if (this.l == true) goto L236;
        g();
        goto L236
    L273:
        this.i.a(r6);     // Catch: Throwable -> L266
        goto L232
    L244:
        throw e;     // Catch: Throwable -> L245
    L135:
        th = th;
    L21:
        r11 = r12;
        r25 = r2;
        r210 = r29;
        goto L289
    L84:
        if (this.j == false) goto L92;
        this.j = false;     // Catch: Throwable -> L135 BaseException -> L137
        this.d.a();     // Catch: Throwable -> L135 BaseException -> L137
        if (this.f15283b.getVerifyCurBytes() <= 0) goto L92;
        if (a(r13, r18, r0) == true) goto L92;
        throw new BaseException(1051, "Fail to verify data");     // Catch: Throwable -> L135 BaseException -> L137
    L92:
        r12.a(r18, 0, r111);     // Catch: Throwable -> L135 BaseException -> L137
        this.g += (long) r111;     // Catch: Throwable -> L135 BaseException -> L137
        int r28 = r6 + r111;
        if (this.f15283b.isHandleRequest() == false) goto L97;
        this.i.a(r18, r111);     // Catch: Throwable -> L131 BaseException -> L133
    L97:
        long r114 = SystemClock.uptimeMillis();     // Catch: Throwable -> L131 BaseException -> L133
        if ((r114 - r23) > 1000) goto L100;
        r6 = r28;
    L111:
        if (r10 == true) goto L130;
        long r30 = this.h;     // Catch: Throwable -> L135 BaseException -> L137
        if (r30 < 0) goto L130;
        if (r30 > (this.g - r19)) goto L130;
    L117:
        if (r6 > 0) goto L282;
    L119:
        if (r12 != null) goto L121;
    L123:
        this.e.d();
        g.a(new Closeable[]{r8});
        g.a(new Closeable[]{r12});
        if (r29 == 0) goto L209;
        if (TextUtils.isEmpty(r29.h()) == true) goto L209;
        this.f15283b.setRequestLog(r29.h());
        if (this.f15283b.isHandleRequest() == false) goto L209;
        r1 = this.i;
        r15 = r29.h();
        goto L207
    L121:
        if (this.l == true) goto L123;
        g();
        goto L123
    L282:
        this.i.a(r6);     // Catch: Throwable -> L262
    L130:
        r20 = r2;
        r3 = r3;
        r110 = r29;
        goto L307
    L100:
        if (this.i.a(r28) == true) goto L291;
    L104:
        com.ss.android.socialbase.downloader.b.a.h.a(this.f15283b);     // Catch: Throwable -> L106 BaseException -> L108
        r23 = r114;
        r6 = 0;
        goto L111
    L291:
        if (this.l == true) goto L104;
        g();     // Catch: Throwable -> L106 BaseException -> L108
        goto L104
    L108:
        e = e;
        r12 = r12;
        r24 = r2;
        r26 = r3;
        r27 = r29;
        r6 = 0;
    L106:
        th = th;
        goto L148
    L133:
        e = e;
        r6 = r28;
    L131:
        th = th;
        r6 = r28;
        goto L21
    L72:
        r29 = r112;
        r2 = r2;
    L75:
        e = e;
        r12 = r12;
        r27 = r112;
        r24 = r2;
        r26 = r3;
    L73:
        th = th;
    L79:
        r29 = r112;
        goto L21
    L80:
        e = e;
        ?? r31 = r20;
        ?? r32 = r112;
    L160:
        r26 = r3;
        r27 = r32;
        r24 = r31;
    L77:
        th = th;
        r2 = r20;
        r3 = r3;
        goto L79
    L82:
        r2 = r20;
        r3 = r3;
        r29 = r110;
        goto L293
    L61:
        r29 = r110;
        goto L117
    L141:
        e = e;
        ?? r33 = r20;
        ?? r34 = r110;
    L159:
        r32 = r34;
        r31 = r33;
    L139:
        th = th;
        r2 = r20;
        r3 = r3;
        r29 = r110;
        goto L21
    L45:
        if (r11.f() == false) goto L47;
        r17 = com.ss.android.socialbase.downloader.constants.b.f;     // Catch: Throwable -> L32 BaseException -> L149
    L47:
        List<Pair<String, String>> r35 = r11.g();     // Catch: Throwable -> L32 BaseException -> L149
        if (r35 == null) goto L51;
        this.f15283b.setHttpResponseHeader(r35.toString());     // Catch: Throwable -> L32 BaseException -> L149
    L51:
        if (this.f15283b.isHandleRequest() == false) goto L53;
        this.i.a(r35);     // Catch: Throwable -> L32 BaseException -> L149
    L32:
        th = th;
        r2 = " isFirstRead:";
        r3 = "Exception:";
        r29 = r11;
        r6 = 0;
    L34:
        r21 = r21;
    L145:
        th = th;
        r21 = r21;
    L149:
        e = e;
        r33 = " isFirstRead:";
        r34 = r11;
        r6 = 0;
    L151:
        th = th;
    L155:
        ?? r212 = r11;
    L156:
        r11 = r12;
        r6 = 0;
        r8 = null;
        r25 = r2;
        r210 = r212;
        goto L289
    L22:
        e = e;
    L163:
        r212 = r11;
    L168:
        e = e;
        r12 = r12;
        r24 = r2;
        r26 = r3;
        r27 = r212;
        r6 = 0;
        r8 = null;
    L166:
        th = th;
        goto L156
    L165:
        throw new BaseException(1054, e);     // Catch: Throwable -> L166 BaseException -> L168
    L19:
        th = th;
        r2 = " isFirstRead:";
        r3 = "Exception:";
        r21 = r21;
        r29 = r11;
        r6 = 0;
        r8 = null;
        goto L21
    L24:
        r19 = r9;
        goto L284
    L157:
        e = e;
        r33 = " isFirstRead:";
        r34 = r11;
        r6 = 0;
        r8 = null;
    L161:
        e = e;
        r19 = r9;
    L153:
        th = th;
        r19 = r9;
        goto L155
    L245:
        th = th;
    L226:
        e = e;
        r24 = " isFirstRead:";
        r26 = "Exception:";
        r27 = r11;
        r6 = 0;
        r8 = null;
        r12 = null;
    L170:
        th = th;
        r25 = " isFirstRead:";
        r3 = "Exception:";
        r21 = r21;
        r19 = r9;
        r210 = r11;
        r6 = 0;
        r8 = null;
        r11 = 0;
        goto L289
    L11:
        r11 = 0;
        goto L277
    L7:
        r0 = 0;
        r13 = null;
        goto L9
    L260:
        this.e.d();
        throw new DownloadRetryNeedlessException(1004, "the content-length is 0");
    }

    public void a(long r2, int r4) {
        this.f15283b.setThrottleNetSpeed(r2, r4);
        this.m = true;
    }

    public void b() {
        if (this.k == false) goto L5;
        return;
    L5:
        this.k = true;
        f();
    }

    public void c() {
        if (this.l == false) goto L5;
        return;
    L5:
        this.l = true;
        f();
    }

    public long d() {
        return this.g;
    }
}
