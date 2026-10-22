package wsc;

import android.graphics.Rect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i extends p {
    public final Rect a;
    public final int b;
    public final int c;

    @Override // wsc.p
    public final Rect a(a r10) {
        if ((r10 instanceof h) == false) goto L5;
        ((h) r10).getClass();
    L5:
        Rect r0 = this.a;
        if (r0 != null) goto L8;
    L10:
        o r1 = r10.c;
        Rect r2 = r10.e.getBounds();
        int r3 = Math.max(this.b, r10.g) - 0;
        float r11 = r10.h;
        if (r1 != null) goto L13;
        int r12 = r.a;
        return r.a(r2, r3, this.c);
    L13:
        o.a r4 = r1.a;
        o.a r5 = r1.b;
        float r6 = r2.width() / r2.height();
        if (r4 != null) goto L16;
        if (r5 != null) goto L28;
    L30:
        int r13 = r.a;
        return r.a(r2, r3, this.c);
    L28:
        if ("%".equals(r5.b) == true) goto L30;
        int r14 = r.c(r5, r11);
        r2 = new Rect(0, 0, (int) ((r14 * r6) + 0.5f), r14);
        goto L30
    L16:
        if ("%".equals(r4.b) == false) goto L18;
        int r7 = (int) (r3 * (r4.a / 100.0f));
    L19:
        if (r5 != null) goto L21;
    L24:
        int r15 = (int) ((r7 / r6) + 0.5f);
    L25:
        r2 = new Rect(0, 0, r7, r15);
        goto L30
    L21:
        if ("%".equals(r5.b) == true) goto L24;
        r15 = r.c(r5, r11);
        goto L25
    L18:
        r7 = r.c(r4, r11);
        goto L19
    L8:
        if (r10.c != null) goto L10;
        return r0;
    }

    public i(Rect r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
