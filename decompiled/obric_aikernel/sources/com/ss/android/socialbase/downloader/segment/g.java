package com.ss.android.socialbase.downloader.segment;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<k> f8220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<k> f8221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DownloadInfo f8222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final jb.i f8223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final rb.a f8224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final sb.d f8225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f8226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BaseException f8227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f8228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f8229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f8230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final za.a f8231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f8232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f8233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f8234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f8235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8236q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f8237r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f8238s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile long f8239t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile long f8240u;

    g(DownloadInfo r10, sb.d r11, c r12) {
        this.f8220a = new LinkedList();
        this.f8221b = new ArrayList();
        boolean r13 = false;
        this.f8228i = false;
        this.f8229j = false;
        this.f8230k = false;
        this.f8236q = true;
        this.f8239t = 0;
        this.f8240u = 0;
        this.f8222c = r10;
        this.f8223d = com.ss.android.socialbase.downloader.downloader.a.o();
        this.f8225f = r11;
        this.f8226g = r12;
        this.f8231l = za.a.k();
        rb.a r14 = rb.a.g(r10.getId());
        this.f8224e = r14;
        if (r14.o("sync_strategy", 0) != 1) goto L5;
        boolean r15 = true;
    L6:
        this.f8232m = r15;
        if (r15 == false) goto L9;
        long r16 = r14.o("sync_interval_ms_fg", 5000);
        long r17 = r14.o("sync_interval_ms_bg", 1000);
        this.f8233n = Math.max(r16, 500);
        this.f8234o = Math.max(r17, 500);
        this.f8235p = r14.s("sync_min_length", 10485760);
    L11:
        if (r14.n("monitor_rw") != 1) goto L13;
        r13 = true;
    L13:
        this.f8237r = r13;
        return;
    L9:
        this.f8233n = 0;
        this.f8234o = 0;
        this.f8235p = 0;
        goto L11
    L5:
        r15 = false;
        goto L6
    }

    private void c(long r10, boolean r11) {
        long r12 = r10 - this.f8240u;
        if (this.f8232m == true) goto L5;
        long r13 = this.f8222c.getCurBytes() - this.f8239t;
        if (r11 == false) goto L14;
    L15:
        f();
        this.f8240u = r10;
        return;
    L14:
        if (g(r13, r12) == true) goto L15;
        return;
    L5:
        if (this.f8231l.o() == false) goto L7;
        long r14 = this.f8233n;
    L9:
        if (r12 > r14) goto L15;
        return;
    L7:
        r14 = this.f8234o;
        goto L9
    }

    private void d(List<k> r10) {
        Iterator<k> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().a();
        goto L4
    }

    private void e(List<k> r10) {
        Iterator<k> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().d();
        goto L4
    }

    private void f() {
        boolean r10 = this.f8237r;
        if (r10 == false) goto L5;
        long r11 = System.nanoTime();
    L6:
        DownloadInfo r12 = this.f8222c;
        jb.i r13 = this.f8223d;
        List<k> r14 = this.f8220a;
        List<k> r15 = this.f8221b;
        Map<Long, i> r16 = r13.l2(r12.getId());
        if (r16 != null) goto L9;
        r16 = new HashMap(4);
    L9:
        boolean r17 = false;
        monitor-enter(this);
        e(r14);     // Catch: Throwable -> L28
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
    L19:
        l(r14, r16);     // Catch: Throwable -> L28
        if (r15.size() <= 0) goto L22;
        d(r15);     // Catch: Throwable -> L28
        r14.removeAll(r15);     // Catch: Throwable -> L28
        r15.clear();     // Catch: Throwable -> L28
    L22:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r17 == false) goto L25;
        r12.updateRealDownloadTime(true);
        r13.U0(r12.getId(), r16);
        r13.b(r12);
        this.f8239t = r12.getCurBytes();
    L25:
        if (r10 == false) goto L35;
        this.f8238s += System.nanoTime() - r11;
        return;
    L35:
        return;
    L14:
        if (this.f8236q == false) goto L16;
        k(r14);     // Catch: Throwable -> L17
    L16:
        r17 = true;
    L28:
        th = move-exception;
        throw th;
    L5:
        r11 = 0;
        goto L6
    }

    private boolean g(long r10, long r11) {
        if (r10 > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) goto L5;
    L7:
        return false;
    L5:
        if (r11 <= 500) goto L7;
        return true;
    }

    private void i(e r10) {
        monitor-enter(this);
        this.f8221b.add((k) r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void k(List<k> r10) {
        Iterator<k> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().g();
        goto L4
    }

    private void l(List<k> r10, Map<Long, i> r11) {
        Iterator<k> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        i r13 = r12.next().e();
        i r14 = r11.get(Long.valueOf(r13.i()));
        if (r14 == null) goto L7;
        r14.m(r13.c());
        r14.o(r13.f());
        goto L4
    L7:
        i r15 = new i(r13);
        r11.put(Long.valueOf(r13.i()), r15);
        goto L4
    }

    void a(k r10) {
        monitor-enter(this);
        this.f8220a.add(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void b() {
        this.f8230k = true;
        this.f8228i = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v40 */
    /* JADX WARN: Type inference failed for: r15v42 */
    /* JADX WARN: Type inference failed for: r15v47 */
    /* JADX WARN: Type inference failed for: r15v48 */
    /* JADX WARN: Type inference failed for: r15v57 */
    /* JADX WARN: Type inference failed for: r15v58 */
    /* JADX WARN: Type inference failed for: r15v59 */
    /* JADX WARN: Type inference failed for: r15v60 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v13 */
    /* JADX WARN: Type inference failed for: r26v14 */
    /* JADX WARN: Type inference failed for: r26v18 */
    /* JADX WARN: Type inference failed for: r26v27 */
    /* JADX WARN: Type inference failed for: r26v38 */
    /* JADX WARN: Type inference failed for: r26v39 */
    /* JADX WARN: Type inference failed for: r26v40 */
    /* JADX WARN: Type inference failed for: r26v41 */
    /* JADX WARN: Type inference failed for: r26v42 */
    /* JADX WARN: Type inference failed for: r26v43 */
    /* JADX WARN: Type inference failed for: r26v44 */
    /* JADX WARN: Type inference failed for: r26v45 */
    /* JADX WARN: Type inference failed for: r26v46 */
    /* JADX WARN: Type inference failed for: r26v47 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r26v7 */
    /* JADX WARN: Type inference failed for: r26v8 */
    void h(d r30) {
        if (this.f8229j == false) goto L5;
        return;
    L5:
        if (this.f8230k == true) goto L444;
        int r10 = 0;
        this.f8227h = null;
        DownloadInfo r11 = this.f8222c;
        sb.d r12 = this.f8225f;
        c r13 = this.f8226g;
        long r14 = r11.getCurBytes();
        long r15 = System.nanoTime();
        boolean r16 = this.f8237r;
        int r17 = 0;
        ?? r18 = 0;
        if (this.f8232m == false) goto L359;
        long r19 = r11.getTotalBytes();
        if (r19 <= 0) goto L359;
        if (r19 > this.f8235p) goto L359;
        this.f8236q = false;
    L359:
        r11.updateRealStartDownloadTime();     // Catch: Throwable -> L170 BaseException -> L258 StreamClosedException -> L309
        this.f8240u = SystemClock.uptimeMillis();     // Catch: BaseException -> L168 Throwable -> L170 StreamClosedException -> L309
        r10 = 0;
        long r22 = 0;
        long r110 = 0;
        long r111 = 0;
        long r112 = 0;
    L17:
        if (r16 == true) goto L418;
    L414:
        a r20 = r30.read();     // Catch: Throwable -> L159 BaseException -> L162 StreamClosedException -> L166
        if (r16 == true) goto L33;
    L34:
        r22 = r22;
        int r113 = r20.f8207c;     // Catch: Throwable -> L152 BaseException -> L154 StreamClosedException -> L156
        if (r113 != (-1)) goto L46;
        i(r20.f8206b);     // Catch: Throwable -> L39 BaseException -> L41 StreamClosedException -> L43
        r13.a(r20);     // Catch: Throwable -> L39 BaseException -> L41 StreamClosedException -> L43
    L43:
        e = e;
        long r24 = r110;
    L45:
        r22 = r22;
    L29:
        r17 = r10;
        ?? r26 = r18;
    L379:
        this.f8227h = e;     // Catch: Throwable -> L313
        throw e;     // Catch: Throwable -> L313
    L313:
        th = move-exception;
        Throwable r23 = th;
        r10 = r17;
        long r114 = r24;
        long r115 = r22;
        ?? r27 = r26;
    L315:
        if (r10 <= 0) goto L319;
        r12.j(r10);     // Catch: Throwable -> L357
    L319:
        if (this.f8230k == true) goto L328;
        this.f8236q = true;     // Catch: Throwable -> L323
        f();     // Catch: Throwable -> L323
    L323:
        Throwable th = th;
        if (lb.a.a() == false) goto L329;
        lb.a.g("MultiSegmentWriter", r11.getId(), "loopAndWrite", "Finally sync, e = " + th);
    L329:
        monitor-enter(this);
        d(this.f8220a);     // Catch: Throwable -> L350
        this.f8220a.clear();     // Catch: Throwable -> L350
        monitor-exit(this);     // Catch: Throwable -> L350
        mb.a.g(this.f8224e, r11, r11.getUrl(), null, this.f8229j, this.f8230k, this.f8227h, r11.getCurBytes() - r14, System.nanoTime() - r15, r16, r115, r114, this.f8238s, null);
        if (th != null) goto L335;
        throw r23;
    L335:
        if (this.f8229j == false) goto L337;
    L342:
        ?? r116 = 1;
    L343:
        if (r116 != 0) goto L442;
        com.ss.android.socialbase.downloader.utils.c.T(th, "loopAndWrite_finally");     // Catch: BaseException -> L346
        throw r23;
    L346:
        e = move-exception;
        this.f8227h = e;
        throw e;
    L442:
        throw r23;
    L337:
        if (this.f8230k == true) goto L342;
        if (this.f8227h != null) goto L342;
        r116 = r27;
    L350:
        th = move-exception;
        throw th;
    L328:
        th = null;
    L41:
        e = e;
    L26:
        long r117 = r110;
        ?? r28 = r18 == true ? 1 : 0;
    L165:
        boolean r118 = true;
        ?? r29 = r28;
    L262:
        if (this.f8229j == false) goto L264;
    L271:
        if (r10 <= 0) goto L275;
        r12.j(r10);     // Catch: Throwable -> L358
    L275:
        if (this.f8230k == false) goto L373;
    L282:
        Throwable r21 = null;
    L283:
        monitor-enter(this);
        d(this.f8220a);     // Catch: Throwable -> L304
        this.f8220a.clear();     // Catch: Throwable -> L304
        monitor-exit(this);     // Catch: Throwable -> L304
        mb.a.g(this.f8224e, r11, r11.getUrl(), null, this.f8229j, this.f8230k, this.f8227h, r11.getCurBytes() - r14, System.nanoTime() - r15, r16, r22, r117, this.f8238s, null);
        if (r21 != null) goto L289;
        return;
    L289:
        if (this.f8229j == false) goto L291;
    L296:
        ?? r119 = 1;
    L297:
        if (r119 != 0) goto L440;
        com.ss.android.socialbase.downloader.utils.c.T(r21, "loopAndWrite_finally");     // Catch: BaseException -> L300
        return;
    L300:
        e = move-exception;
        this.f8227h = e;
        throw e;
    L440:
        return;
    L291:
        if (this.f8230k == true) goto L296;
        if (this.f8227h != null) goto L296;
        r119 = r29;
    L304:
        th = move-exception;
        throw th;
    L373:
        this.f8236q = r118;     // Catch: Throwable -> L278
        f();     // Catch: Throwable -> L278
    L278:
        th = move-exception;
        r21 = th;
        if (lb.a.a() == false) goto L283;
        lb.a.g("MultiSegmentWriter", r11.getId(), "loopAndWrite", "Finally sync, e = " + r21);
        goto L283
    L264:
        if (this.f8230k == true) goto L271;
        if (lb.a.a() == false) goto L269;
        e.printStackTrace();     // Catch: Throwable -> L307
        lb.a.g("MultiSegmentWriter", r11.getId(), "loopAndWrite", "BaseException: " + e);     // Catch: Throwable -> L307
    L269:
        this.f8227h = e;     // Catch: Throwable -> L307
        throw e;     // Catch: Throwable -> L307
    L39:
        th = th;
    L22:
        r114 = r110;
    L23:
        r118 = true;
        ?? r210 = r18;
    L173:
        if (this.f8229j == false) goto L175;
    L220:
        if (r10 <= 0) goto L224;
        r12.j(r10 == true ? 1 : 0);     // Catch: Throwable -> L356
    L224:
        if (this.f8230k == true) goto L233;
        this.f8236q = true;     // Catch: Throwable -> L228
        f();     // Catch: Throwable -> L228
    L228:
        Throwable th2 = th;
        if (lb.a.a() == false) goto L234;
        lb.a.g("MultiSegmentWriter", r11.getId(), "loopAndWrite", "Finally sync, e = " + th2);
    L234:
        monitor-enter(this);
        d(this.f8220a);     // Catch: Throwable -> L255
        this.f8220a.clear();     // Catch: Throwable -> L255
        monitor-exit(this);     // Catch: Throwable -> L255
        mb.a.g(this.f8224e, r11, r11.getUrl(), null, this.f8229j, this.f8230k, this.f8227h, r11.getCurBytes() - r14, System.nanoTime() - r15, r16, r22, r114, this.f8238s, null);
        if (th2 != null) goto L240;
        return;
    L240:
        if (this.f8229j == false) goto L242;
    L247:
        ?? r120 = 1;
    L248:
        if (r120 != 0) goto L438;
        com.ss.android.socialbase.downloader.utils.c.T(th2, "loopAndWrite_finally");     // Catch: BaseException -> L251
        return;
    L251:
        e = move-exception;
        this.f8227h = e;
        throw e;
    L438:
        return;
    L242:
        if (this.f8230k == true) goto L247;
        if (this.f8227h != null) goto L247;
        r120 = r210;
    L255:
        th = move-exception;
        throw th;
    L233:
        th2 = null;
        goto L234
    L175:
        if (this.f8230k == true) goto L220;
        if (lb.a.a() == false) goto L363;
        th.printStackTrace();     // Catch: Throwable -> L307
        lb.a.g("MultiSegmentWriter", r11.getId(), "loopAndWrite", "Throwable: " + th);     // Catch: Throwable -> L307
    L363:
        com.ss.android.socialbase.downloader.utils.c.T(th, "loopAndWrite");     // Catch: BaseException -> L217 Throwable -> L307
        if (r10 <= 0) goto L185;
        r12.j(r10 == true ? 1 : 0);     // Catch: Throwable -> L355
    L185:
        if (this.f8230k == false) goto L395;
    L192:
        Throwable r25 = null;
    L193:
        monitor-enter(this);
        d(this.f8220a);     // Catch: Throwable -> L214
        this.f8220a.clear();     // Catch: Throwable -> L214
        monitor-exit(this);     // Catch: Throwable -> L214
        mb.a.g(this.f8224e, r11, r11.getUrl(), null, this.f8229j, this.f8230k, this.f8227h, r11.getCurBytes() - r14, System.nanoTime() - r15, r16, r22, r114, this.f8238s, null);
        if (r25 != null) goto L199;
        return;
    L199:
        if (this.f8229j == false) goto L201;
    L206:
        ?? r121 = 1;
    L207:
        if (r121 != 0) goto L436;
        com.ss.android.socialbase.downloader.utils.c.T(r25, "loopAndWrite_finally");     // Catch: BaseException -> L210
        return;
    L210:
        e = move-exception;
        this.f8227h = e;
        throw e;
    L436:
        return;
    L201:
        if (this.f8230k == true) goto L206;
        if (this.f8227h != null) goto L206;
        r121 = r210;
    L214:
        th = move-exception;
        throw th;
    L395:
        this.f8236q = r118;     // Catch: Throwable -> L188
        f();     // Catch: Throwable -> L188
    L188:
        th = move-exception;
        r25 = th;
        if (lb.a.a() == false) goto L193;
        lb.a.g("MultiSegmentWriter", r11.getId(), "loopAndWrite", "Finally sync, e = " + r25);
        goto L193
    L217:
        e = move-exception;
        this.f8227h = e;     // Catch: Throwable -> L307
        throw e;     // Catch: Throwable -> L307
    L46:
        if (r16 == false) goto L48;
        r111 = System.nanoTime();     // Catch: Throwable -> L39 BaseException -> L41 StreamClosedException -> L43
    L48:
        r20.f8206b.b(r20);     // Catch: Throwable -> L152 BaseException -> L154 StreamClosedException -> L156
        if (r16 == true) goto L51;
    L52:
        r24 = r110;
        r13.a(r20);     // Catch: Throwable -> L144 BaseException -> L147 StreamClosedException -> L149
        if (this.f8228i == false) goto L104;
        if (this.f8229j == true) goto L66;
    L64:
        e = e;
    L62:
        th = th;
        r114 = r24;
        goto L23
    L58:
        if (this.f8230k == true) goto L66;
        this.f8228i = r18;     // Catch: Throwable -> L62 StreamClosedException -> L64 BaseException -> L147
    L66:
        if (r10 <= 0) goto L70;
        r12.j(r10);     // Catch: Throwable -> L354
    L70:
        if (this.f8230k == true) goto L79;
        this.f8236q = true;     // Catch: Throwable -> L74
        f();     // Catch: Throwable -> L74
    L74:
        Throwable th3 = th;
        if (lb.a.a() == false) goto L80;
        lb.a.g("MultiSegmentWriter", r11.getId(), "loopAndWrite", "Finally sync, e = " + th3);
    L80:
        monitor-enter(this);
        d(this.f8220a);     // Catch: Throwable -> L101
        this.f8220a.clear();     // Catch: Throwable -> L101
        monitor-exit(this);     // Catch: Throwable -> L101
        long r122 = r11.getCurBytes() - r14;
        long r123 = System.nanoTime() - r15;
        rb.a r31 = this.f8224e;
        String r32 = r11.getUrl();
        boolean r33 = this.f8229j;
        boolean r34 = this.f8230k;
        BaseException r35 = this.f8227h;
        long r36 = this.f8238s;
        boolean r211 = r18 == true ? 1 : 0;
        mb.a.g(r31, r11, r32, null, r33, r34, r35, r122, r123, r16, r22, r24, r36, null);
        if (th3 != null) goto L86;
        return;
    L86:
        if (this.f8229j == false) goto L88;
    L93:
        boolean r124 = true;
    L94:
        if (r124 == true) goto L434;
        com.ss.android.socialbase.downloader.utils.c.T(th3, "loopAndWrite_finally");     // Catch: BaseException -> L97
        return;
    L97:
        e = move-exception;
        this.f8227h = e;
        throw e;
    L434:
        return;
    L88:
        if (this.f8230k == true) goto L93;
        if (this.f8227h != null) goto L93;
        r124 = r211 ? 1 : 0;
    L101:
        th = move-exception;
        throw th;
    L79:
        th3 = null;
        goto L80
    L104:
        boolean r212 = r18 == true ? 1 : 0;
        r118 = true;
        r10 = r10 + r113;
        if (r10 < 65536) goto L143;
        long r125 = SystemClock.uptimeMillis();     // Catch: Throwable -> L137 BaseException -> L139 StreamClosedException -> L141
        if ((r125 - r112) <= 200) goto L143;
        boolean r37 = r12.j(r10);     // Catch: Throwable -> L137 BaseException -> L139 StreamClosedException -> L141
    L135:
        e = e;
        r22 = r22;
        r17 = r212 ? 1 : 0;
        r26 = r212;
    L133:
        e = e;
        r117 = r24;
        r10 = r212 ? 1 : 0;
        r29 = r212;
    L131:
        th = th;
        r114 = r24;
        r10 = r212 ? 1 : 0;
        r210 = r212;
        goto L173
    L110:
        if (this.f8236q == false) goto L113;
        c(r125, r37);     // Catch: Throwable -> L131 BaseException -> L133 StreamClosedException -> L135
    L113:
        if (nb.b.f() == false) goto L115;
    L130:
        r112 = r125;
        r110 = r24;
        r10 = r212 ? 1 : 0;
        r18 = r10;
        goto L17
    L115:
        if (r11.isOnlyWifi() == false) goto L122;
        nb.b.k();     // Catch: Throwable -> L131 BaseException -> L133 StreamClosedException -> L135
        if (nb.b.e() == false) goto L122;
        throw new DownloadOnlyWifiException();     // Catch: Throwable -> L131 BaseException -> L133 StreamClosedException -> L135
    L122:
        if (r11.isDownloadFromReserveWifi() == false) goto L130;
        if (r11.isPauseReserveOnWifi() == false) goto L130;
        nb.b.k();     // Catch: Throwable -> L131 BaseException -> L133 StreamClosedException -> L135
        if (nb.b.e() == false) goto L130;
        throw new DownloadPauseReserveWifiException();     // Catch: Throwable -> L131 BaseException -> L133 StreamClosedException -> L135
    L141:
        e = e;
    L151:
        r17 = r10;
        boolean r213 = r212;
    L158:
        r22 = r22;
        r26 = r213;
    L139:
        e = e;
        r117 = r24;
        r29 = r212;
    L137:
        th = th;
    L146:
        r114 = r24;
        r210 = r212;
    L143:
        r110 = r24;
        r18 = r212 ? 1 : 0;
    L147:
        e = e;
        r28 = r18 == true ? 1 : 0;
        r117 = r24;
    L149:
        e = e;
        r212 = r18 == true ? 1 : 0;
    L144:
        th = th;
        r212 = r18 == true ? 1 : 0;
        r118 = true;
        goto L146
    L51:
        r110 = r110 + (System.nanoTime() - r111);
        goto L52
    L156:
        e = e;
        r213 = r18 == true ? 1 : 0;
        r17 = r10;
        r24 = r110;
    L154:
        e = e;
    L164:
        r117 = r110;
        r28 = r18;
    L152:
        th = th;
        r118 = true;
    L161:
        r114 = r110;
        r210 = r18;
        goto L173
    L33:
        r22 = r22 + (System.nanoTime() - r111);
        goto L34
    L166:
        e = e;
        r26 = r18 == true ? 1 : 0;
        r17 = r10;
        r24 = r110;
    L162:
        e = e;
        r22 = r22;
    L159:
        th = th;
        r118 = true;
        r22 = r22;
        goto L161
    L418:
        r111 = System.nanoTime();     // Catch: Throwable -> L20 BaseException -> L24 StreamClosedException -> L27
    L27:
        e = e;
        r24 = r110;
    L24:
        e = e;
        r22 = r22;
    L20:
        th = th;
        r22 = r22;
        goto L22
    L168:
        e = e;
        boolean r214 = false;
        r10 = 0;
        r118 = true;
    L260:
        r117 = 0;
        r22 = 0;
        r29 = r214;
    L258:
        e = e;
        r214 = false;
        r118 = true;
        r10 = 0;
    L307:
        th = move-exception;
        r115 = r22;
        r23 = th;
        r27 = r210;
    L309:
        e = e;
        r26 = 0;
        r22 = 0;
        r24 = 0;
    L170:
        th = th;
        r210 = 0;
        r118 = true;
        r10 = 0;
        r114 = 0;
        r22 = 0;
        goto L173
    }

    public void j() {
        this.f8229j = true;
        this.f8228i = true;
    }
}
