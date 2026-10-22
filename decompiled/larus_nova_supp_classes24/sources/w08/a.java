package w08;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;
import h18.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final void b(TextView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L5;
        int r3 = e.a;
        Typeface r4 = e.a(r1.getContext());
    L6:
        r1.setTypeface(r4);
        return;
    L5:
        int r0 = e.a;
        r4 = e.b(r1.getContext(), r2);
        goto L6
    }

    public static final void a(Paint r1, Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 != 0) goto L5;
        Typeface r4 = e.a(r2);
    L6:
        r1.setTypeface(r4);
        return;
    L5:
        r4 = e.b(r2, r3);
        goto L6
    }
}
