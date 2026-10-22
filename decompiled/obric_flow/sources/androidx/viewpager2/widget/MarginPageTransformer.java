package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(@Px int r5) {
        Preconditions.checkArgumentNonnegative(r5, "Margin must be non-negative");
        this.mMarginPx = r5;
    }

    private ViewPager2 requireViewPager(@NonNull View r5) {
        ViewParent r10 = r5.getParent();
        ViewParent r11 = r10.getParent();
        if ((r10 instanceof RecyclerView) == false) goto L9;
        if ((r11 instanceof ViewPager2) == false) goto L9;
        return (ViewPager2) r11;
    L9:
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View r5, float r10) {
        ViewPager2 r11 = requireViewPager(r5);
        float r12 = this.mMarginPx * r10;
        if (r11.getOrientation() == 0) goto L5;
        r5.setTranslationY(r12);
        return;
    L5:
        if (r11.isRtl() == false) goto L7;
        r12 = -r12;
    L7:
        r5.setTranslationX(r12);
    }
}
