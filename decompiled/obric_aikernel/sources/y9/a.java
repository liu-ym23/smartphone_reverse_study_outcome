package y9;

import android.graphics.Paint;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f13722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f13723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f13724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f13725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f13726f;

    public a(int r10, float r11, float r12, float r13, float r14, Paint r15) {
        Intrinsics.checkNotNullParameter(r15, "paint");
        this.f13721a = r10;
        this.f13722b = r11;
        this.f13723c = r12;
        this.f13724d = r13;
        this.f13725e = r14;
        this.f13726f = r15;
    }

    public /* synthetic */ a(int r10, float r11, float r12, float r13, float r14, Paint r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 32) == 0) goto L5;
        r15 = new Paint(1);
    L5:
        this(r10, r11, r12, r13, r14, r15);
    }

    public final int a() {
        return this.f13721a;
    }

    public final float b() {
        return this.f13723c;
    }

    public final float c() {
        return this.f13724d;
    }

    public final Paint d() {
        return this.f13726f;
    }

    public final float e() {
        return this.f13722b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L18;
        a r11 = (a) r10;
        if (this.f13721a == r11.f13721a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f13722b, r11.f13722b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f13723c, r11.f13723c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f13724d, r11.f13724d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f13725e, r11.f13725e) == 0) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f13726f, r11.f13726f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final float f() {
        return this.f13725e;
    }

    public final void g(int r10) {
        this.f13721a = r10;
    }

    public final void h(float r10) {
        this.f13723c = r10;
    }

    public int hashCode() {
        int r10 = ((((((((Integer.hashCode(this.f13721a) * 31) + Float.hashCode(this.f13722b)) * 31) + Float.hashCode(this.f13723c)) * 31) + Float.hashCode(this.f13724d)) * 31) + Float.hashCode(this.f13725e)) * 31;
        Paint r11 = this.f13726f;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }

    public final void i(float r10) {
        this.f13724d = r10;
    }

    public final void j(float r10) {
        this.f13722b = r10;
    }

    public final void k(float r10) {
        this.f13725e = r10;
    }

    public String toString() {
        return "Shadow(color=" + this.f13721a + ", radius=" + this.f13722b + ", offsetX=" + this.f13723c + ", offsetY=" + this.f13724d + ", spread=" + this.f13725e + ", paint=" + this.f13726f + ")";
    }
}
