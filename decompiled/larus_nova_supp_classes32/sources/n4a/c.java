package n4a;

import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static byte[] a;
    public static boolean b;
    public static boolean c;
    public static volatile ConcurrentHashMap<String, String> d;
    public static final Integer e = null;
    public static final Integer f = null;
    public static final Integer g = null;
    public static final Integer h = null;
    public static final Integer i = null;

    static {
        d = new ConcurrentHashMap(8);
        e = 1;
        f = 2;
        g = 3;
        h = 4;
        i = 5;
    }

    public static String a(String r3) {
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        ConcurrentHashMap<String, String> r1 = d;     // Catch: Throwable -> L16
        monitor-enter(r1);     // Catch: Throwable -> L16
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L6:
        if (d != null) goto L8;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        goto L15
    L8:
        if (d.containsKey(r3) == false) goto L10;
        r0 = d.get(r3);     // Catch: Throwable -> L12
    L15:
        return r0;
    }

    public static void b(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L26;
        ConcurrentHashMap<String, String> r0 = d;     // Catch: Throwable -> L21
        monitor-enter(r0);     // Catch: Throwable -> L21
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
        goto L27
    L10:
        if (d != null) goto L13;
        d = new ConcurrentHashMap(8);     // Catch: Throwable -> L17
    L13:
        if (d.containsKey(r3) == true) goto L15;
        d.put(r3, r4);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
        goto L27
    L26:
        return;
    }
}
