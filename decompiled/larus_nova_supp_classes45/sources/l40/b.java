package l40;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Ll40/b;", "", "", "top", "F", "e", "()F", "setTop", "(F)V", "left", "c", "setLeft", "right", "d", "setRight", "bottom", "a", "setBottom", "widthPercent", "f", "setWidthPercent", "heightPercent", "b", "setHeightPercent", "livecomponentsmarket-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

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

    public final int hashCode() {
        return (((((((((Float.floatToIntBits(this.top) * 31) + Float.floatToIntBits(this.left)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + Float.floatToIntBits(this.widthPercent)) * 31) + Float.floatToIntBits(this.heightPercent);
    }

    public final String toString() {
        return "{top:(" + this.top + "), left:(" + this.left + "), right:(" + this.right + "), bottom:(" + this.bottom + "), widthPercent:(" + this.widthPercent + "), heightPercent:(" + this.heightPercent + ")}";
    }

    public b() {
        this.top = 0.0f;
        this.left = 1.0f;
        this.right = 0.0f;
        this.bottom = 0.0f;
        this.widthPercent = 1.0f;
        this.heightPercent = 1.0f;
    }

    public final float a() {
        return this.bottom;
    }

    public final float b() {
        return this.heightPercent;
    }

    public final float c() {
        return this.left;
    }

    public final float d() {
        return this.right;
    }

    public final float e() {
        return this.top;
    }

    public final float f() {
        return this.widthPercent;
    }

    public final boolean equals(Object r6) {
        if ((r6 instanceof b) == true) goto L5;
        return false;
    L5:
        float r0 = this.top;
        b r7 = (b) r6;
        float r2 = r7.top;
        if (r0 == r2) goto L9;
        return false;
    L9:
        if (this.left == r7.left) goto L12;
        return false;
    L12:
        if (this.right == r7.right) goto L15;
        return false;
    L15:
        if (r0 == r2) goto L18;
        return false;
    L18:
        if (this.bottom == r7.bottom) goto L21;
        return false;
    L21:
        if (this.widthPercent == r7.widthPercent) goto L24;
        return false;
    L24:
        if (this.heightPercent == r7.heightPercent) goto L26;
        return false;
    L26:
        r7.getClass();
        return true;
    }
}
