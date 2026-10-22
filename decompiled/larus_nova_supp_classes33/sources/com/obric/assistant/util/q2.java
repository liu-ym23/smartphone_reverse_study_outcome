package com.obric.assistant.util;

import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q2 {
    static {
    }

    public static void a(TextView r6) {
        Intrinsics.checkNotNullParameter(r6, "textView");
        Typeface r0 = r6.getTypeface();
        if (r0 != null) goto L5;
        r0 = Typeface.DEFAULT;
    L5:
        int r1 = 0;
        if (r0 == null) goto L8;
        int r2 = r0.getStyle();
    L10:
        if ((r2 & 2) == 0) goto L12;
        boolean r3 = true;
    L14:
        if (Build.VERSION.SDK_INT < 28) goto L16;
        Typeface r4 = Typeface.create(r0, 500, r3);
    L19:
        r6.setTypeface(r4);
        return;
    L16:
        if (r3 == false) goto L18;
        r1 = 2;
    L18:
        r4 = Typeface.create(r0, r1);
        goto L19
    L12:
        r3 = false;
        goto L14
    L8:
        r2 = 0;
        goto L10
    }
}
