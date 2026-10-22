package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> mTransformers;

    public CompositePageTransformer() {
        this.mTransformers = new ArrayList();
    }

    public void addTransformer(@NonNull ViewPager2.PageTransformer r10) {
        this.mTransformers.add(r10);
    }

    public void removeTransformer(@NonNull ViewPager2.PageTransformer r10) {
        this.mTransformers.remove(r10);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View r10, float r11) {
        Iterator<ViewPager2.PageTransformer> r12 = this.mTransformers.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().transformPage(r10, r11);
        goto L4
    }
}
