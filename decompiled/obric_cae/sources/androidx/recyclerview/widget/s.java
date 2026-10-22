package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f2554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f2556c;

    public s(RecyclerView.o r8) {
        this.f2555b = Integer.MIN_VALUE;
        this.f2556c = new Rect();
        this.f2554a = r8;
    }

    public static s a(RecyclerView.o r8, int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L8;
        return new r(r8);
    L8:
        throw new IllegalArgumentException("invalid orientation");
    L10:
        return new q(r8);
    }

    public abstract int b(View r8);

    public abstract int c(View r8);

    public abstract int d(View r8);

    public abstract int e(View r8);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public final int m() {
        if (Integer.MIN_VALUE != this.f2555b) goto L6;
        return 0;
    L6:
        return l() - this.f2555b;
    }

    public abstract int n(View r8);

    public abstract int o(View r8);

    public abstract void p(int r8);
}
