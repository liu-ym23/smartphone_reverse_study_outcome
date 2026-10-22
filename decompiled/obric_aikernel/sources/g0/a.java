package g0;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f8906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f8907b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f8908c = false;

    /* JADX INFO: renamed from: g0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0170a {
    }

    public interface b {
        void a();
    }

    public interface c {
        void a(InterfaceC0170a r10);
    }

    static {
    }

    public static void a(InterfaceC0170a r10) {
        c r11 = f8906a;
        if (r11 == null) goto L6;
        r11.a(r10);
        return;
    }

    public static void b() {
        if (f8908c == false) goto L5;
        return;
    L5:
        b r10 = f8907b;
        if (r10 == null) goto L9;
        r10.a();
        f8908c = true;
        return;
    }
}
