package pa;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.smartNetwork.netAccel.AccelMetric;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f9977t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String[] f9978u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f9979v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f9980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f9981b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9982m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f9983n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f9984o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9985p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f9986q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f9987r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f9988s;

    static {
        f9977t = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
        f9978u = new String[128];
        int r8 = 0;
    L4:
        if (r8 > 31) goto L6;
        f9978u[r8] = String.format("\\u%04x", new Object[]{Integer.valueOf(r8)});
        r8 = r8 + 1;
        goto L4
    L6:
        String[] r10 = f9978u;
        r10[34] = "\\\"";
        r10[92] = "\\\\";
        r10[9] = "\\t";
        r10[8] = "\\b";
        r10[10] = "\\n";
        r10[13] = "\\r";
        r10[12] = "\\f";
        String[] r11 = (String[]) r10.clone();
        f9979v = r11;
        r11[60] = "\\u003c";
        r11[62] = "\\u003e";
        r11[38] = "\\u0026";
        r11[61] = "\\u003d";
        r11[39] = "\\u0027";
    }

    public c(Writer r8) {
        int[] r10 = new int[32];
        this.f9981b = r10;
        this.f9982m = 0;
        if (r10.length != 0) goto L5;
        this.f9981b = Arrays.copyOf(r10, 0 * 2);
    L5:
        int[] r11 = this.f9981b;
        int r12 = this.f9982m;
        this.f9982m = r12 + 1;
        r11[r12] = 6;
        this.f9984o = BdimCategoryConstants.SEPARATOR_COLON;
        this.f9988s = true;
        Objects.requireNonNull(r8, "out == null");
        this.f9980a = r8;
    }

    public final int A() {
        int r8 = this.f9982m;
        if (r8 == 0) goto L7;
        return this.f9981b[r8 - 1];
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void B(String r8) {
        if (this.f9986q == false) goto L5;
        String[] r10 = f9979v;
    L6:
        Writer r11 = this.f9980a;
        r11.write(34);
        int r12 = r8.length();
        int r13 = 0;
        int r14 = 0;
    L7:
        if (r13 >= r12) goto L23;
        char r15 = r8.charAt(r13);
        if (r15 >= 128) goto L14;
        String r16 = r10[r15];
        if (r16 == null) goto L22;
    L19:
        if (r14 >= r13) goto L21;
        r11.write(r8, r14, r13 - r14);
    L21:
        r11.write(r16);
        r14 = r13 + 1;
    L22:
        r13 = r13 + 1;
        goto L7
    L14:
        if (r15 != 8232) goto L17;
        r16 = "\\u2028";
        goto L19
    L17:
        if (r15 != 8233) goto L22;
        r16 = "\\u2029";
        goto L19
    L23:
        if (r14 >= r12) goto L25;
        r11.write(r8, r14, r12 - r14);
    L25:
        r11.write(34);
        return;
    L5:
        r10 = f9978u;
        goto L6
    }

    public void C(double r8) {
        J();
        if (this.f9985p == false) goto L5;
    L11:
        a();
        this.f9980a.append(Double.toString(r8));
        return;
    L5:
        if (Double.isNaN(r8) == true) goto L10;
        if (Double.isInfinite(r8) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r8);
    }

    public void D(long r8) {
        J();
        a();
        this.f9980a.write(Long.toString(r8));
    }

    public void E(Boolean r8) {
        if (r8 != null) goto L5;
        z();
        return;
    L5:
        J();
        a();
        if (r8.booleanValue() == false) goto L8;
        String r10 = "true";
    L9:
        this.f9980a.write(r10);
        return;
    L8:
        r10 = "false";
        goto L9
    }

    public void G(Number r8) {
        if (r8 != null) goto L5;
        z();
        return;
    L5:
        J();
        String r10 = r8.toString();
        if (r10.equals("-Infinity") == true) goto L42;
        if (r10.equals("Infinity") == true) goto L42;
        if (r10.equals("NaN") == true) goto L42;
        Class<?> r11 = r8.getClass();
        if (r11 != Integer.class) goto L15;
    L34:
        boolean r12 = true;
    L35:
        if (r12 == false) goto L37;
    L43:
        a();
        this.f9980a.append(r10);
        return;
    L37:
        if (f9977t.matcher(r10).matches() == true) goto L43;
        throw new IllegalArgumentException("String created by " + r11 + " is not a valid JSON number: " + r10);
    L15:
        if (r11 == Long.class) goto L34;
        if (r11 == Double.class) goto L34;
        if (r11 == Float.class) goto L34;
        if (r11 == Byte.class) goto L34;
        if (r11 == Short.class) goto L34;
        if (r11 == BigDecimal.class) goto L34;
        if (r11 == BigInteger.class) goto L34;
        if (r11 == AtomicInteger.class) goto L34;
        if (r11 == AtomicLong.class) goto L34;
        r12 = false;
    L42:
        if (this.f9985p == true) goto L43;
        throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(r10));
    }

    public void H(String r8) {
        if (r8 != null) goto L5;
        z();
        return;
    L5:
        J();
        a();
        B(r8);
    }

    public void I(boolean r8) {
        J();
        a();
        if (r8 == false) goto L5;
        String r10 = "true";
    L6:
        this.f9980a.write(r10);
        return;
    L5:
        r10 = "false";
        goto L6
    }

    public final void J() {
        if (this.f9987r == null) goto L12;
        int r8 = A();
        if (r8 != 5) goto L8;
        this.f9980a.write(44);
    L9:
        x();
        this.f9981b[this.f9982m - 1] = 4;
        B(this.f9987r);
        this.f9987r = null;
        return;
    L8:
        if (r8 == 3) goto L9;
        throw new IllegalStateException("Nesting problem.");
    }

    public final void a() {
        int r8 = A();
        if (r8 == 1) goto L21;
        Writer r10 = this.f9980a;
        if (r8 != 2) goto L7;
        r10.append(',');
    L22:
        x();
        return;
    L7:
        if (r8 != 4) goto L9;
        r10.append(this.f9984o);
        this.f9981b[this.f9982m - 1] = 5;
        return;
    L9:
        if (r8 == 6) goto L18;
        if (r8 != 7) goto L17;
        if (this.f9985p == true) goto L18;
        throw new IllegalStateException("JSON must have only one top-level value.");
    L17:
        throw new IllegalStateException("Nesting problem.");
    L18:
        this.f9981b[this.f9982m - 1] = 7;
        return;
    L21:
        this.f9981b[this.f9982m - 1] = 2;
        goto L22
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9980a.close();
        int r8 = this.f9982m;
        if (r8 > 1) goto L10;
        if (r8 == 1) goto L6;
    L7:
        this.f9982m = 0;
        return;
    L6:
        if (this.f9981b[r8 - 1] == 7) goto L7;
    L10:
        throw new IOException("Incomplete document");
    }

    public void flush() {
        if (this.f9982m == 0) goto L7;
        this.f9980a.flush();
        return;
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void i() {
        J();
        a();
        int r8 = this.f9982m;
        int[] r10 = this.f9981b;
        if (r8 != r10.length) goto L5;
        this.f9981b = Arrays.copyOf(r10, r8 * 2);
    L5:
        int[] r11 = this.f9981b;
        int r12 = this.f9982m;
        this.f9982m = r12 + 1;
        r11[r12] = 1;
        this.f9980a.write(91);
    }

    public void k() {
        J();
        a();
        int r8 = this.f9982m;
        int[] r10 = this.f9981b;
        if (r8 != r10.length) goto L5;
        this.f9981b = Arrays.copyOf(r10, r8 * 2);
    L5:
        int[] r11 = this.f9981b;
        int r12 = this.f9982m;
        this.f9982m = r12 + 1;
        r11[r12] = 3;
        this.f9980a.write(AccelMetric.CAE_MULTI_NET_ACCEL_EVENT_FEATURE_ID);
    }

    public final void n(int r8, int r10, char r11) {
        int r12 = A();
        if (r12 == r10) goto L9;
        if (r12 == r8) goto L9;
        throw new IllegalStateException("Nesting problem.");
    L9:
        if (this.f9987r != null) goto L16;
        this.f9982m--;
        if (r12 != r10) goto L13;
        x();
    L13:
        this.f9980a.write(r11);
        return;
    L16:
        throw new IllegalStateException("Dangling name: " + this.f9987r);
    }

    public void r() {
        n(1, 2, ']');
    }

    public void v() {
        n(3, 5, '}');
    }

    public void w(String r8) {
        Objects.requireNonNull(r8, "name == null");
        if (this.f9987r != null) goto L11;
        if (this.f9982m == 0) goto L9;
        this.f9987r = r8;
        return;
    L9:
        throw new IllegalStateException("JsonWriter is closed.");
    L11:
        throw new IllegalStateException();
    }

    public final void x() {
        if (this.f9983n != null) goto L5;
        return;
    L5:
        Writer r8 = this.f9980a;
        r8.write(10);
        int r10 = this.f9982m;
        int r11 = 1;
    L6:
        if (r11 >= r10) goto L8;
        r8.write(this.f9983n);
        r11 = r11 + 1;
        goto L6
    }

    public c z() {
        if (this.f9987r != null) goto L5;
    L9:
        a();
        this.f9980a.write("null");
        return this;
    L5:
        if (this.f9988s == false) goto L7;
        J();
        goto L9
    L7:
        this.f9987r = null;
        return this;
    }
}
