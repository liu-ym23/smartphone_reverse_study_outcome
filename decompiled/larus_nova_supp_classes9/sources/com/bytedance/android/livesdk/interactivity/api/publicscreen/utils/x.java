package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spanned;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x {
    public static final Object[] a(Spanned r1, int r2, Class r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        if (r1 != null) goto L6;
        return null;
    L6:
        Object[] r4 = r1.getSpans(0, r2, r3);
        if (r4 == null) goto L9;
        Arrays.sort(r4, new w(r1));
    L9:
        return r4;
    }
}
