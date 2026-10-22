package e0;

import com.bytedance.apm6.foundation.UnSampleListener;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f8542a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f8544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f8545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile UnSampleListener f8546e;

    static {
    }

    public static void a(String r10, String r11) {
        if (f8542a == false) goto L8;
        c r12 = f8544c;
        if (r12 == null) goto L9;
        r12.e(r10, r11);
        return;
    L9:
        return;
    }

    public static void b(String r10, String r11) {
        if (f8543b == false) goto L8;
        c r12 = f8544c;
        if (r12 == null) goto L9;
        r12.i(r10, r11);
        return;
    L9:
        return;
    }

    public static c c() {
        return f8545d;
    }

    public static void d(String r10, String r11) {
        if (f8542a == false) goto L8;
        c r12 = f8544c;
        if (r12 == null) goto L9;
        r12.i(r10, r11);
        return;
    L9:
        return;
    }

    public static boolean e() {
        return f8543b;
    }

    public static boolean f() {
        if (f8546e == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static void g(String r10, String r11) {
        if (f8546e == null) goto L6;
        f8546e.onLog(r10, r11);
        return;
    }

    public static void h(c r10) {
        f8544c = r10;
        if (r10 == null) goto L6;
        f8542a = true;
        return;
    }

    public static void i(boolean r10) {
        f8542a = r10;
    }

    public static void j(UnSampleListener r10) {
        f8546e = r10;
    }
}
