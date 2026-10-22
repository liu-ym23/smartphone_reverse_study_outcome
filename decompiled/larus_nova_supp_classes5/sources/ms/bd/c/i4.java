package ms.bd.c;

import android.content.Context;
import android.webkit.WebSettings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class i4 {
    public static String a;

    public static synchronized String a(Context r2) {
        monitor-enter(i4.class);
        String r1 = a;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(i4.class);
        return r1;
    L8:
        String r3 = WebSettings.getDefaultUserAgent(r2);     // Catch: Throwable -> L11
        a = r3;     // Catch: Throwable -> L11
        monitor-exit(i4.class);
        return r3;
    L11:
        th = move-exception;
        throw th;
    }
}
