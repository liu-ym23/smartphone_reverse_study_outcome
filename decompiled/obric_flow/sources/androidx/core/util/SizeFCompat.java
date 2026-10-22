package androidx.core.util;

import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    @RequiresApi(21)
    public static final class Api21Impl {
        private Api21Impl() {
        }

        @NonNull
        @DoNotInline
        public static SizeF toSizeF(@NonNull SizeFCompat r5) {
            Preconditions.checkNotNull(r5);
            return new SizeF(r5.getWidth(), r5.getHeight());
        }

        @NonNull
        @DoNotInline
        public static SizeFCompat toSizeFCompat(@NonNull SizeF r5) {
            Preconditions.checkNotNull(r5);
            return new SizeFCompat(r5.getWidth(), r5.getHeight());
        }
    }

    public SizeFCompat(float r5, float r10) {
        this.mWidth = Preconditions.checkArgumentFinite(r5, "width");
        this.mHeight = Preconditions.checkArgumentFinite(r10, "height");
    }

    @NonNull
    @RequiresApi(21)
    public static SizeFCompat toSizeFCompat(@NonNull SizeF r5) {
        return Api21Impl.toSizeFCompat(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SizeFCompat) == true) goto L8;
        return false;
    L8:
        SizeFCompat r10 = (SizeFCompat) r5;
        if (r10.mWidth != this.mWidth) goto L14;
        if (r10.mHeight != this.mHeight) goto L14;
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
        int r5 = Float.floatToIntBits(this.mWidth);
        return Float.floatToIntBits(this.mHeight) ^ r5;
    }

    @NonNull
    @RequiresApi(21)
    public SizeF toSizeF() {
        return Api21Impl.toSizeF(this);
    }

    @NonNull
    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
