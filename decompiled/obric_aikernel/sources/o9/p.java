package o9;

import android.graphics.Paint;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f11604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f11605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f11606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f11607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f11608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f11609g;

    @JvmOverloads
    public p(int r11, float r12, float r13, float r14, float r15) {
        this(r11, r12, r13, r14, r15, null, 0.0f, 96, null);
    }

    @JvmOverloads
    public p(int r10, float r11, float r12, float r13, float r14, Paint r15, float r16) {
        Intrinsics.checkNotNullParameter(r15, "paint");
        this.f11603a = r10;
        this.f11604b = r11;
        this.f11605c = r12;
        this.f11606d = r13;
        this.f11607e = r14;
        this.f11608f = r15;
        this.f11609g = r16;
    }

    public /* synthetic */ p(int r11, float r12, float r13, float r14, float r15, Paint r16, float r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        Paint r10 = new Paint(1);
    L7:
        if ((r18 & 64) == 0) goto L9;
        float r20 = 0.0f;
    L10:
        this(r11, r12, r13, r14, r15, r10, r20);
        return;
    L9:
        r20 = r17;
        goto L10
    L5:
        r10 = r16;
        goto L7
    }

    public final int a() {
        return this.f11603a;
    }

    public final float b() {
        return this.f11609g;
    }

    public final float c() {
        return this.f11605c;
    }

    public final float d() {
        return this.f11606d;
    }

    public final Paint e() {
        return this.f11608f;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof p) == false) goto L20;
        p r11 = (p) r10;
        if (this.f11603a == r11.f11603a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f11604b, r11.f11604b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f11605c, r11.f11605c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f11606d, r11.f11606d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f11607e, r11.f11607e) == 0) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f11608f, r11.f11608f) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f11609g, r11.f11609g) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final float f() {
        return this.f11604b;
    }

    public final float g() {
        return this.f11607e;
    }

    public final void h(int r10) {
        this.f11603a = r10;
    }

    public int hashCode() {
        int r10 = ((((((((Integer.hashCode(this.f11603a) * 31) + Float.hashCode(this.f11604b)) * 31) + Float.hashCode(this.f11605c)) * 31) + Float.hashCode(this.f11606d)) * 31) + Float.hashCode(this.f11607e)) * 31;
        Paint r11 = this.f11608f;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return ((r10 + r12) * 31) + Float.hashCode(this.f11609g);
    L5:
        r12 = 0;
        goto L7
    }

    public final void i(float r10) {
        this.f11605c = r10;
    }

    public final void j(float r10) {
        this.f11606d = r10;
    }

    public final void k(float r10) {
        this.f11604b = r10;
    }

    public final void l(float r10) {
        this.f11607e = r10;
    }

    public final boolean m() {
        if (this.f11605c == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (this.f11606d != 0.0f) goto L12;
        if (this.f11604b != 0.0f) goto L12;
        if (this.f11607e != 0.0f) goto L12;
        return false;
    }

    public String toString() {
        return "Shadow(color=" + this.f11603a + ", radius=" + this.f11604b + ", offsetX=" + this.f11605c + ", offsetY=" + this.f11606d + ", spread=" + this.f11607e + ", paint=" + this.f11608f + ", cornerRadius=" + this.f11609g + ")";
    }
}
