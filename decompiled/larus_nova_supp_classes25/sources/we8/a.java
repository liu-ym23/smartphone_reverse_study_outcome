package we8;

import android.widget.TextView;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final float a(int r0, boolean r1) {
        float r2 = r0;
        if (r1 == true) goto L7;
        Lazy r3 = e.a;
        return r2 + c7.c(Integer.valueOf(e.b(e.d)));
    L7:
        return r2;
    }

    public static void b(TextView r2, float r3, boolean r4, Float r5, Float r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = null;
    L8:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r4 == true) goto L12;
        Lazy r8 = e.a;
        r3 = r3 + c7.c(Integer.valueOf(e.b(e.d)));
    L12:
        if (r5 == null) goto L15;
        r3 = Math.max(r3, r5.floatValue());
    L15:
        if (r6 == null) goto L18;
        r3 = Math.min(r3, r6.floatValue());
    L18:
        r2.setTextSize(0, r3);
    }
}
