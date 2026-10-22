package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class x extends RecyclerView.l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2564g;

    public x() {
        this.f2564g = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean a(RecyclerView.c0 r10, RecyclerView.c0 r11, RecyclerView.l.c r12, RecyclerView.l.c r13) {
        int r8 = r12.f2310a;
        int r14 = r12.f2311b;
        if (r11.o() == false) goto L5;
        int r15 = r12.f2310a;
        int r16 = r12.f2311b;
        int r17 = r15;
    L6:
        k r18 = (k) this;
        if (r10 == r11) goto L11;
        float r19 = r10.f2281a.getTranslationX();
        View r110 = r10.f2281a;
        float r111 = r110.getTranslationY();
        float r20 = r110.getAlpha();
        r18.l(r10);
        r110.setTranslationX(r19);
        r110.setTranslationY(r111);
        r110.setAlpha(r20);
        r18.l(r11);
        View r112 = r11.f2281a;
        r112.setTranslationX(-((int) ((r17 - r8) - r19)));
        r112.setTranslationY(-((int) ((r16 - r14) - r111)));
        r112.setAlpha(0.0f);
        r18.f2471k.add(new k.a(r10, r11, r8, r14, r17, r16));
        return true;
    L11:
        return r18.g(r10, r8, r14, r17, r16);
    L5:
        r17 = r13.f2310a;
        r16 = r13.f2311b;
        goto L6
    }

    public abstract boolean g(RecyclerView.c0 r8, int r10, int r11, int r12, int r13);
}
