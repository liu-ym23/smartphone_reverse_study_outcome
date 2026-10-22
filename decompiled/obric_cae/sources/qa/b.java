package qa;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f10220a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f10221b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f10222c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, String> f10223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f10224e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f10225f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer f10226g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Integer f10227h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Integer f10228i = null;

    static {
        f10223d = new ConcurrentHashMap(8);
        f10224e = 1;
        f10225f = 2;
        f10226g = 3;
        f10227h = 4;
        f10228i = 5;
    }

    public static String a(String r8) {
        String r10 = "";
        ConcurrentHashMap<String, String> r11 = f10223d;     // Catch: Throwable -> L16
        monitor-enter(r11);     // Catch: Throwable -> L16
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L6:
        if (f10223d != null) goto L8;
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        goto L15
    L8:
        if (f10223d.containsKey(r8) == false) goto L10;
        r10 = f10223d.get(r8);     // Catch: Throwable -> L12
    L15:
        return r10;
    }

    public static void b(String r8, String r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L26;
        ConcurrentHashMap<String, String> r11 = f10223d;     // Catch: Throwable -> L21
        monitor-enter(r11);     // Catch: Throwable -> L21
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
        goto L27
    L10:
        if (f10223d != null) goto L13;
        f10223d = new ConcurrentHashMap(8);     // Catch: Throwable -> L17
    L13:
        if (f10223d.containsKey(r8) == true) goto L15;
        f10223d.put(r8, r10);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
        goto L27
    L26:
        return;
    }
}
