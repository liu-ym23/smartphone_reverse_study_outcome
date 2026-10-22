package androidx.viewpager2.widget;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> mTransformers;

    public CompositePageTransformer() {
        this.mTransformers = new ArrayList();
    }

    public void addTransformer(ViewPager2.PageTransformer r3) {
        ViewPager2.PageTransformer r4 = (ViewPager2.PageTransformer) ZeusTransformUtils.wrapperContextForParams(r3, ViewPager2.PageTransformer.class, "com.obric.memorydata.plugin");
        this.mTransformers.add(r4);
    }

    public void removeTransformer(ViewPager2.PageTransformer r3) {
        ViewPager2.PageTransformer r4 = (ViewPager2.PageTransformer) ZeusTransformUtils.wrapperContextForParams(r3, ViewPager2.PageTransformer.class, "com.obric.memorydata.plugin");
        this.mTransformers.remove(r4);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r4, float r5) {
        Iterator<ViewPager2.PageTransformer> r3 = this.mTransformers.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ViewPager2.PageTransformer) ZeusTransformUtils.preCheckCast(r3.next(), ViewPager2.PageTransformer.class, "com.obric.memorydata.plugin")).transformPage(r4, r5);
        goto L4
    }
}
