package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.a;
import cn.nubia.neopush.commons.AppUtil;
import com.lynx.tasm.p;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Cleaner {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f15221b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Cleaner f15222c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile CleanerConfig f15223a;

    static {
        f15221b = new AtomicBoolean();
        f15222c = null;
    }

    public Cleaner() {
        this.f15223a = new CleanerConfig();
    }

    public static Cleaner a() {
        if (f15222c != null) goto L16;
        monitor-enter(Cleaner.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15222c != null) goto L11;
        f15222c = new Cleaner();     // Catch: Throwable -> L9
    L11:
        monitor-exit(Cleaner.class);     // Catch: Throwable -> L9
    L16:
        return f15222c;
    }

    public final void b() {
        if (Logger.b() == false) goto L5;
        long r5 = System.currentTimeMillis();
    L6:
        CleanerConfig r10 = this.f15223a;
        r10.getClass();
        monitor-enter(DownloadComponentManager.class);     // Catch: Throwable -> L35
        Context r11 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L37
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L37
        if (r11 == null) goto L42;
        String r12 = DownloadComponentManager.b().getPackageName();     // Catch: Throwable -> L35
        r10.f15233m = r12;     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r12) == true) goto L42;
        String r13 = CleanerConfig.b().getString("key_download_cache_clean_strategy", "");     // Catch: Throwable -> L19
    L22:
        if (TextUtils.isEmpty(r13) == true) goto L25;
        r10.a(new JSONObject(r13));     // Catch: Throwable -> L35
    L25:
        LruCache r14 = DownloadSetting.e;     // Catch: Throwable -> L35
        JSONObject r15 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c();     // Catch: Throwable -> L35
        r10.a(r15);     // Catch: Throwable -> L35
        r10.b(r15);     // Catch: Throwable -> L35
        DirectoryCleaner.a(r10);     // Catch: Throwable -> L35
        if (r10.f15225a.isEmpty() == true) goto L42;
        Iterator r16 = r10.f15225a.entrySet().iterator();     // Catch: Throwable -> L35
    L30:
        if (r16.hasNext() == false) goto L42;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Throwable -> L35
        CleanerConfig.CleanItem r18 = (CleanerConfig.CleanItem) r17.getValue();     // Catch: Throwable -> L35
        if (r18.f15234a == true) goto L30;
        r10.f15226b.put(r17.getKey(), r18);     // Catch: Throwable -> L35
    L19:
        th = move-exception;
        Logger.c("CleanerConfig", "getString", "Error:" + th);     // Catch: Throwable -> L35
        r13 = "";
    L42:
        if (Logger.b() == false) goto L56;
        Logger.b("Cleaner", "init", "Cleaner init cost time=" + (System.currentTimeMillis() - r5));
        return;
    L56:
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
        goto L42
    L5:
        r5 = 0;
        goto L6
    }

    public final void a(boolean r14) {
        if (f15221b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (Logger.b() == false) goto L8;
        Logger.b("Cleaner", "start", "enter Cleaner start");
    L8:
        if (DownloadHelper.b() == true) goto L11;
        this.f15223a.a();
        return;
    L11:
        DownloadSetting r5 = DownloadSetting.f;
        int r10 = r5.a("fast_download_clean_temp_path_delay_time_S", 0);
        if (Logger.b() == false) goto L14;
        Logger.b("FastDownloadCleaner", "start", "DelayTime: " + r10);
    L14:
        if (r10 <= 0) goto L17;
        DownloadComponentManager.a(new FastDownloadCleaner$1(), r10, TimeUnit.SECONDS);
    L17:
        final CleanerConfig r11 = this.f15223a;
        if (Logger.b() == false) goto L20;
        Logger.b("CleanerStatistics", "start", "Run");
    L20:
        int r12 = r5.a("monitor_cache_delay_time_s", 0);
        if (r12 <= 0) goto L40;
        int r13 = r5.a("monitor_cache_interval_d", 0);
        if (r13 <= 0) goto L34;
        r11.getClass();
        long r15 = CleanerConfig.a("key_download_cache_last_report_time");
        if (r15 > 0) goto L28;
    L32:
        CleanerConfig.a("key_download_cache_last_report_time", System.currentTimeMillis());
        goto L34
    L28:
        if ((System.currentTimeMillis() - r15) >= (((long) r13) * AppUtil.MILLIS_IN_DAYS)) goto L32;
        if (Logger.b() == false) goto L40;
        Logger.b("CleanerStatistics", "start", "It has already been reported, lastReportTime:" + r15);
    L34:
        monitor-enter(DownloadComponentManager.class);
        Context r16 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L55
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L55
        if (r16 == null) goto L40;
        DownloadComponentManager.a(new CacheStatistics.AnonymousClass1(r11), r12, TimeUnit.SECONDS);
    L55:
        th = move-exception;
        throw th;
    L40:
        int r17 = r5.a("start_clean_delay_time_s", 0);
        if (Logger.b() == false) goto L43;
        StringBuilder r18 = p.d(r17, "Run cleaner startCleanDelayTime: ", " isCacheCleanEnabled:");
        r18.append(this.f15223a.c());
        Logger.b("Cleaner", "run", r18.toString());
    L43:
        if (r17 > 0) goto L45;
    L53:
        this.f15223a.a();
        return;
    L45:
        if (this.f15223a.c() == false) goto L53;
        Runnable r19 = new AnonymousClass1(this);
        if (r14 == false) goto L51;
        r19.run();
        return;
    L51:
        DownloadComponentManager.a(r19, r17, TimeUnit.SECONDS);
    }

    public final void a(DownloadInfo r10) {
        CleanerConfig r11 = this.f15223a;
        Iterator r5 = r11.f15226b.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L46;
        Map.Entry r12 = (Map.Entry) r5.next();
        CleanerConfig.CleanItem r13 = (CleanerConfig.CleanItem) r12.getValue();
        if (r13 == null) goto L4;
        if (TextUtils.isEmpty(r10.e) == true) goto L4;
        if (r13.f15235b.isEmpty() == true) goto L18;
        if (TextUtils.isEmpty(r10.P) == true) goto L18;
        if (r13.f15235b.contains(r10.P) == false) goto L18;
    L43:
        r11.a(((Integer) r12.getKey()).intValue(), r10, false);
        return;
    L18:
        if (r13.f15236c.isEmpty() == true) goto L29;
        String r14 = r10.d;
        if (TextUtils.isEmpty(r14) == true) goto L4;
        Iterator r15 = r13.f15236c.iterator();
    L24:
        if (r15.hasNext() == false) goto L29;
        if (r14.startsWith((String) r15.next()) == false) goto L24;
    L29:
        if (r13.d.isEmpty() == true) goto L4;
        if (TextUtils.isEmpty(r11.f15233m) == true) goto L4;
        String r16 = r10.e;
        if (TextUtils.isEmpty(r16) == true) goto L4;
        if (r16.indexOf(r11.f15233m) <= 0) goto L4;
        if (r16.endsWith("/") == false) goto L42;
        r16 = a.n(r16, 1, 0);
    L42:
        if (r13.d.contains(r16) == false) goto L4;
    L46:
        if (r11.d.isEmpty() == true) goto L96;
        String r17 = r10.e;
        if (TextUtils.isEmpty(r17) == true) goto L97;
        Iterator r18 = r11.d.iterator();
    L52:
        if (r18.hasNext() == false) goto L98;
        if (r17.contains((String) r18.next()) == false) goto L52;
        if (r10.o() != (-3)) goto L58;
        File r19 = new File(r17, r10.f15808b);
    L60:
        if (r19.exists() == false) goto L52;
        if ((System.currentTimeMillis() - r19.lastModified()) <= r11.e) goto L52;
        r11.a(-1, r10, false);
        return;
    L58:
        r19 = new File(r10.q(), r10.p());
        goto L60
    L98:
        return;
    L97:
        return;
    }
}
