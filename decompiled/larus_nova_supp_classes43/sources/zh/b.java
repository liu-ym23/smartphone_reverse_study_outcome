package zh;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public static int a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r0 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r0 > 0) goto L7;
        return 0;
    L7:
        return r10.getResources().getDimensionPixelSize(r0);
    }
}
