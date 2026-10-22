package ms.bd.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class s1 {
    public static volatile p1 a;
    public static boolean b;

    public static void a(Context r16, Intent r17) {
        if (a == null) goto L5;
        return;
    L5:
        monitor-enter(p1.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L22;
        Bundle r2 = r17.getBundleExtra((String) p2.a(16777217, 0, 0, "d59b8b", new byte[]{121, 62, 92, 19, 56, 97, 98, 7}));     // Catch: Throwable -> L12
        Context r3 = BadParcelableCrashOptimizer.getContext();     // Catch: Throwable -> L12
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
        r2.setClassLoader(r3.getClassLoader());     // Catch: Throwable -> L12
    L14:
        if (r2 == null) goto L18;
        CharSequence r4 = r2.getCharSequence((String) p2.a(16777217, 0, 0, "37b310", new byte[]{35, 37, 1, 110, 42}));     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r4) == true) goto L18;
        String r5 = r4.toString();     // Catch: Throwable -> L12
    L21:
        a = new p1(r16, r5);     // Catch: Throwable -> L12
    L18:
        r5 = null;
    L22:
        monitor-exit(p1.class);     // Catch: Throwable -> L12
    }
}
