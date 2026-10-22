package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] EMPTY_STATE_SET = null;
    public static final Rect INSETS_NONE = null;

    @RequiresApi(18)
    static class Api18Impl {
        private static final Field sBottom = null;
        private static final Method sGetOpticalInsets = null;
        private static final Field sLeft = null;
        private static final boolean sReflectionSuccessful = false;
        private static final Field sRight = null;
        private static final Field sTop = null;

        static {
            Class<?> r10 = Class.forName("android.graphics.Insets");     // Catch: NoSuchFieldException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L20
            Method r11 = Drawable.class.getMethod("getOpticalInsets", new Class[0]);     // Catch: NoSuchFieldException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L20
        L37:
            Field r12 = r10.getField("left");     // Catch: NoSuchFieldException -> L13 ClassNotFoundException -> L14 NoSuchMethodException -> L15
            Field r13 = r10.getField("top");     // Catch: NoSuchFieldException -> L10 ClassNotFoundException -> L11 NoSuchMethodException -> L12
            Field r14 = r10.getField("right");     // Catch: Throwable -> L9
            Field r15 = r10.getField("bottom");     // Catch: Throwable -> L28
            boolean r16 = true;
        L24:
            if (r16 == false) goto L26;
            sGetOpticalInsets = r11;
            sLeft = r12;
            sTop = r13;
            sRight = r14;
            sBottom = r15;
            sReflectionSuccessful = true;
            return;
        L26:
            sGetOpticalInsets = null;
            sLeft = null;
            sTop = null;
            sRight = null;
            sBottom = null;
            sReflectionSuccessful = false;
            return;
        L23:
            r16 = false;
            r15 = null;
        L9:
            r14 = null;
            goto L23
        L11:
            r13 = null;
        L22:
            r14 = r13;
        L10:
            r13 = null;
        L12:
            r13 = null;
            goto L22
        L14:
            r12 = null;
        L19:
            r13 = r12;
        L13:
            r12 = null;
        L17:
            r13 = r12;
        L15:
            r12 = null;
        L21:
            r13 = r12;
        L18:
            r11 = null;
            r12 = null;
        L16:
            r11 = null;
            r12 = null;
        L20:
            r11 = null;
            r12 = null;
            goto L21
        }

        private Api18Impl() {
        }

        @NonNull
        static Rect getOpticalInsets(@NonNull Drawable r10) {
            if (Build.VERSION.SDK_INT >= 29) goto L11;
            if (sReflectionSuccessful == false) goto L11;
            Object r11 = sGetOpticalInsets.invoke(r10, new Object[0]);     // Catch: Throwable -> L12
            if (r11 == null) goto L11;
            return new Rect(sLeft.getInt(r11), sTop.getInt(r11), sRight.getInt(r11), sBottom.getInt(r11));
        L11:
            return DrawableUtils.INSETS_NONE;
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static Insets getOpticalInsets(Drawable r10) {
            return r10.getOpticalInsets();
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = new Rect();
    }

    private DrawableUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean canSafelyMutateDrawable(@NonNull Drawable r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 17) goto L6;
        return true;
    L6:
        if (r11 < 15) goto L8;
    L10:
        if (r11 < 15) goto L12;
    L14:
        if (r11 >= 17) goto L19;
        if ((r10 instanceof LayerDrawable) == false) goto L19;
        return false;
    L19:
        if ((r10 instanceof DrawableContainer) == false) goto L29;
        Drawable.ConstantState r12 = r10.getConstantState();
        if ((r12 instanceof DrawableContainer.DrawableContainerState) == false) goto L39;
        Drawable[] r13 = ((DrawableContainer.DrawableContainerState) r12).getChildren();
        int r14 = r13.length;
        int r15 = 0;
    L23:
        if (r15 >= r14) goto L39;
        if (canSafelyMutateDrawable(r13[r15]) == false) goto L26;
        r15 = r15 + 1;
        goto L23
    L26:
        return false;
    L39:
        return true;
    L29:
        if ((r10 instanceof WrappedDrawable) == false) goto L34;
        Drawable r16 = ((WrappedDrawable) r10).getWrappedDrawable();
    L32:
        return canSafelyMutateDrawable(r16);
    L34:
        if ((r10 instanceof DrawableWrapperCompat) == false) goto L37;
        r16 = ((DrawableWrapperCompat) r10).getDrawable();
        goto L32
    L37:
        if ((r10 instanceof ScaleDrawable) == false) goto L39;
        r16 = ((ScaleDrawable) r10).getDrawable();
        goto L32
    L12:
        if ((r10 instanceof GradientDrawable) == false) goto L14;
        return false;
    L8:
        if ((r10 instanceof InsetDrawable) == false) goto L10;
        return false;
    }

    static void fixDrawable(@NonNull Drawable r10) {
        String r11 = r10.getClass().getName();
        int r12 = Build.VERSION.SDK_INT;
        if (r12 != 21) goto L8;
        if ("android.graphics.drawable.VectorDrawable".equals(r11) == false) goto L8;
    L6:
        forceDrawableStateChange(r10);
        return;
    L8:
        if (r12 >= 29) goto L10;
        return;
    L10:
        if (r12 < 31) goto L12;
        return;
    L12:
        if ("android.graphics.drawable.ColorStateListDrawable".equals(r11) == true) goto L6;
    }

    private static void forceDrawableStateChange(Drawable r10) {
        int[] r11 = r10.getState();
        if (r11 != null) goto L5;
    L8:
        r10.setState(CHECKED_STATE_SET);
    L9:
        r10.setState(r11);
        return;
    L5:
        if (r11.length == 0) goto L8;
        r10.setState(EMPTY_STATE_SET);
        goto L9
    }

    @NonNull
    public static Rect getOpticalBounds(@NonNull Drawable r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 29) goto L7;
        Insets r12 = Api29Impl.getOpticalInsets(r10);
        return new Rect(r12.left, r12.top, r12.right, r12.bottom);
    L7:
        if (r11 < 18) goto L11;
        return Api18Impl.getOpticalInsets(DrawableCompat.unwrap(r10));
    L11:
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int r10, PorterDuff.Mode r11) {
        if (r10 == 3) goto L21;
        if (r10 == 5) goto L19;
        if (r10 == 9) goto L17;
        switch(r10) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r11;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }
}
