package com.obric.oui.viewpager2.widget;

import android.view.View;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
final class d extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f14867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewPager2.g f14868b;

    d(LinearLayoutManager r1) {
        this.f14867a = r1;
    }

    ViewPager2.g a() {
        return this.f14868b;
    }

    @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
    public void a(int r1) {
    }

    @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
    public void a(int r5, float r6, int r7) {
        if (this.f14868b != null) goto L5;
        return;
    L5:
        float r8 = -r6;
        int r0 = 0;
    L7:
        if (r0 >= this.f14867a.x()) goto L13;
        View r1 = this.f14867a.i(r0);
        if (r1 == null) goto L12;
        this.f14868b.a(r1, (this.f14867a.d(r1) - r5) + r8);
        r0 = r0 + 1;
        goto L7
    L12:
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(r0), Integer.valueOf(this.f14867a.x())}));
    }

    void a(ViewPager2.g r3) {
        this.f14868b = (ViewPager2.g) ZeusTransformUtils.wrapperContextForParams(r3, ViewPager2.g.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
    public void b(int r1) {
    }
}
