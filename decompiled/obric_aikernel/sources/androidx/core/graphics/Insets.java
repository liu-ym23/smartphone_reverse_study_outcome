package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class Insets {

    @NonNull
    public static final Insets NONE = null;
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static android.graphics.Insets of(int r10, int r11, int r12, int r13) {
            return android.graphics.Insets.of(r10, r11, r12, r13);
        }
    }

    static {
        NONE = new Insets(0, 0, 0, 0);
    }

    private Insets(int r10, int r11, int r12, int r13) {
        this.left = r10;
        this.top = r11;
        this.right = r12;
        this.bottom = r13;
    }

    @NonNull
    public static Insets add(@NonNull Insets r10, @NonNull Insets r11) {
        return of(r10.left + r11.left, r10.top + r11.top, r10.right + r11.right, r10.bottom + r11.bottom);
    }

    @NonNull
    public static Insets max(@NonNull Insets r10, @NonNull Insets r11) {
        return of(Math.max(r10.left, r11.left), Math.max(r10.top, r11.top), Math.max(r10.right, r11.right), Math.max(r10.bottom, r11.bottom));
    }

    @NonNull
    public static Insets min(@NonNull Insets r10, @NonNull Insets r11) {
        return of(Math.min(r10.left, r11.left), Math.min(r10.top, r11.top), Math.min(r10.right, r11.right), Math.min(r10.bottom, r11.bottom));
    }

    @NonNull
    public static Insets of(int r10, int r11, int r12, int r13) {
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        if (r13 != 0) goto L9;
        return NONE;
    L9:
        return new Insets(r10, r11, r12, r13);
    }

    @NonNull
    public static Insets of(@NonNull Rect r10) {
        return of(r10.left, r10.top, r10.right, r10.bottom);
    }

    @NonNull
    public static Insets subtract(@NonNull Insets r10, @NonNull Insets r11) {
        return of(r10.left - r11.left, r10.top - r11.top, r10.right - r11.right, r10.bottom - r11.bottom);
    }

    @NonNull
    @RequiresApi(api = 29)
    public static Insets toCompatInsets(@NonNull android.graphics.Insets r10) {
        return of(r10.left, r10.top, r10.right, r10.bottom);
    }

    @NonNull
    @Deprecated
    @RequiresApi(api = 29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Insets wrap(@NonNull android.graphics.Insets r10) {
        return toCompatInsets(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L23:
        return false;
    L8:
        if (Insets.class != r10.getClass()) goto L23;
        Insets r11 = (Insets) r10;
        if (this.bottom == r11.bottom) goto L14;
        return false;
    L14:
        if (this.left == r11.left) goto L17;
        return false;
    L17:
        if (this.right == r11.right) goto L20;
        return false;
    L20:
        if (this.top == r11.top) goto L22;
        return false;
    L22:
        return true;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @NonNull
    @RequiresApi(29)
    public android.graphics.Insets toPlatformInsets() {
        return Api29Impl.of(this.left, this.top, this.right, this.bottom);
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }
}
