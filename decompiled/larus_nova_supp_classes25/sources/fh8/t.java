package fh8;

import android.graphics.RectF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final Integer f;
    public final int g;
    public final RectF h;
    public boolean i;

    public static final class a {
        public int a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        public Integer f;
        public boolean g;
        public int h;
        public RectF i;

        public final t a() {
            t r9 = new t(this.a, this.b, this.c, this.d, this.e, this.f, this.h, this.i);
            r9.i = this.g;
            return r9;
        }

        public a() {
            this.b = -1;
            this.c = -1;
        }
    }

    public t(int r1, int r2, int r3, boolean r4, boolean r5, Integer r6, int r7, RectF r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
