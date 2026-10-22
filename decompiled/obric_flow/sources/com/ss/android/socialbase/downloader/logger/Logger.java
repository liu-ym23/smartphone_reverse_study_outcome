package com.ss.android.socialbase.downloader.logger;

import ai.j0;
import android.text.TextUtils;
import android.util.Log;
import com.lynx.tasm.utils.k;
import com.ss.android.agilelogger.ALog;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import xs.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f15791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f15792b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f15793c = 6;
    public static ILogWritter d;
    public static final CopyOnWriteArraySet e = null;
    public static final CopyOnWriteArraySet f = null;

    public static class ALogHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f15794a = null;

        static {
            b r5 = ALog.sConfig;     // Catch: Throwable -> L4
            Method r10 = ALog.class.getMethod("e", new Class[]{String.class, String.class});     // Catch: Throwable -> L4
        L6:
            f15794a = r10;
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
            r10 = null;
            goto L6
        }
    }

    public static class AlogHandler extends ILogWritter {
        public AlogHandler() {
        }
    }

    public static abstract class ILogWritter {
        public ILogWritter() {
        }
    }

    static {
        f15791a = new Object();
        e = new CopyOnWriteArraySet();
        f = new CopyOnWriteArraySet();
    }

    public static void a(String r5, String r10) {
        Method r11 = ALogHolder.f15794a;     // Catch: Throwable -> L6
        if (r11 == null) goto L11;
        r11.invoke(null, new Object[]{r5, r10});     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean b() {
        if (f15793c > 3) goto L6;
        return true;
    L6:
        return false;
    }

    public static void c(String r5, String r10, String r11) {
        if (d(r5, r10, r11) == true) goto L6;
        return;
    L6:
        if (a() == false) goto L10;
        a(r5, r10, r11);
        return;
    L10:
        if (f15793c <= 6) goto L12;
        return;
    L12:
        String r12 = j0.k("[MNetDownloader|Global|", r5, "]");
        String r13 = k.j(r10, "|", r11);
        if (d == null) goto L16;
        a(r12, r13);
        return;
    L16:
        Log.e(r12, r13);
    }

    public static boolean d(String r5, String r10, String r11) {
        if (r11 == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(String r5, String r10, String r11) {
        if (d(r5, r10, r11) == true) goto L6;
        return;
    L6:
        if (a() == false) goto L10;
        a(r5, r10, r11);
        return;
    L10:
        if (f15793c <= 3) goto L12;
        return;
    L12:
        String r12 = j0.k("[MNetDownloader|Global|", r5, "]");
        String r13 = k.j(r10, "|", r11);
        if (d == null) goto L16;
        a(r12, r13);
        return;
    L16:
        Log.d(r12, r13);
    }

    public static boolean a() {
        if (f15793c > 4) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean a(String r5) {
        CopyOnWriteArraySet r10 = f;
        if (r10.isEmpty() == true) goto L12;
        if (r10.contains(r5) == false) goto L12;
        if (f15793c > 4) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (f15793c > 3) goto L14;
        return true;
    L14:
        return false;
    }

    public static void a(String r5, String r10, String r11) {
        if (d(r5, r10, r11) == true) goto L5;
        return;
    L5:
        if (f15793c > 4) goto L14;
        String r12 = j0.k("[MNetDownloader|Global|", r5, "]");
        String r13 = k.j(r10, "|", r11);
        if (d == null) goto L11;
        a(r12, r13);
        return;
    L11:
        Log.e(r12, r13);
        return;
    }

    public static void a(String r10, DownloadInfo r11, String r12, String r13) {
        a(r10, r11.l(), r11.P, r12, r13, false);
    }

    public static void a(String r5, int r10, String r11, String r12, String r13, boolean r14) {
        if (d(r5, r12, r13) == false) goto L33;
        if (r14 == false) goto L12;
        if (TextUtils.isEmpty(r11) == true) goto L12;
        CopyOnWriteArraySet r15 = e;
        if (r15.isEmpty() == true) goto L12;
        r15.contains(r11);
    L12:
        if (a() == false) goto L25;
        if (TextUtils.isEmpty(r11) == true) goto L25;
        if (d(r5, r12, r13) == false) goto L34;
        String r16 = String.format("[MNetDownloader|%d|%s]", new Object[]{Integer.valueOf(r10), r5});
        String r17 = k.j(r12, "|", r13);
        if (d == null) goto L22;
        a(r16, r17);
        return;
    L22:
        Log.e(r16, r17);
        return;
    L34:
        return;
    L25:
        if (f15793c <= 3) goto L27;
        return;
    L27:
        String r18 = String.format("[MNetDownloader|%d|%s]", new Object[]{Integer.valueOf(r10), r5});
        String r19 = k.j(r12, "|", r13);
        if (d == null) goto L31;
        a(r18, r19);
        return;
    L31:
        Log.d(r18, r19);
        return;
    }

    public static void a(String r5, int r10, String r11, String r12) {
        if (d(r5, r11, r12) == true) goto L6;
        return;
    L6:
        if (a() == false) goto L17;
        if (d(r5, r11, r12) == false) goto L26;
        String r13 = String.format("[MNetDownloader|%d|%s]", new Object[]{Integer.valueOf(r10), r5});
        String r14 = k.j(r11, "|", r12);
        if (d == null) goto L14;
        a(r13, r14);
        return;
    L14:
        Log.e(r13, r14);
        return;
    L26:
        return;
    L17:
        if (f15793c <= 6) goto L19;
        return;
    L19:
        String r15 = String.format("[MNetDownloader|%d|%s]", new Object[]{Integer.valueOf(r10), r5});
        String r16 = k.j(r11, "|", r12);
        if (d == null) goto L23;
        a(r15, r16);
        return;
    L23:
        Log.e(r15, r16);
    }

    public static void a(int r5, boolean r10, ArrayList r11, ArrayList r12) {
        Object r13 = f15791a;
        monitor-enter(r13);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (f15792b == false) goto L10;
        monitor-exit(r13);     // Catch: Throwable -> L8
        return;
    L10:
        f15792b = true;     // Catch: Throwable -> L8
        f15793c = r5;     // Catch: Throwable -> L8
        d = new AlogHandler();     // Catch: Throwable -> L8
        if (r11.isEmpty() == true) goto L17;
        Iterator r14 = r11.iterator();     // Catch: Throwable -> L8
    L14:
        if (r14.hasNext() == false) goto L17;
        String r15 = (String) r14.next();     // Catch: Throwable -> L8
        e.add(r15);     // Catch: Throwable -> L8
    L17:
        if (r12.isEmpty() == true) goto L22;
        Iterator r16 = r12.iterator();     // Catch: Throwable -> L8
    L20:
        if (r16.hasNext() == false) goto L22;
        String r17 = (String) r16.next();     // Catch: Throwable -> L8
        f.add(r17);     // Catch: Throwable -> L8
    L22:
        monitor-exit(r13);     // Catch: Throwable -> L8
    }

    public static boolean a(DownloadInfo r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        return a(r5.P);
    }
}
