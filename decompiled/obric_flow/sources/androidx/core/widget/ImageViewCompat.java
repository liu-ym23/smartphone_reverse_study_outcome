package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static ColorStateList getImageTintList(ImageView r5) {
            return r5.getImageTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode getImageTintMode(ImageView r5) {
            return r5.getImageTintMode();
        }

        @DoNotInline
        public static void setImageTintList(ImageView r5, ColorStateList r10) {
            r5.setImageTintList(r10);
        }

        @DoNotInline
        public static void setImageTintMode(ImageView r5, PorterDuff.Mode r10) {
            r5.setImageTintMode(r10);
        }
    }

    private ImageViewCompat() {
    }

    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView r5) {
        return Api21Impl.getImageTintList(r5);
    }

    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView r5) {
        return Api21Impl.getImageTintMode(r5);
    }

    public static void setImageTintList(@NonNull ImageView r5, @Nullable ColorStateList r10) {
        Api21Impl.setImageTintList(r5, r10);
    }

    public static void setImageTintMode(@NonNull ImageView r5, @Nullable PorterDuff.Mode r10) {
        Api21Impl.setImageTintMode(r5, r10);
    }
}
