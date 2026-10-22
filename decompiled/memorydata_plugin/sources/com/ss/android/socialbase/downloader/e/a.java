package com.ss.android.socialbase.downloader.e;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f15435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15436b = false;
    private static int c = 6;
    private static c d;
    private static b e;
    private static boolean f;
    private static Set g;
    private static Set h;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.e.a$a, reason: collision with other inner class name */
    private static class C0828a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f15437a;

        C0828a() {
            this.f15437a = ZeusTransformUtils.forName("com.ss.android.agilelogger.ALog", "com.obric.memorydata.plugin").getMethod("e", new Class[]{String.class, String.class});     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.e.a.c
        public void a(String r1, String r2) {
            b(r1, r2);
        }

        @Override // com.ss.android.socialbase.downloader.e.a.c
        public void b(String r4, String r5) {
            Method r3 = this.f15437a;     // Catch: Throwable -> L6
            if (r3 == null) goto L11;
            r3.invoke(null, new Object[]{r4, r5});     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public static abstract class b {
        public void a(String r1, String r2) {
        }
    }

    public static abstract class c {
        public c() {
        }

        public void a(String r1, String r2) {
        }

        public void b(String r1, String r2) {
        }
    }

    static {
        f15435a = new Object();
        g = new CopyOnWriteArraySet();
        h = new CopyOnWriteArraySet();
    }

    public static void a(int r2) {
        Object r0 = f15435a;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f15436b == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        c = r2;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public static void a(int r2, boolean r3, List<String> r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Object r0 = f15435a;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (f15436b == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L8:
        f15436b = true;     // Catch: Throwable -> L25
        c = r2;     // Catch: Throwable -> L25
        d = new C0828a();     // Catch: Throwable -> L25
        f = r3;     // Catch: Throwable -> L25
        if (r6 != null) goto L11;
    L16:
        if (r7 != null) goto L18;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L18:
        if (r7.isEmpty() == true) goto L23;
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L25
    L21:
        if (r8.hasNext() == false) goto L23;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        h.add(r9);     // Catch: Throwable -> L25
        goto L21
    L11:
        if (r6.isEmpty() == true) goto L16;
        Iterator r10 = r6.iterator();     // Catch: Throwable -> L25
    L14:
        if (r10.hasNext() == false) goto L16;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        g.add(r11);     // Catch: Throwable -> L25
        goto L14
    }

    public static void a(String r6, int r7, String r8, String r9) {
        a(r6, r7, null, r8, r9, false);
    }

    private static void a(String r2, int r3, String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (g.isEmpty() == false) goto L7;
        return;
    L7:
        if (g.contains(r4) == true) goto L9;
        return;
    L9:
        if (e(r2, r5, r6) == false) goto L19;
        b r0 = e;
        if (r0 == null) goto L18;
        r0.a("TaskReport", r2 + "|" + r3 + "|" + r4 + "|" + r5 + "|" + r6);
        return;
    L18:
        return;
    }

    public static void a(String r1, int r2, String r3, String r4, String r5, boolean r6) {
        if (e(r1, r4, r5) == true) goto L5;
        return;
    L5:
        if (r6 == false) goto L8;
        a(r1, r2, r3, r4, r5);
    L8:
        if (b() == false) goto L14;
        if (TextUtils.isEmpty(r3) == true) goto L14;
        c(r1, r2, r4, r5);
        return;
    L14:
        if (c <= 3) goto L16;
        return;
    L16:
        String r7 = String.format("[MNetDownloader|%d|%s]", new Object[]{Integer.valueOf(r2), r1});
        String r8 = r4 + "|" + r5;
        c r9 = d;
        if (r9 == null) goto L19;
        r9.a(r7, r8);
        return;
    L19:
        Log.d(r7, r8);
    }

    public static void a(String r6, DownloadInfo r7, String r8, String r9) {
        a(r6, r7.getId(), r7.getMonitorScene(), r8, r9, false);
    }

    public static void a(String r6, DownloadInfo r7, String r8, String r9, boolean r10) {
        a(r6, r7.getId(), r7.getMonitorScene(), r8, r9, r10);
    }

    public static void a(String r2, String r3, String r4) {
        if (e(r2, r3, r4) == true) goto L6;
        return;
    L6:
        if (b() == false) goto L10;
        c(r2, r3, r4);
        return;
    L10:
        if (c <= 3) goto L12;
        return;
    L12:
        String r5 = String.format("[MNetDownloader|Global|%s]", new Object[]{r2});
        String r6 = r3 + "|" + r4;
        c r7 = d;
        if (r7 == null) goto L15;
        r7.a(r5, r6);
        return;
    L15:
        Log.d(r5, r6);
    }

    public static boolean a() {
        if (c > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(DownloadInfo r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return a(r0.getMonitorScene());
    }

    public static boolean a(String r3) {
        if (h.isEmpty() == true) goto L13;
        if (h.contains(r3) == false) goto L13;
        if (c > 4) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (c > 3) goto L16;
        return true;
    L16:
        return false;
    }

    public static void b(String r3, int r4, String r5, String r6) {
        if (e(r3, r5, r6) == true) goto L5;
        return;
    L5:
        d(r3, r5, r4 + "|" + r6);
        if (b() == false) goto L10;
        c(r3, r4, r5, r6);
        return;
    L10:
        if (c <= 6) goto L12;
        return;
    L12:
        String r7 = String.format("[MNetDownloader|%d|%s]", new Object[]{Integer.valueOf(r4), r3});
        String r8 = r5 + "|" + r6;
        c r9 = d;
        if (r9 == null) goto L15;
        r9.b(r7, r8);
        return;
    L15:
        Log.e(r7, r8);
    }

    public static void b(String r2, String r3, String r4) {
        if (e(r2, r3, r4) == true) goto L5;
        return;
    L5:
        d(r2, r3, r4);
        if (b() == false) goto L10;
        c(r2, r3, r4);
        return;
    L10:
        if (c <= 6) goto L12;
        return;
    L12:
        String r5 = String.format("[MNetDownloader|Global|%s]", new Object[]{r2});
        String r6 = r3 + "|" + r4;
        c r7 = d;
        if (r7 == null) goto L15;
        r7.b(r5, r6);
        return;
    L15:
        Log.e(r5, r6);
    }

    public static boolean b() {
        if (c > 4) goto L5;
        return true;
    L5:
        return false;
    }

    private static void c(String r2, int r3, String r4, String r5) {
        if (e(r2, r4, r5) == true) goto L5;
        return;
    L5:
        String r6 = String.format("[MNetDownloader|%d|%s]", new Object[]{Integer.valueOf(r3), r2});
        String r7 = r4 + "|" + r5;
        c r8 = d;
        if (r8 == null) goto L8;
        r8.b(r6, r7);
        return;
    L8:
        Log.e(r6, r7);
    }

    private static void c(String r2, String r3, String r4) {
        if (e(r2, r3, r4) == true) goto L5;
        return;
    L5:
        if (c > 4) goto L14;
        String r5 = String.format("[MNetDownloader|Global|%s]", new Object[]{r2});
        String r6 = r3 + "|" + r4;
        c r7 = d;
        if (r7 == null) goto L10;
        r7.b(r5, r6);
        return;
    L10:
        Log.e(r5, r6);
        return;
    }

    private static void d(String r2, String r3, String r4) {
        if (f == true) goto L5;
        return;
    L5:
        if (e(r2, r3, r4) == false) goto L13;
        b r0 = e;
        if (r0 == null) goto L12;
        r0.a("GlobalReport", r2 + "|" + r3 + "|" + r4);
        return;
    L12:
        return;
    }

    private static boolean e(String r0, String r1, String r2) {
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        return true;
    L6:
        return false;
    }
}
