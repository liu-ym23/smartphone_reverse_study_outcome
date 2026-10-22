package t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j) == true) goto L8;
        return false;
    L8:
        j r11 = (j) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == false) goto L9;
        int r11 = 1231;
    L10:
        int r12 = (r10 + r11) * 31;
        if (this.c == false) goto L13;
        int r13 = 1231;
    L14:
        int r14 = (r12 + r13) * 31;
        if (this.d == false) goto L17;
        int r15 = 1231;
    L18:
        int r16 = (r14 + r15) * 31;
        if (this.e == false) goto L21;
        int r17 = 1231;
    L22:
        int r18 = (r16 + r17) * 31;
        if (this.f == true) goto L27;
        r1 = 1237;
    L27:
        return r18 + r1;
    L21:
        r17 = 1237;
        goto L22
    L17:
        r15 = 1237;
        goto L18
    L13:
        r13 = 1237;
        goto L14
    L9:
        r11 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "BluetoothCharacteristicPropertiesSnapshot(read=" + this.a + ", write=" + this.b + ", notify=" + this.c + ", indicate=" + this.d + ", writeNoResponse=" + this.e + ", writeDefault=" + this.f + ')';
    }

    public j(boolean r1, boolean r10, boolean r11, boolean r12, boolean r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = true;
    }
}
