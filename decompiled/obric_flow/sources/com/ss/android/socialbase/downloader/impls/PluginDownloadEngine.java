package com.ss.android.socialbase.downloader.impls;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class PluginDownloadEngine {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile PluginDownloadEngine f15726i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f15728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadPoolExecutor f15729c;
    public final AbsDownloadEngine d;
    public final PriorityQueue e;
    public final PriorityQueue f;
    public final AtomicInteger g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f15730h;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.PluginDownloadEngine$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadTask f15736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PluginDownloadEngine f15737b;

        public AnonymousClass5(PluginDownloadEngine r5, DownloadTask r10) {
            this.f15737b = r5;
            this.f15736a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DownloadTask r5 = this.f15736a;
            DownloadInfo r10 = r5.f15878a;
            int r11 = r5.e();
            int r12 = this.f15736a.f15878a.f15850z0.ordinal();
            if (Logger.a(r10) == false) goto L12;
            Logger.a("PluginDownloadEngine", r10, "download", "Run type:" + r12);
            Logger.a("PluginDownloadEngine", r10.l(), r10.P, "download", "Before DownloadingPluginQueueSize:" + this.f15737b.e.size() + " WaitingPluginQueueSize:" + this.f15737b.f.size(), false);
            Iterator r13 = this.f15737b.e.iterator();
        L6:
            if (r13.hasNext() == false) goto L8;
            Logger.a("PluginDownloadEngine", r10.l(), r10.P, "download", "Before DownloadingPlugin:" + ((PluginInfo) r13.next()), false);
            goto L6
        L8:
            Iterator r14 = this.f15737b.f.iterator();
        L10:
            if (r14.hasNext() == false) goto L12;
            Logger.a("PluginDownloadEngine", r10.l(), r10.P, "download", "Before WaitingPlugin:" + ((PluginInfo) r14.next()), false);
        L12:
            PluginDownloadEngine r15 = this.f15737b;
            DownloadTask r16 = this.f15736a;
            Iterator r17 = r15.e.iterator();
        L13:
            PluginInfo r18 = null;
            if (r17.hasNext() == false) goto L18;
            PluginInfo r19 = (PluginInfo) r17.next();
            if (r19.f15740c != r11) goto L13;
        L20:
            if (r19 == null) goto L29;
            if (r12 != 4) goto L81;
            if (r19.f15738a != 3) goto L25;
            r19.f15738a = r12;
        L26:
            r15.e.remove(r19);
            r15.e.add(r19);
            if (Logger.a(r10) == false) goto L81;
            Logger.a("PluginDownloadEngine", r10, "getPluginState", "In DownloadingQueue reorder");
            goto L81
        L25:
            r19.f15739b = r15.g.incrementAndGet();
        L81:
            if (Logger.a(r10) == false) goto L90;
            Logger.a("PluginDownloadEngine", r10, "download", "After DownloadingPluginQueueSize:" + this.f15737b.e.size() + " WaitingPluginQueueSize:" + this.f15737b.f.size());
            Iterator r20 = this.f15737b.e.iterator();
        L84:
            if (r20.hasNext() == false) goto L86;
            Logger.a("PluginDownloadEngine", r10.l(), r10.P, "download", "After DownloadingPlugin:" + ((PluginInfo) r20.next()), false);
            goto L84
        L86:
            Iterator r21 = this.f15737b.f.iterator();
        L88:
            if (r21.hasNext() == false) goto L101;
            Logger.a("PluginDownloadEngine", r10.l(), r10.P, "download", "After WaitingPlugin:" + ((PluginInfo) r21.next()), false);
            goto L88
        L101:
            return;
        L90:
            return;
        L29:
            Iterator r110 = r15.f.iterator();
        L31:
            if (r110.hasNext() == false) goto L36;
            PluginInfo r111 = (PluginInfo) r110.next();
            if (r111.f15740c != r11) goto L31;
            r18 = r111;
        L36:
            if (r15.e.size() >= r15.f15727a) goto L61;
            if (r15.f.isEmpty() == true) goto L40;
        L47:
            if (r18 == null) goto L59;
            if (r12 != 4) goto L57;
            if (r18.f15738a != 3) goto L52;
            r18.f15738a = r12;
        L53:
            r15.f.remove(r18);
            r15.f.add(r18);
            if (Logger.a(r10) == false) goto L81;
            Logger.a("PluginDownloadEngine", r10, "getPluginState", "Update Waiting Queue");
            goto L81
        L52:
            r18.f15739b = r15.g.incrementAndGet();
            goto L53
        L57:
            if (Logger.a(r10) == false) goto L81;
            Logger.a("PluginDownloadEngine", r10, "getPluginState", "In Waiting Queue");
            goto L81
        L59:
            PluginInfo r22 = new PluginInfo();
            r22.f15740c = r11;
            r22.f15738a = r12;
            r22.f15739b = r15.g.incrementAndGet();
            r22.d = r16;
            r15.f.add(r22);
            goto L81
        L40:
            if (r15.f15730h.containsKey(Integer.valueOf(r16.e())) == true) goto L47;
            PluginInfo r23 = new PluginInfo();
            r23.f15740c = r11;
            r23.f15738a = r12;
            r23.f15739b = r15.g.incrementAndGet();
            r23.d = r16;
            r15.e.add(r23);
            if (Logger.a(r10) == false) goto L44;
            Logger.a("PluginDownloadEngine", r10, "getPluginState", "New doDownload");
        L44:
            Future r24 = r15.d.a(r16);
            if (r24 == null) goto L81;
            r15.f15730h.put(Integer.valueOf(r16.e()), r24);
            goto L81
        L61:
            if (r18 == null) goto L70;
            if (r12 == 3) goto L64;
            r18.f15738a = r12;
            r18.f15739b = r15.g.incrementAndGet();
            r15.f.remove(r18);
            r15.f.add(r18);
            PluginInfo r25 = (PluginInfo) r15.e.poll();
            r15.f.add(r25);
            if (Logger.a(r10) == false) goto L69;
            Logger.a("PluginDownloadEngine", r10, "getPluginState", a.s(new StringBuilder("Pause:"), r25.f15740c, " Move WaitingQueue"));
        L69:
            r15.d.b(r25.d.e());
            goto L81
        L64:
            if (Logger.a(r10) == false) goto L81;
            Logger.a("PluginDownloadEngine", r10, "getPluginState", "In WaitingQueue wait");
            goto L81
        L70:
            PluginInfo r112 = new PluginInfo();
            r112.f15740c = r11;
            r112.f15738a = r12;
            r112.f15739b = r15.g.incrementAndGet();
            r112.d = r16;
            if (r12 == 3) goto L73;
            PluginInfo r26 = (PluginInfo) r15.e.poll();
            r15.f.add(r26);
            r15.f.add(r112);
            if (Logger.a(r10) == false) goto L79;
            Logger.a("PluginDownloadEngine", r10, "getPluginState", a.s(new StringBuilder("Pause:"), r26.f15740c, " Add WaitingQueue"));
        L79:
            r15.d.b(r26.d.e());
            goto L81
        L73:
            if (Logger.a(r10) == false) goto L75;
            Logger.a("PluginDownloadEngine", r10, "getPluginState", "Add WaitingQueue");
        L75:
            r15.f.add(r112);
            goto L81
        L18:
            r19 = null;
            goto L20
        }
    }

    public class PluginInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15740c;
        public DownloadTask d;

        public PluginInfo() {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L13:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L13;
            if (this.f15740c != ((PluginInfo) r5).f15740c) goto L13;
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f15740c)});
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder("PluginInfo{type=");
            r5.append(this.f15738a);
            r5.append(", index=");
            r5.append(this.f15739b);
            r5.append(", id=");
            return j0.n(r5, this.f15740c, '}');
        }
    }

    public PluginDownloadEngine() {
        LruCache r5 = DownloadSetting.e;
        int r10 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("plugin_thread_pool_size", 2);
        if (r10 > 0) goto L5;
        final int r11 = 2;
    L6:
        this.f15727a = r11;
        TimeUnit r12 = TimeUnit.SECONDS;
        final LinkedBlockingQueue r13 = new LinkedBlockingQueue();
        final DefaultThreadFactory r14 = new DefaultThreadFactory("DownloadThreadPool-plugin");
        final int r15 = r11;
        this.f15728b = new AnonymousClass1(this, r15, r11, r13, r14);
        final LinkedBlockingQueue r16 = new LinkedBlockingQueue();
        final DefaultThreadFactory r17 = new DefaultThreadFactory("DownloadThreadPool-plugin-single");
        this.f15729c = new AnonymousClass2(r16, r17);
        this.d = DownloadComponentManager.j();
        this.e = new PriorityQueue(11, new AnonymousClass3(this));
        this.f = new PriorityQueue(11, new AnonymousClass4(this));
        this.g = new AtomicInteger();
        this.f15730h = new HashMap();
        return;
    L5:
        r11 = r10;
        goto L6
    }

    public static int a(PluginDownloadEngine r5, PluginInfo r10, PluginInfo r11) {
        r5.getClass();
        int r12 = Integer.compare(r10.f15738a, r11.f15738a);
        if (r12 == 0) goto L6;
        return r12;
    L6:
        if (r10.f15738a != 3) goto L10;
        return Integer.compare(r11.f15739b, r10.f15739b);
    L10:
        return Integer.compare(r10.f15739b, r11.f15739b);
    }

    public static PluginDownloadEngine a() {
        if (f15726i != null) goto L16;
        monitor-enter(PluginDownloadEngine.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15726i != null) goto L11;
        f15726i = new PluginDownloadEngine();     // Catch: Throwable -> L9
    L11:
        monitor-exit(PluginDownloadEngine.class);     // Catch: Throwable -> L9
    L16:
        return f15726i;
    }

    public static boolean a(DownloadInfo r5) {
        LruCache r10 = DownloadSetting.e;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("enable_plugin_download_opt") <= 0) goto L10;
        EnqueueType r11 = r5.f15850z0;
        if (r11 != EnqueueType.d) goto L7;
        return true;
    L7:
        if (r11 != EnqueueType.e) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }
}
