package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f15449a = "DownloadThreadPool";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, com.ss.android.socialbase.downloader.b.c> f15450b;
    private AtomicInteger c;

    static {
    }

    public b() {
        this.f15450b = new ConcurrentHashMap();
        this.c = new AtomicInteger(0);
    }

    private boolean a(DownloadInfo r7, com.ss.android.socialbase.downloader.b.c r8) {
        long r2 = 0;
        if (r7.getExpectFileLength() > 0) goto L5;
        return false;
    L5:
        JSONObject r6 = com.ss.android.socialbase.downloader.g.a.a(r7.getId()).e("segment_config");
        if (r6 == null) goto L9;
        r2 = r6.optLong("expect_min_download_size");
    L9:
        if (r2 >= 104857600) goto L12;
        return false;
    L12:
        if (r7.getExpectFileLength() <= r2) goto L15;
        return true;
    L15:
        r8.a(false);
        return false;
    }

    private void b() {
        Iterator<Map.Entry<Integer, com.ss.android.socialbase.downloader.b.c>> r3 = this.f15450b.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        if (((com.ss.android.socialbase.downloader.b.c) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), com.ss.android.socialbase.downloader.b.c.class, "com.obric.memorydata.plugin")).d() == true) goto L4;
        r3.remove();
        goto L4
    }

    private void c(com.ss.android.socialbase.downloader.b.c r3) {
        if (r3 != null) goto L13;
        return;
    L13:
        ExecutorService r2 = d(r3);     // Catch: Exception -> L10
        if (ZeusTransformUtils.instanceOf(r2, ThreadPoolExecutor.class) == false) goto L15;
        ((ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(r2, ThreadPoolExecutor.class, "com.obric.memorydata.plugin")).remove(r3);     // Catch: Exception -> L10
        Future r4 = r3.h();     // Catch: Exception -> L10
        if (r4 == null) goto L16;
        r4.cancel(true);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    private ExecutorService d(com.ss.android.socialbase.downloader.b.c r5) {
        ExecutorService r0 = null;
        DownloadInfo r1 = r5.c().getDownloadInfo();     // Catch: Throwable -> L27 Exception -> L29
        if (r1.isFastDownload() == false) goto L6;
        r0 = com.ss.android.socialbase.downloader.downloader.b.y();     // Catch: Throwable -> L27 Exception -> L29
    L6:
        if (r0 != null) goto L17;
        int r2 = r1.getExecutorGroup();     // Catch: Throwable -> L27 Exception -> L29
        if (r2 != 3) goto L10;
        r0 = com.ss.android.socialbase.downloader.downloader.b.k();     // Catch: Throwable -> L27 Exception -> L29
        goto L17
    L10:
        if (r2 != 4) goto L12;
        r0 = com.ss.android.socialbase.downloader.downloader.b.l();     // Catch: Throwable -> L27 Exception -> L29
        goto L17
    L12:
        if (r2 != 7) goto L17;
        r0 = com.ss.android.socialbase.downloader.downloader.b.u();     // Catch: Throwable -> L27 Exception -> L29
    L17:
        if (r0 == null) goto L19;
    L21:
        if (r0 == null) goto L23;
    L25:
        if (r0 == null) goto L33;
        return r0;
    L33:
        return com.ss.android.socialbase.downloader.downloader.b.m();
    L23:
        if (l.a(r1) == false) goto L25;
        r0 = l.a().b();     // Catch: Throwable -> L27 Exception -> L29
    L19:
        if (a(r1, r5) == false) goto L21;
        r0 = com.ss.android.socialbase.downloader.downloader.b.p();     // Catch: Throwable -> L27 Exception -> L29
    L27:
        th = move-exception;
        if (0 != 0) goto L36;
        com.ss.android.socialbase.downloader.downloader.b.m();
    L36:
        throw th;
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        if (0 == 0) goto L33;
        return null;
    }

    public List<Integer> a() {
        b();
        return new ArrayList(this.f15450b.keySet());
    }

    public Future a(com.ss.android.socialbase.downloader.b.c r8) {
        r8.g();
        int r3 = 0;
        if (this.c.compareAndSet(500, 0) == false) goto L5;
        b();
    L5:
        this.c.incrementAndGet();
        this.f15450b.put(Integer.valueOf(r8.e()), r8);
        DownloadTask r1 = r8.c();
        r1.getTimingInfo().e = System.currentTimeMillis();     // Catch: Exception -> L11
        ExecutorService r7 = d(r8);     // Catch: Exception -> L11
        if (com.ss.android.socialbase.downloader.e.a.a(r8.f()) == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a(f15449a, r8.f(), "execute", "Executor:" + r7);     // Catch: Exception -> L11
    L9:
        Future<?> r9 = r7.submit(r8);     // Catch: Exception -> L11
        r8.a(r9);     // Catch: Exception -> L11
        return r9;
    L11:
        e = move-exception;
        com.ss.android.socialbase.downloader.e.a.b(f15449a, r8.e(), "execute", "Error:" + e);
        if (r1 == null) goto L18;
        IDownloadMonitorDepend r10 = r1.getMonitorDepend();
        DownloadInfo r0 = r1.getDownloadInfo();
        BaseException r2 = new BaseException(1003, g.a(e, "DownloadThreadPoolExecute"));
        if (r1.getDownloadInfo() == null) goto L17;
        r3 = r1.getDownloadInfo().getStatus();
    L17:
        com.ss.android.socialbase.downloader.f.a.a(r10, r0, r2, r3);
    L18:
        e.printStackTrace();
        return null;
    }

    public void a(int r2, long r3, int r5) {
        com.ss.android.socialbase.downloader.b.c r1 = (com.ss.android.socialbase.downloader.b.c) ZeusTransformUtils.preCheckCast(this.f15450b.get(Integer.valueOf(r2)), com.ss.android.socialbase.downloader.b.c.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.a(r3, r5);
        return;
    }

    public boolean a(int r2) {
        com.ss.android.socialbase.downloader.b.c r1 = (com.ss.android.socialbase.downloader.b.c) ZeusTransformUtils.preCheckCast(this.f15450b.get(Integer.valueOf(r2)), com.ss.android.socialbase.downloader.b.c.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.d() == false) goto L7;
        return true;
    }

    public com.ss.android.socialbase.downloader.b.c b(int r3) {
        b();
        com.ss.android.socialbase.downloader.b.c r4 = (com.ss.android.socialbase.downloader.b.c) ZeusTransformUtils.preCheckCast(this.f15450b.remove(Integer.valueOf(r3)), com.ss.android.socialbase.downloader.b.c.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        r4.b();
        c(r4);
    L5:
        return r4;
    }

    public void b(com.ss.android.socialbase.downloader.b.c r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, com.ss.android.socialbase.downloader.b.c>> r3 = this.f15450b.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L14;
        if (((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue() != r4) goto L6;
        r3.remove();
        return;
    }

    public void c(int r3) {
        b();
        com.ss.android.socialbase.downloader.b.c r4 = (com.ss.android.socialbase.downloader.b.c) ZeusTransformUtils.preCheckCast(this.f15450b.remove(Integer.valueOf(r3)), com.ss.android.socialbase.downloader.b.c.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        r4.a();
        c(r4);
        return;
    }
}
