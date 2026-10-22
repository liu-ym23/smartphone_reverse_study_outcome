package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(Rect r10, List<Rect> r11) {
            return new DisplayCutout(r10, r11);
        }

        @DoNotInline
        static List<Rect> getBoundingRects(DisplayCutout r10) {
            return r10.getBoundingRects();
        }

        @DoNotInline
        static int getSafeInsetBottom(DisplayCutout r10) {
            return r10.getSafeInsetBottom();
        }

        @DoNotInline
        static int getSafeInsetLeft(DisplayCutout r10) {
            return r10.getSafeInsetLeft();
        }

        @DoNotInline
        static int getSafeInsetRight(DisplayCutout r10) {
            return r10.getSafeInsetRight();
        }

        @DoNotInline
        static int getSafeInsetTop(DisplayCutout r10) {
            return r10.getSafeInsetTop();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(Insets r10, Rect r11, Rect r12, Rect r13, Rect r14) {
            return new DisplayCutout(r10, r11, r12, r13, r14);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(Insets r10, Rect r11, Rect r12, Rect r13, Rect r14, Insets r15) {
            return new DisplayCutout(r10, r11, r12, r13, r14, r15);
        }

        @DoNotInline
        static Insets getWaterfallInsets(DisplayCutout r10) {
            return r10.getWaterfallInsets();
        }
    }

    public DisplayCutoutCompat(@Nullable Rect r10, @Nullable List<Rect> r11) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        DisplayCutout r12 = Api28Impl.createDisplayCutout(r10, r11);
    L6:
        this(r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    private DisplayCutoutCompat(DisplayCutout r10) {
        this.mDisplayCutout = r10;
    }

    public DisplayCutoutCompat(@NonNull androidx.core.graphics.Insets r10, @Nullable Rect r11, @Nullable Rect r12, @Nullable Rect r13, @Nullable Rect r14, @NonNull androidx.core.graphics.Insets r15) {
        this(constructDisplayCutout(r10, r11, r12, r13, r14, r15));
    }

    private static DisplayCutout constructDisplayCutout(@NonNull androidx.core.graphics.Insets r10, @Nullable Rect r11, @Nullable Rect r12, @Nullable Rect r13, @Nullable Rect r14, @NonNull androidx.core.graphics.Insets r15) {
        int r16 = Build.VERSION.SDK_INT;
        if (r16 < 30) goto L7;
        return Api30Impl.createDisplayCutout(r10.toPlatformInsets(), r11, r12, r13, r14, r15.toPlatformInsets());
    L7:
        if (r16 < 29) goto L11;
        return Api29Impl.createDisplayCutout(r10.toPlatformInsets(), r11, r12, r13, r14);
    L11:
        if (r16 < 28) goto L23;
        Rect r17 = new Rect(r10.left, r10.top, r10.right, r10.bottom);
        ArrayList r18 = new ArrayList();
        if (r11 == null) goto L15;
        r18.add(r11);
    L15:
        if (r12 == null) goto L17;
        r18.add(r12);
    L17:
        if (r13 == null) goto L19;
        r18.add(r13);
    L19:
        if (r14 == null) goto L22;
        r18.add(r14);
    L22:
        return Api28Impl.createDisplayCutout(r17, r18);
    L23:
        return null;
    }

    static DisplayCutoutCompat wrap(DisplayCutout r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        return new DisplayCutoutCompat(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        if (DisplayCutoutCompat.class == r10.getClass()) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) r10).mDisplayCutout);
    }

    @NonNull
    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getBoundingRects(this.mDisplayCutout);
    L7:
        return Collections.emptyList();
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
    }

    @NonNull
    public androidx.core.graphics.Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return androidx.core.graphics.Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
    L7:
        return androidx.core.graphics.Insets.NONE;
    }

    public int hashCode() {
        DisplayCutout r10 = this.mDisplayCutout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    @RequiresApi(28)
    DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }
}
