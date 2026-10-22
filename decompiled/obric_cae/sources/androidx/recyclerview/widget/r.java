package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class r extends s {
    @Override // androidx.recyclerview.widget.s
    public final int b(View r8) {
        RecyclerView.p r10 = (RecyclerView.p) r8.getLayoutParams();
        this.f2554a.getClass();
        return (r8.getBottom() + ((RecyclerView.p) r8.getLayoutParams()).mDecorInsets.bottom) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int c(View r8) {
        RecyclerView.p r10 = (RecyclerView.p) r8.getLayoutParams();
        this.f2554a.getClass();
        Rect r11 = ((RecyclerView.p) r8.getLayoutParams()).mDecorInsets;
        return (((r8.getMeasuredHeight() + r11.top) + r11.bottom) + ((ViewGroup.MarginLayoutParams) r10).topMargin) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int d(View r8) {
        RecyclerView.p r10 = (RecyclerView.p) r8.getLayoutParams();
        this.f2554a.getClass();
        Rect r11 = ((RecyclerView.p) r8.getLayoutParams()).mDecorInsets;
        return (((r8.getMeasuredWidth() + r11.left) + r11.right) + ((ViewGroup.MarginLayoutParams) r10).leftMargin) + ((ViewGroup.MarginLayoutParams) r10).rightMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int e(View r8) {
        RecyclerView.p r10 = (RecyclerView.p) r8.getLayoutParams();
        this.f2554a.getClass();
        return (r8.getTop() - ((RecyclerView.p) r8.getLayoutParams()).mDecorInsets.top) - ((ViewGroup.MarginLayoutParams) r10).topMargin;
    }

    @Override // androidx.recyclerview.widget.s
    public final int f() {
        return this.f2554a.f2327o;
    }

    @Override // androidx.recyclerview.widget.s
    public final int g() {
        RecyclerView.o r8 = this.f2554a;
        return r8.f2327o - r8.C();
    }

    @Override // androidx.recyclerview.widget.s
    public final int h() {
        return this.f2554a.C();
    }

    @Override // androidx.recyclerview.widget.s
    public final int i() {
        return this.f2554a.f2325m;
    }

    @Override // androidx.recyclerview.widget.s
    public final int j() {
        return this.f2554a.f2324l;
    }

    @Override // androidx.recyclerview.widget.s
    public final int k() {
        return this.f2554a.F();
    }

    @Override // androidx.recyclerview.widget.s
    public final int l() {
        RecyclerView.o r8 = this.f2554a;
        return (r8.f2327o - r8.F()) - r8.C();
    }

    @Override // androidx.recyclerview.widget.s
    public final int n(View r8) {
        RecyclerView.o r10 = this.f2554a;
        Rect r11 = this.f2556c;
        r10.J(r8, r11);
        return r11.bottom;
    }

    @Override // androidx.recyclerview.widget.s
    public final int o(View r8) {
        RecyclerView.o r10 = this.f2554a;
        Rect r11 = this.f2556c;
        r10.J(r8, r11);
        return r11.top;
    }

    @Override // androidx.recyclerview.widget.s
    public final void p(int r8) {
        this.f2554a.O(r8);
    }
}
