package k5;

import android.os.SystemProperties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f8952a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f8953b = null;

    static {
        f8952a = new m();
        f8953b = new ConcurrentHashMap();
    }

    public static Object a(String r8) {
        ConcurrentHashMap r10 = f8953b;
        Object r11 = r10.get(r8);
        if (r11 == null) goto L5;
        return r11;
    L5:
        f8952a.getClass();
        String r12 = SystemProperties.get(r8);     // Catch: Throwable -> L8
    L15:
        if (r12 == null) goto L17;
        r10.put(r8, r12);
    L17:
        return r12;
    L8:
        th = move-exception;
        th.printStackTrace();
        Object r13 = m.a();     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r12 = (String) r13.getClass().getMethod("get", new Class[]{String.class}).invoke(r13, new Object[]{r8});     // Catch: IllegalArgumentException -> L12 Throwable -> L14
    L12:
        e = move-exception;
        throw e;
    L14:
        r12 = "";
        goto L15
    }
}
