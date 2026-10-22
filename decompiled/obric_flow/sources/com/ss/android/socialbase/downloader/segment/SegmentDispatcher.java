package com.ss.android.socialbase.downloader.segment;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.lynx.tasm.utils.b;
import com.ss.android.socialbase.downloader.core.module.multi.DownloadMultiSegmentModule;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.DownloadDnsManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import dn.a;
import java.net.InetAddress;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONObject;
import td.d;

/* JADX INFO: loaded from: classes3.dex */
public class SegmentDispatcher {
    public int A;
    public final boolean B;
    public final DownloadWatchDog.IWatcher C;
    public final DownloadWatchDog.IWatcher D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadInfo f16038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DownloadTask f16039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SegmentStrategy f16040c;
    public final BufferQueue d;
    public final DownloadMultiSegmentModule e;
    public final MultiSegmentWriter f;
    public volatile boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f16041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f16042i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f16043j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HttpResponse f16044k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HttpResponse f16045l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f16046m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f16047n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedList f16048o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f16049p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16050q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BaseException f16051r;
    public final Object s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DownloadStenographer f16052t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DownloadWatchDog f16053u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f16054v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f16055w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f16056x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f16057y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f16058z;

    public SegmentDispatcher(DownloadTask r10, DownloadInfo r11, SegmentStrategy r12, DownloadMultiSegmentModule r13) {
        boolean r5 = false;
        this.g = false;
        this.f16041h = false;
        this.f16042i = new ArrayList();
        this.f16043j = new ArrayList();
        this.f16046m = true;
        this.f16048o = new LinkedList();
        this.f16049p = new ArrayList();
        this.s = new Object();
        this.f16054v = false;
        this.C = new AnonymousClass1(this);
        this.D = new AnonymousClass2(this);
        this.f16039b = r10;
        this.f16038a = r11;
        this.f16040c = r12;
        BufferQueue r14 = new BufferQueue(r12.f16086a.optInt("buffer_count", 512), r12.f16086a.optInt("buffer_size", 8192));
        this.d = r14;
        this.e = r13;
        this.f = new MultiSegmentWriter(r11, r13, r14);
        this.f16053u = new DownloadWatchDog();
        this.f16052t = new DownloadStenographer();
        if (DownloadSetting.a(r11.l(), null).a("debug", 0) != 1) goto L5;
        r5 = true;
    L5:
        this.B = r5;
    }

    public final void a(AbstractList r16) {
        Iterator r5 = r16.iterator();
        long r10 = -1;
        long r11 = 0;
        long r12 = -1;
        long r13 = -1;
    L4:
        if (r5.hasNext() == false) goto L21;
        Segment r14 = (Segment) r5.next();
        if (r12 == r10) goto L7;
        if (r14.f16034a <= r13) goto L14;
        r11 = r11 + (r13 - r12);
        long r15 = r14.f16035b.get();
        r12 = r14.f16034a;
        if ((r15 - r12) > 0) goto L18;
        r10 = -1;
        r12 = -1;
        r13 = -1;
        goto L4
    L18:
        r13 = r14.a();
    L10:
        r10 = -1;
        goto L4
    L14:
        if (r14.a() <= r13) goto L10;
        r13 = r14.a();
        goto L10
    L7:
        long r17 = r14.f16035b.get();
        long r18 = r14.f16034a;
        if ((r17 - r18) <= 0) goto L10;
        r13 = r14.a();
        r12 = r18;
        goto L10
    L21:
        if (r12 < 0) goto L26;
        if (r13 <= r12) goto L26;
        r11 = r11 + (r13 - r12);
    L26:
        if (Logger.b() == false) goto L28;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "checkDownloadedBytesLocked", "GetCurBytes = " + this.f16038a.i() + ", totalBytes = " + this.f16038a.f15817h0 + ", downloadedBytes = " + r11, false);
    L28:
        DownloadInfo r19 = this.f16038a;
        long r20 = r19.f15817h0;
        if (r11 > r20) goto L31;
    L33:
        long r21 = r19.i();
        DownloadInfo r22 = this.f16038a;
        if (r21 != r22.f15817h0) goto L36;
        return;
    L36:
        if (r22.i() == r11) goto L48;
        this.f16038a.b(r11);
        return;
    L48:
        return;
    L31:
        if (r20 <= 0) goto L33;
        r11 = r20;
        goto L33
    }

    public final long b(Segment r10) {
        long r5 = r10.d;
        if (r5 < r10.f16034a) goto L5;
        long r11 = (r5 - r10.b()) + 1;
    L7:
        if (r11 != (-1)) goto L12;
        long r12 = this.f16047n;
        if (r12 <= 0) goto L12;
        return r12 - r10.b();
    L12:
        return r11;
    L5:
        r11 = -1;
        goto L7
    }

    public final void c() {
        if (this.f16047n > 0) goto L5;
    L13:
        int r5 = 1;
    L15:
        if (Logger.b() == false) goto L17;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "dispatchReadThread", "TotalLength = " + this.f16047n + ", threadCount = " + r5, false);
    L17:
        if (r5 > 0) goto L19;
        r5 = 1;
    L19:
        monitor-enter(this);
    L38:
    L30:
        th = move-exception;
        throw th;
    L21:
        if (this.f16042i.size() >= r5) goto L34;
        if (this.f16041h == true) goto L32;
        if (this.g == true) goto L32;
        SegmentReader r10 = new SegmentReader(this.f16039b, this.f16038a, this, this.d, h(), this.f16042i.size());     // Catch: Throwable -> L30
        this.f16042i.add(r10);     // Catch: Throwable -> L30
        r10.f16076p = DownloadComponentManager.d().submit(r10);     // Catch: Throwable -> L30
        if (this.f16040c.f16086a.optInt("segment_mode", 1) != 0) goto L38;
    L32:
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L34:
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L5:
        if (this.f16046m == true) goto L13;
        SegmentStrategy r11 = this.f16040c;
        r5 = r11.f16087b;
        long r12 = this.f16047n;
        long r13 = ((long) r11.f16086a.optInt("segment_min_init_mb", 10)) * 1048576;
        if (r13 >= 5242880) goto L10;
        r13 = 5242880;
    L10:
        int r14 = (int) (r12 / r13);
        if (r5 <= r14) goto L15;
        r5 = r14;
        goto L15
    }

    public final void d() {
        int r5 = this.f16040c.f16086a.optInt("ip_strategy", 0);
        if (r5 > 0) goto L7;
        this.f16046m = false;
        c();
        return;
    L7:
        if (DownloadDnsManager.d == null) goto L9;
    L19:
        DownloadDnsManager r10 = DownloadDnsManager.d;
        r10.a(this.f16038a.d, this);
        if (r5 <= 2) goto L29;
        ArrayList r11 = this.f16038a.s;
        if (r11 == null) goto L37;
        Iterator r12 = r11.iterator();
    L25:
        if (r12.hasNext() == false) goto L38;
        String r13 = (String) r12.next();
        if (TextUtils.isEmpty(r13) == true) goto L25;
        r10.a(r13, this);
        goto L25
    L38:
        return;
    L37:
        return;
    L29:
        return;
    L9:
        monitor-enter(DownloadDnsManager.class);
    L13:
        th = move-exception;
        throw th;
    L11:
        if (DownloadDnsManager.d != null) goto L15;
        DownloadDnsManager.d = new DownloadDnsManager();     // Catch: Throwable -> L13
    L15:
        monitor-exit(DownloadDnsManager.class);     // Catch: Throwable -> L13
        goto L19
    }

    public final void e() {
        this.f16043j.add(new UrlRecord(this.f16038a.d, true));
        ArrayList r5 = this.f16038a.s;
        if (r5 == null) goto L10;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        String r11 = (String) r10.next();
        if (TextUtils.isEmpty(r11) == true) goto L6;
        this.f16043j.add(new UrlRecord(r11, false));
    L10:
        this.f16040c.a(this.f16043j.size());
    }

    public final void f() {
        SegmentStrategy r5 = this.f16040c;
        long r10 = r5.f16086a.optInt("connect_timeout", -1);
        long r11 = -1;
        if (r10 >= 2000) goto L6;
        r10 = -1;
    L6:
        this.f16055w = r10;
        long r12 = r5.f16086a.optInt("read_timeout", -1);
        if (r12 < 4000) goto L9;
        r11 = r12;
    L9:
        this.f16056x = r11;
        this.f16058z = Math.min(Math.max(0.0f, (float) r5.f16086a.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
        int r13 = this.A;
        if (r13 <= 0) goto L16;
        DownloadWatchDog r14 = this.f16053u;
        DownloadWatchDog.IWatcher r15 = this.C;
        long r16 = r13;
        Handler r17 = r14.f16116a;
        if (r17 == null) goto L17;
        Message r18 = Message.obtain();
        r18.what = 0;
        r18.obj = r15;
        r17.sendMessageDelayed(r18, r16);
        return;
    L17:
        return;
    }

    public final boolean g() {
        long r5 = this.f16047n;
        long r10 = 0;
        if (r5 > 0) goto L5;
        return false;
    L5:
        monitor-enter(this);
        ArrayList r11 = this.f16049p;     // Catch: Throwable -> L13
        int r12 = r11.size();     // Catch: Throwable -> L13
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L17;
        Segment r14 = (Segment) r11.get(r13);     // Catch: Throwable -> L13
        if (r14.f16034a > r10) goto L17;
        if (r14.b() <= r10) goto L15;
        r10 = r14.b();     // Catch: Throwable -> L13
    L15:
        r13 = r13 + 1;     // Catch: Throwable -> L13
    L17:
        if (Logger.b() == false) goto L20;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "isAllContentDownloaded", "FirstOffset: " + r10, false);     // Catch: Throwable -> L13
    L20:
        if (r10 < r5) goto L24;
        monitor-exit(this);     // Catch: Throwable -> L13
        return true;
    L24:
        monitor-exit(this);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    public final UrlRecord h() {
        monitor-enter(this);
        int r5 = this.f16050q % this.f16043j.size();     // Catch: Throwable -> L6
        if (this.f16040c.f16086a.optInt("url_balance", 2) <= 0) goto L8;
        this.f16050q++;     // Catch: Throwable -> L6
    L8:
        UrlRecord r10 = (UrlRecord) this.f16043j.get(r5);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final void i() {
        if (Logger.b() == false) goto L5;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "onComplete", "Run", false);
    L5:
        this.d.a();
        Object r5 = this.s;
        monitor-enter(r5);
        this.s.notify();     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void j() {
        if (Logger.b() == false) goto L5;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "pause", "Run", false);
    L5:
        this.f16041h = true;
        monitor-enter(this);
        Iterator r5 = this.f16042i.iterator();     // Catch: Throwable -> L11
    L9:
        if (r5.hasNext() == false) goto L13;
        ((SegmentReader) r5.next()).a();     // Catch: Throwable -> L11
        goto L9
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        MultiSegmentWriter r10 = this.f;
        r10.f16021j = true;
        r10.f16020i = true;
        this.d.a();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void k() {
        this.f.a(this.d);     // Catch: BaseException -> L4 StreamClosedException -> L60
    L4:
        e = move-exception;
        Logger.a("SegmentDispatcher", this.f16038a.l(), "writeSegments", "DispatchSegments: loopAndWrite e = " + e);
        a(e);
        throw e;
    L8:
        if (this.f16041h == false) goto L10;
        return;
    L10:
        if (this.g == true) goto L77;
        monitor-enter(this);     // Catch: Throwable -> L26
    L64:
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L14:
        if (this.f16048o.isEmpty() == true) goto L21;
        Segment r5 = (Segment) this.f16048o.poll();     // Catch: Throwable -> L19
        if (r5 == null) goto L64;
        a(this.f16049p, r5, true);     // Catch: Throwable -> L19
        goto L64
    L21:
        a(this.f16049p);     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
    L29:
        if (this.f16054v == true) goto L31;
    L35:
        long r10 = this.f16038a.i();
        DownloadInfo r11 = this.f16038a;
        if (r10 == r11.f15817h0) goto L57;
        ArrayList r12 = this.f16049p;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L47
        if (r12 != null) goto L41;
    L50:
        String r14 = null;
    L51:
        r13.put("segments", r14);     // Catch: Throwable -> L47
        r13.put("cur_bytes", r11.i());     // Catch: Throwable -> L47
        r13.put("total_bytes", r11.f15817h0);     // Catch: Throwable -> L47
        if (DownloadComponentManager.m() == null) goto L57;
        r11.l();     // Catch: Throwable -> L47
        goto L57
    L41:
        if (r12.isEmpty() == true) goto L50;
        Collections.sort(r12, new Segment.AnonymousClass1());     // Catch: Throwable -> L47
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L47
        Iterator r16 = r12.iterator();     // Catch: Throwable -> L47
    L45:
        if (r16.hasNext() == false) goto L49;
        r15.append((Segment) r16.next());     // Catch: Throwable -> L47
        r15.append("\r\n");     // Catch: Throwable -> L47
        goto L45
    L49:
        r14 = r15.toString();     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();
    L57:
        if (Logger.b() == false) goto L76;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "writeSegments", "DispatchSegments::download finished", false);
        return;
    L76:
        return;
    L31:
        if (this.f16051r == null) goto L35;
        Logger.a("SegmentDispatcher", this.f16038a.l(), "writeSegments", "DispatchSegments: failedException = " + this.f16051r);
        throw this.f16051r;
    L26:
        th = move-exception;
        th.printStackTrace();
        goto L29
    }

    public final void b(List r13) {
        DownloadInfo r5 = this.f16038a;
        long r10 = r5.f15817h0;
        this.f16047n = r10;
        if (r10 > 0) goto L7;
        r5.d();
        this.f16047n = r5.T0.optLong("dbjson_key_expect_file_length");
        if (Logger.b() == false) goto L7;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "initSegments", "GetExpectFileLength: " + this.f16047n, false);
    L7:
        monitor-enter(this);
        this.f16048o.clear();     // Catch: Throwable -> L17
        if (r13 != null) goto L11;
    L20:
        DownloadInfo r14 = this.f16038a;     // Catch: Throwable -> L17
        r14.d();     // Catch: Throwable -> L17
        long r11 = r14.T0.optLong("start_offset");     // Catch: Throwable -> L17
        long r12 = this.f16038a.k();     // Catch: Throwable -> L17
        if (r11 >= 0) goto L24;
        r11 = 0;
    L24:
        if (r12 > 0) goto L26;
    L28:
        a(this.f16048o, new Segment(r11, r12), false);     // Catch: Throwable -> L17
    L30:
        if (Logger.b() == false) goto L32;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "initSegments", "TotalLength: " + this.f16047n, false);     // Catch: Throwable -> L17
    L32:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L26:
        if (r12 >= r11) goto L28;
        Logger.a("SegmentDispatcher", this.f16038a.l(), "initSegments", "DownloadInfo.getEndOffset invalid, start = " + r11 + ", end = " + r12);     // Catch: Throwable -> L17
        r12 = -1;
        goto L28
    L11:
        if (r13.isEmpty() == true) goto L20;
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L17
    L15:
        if (r15.hasNext() == false) goto L19;
        a(this.f16048o, new Segment((Segment) r15.next()), false);     // Catch: Throwable -> L17
        goto L15
    L19:
        a(this.f16048o);     // Catch: Throwable -> L17
        a(this.f16048o);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean d(SegmentReader r5) {
        monitor-enter(this);
        UrlRecord r10 = a(r5);     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        boolean r11 = r5.a(r10);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    public static void a(AbstractList r10, Segment r11, boolean r12) {
        long r5 = r11.f16034a;
        int r13 = r10.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L7;
        if (r5 < ((Segment) r10.get(r14)).f16034a) goto L7;
        r14 = r14 + 1;
    L7:
        r10.add(r14, r11);
        if (r12 == false) goto L13;
        r11.e = r13;
        return;
    }

    public final void c(Segment r5) {
        monitor-enter(this);
        r5.g--;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(List r10) {
        e();     // Catch: Throwable -> L30
        b(r10);     // Catch: Throwable -> L30
        c();     // Catch: Throwable -> L30
        f();     // Catch: Throwable -> L30
        d();     // Catch: Throwable -> L30
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L30
        Object r11 = this.s;     // Catch: Throwable -> L23
        monitor-enter(r11);     // Catch: Throwable -> L23
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L8:
        if (this.f16044k == null) goto L10;
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L12
    L16:
        if (this.f16044k == null) goto L18;
    L25:
        long r12 = System.currentTimeMillis() - r5;     // Catch: Throwable -> L30
        DownloadInfo r13 = this.f16038a;     // Catch: Throwable -> L30
        if (r12 <= 0) goto L33;
        r13.d();     // Catch: Throwable -> L30
        if (r13.D != null) goto L32;
        r13.D = new AtomicLong(r13.T0.optLong("dbjson_key_all_connect_time"));     // Catch: Throwable -> L30
    L32:
        r13.D.get();     // Catch: Throwable -> L30
        r13.a("dbjson_key_all_connect_time", Long.valueOf(r13.D.addAndGet(r12)));     // Catch: Throwable -> L30
    L34:
        this.f16038a.a("dbjson_key_first_speed_time", Long.valueOf(r12));     // Catch: Throwable -> L30
        if (this.f16041h == true) goto L60;
        if (this.g == true) goto L60;
        if (this.f16056x <= 0) goto L45;
        this.f16057y = System.currentTimeMillis();     // Catch: Throwable -> L30
        DownloadWatchDog r14 = this.f16053u;     // Catch: Throwable -> L30
        DownloadWatchDog.IWatcher r15 = this.D;     // Catch: Throwable -> L30
        Handler r16 = r14.f16116a;     // Catch: Throwable -> L30
        if (r16 == null) goto L45;
        Message r17 = Message.obtain();     // Catch: Throwable -> L30
        r17.what = 0;     // Catch: Throwable -> L30
        r17.obj = r15;     // Catch: Throwable -> L30
        r16.sendMessageDelayed(r17, 0);     // Catch: Throwable -> L30
    L45:
        k();     // Catch: Throwable -> L30
        if (this.f16041h == false) goto L49;
    L54:
        DownloadWatchDog r18 = this.f16053u;
        Handler r19 = r18.f16116a;
        if (r19 == null) goto L100;
        r18.f16116a = null;
        r19.removeCallbacksAndMessages(null);
        return;
    L100:
        return;
    L49:
        if (this.g == true) goto L54;
        if (Logger.b() == false) goto L53;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "downloadSegments", "Finally pause", false);
    L53:
        j();
    L60:
        if (this.f16041h == false) goto L62;
    L67:
        DownloadWatchDog r20 = this.f16053u;
        Handler r110 = r20.f16116a;
        if (r110 != null) goto L70;
        return;
    L70:
        r20.f16116a = null;
        r110.removeCallbacksAndMessages(null);
        return;
    L62:
        if (this.g == true) goto L67;
        if (Logger.b() == false) goto L66;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "downloadSegments", "Finally pause", false);
    L66:
        j();
        goto L67
    L33:
        r13.getClass();     // Catch: Throwable -> L30
        goto L34
    L18:
        if (this.f16045l != null) goto L25;
        BaseException r111 = this.f16051r;     // Catch: Throwable -> L23
        if (r111 == null) goto L25;
        throw r111;     // Catch: Throwable -> L23
    L10:
        if (this.f16045l != null) goto L14;
        this.s.wait();     // Catch: Throwable -> L12
    L23:
        th = move-exception;
        long r21 = System.currentTimeMillis() - r5;     // Catch: Throwable -> L30
        DownloadInfo r22 = this.f16038a;     // Catch: Throwable -> L30
        if (r21 <= 0) goto L80;
        r22.d();     // Catch: Throwable -> L30
        if (r22.D != null) goto L79;
        r22.D = new AtomicLong(r22.T0.optLong("dbjson_key_all_connect_time"));     // Catch: Throwable -> L30
    L79:
        r22.D.get();     // Catch: Throwable -> L30
        r22.a("dbjson_key_all_connect_time", Long.valueOf(r22.D.addAndGet(r21)));     // Catch: Throwable -> L30
    L81:
        this.f16038a.a("dbjson_key_first_speed_time", Long.valueOf(r21));     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L80:
        r22.getClass();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        if (this.f16041h == false) goto L86;
    L91:
        DownloadWatchDog r23 = this.f16053u;
        Handler r24 = r23.f16116a;
        if (r24 == null) goto L95;
        r23.f16116a = null;
        r24.removeCallbacksAndMessages(null);
    L95:
        throw th;
    L86:
        if (this.g == true) goto L91;
        if (Logger.b() == false) goto L90;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "downloadSegments", "Finally pause", false);
    L90:
        j();
        goto L91
    }

    public final void c(SegmentReader r10, Segment r11) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r11.f == r10) goto L7;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L7:
        if (Logger.b() == false) goto L11;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "unApplySegment", "Segment: " + r11, false);     // Catch: Throwable -> L9
    L11:
        long r5 = r10.f16074n;     // Catch: Throwable -> L9
        if (r5 < r11.f16035b.get()) goto L14;
        r11.f16036c = r5;     // Catch: Throwable -> L9
    L14:
        r11.f = null;     // Catch: Throwable -> L9
        r10.g();     // Catch: Throwable -> L9
        goto L15
    }

    public final void b(String r10, List r11) {
        if (this.f16041h == false) goto L5;
        return;
    L5:
        if (this.g == true) goto L30;
        ArrayList r12 = a(r10, r11);     // Catch: Throwable -> L9
    L11:
        monitor-enter(this);
        if (r12 != null) goto L25;
    L16:
        this.f16046m = false;     // Catch: Throwable -> L14
        this.f16040c.a(this.f16043j.size());     // Catch: Throwable -> L14
        if (Logger.b() == false) goto L19;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "onDnsResolved", "DispatchReadThread", false);     // Catch: Throwable -> L14
    L19:
        c();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L25:
        a(r10, r12);     // Catch: Throwable -> L14
    L9:
        th = move-exception;
        th.printStackTrace();
        r12 = null;
        goto L11
    }

    public final void c(SegmentReader r10) {
        if (Logger.b() == false) goto L5;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "onReaderExit", "ThreadIndex = " + r10.f16080u, false);
    L5:
        monitor-enter(this);
        this.f16042i.remove(r10);     // Catch: Throwable -> L9
        b();     // Catch: Throwable -> L9
        if (this.f16042i.isEmpty() == false) goto L12;
        i();     // Catch: Throwable -> L9
    L21:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L12:
        if (g() == false) goto L21;
        if (Logger.b() == false) goto L16;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "onReaderExit", "allContentDownloaded", false);     // Catch: Throwable -> L9
    L16:
        Iterator r11 = this.f16042i.iterator();     // Catch: Throwable -> L9
    L18:
        if (r11.hasNext() == false) goto L20;
        ((SegmentReader) r11.next()).a();     // Catch: Throwable -> L9
        goto L18
    L20:
        i();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final Segment b(SegmentReader r33) {
    L4:
        if (this.f16048o.isEmpty() == true) goto L13;
        Segment r5 = (Segment) this.f16048o.poll();
        if (r5 == null) goto L4;
        a(this.f16049p, r5, true);
        if (b(r5) > 0) goto L12;
        if (this.f16047n > 0) goto L4;
    L12:
        return r5;
    L13:
        b();
        int r10 = this.f16049p.size();
        int r11 = -1;
        int r12 = 0;
        long r13 = -1;
    L14:
        if (r12 >= r10) goto L29;
        Segment r14 = (Segment) this.f16049p.get(r12);
        long r15 = b(r14);
        int r16 = r12 + 1;
        if (r16 >= r10) goto L18;
        Segment r17 = (Segment) this.f16049p.get(r16);
    L19:
        if (r17 == null) goto L26;
        long r18 = r17.f16034a - r14.b();
        if (r15 != (-1)) goto L24;
        r15 = r18;
        goto L26
    L24:
        r15 = Math.min(r15, r18);
    L26:
        if (r15 <= r13) goto L28;
        r13 = r15;
        r11 = r12;
    L28:
        r12 = r16;
        goto L14
    L18:
        r17 = null;
        goto L19
    L29:
        long r19 = ((long) this.f16040c.f16086a.optInt("segment_min_kb", 512)) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        long r20 = 65536;
        if (r19 >= 65536) goto L32;
        r19 = 65536;
    L32:
        SegmentStrategy r21 = this.f16040c;
        long r22 = ((long) r21.f16086a.optInt("segment_max_kb", 0)) * 1048576;
        long r23 = ((long) r21.f16086a.optInt("segment_min_kb", 512)) * RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (r23 < 65536) goto L37;
        r20 = r23;
    L37:
        if (r22 >= r20) goto L39;
        r22 = -1;
    L39:
        if (r11 >= 0) goto L41;
    L143:
        Segment r24 = null;
    L144:
        if (r24 != null) goto L146;
    L149:
        int r25 = 0;
    L150:
        Iterator r26 = this.f16049p.iterator();
        int r27 = Integer.MAX_VALUE;
        Segment r28 = null;
    L152:
        if (r26.hasNext() == false) goto L158;
        Segment r29 = (Segment) r26.next();
        if (b(r29) <= 0) goto L152;
        int r30 = r29.g;
        if (r30 >= r27) goto L152;
        r28 = r29;
        r27 = r30;
        goto L152
    L158:
        if (r28 == null) goto L205;
        SegmentReader r31 = r28.f;
        if (r31 == null) goto L206;
        if (r28.g >= 2) goto L205;
        long r32 = System.currentTimeMillis();
        a(r32);
        if ((r32 - r31.J) <= 2000) goto L190;
        long r34 = r32 - 2000;
        if (r31.J <= 0) goto L190;
        long r110 = this.f16052t.a(r34, r32);
        int r35 = this.f16042i.size();
        if (r35 <= 0) goto L173;
        long r111 = r110 / ((long) r35);
    L174:
        DownloadStenographer r36 = r31.G;
        if (r36 != null) goto L177;
        long r37 = -1;
    L179:
        if (r37 < 500) goto L183;
        if (r37 >= (r111 * 1.0d)) goto L190;
    L183:
        if (Logger.b() == false) goto L186;
        int r112 = this.f16038a.l();
        StringBuilder r38 = a.K(r110, "TotalSpeed = ", ", threadAvgSpeed = ");
        r38.append(r111);
        kotlin.collections.a.o(r38, ", poorSpeed = 500, speed = ", r37, ",threadIndex = ");
        r38.append(r31.f16080u);
        Logger.a("SegmentDispatcher", r112, null, "isDownloadSpeedPoor", r38.toString(), false);
    L186:
        if (this.B == false) goto L206;
        if (Logger.b() == false) goto L206;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "obtainSegmentWhenNoNewSegment", "IsDownloadSpeedPoor segment = " + r28 + ", owner.threadIndex = " + r31.f16080u, false);
        goto L206
    L177:
        r37 = r36.a(r34, r32);
        goto L179
    L173:
        r111 = r110;
    L190:
        int r39 = r25 + 1;
        if (r25 > 2) goto L193;
        monitor-enter(this);     // Catch: InterruptedException -> L210
        wait(500);     // Catch: Throwable -> L202
        monitor-exit(this);     // Catch: Throwable -> L202
        r25 = r39;
        goto L150
    L202:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L210
    L193:
        if (this.B == false) goto L206;
        if (Logger.b() == false) goto L206;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "obtainSegmentWhenNoNewSegment", "WaitCount > 2, return segment = " + r28, false);
    L206:
        if (r28 == null) goto L208;
        return r28;
    L208:
        return null;
    L205:
        r28 = null;
        goto L206
    L146:
        if (b(r24) <= 0) goto L149;
        a(this.f16049p, r24, true);
        return r24;
    L41:
        if (r13 <= r19) goto L143;
        Segment r40 = (Segment) this.f16049p.get(r11);
        if (this.f16049p.size() >= this.f16042i.size()) goto L45;
        int r41 = 2;
    L47:
        if (r41 != 1) goto L95;
        SegmentReader r42 = r40.f;
        if (r42 == null) goto L140;
        long r113 = System.currentTimeMillis();
        long r43 = r113 - 4000;
        DownloadStenographer r44 = r42.G;
        if (r44 != null) goto L53;
        long r210 = -1;
    L54:
        DownloadStenographer r45 = r33.G;
        if (r45 != null) goto L58;
        long r46 = -1;
    L60:
        if (r210 > 0) goto L62;
    L64:
        float r47 = -1.0f;
    L66:
        if (r47 != (-1.0f)) goto L73;
        long r48 = r42.c();
        long r114 = r33.c();
        if (r48 <= 0) goto L73;
        if (r114 <= 0) goto L73;
        r47 = r114 / (r48 + r114);
    L73:
        if (r47 <= 0.0f) goto L92;
        float r49 = r47 * 0.9f;
        long r50 = (long) (r13 * r49);
        if (r50 >= r19) goto L78;
        r50 = r19;
    L78:
        if (r22 > 0) goto L80;
    L82:
        r22 = r50;
    L83:
        long r51 = r19 / 2;
        long r52 = r13 - r51;
        if (r22 <= r52) goto L87;
        r22 = r52;
    L89:
        r24 = new Segment((r13 - r22) + r40.b(), r40.d);
        if (Logger.b() == false) goto L144;
        int r211 = this.f16038a.l();
        StringBuilder r53 = new StringBuilder("parent = ");
        r53.append(r40);
        r53.append(", child = ");
        r53.append(r24);
        r53.append(", maxRemainBytes = ");
        r53.append(r13);
        kotlin.collections.a.o(r53, ", childLength = ", r22, ", ratio = ");
        r53.append(r49);
        r53.append(", threadIndex = ");
        r53.append(r33.f16080u);
        Logger.a("SegmentDispatcher", r211, null, "obtainChildSegmentFromMaxRemain", r53.toString(), false);
        goto L144
    L87:
        if (r22 >= r51) goto L89;
        r22 = r51;
        goto L89
    L80:
        if (r50 <= r22) goto L82;
    L92:
        r40 = r40;
        goto L140
    L62:
        if (r46 <= 0) goto L64;
        r47 = r46 / (r210 + r46);
        goto L66
    L58:
        r46 = r45.a(r43, r113);
        goto L60
    L53:
        r210 = r44.a(r43, r113);
    L140:
        r24 = new Segment((r13 / 2) + r40.b(), r40.d);
        if (Logger.b() == false) goto L144;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "obtainChildSegmentFromMaxRemain", "parent = " + r40 + ",child = " + r24, false);
        goto L144
    L95:
        if (r41 != 2) goto L140;
        long r115 = this.f16047n - this.f16038a.i();
        long r212 = r13;
        long r116 = r33.c();
        int r54 = this.f16042i.size();
        if (r54 > 1) goto L100;
        r54 = this.f16040c.f16087b;
    L100:
        if (r116 > 0) goto L113;
        Segment r117 = r40;
        float r55 = (float) this.f16040c.f16086a.optDouble("main_ratio", 0.0d);
        if (r55 > 0.0f) goto L104;
    L105:
        r55 = 1.0f / r54;
    L107:
        if (r33.f16080u != 0) goto L110;
    L122:
        long r56 = (long) (r115 * r55);
        if (r56 >= r19) goto L126;
        r56 = r19;
    L126:
        if (r22 > 0) goto L128;
    L130:
        r22 = r56;
    L131:
        long r57 = r19 / 2;
        long r118 = r212 - r57;
        if (r22 <= r118) goto L135;
        r22 = r118;
    L137:
        Segment r58 = r117;
        r24 = new Segment((r212 - r22) + r117.b(), r58.d);
        if (Logger.b() == false) goto L144;
        int r119 = this.f16038a.l();
        StringBuilder r59 = new StringBuilder("parent = ");
        r59.append(r58);
        r59.append(", child = ");
        r59.append(r24);
        r59.append(", maxRemainBytes = ");
        r59.append(r212);
        kotlin.collections.a.o(r59, ", childLength = ", r22, ", ratio = ");
        r59.append(r55);
        r59.append(", threadIndex = ");
        r59.append(r33.f16080u);
        Logger.a("SegmentDispatcher", r119, null, "obtainChildSegmentFromMaxRemain", r59.toString(), false);
        goto L144
    L135:
        if (r22 >= r57) goto L137;
        r22 = r57;
        goto L137
    L128:
        if (r56 <= r22) goto L130;
    L110:
        if (r54 <= 1) goto L112;
        r55 = (1.0f - r55) / (r54 - 1);
        goto L122
    L112:
        long r213 = r115;
    L121:
        r55 = 1.0f / r54;
    L120:
        r115 = r213;
        goto L122
    L104:
        if (r55 < 1.0f) goto L107;
    L113:
        r117 = r40;
        Iterator r60 = this.f16042i.iterator();
        r213 = r115;
        long r120 = 0;
    L115:
        if (r60.hasNext() == false) goto L118;
        r120 = r120 + ((SegmentReader) r60.next()).c();
        goto L115
    L118:
        if (r120 <= r116) goto L121;
        r55 = r116 / r120;
        goto L120
    L45:
        r41 = this.f16040c.f16086a.optInt("ratio_segment", 0);
        goto L47
    }

    public final void a(String r10, ArrayList r11) {
        if (this.B == false) goto L10;
        Iterator r5 = r11.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        UrlRecord r12 = (UrlRecord) r5.next();
        if (Logger.b() == false) goto L6;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "addIpListLocked", "UrlRecord: " + r12, false);
    L10:
        int r13 = 0;
        int r14 = this.f16040c.f16086a.optInt("ip_strategy", 0);
        if (r14 != 1) goto L13;
    L14:
        int r15 = this.f16043j.size();
    L15:
        if (r13 >= r15) goto L20;
        if (TextUtils.equals(((UrlRecord) this.f16043j.get(r13)).f16088a, r10) == true) goto L21;
        r13 = r13 + 1;
    L21:
        if (r13 >= 0) goto L23;
    L26:
        this.f16043j.addAll(r11);
        return;
    L23:
        if (r13 >= this.f16043j.size()) goto L26;
        this.f16043j.addAll(r13 + 1, r11);
        return;
    L20:
        r13 = -1;
        goto L21
    L13:
        if (r14 != 3) goto L26;
        goto L14
    }

    public final ArrayList a(String r13, List r14) {
        if (r14 != null) goto L5;
    L36:
        return null;
    L5:
        if (r14.isEmpty() == true) goto L36;
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r15 = r14.iterator();
        int r10 = 0;
    L9:
        if (r15.hasNext() == false) goto L23;
        InetAddress r11 = (InetAddress) r15.next();
        if (r11 == null) goto L9;
        String r12 = r11.getHostAddress();
        if (TextUtils.isEmpty(r12) == true) goto L9;
        if (this.B == true) goto L17;
    L19:
        UrlRecord r16 = new UrlRecord(r13, r12);
        LinkedList r17 = (LinkedList) r5.get(r16.f16090c);
        if (r17 != null) goto L22;
        r17 = new LinkedList();
        r5.put(r16.f16090c, r17);
    L22:
        r17.add(r16);
        r10 = r10 + 1;
        goto L9
    L17:
        if (Logger.b() == false) goto L19;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "assembleIpAddress", d.b("Ip: ", r12), false);
        goto L19
    L23:
        if (r10 <= 0) goto L36;
        ArrayList r18 = new ArrayList();
    L25:
        Iterator r19 = r5.entrySet().iterator();
        boolean r110 = false;
    L27:
        if (r19.hasNext() == false) goto L33;
        LinkedList r20 = (LinkedList) ((Map.Entry) r19.next()).getValue();
        if (r20 == null) goto L27;
        if (r20.isEmpty() == true) goto L27;
        r18.add((UrlRecord) r20.pollFirst());
        r10 = r10 - 1;
        r110 = true;
        goto L27
    L33:
        if (r10 <= 0) goto L35;
        if (r110 == true) goto L25;
    L35:
        return r18;
    }

    public final void a(LinkedList r24) {
        Segment r5 = (Segment) r24.get(0);
        DownloadInfo r10 = this.f16038a;
        r10.d();
        long r11 = r10.T0.optLong("start_offset");
        if (r11 >= 0) goto L5;
        r11 = 0;
    L5:
        long r12 = r5.f16034a;
        if (r12 <= r11) goto L11;
        Segment r13 = new Segment(r11, r12 - 1);
        if (Logger.b() == false) goto L10;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "fixSegmentsLocked", "First = " + r5 + ", add new first = " + r13, false);
    L10:
        a(r24, r13, true);
    L11:
        Iterator r14 = r24.iterator();
        if (r14.hasNext() == false) goto L23;
        Segment r15 = (Segment) r14.next();
    L15:
        if (r14.hasNext() == false) goto L23;
        Segment r16 = (Segment) r14.next();
        if (r15.d >= (r16.f16034a - 1)) goto L22;
        if (Logger.b() == false) goto L21;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "fixSegmentsLocked", "Segment = " + r15 + ", new end = " + (r16.f16034a - 1), false);
    L21:
        r15.a(r16.f16034a - 1);
    L22:
        r15 = r16;
    L23:
        Segment r17 = (Segment) r24.get(r24.size() - 1);
        long r18 = this.f16038a.k();
        if (r18 > 0) goto L26;
    L29:
        long r19 = this.f16038a.f15817h0;
        if (r19 <= 0) goto L38;
        long r20 = r17.d;
        if (r20 != (-1)) goto L34;
        return;
    L34:
        if (r20 < (r19 - 1)) goto L38;
        return;
    L38:
        if (Logger.b() == false) goto L40;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "fixSegmentsLocked", "Last segment = " + r17 + ", new end=-1", false);
    L40:
        r17.a(-1);
        return;
    L26:
        if (r18 <= r11) goto L29;
        r17.a(r18);
    }

    public final void b(SegmentReader r29, Segment r30) {
        if (Logger.b() == false) goto L6;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "start " + r30, false);
    L6:
        if (r30.f != r29) goto L12;
        if (Logger.b() == false) goto L151;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "ApplySegment:" + r29 + " is already the owner of " + r30, false);
        return;
    L151:
        return;
    L12:
        if (r30.f == null) goto L14;
        Logger.a("SegmentDispatcher", this.f16038a.l(), "applySegmentLocked", "ApplySegment: " + r30 + " is already has an owner:" + r30.f);
        throw new SegmentApplyException(1, "segment already has an owner");
    L14:
        if (r29.f16071k != r30.b()) goto L136;
        long r10 = r30.f16034a;
        int r5 = this.f16049p.size();
        int r11 = 0;
    L17:
        if (r11 >= r5) goto L24;
        long r12 = ((Segment) this.f16049p.get(r11)).f16034a;
        if (r12 == r10) goto L25;
        if (r12 > r10) goto L24;
        r11 = r11 + 1;
    L25:
        if (r11 == (-1)) goto L133;
        Segment r13 = (Segment) this.f16049p.get(r11);
        if (r13 == null) goto L133;
        if (r13 != r30) goto L31;
        r10 = r10;
    L59:
        long r14 = r30.f16035b.get() - r30.f16034a;
        int r15 = r11 - 1;
    L61:
        if (r15 < 0) goto L102;
        Segment r16 = (Segment) this.f16049p.get(r15);
        long r17 = r16.d;
        if (r17 <= 0) goto L67;
        if (r17 >= r10) goto L67;
    L84:
        r15 = r15 - 1;
    L67:
        if (r14 > 0) goto L74;
        if (r16.b() <= r10) goto L74;
        Logger.a("SegmentDispatcher", this.f16038a.l(), "applySegmentLocked", "Prev's current has over this start, prev = " + r16 + ", segment = " + r30);
        this.f16049p.remove(r30);
        throw new SegmentApplyException(3, "prev overstep");
    L74:
        if (r16.f != null) goto L85;
        r16.a(r10 - 1);
        if (Logger.b() == false) goto L79;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "Prev set end, prev = " + r16, false);
    L79:
        if ((r16.f16035b.get() - r16.f16034a) <= 0) goto L84;
        if (Logger.b() == false) goto L102;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "Break", false);
        goto L102
    L85:
        SegmentReader r18 = r16.f;
        long r19 = r10 - 1;
        long r20 = r18.f16073m;
        if (r19 > 0) goto L91;
        if (r20 <= 0) goto L91;
    L95:
        if (Logger.b() == false) goto L98;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "adjustSegmentEndOffset filed, prev = " + r16, false);
    L98:
        throw new SegmentApplyException(4, "prev end adjust fail");
    L91:
        if (r19 > r20) goto L93;
    L99:
        r18.f16072l = r19;
        r18.f16081v = true;
        r16.a(r19);
        if (Logger.b() == false) goto L102;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "adjustSegmentEndOffset succeed, prev = " + r16, false);
        goto L102
    L93:
        if (r20 <= 0) goto L99;
    L102:
        int r110 = r11 + 1;
        int r21 = this.f16049p.size();
    L103:
        if (r110 >= r21) goto L120;
        Segment r22 = (Segment) this.f16049p.get(r110);
        if ((r22.f16035b.get() - r22.f16034a) > 0) goto L110;
        if (r22.f != null) goto L110;
        r110 = r110 + 1;
    L110:
        long r23 = r30.d;
        long r24 = r22.f16034a;
        if (r23 > 0) goto L113;
    L114:
        long r25 = r24 - 1;
        r30.a(r25);
        if (Logger.b() == false) goto L118;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "segment set end:" + r25 + ", later = " + r22, false);
    L118:
        if (Logger.b() == false) goto L120;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "Break 2", false);
        goto L120
    L113:
        if (r23 < r24) goto L118;
    L120:
        long r26 = r30.d;
        if (r26 > 0) goto L123;
    L129:
        r30.f = r29;
        if (Logger.b() == false) goto L152;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "ApplySegment: OK " + r30, false);
        return;
    L152:
        return;
    L123:
        if (r10 > r26) goto L128;
        if (r30.b() <= r26) goto L129;
    L128:
        throw new SegmentApplyException(6, "applySegment: " + r30);
    L31:
        if (r13.f16034a != r30.f16034a) goto L56;
        long r27 = b(r13);
        if (r27 <= 0) goto L56;
        SegmentReader r111 = r13.f;
        if (r111 == null) goto L47;
        if (r27 >= 524288) goto L44;
        if ((r29.J - r111.J) <= 1000) goto L44;
        if ((r13.b() - r30.b()) < (r27 / 2)) goto L47;
    L44:
        if (Logger.b() == false) goto L56;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "Has same segment, but owner is normal, abort. segmentInList = " + r13, false);
    L47:
        if (r111 == null) goto L53;
        if (Logger.b() == false) goto L51;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "Has same segment,and owner too slow, segmentInList = " + r13, false);
    L51:
        r111.a(true);
    L55:
        r30.a(r13.d);
        r30.g = r13.g;
        this.f16049p.set(r11, r30);
        goto L59
    L53:
        if (Logger.b() == false) goto L55;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "applySegmentLocked", "Has same segment and no owner, segmentInList = " + r13, false);
    L56:
        Logger.a("SegmentDispatcher", this.f16038a.l(), "applySegmentLocked", "ApplySegment: " + r30 + " not exist! but has another same segment, segmentInList = " + r13);
        throw new SegmentApplyException(2, "segment not exist, but has another same segment");
    L133:
        Logger.a("SegmentDispatcher", this.f16038a.l(), "applySegmentLocked", "ApplySegment: " + r30 + " not exist! segmentIndex = " + r11);
        throw new SegmentApplyException(2, "segment not exist");
    L24:
        r11 = -1;
        goto L25
    L136:
        throw new SegmentApplyException(5, "applySegment");
    }

    public final Segment a(SegmentReader r5, UrlRecord r10) {
        if (this.g == false) goto L5;
        return null;
    L5:
        if (this.f16041h == true) goto L24;
        monitor-enter(this);
        Segment r11 = b(r5);     // Catch: Throwable -> L15
        if (r11 == null) goto L17;
        int r12 = r11.g + 1;     // Catch: Throwable -> L15
        r11.g = r12;     // Catch: Throwable -> L15
        if (r12 <= 1) goto L17;
        Segment r13 = new Segment(r11);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r13;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L15
        return r11;
    L15:
        th = move-exception;
        throw th;
    L24:
        return null;
    }

    public final void a(SegmentReader r5, Segment r10) {
        monitor-enter(this);
        b(r5, r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final IOutput a(Segment r5) {
        monitor-enter(this);
        SegmentOutput r10 = new SegmentOutput(this.f16038a, this.d, r5);     // Catch: Throwable -> L6
        this.f.a(r10);     // Catch: Throwable -> L6
        IOutput r11 = r10.f16064c;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(SegmentReader r10, Segment r11, BaseException r12) {
        monitor-enter(this);
        Logger.a("SegmentDispatcher", this.f16038a.l(), "onSegmentFailed", "Segment: " + r11 + " e:" + r12);     // Catch: Throwable -> L7
        r10.F = true;     // Catch: Throwable -> L7
        if (r10.f16080u != 0) goto L9;
        this.f16051r = r12;     // Catch: Throwable -> L7
    L9:
        Iterator r13 = this.f16042i.iterator();     // Catch: Throwable -> L7
    L11:
        if (r13.hasNext() == false) goto L16;
        if (((SegmentReader) r13.next()).F == true) goto L11;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L16:
        if (this.f16051r != null) goto L18;
        this.f16051r = r12;     // Catch: Throwable -> L7
    L18:
        this.f16054v = true;     // Catch: Throwable -> L7
        a(this.f16051r);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(BaseException r5) {
        Logger.a("SegmentDispatcher", this.f16038a.l(), "onError", "Exception: " + r5);
        this.f16051r = r5;
        this.d.a();
        monitor-enter(this);
        Iterator r10 = this.f16042i.iterator();     // Catch: Throwable -> L8
    L6:
        if (r10.hasNext() == false) goto L10;
        ((SegmentReader) r10.next()).a();     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final UrlRecord a(SegmentReader r10) {
        Iterator r5 = this.f16043j.iterator();
        UrlRecord r11 = null;
    L4:
        if (r5.hasNext() == false) goto L19;
        UrlRecord r12 = (UrlRecord) r5.next();
        if (r12 == r10.f16070j) goto L4;
        monitor-enter(r12);
        boolean r13 = r12.g;     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
        if (r13 == true) goto L4;
        if (r11 != null) goto L14;
        r11 = r12;
    L14:
        if (r12.a() > 0) goto L4;
    L21:
        if (this.f16040c.f16086a.optInt("url_balance", 2) <= 0) goto L27;
        if (r12 == null) goto L25;
        return r12;
    L25:
        if (this.f16040c.f16086a.optInt("url_balance", 2) != 1) goto L27;
        return null;
    L27:
        return r11;
    L16:
        th = move-exception;
        throw th;
    L19:
        r12 = null;
        goto L21
    }

    public final void a(SegmentReader r11, Segment r12, UrlRecord r13, HttpResponse r14) {
        SegmentReader r5 = r12.f;
        if (r5 == null) goto L9;
        if (r5 == r11) goto L9;
        throw new SegmentApplyException(1, "segment already has an owner");
    L9:
        if (r11.f16071k != r12.b()) goto L94;
        if (r14.a() == false) goto L13;
    L24:
        DownloadMultiSegmentModule r15 = this.e;
        if (r15 == null) goto L28;
        r15.b(r14.c(), this.f16038a.f15819j);
    L28:
        if (r13.d == true) goto L30;
        HttpResponse r16 = this.f16044k;
        if (r16 != null) goto L56;
        r16 = this.f16045l;
        if (r16 != null) goto L56;
    L77:
        if (this.f16045l != null) goto L106;
        this.f16045l = r14;
        if (this.f16038a.f15817h0 > 0) goto L84;
        long r17 = r14.c();
        if (Logger.b() == false) goto L83;
        int r10 = this.f16038a.l();
        StringBuilder r18 = a.K(r17, "Len=", ",url=");
        r18.append(r13.f16088a);
        Logger.a("SegmentDispatcher", r10, null, "checkSegmentHttpResponseLocked", r18.toString(), false);
    L83:
        this.f16038a.f15817h0 = r17;
    L84:
        Object r19 = this.s;
        monitor-enter(r19);
        this.s.notify();     // Catch: Throwable -> L89
        monitor-exit(r19);     // Catch: Throwable -> L89
        return;
    L89:
        th = move-exception;
        throw th;
    L106:
        return;
    L56:
        long r20 = r14.c();
        long r21 = r16.c();
        if (r20 == r21) goto L65;
        StringBuilder r110 = a.K(r20, "Total len not equals,len=", ",sLen=");
        r110.append(r21);
        r110.append(",code=");
        r110.append(r14.f15913c);
        r110.append(",sCode=");
        r110.append(r16.f15913c);
        r110.append(",range=");
        r110.append(DownloadUtils.a(r14.f15912b, "Content-Range"));
        r110.append(",sRange = ");
        r110.append(DownloadUtils.a(r16.f15912b, "Content-Range"));
        r110.append(",url = ");
        r110.append(r14.f15911a);
        r110.append(",sUrl=");
        r110.append(r16.f15911a);
        String r111 = r110.toString();
        Logger.a("SegmentDispatcher", this.f16038a.l(), "validateHttpResponse", r111);
        if (r20 <= 0) goto L65;
        if (r21 <= 0) goto L65;
        throw new BaseException(1074, r111);
    L65:
        String r112 = r14.f15912b.a("Etag");
        String r113 = r16.f15912b.a("Etag");
        if (TextUtils.equals(r112, r113) == true) goto L77;
        String r22 = b.j("Etag not equals with main url, etag = ", r112, ", mainEtag = ", r113);
        Logger.a("SegmentDispatcher", this.f16038a.l(), "validateHttpResponse", r22);
        if (TextUtils.isEmpty(r112) == true) goto L77;
        if (TextUtils.isEmpty(r113) == true) goto L77;
        if (r112.equalsIgnoreCase(r113) == true) goto L77;
        throw new BaseException(1074, r22);
    L30:
        if (this.f16044k != null) goto L92;
        this.f16044k = r14;
        Object r114 = this.s;
        monitor-enter(r114);
        this.s.notify();     // Catch: Throwable -> L48
        monitor-exit(r114);     // Catch: Throwable -> L48
        DownloadMultiSegmentModule r115 = this.e;
        if (r115 == null) goto L38;
        r115.a(r13.f16088a, r14.f15912b, r12.b());
    L38:
        long r116 = r14.c();
        if (r116 <= 0) goto L105;
        Iterator r117 = this.f16049p.iterator();
    L42:
        if (r117.hasNext() == false) goto L107;
        Segment r118 = (Segment) r117.next();
        long r23 = r118.d;
        if (r23 <= 0) goto L47;
        if (r23 <= (r116 - 1)) goto L42;
    L47:
        r118.a(r116 - 1);
        goto L42
    L107:
        return;
    L105:
        return;
    L48:
        th = move-exception;
        throw th;
    L92:
        return;
    L13:
        if (r12.b() > 0) goto L23;
        Logger.a("SegmentDispatcher", this.f16038a.l(), "checkSegmentHttpResponseLocked", "Segment.getCurrentOffsetRead = " + r12.b());
        int r119 = r14.f15913c;
        SparseArray r24 = DownloadHelper.f16133a;
        if (r119 == 200) goto L24;
        if (r119 == 201) goto L24;
        if (r119 == 0) goto L24;
        throw new DownloadHttpException(r14.f15913c, "2: response code error : " + r14.f15913c + " segment=" + r12);
    L23:
        throw new DownloadHttpException(r14.f15913c, "1: response code error : " + r14.f15913c + " segment=" + r12);
    L94:
        throw new SegmentApplyException(5, "applySegment");
    }

    public final void b() {
        if (this.f16047n <= 0) goto L55;
        int r5 = this.f16049p.size();
        if (r5 <= 1) goto L56;
        ArrayList r10 = null;
        int r11 = 0;
        int r12 = 1;
    L9:
        if (r12 >= r5) goto L27;
        Segment r13 = (Segment) this.f16049p.get(r11);
        Segment r14 = (Segment) this.f16049p.get(r12);
        if (r13.b() <= r14.f16034a) goto L24;
        if ((r14.f16035b.get() - r14.f16034a) > 0) goto L24;
        if (r14.f != null) goto L24;
        if (r10 != null) goto L18;
        r10 = new ArrayList(1);
    L18:
        r10.add(r14);
        if (this.B == false) goto L26;
        if (Logger.b() == false) goto L26;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "clearCoveredSegmentLocked", "covered = " + r14 + ", prev = " + r13, false);
    L26:
        r12 = r12 + 1;
    L24:
        if (r14.b() <= r13.b()) goto L26;
        r11 = r11 + 1;
        goto L26
    L27:
        if (r10 == null) goto L42;
        Iterator r15 = r10.iterator();
    L30:
        if (r15.hasNext() == false) goto L57;
        Segment r16 = (Segment) r15.next();
        this.f16049p.remove(r16);
        Iterator r17 = this.f16042i.iterator();
    L33:
        if (r17.hasNext() == false) goto L30;
        SegmentReader r18 = (SegmentReader) r17.next();
        if (r18.f16069i != r16) goto L33;
        if (this.B == true) goto L39;
    L41:
        r18.a(true);
        goto L33
    L39:
        if (Logger.b() == false) goto L41;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "clearCoveredSegmentLocked", "reconnect, segment = " + r16 + ", threadIndex = " + r18.f16080u, false);
        goto L41
    L57:
        return;
    L42:
        return;
    L56:
        return;
    }

    public final void a() {
        if (Logger.b() == false) goto L5;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "cancel", "Run", false);
    L5:
        this.g = true;
        monitor-enter(this);
        Iterator r5 = this.f16042i.iterator();     // Catch: Throwable -> L11
    L9:
        if (r5.hasNext() == false) goto L13;
        ((SegmentReader) r5.next()).a();     // Catch: Throwable -> L11
        goto L9
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        MultiSegmentWriter r10 = this.f;
        r10.f16022k = true;
        r10.f16020i = true;
        this.d.a();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final SegmentReader a(boolean r10, long r11, long r12) {
        Iterator r13 = this.f16042i.iterator();
        SegmentReader r5 = null;
    L4:
        if (r13.hasNext() == false) goto L20;
        SegmentReader r14 = (SegmentReader) r13.next();
        if (r14.f16080u != 0) goto L10;
        if (r10 == false) goto L4;
    L10:
        if (r14.H <= 0) goto L4;
        if (r14.I > 0) goto L4;
        if ((r11 - r14.H) <= r12) goto L4;
        if (r5 == null) goto L19;
        if (r14.H >= r5.H) goto L4;
    L19:
        r5 = r14;
        goto L4
    L20:
        return r5;
    }

    public final void a(long r12) {
        this.f16052t.b(this.f16038a.i(), r12);
        Iterator r11 = this.f16042i.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        SegmentReader r5 = (SegmentReader) r11.next();
        long r10 = r5.f16074n;
        DownloadStenographer r13 = r5.G;
        if (r10 < 0) goto L4;
        if (r13 == null) goto L4;
        if (Logger.b() == false) goto L12;
        int r14 = r5.d.l();
        StringBuilder r15 = a.K(r10, "CurSegmentReadOffset = ", ", threadIndex = ");
        r15.append(r5.f16080u);
        Logger.a("SegmentReader", r14, null, "markProgress", r15.toString(), false);
    L12:
        r13.b(r10, r12);
        goto L4
    }

    public final boolean a(long r27, long r29) {
        long r5 = r27 - r29;
        long r10 = this.f16052t.a(r5, r27);
        int r11 = this.f16042i.size();
        if (r11 <= 0) goto L5;
        r10 = r10 / ((long) r11);
    L5:
        long r12 = (long) Math.max(10.0f, r10 * this.f16058z);
        int r13 = r11 / 2;
        Iterator r14 = this.f16042i.iterator();
        long r15 = Long.MAX_VALUE;
        SegmentReader r16 = null;
        int r17 = 0;
    L7:
        if (r14.hasNext() == false) goto L28;
        SegmentReader r18 = (SegmentReader) r14.next();
        long r19 = r15;
        if (r18.J <= 0) goto L27;
        r17 = r17 + 1;
        if (r18.J >= r5) goto L27;
        DownloadStenographer r110 = r18.G;
        if (r110 != null) goto L16;
        long r111 = -1;
    L15:
        r15 = r111;
        if (this.B == false) goto L23;
        if (Logger.b() == false) goto L23;
        int r21 = this.f16038a.l();
        StringBuilder r20 = a.K(r15, "Speed = ", ", threadIndex = ");
        r20.append(r18.f16080u);
        Logger.a("SegmentDispatcher", r21, null, "findPoorReadThread", r20.toString(), false);
    L23:
        if (r15 < 0) goto L27;
        if (r15 >= r19) goto L27;
        r16 = r18;
        goto L7
    L16:
        r111 = r110.a(r5, r27);
    L27:
        r15 = r19;
        goto L7
    L28:
        long r112 = r15;
        if (r16 == null) goto L37;
        if (r17 < r13) goto L37;
        if (r112 >= r12) goto L37;
        if (Logger.b() == false) goto L36;
        int r113 = this.f16038a.l();
        StringBuilder r22 = a.K(r112, "MinSpeed = ", ", threadIndex = ");
        r22.append(r16.f16080u);
        Logger.a("SegmentDispatcher", r113, null, "findPoorReadThread", r22.toString(), false);
    L36:
        SegmentReader r23 = r16;
    L39:
        if (r23 == null) goto L45;
        d(r23);
        if (Logger.b() == false) goto L43;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "findPoorReadThreadAndReconnect", "HandlePoorReadThread: reconnect for poor speed, threadIndex = " + r23.f16080u, false);
    L43:
        r23.a(false);
        return true;
    L45:
        SegmentReader r24 = a(true, r27, r29);
        if (r24 == null) goto L52;
        d(r24);
        if (Logger.b() == false) goto L50;
        Logger.a("SegmentDispatcher", this.f16038a.l(), null, "findPoorReadThreadAndReconnect", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + r24.f16080u, false);
    L50:
        r24.a(false);
        return true;
    L52:
        return false;
    L37:
        r23 = null;
        goto L39
    }
}
