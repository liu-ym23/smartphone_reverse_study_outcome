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

    public MarginPageTransformer(@Px int r10) {
        Preconditions.checkArgumentNonnegative(r10, "Margin must be non-negative");
        this.mMarginPx = r10;
    }

    private ViewPager2 requireViewPager(@NonNull View r10) {
        ViewParent r11 = r10.getParent();
        ViewParent r12 = r11.getParent();
        if ((r11 instanceof RecyclerView) == false) goto L9;
        if ((r12 instanceof ViewPager2) == false) goto L9;
        return (ViewPager2) r12;
    L9:
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View r10, float r11) {
        ViewPager2 r12 = requireViewPager(r10);
        float r13 = this.mMarginPx * r11;
        if (r12.getOrientation() == 0) goto L5;
        r10.setTranslationY(r13);
        return;
    L5:
        if (r12.isRtl() == false) goto L7;
        r13 = -r13;
    L7:
        r10.setTranslationX(r13);
    }
}
