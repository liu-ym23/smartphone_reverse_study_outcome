package gb;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends cb.a implements f.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f9020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f9021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f9024p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<f> f9025q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private e f9026r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private d f9027s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private b f9028t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private i f9029u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private nb.h f9030v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private g f9031w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Throwable f9032x;

    public a() {
        this.f9025q = new CopyOnWriteArrayList();
    }

    private void A() {
        this.f9031w = new g(this.f544h.getPcdnUrls(), this.f544h.getCdnUrls());
        h r10 = new h(this.f9022n);
        String r11 = null;
    L4:
        if (m() == true) goto L38;
        r11 = this.f9031w.c();     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        if (lb.a.a() == false) goto L8;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "getTotalSize", "Before Url:" + r11 + " isPcdn:" + this.f9031w.b());     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
    L8:
        nb.h r12 = t(r11, n(this.f544h.getStartOffset(), this.f544h.getEndOffset(), false), this.f544h.getStartOffset());     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        this.f9030v = r12;     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        q(r11, 0, r12);     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
    L9:
        nb.h r13 = this.f9030v;
        if (r13 == null) goto L13;
        r13.a();
    L13:
        if (lb.a.a() == false) goto L50;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "getTotalSize", "After Url:" + r11 + " isPcdn:" + this.f9031w.b());
        return;
    L50:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        if (r10.a(true) == false) goto L28;
        this.f9031w.d();     // Catch: Throwable -> L16
        nb.h r14 = this.f9030v;
        if (r14 == null) goto L26;
        r14.a();
    L26:
        if (lb.a.a() == false) goto L4;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "getTotalSize", "After Url:" + r11 + " isPcdn:" + this.f9031w.b());
        goto L4
    L28:
        throw e;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        nb.h r15 = this.f9030v;
        if (r15 == null) goto L35;
        r15.a();
    L35:
        if (lb.a.a() == false) goto L37;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "getTotalSize", "After Url:" + r11 + " isPcdn:" + this.f9031w.b());
    L37:
        throw th;
    L29:
        e = move-exception;
        throw e;     // Catch: Throwable -> L16
    }

    private void B() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), CommonConsts.APM_INNER_EVENT_COST_INIT, "Run");
    L5:
        cb.h r10 = this.f547k;
        this.f9026r = new e(this, r10.f676a, r10.f678c);
        this.f9027s = new d(this.f547k.f678c, this.f9020l);
        this.f9028t = new b(this.f547k.f678c.getId(), this.f9023o, this.f9024p);
        if (this.f9029u != null) goto L8;
        this.f9029u = new i(this.f544h, this.f9022n);
    L8:
        this.f9025q.clear();
        this.f9032x = null;
    }

    private void C(JSONObject r10) {
        this.f9020l = r10.optLong("max_chunk_length");
        this.f9021m = r10.optInt("thread_count");
        this.f9022n = r10.optInt("chunk_retry_count");
        this.f9023o = r10.optLong("pcdn_degrade_bandwidth_limit");
        int r11 = r10.optInt("pcdn_degrade_sample_count");
        this.f9024p = r11;
        if (this.f9020l > 0) goto L6;
        this.f9020l = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
    L6:
        if (this.f9021m > 0) goto L9;
        this.f9021m = 3;
    L9:
        if (this.f9021m <= 6) goto L12;
        this.f9021m = 6;
    L12:
        if (this.f9022n <= 20) goto L14;
        this.f9022n = 20;
    L14:
        if (r11 >= 3) goto L17;
        this.f9024p = 3;
        return;
    }

    private void y() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "checkTotalSize", "Run");
    L5:
        long r10 = this.f544h.getTotalBytes();
        if (r10 > 0) goto L8;
    L9:
        A();
        r10 = this.f544h.getTotalBytes();
    L11:
        if (r10 <= 0) goto L17;
        a(r10, this.f544h.getMaxBytes());
        if (lb.a.a() == false) goto L18;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "checkTotalSize", "TotalSize: " + r10);
        return;
    L18:
        return;
    L17:
        throw new BaseException(1090, "pcdn content-length empty");
    L8:
        if (this.f547k.f685j == false) goto L11;
        goto L9
    }

    private void z() {
        long r10 = com.ss.android.socialbase.downloader.utils.c.p(this.f544h) + this.f544h.getStartOffset();
        int r11 = (int) Math.ceil(((this.f544h.getTotalBytes() - r10) * 1.0d) / this.f9020l);
        int r12 = this.f9021m;
        if (r11 >= r12) goto L6;
        r12 = r11;
    L6:
        if (lb.a.a() == false) goto L8;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "doDownload", "StartOffset:" + r10 + " chunkCount:" + r11 + " threadCount:" + r12);
    L8:
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        f r14 = new f(this.f9026r, this.f9027s, this.f9028t, this.f9029u, this.f9031w, this.f9022n, this);
        r14.e(this.f547k);
        r14.E(com.ss.android.socialbase.downloader.downloader.a.j().submit(r14));
        this.f9025q.add(r14);
        r13 = r13 + 1;
        goto L9
    L11:
        Iterator<f> r15 = this.f9025q.iterator();
    L13:
        if (r15.hasNext() == false) goto L20;
        r15.next().C().get();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L13
    L20:
        if (lb.a.a() == false) goto L22;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "doDownload", "ChunkRunnable End");
    L22:
        this.f9028t.f();
        this.f9029u.g();
        if (m() == false) goto L25;
        return;
    L25:
        Throwable r16 = this.f9032x;
        if (r16 != null) goto L28;
        return;
    L28:
        if ((r16 instanceof BaseException) == false) goto L32;
        throw ((BaseException) r16);
    L32:
        throw new BaseException(1000, this.f9032x);
    }

    @Override // bb.a, bb.e
    public void cancel() {
        o(this.f9030v);
        Iterator<f> r10 = this.f9025q.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().cancel();
        goto L4
    }

    @Override // bb.a, bb.e
    public bb.e e(cb.h r10) {
        JSONObject r11 = r10.f679d.q("pcdn_config");
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r10.f678c.getPcdnUrls() == null) goto L9;
        if (r10.f678c.getPcdnUrls().isEmpty() == true) goto L9;
    L13:
        C(r11);
        return super.e(r10);
    L9:
        if (r10.f678c.getCdnUrls() != null) goto L11;
        return null;
    L11:
        if (r10.f678c.getCdnUrls().isEmpty() == false) goto L13;
        return null;
    }

    @Override // bb.a, bb.e
    public void f() {
        o(this.f9030v);
        Iterator<f> r10 = this.f9025q.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().f();
        goto L4
    }

    @Override // cb.a, bb.e
    public void k(bb.f r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.g("DownloadPCDNSegmentModule", this.f544h.getId(), "proceed", "Run");
    L6:
        if (r(r10, true) == false) goto L22;
        return;
    L22:
        y();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        if (m() == false) goto L11;
        return;
    L11:
        B();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        z();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        r10.b();
        return;
    L20:
        e = move-exception;
        throw e;
    L17:
        e = move-exception;
        throw new DownloadPCDNException(e.getErrorCode(), e.getErrorMessage());
    L14:
        th = move-exception;
        throw new DownloadPCDNException(1000, th.getMessage());
    }

    @Override // gb.f.a
    public void onError(Throwable r10) {
        this.f9032x = r10;
        cancel();
    }
}
