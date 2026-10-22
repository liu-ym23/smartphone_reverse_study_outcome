package as9;

import android.content.Context;
import android.os.Build;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static Looper a;

    public static a a(int r2, Context r3) {
        if (r2 != 0) goto L6;
        return new yr9.b(r3, a);
    L6:
        if (r2 == 1) goto L8;
    L11:
        return null;
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L11;
        return new yr9.a(r3, a);
    }
}
