package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    PageTransformerAdapter(LinearLayoutManager r10) {
        this.mLayoutManager = r10;
    }

    ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int r10) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r10, float r11, int r12) {
        if (this.mPageTransformer != null) goto L5;
        return;
    L5:
        float r13 = -r11;
        int r14 = 0;
    L7:
        if (r14 >= this.mLayoutManager.getChildCount()) goto L13;
        View r15 = this.mLayoutManager.getChildAt(r14);
        if (r15 == null) goto L12;
        this.mPageTransformer.transformPage(r15, (this.mLayoutManager.getPosition(r15) - r10) + r13);
        r14 = r14 + 1;
        goto L7
    L12:
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(r14), Integer.valueOf(this.mLayoutManager.getChildCount())}));
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int r10) {
    }

    void setPageTransformer(@Nullable ViewPager2.PageTransformer r10) {
        this.mPageTransformer = r10;
    }
}
