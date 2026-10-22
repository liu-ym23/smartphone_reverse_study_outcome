package cy9;

import android.R;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        View r3 = r1.getRootView().findViewById(R.id.content);
        if (r3 == null) goto L5;
        int r4 = r3.getPaddingBottom();
    L7:
        return RangesKt.coerceAtLeast(r2 - r4, 0);
    L5:
        r4 = 0;
        goto L7
    }
}
