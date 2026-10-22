package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4275a;

    public m(Boolean r10) {
        Objects.requireNonNull(r10);
        this.f4275a = r10;
    }

    public m(Number r10) {
        Objects.requireNonNull(r10);
        this.f4275a = r10;
    }

    public m(String r10) {
        Objects.requireNonNull(r10);
        this.f4275a = r10;
    }

    private static boolean o(m r10) {
        Object r11 = r10.f4275a;
        if ((r11 instanceof Number) == false) goto L16;
        Number r12 = (Number) r11;
        if ((r12 instanceof BigInteger) == false) goto L7;
    L14:
        return true;
    L7:
        if ((r12 instanceof Long) == true) goto L14;
        if ((r12 instanceof Integer) == true) goto L14;
        if ((r12 instanceof Short) == true) goto L14;
        if ((r12 instanceof Byte) == true) goto L14;
        return false;
    L16:
        return false;
    }

    @Override // com.google.gson.i
    public boolean a() {
        if (n() == false) goto L7;
        return ((Boolean) this.f4275a).booleanValue();
    L7:
        return Boolean.parseBoolean(h());
    }

    @Override // com.google.gson.i
    public double b() {
        if (p() == false) goto L6;
        return m().doubleValue();
    L6:
        return Double.parseDouble(h());
    }

    @Override // com.google.gson.i
    public int c() {
        if (p() == false) goto L6;
        return m().intValue();
    L6:
        return Integer.parseInt(h());
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L41:
        return false;
    L8:
        if (m.class != r10.getClass()) goto L41;
        m r11 = (m) r10;
        if (this.f4275a != null) goto L18;
        if (r11.f4275a != null) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (o(this) == true) goto L20;
    L26:
        Object r12 = this.f4275a;
        if ((r12 instanceof Number) == false) goto L40;
        if ((r11.f4275a instanceof Number) == false) goto L40;
        double r13 = m().doubleValue();
        double r14 = r11.m().doubleValue();
        if (r13 != r14) goto L33;
        return true;
    L33:
        if (Double.isNaN(r13) == false) goto L38;
        if (Double.isNaN(r14) == false) goto L38;
        return true;
    L38:
        return false;
    L40:
        return r12.equals(r11.f4275a);
    L20:
        if (o(r11) == false) goto L26;
        if (m().longValue() != r11.m().longValue()) goto L25;
        return true;
    L25:
        return false;
    }

    @Override // com.google.gson.i
    public long g() {
        if (p() == false) goto L6;
        return m().longValue();
    L6:
        return Long.parseLong(h());
    }

    @Override // com.google.gson.i
    public String h() {
        Object r10 = this.f4275a;
        if ((r10 instanceof String) == false) goto L7;
        return (String) r10;
    L7:
        if (p() == false) goto L11;
        return m().toString();
    L11:
        if (n() == false) goto L15;
        return ((Boolean) this.f4275a).toString();
    L15:
        throw new AssertionError("Unexpected value type: " + this.f4275a.getClass());
    }

    public int hashCode() {
        if (this.f4275a != null) goto L7;
        return 31;
    L7:
        if (o(this) == false) goto L11;
        long r10 = m().longValue();
    L10:
        return (int) ((r10 >>> 32) ^ r10);
    L11:
        Object r11 = this.f4275a;
        if ((r11 instanceof Number) == false) goto L15;
        r10 = Double.doubleToLongBits(m().doubleValue());
        goto L10
    L15:
        return r11.hashCode();
    }

    public Number m() {
        Object r10 = this.f4275a;
        if ((r10 instanceof Number) == false) goto L7;
        return (Number) r10;
    L7:
        if ((r10 instanceof String) == false) goto L11;
        return new LazilyParsedNumber((String) r10);
    L11:
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean n() {
        return this.f4275a instanceof Boolean;
    }

    public boolean p() {
        return this.f4275a instanceof Number;
    }

    public boolean q() {
        return this.f4275a instanceof String;
    }
}
