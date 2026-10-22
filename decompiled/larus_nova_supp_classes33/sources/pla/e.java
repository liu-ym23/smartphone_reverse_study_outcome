package pla;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    static {
    }

    public static boolean a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r2.getResources().getConfiguration().orientation != 2) goto L9;
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        wma.b.c("ResourceUtils", "isLandscape error", e);
        goto L9
    }
}
