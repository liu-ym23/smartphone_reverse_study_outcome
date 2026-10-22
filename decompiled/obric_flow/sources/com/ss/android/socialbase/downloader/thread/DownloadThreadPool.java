package com.ss.android.socialbase.downloader.thread;

import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.PluginDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f16114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f16115b;

    public DownloadThreadPool() {
        this.f16114a = new ConcurrentHashMap();
        this.f16115b = new AtomicInteger(0);
    }

    public static void c(DownloadRunnable r5) {
        ExecutorService r10 = b(r5);     // Catch: Exception -> L8
        if ((r10 instanceof ThreadPoolExecutor) == false) goto L13;
        ((ThreadPoolExecutor) r10).remove(r5);     // Catch: Exception -> L8
        Future r11 = r5.f15296c;     // Catch: Exception -> L8
        if (r11 == null) goto L14;
        r11.cancel(true);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public final Future a(DownloadRunnable r10) {
        DownloadStatusHandler r5 = r10.f15294a.e;
        r5.getClass();
        r5.f15560p = System.currentTimeMillis();
        if (r5.f15551c.c() == true) goto L6;
        r5.f15551c.a(1);
    L6:
        int r11 = 0;
        if (this.f16115b.compareAndSet(500, 0) == false) goto L9;
        a();
    L9:
        this.f16115b.incrementAndGet();
        this.f16114a.put(Integer.valueOf(r10.f15294a.f15310c.l()), r10);
        DownloadTask r12 = r10.f15294a.f15309b;
        r12.s.e = System.currentTimeMillis();     // Catch: Exception -> L13
        ExecutorService r13 = b(r10);     // Catch: Exception -> L13
        if (Logger.a(r10.f15294a.f15310c) == false) goto L15;
        Logger.a("DownloadThreadPool", r10.f15294a.f15310c, "execute", "Executor:" + r13);     // Catch: Exception -> L13
    L15:
        Future<?> r14 = r13.submit(r10);     // Catch: Exception -> L13
        r10.f15296c = r14;     // Catch: Exception -> L13
        return r14;
    L13:
        e = move-exception;
        Logger.a("DownloadThreadPool", r10.f15294a.f15310c.l(), "execute", "Error:" + e);
        if (r12 == null) goto L23;
        IDownloadMonitorDepend r15 = r12.f15883j;
        DownloadInfo r16 = r12.f15878a;
        BaseException r17 = new BaseException(PointerIconCompat.TYPE_HELP, DownloadUtils.a(e, "DownloadThreadPoolExecute"));
        DownloadInfo r18 = r12.f15878a;
        if (r18 == null) goto L22;
        r11 = r18.o();
    L22:
        DownloadMonitorHelper.a(r15, r16, r17, r11);
    L23:
        e.printStackTrace();
        return null;
    }

    public final void b(int r5) {
        a();
        DownloadRunnable r10 = (DownloadRunnable) this.f16114a.remove(Integer.valueOf(r5));
        if (r10 != null) goto L5;
        return;
    L5:
        if (Logger.a(r10.f15294a.f15310c) == false) goto L7;
        Logger.a("DownloadRunnable", r10.f15294a.f15310c, "pause", "Run");
    L7:
        DownloadCommonParams r11 = r10.f15294a;
        r11.f = RunStatus.f15284b;
        r10.f15295b.b();
        if (r10.f15295b.d == true) goto L10;
        r10.f15294a.e.c();
        r10.a();
    L10:
        c(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.concurrent.ThreadPoolExecutor] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static ExecutorService b(DownloadRunnable r10) {
        Object r5 = null;
        ?? r11 = 0;
        ?? r12 = 0;
        DownloadInfo r13 = r10.f15294a.f15309b.f15878a;     // Catch: Throwable -> L7 Exception -> L9
        if (r13.b1 == false) goto L11;
        Object r14 = DownloadComponentManager.n();     // Catch: Throwable -> L7 Exception -> L9
    L12:
        if (r14 == null) goto L50;
    L28:
        r12 = r14;
        r14 = r14;
    L29:
        if (r12 == 0) goto L31;
    L33:
        if (r12 == 0) goto L35;
    L37:
        if (r12 == 0) goto L39;
        return r12;
    L39:
        return DownloadComponentManager.q();
    L35:
        if (PluginDownloadEngine.a(r13) == false) goto L37;
        r12 = PluginDownloadEngine.a().f15728b;     // Catch: Throwable -> L7 Exception -> L9
        goto L37
    L23:
        e = e;
        r11 = r14;
    L41:
        e.printStackTrace();     // Catch: Throwable -> L7
        if (r11 == 0) goto L44;
        return r11;
    L44:
        return DownloadComponentManager.q();
    L21:
        th = th;
        r5 = r14;
    L45:
        if (r5 != null) goto L47;
        DownloadComponentManager.q();
    L47:
        throw th;
    L31:
        if (a(r13, r10) == false) goto L33;
        r12 = DownloadComponentManager.r();     // Catch: Throwable -> L7 Exception -> L9
        goto L33
    L50:
        r13.d();     // Catch: Throwable -> L21 Exception -> L23
        int r15 = r13.T0.optInt("executor_group", 2);     // Catch: Throwable -> L21 Exception -> L23
        if (r15 != 3) goto L16;
        r12 = DownloadComponentManager.q();     // Catch: Throwable -> L21 Exception -> L23
        r14 = r14;
        goto L29
    L16:
        if (r15 != 4) goto L18;
        r12 = DownloadComponentManager.q();     // Catch: Throwable -> L21 Exception -> L23
        r14 = r14;
        goto L29
    L18:
        if (r15 != 7) goto L28;
        r14 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L21 Exception -> L23
        goto L29
    L11:
        r14 = null;
    L7:
        th = th;
    L9:
        e = e;
        goto L41
    }

    public final void a() {
        Iterator r5 = this.f16114a.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((DownloadRunnable) ((Map.Entry) r5.next()).getValue()).f15294a.g == true) goto L4;
        r5.remove();
        goto L4
    }

    public final DownloadRunnable a(int r5) {
        a();
        DownloadRunnable r10 = (DownloadRunnable) this.f16114a.remove(Integer.valueOf(r5));
        if (r10 != null) goto L5;
    L11:
        return r10;
    L5:
        if (Logger.a(r10.f15294a.f15310c) == false) goto L7;
        Logger.a("DownloadRunnable", r10.f15294a.f15310c, "cancel", "Run");
    L7:
        DownloadCommonParams r11 = r10.f15294a;
        r11.f = RunStatus.f15285c;
        r10.f15295b.a();
        if (r10.f15295b.d == true) goto L10;
        r10.f15294a.e.a(-4, null);
        r10.a();
    L10:
        c(r10);
        goto L11
    }

    public static boolean a(DownloadInfo r10, DownloadRunnable r11) {
        r10.d();
        long r5 = 0;
        if (r10.T0.optLong("dbjson_key_expect_file_length") > 0) goto L5;
        return false;
    L5:
        JSONObject r12 = DownloadSetting.a(r10.l(), null).d("segment_config");
        if (r12 == null) goto L9;
        r5 = r12.optLong("expect_min_download_size");
    L9:
        if (r5 >= 104857600) goto L11;
        return false;
    L11:
        r10.d();
        if (r10.T0.optLong("dbjson_key_expect_file_length") <= r5) goto L15;
        return true;
    L15:
        r11.f15294a.f15311h = false;
        return false;
    }
}
