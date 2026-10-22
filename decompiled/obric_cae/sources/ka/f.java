package ka;

import java.io.Reader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends pa.a {
    public static final a D = null;
    public static final Object E = null;
    public int A;
    public String[] B;
    public int[] C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object[] f8996z;

    public class a extends Reader {
        public a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public final int read(char[] r8, int r10, int r11) {
            throw new AssertionError();
        }
    }

    static {
        D = new a();
        E = new Object();
    }

    public f(ha.p r8) {
        super(D);
        this.f8996z = new Object[32];
        this.A = 0;
        this.B = new String[32];
        this.C = new int[32];
        B0(r8);
    }

    private String D() {
        return " at path " + z(false);
    }

    private String z(boolean r8) {
        StringBuilder r10 = new StringBuilder("$");
        int r11 = 0;
    L3:
        int r12 = this.A;
        if (r11 >= r12) goto L31;
        Object[] r13 = this.f8996z;
        Object r14 = r13[r11];
        if ((r14 instanceof ha.m) == false) goto L21;
        r11 = r11 + 1;
        if (r11 >= r12) goto L29;
        if ((r13[r11] instanceof Iterator) == false) goto L29;
        int r15 = this.C[r11];
        if (r8 == false) goto L19;
        if (r15 <= 0) goto L19;
        if (r11 != (r12 - 1)) goto L17;
    L18:
        r15 = r15 - 1;
        goto L19
    L17:
        if (r11 == (r12 - 2)) goto L18;
    L19:
        r10.append('[');
        r10.append(r15);
        r10.append(']');
    L29:
        r11 = r11 + 1;
        goto L3
    L21:
        if ((r14 instanceof ha.s) == false) goto L29;
        r11 = r11 + 1;
        if (r11 >= r12) goto L29;
        if ((r13[r11] instanceof Iterator) == false) goto L29;
        r10.append('.');
        String r16 = this.B[r11];
        if (r16 == null) goto L29;
        r10.append(r16);
        goto L29
    L31:
        return r10.toString();
    }

    @Override // pa.a
    public final String A() {
        return z(true);
    }

    public final Object A0() {
        Object[] r8 = this.f8996z;
        int r10 = this.A - 1;
        this.A = r10;
        Object r11 = r8[r10];
        r8[r10] = null;
        return r11;
    }

    @Override // pa.a
    public final boolean B() {
        pa.b r8 = h0();
        if (r8 != pa.b.f9969n) goto L5;
    L9:
        return false;
    L5:
        if (r8 == pa.b.f9967b) goto L9;
        if (r8 == pa.b.f9975t) goto L9;
        return true;
    }

    public final void B0(Object r8) {
        int r10 = this.A;
        Object[] r11 = this.f8996z;
        if (r10 != r11.length) goto L5;
        int r12 = r10 * 2;
        this.f8996z = Arrays.copyOf(r11, r12);
        this.C = Arrays.copyOf(this.C, r12);
        this.B = (String[]) Arrays.copyOf(this.B, r12);
    L5:
        Object[] r13 = this.f8996z;
        int r14 = this.A;
        this.A = r14 + 1;
        r13[r14] = r8;
    }

    @Override // pa.a
    public final boolean E() {
        w0(pa.b.f9973r);
        boolean r8 = ((ha.u) A0()).b();
        int r10 = this.A;
        if (r10 <= 0) goto L5;
        int[] r11 = this.C;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
    L5:
        return r8;
    }

    @Override // pa.a
    public final double G() {
        pa.b r8 = h0();
        pa.b r10 = pa.b.f9972q;
        if (r8 != r10) goto L5;
    L9:
        double r11 = ((ha.u) z0()).c();
        if (this.f9952b == false) goto L12;
    L18:
        A0();
        int r12 = this.A;
        if (r12 <= 0) goto L21;
        int[] r13 = this.C;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
    L21:
        return r11;
    L12:
        if (Double.isNaN(r11) == true) goto L17;
        if (Double.isInfinite(r11) == false) goto L18;
    L17:
        throw new pa.d("JSON forbids NaN and infinities: " + r11);
    L5:
        if (r8 == pa.b.f9971p) goto L9;
        throw new IllegalStateException("Expected " + r10 + " but was " + r8 + D());
    }

    @Override // pa.a
    public final int H() {
        pa.b r8 = h0();
        pa.b r10 = pa.b.f9972q;
        if (r8 != r10) goto L5;
    L9:
        int r11 = ((ha.u) z0()).d();
        A0();
        int r12 = this.A;
        if (r12 <= 0) goto L12;
        int[] r13 = this.C;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
    L12:
        return r11;
    L5:
        if (r8 == pa.b.f9971p) goto L9;
        throw new IllegalStateException("Expected " + r10 + " but was " + r8 + D());
    }

    @Override // pa.a
    public final long I() {
        pa.b r8 = h0();
        pa.b r10 = pa.b.f9972q;
        if (r8 != r10) goto L5;
    L9:
        long r11 = ((ha.u) z0()).h();
        A0();
        int r12 = this.A;
        if (r12 <= 0) goto L12;
        int[] r13 = this.C;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
    L12:
        return r11;
    L5:
        if (r8 == pa.b.f9971p) goto L9;
        throw new IllegalStateException("Expected " + r10 + " but was " + r8 + D());
    }

    @Override // pa.a
    public final String J() {
        return y0(false);
    }

    @Override // pa.a
    public final void V() {
        w0(pa.b.f9974s);
        A0();
        int r8 = this.A;
        if (r8 <= 0) goto L6;
        int[] r10 = this.C;
        int r11 = r8 - 1;
        r10[r11] = r10[r11] + 1;
        return;
    }

    @Override // pa.a
    public final void a() {
        w0(pa.b.f9966a);
        B0(((ha.m) z0()).iterator());
        this.C[this.A - 1] = 0;
    }

    @Override // pa.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8996z = new Object[]{E};
        this.A = 1;
    }

    @Override // pa.a
    public final String e0() {
        pa.b r8 = h0();
        pa.b r10 = pa.b.f9971p;
        if (r8 != r10) goto L5;
    L9:
        String r11 = ((ha.u) A0()).j();
        int r12 = this.A;
        if (r12 <= 0) goto L12;
        int[] r13 = this.C;
        int r14 = r12 - 1;
        r13[r14] = r13[r14] + 1;
    L12:
        return r11;
    L5:
        if (r8 == pa.b.f9972q) goto L9;
        throw new IllegalStateException("Expected " + r10 + " but was " + r8 + D());
    }

    @Override // pa.a
    public final pa.b h0() {
        if (this.A == 0) goto L5;
        Object r8 = z0();
        if ((r8 instanceof Iterator) == false) goto L20;
        boolean r10 = this.f8996z[this.A - 2] instanceof ha.s;
        Iterator r11 = (Iterator) r8;
        if (r11.hasNext() == false) goto L15;
        if (r10 == true) goto L12;
        B0(r11.next());
        return h0();
    L12:
        return pa.b.f9970o;
    L15:
        if (r10 == false) goto L18;
        return pa.b.f9969n;
    L18:
        return pa.b.f9967b;
    L20:
        if ((r8 instanceof ha.s) == false) goto L24;
        return pa.b.f9968m;
    L24:
        if ((r8 instanceof ha.m) == false) goto L28;
        return pa.b.f9966a;
    L28:
        if ((r8 instanceof ha.u) == false) goto L44;
        Serializable r12 = ((ha.u) r8).f8004a;
        if ((r12 instanceof String) == false) goto L34;
        return pa.b.f9971p;
    L34:
        if ((r12 instanceof Boolean) == false) goto L38;
        return pa.b.f9973r;
    L38:
        if ((r12 instanceof Number) == false) goto L42;
        return pa.b.f9972q;
    L42:
        throw new AssertionError();
    L44:
        if ((r8 instanceof ha.r) == false) goto L48;
        return pa.b.f9974s;
    L48:
        if (r8 != E) goto L52;
        throw new IllegalStateException("JsonReader is closed");
    L52:
        throw new pa.d("Custom JsonElement subclass " + r8.getClass().getName() + " is not supported");
    L5:
        return pa.b.f9975t;
    }

    @Override // pa.a
    public final void i() {
        w0(pa.b.f9968m);
        B0(new ja.s.b.a(((ha.s) z0()).o()));
    }

    @Override // pa.a
    public final void r() {
        w0(pa.b.f9967b);
        A0();
        A0();
        int r8 = this.A;
        if (r8 <= 0) goto L6;
        int[] r10 = this.C;
        int r11 = r8 - 1;
        r10[r11] = r10[r11] + 1;
        return;
    }

    @Override // pa.a
    public final String toString() {
        return f.class.getSimpleName() + D();
    }

    @Override // pa.a
    public final void u0() {
        int r8 = h0().ordinal();
        if (r8 != 1) goto L5;
        r();
        return;
    L5:
        if (r8 != 9) goto L7;
        return;
    L7:
        if (r8 != 3) goto L9;
        v();
        return;
    L9:
        if (r8 == 4) goto L13;
        A0();
        int r10 = this.A;
        if (r10 <= 0) goto L18;
        int[] r11 = this.C;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        return;
    L18:
        return;
    L13:
        y0(true);
    }

    @Override // pa.a
    public final void v() {
        w0(pa.b.f9969n);
        this.B[this.A - 1] = null;
        A0();
        A0();
        int r8 = this.A;
        if (r8 <= 0) goto L6;
        int[] r10 = this.C;
        int r11 = r8 - 1;
        r10[r11] = r10[r11] + 1;
        return;
    }

    public final void w0(pa.b r8) {
        if (h0() != r8) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r8 + " but was " + h0() + D());
    }

    @Override // pa.a
    public final String x() {
        return z(false);
    }

    public final ha.p x0() {
        pa.b r8 = h0();
        if (r8 == pa.b.f9970o) goto L13;
        if (r8 == pa.b.f9967b) goto L13;
        if (r8 == pa.b.f9969n) goto L13;
        if (r8 == pa.b.f9975t) goto L13;
        ha.p r10 = (ha.p) z0();
        u0();
        return r10;
    L13:
        throw new IllegalStateException("Unexpected " + r8 + " when reading a JsonElement.");
    }

    public final String y0(boolean r8) {
        w0(pa.b.f9970o);
        Map.Entry r10 = (Map.Entry) ((Iterator) z0()).next();
        String r11 = (String) r10.getKey();
        String[] r12 = this.B;
        int r13 = this.A - 1;
        if (r8 == false) goto L5;
        String r14 = "<skipped>";
    L6:
        r12[r13] = r14;
        B0(r10.getValue());
        return r11;
    L5:
        r14 = r11;
        goto L6
    }

    public final Object z0() {
        return this.f8996z[this.A - 1];
    }
}
