package p6a;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends c {
    public int b;
    public int c;
    public final Path d;

    public a() {
        this.b = 0;
        this.c = 0;
        this.d = new Path();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r14) {
        Rect r0 = getBounds();
        int r1 = r0.width();
        int r2 = r0.height();
        if (this.b == r1) goto L5;
    L6:
        this.d.reset();
        float r3 = (r1 * 30) / 225;
        float r4 = r3 * 0.70710677f;
        float r5 = r3 / 0.70710677f;
        float r6 = r1;
        float r8 = r6 / 2.0f;
        float r9 = r2;
        this.d.moveTo(r8, r9);
        float r10 = r9 / 2.0f;
        this.d.lineTo(0.0f, r10);
        float r12 = r10 - r4;
        this.d.lineTo(r4, r12);
        float r7 = r3 / 2.0f;
        float r11 = r8 - r7;
        float r13 = (r9 - r5) - r7;
        this.d.lineTo(r11, r13);
        this.d.lineTo(r11, 0.0f);
        float r15 = r8 + r7;
        this.d.lineTo(r15, 0.0f);
        this.d.lineTo(r15, r13);
        this.d.lineTo(r6 - r4, r12);
        this.d.lineTo(r6, r10);
        this.d.close();
        this.b = r1;
        this.c = r2;
    L7:
        r14.drawPath(this.d, this.a);
        return;
    L5:
        if (this.c == r2) goto L7;
        goto L6
    }
}
