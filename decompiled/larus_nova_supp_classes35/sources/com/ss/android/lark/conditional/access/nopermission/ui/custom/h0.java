package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h0 {
    public static final void a(TextView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setTypeface(b(r1.getContext(), r2));
    }

    public static final Typeface b(Context r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Typeface r0 = h18.e.a(r4);
        int r3 = 0;
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Typeface r6 = Typeface.create(r0, r5, false);
        Intrinsics.checkNotNull(r6);
        return r6;
    L6:
        if (r5 < 500) goto L9;
        r3 = 1;
    L9:
        return h18.e.b(r4, r3);
    }
}
