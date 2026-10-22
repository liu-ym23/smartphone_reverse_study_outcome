package o0;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f11372a;

    static {
        f11372a = new a();
    }

    public static boolean a(String r10) {
        return f11372a.getLogTypeSwitch(r10);
    }

    public static boolean b(String r10) {
        return f11372a.b(r10);
    }

    public static boolean c(String r10) {
        return f11372a.d(r10);
    }

    public static boolean d(String r10, String r11) {
        return f11372a.a(r10, r11);
    }

    public static boolean e(String r10) {
        return f11372a.c(r10);
    }

    public static boolean f(String r10) {
        return f11372a.getServiceSwitch(r10);
    }

    public static void g(b r10) {
        f11372a = r10;
    }
}
