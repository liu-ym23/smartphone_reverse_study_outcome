package com.lynx.tasm.behavior.ui.swiper;

import android.view.View;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements ViewPager.e {
    public b() {
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.e
    public final void a(View r2) {
        if (r2 == null) goto L5;
        r2.setRotationX(0.0f);
        r2.setRotationY(0.0f);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.e
    public final void b(ViewPager r2, View r3, boolean r4, int r5) {
        if (r2 == null) goto L12;
        int r6 = r2.getChildExpectSize();
        if (r6 == 0) goto L6;
        float r7 = r5 / r6;
    L7:
        float r8 = MathUtils.clamp(r7 * 9.0f, -9.0f, 9.0f);
        r3.setCameraDistance(1280.0f);
        if (r4 == false) goto L10;
        r3.setRotationX(r8);
        return;
    L10:
        r3.setRotationY(-r8);
        return;
    L6:
        r7 = 0.0f;
        goto L7
    }
}
