package r81;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements ComponentCallbacks2 {
    public static WeakReference<a> a;
    public static final b b = null;

    public b() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    static {
        b = new b();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        WeakReference<a> r0 = a;
        if (r0 == null) goto L8;
        a r1 = r0.get();
        if (r1 == null) goto L9;
        r1.onLowMemory();
        return;
    L9:
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r2) {
        if (r2 != 5) goto L5;
    L9:
        WeakReference<a> r3 = a;
        if (r3 == null) goto L15;
        a r4 = r3.get();
        if (r4 == null) goto L16;
        r4.onLowMemory();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r2 == 10) goto L9;
        if (r2 == 15) goto L9;
    }
}
