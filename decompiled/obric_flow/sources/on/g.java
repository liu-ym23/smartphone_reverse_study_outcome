package on;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f20784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f20785b;

    public g(float r5, float r10) {
        this.f20784a = r5;
        this.f20785b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        if (Float.compare(r10.f20784a, this.f20784a) == 0) goto L11;
    L13:
        return false;
    L11:
        if (Float.compare(r10.f20785b, this.f20785b) != 0) goto L13;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new float[]{this.f20784a, this.f20785b});
    }

    public final String toString() {
        return "Point{x=" + this.f20784a + ", y=" + this.f20785b + '}';
    }
}
