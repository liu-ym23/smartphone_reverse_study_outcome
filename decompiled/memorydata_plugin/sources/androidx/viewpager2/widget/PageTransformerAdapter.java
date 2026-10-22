package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    PageTransformerAdapter(LinearLayoutManager r1) {
        this.mLayoutManager = r1;
    }

    ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int r1) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r5, float r6, int r7) {
        if (this.mPageTransformer != null) goto L5;
        return;
    L5:
        float r8 = -r6;
        int r0 = 0;
    L7:
        if (r0 >= this.mLayoutManager.getChildCount()) goto L13;
        View r1 = this.mLayoutManager.getChildAt(r0);
        if (r1 == null) goto L12;
        this.mPageTransformer.transformPage(r1, (this.mLayoutManager.getPosition(r1) - r5) + r8);
        r0 = r0 + 1;
        goto L7
    L12:
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(r0), Integer.valueOf(this.mLayoutManager.getChildCount())}));
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int r1) {
    }

    void setPageTransformer(ViewPager2.PageTransformer r3) {
        this.mPageTransformer = (ViewPager2.PageTransformer) ZeusTransformUtils.wrapperContextForParams(r3, ViewPager2.PageTransformer.class, "com.obric.memorydata.plugin");
    }
}
