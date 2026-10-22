package msc;

import android.graphics.Paint;
import android.graphics.Typeface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s {
    public static final float[] B = null;
    public final boolean A;
    public final int a;
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final float i;
    public final float j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final Typeface r;
    public final int s;
    public final int t;
    public final int u;
    public final Typeface v;
    public final float[] w;
    public final int x;
    public final int y;
    public final boolean z;

    public static class a {
        public int a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public float i;
        public float j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public boolean v;

        public a() {
            this.b = true;
            this.i = 1.0f;
            this.j = 1.0f;
            this.r = -1;
            this.t = -1;
            this.u = false;
            this.v = false;
        }
    }

    static {
        B = new float[]{2.0f, 1.5f, 1.17f, 1.0f, 0.83f, 0.67f};
    }

    public s(a r4) {
        this.a = r4.a;
        this.b = r4.b;
        this.c = r4.c;
        this.d = r4.d;
        this.e = r4.e;
        this.f = r4.f;
        this.h = r4.h;
        this.g = r4.g;
        this.i = r4.i;
        this.j = r4.j;
        this.k = r4.k;
        this.l = r4.l;
        this.m = r4.m;
        this.n = r4.n;
        this.o = r4.o;
        this.p = r4.p;
        this.q = r4.q;
        this.r = null;
        this.s = 0;
        this.t = r4.r;
        this.u = 0;
        this.v = null;
        this.w = null;
        this.x = r4.s;
        this.y = r4.t;
        this.z = r4.u;
        this.A = r4.v;
    }

    public final void a(Paint r3) {
        int r0 = this.n;
        if (r0 != 0) goto L6;
        r0 = this.m;
    L6:
        if (r0 == 0) goto L8;
        r3.setColor(r0);
    L8:
        Typeface r1 = this.r;
        if (r1 == null) goto L13;
        r3.setTypeface(r1);
        int r2 = this.s;
        if (r2 <= 0) goto L18;
        r3.setTextSize(r2);
        return;
    L18:
        return;
    L13:
        r3.setTypeface(Typeface.MONOSPACE);
        int r4 = this.s;
        if (r4 <= 0) goto L16;
        r3.setTextSize(r4);
        return;
    L16:
        r3.setTextSize(r3.getTextSize() * 0.87f);
    }

    public final void c(Paint r3) {
        int r0 = this.x;
        if (r0 != 0) goto L6;
        r0 = ftc.a.a(r3.getColor(), 25);
    L6:
        r3.setColor(r0);
        r3.setStyle(Paint.Style.FILL);
        int r1 = this.y;
        if (r1 < 0) goto L10;
        r3.setStrokeWidth(r1);
        return;
    }

    public final void b(Paint r1, boolean r2) {
        if (r2 == false) goto L7;
        int r3 = this.h;
        if (r3 != 0) goto L11;
        r3 = this.f;
    L11:
        if (r3 == 0) goto L13;
        r1.setColor(r3);
    L13:
        int r4 = this.k;
        if (r4 == 0) goto L17;
        r1.setStrokeWidth(r4);
        return;
    L17:
        return;
    L7:
        r3 = this.g;
        if (r3 != 0) goto L11;
        r3 = this.f;
        goto L11
    }
}
