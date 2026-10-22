package hr;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends o {
    @Override // hr.o
    public final void V(int r10, int r11, int r12, int r13) {
        int r5 = this.A0 + this.B0;
        int r14 = this.f17465w0 + this.f17466x0;
        boolean r15 = false;
        if (this.f17463v0 <= 0) goto L5;
        r5 = r5 + this.f17462u0[0].r();
        r14 = r14 + this.f17462u0[0].l();
    L5:
        int r16 = Math.max(this.f17400d0, r5);
        int r17 = Math.max(this.f17401e0, r14);
        if (r10 == 1073741824) goto L13;
        if (r10 != Integer.MIN_VALUE) goto L10;
        r11 = Math.min(r16, r11);
        goto L13
    L10:
        if (r10 != 0) goto L12;
        r11 = r16;
        goto L13
    L12:
        r11 = 0;
    L13:
        if (r12 == 1073741824) goto L20;
        if (r12 != Integer.MIN_VALUE) goto L17;
        r13 = Math.min(r17, r13);
        goto L20
    L17:
        if (r12 != 0) goto L19;
        r13 = r17;
        goto L20
    L19:
        r13 = 0;
    L20:
        this.D0 = r11;
        this.E0 = r13;
        P(r11);
        M(r13);
        if (this.f17463v0 <= 0) goto L23;
        r15 = true;
    L23:
        this.C0 = r15;
    }

    @Override // hr.f
    public final void b(fr.c r5, boolean r10) {
        super.b(r5, r10);
        if (this.f17463v0 <= 0) goto L6;
        f r11 = this.f17462u0[0];
        r11.E();
        r11.g0 = 0.5f;
        r11.f17402f0 = 0.5f;
        ConstraintAnchor$Type r12 = ConstraintAnchor$Type.LEFT;
        r11.e(r12, this, r12, 0);
        ConstraintAnchor$Type r13 = ConstraintAnchor$Type.RIGHT;
        r11.e(r13, this, r13, 0);
        ConstraintAnchor$Type r14 = ConstraintAnchor$Type.TOP;
        r11.e(r14, this, r14, 0);
        ConstraintAnchor$Type r15 = ConstraintAnchor$Type.BOTTOM;
        r11.e(r15, this, r15, 0);
        return;
    }
}
