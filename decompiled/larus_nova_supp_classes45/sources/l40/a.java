package l40;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Ll40/a;", "", "", "top", "F", "d", "()F", "j", "(F)V", "left", "c", "h", "right", "getRight", "i", "bottom", "getBottom", "f", "widthPercent", "e", "k", "heightPercent", "b", "g", "livecomponentsmarket-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {
    public transient long a;

    @SerializedName("bottom")
    private float bottom;

    @SerializedName("height")
    private float heightPercent;

    @SerializedName("left")
    private float left;

    @SerializedName("right")
    private float right;

    @SerializedName("top")
    private float top;

    @SerializedName("width")
    private float widthPercent;

    public a() {
        this(0);
    }

    public final int hashCode() {
        return (((((((((Float.floatToIntBits(this.top) * 31) + Float.floatToIntBits(this.left)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + Float.floatToIntBits(this.widthPercent)) * 31) + Float.floatToIntBits(this.heightPercent);
    }

    public final String toString() {
        return "{top:(" + this.top + "), left:(" + this.left + "), right:(" + this.right + "), bottom:(" + this.bottom + "), widthPercent:(" + this.widthPercent + "), heightPercent:(" + this.heightPercent + ")}";
    }

    public final float b() {
        return this.heightPercent;
    }

    public final float c() {
        return this.left;
    }

    public final float d() {
        return this.top;
    }

    public final float e() {
        return this.widthPercent;
    }

    public /* synthetic */ a(int r8) {
        this(0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f);
    }

    public static a a(a r7) {
        return new a(r7.top, r7.left, r7.right, r7.bottom, r7.widthPercent, r7.heightPercent);
    }

    public final boolean equals(Object r7) {
        if ((r7 instanceof b) == true) goto L5;
        return false;
    L5:
        b r8 = (b) r7;
        if (this.top == r8.e()) goto L9;
        return false;
    L9:
        if (this.left == r8.c()) goto L12;
        return false;
    L12:
        if (this.right == r8.d()) goto L15;
        return false;
    L15:
        if (this.top == r8.e()) goto L18;
        return false;
    L18:
        if (this.bottom == r8.a()) goto L21;
        return false;
    L21:
        if (this.widthPercent == r8.f()) goto L24;
        return false;
    L24:
        if (this.heightPercent == r8.b()) goto L26;
        return false;
    L26:
        long r2 = this.a;
        r8.getClass();
        if (r2 == 0) goto L29;
        return false;
    L29:
        return true;
    }

    public final void f(float r1) {
        this.bottom = r1;
    }

    public final void g(float r1) {
        this.heightPercent = r1;
    }

    public final void h(float r1) {
        this.left = r1;
    }

    public final void i(float r1) {
        this.right = r1;
    }

    public final void j(float r1) {
        this.top = r1;
    }

    public final void k(float r1) {
        this.widthPercent = r1;
    }

    public a(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.top = r1;
        this.left = r2;
        this.right = r3;
        this.bottom = r4;
        this.widthPercent = r5;
        this.heightPercent = r6;
    }
}
