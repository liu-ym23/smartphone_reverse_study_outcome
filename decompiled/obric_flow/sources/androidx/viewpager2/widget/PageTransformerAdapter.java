package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    public PageTransformerAdapter(LinearLayoutManager r5) {
        this.mLayoutManager = r5;
    }

    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int r5) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r5, float r10, int r11) {
        if (this.mPageTransformer != null) goto L5;
        return;
    L5:
        float r12 = -r10;
        int r13 = 0;
    L7:
        if (r13 >= this.mLayoutManager.getChildCount()) goto L13;
        View r14 = this.mLayoutManager.getChildAt(r13);
        if (r14 == null) goto L11;
        this.mPageTransformer.transformPage(r14, (this.mLayoutManager.getPosition(r14) - r5) + r12);
        r13 = r13 + 1;
        goto L7
    L11:
        Locale r15 = Locale.US;
        throw new IllegalStateException("LayoutManager returned a null child at pos " + r13 + "/" + this.mLayoutManager.getChildCount() + " while transforming pages");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int r5) {
    }

    public void setPageTransformer(@Nullable ViewPager2.PageTransformer r5) {
        this.mPageTransformer = r5;
    }
}
