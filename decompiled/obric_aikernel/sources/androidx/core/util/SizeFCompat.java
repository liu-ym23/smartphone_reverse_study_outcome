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
    private static final class Api21Impl {
        private Api21Impl() {
        }

        @NonNull
        @DoNotInline
        static SizeF toSizeF(@NonNull SizeFCompat r10) {
            Preconditions.checkNotNull(r10);
            return new SizeF(r10.getWidth(), r10.getHeight());
        }

        @NonNull
        @DoNotInline
        static SizeFCompat toSizeFCompat(@NonNull SizeF r10) {
            Preconditions.checkNotNull(r10);
            return new SizeFCompat(r10.getWidth(), r10.getHeight());
        }
    }

    public SizeFCompat(float r10, float r11) {
        this.mWidth = Preconditions.checkArgumentFinite(r10, "width");
        this.mHeight = Preconditions.checkArgumentFinite(r11, "height");
    }

    @NonNull
    @RequiresApi(21)
    public static SizeFCompat toSizeFCompat(@NonNull SizeF r10) {
        return Api21Impl.toSizeFCompat(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SizeFCompat) == true) goto L8;
        return false;
    L8:
        SizeFCompat r11 = (SizeFCompat) r10;
        if (r11.mWidth != this.mWidth) goto L14;
        if (r11.mHeight != this.mHeight) goto L14;
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
        int r10 = Float.floatToIntBits(this.mWidth);
        return Float.floatToIntBits(this.mHeight) ^ r10;
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
