package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class t extends o {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ u f2557q;

    public t(u r8, Context r10) {
        this.f2557q = r8;
        super(r10);
    }

    @Override // androidx.recyclerview.widget.o, androidx.recyclerview.widget.RecyclerView.y
    public final void c(View r8, RecyclerView.y.a r10) {
        u r11 = this.f2557q;
        int[] r12 = r11.a(r11.f2565a.getLayoutManager(), r8);
        int r13 = r12[0];
        int r14 = r12[1];
        int r15 = (int) Math.ceil(((double) i(Math.max(Math.abs(r13), Math.abs(r14)))) / 0.3356d);
        if (r15 <= 0) goto L6;
        DecelerateInterpolator r16 = this.f2546j;
        r10.f2357a = r13;
        r10.f2358b = r14;
        r10.f2359c = r15;
        r10.f2361e = r16;
        r10.f2362f = true;
        return;
    }

    @Override // androidx.recyclerview.widget.o
    public final float h(DisplayMetrics r8) {
        return 100.0f / r8.densityDpi;
    }

    @Override // androidx.recyclerview.widget.o
    public final int i(int r8) {
        return Math.min(100, super.i(r8));
    }
}
