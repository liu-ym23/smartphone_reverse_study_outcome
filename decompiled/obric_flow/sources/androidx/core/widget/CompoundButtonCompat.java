package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static ColorStateList getButtonTintList(CompoundButton r5) {
            return r5.getButtonTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode getButtonTintMode(CompoundButton r5) {
            return r5.getButtonTintMode();
        }

        @DoNotInline
        public static void setButtonTintList(CompoundButton r5, ColorStateList r10) {
            r5.setButtonTintList(r10);
        }

        @DoNotInline
        public static void setButtonTintMode(CompoundButton r5, PorterDuff.Mode r10) {
            r5.setButtonTintMode(r10);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static Drawable getButtonDrawable(CompoundButton r5) {
            return r5.getButtonDrawable();
        }
    }

    private CompoundButtonCompat() {
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton r5) {
        return Api23Impl.getButtonDrawable(r5);
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton r5) {
        return Api21Impl.getButtonTintList(r5);
    }

    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton r5) {
        return Api21Impl.getButtonTintMode(r5);
    }

    public static void setButtonTintList(@NonNull CompoundButton r5, @Nullable ColorStateList r10) {
        Api21Impl.setButtonTintList(r5, r10);
    }

    public static void setButtonTintMode(@NonNull CompoundButton r5, @Nullable PorterDuff.Mode r10) {
        Api21Impl.setButtonTintMode(r5, r10);
    }
}
