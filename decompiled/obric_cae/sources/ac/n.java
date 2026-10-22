package ac;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f340g;

    public n(int r8) {
        this(r8, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final boolean a() {
        if (this.f336c == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (this.f337d != 0.0f) goto L12;
        if (this.f335b != 0.0f) goto L12;
        if (this.f338e != 0.0f) goto L12;
        return false;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L4;
        return true;
    L4:
        if ((r8 instanceof n) == false) goto L20;
        n r10 = (n) r8;
        if (this.f334a == r10.f334a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f335b, r10.f335b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f336c, r10.f336c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f337d, r10.f337d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f338e, r10.f338e) == 0) goto L16;
        return false;
    L16:
        if (he.i.a(this.f339f, r10.f339f) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f340g, r10.f340g) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r8 = Integer.hashCode(this.f334a) * 31;
        int r10 = (Float.hashCode(this.f335b) + r8) * 31;
        int r11 = (Float.hashCode(this.f336c) + r10) * 31;
        int r12 = (Float.hashCode(this.f337d) + r11) * 31;
        int r13 = (Float.hashCode(this.f338e) + r12) * 31;
        Paint r14 = this.f339f;
        if (r14 == null) goto L5;
        int r15 = r14.hashCode();
    L6:
        int r16 = Float.hashCode(this.f340g);
        return r16 + ((r13 + r15) * 31);
    L5:
        r15 = 0;
        goto L6
    }

    public final String toString() {
        return "Shadow(color=" + this.f334a + ", radius=" + this.f335b + ", offsetX=" + this.f336c + ", offsetY=" + this.f337d + ", spread=" + this.f338e + ", paint=" + this.f339f + ", cornerRadius=" + this.f340g + ")";
    }

    public n(int r8, float r10, float r11, float r12, float r13) {
        Paint r14 = new Paint(1);
        this.f334a = r8;
        this.f335b = r10;
        this.f336c = r11;
        this.f337d = r12;
        this.f338e = r13;
        this.f339f = r14;
        this.f340g = 0.0f;
    }
}
