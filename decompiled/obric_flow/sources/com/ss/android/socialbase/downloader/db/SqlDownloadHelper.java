package com.ss.android.socialbase.downloader.db;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.nubia.neopush.commons.Constant;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SqlDownloadHelper {
    public static int A = -1;
    public static int B = -1;
    public static int C = -1;
    public static int D = -1;
    public static int E = -1;
    public static int F = -1;
    public static int G = -1;
    public static int H = -1;
    public static int I = -1;
    public static int J = -1;
    public static int K = -1;
    public static int L = -1;
    public static int M = -1;
    public static int N = -1;
    public static int O = -1;
    public static int P = -1;
    public static int Q = -1;
    public static boolean R = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f15456a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f15457b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f15458c = -1;
    public static int d = -1;
    public static int e = -1;
    public static int f = -1;
    public static int g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f15459h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f15460i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f15461j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f15462k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f15463l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f15464m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f15465n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f15466o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f15467p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f15468q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f15469r = -1;
    public static int s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f15470t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f15471u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f15472v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f15473w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f15474x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f15475y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f15476z = -1;

    public static boolean a(Cursor r5) {
        if (R == false) goto L11;
        return true;
    L11:
        f15456a = r5.getColumnIndex("_id");     // Catch: Exception -> L8
        e = r5.getColumnIndex("name");     // Catch: Exception -> L8
        f15467p = r5.getColumnIndex(Constant.TITLE);     // Catch: Exception -> L8
        f15457b = r5.getColumnIndex("url");     // Catch: Exception -> L8
        f15458c = r5.getColumnIndex("savePath");     // Catch: Exception -> L8
        d = r5.getColumnIndex("tempPath");     // Catch: Exception -> L8
        g = r5.getColumnIndex(NotificationCompat.CATEGORY_STATUS);     // Catch: Exception -> L8
        f15459h = r5.getColumnIndex("curBytes");     // Catch: Exception -> L8
        f15463l = r5.getColumnIndex("force");     // Catch: Exception -> L8
        f15466o = r5.getColumnIndex("mimeType");     // Catch: Exception -> L8
        L = r5.getColumnIndex("cacheLifeTimeMax");     // Catch: Exception -> L8
        E = r5.getColumnIndex("auxiliaryJsonobjectString");     // Catch: Exception -> L8
        H = r5.getColumnIndex("downloadStartTimeStamp");     // Catch: Exception -> L8
        Q = r5.getColumnIndex("monitorScene");     // Catch: Exception -> L8
        f = r5.getColumnIndex("chunkCount");     // Catch: Exception -> L8
        O = r5.getColumnIndex("backCurBytes");     // Catch: Exception -> L8
        f15460i = r5.getColumnIndex("totalBytes");     // Catch: Exception -> L8
        f15461j = r5.getColumnIndex("eTag");     // Catch: Exception -> L8
        f15462k = r5.getColumnIndex("onlyWifi");     // Catch: Exception -> L8
        f15464m = r5.getColumnIndex("retryCount");     // Catch: Exception -> L8
        f15465n = r5.getColumnIndex("extra");     // Catch: Exception -> L8
        f15468q = r5.getColumnIndex("notificationEnable");     // Catch: Exception -> L8
        f15469r = r5.getColumnIndex("notificationVisibility");     // Catch: Exception -> L8
        s = r5.getColumnIndex("isFirstDownload");     // Catch: Exception -> L8
        f15470t = r5.getColumnIndex("isFirstSuccess");     // Catch: Exception -> L8
        f15471u = r5.getColumnIndex("needHttpsToHttpRetry");     // Catch: Exception -> L8
        f15472v = r5.getColumnIndex("downloadTime");     // Catch: Exception -> L8
        f15473w = r5.getColumnIndex("packageName");     // Catch: Exception -> L8
        f15474x = r5.getColumnIndex("md5");     // Catch: Exception -> L8
        f15475y = r5.getColumnIndex("curRetryTime");     // Catch: Exception -> L8
        f15476z = r5.getColumnIndex("defaultHttpServiceBackUp");     // Catch: Exception -> L8
        A = r5.getColumnIndex("backUpUrlsStr");     // Catch: Exception -> L8
        B = r5.getColumnIndex("backUpUrlRetryCount");     // Catch: Exception -> L8
        C = r5.getColumnIndex("realDownloadTime");     // Catch: Exception -> L8
        P = r5.getColumnIndex("realBackDownloadTime");     // Catch: Exception -> L8
        D = r5.getColumnIndex("independentProcess");     // Catch: Exception -> L8
        F = r5.getColumnIndex("iconUrl");     // Catch: Exception -> L8
        G = r5.getColumnIndex("appVersionCode");     // Catch: Exception -> L8
        I = r5.getColumnIndex("downloadFinishTimeStamp");     // Catch: Exception -> L8
        J = r5.getColumnIndex("installedTimeStamp");     // Catch: Exception -> L8
        K = r5.getColumnIndex("hasDoInstallation");     // Catch: Exception -> L8
        M = r5.getColumnIndex("pcdnUrlsStr");     // Catch: Exception -> L8
        N = r5.getColumnIndex("cdnUrlsStr");     // Catch: Exception -> L8
        R = true;
        return true;
    L8:
        e = move-exception;
        Context r10 = DownloadComponentManager.f15515a;
        Logger.c("SqlDownloadHelper", "loadDownloadInfoIndex", "Error:" + e);
        return false;
    }

    public static DownloadInfo b(Cursor r5) {
        DownloadInfo r10 = new DownloadInfo();
        r10.f15805a = r5.getInt(f15456a);     // Catch: Exception -> L11
        r10.f15808b = r5.getString(e);     // Catch: Exception -> L11
        r10.f15810c = r5.getString(f15467p);     // Catch: Exception -> L11
        r10.d = r5.getString(f15457b);     // Catch: Exception -> L11
        r10.e = r5.getString(f15458c);     // Catch: Exception -> L11
        r10.f = r5.getString(d);     // Catch: Exception -> L11
        r10.a(r5.getInt(g));     // Catch: Exception -> L11
        r10.b(r5.getLong(f15459h));     // Catch: Exception -> L11
        if (r5.getInt(f15463l) == 0) goto L6;
        boolean r11 = true;
    L7:
        r10.f15828o = r11;     // Catch: Exception -> L11
        r10.f15839u = r5.getString(f15466o);     // Catch: Exception -> L11
        r10.f15843w = r5.getLong(L);     // Catch: Exception -> L11
        r10.U0 = r5.getString(E);     // Catch: Exception -> L11
        r10.X = r5.getLong(H);     // Catch: Exception -> L11
        String r12 = r5.getString(Q);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r12) == true) goto L13;
        r10.P = r12;     // Catch: Exception -> L11
        return r10;
    L13:
        r10.B();     // Catch: Exception -> L11
        r10.d();     // Catch: Exception -> L11
        r10.P = r10.T0.optString("monitor_scene");     // Catch: Exception -> L11
        return r10;
    L6:
        r11 = false;
    L11:
        e = move-exception;
        Context r13 = DownloadComponentManager.f15515a;
        Logger.c("SqlDownloadHelper", "parsePartialDownloadInfo", "Error:" + e);
        return r10;
    }

    public static void a(Cursor r5, DownloadInfo r10) {
        r10.f15814e0 = r5.getInt(f);     // Catch: Exception -> L35
        r10.a(r5.getLong(O));     // Catch: Exception -> L35
        r10.f15817h0 = r5.getLong(f15460i);     // Catch: Exception -> L35
        r10.F = r5.getString(f15461j);     // Catch: Exception -> L35
        boolean r11 = false;
        if (r5.getInt(f15462k) == 0) goto L5;
        boolean r12 = true;
    L6:
        r10.g = r12;     // Catch: Exception -> L35
        r10.f15824m = r5.getInt(f15464m);     // Catch: Exception -> L35
        r10.f15816h = r5.getString(f15465n);     // Catch: Exception -> L35
        if (r5.getInt(f15468q) == 0) goto L9;
        boolean r13 = true;
    L10:
        r10.f15837t = r13;     // Catch: Exception -> L35
        r10.f15813d0 = r5.getInt(f15469r);     // Catch: Exception -> L35
        if (r5.getInt(s) != 1) goto L13;
        boolean r14 = true;
    L14:
        r10.f15822k0 = r14;     // Catch: Exception -> L35
        if (r5.getInt(f15470t) != 1) goto L17;
        boolean r15 = true;
    L18:
        r10.l0 = r15;     // Catch: Exception -> L35
        if (r5.getInt(f15471u) != 1) goto L21;
        boolean r16 = true;
    L22:
        r10.f15841v = r16;     // Catch: Exception -> L35
        r10.f15825m0 = r5.getLong(f15472v);     // Catch: Exception -> L35
        r10.B = r5.getString(f15473w);     // Catch: Exception -> L35
        r10.C = r5.getString(f15474x);     // Catch: Exception -> L35
        r10.G = r5.getInt(f15475y);     // Catch: Exception -> L35
        if (r5.getInt(f15476z) != 1) goto L25;
        boolean r17 = true;
    L26:
        r10.E = r17;     // Catch: Exception -> L35
        r10.b(r5.getString(A));     // Catch: Exception -> L35
        r10.f15826n = r5.getInt(B);     // Catch: Exception -> L35
        r10.f15827n0 = r5.getLong(C);     // Catch: Exception -> L35
        r10.f15829o0 = r5.getLong(P);     // Catch: Exception -> L35
        if (r5.getInt(D) != 1) goto L29;
        boolean r18 = true;
    L30:
        r10.J = r18;     // Catch: Exception -> L35
        r10.M = r5.getString(F);     // Catch: Exception -> L35
        r10.H0 = r5.getInt(G);     // Catch: Exception -> L35
        r10.Y = r5.getLong(I);     // Catch: Exception -> L35
        r10.Z = r5.getLong(J);     // Catch: Exception -> L35
        if (r5.getInt(K) != 1) goto L33;
        r11 = true;
    L33:
        r10.f15806a0 = r11;     // Catch: Exception -> L35
        r10.f15849z = r5.getString(M);     // Catch: Exception -> L35
        r10.A = r5.getString(N);     // Catch: Exception -> L35
        return;
    L29:
        r18 = false;
        goto L30
    L25:
        r17 = false;
        goto L26
    L21:
        r16 = false;
        goto L22
    L17:
        r15 = false;
        goto L18
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
    L35:
        e = move-exception;
        Context r19 = DownloadComponentManager.f15515a;
        Logger.c("SqlDownloadHelper", "parseAllRemainingDownloadInfo", "Error:" + e);
    }
}
