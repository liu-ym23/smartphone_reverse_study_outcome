package com.ss.android.socialbase.downloader.segment;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.ss.android.socialbase.downloader.downloader.v;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
class l implements Runnable {
    private volatile boolean A;
    private Thread B;
    private volatile boolean C;
    private int D;
    private int E;
    private int F;
    private w G;
    private v H;
    private long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f15628J;
    private boolean K;
    private BaseException L;
    private boolean M;
    private boolean N;
    private com.ss.android.socialbase.downloader.utils.f O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile i f15629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    o f15630b;
    final int c;
    volatile long d;
    volatile long e;
    volatile long f;
    volatile long g;
    String h;
    String i;
    String j;
    private final f k;
    private final c l;
    private final DownloadTask m;
    private final DownloadInfo n;
    private final com.ss.android.socialbase.downloader.g.a o;
    private com.ss.android.socialbase.downloader.network.h p;
    private com.ss.android.socialbase.downloader.model.f q;
    private final List<i> r;
    private long s;
    private volatile long t;
    private volatile long u;
    private volatile long v;
    private volatile long w;
    private Future x;
    private volatile boolean y;
    private volatile boolean z;

    l(DownloadTask r3, DownloadInfo r4, j r5, c r6, o r7, int r8) {
        c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
        this.r = new ArrayList();
        this.v = -1;
        this.m = r3;
        this.n = r4;
        this.k = r5;
        this.l = r9;
        this.o = com.ss.android.socialbase.downloader.g.a.a(r4.getId());
        this.f15630b = r7;
        this.c = r8;
        this.G = new w(r4);
        this.H = new v(r4);
    }

    private a a(c r5, InputStream r6) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        a r7 = r4.b();
        int r8 = r6.read(r7.f15611a);     // Catch: Throwable -> L13
        if (r8 == (-1)) goto L12;
        r7.c = r8;     // Catch: Throwable -> L9
        if (r8 != (-1)) goto L8;
        r4.a(r7);
    L8:
        return r7;
    L12:
        throw new BaseException(1073, "probe");     // Catch: Throwable -> L9
    L9:
        th = th;
    L15:
        if (r8 != (-1)) goto L17;
        r4.a(r7);
    L17:
        throw th;
    L13:
        th = th;
        r8 = -1;
        goto L15
    }

    private boolean a(BaseException r3) {
        if (com.ss.android.socialbase.downloader.utils.c.c(r3) == true) goto L5;
        return false;
    L5:
        String r4 = this.f15630b.f15633a;
        if (TextUtils.isEmpty(r4) == false) goto L8;
    L18:
        return false;
    L8:
        if (r4.startsWith(LocationInfoConst.HTTPS) == false) goto L18;
        if (this.n.isNeedHttpsToHttpRetry() == true) goto L14;
        return false;
    L14:
        if (this.K == false) goto L16;
        return false;
    L16:
        this.K = true;
        l();
        return true;
    }

    private boolean a(i r7) {
        k();
    L48:
        b(r7);     // Catch: Throwable -> L6 SegmentApplyException -> L37
        d(r7);     // Catch: Throwable -> L6 SegmentApplyException -> L37
    L4:
        i();
        return true;
    L37:
        e = move-exception;
        this.L = e;     // Catch: Throwable -> L40
        throw e;     // Catch: Throwable -> L40
    L6:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("SegmentReader", this.n.getId(), "download", "e = " + th + ", threadIndex = " + this.c + ", reconnect = " + this.z + ", closed = " + this.y);     // Catch: Throwable -> L40
        if (this.y == true) goto L10;
        if (this.z == false) goto L24;
        this.z = false;     // Catch: Throwable -> L40
        Thread.interrupted();     // Catch: Throwable -> L17
    L20:
        if (this.A == false) goto L21;
        this.A = false;     // Catch: Throwable -> L40
        throw new SegmentApplyException(5, "download");     // Catch: Throwable -> L40
    L21:
        i();
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L40
        goto L20
    L24:
        BaseException e = null;
        if (ZeusTransformUtils.instanceOf(th, BaseException.class) == false) goto L46;
        e = (BaseException) ZeusTransformUtils.preCheckCast(th, BaseException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
    L31:
        if (e == null) goto L35;
        if (a(r7, e) == true) goto L21;
    L35:
        i();
        return false;
    L46:
        com.ss.android.socialbase.downloader.utils.c.a(th, "download");     // Catch: BaseException -> L30 Throwable -> L40
    L30:
        e = e;
        goto L31
    L10:
        i();
        return false;
    L40:
        th = move-exception;
        i();
        throw th;
    }

    private boolean a(i r9, BaseException r10) {
        com.ss.android.socialbase.downloader.e.a.b("SegmentReader", this.n.getId(), "handleFailedAndCheckRetry", "Exception = " + r10 + ", curRetryCount = " + this.F + ", retryCount = " + this.E);
        this.L = r10;
        this.f15630b.b();
        if (this.k.a(this, this.f15630b, r9, r10, this.F, this.E) == true) goto L5;
        return false;
    L5:
        int r0 = this.F;
        if (r0 >= this.E) goto L9;
        this.F = r0 + 1;
        return true;
    L9:
        this.H.a(r10);
        if (this.G.a(r10) == false) goto L14;
        this.G.b();
        this.n.setCurNetworkRetryCount(this.G.c());
        return true;
    L14:
        if (a(r10) == false) goto L16;
        return true;
    L16:
        this.k.a(this, this.f15630b, r9, r10);
        return false;
    }

    private void b(i r4) {
        c(r4);
        this.k.a(this, r4, this.f15630b, this.q);
        this.f15630b.c();
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0229: INVOKE 
      (r8v2 ?? I:java.lang.String)
      (r4 I:com.ss.android.socialbase.downloader.network.h)
      (r2 I:java.lang.Throwable)
      (r1 I:com.ss.android.socialbase.downloader.depend.j)
     STATIC call: com.ss.android.socialbase.downloader.f.a.a(java.lang.String, com.ss.android.socialbase.downloader.network.h, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.j):void A[MD:(java.lang.String, com.ss.android.socialbase.downloader.network.h, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.j):void (m)], block:B:82:0x021d */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0229: INVOKE 
      (r8 I:java.lang.String)
      (r4 I:com.ss.android.socialbase.downloader.network.h)
      (r2 I:java.lang.Throwable)
      (r1 I:com.ss.android.socialbase.downloader.depend.j)
     STATIC call: com.ss.android.socialbase.downloader.f.a.a(java.lang.String, com.ss.android.socialbase.downloader.network.h, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.j):void A[MD:(java.lang.String, com.ss.android.socialbase.downloader.network.h, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.j):void (m)], block:B:82:0x021d */
    private void c(i r23) {
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L71 BaseException -> L77
        this.e = 0;     // Catch: Throwable -> L71 BaseException -> L77
        this.d = r5;     // Catch: Throwable -> L71 BaseException -> L77
        this.s = r23.e();     // Catch: Throwable -> L71 BaseException -> L77
        this.u = r23.f();     // Catch: Throwable -> L71 BaseException -> L77
        if (this.u > 0) goto L93;
    L15:
        this.O = new com.ss.android.socialbase.downloader.utils.f();     // Catch: Throwable -> L71 BaseException -> L77
        List<HttpHeader> r7 = com.ss.android.socialbase.downloader.utils.c.a(this.n.getExtraHeaders(), this.n.geteTag(), this.s, this.u);     // Catch: Throwable -> L71 BaseException -> L77
        r7.add(new HttpHeader("Segment-Index", String.valueOf(r23.g())));     // Catch: Throwable -> L71 BaseException -> L77
        r7.add(new HttpHeader("Thread-Index", String.valueOf(this.c)));     // Catch: Throwable -> L71 BaseException -> L77
        r7.add(new HttpHeader("extra_download_id", String.valueOf(this.n.getId())));     // Catch: Throwable -> L71 BaseException -> L77
        com.ss.android.socialbase.downloader.utils.c.a(this.o, r7, this.n);     // Catch: Throwable -> L71 BaseException -> L77
        this.H.a(r7);     // Catch: Throwable -> L71 BaseException -> L77
        String r8 = this.f15630b.f15633a;     // Catch: Throwable -> L71 BaseException -> L77
    L66:
        th = th;
        String r9 = "createConn";
    L68:
        com.ss.android.socialbase.downloader.network.h r4 = null;
    L73:
        Throwable r2 = th;
    L74:
        com.ss.android.socialbase.downloader.utils.c.a(r2, r9);     // Catch: Throwable -> L81
        this.e = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.f.a.a(r8, r4, r2, this.m.getCdnListener());
        return;
    L69:
        e = e;
    L80:
        throw e;     // Catch: Throwable -> L81
    L17:
        if (this.K == true) goto L84;
    L29:
        String r3 = this.f15630b.f15634b;     // Catch: Throwable -> L66 BaseException -> L69
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L33;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "createConnection", "Url = " + r8 + ", ip = " + r3 + ", segment = " + r23 + ", threadIndex = " + this.c);     // Catch: Throwable -> L24 BaseException -> L27
    L24:
        th = move-exception;
        r2 = th;
        r9 = "createConn";
    L26:
        r4 = null;
    L33:
        this.h = r8;     // Catch: Throwable -> L66 BaseException -> L69
        this.i = r3;     // Catch: Throwable -> L66 BaseException -> L69
        boolean r14 = this.n.isNeedDefaultHttpServiceBackUp();     // Catch: Throwable -> L66 BaseException -> L69
        int r0 = this.n.getMaxBytes();     // Catch: Throwable -> L66 BaseException -> L69
        r9 = "createConn";
    L64:
        th = th;
        goto L68
    L37:
        if ((r5 - this.I) > 3000) goto L86;
    L43:
        boolean r6 = false;
    L45:
        com.ss.android.socialbase.downloader.network.h r10 = com.ss.android.socialbase.downloader.downloader.b.a(r14, r0, r8, r3, r7, 0, r6, this.n);     // Catch: Throwable -> L64 BaseException -> L69
    L95:
        if (r10 == null) goto L63;
        this.p = r10;     // Catch: Throwable -> L58 BaseException -> L60
        this.q = new com.ss.android.socialbase.downloader.model.f(r8, r10);     // Catch: Throwable -> L58 BaseException -> L60
        if (this.y == true) goto L57;
        if (ZeusTransformUtils.instanceOf(r10, com.ss.android.socialbase.downloader.network.a.class) == false) goto L53;
        this.j = ((com.ss.android.socialbase.downloader.network.a) ZeusTransformUtils.preCheckCast(r10, com.ss.android.socialbase.downloader.network.a.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L58 BaseException -> L60
    L53:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L55;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "createConnection", "Url = " + r8 + ", ip = " + r3 + ", hostRealIp = " + this.j + ", threadIndex = " + this.c);     // Catch: Throwable -> L58 BaseException -> L60
    L55:
        this.e = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.f.a.a(r8, r10, null, this.m.getCdnListener());
        return;
    L57:
        throw new StreamClosedException(r9);     // Catch: Throwable -> L58 BaseException -> L60
    L63:
        throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));     // Catch: Throwable -> L58 BaseException -> L60
    L60:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L58:
        th = move-exception;
        r2 = th;
        r4 = r10;
        goto L74
    L86:
        if (this.o.b("monitor_download_connect") <= 0) goto L43;
        r6 = true;
        goto L45
    L27:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L41:
        th = move-exception;
        r2 = th;
        goto L26
    L84:
        if (TextUtils.isEmpty(r8) == true) goto L29;
        if (r8.startsWith(LocationInfoConst.HTTPS) == false) goto L29;
        r8 = r8.replaceFirst(LocationInfoConst.HTTPS, "http");     // Catch: Throwable -> L24 BaseException -> L27
        goto L29
    L93:
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L11:
        th = move-exception;
        r2 = th;
        r9 = "createConn";
        r4 = null;
        r8 = null;
        goto L74
    L7:
        if (this.s <= this.u) goto L15;
        throw new SegmentApplyException(6, "createConn, " + r23);     // Catch: Throwable -> L11 BaseException -> L13
    L81:
        th = move-exception;
        this.e = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.f.a.a(r8, r4, LocationInfoConst.HTTPS, this.m.getCdnListener());
        throw th;
    L77:
        e = e;
    L71:
        th = th;
        r9 = "createConn";
        r4 = null;
        r8 = null;
        goto L73
    }

    private void d(i r41) {
        i r2 = r41;
        c r3 = this.l;
        this.f = System.currentTimeMillis();
        long r4 = r41.e();
        boolean r8 = false;
        InputStream r10 = this.p.a();     // Catch: Throwable -> L208 BaseException -> L238
        if (r10 == null) goto L203;
        long r11 = this.q.h();     // Catch: Throwable -> L196 BaseException -> L199
        if (r11 == 0) goto L195;
        a r15 = a(r3, r10);     // Catch: Throwable -> L196 BaseException -> L199
    L309:
    L190:
        e = e;
        r4 = r4;
    L241:
        this.L = e;     // Catch: Throwable -> L243
        throw e;     // Catch: Throwable -> L243
    L187:
        th = th;
        r4 = r4;
    L189:
        long r13 = r4;
        e r9 = null;
    L211:
        com.ss.android.socialbase.downloader.e.a.b("SegmentReader", this.n.getId(), "loopAndRead", "Exception: " + th + " stack: " + Log.getStackTraceString(th));     // Catch: Throwable -> L243
        th.printStackTrace();     // Catch: Throwable -> L243
        com.ss.android.socialbase.downloader.utils.c.a(th, "loopAndRead");     // Catch: BaseException -> L235 Throwable -> L243
        com.ss.android.socialbase.downloader.utils.g.a(new Closeable[]{r10});
        if (r9 == null) goto L219;
        if (r15 == null) goto L279;
    L217:
        r15.c = -1;     // Catch: Throwable -> L265
        r9.b(r15);     // Catch: Throwable -> L265
        a r12 = null;
    L220:
        if (r12 == null) goto L222;
        r3.a(r12);
    L222:
        this.g = System.currentTimeMillis();
        if (r13 <= r4) goto L232;
        com.ss.android.socialbase.downloader.g.a r0 = this.o;
        DownloadInfo r5 = this.n;
        String r6 = this.h;
        String r7 = this.i;
        String r14 = this.j;
        if (this.y == false) goto L227;
    L230:
        boolean r33 = true;
    L231:
        com.ss.android.socialbase.downloader.f.a.a(r0, r5, r6, r7, r14, r33, this.p, this.L, r13 - r4, TimeUnit.MILLISECONDS.toNanos(this.g - this.f));
        goto L232
    L227:
        if (this.z == true) goto L230;
        r33 = false;
    L232:
        f r1 = this.k;
    L233:
        r1.c(this, r2);
        return;
    L279:
        r15 = r3.b();     // Catch: Throwable -> L265
    L219:
        r12 = r15;
        goto L220
    L235:
        e = move-exception;
        this.L = e;     // Catch: Throwable -> L243
        com.ss.android.socialbase.downloader.utils.c.a(this.p, e);     // Catch: Throwable -> L243
        throw e;     // Catch: Throwable -> L243
    L9:
        if (this.z == false) goto L11;
    L180:
        r4 = r4;
    L185:
        e = e;
    L183:
        th = th;
        goto L189
    L182:
        throw new StreamClosedException("probe");     // Catch: Throwable -> L183 BaseException -> L185
    L11:
        if (this.y == true) goto L180;
        this.G.a();     // Catch: Throwable -> L187 BaseException -> L190
        this.k.b(this, r2);     // Catch: Throwable -> L187 BaseException -> L190
        r9 = this.k.d(this, r2);     // Catch: Throwable -> L187 BaseException -> L190
        long r17 = r41.f();     // Catch: Throwable -> L176 BaseException -> L178
        if (r17 > 0) goto L19;
        if (r11 <= 0) goto L18;
        r17 = (r11 + r4) - 1;     // Catch: Throwable -> L176 BaseException -> L178
        goto L19
    L18:
        r17 = Long.MAX_VALUE;
    L19:
        int r16 = r15.c;     // Catch: Throwable -> L176 BaseException -> L178
        long r18 = r16;
        r13 = r4 + r18;
        if (r13 <= r17) goto L50;
        long r19 = r17 + 1;
        if (r13 <= r19) goto L28;
        int r110 = (int) (r18 - (r13 - r19));
        if (r110 <= 0) goto L28;
        if (r110 >= r16) goto L28;
        r15.c = r110;     // Catch: Throwable -> L172 BaseException -> L174
        r13 = r19;
    L28:
        this.v = r13;     // Catch: Throwable -> L172 BaseException -> L174
        r9.b(r15);     // Catch: Throwable -> L172 BaseException -> L174
        com.ss.android.socialbase.downloader.utils.g.a(new Closeable[]{r10});
        if (r9 != null) goto L289;
    L35:
        a r20 = null;
    L36:
        if (r20 == null) goto L38;
        r3.a(r20);
    L38:
        this.g = System.currentTimeMillis();
        if (r13 <= r4) goto L48;
        com.ss.android.socialbase.downloader.g.a r111 = this.o;
        DownloadInfo r21 = this.n;
        String r22 = this.h;
        String r23 = this.i;
        String r24 = this.j;
        if (this.y == false) goto L43;
    L46:
        boolean r25 = true;
    L47:
        com.ss.android.socialbase.downloader.f.a.a(r111, r21, r22, r23, r24, r25, this.p, this.L, r13 - r4, TimeUnit.MILLISECONDS.toNanos(this.g - this.f));
        goto L48
    L43:
        if (this.z == true) goto L46;
        r25 = false;
    L48:
        this.k.c(this, r2);
        return;
    L289:
        a r26 = r3.b();     // Catch: Throwable -> L267
        r26.c = -1;     // Catch: Throwable -> L34
        r9.b(r26);     // Catch: Throwable -> L34
    L34:
        r20 = r26;
        goto L36
    L50:
        this.v = r13;     // Catch: Throwable -> L172 BaseException -> L174
        r9.b(r15);     // Catch: Throwable -> L172 BaseException -> L174
        long r112 = r17;
    L297:
        if (this.C == true) goto L269;
        r4 = r4;
    L305:
        r15 = r3.b();     // Catch: Throwable -> L164 BaseException -> L166
        int r27 = r10.read(r15.f15611a);     // Catch: Throwable -> L160 BaseException -> L162
        r15.c = r27;     // Catch: Throwable -> L160 BaseException -> L162
        if (r27 == (-1)) goto L109;
        long r28 = r27;
        r13 = r13 + r28;     // Catch: Throwable -> L160 BaseException -> L162
        if (r13 > r112) goto L112;
        r2 = r41;
        this.v = r13;     // Catch: Throwable -> L156 BaseException -> L158
        r9.b(r15);     // Catch: Throwable -> L156 BaseException -> L158
        r4 = r4;
        r8 = false;
        goto L297
    L158:
        e = e;
    L156:
        th = th;
        goto L211
    L112:
        long r29 = r112 + 1;     // Catch: Throwable -> L160 BaseException -> L162
        if (r13 <= r29) goto L118;
        int r30 = (int) (r28 - (r13 - r29));     // Catch: Throwable -> L160 BaseException -> L162
        if (r30 <= 0) goto L118;
        if (r30 >= r27) goto L118;
        r15.c = r30;     // Catch: Throwable -> L160 BaseException -> L162
        r13 = r29;
    L118:
        this.v = r13;     // Catch: Throwable -> L160 BaseException -> L162
        r9.b(r15);     // Catch: Throwable -> L160 BaseException -> L162
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L122;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "loopAndRead", "BytesRead = " + (r13 - r4) + ", url = " + this.f15630b.f15633a);     // Catch: Throwable -> L164 BaseException -> L166
    L122:
        long r31 = 0;
    L124:
        if (r112 > r31) goto L126;
    L132:
        com.ss.android.socialbase.downloader.utils.g.a(new Closeable[]{r10});
        if (r9 != null) goto L275;
    L139:
        a r32 = null;
    L140:
        if (r32 == null) goto L142;
        r3.a(r32);
    L142:
        this.g = System.currentTimeMillis();
        if (r13 <= r4) goto L152;
        com.ss.android.socialbase.downloader.g.a r34 = this.o;
        DownloadInfo r35 = this.n;
        String r36 = this.h;
        String r37 = this.i;
        String r38 = this.j;
        if (this.y == false) goto L147;
    L150:
        boolean r39 = true;
    L151:
        com.ss.android.socialbase.downloader.f.a.a(r34, r35, r36, r37, r38, r39, this.p, this.L, r13 - r4, TimeUnit.MILLISECONDS.toNanos(this.g - this.f));
        goto L152
    L147:
        if (this.z == true) goto L150;
        r39 = false;
    L152:
        r1 = this.k;
        r2 = r41;
        goto L233
    L275:
        a r40 = r3.b();     // Catch: Throwable -> L268
        r40.c = -1;     // Catch: Throwable -> L138
        r9.b(r40);     // Catch: Throwable -> L138
    L138:
        r32 = r40;
        goto L140
    L126:
        if (r112 == Long.MAX_VALUE) goto L132;
        if (r13 > r112) goto L132;
        throw new BaseException(1051, String.format(Locale.US, "range[%d, %d] , but readCurrent[%d] , readStart[%d]", new Object[]{Long.valueOf(r4), Long.valueOf(r112), Long.valueOf(r13), Long.valueOf(r4)}));     // Catch: Throwable -> L164 BaseException -> L166
    L109:
        r9.b(r15);     // Catch: Throwable -> L160 BaseException -> L162
        r31 = 0;
        r9 = null;
    L162:
        e = e;
    L160:
        th = th;
        r2 = r41;
    L166:
        e = e;
    L164:
        th = th;
    L165:
        r2 = r41;
    L210:
        r15 = null;
        goto L211
    L269:
        monitor-enter(this);     // Catch: Throwable -> L101 BaseException -> L103
        this.C = r8;     // Catch: Throwable -> L95
        if (this.z == true) goto L94;
        if (this.y == true) goto L94;
        monitor-exit(this);     // Catch: Throwable -> L95
        f r113 = this.k;     // Catch: Throwable -> L101 BaseException -> L103
        monitor-enter(r113);     // Catch: Throwable -> L101 BaseException -> L103
    L86:
        th = th;
    L88:
        monitor-exit(r113);     // Catch: Throwable -> L90
    L90:
        th = th;
        goto L88
    L89:
        throw th;     // Catch: Throwable -> L164 BaseException -> L166
    L63:
        if (this.t != 0) goto L65;
        r4 = r4;
    L84:
        monitor-exit(r113);     // Catch: Throwable -> L90
        goto L305
    L65:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L70;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "loopAndRead", "Change readEnd = " + r112 + ", segmentNewEndOffset = " + this.t + ", segment = " + r2);     // Catch: Throwable -> L90
        goto L70
    L311:
        th = th;
    L70:
        r112 = m();     // Catch: Throwable -> L90
        if (r13 <= r112) goto L84;
        long r42 = r112 + 1;     // Catch: Throwable -> L90
        long r43 = r13 - r42;     // Catch: Throwable -> L90
        if (r43 <= 0) goto L281;
        com.ss.android.socialbase.downloader.e.a.b("SegmentReader", this.n.getId(), "loopAndRead", "redundant: " + r43);     // Catch: Throwable -> L90
    L281:
        this.v = r42;     // Catch: Throwable -> L80
        monitor-exit(r113);     // Catch: Throwable -> L80
        r13 = r42;
        r112 = r112;
    L80:
        th = th;
        goto L88
    L94:
        throw new StreamClosedException("loopAndRead");     // Catch: Throwable -> L99
    L95:
        th = th;
    L97:
        monitor-exit(this);     // Catch: Throwable -> L99
        throw th;     // Catch: Throwable -> L164 BaseException -> L166
    L99:
        th = th;
    L103:
        e = e;
    L101:
        th = th;
        r4 = r4;
        goto L165
    L170:
        e = e;
    L168:
        th = th;
        r4 = r4;
    L174:
        e = e;
    L172:
        th = th;
        r4 = r4;
        goto L211
    L178:
        e = e;
    L176:
        th = th;
        r4 = r4;
        r13 = r4;
        goto L211
    L195:
        throw new DownloadRetryNeedlessException(1004, "the content-length is 0, contentLength = " + r11);     // Catch: Throwable -> L204 BaseException -> L206
    L199:
        e = e;
    L196:
        th = th;
        r4 = r4;
    L198:
        r13 = r4;
        r9 = null;
        goto L210
    L203:
        throw new BaseException(1042, new IOException("inputStream is null"));     // Catch: Throwable -> L204 BaseException -> L206
    L206:
        e = e;
    L204:
        th = th;
        goto L198
    L243:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.a(new Closeable[]{r10});
        if (r9 == null) goto L250;
        if (r15 == null) goto L277;
    L248:
        r15.c = -1;     // Catch: Throwable -> L266
        r9.b(r15);     // Catch: Throwable -> L266
        a r44 = null;
    L251:
        if (r44 == null) goto L253;
        r3.a(r44);
    L253:
        this.g = System.currentTimeMillis();
        if (r13 <= r4) goto L263;
        com.ss.android.socialbase.downloader.g.a r45 = this.o;
        DownloadInfo r46 = this.n;
        String r47 = this.h;
        String r48 = this.i;
        String r49 = this.j;
        if (this.y == false) goto L258;
    L261:
        boolean r310 = true;
    L262:
        com.ss.android.socialbase.downloader.f.a.a(r45, r46, r47, r48, r49, r310, this.p, this.L, r13 - r4, TimeUnit.MILLISECONDS.toNanos(this.g - this.f));
        goto L263
    L258:
        if (this.z == true) goto L261;
        r310 = false;
    L263:
        this.k.c(this, r2);
        throw th;
    L277:
        r15 = r3.b();     // Catch: Throwable -> L266
    L250:
        r44 = r15;
    L238:
        e = e;
    L208:
        th = th;
        r4 = r4;
        r13 = r4;
        r9 = null;
        r10 = null;
        goto L210
    }

    private void i() {
        this.I = this.d;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        j();
    }

    private void j() {
        com.ss.android.socialbase.downloader.network.h r0 = this.p;
        if (r0 == null) goto L12;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L7;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "closeConnection", "Thread: " + this.c);     // Catch: Throwable -> L9
    L7:
        r0.d();     // Catch: Throwable -> L9
        r0.c();     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    private void k() {
        this.K = false;
        l();
    }

    private void l() {
        if (this.f15630b.d == false) goto L5;
        int r0 = this.n.getRetryCount();
    L6:
        this.E = r0;
        this.F = 0;
        this.G.a();
        return;
    L5:
        r0 = this.n.getBackUpUrlRetryCount();
        goto L6
    }

    private long m() {
        long r0 = this.t;
        this.t = 0;
        if (r0 > 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r0;
    }

    long a(long r1, long r3) {
        com.ss.android.socialbase.downloader.utils.f r0 = this.O;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.b(r1, r3);
    }

    void a() {
        o r0 = this.f15630b;
        f r1 = this.k;     // Catch: Throwable -> L15
        monitor-enter(r1);     // Catch: Throwable -> L15
        long r2 = c();     // Catch: Throwable -> L11
        if (r2 <= 0) goto L8;
        this.w += r2;     // Catch: Throwable -> L11
        r0.a(r2);     // Catch: Throwable -> L11
    L8:
        this.v = -1;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        goto L19
    L14:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    }

    void a(Future r3) {
        this.x = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.memorydata.plugin");
    }

    public void a(boolean r6) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "reconnect", "ThreadIndex: " + this.c);
    L5:
        monitor-enter(this);
        this.A = r6;     // Catch: Throwable -> L15
        this.z = true;     // Catch: Throwable -> L15
        this.C = true;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        j();
        Thread r7 = this.B;
        if (r7 == null) goto L23;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "reconnect", "Interrupt ThreadIndex: " + this.c);     // Catch: Throwable -> L18
    L13:
        r7.interrupt();     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean a(long r7) {
        long r0 = this.u;
        if (r7 > 0) goto L8;
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r7 > r0) goto L10;
    L12:
        this.t = r7;
        this.C = true;
        return true;
    L10:
        if (r0 <= 0) goto L12;
        return false;
    }

    boolean a(o r3) {
        int r0 = this.f15628J;
        if (r0 < 30) goto L6;
        return false;
    L6:
        this.f15628J = r0 + 1;
        o r1 = this.f15630b;
        if (r1 == null) goto L9;
        r1.b(this);
    L9:
        r3.a(this);
        this.f15630b = r3;
        l();
        return true;
    }

    public long b() {
        f r0 = this.k;
        monitor-enter(r0);
        long r1 = this.w + c();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void b(long r7) {
        long r0 = this.v;
        com.ss.android.socialbase.downloader.utils.f r2 = this.O;
        if (r0 < 0) goto L11;
        if (r2 != null) goto L7;
        return;
    L7:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "markProgress", "CurSegmentReadOffset = " + r0 + ", threadIndex = " + this.c);
    L9:
        r2.a(r0, r7);
        return;
    }

    void b(boolean r1) {
        this.M = r1;
    }

    public long c() {
        f r0 = this.k;
        monitor-enter(r0);
        long r1 = this.v;     // Catch: Throwable -> L13
        long r3 = this.s;     // Catch: Throwable -> L13
        if (r3 >= 0) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return 0;
    L7:
        if (r1 <= r3) goto L11;
        long r2 = r1 - r3;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    public void c(boolean r1) {
        this.N = r1;
    }

    public long d() {
        return this.v;
    }

    public void e() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), IslandSession.REOPEN_VALUE_CLOSE, "ThreadIndex: " + this.c);
    L5:
        monitor-enter(this);
        this.y = true;     // Catch: Throwable -> L17
        this.C = true;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        j();
        Future r1 = this.x;
        if (r1 == null) goto L24;
        this.x = null;
        r1.cancel(true);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void f() {
        a(false);
    }

    boolean g() {
        return this.M;
    }

    long h() {
        return this.s;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.B = Thread.currentThread();     // Catch: Throwable -> L38
        this.k.a(this);     // Catch: Throwable -> L38
        this.f15630b.a(this);     // Catch: Throwable -> L38
    L4:
        i r1 = this.k.a(this, this.f15630b);     // Catch: Throwable -> L38
        if (r1 == null) goto L8;
        this.f15629a = r1;     // Catch: Throwable -> L38
    L25:
        e = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("SegmentReader", this.n.getId(), "run", "SegmentApplyException, Exception = " + e);     // Catch: Throwable -> L23
        int r4 = this.D;     // Catch: Throwable -> L23
        if (r4 >= 50) goto L28;
        this.D = r4 + 1;     // Catch: Throwable -> L23
        this.f15629a = null;     // Catch: Throwable -> L38
        f r2 = this.k;     // Catch: Throwable -> L38
    L15:
        r2.a(this, r1);     // Catch: Throwable -> L38
        goto L4
    L28:
        com.ss.android.socialbase.downloader.e.a.b("SegmentReader", this.n.getId(), "run", "Segment apply failed " + this.D + "times, thread_index = " + this.c);     // Catch: Throwable -> L23
        this.f15629a = null;     // Catch: Throwable -> L38
        f r3 = this.k;     // Catch: Throwable -> L38
    L21:
        r3.a(this, r1);     // Catch: Throwable -> L38
    L31:
        this.f15630b.b(this);     // Catch: Throwable -> L48
        f r5 = this.k;     // Catch: Throwable -> L48
    L41:
        r5.b(this);     // Catch: Throwable -> L48
        goto L42
    L23:
        th = move-exception;
        this.f15629a = null;     // Catch: Throwable -> L38
        this.k.a(this, r1);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L12:
        if (a(r1) == false) goto L18;
        this.r.add(r1);     // Catch: Throwable -> L23 SegmentApplyException -> L25
        this.f15629a = null;     // Catch: Throwable -> L38
        r2 = this.k;     // Catch: Throwable -> L38
        goto L15
    L18:
        if (this.y == true) goto L20;
        com.ss.android.socialbase.downloader.e.a.b("SegmentReader", this.n.getId(), "run", "Download segment failed, segment = " + r1 + ", thread_index = " + this.c + ", failedException = " + this.L);     // Catch: Throwable -> L23 SegmentApplyException -> L25
    L20:
        this.f15629a = null;     // Catch: Throwable -> L38
        r3 = this.k;     // Catch: Throwable -> L38
        goto L21
    L8:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L31;
        com.ss.android.socialbase.downloader.e.a.a("SegmentReader", this.n.getId(), "run", "No more segment, thread_index: " + this.c);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44
        this.f15630b.b(this);     // Catch: Throwable -> L48
        r5 = this.k;     // Catch: Throwable -> L48
    L44:
        th = move-exception;
        this.f15630b.b(this);     // Catch: Throwable -> L49
        this.k.b(this);     // Catch: Throwable -> L49
    L46:
        this.B = null;
        throw th;
    L42:
        this.B = null;
    }
}
