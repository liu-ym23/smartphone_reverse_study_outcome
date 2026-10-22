package com.bytedance.android.livesdk.gamesticker.hok;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Paint r3, int r4) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        if (r4 <= 1000) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L18;
        if (r3 == null) goto L19;
        Typeface r0 = r3.getTypeface();
        Typeface r1 = r3.getTypeface();
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        r3.setTypeface(Typeface.create(r0, r4, r2));
        return;
    L12:
        if (r1.getStyle() != 2) goto L14;
        r2 = true;
        goto L15
    L19:
        return;
    }
}
