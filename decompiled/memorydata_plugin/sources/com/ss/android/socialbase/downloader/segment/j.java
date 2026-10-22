package com.ss.android.socialbase.downloader.segment;

import android.security.obric.guard.ObricSecurityGuardStub;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class j implements com.ss.android.socialbase.downloader.network.c.a, f {
    private float A;
    private int B;
    private final boolean C;
    private final com.ss.android.socialbase.downloader.h.c.b D;
    private final com.ss.android.socialbase.downloader.h.c.b E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DownloadInfo f15621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DownloadTask f15622b;
    private final m c;
    private final b d;
    private final com.ss.android.socialbase.downloader.h.d e;
    private final g f;
    private volatile boolean g;
    private volatile boolean h;
    private final List<l> i;
    private final List<o> j;
    private com.ss.android.socialbase.downloader.model.f k;
    private com.ss.android.socialbase.downloader.model.f l;
    private volatile boolean m;
    private long n;
    private final LinkedList<i> o;
    private final List<i> p;
    private int q;
    private BaseException r;
    private volatile boolean s;
    private final Object t;
    private final com.ss.android.socialbase.downloader.utils.f u;
    private final com.ss.android.socialbase.downloader.h.c v;
    private volatile boolean w;
    private long x;
    private long y;
    private long z;

    public j(DownloadTask r4, DownloadInfo r5, m r6, com.ss.android.socialbase.downloader.h.d r7) {
        com.ss.android.socialbase.downloader.h.d r8 = (com.ss.android.socialbase.downloader.h.d) ZeusTransformUtils.wrapperContextForParams(r7, com.ss.android.socialbase.downloader.h.d.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        this.g = false;
        this.h = false;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.m = true;
        this.o = new LinkedList();
        this.p = new ArrayList();
        this.t = new Object();
        this.w = false;
        this.D = new AnonymousClass1(this);
        this.E = new AnonymousClass2(this);
        this.f15622b = r4;
        this.f15621a = r5;
        this.c = r6;
        b r9 = new b(r6.d(), r6.e());
        this.d = r9;
        this.e = r8;
        this.f = new g(r5, r8, r9);
        this.v = new com.ss.android.socialbase.downloader.h.c();
        this.u = new com.ss.android.socialbase.downloader.utils.f();
        if (com.ss.android.socialbase.downloader.g.a.a(r5.getId()).b("debug") != 1) goto L5;
        r0 = true;
    L5:
        this.C = r0;
    }

    private int a(long r6) {
        int r0 = this.p.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        i r2 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r1), i.class, "com.obric.memorydata.plugin");
        if (r2.c() == r6) goto L6;
        if (r2.c() > r6) goto L16;
        r1 = r1 + 1;
        goto L3
    L16:
        return -1;
    L6:
        return r1;
    L11:
        return -1;
    }

    private int a(String r6) {
        int r0 = this.j.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (TextUtils.equals(((o) ZeusTransformUtils.preCheckCast(this.j.get(r1), o.class, "com.obric.memorydata.plugin")).f15633a, r6) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private long a(int r6, int r7) {
        i r0 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r6), i.class, "com.obric.memorydata.plugin");
        long r3 = a(r0);
        int r8 = r6 + 1;
        if (r8 >= r7) goto L5;
        i r5 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r8), i.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 != null) goto L8;
        return r3;
    L8:
        long r9 = r5.c() - r0.e();
        if (r3 != (-1)) goto L12;
        return r9;
    L12:
        return Math.min(r3, r9);
    L5:
        r5 = null;
        goto L6
    }

    private long a(i r7) {
        long r0 = r7.b();
        if (r0 != (-1)) goto L8;
        long r2 = this.n;
        if (r2 > 0) goto L7;
        return r0;
    L7:
        return r2 - r7.e();
    L8:
        return r0;
    }

    private l a(long r20, long r22, long r24, int r26) {
        Iterator<l> r3 = this.i.iterator();
        long r5 = Long.MAX_VALUE;
        int r7 = 0;
        l r8 = null;
    L4:
        if (r3.hasNext() == false) goto L24;
        l r9 = (l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin");
        if (r9.f <= 0) goto L4;
        r7 = r7 + 1;
        if (r9.f >= r20) goto L20;
        long r17 = r5;
        long r4 = r9.a(r20, r22);
        if (this.C == true) goto L12;
    L14:
        long r1 = 0;
    L16:
        if (r4 >= r1) goto L18;
    L21:
        r5 = r17;
        goto L4
    L18:
        if (r4 >= r17) goto L21;
        r5 = r4;
        r8 = r9;
        goto L4
    L12:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "findPoorReadThread", "Speed = " + r4 + ", threadIndex = " + r9.c);
        r1 = 0;
        goto L16
    L20:
        r17 = r5;
        goto L21
    L24:
        long r18 = r5;
        if (r8 != null) goto L27;
        return null;
    L27:
        if (r7 >= r26) goto L29;
        return null;
    L29:
        if (r18 < r24) goto L31;
        return null;
    L31:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L33;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "findPoorReadThread", "MinSpeed = " + r18 + ", threadIndex = " + r8.c);
    L33:
        return r8;
    }

    static /* synthetic */ l a(j r0, boolean r1, long r2, long r4) {
        return r0.a(r1, r2, r4);
    }

    private l a(boolean r7, long r8, long r10) {
        Iterator<l> r6 = this.i.iterator();
        l r0 = null;
    L4:
        if (r6.hasNext() == false) goto L20;
        l r1 = (l) ZeusTransformUtils.preCheckCast(r6.next(), l.class, "com.obric.memorydata.plugin");
        if (r1.c != 0) goto L10;
        if (r7 == false) goto L4;
    L10:
        if (r1.d <= 0) goto L4;
        if (r1.e > 0) goto L4;
        if ((r8 - r1.d) <= r10) goto L4;
        if (r0 == null) goto L16;
        if (r1.d >= r0.d) goto L4;
    L16:
        r0 = r1;
        goto L4
    L20:
        return r0;
    }

    private void a(BaseException r6) {
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "onError", "Exception: " + r6);
        this.r = r6;
        this.d.c();
        monitor-enter(this);
        Iterator<l> r7 = this.i.iterator();     // Catch: Throwable -> L10
    L6:
        if (r7.hasNext() == false) goto L8;
        ((l) ZeusTransformUtils.preCheckCast(r7.next(), l.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void a(com.ss.android.socialbase.downloader.model.f r12) {
        com.ss.android.socialbase.downloader.model.f r0 = this.k;
        if (r0 != null) goto L7;
        r0 = this.l;
        if (r0 != null) goto L7;
        return;
    L7:
        long r1 = r12.k();
        long r3 = r0.k();
        if (r1 == r3) goto L16;
        String r5 = "Total len not equals,len=" + r1 + ",sLen=" + r3 + ",code=" + r12.c + ",sCode=" + r0.c + ",range=" + r12.e() + ",sRange = " + r0.e() + ",url = " + r12.f15573a + ",sUrl=" + r0.f15573a;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "validateHttpResponse", r5);
        if (r1 <= 0) goto L16;
        if (r3 <= 0) goto L16;
        throw new BaseException(1074, r5);
    L16:
        String r13 = r12.c();
        String r2 = r0.c();
        if (TextUtils.equals(r13, r2) == true) goto L27;
        String r4 = "Etag not equals with main url, etag = " + r13 + ", mainEtag = " + r2;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "validateHttpResponse", r4);
        if (TextUtils.isEmpty(r13) == false) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r2) == false) goto L23;
        return;
    L23:
        if (r13.equalsIgnoreCase(r2) == false) goto L26;
        return;
    L26:
        throw new BaseException(1074, r4);
    }

    private void a(o r9) {
        l r7 = new l(this.f15622b, this.f15621a, this, this.d, r9, this.i.size());
        this.i.add(r7);
        r7.a(com.ss.android.socialbase.downloader.downloader.b.o().submit(r7));
    }

    private void a(List<i> r7, i r8, boolean r9) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        long r1 = r8.c();
        int r10 = r6.size();
        int r3 = 0;
    L3:
        if (r3 >= r10) goto L7;
        if (r1 < ((i) ZeusTransformUtils.preCheckCast(r6.get(r3), i.class, "com.obric.memorydata.plugin")).c()) goto L7;
        r3 = r3 + 1;
    L7:
        r6.add(r3, r8);
        if (r9 == false) goto L13;
        r8.a(r10);
        return;
    }

    private boolean a(long r11, long r13) {
        long r2 = r11 - r13;
        long r0 = this.u.b(r2, r11);
        int r4 = this.i.size();
        if (r4 <= 0) goto L5;
        r0 = r0 / ((long) r4);
    L5:
        l r1 = a(r2, r11, (long) Math.max(10.0f, r0 * this.A), r4 / 2);
        if (r1 == null) goto L12;
        c(r1);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L10;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "findPoorReadThreadAndReconnect", "HandlePoorReadThread: reconnect for poor speed, threadIndex = " + r1.c);
    L10:
        r1.f();
        return true;
    L12:
        l r12 = a(true, r11, r13);
        if (r12 == null) goto L19;
        c(r12);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L17;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "findPoorReadThreadAndReconnect", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + r12.c);
    L17:
        r12.f();
        return true;
    L19:
        return false;
    }

    static /* synthetic */ boolean a(j r0) {
        return r0.g;
    }

    static /* synthetic */ boolean a(j r0, l r1) {
        return r0.c(r1);
    }

    private boolean a(l r7, long r8, long r10, long r12, double r14) {
        if (r7.f <= 0) goto L17;
        long r0 = this.u.b(r8, r10);
        int r2 = this.i.size();
        if (r2 <= 0) goto L7;
        long r3 = r0 / ((long) r2);
    L8:
        long r9 = r7.a(r8, r10);
        if (r9 < r12) goto L13;
        if (r9 < (r3 * r14)) goto L13;
        return false;
    L13:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L19;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "isDownloadSpeedPoor", "TotalSpeed = " + r0 + ", threadAvgSpeed = " + r3 + ", poorSpeed = " + r12 + ", speed = " + r9 + ",threadIndex = " + r7.c);
        return true;
    L19:
        return true;
    L7:
        r3 = r0;
        goto L8
    L17:
        return false;
    }

    private i b(l r7, o r8) {
    L3:
        if (this.o.isEmpty() == true) goto L12;
        i r0 = (i) ZeusTransformUtils.preCheckCast(this.o.poll(), i.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L3;
        a(this.p, r0, true);
        if (a(r0) > 0) goto L11;
        if (this.n > 0) goto L3;
    L11:
        return r0;
    L12:
        m();
        i r9 = c(r7, r8);
        if (r9 != null) goto L15;
    L18:
        i r6 = p();
        if (r6 == null) goto L21;
        return r6;
    L21:
        return null;
    L15:
        if (a(r9) <= 0) goto L18;
        a(this.p, r9, true);
        return r9;
    }

    private void b(long r4) {
        this.u.a(this.f15621a.getCurBytes(), r4);
        Iterator<l> r3 = this.i.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin")).b(r4);
        goto L4
    }

    private void b(l r9, i r10, o r11, com.ss.android.socialbase.downloader.model.f r12) {
        l r0 = r10.f15619a;
        if (r0 == null) goto L9;
        if (r0 == r9) goto L9;
        throw new SegmentApplyException(1, "segment already has an owner");
    L9:
        if (r9.h() != r10.e()) goto L66;
        if (r12.b() == false) goto L13;
    L21:
        com.ss.android.socialbase.downloader.h.d r13 = this.e;
        if (r13 == null) goto L25;
        r13.b(r12.k(), this.f15621a.getMaxBytes());
    L25:
        if (r11.d == true) goto L27;
        a(r12);
        if (this.l != null) goto L78;
        this.l = r12;
        if (this.f15621a.getTotalBytes() > 0) goto L56;
        long r14 = r12.k();
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L55;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "checkSegmentHttpResponseLocked", "Len=" + r14 + ",url=" + r11.f15633a);
    L55:
        this.f15621a.setTotalBytes(r14);
    L56:
        Object r15 = this.t;
        monitor-enter(r15);
        this.t.notify();     // Catch: Throwable -> L61
        monitor-exit(r15);     // Catch: Throwable -> L61
        return;
    L61:
        th = move-exception;
        throw th;
    L78:
        return;
    L27:
        if (this.k != null) goto L64;
        this.k = r12;
        Object r16 = this.t;
        monitor-enter(r16);
        this.t.notify();     // Catch: Throwable -> L45
        monitor-exit(r16);     // Catch: Throwable -> L45
        com.ss.android.socialbase.downloader.h.d r17 = this.e;
        if (r17 == null) goto L35;
        r17.a(r11.f15633a, r12.f15574b, r10.e());
    L35:
        long r18 = r12.k();
        if (r18 <= 0) goto L77;
        Iterator<i> r8 = this.p.iterator();
    L39:
        if (r8.hasNext() == false) goto L80;
        i r19 = (i) ZeusTransformUtils.preCheckCast(r8.next(), i.class, "com.obric.memorydata.plugin");
        if (r19.f() <= 0) goto L44;
        if (r19.f() <= (r18 - 1)) goto L39;
    L44:
        r19.c(r18 - 1);
        goto L39
    L80:
        return;
    L77:
        return;
    L45:
        th = move-exception;
        throw th;
    L64:
        return;
    L13:
        if (r10.e() > 0) goto L20;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "checkSegmentHttpResponseLocked", "Segment.getCurrentOffsetRead = " + r10.e());
        if (r12.a() == true) goto L21;
        throw new DownloadHttpException(1004, r12.c, "2: response code error : " + r12.c + " segment=" + r10);
    L20:
        throw new DownloadHttpException(1004, r12.c, "1: response code error : " + r12.c + " segment=" + r10);
    L66:
        throw new SegmentApplyException(5, "applySegment");
    }

    private void b(String r7, List<o> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (this.C == false) goto L10;
        Iterator r0 = r9.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        o r2 = (o) ZeusTransformUtils.preCheckCast(r0.next(), o.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "addIpListLocked", "UrlRecord: " + r2);
    L10:
        int r1 = this.c.l();
        if (r1 != 1) goto L13;
    L14:
        int r10 = a(r7);
        if (r10 >= 0) goto L17;
    L20:
        this.j.addAll(r9);
        return;
    L17:
        if (r10 >= this.j.size()) goto L20;
        this.j.addAll(r10 + 1, r9);
        return;
    L13:
        if (r1 != 3) goto L20;
        goto L14
    }

    private void b(List<i> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        long r0 = this.f15621a.getTotalBytes();
        this.n = r0;
        if (r0 > 0) goto L7;
        this.n = this.f15621a.getExpectFileLength();
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L7;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "initSegments", "GetExpectFileLength: " + this.n);
    L7:
        monitor-enter(this);
        this.o.clear();     // Catch: Throwable -> L32
        if (r11 != null) goto L11;
    L18:
        long r4 = this.f15621a.getStartOffset();     // Catch: Throwable -> L32
        long r6 = this.f15621a.getEndOffset();     // Catch: Throwable -> L32
        if (r4 >= 0) goto L22;
        r4 = 0;
    L22:
        if (r6 > 0) goto L24;
    L26:
        a(this.o, new i(r4, r6), false);     // Catch: Throwable -> L32
    L28:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L30;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "initSegments", "TotalLength: " + this.n);     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L24:
        if (r6 >= r4) goto L26;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "initSegments", "DownloadInfo.getEndOffset invalid, start = " + r4 + ", end = " + r6);     // Catch: Throwable -> L32
        r6 = -1;
        goto L26
    L11:
        if (r11.isEmpty() == true) goto L18;
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L32
    L15:
        if (r12.hasNext() == false) goto L17;
        a(this.o, new i((i) ZeusTransformUtils.preCheckCast(r12.next(), i.class, "com.obric.memorydata.plugin")), false);     // Catch: Throwable -> L32
        goto L15
    L17:
        d(this.o);     // Catch: Throwable -> L32
        c(this.o);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean b(j r0) {
        return r0.h;
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.model.f c(j r0) {
        return r0.k;
    }

    private i c(l r31, o r32) {
        int r2 = this.p.size();
        long r3 = -1;
        int r5 = -1;
        int r6 = 0;
    L3:
        if (r6 >= r2) goto L8;
        long r7 = a(r6, r2);
        if (r7 <= r3) goto L7;
        r5 = r6;
        r3 = r7;
    L7:
        r6 = r6 + 1;
        goto L3
    L8:
        long r8 = this.c.g();
        long r9 = this.c.i();
        if (r5 >= 0) goto L11;
        return null;
    L11:
        if (r3 <= r8) goto L88;
        i r4 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r5), i.class, "com.obric.memorydata.plugin");
        if (this.p.size() >= this.i.size()) goto L15;
        int r10 = 2;
    L17:
        if (r10 != 1) goto L58;
        l r11 = r4.f15619a;
        if (r11 == null) goto L56;
        long r12 = System.currentTimeMillis();
        long r14 = r12 - WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS;
        long r25 = r11.a(r14, r12);
        long r13 = r31.a(r14, r12);
        if (r25 > 0) goto L23;
    L25:
        float r15 = -1.0f;
    L27:
        if (r15 != (-1.0f)) goto L33;
        long r16 = r11.b();
        float r33 = r15;
        long r17 = r31.b();
        if (r16 > 0) goto L31;
    L34:
        float r18 = r33;
    L36:
        if (r18 <= 0.0f) goto L56;
        float r19 = r18 * 0.9f;
        long r110 = (long) (r3 * r19);
        if (r110 >= r8) goto L41;
        r110 = r8;
    L41:
        if (r9 > 0) goto L43;
    L45:
        r9 = r110;
    L46:
        long r20 = r8 / 2;
        long r111 = r3 - r20;
        if (r9 <= r111) goto L50;
        r9 = r111;
    L52:
        i r21 = new i(r4.e() + (r3 - r9), r4.f());
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L55;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "obtainChildSegmentFromMaxRemain", "parent = " + r4 + ", child = " + r21 + ", maxRemainBytes = " + r3 + ", childLength = " + r9 + ", ratio = " + r19 + ", threadIndex = " + r31.c);
    L55:
        return r21;
    L50:
        if (r9 >= r20) goto L52;
        r9 = r20;
        goto L52
    L43:
        if (r110 <= r9) goto L45;
    L31:
        if (r17 <= 0) goto L34;
        r18 = r17 / (r16 + r17);
        goto L36
    L33:
        r33 = r15;
        goto L34
    L23:
        if (r13 <= 0) goto L25;
        r15 = r13 / (r25 + r13);
    L56:
        String r22 = "obtainChildSegmentFromMaxRemain";
        String r23 = "SegmentDispatcher";
    L79:
        i r1 = new i(r4.e() + (r3 / 2), r4.f());
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L82;
        com.ss.android.socialbase.downloader.e.a.a(r23, this.f15621a.getId(), r22, "parent = " + r4 + ",child = " + r1);
    L82:
        return r1;
    L58:
        if (r10 != 2) goto L78;
        long r112 = this.n - this.f15621a.getCurBytes();
        float r24 = d(r31, r32);
        long r113 = (long) (r112 * r24);
        if (r113 >= r8) goto L63;
        r113 = r8;
    L63:
        if (r9 > 0) goto L65;
    L67:
        r9 = r113;
    L68:
        long r26 = r8 / 2;
        long r114 = r3 - r26;
        if (r9 <= r114) goto L72;
        r9 = r114;
    L74:
        i r27 = new i(r4.e() + (r3 - r9), r4.f());
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L77;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "obtainChildSegmentFromMaxRemain", "parent = " + r4 + ", child = " + r27 + ", maxRemainBytes = " + r3 + ", childLength = " + r9 + ", ratio = " + r24 + ", threadIndex = " + r31.c);
    L77:
        return r27;
    L72:
        if (r9 >= r26) goto L74;
        r9 = r26;
        goto L74
    L65:
        if (r113 <= r9) goto L67;
    L78:
        r22 = "obtainChildSegmentFromMaxRemain";
        r23 = "SegmentDispatcher";
        goto L79
    L15:
        r10 = this.c.n();
        goto L17
    L88:
        return null;
    }

    private List<o> c(String r11, List<InetAddress> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
    L36:
        return null;
    L5:
        if (r13.isEmpty() == true) goto L36;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r14 = r13.iterator();
        int r4 = 0;
    L9:
        if (r14.hasNext() == false) goto L23;
        InetAddress r5 = (InetAddress) ZeusTransformUtils.preCheckCast(r14.next(), InetAddress.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        String r6 = r5.getHostAddress();
        if (TextUtils.isEmpty(r6) == true) goto L9;
        if (this.C == true) goto L17;
    L19:
        o r7 = new o(r11, r6);
        LinkedList r8 = (LinkedList) ZeusTransformUtils.preCheckCast(r2.get(r7.c), LinkedList.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L22;
        r8 = new LinkedList();
        r2.put(r7.c, r8);
    L22:
        r8.add(r7);
        r4 = r4 + 1;
        goto L9
    L17:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L19;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "assembleIpAddress", "Ip: " + r6);
        goto L19
    L23:
        if (r4 <= 0) goto L36;
        ArrayList r10 = new ArrayList();
    L25:
        Iterator r15 = r2.entrySet().iterator();
        boolean r16 = false;
    L27:
        if (r15.hasNext() == false) goto L33;
        LinkedList r0 = (LinkedList) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), LinkedList.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L27;
        if (r0.isEmpty() == true) goto L27;
        r10.add((o) ZeusTransformUtils.preCheckCast(r0.pollFirst(), o.class, "com.obric.memorydata.plugin"));
        r4 = r4 - 1;
        r16 = true;
        goto L27
    L33:
        if (r4 <= 0) goto L35;
        if (r16 == true) goto L25;
    L35:
        return r10;
    }

    private void c() {
        Object r0 = this.t;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.k == null) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L19
        if (this.k == null) goto L13;
        return;
    L13:
        if (this.l != null) goto L24;
        BaseException r2 = this.r;
        if (r2 == null) goto L25;
        throw r2;
    L25:
        return;
    L24:
        return;
    L7:
        if (this.l != null) goto L9;
        this.t.wait();     // Catch: Throwable -> L19
        goto L9
    }

    private void c(List<i> r7) {
        long r0 = n.b((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"));
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "checkDownloadedBytesLocked", "GetCurBytes = " + this.f15621a.getCurBytes() + ", totalBytes = " + this.f15621a.getTotalBytes() + ", downloadedBytes = " + r0);
    L6:
        if (r0 <= this.f15621a.getTotalBytes()) goto L11;
        if (this.f15621a.getTotalBytes() <= 0) goto L11;
        r0 = this.f15621a.getTotalBytes();
    L11:
        if (this.f15621a.getCurBytes() != this.f15621a.getTotalBytes()) goto L13;
        return;
    L13:
        if (this.f15621a.getCurBytes() == r0) goto L17;
        this.f15621a.setCurBytes(r0);
        return;
    }

    private boolean c(l r2) {
        monitor-enter(this);
        o r0 = d(r2);     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        boolean r3 = r2.a(r0);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r3;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    private float d(l r6, o r7) {
        long r0 = r6.b();
        int r8 = this.i.size();
        if (r8 > 1) goto L5;
        r8 = this.c.a();
    L5:
        float r4 = 1.0f;
        if (r0 > 0) goto L19;
        float r5 = this.c.m();
        if (r5 > 0.0f) goto L10;
    L11:
        r5 = 1.0f / r8;
    L13:
        if (r6.c != 0) goto L15;
        return r5;
    L15:
        if (r8 <= 1) goto L18;
        r4 = 1.0f - r5;
        r8 = r8 - 1;
    L18:
        return r4 / r8;
    L10:
        if (r5 < 1.0f) goto L13;
    L19:
        long r9 = o();
        if (r9 <= r0) goto L18;
        return r0 / r9;
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.model.f d(j r0) {
        return r0.l;
    }

    private o d(l r7) {
        Iterator<o> r0 = this.j.iterator();
        o r2 = null;
    L4:
        if (r0.hasNext() == false) goto L14;
        o r3 = (o) ZeusTransformUtils.preCheckCast(r0.next(), o.class, "com.obric.memorydata.plugin");
        if (r3 == r7.f15630b) goto L4;
        if (r3.d() == true) goto L4;
        if (r2 != null) goto L12;
        r2 = r3;
    L12:
        if (r3.a() > 0) goto L4;
    L16:
        if (this.c.b() == false) goto L22;
        if (r3 == null) goto L20;
        return r3;
    L20:
        if (this.c.c() == false) goto L22;
        return null;
    L22:
        return r2;
    L14:
        r3 = null;
        goto L16
    }

    private void d() {
        this.f.a(this.d);     // Catch: BaseException -> L4 StreamClosedException -> L41
    L4:
        e = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "writeSegments", "DispatchSegments: loopAndWrite e = " + e);
        a(e);
        throw e;
    L8:
        if (this.h == false) goto L10;
        return;
    L10:
        if (this.g == true) goto L56;
        monitor-enter(this);     // Catch: Throwable -> L25
    L42:
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L14:
        if (this.o.isEmpty() == true) goto L19;
        i r0 = (i) ZeusTransformUtils.preCheckCast(this.o.poll(), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r0 == null) goto L42;
        a(this.p, r0, true);     // Catch: Throwable -> L22
        goto L42
    L19:
        c(this.p);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
    L28:
        if (this.w == false) goto L35;
        if (this.r == null) goto L35;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "writeSegments", "DispatchSegments: failedException = " + this.r);
        throw this.r;
    L35:
        if (this.f15621a.getCurBytes() == this.f15621a.getTotalBytes()) goto L38;
        com.ss.android.socialbase.downloader.f.a.a(this.f15621a, this.p);
    L38:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L55;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "writeSegments", "DispatchSegments::download finished");
        return;
    L55:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    private void d(List<i> r19) {
        List<i> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        i r3 = (i) ZeusTransformUtils.preCheckCast(r1.get(0), i.class, "com.obric.memorydata.plugin");
        long r4 = this.f15621a.getStartOffset();
        if (r4 >= 0) goto L5;
        r4 = 0;
    L5:
        long r8 = r3.c();
        String r12 = "fixSegmentsLocked";
        if (r8 <= r4) goto L11;
        i r10 = new i(r4, r8 - 1);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L10;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "fixSegmentsLocked", "First = " + r3 + ", add new first = " + r10);
    L10:
        a(r1, r10, true);
    L11:
        Iterator<i> r5 = r1.iterator();
        if (r5.hasNext() == false) goto L25;
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5.next(), i.class, "com.obric.memorydata.plugin");
    L15:
        if (r5.hasNext() == false) goto L25;
        i r7 = (i) ZeusTransformUtils.preCheckCast(r5.next(), i.class, "com.obric.memorydata.plugin");
        if (r6.f() < (r7.c() - 1)) goto L19;
        String r11 = r12;
    L24:
        r6 = r7;
        r12 = r11;
        goto L15
    L19:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L21;
        r11 = r12;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), r11, "Segment = " + r6 + ", new end = " + (r7.c() - 1));
    L22:
        r6.c(r7.c() - 1);
        goto L24
    L21:
        r11 = r12;
    L25:
        String r13 = r12;
        i r2 = (i) ZeusTransformUtils.preCheckCast(r1.get(r1.size() - 1), i.class, "com.obric.memorydata.plugin");
        long r9 = this.f15621a.getEndOffset();
        if (r9 > 0) goto L28;
    L31:
        long r14 = this.f15621a.getTotalBytes();
        if (r14 <= 0) goto L38;
        if (r2.f() != (-1)) goto L36;
        return;
    L36:
        if (r2.f() < (r14 - 1)) goto L38;
        return;
    L38:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L40;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), r13, "Last segment = " + r2 + ", new end=-1");
    L40:
        r2.c(-1);
        return;
    L28:
        if (r9 <= r4) goto L31;
        r2.c(r9);
    }

    static /* synthetic */ long e(j r2) {
        return r2.x;
    }

    private void e() {
        int r1 = 1;
        if (this.n > 0) goto L5;
    L10:
        int r0 = 1;
    L12:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "dispatchReadThread", "TotalLength = " + this.n + ", threadCount = " + r0);
    L14:
        if (r0 <= 0) goto L17;
        r1 = r0;
    L17:
        monitor-enter(this);
    L35:
    L32:
        th = move-exception;
        throw th;
    L19:
        if (this.i.size() >= r1) goto L30;
        if (this.h == true) goto L28;
        if (this.g == true) goto L28;
        a(j());     // Catch: Throwable -> L32
        if (this.c.f() == false) goto L35;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L30:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L5:
        if (this.m == true) goto L10;
        r0 = this.c.a();
        int r2 = (int) (this.n / this.c.h());
        if (r0 <= r2) goto L12;
        r0 = r2;
        goto L12
    }

    private void e(l r24, i r25) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "start " + r25);
    L6:
        if (r25.f15619a != r24) goto L12;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L136;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "ApplySegment:" + r24 + " is already the owner of " + r25);
        return;
    L136:
        return;
    L12:
        if (r25.f15619a == null) goto L14;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "ApplySegment: " + r25 + " is already has an owner:" + r25.f15619a);
        throw new SegmentApplyException(1, "segment already has an owner");
    L14:
        if (r24.h() != r25.e()) goto L124;
        long r8 = r25.c();
        int r3 = a(r8);
        if (r3 == (-1)) goto L121;
        i r11 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r3), i.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L121;
        if (r11 != r25) goto L22;
        long r21 = r8;
    L54:
        long r6 = r25.a();
        int r9 = r3 - 1;
    L56:
        if (r9 < 0) goto L90;
        i r12 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r9), i.class, "com.obric.memorydata.plugin");
        long r14 = r12.f();
        if (r14 <= 0) goto L62;
        if (r14 >= r21) goto L62;
    L78:
        r9 = r9 - 1;
    L62:
        if (r6 > 0) goto L69;
        if (r12.e() <= r21) goto L69;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "Prev's current has over this start, prev = " + r12 + ", segment = " + r25);
        this.p.remove(r25);
        throw new SegmentApplyException(3, "prev overstep");
    L69:
        if (r12.f15619a != null) goto L79;
        r12.c(r21 - 1);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L74;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "Prev set end, prev = " + r12);
    L74:
        if (r12.a() <= 0) goto L78;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L90;
        int r7 = this.f15621a.getId();
        String r10 = "Break";
    L84:
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", r7, "applySegmentLocked", r10);
        goto L90
    L79:
        long r13 = r21 - 1;
        if (r12.f15619a.a(r13) == false) goto L86;
        r12.c(r13);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L90;
        r7 = this.f15621a.getId();
        r10 = "adjustSegmentEndOffset succeed, prev = " + r12;
        goto L84
    L86:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L89;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "adjustSegmentEndOffset filed, prev = " + r12);
    L89:
        throw new SegmentApplyException(4, "prev end adjust fail");
    L90:
        int r4 = r3 + 1;
        int r15 = this.p.size();
    L91:
        if (r4 >= r15) goto L108;
        i r16 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r4), i.class, "com.obric.memorydata.plugin");
        if (r16.a() > 0) goto L98;
        if (r16.f15619a != null) goto L98;
        r4 = r4 + 1;
    L98:
        long r17 = r25.f();
        long r18 = r16.c();
        if (r17 > 0) goto L101;
    L102:
        long r19 = r18 - 1;
        r25.c(r19);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L106;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "segment set end:" + r19 + ", later = " + r16);
    L106:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L108;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "Break 2");
        goto L108
    L101:
        if (r17 < r18) goto L106;
    L108:
        long r20 = r25.f();
        if (r20 > 0) goto L111;
    L117:
        r25.f15619a = r24;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L137;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "ApplySegment: OK " + r25);
        return;
    L137:
        return;
    L111:
        if (r21 > r20) goto L116;
        if (r25.e() <= r20) goto L117;
    L116:
        throw new SegmentApplyException(6, "applySegment: " + r25);
    L22:
        if (r11.c() != r25.c()) goto L47;
        long r110 = a(r11);
        if (r110 <= 0) goto L47;
        l r111 = r11.f15619a;
        if (r111 != null) goto L28;
        r21 = r8;
    L39:
        boolean r22 = com.ss.android.socialbase.downloader.e.a.a();
        if (r111 == null) goto L44;
        if (r22 == false) goto L43;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "Has same segment,and owner too slow, segmentInList = " + r11);
    L43:
        r111.a(true);
    L46:
        r25.c(r11.f());
        r25.b(r11.j());
        this.p.set(r3, r25);
        boolean r112 = true;
    L49:
        if (r112 == true) goto L54;
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "ApplySegment: " + r25 + " not exist! but has another same segment, segmentInList = " + r11);
        throw new SegmentApplyException(2, "segment not exist, but has another same segment");
    L44:
        if (r22 == false) goto L46;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "Has same segment and no owner, segmentInList = " + r11);
        goto L46
    L28:
        if (r110 >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) goto L34;
        r21 = r8;
        if ((r24.f - r111.f) <= 1000) goto L36;
        if ((r11.e() - r25.e()) < (r110 / 2)) goto L39;
    L36:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L48;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "Has same segment, but owner is normal, abort. segmentInList = " + r11);
    L48:
        r112 = false;
        goto L49
    L34:
        r21 = r8;
    L47:
        r21 = r8;
    L121:
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "applySegmentLocked", "ApplySegment: " + r25 + " not exist! segmentIndex = " + r3);
        throw new SegmentApplyException(2, "segment not exist");
    L124:
        throw new SegmentApplyException(5, "applySegment");
    }

    static /* synthetic */ DownloadInfo f(j r0) {
        return r0.f15621a;
    }

    private void f() {
        this.j.add(new o(this.f15621a.getUrl(), true));
        List<String> r0 = this.f15621a.getBackUpUrls();
        if (r0 == null) goto L10;
        Iterator<String> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.j.add(new o(r2, false));
    L10:
        this.c.a(this.j.size());
    }

    static /* synthetic */ List g(j r0) {
        return r0.j;
    }

    private void g() {
        m r0 = this.c;
        this.x = r0.j();
        this.y = r0.k();
        this.A = r0.o();
        int r1 = this.B;
        if (r1 <= 0) goto L6;
        this.v.a(this.D, r1);
        return;
    }

    static /* synthetic */ long h(j r2) {
        return r2.r();
    }

    private void h() {
        if (this.y <= 0) goto L6;
        this.z = System.currentTimeMillis();
        this.v.a(this.E, 0);
        return;
    }

    private void i() {
        int r0 = this.c.l();
        if (r0 > 0) goto L6;
        this.m = false;
        e();
        return;
    L6:
        com.ss.android.socialbase.downloader.network.c r1 = com.ss.android.socialbase.downloader.network.c.a();
        r1.a(this.f15621a.getUrl(), this, 2000);
        if (r0 <= 2) goto L16;
        List<String> r2 = this.f15621a.getBackUpUrls();
        if (r2 == null) goto L22;
        Iterator<String> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L23;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L12;
        r1.a(r4, this, 2000);
        goto L12
    L23:
        return;
    L22:
        return;
    }

    private o j() {
        monitor-enter(this);
        int r0 = this.q % this.j.size();     // Catch: Throwable -> L9
        if (this.c.b() == false) goto L6;
        this.q++;     // Catch: Throwable -> L9
    L6:
        o r1 = (o) ZeusTransformUtils.preCheckCast(this.j.get(r0), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    private void k() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "onComplete", "Run");
    L5:
        this.d.c();
        Object r0 = this.t;
        monitor-enter(r0);
        this.t.notify();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean l() {
        Iterator<l> r3 = this.i.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin")).g() == true) goto L4;
        return false;
    L9:
        return true;
    }

    private void m() {
        if (this.n > 0) goto L5;
        return;
    L5:
        int r0 = this.p.size();
        if (r0 > 1) goto L8;
        return;
    L8:
        ArrayList r4 = null;
        int r5 = 0;
        int r6 = 1;
    L10:
        if (r6 >= r0) goto L28;
        i r10 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r5), i.class, "com.obric.memorydata.plugin");
        i r9 = (i) ZeusTransformUtils.preCheckCast(this.p.get(r6), i.class, "com.obric.memorydata.plugin");
        if (r10.e() <= r9.c()) goto L25;
        if (r9.a() > 0) goto L25;
        if (r9.f15619a != null) goto L25;
        if (r4 != null) goto L19;
        r4 = new ArrayList(1);
    L19:
        r4.add(r9);
        if (this.C == false) goto L27;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L27;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "clearCoveredSegmentLocked", "covered = " + r9 + ", prev = " + r10);
    L27:
        r6 = r6 + 1;
    L25:
        if (r9.e() <= r10.e()) goto L27;
        r5 = r5 + 1;
        goto L27
    L28:
        if (r4 == null) goto L43;
        Iterator r1 = r4.iterator();
    L31:
        if (r1.hasNext() == false) goto L56;
        i r2 = (i) ZeusTransformUtils.preCheckCast(r1.next(), i.class, "com.obric.memorydata.plugin");
        this.p.remove(r2);
        Iterator<l> r3 = this.i.iterator();
    L34:
        if (r3.hasNext() == false) goto L31;
        l r7 = (l) ZeusTransformUtils.preCheckCast(r3.next(), l.class, "com.obric.memorydata.plugin");
        if (r7.f15629a != r2) goto L34;
        if (this.C == true) goto L40;
    L42:
        r7.a(true);
        goto L34
    L40:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L42;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "clearCoveredSegmentLocked", "reconnect, segment = " + r2 + ", threadIndex = " + r7.c);
        goto L42
    L56:
        return;
    }

    private boolean n() {
        long r0 = this.n;
        if (r0 > 0) goto L6;
        this.s = false;
        return false;
    L6:
        monitor-enter(this);
        long r4 = n.a(this.p);     // Catch: Throwable -> L18
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "isAllContentDownloaded", "FirstOffset: " + r4);     // Catch: Throwable -> L18
    L11:
        if (r4 < r0) goto L15;
        this.s = true;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return true;
    L15:
        this.s = false;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    private long o() {
        Iterator<l> r5 = this.i.iterator();
        long r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 + ((l) ZeusTransformUtils.preCheckCast(r5.next(), l.class, "com.obric.memorydata.plugin")).b();
        goto L4
    L6:
        return r0;
    }

    private i p() {
        int r0 = 0;
    L3:
        i r1 = q();
        if (r1 == null) goto L5;
        l r13 = r1.f15619a;
        if (r13 == null) goto L8;
        if (r1.j() >= 2) goto L11;
        long r7 = System.currentTimeMillis();
        b(r7);
        if ((r7 - r13.f) > 2000) goto L15;
    L22:
        int r3 = r0 + 1;
        if (r0 > 2) goto L25;
        monitor-enter(this);     // Catch: InterruptedException -> L38
        wait(500);     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        r0 = r3;
        goto L3
    L35:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L38
    L38:
        return null;
    L25:
        if (this.C == true) goto L27;
    L29:
        return r1;
    L27:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L29;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "obtainSegmentWhenNoNewSegment", "WaitCount > 2, return segment = " + r1);
        goto L29
    L15:
        if (a(r13, r7 - 2000, r7, 500, 1.0d) == false) goto L22;
        if (this.C == true) goto L19;
    L21:
        return r1;
    L19:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L21;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "obtainSegmentWhenNoNewSegment", "IsDownloadSpeedPoor segment = " + r1 + ", owner.threadIndex = " + r13.c);
        goto L21
    L11:
        return null;
    L8:
        return r1;
    L5:
        return null;
    }

    private i q() {
        Iterator<i> r0 = this.p.iterator();
        i r1 = null;
        int r2 = Integer.MAX_VALUE;
    L4:
        if (r0.hasNext() == false) goto L10;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r0.next(), i.class, "com.obric.memorydata.plugin");
        if (a(r3) <= 0) goto L4;
        int r4 = r3.j();
        if (r4 >= r2) goto L4;
        r1 = r3;
        r2 = r4;
        goto L4
    L10:
        return r1;
    }

    private long r() {
        if (this.g == false) goto L5;
        return -1;
    L5:
        if (this.h == true) goto L28;
        long r0 = System.currentTimeMillis();
        monitor-enter(this);
        b(r0);     // Catch: Throwable -> L21
        long r2 = this.c.k();     // Catch: Throwable -> L21
        if (r2 <= 0) goto L19;
        long r6 = this.z;     // Catch: Throwable -> L21
        if (r6 <= 0) goto L19;
        if ((r0 - r6) <= r2) goto L19;
        if (a(r0, r2) == false) goto L19;
        this.z = r0;     // Catch: Throwable -> L21
        this.B++;     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return 2000;
    L21:
        th = move-exception;
        throw th;
    L28:
        return -1;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public i a(l r2, o r3) {
        if (this.g == false) goto L5;
        return null;
    L5:
        if (this.h == true) goto L23;
        monitor-enter(this);
        i r4 = b(r2, r3);     // Catch: Throwable -> L17
        if (r4 == null) goto L15;
        r4.h();     // Catch: Throwable -> L17
        if (r4.j() <= 1) goto L15;
        i r5 = new i(r4);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return r5;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return r4;
    L17:
        th = move-exception;
        throw th;
    L23:
        return null;
    }

    public void a() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "Run");
    L5:
        this.g = true;
        monitor-enter(this);
        Iterator<l> r0 = this.i.iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        ((l) ZeusTransformUtils.preCheckCast(r0.next(), l.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L14
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.f.a();
        this.d.c();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void a(l r3) {
        if (this.C == true) goto L5;
        return;
    L5:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "onReaderRun", "ThreadIndex = " + r3.c);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void a(l r1, i r2) {
        monitor-enter(this);
        r2.i();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void a(l r3, i r4, o r5, com.ss.android.socialbase.downloader.model.f r6) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.g == true) goto L19;
        if (this.h == true) goto L19;
        b(r3, r4, r5, r6);     // Catch: Throwable -> L20
        r3.b(false);     // Catch: Throwable -> L20
        if (this.n > 0) goto L14;
        long r7 = this.f15621a.getTotalBytes();     // Catch: Throwable -> L20
        this.n = r7;     // Catch: Throwable -> L20
        if (r7 > 0) goto L12;
        this.n = r6.k();     // Catch: Throwable -> L20
    L12:
        e();     // Catch: Throwable -> L20
    L16:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L14:
        if (this.c.f() == false) goto L16;
    L19:
        throw new StreamClosedException("connected");     // Catch: Throwable -> L20
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void a(l r5, o r6, i r7, BaseException r8) {
        monitor-enter(this);
        com.ss.android.socialbase.downloader.e.a.b("SegmentDispatcher", this.f15621a.getId(), "onSegmentFailed", "Segment: " + r7 + " e:" + r8);     // Catch: Throwable -> L14
        r5.b(true);     // Catch: Throwable -> L14
        if (r5.c != 0) goto L7;
        this.r = r8;     // Catch: Throwable -> L14
    L7:
        if (l() == true) goto L9;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L9:
        if (this.r != null) goto L11;
        this.r = r8;     // Catch: Throwable -> L14
    L11:
        this.w = true;     // Catch: Throwable -> L14
        a(this.r);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.network.c.a
    public void a(String r3, List<InetAddress> r4) {
        List<InetAddress> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (this.h == false) goto L5;
        return;
    L5:
        if (this.g == true) goto L29;
        List<o> r0 = null;
        r0 = c(r3, r5);     // Catch: Throwable -> L10
    L12:
        monitor-enter(this);
        if (r0 != null) goto L27;
    L15:
        this.m = false;     // Catch: Throwable -> L21
        this.c.a(this.j.size());     // Catch: Throwable -> L21
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "onDnsResolved", "DispatchReadThread");     // Catch: Throwable -> L21
    L18:
        e();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L27:
        b(r3, r0);     // Catch: Throwable -> L21
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public boolean a(l r3, o r4, i r5, BaseException r6, int r7, int r8) {
        int r9 = r6.getErrorCode();
        boolean r10 = false;
        if (r9 != 1083) goto L7;
        a(r6);
        return false;
    L7:
        if (r9 != 1047) goto L9;
    L12:
        r10 = true;
    L14:
        if (com.ss.android.socialbase.downloader.utils.c.b(r6) == false) goto L16;
        r10 = true;
    L16:
        if (r10 == true) goto L18;
        if (r7 >= r8) goto L18;
    L19:
        return true;
    L18:
        c(r3);
        goto L19
    L9:
        if (r9 == 1074) goto L12;
        if (r9 != 1055) goto L14;
        goto L12
    }

    public boolean a(List<i> r8) {
        List<i> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        f();     // Catch: Throwable -> L34
        b(r9);     // Catch: Throwable -> L34
        e();     // Catch: Throwable -> L34
        g();     // Catch: Throwable -> L34
        i();     // Catch: Throwable -> L34
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L34
        c();     // Catch: Throwable -> L31
        long r5 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L34
        this.f15621a.increaseAllConnectTime(r5);     // Catch: Throwable -> L34
        this.f15621a.setFirstSpeedTime(r5);     // Catch: Throwable -> L34
        if (this.h == true) goto L22;
        if (this.g == true) goto L22;
        h();     // Catch: Throwable -> L34
        d();     // Catch: Throwable -> L34
        if (this.h == false) goto L14;
    L19:
        this.v.b();
        return true;
    L14:
        if (this.g == true) goto L19;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "downloadSegments", "Finally pause");
    L18:
        b();
    L22:
        if (this.h == false) goto L24;
    L29:
        this.v.b();
        return true;
    L24:
        if (this.g == true) goto L29;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L28;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "downloadSegments", "Finally pause");
    L28:
        b();
        goto L29
    L31:
        th = move-exception;
        long r6 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L34
        this.f15621a.increaseAllConnectTime(r6);     // Catch: Throwable -> L34
        this.f15621a.setFirstSpeedTime(r6);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (this.h == false) goto L38;
    L43:
        this.v.b();
        throw th;
    L38:
        if (this.g == true) goto L43;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L42;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "downloadSegments", "Finally pause");
    L42:
        b();
        goto L43
    }

    public void b() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "pause", "Run");
    L5:
        this.h = true;
        monitor-enter(this);
        Iterator<l> r0 = this.i.iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        ((l) ZeusTransformUtils.preCheckCast(r0.next(), l.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L14
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.f.b();
        this.d.c();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void b(l r6) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "onReaderExit", "ThreadIndex = " + r6.c);
    L5:
        monitor-enter(this);
        r6.c(true);     // Catch: Throwable -> L21
        this.i.remove(r6);     // Catch: Throwable -> L21
        m();     // Catch: Throwable -> L21
        if (this.i.isEmpty() == false) goto L11;
    L9:
        k();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L11:
        if (n() == false) goto L19;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "onReaderExit", "allContentDownloaded");     // Catch: Throwable -> L21
    L15:
        Iterator<l> r7 = this.i.iterator();     // Catch: Throwable -> L21
    L17:
        if (r7.hasNext() == false) goto L9;
        ((l) ZeusTransformUtils.preCheckCast(r7.next(), l.class, "com.obric.memorydata.plugin")).e();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void b(l r1, i r2) {
        monitor-enter(this);
        e(r1, r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void c(l r6, i r7) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r7.f15619a == r6) goto L6;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L6:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a("SegmentDispatcher", this.f15621a.getId(), "unApplySegment", "Segment: " + r7);     // Catch: Throwable -> L11
    L8:
        r7.d(r6.d());     // Catch: Throwable -> L11
        r7.f15619a = null;     // Catch: Throwable -> L11
        r6.a();     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public e d(l r3, i r4) {
        monitor-enter(this);
        k r5 = new k(this.f15621a, this.d, r4);     // Catch: Throwable -> L6
        this.f.a(r5);     // Catch: Throwable -> L6
        e r6 = r5.a();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r6;
    L6:
        th = move-exception;
        throw th;
    }
}
