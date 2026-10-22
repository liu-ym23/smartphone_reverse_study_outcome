package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int getAlpha(Drawable r10) {
            return r10.getAlpha();
        }

        @DoNotInline
        static Drawable getChild(DrawableContainer.DrawableContainerState r10, int r11) {
            return r10.getChild(r11);
        }

        @DoNotInline
        static Drawable getDrawable(InsetDrawable r10) {
            return r10.getDrawable();
        }

        @DoNotInline
        static boolean isAutoMirrored(Drawable r10) {
            return r10.isAutoMirrored();
        }

        @DoNotInline
        static void setAutoMirrored(Drawable r10, boolean r11) {
            r10.setAutoMirrored(r11);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void applyTheme(Drawable r10, Resources.Theme r11) {
            r10.applyTheme(r11);
        }

        @DoNotInline
        static boolean canApplyTheme(Drawable r10) {
            return r10.canApplyTheme();
        }

        @DoNotInline
        static ColorFilter getColorFilter(Drawable r10) {
            return r10.getColorFilter();
        }

        @DoNotInline
        static void inflate(Drawable r10, Resources r11, XmlPullParser r12, AttributeSet r13, Resources.Theme r14) {
            r10.inflate(r11, r12, r13, r14);
        }

        @DoNotInline
        static void setHotspot(Drawable r10, float r11, float r12) {
            r10.setHotspot(r11, r12);
        }

        @DoNotInline
        static void setHotspotBounds(Drawable r10, int r11, int r12, int r13, int r14) {
            r10.setHotspotBounds(r11, r12, r13, r14);
        }

        @DoNotInline
        static void setTint(Drawable r10, int r11) {
            r10.setTint(r11);
        }

        @DoNotInline
        static void setTintList(Drawable r10, ColorStateList r11) {
            r10.setTintList(r11);
        }

        @DoNotInline
        static void setTintMode(Drawable r10, PorterDuff.Mode r11) {
            r10.setTintMode(r11);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getLayoutDirection(Drawable r10) {
            return r10.getLayoutDirection();
        }

        @DoNotInline
        static boolean setLayoutDirection(Drawable r10, int r11) {
            return r10.setLayoutDirection(r11);
        }
    }

    private DrawableCompat() {
    }

    public static void applyTheme(@NonNull Drawable r10, @NonNull Resources.Theme r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.applyTheme(r10, r11);
        return;
    }

    public static boolean canApplyTheme(@NonNull Drawable r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return Api21Impl.canApplyTheme(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clearColorFilter(@NonNull Drawable r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 23) goto L6;
    L4:
        r10.clearColorFilter();
        return;
    L6:
        if (r11 < 21) goto L4;
        r10.clearColorFilter();
        if ((r10 instanceof InsetDrawable) == false) goto L12;
        Drawable r12 = Api19Impl.getDrawable((InsetDrawable) r10);
    L10:
        clearColorFilter(r12);
        return;
    L12:
        if ((r10 instanceof WrappedDrawable) == false) goto L15;
        r12 = ((WrappedDrawable) r10).getWrappedDrawable();
        goto L10
    L15:
        if ((r10 instanceof DrawableContainer) == false) goto L29;
        DrawableContainer.DrawableContainerState r13 = (DrawableContainer.DrawableContainerState) ((DrawableContainer) r10).getConstantState();
        if (r13 == null) goto L30;
        int r14 = 0;
        int r15 = r13.getChildCount();
    L19:
        if (r14 >= r15) goto L31;
        Drawable r16 = Api19Impl.getChild(r13, r14);
        if (r16 == null) goto L23;
        clearColorFilter(r16);
    L23:
        r14 = r14 + 1;
        goto L19
    L31:
        return;
    L30:
        return;
    }

    public static int getAlpha(@NonNull Drawable r10) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return Api19Impl.getAlpha(r10);
    }

    @Nullable
    public static ColorFilter getColorFilter(@NonNull Drawable r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return Api21Impl.getColorFilter(r10);
    }

    public static int getLayoutDirection(@NonNull Drawable r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 23) goto L7;
        return Api23Impl.getLayoutDirection(r10);
    L7:
        if (r11 >= 17) goto L9;
    L22:
        return 0;
    L9:
        if (sGetLayoutDirectionMethodFetched == false) goto L25;
    L16:
        Method r12 = sGetLayoutDirectionMethod;
        if (r12 == null) goto L22;
        return ((Integer) r12.invoke(r10, new Object[0])).intValue();
    L20:
        e = move-exception;
        Log.i(TAG, "Failed to invoke getLayoutDirection() via reflection", e);
        sGetLayoutDirectionMethod = null;
        goto L22
    L25:
        Method r13 = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);     // Catch: NoSuchMethodException -> L13
        sGetLayoutDirectionMethod = r13;     // Catch: NoSuchMethodException -> L13
        r13.setAccessible(true);     // Catch: NoSuchMethodException -> L13
    L15:
        sGetLayoutDirectionMethodFetched = true;
    L13:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve getLayoutDirection() method", e);
        goto L15
    }

    public static void inflate(@NonNull Drawable r10, @NonNull Resources r11, @NonNull XmlPullParser r12, @NonNull AttributeSet r13, @Nullable Resources.Theme r14) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.inflate(r10, r11, r12, r13, r14);
        return;
    L5:
        r10.inflate(r11, r12, r13);
    }

    public static boolean isAutoMirrored(@NonNull Drawable r10) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.isAutoMirrored(r10);
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable r10) {
        r10.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setAutoMirrored(r10, r11);
        return;
    }

    public static void setHotspot(@NonNull Drawable r10, float r11, float r12) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setHotspot(r10, r11, r12);
        return;
    }

    public static void setHotspotBounds(@NonNull Drawable r10, int r11, int r12, int r13, int r14) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setHotspotBounds(r10, r11, r12, r13, r14);
        return;
    }

    public static boolean setLayoutDirection(@NonNull Drawable r10, int r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 23) goto L7;
        return Api23Impl.setLayoutDirection(r10, r11);
    L7:
        if (r12 >= 17) goto L9;
    L21:
        return false;
    L9:
        if (sSetLayoutDirectionMethodFetched == false) goto L22;
    L15:
        Method r13 = sSetLayoutDirectionMethod;
        if (r13 == null) goto L21;
        r13.invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L19
        return true;
    L19:
        e = move-exception;
        Log.i(TAG, "Failed to invoke setLayoutDirection(int) via reflection", e);
        sSetLayoutDirectionMethod = null;
        goto L21
    L22:
        Method r14 = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L12
        sSetLayoutDirectionMethod = r14;     // Catch: NoSuchMethodException -> L12
        r14.setAccessible(true);     // Catch: NoSuchMethodException -> L12
    L14:
        sSetLayoutDirectionMethodFetched = true;
    L12:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve setLayoutDirection(int) method", e);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTint(@NonNull Drawable r10, @ColorInt int r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTint(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintAwareDrawable) == false) goto L10;
        ((TintAwareDrawable) r10).setTint(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTintList(@NonNull Drawable r10, @Nullable ColorStateList r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTintList(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintAwareDrawable) == false) goto L10;
        ((TintAwareDrawable) r10).setTintList(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTintMode(@NonNull Drawable r10, @Nullable PorterDuff.Mode r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTintMode(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintAwareDrawable) == false) goto L10;
        ((TintAwareDrawable) r10).setTintMode(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(@NonNull Drawable r10) {
        if ((r10 instanceof WrappedDrawable) == true) goto L5;
        return r10;
    L5:
        return (T) ((WrappedDrawable) r10).getWrappedDrawable();
    }

    @NonNull
    public static Drawable wrap(@NonNull Drawable r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 23) goto L6;
        return r10;
    L6:
        if (r11 < 21) goto L13;
        if ((r10 instanceof TintAwareDrawable) == false) goto L10;
        return r10;
    L10:
        return new WrappedDrawableApi21(r10);
    L13:
        if ((r10 instanceof TintAwareDrawable) == false) goto L15;
        return r10;
    L15:
        return new WrappedDrawableApi14(r10);
    }
}
