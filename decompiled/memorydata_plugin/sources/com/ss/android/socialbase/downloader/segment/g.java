package com.ss.android.socialbase.downloader.segment;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<k> f15615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<k> f15616b;
    private final DownloadInfo c;
    private final com.ss.android.socialbase.downloader.downloader.h d;
    private final com.ss.android.socialbase.downloader.g.a e;
    private final com.ss.android.socialbase.downloader.h.d f;
    private final c g;
    private BaseException h;
    private volatile boolean i;
    private volatile boolean j;
    private volatile boolean k;
    private final com.ss.android.socialbase.downloader.a.a l;
    private final boolean m;
    private final long n;
    private final long o;
    private final long p;
    private boolean q;
    private final boolean r;
    private long s;
    private volatile long t;
    private volatile long u;

    g(DownloadInfo r7, com.ss.android.socialbase.downloader.h.d r8, c r9) {
        com.ss.android.socialbase.downloader.h.d r10 = (com.ss.android.socialbase.downloader.h.d) ZeusTransformUtils.wrapperContextForParams(r8, com.ss.android.socialbase.downloader.h.d.class, "com.obric.memorydata.plugin");
        c r11 = (c) ZeusTransformUtils.wrapperContextForParams(r9, c.class, "com.obric.memorydata.plugin");
        this.f15615a = new LinkedList();
        this.f15616b = new ArrayList();
        boolean r0 = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.q = true;
        this.t = 0;
        this.u = 0;
        this.c = r7;
        this.d = com.ss.android.socialbase.downloader.downloader.b.C();
        this.f = r10;
        this.g = r11;
        this.l = com.ss.android.socialbase.downloader.a.a.a();
        com.ss.android.socialbase.downloader.g.a r12 = com.ss.android.socialbase.downloader.g.a.a(r7.getId());
        this.e = r12;
        if (r12.a("sync_strategy", 0) != 1) goto L5;
        boolean r13 = true;
    L6:
        this.m = r13;
        if (r13 == false) goto L9;
        long r14 = r12.a("sync_interval_ms_fg", 5000);
        long r2 = r12.a("sync_interval_ms_bg", 1000);
        this.n = Math.max(r14, 500);
        this.o = Math.max(r2, 500);
        this.p = r12.a("sync_min_length", 10485760);
    L11:
        if (r12.b("monitor_rw") != 1) goto L13;
        r0 = true;
    L13:
        this.r = r0;
        return;
    L9:
        this.n = 0;
        this.o = 0;
        this.p = 0;
        goto L11
    L5:
        r13 = false;
        goto L6
    }

    private void a(long r7, boolean r9) {
        long r0 = r7 - this.u;
        if (this.m == true) goto L5;
        long r2 = this.c.getCurBytes() - this.t;
        if (r9 == false) goto L14;
    L15:
        c();
        this.u = r7;
        return;
    L14:
        if (a(r2, r0) == true) goto L15;
        return;
    L5:
        if (this.l.b() == false) goto L7;
        long r3 = this.n;
    L9:
        if (r0 > r3) goto L15;
        return;
    L7:
        r3 = this.o;
        goto L9
    }

    private void a(e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        this.f15616b.add((k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void a(List<k> r3) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r2.next(), k.class, "com.obric.memorydata.plugin")).b();
        goto L4
    }

    private void a(List<k> r5, Map<Long, i> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        i r9 = ((k) ZeusTransformUtils.preCheckCast(r8.next(), k.class, "com.obric.memorydata.plugin")).e();
        i r1 = (i) ZeusTransformUtils.preCheckCast(r7.get(Long.valueOf(r9.c())), i.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        r1.a(r9.d());
        r1.c(r9.f());
        goto L4
    L7:
        i r2 = new i(r9);
        r7.put(Long.valueOf(r9.c()), r2);
        goto L4
    }

    private boolean a(long r3, long r5) {
        if (r3 > 65536) goto L5;
    L7:
        return false;
    L5:
        if (r5 <= 500) goto L7;
        return true;
    }

    private void b(List<k> r3) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r2.next(), k.class, "com.obric.memorydata.plugin")).c();
        goto L4
    }

    private void c() {
        boolean r0 = this.r;
        if (r0 == false) goto L5;
        long r1 = System.nanoTime();
    L6:
        DownloadInfo r3 = this.c;
        com.ss.android.socialbase.downloader.downloader.h r4 = this.d;
        List<k> r5 = this.f15615a;
        List<k> r6 = this.f15616b;
        Map<Long, i> r7 = r4.k(r3.getId());
        if (r7 != null) goto L9;
        r7 = new HashMap(4);
    L9:
        boolean r8 = false;
        monitor-enter(this);
        a(r5);     // Catch: Throwable -> L28
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
    L19:
        a(r5, r7);     // Catch: Throwable -> L28
        if (r6.size() <= 0) goto L22;
        c(r6);     // Catch: Throwable -> L28
        r5.removeAll(r6);     // Catch: Throwable -> L28
        r6.clear();     // Catch: Throwable -> L28
    L22:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r8 == false) goto L25;
        r3.updateRealDownloadTime(true);
        r4.a(r3.getId(), r7);
        r4.a(r3);
        this.t = r3.getCurBytes();
    L25:
        if (r0 == false) goto L35;
        this.s += System.nanoTime() - r1;
        return;
    L35:
        return;
    L14:
        if (this.q == false) goto L16;
        b(r5);     // Catch: Throwable -> L17
    L16:
        r8 = true;
    L28:
        th = move-exception;
        throw th;
    L5:
        r1 = 0;
        goto L6
    }

    private void c(List<k> r3) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((k) ZeusTransformUtils.preCheckCast(r2.next(), k.class, "com.obric.memorydata.plugin")).d();
        goto L4
    }

    public void a() {
        this.k = true;
        this.i = true;
    }

    void a(d r28) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r28, d.class, "com.obric.memorydata.plugin");
        if (this.j == false) goto L5;
        return;
    L5:
        if (this.k == true) goto L405;
        this.h = null;
        DownloadInfo r4 = this.c;
        com.ss.android.socialbase.downloader.h.d r3 = this.f;
        c r5 = this.g;
        long r6 = r4.getCurBytes();
        long r8 = System.nanoTime();
        boolean r14 = this.r;
        int r15 = 0;
        if (this.m == false) goto L378;
        long r16 = r4.getTotalBytes();
        if (r16 <= 0) goto L378;
        if (r16 > this.p) goto L378;
        this.q = false;
    L378:
        r4.updateRealStartDownloadTime();     // Catch: Throwable -> L149 BaseException -> L237 StreamClosedException -> L286
        this.u = SystemClock.uptimeMillis();     // Catch: Throwable -> L149 BaseException -> L237 StreamClosedException -> L286
        r15 = 0;
        long r10 = 0;
        long r17 = 0;
        long r22 = 0;
        long r20 = 0;
    L16:
        if (r14 == true) goto L387;
    L18:
        a r2 = r0.a();     // Catch: Throwable -> L140 BaseException -> L143 StreamClosedException -> L146
        if (r14 == true) goto L21;
    L22:
        r22 = r22;
        int r12 = r2.c;     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
        if (r12 != (-1)) goto L28;
        a(r2.f15612b);     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
        r5.a(r2);     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
        goto L16
    L28:
        if (r14 == false) goto L30;
        r10 = System.nanoTime();     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
    L30:
        r2.f15612b.b(r2);     // Catch: Throwable -> L134 BaseException -> L136 StreamClosedException -> L138
        if (r14 == true) goto L33;
    L34:
        long r18 = r17;
        r5.a(r2);     // Catch: Throwable -> L125 BaseException -> L128 StreamClosedException -> L131
        if (this.i == true) goto L38;
    L83:
        r15 = r15 + r12;
        if (r15 < 65536) goto L123;
        r3 = r3;
        long r7 = SystemClock.uptimeMillis();     // Catch: Throwable -> L117 BaseException -> L119 StreamClosedException -> L121
        if ((r7 - r20) <= 200) goto L124;
        long r25 = r10;
        boolean r11 = r3.a(r15);     // Catch: Throwable -> L117 BaseException -> L119 StreamClosedException -> L121
    L115:
        e = e;
    L288:
        this.h = e;     // Catch: Throwable -> L290
        throw e;     // Catch: Throwable -> L290
    L113:
        e = e;
        r15 = 0;
    L240:
        if (this.j == false) goto L242;
    L249:
        if (r15 <= 0) goto L253;
        r3.a(r15);     // Catch: Throwable -> L335
    L253:
        if (this.k == false) goto L376;
    L261:
        Throwable r9 = null;
    L262:
        monitor-enter(this);
        c(this.f15615a);     // Catch: Throwable -> L283
        this.f15615a.clear();     // Catch: Throwable -> L283
        monitor-exit(this);     // Catch: Throwable -> L283
        com.ss.android.socialbase.downloader.f.a.a(this.e, r4, r4.getUrl(), null, this.j, this.k, this.h, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.s, null);
        if (r9 != null) goto L268;
        return;
    L268:
        if (this.j == false) goto L270;
    L275:
        boolean r19 = true;
    L276:
        if (r19 == true) goto L401;
        com.ss.android.socialbase.downloader.utils.c.a(r9, "loopAndWrite_finally");     // Catch: BaseException -> L279
        return;
    L279:
        e = move-exception;
        this.h = e;
        throw e;
    L401:
        return;
    L270:
        if (this.k == true) goto L275;
        if (this.h != null) goto L275;
        r19 = false;
    L283:
        th = move-exception;
        throw th;
    L376:
        this.q = true;     // Catch: Throwable -> L257
        c();     // Catch: Throwable -> L257
    L257:
        th = move-exception;
        r9 = th;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L262;
        com.ss.android.socialbase.downloader.e.a.a("MultiSegmentWriter", r4.getId(), "loopAndWrite", "Finally sync, e = " + r9);
        goto L262
    L242:
        if (this.k == true) goto L249;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L247;
        e.printStackTrace();     // Catch: Throwable -> L290
        com.ss.android.socialbase.downloader.e.a.a("MultiSegmentWriter", r4.getId(), "loopAndWrite", "BaseException: " + e);     // Catch: Throwable -> L290
    L247:
        this.h = e;     // Catch: Throwable -> L290
        throw e;     // Catch: Throwable -> L290
    L111:
        th = th;
        r15 = 0;
    L152:
        if (this.j == false) goto L154;
    L200:
        if (r15 <= 0) goto L204;
        r3.a(r15);     // Catch: Throwable -> L333
    L204:
        if (this.k == false) goto L374;
    L212:
        Throwable r13 = null;
    L213:
        monitor-enter(this);
        c(this.f15615a);     // Catch: Throwable -> L234
        this.f15615a.clear();     // Catch: Throwable -> L234
        monitor-exit(this);     // Catch: Throwable -> L234
        com.ss.android.socialbase.downloader.f.a.a(this.e, r4, r4.getUrl(), null, this.j, this.k, this.h, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.s, null);
        if (r13 != null) goto L219;
        return;
    L219:
        if (this.j == false) goto L221;
    L226:
        boolean r110 = true;
    L227:
        if (r110 == true) goto L399;
        com.ss.android.socialbase.downloader.utils.c.a(r13, "loopAndWrite_finally");     // Catch: BaseException -> L230
        return;
    L230:
        e = move-exception;
        this.h = e;
        throw e;
    L399:
        return;
    L221:
        if (this.k == true) goto L226;
        if (this.h != null) goto L226;
        r110 = false;
    L234:
        th = move-exception;
        throw th;
    L374:
        this.q = true;     // Catch: Throwable -> L208
        c();     // Catch: Throwable -> L208
    L208:
        th = move-exception;
        r13 = th;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L213;
        com.ss.android.socialbase.downloader.e.a.a("MultiSegmentWriter", r4.getId(), "loopAndWrite", "Finally sync, e = " + r13);
        goto L213
    L154:
        if (this.k == true) goto L200;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L348;
        th.printStackTrace();     // Catch: Throwable -> L290
        com.ss.android.socialbase.downloader.e.a.a("MultiSegmentWriter", r4.getId(), "loopAndWrite", "Throwable: " + th);     // Catch: Throwable -> L290
    L348:
        com.ss.android.socialbase.downloader.utils.c.a(th, "loopAndWrite");     // Catch: BaseException -> L197 Throwable -> L290
        if (r15 <= 0) goto L164;
        r3.a(r15);     // Catch: Throwable -> L332
    L164:
        if (this.k == false) goto L360;
    L172:
        Throwable r21 = null;
    L173:
        monitor-enter(this);
        c(this.f15615a);     // Catch: Throwable -> L194
        this.f15615a.clear();     // Catch: Throwable -> L194
        monitor-exit(this);     // Catch: Throwable -> L194
        com.ss.android.socialbase.downloader.f.a.a(this.e, r4, r4.getUrl(), null, this.j, this.k, this.h, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.s, null);
        if (r21 != null) goto L179;
        return;
    L179:
        if (this.j == false) goto L181;
    L186:
        boolean r111 = true;
    L187:
        if (r111 == true) goto L397;
        com.ss.android.socialbase.downloader.utils.c.a(r21, "loopAndWrite_finally");     // Catch: BaseException -> L190
        return;
    L190:
        e = move-exception;
        this.h = e;
        throw e;
    L397:
        return;
    L181:
        if (this.k == true) goto L186;
        if (this.h != null) goto L186;
        r111 = false;
    L194:
        th = move-exception;
        throw th;
    L360:
        this.q = true;     // Catch: Throwable -> L168
        c();     // Catch: Throwable -> L168
    L168:
        th = move-exception;
        r21 = th;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L173;
        com.ss.android.socialbase.downloader.e.a.a("MultiSegmentWriter", r4.getId(), "loopAndWrite", "Finally sync, e = " + r21);
        goto L173
    L197:
        e = move-exception;
        this.h = e;     // Catch: Throwable -> L290
        throw e;     // Catch: Throwable -> L290
    L90:
        if (this.q == false) goto L93;
        a(r7, r11);     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
    L93:
        if (com.ss.android.socialbase.downloader.network.b.g() == false) goto L95;
    L110:
        r20 = r7;
        r3 = r3;
        r17 = r18;
        r22 = r22;
        r10 = r25;
        r15 = 0;
        goto L16
    L95:
        if (r4.isOnlyWifi() == false) goto L102;
        com.ss.android.socialbase.downloader.network.b.f();     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
        if (com.ss.android.socialbase.downloader.network.b.h() == false) goto L102;
        throw new DownloadOnlyWifiException();     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
    L102:
        if (r4.isDownloadFromReserveWifi() == false) goto L110;
        if (r4.isPauseReserveOnWifi() == false) goto L110;
        com.ss.android.socialbase.downloader.network.b.f();     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
        if (com.ss.android.socialbase.downloader.network.b.h() == false) goto L110;
        throw new DownloadPauseReserveWifiException();     // Catch: Throwable -> L111 BaseException -> L113 StreamClosedException -> L115
    L124:
        r3 = r3;
        r17 = r18;
        r10 = r10;
    L121:
        e = e;
    L119:
        e = e;
    L130:
        r15 = r15;
    L117:
        th = th;
    L127:
        r15 = r15;
        goto L152
    L123:
        r3 = r3;
        goto L124
    L38:
        if (this.j == true) goto L45;
        if (this.k == true) goto L45;
        this.i = false;     // Catch: Throwable -> L125 BaseException -> L128 StreamClosedException -> L131
    L45:
        if (r15 <= 0) goto L49;
        r3.a(r15);     // Catch: Throwable -> L331
    L49:
        if (this.k == true) goto L57;
        boolean r23 = true;
        this.q = true;     // Catch: Throwable -> L53
        c();     // Catch: Throwable -> L53
    L58:
        Throwable th = null;
    L59:
        monitor-enter(this);
        c(this.f15615a);     // Catch: Throwable -> L80
        this.f15615a.clear();     // Catch: Throwable -> L80
        monitor-exit(this);     // Catch: Throwable -> L80
        boolean r112 = r23;
        com.ss.android.socialbase.downloader.f.a.a(this.e, r4, r4.getUrl(), null, this.j, this.k, this.h, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.s, null);
        if (th != null) goto L65;
        return;
    L65:
        if (this.j == false) goto L67;
    L72:
        boolean r113 = r112;
    L73:
        if (r113 == true) goto L395;
        com.ss.android.socialbase.downloader.utils.c.a(th, "loopAndWrite_finally");     // Catch: BaseException -> L76
        return;
    L76:
        e = move-exception;
        this.h = e;
        throw e;
    L395:
        return;
    L67:
        if (this.k == true) goto L72;
        if (this.h != null) goto L72;
        r113 = false;
    L80:
        th = move-exception;
        throw th;
    L53:
        th = th;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L59;
        com.ss.android.socialbase.downloader.e.a.a("MultiSegmentWriter", r4.getId(), "loopAndWrite", "Finally sync, e = " + th);
        goto L59
    L57:
        r23 = true;
    L131:
        e = e;
    L128:
        e = e;
        r3 = r3;
    L125:
        th = th;
        r3 = r3;
        goto L127
    L33:
        r17 = r17 + (System.nanoTime() - r10);
        goto L34
    L138:
        e = e;
    L136:
        e = e;
    L145:
        r18 = r17;
    L134:
        th = th;
    L142:
        r18 = r17;
        goto L152
    L21:
        r22 = r22 + (System.nanoTime() - r10);
        goto L22
    L387:
        r10 = System.nanoTime();     // Catch: Throwable -> L140 BaseException -> L143 StreamClosedException -> L146
    L146:
        e = e;
    L143:
        e = e;
        r22 = r22;
    L140:
        th = th;
        r22 = r22;
        goto L142
    L290:
        th = move-exception;
        if (r15 <= 0) goto L296;
        r3.a(r15);     // Catch: Throwable -> L334
    L296:
        if (this.k == true) goto L304;
        boolean r114 = true;
        this.q = true;     // Catch: Throwable -> L300
        c();     // Catch: Throwable -> L300
    L305:
        Throwable th2 = null;
    L306:
        monitor-enter(this);
        c(this.f15615a);     // Catch: Throwable -> L327
        this.f15615a.clear();     // Catch: Throwable -> L327
        boolean r26 = r114;
        com.ss.android.socialbase.downloader.f.a.a(this.e, r4, r4.getUrl(), null, this.j, this.k, this.h, r4.getCurBytes() - r6, System.nanoTime() - r8, r14, r22, r18, this.s, null);
        if (th2 != null) goto L312;
        throw th;
    L312:
        if (this.j == false) goto L314;
    L319:
        boolean r115 = r26;
    L320:
        if (r115 == true) goto L403;
        com.ss.android.socialbase.downloader.utils.c.a(th2, "loopAndWrite_finally");     // Catch: BaseException -> L323
        throw th;
    L323:
        e = move-exception;
        this.h = e;
        throw e;
    L403:
        throw th;
    L314:
        if (this.k == true) goto L319;
        if (this.h != null) goto L319;
        r115 = false;
    L327:
        th = move-exception;
        throw th;
    L300:
        th2 = th;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L306;
        com.ss.android.socialbase.downloader.e.a.a("MultiSegmentWriter", r4.getId(), "loopAndWrite", "Finally sync, e = " + th2);
        goto L306
    L304:
        r114 = true;
    L286:
        e = e;
    L237:
        e = e;
        r3 = r3;
        r15 = 0;
        r18 = 0;
        r22 = 0;
    L149:
        th = th;
        r3 = r3;
        r15 = 0;
        r18 = 0;
        r22 = 0;
        goto L152
    }

    void a(k r2) {
        monitor-enter(this);
        this.f15615a.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void b() {
        this.j = true;
        this.i = true;
    }
}
