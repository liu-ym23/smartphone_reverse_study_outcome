package com.obric.oui.viewpager2.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class b extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ViewPager2.e> f14864a;

    b(int r2) {
        this.f14864a = new ArrayList(r2);
    }

    private void a(ConcurrentModificationException r2) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", r2);
    }

    @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
    public void a(int r5) {
        Iterator<ViewPager2.e> r0 = this.f14864a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        ((ViewPager2.e) ZeusTransformUtils.preCheckCast(r0.next(), ViewPager2.e.class, "com.obric.memorydata.plugin")).a(r5);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        a(e);
    }

    @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
    public void a(int r5, float r6, int r7) {
        Iterator<ViewPager2.e> r0 = this.f14864a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        ((ViewPager2.e) ZeusTransformUtils.preCheckCast(r0.next(), ViewPager2.e.class, "com.obric.memorydata.plugin")).a(r5, r6, r7);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        a(e);
    }

    void a(ViewPager2.e r1) {
        this.f14864a.add(r1);
    }

    @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
    public void b(int r5) {
        Iterator<ViewPager2.e> r0 = this.f14864a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        ((ViewPager2.e) ZeusTransformUtils.preCheckCast(r0.next(), ViewPager2.e.class, "com.obric.memorydata.plugin")).b(r5);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        a(e);
    }

    void b(ViewPager2.e r1) {
        this.f14864a.remove(r1);
    }
}
