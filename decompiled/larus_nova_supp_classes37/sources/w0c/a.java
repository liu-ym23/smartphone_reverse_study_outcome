package w0c;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final List<Bundle> a = null;

    static {
        a = new ArrayList();
        int r0 = 0;
    L4:
        if (r0 >= 3) goto L6;
        a.add(new Bundle());
        r0 = r0 + 1;
        goto L4
    }

    public static synchronized Bundle a() {
        monitor-enter(a.class);
        int r1 = 0;
    L6:
        if (r1 >= 3) goto L13;
        List<Bundle> r2 = a;     // Catch: Throwable -> L16
        if (((Bundle) ListProtector.get(r2, r1)).isEmpty() == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        Bundle r3 = (Bundle) ListProtector.get(r2, r1);     // Catch: Throwable -> L16
        monitor-exit(a.class);
        return r3;
    L16:
        th = move-exception;
        throw th;
    L13:
        Log.w("BundlePool", "<create new bundle object>");     // Catch: Throwable -> L16
        Bundle r4 = new Bundle();     // Catch: Throwable -> L16
        monitor-exit(a.class);
        return r4;
    }
}
