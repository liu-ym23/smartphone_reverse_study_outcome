package com.obric.memorydata.recommend.settings;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ZoomOutPageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "<init>", "()V", "minScale", "", "minAlpha", "transformPage", "", "view", "Landroid/view/View;", "position", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
    private final float minAlpha;
    private final float minScale;

    public ZoomOutPageTransformer() {
        this.minScale = 0.85f;
        this.minAlpha = 0.5f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r8, float r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        int r0 = r8.getWidth();
        int r1 = r8.getHeight();
        if (r9 >= (-1.0f)) goto L6;
    L4:
        r8.setAlpha(0.0f);
        return;
    L6:
        if (r9 > 1.0f) goto L4;
        float r4 = 1;
        float r2 = Math.max(this.minScale, r4 - Math.abs(r9));
        float r5 = r4 - r2;
        float r6 = 2;
        float r3 = (r0 * r5) / r6;
        float r7 = ((r1 * r5) / r6) / r6;
        if (r9 >= 0.0f) goto L10;
        float r10 = r3 - r7;
    L11:
        r8.setTranslationX(r10);
        r8.setScaleX(r2);
        r8.setScaleY(r2);
        float r11 = this.minAlpha;
        float r12 = this.minScale;
        r8.setAlpha(r11 + (((r2 - r12) / (r4 - r12)) * (r4 - r11)));
        return;
    L10:
        r10 = r3 + r7;
        goto L11
    }
}
