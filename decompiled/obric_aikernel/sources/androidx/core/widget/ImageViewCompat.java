package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ColorStateList getImageTintList(ImageView r10) {
            return r10.getImageTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getImageTintMode(ImageView r10) {
            return r10.getImageTintMode();
        }

        @DoNotInline
        static void setImageTintList(ImageView r10, ColorStateList r11) {
            r10.setImageTintList(r11);
        }

        @DoNotInline
        static void setImageTintMode(ImageView r10, PorterDuff.Mode r11) {
            r10.setImageTintMode(r11);
        }
    }

    private ImageViewCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getImageTintList(r10);
    L7:
        if ((r10 instanceof TintableImageSourceView) == true) goto L11;
        return null;
    L11:
        return ((TintableImageSourceView) r10).getSupportImageTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getImageTintMode(r10);
    L7:
        if ((r10 instanceof TintableImageSourceView) == true) goto L11;
        return null;
    L11:
        return ((TintableImageSourceView) r10).getSupportImageTintMode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setImageTintList(@NonNull ImageView r10, @Nullable ColorStateList r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L15;
        Api21Impl.setImageTintList(r10, r11);
        if (r12 != 21) goto L18;
        Drawable r13 = r10.getDrawable();
        if (r13 != null) goto L9;
        return;
    L9:
        if (Api21Impl.getImageTintList(r10) != null) goto L11;
        return;
    L11:
        if (r13.isStateful() == false) goto L13;
        r13.setState(r10.getDrawableState());
    L13:
        r10.setImageDrawable(r13);
        return;
    L18:
        return;
    L15:
        if ((r10 instanceof TintableImageSourceView) == false) goto L22;
        ((TintableImageSourceView) r10).setSupportImageTintList(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setImageTintMode(@NonNull ImageView r10, @Nullable PorterDuff.Mode r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L15;
        Api21Impl.setImageTintMode(r10, r11);
        if (r12 != 21) goto L18;
        Drawable r13 = r10.getDrawable();
        if (r13 != null) goto L9;
        return;
    L9:
        if (Api21Impl.getImageTintList(r10) != null) goto L11;
        return;
    L11:
        if (r13.isStateful() == false) goto L13;
        r13.setState(r10.getDrawableState());
    L13:
        r10.setImageDrawable(r13);
        return;
    L18:
        return;
    L15:
        if ((r10 instanceof TintableImageSourceView) == false) goto L22;
        ((TintableImageSourceView) r10).setSupportImageTintMode(r11);
        return;
    }
}
