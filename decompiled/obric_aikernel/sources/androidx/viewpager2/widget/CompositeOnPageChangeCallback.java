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

    CompositeOnPageChangeCallback(int r10) {
        this.mCallbacks = new ArrayList(r10);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException r10) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", r10);
    }

    void addOnPageChangeCallback(ViewPager2.OnPageChangeCallback r10) {
        this.mCallbacks.add(r10);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int r10) {
        Iterator<ViewPager2.OnPageChangeCallback> r11 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r11.hasNext() == false) goto L14;
        r11.next().onPageScrollStateChanged(r10);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r10, float r11, @Px int r12) {
        Iterator<ViewPager2.OnPageChangeCallback> r13 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r13.hasNext() == false) goto L14;
        r13.next().onPageScrolled(r10, r11, r12);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int r10) {
        Iterator<ViewPager2.OnPageChangeCallback> r11 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r11.hasNext() == false) goto L14;
        r11.next().onPageSelected(r10);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    void removeOnPageChangeCallback(ViewPager2.OnPageChangeCallback r10) {
        this.mCallbacks.remove(r10);
    }
}
