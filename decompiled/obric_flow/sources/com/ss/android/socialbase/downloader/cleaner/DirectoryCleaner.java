package com.ss.android.socialbase.downloader.cleaner;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.nubia.neopush.commons.AppUtil;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DirectoryCleaner implements CleanerImpl.CleanerHandler {
    public static volatile long d = 0;
    public static volatile boolean e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CleanerImpl f15252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CleanerConfig f15253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15254c;

    public DirectoryCleaner(CleanerImpl r5, CleanerConfig r10) {
        this.f15252a = r5;
        this.f15253b = r10;
    }

    public static void a(CleanerConfig r11) {
        if (Logger.b() == false) goto L5;
        Logger.b("DirectoryCleaner", "init", "Run");
    L5:
        DownloadSetting r5 = DownloadSetting.f;
        if (r5.a("auto_clean_directory", 0) <= 0) goto L32;
        JSONArray r10 = r5.c("clean_directory_list");
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.length() <= 0) goto L33;
        int r12 = r5.a("clean_directory_check_interval_d", 0);
        if (Logger.b() == false) goto L16;
        Logger.b("DirectoryCleaner", "init", "Clean_directory_check_interval_d:" + r12 + " clean_directory_list:" + r10);
    L16:
        if (r12 <= 0) goto L25;
        r11.getClass();
        long r13 = CleanerConfig.a("key_download_cache_last_directory_clean_time");
        if (r13 <= 0) goto L25;
        if ((System.currentTimeMillis() - r13) >= (((long) r12) * AppUtil.MILLIS_IN_DAYS)) goto L25;
        if (Logger.b() == false) goto L30;
        Logger.b("DirectoryCleaner", "start", "It has already been clean, lastCleanTime:" + r13);
        return;
    L30:
        return;
    L25:
        e = true;
        if (Logger.b() == false) goto L31;
        Logger.b("DirectoryCleaner", "init", "Run End");
        return;
    L31:
        return;
    L33:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.cleaner.CleanerImpl.CleanerHandler
    public final void start() {
        if (Logger.b() == false) goto L5;
        Logger.b("DirectoryCleaner", "start", "Run");
    L5:
        System.nanoTime();
        a();     // Catch: Throwable -> L12
        if (Logger.b() == false) goto L10;
        Logger.b("DirectoryCleaner", "start", "Run End");
    L10:
        System.nanoTime();
        return;
    L12:
        th = move-exception;
        Logger.c("DirectoryCleaner", "start", "Error:" + th);     // Catch: Throwable -> L19
        if (Logger.b() == false) goto L17;
        Logger.b("DirectoryCleaner", "start", "Run End");
    L17:
        System.nanoTime();
        return;
    L19:
        th = move-exception;
        if (Logger.b() == false) goto L23;
        Logger.b("DirectoryCleaner", "start", "Run End");
    L23:
        System.nanoTime();
        throw th;
    }

    public final void a() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L71
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L71
        if (r5 != null) goto L9;
        Logger.c("DirectoryCleaner", "init", "Error context is null");
        return;
    L9:
        this.f15254c = r5.getPackageName();
        if (d >= 0) goto L13;
        d = DownloadSetting.f.a("clean_directory_expired_time_d", -1);
    L13:
        if (Logger.b() == false) goto L16;
        Logger.b("DirectoryCleaner", "init", "ExpiredTime" + d);
    L16:
        if (d < 0) goto L87;
        d *= AppUtil.MILLIS_IN_DAYS;
        if (this.f15253b == null) goto L21;
        CleanerConfig.a("key_download_cache_last_directory_clean_time", System.currentTimeMillis());
    L21:
        JSONArray r10 = DownloadSetting.f.c("clean_directory_list");
        if (r10 != null) goto L24;
        return;
    L24:
        if (r10.length() <= 0) goto L88;
        int r11 = 0;
    L28:
        if (r11 >= r10.length()) goto L90;
        JSONObject r12 = r10.optJSONObject(r11);
        if (r12 == null) goto L69;
        String r13 = r12.optString("directory_path");
        if (Logger.b() == false) goto L36;
        Logger.b("DirectoryCleaner", "startImpl", "Run directoryPath:" + r13);
    L36:
        if (TextUtils.isEmpty(r13) == true) goto L69;
        JSONArray r14 = r12.optJSONArray("path_contains_list");
        ArrayList r15 = new ArrayList();
        if (r14 != null) goto L41;
    L49:
        File r16 = CleanerConfig.a(r13, this.f15254c);
        if (r16 != null) goto L52;
    L54:
        CleanerImpl r17 = this.f15252a;
        if (r17 != null) goto L57;
    L59:
        File r18 = CleanerConfig.b(r13, this.f15254c);
        if (r18 != null) goto L62;
    L64:
        CleanerImpl r19 = this.f15252a;
        if (r19 == null) goto L69;
        if (r19.f15238b == false) goto L69;
        return;
    L62:
        if (r18.isDirectory() == false) goto L64;
        a(r18, r15);
        goto L64
    L57:
        if (r17.f15238b == false) goto L59;
        return;
    L52:
        if (r16.isDirectory() == false) goto L54;
        a(r16, r15);
        goto L69
    L41:
        if (r14.length() <= 0) goto L49;
        int r20 = 0;
    L44:
        if (r20 >= r14.length()) goto L49;
        String r21 = r14.optString(r20);
        if (TextUtils.isEmpty(r21) == true) goto L48;
        r15.add(r21);
    L48:
        r20 = r20 + 1;
    L69:
        r11 = r11 + 1;
        goto L28
    L90:
        return;
    L88:
        return;
    L87:
        return;
    L71:
        th = move-exception;
        throw th;
    }

    public final void a(File r10, final ArrayList r11) {
        final long r5 = System.currentTimeMillis();
        final ArrayList r12 = new ArrayList();
        final LinkedList r13 = new LinkedList();
        r13.add(r10);
        FileFilter r14 = new AnonymousClass1(r11, r5, r12, r13);
    L4:
        if (r13.isEmpty() == true) goto L7;
        ((File) r13.poll()).listFiles(r14);
        goto L4
    L7:
        if (r12.isEmpty() == false) goto L10;
        return;
    L10:
        monitor-enter(DownloadComponentManager.class);
        Context r15 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L35
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L35
        Map r16 = Downloader.b(r15).b(r10.getAbsolutePath() + "%");
        if (r16 == null) goto L16;
        r16.size();
    L16:
        Iterator r17 = r12.iterator();
    L18:
        if (r17.hasNext() == false) goto L47;
        File r18 = (File) r17.next();
        CleanerImpl r19 = this.f15252a;
        if (r19 != null) goto L22;
    L24:
        String r20 = r18.getAbsolutePath();
        if (r16 == null) goto L31;
        Pair r21 = (Pair) r16.get(r20.toLowerCase(Locale.getDefault()));
        if (r21 == null) goto L31;
        if (((Long) r21.second).longValue() > 0) goto L31;
        ((DefaultDownloadCache) DownloadComponentManager.h()).d(((Integer) r21.first).intValue());
    L31:
        r18.delete();
        if (Logger.b() == false) goto L18;
        Logger.b("DirectoryCleaner", "deleteCacheDataImpl", "Delete DownloadData:" + r20);
        goto L18
    L22:
        if (r19.f15238b == false) goto L24;
        return;
    L47:
        return;
    L35:
        th = move-exception;
        throw th;
    }
}
