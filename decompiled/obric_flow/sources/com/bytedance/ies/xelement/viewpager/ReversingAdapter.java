package com.bytedance.ies.xelement.viewpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import gs.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/ReversingAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "gs/f", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReversingAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PagerAdapter f6523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6524b;

    public ReversingAdapter(PagerAdapter r5) {
        Intrinsics.checkNotNullParameter(r5, "mDelegete");
        this.f6523a = r5;
        r5.registerDataSetObserver(new f(this));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r5, int r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r11, "object");
        boolean r12 = this.f6524b;
        PagerAdapter r13 = this.f6523a;
        if (r12 == false) goto L5;
        r10 = (r13.getCount() - r10) - 1;
    L5:
        r13.destroyItem(r5, r10, r11);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f6523a.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "object");
        PagerAdapter r10 = this.f6523a;
        int r11 = r10.getItemPosition(r5);
        if (this.f6524b == true) goto L5;
        return r11;
    L5:
        if (r11 != (-2)) goto L7;
        return -2;
    L7:
        if (r11 != (-1)) goto L9;
        return -2;
    L9:
        return (r10.getCount() - r11) - 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r5) {
        boolean r10 = this.f6524b;
        PagerAdapter r11 = this.f6523a;
        if (r10 == false) goto L6;
        r5 = (r11.getCount() - r5) - 1;
    L6:
        return r11.getPageTitle(r5);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final float getPageWidth(int r5) {
        boolean r10 = this.f6524b;
        PagerAdapter r11 = this.f6523a;
        if (r10 == false) goto L6;
        r5 = (r11.getCount() - r5) - 1;
    L6:
        return r11.getPageWidth(r5);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        boolean r11 = this.f6524b;
        PagerAdapter r12 = this.f6523a;
        if (r11 == false) goto L6;
        r10 = (r12.getCount() - r10) - 1;
    L6:
        return r12.instantiateItem(r5, r10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "o");
        return this.f6523a.isViewFromObject(r5, r10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r5, int r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r11, "object");
        boolean r12 = this.f6524b;
        PagerAdapter r13 = this.f6523a;
        if (r12 == false) goto L5;
        r10 = (r13.getCount() - r10) - 1;
    L5:
        r13.setPrimaryItem(r5, r10, r11);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(View r5, int r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r11, "object");
        boolean r12 = this.f6524b;
        PagerAdapter r13 = this.f6523a;
        if (r12 == false) goto L5;
        r10 = (r13.getCount() - r10) - 1;
    L5:
        r13.destroyItem(r5, r10, r11);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(View r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        boolean r11 = this.f6524b;
        PagerAdapter r12 = this.f6523a;
        if (r11 == false) goto L6;
        r10 = (r12.getCount() - r10) - 1;
    L6:
        return r12.instantiateItem(r5, r10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(View r5, int r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r11, "object");
        boolean r12 = this.f6524b;
        PagerAdapter r13 = this.f6523a;
        if (r12 == false) goto L5;
        r10 = (r13.getCount() - r10) - 1;
    L5:
        r13.setPrimaryItem(r5, r10, r11);
    }
}
