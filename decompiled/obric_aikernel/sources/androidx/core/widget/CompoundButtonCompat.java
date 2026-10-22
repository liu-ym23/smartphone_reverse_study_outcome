package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
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
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ColorStateList getButtonTintList(CompoundButton r10) {
            return r10.getButtonTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getButtonTintMode(CompoundButton r10) {
            return r10.getButtonTintMode();
        }

        @DoNotInline
        static void setButtonTintList(CompoundButton r10, ColorStateList r11) {
            r10.setButtonTintList(r11);
        }

        @DoNotInline
        static void setButtonTintMode(CompoundButton r10, PorterDuff.Mode r11) {
            r10.setButtonTintMode(r11);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Drawable getButtonDrawable(CompoundButton r10) {
            return r10.getButtonDrawable();
        }
    }

    private CompoundButtonCompat() {
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton r10) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getButtonDrawable(r10);
    L7:
        if (sButtonDrawableFieldFetched == false) goto L23;
    L14:
        Field r11 = sButtonDrawableField;
        if (r11 != null) goto L21;
    L20:
        return null;
    L21:
        return (Drawable) r11.get(r10);
    L18:
        e = move-exception;
        Log.i(TAG, "Failed to get button drawable via reflection", e);
        sButtonDrawableField = null;
        goto L20
    L23:
        Field r12 = CompoundButton.class.getDeclaredField("mButtonDrawable");     // Catch: NoSuchFieldException -> L11
        sButtonDrawableField = r12;     // Catch: NoSuchFieldException -> L11
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L11
    L13:
        sButtonDrawableFieldFetched = true;
    L11:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve mButtonDrawable field", e);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getButtonTintList(r10);
    L7:
        if ((r10 instanceof TintableCompoundButton) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundButton) r10).getSupportButtonTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getButtonTintMode(r10);
    L7:
        if ((r10 instanceof TintableCompoundButton) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundButton) r10).getSupportButtonTintMode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setButtonTintList(@NonNull CompoundButton r10, @Nullable ColorStateList r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setButtonTintList(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintableCompoundButton) == false) goto L10;
        ((TintableCompoundButton) r10).setSupportButtonTintList(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setButtonTintMode(@NonNull CompoundButton r10, @Nullable PorterDuff.Mode r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setButtonTintMode(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintableCompoundButton) == false) goto L10;
        ((TintableCompoundButton) r10).setSupportButtonTintMode(r11);
        return;
    }
}
