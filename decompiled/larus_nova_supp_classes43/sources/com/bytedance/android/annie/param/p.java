package com.bytedance.android.annie.param;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.util.t;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public final DisplayMetrics a;
    public final int b;
    public final DisplayMetrics c;
    public final int d;
    public final int e;

    public p(FragmentActivity r10) {
        com.bytedance.android.annie.util.p r0 = com.bytedance.android.annie.util.p.a;
        if (r10 == null) goto L5;
        Resources r1 = r10.getResources();
        DisplayMetrics r11 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    L6:
        if (r11 != null) goto L8;
        r11 = r0.b();
    L8:
        this.a = r11;
        this.b = -1;
        com.bytedance.android.annie.util.p.f();
        this.e = r0.getResources().getConfiguration().orientation;
        if (r10 == null) goto L12;
        this.b = r10.getRequestedOrientation();
        this.c = com.bytedance.android.annie.util.p.c(r10);
        this.d = t.a.e(r10);
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }
}
