package com.ss.android.socialbase.downloader.segment;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNetworkService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: classes3.dex */
class SegmentReader implements Runnable {
    public final NetworkFailoverStrategy A;
    public long B;
    public int C;
    public boolean D;
    public BaseException E;
    public boolean F;
    public DownloadStenographer G;
    public volatile long H;
    public volatile long I;
    public volatile long J;
    public volatile long K;
    public String L;
    public String M;
    public String N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SegmentDispatcher f16065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IBufferPool f16066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadTask f16067c;
    public final DownloadInfo d;
    public final DownloadSetting e;
    public IDownloadHttpConnection f;
    public HttpResponse g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f16068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Segment f16069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UrlRecord f16070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f16071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f16072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile long f16073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile long f16074n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile long f16075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Future f16076p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f16077q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f16078r;
    public volatile boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Thread f16079t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f16080u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f16081v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f16082w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f16083x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f16084y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final NetworkRetryStrategy f16085z;

    public SegmentReader(DownloadTask r5, DownloadInfo r10, SegmentDispatcher r11, IBufferPool r12, UrlRecord r13, int r14) {
        this.f16068h = new ArrayList();
        this.f16074n = -1;
        this.f16067c = r5;
        this.d = r10;
        this.f16065a = r11;
        this.f16066b = r12;
        this.e = DownloadSetting.a(r10.l(), null);
        this.f16070j = r13;
        this.f16080u = r14;
        this.f16085z = new NetworkRetryStrategy(r10);
        this.A = new NetworkFailoverStrategy(r10);
    }

    public final boolean a(UrlRecord r5) {
        int r10 = this.C;
        if (r10 < 30) goto L6;
        return false;
    L6:
        this.C = r10 + 1;
        UrlRecord r11 = this.f16070j;
        if (r11 == null) goto L9;
        r11.a(this);
    L9:
        monitor-enter(r5);
        r5.e.add(this);     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        this.f16070j = r5;
        f();
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    public final void b() {
        IDownloadHttpConnection r5 = this.f;
        if (r5 == null) goto L12;
        if (Logger.b() == false) goto L7;
        Logger.a("SegmentReader", this.d.l(), null, "closeConnection", "Thread: " + this.f16080u, false);     // Catch: Throwable -> L9
    L7:
        r5.c();     // Catch: Throwable -> L9
        r5.cancel();     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    public final void c(Segment r40) {
        Segment r5 = r40;
        IBufferPool r10 = this.f16066b;
        this.J = System.currentTimeMillis();
        long r11 = r40.b();
        InputStream r12 = this.f.a();     // Catch: Throwable -> L203 BaseException -> L205
        if (r12 == null) goto L200;
        HttpResponse r13 = this.g;     // Catch: Throwable -> L10 BaseException -> L194
        if (r13.d > 0) goto L14;
        r13.d = DownloadUtils.a(r13.f15912b);     // Catch: Throwable -> L10 BaseException -> L12
    L14:
        long r14 = r13.d;     // Catch: Throwable -> L10 BaseException -> L12
        if (r14 == 0) goto L197;
        Buffer r15 = a(r10, r12);     // Catch: Throwable -> L10 BaseException -> L194
    L188:
        e = e;
    L224:
        this.E = e;     // Catch: Throwable -> L211
        throw e;     // Catch: Throwable -> L211
    L186:
        th = th;
        IOutput r16 = null;
    L190:
        long r17 = r11;
    L268:
        Logger.a("SegmentReader", this.d.l(), "loopAndRead", "Exception: " + th + " stack: " + Log.getStackTraceString(th));     // Catch: Throwable -> L215
        th.printStackTrace();     // Catch: Throwable -> L215
        DownloadHelper.a(th, "loopAndRead");     // Catch: Throwable -> L215 BaseException -> L217
    L275:
        throw null;     // Catch: Throwable -> L211 BaseException -> L213
    L213:
        e = e;
    L219:
        this.E = e;     // Catch: Throwable -> L211
        DownloadHelper.a(this.f, e);     // Catch: Throwable -> L211
        throw e;     // Catch: Throwable -> L211
    L217:
        e = e;
    L215:
        th = th;
    L226:
        DownloadUtils.a(new Closeable[]{r12});
        if (r16 == null) goto L232;
        if (r15 == null) goto L266;
    L230:
        r15.f16008c = -1;     // Catch: Throwable -> L246
        OutputStub r18 = (OutputStub) r16;     // Catch: Throwable -> L246
        r15.f16007b = r18.f16033b;     // Catch: Throwable -> L246
        ((BufferQueue) r18.f16032a).b(r15);     // Catch: Throwable -> L246
        r15 = null;
        goto L232
    L266:
        r15 = ((BufferQueue) r10).b();     // Catch: Throwable -> L246
    L232:
        if (r15 == null) goto L234;
        ((BufferQueue) r10).a(r15);
    L234:
        this.K = System.currentTimeMillis();
        if (r17 <= r11) goto L244;
        DownloadSetting r19 = this.e;
        DownloadInfo r20 = this.d;
        String r21 = this.L;
        String r22 = this.M;
        String r110 = this.N;
        if (this.f16077q == false) goto L239;
    L242:
        boolean r24 = true;
    L243:
        DownloadMonitorHelper.a(r19.a("monitor_segment_io", 0), r19, r20, r21, r22, r110, this.f, r24, false, this.E, r17 - r11, TimeUnit.MILLISECONDS.toNanos(this.K - this.J), false, -1, -1, -1);
        goto L244
    L239:
        if (this.f16078r == true) goto L242;
        r24 = false;
    L244:
        this.f16065a.c(this, r5);
        throw th;
    L19:
        if (this.f16078r == true) goto L193;
        if (this.f16077q == true) goto L193;
        this.f16085z.b();     // Catch: Throwable -> L186 BaseException -> L188
        this.f16065a.a(this, r5);     // Catch: Throwable -> L186 BaseException -> L188
        r16 = this.f16065a.a(r5);     // Catch: Throwable -> L186 BaseException -> L188
        long r23 = r5.d;     // Catch: Throwable -> L182 BaseException -> L184
        if (r23 > 0) goto L29;
        if (r14 <= 0) goto L28;
        r23 = (r14 + r11) - 1;     // Catch: Throwable -> L182 BaseException -> L184
        goto L29
    L28:
        r23 = Long.MAX_VALUE;
    L29:
        int r25 = r15.f16008c;     // Catch: Throwable -> L182 BaseException -> L184
        long r111 = r25;
        r17 = r11 + r111;
        if (r17 <= r23) goto L62;
        long r26 = r23 + 1;
        if (r17 <= r26) goto L38;
        int r112 = (int) (r111 - (r17 - r26));
        if (r112 <= 0) goto L38;
        if (r112 >= r25) goto L38;
        r15.f16008c = r112;     // Catch: Throwable -> L58 BaseException -> L60
        r17 = r26;
    L38:
        this.f16074n = r17;     // Catch: Throwable -> L58 BaseException -> L60
        OutputStub r27 = (OutputStub) r16;     // Catch: Throwable -> L58 BaseException -> L60
        r15.f16007b = r27.f16033b;     // Catch: Throwable -> L58 BaseException -> L60
        ((BufferQueue) r27.f16032a).b(r15);     // Catch: Throwable -> L58 BaseException -> L60
        DownloadUtils.a(new Closeable[]{r12});
        Buffer r28 = ((BufferQueue) r10).b();     // Catch: Throwable -> L247
        r28.f16008c = -1;     // Catch: Throwable -> L43
        OutputStub r29 = (OutputStub) r16;     // Catch: Throwable -> L43
        r28.f16007b = r29.f16033b;     // Catch: Throwable -> L43
        ((BufferQueue) r29.f16032a).b(r28);     // Catch: Throwable -> L43
    L43:
        Buffer r30 = r28;
    L44:
        if (r30 == null) goto L46;
        ((BufferQueue) r10).a(r30);
    L46:
        this.K = System.currentTimeMillis();
        if (r17 <= r11) goto L56;
        DownloadSetting r31 = this.e;
        DownloadInfo r32 = this.d;
        String r33 = this.L;
        String r34 = this.M;
        String r35 = this.N;
        if (this.f16077q == false) goto L51;
    L54:
        boolean r210 = true;
    L55:
        DownloadMonitorHelper.a(r31.a("monitor_segment_io", 0), r31, r32, r33, r34, r35, this.f, r210, false, this.E, r17 - r11, TimeUnit.MILLISECONDS.toNanos(this.K - this.J), false, -1, -1, -1);
        goto L56
    L51:
        if (this.f16078r == true) goto L54;
        r210 = false;
    L56:
        this.f16065a.c(this, r5);
        return;
    L42:
        r30 = null;
        goto L44
    L62:
        this.f16074n = r17;     // Catch: Throwable -> L58 BaseException -> L60
        OutputStub r36 = (OutputStub) r16;     // Catch: Throwable -> L58 BaseException -> L60
        r15.f16007b = r36.f16033b;     // Catch: Throwable -> L58 BaseException -> L60
        ((BufferQueue) r36.f16032a).b(r15);     // Catch: Throwable -> L58 BaseException -> L60
    L283:
        if (this.f16081v == true) goto L280;
    L115:
        r15 = ((BufferQueue) r10).b();     // Catch: Throwable -> L105 BaseException -> L107
        SparseArray r37 = DownloadHelper.f16133a;     // Catch: Throwable -> L119 BaseException -> L121
        int r38 = r12.read(r15.f16006a);     // Catch: Throwable -> L119 BaseException -> L121
        r15.f16008c = r38;     // Catch: Throwable -> L119 BaseException -> L121
        if (r38 == (-1)) goto L118;
        long r113 = r38;
        r17 = r17 + r113;     // Catch: Throwable -> L119 BaseException -> L121
        if (r17 > r23) goto L125;
        r5 = r40;
        this.f16074n = r17;     // Catch: Throwable -> L58 BaseException -> L60
        OutputStub r39 = (OutputStub) r16;     // Catch: Throwable -> L58 BaseException -> L60
        r15.f16007b = r39.f16033b;     // Catch: Throwable -> L58 BaseException -> L60
        ((BufferQueue) r39.f16032a).b(r15);     // Catch: Throwable -> L58 BaseException -> L60
        goto L283
    L125:
        long r211 = r23 + 1;     // Catch: Throwable -> L119 BaseException -> L121
        if (r17 <= r211) goto L131;
        int r41 = (int) (r113 - (r17 - r211));     // Catch: Throwable -> L119 BaseException -> L121
        if (r41 <= 0) goto L131;
        if (r41 >= r38) goto L131;
        r15.f16008c = r41;     // Catch: Throwable -> L119 BaseException -> L121
        r17 = r211;
    L131:
        this.f16074n = r17;     // Catch: Throwable -> L119 BaseException -> L121
        OutputStub r42 = (OutputStub) r16;     // Catch: Throwable -> L119 BaseException -> L121
        r15.f16007b = r42.f16033b;     // Catch: Throwable -> L119 BaseException -> L121
        ((BufferQueue) r42.f16032a).b(r15);     // Catch: Throwable -> L119 BaseException -> L121
        if (Logger.b() == true) goto L134;
    L96:
        long r114 = 0;
    L137:
        if (r23 <= r114) goto L153;
        if (r23 == Long.MAX_VALUE) goto L153;
        if (r17 > r23) goto L153;
        Locale r43 = Locale.US;     // Catch: Throwable -> L145 BaseException -> L147
        throw new BaseException(1051, "range[" + r11 + ", " + r23 + "] , but readCurrent[" + r17 + "] , readStart[" + r11 + "]");     // Catch: Throwable -> L145 BaseException -> L147
    L147:
        e = e;
    L145:
        th = th;
    L149:
        r5 = r40;
    L150:
        r15 = null;
    L153:
        DownloadUtils.a(new Closeable[]{r12});
        if (r16 != null) goto L256;
    L158:
        Buffer r44 = null;
    L160:
        if (r44 == null) goto L162;
        ((BufferQueue) r10).a(r44);
    L162:
        this.K = System.currentTimeMillis();
        if (r17 <= r11) goto L172;
        DownloadSetting r45 = this.e;
        DownloadInfo r46 = this.d;
        String r47 = this.L;
        String r48 = this.M;
        String r49 = this.N;
        if (this.f16077q == false) goto L167;
    L170:
        boolean r212 = true;
    L171:
        DownloadMonitorHelper.a(r45.a("monitor_segment_io", 0), r45, r46, r47, r48, r49, this.f, r212, false, this.E, r17 - r11, TimeUnit.MILLISECONDS.toNanos(this.K - this.J), false, -1, -1, -1);
        goto L172
    L167:
        if (this.f16078r == true) goto L170;
        r212 = false;
    L172:
        this.f16065a.c(this, r40);
        return;
    L256:
        Buffer r50 = ((BufferQueue) r10).b();     // Catch: Throwable -> L248
        r50.f16008c = -1;     // Catch: Throwable -> L159
        OutputStub r51 = (OutputStub) r16;     // Catch: Throwable -> L159
        r50.f16007b = r51.f16033b;     // Catch: Throwable -> L159
        ((BufferQueue) r51.f16032a).b(r50);     // Catch: Throwable -> L159
    L159:
        r44 = r50;
        goto L160
    L134:
        Logger.a("SegmentReader", this.d.l(), null, "loopAndRead", "BytesRead = " + (r17 - r11) + ", url = " + this.f16070j.f16088a, false);     // Catch: Throwable -> L105 BaseException -> L107
        goto L96
    L118:
        OutputStub r52 = (OutputStub) r16;     // Catch: Throwable -> L119 BaseException -> L121
        r15.f16007b = r52.f16033b;     // Catch: Throwable -> L119 BaseException -> L121
        ((BufferQueue) r52.f16032a).b(r15);     // Catch: Throwable -> L119 BaseException -> L121
        r114 = 0;
        r16 = null;
    L121:
        e = e;
    L119:
        th = th;
        r5 = r40;
        goto L268
    L280:
        monitor-enter(this);     // Catch: Throwable -> L105 BaseException -> L107
        this.f16081v = false;     // Catch: Throwable -> L109
        if (this.f16078r == true) goto L112;
        if (this.f16077q == true) goto L112;
        monitor-exit(this);     // Catch: Throwable -> L109
        SegmentDispatcher r53 = this.f16065a;     // Catch: Throwable -> L105 BaseException -> L107
        monitor-enter(r53);     // Catch: Throwable -> L105 BaseException -> L107
        if (this.f16072l != 0) goto L77;
    L100:
        SegmentDispatcher r213 = r53;
        monitor-exit(r213);     // Catch: Throwable -> L91
    L91:
        th = th;
    L103:
        monitor-exit(r213);     // Catch: Throwable -> L91
        throw th;     // Catch: Throwable -> L105 BaseException -> L107
    L77:
        if (Logger.b() == false) goto L81;
        Logger.a("SegmentReader", this.d.l(), null, "loopAndRead", "Change readEnd = " + r23 + ", segmentNewEndOffset = " + this.f16072l + ", segment = " + r5, false);     // Catch: Throwable -> L79
    L81:
        r23 = this.f16072l;     // Catch: Throwable -> L79
        this.f16072l = 0;     // Catch: Throwable -> L79
        if (r23 > 0) goto L86;
        r23 = Long.MAX_VALUE;
    L86:
        if (r17 <= r23) goto L100;
        r213 = r53;
        long r54 = r23 + 1;
        long r214 = r23;
        long r55 = r17 - r54;
        if (r55 <= 0) goto L271;
        Logger.a("SegmentReader", this.d.l(), "loopAndRead", "redundant: " + r55);     // Catch: Throwable -> L91
    L271:
        this.f16074n = r54;     // Catch: Throwable -> L97
        monitor-exit(r213);     // Catch: Throwable -> L97
        r17 = r54;
        r23 = r214;
    L97:
        th = th;
    L79:
        th = th;
        r213 = r53;
    L112:
        throw new StreamClosedException("loopAndRead");     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        throw th;     // Catch: Throwable -> L105 BaseException -> L107
    L107:
        e = e;
    L105:
        th = th;
        goto L149
    L179:
        e = e;
    L177:
        th = th;
    L60:
        e = e;
    L58:
        th = th;
        goto L268
    L184:
        e = e;
    L182:
        th = th;
    L193:
        throw new StreamClosedException("probe");     // Catch: Throwable -> L186 BaseException -> L188
    L197:
        throw new DownloadRetryNeedlessException(PointerIconCompat.TYPE_WAIT, "the content-length is 0, contentLength = " + r14);     // Catch: Throwable -> L10 BaseException -> L194
    L200:
        throw new BaseException(1042, DownloadUtils.a(new IOException("inputStream is null")));     // Catch: Throwable -> L10 BaseException -> L194
    L10:
        th = th;
    L201:
        r17 = r11;
        r15 = null;
        r16 = null;
    L12:
        e = e;
    L194:
        e = e;
        Object r56 = null;
        goto L224
    L205:
        e = e;
        r56 = null;
    L221:
        e = e;
        r56 = null;
    L203:
        th = th;
        r12 = null;
    L211:
        th = th;
        goto L226
    }

    public final long d() {
        SegmentDispatcher r5 = this.f16065a;
        monitor-enter(r5);
        long r10 = this.f16074n;     // Catch: Throwable -> L11
        long r11 = this.f16071k;     // Catch: Throwable -> L11
        if (r11 >= 0) goto L7;
    L13:
        monitor-exit(r5);     // Catch: Throwable -> L11
        return 0;
    L7:
        if (r10 <= r11) goto L13;
        long r12 = r10 - r11;     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e() {
        this.B = this.H;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        b();
    }

    public final void f() {
        if (this.f16070j.d == false) goto L5;
        int r5 = this.d.f15824m;
    L6:
        this.f16083x = r5;
        this.f16084y = 0;
        this.f16085z.b();
        return;
    L5:
        r5 = this.d.f15826n;
        goto L6
    }

    public final void g() {
        UrlRecord r5 = this.f16070j;
        SegmentDispatcher r10 = this.f16065a;     // Catch: Throwable -> L15
        monitor-enter(r10);     // Catch: Throwable -> L15
        long r11 = d();     // Catch: Throwable -> L8
        if (r11 <= 0) goto L10;
        this.f16075o += r11;     // Catch: Throwable -> L8
        r5.f16093j.addAndGet(r11);     // Catch: Throwable -> L8
    L10:
        this.f16074n = -1;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        this.f16079t = Thread.currentThread();     // Catch: Throwable -> L8
        SegmentDispatcher r5 = this.f16065a;     // Catch: Throwable -> L8
        if (r5.B == true) goto L6;
    L10:
        UrlRecord r10 = this.f16070j;     // Catch: Throwable -> L8
        monitor-enter(r10);     // Catch: Throwable -> L8
        r10.e.add(this);     // Catch: Throwable -> L47
        monitor-exit(r10);     // Catch: Throwable -> L47
    L14:
        Segment r11 = this.f16065a.a(this, this.f16070j);     // Catch: Throwable -> L8
        if (r11 == null) goto L17;
        this.f16069i = r11;     // Catch: Throwable -> L8
    L27:
        e = move-exception;
        Logger.a("SegmentReader", this.d.l(), "run", "SegmentApplyException, Exception = " + e);     // Catch: Throwable -> L25
        int r12 = this.f16082w;     // Catch: Throwable -> L25
        if (r12 >= 50) goto L36;
        this.f16082w = r12 + 1;     // Catch: Throwable -> L25
        this.f16069i = null;     // Catch: Throwable -> L8
        SegmentDispatcher r13 = this.f16065a;     // Catch: Throwable -> L8
    L44:
        r13.c(r11);     // Catch: Throwable -> L8
        goto L14
    L36:
        Logger.a("SegmentReader", this.d.l(), "run", "Segment apply failed " + this.f16082w + "times, thread_index = " + this.f16080u);     // Catch: Throwable -> L25
        this.f16069i = null;     // Catch: Throwable -> L8
        SegmentDispatcher r14 = this.f16065a;     // Catch: Throwable -> L8
    L38:
        r14.c(r11);     // Catch: Throwable -> L8
    L39:
        this.f16070j.a(this);     // Catch: Throwable -> L58
        this.f16065a.c(this);     // Catch: Throwable -> L58
        goto L52
    L25:
        th = move-exception;
        this.f16069i = null;     // Catch: Throwable -> L8
        this.f16065a.c(r11);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L21:
        if (b(r11) == false) goto L30;
        this.f16068h.add(r11);     // Catch: Throwable -> L25 SegmentApplyException -> L27
        this.f16069i = null;     // Catch: Throwable -> L8
        r13 = this.f16065a;     // Catch: Throwable -> L8
        goto L44
    L30:
        if (this.f16077q == true) goto L32;
        Logger.a("SegmentReader", this.d.l(), "run", "Download segment failed, segment = " + r11 + ", thread_index = " + this.f16080u + ", failedException = " + this.E);     // Catch: Throwable -> L25 SegmentApplyException -> L27
    L32:
        this.f16069i = null;     // Catch: Throwable -> L8
        r14 = this.f16065a;     // Catch: Throwable -> L8
        goto L38
    L17:
        if (Logger.b() == false) goto L39;
        Logger.a("SegmentReader", this.d.l(), null, "run", "No more segment, thread_index: " + this.f16080u, false);     // Catch: Throwable -> L8
        goto L39
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L6:
        if (Logger.b() == false) goto L10;
        Logger.a("SegmentDispatcher", r5.f16038a.l(), null, "onReaderRun", "ThreadIndex = " + this.f16080u, false);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L54
        this.f16070j.a(this);     // Catch: Throwable -> L58
        this.f16065a.c(this);     // Catch: Throwable -> L58
    L54:
        th = move-exception;
        this.f16070j.a(this);     // Catch: Throwable -> L59
        this.f16065a.c(this);     // Catch: Throwable -> L59
    L56:
        this.f16079t = null;
        throw th;
    L52:
        this.f16079t = null;
    }

    public final boolean b(Segment r10) {
        this.D = false;
        f();
    L49:
        a(r10);     // Catch: Throwable -> L6 SegmentApplyException -> L8
        c(r10);     // Catch: Throwable -> L6 SegmentApplyException -> L8
    L4:
        e();
        return true;
    L8:
        e = move-exception;
        this.E = e;     // Catch: Throwable -> L26
        throw e;     // Catch: Throwable -> L26
    L6:
        th = move-exception;
        Logger.a("SegmentReader", this.d.l(), "download", "e = " + th + ", threadIndex = " + this.f16080u + ", reconnect = " + this.f16078r + ", closed = " + this.f16077q);     // Catch: Throwable -> L26
        if (this.f16077q == true) goto L12;
        if (this.f16078r == false) goto L29;
        this.f16078r = false;     // Catch: Throwable -> L26
        Thread.interrupted();     // Catch: Throwable -> L19
    L22:
        if (this.s == true) goto L24;
    L37:
        e();
        goto L49
    L24:
        this.s = false;     // Catch: Throwable -> L26
        throw new SegmentApplyException(5, "download");     // Catch: Throwable -> L26
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        goto L22
    L29:
        if ((th instanceof BaseException) == false) goto L47;
        e = th;     // Catch: Throwable -> L26
    L36:
        if (a(r10, e) == true) goto L37;
        e();
        return false;
    L47:
        DownloadHelper.a(th, "download");     // Catch: Throwable -> L26 BaseException -> L34
        throw null;     // Catch: Throwable -> L26 BaseException -> L34
    L34:
        e = e;
        goto L36
    L12:
        e();
        return false;
    L26:
        th = move-exception;
        e();
        throw th;
    }

    public final boolean a(Segment r10, BaseException r11) {
        Logger.a("SegmentReader", this.d.l(), "handleFailedAndCheckRetry", "Exception = " + r11 + ", curRetryCount = " + this.f16084y + ", retryCount = " + this.f16083x);
        this.E = r11;
        UrlRecord r5 = this.f16070j;
        monitor-enter(r5);
        r5.f++;     // Catch: Throwable -> L67
        r5.g = true;     // Catch: Throwable -> L67
        monitor-exit(r5);     // Catch: Throwable -> L67
        SegmentDispatcher r12 = this.f16065a;
        int r13 = this.f16084y;
        int r14 = this.f16083x;
        r12.getClass();
        int r15 = r11.f15601a;
        if (r15 != 1083) goto L10;
        r12.a(r11);
        boolean r16 = false;
    L29:
        if (r16 == true) goto L31;
        return false;
    L31:
        int r17 = this.f16084y;
        if (r17 >= this.f16083x) goto L35;
        this.f16084y = r17 + 1;
        return true;
    L35:
        this.A.a(r11);
        if (this.f16085z.a(r11) == false) goto L39;
        this.f16085z.a();
        this.d.N = this.f16085z.f15597i;
        return true;
    L39:
        SparseArray r18 = DownloadHelper.f16133a;
        if (r11.f15601a != 1011) goto L42;
    L47:
        boolean r19 = true;
    L48:
        if (r19 == false) goto L62;
        String r20 = this.f16070j.f16088a;
        if (TextUtils.isEmpty(r20) == true) goto L62;
        if (r20.startsWith(IIvyAIPackageResourceService.SCHEMA) == false) goto L62;
        if (this.d.f15841v == false) goto L62;
        if (this.D == true) goto L62;
        this.D = true;
        f();
        boolean r21 = true;
    L63:
        if (r21 == false) goto L65;
        return true;
    L65:
        this.f16065a.a(this, r10, r11);
        return false;
    L62:
        r21 = false;
        goto L63
    L42:
        if (r11.getCause() != null) goto L44;
    L46:
        r19 = false;
        goto L48
    L44:
        if ((r11.getCause() instanceof SSLHandshakeException) == false) goto L46;
    L10:
        if (r15 != 1047) goto L12;
    L17:
        boolean r22 = true;
    L18:
        SparseArray r23 = DownloadHelper.f16133a;
        if ((r11 instanceof DownloadHttpException) == false) goto L25;
        int r24 = ((DownloadHttpException) r11).d;
        if (r24 != 412) goto L23;
    L24:
        r22 = true;
        goto L25
    L23:
        if (r24 == 416) goto L24;
    L25:
        if (r22 == true) goto L27;
        if (r13 >= r14) goto L27;
    L28:
        r16 = true;
    L27:
        r12.d(this);
        goto L28
    L12:
        if (r15 == 1074) goto L17;
        if (r15 == 1055) goto L17;
        r22 = false;
    L67:
        th = move-exception;
        throw th;
    }

    public final void a(Segment r25) {
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L10 BaseException -> L12
        this.I = 0;     // Catch: Throwable -> L10 BaseException -> L12
        this.H = r5;     // Catch: Throwable -> L10 BaseException -> L12
        this.f16071k = r25.b();     // Catch: Throwable -> L10 BaseException -> L12
        this.f16073m = r25.d;     // Catch: Throwable -> L10 BaseException -> L12
        if (this.f16073m > 0) goto L6;
    L14:
        this.G = new DownloadStenographer();     // Catch: Throwable -> L10 BaseException -> L12
        DownloadInfo r10 = this.d;     // Catch: Throwable -> L10 BaseException -> L12
        ArrayList r11 = DownloadHelper.a(r10.f15818i, r10.F, this.f16071k, this.f16073m);     // Catch: Throwable -> L10 BaseException -> L12
        r11.add(new HttpHeader("Segment-Index", String.valueOf(r25.e)));     // Catch: Throwable -> L10 BaseException -> L12
        r11.add(new HttpHeader("Thread-Index", String.valueOf(this.f16080u)));     // Catch: Throwable -> L10 BaseException -> L12
        r11.add(new HttpHeader("extra_download_id", String.valueOf(this.d.l())));     // Catch: Throwable -> L10 BaseException -> L12
        DownloadHelper.a(this.e, r11, this.d);     // Catch: Throwable -> L10 BaseException -> L12
        this.A.a(r11);     // Catch: Throwable -> L10 BaseException -> L12
        String r12 = this.f16070j.f16088a;     // Catch: Throwable -> L10 BaseException -> L12
        if (this.D == true) goto L17;
    L21:
        String r13 = this.f16070j.f16089b;     // Catch: Throwable -> L10 BaseException -> L12
        if (Logger.b() == false) goto L24;
        Logger.a("SegmentReader", this.d.l(), null, "createConnection", "Url = " + r12 + ", ip = " + r13 + ", segment = " + r25 + ", threadIndex = " + this.f16080u, false);     // Catch: Throwable -> L10 BaseException -> L12
    L24:
        this.L = r12;     // Catch: Throwable -> L10 BaseException -> L12
        this.M = r13;     // Catch: Throwable -> L10 BaseException -> L12
        DownloadInfo r14 = this.d;     // Catch: Throwable -> L10 BaseException -> L12
        boolean r15 = r14.E;     // Catch: Throwable -> L10 BaseException -> L12
        int r16 = r14.f15819j;     // Catch: Throwable -> L10 BaseException -> L12
        if ((r5 - this.B) > WsConstants.EXIT_DELAY_TIME) goto L27;
    L29:
        boolean r22 = false;
    L30:
        DownloadInfo r17 = this.d;     // Catch: Throwable -> L10 BaseException -> L12
        Context r18 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L10 BaseException -> L12
        IDownloadHttpConnection r19 = ((IDownloadNetworkService) DownloadServiceManager.a(IDownloadNetworkService.class)).a(r15, r16, r12, r13, r11, 0, r22, r17);     // Catch: Throwable -> L10 BaseException -> L12
        if (r19 == null) goto L64;
        this.f = r19;     // Catch: Throwable -> L10 BaseException -> L12
        this.g = new HttpResponse(r12, r19);     // Catch: Throwable -> L10 BaseException -> L12
        if (this.f16077q == true) goto L62;
        this.N = "";     // Catch: Throwable -> L10 BaseException -> L12
        if (Logger.b() == false) goto L37;
        Logger.a("SegmentReader", this.d.l(), null, "createConnection", "Url = " + r12 + ", ip = " + r13 + ", hostRealIp = " + this.N + ", threadIndex = " + this.f16080u, false);     // Catch: Throwable -> L10 BaseException -> L12
    L37:
        this.I = System.currentTimeMillis();
        this.f16067c.getClass();
        SegmentDispatcher r20 = this.f16065a;
        UrlRecord r21 = this.f16070j;
        HttpResponse r23 = this.g;
        monitor-enter(r20);
    L48:
        th = move-exception;
        throw th;
    L40:
        if (r20.g == true) goto L58;
        if (r20.f16041h == true) goto L58;
        r20.a(this, r25, r21, r23);     // Catch: Throwable -> L48
        this.F = false;     // Catch: Throwable -> L48
        if (r20.f16047n > 0) goto L52;
        long r24 = r20.f16038a.f15817h0;     // Catch: Throwable -> L48
        r20.f16047n = r24;     // Catch: Throwable -> L48
        if (r24 > 0) goto L50;
        r20.f16047n = r23.c();     // Catch: Throwable -> L48
    L50:
        r20.c();     // Catch: Throwable -> L48
    L54:
        monitor-exit(r20);     // Catch: Throwable -> L48
        this.f16070j.c();
        return;
    L52:
        if (r20.f16040c.f16086a.optInt("segment_mode", 1) != 0) goto L54;
        r20.c();     // Catch: Throwable -> L48
    L58:
        throw new StreamClosedException("connected");     // Catch: Throwable -> L48
    L62:
        throw new StreamClosedException("createConn");     // Catch: Throwable -> L10 BaseException -> L12
    L64:
        throw new BaseException(1022, DownloadUtils.a(new IOException("download can't continue, chunk connection is null")));     // Catch: Throwable -> L10 BaseException -> L12
    L27:
        if (this.e.a("monitor_download_connect", 0) <= 0) goto L29;
        r22 = true;
        goto L30
    L17:
        if (TextUtils.isEmpty(r12) == true) goto L21;
        if (r12.startsWith(IIvyAIPackageResourceService.SCHEMA) == false) goto L21;
        r12 = r12.replaceFirst(IIvyAIPackageResourceService.SCHEMA, "http");     // Catch: Throwable -> L10 BaseException -> L12
        goto L21
    L6:
        if (this.f16071k <= this.f16073m) goto L14;
        throw new SegmentApplyException(6, "createConn, " + r25);     // Catch: Throwable -> L10 BaseException -> L12
    L67:
        th = move-exception;
        this.I = System.currentTimeMillis();
        this.f16067c.getClass();
        throw th;
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L67
    L10:
        th = move-exception;
        DownloadHelper.a(th, "createConn");     // Catch: Throwable -> L67
        throw null;     // Catch: Throwable -> L67
    }

    public static Buffer a(IBufferPool r5, InputStream r10) {
        BufferQueue r11 = (BufferQueue) r5;
        Buffer r12 = r11.b();
        int r13 = r10.read(r12.f16006a);     // Catch: Throwable -> L13
        if (r13 == (-1)) goto L12;
        r12.f16008c = r13;     // Catch: Throwable -> L9
        if (r13 != (-1)) goto L8;
        r11.a(r12);
    L8:
        return r12;
    L12:
        throw new BaseException(1073, "probe");     // Catch: Throwable -> L9
    L9:
        th = th;
    L15:
        if (r13 != (-1)) goto L17;
        r11.a(r12);
    L17:
        throw th;
    L13:
        th = th;
        r13 = -1;
        goto L15
    }

    public final long c() {
        SegmentDispatcher r5 = this.f16065a;
        monitor-enter(r5);
        long r10 = this.f16075o + d();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a() {
        if (Logger.b() == false) goto L5;
        Logger.a("SegmentReader", this.d.l(), null, "close", "ThreadIndex: " + this.f16080u, false);
    L5:
        monitor-enter(this);
        this.f16077q = true;     // Catch: Throwable -> L17
        this.f16081v = true;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        b();
        Future r5 = this.f16076p;
        if (r5 == null) goto L24;
        this.f16076p = null;
        r5.cancel(true);     // Catch: Throwable -> L14
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

    public final void a(boolean r10) {
        if (Logger.b() == false) goto L5;
        Logger.a("SegmentReader", this.d.l(), null, "reconnect", "ThreadIndex: " + this.f16080u, false);
    L5:
        monitor-enter(this);
        this.s = r10;     // Catch: Throwable -> L15
        this.f16078r = true;     // Catch: Throwable -> L15
        this.f16081v = true;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        b();
        Thread r11 = this.f16079t;
        if (r11 == null) goto L23;
        if (Logger.b() == false) goto L13;
        Logger.a("SegmentReader", this.d.l(), null, "reconnect", "Interrupt ThreadIndex: " + this.f16080u, false);     // Catch: Throwable -> L18
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
}
