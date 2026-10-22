package com.obric.oui.orecyclerview.widget;

import android.database.Observable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        int r5 = ((Observable) this).mObservers.size() - 1;
    L3:
        if (r5 < 0) goto L8;
        RecyclerView r10 = ((s0) ((c0) ((Observable) this).mObservers.get(r5))).f13910a;
        r10.j(null);
        r10.f13729b0.e = true;
        r10.P(true);
        if (r10.d.g() == true) goto L7;
        r10.requestLayout();
    L7:
        r5 = r5 - 1;
        goto L3
    }

    public final void c(int r10, int r11) {
        int r5 = ((Observable) this).mObservers.size() - 1;
    L3:
        if (r5 < 0) goto L11;
        s0 r12 = (s0) ((c0) ((Observable) this).mObservers.get(r5));
        RecyclerView r13 = r12.f13910a;
        r13.j(null);
        b r14 = r13.d;
        r14.getClass();
        if (r10 == r11) goto L10;
        ArrayList r15 = r14.f13792b;
        r15.add(r14.h(8, r10, r11, null));
        r14.f |= 8;
        if (r15.size() != 1) goto L10;
        r12.a();
    L10:
        r5 = r5 - 1;
        goto L3
    }

    public final void d(int r10, int r11, Object r12) {
        int r5 = ((Observable) this).mObservers.size() - 1;
    L3:
        if (r5 < 0) goto L11;
        s0 r13 = (s0) ((c0) ((Observable) this).mObservers.get(r5));
        RecyclerView r14 = r13.f13910a;
        r14.j(null);
        b r15 = r14.d;
        if (r11 >= 1) goto L7;
        r15.getClass();
    L10:
        r5 = r5 - 1;
        goto L3
    L7:
        ArrayList r16 = r15.f13792b;
        r16.add(r15.h(4, r10, r11, r12));
        r15.f = 4 | r15.f;
        if (r16.size() != 1) goto L10;
        r13.a();
        goto L10
    }

    public final void e(int r10, int r11) {
        int r5 = ((Observable) this).mObservers.size() - 1;
    L3:
        if (r5 < 0) goto L11;
        s0 r12 = (s0) ((c0) ((Observable) this).mObservers.get(r5));
        RecyclerView r13 = r12.f13910a;
        r13.j(null);
        b r14 = r13.d;
        if (r11 >= 1) goto L7;
        r14.getClass();
    L10:
        r5 = r5 - 1;
        goto L3
    L7:
        ArrayList r15 = r14.f13792b;
        r15.add(r14.h(1, r10, r11, null));
        r14.f |= 1;
        if (r15.size() != 1) goto L10;
        r12.a();
        goto L10
    }

    public final void f(int r10, int r11) {
        int r5 = ((Observable) this).mObservers.size() - 1;
    L3:
        if (r5 < 0) goto L11;
        s0 r12 = (s0) ((c0) ((Observable) this).mObservers.get(r5));
        RecyclerView r13 = r12.f13910a;
        r13.j(null);
        b r14 = r13.d;
        if (r11 >= 1) goto L7;
        r14.getClass();
    L10:
        r5 = r5 - 1;
        goto L3
    L7:
        ArrayList r15 = r14.f13792b;
        r15.add(r14.h(2, r10, r11, null));
        r14.f |= 2;
        if (r15.size() != 1) goto L10;
        r12.a();
        goto L10
    }

    public final void g() {
        int r5 = ((Observable) this).mObservers.size() - 1;
    L3:
        if (r5 < 0) goto L13;
        RecyclerView r10 = ((s0) ((c0) ((Observable) this).mObservers.get(r5))).f13910a;
        if (r10.f13730c == null) goto L12;
        a0 r11 = r10.f13742l;
        if (r11 == null) goto L12;
        if (r11.canRestoreState() == false) goto L12;
        r10.requestLayout();
    L12:
        r5 = r5 - 1;
        goto L3
    }
}
