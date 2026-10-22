package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class y extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f2565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2566b;

    public class a extends RecyclerView.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f2568b;

        public a(y r8) {
            this.f2568b = r8;
            this.f2567a = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public final void a(RecyclerView r8, int r10) {
            if (r10 == 0) goto L4;
            return;
        L4:
            if (this.f2567a == false) goto L8;
            this.f2567a = false;
            this.f2568b.b();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public final void b(RecyclerView r8, int r10, int r11) {
            if (r10 != 0) goto L4;
            if (r11 != 0) goto L4;
            return;
        L4:
            this.f2567a = true;
        }
    }

    public y() {
        this.f2566b = new a(this);
    }

    public abstract int[] a(RecyclerView.o r8, View r10);

    public final void b() {
        RecyclerView r8 = this.f2565a;
        if (r8 != null) goto L5;
        return;
    L5:
        RecyclerView.o r10 = r8.getLayoutManager();
        if (r10 != null) goto L8;
        return;
    L8:
        u r11 = (u) this;
        View r12 = null;
        if (r10.f() == false) goto L12;
        s r13 = r11.e(r10);
    L14:
        int r14 = r10.w();
        if (r14 == 0) goto L23;
        int r15 = (r13.l() / 2) + r13.k();
        int r16 = Integer.MAX_VALUE;
        int r17 = 0;
    L18:
        if (r17 >= r14) goto L23;
        View r18 = r10.v(r17);
        int r19 = Math.abs(((r13.c(r18) / 2) + r13.e(r18)) - r15);
        if (r19 >= r16) goto L22;
        r12 = r18;
        r16 = r19;
    L22:
        r17 = r17 + 1;
    L23:
        if (r12 != null) goto L25;
        return;
    L25:
        int[] r20 = a(r10, r12);
        int r21 = r20[0];
        if (r21 == 0) goto L28;
    L29:
        this.f2565a.smoothScrollBy(r21, r20[1]);
        return;
    L28:
        if (r20[1] != 0) goto L29;
        return;
    L12:
        if (r10.e() == false) goto L23;
        r13 = r11.d(r10);
        goto L14
    }
}
