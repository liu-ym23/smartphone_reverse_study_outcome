package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] EMPTY_STATE_SET = null;
    public static final Rect INSETS_NONE = null;

    @RequiresApi(18)
    public static class Api18Impl {
        private static final Field sBottom = null;
        private static final Method sGetOpticalInsets = null;
        private static final Field sLeft = null;
        private static final boolean sReflectionSuccessful = false;
        private static final Field sRight = null;
        private static final Field sTop = null;

        static {
            Class<?> r5 = Class.forName("android.graphics.Insets");     // Catch: NoSuchFieldException -> L20 ClassNotFoundException -> L21 NoSuchMethodException -> L22
            Method r10 = Drawable.class.getMethod("getOpticalInsets", null);     // Catch: NoSuchFieldException -> L20 ClassNotFoundException -> L21 NoSuchMethodException -> L22
            Field r11 = r5.getField(OpenPageMethod.ALIGN_LEFT);     // Catch: NoSuchFieldException -> L14 ClassNotFoundException -> L16 NoSuchMethodException -> L18
            Field r12 = r5.getField("top");     // Catch: NoSuchFieldException -> L10 ClassNotFoundException -> L12 NoSuchMethodException -> L13
            Field r13 = r5.getField("right");     // Catch: Throwable -> L9
            Field r14 = r5.getField("bottom");     // Catch: Throwable -> L28
            boolean r15 = true;
        L24:
            if (r15 == false) goto L26;
            sGetOpticalInsets = r10;
            sLeft = r11;
            sTop = r12;
            sRight = r13;
            sBottom = r14;
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
            r14 = null;
            r15 = false;
        L9:
            r13 = null;
            goto L23
        L12:
            r12 = null;
        L11:
            r13 = r12;
        L10:
            r12 = null;
        L13:
            r12 = null;
            goto L11
        L16:
            r11 = null;
        L17:
            r12 = r11;
        L14:
            r11 = null;
        L15:
            r12 = r11;
        L18:
            r11 = null;
        L19:
            r12 = r11;
            goto L11
        L21:
            r10 = null;
            r11 = null;
        L20:
            r10 = null;
            r11 = null;
        L22:
            r10 = null;
            r11 = null;
            goto L19
        }

        private Api18Impl() {
        }

        @NonNull
        public static Rect getOpticalInsets(@NonNull Drawable r5) {
            return DrawableUtils.INSETS_NONE;
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static Insets getOpticalInsets(Drawable r5) {
            return r5.getOpticalInsets();
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = new Rect();
    }

    private DrawableUtils() {
    }

    public static boolean canSafelyMutateDrawable(@NonNull Drawable r5) {
        return true;
    }

    public static void fixDrawable(@NonNull Drawable r5) {
        r5.getClass();
    }

    private static void forceDrawableStateChange(Drawable r5) {
        int[] r10 = r5.getState();
        if (r10 != null) goto L5;
    L8:
        r5.setState(CHECKED_STATE_SET);
    L9:
        r5.setState(r10);
        return;
    L5:
        if (r10.length == 0) goto L8;
        r5.setState(EMPTY_STATE_SET);
        goto L9
    }

    @NonNull
    public static Rect getOpticalBounds(@NonNull Drawable r5) {
        Insets r10 = Api29Impl.getOpticalInsets(r5);
        return new Rect(r10.left, r10.top, r10.right, r10.bottom);
    }

    public static PorterDuff.Mode parseTintMode(int r5, PorterDuff.Mode r10) {
        if (r5 == 3) goto L21;
        if (r5 == 5) goto L19;
        if (r5 == 9) goto L17;
        switch(r5) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r10;
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
