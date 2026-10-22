package t3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f12939a;

    public f(byte[] r10) {
        int r11 = r10.length;
        byte[] r12 = new byte[r11];
        this.f12939a = r12;
        System.arraycopy(r10, 0, r12, 0, r11);
    }

    public byte[] a() {
        return this.f12939a;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof f) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.f12939a, ((f) r10).f12939a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f12939a);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("0x");
        byte[] r11 = this.f12939a;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r10.append(Integer.toHexString(r11[r13] & 255));
        r13 = r13 + 1;
        goto L3
    L6:
        return r10.toString();
    }
}
