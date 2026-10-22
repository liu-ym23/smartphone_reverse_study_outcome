package com.obric.memorydata.recommend.settings;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/settings/DepthPageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "<init>", "()V", "minScale", "", "transformPage", "", "view", "Landroid/view/View;", "position", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DepthPageTransformer implements ViewPager2.PageTransformer {
    private final float minScale;

    public DepthPageTransformer() {
        this.minScale = 0.75f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r5, float r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        int r0 = r5.getWidth();
        if (r6 >= (-1.0f)) goto L6;
    L4:
        r5.setAlpha(0.0f);
        return;
    L6:
        if (r6 > 0.0f) goto L9;
        r5.setAlpha(1.0f);
        r5.setTranslationX(0.0f);
        r5.setScaleX(1.0f);
        r5.setScaleY(1.0f);
        return;
    L9:
        if (r6 > 1.0f) goto L4;
        float r1 = 1;
        r5.setAlpha(r1 - r6);
        r5.setTranslationX(r0 * (-r6));
        float r4 = this.minScale;
        float r7 = r4 + ((r1 - r4) * (r1 - Math.abs(r6)));
        r5.setScaleX(r7);
        r5.setScaleY(r7);
    }
}
