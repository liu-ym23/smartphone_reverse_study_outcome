package io.noties.markwon.core;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    private static final float[] D = null;
    protected final int A;
    public final boolean B;
    public final boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f16435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f16436b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final int f;
    protected final int g;
    protected final int h;
    public final float i;
    public final float j;
    protected final int k;
    protected final int l;
    protected final int m;
    protected final int n;
    protected final int o;
    protected final int p;
    protected final int q;
    protected final Typeface r;
    protected final Typeface s;
    protected final int t;
    protected final int u;
    protected final int v;
    protected final int w;
    protected final Typeface x;
    protected final float[] y;
    protected final int z;

    public static class a {
        private int A;
        private boolean B;
        private boolean C;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f16438b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private float i;
        private float j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private Typeface r;
        private Typeface s;
        private int t;
        private int u;
        private int v;
        private int w;
        private Typeface x;
        private float[] y;
        private int z;

        a() {
            this.f16438b = true;
            this.i = 1.0f;
            this.j = 1.0f;
            this.v = -1;
            this.A = -1;
            this.B = false;
            this.C = false;
        }

        a(c r2) {
            this.f16438b = true;
            this.i = 1.0f;
            this.j = 1.0f;
            this.v = -1;
            this.A = -1;
            this.B = false;
            this.C = false;
            this.f16437a = r2.f16435a;
            this.f16438b = r2.f16436b;
            this.c = r2.c;
            this.d = r2.d;
            this.e = r2.e;
            this.f = r2.f;
            this.i = r2.i;
            this.k = r2.k;
            this.l = r2.l;
            this.m = r2.m;
            this.n = r2.n;
            this.o = r2.o;
            this.p = r2.p;
            this.q = r2.q;
            this.r = r2.r;
            this.t = r2.t;
            this.v = r2.v;
            this.w = r2.w;
            this.x = r2.x;
            this.y = r2.y;
            this.z = r2.z;
            this.A = r2.A;
            this.B = r2.B;
            this.C = r2.C;
        }

        static /* synthetic */ int A(a r0) {
            return r0.A;
        }

        static /* synthetic */ boolean B(a r0) {
            return r0.B;
        }

        static /* synthetic */ boolean C(a r0) {
            return r0.C;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f16437a;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.f16438b;
        }

        static /* synthetic */ int c(a r0) {
            return r0.c;
        }

        static /* synthetic */ int d(a r0) {
            return r0.d;
        }

        static /* synthetic */ int e(a r0) {
            return r0.e;
        }

        static /* synthetic */ int f(a r0) {
            return r0.f;
        }

        static /* synthetic */ int g(a r0) {
            return r0.h;
        }

        static /* synthetic */ int h(a r0) {
            return r0.g;
        }

        static /* synthetic */ float i(a r0) {
            return r0.i;
        }

        static /* synthetic */ float j(a r0) {
            return r0.j;
        }

        static /* synthetic */ int k(a r0) {
            return r0.k;
        }

        static /* synthetic */ int l(a r0) {
            return r0.l;
        }

        static /* synthetic */ int m(a r0) {
            return r0.m;
        }

        static /* synthetic */ int n(a r0) {
            return r0.n;
        }

        static /* synthetic */ int o(a r0) {
            return r0.o;
        }

        static /* synthetic */ int p(a r0) {
            return r0.p;
        }

        static /* synthetic */ int q(a r0) {
            return r0.q;
        }

        static /* synthetic */ Typeface r(a r0) {
            return r0.r;
        }

        static /* synthetic */ Typeface s(a r0) {
            return r0.s;
        }

        static /* synthetic */ int t(a r0) {
            return r0.t;
        }

        static /* synthetic */ int u(a r0) {
            return r0.u;
        }

        static /* synthetic */ int v(a r0) {
            return r0.v;
        }

        static /* synthetic */ int w(a r0) {
            return r0.w;
        }

        static /* synthetic */ Typeface x(a r0) {
            return r0.x;
        }

        static /* synthetic */ float[] y(a r0) {
            return r0.y;
        }

        static /* synthetic */ int z(a r0) {
            return r0.z;
        }

        public a a(float r1) {
            this.i = r1;
            return this;
        }

        public a a(int r1) {
            this.f16437a = r1;
            return this;
        }

        public a a(boolean r1) {
            this.f16438b = r1;
            return this;
        }

        public c a() {
            return new c(this);
        }

        public a b(float r1) {
            this.j = r1;
            return this;
        }

        public a b(int r1) {
            this.c = r1;
            return this;
        }

        public a b(boolean r1) {
            this.B = r1;
            return this;
        }

        public a c(int r1) {
            this.d = r1;
            return this;
        }

        public a c(boolean r1) {
            this.C = r1;
            return this;
        }

        public a d(int r1) {
            this.e = r1;
            return this;
        }

        public a e(int r1) {
            this.f = r1;
            return this;
        }

        public a f(int r1) {
            this.g = r1;
            return this;
        }

        public a g(int r1) {
            this.h = r1;
            return this;
        }

        public a h(int r1) {
            this.k = r1;
            return this;
        }

        public a i(int r1) {
            this.l = r1;
            return this;
        }

        public a j(int r1) {
            this.m = r1;
            return this;
        }

        public a k(int r1) {
            this.n = r1;
            return this;
        }

        public a l(int r1) {
            this.o = r1;
            return this;
        }

        public a m(int r1) {
            this.p = r1;
            return this;
        }

        public a n(int r1) {
            this.q = r1;
            return this;
        }

        public a o(int r1) {
            this.v = r1;
            return this;
        }

        public a p(int r1) {
            this.z = r1;
            return this;
        }

        public a q(int r1) {
            this.A = r1;
            return this;
        }
    }

    static {
        D = new float[]{2.0f, 1.5f, 1.17f, 1.0f, 0.83f, 0.67f};
    }

    public c(a r2) {
        this.f16435a = a.a(r2);
        this.f16436b = a.b(r2);
        this.c = a.c(r2);
        this.d = a.d(r2);
        this.e = a.e(r2);
        this.f = a.f(r2);
        this.h = a.g(r2);
        this.g = a.h(r2);
        this.i = a.i(r2);
        this.j = a.j(r2);
        this.k = a.k(r2);
        this.l = a.l(r2);
        this.m = a.m(r2);
        this.n = a.n(r2);
        this.o = a.o(r2);
        this.p = a.p(r2);
        this.q = a.q(r2);
        this.r = a.r(r2);
        this.s = a.s(r2);
        this.t = a.t(r2);
        this.u = a.u(r2);
        this.v = a.v(r2);
        this.w = a.w(r2);
        this.x = a.x(r2);
        this.y = a.y(r2);
        this.z = a.z(r2);
        this.A = a.A(r2);
        this.B = a.B(r2);
        this.C = a.C(r2);
    }

    public static a a(Context r4) {
        io.noties.markwon.g.c r5 = io.noties.markwon.g.c.a((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"));
        return new a().n(r5.a(8)).b(r5.a(24)).c(r5.a(4)).h(r5.a(1)).o(r5.a(1)).q(r5.a(4));
    }

    public static a a(c r1) {
        return new a(r1);
    }

    public int a() {
        return this.c;
    }

    public int a(int r2) {
        int r3 = Math.min(this.c, r2) / 2;
        int r1 = this.l;
        if (r1 == 0) goto L8;
        if (r1 <= r3) goto L7;
        return r3;
    L7:
        return r1;
    L8:
        return r3;
    }

    public void a(Paint r2) {
        r2.setUnderlineText(this.f16436b);
        int r1 = this.f16435a;
        if (r1 == 0) goto L6;
    L4:
        r2.setColor(r1);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TextPaint.class) == false) goto L9;
        r1 = ((TextPaint) ZeusTransformUtils.preCheckCast(r2, TextPaint.class, "com.obric.memorydata.plugin")).linkColor;
        goto L4
    }

    public void a(Paint r5, int r6) {
        Typeface r0 = this.x;
        if (r0 != null) goto L5;
        r5.setFakeBoldText(true);
    L6:
        float[] r4 = this.y;
        if (r4 != null) goto L10;
        r4 = D;
    L10:
        if (r4 == null) goto L16;
        if (r4.length < r6) goto L16;
        r5.setTextSize(r5.getTextSize() * r4[r6 - 1]);
        return;
    L16:
        throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", new Object[]{Integer.valueOf(r6), Arrays.toString(r4)}));
    L5:
        r5.setTypeface(r0);
        goto L6
    }

    public void a(Paint r1, boolean r2) {
        if (r2 == false) goto L7;
        int r3 = this.h;
        if (r3 != 0) goto L9;
    L6:
        r3 = this.f;
    L9:
        if (r3 == 0) goto L11;
        r1.setColor(r3);
    L11:
        int r0 = this.k;
        if (r0 == 0) goto L15;
        r1.setStrokeWidth(r0);
        return;
    L15:
        return;
    L7:
        r3 = this.g;
        if (r3 == 0) goto L6;
        goto L6
    }

    public void a(TextPaint r2) {
        r2.setUnderlineText(this.f16436b);
        int r1 = this.f16435a;
        if (r1 != 0) goto L6;
        r1 = r2.linkColor;
    L6:
        r2.setColor(r1);
    }

    public int b() {
        int r0 = this.d;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return (int) ((this.c * 0.25f) + 0.5f);
    }

    public void b(Paint r2) {
        int r1 = this.e;
        if (r1 != 0) goto L5;
        r1 = io.noties.markwon.g.a.a(r2.getColor(), 25);
    L5:
        r2.setStyle(Paint.Style.FILL);
        r2.setColor(r1);
    }

    public int c() {
        return this.q;
    }

    public void c(Paint r2) {
        int r0 = this.m;
        if (r0 == 0) goto L5;
        r2.setColor(r0);
    L5:
        Typeface r1 = this.r;
        if (r1 == null) goto L10;
        r2.setTypeface(r1);
        int r3 = this.t;
        if (r3 <= 0) goto L16;
    L12:
        float r4 = r3;
    L14:
        r2.setTextSize(r4);
        return;
    L16:
        return;
    L10:
        r2.setTypeface(Typeface.MONOSPACE);
        r3 = this.t;
        if (r3 > 0) goto L12;
        r4 = r2.getTextSize() * 0.87f;
        goto L14
    }

    public void d(Paint r2) {
        int r0 = this.n;
        if (r0 != 0) goto L6;
        r0 = this.m;
    L6:
        if (r0 == 0) goto L8;
        r2.setColor(r0);
    L8:
        Typeface r1 = this.s;
        if (r1 != null) goto L12;
        r1 = this.r;
    L12:
        if (r1 == null) goto L19;
        r2.setTypeface(r1);
        int r3 = this.u;
        if (r3 > 0) goto L17;
        r3 = this.t;
    L17:
        if (r3 <= 0) goto L28;
    L24:
        float r4 = r3;
    L26:
        r2.setTextSize(r4);
        return;
    L28:
        return;
    L19:
        r2.setTypeface(Typeface.MONOSPACE);
        r3 = this.u;
        if (r3 > 0) goto L23;
        r3 = this.t;
    L23:
        if (r3 > 0) goto L24;
        r4 = r2.getTextSize() * 0.87f;
        goto L26
    }

    public int e(Paint r1) {
        int r0 = this.o;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return io.noties.markwon.g.a.a(r1.getColor(), 25);
    }

    public int f(Paint r2) {
        int r0 = this.p;
        if (r0 != 0) goto L6;
        r0 = this.o;
    L6:
        if (r0 == 0) goto L9;
        return r0;
    L9:
        return io.noties.markwon.g.a.a(r2.getColor(), 25);
    }

    public void g(Paint r3) {
        int r0 = this.w;
        if (r0 != 0) goto L6;
        r0 = io.noties.markwon.g.a.a(r3.getColor(), 75);
    L6:
        r3.setColor(r0);
        r3.setStyle(Paint.Style.FILL);
        int r2 = this.v;
        if (r2 < 0) goto L10;
        r3.setStrokeWidth(r2);
        return;
    }

    public void h(Paint r3) {
        int r0 = this.z;
        if (r0 != 0) goto L6;
        r0 = io.noties.markwon.g.a.a(r3.getColor(), 25);
    L6:
        r3.setColor(r0);
        r3.setStyle(Paint.Style.FILL);
        int r2 = this.A;
        if (r2 < 0) goto L10;
        r3.setStrokeWidth(r2);
        return;
    }
}
