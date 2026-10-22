package hr;

import com.obric.oui.constraintlayout.core.SolverVariable$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.analyzer.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet f17387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17389c;
    public final f d;
    public final ConstraintAnchor$Type e;
    public d f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public fr.e f17391i;

    public d(f r5, ConstraintAnchor$Type r10) {
        this.f17387a = null;
        this.g = 0;
        this.f17390h = Integer.MIN_VALUE;
        this.d = r5;
        this.e = r10;
    }

    public final void a(d r5, int r10) {
        b(r5, r10, Integer.MIN_VALUE, false);
    }

    public final boolean b(d r5, int r10, int r11, boolean r12) {
        if (r5 != null) goto L6;
        j();
        return true;
    L6:
        if (r12 == false) goto L8;
    L11:
        this.f = r5;
        if (r5.f17387a != null) goto L14;
        r5.f17387a = new HashSet();
    L14:
        HashSet r13 = this.f.f17387a;
        if (r13 == null) goto L17;
        r13.add(this);
    L17:
        this.g = r10;
        this.f17390h = r11;
        return true;
    L8:
        if (i(r5) == true) goto L11;
        return false;
    }

    public final void c(int r5, q r10, ArrayList r11) {
        HashSet r12 = this.f17387a;
        if (r12 == null) goto L8;
        Iterator r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(((d) r13.next()).d, r5, r11, r10);
        goto L6
    L10:
        return;
    }

    public final int d() {
        if (this.f17389c == true) goto L7;
        return 0;
    L7:
        return this.f17388b;
    }

    public final int e() {
        if (this.d.i0 != 8) goto L6;
        return 0;
    L6:
        int r5 = this.f17390h;
        if (r5 == Integer.MIN_VALUE) goto L14;
        d r10 = this.f;
        if (r10 == null) goto L14;
        if (r10.d.i0 != 8) goto L14;
        return r5;
    L14:
        return this.g;
    }

    public final d f() {
        int[] r5 = c.f17386a;
        ConstraintAnchor$Type r10 = this.e;
        int r11 = r5[r10.ordinal()];
        f r12 = this.d;
        switch(r11) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        throw new AssertionError(r10.name());
    L7:
        return r12.K;
    L9:
        return r12.M;
    L11:
        return r12.J;
    L13:
        return r12.L;
    }

    public final boolean g() {
        HashSet r5 = this.f17387a;
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator r10 = r5.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        if (((d) r10.next()).f().h() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean h() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i(d r10) {
        boolean r5 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        ConstraintAnchor$Type r11 = this.e;
        f r12 = r10.d;
        ConstraintAnchor$Type r13 = r10.e;
        if (r13 != r11) goto L16;
        if (r11 == ConstraintAnchor$Type.BASELINE) goto L10;
    L14:
        return true;
    L10:
        if (r12.E == true) goto L12;
    L13:
        return false;
    L12:
        if (this.d.E == true) goto L14;
    L16:
        switch(c.f17386a[r11.ordinal()]) {
            case 1: goto L58;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L19;
            case 9: goto L19;
            default: goto L18;
        };
    L19:
        return false;
    L18:
        throw new AssertionError(r11.name());
    L21:
        if (r13 != ConstraintAnchor$Type.LEFT) goto L23;
    L26:
        return false;
    L23:
        if (r13 == ConstraintAnchor$Type.RIGHT) goto L26;
        return true;
    L28:
        if (r13 != ConstraintAnchor$Type.TOP) goto L30;
    L33:
        boolean r14 = true;
    L35:
        if ((r12 instanceof k) == false) goto L65;
        if (r14 == false) goto L38;
    L39:
        r5 = true;
    L41:
        return r5;
    L38:
        if (r13 != ConstraintAnchor$Type.CENTER_Y) goto L41;
    L65:
        return r14;
    L30:
        if (r13 == ConstraintAnchor$Type.BOTTOM) goto L33;
        r14 = false;
        goto L35
    L43:
        if (r13 != ConstraintAnchor$Type.LEFT) goto L45;
    L48:
        boolean r15 = true;
    L50:
        if ((r12 instanceof k) == false) goto L66;
        if (r15 == false) goto L53;
    L54:
        r5 = true;
    L56:
        return r5;
    L53:
        if (r13 != ConstraintAnchor$Type.CENTER_X) goto L56;
    L66:
        return r15;
    L45:
        if (r13 == ConstraintAnchor$Type.RIGHT) goto L48;
        r15 = false;
        goto L50
    L58:
        if (r13 != ConstraintAnchor$Type.BASELINE) goto L60;
        return false;
    L60:
        if (r13 != ConstraintAnchor$Type.CENTER_X) goto L62;
        return false;
    L62:
        if (r13 != ConstraintAnchor$Type.CENTER_Y) goto L64;
        return false;
    L64:
        return true;
    }

    public final void j() {
        d r5 = this.f;
        if (r5 == null) goto L9;
        HashSet r10 = r5.f17387a;
        if (r10 == null) goto L9;
        r10.remove(this);
        if (this.f.f17387a.size() != 0) goto L9;
        this.f.f17387a = null;
    L9:
        this.f17387a = null;
        this.f = null;
        this.g = 0;
        this.f17390h = Integer.MIN_VALUE;
        this.f17389c = false;
        this.f17388b = 0;
    }

    public final void k() {
        fr.e r5 = this.f17391i;
        if (r5 != null) goto L5;
        this.f17391i = new fr.e(SolverVariable$Type.UNRESTRICTED);
        return;
    L5:
        r5.c();
    }

    public final void l(int r5) {
        this.f17388b = r5;
        this.f17389c = true;
    }

    public final String toString() {
        return this.d.f17409k0 + ":" + this.e.toString();
    }
}
