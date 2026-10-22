package com.obric.oui.constraintlayout.core.widgets.analyzer;

import ai.j0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f12588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12590c;
    public ArrayList d;
    public int e;

    public final void a(ArrayList r10) {
        int r5 = this.f12588a.size();
        if (this.e == (-1)) goto L12;
        if (r5 <= 0) goto L12;
        int r11 = 0;
    L7:
        if (r11 >= r10.size()) goto L12;
        q r12 = (q) r10.get(r11);
        if (this.e != r12.f12589b) goto L11;
        c(this.f12590c, r12);
    L11:
        r11 = r11 + 1;
    L12:
        if (r5 != 0) goto L18;
        r10.remove(this);
        return;
    }

    public final int b(fr.c r10, int r11) {
        ArrayList r5 = this.f12588a;
        int r12 = 0;
        if (r5.size() != 0) goto L5;
        return 0;
    L5:
        hr.g r13 = (hr.g) ((hr.f) r5.get(0)).V;
        r10.t();
        r13.b(r10, false);
        int r14 = 0;
    L7:
        if (r14 >= r5.size()) goto L9;
        ((hr.f) r5.get(r14)).b(r10, false);
        r14 = r14 + 1;
        goto L7
    L9:
        if (r11 != 0) goto L14;
        if (r13.D0 <= 0) goto L14;
        hr.m.a(r13, r10, r5, 0);
    L14:
        if (r11 == 1) goto L16;
    L31:
        r10.p();     // Catch: Exception -> L20
    L22:
        this.d = new ArrayList();
    L24:
        if (r12 >= r5.size()) goto L26;
        hr.f r15 = (hr.f) r5.get(r12);
        f9.a r16 = new f9.a(9);
        new WeakReference(r15);
        fr.c.n(r15.J);
        fr.c.n(r15.K);
        fr.c.n(r15.L);
        fr.c.n(r15.M);
        fr.c.n(r15.N);
        this.d.add(r16);
        r12 = r12 + 1;
        goto L24
    L26:
        if (r11 != 0) goto L29;
        int r17 = fr.c.n(r13.J);
        int r18 = fr.c.n(r13.L);
        r10.t();
    L30:
        return r18 - r17;
    L29:
        r17 = fr.c.n(r13.K);
        r18 = fr.c.n(r13.M);
        r10.t();
    L20:
        e = move-exception;
        System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        goto L22
    L16:
        if (r13.E0 <= 0) goto L31;
        hr.m.a(r13, r10, r5, 1);
        goto L31
    }

    public final void c(int r5, q r10) {
        Iterator r11 = this.f12588a.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        hr.f r12 = (hr.f) r11.next();
        ArrayList r13 = r10.f12588a;
        if (r13.contains(r12) == true) goto L9;
        r13.add(r12);
    L9:
        int r14 = r10.f12589b;
        if (r5 == 0) goto L11;
        r12.f17425t0 = r14;
        goto L4
    L11:
        r12.f17423s0 = r14;
        goto L4
    L13:
        this.e = r10.f12589b;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        int r10 = this.f12590c;
        if (r10 != 0) goto L6;
        String r11 = "Horizontal";
    L12:
        r5.append(r11);
        r5.append(" [");
        String r12 = androidx.constraintlayout.motion.widget.a.s(r5, this.f12589b, "] <");
        Iterator r13 = this.f12588a.iterator();
    L14:
        if (r13.hasNext() == false) goto L17;
        hr.f r14 = (hr.f) r13.next();
        StringBuilder r15 = j0.w(r12, " ");
        r15.append(r14.f17409k0);
        r12 = r15.toString();
        goto L14
    L17:
        return j0.j(r12, " >");
    L6:
        if (r10 != 1) goto L9;
        r11 = "Vertical";
        goto L12
    L9:
        if (r10 != 2) goto L11;
        r11 = "Both";
        goto L12
    L11:
        r11 = "Unknown";
        goto L12
    }
}
