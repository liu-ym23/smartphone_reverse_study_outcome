package ja;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class r extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8783a;

    public r(String r8) {
        this.f8783a = r8;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f8783a);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof r) == false) goto L14;
        Object r10 = ((r) r8).f8783a;
        String r11 = this.f8783a;
        if (r11 != r10) goto L10;
        return true;
    L10:
        if (r11.equals(r10) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f8783a);
    }

    public final int hashCode() {
        return this.f8783a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String r8 = this.f8783a;
        return Integer.parseInt(r8);
    L5:
        return (int) Long.parseLong(r8);
    L9:
        return new BigDecimal(r8).intValue();
    }

    @Override // java.lang.Number
    public final long longValue() {
        String r8 = this.f8783a;
        return Long.parseLong(r8);
    L6:
        return new BigDecimal(r8).longValue();
    }

    public final String toString() {
        return this.f8783a;
    }
}
