package y1c;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static b a;

    public static g5c.a a() {
        if (a != null) goto L16;
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (b.b != null) goto L9;
        b.b = new b();     // Catch: Throwable -> L12
    L9:
        b r1 = b.b;     // Catch: Throwable -> L12
        monitor-exit(b.class);
        a = r1;
    L16:
        return a;
    }

    public static <T> void b(String r2, String r3, T r4) {
        Log.e("SPHelperImpl", "save error name = " + r2 + ", type = " + r3 + ", t = " + r4);
    }
}
