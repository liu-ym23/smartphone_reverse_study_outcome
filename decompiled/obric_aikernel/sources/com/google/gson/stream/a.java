package com.google.gson.stream;

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

/* JADX INFO: loaded from: classes2.dex */
public class a implements Closeable, Flushable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Pattern f4277o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String[] f4278p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String[] f4279q = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Writer f4280c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f4281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f4283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f4287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f4288n;

    static {
        f4277o = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
        f4278p = new String[128];
        int r10 = 0;
    L4:
        if (r10 > 31) goto L6;
        f4278p[r10] = String.format("\\u%04x", new Object[]{Integer.valueOf(r10)});
        r10 = r10 + 1;
        goto L4
    L6:
        String[] r11 = f4278p;
        r11[34] = "\\\"";
        r11[92] = "\\\\";
        r11[9] = "\\t";
        r11[8] = "\\b";
        r11[10] = "\\n";
        r11[13] = "\\r";
        r11[12] = "\\f";
        String[] r12 = (String[]) r11.clone();
        f4279q = r12;
        r12[60] = "\\u003c";
        r12[62] = "\\u003e";
        r12[38] = "\\u0026";
        r12[61] = "\\u003d";
        r12[39] = "\\u0027";
    }

    public a(Writer r10) {
        this.f4281g = new int[32];
        this.f4282h = 0;
        F(6);
        this.f4284j = ":";
        this.f4288n = true;
        Objects.requireNonNull(r10, "out == null");
        this.f4280c = r10;
    }

    private void A() {
        if (this.f4283i != null) goto L5;
        return;
    L5:
        this.f4280c.write(10);
        int r10 = this.f4282h;
        int r11 = 1;
    L6:
        if (r11 >= r10) goto L8;
        this.f4280c.write(this.f4283i);
        r11 = r11 + 1;
        goto L6
    }

    private a C(int r10, char r11) {
        c();
        F(r10);
        this.f4280c.write(r11);
        return this;
    }

    private int D() {
        int r10 = this.f4282h;
        if (r10 == 0) goto L7;
        return this.f4281g[r10 - 1];
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void F(int r10) {
        int r11 = this.f4282h;
        int[] r12 = this.f4281g;
        if (r11 != r12.length) goto L5;
        this.f4281g = Arrays.copyOf(r12, r11 * 2);
    L5:
        int[] r13 = this.f4281g;
        int r14 = this.f4282h;
        this.f4282h = r14 + 1;
        r13[r14] = r10;
    }

    private void G(int r10) {
        this.f4281g[this.f4282h - 1] = r10;
    }

    private void N(String r10) {
        if (this.f4286l == false) goto L5;
        String[] r11 = f4279q;
    L6:
        this.f4280c.write(34);
        int r12 = r10.length();
        int r13 = 0;
        int r14 = 0;
    L7:
        if (r13 >= r12) goto L23;
        char r15 = r10.charAt(r13);
        if (r15 >= 128) goto L14;
        String r16 = r11[r15];
        if (r16 == null) goto L22;
    L19:
        if (r14 >= r13) goto L21;
        this.f4280c.write(r10, r14, r13 - r14);
    L21:
        this.f4280c.write(r16);
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
        this.f4280c.write(r10, r14, r12 - r14);
    L25:
        this.f4280c.write(34);
        return;
    L5:
        r11 = f4278p;
        goto L6
    }

    private void a() {
        int r10 = D();
        if (r10 != 5) goto L6;
        this.f4280c.write(44);
    L7:
        A();
        G(4);
        return;
    L6:
        if (r10 == 3) goto L7;
        throw new IllegalStateException("Nesting problem.");
    }

    private void c() {
        int r10 = D();
        if (r10 == 1) goto L20;
        if (r10 != 2) goto L6;
        this.f4280c.append(',');
    L21:
        A();
        return;
    L6:
        if (r10 != 4) goto L8;
        this.f4280c.append(this.f4284j);
        G(5);
        return;
    L8:
        if (r10 == 6) goto L17;
        if (r10 != 7) goto L16;
        if (this.f4285k == true) goto L17;
        throw new IllegalStateException("JSON must have only one top-level value.");
    L16:
        throw new IllegalStateException("Nesting problem.");
    L17:
        G(7);
        return;
    L20:
        G(2);
        goto L21
    }

    private void d0() {
        if (this.f4287m == null) goto L6;
        a();
        N(this.f4287m);
        this.f4287m = null;
        return;
    }

    private a k(int r10, int r11, char r12) {
        int r13 = D();
        if (r13 == r11) goto L9;
        if (r13 == r10) goto L9;
        throw new IllegalStateException("Nesting problem.");
    L9:
        if (this.f4287m != null) goto L16;
        this.f4282h--;
        if (r13 != r11) goto L13;
        A();
    L13:
        this.f4280c.write(r12);
        return this;
    L16:
        throw new IllegalStateException("Dangling name: " + this.f4287m);
    }

    private static boolean u(Class<? extends Number> r10) {
        if (r10 != Integer.class) goto L5;
    L24:
        return true;
    L5:
        if (r10 == Long.class) goto L24;
        if (r10 == Double.class) goto L24;
        if (r10 == Float.class) goto L24;
        if (r10 == Byte.class) goto L24;
        if (r10 == Short.class) goto L24;
        if (r10 == BigDecimal.class) goto L24;
        if (r10 == BigInteger.class) goto L24;
        if (r10 == AtomicInteger.class) goto L24;
        if (r10 == AtomicLong.class) goto L24;
        return false;
    }

    public a B() {
        if (this.f4287m != null) goto L5;
    L9:
        c();
        this.f4280c.write("null");
        return this;
    L5:
        if (this.f4288n == false) goto L7;
        d0();
        goto L9
    L7:
        this.f4287m = null;
        return this;
    }

    public final void I(boolean r10) {
        this.f4286l = r10;
    }

    public final void J(String r10) {
        if (r10.length() != 0) goto L5;
        this.f4283i = null;
        String r11 = ":";
    L6:
        this.f4284j = r11;
        return;
    L5:
        this.f4283i = r10;
        r11 = ": ";
        goto L6
    }

    public final void K(boolean r10) {
        this.f4285k = r10;
    }

    public final void M(boolean r10) {
        this.f4288n = r10;
    }

    public a P(double r10) {
        d0();
        if (this.f4285k == false) goto L5;
    L11:
        c();
        this.f4280c.append(Double.toString(r10));
        return this;
    L5:
        if (Double.isNaN(r10) == true) goto L10;
        if (Double.isInfinite(r10) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r10);
    }

    public a Q(long r10) {
        d0();
        c();
        this.f4280c.write(Long.toString(r10));
        return this;
    }

    public a V(Boolean r10) {
        if (r10 == null) goto L4;
        d0();
        c();
        Writer r11 = this.f4280c;
        if (r10.booleanValue() == false) goto L8;
        String r12 = "true";
    L9:
        r11.write(r12);
        return this;
    L8:
        r12 = "false";
        goto L9
    L4:
        return B();
    }

    public a X(Number r10) {
        if (r10 == null) goto L4;
        d0();
        String r11 = r10.toString();
        if (r11.equals("-Infinity") == true) goto L20;
        if (r11.equals("Infinity") == true) goto L20;
        if (r11.equals("NaN") == true) goto L20;
        Class<?> r12 = r10.getClass();
        if (u(r12) == false) goto L15;
    L21:
        c();
        this.f4280c.append(r11);
        return this;
    L15:
        if (f4277o.matcher(r11).matches() == true) goto L21;
        throw new IllegalArgumentException("String created by " + r12 + " is not a valid JSON number: " + r11);
    L20:
        if (this.f4285k == true) goto L21;
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r11);
    L4:
        return B();
    }

    public a a0(String r10) {
        if (r10 == null) goto L4;
        d0();
        c();
        N(r10);
        return this;
    L4:
        return B();
    }

    public a c0(boolean r10) {
        d0();
        c();
        Writer r11 = this.f4280c;
        if (r10 == false) goto L5;
        String r12 = "true";
    L6:
        r11.write(r12);
        return this;
    L5:
        r12 = "false";
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4280c.close();
        int r10 = this.f4282h;
        if (r10 > 1) goto L10;
        if (r10 == 1) goto L6;
    L7:
        this.f4282h = 0;
        return;
    L6:
        if (this.f4281g[r10 - 1] == 7) goto L7;
    L10:
        throw new IOException("Incomplete document");
    }

    public a f() {
        d0();
        return C(1, '[');
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f4282h == 0) goto L7;
        this.f4280c.flush();
        return;
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public a i() {
        d0();
        return C(3, '{');
    }

    public a l() {
        return k(1, 2, ']');
    }

    public a o() {
        return k(3, 5, '}');
    }

    public final boolean p() {
        return this.f4288n;
    }

    public final boolean r() {
        return this.f4286l;
    }

    public boolean s() {
        return this.f4285k;
    }

    public a v(String r10) {
        Objects.requireNonNull(r10, "name == null");
        if (this.f4287m != null) goto L11;
        if (this.f4282h == 0) goto L9;
        this.f4287m = r10;
        return this;
    L9:
        throw new IllegalStateException("JsonWriter is closed.");
    L11:
        throw new IllegalStateException();
    }
}
