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

    public void addTransformer(@NonNull ViewPager2.PageTransformer r5) {
        this.mTransformers.add(r5);
    }

    public void removeTransformer(@NonNull ViewPager2.PageTransformer r5) {
        this.mTransformers.remove(r5);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View r5, float r10) {
        Iterator<ViewPager2.PageTransformer> r11 = this.mTransformers.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().transformPage(r5, r10);
        goto L4
    }
}
