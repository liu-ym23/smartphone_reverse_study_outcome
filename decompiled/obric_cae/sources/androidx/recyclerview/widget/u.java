package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class u extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f2558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f2559d;

    public static int c(View r8, s r10) {
        int r11 = r10.e(r8);
        int r12 = (r10.c(r8) / 2) + r11;
        int r13 = r10.k();
        return r12 - ((r10.l() / 2) + r13);
    }

    @Override // androidx.recyclerview.widget.y
    public final int[] a(RecyclerView.o r8, View r10) {
        int[] r11 = new int[2];
        if (r8.e() == false) goto L5;
        r11[0] = c(r10, d(r8));
    L7:
        if (r8.f() == false) goto L9;
        r11[1] = c(r10, e(r8));
    L10:
        return r11;
    L9:
        r11[1] = 0;
        goto L10
    L5:
        r11[0] = 0;
        goto L7
    }

    public final s d(RecyclerView.o r8) {
        q r10 = this.f2559d;
        if (r10 != null) goto L5;
    L6:
        this.f2559d = new q(r8);
    L8:
        return this.f2559d;
    L5:
        if (r10.f2554a == r8) goto L8;
        goto L6
    }

    public final s e(RecyclerView.o r8) {
        r r10 = this.f2558c;
        if (r10 != null) goto L5;
    L6:
        this.f2558c = new r(r8);
    L8:
        return this.f2558c;
    L5:
        if (r10.f2554a == r8) goto L8;
        goto L6
    }
}
