package ha;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class u extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f8004a;

    public u(Boolean r8) {
        Objects.requireNonNull(r8);
        this.f8004a = r8;
    }

    public static boolean l(u r8) {
        Serializable r10 = r8.f8004a;
        if ((r10 instanceof Number) == false) goto L15;
        Number r11 = (Number) r10;
        if ((r11 instanceof BigInteger) == false) goto L7;
    L14:
        return true;
    L7:
        if ((r11 instanceof Long) == true) goto L14;
        if ((r11 instanceof Integer) == true) goto L14;
        if ((r11 instanceof Short) == true) goto L14;
        if ((r11 instanceof Byte) == true) goto L14;
    L15:
        return false;
    }

    @Override // ha.p
    public final p a() {
        return this;
    }

    @Override // ha.p
    public final boolean b() {
        Serializable r8 = this.f8004a;
        if ((r8 instanceof Boolean) == false) goto L7;
        return ((Boolean) r8).booleanValue();
    L7:
        return Boolean.parseBoolean(j());
    }

    @Override // ha.p
    public final double c() {
        if ((this.f8004a instanceof Number) == false) goto L6;
        return i().doubleValue();
    L6:
        return Double.parseDouble(j());
    }

    @Override // ha.p
    public final int d() {
        if ((this.f8004a instanceof Number) == false) goto L6;
        return i().intValue();
    L6:
        return Integer.parseInt(j());
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L40:
        return false;
    L8:
        if (u.class != r8.getClass()) goto L40;
        u r10 = (u) r8;
        Serializable r11 = this.f8004a;
        Serializable r12 = r10.f8004a;
        if (r11 != null) goto L17;
        if (r12 != null) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (l(this) == false) goto L26;
        if (l(r10) == false) goto L26;
        if (i().longValue() != r10.i().longValue()) goto L24;
        return true;
    L24:
        return false;
    L26:
        if ((r11 instanceof Number) == false) goto L39;
        if ((r12 instanceof Number) == false) goto L39;
        double r13 = i().doubleValue();
        double r14 = r10.i().doubleValue();
        if (r13 != r14) goto L32;
        return true;
    L32:
        if (Double.isNaN(r13) == false) goto L37;
        if (Double.isNaN(r14) == false) goto L37;
        return true;
    L37:
        return false;
    L39:
        return r11.equals(r12);
    }

    @Override // ha.p
    public final long h() {
        if ((this.f8004a instanceof Number) == false) goto L6;
        return i().longValue();
    L6:
        return Long.parseLong(j());
    }

    public final int hashCode() {
        Serializable r8 = this.f8004a;
        if (r8 != null) goto L7;
        return 31;
    L7:
        if (l(this) == false) goto L10;
        long r10 = i().longValue();
    L13:
        return (int) (r10 ^ (r10 >>> 32));
    L10:
        if ((r8 instanceof Number) == false) goto L15;
        r10 = Double.doubleToLongBits(i().doubleValue());
        goto L13
    L15:
        return r8.hashCode();
    }

    @Override // ha.p
    public final Number i() {
        Serializable r8 = this.f8004a;
        if ((r8 instanceof Number) == false) goto L7;
        return (Number) r8;
    L7:
        if ((r8 instanceof String) == false) goto L11;
        return new ja.r((String) r8);
    L11:
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    @Override // ha.p
    public final String j() {
        Serializable r8 = this.f8004a;
        if ((r8 instanceof String) == false) goto L7;
        return (String) r8;
    L7:
        if ((r8 instanceof Number) == false) goto L11;
        return i().toString();
    L11:
        if ((r8 instanceof Boolean) == false) goto L15;
        return ((Boolean) r8).toString();
    L15:
        throw new AssertionError("Unexpected value type: " + r8.getClass());
    }

    public final float k() {
        if ((this.f8004a instanceof Number) == false) goto L6;
        return i().floatValue();
    L6:
        return Float.parseFloat(j());
    }

    public u(Number r8) {
        Objects.requireNonNull(r8);
        this.f8004a = r8;
    }

    public u(String r8) {
        Objects.requireNonNull(r8);
        this.f8004a = r8;
    }
}
