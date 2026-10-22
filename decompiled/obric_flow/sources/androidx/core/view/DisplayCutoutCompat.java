package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static DisplayCutout createDisplayCutout(Rect r5, List<Rect> r10) {
            return new DisplayCutout(r5, r10);
        }

        @DoNotInline
        public static List<Rect> getBoundingRects(DisplayCutout r5) {
            return r5.getBoundingRects();
        }

        @DoNotInline
        public static int getSafeInsetBottom(DisplayCutout r5) {
            return r5.getSafeInsetBottom();
        }

        @DoNotInline
        public static int getSafeInsetLeft(DisplayCutout r5) {
            return r5.getSafeInsetLeft();
        }

        @DoNotInline
        public static int getSafeInsetRight(DisplayCutout r5) {
            return r5.getSafeInsetRight();
        }

        @DoNotInline
        public static int getSafeInsetTop(DisplayCutout r5) {
            return r5.getSafeInsetTop();
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static DisplayCutout createDisplayCutout(Insets r10, Rect r11, Rect r12, Rect r13, Rect r14) {
            return new DisplayCutout(r10, r11, r12, r13, r14);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static DisplayCutout createDisplayCutout(Insets r10, Rect r11, Rect r12, Rect r13, Rect r14, Insets r15) {
            return new DisplayCutout(r10, r11, r12, r13, r14, r15);
        }

        @DoNotInline
        public static Insets getWaterfallInsets(DisplayCutout r5) {
            return r5.getWaterfallInsets();
        }
    }

    public DisplayCutoutCompat(@Nullable Rect r5, @Nullable List<Rect> r10) {
        this(Api28Impl.createDisplayCutout(r5, r10));
    }

    private static DisplayCutout constructDisplayCutout(@NonNull androidx.core.graphics.Insets r10, @Nullable Rect r11, @Nullable Rect r12, @Nullable Rect r13, @Nullable Rect r14, @NonNull androidx.core.graphics.Insets r15) {
        return Api30Impl.createDisplayCutout(r10.toPlatformInsets(), r11, r12, r13, r14, r15.toPlatformInsets());
    }

    public static DisplayCutoutCompat wrap(DisplayCutout r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        return new DisplayCutoutCompat(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 != null) goto L7;
        return false;
    L7:
        if (DisplayCutoutCompat.class == r5.getClass()) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) r5).mDisplayCutout);
    }

    @NonNull
    public List<Rect> getBoundingRects() {
        return Api28Impl.getBoundingRects(this.mDisplayCutout);
    }

    public int getSafeInsetBottom() {
        return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
    }

    public int getSafeInsetLeft() {
        return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
    }

    public int getSafeInsetRight() {
        return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
    }

    public int getSafeInsetTop() {
        return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
    }

    @NonNull
    public androidx.core.graphics.Insets getWaterfallInsets() {
        return androidx.core.graphics.Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
    }

    public int hashCode() {
        DisplayCutout r5 = this.mDisplayCutout;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    @RequiresApi(28)
    public DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }

    public DisplayCutoutCompat(@NonNull androidx.core.graphics.Insets r5, @Nullable Rect r10, @Nullable Rect r11, @Nullable Rect r12, @Nullable Rect r13, @NonNull androidx.core.graphics.Insets r14) {
        this(constructDisplayCutout(r5, r10, r11, r12, r13, r14));
    }

    private DisplayCutoutCompat(DisplayCutout r5) {
        this.mDisplayCutout = r5;
    }
}
