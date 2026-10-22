package com.obric.oui.calendar;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements ViewPager.PageTransformer {
    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public final void transformPage(View r5, float r10) {
        r5.setAlpha((float) Math.sqrt(1.0f - Math.abs(r10)));
    }
}
