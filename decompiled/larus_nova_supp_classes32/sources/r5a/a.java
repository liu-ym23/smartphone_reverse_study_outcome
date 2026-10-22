package r5a;

import android.content.Context;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static Boolean a;

    public static boolean a(Context r2) {
        if (a != null) goto L9;
        new TTVideoEngine(r2.getApplicationContext(), 0).releaseAsync();     // Catch: Throwable -> L6
        a = Boolean.TRUE;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        a = Boolean.FALSE;
    L9:
        return a.booleanValue();
    }
}
