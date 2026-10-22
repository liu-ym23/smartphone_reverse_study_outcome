package sb;

import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.g;
import ib.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f12779c = "DownloadThreadPool";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Integer, bb.c> f12780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f12781b;

    static {
    }

    public b() {
        this.f12780a = new ConcurrentHashMap();
        this.f12781b = new AtomicInteger(0);
    }

    private boolean a(DownloadInfo r10, bb.c r11) {
        long r12 = 0;
        if (r10.getExpectFileLength() > 0) goto L5;
        return false;
    L5:
        JSONObject r13 = rb.a.g(r10.getId()).q("segment_config");
        if (r13 == null) goto L9;
        r12 = r13.optLong("expect_min_download_size");
    L9:
        if (r12 >= 104857600) goto L12;
        return false;
    L12:
        if (r10.getExpectFileLength() <= r12) goto L15;
        return true;
    L15:
        r11.k(false);
        return false;
    }

    private void c() {
        Iterator<Map.Entry<Integer, bb.c>> r10 = this.f12780a.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r10.next().getValue().f() == true) goto L4;
        r10.remove();
        goto L4
    }

    private ExecutorService g(bb.c r10) {
        ExecutorService r11 = null;
        DownloadInfo r12 = r10.d().y();     // Catch: Throwable -> L27 Exception -> L29
        if (r12.isFastDownload() == false) goto L6;
        r11 = com.ss.android.socialbase.downloader.downloader.a.E();     // Catch: Throwable -> L27 Exception -> L29
    L6:
        if (r11 != null) goto L17;
        int r13 = r12.getExecutorGroup();     // Catch: Throwable -> L27 Exception -> L29
        if (r13 != 3) goto L10;
        r11 = com.ss.android.socialbase.downloader.downloader.a.M();     // Catch: Throwable -> L27 Exception -> L29
        goto L17
    L10:
        if (r13 != 4) goto L12;
        r11 = com.ss.android.socialbase.downloader.downloader.a.K();     // Catch: Throwable -> L27 Exception -> L29
        goto L17
    L12:
        if (r13 != 7) goto L17;
        r11 = com.ss.android.socialbase.downloader.downloader.a.k();     // Catch: Throwable -> L27 Exception -> L29
    L17:
        if (r11 == null) goto L19;
    L21:
        if (r11 == null) goto L23;
    L25:
        if (r11 == null) goto L33;
        return r11;
    L33:
        return com.ss.android.socialbase.downloader.downloader.a.L();
    L23:
        if (k.j(r12) == false) goto L25;
        r11 = k.f().g();     // Catch: Throwable -> L27 Exception -> L29
    L19:
        if (a(r12, r10) == false) goto L21;
        r11 = com.ss.android.socialbase.downloader.downloader.a.S();     // Catch: Throwable -> L27 Exception -> L29
    L27:
        th = move-exception;
        if (0 != 0) goto L36;
        com.ss.android.socialbase.downloader.downloader.a.L();
    L36:
        throw th;
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        if (0 == 0) goto L33;
        return null;
    }

    private void i(bb.c r10) {
        if (r10 != null) goto L13;
        return;
    L13:
        ExecutorService r11 = g(r10);     // Catch: Exception -> L10
        if ((r11 instanceof ThreadPoolExecutor) == false) goto L15;
        ((ThreadPoolExecutor) r11).remove(r10);     // Catch: Exception -> L10
        Future r12 = r10.e();     // Catch: Exception -> L10
        if (r12 == null) goto L16;
        r12.cancel(true);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public bb.c b(int r10) {
        c();
        bb.c r11 = this.f12780a.remove(Integer.valueOf(r10));
        if (r11 == null) goto L5;
        r11.b();
        i(r11);
    L5:
        return r11;
    }

    public boolean d(int r10) {
        bb.c r11 = this.f12780a.get(Integer.valueOf(r10));
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.f() == false) goto L7;
        return true;
    }

    public void e(bb.c r10) {
        r10.h();
        int r11 = 0;
        if (this.f12781b.compareAndSet(500, 0) == false) goto L5;
        c();
    L5:
        this.f12781b.incrementAndGet();
        this.f12780a.put(Integer.valueOf(r10.c()), r10);
        com.ss.android.socialbase.downloader.model.d r12 = r10.d();
        r12.M().f8185e = System.currentTimeMillis();     // Catch: Exception -> L11
        ExecutorService r13 = g(r10);     // Catch: Exception -> L11
        if (lb.a.a() == false) goto L9;
        lb.a.g(f12779c, r10.c(), "execute", "Executor:" + r13);     // Catch: Exception -> L11
    L9:
        r10.l(r13.submit(r10));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        lb.a.h(f12779c, r10.c(), "execute", "Error:" + e);
        if (r12 == null) goto L18;
        b0 r14 = r12.G();
        DownloadInfo r15 = r12.y();
        BaseException r16 = new BaseException(PointerIconCompat.TYPE_HELP, g.w(e, "DownloadThreadPoolExecute"));
        if (r12.y() == null) goto L17;
        r11 = r12.y().getStatus();
    L17:
        mb.a.n(r14, r15, r16, r11);
    L18:
        e.printStackTrace();
    }

    public List<Integer> f() {
        c();
        return new ArrayList(this.f12780a.keySet());
    }

    public void h(int r10) {
        c();
        bb.c r11 = this.f12780a.remove(Integer.valueOf(r10));
        if (r11 == null) goto L6;
        r11.g();
        i(r11);
        return;
    }

    public void j(bb.c r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, bb.c>> r11 = this.f12780a.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L14;
        if (r11.next().getValue() != r10) goto L6;
        r11.remove();
        return;
    }

    public void k(int r10, boolean r11) {
        bb.c r12 = this.f12780a.get(Integer.valueOf(r10));
        if (r12 == null) goto L6;
        r12.j(r11);
        return;
    }

    public void l(int r10, long r11, int r12) {
        bb.c r13 = this.f12780a.get(Integer.valueOf(r10));
        if (r13 == null) goto L6;
        r13.m(r11, r12);
        return;
    }
}
