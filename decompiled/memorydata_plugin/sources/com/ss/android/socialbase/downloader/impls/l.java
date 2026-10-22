package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile l f15506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15507b;
    private ThreadPoolExecutor c;
    private ThreadPoolExecutor d;
    private com.ss.android.socialbase.downloader.impls.a e;
    private Queue<a> f;
    private Queue<a> g;
    private AtomicInteger h;
    private Map<Integer, Future> i;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15517b;
        int c;
        DownloadTask d;
        final /* synthetic */ l e;

        private a(l r1) {
            this.e = r1;
        }

        /* synthetic */ a(l r1, AnonymousClass1 r2) {
            this(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L15:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L15;
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.c != r6.c) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.c)});
        }

        public String toString() {
            return "PluginInfo{type=" + this.f15516a + ", index=" + this.f15517b + ", id=" + this.c + '}';
        }
    }

    private l() {
        this.f15507b = c();
        final int r3 = this.f15507b;
        final TimeUnit r6 = TimeUnit.SECONDS;
        final LinkedBlockingQueue r7 = new LinkedBlockingQueue();
        final com.ss.android.socialbase.downloader.h.a r8 = new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-plugin", true);
        final long r4 = 15;
        this.c = new AnonymousClass1(this, r3, r3, r4, r6, r7, r8);
        final TimeUnit r9 = TimeUnit.SECONDS;
        final LinkedBlockingQueue r10 = new LinkedBlockingQueue();
        final com.ss.android.socialbase.downloader.h.a r11 = new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-plugin-single", true);
        final int r2 = 1;
        final int r5 = 1;
        final long r12 = 30;
        this.d = new AnonymousClass2(this, r2, r5, r12, r9, r10, r11);
        this.e = com.ss.android.socialbase.downloader.downloader.b.F();
        this.f = new PriorityQueue(11, new AnonymousClass3(this));
        this.g = new PriorityQueue(11, new AnonymousClass4(this));
        this.h = new AtomicInteger();
        this.i = new HashMap();
    }

    private int a(a r2, a r3) {
        int r1 = Integer.compare(r2.f15516a, r3.f15516a);
        if (r1 == 0) goto L6;
        return r1;
    L6:
        if (r2.f15516a != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L10;
        int r4 = r3.f15517b;
        int r5 = r2.f15517b;
    L9:
        return Integer.compare(r4, r5);
    L10:
        r4 = r2.f15517b;
        r5 = r3.f15517b;
        goto L9
    }

    static /* synthetic */ int a(l r0, a r1, a r2) {
        return r0.a(r1, r2);
    }

    private a a(Collection<a> r3, int r4) {
        Iterator r2 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin");
        if (r5.c != r4) goto L4;
        return r5;
    L8:
        return null;
    }

    public static l a() {
        if (f15506a != null) goto L15;
        monitor-enter(l.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15506a != null) goto L9;
        f15506a = new l();     // Catch: Throwable -> L11
    L9:
        monitor-exit(l.class);     // Catch: Throwable -> L11
    L15:
        return f15506a;
    }

    static /* synthetic */ Map a(l r0) {
        return r0.i;
    }

    private void a(int r10) {
        a r0 = new a(this, null);
        r0.c = r10;
        this.f.remove(r0);
        if (this.f.size() >= this.f15507b) goto L5;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.g.poll(), a.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a("morpheus_plugin_download") == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "morpheus_plugin_download", "tryDownloadNext", "Remove " + r10 + " Try doDownload:" + r1, false);
    L11:
        if (r1 != null) goto L14;
        return;
    L14:
        if (this.i.containsKey(Integer.valueOf(r1.c)) == false) goto L19;
        this.g.add(r1);
        if (com.ss.android.socialbase.downloader.e.a.a("morpheus_plugin_download") == false) goto L24;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "morpheus_plugin_download", "tryDownloadNext", "Task is running", false);
        return;
    L24:
        return;
    L19:
        this.f.add(r1);
        Future r11 = this.e.a(r1.d);
        if (r11 == null) goto L25;
        this.i.put(Integer.valueOf(r1.d.getDownloadId()), r11);
        return;
    L25:
        return;
    L5:
        if (com.ss.android.socialbase.downloader.e.a.a("morpheus_plugin_download") == false) goto L23;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "morpheus_plugin_download", "tryDownloadNext", "DownloadingPluginQueue full", false);
        return;
    }

    private void a(int r7, int r8, DownloadTask r9, DownloadInfo r10) {
        a r0 = a(this.f, r7);
        if (r0 != null) goto L5;
        a r1 = a(this.g, r7);
        AnonymousClass1 r5 = null;
        if (this.f.size() >= this.f15507b) goto L44;
        if (this.g.isEmpty() == true) goto L19;
    L27:
        if (r1 != null) goto L29;
        a r11 = new a(this, r5);
        r11.c = r7;
        r11.f15516a = r8;
        r11.f15517b = this.h.incrementAndGet();
        r11.d = r9;
        this.g.add(r11);
        return;
    L29:
        if (r8 != EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) goto L38;
        if (r1.f15516a != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L33;
        r1.f15516a = r8;
    L34:
        this.g.remove(r1);
        this.g.add(r1);
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L70;
        String r6 = "Update Waiting Queue";
    L40:
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "getPluginState", r6);
        return;
    L70:
        return;
    L33:
        r1.f15517b = this.h.incrementAndGet();
        goto L34
    L38:
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L71;
        r6 = "In Waiting Queue";
        goto L40
    L71:
        return;
    L19:
        if (this.i.containsKey(Integer.valueOf(r9.getDownloadId())) == true) goto L27;
        a r2 = new a(this, r5);
        r2.c = r7;
        r2.f15516a = r8;
        r2.f15517b = this.h.incrementAndGet();
        r2.d = r9;
        this.f.add(r2);
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L23;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "getPluginState", "New doDownload");
    L23:
        Future r12 = this.e.a(r9);
        if (r12 == null) goto L69;
        this.i.put(Integer.valueOf(r9.getDownloadId()), r12);
        return;
    L69:
        return;
    L44:
        if (r1 != null) goto L46;
        a r3 = new a(this, r5);
        r3.c = r7;
        r3.f15516a = r8;
        r3.f15517b = this.h.incrementAndGet();
        r3.d = r9;
        if (r8 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L59;
        a r13 = (a) ZeusTransformUtils.preCheckCast(this.f.poll(), a.class, "com.obric.memorydata.plugin");
        this.g.add(r13);
        this.g.add(r3);
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L65;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "getPluginState", "Pause:" + r13.c + " Add WaitingQueue");
    L65:
        this.e.b(r13.d.getDownloadId());
        return;
    L59:
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L61;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "getPluginState", "Add WaitingQueue");
    L61:
        this.g.add(r3);
        return;
    L46:
        if (r8 == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L48;
        r1.f15516a = r8;
        r1.f15517b = this.h.incrementAndGet();
        this.g.remove(r1);
        this.g.add(r1);
        a r14 = (a) ZeusTransformUtils.preCheckCast(this.f.poll(), a.class, "com.obric.memorydata.plugin");
        this.g.add(r14);
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L54;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "getPluginState", "Pause:" + r14.c + " Move WaitingQueue");
    L54:
        this.e.b(r14.d.getDownloadId());
        return;
    L48:
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L73;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "getPluginState", "In WaitingQueue wait");
        return;
    L73:
        return;
    L5:
        if (r8 == EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) goto L7;
        return;
    L7:
        if (r0.f15516a != EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) goto L9;
        r0.f15516a = r8;
    L10:
        this.f.remove(r0);
        this.f.add(r0);
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L68;
        com.ss.android.socialbase.downloader.e.a.a("PluginDownloadEngine", r10, "getPluginState", "In DownloadingQueue reorder");
        return;
    L68:
        return;
    L9:
        r0.f15517b = this.h.incrementAndGet();
        goto L10
    }

    static /* synthetic */ void a(l r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(l r0, int r1, int r2, DownloadTask r3, DownloadInfo r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static boolean a(DownloadInfo r2) {
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("enable_plugin_download_opt") > 0) goto L5;
    L9:
        return false;
    L5:
        if (r2.getEnqueueType() != EnqueueType.NEW_ENQUEUE_NORMAL) goto L7;
    L8:
        return true;
    L7:
        if (r2.getEnqueueType() != EnqueueType.NEW_ENQUEUE_IMMEDIATE) goto L9;
        goto L8
    }

    static /* synthetic */ ThreadPoolExecutor b(l r0) {
        return r0.d;
    }

    private int c() {
        int r2 = com.ss.android.socialbase.downloader.g.a.b().optInt("plugin_thread_pool_size", 2);
        if (r2 > 0) goto L6;
        return 2;
    L6:
        return r2;
    }

    static /* synthetic */ Queue c(l r0) {
        return r0.f;
    }

    static /* synthetic */ Queue d(l r0) {
        return r0.g;
    }

    public void a(final DownloadTask r3) {
        this.d.execute(new AnonymousClass5(this, r3));
    }

    public ExecutorService b() {
        return this.c;
    }
}
