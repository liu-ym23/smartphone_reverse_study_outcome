package k2;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f10035a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f10036b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f10037c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f10038d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f10039e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f10040f = false;

    static {
    }

    public static boolean a() {
        return f10036b;
    }

    public static boolean b() {
        return f10037c;
    }

    public static boolean c() {
        return f10038d;
    }

    public static boolean d() {
        return f10035a;
    }

    public static boolean e() {
        return f10039e;
    }

    public static boolean f() {
        return f10040f;
    }

    public static void g(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        h();
        boolean r11 = false;
        if (r10.optInt("cookie_save_v2_enabled", 0) <= 0) goto L7;
        boolean r12 = true;
    L8:
        f10035a = r12;
        if (r10.optInt("cookie_backup_async_save_enabled", 0) <= 0) goto L11;
        boolean r13 = true;
    L12:
        f10036b = r13;
        if (r10.optInt("cookie_backup_disabled", 0) <= 0) goto L15;
        boolean r14 = true;
    L16:
        f10037c = r14;
        if (r10.optInt("cookie_batch", 0) <= 0) goto L19;
        boolean r15 = true;
    L20:
        f10038d = r15;
        if (r10.optInt("disable_cookie_share_host_match_fix", 0) <= 0) goto L23;
        boolean r16 = true;
    L24:
        f10039e = r16;
        if (r10.optInt("enable_flush_cookie_for_region", 0) <= 0) goto L27;
        r11 = true;
    L27:
        f10040f = r11;
        return;
    L23:
        r16 = false;
        goto L24
    L19:
        r15 = false;
        goto L20
    L15:
        r14 = false;
        goto L16
    L11:
        r13 = false;
        goto L12
    L7:
        r12 = false;
        goto L8
    }

    private static void h() {
        f10035a = false;
        f10036b = false;
        f10037c = false;
        f10038d = false;
        f10039e = false;
        f10040f = false;
    }
}
