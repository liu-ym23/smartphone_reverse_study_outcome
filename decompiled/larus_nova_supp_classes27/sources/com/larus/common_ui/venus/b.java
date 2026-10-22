package com.larus.common_ui.venus;

import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final void a(View r8, a.C0014a r9) {
        a r0 = new a(r9);
        LayerDrawable r10 = new LayerDrawable(new a[]{r0});
        r10.setLayerInset(0, (int) r0.b, (int) r0.d, (int) r0.c, (int) r0.e);
        r8.setBackground(r10);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return;
    L5:
        if (r0.getPaint() == null) goto L9;
        r8.setLayerType(1, r0.getPaint());
        return;
    }
}
