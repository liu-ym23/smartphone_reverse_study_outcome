package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class CheckedTextViewCompat {
    private static final String TAG = "CheckedTextViewCompat";

    private static class Api14Impl {
        private static Field sCheckMarkDrawableField;
        private static boolean sResolved;

        private Api14Impl() {
        }

        @Nullable
        static Drawable getCheckMarkDrawable(@NonNull CheckedTextView r10) {
            if (sResolved == false) goto L17;
        L10:
            Field r11 = sCheckMarkDrawableField;
            if (r11 != null) goto L19;
        L16:
            return null;
        L19:
            return (Drawable) r11.get(r10);
        L14:
            e = move-exception;
            Log.i(CheckedTextViewCompat.TAG, "Failed to get check mark drawable via reflection", e);
            sCheckMarkDrawableField = null;
            goto L16
        L17:
            Field r12 = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");     // Catch: NoSuchFieldException -> L7
            sCheckMarkDrawableField = r12;     // Catch: NoSuchFieldException -> L7
            r12.setAccessible(true);     // Catch: NoSuchFieldException -> L7
        L9:
            sResolved = true;
        L7:
            e = move-exception;
            Log.i(CheckedTextViewCompat.TAG, "Failed to retrieve mCheckMarkDrawable field", e);
            goto L9
        }
    }

    @RequiresApi(16)
    private static class Api16Impl {
        private Api16Impl() {
        }

        @Nullable
        static Drawable getCheckMarkDrawable(@NonNull CheckedTextView r10) {
            return r10.getCheckMarkDrawable();
        }
    }

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @Nullable
        static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView r10) {
            return r10.getCheckMarkTintList();
        }

        @Nullable
        static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView r10) {
            return r10.getCheckMarkTintMode();
        }

        static void setCheckMarkTintList(@NonNull CheckedTextView r10, @Nullable ColorStateList r11) {
            r10.setCheckMarkTintList(r11);
        }

        static void setCheckMarkTintMode(@NonNull CheckedTextView r10, @Nullable PorterDuff.Mode r11) {
            r10.setCheckMarkTintMode(r11);
        }
    }

    private CheckedTextViewCompat() {
    }

    @Nullable
    public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView r10) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getCheckMarkDrawable(r10);
    L7:
        return Api14Impl.getCheckMarkDrawable(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCheckMarkTintList(r10);
    L7:
        if ((r10 instanceof TintableCheckedTextView) == true) goto L9;
        return null;
    L9:
        return ((TintableCheckedTextView) r10).getSupportCheckMarkTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView r10) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCheckMarkTintMode(r10);
    L7:
        if ((r10 instanceof TintableCheckedTextView) == true) goto L9;
        return null;
    L9:
        return ((TintableCheckedTextView) r10).getSupportCheckMarkTintMode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCheckMarkTintList(@NonNull CheckedTextView r10, @Nullable ColorStateList r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setCheckMarkTintList(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintableCheckedTextView) == false) goto L10;
        ((TintableCheckedTextView) r10).setSupportCheckMarkTintList(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCheckMarkTintMode(@NonNull CheckedTextView r10, @Nullable PorterDuff.Mode r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setCheckMarkTintMode(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintableCheckedTextView) == false) goto L10;
        ((TintableCheckedTextView) r10).setSupportCheckMarkTintMode(r11);
        return;
    }
}
