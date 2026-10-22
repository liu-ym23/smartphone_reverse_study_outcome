package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static int a(RecyclerView.z r8, s r10, View r11, View r12, RecyclerView.o r13, boolean r14) {
        if (r13.w() != 0) goto L5;
        return 0;
    L5:
        if (r8.b() == 0) goto L16;
        if (r11 == null) goto L17;
        if (r12 == null) goto L18;
        if (r14 == false) goto L11;
        int r15 = r10.b(r12) - r10.e(r11);
        return Math.min(r10.l(), r15);
    L11:
        return Math.abs(RecyclerView.o.G(r11) - RecyclerView.o.G(r12)) + 1;
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static int b(RecyclerView.z r8, s r10, View r11, View r12, RecyclerView.o r13, boolean r14, boolean r15) {
        if (r13.w() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r8.b() == 0) goto L17;
        if (r11 == null) goto L17;
        if (r12 == null) goto L17;
        int r16 = Math.min(RecyclerView.o.G(r11), RecyclerView.o.G(r12));
        int r17 = Math.max(RecyclerView.o.G(r11), RecyclerView.o.G(r12));
        if (r15 == false) goto L12;
        int r18 = Math.max(0, (r8.b() - r17) - 1);
    L13:
        if (r14 == true) goto L16;
        return r18;
    L16:
        return Math.round((r18 * (Math.abs(r10.b(r12) - r10.e(r11)) / (Math.abs(RecyclerView.o.G(r11) - RecyclerView.o.G(r12)) + 1))) + (r10.k() - r10.e(r11)));
    L12:
        r18 = Math.max(0, r16);
        goto L13
    }

    public static int c(RecyclerView.z r8, s r10, View r11, View r12, RecyclerView.o r13, boolean r14) {
        if (r13.w() != 0) goto L5;
        return 0;
    L5:
        if (r8.b() == 0) goto L16;
        if (r11 == null) goto L17;
        if (r12 == null) goto L18;
        if (r14 == true) goto L13;
        return r8.b();
    L13:
        return (int) (((r10.b(r12) - r10.e(r11)) / (Math.abs(RecyclerView.o.G(r11) - RecyclerView.o.G(r12)) + 1)) * r8.b());
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }
}
