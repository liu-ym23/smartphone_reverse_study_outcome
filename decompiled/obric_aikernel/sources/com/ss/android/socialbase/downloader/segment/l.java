package com.ss.android.socialbase.downloader.segment;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import jb.v;
import jb.w;

/* JADX INFO: loaded from: classes2.dex */
class l implements Runnable {
    private volatile boolean A;
    private int B;
    private int C;
    private int D;
    private w E;
    private v F;
    private long G;
    private int H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private BaseException f8283J;
    private boolean K;
    private com.ss.android.socialbase.downloader.utils.f L;
    volatile long M;
    volatile long N;
    volatile long O;
    volatile long P;
    String Q;
    String R;
    String S;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f8284c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f8285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.d f8286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final DownloadInfo f8287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final rb.a f8288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private nb.h f8289k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.g f8290l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List<i> f8291m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    volatile i f8292n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    o f8293o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f8294p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile long f8295q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile long f8296r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile long f8297s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile long f8298t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Future f8299u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile boolean f8300v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile boolean f8301w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private volatile boolean f8302x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Thread f8303y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final int f8304z;

    l(com.ss.android.socialbase.downloader.model.d r10, DownloadInfo r11, j r12, c r13, o r14, int r15) {
        this.f8291m = new ArrayList();
        this.f8297s = -1;
        this.f8286h = r10;
        this.f8287i = r11;
        this.f8284c = r12;
        this.f8285g = r13;
        this.f8288j = rb.a.g(r11.getId());
        this.f8293o = r14;
        this.f8304z = r15;
        this.E = new w(r11);
        this.F = new v(r11);
    }

    private boolean b(BaseException r10) {
        if (com.ss.android.socialbase.downloader.utils.c.D(r10) == true) goto L5;
        return false;
    L5:
        String r11 = this.f8293o.f8307a;
        if (TextUtils.isEmpty(r11) == false) goto L8;
    L18:
        return false;
    L8:
        if (r11.startsWith("https") == false) goto L18;
        if (this.f8287i.isNeedHttpsToHttpRetry() == true) goto L14;
        return false;
    L14:
        if (this.I == false) goto L16;
        return false;
    L16:
        this.I = true;
        y();
        return true;
    }

    private void d() {
        nb.h r10 = this.f8289k;
        if (r10 == null) goto L12;
        if (lb.a.a() == false) goto L7;
        lb.a.g("SegmentReader", this.f8287i.getId(), "closeConnection", "Thread: " + this.f8304z);     // Catch: Throwable -> L9
    L7:
        r10.a();     // Catch: Throwable -> L9
        r10.cancel();     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x020c: INVOKE (r8v2 ?? I:java.lang.String), (r4 I:nb.h), (r2 I:java.lang.Throwable), (r1 I:ib.k) STATIC call: mb.a.d(java.lang.String, nb.h, java.lang.Throwable, ib.k):void A[MD:(java.lang.String, nb.h, java.lang.Throwable, ib.k):void (m)], block:B:82:0x0200 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x020c: INVOKE (r8 I:java.lang.String), (r4 I:nb.h), (r2 I:java.lang.Throwable), (r1 I:ib.k) STATIC call: mb.a.d(java.lang.String, nb.h, java.lang.Throwable, ib.k):void A[MD:(java.lang.String, nb.h, java.lang.Throwable, ib.k):void (m)], block:B:82:0x0200 */
    private void e(i r23) {
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L71 BaseException -> L77
        this.N = 0;     // Catch: Throwable -> L71 BaseException -> L77
        this.M = r10;     // Catch: Throwable -> L71 BaseException -> L77
        this.f8294p = r23.d();     // Catch: Throwable -> L71 BaseException -> L77
        this.f8296r = r23.f();     // Catch: Throwable -> L71 BaseException -> L77
        if (this.f8296r > 0) goto L94;
    L15:
        this.L = new com.ss.android.socialbase.downloader.utils.f();     // Catch: Throwable -> L71 BaseException -> L77
        List<HttpHeader> r11 = com.ss.android.socialbase.downloader.utils.c.a(this.f8287i.getExtraHeaders(), this.f8287i.geteTag(), this.f8294p, this.f8296r);     // Catch: Throwable -> L71 BaseException -> L77
        r11.add(new HttpHeader("Segment-Index", String.valueOf(r23.g())));     // Catch: Throwable -> L71 BaseException -> L77
        r11.add(new HttpHeader("Thread-Index", String.valueOf(this.f8304z)));     // Catch: Throwable -> L71 BaseException -> L77
        r11.add(new HttpHeader("extra_download_id", String.valueOf(this.f8287i.getId())));     // Catch: Throwable -> L71 BaseException -> L77
        com.ss.android.socialbase.downloader.utils.c.b(this.f8288j, r11, this.f8287i);     // Catch: Throwable -> L71 BaseException -> L77
        this.F.n(r11);     // Catch: Throwable -> L71 BaseException -> L77
        String r12 = this.f8293o.f8307a;     // Catch: Throwable -> L71 BaseException -> L77
    L69:
        e = e;
    L80:
        throw e;     // Catch: Throwable -> L81
    L66:
        th = th;
        String r13 = "createConn";
    L68:
        nb.h r14 = null;
    L73:
        Throwable r15 = th;
    L74:
        com.ss.android.socialbase.downloader.utils.c.T(r15, r13);     // Catch: Throwable -> L81
        this.N = System.currentTimeMillis();
        mb.a.d(r12, r14, r15, this.f8286h.s());
        return;
    L17:
        if (this.I == true) goto L84;
    L29:
        String r16 = this.f8293o.f8308b;     // Catch: Throwable -> L66 BaseException -> L69
        if (lb.a.a() == false) goto L33;
        lb.a.g("SegmentReader", this.f8287i.getId(), "createConnection", "Url = " + r12 + ", ip = " + r16 + ", segment = " + r23 + ", threadIndex = " + this.f8304z);     // Catch: Throwable -> L24 BaseException -> L27
    L24:
        th = move-exception;
        r15 = th;
        r13 = "createConn";
    L26:
        r14 = null;
    L33:
        this.Q = r12;     // Catch: Throwable -> L66 BaseException -> L69
        this.R = r16;     // Catch: Throwable -> L66 BaseException -> L69
        boolean r17 = this.f8287i.isNeedDefaultHttpServiceBackUp();     // Catch: Throwable -> L66 BaseException -> L69
        int r18 = this.f8287i.getMaxBytes();     // Catch: Throwable -> L66 BaseException -> L69
        r13 = "createConn";
    L64:
        th = th;
        goto L68
    L37:
        if ((r10 - this.G) > WsConstants.EXIT_DELAY_TIME) goto L92;
    L43:
        boolean r19 = false;
    L45:
        nb.h r20 = com.ss.android.socialbase.downloader.downloader.a.f(r17, r18, r12, r16, r11, 0, r19, this.f8287i);     // Catch: Throwable -> L64 BaseException -> L69
    L96:
        if (r20 == null) goto L63;
        this.f8289k = r20;     // Catch: Throwable -> L58 BaseException -> L60
        this.f8290l = new com.ss.android.socialbase.downloader.model.g(r12, r20);     // Catch: Throwable -> L58 BaseException -> L60
        if (this.f8300v == true) goto L57;
        if ((r20 instanceof nb.a) == false) goto L53;
        this.S = ((nb.a) r20).e();     // Catch: Throwable -> L58 BaseException -> L60
    L53:
        if (lb.a.a() == false) goto L55;
        lb.a.g("SegmentReader", this.f8287i.getId(), "createConnection", "Url = " + r12 + ", ip = " + r16 + ", hostRealIp = " + this.S + ", threadIndex = " + this.f8304z);     // Catch: Throwable -> L58 BaseException -> L60
    L55:
        this.N = System.currentTimeMillis();
        mb.a.d(r12, r20, null, this.f8286h.s());
        return;
    L57:
        throw new StreamClosedException(r13);     // Catch: Throwable -> L58 BaseException -> L60
    L63:
        throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));     // Catch: Throwable -> L58 BaseException -> L60
    L60:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L58:
        th = move-exception;
        r15 = th;
        r14 = r20;
        goto L74
    L92:
        if (this.f8288j.n("monitor_download_connect") <= 0) goto L43;
        r19 = true;
        goto L45
    L27:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L41:
        th = move-exception;
        r15 = th;
        goto L26
    L84:
        if (TextUtils.isEmpty(r12) == true) goto L29;
        if (r12.startsWith("https") == false) goto L29;
        r12 = r12.replaceFirst("https", "http");     // Catch: Throwable -> L24 BaseException -> L27
        goto L29
    L94:
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L11:
        th = move-exception;
        r15 = th;
        r13 = "createConn";
        r14 = null;
        r12 = null;
        goto L74
    L7:
        if (this.f8294p <= this.f8296r) goto L15;
        throw new SegmentApplyException(6, "createConn, " + r23);     // Catch: Throwable -> L11 BaseException -> L13
    L81:
        th = move-exception;
        this.N = System.currentTimeMillis();
        mb.a.d(r8, r4, "https", this.f8286h.s());
        throw th;
    L77:
        e = e;
    L71:
        th = th;
        r13 = "createConn";
        r14 = null;
        r12 = null;
        goto L73
    }

    private void f(i r10) {
        e(r10);
        this.f8284c.d(this, r10, this.f8293o, this.f8290l);
        this.f8293o.g();
    }

    private boolean g(i r10) {
        n();
    L48:
        f(r10);     // Catch: Throwable -> L6 SegmentApplyException -> L37
        p(r10);     // Catch: Throwable -> L6 SegmentApplyException -> L37
    L4:
        x();
        return true;
    L37:
        e = move-exception;
        this.f8283J = e;     // Catch: Throwable -> L40
        throw e;     // Catch: Throwable -> L40
    L6:
        th = move-exception;
        lb.a.h("SegmentReader", this.f8287i.getId(), "download", "e = " + th + ", threadIndex = " + this.f8304z + ", reconnect = " + this.f8301w + ", closed = " + this.f8300v);     // Catch: Throwable -> L40
        if (this.f8300v == true) goto L10;
        if (this.f8301w == false) goto L24;
        this.f8301w = false;     // Catch: Throwable -> L40
        Thread.interrupted();     // Catch: Throwable -> L17
    L20:
        if (this.f8302x == false) goto L21;
        this.f8302x = false;     // Catch: Throwable -> L40
        throw new SegmentApplyException(5, "download");     // Catch: Throwable -> L40
    L21:
        x();
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L40
        goto L20
    L24:
        BaseException e10 = null;
        if ((th instanceof BaseException) == false) goto L43;
        e10 = th;     // Catch: Throwable -> L40
    L31:
        if (e10 == null) goto L35;
        if (m(r10, e10) == true) goto L21;
    L35:
        x();
        return false;
    L43:
        com.ss.android.socialbase.downloader.utils.c.T(th, "download");     // Catch: BaseException -> L30 Throwable -> L40
    L30:
        e10 = e;
        goto L31
    L10:
        x();
        return false;
    L40:
        th = move-exception;
        x();
        throw th;
    }

    private boolean m(i r10, BaseException r11) {
        lb.a.h("SegmentReader", this.f8287i.getId(), "handleFailedAndCheckRetry", "Exception = " + r11 + ", curRetryCount = " + this.D + ", retryCount = " + this.C);
        this.f8283J = r11;
        this.f8293o.f();
        if (this.f8284c.j(this, this.f8293o, r10, r11, this.D, this.C) == true) goto L5;
        return false;
    L5:
        int r12 = this.D;
        if (r12 >= this.C) goto L9;
        this.D = r12 + 1;
        return true;
    L9:
        this.F.m(r11);
        if (this.E.a(r11) == false) goto L14;
        this.E.c();
        this.f8287i.setCurNetworkRetryCount(this.E.d());
        return true;
    L14:
        if (b(r11) == false) goto L16;
        return true;
    L16:
        this.f8284c.k(this, this.f8293o, r10, r11);
        return false;
    }

    private void n() {
        this.I = false;
        y();
    }

    private void p(i r41) {
        i r10 = r41;
        c r11 = this.f8285g;
        this.O = System.currentTimeMillis();
        long r12 = r41.d();
        boolean r13 = false;
        InputStream r14 = this.f8289k.b();     // Catch: Throwable -> L206 BaseException -> L236
    L305:
        if (r14 == null) goto L201;
        long r15 = this.f8290l.d();     // Catch: Throwable -> L194 BaseException -> L197
        if (r15 == 0) goto L193;
        a r16 = r(r11, r14);     // Catch: Throwable -> L194 BaseException -> L197
    L188:
        e = e;
        r12 = r12;
    L239:
        this.f8283J = e;     // Catch: Throwable -> L241
        throw e;     // Catch: Throwable -> L241
    L185:
        th = th;
        r12 = r12;
    L187:
        long r17 = r12;
        e r18 = null;
    L209:
        lb.a.h("SegmentReader", this.f8287i.getId(), "loopAndRead", "Exception: " + th + " stack: " + Log.getStackTraceString(th));     // Catch: Throwable -> L241
        th.printStackTrace();     // Catch: Throwable -> L241
        com.ss.android.socialbase.downloader.utils.c.T(th, "loopAndRead");     // Catch: BaseException -> L233 Throwable -> L241
        com.ss.android.socialbase.downloader.utils.g.b0(new Closeable[]{r14});
        if (r18 == null) goto L217;
        if (r16 == null) goto L269;
    L215:
        r16.f8207c = -1;     // Catch: Throwable -> L263
        r18.b(r16);     // Catch: Throwable -> L263
        a r19 = null;
    L218:
        if (r19 == null) goto L220;
        r11.a(r19);
    L220:
        this.P = System.currentTimeMillis();
        if (r17 <= r12) goto L230;
        rb.a r20 = this.f8288j;
        DownloadInfo r21 = this.f8287i;
        String r22 = this.Q;
        String r23 = this.R;
        String r24 = this.S;
        if (this.f8300v == false) goto L225;
    L228:
        boolean r33 = true;
    L229:
        mb.a.j(r20, r21, r22, r23, r24, r33, this.f8289k, this.f8283J, r17 - r12, TimeUnit.MILLISECONDS.toNanos(this.P - this.O));
        goto L230
    L225:
        if (this.f8301w == true) goto L228;
        r33 = false;
    L230:
        f r25 = this.f8284c;
    L231:
        r25.a(this, r10);
        return;
    L269:
        r16 = r11.c();     // Catch: Throwable -> L263
    L217:
        r19 = r16;
        goto L218
    L233:
        e = move-exception;
        this.f8283J = e;     // Catch: Throwable -> L241
        com.ss.android.socialbase.downloader.utils.c.w(this.f8289k, e);     // Catch: Throwable -> L241
        throw e;     // Catch: Throwable -> L241
    L9:
        if (this.f8301w == false) goto L11;
    L178:
        r12 = r12;
    L183:
        e = e;
    L181:
        th = th;
        goto L187
    L180:
        throw new StreamClosedException("probe");     // Catch: Throwable -> L181 BaseException -> L183
    L11:
        if (this.f8300v == true) goto L178;
        this.E.f();     // Catch: Throwable -> L185 BaseException -> L188
        this.f8284c.b(this, r10);     // Catch: Throwable -> L185 BaseException -> L188
        r18 = this.f8284c.c(this, r10);     // Catch: Throwable -> L185 BaseException -> L188
    L295:
        long r110 = r41.f();     // Catch: Throwable -> L174 BaseException -> L176
        if (r110 > 0) goto L19;
        if (r15 <= 0) goto L18;
        r110 = (r15 + r12) - 1;     // Catch: Throwable -> L174 BaseException -> L176
        goto L19
    L18:
        r110 = Long.MAX_VALUE;
    L19:
        int r26 = r16.f8207c;     // Catch: Throwable -> L174 BaseException -> L176
        long r111 = r26;
        r17 = r12 + r111;
        if (r17 <= r110) goto L48;
        long r112 = r110 + 1;
        if (r17 <= r112) goto L28;
        int r113 = (int) (r111 - (r17 - r112));
        if (r113 <= 0) goto L28;
        if (r113 >= r26) goto L28;
        r16.f8207c = r113;     // Catch: Throwable -> L170 BaseException -> L172
        r17 = r112;
    L28:
        this.f8297s = r17;     // Catch: Throwable -> L170 BaseException -> L172
        r18.b(r16);     // Catch: Throwable -> L170 BaseException -> L172
        com.ss.android.socialbase.downloader.utils.g.b0(new Closeable[]{r14});
        a r27 = r11.c();     // Catch: Throwable -> L265
        r27.f8207c = -1;     // Catch: Throwable -> L33
        r18.b(r27);     // Catch: Throwable -> L33
    L33:
        a r28 = r27;
    L34:
        if (r28 == null) goto L36;
        r11.a(r28);
    L36:
        this.P = System.currentTimeMillis();
        if (r17 <= r12) goto L46;
        rb.a r114 = this.f8288j;
        DownloadInfo r29 = this.f8287i;
        String r30 = this.Q;
        String r31 = this.R;
        String r32 = this.S;
        if (this.f8300v == false) goto L41;
    L44:
        boolean r210 = true;
    L45:
        mb.a.j(r114, r29, r30, r31, r32, r210, this.f8289k, this.f8283J, r17 - r12, TimeUnit.MILLISECONDS.toNanos(this.P - this.O));
        goto L46
    L41:
        if (this.f8301w == true) goto L44;
        r210 = false;
    L46:
        this.f8284c.a(this, r10);
        return;
    L32:
        r28 = null;
        goto L34
    L48:
        this.f8297s = r17;     // Catch: Throwable -> L170 BaseException -> L172
        r18.b(r16);     // Catch: Throwable -> L170 BaseException -> L172
        long r115 = r110;
    L307:
        if (this.A == true) goto L286;
        r12 = r12;
    L304:
        r16 = r11.c();     // Catch: Throwable -> L162 BaseException -> L164
        int r34 = r14.read(r16.f8205a);     // Catch: Throwable -> L158 BaseException -> L160
        r16.f8207c = r34;     // Catch: Throwable -> L158 BaseException -> L160
        if (r34 == (-1)) goto L107;
        long r35 = r34;
        r17 = r17 + r35;     // Catch: Throwable -> L158 BaseException -> L160
        if (r17 > r115) goto L110;
        r10 = r41;
        this.f8297s = r17;     // Catch: Throwable -> L154 BaseException -> L156
        r18.b(r16);     // Catch: Throwable -> L154 BaseException -> L156
        r12 = r12;
        r13 = false;
        goto L307
    L156:
        e = e;
    L154:
        th = th;
        goto L209
    L110:
        long r211 = r115 + 1;     // Catch: Throwable -> L158 BaseException -> L160
        if (r17 <= r211) goto L116;
        int r36 = (int) (r35 - (r17 - r211));     // Catch: Throwable -> L158 BaseException -> L160
        if (r36 <= 0) goto L116;
        if (r36 >= r34) goto L116;
        r16.f8207c = r36;     // Catch: Throwable -> L158 BaseException -> L160
        r17 = r211;
    L116:
        this.f8297s = r17;     // Catch: Throwable -> L158 BaseException -> L160
        r18.b(r16);     // Catch: Throwable -> L158 BaseException -> L160
        if (lb.a.a() == false) goto L120;
        lb.a.g("SegmentReader", this.f8287i.getId(), "loopAndRead", "BytesRead = " + (r17 - r12) + ", url = " + this.f8293o.f8307a);     // Catch: Throwable -> L162 BaseException -> L164
    L120:
        long r37 = 0;
    L122:
        if (r115 > r37) goto L124;
    L130:
        com.ss.android.socialbase.downloader.utils.g.b0(new Closeable[]{r14});
        if (r18 != null) goto L289;
    L137:
        a r38 = null;
    L138:
        if (r38 == null) goto L140;
        r11.a(r38);
    L140:
        this.P = System.currentTimeMillis();
        if (r17 <= r12) goto L150;
        rb.a r39 = this.f8288j;
        DownloadInfo r40 = this.f8287i;
        String r42 = this.Q;
        String r43 = this.R;
        String r44 = this.S;
        if (this.f8300v == false) goto L145;
    L148:
        boolean r310 = true;
    L149:
        mb.a.j(r39, r40, r42, r43, r44, r310, this.f8289k, this.f8283J, r17 - r12, TimeUnit.MILLISECONDS.toNanos(this.P - this.O));
        goto L150
    L145:
        if (this.f8301w == true) goto L148;
        r310 = false;
    L150:
        r25 = this.f8284c;
        r10 = r41;
        goto L231
    L289:
        a r45 = r11.c();     // Catch: Throwable -> L266
        r45.f8207c = -1;     // Catch: Throwable -> L136
        r18.b(r45);     // Catch: Throwable -> L136
    L136:
        r38 = r45;
        goto L138
    L124:
        if (r115 == Long.MAX_VALUE) goto L130;
        if (r17 > r115) goto L130;
        throw new BaseException(1051, String.format(Locale.US, "range[%d, %d] , but readCurrent[%d] , readStart[%d]", new Object[]{Long.valueOf(r12), Long.valueOf(r115), Long.valueOf(r17), Long.valueOf(r12)}));     // Catch: Throwable -> L162 BaseException -> L164
    L107:
        r18.b(r16);     // Catch: Throwable -> L158 BaseException -> L160
        r37 = 0;
        r18 = null;
    L160:
        e = e;
    L158:
        th = th;
        r10 = r41;
    L164:
        e = e;
    L162:
        th = th;
    L163:
        r10 = r41;
    L208:
        r16 = null;
        goto L209
    L286:
        monitor-enter(this);     // Catch: Throwable -> L99 BaseException -> L101
        this.A = r13;     // Catch: Throwable -> L93
        if (this.f8301w == true) goto L92;
        if (this.f8300v == true) goto L92;
        monitor-exit(this);     // Catch: Throwable -> L93
        f r116 = this.f8284c;     // Catch: Throwable -> L99 BaseException -> L101
        monitor-enter(r116);     // Catch: Throwable -> L99 BaseException -> L101
    L84:
        th = th;
    L86:
        monitor-exit(r116);     // Catch: Throwable -> L88
    L88:
        th = th;
        goto L86
    L87:
        throw th;     // Catch: Throwable -> L162 BaseException -> L164
    L61:
        if (this.f8295q != 0) goto L63;
        r12 = r12;
    L82:
        monitor-exit(r116);     // Catch: Throwable -> L88
        goto L304
    L63:
        if (lb.a.a() == false) goto L68;
        int r46 = this.f8287i.getId();     // Catch: Throwable -> L84
        StringBuilder r47 = new StringBuilder();     // Catch: Throwable -> L84
        r47.append("Change readEnd = ");     // Catch: Throwable -> L88
        r47.append(r115);     // Catch: Throwable -> L88
        r47.append(", segmentNewEndOffset = ");     // Catch: Throwable -> L88
        r47.append(this.f8295q);     // Catch: Throwable -> L88
        r47.append(", segment = ");     // Catch: Throwable -> L88
        r47.append(r10);     // Catch: Throwable -> L88
        lb.a.g("SegmentReader", r46, "loopAndRead", r47.toString());     // Catch: Throwable -> L88
        goto L68
    L309:
        th = th;
    L68:
        r115 = w();     // Catch: Throwable -> L88
        if (r17 <= r115) goto L82;
        long r48 = r115 + 1;     // Catch: Throwable -> L88
        long r49 = r17 - r48;     // Catch: Throwable -> L88
        if (r49 <= 0) goto L271;
        lb.a.h("SegmentReader", this.f8287i.getId(), "loopAndRead", "redundant: " + r49);     // Catch: Throwable -> L88
    L271:
        this.f8297s = r48;     // Catch: Throwable -> L78
        monitor-exit(r116);     // Catch: Throwable -> L78
        r17 = r48;
        r115 = r115;
    L78:
        th = th;
        goto L86
    L92:
        throw new StreamClosedException("loopAndRead");     // Catch: Throwable -> L97
    L93:
        th = th;
    L95:
        monitor-exit(this);     // Catch: Throwable -> L97
        throw th;     // Catch: Throwable -> L162 BaseException -> L164
    L97:
        th = th;
    L101:
        e = e;
    L99:
        th = th;
        r12 = r12;
        goto L163
    L168:
        e = e;
    L166:
        th = th;
        r12 = r12;
    L172:
        e = e;
    L170:
        th = th;
        r12 = r12;
        goto L209
    L176:
        e = e;
    L174:
        th = th;
        r12 = r12;
        r17 = r12;
        goto L209
    L193:
        throw new DownloadRetryNeedlessException(PointerIconCompat.TYPE_WAIT, "the content-length is 0, contentLength = " + r15);     // Catch: Throwable -> L202 BaseException -> L204
    L197:
        e = e;
    L194:
        th = th;
        r12 = r12;
    L196:
        r17 = r12;
        r18 = null;
        goto L208
    L201:
        throw new BaseException(1042, new IOException("inputStream is null"));     // Catch: Throwable -> L202 BaseException -> L204
    L204:
        e = e;
    L202:
        th = th;
    L241:
        th = move-exception;
        com.ss.android.socialbase.downloader.utils.g.b0(new Closeable[]{r14});
        if (r18 == null) goto L248;
        if (r16 == null) goto L267;
    L246:
        r16.f8207c = -1;     // Catch: Throwable -> L264
        r18.b(r16);     // Catch: Throwable -> L264
        a r50 = null;
    L249:
        if (r50 == null) goto L251;
        r11.a(r50);
    L251:
        this.P = System.currentTimeMillis();
        if (r17 <= r12) goto L261;
        rb.a r51 = this.f8288j;
        DownloadInfo r52 = this.f8287i;
        String r53 = this.Q;
        String r54 = this.R;
        String r55 = this.S;
        if (this.f8300v == false) goto L256;
    L259:
        boolean r311 = true;
    L260:
        mb.a.j(r51, r52, r53, r54, r55, r311, this.f8289k, this.f8283J, r17 - r12, TimeUnit.MILLISECONDS.toNanos(this.P - this.O));
        goto L261
    L256:
        if (this.f8301w == true) goto L259;
        r311 = false;
    L261:
        this.f8284c.a(this, r10);
        throw th;
    L267:
        r16 = r11.c();     // Catch: Throwable -> L264
    L248:
        r50 = r16;
    L236:
        e = e;
    L206:
        th = th;
        r12 = r12;
        r17 = r12;
        r18 = null;
        r14 = null;
        goto L208
    }

    private a r(c r10, InputStream r11) {
        a r12 = r10.c();
        int r13 = r11.read(r12.f8205a);     // Catch: Throwable -> L13
        if (r13 == (-1)) goto L12;
        r12.f8207c = r13;     // Catch: Throwable -> L9
        if (r13 != (-1)) goto L8;
        r10.a(r12);
    L8:
        return r12;
    L12:
        throw new BaseException(1073, "probe");     // Catch: Throwable -> L9
    L9:
        th = th;
    L15:
        if (r13 != (-1)) goto L17;
        r10.a(r12);
    L17:
        throw th;
    L13:
        th = th;
        r13 = -1;
        goto L15
    }

    private long w() {
        long r10 = this.f8295q;
        this.f8295q = 0;
        if (r10 > 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r10;
    }

    private void x() {
        this.G = this.M;
        this.M = -1;
        this.N = -1;
        this.O = -1;
        this.P = -1;
        d();
    }

    private void y() {
        if (this.f8293o.f8310d == false) goto L5;
        int r10 = this.f8287i.getRetryCount();
    L6:
        this.C = r10;
        this.D = 0;
        this.E.f();
        return;
    L5:
        r10 = this.f8287i.getBackUpUrlRetryCount();
        goto L6
    }

    void A(boolean r10) {
        this.K = r10;
    }

    void B(Future r10) {
        this.f8299u = r10;
    }

    boolean C(o r10) {
        int r11 = this.H;
        if (r11 < 30) goto L6;
        return false;
    L6:
        this.H = r11 + 1;
        o r12 = this.f8293o;
        if (r12 == null) goto L9;
        r12.h(this);
    L9:
        r10.i(this);
        this.f8293o = r10;
        y();
        return true;
    }

    void E() {
        o r10 = this.f8293o;
        f r11 = this.f8284c;     // Catch: Throwable -> L15
        monitor-enter(r11);     // Catch: Throwable -> L15
        long r12 = j();     // Catch: Throwable -> L11
        if (r12 <= 0) goto L8;
        this.f8298t += r12;     // Catch: Throwable -> L11
        r10.d(r12);     // Catch: Throwable -> L11
    L8:
        this.f8297s = -1;     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        goto L19
    L14:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    }

    public boolean a(long r10) {
        long r11 = this.f8296r;
        if (r10 > 0) goto L8;
        if (r11 <= 0) goto L8;
        return false;
    L8:
        if (r10 > r11) goto L10;
    L12:
        this.f8295q = r10;
        this.A = true;
        return true;
    L10:
        if (r11 <= 0) goto L12;
        return false;
    }

    public void c() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("SegmentReader", this.f8287i.getId(), "close", "ThreadIndex: " + this.f8304z);
    L5:
        monitor-enter(this);
        this.f8300v = true;     // Catch: Throwable -> L17
        this.A = true;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        d();
        Future r10 = this.f8299u;
        if (r10 == null) goto L24;
        this.f8299u = null;
        r10.cancel(true);     // Catch: Throwable -> L14
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

    public long h() {
        return this.f8297s;
    }

    public long i() {
        f r10 = this.f8284c;
        monitor-enter(r10);
        long r11 = this.f8298t + j();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public long j() {
        f r10 = this.f8284c;
        monitor-enter(r10);
        long r11 = this.f8297s;     // Catch: Throwable -> L13
        long r12 = this.f8294p;     // Catch: Throwable -> L13
        if (r12 >= 0) goto L7;
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return 0;
    L7:
        if (r11 <= r12) goto L11;
        long r13 = r11 - r12;     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r13;
    L13:
        th = move-exception;
        throw th;
    }

    long k(long r10, long r11) {
        com.ss.android.socialbase.downloader.utils.f r12 = this.L;
        if (r12 != null) goto L7;
        return -1;
    L7:
        return r12.b(r10, r11);
    }

    long l() {
        return this.f8294p;
    }

    boolean o() {
        return this.K;
    }

    void q(long r10) {
        long r11 = this.f8297s;
        com.ss.android.socialbase.downloader.utils.f r12 = this.L;
        if (r11 < 0) goto L11;
        if (r12 != null) goto L7;
        return;
    L7:
        if (lb.a.a() == false) goto L9;
        lb.a.g("SegmentReader", this.f8287i.getId(), "markProgress", "CurSegmentReadOffset = " + r11 + ", threadIndex = " + this.f8304z);
    L9:
        r12.c(r11, r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.f8303y = Thread.currentThread();     // Catch: Throwable -> L38
        this.f8284c.h(this);     // Catch: Throwable -> L38
        this.f8293o.i(this);     // Catch: Throwable -> L38
    L4:
        i r10 = this.f8284c.f(this, this.f8293o);     // Catch: Throwable -> L38
        if (r10 == null) goto L8;
        this.f8292n = r10;     // Catch: Throwable -> L38
    L23:
        th = move-exception;
        this.f8292n = null;     // Catch: Throwable -> L38
        this.f8284c.i(this, r10);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L25:
        e = move-exception;
        lb.a.h("SegmentReader", this.f8287i.getId(), "run", "SegmentApplyException, Exception = " + e);     // Catch: Throwable -> L23
        int r11 = this.B;     // Catch: Throwable -> L23
        if (r11 >= 50) goto L28;
        this.B = r11 + 1;     // Catch: Throwable -> L23
        this.f8292n = null;     // Catch: Throwable -> L38
        f r12 = this.f8284c;     // Catch: Throwable -> L38
    L15:
        r12.i(this, r10);     // Catch: Throwable -> L38
        goto L4
    L28:
        lb.a.h("SegmentReader", this.f8287i.getId(), "run", "Segment apply failed " + this.B + "times, thread_index = " + this.f8304z);     // Catch: Throwable -> L23
        this.f8292n = null;     // Catch: Throwable -> L38
        f r13 = this.f8284c;     // Catch: Throwable -> L38
    L21:
        r13.i(this, r10);     // Catch: Throwable -> L38
    L31:
        this.f8293o.h(this);     // Catch: Throwable -> L48
        f r14 = this.f8284c;     // Catch: Throwable -> L48
    L41:
        r14.g(this);     // Catch: Throwable -> L48
        goto L42
    L12:
        if (g(r10) == false) goto L18;
        this.f8291m.add(r10);     // Catch: Throwable -> L23 SegmentApplyException -> L25
        this.f8292n = null;     // Catch: Throwable -> L38
        r12 = this.f8284c;     // Catch: Throwable -> L38
        goto L15
    L18:
        if (this.f8300v == true) goto L20;
        lb.a.h("SegmentReader", this.f8287i.getId(), "run", "Download segment failed, segment = " + r10 + ", thread_index = " + this.f8304z + ", failedException = " + this.f8283J);     // Catch: Throwable -> L23 SegmentApplyException -> L25
    L20:
        this.f8292n = null;     // Catch: Throwable -> L38
        r13 = this.f8284c;     // Catch: Throwable -> L38
        goto L21
    L8:
        if (lb.a.a() == false) goto L31;
        lb.a.g("SegmentReader", this.f8287i.getId(), "run", "No more segment, thread_index: " + this.f8304z);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44
        this.f8293o.h(this);     // Catch: Throwable -> L48
        r14 = this.f8284c;     // Catch: Throwable -> L48
    L44:
        th = move-exception;
        this.f8293o.h(this);     // Catch: Throwable -> L49
        this.f8284c.g(this);     // Catch: Throwable -> L49
    L46:
        this.f8303y = null;
        throw th;
    L42:
        this.f8303y = null;
    }

    public void s() {
        t(false);
    }

    public void t(boolean r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("SegmentReader", this.f8287i.getId(), "reconnect", "ThreadIndex: " + this.f8304z);
    L5:
        monitor-enter(this);
        this.f8302x = r10;     // Catch: Throwable -> L15
        this.f8301w = true;     // Catch: Throwable -> L15
        this.A = true;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        d();
        Thread r11 = this.f8303y;
        if (r11 == null) goto L23;
        if (lb.a.a() == false) goto L13;
        lb.a.g("SegmentReader", this.f8287i.getId(), "reconnect", "Interrupt ThreadIndex: " + this.f8304z);     // Catch: Throwable -> L18
    L13:
        r11.interrupt();     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void z(boolean r10) {
    }
}
