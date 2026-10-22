package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class CheckedTextViewCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @Nullable
        public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView r5) {
            return r5.getCheckMarkTintList();
        }

        @Nullable
        public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView r5) {
            return r5.getCheckMarkTintMode();
        }

        public static void setCheckMarkTintList(@NonNull CheckedTextView r5, @Nullable ColorStateList r10) {
            r5.setCheckMarkTintList(r10);
        }

        public static void setCheckMarkTintMode(@NonNull CheckedTextView r5, @Nullable PorterDuff.Mode r10) {
            r5.setCheckMarkTintMode(r10);
        }
    }

    private CheckedTextViewCompat() {
    }

    @Nullable
    public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView r5) {
        return r5.getCheckMarkDrawable();
    }

    @Nullable
    public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView r5) {
        return Api21Impl.getCheckMarkTintList(r5);
    }

    @Nullable
    public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView r5) {
        return Api21Impl.getCheckMarkTintMode(r5);
    }

    public static void setCheckMarkTintList(@NonNull CheckedTextView r5, @Nullable ColorStateList r10) {
        Api21Impl.setCheckMarkTintList(r5, r10);
    }

    public static void setCheckMarkTintMode(@NonNull CheckedTextView r5, @Nullable PorterDuff.Mode r10) {
        Api21Impl.setCheckMarkTintMode(r5, r10);
    }
}
