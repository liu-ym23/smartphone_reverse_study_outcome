package t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final int a;
    public final boolean b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "BatteryInfoSnapshot(level=" + this.a + ", isCharging=" + this.b + ')';
    }

    public g(int r1, boolean r10) {
        this.a = r1;
        this.b = r10;
    }
}
