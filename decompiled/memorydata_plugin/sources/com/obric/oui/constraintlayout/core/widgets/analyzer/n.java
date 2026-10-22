package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f13632b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<ConstraintWidget> f13633a;
    int c;
    boolean d;
    int e;
    ArrayList<a> f;
    private int g;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<ConstraintWidget> f13634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13635b;
        int c;
        int d;
        int e;
        int f;
        int g;

        a(ConstraintWidget r2, com.obric.oui.constraintlayout.core.d r3, int r4) {
            this.f13634a = new WeakReference(r2);
            this.f13635b = r3.b(r2.B);
            this.c = r3.b(r2.C);
            this.d = r3.b(r2.D);
            this.e = r3.b(r2.E);
            this.f = r3.b(r2.F);
            this.g = r4;
        }
    }

    static {
    }

    public n(int r3) {
        this.f13633a = new ArrayList();
        this.c = -1;
        this.d = false;
        this.e = 0;
        this.f = null;
        this.g = -1;
        int r0 = f13632b;
        f13632b = r0 + 1;
        this.c = r0;
        this.e = r3;
    }

    private int a(com.obric.oui.constraintlayout.core.d r9, ArrayList<ConstraintWidget> r10, int r11) {
        int r0 = 0;
        com.obric.oui.constraintlayout.core.widgets.d r1 = (com.obric.oui.constraintlayout.core.widgets.d) ZeusTransformUtils.preCheckCast(((ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(0), ConstraintWidget.class, "com.obric.memorydata.plugin")).A(), com.obric.oui.constraintlayout.core.widgets.d.class, "com.obric.memorydata.plugin");
        r9.b();
        r1.a(r9, false);
        int r2 = 0;
    L4:
        if (r2 >= r10.size()) goto L6;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(r2), ConstraintWidget.class, "com.obric.memorydata.plugin")).a(r9, false);
        r2 = r2 + 1;
        goto L4
    L6:
        if (r11 != 0) goto L11;
        if (r1.aH <= 0) goto L11;
        com.obric.oui.constraintlayout.core.widgets.b.a(r1, r9, r10, 0);
    L11:
        if (r11 == 1) goto L13;
    L28:
        r9.f();     // Catch: Exception -> L17
    L19:
        this.f = new ArrayList();
    L21:
        if (r0 >= r10.size()) goto L23;
        this.f.add(new a((ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(r0), ConstraintWidget.class, "com.obric.memorydata.plugin"), r9, r11));
        r0 = r0 + 1;
        goto L21
    L23:
        if (r11 != 0) goto L27;
        int r8 = r9.b(r1.B);
        ConstraintAnchor r12 = r1.D;
    L25:
        int r13 = r9.b(r12);
        r9.b();
        return r13 - r8;
    L27:
        r8 = r9.b(r1.C);
        r12 = r1.E;
    L17:
        e = move-exception;
        System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        goto L19
    L13:
        if (r1.aI <= 0) goto L28;
        com.obric.oui.constraintlayout.core.widgets.b.a(r1, r9, r10, 1);
        goto L28
    }

    private String c() {
        int r1 = this.e;
        if (r1 != 0) goto L7;
        return "Horizontal";
    L7:
        if (r1 != 1) goto L11;
        return "Vertical";
    L11:
        if (r1 != 2) goto L14;
        return com.tom_roush.pdfbox.pdmodel.a.d.h.g;
    L14:
        return "Unknown";
    }

    public int a() {
        return this.e;
    }

    public int a(com.obric.oui.constraintlayout.core.d r2, int r3) {
        if (this.f13633a.size() != 0) goto L7;
        return 0;
    L7:
        return a(r2, this.f13633a, r3);
    }

    public void a(int r1) {
        this.e = r1;
    }

    public void a(int r5, n r6) {
        Iterator<ConstraintWidget> r0 = this.f13633a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ConstraintWidget r1 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r6.a(r1);
        int r2 = r6.b();
        if (r5 == 0) goto L7;
        r1.ay = r2;
        goto L4
    L7:
        r1.ax = r2;
        goto L4
    L9:
        this.g = r6.c;
    }

    public void a(ArrayList<n> r6) {
        int r0 = this.f13633a.size();
        if (this.g == (-1)) goto L12;
        if (r0 <= 0) goto L12;
        int r1 = 0;
    L7:
        if (r1 >= r6.size()) goto L12;
        n r2 = (n) ZeusTransformUtils.preCheckCast(r6.get(r1), n.class, "com.obric.memorydata.plugin");
        if (this.g != r2.c) goto L11;
        a(this.e, r2);
    L11:
        r1 = r1 + 1;
    L12:
        if (r0 != 0) goto L18;
        r6.remove(this);
        return;
    }

    public void a(boolean r1) {
        this.d = r1;
    }

    public boolean a(ConstraintWidget r2) {
        if (this.f13633a.contains(r2) == false) goto L6;
        return false;
    L6:
        this.f13633a.add(r2);
        return true;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        String r0 = c() + " [" + this.c + "] <";
        Iterator<ConstraintWidget> r4 = this.f13633a.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0 = r0 + " " + ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.next(), ConstraintWidget.class, "com.obric.memorydata.plugin")).C();
        goto L4
    L7:
        return r0 + " >";
    }
}
