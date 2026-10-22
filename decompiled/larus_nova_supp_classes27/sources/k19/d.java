package k19;

import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public int a;
    public int b;
    public final int[] c;
    public final float[] d;
    public final float[] e;
    public final float[] f;
    public final float[] g;
    public final float[] h;
    public final float[] i;
    public b<d> j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        b<d> r0 = this.j;
        if (r0 == null) goto L5;
        r0.onGestureEnd(this);
    L5:
        int r1 = 0;
        this.a = 0;
        this.b = 0;
    L7:
        if (r1 >= 2) goto L9;
        this.c[r1] = -1;
        this.d[r1] = 0.0f;
        this.e[r1] = 0.0f;
        this.f[r1] = 0.0f;
        this.g[r1] = 0.0f;
        this.h[r1] = 0.0f;
        this.i[r1] = 0.0f;
        r1 = r1 + 1;
        goto L7
    }

    public d() {
        this.c = new int[2];
        this.d = new float[2];
        this.e = new float[2];
        this.f = new float[2];
        this.g = new float[2];
        this.h = new float[2];
        this.i = new float[2];
    }

    public final void b(MotionEvent r7) {
        r7.getAction();
        this.b = this.a;
        int r0 = 0;
        this.a = 0;
    L4:
        if (r0 >= 2) goto L21;
        int r1 = r7.getPointerCount();
        int r2 = r7.getActionMasked();
        int r3 = r7.getActionIndex();
        if (r2 != 1) goto L8;
    L10:
        if (r0 < r3) goto L12;
        int r4 = r0 + 1;
    L14:
        if (r4 < r1) goto L17;
        r4 = -1;
    L17:
        if (r4 != (-1)) goto L19;
        this.c[r0] = -1;
    L20:
        r0 = r0 + 1;
        goto L4
    L19:
        this.c[r0] = r7.getPointerId(r4);
        this.h[r0] = r7.getX(r4);
        float[] r5 = this.d;
        float r6 = this.h[r0];
        r5[r0] = r6;
        this.f[r0] = r6;
        this.i[r0] = r7.getY(r4);
        float[] r8 = this.e;
        float r9 = this.i[r0];
        r8[r0] = r9;
        this.g[r0] = r9;
        this.a++;
    L12:
        r4 = r0;
        goto L14
    L8:
        if (r2 == 6) goto L10;
    }
}
