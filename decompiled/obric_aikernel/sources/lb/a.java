package lb;

import android.util.Log;
import com.ss.android.agilelogger.ALog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f10919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f10920b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f10921c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f10922d;

    /* JADX INFO: renamed from: lb.a$a, reason: collision with other inner class name */
    private static class C0234a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f10923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f10924b;

        C0234a() {
            com.ss.android.agilelogger.a r10 = ALog.sConfig;     // Catch: Throwable -> L5
            this.f10923a = ALog.class.getMethod("d", new Class[]{String.class, String.class});     // Catch: Throwable -> L5
            this.f10924b = ALog.class.getMethod("e", new Class[]{String.class, String.class});     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // lb.a.b
        public void a(String r10, String r11) {
            Method r12 = this.f10923a;     // Catch: Throwable -> L6
            if (r12 == null) goto L11;
            r12.invoke(null, new Object[]{r10, r11});     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // lb.a.b
        public void b(String r10, String r11) {
            Method r12 = this.f10924b;     // Catch: Throwable -> L6
            if (r12 == null) goto L11;
            r12.invoke(null, new Object[]{r10, r11});     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(String r10, String r11);

        public abstract void b(String r10, String r11);
    }

    static {
        f10919a = new Object();
    }

    public static boolean a() {
        if (f10921c > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(String r10, String r11, String r12) {
        if (d(r10, r11, r12) == true) goto L5;
        return;
    L5:
        if (f10921c > 3) goto L13;
        String r13 = String.format("[Downloader|Global|%s]", new Object[]{r10});
        String r14 = r11 + "|" + r12;
        Log.d(r13, r14);
        b r15 = f10922d;
        if (r15 == null) goto L12;
        r15.a(r13, r14);
        return;
    L12:
        return;
    }

    public static void c(String r10, String r11, String r12) {
        if (d(r10, r11, r12) == true) goto L5;
        return;
    L5:
        if (f10921c > 6) goto L13;
        String r13 = String.format("[Downloader|Global|%s]", new Object[]{r10});
        String r14 = r11 + "|" + r12;
        Log.e(r13, r14);
        b r15 = f10922d;
        if (r15 == null) goto L12;
        r15.b(r13, r14);
        return;
    L12:
        return;
    }

    private static boolean d(String r10, String r11, String r12) {
        if (r10 == null) goto L6;
        if (r11 == null) goto L6;
        if (r12 == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static void e(int r10) {
        Object r11 = f10919a;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f10920b == false) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        f10920b = true;     // Catch: Throwable -> L11
        f10921c = r10;     // Catch: Throwable -> L11
        f10922d = new C0234a();     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    public static void f(int r10) {
        Object r11 = f10919a;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f10920b == false) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        f10921c = r10;     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    public static void g(String r10, int r11, String r12, String r13) {
        if (d(r10, r12, r13) == true) goto L5;
        return;
    L5:
        if (f10921c > 3) goto L13;
        String r14 = String.format("[Downloader|%d|%s]", new Object[]{Integer.valueOf(r11), r10});
        String r15 = r12 + "|" + r13;
        Log.d(r14, r15);
        b r16 = f10922d;
        if (r16 == null) goto L12;
        r16.a(r14, r15);
        return;
    L12:
        return;
    }

    public static void h(String r10, int r11, String r12, String r13) {
        if (d(r10, r12, r13) == true) goto L5;
        return;
    L5:
        if (f10921c > 6) goto L13;
        String r14 = String.format("[Downloader|%d|%s]", new Object[]{Integer.valueOf(r11), r10});
        String r15 = r12 + "|" + r13;
        Log.e(r14, r15);
        b r16 = f10922d;
        if (r16 == null) goto L12;
        r16.b(r14, r15);
        return;
    L12:
        return;
    }
}
