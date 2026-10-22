package io.noties.markwon.a;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes6.dex */
public class j extends i {
    public j() {
    }

    public int a(h.a r1, int r2, float r3) {
        if ("em".equals(r1.f16403b) == false) goto L5;
        float r0 = r1.f16402a * r3;
    L7:
        return (int) (r0 + 0.5f);
    L5:
        r0 = r1.f16402a;
        goto L7
    }

    @Override // io.noties.markwon.a.i
    public Rect a(a r4) {
        return a(r4.c(), r4.f().getBounds(), r4.d(), r4.e());
    }

    public Rect a(h r8, Rect r9, int r10, float r11) {
        if (r8 != null) goto L8;
        int r7 = r9.width();
        if (r7 > r10) goto L7;
        return r9;
    L7:
        return new Rect(0, 0, r10, (int) ((r9.height() / (r7 / r10)) + 0.5f));
    L8:
        h.a r2 = r8.f16400a;
        h.a r12 = r8.f16401b;
        int r3 = r9.width();
        int r4 = r9.height();
        float r5 = r3 / r4;
        if (r2 != null) goto L11;
        if (r12 != null) goto L23;
        return r9;
    L23:
        if ("%".equals(r12.f16403b) == true) goto L29;
        int r13 = a(r12, r4, r11);
        return new Rect(0, 0, (int) ((r13 * r5) + 0.5f), r13);
    L29:
        return r9;
    L11:
        if ("%".equals(r2.f16403b) == false) goto L13;
        int r14 = (int) ((r10 * (r2.f16402a / 100.0f)) + 0.5f);
    L14:
        if (r12 != null) goto L16;
    L19:
        int r15 = (int) ((r14 / r5) + 0.5f);
    L27:
        return new Rect(0, 0, r14, r15);
    L16:
        if ("%".equals(r12.f16403b) == true) goto L19;
        r15 = a(r12, r4, r11);
        goto L27
    L13:
        r14 = a(r2, r3, r11);
        goto L14
    }
}
