package androidx.core.graphics;

import ai.j0;
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
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static android.graphics.Insets of(int r5, int r10, int r11, int r12) {
            return android.graphics.Insets.of(r5, r10, r11, r12);
        }
    }

    static {
        NONE = new Insets(0, 0, 0, 0);
    }

    private Insets(int r5, int r10, int r11, int r12) {
        this.left = r5;
        this.top = r10;
        this.right = r11;
        this.bottom = r12;
    }

    @NonNull
    public static Insets add(@NonNull Insets r5, @NonNull Insets r10) {
        return of(r5.left + r10.left, r5.top + r10.top, r5.right + r10.right, r5.bottom + r10.bottom);
    }

    @NonNull
    public static Insets max(@NonNull Insets r5, @NonNull Insets r10) {
        return of(Math.max(r5.left, r10.left), Math.max(r5.top, r10.top), Math.max(r5.right, r10.right), Math.max(r5.bottom, r10.bottom));
    }

    @NonNull
    public static Insets min(@NonNull Insets r5, @NonNull Insets r10) {
        return of(Math.min(r5.left, r10.left), Math.min(r5.top, r10.top), Math.min(r5.right, r10.right), Math.min(r5.bottom, r10.bottom));
    }

    @NonNull
    public static Insets of(int r5, int r10, int r11, int r12) {
        if (r5 != 0) goto L9;
        if (r10 != 0) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != 0) goto L9;
        return NONE;
    L9:
        return new Insets(r5, r10, r11, r12);
    }

    @NonNull
    public static Insets subtract(@NonNull Insets r5, @NonNull Insets r10) {
        return of(r5.left - r10.left, r5.top - r10.top, r5.right - r10.right, r5.bottom - r10.bottom);
    }

    @NonNull
    @RequiresApi(api = 29)
    public static Insets toCompatInsets(@NonNull android.graphics.Insets r5) {
        return of(r5.left, r5.top, r5.right, r5.bottom);
    }

    @NonNull
    @Deprecated
    @RequiresApi(api = 29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Insets wrap(@NonNull android.graphics.Insets r5) {
        return toCompatInsets(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if (Insets.class != r5.getClass()) goto L23;
        Insets r10 = (Insets) r5;
        if (this.bottom == r10.bottom) goto L14;
        return false;
    L14:
        if (this.left == r10.left) goto L17;
        return false;
    L17:
        if (this.right == r10.right) goto L20;
        return false;
    L20:
        if (this.top == r10.top) goto L22;
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
        StringBuilder r5 = new StringBuilder("Insets{left=");
        r5.append(this.left);
        r5.append(", top=");
        r5.append(this.top);
        r5.append(", right=");
        r5.append(this.right);
        r5.append(", bottom=");
        return j0.n(r5, this.bottom, '}');
    }

    @NonNull
    public static Insets of(@NonNull Rect r5) {
        return of(r5.left, r5.top, r5.right, r5.bottom);
    }
}
