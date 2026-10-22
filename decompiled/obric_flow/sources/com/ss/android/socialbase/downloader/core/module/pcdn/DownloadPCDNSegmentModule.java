package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.util.SparseArray;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.lynx.tasm.utils.e;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadPCDNSegmentModule extends BaseDownloadNetworkModule {
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f15330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15331k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArrayList f15332l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PCDNChunkProgressManager f15333m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PCDNChunkAllocater f15334n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PCDNBandwidthSampler f15335o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PCDNStats f15336p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IDownloadHttpConnection f15337q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PCDNChunkUrlPolicy f15338r;
    public Throwable s;

    public DownloadPCDNSegmentModule() {
        this.f15332l = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r10) {
        JSONObject r5 = r10.d.d("pcdn_config");
        if (r5 == null) goto L29;
        ArrayList r11 = r10.f15310c.f15845x;
        if (r11 != null) goto L7;
    L8:
        ArrayList r12 = r10.f15310c.f15847y;
        if (r12 != null) goto L11;
        return null;
    L11:
        if (r12.isEmpty() == true) goto L32;
    L13:
        this.g = r5.optLong("max_chunk_length");
        this.f15328h = r5.optInt("thread_count");
        this.f15329i = r5.optInt("chunk_retry_count");
        this.f15330j = r5.optLong("pcdn_degrade_bandwidth_limit");
        int r13 = r5.optInt("pcdn_degrade_sample_count");
        this.f15331k = r13;
        if (this.g > 0) goto L17;
        this.g = 2097152;
    L17:
        if (this.f15328h > 0) goto L20;
        this.f15328h = 3;
    L20:
        if (this.f15328h <= 6) goto L23;
        this.f15328h = 6;
    L23:
        if (this.f15329i <= 20) goto L25;
        this.f15329i = 20;
    L25:
        if (r13 >= 3) goto L28;
        this.f15331k = 3;
    L28:
        return super.a(r10);
    L32:
        return null;
    L7:
        if (r11.isEmpty() == false) goto L13;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void cancel() {
        BaseDownloadNetworkModule.a(this.f15337q);
        Iterator r5 = this.f15332l.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((PCDNChunkRunnableModule) r5.next()).cancel();
        goto L4
    }

    public final void d() {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadPCDNSegmentModule", this.f15290c, "checkTotalSize", "Run");
    L5:
        DownloadInfo r5 = this.f15290c;
        long r10 = r5.f15817h0;
        if (r10 > 0) goto L8;
    L11:
        this.f15338r = new PCDNChunkUrlPolicy(r5.f15845x, r5.f15847y);
        PCDNRetryPolicy r11 = new PCDNRetryPolicy(this.f15329i);
        String r12 = null;
    L13:
        if (b() == true) goto L72;
        String r13 = this.f15338r.b();     // Catch: Throwable -> L47 BaseException -> L49 DownloadFileExistException -> L51
    L86:
    L45:
        e = e;
        String r14 = r13;
    L95:
        throw e;     // Catch: Throwable -> L47
    L43:
        e = e;
        r14 = r13;
    L38:
        r12 = r14;
    L81:
        e.printStackTrace();     // Catch: Throwable -> L47
        int r15 = r11.f15370a;     // Catch: Throwable -> L47
        if (r15 >= r11.f15371b) goto L63;
        r11.f15370a = r15 + 1;     // Catch: Throwable -> L47
        this.f15338r.c();     // Catch: Throwable -> L47
        IDownloadHttpConnection r16 = this.f15337q;
        if (r16 == null) goto L60;
        r16.c();
    L60:
        if (Logger.a(this.f15290c) == false) goto L62;
        DownloadInfo r17 = this.f15290c;
        StringBuilder r18 = e.b("After Url:", r12, " isPcdn:");
        r18.append(this.f15338r.a());
        Logger.a("DownloadPCDNSegmentModule", r17, "getTotalSize", r18.toString());
    L62:
        r11 = r11;
        goto L13
    L63:
        throw e;     // Catch: Throwable -> L47
    L47:
        Throwable th2 = th;
    L65:
        IDownloadHttpConnection r19 = this.f15337q;
        if (r19 == null) goto L69;
        r19.c();
    L69:
        if (Logger.a(this.f15290c) == false) goto L71;
        DownloadInfo r20 = this.f15290c;
        StringBuilder r21 = e.b("After Url:", r12, " isPcdn:");
        r21.append(this.f15338r.a());
        Logger.a("DownloadPCDNSegmentModule", r20, "getTotalSize", r21.toString());
    L71:
        throw th2;
    L41:
        th2 = th;
        r14 = r13;
    L36:
        r12 = r14;
        goto L65
    L16:
        if (Logger.a(this.f15290c) == true) goto L84;
    L26:
        DownloadInfo r22 = this.f15290c;     // Catch: Throwable -> L41 BaseException -> L43 DownloadFileExistException -> L45
        r22.d();     // Catch: Throwable -> L41 BaseException -> L43 DownloadFileExistException -> L45
        r14 = r13;
        ArrayList r23 = a(r22.T0.optLong("start_offset"), this.f15290c.k(), false);     // Catch: Throwable -> L35 BaseException -> L37 DownloadFileExistException -> L39
        DownloadInfo r24 = this.f15290c;     // Catch: Throwable -> L35 BaseException -> L37 DownloadFileExistException -> L39
        r24.d();     // Catch: Throwable -> L35 BaseException -> L37 DownloadFileExistException -> L39
        IDownloadHttpConnection r25 = a(r14, r23, r24.T0.optLong("start_offset"));     // Catch: Throwable -> L35 BaseException -> L37 DownloadFileExistException -> L39
        this.f15337q = r25;     // Catch: Throwable -> L35 BaseException -> L37 DownloadFileExistException -> L39
        a(r14, 0, r25);     // Catch: Throwable -> L35 BaseException -> L37 DownloadFileExistException -> L39
    L29:
        IDownloadHttpConnection r26 = this.f15337q;
        if (r26 == null) goto L33;
        r26.c();
    L33:
        if (Logger.a(this.f15290c) == false) goto L72;
        DownloadInfo r27 = this.f15290c;
        StringBuilder r28 = e.b("After Url:", r14, " isPcdn:");
        r28.append(this.f15338r.a());
        Logger.a("DownloadPCDNSegmentModule", r27, "getTotalSize", r28.toString());
    L39:
        e = e;
    L37:
        e = e;
    L35:
        th2 = th;
        goto L36
    L84:
        Logger.a("DownloadPCDNSegmentModule", this.f15290c, "getTotalSize", "Before Url:" + r13 + " isPcdn:" + this.f15338r.a());     // Catch: Throwable -> L19 BaseException -> L21 DownloadFileExistException -> L24
    L24:
        e = move-exception;
        throw e;     // Catch: Throwable -> L47
    L21:
        e = e;
        r12 = r13;
    L23:
        r11 = r11;
    L19:
        th2 = th;
        r12 = r13;
    L51:
        e = move-exception;
        throw e;     // Catch: Throwable -> L47
    L49:
        e = e;
    L72:
        r10 = this.f15290c.f15817h0;
        long r29 = 0;
    L74:
        if (r10 <= r29) goto L80;
        b(r10, this.f15290c.f15819j);
        if (Logger.a(this.f15290c) == false) goto L97;
        Logger.a("DownloadPCDNSegmentModule", this.f15290c, "checkTotalSize", a.j(r10, "TotalSize: "));
        return;
    L97:
        return;
    L80:
        throw new BaseException(1090, "pcdn content-length empty");
    L8:
        if (this.f.f15313j == true) goto L11;
        r29 = 0;
        goto L74
    }

    public final void e() {
        DownloadInfo r5 = this.f15290c;
        SparseArray r10 = DownloadHelper.f16133a;
        if (r5 != null) goto L5;
        long r11 = -1;
    L6:
        DownloadInfo r12 = this.f15290c;
        r12.d();
        long r13 = r12.T0.optLong("start_offset") + r11;
        int r14 = (int) Math.ceil(((this.f15290c.f15817h0 - r13) * 1.0d) / this.g);
        int r15 = this.f15328h;
        if (r14 >= r15) goto L10;
        r15 = r14;
    L10:
        if (Logger.a(this.f15290c) == false) goto L12;
        Logger.a("DownloadPCDNSegmentModule", this.f15290c, "doDownload", "StartOffset:" + r13 + " chunkCount:" + r14 + " threadCount:" + r15);
    L12:
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L15;
        PCDNChunkRunnableModule r17 = new PCDNChunkRunnableModule(this.f15333m, this.f15334n, this.f15335o, this.f15336p, this.f15338r, this.f15329i, this);
        r17.a(this.f);
        r17.g = DownloadComponentManager.d().submit(r17);
        this.f15332l.add(r17);
        r16 = r16 + 1;
        goto L13
    L15:
        Iterator r18 = this.f15332l.iterator();
    L17:
        if (r18.hasNext() == false) goto L24;
        ((PCDNChunkRunnableModule) r18.next()).g.get();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L24:
        if (Logger.a(this.f15290c) == false) goto L26;
        Logger.a("DownloadPCDNSegmentModule", this.f15290c, "doDownload", "ChunkRunnable End");
    L26:
        PCDNBandwidthSampler r19 = this.f15335o;
        r19.f15339a = false;
        DeviceBandwidthSampler.b().f15945a.remove(r19);
        PCDNStats r20 = this.f15336p;
        monitor-enter(r20);
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L32
        r21.put("bus_id", r20.f15372a.P);     // Catch: Throwable -> L32
        r21.put("pcdn_size", r20.f15373b);     // Catch: Throwable -> L32
        r21.put("pcdn_dur", r20.d);     // Catch: Throwable -> L32
        r21.put("cdn_size", r20.f15374c);     // Catch: Throwable -> L32
        r21.put("cdn_dur", r20.e);     // Catch: Throwable -> L32
        r21.put("retry_times_max", r20.f);     // Catch: Throwable -> L32
        JSONArray r22 = new JSONArray();     // Catch: Throwable -> L32
        Iterator r23 = r20.g.entrySet().iterator();     // Catch: Throwable -> L32
    L30:
        if (r23.hasNext() == false) goto L34;
        Map.Entry r24 = (Map.Entry) r23.next();     // Catch: Throwable -> L32
        JSONObject r25 = new JSONObject();     // Catch: Throwable -> L32
        r25.put("url", r24.getKey());     // Catch: Throwable -> L32
        PCDNStats.UrlStats r26 = (PCDNStats.UrlStats) r24.getValue();     // Catch: Throwable -> L32
        r25.put("is_pcdn", r26.f15379a);     // Catch: Throwable -> L32
        r25.put("code", r26.f15380b);     // Catch: Throwable -> L32
        r25.put("size", r26.d);     // Catch: Throwable -> L32
        r25.put("duration", r26.e);     // Catch: Throwable -> L32
        r25.put("protocol", r26.f);     // Catch: Throwable -> L32
        r25.put(ICronetClient.KEY_TTFB, 0);     // Catch: Throwable -> L32
        r25.put(NotificationCompat.CATEGORY_ERROR, r26.f15381c);     // Catch: Throwable -> L32
        r22.put(r25);     // Catch: Throwable -> L32
        goto L30
    L34:
        r21.put("urls", r22);     // Catch: Throwable -> L32
        r20.f15372a.R0 = r21;     // Catch: Throwable -> L32
    L37:
        monitor-exit(r20);     // Catch: Throwable -> L50
        if (b() == true) goto L64;
        Throwable r27 = this.s;
        if (r27 != null) goto L44;
        return;
    L44:
        if ((r27 instanceof BaseException) == false) goto L48;
        throw ((BaseException) r27);
    L48:
        throw new BaseException(1000, DownloadUtils.a(this.s));
    L64:
        return;
    L32:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    L5:
        r11 = r5.i();
        goto L6
    }

    public final void f() {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadPCDNSegmentModule", this.f15290c, "init", "Run");
    L5:
        DownloadCommonParams r5 = this.f;
        this.f15333m = new PCDNChunkProgressManager(this, r5.f15308a, r5.f15310c);
        this.f15334n = new PCDNChunkAllocater(this.f.f15310c, this.g);
        this.f15335o = new PCDNBandwidthSampler(this.f.f15310c.l(), this.f15330j, this.f15331k);
        if (this.f15336p != null) goto L8;
        this.f15336p = new PCDNStats(this.f15290c, this.f15329i);
    L8:
        this.f15332l.clear();
        this.s = null;
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("DownloadPCDNSegmentModule", this.f15290c, "proceed", "Run");
    L5:
        DownloadCommonParams r10 = this.f;
        if (r10.f15312i == false) goto L9;
        r5.c();
        return;
    L9:
        r10.f15312i = true;
        d();     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L20
        if (b() == false) goto L13;
        return;
    L13:
        f();     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L20
        e();     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L20
        r5.c();
        return;
    L20:
        e = move-exception;
        throw e;
    L18:
        e = move-exception;
        throw new DownloadPCDNException(e.f15601a, e.f15602b);
    L16:
        th = move-exception;
        throw new DownloadPCDNException(1000, th.getMessage());
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a() {
        BaseDownloadNetworkModule.a(this.f15337q);
        Iterator r5 = this.f15332l.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((PCDNChunkRunnableModule) r5.next()).a();
        goto L4
    }
}
