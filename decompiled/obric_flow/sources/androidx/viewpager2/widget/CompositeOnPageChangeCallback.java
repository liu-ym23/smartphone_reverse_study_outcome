package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    @NonNull
    private final List<ViewPager2.OnPageChangeCallback> mCallbacks;

    public CompositeOnPageChangeCallback(int r5) {
        this.mCallbacks = new ArrayList(r5);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException r5) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", r5);
    }

    public void addOnPageChangeCallback(ViewPager2.OnPageChangeCallback r5) {
        this.mCallbacks.add(r5);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int r5) {
        Iterator<ViewPager2.OnPageChangeCallback> r10 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r10.hasNext() == false) goto L14;
        r10.next().onPageScrollStateChanged(r5);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r5, float r10, @Px int r11) {
        Iterator<ViewPager2.OnPageChangeCallback> r12 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r12.hasNext() == false) goto L14;
        r12.next().onPageScrolled(r5, r10, r11);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int r5) {
        Iterator<ViewPager2.OnPageChangeCallback> r10 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r10.hasNext() == false) goto L14;
        r10.next().onPageSelected(r5);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    public void removeOnPageChangeCallback(ViewPager2.OnPageChangeCallback r5) {
        this.mCallbacks.remove(r5);
    }
}
