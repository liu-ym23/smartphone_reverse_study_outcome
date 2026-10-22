package com.ss.android.socialbase.downloader.segment;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j implements f, nb.c.InterfaceC0251c {
    private int A;
    private final boolean B;
    private final sb.c.b C;
    private final sb.c.b D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DownloadInfo f8251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.d f8252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m f8253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.segment.b f8254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final sb.d f8255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f8256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f8257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f8258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<l> f8259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<o> f8260j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.g f8261k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.g f8262l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f8263m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f8264n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final LinkedList<i> f8265o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List<i> f8266p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8267q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private BaseException f8268r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Object f8269s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.utils.f f8270t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final sb.c f8271u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile boolean f8272v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f8273w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f8274x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f8275y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f8276z;

    class a implements sb.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f8278b;

        a(j r10) {
            this.f8278b = r10;
        }

        @Override // sb.c.b
        public long a() {
            if (j.l(this.f8278b) == false) goto L5;
        L33:
            return -1;
        L5:
            if (j.m(this.f8278b) == true) goto L33;
            j r10 = this.f8278b;
            monitor-enter(r10);
        L30:
            th = move-exception;
            throw th;
        L10:
            if (j.n(this.f8278b) == null) goto L12;
        L28:
            monitor-exit(r10);     // Catch: Throwable -> L30
            return -1;
        L12:
            if (j.o(this.f8278b) != null) goto L28;
            long r11 = j.p(this.f8278b);     // Catch: Throwable -> L30
            if (r11 > 0) goto L18;
            monitor-exit(r10);     // Catch: Throwable -> L30
            return -1;
        L18:
            this.f8277a++;     // Catch: Throwable -> L30
            l r12 = j.q(this.f8278b, false, System.currentTimeMillis(), r11);     // Catch: Throwable -> L30
            if (r12 != null) goto L21;
            monitor-exit(r10);     // Catch: Throwable -> L30
            return r11;
        L21:
            if (lb.a.a() == false) goto L23;
            lb.a.g("SegmentDispatcher", j.r(this.f8278b).getId(), "onScheduleWatch", "connectWatcher: switchUrl and reconnect");     // Catch: Throwable -> L30
        L23:
            j.s(this.f8278b, r12);     // Catch: Throwable -> L30
            r12.s();     // Catch: Throwable -> L30
            long r13 = ((long) ((this.f8277a / j.t(this.f8278b).size()) + 1)) * r11;     // Catch: Throwable -> L30
            monitor-exit(r10);     // Catch: Throwable -> L30
            return r13;
        }
    }

    class b implements sb.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f8279a;

        b(j r10) {
            this.f8279a = r10;
        }

        @Override // sb.c.b
        public long a() {
            return j.u(this.f8279a);
        }
    }

    public j(@NonNull com.ss.android.socialbase.downloader.model.d r10, @NonNull DownloadInfo r11, @NonNull m r12, sb.d r13) {
        boolean r14 = false;
        this.f8257g = false;
        this.f8258h = false;
        this.f8259i = new ArrayList();
        this.f8260j = new ArrayList();
        this.f8263m = true;
        this.f8265o = new LinkedList();
        this.f8266p = new ArrayList();
        this.f8269s = new Object();
        this.f8272v = false;
        this.C = new a(this);
        this.D = new b(this);
        this.f8252b = r10;
        this.f8251a = r11;
        this.f8253c = r12;
        com.ss.android.socialbase.downloader.segment.b r15 = new com.ss.android.socialbase.downloader.segment.b(r12.c(), r12.d());
        this.f8254d = r15;
        this.f8255e = r13;
        this.f8256f = new g(r11, r13, r15);
        this.f8271u = new sb.c();
        this.f8270t = new com.ss.android.socialbase.downloader.utils.f();
        if (rb.a.g(r11.getId()).n("debug") != 1) goto L5;
        r14 = true;
    L5:
        this.B = r14;
    }

    private void A(List<i> r10) {
        long r11 = n.a(r10);
        if (lb.a.a() == false) goto L6;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "checkDownloadedBytesLocked", "GetCurBytes = " + this.f8251a.getCurBytes() + ", totalBytes = " + this.f8251a.getTotalBytes() + ", downloadedBytes = " + r11);
    L6:
        if (r11 <= this.f8251a.getTotalBytes()) goto L11;
        if (this.f8251a.getTotalBytes() <= 0) goto L11;
        r11 = this.f8251a.getTotalBytes();
    L11:
        if (this.f8251a.getCurBytes() != this.f8251a.getTotalBytes()) goto L13;
        return;
    L13:
        if (this.f8251a.getCurBytes() == r11) goto L17;
        this.f8251a.setCurBytes(r11);
        return;
    }

    private void B(l r10, i r11, o r12, com.ss.android.socialbase.downloader.model.g r13) {
        l r14 = r11.f8248f;
        if (r14 == null) goto L9;
        if (r14 == r10) goto L9;
        throw new SegmentApplyException(1, "segment already has an owner");
    L9:
        if (r10.l() != r11.d()) goto L66;
        if (r13.a() == false) goto L13;
    L21:
        sb.d r15 = this.f8255e;
        if (r15 == null) goto L25;
        r15.a(r13.j(), this.f8251a.getMaxBytes());
    L25:
        if (r12.f8310d == true) goto L27;
        k0(r13);
        if (this.f8262l != null) goto L78;
        this.f8262l = r13;
        if (this.f8251a.getTotalBytes() > 0) goto L56;
        long r16 = r13.j();
        if (lb.a.a() == false) goto L55;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "checkSegmentHttpResponseLocked", "Len=" + r16 + ",url=" + r12.f8307a);
    L55:
        this.f8251a.setTotalBytes(r16);
    L56:
        Object r17 = this.f8269s;
        monitor-enter(r17);
        this.f8269s.notify();     // Catch: Throwable -> L61
        monitor-exit(r17);     // Catch: Throwable -> L61
        return;
    L61:
        th = move-exception;
        throw th;
    L78:
        return;
    L27:
        if (this.f8261k != null) goto L64;
        this.f8261k = r13;
        Object r18 = this.f8269s;
        monitor-enter(r18);
        this.f8269s.notify();     // Catch: Throwable -> L45
        monitor-exit(r18);     // Catch: Throwable -> L45
        sb.d r19 = this.f8255e;
        if (r19 == null) goto L35;
        r19.d(r12.f8307a, r13.f8194b, r11.d());
    L35:
        long r20 = r13.j();
        if (r20 <= 0) goto L77;
        Iterator<i> r21 = this.f8266p.iterator();
    L39:
        if (r21.hasNext() == false) goto L80;
        i r110 = r21.next();
        if (r110.f() <= 0) goto L44;
        if (r110.f() <= (r20 - 1)) goto L39;
    L44:
        r110.o(r20 - 1);
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
        if (r11.d() > 0) goto L20;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "checkSegmentHttpResponseLocked", "Segment.getCurrentOffsetRead = " + r11.d());
        if (r13.m() == true) goto L21;
        throw new DownloadHttpException(PointerIconCompat.TYPE_WAIT, r13.f8195c, "2: response code error : " + r13.f8195c + " segment=" + r11);
    L20:
        throw new DownloadHttpException(PointerIconCompat.TYPE_WAIT, r13.f8195c, "1: response code error : " + r13.f8195c + " segment=" + r11);
    L66:
        throw new SegmentApplyException(5, "applySegment");
    }

    private void C() {
        if (this.f8264n > 0) goto L5;
        return;
    L5:
        int r10 = this.f8266p.size();
        if (r10 > 1) goto L8;
        return;
    L8:
        ArrayList r11 = null;
        int r12 = 0;
        int r13 = 1;
    L10:
        if (r13 >= r10) goto L28;
        i r14 = this.f8266p.get(r12);
        i r15 = this.f8266p.get(r13);
        if (r14.d() <= r15.i()) goto L25;
        if (r15.e() > 0) goto L25;
        if (r15.f8248f != null) goto L25;
        if (r11 != null) goto L19;
        r11 = new ArrayList(1);
    L19:
        r11.add(r15);
        if (this.B == false) goto L27;
        if (lb.a.a() == false) goto L27;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "clearCoveredSegmentLocked", "covered = " + r15 + ", prev = " + r14);
    L27:
        r13 = r13 + 1;
    L25:
        if (r15.d() <= r14.d()) goto L27;
        r12 = r12 + 1;
        goto L27
    L28:
        if (r11 == null) goto L43;
        Iterator r16 = r11.iterator();
    L31:
        if (r16.hasNext() == false) goto L56;
        i r17 = (i) r16.next();
        this.f8266p.remove(r17);
        Iterator<l> r18 = this.f8259i.iterator();
    L34:
        if (r18.hasNext() == false) goto L31;
        l r19 = r18.next();
        if (r19.f8292n != r17) goto L34;
        if (this.B == true) goto L40;
    L42:
        r19.t(true);
        goto L34
    L40:
        if (lb.a.a() == false) goto L42;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "clearCoveredSegmentLocked", "reconnect, segment = " + r17 + ", threadIndex = " + r19.f8304z);
        goto L42
    L56:
        return;
    }

    private void D() {
        int r10 = 1;
        if (this.f8264n > 0) goto L5;
    L10:
        int r11 = 1;
    L12:
        if (lb.a.a() == false) goto L14;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "dispatchReadThread", "TotalLength = " + this.f8264n + ", threadCount = " + r11);
    L14:
        if (r11 <= 0) goto L17;
        r10 = r11;
    L17:
        monitor-enter(this);
    L35:
    L32:
        th = move-exception;
        throw th;
    L19:
        if (this.f8259i.size() >= r10) goto L30;
        if (this.f8258h == true) goto L28;
        if (this.f8257g == true) goto L28;
        E(e0());     // Catch: Throwable -> L32
        if (this.f8253c.p() == false) goto L35;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L30:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L5:
        if (this.f8263m == true) goto L10;
        r11 = this.f8253c.n();
        int r12 = (int) (this.f8264n / this.f8253c.l());
        if (r11 <= r12) goto L12;
        r11 = r12;
        goto L12
    }

    private void E(o r10) {
        l r11 = new l(this.f8252b, this.f8251a, this, this.f8254d, r10, this.f8259i.size());
        this.f8259i.add(r11);
        r11.B(com.ss.android.socialbase.downloader.downloader.a.j().submit(r11));
    }

    private l G(boolean r10, long r11, long r12) {
        Iterator<l> r13 = this.f8259i.iterator();
        l r14 = null;
    L4:
        if (r13.hasNext() == false) goto L20;
        l r15 = r13.next();
        if (r15.f8304z != 0) goto L10;
        if (r10 == false) goto L4;
    L10:
        if (r15.M <= 0) goto L4;
        if (r15.N > 0) goto L4;
        if ((r11 - r15.M) <= r12) goto L4;
        if (r14 == null) goto L16;
        if (r15.M >= r14.M) goto L4;
    L16:
        r14 = r15;
        goto L4
    L20:
        return r14;
    }

    private o H(l r10) {
        Iterator<o> r11 = this.f8260j.iterator();
        o r12 = null;
    L4:
        if (r11.hasNext() == false) goto L14;
        o r13 = r11.next();
        if (r13 == r10.f8293o) goto L4;
        if (r13.e() == true) goto L4;
        if (r12 != null) goto L12;
        r12 = r13;
    L12:
        if (r13.a() > 0) goto L4;
    L16:
        if (this.f8253c.r() == false) goto L22;
        if (r13 == null) goto L20;
        return r13;
    L20:
        if (this.f8253c.s() == false) goto L22;
        return null;
    L22:
        return r12;
    L14:
        r13 = null;
        goto L16
    }

    private l I(long r20, long r22, long r24, int r26) {
        Iterator<l> r10 = this.f8259i.iterator();
        long r11 = Long.MAX_VALUE;
        int r12 = 0;
        l r13 = null;
    L4:
        if (r10.hasNext() == false) goto L24;
        l r14 = r10.next();
        if (r14.O <= 0) goto L4;
        r12 = r12 + 1;
        if (r14.O >= r20) goto L20;
        long r17 = r11;
        long r15 = r14.k(r20, r22);
        if (this.B == true) goto L12;
    L14:
        long r16 = 0;
    L16:
        if (r15 >= r16) goto L18;
    L21:
        r11 = r17;
        goto L4
    L18:
        if (r15 >= r17) goto L21;
        r11 = r15;
        r13 = r14;
        goto L4
    L12:
        if (lb.a.a() == false) goto L14;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "findPoorReadThread", "Speed = " + r15 + ", threadIndex = " + r14.f8304z);
        r16 = 0;
        goto L16
    L20:
        r17 = r11;
        goto L21
    L24:
        long r18 = r11;
        if (r13 != null) goto L27;
        return null;
    L27:
        if (r12 >= r26) goto L29;
        return null;
    L29:
        if (r18 < r24) goto L31;
        return null;
    L31:
        if (lb.a.a() == false) goto L33;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "findPoorReadThread", "MinSpeed = " + r18 + ", threadIndex = " + r13.f8304z);
    L33:
        return r13;
    }

    private boolean J(long r11, long r13) {
        long r10 = r11 - r13;
        long r12 = this.f8270t.b(r10, r11);
        int r14 = this.f8259i.size();
        if (r14 <= 0) goto L5;
        r12 = r12 / ((long) r14);
    L5:
        l r15 = I(r10, r11, (long) Math.max(10.0f, r12 * this.f8276z), r14 / 2);
        if (r15 == null) goto L12;
        j0(r15);
        if (lb.a.a() == false) goto L10;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "findPoorReadThreadAndReconnect", "HandlePoorReadThread: reconnect for poor speed, threadIndex = " + r15.f8304z);
    L10:
        r15.s();
        return true;
    L12:
        l r16 = G(true, r11, r13);
        if (r16 == null) goto L19;
        j0(r16);
        if (lb.a.a() == false) goto L17;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "findPoorReadThreadAndReconnect", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + r16.f8304z);
    L17:
        r16.s();
        return true;
    L19:
        return false;
    }

    private void K(List<i> r20) {
        i r10 = r20.get(0);
        long r11 = this.f8251a.getStartOffset();
        if (r11 >= 0) goto L5;
        r11 = 0;
    L5:
        long r12 = r10.i();
        if (r12 <= r11) goto L11;
        i r13 = new i(r11, r12 - 1);
        if (lb.a.a() == false) goto L10;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "fixSegmentsLocked", "First = " + r10 + ", add new first = " + r13);
    L10:
        x(r20, r13, true);
    L11:
        Iterator<i> r14 = r20.iterator();
        if (r14.hasNext() == false) goto L23;
        i r15 = r14.next();
    L15:
        if (r14.hasNext() == false) goto L23;
        i r16 = r14.next();
        if (r15.f() >= (r16.i() - 1)) goto L22;
        if (lb.a.a() == false) goto L21;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "fixSegmentsLocked", "Segment = " + r15 + ", new end = " + (r16.i() - 1));
    L21:
        r15.o(r16.i() - 1);
    L22:
        r15 = r16;
    L23:
        i r17 = r20.get(r20.size() - 1);
        long r18 = this.f8251a.getEndOffset();
        if (r18 > 0) goto L26;
    L29:
        long r19 = this.f8251a.getTotalBytes();
        if (r19 <= 0) goto L36;
        if (r17.f() != (-1)) goto L34;
        return;
    L34:
        if (r17.f() < (r19 - 1)) goto L36;
        return;
    L36:
        if (lb.a.a() == false) goto L38;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "fixSegmentsLocked", "Last segment = " + r17 + ", new end=-1");
    L38:
        r17.o(-1);
        return;
    L26:
        if (r18 <= r11) goto L29;
        r17.o(r18);
    }

    private float L(l r10, o r11) {
        long r12 = r10.i();
        int r13 = this.f8259i.size();
        if (r13 > 1) goto L5;
        r13 = this.f8253c.n();
    L5:
        float r14 = 1.0f;
        if (r12 > 0) goto L19;
        float r15 = this.f8253c.g();
        if (r15 > 0.0f) goto L10;
    L11:
        r15 = 1.0f / r13;
    L13:
        if (r10.f8304z != 0) goto L15;
        return r15;
    L15:
        if (r13 <= 1) goto L18;
        r14 = 1.0f - r15;
        r13 = r13 - 1;
    L18:
        return r14 / r13;
    L10:
        if (r15 < 1.0f) goto L13;
    L19:
        long r16 = N();
        if (r16 <= r12) goto L18;
        return r12 / r16;
    }

    private long M(i r10) {
        long r11 = r10.h();
        if (r11 != (-1)) goto L8;
        long r12 = this.f8264n;
        if (r12 > 0) goto L7;
        return r11;
    L7:
        return r12 - r10.d();
    L8:
        return r11;
    }

    private long N() {
        Iterator<l> r10 = this.f8259i.iterator();
        long r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + r10.next().i();
        goto L4
    L6:
        return r11;
    }

    private long O(int r10, int r11) {
        i r12 = this.f8266p.get(r10);
        long r13 = M(r12);
        int r14 = r10 + 1;
        if (r14 >= r11) goto L5;
        i r15 = this.f8266p.get(r14);
    L6:
        if (r15 != null) goto L8;
        return r13;
    L8:
        long r16 = r15.i() - r12.d();
        if (r13 != (-1)) goto L12;
        return r16;
    L12:
        return Math.min(r13, r16);
    L5:
        r15 = null;
        goto L6
    }

    private int P(long r10) {
        int r11 = this.f8266p.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L11;
        i r13 = this.f8266p.get(r12);
        if (r13.i() == r10) goto L6;
        if (r13.i() > r10) goto L16;
        r12 = r12 + 1;
        goto L3
    L16:
        return -1;
    L6:
        return r12;
    L11:
        return -1;
    }

    private int Q(String r10) {
        int r11 = this.f8260j.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (TextUtils.equals(this.f8260j.get(r12).f8307a, r10) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return -1;
    }

    private void R() {
        int r10 = this.f8253c.f();
        if (r10 > 0) goto L6;
        this.f8263m = false;
        D();
        return;
    L6:
        nb.c r11 = nb.c.b();
        r11.d(this.f8251a.getUrl(), this, 2000);
        if (r10 <= 2) goto L16;
        List<String> r12 = this.f8251a.getBackUpUrls();
        if (r12 == null) goto L22;
        Iterator<String> r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L23;
        String r14 = r13.next();
        if (TextUtils.isEmpty(r14) == true) goto L12;
        r11.d(r14, this, 2000);
        goto L12
    L23:
        return;
    L22:
        return;
    }

    private void S(List<i> r10) {
        long r11 = this.f8251a.getTotalBytes();
        this.f8264n = r11;
        if (r11 > 0) goto L7;
        this.f8264n = this.f8251a.getExpectFileLength();
        if (lb.a.a() == false) goto L7;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "initSegments", "GetExpectFileLength: " + this.f8264n);
    L7:
        monitor-enter(this);
        this.f8265o.clear();     // Catch: Throwable -> L32
        if (r10 != null) goto L11;
    L18:
        long r12 = this.f8251a.getStartOffset();     // Catch: Throwable -> L32
        long r13 = this.f8251a.getEndOffset();     // Catch: Throwable -> L32
        if (r12 >= 0) goto L22;
        r12 = 0;
    L22:
        if (r13 > 0) goto L24;
    L26:
        x(this.f8265o, new i(r12, r13), false);     // Catch: Throwable -> L32
    L28:
        if (lb.a.a() == false) goto L30;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "initSegments", "TotalLength: " + this.f8264n);     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L24:
        if (r13 >= r12) goto L26;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "initSegments", "DownloadInfo.getEndOffset invalid, start = " + r12 + ", end = " + r13);     // Catch: Throwable -> L32
        r13 = -1;
        goto L26
    L11:
        if (r10.isEmpty() == true) goto L18;
        Iterator<i> r14 = r10.iterator();     // Catch: Throwable -> L32
    L15:
        if (r14.hasNext() == false) goto L17;
        x(this.f8265o, new i(r14.next()), false);     // Catch: Throwable -> L32
        goto L15
    L17:
        K(this.f8265o);     // Catch: Throwable -> L32
        A(this.f8265o);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    private void T() {
        this.f8260j.add(new o(this.f8251a.getUrl(), true));
        List<String> r10 = this.f8251a.getBackUpUrls();
        if (r10 == null) goto L10;
        Iterator<String> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        String r12 = r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L6;
        this.f8260j.add(new o(r12, false));
    L10:
        this.f8253c.q(this.f8260j.size());
    }

    private void U() {
        m r10 = this.f8253c;
        this.f8273w = r10.e();
        this.f8274x = r10.j();
        this.f8276z = r10.h();
        int r11 = this.A;
        if (r11 <= 0) goto L6;
        this.f8271u.a(this.C, r11);
        return;
    }

    private void V() {
        if (this.f8274x <= 0) goto L6;
        this.f8275y = System.currentTimeMillis();
        this.f8271u.a(this.D, 0);
        return;
    }

    private boolean W() {
        long r10 = this.f8264n;
        if (r10 > 0) goto L5;
        return false;
    L5:
        monitor-enter(this);
        long r11 = n.b(this.f8266p);     // Catch: Throwable -> L16
        if (lb.a.a() == false) goto L10;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "isAllContentDownloaded", "FirstOffset: " + r11);     // Catch: Throwable -> L16
    L10:
        if (r11 >= r10) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L16
        return false;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    private boolean X() {
        Iterator<l> r10 = this.f8259i.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r10.next().o() == true) goto L4;
        return false;
    L9:
        return true;
    }

    private boolean Y(l r10, long r11, long r12, long r13, double r14) {
        if (r10.O <= 0) goto L17;
        long r15 = this.f8270t.b(r11, r12);
        int r16 = this.f8259i.size();
        if (r16 <= 0) goto L7;
        long r17 = r15 / ((long) r16);
    L8:
        long r18 = r10.k(r11, r12);
        if (r18 < r13) goto L13;
        if (r18 < (r17 * r14)) goto L13;
        return false;
    L13:
        if (lb.a.a() == false) goto L19;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "isDownloadSpeedPoor", "TotalSpeed = " + r15 + ", threadAvgSpeed = " + r17 + ", poorSpeed = " + r13 + ", speed = " + r18 + ",threadIndex = " + r10.f8304z);
        return true;
    L19:
        return true;
    L7:
        r17 = r15;
        goto L8
    L17:
        return false;
    }

    private void Z(long r10) {
        this.f8270t.c(this.f8251a.getCurBytes(), r10);
        Iterator<l> r11 = this.f8259i.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().q(r10);
        goto L4
    }

    private i a0(l r31, o r32) {
        int r10 = this.f8266p.size();
        long r11 = -1;
        int r12 = -1;
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L8;
        long r14 = O(r13, r10);
        if (r14 <= r11) goto L7;
        r12 = r13;
        r11 = r14;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        long r15 = this.f8253c.m();
        long r16 = this.f8253c.k();
        if (r12 >= 0) goto L11;
        return null;
    L11:
        if (r11 <= r15) goto L88;
        i r17 = this.f8266p.get(r12);
        if (this.f8266p.size() >= this.f8259i.size()) goto L15;
        int r18 = 2;
    L17:
        if (r18 != 1) goto L58;
        l r19 = r17.f8248f;
        if (r19 == null) goto L56;
        long r110 = System.currentTimeMillis();
        long r111 = r110 - 4000;
        long r25 = r19.k(r111, r110);
        long r112 = r31.k(r111, r110);
        if (r25 > 0) goto L23;
    L25:
        float r113 = -1.0f;
    L27:
        if (r113 != (-1.0f)) goto L33;
        long r114 = r19.i();
        float r33 = r113;
        long r115 = r31.i();
        if (r114 > 0) goto L31;
    L34:
        float r116 = r33;
    L36:
        if (r116 <= 0.0f) goto L56;
        float r117 = r116 * 0.9f;
        long r118 = (long) (r11 * r117);
        if (r118 >= r15) goto L41;
        r118 = r15;
    L41:
        if (r16 > 0) goto L43;
    L45:
        r16 = r118;
    L46:
        long r20 = r15 / 2;
        long r119 = r11 - r20;
        if (r16 <= r119) goto L50;
        r16 = r119;
    L52:
        i r21 = new i(r17.d() + (r11 - r16), r17.f());
        if (lb.a.a() == false) goto L55;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "obtainChildSegmentFromMaxRemain", "parent = " + r17 + ", child = " + r21 + ", maxRemainBytes = " + r11 + ", childLength = " + r16 + ", ratio = " + r117 + ", threadIndex = " + r31.f8304z);
    L55:
        return r21;
    L50:
        if (r16 >= r20) goto L52;
        r16 = r20;
        goto L52
    L43:
        if (r118 <= r16) goto L45;
    L31:
        if (r115 <= 0) goto L34;
        r116 = r115 / (r114 + r115);
        goto L36
    L33:
        r33 = r113;
        goto L34
    L23:
        if (r112 <= 0) goto L25;
        r113 = r112 / (r25 + r112);
    L56:
        String r22 = "obtainChildSegmentFromMaxRemain";
        String r23 = "SegmentDispatcher";
    L79:
        i r24 = new i(r17.d() + (r11 / 2), r17.f());
        if (lb.a.a() == false) goto L82;
        lb.a.g(r23, this.f8251a.getId(), r22, "parent = " + r17 + ",child = " + r24);
    L82:
        return r24;
    L58:
        if (r18 != 2) goto L78;
        long r120 = this.f8264n - this.f8251a.getCurBytes();
        float r26 = L(r31, r32);
        long r121 = (long) (r120 * r26);
        if (r121 >= r15) goto L63;
        r121 = r15;
    L63:
        if (r16 > 0) goto L65;
    L67:
        r16 = r121;
    L68:
        long r27 = r15 / 2;
        long r122 = r11 - r27;
        if (r16 <= r122) goto L72;
        r16 = r122;
    L74:
        i r28 = new i(r17.d() + (r11 - r16), r17.f());
        if (lb.a.a() == false) goto L77;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "obtainChildSegmentFromMaxRemain", "parent = " + r17 + ", child = " + r28 + ", maxRemainBytes = " + r11 + ", childLength = " + r16 + ", ratio = " + r26 + ", threadIndex = " + r31.f8304z);
    L77:
        return r28;
    L72:
        if (r16 >= r27) goto L74;
        r16 = r27;
        goto L74
    L65:
        if (r121 <= r16) goto L67;
    L78:
        r22 = "obtainChildSegmentFromMaxRemain";
        r23 = "SegmentDispatcher";
        goto L79
    L15:
        r18 = this.f8253c.i();
        goto L17
    L88:
        return null;
    }

    private i b0() {
        Iterator<i> r10 = this.f8266p.iterator();
        i r11 = null;
        int r12 = Integer.MAX_VALUE;
    L4:
        if (r10.hasNext() == false) goto L10;
        i r13 = r10.next();
        if (M(r13) <= 0) goto L4;
        int r14 = r13.b();
        if (r14 >= r12) goto L4;
        r11 = r13;
        r12 = r14;
        goto L4
    L10:
        return r11;
    }

    private i c0(l r10, o r11) {
    L3:
        if (this.f8265o.isEmpty() == true) goto L12;
        i r12 = this.f8265o.poll();
        if (r12 == null) goto L3;
        x(this.f8266p, r12, true);
        if (M(r12) > 0) goto L11;
        if (this.f8264n > 0) goto L3;
    L11:
        return r12;
    L12:
        C();
        i r13 = a0(r10, r11);
        if (r13 != null) goto L15;
    L18:
        i r14 = d0();
        if (r14 == null) goto L21;
        return r14;
    L21:
        return null;
    L15:
        if (M(r13) <= 0) goto L18;
        x(this.f8266p, r13, true);
        return r13;
    }

    private i d0() {
        int r10 = 0;
    L3:
        i r11 = b0();
        if (r11 == null) goto L5;
        l r13 = r11.f8248f;
        if (r13 == null) goto L8;
        if (r11.b() >= 2) goto L11;
        long r12 = System.currentTimeMillis();
        Z(r12);
        if ((r12 - r13.O) > 2000) goto L15;
    L22:
        int r14 = r10 + 1;
        if (r10 > 2) goto L25;
        monitor-enter(this);     // Catch: InterruptedException -> L38
        wait(500);     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        r10 = r14;
        goto L3
    L35:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L38
    L38:
        return null;
    L25:
        if (this.B == true) goto L27;
    L29:
        return r11;
    L27:
        if (lb.a.a() == false) goto L29;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "obtainSegmentWhenNoNewSegment", "WaitCount > 2, return segment = " + r11);
        goto L29
    L15:
        if (Y(r13, r12 - 2000, r12, 500, 1.0d) == false) goto L22;
        if (this.B == true) goto L19;
    L21:
        return r11;
    L19:
        if (lb.a.a() == false) goto L21;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "obtainSegmentWhenNoNewSegment", "IsDownloadSpeedPoor segment = " + r11 + ", owner.threadIndex = " + r13.f8304z);
        goto L21
    L11:
        return null;
    L8:
        return r11;
    L5:
        return null;
    }

    private o e0() {
        monitor-enter(this);
        int r10 = this.f8267q % this.f8260j.size();     // Catch: Throwable -> L9
        if (this.f8253c.r() == false) goto L6;
        this.f8267q++;     // Catch: Throwable -> L9
    L6:
        o r11 = this.f8260j.get(r10);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
    }

    private void f0() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "onComplete", "Run");
    L5:
        this.f8254d.d();
        Object r10 = this.f8269s;
        monitor-enter(r10);
        this.f8269s.notify();     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void g0(BaseException r10) {
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "onError", "Exception: " + r10);
        this.f8268r = r10;
        this.f8254d.d();
        monitor-enter(this);
        Iterator<l> r11 = this.f8259i.iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().c();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private long i0() {
        if (this.f8257g == false) goto L5;
        return -1;
    L5:
        if (this.f8258h == true) goto L28;
        long r10 = System.currentTimeMillis();
        monitor-enter(this);
        Z(r10);     // Catch: Throwable -> L21
        long r11 = this.f8253c.j();     // Catch: Throwable -> L21
        if (r11 <= 0) goto L19;
        long r12 = this.f8275y;     // Catch: Throwable -> L21
        if (r12 <= 0) goto L19;
        if ((r10 - r12) <= r11) goto L19;
        if (J(r10, r11) == false) goto L19;
        this.f8275y = r10;     // Catch: Throwable -> L21
        this.A++;     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return 2000;
    L21:
        th = move-exception;
        throw th;
    L28:
        return -1;
    }

    private boolean j0(l r10) {
        monitor-enter(this);
        o r11 = H(r10);     // Catch: Throwable -> L11
        if (r11 == null) goto L6;
        boolean r12 = r10.C(r11);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r12;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    private void k0(com.ss.android.socialbase.downloader.model.g r12) {
        com.ss.android.socialbase.downloader.model.g r10 = this.f8261k;
        if (r10 != null) goto L7;
        r10 = this.f8262l;
        if (r10 != null) goto L7;
        return;
    L7:
        long r11 = r12.j();
        long r13 = r10.j();
        if (r11 == r13) goto L16;
        String r14 = "Total len not equals,len=" + r11 + ",sLen=" + r13 + ",code=" + r12.f8195c + ",sCode=" + r10.f8195c + ",range=" + r12.e() + ",sRange = " + r10.e() + ",url = " + r12.f8193a + ",sUrl=" + r10.f8193a;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "validateHttpResponse", r14);
        if (r11 <= 0) goto L16;
        if (r13 <= 0) goto L16;
        throw new BaseException(1074, r14);
    L16:
        String r15 = r12.g();
        String r16 = r10.g();
        if (TextUtils.equals(r15, r16) == true) goto L27;
        String r17 = "Etag not equals with main url, etag = " + r15 + ", mainEtag = " + r16;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "validateHttpResponse", r17);
        if (TextUtils.isEmpty(r15) == false) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r16) == false) goto L23;
        return;
    L23:
        if (r15.equalsIgnoreCase(r16) == false) goto L26;
        return;
    L26:
        throw new BaseException(1074, r17);
    }

    static /* synthetic */ boolean l(j r10) {
        return r10.f8257g;
    }

    private void l0() {
        Object r10 = this.f8269s;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.f8261k == null) goto L7;
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L19
        if (this.f8261k == null) goto L13;
        return;
    L13:
        if (this.f8262l != null) goto L24;
        BaseException r11 = this.f8268r;
        if (r11 == null) goto L25;
        throw r11;
    L25:
        return;
    L24:
        return;
    L7:
        if (this.f8262l != null) goto L9;
        this.f8269s.wait();     // Catch: Throwable -> L19
        goto L9
    }

    static /* synthetic */ boolean m(j r10) {
        return r10.f8258h;
    }

    private void m0() {
        this.f8256f.h(this.f8254d);     // Catch: BaseException -> L4 StreamClosedException -> L41
    L4:
        e = move-exception;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "writeSegments", "DispatchSegments: loopAndWrite e = " + e);
        g0(e);
        throw e;
    L8:
        if (this.f8258h == false) goto L10;
        return;
    L10:
        if (this.f8257g == true) goto L56;
        monitor-enter(this);     // Catch: Throwable -> L25
    L42:
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L14:
        if (this.f8265o.isEmpty() == true) goto L19;
        i r10 = this.f8265o.poll();     // Catch: Throwable -> L22
        if (r10 == null) goto L42;
        x(this.f8266p, r10, true);     // Catch: Throwable -> L22
        goto L42
    L19:
        A(this.f8266p);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
    L28:
        if (this.f8272v == false) goto L35;
        if (this.f8268r == null) goto L35;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "writeSegments", "DispatchSegments: failedException = " + this.f8268r);
        throw this.f8268r;
    L35:
        if (this.f8251a.getCurBytes() == this.f8251a.getTotalBytes()) goto L38;
        mb.a.k(this.f8251a, this.f8266p);
    L38:
        if (lb.a.a() == false) goto L55;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "writeSegments", "DispatchSegments::download finished");
        return;
    L55:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.model.g n(j r10) {
        return r10.f8261k;
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.model.g o(j r10) {
        return r10.f8262l;
    }

    static /* synthetic */ long p(j r10) {
        return r10.f8273w;
    }

    static /* synthetic */ l q(j r10, boolean r11, long r12, long r13) {
        return r10.G(r11, r12, r13);
    }

    static /* synthetic */ DownloadInfo r(j r10) {
        return r10.f8251a;
    }

    static /* synthetic */ boolean s(j r10, l r11) {
        return r10.j0(r11);
    }

    static /* synthetic */ List t(j r10) {
        return r10.f8260j;
    }

    static /* synthetic */ long u(j r10) {
        return r10.i0();
    }

    private void v(String r10, List<o> r11) {
        if (this.B == false) goto L10;
        Iterator<o> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L10;
        o r13 = r12.next();
        if (lb.a.a() == false) goto L6;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "addIpListLocked", "UrlRecord: " + r13);
    L10:
        int r14 = this.f8253c.f();
        if (r14 != 1) goto L13;
    L14:
        int r15 = Q(r10);
        if (r15 >= 0) goto L17;
    L20:
        this.f8260j.addAll(r11);
        return;
    L17:
        if (r15 >= this.f8260j.size()) goto L20;
        this.f8260j.addAll(r15 + 1, r11);
        return;
    L13:
        if (r14 != 3) goto L20;
        goto L14
    }

    private void w(l r23, i r24) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "start " + r24);
    L6:
        if (r24.f8248f != r23) goto L12;
        if (lb.a.a() == false) goto L136;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "ApplySegment:" + r23 + " is already the owner of " + r24);
        return;
    L136:
        return;
    L12:
        if (r24.f8248f == null) goto L14;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "ApplySegment: " + r24 + " is already has an owner:" + r24.f8248f);
        throw new SegmentApplyException(1, "segment already has an owner");
    L14:
        if (r23.l() != r24.d()) goto L124;
        long r10 = r24.i();
        int r11 = P(r10);
        if (r11 == (-1)) goto L121;
        i r12 = this.f8266p.get(r11);
        if (r12 == null) goto L121;
        if (r12 != r24) goto L22;
        long r20 = r10;
    L54:
        long r13 = r24.e();
        int r14 = r11 - 1;
    L56:
        if (r14 < 0) goto L90;
        i r15 = this.f8266p.get(r14);
        long r16 = r15.f();
        if (r16 <= 0) goto L62;
        if (r16 >= r20) goto L62;
    L78:
        r14 = r14 - 1;
    L62:
        if (r13 > 0) goto L69;
        if (r15.d() <= r20) goto L69;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "Prev's current has over this start, prev = " + r15 + ", segment = " + r24);
        this.f8266p.remove(r24);
        throw new SegmentApplyException(3, "prev overstep");
    L69:
        if (r15.f8248f != null) goto L79;
        r15.o(r20 - 1);
        if (lb.a.a() == false) goto L74;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "Prev set end, prev = " + r15);
    L74:
        if (r15.e() <= 0) goto L78;
        if (lb.a.a() == false) goto L90;
        int r17 = this.f8251a.getId();
        String r18 = "Break";
    L84:
        lb.a.g("SegmentDispatcher", r17, "applySegmentLocked", r18);
        goto L90
    L79:
        long r19 = r20 - 1;
        if (r15.f8248f.a(r19) == false) goto L86;
        r15.o(r19);
        if (lb.a.a() == false) goto L90;
        r17 = this.f8251a.getId();
        r18 = "adjustSegmentEndOffset succeed, prev = " + r15;
        goto L84
    L86:
        if (lb.a.a() == false) goto L89;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "adjustSegmentEndOffset filed, prev = " + r15);
    L89:
        throw new SegmentApplyException(4, "prev end adjust fail");
    L90:
        int r21 = r11 + 1;
        int r22 = this.f8266p.size();
    L91:
        if (r21 >= r22) goto L108;
        i r25 = this.f8266p.get(r21);
        if (r25.e() > 0) goto L98;
        if (r25.f8248f != null) goto L98;
        r21 = r21 + 1;
    L98:
        long r110 = r24.f();
        long r111 = r25.i();
        if (r110 > 0) goto L101;
    L102:
        long r26 = r111 - 1;
        r24.o(r26);
        if (lb.a.a() == false) goto L106;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "segment set end:" + r26 + ", later = " + r25);
    L106:
        if (lb.a.a() == false) goto L108;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "Break 2");
        goto L108
    L101:
        if (r110 < r111) goto L106;
    L108:
        long r27 = r24.f();
        if (r27 > 0) goto L111;
    L117:
        r24.f8248f = r23;
        if (lb.a.a() == false) goto L137;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "ApplySegment: OK " + r24);
        return;
    L137:
        return;
    L111:
        if (r20 > r27) goto L116;
        if (r24.d() <= r27) goto L117;
    L116:
        throw new SegmentApplyException(6, "applySegment: " + r24);
    L22:
        if (r12.i() != r24.i()) goto L47;
        long r112 = M(r12);
        if (r112 <= 0) goto L47;
        l r113 = r12.f8248f;
        if (r113 != null) goto L28;
        r20 = r10;
    L39:
        boolean r28 = lb.a.a();
        if (r113 == null) goto L44;
        if (r28 == false) goto L43;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "Has same segment,and owner too slow, segmentInList = " + r12);
    L43:
        r113.t(true);
    L46:
        r24.o(r12.f());
        r24.l(r12.b());
        this.f8266p.set(r11, r24);
        boolean r114 = true;
    L49:
        if (r114 == true) goto L54;
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "ApplySegment: " + r24 + " not exist! but has another same segment, segmentInList = " + r12);
        throw new SegmentApplyException(2, "segment not exist, but has another same segment");
    L44:
        if (r28 == false) goto L46;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "Has same segment and no owner, segmentInList = " + r12);
        goto L46
    L28:
        if (r112 >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) goto L34;
        r20 = r10;
        if ((r23.O - r113.O) <= 1000) goto L36;
        if ((r12.d() - r24.d()) < (r112 / 2)) goto L39;
    L36:
        if (lb.a.a() == false) goto L48;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "Has same segment, but owner is normal, abort. segmentInList = " + r12);
    L48:
        r114 = false;
        goto L49
    L34:
        r20 = r10;
    L47:
        r20 = r10;
    L121:
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "applySegmentLocked", "ApplySegment: " + r24 + " not exist! segmentIndex = " + r11);
        throw new SegmentApplyException(2, "segment not exist");
    L124:
        throw new SegmentApplyException(5, "applySegment");
    }

    private void x(List<i> r10, i r11, boolean r12) {
        long r13 = r11.i();
        int r14 = r10.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L7;
        if (r13 < r10.get(r15).i()) goto L7;
        r15 = r15 + 1;
    L7:
        r10.add(r15, r11);
        if (r12 == false) goto L13;
        r11.p(r14);
        return;
    }

    private List<o> y(String r10, List<InetAddress> r11) {
        if (r11 != null) goto L5;
    L36:
        return null;
    L5:
        if (r11.isEmpty() == true) goto L36;
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<InetAddress> r13 = r11.iterator();
        int r14 = 0;
    L9:
        if (r13.hasNext() == false) goto L23;
        InetAddress r15 = r13.next();
        if (r15 == null) goto L9;
        String r16 = r15.getHostAddress();
        if (TextUtils.isEmpty(r16) == true) goto L9;
        if (this.B == true) goto L17;
    L19:
        o r17 = new o(r10, r16);
        LinkedList r18 = (LinkedList) r12.get(r17.f8309c);
        if (r18 != null) goto L22;
        r18 = new LinkedList();
        r12.put(r17.f8309c, r18);
    L22:
        r18.add(r17);
        r14 = r14 + 1;
        goto L9
    L17:
        if (lb.a.a() == false) goto L19;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "assembleIpAddress", "Ip: " + r16);
        goto L19
    L23:
        if (r14 <= 0) goto L36;
        ArrayList r19 = new ArrayList();
    L25:
        Iterator r110 = r12.entrySet().iterator();
        boolean r111 = false;
    L27:
        if (r110.hasNext() == false) goto L33;
        LinkedList r20 = (LinkedList) ((Map.Entry) r110.next()).getValue();
        if (r20 == null) goto L27;
        if (r20.isEmpty() == true) goto L27;
        r19.add((o) r20.pollFirst());
        r14 = r14 - 1;
        r111 = true;
        goto L27
    L33:
        if (r14 <= 0) goto L35;
        if (r111 == true) goto L25;
    L35:
        return r19;
    }

    public boolean F(List<i> r10) {
        T();     // Catch: Throwable -> L34
        S(r10);     // Catch: Throwable -> L34
        D();     // Catch: Throwable -> L34
        U();     // Catch: Throwable -> L34
        R();     // Catch: Throwable -> L34
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L34
        l0();     // Catch: Throwable -> L31
        long r12 = System.currentTimeMillis() - r11;     // Catch: Throwable -> L34
        this.f8251a.increaseAllConnectTime(r12);     // Catch: Throwable -> L34
        this.f8251a.setFirstSpeedTime(r12);     // Catch: Throwable -> L34
        if (this.f8258h == true) goto L22;
        if (this.f8257g == true) goto L22;
        V();     // Catch: Throwable -> L34
        m0();     // Catch: Throwable -> L34
        if (this.f8258h == false) goto L14;
    L19:
        this.f8271u.c();
        return true;
    L14:
        if (this.f8257g == true) goto L19;
        if (lb.a.a() == false) goto L18;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "downloadSegments", "Finally pause");
    L18:
        h0();
    L22:
        if (this.f8258h == false) goto L24;
    L29:
        this.f8271u.c();
        return true;
    L24:
        if (this.f8257g == true) goto L29;
        if (lb.a.a() == false) goto L28;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "downloadSegments", "Finally pause");
    L28:
        h0();
        goto L29
    L31:
        th = move-exception;
        long r13 = System.currentTimeMillis() - r11;     // Catch: Throwable -> L34
        this.f8251a.increaseAllConnectTime(r13);     // Catch: Throwable -> L34
        this.f8251a.setFirstSpeedTime(r13);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (this.f8258h == false) goto L38;
    L43:
        this.f8271u.c();
        throw th;
    L38:
        if (this.f8257g == true) goto L43;
        if (lb.a.a() == false) goto L42;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "downloadSegments", "Finally pause");
    L42:
        h0();
        goto L43
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void a(l r10, i r11) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r11.f8248f == r10) goto L6;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L6:
        if (lb.a.a() == false) goto L8;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "unApplySegment", "Segment: " + r11);     // Catch: Throwable -> L11
    L8:
        r11.n(r10.h());     // Catch: Throwable -> L11
        r11.f8248f = null;     // Catch: Throwable -> L11
        r10.E();     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void b(l r10, i r11) {
        monitor-enter(this);
        w(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public e c(l r10, i r11) {
        monitor-enter(this);
        k r12 = new k(this.f8251a, this.f8254d, r11);     // Catch: Throwable -> L6
        this.f8256f.a(r12);     // Catch: Throwable -> L6
        e r13 = r12.f();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void d(l r10, i r11, o r12, com.ss.android.socialbase.downloader.model.g r13) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.f8257g == true) goto L19;
        if (this.f8258h == true) goto L19;
        B(r10, r11, r12, r13);     // Catch: Throwable -> L20
        r10.A(false);     // Catch: Throwable -> L20
        if (this.f8264n > 0) goto L14;
        long r14 = this.f8251a.getTotalBytes();     // Catch: Throwable -> L20
        this.f8264n = r14;     // Catch: Throwable -> L20
        if (r14 > 0) goto L12;
        this.f8264n = r13.j();     // Catch: Throwable -> L20
    L12:
        D();     // Catch: Throwable -> L20
    L16:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L14:
        if (this.f8253c.p() == false) goto L16;
    L19:
        throw new StreamClosedException("connected");     // Catch: Throwable -> L20
    }

    @Override // nb.c.InterfaceC0251c
    public void e(String r10, List<InetAddress> r11) {
        if (this.f8258h == false) goto L5;
        return;
    L5:
        if (this.f8257g == true) goto L29;
        List<o> r12 = null;
        r12 = y(r10, r11);     // Catch: Throwable -> L10
    L12:
        monitor-enter(this);
        if (r12 != null) goto L25;
    L15:
        this.f8263m = false;     // Catch: Throwable -> L21
        this.f8253c.q(this.f8260j.size());     // Catch: Throwable -> L21
        if (lb.a.a() == false) goto L18;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "onDnsResolved", "DispatchReadThread");     // Catch: Throwable -> L21
    L18:
        D();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L25:
        v(r10, r12);     // Catch: Throwable -> L21
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public i f(l r10, o r11) {
        if (this.f8257g == false) goto L5;
        return null;
    L5:
        if (this.f8258h == true) goto L23;
        monitor-enter(this);
        i r12 = c0(r10, r11);     // Catch: Throwable -> L17
        if (r12 == null) goto L15;
        r12.j();     // Catch: Throwable -> L17
        if (r12.b() <= 1) goto L15;
        i r13 = new i(r12);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return r13;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return r12;
    L17:
        th = move-exception;
        throw th;
    L23:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void g(l r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "onReaderExit", "ThreadIndex = " + r10.f8304z);
    L5:
        monitor-enter(this);
        r10.z(true);     // Catch: Throwable -> L21
        this.f8259i.remove(r10);     // Catch: Throwable -> L21
        C();     // Catch: Throwable -> L21
        if (this.f8259i.isEmpty() == false) goto L11;
    L9:
        f0();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L11:
        if (W() == false) goto L19;
        if (lb.a.a() == false) goto L15;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "onReaderExit", "allContentDownloaded");     // Catch: Throwable -> L21
    L15:
        Iterator<l> r11 = this.f8259i.iterator();     // Catch: Throwable -> L21
    L17:
        if (r11.hasNext() == false) goto L9;
        r11.next().c();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void h(l r10) {
        if (this.B == true) goto L5;
        return;
    L5:
        if (lb.a.a() == false) goto L9;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "onReaderRun", "ThreadIndex = " + r10.f8304z);
        return;
    }

    public void h0() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "pause", "Run");
    L5:
        this.f8258h = true;
        monitor-enter(this);
        Iterator<l> r10 = this.f8259i.iterator();     // Catch: Throwable -> L14
    L9:
        if (r10.hasNext() == false) goto L11;
        r10.next().c();     // Catch: Throwable -> L14
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.f8256f.j();
        this.f8254d.d();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void i(l r10, i r11) {
        monitor-enter(this);
        r11.a();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public boolean j(l r10, o r11, i r12, BaseException r13, int r14, int r15) {
        int r16 = r13.getErrorCode();
        boolean r17 = false;
        if (r16 != 1083) goto L7;
        g0(r13);
        return false;
    L7:
        if (r16 != 1047) goto L9;
    L12:
        r17 = true;
    L14:
        if (com.ss.android.socialbase.downloader.utils.c.J(r13) == false) goto L16;
        r17 = true;
    L16:
        if (r17 == true) goto L18;
        if (r14 >= r15) goto L18;
    L19:
        return true;
    L18:
        j0(r10);
        goto L19
    L9:
        if (r16 == 1074) goto L12;
        if (r16 != 1055) goto L14;
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.segment.f
    public void k(l r10, o r11, i r12, BaseException r13) {
        monitor-enter(this);
        lb.a.h("SegmentDispatcher", this.f8251a.getId(), "onSegmentFailed", "Segment: " + r12 + " e:" + r13);     // Catch: Throwable -> L14
        r10.A(true);     // Catch: Throwable -> L14
        if (r10.f8304z != 0) goto L7;
        this.f8268r = r13;     // Catch: Throwable -> L14
    L7:
        if (X() == true) goto L9;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L9:
        if (this.f8268r != null) goto L11;
        this.f8268r = r13;     // Catch: Throwable -> L14
    L11:
        this.f8272v = true;     // Catch: Throwable -> L14
        g0(this.f8268r);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void z() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("SegmentDispatcher", this.f8251a.getId(), "cancel", "Run");
    L5:
        this.f8257g = true;
        monitor-enter(this);
        Iterator<l> r10 = this.f8259i.iterator();     // Catch: Throwable -> L14
    L9:
        if (r10.hasNext() == false) goto L11;
        r10.next().c();     // Catch: Throwable -> L14
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.f8256f.b();
        this.f8254d.d();
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
