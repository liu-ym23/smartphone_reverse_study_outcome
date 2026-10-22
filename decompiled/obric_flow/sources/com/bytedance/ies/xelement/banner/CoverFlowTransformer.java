package com.bytedance.ies.xelement.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class CoverFlowTransformer implements ViewPager.PageTransformer {
    public CoverFlowTransformer() {
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public final void transformPage(View r5, float r10) {
        ViewPager r11 = (ViewPager) r5.getParent();
        int r12 = (r5.getLeft() - r11.getPaddingLeft()) - r11.getScrollX();
        int r13 = (r11.getMeasuredWidth() - r11.getPaddingLeft()) - r11.getPaddingRight();
        if (r13 == 0) goto L5;
        float r14 = r12 / r13;
    L6:
        float r15 = Math.min(9.0f, Math.max(-9.0f, r14 * 9.0f));
        r5.setCameraDistance(1280.0f);
        r5.setRotationY(-r15);
        return;
    L5:
        r14 = 0.0f;
        goto L6
    }
}
