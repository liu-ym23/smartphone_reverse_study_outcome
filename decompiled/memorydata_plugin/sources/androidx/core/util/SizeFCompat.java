package androidx.core.util;

import android.util.SizeF;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    private static final class Api21Impl {
        private Api21Impl() {
        }

        static SizeF toSizeF(SizeFCompat r2) {
            Preconditions.checkNotNull(r2);
            return new SizeF(r2.getWidth(), r2.getHeight());
        }

        static SizeFCompat toSizeFCompat(SizeF r2) {
            Preconditions.checkNotNull(r2);
            return new SizeFCompat(r2.getWidth(), r2.getHeight());
        }
    }

    public SizeFCompat(float r2, float r3) {
        this.mWidth = Preconditions.checkArgumentFinite(r2, "width");
        this.mHeight = Preconditions.checkArgumentFinite(r3, "height");
    }

    public static SizeFCompat toSizeFCompat(SizeF r0) {
        return Api21Impl.toSizeFCompat(r0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SizeFCompat.class) == true) goto L8;
        return false;
    L8:
        SizeFCompat r6 = (SizeFCompat) ZeusTransformUtils.preCheckCast(r5, SizeFCompat.class, "com.obric.memorydata.plugin");
        if (r6.mWidth != this.mWidth) goto L14;
        if (r6.mHeight != this.mHeight) goto L14;
        return true;
    L14:
        return false;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int r0 = Float.floatToIntBits(this.mWidth);
        return Float.floatToIntBits(this.mHeight) ^ r0;
    }

    public SizeF toSizeF() {
        return Api21Impl.toSizeF(this);
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
