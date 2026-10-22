package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final int a;
    public final float b;
    public final Context c;
    public final ba2.e d;

    public final Context getContext() {
        return this.c;
    }

    public c(Context r6, ba2.e r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "detector");
        this.c = r6;
        this.d = r7;
        Resources r8 = r6.getResources();
        int r0 = 0;
        if (r8 == null) goto L7;
        DisplayMetrics r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics());
        if (r9 == null) goto L7;
        int r10 = r9.heightPixels;
    L8:
        int r1 = r6.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r1 <= 0) goto L11;
        r0 = r6.getResources().getDimensionPixelSize(r1);
    L11:
        this.a = (r10 + r0) / 2;
        this.b = 0.3f;
        return;
    L7:
        r10 = 0;
        goto L8
    }
}
