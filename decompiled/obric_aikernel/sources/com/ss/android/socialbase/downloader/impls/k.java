package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile k f8005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f8006i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f8008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.impls.a f8009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Queue<d> f8010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Queue<d> f8011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f8012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicInteger f8013g;

    class a extends ThreadPoolExecutor {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f8014c;

        a(k r10, int r11, int r12, long r13, TimeUnit r15, BlockingQueue r16, ThreadFactory r17) {
            this.f8014c = r10;
            super(r11, r12, r13, r15, r16, r17);
            allowCoreThreadTimeOut(true);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable r10, Throwable r11) {
            if (r10 != null) goto L4;
            return;
        L4:
            if ((r10 instanceof FutureTask) == true) goto L6;
            return;
        L6:
            if (((FutureTask) r10).isCancelled() == false) goto L11;
            k.a(this.f8014c, 0);
            return;
        }
    }

    class b implements Comparator<d> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f8015c;

        b(k r10) {
            this.f8015c = r10;
        }

        public int a(d r10, d r11) {
            return k.b(this.f8015c, r10, r11);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(d r10, d r11) {
            return a(r10, r11);
        }
    }

    class c implements Comparator<d> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f8016c;

        c(k r10) {
            this.f8016c = r10;
        }

        public int a(d r10, d r11) {
            return k.b(this.f8016c, r11, r10);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(d r10, d r11) {
            return a(r10, r11);
        }
    }

    private class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f8018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f8019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.ss.android.socialbase.downloader.model.d f8020d;

        private d(k r10) {
        }

        /* synthetic */ d(k r10, a r11) {
            this(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L8;
        L15:
            return false;
        L8:
            if (d.class != r10.getClass()) goto L15;
            if (this.f8019c != ((d) r10).f8019c) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f8019c)});
        }

        public String toString() {
            return "PluginInfo{type=" + this.f8017a + ", index=" + this.f8018b + ", id=" + this.f8019c + '}';
        }
    }

    private class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8021a;

        public e(k r10, com.ss.android.socialbase.downloader.model.d r11, int r12) {
            this.f8021a = r12;
        }
    }

    static {
        f8006i = k();
    }

    private k() {
        this.f8007a = i();
        int r10 = this.f8007a;
        this.f8008b = new a(this, r10, r10, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sb.a("DownloadThreadPool-plugin", true));
        this.f8009c = com.ss.android.socialbase.downloader.downloader.a.s();
        this.f8010d = new PriorityQueue(11, new b(this));
        this.f8011e = new PriorityQueue(11, new c(this));
        this.f8012f = new Object();
        this.f8013g = new AtomicInteger();
    }

    static /* synthetic */ void a(k r10, int r11) {
        r10.m(r11);
    }

    static /* synthetic */ int b(k r10, d r11, d r12) {
        return r10.c(r11, r12);
    }

    private int c(d r10, d r11) {
        int r12 = Integer.compare(r10.f8017a, r11.f8017a);
        if (r12 == 0) goto L6;
        return r12;
    L6:
        if (r10.f8017a != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L10;
        int r13 = r11.f8018b;
        int r14 = r10.f8018b;
    L9:
        return Integer.compare(r13, r14);
    L10:
        r13 = r10.f8018b;
        r14 = r11.f8018b;
        goto L9
    }

    private d e(Collection<d> r10, int r11) {
        Iterator<d> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        d r13 = r12.next();
        if (r13.f8019c != r11) goto L4;
        return r13;
    L8:
        return null;
    }

    public static k f() {
        if (f8005h != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8005h != null) goto L9;
        f8005h = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f8005h;
    }

    private e h(int r10, int r11, com.ss.android.socialbase.downloader.model.d r12) {
        d r13 = e(this.f8010d, r10);
        a r14 = null;
        if (r13 == null) goto L15;
        if (r11 == EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) goto L7;
    L13:
        return null;
    L7:
        if (r13.f8017a != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L9;
        r13.f8017a = r11;
    L10:
        this.f8010d.remove(r13);
        this.f8010d.add(r13);
        if (lb.a.a() == false) goto L13;
        lb.a.g("PluginDownloadEngine", r10, "getPluginState", "In DownloadingQueue reorder");
        goto L13
    L9:
        r13.f8018b = this.f8013g.incrementAndGet();
        goto L10
    L15:
        if (this.f8010d.size() >= this.f8007a) goto L21;
        d r15 = new d(this, r14);
        r15.f8019c = r10;
        r15.f8017a = r11;
        r15.f8018b = this.f8013g.incrementAndGet();
        r15.f8020d = r12;
        this.f8010d.add(r15);
        if (lb.a.a() == false) goto L20;
        lb.a.g("PluginDownloadEngine", r10, "getPluginState", "New doDownload");
    L20:
        return new e(this, r12, 1);
    L21:
        d r16 = e(this.f8011e, r10);
        if (r16 != null) goto L24;
        d r17 = new d(this, r14);
        r17.f8019c = r10;
        r17.f8017a = r11;
        r17.f8018b = this.f8013g.incrementAndGet();
        r17.f8020d = r12;
        if (r11 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L37;
        d r18 = this.f8010d.poll();
        this.f8011e.add(r18);
        this.f8011e.add(r17);
        if (lb.a.a() == false) goto L45;
        lb.a.g("PluginDownloadEngine", r10, "getPluginState", "Pause:" + r18.f8019c + " Add WaitingQueue");
    L45:
        return new e(this, r18.f8020d, 2);
    L37:
        if (lb.a.a() == false) goto L39;
        lb.a.g("PluginDownloadEngine", r10, "getPluginState", "Add WaitingQueue");
    L39:
        this.f8011e.add(r17);
        return null;
    L24:
        if (r11 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L26;
        r16.f8017a = r11;
        r16.f8018b = this.f8013g.incrementAndGet();
        this.f8011e.remove(r16);
        this.f8011e.add(r16);
        d r19 = this.f8010d.poll();
        this.f8011e.add(r19);
        if (lb.a.a() == false) goto L33;
        lb.a.g("PluginDownloadEngine", r10, "getPluginState", "Pause:" + r19.f8019c + " Move WaitingQueue");
    L33:
        return new e(this, r19.f8020d, 2);
    L26:
        if (lb.a.a() == false) goto L28;
        lb.a.g("PluginDownloadEngine", r10, "getPluginState", "In WaitingQueue wait");
    L28:
        return null;
    }

    private int i() {
        int r10 = rb.a.d().optInt("plugin_thread_pool_size", 2);
        if (r10 > 0) goto L6;
        return 2;
    L6:
        return r10;
    }

    public static boolean j(DownloadInfo r10) {
        if (f8006i == true) goto L5;
    L9:
        return false;
    L5:
        if (r10.getEnqueueType() != EnqueueType.NEW_ENQUEUE_NORMAL) goto L7;
    L8:
        return true;
    L7:
        if (r10.getEnqueueType() != EnqueueType.NEW_ENQUEUE_IMMEDIATE) goto L9;
        goto L8
    }

    private static boolean k() {
        if (rb.a.d().optInt("enable_plugin_download_opt") <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void m(int r10) {
        d r11 = new d(this, null);
        r11.f8019c = r10;
        Object r12 = this.f8012f;
        monitor-enter(r12);
        this.f8010d.remove(r11);     // Catch: Throwable -> L21
        if (this.f8010d.size() >= this.f8007a) goto L7;
        d r13 = this.f8011e.poll();     // Catch: Throwable -> L21
        if (lb.a.a() == false) goto L14;
        lb.a.g("PluginDownloadEngine", r10, "tryDownloadNext", "Remove " + r10 + " Try doDownload:" + r13);     // Catch: Throwable -> L21
    L14:
        if (r13 != null) goto L17;
        monitor-exit(r12);     // Catch: Throwable -> L21
        return;
    L17:
        this.f8010d.add(r13);     // Catch: Throwable -> L21
        monitor-exit(r12);     // Catch: Throwable -> L21
        this.f8009c.l(r13.f8020d);
        return;
    L7:
        if (lb.a.a() == false) goto L9;
        lb.a.g("PluginDownloadEngine", r10, "tryDownloadNext", "DownloadingPluginQueue full");     // Catch: Throwable -> L21
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public void d(com.ss.android.socialbase.downloader.model.d r10) {
        Object r11 = this.f8012f;
        monitor-enter(r11);
        int r12 = r10.x();     // Catch: Throwable -> L36
        int r13 = r10.y().getEnqueueType().ordinal();     // Catch: Throwable -> L36
        if (lb.a.a() == false) goto L14;
        lb.a.g("PluginDownloadEngine", r12, "download", "Run type:" + r13);     // Catch: Throwable -> L36
        lb.a.g("PluginDownloadEngine", r12, "download", "Before DownloadingPluginQueueSize:" + this.f8010d.size() + " WaitingPluginQueueSize:" + this.f8011e.size());     // Catch: Throwable -> L36
        Iterator<d> r14 = this.f8010d.iterator();     // Catch: Throwable -> L36
    L8:
        if (r14.hasNext() == false) goto L10;
        lb.a.g("PluginDownloadEngine", r12, "download", "Before DownloadingPlugin:" + r14.next());     // Catch: Throwable -> L36
        goto L8
    L10:
        Iterator<d> r15 = this.f8011e.iterator();     // Catch: Throwable -> L36
    L12:
        if (r15.hasNext() == false) goto L14;
        lb.a.g("PluginDownloadEngine", r12, "download", "Before WaitingPlugin:" + r15.next());     // Catch: Throwable -> L36
    L14:
        e r16 = h(r12, r13, r10);     // Catch: Throwable -> L36
        if (lb.a.a() == false) goto L24;
        lb.a.g("PluginDownloadEngine", r12, "download", "After DownloadingPluginQueueSize:" + this.f8010d.size() + " WaitingPluginQueueSize:" + this.f8011e.size());     // Catch: Throwable -> L36
        Iterator<d> r17 = this.f8010d.iterator();     // Catch: Throwable -> L36
    L18:
        if (r17.hasNext() == false) goto L20;
        lb.a.g("PluginDownloadEngine", r12, "download", "After DownloadingPlugin:" + r17.next());     // Catch: Throwable -> L36
        goto L18
    L20:
        Iterator<d> r18 = this.f8011e.iterator();     // Catch: Throwable -> L36
    L22:
        if (r18.hasNext() == false) goto L24;
        lb.a.g("PluginDownloadEngine", r12, "download", "After WaitingPlugin:" + r18.next());     // Catch: Throwable -> L36
    L24:
        if (r16 != null) goto L27;
        monitor-exit(r11);     // Catch: Throwable -> L36
        return;
    L27:
        monitor-exit(r11);     // Catch: Throwable -> L36
        int r19 = r16.f8021a;
        if (r19 != 1) goto L31;
        this.f8009c.l(r10);
        return;
    L31:
        if (r19 != 2) goto L45;
        this.f8009c.G(r10.x());
        return;
    L45:
        return;
    L36:
        th = move-exception;
        throw th;
    }

    public ExecutorService g() {
        return this.f8008b;
    }

    public void l(bb.c r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("PluginDownloadEngine", r10.c(), "onFinish", "Run");
    L5:
        m(r10.c());
    }
}
