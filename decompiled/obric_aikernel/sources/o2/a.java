package o2;

import com.bytedance.frameworks.baselib.network.http.parser.MimeType;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f11391a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f11392b = false;

    static {
    }

    public a() {
    }

    public static long b() {
        return f11391a;
    }

    public static void c() {
        if (f11392b == false) goto L6;
        f11392b = false;
        f11391a++;
        return;
    }

    public static void d() {
        if (f11392b == true) goto L6;
        f11392b = true;
        f11391a++;
        return;
    }

    public static String e(String r10) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (com.bytedance.common.utility.g.b(r10) == true) goto L12;
        return new MimeType(r10).getBaseType();
    L12:
        return "";
    }
}
