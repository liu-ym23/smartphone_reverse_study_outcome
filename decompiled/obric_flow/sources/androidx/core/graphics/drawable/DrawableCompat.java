package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void applyTheme(Drawable r5, Resources.Theme r10) {
            r5.applyTheme(r10);
        }

        @DoNotInline
        public static boolean canApplyTheme(Drawable r5) {
            return r5.canApplyTheme();
        }

        @DoNotInline
        public static ColorFilter getColorFilter(Drawable r5) {
            return r5.getColorFilter();
        }

        @DoNotInline
        public static void inflate(Drawable r5, Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) throws XmlPullParserException, IOException {
            r5.inflate(r10, r11, r12, r13);
        }

        @DoNotInline
        public static void setHotspot(Drawable r5, float r10, float r11) {
            r5.setHotspot(r10, r11);
        }

        @DoNotInline
        public static void setHotspotBounds(Drawable r5, int r10, int r11, int r12, int r13) {
            r5.setHotspotBounds(r10, r11, r12, r13);
        }

        @DoNotInline
        public static void setTint(Drawable r5, int r10) {
            r5.setTint(r10);
        }

        @DoNotInline
        public static void setTintList(Drawable r5, ColorStateList r10) {
            r5.setTintList(r10);
        }

        @DoNotInline
        public static void setTintMode(Drawable r5, PorterDuff.Mode r10) {
            r5.setTintMode(r10);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int getLayoutDirection(Drawable r5) {
            return r5.getLayoutDirection();
        }

        @DoNotInline
        public static boolean setLayoutDirection(Drawable r5, int r10) {
            return r5.setLayoutDirection(r10);
        }
    }

    private DrawableCompat() {
    }

    public static void applyTheme(@NonNull Drawable r5, @NonNull Resources.Theme r10) {
        Api21Impl.applyTheme(r5, r10);
    }

    public static boolean canApplyTheme(@NonNull Drawable r5) {
        return Api21Impl.canApplyTheme(r5);
    }

    public static void clearColorFilter(@NonNull Drawable r5) {
        r5.clearColorFilter();
    }

    public static int getAlpha(@NonNull Drawable r5) {
        return r5.getAlpha();
    }

    @Nullable
    public static ColorFilter getColorFilter(@NonNull Drawable r5) {
        return Api21Impl.getColorFilter(r5);
    }

    public static int getLayoutDirection(@NonNull Drawable r5) {
        return Api23Impl.getLayoutDirection(r5);
    }

    public static void inflate(@NonNull Drawable r5, @NonNull Resources r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) throws XmlPullParserException, IOException {
        Api21Impl.inflate(r5, r10, r11, r12, r13);
    }

    public static boolean isAutoMirrored(@NonNull Drawable r5) {
        return r5.isAutoMirrored();
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable r5) {
        r5.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable r5, boolean r10) {
        r5.setAutoMirrored(r10);
    }

    public static void setHotspot(@NonNull Drawable r5, float r10, float r11) {
        Api21Impl.setHotspot(r5, r10, r11);
    }

    public static void setHotspotBounds(@NonNull Drawable r5, int r10, int r11, int r12, int r13) {
        Api21Impl.setHotspotBounds(r5, r10, r11, r12, r13);
    }

    public static boolean setLayoutDirection(@NonNull Drawable r5, int r10) {
        return Api23Impl.setLayoutDirection(r5, r10);
    }

    public static void setTint(@NonNull Drawable r5, @ColorInt int r10) {
        Api21Impl.setTint(r5, r10);
    }

    public static void setTintList(@NonNull Drawable r5, @Nullable ColorStateList r10) {
        Api21Impl.setTintList(r5, r10);
    }

    public static void setTintMode(@NonNull Drawable r5, @Nullable PorterDuff.Mode r10) {
        Api21Impl.setTintMode(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(@NonNull Drawable r5) {
        if ((r5 instanceof WrappedDrawable) == true) goto L5;
        return r5;
    L5:
        return (T) ((WrappedDrawable) r5).getWrappedDrawable();
    }

    @NonNull
    public static Drawable wrap(@NonNull Drawable r5) {
        return r5;
    }
}
